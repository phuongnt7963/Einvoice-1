package com.seatech.ibs.admin.delegate.taxreport;

import java.util.Map;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.service.taxreport.IhtkkReportService;
import com.seatech.ibs.common.util.SpringBeanDelegate;

public class IhtkkReportDelegate extends DelegateBase {
	private IhtkkReportService getIhtkkReportService() throws Exception {
		return (IhtkkReportService)SpringBeanDelegate.getBean("ihtkkReportService");
	}
	public Integer getTotalR1a (Map map) throws Exception{
		return  getIhtkkReportService().getTotalR1a(map);
	}
	public Integer getTotalR1b (Map map) throws Exception{
		return  getIhtkkReportService().getTotalR1b(map);
	}
	public Integer getTotalR1c () throws Exception{
		return  getIhtkkReportService().getTotalR1c();
	}
}
