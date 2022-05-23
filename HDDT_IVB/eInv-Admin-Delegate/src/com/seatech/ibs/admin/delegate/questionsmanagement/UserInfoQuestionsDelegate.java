package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.user.UserInfoQuestions;
import com.seatech.ibs.admin.service.questionsmanagement.UserInforQuestionService;
import com.seatech.ibs.common.dto.Pagination;

public class UserInfoQuestionsDelegate  extends DelegateBase{
	public List<UserInfoQuestions> selectByOrgId(Pagination pn, Map<String,Object> map) throws Exception {
		return ((UserInforQuestionService) getBean("userInfoQuestionService")).selectByOrgId(pn, map);			
	}
	
	public List<UserInfoQuestions> selectByUserNameAndNick(UserInfoQuestions userQuestions) throws Exception {
		return ((UserInforQuestionService) getBean("userInfoQuestionService")).selectByUserNameAndNick(userQuestions);	
	}
	
	public List<UserInfoQuestions> selectByUserRoleId(UserInfoQuestions userQuestions) throws Exception {
		return ((UserInforQuestionService) getBean("userInfoQuestionService")).selectByUserRoleId(userQuestions);	
	}
	
	public List<UserInfoQuestions> selectAllCondition(UserInfoQuestions info) throws Exception {
		return ((UserInforQuestionService) getBean("userInfoQuestionService")).selectAllCondition(info);	
	}
}
