package com.seatech.ibs.admin.delegate.permission;

import com.seatech.ibs.admin.pojo.module.Module;
import com.seatech.ibs.admin.service.permission.UserPermissionService;
import com.seatech.ibs.common.util.SpringBeanDelegate;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class UserPermissionServicDelegate
{

    public UserPermissionServicDelegate()
    {
    }

    public static boolean checkUserPermissionByUserId(Integer pUserId, Integer pModuleId)
        throws Exception
    {
        UserPermissionService aUserPermissionService = (UserPermissionService)SpringBeanDelegate.getBean("userPermissionService");
        return aUserPermissionService.checkUserPermissionByUserId(pUserId, pModuleId);
    }

    public static Module queryModuleByProcName(String pProcName)
        throws Exception
    {
        if(pProcName == null || "".equals(pProcName))
            return null;
        UserPermissionService aUserPermissionService = (UserPermissionService)SpringBeanDelegate.getBean("userPermissionService");
        return aUserPermissionService.queryModuleByProcName(pProcName);
    }

    public static Module queryModuleByProcName(HttpServletRequest req, String pProcName)
        throws Exception
    {
        UserPermissionService aUserPermissionService = (UserPermissionService)WebApplicationContextUtils.getRequiredWebApplicationContext(req.getSession().getServletContext()).getBean("userPermissionService");
        return aUserPermissionService.queryModuleByProcName(pProcName);
    }

    public static boolean checkModulePermissionForUser(HttpServletRequest req, Integer pUserID, Integer pModuleId)
        throws Exception
    {
        UserPermissionService aUserPermissionService = (UserPermissionService)WebApplicationContextUtils.getRequiredWebApplicationContext(req.getSession().getServletContext()).getBean("userPermissionService");
        return aUserPermissionService.checkUserPermissionByUserId(pUserID, pModuleId);
    }
}