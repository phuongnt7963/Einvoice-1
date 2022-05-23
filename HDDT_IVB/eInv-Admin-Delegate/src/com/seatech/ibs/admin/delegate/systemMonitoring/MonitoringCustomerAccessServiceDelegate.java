package com.seatech.ibs.admin.delegate.systemMonitoring;

import java.util.Date;
import java.util.List;

import com.seatech.ibs.admin.service.systemMonitoring.MonitoringCustomerAccessService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;


public class MonitoringCustomerAccessServiceDelegate {
	
	public static MonitoringCustomerAccessService getBean()throws Exception{
		try {
			return (MonitoringCustomerAccessService) SpringBeanDelegate.getBean("adminMonitoringCustomerAccessService");
		} catch (Exception e) {
			throw e;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static List queryCusomerAccess(Pagination pn,String pUserName,String CIF,String pAccountNo,Date pFromeDate,Date pToDate,String pOperationType,String content)throws Exception{
		try {
			return getBean().queryCustomerAccess(pn,pUserName, CIF, pAccountNo, pFromeDate, pToDate, pOperationType,content);
		} catch (Exception e) {
			throw e;
		}
	}

}
