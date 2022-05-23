package com.seatech.ibs.admin.delegate.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.dto.InformationUserInfo;
import com.seatech.ibs.admin.pojo.dto.SecurityEquipmentUserInfo;
import com.seatech.ibs.admin.service.permission.CorpUserPermissionService;
import com.seatech.ibs.admin.service.user.BBUserInfoService;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.corp.pojo.permission.UserPermission;
import com.seatech.ibs.corp.pojo.user.UserInfo;
import com.seatech.ibs.corp.pojo.user.UserInfoBK;

public class BBUserInfoDelegate {
	
    public void auditBBUserInfo(UserInfo userInfo) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        service.auditBBUserInfo(userInfo);
    }
    
    public void deleteBBUserInfo(int pUserId) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        service.deleteBBUserInfo(pUserId);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void delete(int userId,String status) throws Exception{
    	 BBUserInfoService service = this.getUserInfoBean();
      	 Map map = new HashMap<String, Object>();
		 map.put("userId", userId);
		 map.put("status", status);
   	      service.delete(map);
      }
    
    public UserInfo getUserId(int pUserId) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.getUserId(pUserId);
    }
    
    public void insertBBUserInfo(UserInfo userInfo) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        service.insertBBUserInfo(userInfo);
    }
    
    public List<UserInfo> selectBBUserInfo(UserInfo userInfo) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.selectBBUserInfo(userInfo);
    }

    
    public List<InformationUserInfo> selectInformationUserInfo(InformationUserInfo userInfo, Pagination pn) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.selectInformationUserInfo(userInfo, pn);
    }

    
    public List<SecurityEquipmentUserInfo> selectSecurityEquipmentUserInfo(int corpId) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.selectSecurityEquipmentUserInfo(corpId);
    }

    public void updateBBUserInfo(UserInfo userInfo) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        service.updateBBUserInfo(userInfo);
    }

    
    public void updateBBUserInfoSelective(UserInfo userInfo) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        service.updateUserInfoSelective(userInfo);
    }

    
    public List<UserInfo> queryBBUserInfoSelective(UserInfo userInfo) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.queryUserInfoSelective(userInfo);
    }
    
    public List<UserInfo> queryAllUserInfoByCorpId(int corpId) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.queryAllUserInfoByCorpId(corpId);
    }

    
    public List<UserInfo> queryBBUserInfoByCondition(Criterion pCriterion) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.queryBcUserInfoByCondition(pCriterion);
    }
    
    private BBUserInfoService getUserInfoBean() {
        return (BBUserInfoService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("userInfoService");
    }
    
    public UserInfo getUserInfoByUserName(String userName) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.getUserInfoByUserName(userName);
    }
    
    @SuppressWarnings("unchecked")
	public List<UserPermission> queryRoleAndUserPermission(UserInfo userInfo) throws Exception {
        CorpUserPermissionService corpUserPermissionService = (CorpUserPermissionService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpUserPermissionService");
        List<UserPermission> aUserPermissionList = (ArrayList<UserPermission>) corpUserPermissionService.queryRoleAndUserPermission(userInfo);
        return aUserPermissionList;
    }

    public int findCorpByUpdateId(int pUserId) throws Exception {
        BBUserInfoService service = this.getUserInfoBean();
        return service.findCorpByUpdateId(pUserId);
    }
    
    public void updateBBUserInfoDynamicByCorpId(UserInfo pUserInfo) throws Exception {
    	BBUserInfoService service = this.getUserInfoBean();
    	service.updateBBUserInfoDynamicByCorpId(pUserInfo);
    }
    
    public UserInfo getUserForEdit(int userId) throws Exception {
    	BBUserInfoService service = this.getUserInfoBean();
        return service.getUserForEdit(userId);
    }
    
    public void updateMakerChange(UserInfoBK userInfo)throws Exception {
    	this.getUserInfoBean().updateMakerChange(userInfo);
    }
    
    public void updateBBUserInfoChange(UserInfo userInfo) throws Exception {
    	this.getUserInfoBean().updateBBUserInfoChange(userInfo);
    }
    
    public void enableBBUserInfo(UserInfo userInfo) throws Exception {
    	this.getUserInfoBean().enableBBUserInfo(userInfo);
    }
    
    public List<InformationUserInfo> selectInformationUserInfoPending(InformationUserInfo userInfo, Pagination pn) throws Exception {
    	return this.getUserInfoBean().selectInformationUserInfoPending(userInfo, pn);
    }
    
    public void updateLog(int userId, String changeType, int approveId, String approveStatus, int appLogId) throws Exception {
    	this.getUserInfoBean().updateLog(userId, changeType, approveId, approveStatus, appLogId);
    }
    
//    public UserInfoBK copyToBK(UserInfo userInfo){
//    	UserInfoBK userBK = new UserInfoBK();
//    	userBK.setUserId(userInfo.getUserId());
//    	userBK.setUserName(userInfo.getUserName());
//    	userBK.setNick(userInfo.getNick());
//    	userBK.setGender(userInfo.getGender());
//    	userBK.setCorpId(userInfo.getCorpId());
//    	userBK.setOrgId(userInfo.getOrgId());
//    	userBK.setRoleId(userInfo.getRoleId());
//    	userBK.setIsDelegate(userInfo.getIsDelegate());
//    	userBK.setLoginPwd(userInfo.getLoginPwd());
//    	userBK.setTradePwd(userInfo.getTradePwd());
//    	userBK.setDcType(userInfo.getDcType());
//    	userBK.setCertType(userInfo.getCertType());
//    	userBK.setCertCode(userInfo.getCertCode());
//    	userBK.setTelephone(userInfo.getTelephone());
//    	userBK.setMobile(userInfo.getMobile());
//    	userBK.setAddress(userInfo.getAddress());
//    	userBK.setPostalcode(userInfo.getPostalcode());
//    	userBK.setEmail(userInfo.getEmail());
//    	userBK.setServiceType(userInfo.getServiceType());
//    	userBK.setRemark(userInfo.getRemark());
//    	userBK.setCreateBy(userInfo.getCreateBy());
//    	userBK.setCreateByMng(userInfo.getCreateByMng());
//    	userBK.setCreateTime(userInfo.getCreateTime());
//    	userBK.setUpdateBy(userInfo.getUpdateBy());
//    	userBK.setUpdateByMng(userInfo.getUpdateByMng());
//    	userBK.setUpdateTime(userInfo.getUpdateTime());
//    	userBK.setStatus(userInfo.getStatus());
//    	userBK.setFreezedStartTime(userInfo.getFreezedStartTime());
//    	userBK.setFreezedEndTime(userInfo.getFreezedEndTime());
//    	userBK.setFreezedEndTime(userInfo.getFreezedEndTime());
//     // chi nhanh sua: postalcode
//        userInfo.setPostalcode(orgId);
//    		
//    	
//    	return userBK;
//    }
}
