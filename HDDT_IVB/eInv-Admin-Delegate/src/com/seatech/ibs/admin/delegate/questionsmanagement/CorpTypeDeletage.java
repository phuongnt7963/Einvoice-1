package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.questionsmanagement.CorpType;
import com.seatech.ibs.admin.service.questionsmanagement.CorpTypeService;

public class CorpTypeDeletage extends DelegateBase {
	public List<CorpType> selectAllCorpType() throws Exception {
		return ((CorpTypeService) getBean("corpTypeQuestionService")).selectAllCorpType();
	}
	
	public List<CorpType> selectByType(String[] typeId) throws Exception {
		return ((CorpTypeService) getBean("corpTypeQuestionService")).selectByType(typeId);
	}
	
	public List<CorpType> selectByType1(CorpType corpType) throws Exception {
		return ((CorpTypeService) getBean("corpTypeQuestionService")).selectByType1(corpType);
	}
}
