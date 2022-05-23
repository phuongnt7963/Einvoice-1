package com.seatech.ibs.admin.delegate.user;

import org.springframework.web.context.support.WebApplicationContextUtils;


import com.seatech.ibs.admin.service.user.BBUserSettingSecurityBKService;
import com.seatech.ibs.corp.pojo.setting.UserSettingSecurityBK;
import com.ibm.btt.sm.HttpSessionInfoHolder;


public class BBUserSettingSecurityBKDelegate {

    BBUserSettingSecurityBKService userSettingSecurityService = (BBUserSettingSecurityBKService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminCorpUserSettingSecurityBKService");
    
    public void insertOrUpdateBBUserSettingSecurity(UserSettingSecurityBK bbUserSettingSecurity) throws Exception {        
        userSettingSecurityService.insertOrUpdateBBUserSettingSecurity(bbUserSettingSecurity);
    }

    public UserSettingSecurityBK queryUserSettingSecurityDynamic(UserSettingSecurityBK pUserSettingSecurity) throws Exception {
        return userSettingSecurityService.queryUserSettingSecurityDynamic(pUserSettingSecurity);
    }
}
