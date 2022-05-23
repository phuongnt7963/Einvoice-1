package com.seatech.ibs.admin.delegate.etax;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.dsachTBao.DMucTBaoService;
import com.seatech.ibs.corp.pojo.etax.enumeration.DMucTBaoBean;

public class DMucTBaoDelegate {
	DMucTBaoService dmucTBaoService = (DMucTBaoService)WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
					.getServletContext()).getBean("dmucTBaoService");	
	
	public String getPBanTBaoXML(String maTBaoXML) throws Exception {
		return dmucTBaoService.getPBanTBaoXML(maTBaoXML);
	}
	
	public String getTenTBao(String maTBao) throws Exception {
		return dmucTBaoService.getTenTBao(maTBao);
	}
	
	public String getTimeDateDB() throws Exception {
		return dmucTBaoService.getTimeDateDB();
	}
	
	public List<DMucTBaoBean> queryList (DMucTBaoBean dmucTBao) throws Exception{
		return dmucTBaoService.queryList(dmucTBao);		
	}
		
	public List<DMucTBaoBean> queryListDLT (DMucTBaoBean dmucTBao) throws Exception{
		return dmucTBaoService.queryList(dmucTBao);		
	}	
}
