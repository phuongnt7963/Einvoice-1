package com.seatech.ibs.admin.delegate.in;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.in.InternalMessage;
import com.seatech.ibs.admin.pojo.user.UserInfo;
import com.seatech.ibs.admin.service.in.InternalMessageService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.service.exception.IBSServiceException;

public class InternalMessageDelegate {
	
	public void addInternalMessage(InternalMessage message) throws Exception{
		InternalMessageService service=this.getInternalMessageBean();
		service.addInternalMessage(message);
	}
	public void addInternalMessage(List<UserInfo> listSend, InternalMessage message) throws Exception{
		InternalMessageService service=this.getInternalMessageBean();
		service.addInternalMessage(listSend,message);
	}
	
	public void removeInternalMessage(int messageId) throws Exception{
		InternalMessageService service=this.getInternalMessageBean();
		service.removeInternalMessage(messageId);
	}
	
	public InternalMessage getInternalMessageById(int messageId) throws Exception {
		InternalMessageService service=this.getInternalMessageBean();
		return service.getInternalMessageById(messageId);
	}
	
	public void modifyInternalMessage(InternalMessage message) throws Exception {
		InternalMessageService service=this.getInternalMessageBean();
		service.modifyInternalMessage(message);
	}
	
	public List<InternalMessage> queryInternalMessageList(InternalMessage message) throws Exception {
		InternalMessageService service=this.getInternalMessageBean();
		return service.queryInternalMessageList(message);
	}

    public List<InternalMessage> queryInternalMessageListPagination(InternalMessage message,Pagination pn) throws IBSServiceException {
    	InternalMessageService service=this.getInternalMessageBean();
    	return service.queryInternalMessageListPagination(message, pn);
	}
    
    private InternalMessageService getInternalMessageBean(){
		return  (InternalMessageService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminInternalMessageService");
	}
}
