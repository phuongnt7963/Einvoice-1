package com.seatech.ibs.admin.delegate.apporveLog;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.approveLog.ApproveLog;
import com.seatech.ibs.admin.service.approveLog.ApproveLogService;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Criterion.Criteria;
import com.seatech.ibs.common.dto.Pagination;

public class ApproveLogDelegate {
			
	public void addApproveLog(ApproveLog log) {
		ApproveLogService service = getService();
		service.insertLog(log);
	}
	
	public List<ApproveLog> queryPendingLogBycondition(String sysCode, String moduleName, String approveStatus, String changeType, 
														String channelCode, Timestamp fromDate, Timestamp toDate, Pagination pn) {
		ApproveLogService service = getService();
		Criterion aCriterion = new Criterion();
    	Criteria aCriteria = aCriterion.createCriteria();
    	aCriteria.andDataIsEqualTo("sys_code", sysCode);
    	aCriteria.andDataIsEqualTo("module_name", moduleName);
    	aCriteria.andDataIsEqualTo("approve_status", approveStatus);
    	aCriteria.andDataIsEqualTo("change_type", changeType);
    	aCriteria.andDataIsEqualTo("channel_code", channelCode);
    	aCriteria.andDataGreaterThanOrEqualTo("create_time", fromDate);
    	aCriteria.andDataLessThanOrEqualTo("create_time", toDate);
        return service.queryPendingLog(aCriterion, pn);
	}
	
	public void updatePendingLog(ApproveLog log) {
		ApproveLogService service = getService();
		service.update(log);		
	}
	
	private ApproveLogService getService() {
        return (ApproveLogService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("approveLogService");
    }	
}
