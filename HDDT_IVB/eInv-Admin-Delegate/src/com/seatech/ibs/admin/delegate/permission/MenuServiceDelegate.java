package com.seatech.ibs.admin.delegate.permission;

import com.ibm.btt.base.KeyedCollection;
import com.seatech.ibs.admin.service.permission.MenuService;
import com.seatech.ibs.common.util.SpringBeanDelegate;

import java.util.List;

public class MenuServiceDelegate
{

    public MenuServiceDelegate()
    {
    }

    public static void queryMenu(KeyedCollection pCtx, Integer pUserId)
        throws Exception
    {
        try
        {
            MenuService aMenuService = (MenuService)SpringBeanDelegate.getBean("bkLoadMenuService");
            aMenuService.queryMenu(pCtx, pUserId);
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    @SuppressWarnings("rawtypes")
	public static List queryModule()
        throws Exception
    {
        MenuService aMenuService = (MenuService)SpringBeanDelegate.getBean("bkLoadMenuService");
        return aMenuService.queryAllModule();
    }

    @SuppressWarnings("rawtypes")
	public static List queryModuleExceptDLTD()
        throws Exception
    {
        MenuService aMenuService = (MenuService)SpringBeanDelegate.getBean("bkLoadMenuService");
        return aMenuService.queryAllModuleExceptELTD();
    }
}