package com.seatech.ibs.admin.delegate.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.user.UserOnline;
import com.seatech.ibs.admin.service.user.OnlineUserService;
import com.seatech.ibs.common.dto.Pagination;


public class OnlineUserDelegate {
	
	OnlineUserService onlineUserService = (OnlineUserService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("onlineUserService");
	
    public List<UserOnline> queryOnlineUser(HashMap<String,Object> aQueryParam,Pagination pn) throws Exception {
        return onlineUserService.queryOnlineUser(aQueryParam, pn);
    }
    
    public List<UserOnline> queryOnlineUserNotBK(HashMap<String,Object> aQueryParam,Pagination pn) throws Exception {
        return onlineUserService.queryOnlineUserNotBK(aQueryParam, pn);
    }
    
    public int countOnlineUser(HashMap<String,Object> aQueryParam) throws Exception {
    	return onlineUserService.countOnlineUser(aQueryParam);
    }
    
    public int countOnlineUserNotBK(HashMap<String,Object> aQueryParam) throws Exception {
    	return onlineUserService.countOnlineUserNotBK(aQueryParam);
    }
}
