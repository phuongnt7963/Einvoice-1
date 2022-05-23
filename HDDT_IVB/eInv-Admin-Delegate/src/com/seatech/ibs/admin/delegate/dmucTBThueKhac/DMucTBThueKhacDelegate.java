package com.seatech.ibs.admin.delegate.dmucTBThueKhac;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.dmucTBThueKhac.DMucTBThueKhacService;
import com.seatech.ibs.common.dto.Pagination;

public class DMucTBThueKhacDelegate {
	DMucTBThueKhacService adminTBThueKhacService = (DMucTBThueKhacService) WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext())
			.getBean("adminTBThueKhacService");

	public Collection getDSachTBThueKhac(HashMap mapParam, Pagination pn, int maxSelectResult) throws Exception {
		return adminTBThueKhacService.getDSachTBThueKhac(mapParam, pn, maxSelectResult);
	}

}
