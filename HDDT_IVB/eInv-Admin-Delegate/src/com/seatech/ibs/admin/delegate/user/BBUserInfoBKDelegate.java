package com.seatech.ibs.admin.delegate.user;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.dto.InformationUserInfo;
import com.seatech.ibs.admin.pojo.dto.SecurityEquipmentUserInfo;
import com.seatech.ibs.admin.service.user.BBUserInfoBKService;
import com.seatech.ibs.corp.pojo.user.UserInfoBK;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Pagination;


public class BBUserInfoBKDelegate {
	
    public void auditBBUserInfo(UserInfoBK userInfo, String currentStatus) throws Exception {
        BBUserInfoBKService service = this.getUserInfoBean();
        service.auditBBUserInfo(userInfo, currentStatus);
    }
    
    public void deleteBBUserInfo(int pUserId) throws Exception {
    	BBUserInfoBKService service = this.getUserInfoBean();
        service.deleteBBUserInfo(pUserId);
    }
    
    public UserInfoBK getUserId(int pUserId) throws Exception {
    	BBUserInfoBKService service = this.getUserInfoBean();
        return service.getUserId(pUserId);
    }
    
    public void insertBBUserInfo(UserInfoBK userInfo) throws Exception {
    	BBUserInfoBKService service = this.getUserInfoBean();
        service.insertBBUserInfo(userInfo);
    }
    
    public List<UserInfoBK> selectBBUserInfo(UserInfoBK userInfo) throws Exception {
    	BBUserInfoBKService service = this.getUserInfoBean();
        return service.selectBBUserInfo(userInfo);
    }

    
    public List<InformationUserInfo> selectInformationUserInfo(InformationUserInfo userInfo, Pagination pn) throws Exception {
    	BBUserInfoBKService service = this.getUserInfoBean();
        return service.selectInformationUserInfo(userInfo, pn);
    }

    
    public List<SecurityEquipmentUserInfo> selectSecurityEquipmentUserInfo(int corpId) throws Exception {
    	BBUserInfoBKService service = this.getUserInfoBean();
        return service.selectSecurityEquipmentUserInfo(corpId);
    }

    public void updateBBUserInfo(UserInfoBK userInfo) throws Exception {
        BBUserInfoBKService service = this.getUserInfoBean();
        service.updateBBUserInfo(userInfo);
    }

    
    public void updateBBUserInfoSelective(UserInfoBK userInfo) throws Exception {
        BBUserInfoBKService service = this.getUserInfoBean();
        service.updateUserInfoSelective(userInfo);
    }

    
    public List<UserInfoBK> queryBBUserInfoSelective(UserInfoBK userInfo) throws Exception {
        BBUserInfoBKService service = this.getUserInfoBean();
        return service.queryUserInfoSelective(userInfo);
    }
    
    public List<UserInfoBK> queryAllUserInfoByCorpId(int corpId) throws Exception {
        BBUserInfoBKService service = this.getUserInfoBean();
        return service.queryAllUserInfoByCorpId(corpId);
    }

    
    public List<UserInfoBK> queryBcUserInfoByCondition(Criterion pCriterion) throws Exception {
        BBUserInfoBKService service = this.getUserInfoBean();
        return service.queryBcUserInfoByCondition(pCriterion);
    }
    
    private BBUserInfoBKService getUserInfoBean() {
        return (BBUserInfoBKService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("userInfoBKService");
    }
    
    public UserInfoBK getUserInfoByUserName(String userName) throws Exception {
        BBUserInfoBKService service = this.getUserInfoBean();
        return service.getUserInfoByUserName(userName);
    }
    






}
