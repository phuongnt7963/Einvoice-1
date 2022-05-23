package com.seatech.ibs.admin.delegate.etax;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.dsachTBao.DSachTBaoService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTBaoBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTBao_ChuaKyBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTKhaiBean;

public class DSachTBaoDelegate {
	DSachTBaoService dsachTBaoService = (DSachTBaoService)WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
					.getServletContext()).getBean("dsachTBaoService");			
			
	public DSachTBaoBean downfileCBT (long messId) throws Exception{
		return dsachTBaoService.downfileCBT(messId);
	}
	
	public void insert(DSachTBaoBean dsachTBaoBean) throws Exception {
		dsachTBaoService.insert(dsachTBaoBean);	
	}			
	
	public void insertTBaoCBTBuffer(DSachTBaoBean dsachTBaoBean) throws Exception {
		DSachTBaoService dsachTBaoService = (DSachTBaoService)SpringBeanDelegate.getBean("dsachTBaoService");
		dsachTBaoService.insertTBaoCBTBuffer(dsachTBaoBean);	
	}
	
	public void insertTKhaiXMLBuffer(DSachTKhaiBean dsachTBaoBean) throws Exception {
		DSachTBaoService dsachTBaoService = (DSachTBaoService)SpringBeanDelegate.getBean("dsachTBaoService");
		dsachTBaoService.insertTKhaiXMLBuffer(dsachTBaoBean);	
	}
	
	public void insertTBaoChuaKy(DSachTBao_ChuaKyBean dsachTbao) throws Exception{
		dsachTBaoService.insertTBaoChuaKy(dsachTbao);	
	}
	
	public byte[] fun_downfileCBT (long id, String type) throws Exception{
		return dsachTBaoService.fun_downfileCBT(id, type);
	}
}
