package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.customermanagement.CorpGroupServices;
import com.seatech.ibs.admin.service.customermanagement.UserGroupRetailServices;
import com.seatech.ibs.common.constant.AppConstant;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.dto.Criterion.Criteria;
import com.seatech.ibs.corp.pojo.account.LimitGroup;
import com.seatech.ibs.corp.pojo.corp.CorpGroup;
import com.seatech.ibs.retail.pojo.user.UserGroup;

public class CorpGroupDelegate {

    public List<CorpGroup> selectCorpGroup() throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        return service.selectCorpGroup();
    }

    public List<CorpGroup> selectCorpGroupSelected(Integer groupId) throws RuntimeException {
    	try {
			return Arrays.asList(this.getCorpGroupInfo(groupId));
		} catch (Exception e) {
			e.printStackTrace();
		}
//        CorpGroupServices service = this.getCorpGroupBean();
//        return service.selectCorpGroupSelected(groupId);
		return null;
    }

    public List<CorpGroup> selectCorpGroup(Pagination pn) throws RuntimeException {
    	CorpGroupServices service = this.getCorpGroupBean();
        Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIn("a.channel_code", Arrays.asList(
				new String[]{
						AppConstant.SYS_CHANNEL_CODE_IB,
						AppConstant.SYS_CHANNEL_CODE_MB,
		}));
        return service.selectCorpGroup(aCriterion, pn);
    }

    public List<CorpGroup> selectCorpGroup(String channelCode, Pagination pn) throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIsEqualTo("a.channel_Code", channelCode);
        return service.selectCorpGroup(aCriterion, pn);
    }

    public void deleteCorpGroup(int groupId) throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        service.deleteCorpGroup(groupId);
    }

    public CorpGroup getCorpGroup(int id) throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        return service.getCorpGroup(id);
    }

    public List<CorpGroup> getCorpGroupBK(int id) throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        return service.getCorpGroupBK(id);
    }

    public Map<String, Object> selectCorpGroupList() throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        return service.selectCorpGroupList();
    }

    public List<LimitGroup> selectCorpLimitGroupList() throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        return service.getCorpLimitGroupList();
    }

    public Map<String, Object> getCorpGroupList(Map<String, Integer> mapValue) throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        return service.getCorpGroupList(mapValue);
    }

    public int addCorpGroup(CorpGroup corpGroupInfo) throws  Exception {
        CorpGroupServices service = this.getCorpGroupBean();
        return service.addCorpGroup(corpGroupInfo);
    }

    public void addCorpGroupBK(CorpGroup corpGroupInfo) throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        service.addCorpGroupBK(corpGroupInfo);
    }

    public void updateCorpGroup(CorpGroup corpGroupInfo) throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        service.updateCorpGroup(corpGroupInfo);
    }

    public void updateCorpGroupBK(CorpGroup corpGroupInfo) throws RuntimeException {
        CorpGroupServices service = this.getCorpGroupBean();
        service.updateCorpGroupBK(corpGroupInfo);
    }

    public List findGroupIdNameList() throws Exception{
    	CorpGroupServices service = this.getCorpGroupBean();
        return service.findGroupIdNameList();
    }
    private CorpGroupServices getCorpGroupBean() {
        return (CorpGroupServices) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpGroupServices");
    }
    public void corpGroupChange(Map map){
    	CorpGroupServices service = this.getCorpGroupBean();
        service.corpGroupChange(map);
    }

    public  CorpGroup getCorpGroupInfo(int groupId) throws Exception {
    	CorpGroupServices service = this.getCorpGroupBean();
        return service.getCorpGroupInfo(groupId);
    }

    public  CorpGroup getCorpGroupInfoBK(int groupId) throws Exception {
    	CorpGroupServices service = this.getCorpGroupBean();
        return service.getCorpGroupInfoBK(groupId);
    }
}
