package com.seatech.ibs.admin.delegate.hso;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.hso.AdminHSoService;
import com.seatech.ibs.common.dto.Pagination;

public class AdminHSoDelegate {
	AdminHSoService adminHSoService = (AdminHSoService) WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext())
			.getBean("adminHSoService");
	
	public Collection getDMucHSo(String loaiHSo) throws Exception {
		Collection  dmucCol = (Collection) adminHSoService.getDMucHSo(loaiHSo);
		return dmucCol;
	}
	
	public Collection getDsHSo(HashMap mapParam, Pagination pn) throws Exception {
		Collection  dmucCol = (Collection) adminHSoService.getDsHSo(mapParam, pn);
		return dmucCol;
	}		
	
	public Collection getCTietHSo(String maGDich) throws Exception {
		Collection  dmucCol = (Collection) adminHSoService.getCTietHSo(maGDich);
		return dmucCol;
	}	
	
	public void tuchoiTThaiXuly(String maGDich) throws Exception {
		adminHSoService.tuchoiTThaiXuly(maGDich);
	}

	public void duyetTThaiXuly(String maGDich) throws Exception {
		adminHSoService.duyetTThaiXuly(maGDich);
	}	
}
