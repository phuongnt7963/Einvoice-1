package com.seatech.ibs.admin.delegate.mb;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.mb.MessageBoard;
import com.seatech.ibs.admin.service.mb.MessageBoardService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.service.exception.IBSServiceException;


public class MessageBoardDelegate {
	
	public void addMessageBoard(MessageBoard board) throws Exception{
		MessageBoardService service=this.getMessageBoardBean();
		service.addMessageBoard(board);
	}
	
	public void removeMessageBoard(int messageId) throws Exception{
		MessageBoardService service=this.getMessageBoardBean();
		service.removeMessageBoard(messageId);
	}
	
	public MessageBoard getMessageBoardById(int messageId) throws Exception {
		MessageBoardService service=this.getMessageBoardBean();
		return service.getMessageBoardById(messageId);
	}
	
	public void modifyMessageBoard(MessageBoard board) throws Exception {
		MessageBoardService service=this.getMessageBoardBean();
		service.modifyMessageBoard(board);
	}
	
	public List<MessageBoard> queryMessageBoardList(MessageBoard board) throws Exception {
		MessageBoardService service=this.getMessageBoardBean();
		return service.queryMessageBoardList(board);
	}

    @SuppressWarnings("rawtypes")
	public List<MessageBoard> queryMessageBoardListPagination(HashMap board,Pagination pn) throws IBSServiceException {
    	MessageBoardService service=this.getMessageBoardBean();
    	return service.queryMessageBoardListPagination(board, pn);
	}
    
    private MessageBoardService getMessageBoardBean(){
		try {
			return (MessageBoardService) SpringBeanDelegate.getBean("adminMessageBoardService");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return  (MessageBoardService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminMessageBoardService");
		}

	}
}
