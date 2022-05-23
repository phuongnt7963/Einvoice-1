package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.customermanagement.ServiceGroupServices;
import com.seatech.ibs.common.constant.AppConstant;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Criterion.Criteria;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.corp.pojo.corp.CorpServiceGroup;
import com.seatech.ibs.corp.pojo.module.Module;
import com.seatech.ibs.corp.pojo.permission.CorpPermission;

public class ServiceGroupDelegate {

    
    public List<CorpServiceGroup> selectCorpServiceGroup(Pagination pn) throws RuntimeException {
    	ServiceGroupServices service = this.getServiceGroupBean();
        Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIn("channel_code", Arrays.asList(
    				new String[]{
    						AppConstant.SYS_CHANNEL_CODE_IB,
    						AppConstant.SYS_CHANNEL_CODE_MB,
    	}));
        return service.selectCorpServiceGroup(aCriterion, pn);

    }
    
    public List<CorpServiceGroup> selectCorpServiceGroup(String channelCode, Pagination pn) throws RuntimeException {
        ServiceGroupServices service = this.getServiceGroupBean();
        Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIsEqualTo("channel_code", channelCode);
        return service.selectCorpServiceGroup(aCriterion, pn);
    }

    public void deleteServiceGroup(int groupId) throws RuntimeException {
        ServiceGroupServices service = this.getServiceGroupBean();
        service.deleteServiceGroup(groupId);
    }
    
    public CorpServiceGroup getCorpServiceGroup(int id) throws RuntimeException {
        ServiceGroupServices service = this.getServiceGroupBean();
        return service.getCorpServiceGroup(id);
    }

    public void addServiceGroup(Map<String, Object> map) throws Exception {
        ServiceGroupServices service = this.getServiceGroupBean();
        service.addServiceGroup(map);
    }

    public Map<String, List> queryStatusFunctionName(String channelCode) throws RuntimeException {
        ServiceGroupServices service = this.getServiceGroupBean();
        return service.queryStatusFunctionName(channelCode);
    }

    public List<CorpPermission> querySelectedStatusName(int groupId) throws RuntimeException {
        ServiceGroupServices service = this.getServiceGroupBean();
        return service.querySelectedStatusName(groupId);
    }
    
    public List<CorpPermission> queryBBCorpPermissionListBK(int groupId) throws RuntimeException {
        ServiceGroupServices service = this.getServiceGroupBean();
        return service.queryBBCorpPermissionListBK(groupId);
    }
    
    public void modifyServiceGroup(Map<String, Object> map) throws Exception {
        ServiceGroupServices service = this.getServiceGroupBean();
        service.modifyServiceGroup(map);
    }
    
    public void serviceGroupChange(Map map){
    	ServiceGroupServices service = this.getServiceGroupBean();
        service.serviceGroupChange(map);
    }
    
    public List<CorpPermission> queryCorpPermission() throws RuntimeException {
        ServiceGroupServices service = this.getServiceGroupBean();
        return service.queryCorpPermission();
    }

    private ServiceGroupServices getServiceGroupBean() {
        
        return (ServiceGroupServices) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("serviceGroupServices");

    }

    public List<CorpServiceGroup> selectBBCorpServiceGroupList() throws Exception {
        ServiceGroupServices service = this.getServiceGroupBean();
        return service.selectBBCorpServiceGroupList();
    }
    
    
    public Map<String, List<Module>> getParentModuleList(List<Module> moduleList) throws RuntimeException {

        Map<String, List<Module>> returnMap = new HashMap<String, List<Module>>();
        List<Module> frtLevelModuleList = new ArrayList<Module>();
        List<Module> secLevelModuleList = new ArrayList<Module>();
        int firstLevelModuleId = 0;
        for (int i = 0; i < moduleList.size(); i++) {
            Module module = moduleList.get(i);
            if (module.getPModuleId() == -1) {
                firstLevelModuleId = module.getModuleId();
                break;
            }
        }
        for (int i = 0; i < moduleList.size(); i++) {
            Module module = moduleList.get(i);
            if (module.getPModuleId() == firstLevelModuleId && "L2".equals(module.getModuleType())) {
                frtLevelModuleList.add(module);
            }
        }
        for (int i = 0; i < frtLevelModuleList.size(); i++) {
            Module parentModule = frtLevelModuleList.get(i);
            int parentModuleId = parentModule.getModuleId();
            for (int j = 0; j < moduleList.size(); j++) {
                Module subModule = moduleList.get(j);
                if (subModule.getPModuleId() == parentModuleId && !"BA".equals(subModule.getModuleType()) && !"BN".equals(subModule.getModuleType()) && !"BS".equals(subModule.getModuleType())) {
                    secLevelModuleList.add(subModule);
                }
            }
        }
        returnMap.put("frtLevelModuleList", frtLevelModuleList);
        returnMap.put("secLevelModuleList", secLevelModuleList);
        return returnMap;
    }
    
    public List<CorpServiceGroup> queryServiceGroupSelective(CorpServiceGroup userServiceGroup) throws Exception {
    	ServiceGroupServices service = this.getServiceGroupBean();
        return service.queryServiceGroupSelective(userServiceGroup);
    }
    
    public void updateServiceGroupApprove(Map map) throws RuntimeException {
    	ServiceGroupServices service = this.getServiceGroupBean();
        service.updateServiceGroupApprove(map);
    }
    
    public void updateBBCorpPermissionBKByServiceGroup(CorpPermission corpPermission)
			throws DataAccessException {
    	ServiceGroupServices service = this.getServiceGroupBean();
		service.updateBBCorpPermissionBKByServiceGroup(corpPermission);
	}
    
    public void updateServiceGroupBK(CorpServiceGroup corpServiceGroup) {
    	ServiceGroupServices service = this.getServiceGroupBean();
        service.updateServiceGroupBK(corpServiceGroup);
    }

	public void updateBBCorpPermissionByServiceGroup(CorpPermission userPermission) {
		ServiceGroupServices service = this.getServiceGroupBean();
		service.updateBBCorpPermissionByServiceGroup(userPermission);
	}
	
	public void insertCorpPermissionBatch(List<CorpPermission> corpPermissionList)
			throws Exception {
		ServiceGroupServices service = this.getServiceGroupBean();
		service.insertCorpPermissionBatch(corpPermissionList);
	}

	public void deleteCorpPermissionBKByServiceGroup(Integer groupId) {
		ServiceGroupServices service = this.getServiceGroupBean();
		service.deleteUserPermissionBKByServiceGroup(groupId);
	}
	public void deleteCorpPermissionByServiceGroup(Integer groupId) {
		ServiceGroupServices service = this.getServiceGroupBean();
		CorpPermission cp = new CorpPermission();
		cp.setServiceGroupId(groupId);
		service.deteteCorpPermissionSelective(cp);
	}
}
