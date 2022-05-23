package com.seatech.ibs.admin.delegate.LPTB.QlyDanhMuc;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.LPTB.DanhMucCTBanhXe;
import com.seatech.ibs.admin.pojo.LPTB.DanhMucNH_LPTB;
import com.seatech.ibs.admin.pojo.LPTB.DanhMucNhanHieu;
import com.seatech.ibs.admin.service.LPTB.QlyDanhMucLPTB.QlyDanhMucLPTBService;
import com.seatech.ibs.common.dto.Pagination;

public class QlyDanhMucLPTBDelegate {
	QlyDanhMucLPTBService qlyDanhMucLPTBService = (QlyDanhMucLPTBService)WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
					.getServletContext()).getBean("qlyDanhMucLPTBService");
	
	public List<DanhMucNH_LPTB> dmucNH() throws Exception{
		return qlyDanhMucLPTBService.dmucNH();		
	}
     /*anhvt DanhMuc CTBanhXe*/
	@SuppressWarnings("rawtypes")
	public List<DanhMucCTBanhXe> queryListDmucCTBxePagination(HashMap list,Pagination pn) throws Exception{   	
    	return qlyDanhMucLPTBService.queryListDmucCTBxePagination(list, pn);
	}
	
	public String rec_exists (String maCtBxe) throws Exception{
		return qlyDanhMucLPTBService.rec_exists(maCtBxe);
	}
	
	public void updateDmucCTBxe (DanhMucCTBanhXe dmuc) throws Exception{
		qlyDanhMucLPTBService.updateDmucCTBxe(dmuc);
	}
	
	public void insertDmucCTBxe (DanhMucCTBanhXe dmuc) throws Exception{
		qlyDanhMucLPTBService.insertDmucCTBxe(dmuc);
	}
	
	public void changeTthai (DanhMucCTBanhXe dmuc) throws Exception{
		qlyDanhMucLPTBService.changeTthai(dmuc);
	}
	
	public DanhMucCTBanhXe dmuc (String maCtBxe ) throws Exception{
		return qlyDanhMucLPTBService.dmuc(maCtBxe);
	}
	/*end*/
	
	/*anhvt DanhMuc Nhan Hieu*/
	public List<DanhMucNhanHieu> dmuc() throws Exception{
		return qlyDanhMucLPTBService.dmuc();	
	}
	@SuppressWarnings("rawtypes")
	public List<DanhMucNhanHieu> queryListDanhMucNhanHieuPagination(HashMap list,Pagination pn) throws Exception{   	
    	return qlyDanhMucLPTBService.queryListDanhMucNhanHieuPagination(list, pn);
	}
	
	public String rec_existsNhanHieu(String maNhanHieu) throws Exception{
		return qlyDanhMucLPTBService.rec_existsNhanHieu(maNhanHieu);
	}
	
	public void updateDanhMucNhanHieu (DanhMucNhanHieu dmuc) throws Exception{
		qlyDanhMucLPTBService.updateDanhMucNhanHieu(dmuc);
	}
	
	public void insertDanhMucNhanHieu (DanhMucNhanHieu dmuc) throws Exception{
		qlyDanhMucLPTBService.insertDanhMucNhanHieu(dmuc);
	}
	
	public void changeTthaiNhanHieu (DanhMucNhanHieu dmuc) throws Exception{
		qlyDanhMucLPTBService.changeTthaiNhanHieu(dmuc);
	}
	
}
