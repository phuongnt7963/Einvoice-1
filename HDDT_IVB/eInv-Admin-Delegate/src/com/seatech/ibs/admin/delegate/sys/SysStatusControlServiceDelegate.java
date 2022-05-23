package com.seatech.ibs.admin.delegate.sys;

import com.seatech.ibs.admin.service.sys.SysStatusControlService;
import com.seatech.ibs.common.util.SpringBeanDelegate;

public class SysStatusControlServiceDelegate
{

    public SysStatusControlServiceDelegate()
    {
    }

    public static SysStatusControlService getBean()
        throws Exception
    {
        return (SysStatusControlService)SpringBeanDelegate.getBean("adminSysStatusControlService");
    }

    public static Boolean isCurrentBackendSysOnline(String onlineSignalCode, String offlineSignalCode)
        throws Exception
    {
        return getBean().isCurrentBackendSysOnline(onlineSignalCode, offlineSignalCode);
    }
}