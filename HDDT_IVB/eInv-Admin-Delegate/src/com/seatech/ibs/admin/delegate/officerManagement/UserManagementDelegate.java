package com.seatech.ibs.admin.delegate.officerManagement;

import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.pojo.bank.BankOrg;
import com.seatech.ibs.admin.pojo.module.Module;
import com.seatech.ibs.admin.pojo.permission.UserPermission;
import com.seatech.ibs.admin.pojo.user.BkUsersRole;
import com.seatech.ibs.admin.pojo.user.UserInfo;
import com.seatech.ibs.admin.pojo.user.UserManagement;
import com.seatech.ibs.admin.pojo.user.UserRole;
import com.seatech.ibs.admin.service.officerManagement.UserManagementService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;


public class UserManagementDelegate {

	public List<UserManagement> queryUserManagementWithoutAdminByRoleId(Pagination pn,Map<String,Object> pMap) throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.queryUserManagementWithoutAdminByRoleId(pn,pMap);
	}

	public List<UserRole> queryAllUserRole() throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.queryAllUserRole();
	}

	public List<Module> queryMoudleByRoleIdUserIdActionType(int pRoleId,int pUserId,String pActionType) throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.queryMoudleByRoleIdUserIdActionType(pRoleId, pUserId, pActionType);
	}

	public List<BankOrg> findAllBankOrg() throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.findAllBankOrg();
	}

	public void insertUserManagement(List<UserPermission> userPermissionList,UserInfo userInfo)throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		aUserManagementService.insertUserManagement(userPermissionList, userInfo);
	}

	public void deleteUserManagement(int pRoleId,int pUserId,String pStatus) throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		aUserManagementService.deleteUserManagement(pRoleId, pUserId, pStatus);
	}
	public void updateStatus(int pUserId,String pStatus) throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		aUserManagementService.updateStatus(pUserId, pStatus);
	}

	public void resetPassword(int pUserId,String pPassword) throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		aUserManagementService.resetPassword(pUserId, pPassword);
	}

	public void modifyUserManagement(List<UserPermission> userPermissionList,UserInfo userInfo)throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		aUserManagementService.modifyUserManagement(userPermissionList, userInfo);
	}

	public List<BankOrg> findBankOrgByShortName(String pShortName) throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.findBankOrgByShortName(pShortName);
	}

	public List<BankOrg> findBankOrgByOrgNoMatch(Map<String,Object> map) throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.findBankOrgByOrgNoMatch(map);
	}

	public BankOrg findBankOrgByOrgNo(String orgNo)throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.findBankOrgByOrgNo(orgNo);
	}

	public List<Module> queryUserPermission(Map<String,Object> pMap) throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.queryUserPermission(pMap);
	}

	public List<String> queryUserStatus() throws Exception{
		UserManagementService	aUserManagementService = (UserManagementService)SpringBeanDelegate.getBean("userManagementService");
		return aUserManagementService.queryUserStatus();
	}

	public List<UserRole> queryAllUserRole(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertBkUsersRole(BkUsersRole userRole) {
		// TODO Auto-generated method stub

	}

	public void deleteBkUsersRole(BkUsersRole userRole) {
		// TODO Auto-generated method stub

	}

	public List<UserManagement> queryUserAdminByOrgId(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BkUsersRole> findListBkUsersRole(BkUsersRole bkUserRole) {
		// TODO Auto-generated method stub
		return null;
	}
}
