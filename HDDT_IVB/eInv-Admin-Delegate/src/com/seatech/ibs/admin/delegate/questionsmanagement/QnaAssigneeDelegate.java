package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.questionsmanagement.QnaAssignee;
import com.seatech.ibs.admin.service.questionsmanagement.QnaAssigneeService;

public class QnaAssigneeDelegate extends DelegateBase {
	public List<QnaAssignee> selectByTyAndUserId(QnaAssignee qnaAssignee) throws Exception{
		return ((QnaAssigneeService) getBean("qnaAssigneeService")).selectByTyAndUserId(qnaAssignee);
	}
	
	public void delete(QnaAssignee qnaAssignee) throws Exception{
		((QnaAssigneeService) getBean("qnaAssigneeService")).delete(qnaAssignee);
	}
	
	public void insert(QnaAssignee qnaAssignee) throws Exception{
		((QnaAssigneeService) getBean("qnaAssigneeService")).insert(qnaAssignee);
	}
	
	public List<QnaAssignee> selectByUserAndOrgId(QnaAssignee qnaAssignee) throws Exception{
		return ((QnaAssigneeService) getBean("qnaAssigneeService")).selectByUserAndOrgId(qnaAssignee);
	}
	public List<QnaAssignee> selectDistinct (QnaAssignee qnaAssignee) throws Exception{
		return ((QnaAssigneeService) getBean("qnaAssigneeService")).selectDistinct(qnaAssignee);
	}
	
	public List<QnaAssignee> selectByTaxOrg (String tax_org) throws Exception{
		return ((QnaAssigneeService) getBean("qnaAssigneeService")).selectByTaxOrg(tax_org);
	}
}
