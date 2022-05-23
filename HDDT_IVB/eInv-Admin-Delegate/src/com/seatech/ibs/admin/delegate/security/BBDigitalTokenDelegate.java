package com.seatech.ibs.admin.delegate.security;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.security.BBDigitalTokenService;
import com.seatech.ibs.corp.pojo.security.DigitalToken;

public class BBDigitalTokenDelegate {

		
	public void deleteBBDigitalToken(String pTokenNo) throws Exception{
		BBDigitalTokenService service = this.getDigitalTokenBean();
		service.deleteBBDigitalToken(pTokenNo);
	}
	
	public void deleteBBDigitalTokenByUserId(Integer userId) throws Exception{
		BBDigitalTokenService service = this.getDigitalTokenBean();
		service.deleteBBDigitalTokenByUserId(userId);
	}

	public DigitalToken getTokenNo(String pTokenNo) throws Exception{
		BBDigitalTokenService service = this.getDigitalTokenBean();
		return service.getTokenNo(pTokenNo);
	}
	
	public DigitalToken getUserId(int userId) throws Exception {
		BBDigitalTokenService service = this.getDigitalTokenBean();
		return service.getUserId(userId);
	}
	
	public DigitalToken getUserIdTokenInfoCorp(int userId) throws Exception {
		BBDigitalTokenService service = this.getDigitalTokenBean();
		return service.getUserIdTokenInfoCorp(userId);
	}
	
	public int countUserRsaByUserId(int userId) throws Exception {
		BBDigitalTokenService service = this.getDigitalTokenBean();
		return service.countUserRsaByUserId(userId);
	}
	
	public void insertBBDigitalToken(DigitalToken digitalToken) throws Exception{
		BBDigitalTokenService service = this.getDigitalTokenBean();
		service.insertBBDigitalToken(digitalToken);
	}
	
	public List<DigitalToken> selectBBDigitalToken(DigitalToken digitalToken)
			throws Exception {
		BBDigitalTokenService service = this.getDigitalTokenBean();
		return service.selectBBDigitalToken(digitalToken);
	}

	public void updateBBDigitalToken(DigitalToken digitalToken) throws Exception {
		BBDigitalTokenService service = this.getDigitalTokenBean();
		service.updateBBDigitalToken(digitalToken);
	}
	
	public void insertFromBK(DigitalToken digitalToken) throws Exception {
		BBDigitalTokenService service = this.getDigitalTokenBean();
		service.insertFromBK(digitalToken);
	}
	
	public void updateBBDigitalTokenBK(DigitalToken digitalToken) throws Exception {
		BBDigitalTokenService service = this.getDigitalTokenBean();
		service.updateBBDigitalTokenBK(digitalToken);
	}
	
	public List<DigitalToken> selectBBUserInfoDigitalToken(Map map)
			throws Exception {
		BBDigitalTokenService service = this.getDigitalTokenBean();
		return service.selectBBUserInfoDigitalToken(map);
	}
	
	
	private BBDigitalTokenService getDigitalTokenBean(){
		return  (BBDigitalTokenService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("digitalTokenService");
	}

}
