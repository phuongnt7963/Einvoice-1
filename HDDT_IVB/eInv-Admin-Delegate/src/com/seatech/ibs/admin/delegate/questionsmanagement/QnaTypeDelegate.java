package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.danhmucTT.QnaType;
import com.seatech.ibs.admin.service.questionsmanagement.QnaTypeService;

public class QnaTypeDelegate {
	QnaTypeService  qnaTypeService = (QnaTypeService) WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
					.getServletContext()).getBean("qnaTypeService");
	
	public List<QnaType> queryListQnaType(QnaType qnaType) throws Exception{
		return this.qnaTypeService.queryListQnaType(qnaType);
	}
}
