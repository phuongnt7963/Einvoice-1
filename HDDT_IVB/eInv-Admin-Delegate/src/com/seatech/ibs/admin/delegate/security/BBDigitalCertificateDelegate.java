package com.seatech.ibs.admin.delegate.security;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.service.security.BBDigitalCertificateService;
import com.seatech.ibs.corp.pojo.security.DigitalCertificate;
import com.ibm.btt.sm.HttpSessionInfoHolder;


public class BBDigitalCertificateDelegate {

	public void deleteBBDigitalCertificate(String pDcNo) throws Exception{
		BBDigitalCertificateService digitalCertificateService =(BBDigitalCertificateService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("digitalCertificateService");
		digitalCertificateService.deleteBBDigitalCertificate(pDcNo);
		
	}

	public DigitalCertificate getDcNo(String pDcNo) throws Exception{
		BBDigitalCertificateService digitalCertificateService =(BBDigitalCertificateService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("digitalCertificateService");
		return digitalCertificateService.getDcNo(pDcNo);
	}

	public void insertBBDigitalCertificate(
			DigitalCertificate digitalCertificate) throws Exception{
		BBDigitalCertificateService digitalCertificateService =(BBDigitalCertificateService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("digitalCertificateService");
		digitalCertificateService.insertBBDigitalCertificate(digitalCertificate);
	}

	public List<DigitalCertificate> selectBBDigitalCertificate(
			DigitalCertificate digitalCertificate) throws Exception{
		BBDigitalCertificateService digitalCertificateService =(BBDigitalCertificateService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("digitalCertificateService");
		return digitalCertificateService.selectBBDigitalCertificate(digitalCertificate);
	}

	public void updateBBDigitalCertificate(
			DigitalCertificate digitalCertificate) throws Exception{
		BBDigitalCertificateService digitalCertificateService =(BBDigitalCertificateService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("digitalCertificateService");
		digitalCertificateService.updateBBDigitalCertificate(digitalCertificate);
	}

}
