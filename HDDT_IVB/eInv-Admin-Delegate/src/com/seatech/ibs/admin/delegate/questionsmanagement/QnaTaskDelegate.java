package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.danhmucTT.QnaTask;
import com.seatech.ibs.admin.service.questionsmanagement.QnaTaskService;

public class QnaTaskDelegate {
	
	QnaTaskService  qnaTaskService = (QnaTaskService) WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
					.getServletContext()).getBean("qnaTaskService");
	
	public void addQnaTask(QnaTask qnaTask) throws Exception{
		 this.qnaTaskService.addQnaTask(qnaTask);
	}
	
	public Integer selectId (QnaTask qnaTask) throws Exception{
		return qnaTaskService.selectId(qnaTask);
	}
	
	public List<QnaTask> selectUser (int messageId) throws Exception{
		return qnaTaskService.selectUser(messageId);
	}
	
	public void deleteQnaTask(QnaTask qnaTask) throws Exception{
		 this.qnaTaskService.deleteQnaTask(qnaTask);
	}

}
