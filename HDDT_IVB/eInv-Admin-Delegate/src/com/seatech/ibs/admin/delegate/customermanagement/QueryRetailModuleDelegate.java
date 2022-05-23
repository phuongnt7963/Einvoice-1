package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;


import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.customermanagement.QueryRetailModuleService;
import com.seatech.ibs.retail.pojo.module.Module;

public class QueryRetailModuleDelegate {

	@SuppressWarnings("unchecked")
	public List<Module> getBranchModuleList() throws Exception{
		QueryRetailModuleService queryRetailModuleService = (QueryRetailModuleService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("queryRetailModuleService");	
		return queryRetailModuleService.queryBranchModuleList();
	}
}
