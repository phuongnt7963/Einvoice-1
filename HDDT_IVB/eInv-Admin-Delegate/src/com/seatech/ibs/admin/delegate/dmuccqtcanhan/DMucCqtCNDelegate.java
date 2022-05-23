package com.seatech.ibs.admin.delegate.dmuccqtcanhan;

import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.etaxcn.DMucCqtCN;
import com.seatech.ibs.admin.service.dmuccqtcanhan.DMucCqtCNService;

public class DMucCqtCNDelegate {
	DMucCqtCNService dMucCqtService = (DMucCqtCNService) WebApplicationContextUtils.getWebApplicationContext(
            HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("dMucCqtCNService");
	
	public DMucCqtCN getTenCqtByMa(Map<String, Object> map) throws Exception {
		return dMucCqtService.getTenCqtByMa(map);
	}
}
