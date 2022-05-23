package com.seatech.ibs.admin.delegate.modulemanagement;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.module.Module;
import com.seatech.ibs.admin.service.systemmanagement.ModuleManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.constant.AdminAppConstant;
import com.seatech.ibs.service.exception.IBSServiceException;


public class ModuleManagementDelegate {
	
	private ModuleManagementService moduleManagementService = (ModuleManagementService)WebApplicationContextUtils.
	getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext())
		.getBean(AdminAppConstant.DELEGATE_MODULE_MANAGEMENT_SERVICE);

	
	public List<Module> getModuleList(String systemCode)throws IBSServiceException {
		
		return moduleManagementService.queryModuleList(systemCode);
	}
	
	public List<com.seatech.ibs.corp.pojo.module.Module> getCorpModuleList(String systemCode)throws IBSServiceException{
		try {
			return moduleManagementService.queryCorpModuleList(systemCode);
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when query corporate module",e);
		}
	}
	
	public List<com.seatech.ibs.retail.pojo.module.Module> getRetailModuleList(String systemCode)throws IBSServiceException{
		try {
			return moduleManagementService.queryRetailModuleList(systemCode);
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when query retail module",e);
		}
	}
	
	public Module queryAdminModuleByModuleId(Integer pModuleId)throws IBSServiceException{
		try {
			return moduleManagementService.queryAdminModuleByModuleId(pModuleId);
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when query admin module detail",e);
		}
	}
	
	public com.seatech.ibs.corp.pojo.module.Module queryCorpModuleByModuleId(Integer pModuleId)throws IBSServiceException{
		try {
			return moduleManagementService.queryCorpModuleByModuleId(pModuleId);
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when query corporate module detail",e);
		}
	}
	
	public com.seatech.ibs.retail.pojo.module.Module queryRetailModuleByModuleId(Integer pModuleId)throws IBSServiceException{
		try {
			return moduleManagementService.queryRetailModuleByModuleId(pModuleId);
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when query retail module detail",e);
		}
	}
	
	
	public Boolean modifyAdminModuleByModuleId(Module module)throws IBSServiceException{
		try {
			return moduleManagementService.modifyAdminModuleByModuleId(module);
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when modifying module detail",e);
		}
	}
	
	
	public Boolean switchAdminModuleStatusByModuleId(String[] moduleIdArr, String actionType, Integer updateBy) throws IBSServiceException{
		try {
			ModuleManagementService moduleManagementService = (ModuleManagementService)WebApplicationContextUtils.
			getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext())
			.getBean(AdminAppConstant.DELEGATE_MODULE_MANAGEMENT_SERVICE);
			
			return moduleManagementService.switchAdminModuleStatusByModuleId(moduleIdArr, actionType, updateBy);
			
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when switching module status",e);
		}
	}
	
	
	public Boolean modifyRetailModuleByModuleId(com.seatech.ibs.retail.pojo.module.Module module)throws IBSServiceException{
		try {
			return moduleManagementService.modifyRetailModuleByModuleId(module);
			
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when modifying module detail",e);
		}
	}
	
	
	public Boolean switchRetailModuleStatusByModuleId(String[] moduleIdArr, String actionType, Integer updateBy) throws IBSServiceException{
		try {
			return moduleManagementService.switchRetailModuleStatusByModuleId(moduleIdArr, actionType, updateBy);
			
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when switching module status",e);
		}
	}

	
	public Boolean modifyCorpModuleByModuleId(com.seatech.ibs.corp.pojo.module.Module module)throws IBSServiceException{
		try {
			return moduleManagementService.modifyCorpModuleByModuleId(module);
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when modifying module detail",e);
		}
	}
	
	
	public Boolean switchCorpModuleStatusByModuleId(String[] moduleIdArr, String actionType, Integer updateBy) throws IBSServiceException{
		try {
			return moduleManagementService.switchCorpModuleStatusByModuleId(moduleIdArr, actionType, updateBy);
		} catch (Exception e) {
			throw new IBSServiceException("Exception occured when switching module status",e);
		}
	}
}
