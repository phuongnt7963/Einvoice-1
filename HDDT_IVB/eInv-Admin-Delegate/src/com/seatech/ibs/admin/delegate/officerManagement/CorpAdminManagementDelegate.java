package com.seatech.ibs.admin.delegate.officerManagement;

import java.util.List;

import com.seatech.ibs.admin.pojo.user.CorpAdminManagement;
import com.seatech.ibs.admin.pojo.user.UserDelegate;
import com.seatech.ibs.admin.pojo.user.UserInfo;
import com.seatech.ibs.admin.service.officerManagement.CorpAdminManagementService;
import com.seatech.ibs.corp.pojo.corp.CorpInfo;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;


public class CorpAdminManagementDelegate {
	
	public List<CorpAdminManagement> queryAllCorpAdminManagement(Pagination pn) throws Exception{
		CorpAdminManagementService aCorpAdminManagementService = (CorpAdminManagementService)SpringBeanDelegate.getBean("corpAdminManagementService");
		return aCorpAdminManagementService.queryAllCorpAdminManagement(pn);
	}
	
	public List<CorpInfo> queryByCorpIdCorpNameCifNo(String pCondition) throws Exception{
		CorpAdminManagementService aCorpAdminManagementService = (CorpAdminManagementService)SpringBeanDelegate.getBean("corpAdminManagementService");
		return aCorpAdminManagementService.queryByCorpIdCorpNameCifNo(pCondition);
	}
	
	public void deleteCorpAdminManagement(int pUserId,String pStatus) throws Exception{
		CorpAdminManagementService aCorpAdminManagementService = (CorpAdminManagementService)SpringBeanDelegate.getBean("corpAdminManagementService");
		aCorpAdminManagementService.deleteCorpAdminManagement(pUserId, pStatus);
	}
	
	public void resetPasswordCorpAdminManagement(int pUserId,String pPassword) throws Exception{
		CorpAdminManagementService aCorpAdminManagementService = (CorpAdminManagementService)SpringBeanDelegate.getBean("corpAdminManagementService");
		aCorpAdminManagementService.resetPasswordCorpAdminManagement(pUserId, pPassword);
	}
	
	public void addCorpAdminManagement(UserInfo pUserInfo,UserDelegate pUserDelegate,String[] corpName) throws Exception{
		CorpAdminManagementService aCorpAdminManagementService = (CorpAdminManagementService)SpringBeanDelegate.getBean("corpAdminManagementService");
		aCorpAdminManagementService.addCorpAdminManagement(pUserInfo, pUserDelegate, corpName);
	}
	
	public List<CorpInfo> queryUserDelegateCorpIdCorpNameByUserId(int pUserId)  throws Exception{
		CorpAdminManagementService aCorpAdminManagementService = (CorpAdminManagementService)SpringBeanDelegate.getBean("corpAdminManagementService");
		return aCorpAdminManagementService.queryUserDelegateCorpIdCorpNameByUserId(pUserId);
	}
	
	public void modifyCorpAdminManagement(UserInfo pUserInfo,UserDelegate pUserDelegate,String[] corpName) throws Exception{
		CorpAdminManagementService aCorpAdminManagementService = (CorpAdminManagementService)SpringBeanDelegate.getBean("corpAdminManagementService");
		aCorpAdminManagementService.modifyCorpAdminManagement(pUserInfo, pUserDelegate, corpName);
	}
	
	public List<CorpInfo> queryAllCorpIdCorpName() throws Exception{
		CorpAdminManagementService aCorpAdminManagementService = (CorpAdminManagementService)SpringBeanDelegate.getBean("corpAdminManagementService");
		return aCorpAdminManagementService.queryAllCorpIdCorpName();
	}
}
