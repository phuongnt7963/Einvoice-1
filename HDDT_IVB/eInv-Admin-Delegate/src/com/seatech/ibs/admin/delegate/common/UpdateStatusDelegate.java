package com.seatech.ibs.admin.delegate.common;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.common.UpdateStatusService;
import com.seatech.ibs.service.exception.IBSServiceException;

public class UpdateStatusDelegate {
	
	public void updateData(String pUPType, String tranSn, String pStatus,String updateUserId)
			throws IBSServiceException {
		UpdateStatusService service = this.getUpdateStatusService();
		service.updateData(pUPType, tranSn, pStatus,updateUserId);
	} 
	
	
	private UpdateStatusService getUpdateStatusService(){
		return  (UpdateStatusService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("updateStatusService");
	}
}
