package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.List;

import com.seatech.ibs.admin.service.customermanagement.QueryCorpModuleService;
import com.seatech.ibs.admin.service.customermanagement.QueryRetailModuleService;
import com.seatech.ibs.common.constant.CorpAppConstant;
import com.seatech.ibs.common.constant.RetailAppConstant;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.retail.pojo.module.Module;

public class FeePortfolioDelegate {

	@SuppressWarnings("unchecked")
	public List<Module> queryRetailBranchModuleList() throws Exception{
		try{
			QueryRetailModuleService queryRetailModuleService = (QueryRetailModuleService) SpringBeanDelegate.getBean(RetailAppConstant.SERVICE_USER_SETTING_FAST_CHANNEL);
			return queryRetailModuleService.queryBranchModuleList();
		}catch(Exception e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Module> queryCorpBranchModuleList() throws Exception{
		try{
			QueryCorpModuleService queryCorpModuleService = (QueryCorpModuleService) SpringBeanDelegate.getBean(CorpAppConstant.SERVICE_SETTING_FAST_CHANNEL_SERVICE);
			return queryCorpModuleService.queryBranchModuleList();
		}catch(Exception e){
			throw e;
		}
	}
	
 
	
}
