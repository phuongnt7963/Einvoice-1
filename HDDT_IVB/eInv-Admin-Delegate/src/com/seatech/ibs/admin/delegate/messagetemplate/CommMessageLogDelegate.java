package com.seatech.ibs.admin.delegate.messagetemplate;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.comm.CommMessageLog;
import com.seatech.ibs.admin.service.messagetemplate.CommMessageLogService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;


public class CommMessageLogDelegate{

	
	public void remove(int pId) throws Exception {
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		service.remove(pId);
		
	}

	
	public CommMessageLog getById(int pTemplateId)throws Exception{
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		return service.getById(pTemplateId);
	}	

	
	public void add(CommMessageLog pMessageTemplate) throws Exception {
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		service.add(pMessageTemplate);
	}
	public void add(List<String> senderList,CommMessageLog pMessageTemplate) throws Exception {
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		service.add(senderList,pMessageTemplate);
	}

	
	public void modify(CommMessageLog pMessageTemplate) throws Exception {
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		service.modify(pMessageTemplate);
	}

	
	public List<CommMessageLog> query(String pMessageTyme) throws Exception {
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		return service.query(pMessageTyme);
	}

	
	public List<CommMessageLog> query(String pCommChannel,String pStatus) throws Exception {
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		return service.query(pCommChannel,pStatus);
	}

	
	public List<CommMessageLog> queryPn(CommMessageLog pCommMessageLog,Pagination pn)throws Exception{
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		return service.queryPn(pCommMessageLog,pn);
	}
	
	
	private CommMessageLogService getCommMessageLogServiceBean(){
		return (CommMessageLogService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminCommMessageLogService");
	}
	
	
	public void reactiveWithEmail(Map<String,Object> map) throws Exception {
			CommMessageLogService service=this.getCommMessageLogServiceBean();
			service.reactiveWithEmail(map);
	}
	public List<CommMessageLog> getLastestEmailWithUserName(Map<String,Object> map)throws Exception{		
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		return service.getLastestEmailWithUserName(map);
	}
	public CommMessageLog getLastestEmailByCondition(Map<String,Object> params)throws Exception{		
		CommMessageLogService service=this.getCommMessageLogServiceBean();
		return service.getLastestEmailByCondition(params);
	}
}
