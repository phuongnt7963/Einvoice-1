package com.ibm.btt.base;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.ResourceBundle;

import com.ibm.btt.base.types.DSEType;
import com.ibm.btt.base.types.DSETypeException;
import com.ibm.btt.config.BTTInitException;
import com.ibm.btt.utils.StringUtils;

public abstract class BTTOperation implements Externalizable, Operation,
Cacheable {
	private static final String COPYRIGHT = "Licensed Materials - Property of IBM Restricted Materials of IBM 5724-H82 (C) Copyright IBM Corp. 2006, 2008 All Rights Reserved. US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp ";
	protected static final String COMPID = "#BTTOperation";
	private static final BTTLog log = BTTLogFactory.getLog(BTTOperation.class
			.getName());

	private static ResourceBundle opstepTrace = ResourceBundle
			.getBundle("opstep_trace");

	protected static Externalizer externalizer = null;

	private Context context = null;
	private Context msgcontext = null;
	private String id = null;
	private Hashtable formats = new Hashtable();
	private boolean isSelfDefinedOperation = false;
	private KeyedCollection opSteps = new KeyedCollection();
	private int opStepRC;
	private OperationXValidate xval = null;
	private String applicationId;
	private boolean isDefinedContext = true;
	private String sessionId;
	protected transient OperationRepliedListener aOperationRepliedListener = null;
	private Tag tag;
	public BTTOperation() throws BTTInitException {
		//InitManager.reset("jar:///definitions/btt.xml");
		resetBtt();
	}

	private void resetBtt() throws BTTInitException{
		//com.ibm.btt.config.InitManager.reset("jar:///definitions/btt.xml");
	}

	public BTTOperation(String aName) throws IOException {
		setName(aName);
		readExternal();
	}

	public BTTOperation(String anOperationName, Context aParentContext)
			throws IOException, DSEInvalidRequestException {
		setName(anOperationName);
		readExternal();
		chainTo(aParentContext);
	}

	public BTTOperation(String anOperationName, String aParentContext)
			throws IOException, DSEInvalidRequestException,
			DSEObjectNotFoundException {
		setName(anOperationName);
		readExternal();
		Context parentContext = ContextFactory.getContextNamed(aParentContext);
		if (parentContext == null)
			parentContext = ContextFactory.createContext(aParentContext, false);
		chainTo(parentContext);
	}

	public void chainTo(Context aContext) throws DSEInvalidRequestException {
		if (this.context == null)
			return;
		this.context.chainTo(aContext);
	}

	public static Externalizer getExternalizer() throws IOException {
		if (externalizer == null)
			throw new IOException("Operations externalizer not initialized");
		return externalizer;
	}

	public Object initializeFrom(Tag aTag) throws IOException, DSEException {
		if (log.doDebug())
			log.entry();

		setContext(null);
		setName("");
		getFormats().removeAll();
		this.opSteps.removeAll();
		setName(aTag.getId());
		try {
			getExternalizer().tagWithId(getName());
		} catch (IOException e) {
			this.isSelfDefinedOperation = true;
		}

		if (aTag.getSubTags().size() > 0) {
			Tag opContextTag = (Tag) aTag.getSubTags().lastElement();
			if (opContextTag.getName().equals("context")) {
				try {
					setContext((Context) ContextFactory.getExternalizer()
							.convertTagToObject(opContextTag));
				} catch (Exception e) {
					throw ((IOException) new IOException(
							"Not able to create the context "
									+ opContextTag.getId() + " in operation "
									+ getName() + " " + e.toString())
					.initCause(e));
				}
			}
			//anhld
			if (opContextTag.getName().equals("msgcontext")) {
				try {
					setMsgContext((Context) ContextFactory.getExternalizer()
							.convertTagToObject(opContextTag));
				} catch (Exception e) {
					throw ((IOException) new IOException(
							"Not able to create the msg context "
									+ opContextTag.getId() + " in operation "
									+ getName() + " " + e.toString())
					.initCause(e));
				}
			}
		}

		Enumeration theSubTags = aTag.getSubTags().elements();
		Tag nextSubTag = null;

		while (theSubTags.hasMoreElements()) {
			nextSubTag = (Tag) theSubTags.nextElement();

			if (nextSubTag.getName().equals("refFormat")) {
				initializeFormatFrom(nextSubTag);
			} else if (nextSubTag.getName().equals("opStep")) {
				initializeOpStep(nextSubTag);
			} else if (nextSubTag.getName().equals("refOpSteps")) {
				initializeOpStepsFrom(nextSubTag);
			} else if (nextSubTag.getName().equals("iniValue")) {
				initializeKeyedCollectionValueFrom(nextSubTag);
			}
			if (!(log.doDebug()))
				continue;
			log.debug("The Tag Name is " + nextSubTag.getName());
		}

		Vector attrs = aTag.getAttrList();
		for (int idx = 0; idx < attrs.size(); ++idx) {
			TagAttribute attr = (TagAttribute) attrs.elementAt(idx);
			if (attr.getName().equals("xVal")) {
				initializeXValidation((String) attr.getValue());
			}
		}

		this.tag = aTag;

		if (log.doDebug())
			log.exit();

		return this;
	}

	public Object initializeFormatFrom(Tag aTag) throws IOException {
		Object formatObject = null;
		String aFormatElementId = null;
		String aFormatElementName = null;

		for (Enumeration en = aTag.getAttrList().elements(); en
				.hasMoreElements();) {
			TagAttribute attribute = (TagAttribute) en.nextElement();

			if (attribute.getName().equals("name")) {
				aFormatElementName = (String) attribute.getValue();
			} else if (attribute.getName().equals("refId")) {
				aFormatElementId = (String) attribute.getValue();
			}
		}

		formatObject = FormatElement.getExternalizer().convertTagToObject(aTag);
		((FormatElement) formatObject).setName(aFormatElementId);
		//((Cacheable) formatObject).setName(aFormatElementId);

		getFormats().put(aFormatElementName, formatObject);
		return this;
	}

	public void initializeOpStep(Tag aTag) throws IOException,
	DSEInvalidArgumentException {
		KeyedCollection kc = new KeyedCollection();
		DataField onOther = new DataField();
		DataField name = new DataField();
		name.setName("name");
		onOther.setName("onOtherDo");
		onOther.setValue("next");
		for (Enumeration en = aTag.getAttrList().elements(); en
				.hasMoreElements();) {
			TagAttribute attribute = (TagAttribute) en.nextElement();
			if (attribute.getName().equals("onOtherDo")) {
				onOther.setValue(attribute.getValue());
			} else if (attribute.getName().equals("id")) {
				name.setValue(attribute.getValue());
				kc.setName((String) attribute.getValue());
			} else {
				DataField df = new DataField();
				if (attribute.getName().equals("onTrue"))
					df.setName("on0Do");
				else if (attribute.getName().equals("onFalse"))
					df.setName("on1Do");
				else
					df.setName(attribute.getName());
				df.setValue(attribute.getValue());
				kc.addElement(df);
			}

		}

		Enumeration theSubTags = aTag.getSubTags().elements();
		Tag nextSubTag = null;
		while (theSubTags.hasMoreElements()) {
			nextSubTag = (Tag) theSubTags.nextElement();
			if (!(nextSubTag.getName().equals("param")))
				continue;
			String paramName = null;
			String paramValue = null;
			Enumeration subTagAttributes = nextSubTag.getAttrList().elements();
			while (subTagAttributes.hasMoreElements()) {
				TagAttribute subTagAttribute = (TagAttribute) subTagAttributes
						.nextElement();
				if (subTagAttribute.getName().equals("id"))
					paramName = (String) subTagAttribute.getValue();
				else if (subTagAttribute.getName().equals("value"))
					paramValue = (String) subTagAttribute.getValue();
			}
			if ((paramName != null) && (paramValue != null)) {
				DataField df = new DataField();
				df.setName(paramName);
				df.setValue(paramValue);
				kc.addElement(df);
			}
		}

		kc.addElement(name);
		kc.addElement(onOther);
		this.opSteps.addElement(kc);
	}

	public void initializeOpStepsFrom(Tag aTag) throws IOException {
		try {
			Tag opStepsTag = (Tag) aTag.getSubTags().lastElement();

			if (!(opStepsTag.getName().equals("opStepsKColl"))) {
				throw new DSEException(DSEException.harmless,
						"BTTOperation.initializeOpStepsFrom", "invalid tag: "
								+ opStepsTag.getName());
			}
			Enumeration subTags = opStepsTag.getSubTags().elements();
			Tag nextSubTag = null;
			while (subTags.hasMoreElements()) {
				nextSubTag = (Tag) subTags.nextElement();

				if (nextSubTag.getName().equals("opStep")) {
					initializeOpStep(nextSubTag);
				}

				if (nextSubTag.getName().equals("refOpSteps"))
					;
				initializeOpStepsFrom(nextSubTag);
			}
		} catch (Exception e) {
			throw ((IOException) new IOException(
					"Unable to initialize the operation steps from Tag: "
							+ aTag + ".").initCause(e));
		}
	}

	public Object initializeKeyedCollectionValueFrom(Tag aTag)
			throws IOException {
		String dataName = null;
		Object dataValue = null;
		Enumeration attributes = aTag.getAttrList().elements();
		while (attributes.hasMoreElements()) {
			TagAttribute attribute = (TagAttribute) attributes.nextElement();
			if (attribute.getName().equals("name")) {
				dataName = (String) attribute.getValue();
			} else if (attribute.getName().equals("value"))
				dataValue = attribute.getValue();
		}
		try {
			if (dataName.length() == 0)
				throw new IOException(
						"Not able to initialize keyed collection from tag: "
								+ aTag.toString());
			getKeyedCollection().setValueAt(dataName, dataValue);
		} catch (Exception e) {
			throw ((IOException) new IOException(e.toString()).initCause(e));
		}
		return this;
	}

	private void initializeXValidation(String className) throws IOException {
		Class cls;
		try {
			cls = BTTClassLoader.loadClass(className);
		} catch (ClassNotFoundException xcp) {
			throw ((IOException) new IOException(
					"Cross validation class named \"" + className
					+ "\" could not be found.").initCause(xcp));
		}

		try {
			this.xval = ((OperationXValidate) cls.newInstance());
		} catch (Exception xcp) {
			throw ((IOException) new IOException(
					"Could not create an instance of the cross validation class named \""
							+ className + "\".").initCause(xcp));
		}
	}

	public void setContext(Context aContext) {
		this.context = aContext;
	}

	public void setMsgContext(Context aContext) {
		this.msgcontext = aContext;
	}

	public KeyedCollection getKeyedCollection()
			throws DSEInvalidRequestException {
		if (this.context == null)
			return null;
		return this.context.getKeyedCollection();
	}

	public void execute() throws Exception {
		if (log.doDebug())
			log.entry();

		String onDo = "";
		String next = null;

		if (this.opSteps.size() > 0) {
			this.opStepRC = 0;
			OperationStepInterface opST = null;
			int index = 0;
			while (true) {
				KeyedCollection kc = null;
				OperationStepInterface opS = null;
				String aclass = null;
				DataField aData = null;
				try {
					kc = getOperationStep(index);

					String tag = "";
					aData = (DataField) kc.getElements().get("implClass");
					if (aData != null) {
						aclass = (String) aData.getValue();
						opS = getInstanceOfOperationStep(aclass);
					} else {
						tag = tag + ((String) kc.getValueAt("name"));

						opS = getInstanceOfOperationStep((String) OperationInitializer
								.getTagClassTable().get(tag));
					}
					opS.setParams(kc);
				} catch (Exception e) {
					if (log.doInfo()) {
						if (e instanceof ArrayIndexOutOfBoundsException) {
							String aMessage = opstepTrace
									.getString("OPSTEPINF00002I");
							MessageFormat msgFormat = new MessageFormat(
									aMessage);
							Object[] args = new Object[1];
							args[0] = opST.getName();
							log.info(msgFormat.format(args));
						} else {
							log.info(e.getMessage(), e);
						}

					}

					fireHandleOperationRepliedEvent(new OperationRepliedEvent(
							this));
					return;
				}
				opS.setOperation(this);

				if (log.doDebug())
					log.debug("The [" + opS.getName()
							+ "] OpStep begin to exectue.");

				Object object = opS.preExecute();
				this.opStepRC = opS.execute();
				opS.postExecute(object);

				opST = opS;

				if (log.doDebug())
					log.debug("The [" + opS.getName()
							+ "] OpStep execute successfully.");

				if (stopExecution(opS)) {
					break;
				}
				onDo = "on" + String.valueOf(this.opStepRC) + "Do";
				try {
					next = (String) kc.getValueAt(onDo);
				} catch (Exception e) {
					next = (String) kc.getValueAt("onOtherDo");
				}
				if (next.equals("next")) {
					++index;
				} else {
					if (next.equals("end"))
						break;
					index = this.opSteps.getIndexOf(next);
				}
				if (index == -1) {
					break;
				}
			}
		}
		fireHandleOperationRepliedEvent(new OperationRepliedEvent(this));

		if (!(log.doDebug()))
			return;
		log.exit();
	}

	public KeyedCollection getOperationStep(int index) throws Exception {
		return ((KeyedCollection) this.opSteps.getElementAt(index));
	}

	public OperationStepInterface getInstanceOfOperationStep(String anOpStep)
			throws Exception {
		String pack = null;
		OperationStepInterface op = null;
		try {
			op = (OperationStepInterface) BTTClassLoader.loadClass(anOpStep)
					.newInstance();
			op.setOperation(this);
			return op;
		} catch (Exception ex) {
			if (log.doInfo()) {
				String aMessage = opstepTrace.getString("OPSTEPINF00003I");
				MessageFormat msgFormat = new MessageFormat(aMessage);
				Object[] args = new Object[2];
				args[0] = super.getClass().getName();
				args[1] = ex.toString();
				log.info(msgFormat.format(args), ex);
			}
			try {
				int cont = 0;

				pack = (String) OperationInitializer.getSettings().getValueAt(
						"operations.package" + String.valueOf(cont + 1));
				try {
					op = (OperationStepInterface) BTTClassLoader.loadClass(
							pack + "." + anOpStep).newInstance();
					op.setOperation(this);
					return op;
				} catch (Exception e) {
					if (log.doInfo()) {
						String aMessage = opstepTrace
								.getString("OPSTEPINF00004I");
						MessageFormat msgFormat = new MessageFormat(aMessage);
						Object[] args = new Object[2];
						args[0] = super.getClass().getName();
						args[1] = e.toString();
						log.info(msgFormat.format(args), e);
					}
				}
				++cont;
			} catch (Exception e) {
				if (log.doInfo()) {
					String aMessage = opstepTrace.getString("OPSTEPINF00005I");
					MessageFormat msgFormat = new MessageFormat(aMessage);
					Object[] args = new Object[2];
					args[0] = super.getClass().getName();
					args[1] = anOpStep;
					log.info(msgFormat.format(args), e);
				}
			}
		}
		return null;
	}

	public String[] xValidate() {
		String[] xverrs = null;

		if (this.xval != null) {
			Context ctx = getContext();
			if (ctx != null) {
				xverrs = this.xval.xValidate(ctx);
			}

		}

		return xverrs;
	}

	public OperationXValidate getXValidator() {
		return this.xval;
	}

	public static synchronized void setExternalizer(Externalizer anExternalizer) {
		externalizer = anExternalizer;
	}

	public Externalizer externalizer() throws IOException {
		return getExternalizer();
	}

	public String getName() {
		return this.id;
	}

	public void readExternal() throws IOException {
		Tag aTag = null;

		String modularityValue = Settings.getModularityValue();
		try {
			if ((modularityValue.equals("grouped"))
					|| (modularityValue.equals("mixed")))
				aTag = externalizer.getTagInputStream().tagWithId(getName());
			else
				throw new IOException(
						"Modularity tag value in .INI file is nor grouped and neither mixed.");

		} catch (Exception e0) {
			Object[] operationData = null;
			String fileOpName = null;
			String pathFile = null;
			try {
				if ((modularityValue.equals("mixed"))
						|| (modularityValue.equals("split"))) {
					TagInputStream theSelfDefinedTagInputStream;
					try {
						theSelfDefinedTagInputStream = getSelfDefinedOpTagInputStream(getName());
						if (theSelfDefinedTagInputStream == null)
							throw new IOException(
									"TagInputStream corresponding to the self-defined operation file containing the operation id "
											+ getName() + " not created.");
					} catch (Exception e) {
						throw ((IOException) new IOException(e.getMessage())
						.initCause(e));
					}

					aTag = theSelfDefinedTagInputStream.tagWithId(getName());
				} else {
					throw new IOException(
							"Modularity tag value in .INI file is nor mixed and neither split.");
				}

			} catch (Exception e1) {
				if (e1.getMessage()
						.equals("TagInputStream corresponding to the self-defined operation file containing the operation id "
								+ getName() + " not created.")) {
					try {
						operationData = ((OperationExternalizer) getExternalizer())
								.getSgmlSelfDefinedOpFileName(getName());
						fileOpName = (String) operationData[1];
						pathFile = (String) operationData[2];

						((OperationExternalizer) getExternalizer())
						.setSelfDefinedOpTagInputStream(fileOpName,
								pathFile);

						aTag = getSelfDefinedOpTagInputStream(getName())
								.tagWithId(getName());
					} catch (Exception e2) {
						throw ((IOException) new IOException(
								"Regarding to the generic operation file, the following exception has been thrown: "
										+ e0.getMessage()
										+ " -- Regarding to the "
										+ getSgmlSelfDefinedOpFileName(getName())
										+ " file, the following exception has been thrown: "
										+ e2.getMessage()).initCause(e2));
					}

				} else {
					throw new IOException(
							"Regarding to the generic operation file, the following exception has been thrown: "
									+ e0.getMessage()
									+ "  -- "
									+ e1.getMessage());
				}

			}

		}

		try {
			initializeFrom(aTag);
		} catch (Exception e) {
			throw ((IOException) new IOException(e.toString()).initCause(e));
		}
	}

	public TagInputStream getSelfDefinedOpTagInputStream(
			String aSelfDefinedOperationId) throws IOException {
		return ((OperationExternalizer) getExternalizer())
				.getSelfDefinedOpTagInputStream(getSgmlSelfDefinedOpFileName(aSelfDefinedOperationId));
	}

	public String getSgmlSelfDefinedOpFileName(String anOperationId) {
		return ((String) Settings.getSgmlSelfDefinedOperation(anOperationId)[1]);
	}

	public void removeExternal() throws IOException {
		if (!(this.isSelfDefinedOperation))
			getExternalizer().getTagOutputStream().removeTags(toTags());
		else
			((OperationExternalizer) getExternalizer())
			.getSelfDefinedOpTagOutputStream(
					getSgmlSelfDefinedOpFileName(getName()))
					.removeTags(toTags());
	}

	public void setName(String aName) {
		this.id = aName;
	}

	public Vector toStrings() {
		Vector v = new Vector();
		String lcn = super.getClass().getName();
		String shortClassName = lcn.substring(lcn.lastIndexOf(46) + 1);
		String s = "<" + shortClassName + " ";
		if ((getName() != null) && (getName().length() > 0))
			s = s + "id=" + JavaExtensions.doubleQuote(getName()) + " ";
		if ((getContext() != null) && (getContext().getName().length() > 0))
			s = s + "operationContext="
					+ JavaExtensions.doubleQuote(getContext().getName()) + " ";
		s = s + ">";
		v.addElement(s);

		for (Enumeration e = getFormats().keys(); e.hasMoreElements();) {
			String refFormatName = (String) e.nextElement();
			String t = "<refFormat name="
					+ JavaExtensions.doubleQuote(refFormatName)
					+ " refId="
					+ JavaExtensions.doubleQuote(((Cacheable) getFormats().get(
							refFormatName)).getName()) + " " + "/" + ">";
			v.addElement(t);
		}

		for (Enumeration enum1 = getOperationSteps().getElements().elements(); enum1
				.hasMoreElements();) {
			KeyedCollection anOpStep = (KeyedCollection) enum1.nextElement();
			String u = "<opStep id="
					+ JavaExtensions.doubleQuote(anOpStep.getName());
			for (int i = 0; i < anOpStep.getOrderVector().size(); ++i) {
				String attrName = (String) anOpStep.getOrderVector().elementAt(
						i);
				DataField anAttrib = (DataField) anOpStep.getElements().get(
						attrName);
				if (!(anAttrib.getName().equals("name")))
					u = u
					+ " "
					+ anAttrib.getName()
					+ "="
					+ JavaExtensions.doubleQuote(anAttrib.getValue()
							.toString());
			}
			u = u + " " + "/" + ">";
			v.addElement(u);
		}

		v.addElement("</" + shortClassName + " >");
		v.tabulate();
		return v;
	}

	public KeyedCollection getOperationSteps() {
		return this.opSteps;
	}

	public Vector toTags() throws IOException {
		return toStrings().toTags();
	}

	public void writeExternal() throws IOException {
		if (!(this.isSelfDefinedOperation))
			getExternalizer().getTagOutputStream().writeTags(toTags());
		else
			((OperationExternalizer) getExternalizer())
			.getSelfDefinedOpTagOutputStream(
					getSgmlSelfDefinedOpFileName(getName())).writeTags(
							toTags());
	}

	public void readExternal(ObjectInput s) throws IOException,
	ClassNotFoundException {
	}

	public static Context getContextNamed(String aContextName)
			throws DSEInvalidRequestException {
		return ContextFactory.getContextNamed(aContextName);
	}

	public static Context getMsgContextNamed(String aContextName)
			throws DSEInvalidRequestException {
		return ContextFactory.getContextNamed(aContextName);
	}

	public Hashtable getFormats() {
		return this.formats;
	}

	public Object getValueAt(String aCompositeKey)
			throws DSEObjectNotFoundException {
		if (this.context == null)
			return null;
		return this.context.getValueAt(aCompositeKey);
	}

	public void setValueAt(String aCompositeKey, Object aDataValue)
			throws DSEObjectNotFoundException, DSEInvalidArgumentException {
		if (this.context == null)
			return;
		try {
			this.context.setValueAt(aCompositeKey, aDataValue);
		} catch (DSEInvalidRequestException e) {
			throw new DSEInvalidArgumentException(e.getMessage(), e);
		}
	}

	public boolean isCacheable() {
		return true;
	}

	public void reinitialize() {
		if (this.tag == null)
			return;
		try {
			initializeFrom(this.tag);
		} catch (Exception e) {
			if (log.doError())
				log.error(StringUtils
						.contactString(new Object[] {
								"MSG:",
								"Exception caught while reinitializing the operation: ",
								getName(),
								". The operation is not reinitialized. Exception: ",
								e }));
		}
	}

	public void writeExternal(ObjectOutput s) throws IOException {
	}

	public Context getContext() {
		return this.context;
	}

	public Context getMSgContext() {
		return this.msgcontext;
	}

	public static Object readObject(String aName) throws IOException {
		return getExternalizer().readObject(aName);
	}

	public void unchain() throws DSEInvalidRequestException,
	DSEObjectNotFoundException {
		if (this.context == null)
			return;
		this.context.unchain();
	}

	public DataElement addElement(DataElement aDataElement)
			throws DSEInvalidRequestException {
		if (this.context == null)
			return null;
		this.context.addElement(aDataElement);
		return aDataElement;
	}

	public void close() throws DSEInvalidRequestException,
	DSEObjectNotFoundException {
		if (this.context == null)
			return;
		if (this.isDefinedContext) {
			unchain();
			prune();
		}
	}

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String appId) {
		this.applicationId = appId;
	}

	public String getContextName() {
		if (this.context == null)
			return null;
		return this.context.getName();
	}

	public String getMsgContextName() {
		if (this.msgcontext == null)
			return null;
		return this.msgcontext.getName();
	}

	public DataElement getElementAt(String aCompositeKey)
			throws DSEObjectNotFoundException {
		if (this.context == null)
			return null;
		return this.context.getElementAt(aCompositeKey);
	}

	public Object getFormat(String aFormatName)
			throws DSEInvalidArgumentException {
		try {
			return getFormats().get(aFormatName);
		} catch (NullPointerException e) {
			String message = StringUtils.contactString(new Object[] {
					"the format named: ", aFormatName, " has not been found" });
			throw new DSEInvalidArgumentException(DSEException.harmless, super
					.getClass().getName(), message, e);
		}
	}

	public Context getParent() throws DSEInvalidRequestException {
		if (this.context == null)
			return null;
		return this.context.getParent();
	}

	public String getType() throws DSEInvalidRequestException {
		if (this.context == null)
			return null;
		return this.context.getType();
	}

	public boolean isChained() throws DSEInvalidRequestException {
		if (this.context == null)
			return false;
		return this.context.isChained();
	}

	public void prune() throws DSEInvalidRequestException,
	DSEObjectNotFoundException {
		if (this.context == null)
			return;
		this.context.prune();
	}

	public DataElement removeAt(String aCompositeKey)
			throws DSEInvalidRequestException, DSEObjectNotFoundException {
		if (this.context == null)
			return null;
		return this.context.removeAt(aCompositeKey);
	}

	public void setContextName(String aContextName) {
		if (this.context == null)
			return;
		this.context.setName(aContextName);
	}

	public void setMsgContextName(String aContextName) {
		if (this.msgcontext == null)
			return;
		this.msgcontext.setName(aContextName);
	}

	public void setKeyedCollection(KeyedCollection aKeyedCollection)
			throws DSEInvalidRequestException {
		if (this.context == null)
			return;
		this.context.setKeyedCollection(aKeyedCollection);
	}

	public void setType(String aContextType) throws DSEInvalidRequestException {
		if (this.context == null)
			return;
		this.context.setType(aContextType);
	}

	public void setDefinedContext(boolean anIsDefinedContext) {
		this.isDefinedContext = anIsDefinedContext;
	}

	public void clearKeyedCollection(boolean keepKCollStatus,
			boolean clearOnlyValues) throws IOException,
			DSEInvalidRequestException, DSEInvalidArgumentException {
		KeyedCollection kc = null;
		Hashtable currHash = null;
		Hashtable newHash = null;
		Object key = null;
		Object value = null;
		DataElement element = null;
		Enumeration currKeys = null;
		Enumeration values = null;
		if (this.isSelfDefinedOperation) {
			boolean typedElement = false;

			if (getKeyedCollection().getDescriptor() != null)
				typedElement = true;
			try {
				if (!(typedElement))
					kc = (KeyedCollection) DataElement
					.readObject(getKeyedCollection().getName());
				else {
					kc = (KeyedCollection) DSEType.getExternalizer()
							.readObject(getKeyedCollection().getName());
				}
			} catch (IOException e) {
				kc = ((OperationExternalizer) getExternalizer())
						.getNewKCollForOperation(getName(),
								getKeyedCollection().getName());
			} catch (DSETypeException e) {
				try {
					kc = (KeyedCollection) DataElement
							.readObject(getKeyedCollection().getName());
				} catch (IOException e2) {
					kc = ((OperationExternalizer) getExternalizer())
							.getNewKCollForOperation(getName(),
									getKeyedCollection().getName());
				}
			}
			if (kc == null) {
				String message = "kColl named "
						+ getContext().getKeyedCollection().getName()
						+ " has not been found neither in the generic files nor in the self defined file";
				if ((keepKCollStatus) && (clearOnlyValues)) {
					if (log.doInfo()) {
						log.info(message);
					}

				} else {
					throw new IOException("Error clearing operation context: "
							+ message);
				}

			} else if (!(clearOnlyValues)) {
				if (keepKCollStatus) {
					kc.setDescription(getKeyedCollection().getDescription());
					kc.setParameters(getKeyedCollection().getParameters());
					kc.setErrorInfo(getKeyedCollection().getErrorInfo());
					kc.setState(getKeyedCollection().getState());
					kc.setDescriptor(getKeyedCollection().getDescriptor());
					kc.setDynamic(getKeyedCollection().getDynamic());
				}
				setKeyedCollection(kc);
			} else {
				newHash = kc.calculeNestedQualifiedElements();
				currHash = getKeyedCollection()
						.calculeNestedQualifiedElements();
				currKeys = currHash.keys();
				while (currKeys.hasMoreElements()) {
					key = currKeys.nextElement();
					element = (DataElement) newHash.get(key);
					if ((element == null) || (!(element instanceof DataField)))
						continue;
					Object newValue = ((DataField) element).getValue();
					DataField field = (DataField) currHash.get(key);
					if (field != null)
						field.setValue(newValue);

				}

				if (!(keepKCollStatus)) {
					getKeyedCollection().setDescription(kc.getDescription());
					getKeyedCollection().setParameters(kc.getParameters());
					getKeyedCollection().setErrorInfo(kc.getErrorInfo());
					getKeyedCollection().setState(kc.getState());
					getKeyedCollection().setDescriptor(kc.getDescriptor());
					getKeyedCollection().setDynamic(kc.getDynamic());
				}
			}

		} else {
			getContext().clearKeyedCollection(keepKCollStatus, clearOnlyValues);
		}
	}

	public Context getContextByType(String aContextType)
			throws DSEInvalidRequestException {
		if (this.context == null)
			return null;
		return this.context.getContextByType(aContextType);
	}

	public Object getHostReceiveFormat() {
		return getFormats().get("hostReceiveFormat");
	}

	public Object getHostSendFormat() {
		return getFormats().get("hostSendFormat");
	}

	public int getOperationStepRC() {
		return this.opStepRC;
	}

	public Service getService(String aServiceName)
			throws DSEObjectNotFoundException {
		if (this.context == null)
			return null;
		try {
			return this.context.getService(aServiceName);
		} catch (DSEObjectNotFoundException e) {
			try {
				return ((Service) Service.readObject(aServiceName));
			} catch (IOException e1) {
				throw new DSEObjectNotFoundException(e1);
			}
		}
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setHostReceiveFormat(Object aFormat) {
		getFormats().put("hostReceiveFormat", aFormat);
	}

	public void setHostSendFormat(Object aFormat) {
		getFormats().put("hostSendFormat", aFormat);
	}

	public void setSessionId(String sessId) {
		this.sessionId = sessId;
	}

	public void setXValidator(OperationXValidate xValidator) {
		this.xval = xValidator;
	}

	public String toString() {
		return toStrings().toOneString();
	}

	public void addOperationRepliedListener(OperationRepliedListener newListener) {
		this.aOperationRepliedListener = OperationRepliedEventMulticaster.add(
				this.aOperationRepliedListener, newListener);
	}

	public void removeOperationRepliedListener(
			OperationRepliedListener newListener) {
		this.aOperationRepliedListener = OperationRepliedEventMulticaster
				.remove(this.aOperationRepliedListener, newListener);
	}

	public void fireHandleOperationRepliedEvent(OperationRepliedEvent event) {
		if (this.aOperationRepliedListener == null) {
			return;
		}
		this.aOperationRepliedListener.handleOperationRepliedEvent(event);
	}

	public Object preExecute() {
		return null;
	}

	public void postExecute(Object object) {
	}

	protected boolean stopExecution(OperationStepInterface opStep) {
		return false;
	}
}