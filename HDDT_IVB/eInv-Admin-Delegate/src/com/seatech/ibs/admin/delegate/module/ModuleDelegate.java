package com.seatech.ibs.admin.delegate.module;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.module.ModuleService;
import com.seatech.ibs.service.exception.IBSServiceException;

import java.util.List;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ModuleDelegate
{

    public ModuleDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryValidModule()
        throws IBSServiceException
    {
        ModuleService service = getServiceBean();
        return service.queryValidModule();
    }

    private ModuleService getServiceBean()
    {
        return (ModuleService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminModuleService");
    }
}