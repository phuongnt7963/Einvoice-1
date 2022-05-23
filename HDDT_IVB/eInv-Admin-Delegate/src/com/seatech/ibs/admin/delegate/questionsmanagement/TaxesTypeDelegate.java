package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.questionsmanagement.TaxesType;
import com.seatech.ibs.admin.service.questionsmanagement.TaxesTypeService;

public class TaxesTypeDelegate extends DelegateBase {
	
	public List<TaxesType> selectByStatus() throws Exception {
		return ((TaxesTypeService) getBean("taxesTypeQuestionService")).selectByStatus();
	}
		
	public List<TaxesType> selectByType(String[] typeId) throws Exception {
		return ((TaxesTypeService) getBean("taxesTypeQuestionService")).selectByType(typeId);
	}
	
	public List<TaxesType> selectByType1(TaxesType taxesType) throws Exception{
		return ((TaxesTypeService) getBean("taxesTypeQuestionService")).selectByType1(taxesType);
	}
}
