package com.seatech.ibs.admin.delegate.account;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.account.CorpLimitGroupService;
import com.seatech.ibs.common.constant.AppConstant;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Criterion.Criteria;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.corp.pojo.account.AccountSecurity;
import com.seatech.ibs.corp.pojo.account.LimitGroup;
import com.seatech.ibs.corp.pojo.module.Module;

public class CorpLimitGroupDelegate {

    public void deleteLimitGroup(int groupId) throws RuntimeException {
        CorpLimitGroupService service = this.getLimitGroupBean();
        service.deleteLimitGroup(groupId);

    }

    public LimitGroup getLimitGroup(int id) throws RuntimeException {
        CorpLimitGroupService service = this.getLimitGroupBean();
        return service.getLimitGroupById(id);
    }

    public List<LimitGroup> selectLimit(Pagination pn) throws RuntimeException {
    	CorpLimitGroupService service = this.getLimitGroupBean();
    	Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIn("a.channel_code", Arrays.asList(
    				new String[]{
    						AppConstant.SYS_CHANNEL_CODE_IB,
    						AppConstant.SYS_CHANNEL_CODE_MB,
    	}));
    	return service.selectLimitGroup(aCriterion, pn);
    }

    public List<LimitGroup> selectLimit(String channelCode, Pagination pn) throws RuntimeException {
        CorpLimitGroupService service = this.getLimitGroupBean();
        Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIsEqualTo("a.channel_code", channelCode);
        return service.selectLimitGroup(aCriterion, pn);
    }

    public void addLimitGroup(LimitGroup limitGroup, List<AccountSecurity> list) throws Exception {
        CorpLimitGroupService service = this.getLimitGroupBean();
        service.addLimitGroupBatch(limitGroup, list);
    }

    @SuppressWarnings("rawtypes")
	public Map selectInitLimitAddList(int... moduleId) {
        CorpLimitGroupService service = this.getLimitGroupBean();
        return service.selectInitLimitAddList(moduleId);

    }
    public List<Module> getListModule(String moduleId){
    	 CorpLimitGroupService service = this.getLimitGroupBean();
         return service.getModuleList(moduleId);
    }

    @SuppressWarnings("rawtypes")
	public Map selectInitLimitUpdateList(int groupId) throws Exception {
        CorpLimitGroupService service = this.getLimitGroupBean();
        return service.selectInitLimitUpdateLimit(groupId);

    }

    public void updateLimitGroup(LimitGroup limitGroup, List<AccountSecurity> list) throws Exception {
        CorpLimitGroupService service = this.getLimitGroupBean();
        service.updateLimitBatch(limitGroup, list);
    }

    public List<LimitGroup> selectLimitGroupList() throws Exception {
        CorpLimitGroupService service = this.getLimitGroupBean();
        return service.selectLimitGroupList();
    }

    @SuppressWarnings({ "rawtypes" })
	public List selectLimitGroupByCondition(Criterion pCriterion) throws Exception {
            CorpLimitGroupService service = this.getLimitGroupBean();
            return service.selectLimitGroupByCondition(pCriterion);

    }

    private CorpLimitGroupService getLimitGroupBean() {
        return (CorpLimitGroupService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpLimitGroupService");
    }

	public void approveStatusChange(Map<String, Object> map) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.approveStatusChange(map);
	}

	public List<LimitGroup> queryLimitGroupSelective(LimitGroup qryLimitGroup) {
		if (null == qryLimitGroup) {
			return null;
		}
		CorpLimitGroupService service = this.getLimitGroupBean();
		return service.queryLimitGroupSelective(qryLimitGroup);
	}

	public LimitGroup getSelectiveByGroupId(Integer as) throws Exception {
		CorpLimitGroupService service = this.getLimitGroupBean();
		return service.getSelectiveByGroupId(as);
	}

	public void updateLimitGroup(LimitGroup limitGroupUpdate) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.updateLimitGroup(limitGroupUpdate);
	}

	public void updateStatusByGroupId(AccountSecurity updateAS) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.updateStatusByGroupId(updateAS);
	}

	public void updateAccountSecurityBKApprove(AccountSecurity updateASBK) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.updateAccountSecurityBKApprove(updateASBK);
	}

	public void updateLimitGroupBK(LimitGroup limitGroupUpdate) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.updateLimitGroupBK(limitGroupUpdate);
	}

	public void deleteBKByLimitGroupId(Integer processId) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.deleteBKByLimitGroupId(processId);
	}

	public void deleteASByLimitGroupId(Integer processId) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.deleteASByLimitGroupId(processId);
	}

	public LimitGroup queryLimitGroupBK(LimitGroup queryBK) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		return service.queryLimitGroupBK(queryBK);
	}

	public List<AccountSecurity> selectASBKByLimitGroupId(AccountSecurity querybk) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		return service.selectASBKByLimitGroupId(querybk);
	}

	public void insertAccountSecurityBatch(List<AccountSecurity> asbklist) {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.insertAccountSecurityBatch(asbklist);
	}

	public Map<String, List> viewLimitList(int groupId) throws Exception {
		CorpLimitGroupService service = this.getLimitGroupBean();
		return service.viewLimitList(groupId);
	}

	public void addLimitGroup(LimitGroup limitGroup) throws Exception {
		CorpLimitGroupService service = this.getLimitGroupBean();
		service.addLimitGroup(limitGroup);

	}
}
