package com.seatech.ibs.admin.delegate.registerLog;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.RegisterLog.RegisterLogService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.retail.Log.RegisterLog;

public class RegisterLogDelegate {

	public void addRegisterLog(RegisterLog log) {
		RegisterLogService service = getService();
		service.insert(log);
	}
	public List<RegisterLog> queryLogBycondition(Pagination pn,Map<String, Object> queryCondition) {
		RegisterLogService service = getService();
		return service.queryLogBycondition(pn, queryCondition);
	}
	public List<RegisterLog> queryLogBycondition(Map<String, Object> queryCondition) {
		RegisterLogService service = getService();
		return service.queryLogBycondition(queryCondition);
	}

	private RegisterLogService getService() {
        return (RegisterLogService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("registerLogService");
    }
	public void updateStatus(Map<String, Object> map) {
		RegisterLogService service = getService();
		service.updateStatus(map);
	}
}
