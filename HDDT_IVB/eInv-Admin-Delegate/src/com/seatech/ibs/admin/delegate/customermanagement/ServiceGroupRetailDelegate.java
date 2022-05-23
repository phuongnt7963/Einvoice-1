package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.customermanagement.ServiceGroupRetailServices;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.dto.Criterion.Criteria;
import com.seatech.ibs.retail.pojo.module.Module;
import com.seatech.ibs.retail.pojo.permission.UserPermission;
import com.seatech.ibs.retail.pojo.user.UserServiceGroup;

public class ServiceGroupRetailDelegate {

    public List<UserServiceGroup> selectUserServiceGroup(Pagination pn) throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        return service.selectUserServiceGroup(pn);
    }
    public List<UserServiceGroup> selectUserServiceGroup(String channelCode, Pagination pn) throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIsEqualTo("channel_code", channelCode);
        return service.selectUserServiceGroup(aCriterion, pn);
    }

    public List<UserPermission> queryUserPermission() throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        return service.queryUserPermission();
    }

    public List<UserPermission> queryUserPermissionByGroupId(int groupId) throws Exception {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        return service.queryUserPermissionByGroupId(groupId);
    }
    
    public List<UserPermission> queryUserPermissionBKByGroupId(int groupId) throws Exception {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        return service.queryUserPermissionBKByGroupId(groupId);
    }
    
    public void deleteServiceGroup(int groupId) throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        service.deleteServiceGroup(groupId);
    }
    
    public void serviceGroupChange(Map map){
    	ServiceGroupRetailServices service = this.getServiceGroupBean();
        service.serviceGroupChange(map);
    }
    
    public void addServiceGroup(Map map) {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        service.addServiceGroup(map);
    }

    public List<UserPermission> querySelectedStatusName(int groupId) throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        return service.querySelectedStatusName(groupId);
    }

    public UserServiceGroup getUserServiceGroup(int id) throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        return service.getUserServiceGroup(id);
    }

    public Map<String, List> queryStatusFunctionName(String channelCode) throws Exception {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        return service.queryStatusFunctionName(channelCode);
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

    @SuppressWarnings("rawtypes")
	public void updateServiceGroup(Map map) throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        service.updateServiceGroup(map);
    }
    
    @SuppressWarnings("rawtypes")
	public void updateServiceGroupApprove(Map map) throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        service.updateServiceGroupApprove(map);
    }
    
	public void updateServiceGroupBK(UserServiceGroup userServiceGroup) throws RuntimeException {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        service.updateServiceGroupBK(userServiceGroup);
    }
    
    private ServiceGroupRetailServices getServiceGroupBean() {
        return (ServiceGroupRetailServices) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("serviceGroupRetailServices");

    }

    
    public List<UserServiceGroup> queryServiceGroupSelective(UserServiceGroup userServiceGroup) throws Exception {
        ServiceGroupRetailServices service = this.getServiceGroupBean();
        return service.queryServiceGroupSelective(userServiceGroup);
    }
    
	public void updatePermision(UserPermission userPermissionInfo)
			throws DataAccessException {
		ServiceGroupRetailServices service = this.getServiceGroupBean();
		service.updatePermision(userPermissionInfo);
		
	}
	
	public void updatePermissionBK(UserPermission userPermissionInfo)
			throws DataAccessException {
		ServiceGroupRetailServices service = this.getServiceGroupBean();
		service.updatePermissionBK(userPermissionInfo);
		
	}
	
	public void updateBCUserPermissionByServiceGroup(UserPermission userPermissionInfo)
			throws DataAccessException {
		ServiceGroupRetailServices service = this.getServiceGroupBean();
		service.updateBCUserPermissionByServiceGroup(userPermissionInfo);
	}
	
	public void updateBCUserPermissionBKByServiceGroup(UserPermission userPermissionInfo)
			throws DataAccessException {
		ServiceGroupRetailServices service = this.getServiceGroupBean();
		service.updateBCUserPermissionBKByServiceGroup(userPermissionInfo);
	}
	
	public void insertUserPermissionBatch(List<UserPermission> userPermissionList)
			throws DataAccessException {
		ServiceGroupRetailServices service = this.getServiceGroupBean();
		service.insertUserPermissionBatch(userPermissionList);
	}
	
	public void deleteUserPermissionByServiceGroup(Integer groupId) 
			throws DataAccessException {
		ServiceGroupRetailServices service = this.getServiceGroupBean();
		service.deleteUserPermissionByServiceGroup(groupId);
    }
	
	public void deleteUserPermissionBKByServiceGroup(Integer groupId) 
			throws DataAccessException {
		ServiceGroupRetailServices service = this.getServiceGroupBean();
		service.deleteUserPermissionBKByServiceGroup(groupId);
    }

}
