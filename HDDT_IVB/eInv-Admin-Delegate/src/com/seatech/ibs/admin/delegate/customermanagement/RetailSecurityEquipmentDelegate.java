package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.customermanagement.RetailAssignTokenService;

public class RetailSecurityEquipmentDelegate {

	public static String getSeqRsaUserId() {
		RetailAssignTokenService service = (RetailAssignTokenService) WebApplicationContextUtils.getWebApplicationContext(
				HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("retailAssignTokenService");
		return service.getSeqRsaUserId();
	}

	public static void assignToken(int userId, String tokenNumber, String rsaUserId, int setId, Map map) throws Exception {
		RetailAssignTokenService service = (RetailAssignTokenService) WebApplicationContextUtils.getWebApplicationContext(
				HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("retailAssignTokenService");
		service.assignToken(userId, tokenNumber, rsaUserId, setId, map);
	}
	
	public void updateUserDigitalType(int userId,String securityType) throws Exception {
		RetailAssignTokenService service = getBCDigitalTokenBean();
		service.updateUserDigitalType(userId, securityType);
	}
	
	
	private RetailAssignTokenService getBCDigitalTokenBean(){
		return  (RetailAssignTokenService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("retailAssignTokenService");
	}

}
