package com.seatech.ibs.admin.delegate.user;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucCQT;
import com.seatech.ibs.admin.pojo.user.UserBlock;
import com.seatech.ibs.admin.pojo.user.UserInfo;
import com.seatech.ibs.admin.pojo.user.UserSaleInfo;
import com.seatech.ibs.admin.service.user.AdminService;
import com.seatech.ibs.common.constant.AppConstant;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.retail.pojo.user.UserAlterPwdHistory;


public class AdminDelegate {

	public boolean checkUserPwd(String pUserName,String pPassword) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");

		return adminService.checkUserPwd(pUserName,pPassword);
	}

	public int findIDByNamePwd(String pUserName,String pPassword) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.findIDByNamePwd(pUserName,pPassword);
	}

	public List<UserInfo> checkAvailbleUserName(Map map) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.checkUserName(map);
	}

	public int findLoginCount(int pUserId) throws Exception{
		AdminService adminService = (AdminService)SpringBeanDelegate.getBean("adminService");
		return adminService.findLoginCount(pUserId);
	}

	public String selectStatusById(int pUserId) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.selectStatusById(pUserId);
	}
	public String getStatusUser(int pUserId) throws Exception{

		//TODO
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		String status = adminService.selectStatusById(pUserId);
		if(AppConstant.OPER_STATUS_ACTV.equalsIgnoreCase(status)){
			UserBlock condition = new UserBlock(pUserId, AppConstant.SYS_CODE_BK);
			UserBlock block = this.getBlockUser(condition);
			if(block!=null){
				Calendar now = Calendar.getInstance();
				Timestamp nowTime = new Timestamp(now.getTime().getTime());
				if(nowTime.compareTo(block.getTimeLock())>0){
					this.clearBlockUser(condition);
				}else{
					return AppConstant.LOCK_USER;
				}
			}
		}
		return status;
	}

	public void updateBKUserStatus(int pUserId,String pStatus) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		adminService.updateBKUserStatus(pUserId,pStatus);
	}

	public void updateBKOnline(int pUserId,String pOnline)throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		adminService.updateBKOnline(pUserId,pOnline);
	}

	public void updateBKUserLoginCount(int pUserId)throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		adminService.updateBKUserLoginCount(pUserId);
	}

	public boolean checkPwdById(int pUserId,String pPassword)throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.checkPwdById(pUserId, pPassword);
	}

	public void updateBKUserPWD(int pUserId,String pPassword)throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		adminService.updateBKUserPWD(pUserId, pPassword);
	}

	public void updateBKUserInfo(UserInfo bkUserInfo) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		adminService.updateBKUserInfo(bkUserInfo);
	}

	public UserInfo getUserInfoById(int id) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.getUserInfoById(id);
	}

	public boolean checkUserName(String pUserName) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.checkUserName(pUserName);
	}


	public String getUserNameById(int id)throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.getUserNameById(id);
	}

	public List<UserInfo> queryUserInfoByRoleName(String roleName)throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.queryUserInfoByRoleName(roleName);
	}

	public UserInfo getUserIdbyName(String name) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.getUserIdByName(name);
	}


	public List<UserSaleInfo> getAllUserSale(String str) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.getAllUserSale(str);
	}
	@SuppressWarnings("rawtypes")
	public List<UserSaleInfo> getByParamUserSale(Map map) throws Exception {
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.getByParamUserSale(map);
	}
	@SuppressWarnings("rawtypes")
	public List<UserSaleInfo> checkExistSale(Map map) throws Exception {
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.checkExistSale(map);
	}



	public boolean insertUserSale(UserSaleInfo user) throws Exception {
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.insertUserSale(user);
	}
	public boolean deleteUserSale(int id) throws Exception {
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.deleteUserSale(id);
	}
	@SuppressWarnings("rawtypes")
	public boolean updateSale(Map map) throws Exception {
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.updateSale(map);
	}

	@SuppressWarnings("rawtypes")
	public int updateBkUserInfo(Map map) throws Exception{
		AdminService adminService = (AdminService)SpringBeanDelegate.getBean("adminService");
		return adminService.updateBkUserInfoAdmin(map);
	}

	public UserSaleInfo querySaleById(int saleId) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.querySaleById(saleId);
	}
	public void setBlockUser(UserBlock userBlock) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		adminService.setBlockUser(userBlock);
	}
	public void clearBlockUser(UserBlock userBlock) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		adminService.clearBlockUser(userBlock);
	}
	public UserBlock getBlockUser(UserBlock userBlock) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.getBlockUser(userBlock);
	}

	public List<UserAlterPwdHistory> queryAlterPasswordHistory(Map pMap) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		return adminService.queryAlterPasswordHistory(pMap);
	}

	public void insertAlterPasswordHistory(Map pMap) throws Exception{
		AdminService adminService = (AdminService) SpringBeanDelegate.getBean("adminService");
		adminService.insertAlterPasswordHistory(pMap);
	}

	public List<DanhMucCQT> findRoleDataByUserId(int pUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(UserInfo userInfo) {
		// TODO Auto-generated method stub

	}

	public void updateOrgIdBKUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub

	}

	public void updateBKUserInfoDynamicById(UserInfo userInfo) {
		// TODO Auto-generated method stub

	}
}
