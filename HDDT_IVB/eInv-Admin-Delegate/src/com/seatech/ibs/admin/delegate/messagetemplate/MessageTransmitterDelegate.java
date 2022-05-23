package com.seatech.ibs.admin.delegate.messagetemplate;

import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.messagetemplate.MessageTransmitterService;
import com.seatech.ibs.retail.pojo.user.UserInfo;

public class MessageTransmitterDelegate{

	
	@SuppressWarnings("rawtypes")
	public void createEmail(Map params) throws Exception {
		MessageTransmitterService service=this.getCommMessageLogServiceBean();
		service.createEmail(params);		
	}

	
	@SuppressWarnings("rawtypes")
	public void createSMS(Map params) throws Exception {
		MessageTransmitterService service=this.getCommMessageLogServiceBean();
		service.createSMS(params);		
	}
	
	
	@SuppressWarnings("rawtypes")
	public void createInbox(Map params)throws Exception{
		MessageTransmitterService service=this.getCommMessageLogServiceBean();
		service.createInbox(params);	
	}
	
	public void savePrintedInfo(Map params) throws Exception {
		MessageTransmitterService service=this.getCommMessageLogServiceBean();
		service.savePrintedInfo(params);
	}
	
	private MessageTransmitterService getCommMessageLogServiceBean(){
		return (MessageTransmitterService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminMessageTransmitterService");
	}
}
