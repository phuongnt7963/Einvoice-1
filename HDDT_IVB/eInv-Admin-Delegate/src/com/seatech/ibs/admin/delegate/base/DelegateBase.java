
package com.seatech.ibs.admin.delegate.base;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DelegateBase
{

    public DelegateBase()
    {
    }

    public Object getBean(String beanId)
    {
        return WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean(beanId);
    }
}