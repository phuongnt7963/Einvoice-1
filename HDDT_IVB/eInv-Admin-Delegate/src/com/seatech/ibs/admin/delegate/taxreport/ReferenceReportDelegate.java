package com.seatech.ibs.admin.delegate.taxreport;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.taxreport.TaxReportDTLR1;
import com.seatech.ibs.admin.pojo.taxreport.TaxReportDTLR2;
import com.seatech.ibs.admin.pojo.taxreport.TaxReportDTLR3;
import com.seatech.ibs.admin.pojo.taxreport.TaxReportDTLR4;
import com.seatech.ibs.admin.pojo.taxreport.TaxReportDTLR5;
import com.seatech.ibs.admin.pojo.taxreport.TaxReportHDR;
import com.seatech.ibs.admin.service.taxreport.ReferenceReportService;

public class ReferenceReportDelegate extends DelegateBase {
	private ReferenceReportService getReferenceReportService() {
		return (ReferenceReportService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("referenceReportService");
	}
	public TaxReportHDR getBCaoHDR (Map map) throws Exception{
		return this.getReferenceReportService().getBCaoHDR(map);
	}
	
	public List<TaxReportDTLR1> queryReportDTLR1 (Map map) throws Exception{
		return this.getReferenceReportService().queryReportDTLR1(map);
	}
	
	public List<TaxReportDTLR2> queryReportDTLR2 (Map map) throws Exception{
		return this.getReferenceReportService().queryReportDTLR2(map);
	}
	
	public List<TaxReportDTLR3> queryReportDTLR3 (Map map) throws Exception{
		return this.getReferenceReportService().queryReportDTLR3(map);
	}
	
	public List<TaxReportDTLR4> queryReportDTLR4 (Map map) throws Exception{
		return this.getReferenceReportService().queryReportDTLR4(map);
	}
	
	public List<TaxReportDTLR5> queryReportDTLR5 (Map map) throws Exception{
		return this.getReferenceReportService().queryReportDTLR5(map);
	}
}
