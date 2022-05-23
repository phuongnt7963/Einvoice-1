
package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.customermanagement.ServiceGroupRetailServices;
import com.seatech.ibs.admin.service.customermanagement.UserGroupRetailServices;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.dto.Criterion.Criteria;
import com.seatech.ibs.retail.pojo.user.UserGroup;


public class UserGroupRetailDelegate {

    public List<UserGroup> selectUserGroup() throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        return service.selectUserGroup();
    }
    
    public List<UserGroup> selectUserGroup(Pagination pn) throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        return service.selectUserGroup(pn);
    }
    
    public List<UserGroup> selectUserGroup(String channelCode, Pagination pn) throws RuntimeException {
    	Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIsEqualTo("a.channel_Code", channelCode);
        UserGroupRetailServices service = this.getUserGroupBean();
        return service.selectUserGroup(aCriterion,pn);
    }

    public List<UserGroup> selectUserGroupIdName() throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        return service.selectBCUserGroupIdName();
    }

    public void deleteUserGroup(int groupId) throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        service.deleteUserGroup(groupId);
    }

    public UserGroup getUserGroup(int id) throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        return service.getUserGroup(id);
    }
    
    public UserGroup selectBCUserGroupId(int id) throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        return service.getUserGroupInfo(id);
    }

    public Map<String, Object> selectUserGroupList() throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        return service.selectUserGroupList();
    }

    public Map<String, Object> getUserGroupList(Map<String, Integer> mapValue) throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        return service.getUserGroupList(mapValue);
    }

	public int countUserGroupExist(int groupId) throws Exception{
		 UserGroupRetailServices service = this.getUserGroupBean();
		return service.countUserGroupExist(groupId);
	}
    
    //public int addUserGroup(UserGroup UserGroupInfo) throws RuntimeException {
   //     UserGroupRetailServices service = this.getUserGroupBean();
   //     service.addUserGroup(UserGroupInfo);
   // }

    public void updateUserGroup(UserGroup UserGroupInfo) throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        service.updateUserGroup(UserGroupInfo);
    }
    
    public void updateUserGroupBK(UserGroup UserGroupInfo) throws RuntimeException {
        UserGroupRetailServices service = this.getUserGroupBean();
        service.updateUserGroupBK(UserGroupInfo);
    }

    
    public int updateByPrimaryKeySelective(UserGroup userGroup) throws Exception {
        return this.getUserGroupBean().updateByPrimaryKeySelective(userGroup);
    }

    
    public List<UserGroup> queryRetailUserGroupSelective(UserGroup userGroup) throws Exception {
        return this.getUserGroupBean().queryRetailUserGroupSelective(userGroup);
    }
    
    public List<UserGroup> queryRetailUserGroupSelectiveBK(UserGroup userGroup) throws Exception {
        return this.getUserGroupBean().queryRetailUserGroupSelectiveBK(userGroup);
    }
    
    public UserGroup getUserGroupInfoBK(int groupId) throws Exception {
    	UserGroupRetailServices service = this.getUserGroupBean();
        return service.getUserGroupInfoBK(groupId);
       
    }

    private UserGroupRetailServices getUserGroupBean() {
        return (UserGroupRetailServices) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("userGroupRetailServices");
    }
    
    public void userGroupChange(Map map){
    	UserGroupRetailServices service = this.getUserGroupBean();
        service.userGroupChange(map);
    }
    

}
