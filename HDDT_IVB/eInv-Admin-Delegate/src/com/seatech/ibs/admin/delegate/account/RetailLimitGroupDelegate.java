package com.seatech.ibs.admin.delegate.account;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.account.RetailLimitGroupService;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Criterion.Criteria;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.retail.pojo.account.AccountSecurity;
import com.seatech.ibs.retail.pojo.account.LimitGroup;

public class RetailLimitGroupDelegate {

	public void deleteLimitGroup(int groupId) throws RuntimeException {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.deleteLimitGroup(groupId);

	}

	public LimitGroup getLimitGroup(int id) throws RuntimeException {
		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.getLimitGroupById(id);
	}

	public List<LimitGroup> selectLimit(Pagination pn) throws RuntimeException {
		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.selectLimitGroup(pn);
	}

	public List<LimitGroup> selectLimit(String channelCode, Pagination pn) throws RuntimeException {
		RetailLimitGroupService service = this.getLimitGroupBean();
		Criterion aCriterion = new Criterion();
		Criteria aCriteria = aCriterion.createCriteria();
		aCriteria.andDataIsEqualTo("a.channel_code", channelCode);
		return service.selectLimitGroup(aCriterion, pn);
	}

	public void addLimitGroup(LimitGroup limitGroup, List<AccountSecurity> list) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.addLimitGroupBatch(limitGroup, list);
	}

	@SuppressWarnings("rawtypes")
	public Map selectInitLimitAddList(String module) {

		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.selectInitLimitAddList(module);

	}

	@SuppressWarnings("rawtypes")
	public Map selectInitLimitUpdateList(Integer groupId) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.selectInitLimitUpdateLimit(groupId);
	}

	public void updateLimitGroup(LimitGroup limitGroup, List<AccountSecurity> list) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.updateLimitBatch(limitGroup, list);
	}

	private RetailLimitGroupService getLimitGroupBean() {
		return (RetailLimitGroupService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext())
				.getBean("retailLimitGroupService");
	}

	/**
	 * @desc:queryLimitGroupSelective
	 * @param limitGroupInfo
	 * @return
	 * @throws Exception
	 * @author:xinliangWang
	 * @createDate:2011-8-16 Amendment History: Amended By Amended On Amendment Description ------------ -----------
	 *                       ---------------------------------------------
	 */
	public List<LimitGroup> queryLimitGroupSelective(LimitGroup limitGroupInfo) throws Exception {
		if (null == limitGroupInfo) {
			return null;
		}
		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.queryLimitGroupSelective(limitGroupInfo);

	}

	public void approveStatusChange(Map<String, Object> map) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.approveStatusChange(map);
	}

	public void updateLimitGroup(LimitGroup limitGroup) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.updateLimitGroup(limitGroup);
	}
	public void updateStatusByGroupId(AccountSecurity as) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.updateStatusByGroupId(as);
	}
	
	public void updateLimitGroupBK(LimitGroup updatebk) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.updateLimitGroupBK(updatebk);
	}
	public void deleteASByLimitGroupId(Integer id) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.deleteASByLimitGroupId(id);
	}
	public void updateAccountSecurityBKApprove(AccountSecurity as) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.updateAccountSecurityBKApprove(as);
	}
	public LimitGroup queryLimitGroupBK(LimitGroup as) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.queryLimitGroupBK(as);
	}
	public List<AccountSecurity> selectASBKByLimitGroupId(AccountSecurity as){
		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.selectASBKByLimitGroupId(as);
	}
	public void insertAccountSecurityBatch(List<AccountSecurity> as) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.insertAccountSecurityBatch(as);
	}
	public void deleteBKByLimitGroupId(Integer id) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		service.deleteBKByLimitGroupId(id);
	}
	public LimitGroup getSelectiveByGroupId(Integer as) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.getSelectiveByGroupId(as);
	}

	public Map viewLimitList(int groupId) throws Exception {
		RetailLimitGroupService service = this.getLimitGroupBean();
		return service.viewLimitList(groupId);
	}
}
