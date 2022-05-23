package com.seatech.ibs.admin.delegate.officerManagement;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.module.Module;
import com.seatech.ibs.admin.pojo.permission.UserPermission;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucCQT;
import com.seatech.ibs.admin.pojo.user.UserRole;
import com.seatech.ibs.admin.service.officerManagement.RolePermissionManagementService;
import com.seatech.ibs.common.dto.Pagination;


public class RolePermissionManageDelegate {

	public List<Module> queryAllModuleList() throws Exception{
		RolePermissionManagementService aRolePermissionManageService = (RolePermissionManagementService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("rolePermissionManagementService");
		return aRolePermissionManageService.queryAllModuleList();
	}

	public void insertOrUpdateUserPermissionBatch(final List<UserPermission> userPermissionList,final int pRoleId,final int pUserId) throws Exception{
		RolePermissionManagementService aRolePermissionManageService = (RolePermissionManagementService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("rolePermissionManagementService");
		aRolePermissionManageService.insertOrUpdateUserPermissionBatch(userPermissionList, pRoleId, pUserId);
	}

	public List<UserPermission> queryUserPermissionByRoleId(int pRoleId) throws Exception{
		RolePermissionManagementService aRolePermissionManageService = (RolePermissionManagementService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("rolePermissionManagementService");
		return aRolePermissionManageService.queryUserPermissionByRoleId(pRoleId);
	}

	public List<UserRole> queryAllUserRole() throws Exception{
		RolePermissionManagementService aRolePermissionManageService = (RolePermissionManagementService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("rolePermissionManagementService");
		return aRolePermissionManageService.queryAllUserRole();
	}

	private RolePermissionManagementService getService(){
		return (RolePermissionManagementService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("rolePermissionManagementService");
	}

	public List<UserRole> selectUserRole(Map<String, Object> aQueryParam, Pagination pn) throws Exception{
		return getService().selectUserRole(aQueryParam, pn);
	}
	public List<UserRole> checkExist(Map<String, Object> aQueryParam, Pagination pn) throws Exception{
		aQueryParam.put("check", true);
		return getService().selectUserRole(aQueryParam, pn);
	}
	public int selectCount(Map<String, Object> aQueryParam) throws Exception{
		return getService().selectCount(aQueryParam);
	}

	public void insertUserRole(Map<String, Object> aQueryParam,int userID) throws Exception{
		getService().insertUserRole(aQueryParam,userID);
	}

	public void updateUserRole(Map<String, Object> aQueryParam) throws Exception{
		getService().updateUserRole(aQueryParam);
	}

	public void deleteUserRole(Map<String, Object> aQueryParam,int roleID) throws Exception{
		getService().deleteUserRole(aQueryParam,roleID);
	}

	public List<DanhMucCQT> queryDMucCQT(DanhMucCQT dmCQT) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserRole findRoleInfoByRoleId(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserRole> queryRoleByUserId(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserRole> findRoleByUserId(Map pMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
