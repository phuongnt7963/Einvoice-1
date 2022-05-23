package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.service.customermanagement.QueryCorpModuleService;
import com.seatech.ibs.corp.pojo.module.Module;
import com.ibm.btt.sm.HttpSessionInfoHolder;

 

public class QueryCorpModuleDelegate {

	@SuppressWarnings("unchecked")
	public List<Module> getBranchModuleList() throws Exception{
		QueryCorpModuleService queryCorpModuleService = (QueryCorpModuleService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("queryCorpModuleService");	
		return queryCorpModuleService.queryBranchModuleList();
	}
}
