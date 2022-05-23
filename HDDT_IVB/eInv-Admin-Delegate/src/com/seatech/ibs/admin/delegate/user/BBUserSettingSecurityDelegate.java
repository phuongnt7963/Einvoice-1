
package com.seatech.ibs.admin.delegate.user;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.service.user.BBUserSettingSecurityService;
import com.seatech.ibs.corp.pojo.setting.UserSettingSecurity;
import com.ibm.btt.sm.HttpSessionInfoHolder;


public class BBUserSettingSecurityDelegate {

    BBUserSettingSecurityService userSettingSecurityService = (BBUserSettingSecurityService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminCorpUserSettingSecurityService");
    
    public void insertOrUpdateBBUserSettingSecurity(UserSettingSecurity bbUserSettingSecurity) throws Exception {        
        userSettingSecurityService.insertOrUpdateBBUserSettingSecurity(bbUserSettingSecurity);
    }

    public UserSettingSecurity queryUserSettingSecurityDynamic(UserSettingSecurity pUserSettingSecurity) throws Exception {
        return userSettingSecurityService.queryUserSettingSecurityDynamic(pUserSettingSecurity);
    }
}
