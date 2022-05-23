package com.seatech.ibs.admin.delegate.sys;

import com.seatech.ibs.admin.pojo.sys.SysParameter;
import com.seatech.ibs.admin.service.officerManagement.CorpAdminManagementService;
import com.seatech.ibs.admin.service.sys.SysParameterService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.service.exception.IBSServiceException;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class SysParameterDelegate
{

    public SysParameterDelegate()
    {
    }

	public List<SysParameter> getSysParameterByType(String channel, String type)
        throws IBSServiceException
    {
        SysParameterService sysParameterService = (SysParameterService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("sysParameterService");
        return sysParameterService.getSysParamByChannelType(channel, type);
    }

	public List<SysParameter> getSysParameter(String channel, String type)
    throws IBSServiceException
{
    SysParameterService sysParameterService = (SysParameterService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("sysParameterService");
    return sysParameterService.getSysParam(channel, type);
}

    public  SysParameterService getDelegate() throws Exception{
    	 return (SysParameterService)SpringBeanDelegate.getBean("sysParameterService");
    }
    public SysParameter getSysParameterByTypeCode(String channel, String type, String code)
        throws Exception
    {
        SysParameterService sysParameterService = getDelegate();
        return sysParameterService.getSysParamByChannelTypeCode(channel, type, code);
    }

    @SuppressWarnings("rawtypes")
	public boolean checkCurrencyTranPermission(String currencyCode)
        throws Exception
    {
        if(currencyCode == null)
            return false;
        List currencyTranPermissionList = getSysParameterByType("IB", "canTranCurrency");
        if(currencyTranPermissionList == null)
            return false;
        boolean returnValue = false;
        for(Iterator iterator = currencyTranPermissionList.iterator(); iterator.hasNext();)
        {
            SysParameter sysParameter = (SysParameter)iterator.next();
            if(sysParameter.getCode() != null && sysParameter.getCode().equalsIgnoreCase(currencyCode))
            {
                returnValue = true;
                break;
            }
        }

        return returnValue;
    }

	public void addSysParameter(SysParameter sys) {
		// TODO Auto-generated method stub

	}

	public void deleteSysParameter(int parameterId) {
		// TODO Auto-generated method stub

	}

	public void updateSysParameter(SysParameter sys) {
		// TODO Auto-generated method stub

	}

	public List<SysParameter> querySysParameter(Pagination pn, Map map) {
		// TODO Auto-generated method stub
		return null;
	}
}