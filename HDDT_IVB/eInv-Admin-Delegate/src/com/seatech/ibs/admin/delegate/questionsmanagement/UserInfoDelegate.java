package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;

import com.seatech.ibs.admin.service.questionsmanagement.UserInfoService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.ldap.LdapContactDTO;
import com.seatech.ibs.corp.pojo.user.UserInfo;




public class UserInfoDelegate {
	private UserInfoService userService()throws Exception{
		try {
			return (UserInfoService) SpringBeanDelegate.getBean("bBUserService");
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 
	 * @param pUserId
	 * @return
	 * @throws Exception
	 */
	public  UserInfo findBBUserInfoById(int pUserId) throws Exception{
		return userService().findBBUserInfoById(pUserId);
	}
	
	
	public UserInfo getUserInfoByUserName(String pUserName) throws Exception{
		return userService().getUserInfoByUserName(pUserName);
	}
	
	public LdapContactDTO findUser(String userName) throws Exception {
		return userService().findUser(userName);
	}
	
	
}