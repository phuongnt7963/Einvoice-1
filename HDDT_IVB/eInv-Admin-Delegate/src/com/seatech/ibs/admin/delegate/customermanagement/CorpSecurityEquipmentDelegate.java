package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.customermanagement.CorpAssignTokenService;

public class CorpSecurityEquipmentDelegate {

	public static String getSeqRsaUserId() {
		CorpAssignTokenService service = (CorpAssignTokenService) WebApplicationContextUtils.getWebApplicationContext(
				HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpAssignTokenService");
		return service.getSeqRsaUserId();
	}

	public static void assignToken(int userId, String tokenNumber, String rsaUserId, int setId, Map map) throws Exception {
		CorpAssignTokenService service = (CorpAssignTokenService) WebApplicationContextUtils.getWebApplicationContext(
				HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpAssignTokenService");
		service.assignToken(userId, tokenNumber, rsaUserId, setId, map);
	}
	
	public void updateUserDigitalType(int userId,String securityType) throws Exception {
		CorpAssignTokenService service = getBBDigitalTokenBean();
		service.updateUserDigitalType(userId, securityType);
	}
	
	
	private CorpAssignTokenService getBBDigitalTokenBean(){
		return  (CorpAssignTokenService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpAssignTokenService");
	}


}
