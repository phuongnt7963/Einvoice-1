package com.seatech.ibs.admin.delegate.taxreport;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.service.taxreport.StatisticReportService;

public class StatisticReportDelegate extends DelegateBase {
	private StatisticReportService getStatisticReportService() {
		return (StatisticReportService) WebApplicationContextUtils
				.getWebApplicationContext(
						HttpSessionInfoHolder.getHttpSession()
								.getServletContext()).getBean(
						"statisticReportService");
	}

	public List<Object> queryReport(Map map) throws Exception {
		return this.getStatisticReportService().queryReport(map);
	}
	
	public List<Object> callProcedureTK(Map map) throws Exception {
		return this.getStatisticReportService().callProcedureTK(map);
	}
}
