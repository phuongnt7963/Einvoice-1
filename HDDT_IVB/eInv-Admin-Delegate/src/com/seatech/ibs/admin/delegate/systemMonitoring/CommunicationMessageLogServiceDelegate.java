package com.seatech.ibs.admin.delegate.systemMonitoring;

import java.util.List;

import com.seatech.ibs.admin.service.systemMonitoring.CommunicationMessageLogService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;

public class CommunicationMessageLogServiceDelegate {
	
	public static CommunicationMessageLogService getBean()throws Exception{
		try {
			return (CommunicationMessageLogService) SpringBeanDelegate.getBean("adminCommunicationMessageLogService");
		} catch (Exception e) {
			throw e;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static List queryMessageLog(String pSystemCode,Integer pUserID,String pMobile,String pUserName,String pEmail,String pChannelCode,String pStatus,Pagination pn )throws Exception{
		try {
			return getBean().queryMessageLog(pSystemCode, pUserID, pMobile, pUserName, pEmail, pChannelCode, pStatus, pn);
		} catch (Exception e) {
			throw e;
		}
	}

}
