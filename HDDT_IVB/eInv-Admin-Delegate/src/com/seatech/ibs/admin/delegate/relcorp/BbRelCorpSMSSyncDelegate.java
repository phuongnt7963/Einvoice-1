package com.seatech.ibs.admin.delegate.relcorp;

import java.util.List;
import java.util.Map;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.admin.service.relcorp.BbRelCorpSMSSyncService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.relcorp.BbRelSMSSync;


public class BbRelCorpSMSSyncDelegate {

	public BbRelCorpSMSSyncDelegate() {
		
	}
	
	@SuppressWarnings("unused")
	private static final BTTLog log = BTTLogFactory.getLog(BbRelCorpSMSSyncDelegate.class.getName());		
	
	@SuppressWarnings("rawtypes")
	public List<BbRelSMSSync> queryAllSMSSyncByCifNo(Map map) throws Exception {
		
		BbRelCorpSMSSyncService bbRelCorpAcctService = (BbRelCorpSMSSyncService)SpringBeanDelegate.getBean("bbRelCorpSMSSyncService");
		
		return bbRelCorpAcctService.queryAllSMSSyncByCifNo(map);
	}
	
	@SuppressWarnings("rawtypes")
	public List<BbRelSMSSync> queryAllAccountsByCifNo(Map map) throws Exception {
		
		BbRelCorpSMSSyncService bbRelCorpAcctService = (BbRelCorpSMSSyncService)SpringBeanDelegate.getBean("bbRelCorpSMSSyncService");
		
		return bbRelCorpAcctService.queryAllAccountsByCifNo(map);
	}
	
	public BbRelSMSSync querySMSSyncByParams(Map map) throws Exception {
		
		BbRelCorpSMSSyncService bbRelCorpAcctService = (BbRelCorpSMSSyncService)SpringBeanDelegate.getBean("bbRelCorpSMSSyncService");
		BbRelSMSSync result = null;
		List<BbRelSMSSync> bb=bbRelCorpAcctService.querySMSSyncByParams(map);
		if(bb != null && bb.size() > 0) {
			result = bbRelCorpAcctService.querySMSSyncByParams(map).get(0);
		}
		return result;
	}
				
	public boolean insertListOfSMSSync(List<BbRelSMSSync> listOfSMSSync) throws Exception {				
		BbRelCorpSMSSyncService bbRelCorpAcctService = (BbRelCorpSMSSyncService)SpringBeanDelegate.getBean("bbRelCorpSMSSyncService");		
		return bbRelCorpAcctService.insertListOfSMSSync(listOfSMSSync);
	}
	
	public boolean updateListOfSMSSync(List<BbRelSMSSync> listOfSMSSync) throws Exception {
		BbRelCorpSMSSyncService bbRelCorpAcctService = (BbRelCorpSMSSyncService)SpringBeanDelegate.getBean("bbRelCorpSMSSyncService");		
		return bbRelCorpAcctService.updateListOfSMSSync(listOfSMSSync);
	}
	
	public boolean removeListOfSMSSync(List<BbRelSMSSync> listOfSMSSync) throws Exception {				
		BbRelCorpSMSSyncService bbRelCorpAcctService = (BbRelCorpSMSSyncService)SpringBeanDelegate.getBean("bbRelCorpSMSSyncService");		
		return bbRelCorpAcctService.deleteListOfSMSSync(listOfSMSSync);
	}
	
	
}
