package com.seatech.ibs.admin.delegate.LPTB.DsachTkhaiLPTBDelegate;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.LPTB.DSachCTuLPTB;
import com.seatech.ibs.admin.pojo.LPTB.DSachTKhaiLPTB;
import com.seatech.ibs.admin.pojo.dmucTkhai.TKhaiFileContent;
import com.seatech.ibs.admin.service.LPTB.DSachTKhaiLPTB.DSachTKhaiLPTBService;
import com.seatech.ibs.common.dto.Pagination;

public class DSachTKhaiLPTBDelegate {
	DSachTKhaiLPTBService dSachTKhaiLPTBService = (DSachTKhaiLPTBService)WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
					.getServletContext()).getBean("dSachTKhaiLPTBService");
			
			@SuppressWarnings("rawtypes")
			public List<DSachTKhaiLPTB> queryListTKhaiPagination(HashMap listTKhai,Pagination pn) throws Exception{   	
		    	return dSachTKhaiLPTBService.queryListTKhaiPagination(listTKhai, pn);
			}
			
			public byte[] getFileContentById(TKhaiFileContent bean) throws Exception{
				return dSachTKhaiLPTBService.getFileContentById(bean);
			}
			
			@SuppressWarnings("rawtypes")
			public List<DSachCTuLPTB> queryListCtuPagination(HashMap listCtu, Pagination pn) throws Exception{   
				return dSachTKhaiLPTBService.queryListCtuPagination(listCtu, pn);
			}
			
			public byte[] contentCtuLPTB (TKhaiFileContent bean) throws Exception{
				return dSachTKhaiLPTBService.contentCtuLPTB(bean);
			}
}
