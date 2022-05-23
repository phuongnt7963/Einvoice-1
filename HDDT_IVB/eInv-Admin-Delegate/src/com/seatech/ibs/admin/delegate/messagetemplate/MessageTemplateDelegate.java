package com.seatech.ibs.admin.delegate.messagetemplate;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.messagetemplate.MessageTemplate;
import com.seatech.ibs.admin.service.messagetemplate.MessageTemplateService;
import com.ibm.btt.sm.HttpSessionInfoHolder;

public class MessageTemplateDelegate{

	public void remove(int pTemplateId) throws Exception {
		MessageTemplateService service=this.getMessageTemplateServiceBean();
		service.remove(pTemplateId);
		
	}

	
	public MessageTemplate getById(int pTemplateId)throws Exception{
		MessageTemplateService service=this.getMessageTemplateServiceBean();
		return service.getById(pTemplateId);
	}	

	
	public void add(MessageTemplate pMessageTemplate) throws Exception {
		MessageTemplateService service=this.getMessageTemplateServiceBean();
		service.add(pMessageTemplate);
	}

	
	public void modify(MessageTemplate pMessageTemplate) throws Exception {
		MessageTemplateService service=this.getMessageTemplateServiceBean();
		service.modify(pMessageTemplate);
	}

	
	public List<MessageTemplate> query(String pMessageTyme) throws Exception {
		MessageTemplateService service=this.getMessageTemplateServiceBean();
		return service.query(pMessageTyme);
	}
	
	public List<MessageTemplate> queryByParams(Map<String, Object> params)throws Exception{
		return this.getMessageTemplateServiceBean().queryByParams(params);
	}
	
	public MessageTemplate queryMessageTemplate(String sysCode,String templateType,String templateCode,String channel) throws Exception {
		MessageTemplateService service=this.getMessageTemplateServiceBean();
		return service.getByServiceType(sysCode, templateType, templateCode, channel);
	}
	
	
	@SuppressWarnings("rawtypes")
	public String[] getTitleAndContent(String sysCode,String templateType,String serviceType,String channel,Map params)throws Exception{
		MessageTemplateService service=this.getMessageTemplateServiceBean();
		return service.getTitleAndContent( sysCode, templateType, serviceType, channel, params);
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	public String getContent(String sysCode,String templateType,String serviceType,String channel,Map params)throws Exception{
		MessageTemplateService service=this.getMessageTemplateServiceBean();
		return service.getContent( sysCode, templateType, serviceType, channel,params);
	}
	
	
	private MessageTemplateService getMessageTemplateServiceBean(){
		return (MessageTemplateService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminMessageTemplateService");
	}
	
}
