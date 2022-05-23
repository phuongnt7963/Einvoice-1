package com.seatech.ibs.admin.delegate.dmucLPTB;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.dmucbanggia.DmucBangGia;
import com.seatech.ibs.admin.pojo.dmuctaisan.DmucTSan;
import com.seatech.ibs.admin.pojo.dmuctaisan.DmucTaiSan;
import com.seatech.ibs.admin.service.dmucLPTB.DMucLPTBService;
import com.seatech.ibs.common.dto.Pagination;

public class DMucLPTBDelegate {
	DMucLPTBService dmucLPTBService = (DMucLPTBService) WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext())
			.getBean("dmucLPTBService");
	
	public void insertPriceRetail(DmucBangGia dmucBangGia) throws Exception {
		dmucLPTBService.insertPriceRetail(dmucBangGia);
	}
	
	public void updatePriceRetail(DmucBangGia dmucBangGia) throws Exception {
		dmucLPTBService.updatePriceRetail(dmucBangGia);
	}
	
	public List<DmucTSan> getLoaiTSan(HashMap<String, Object> bean) throws Exception {
		return dmucLPTBService.getLoaiTSan(bean);
	}
	
	public List<DmucTSan> getTsanGroup(HashMap<String, Object> bean) throws Exception {
		return dmucLPTBService.getTsanGroup(bean);
	}
	
	public List<DmucTSan> getNhanHieu(HashMap<String, Object> bean) throws Exception {
		return dmucLPTBService.getNhanHieu(bean);
	}
	
	public List<DmucTSan> getCongThucBanhXe(HashMap<String, Object> bean) throws Exception {
		return dmucLPTBService.getCongThucBanhXe(bean);
	}	
	
	public List<DmucTSan> getNuocSXuat(HashMap<String, Object> bean) throws Exception {
		return dmucLPTBService.getNuocSXuat(bean);
	}
	
	public List<DmucTSan> getTenThuongMai(HashMap<String, Object> bean) throws Exception {
		return dmucLPTBService.getTenThuongMai(bean);
	}
	
	public List<DmucBangGia> getListBGia(HashMap listTKhai,Pagination pn) throws Exception {
		return dmucLPTBService.getListBGia(listTKhai,pn);
	}
	
	public List<DmucBangGia> getListTSan(HashMap listTKhai,Pagination pn) throws Exception {
		return dmucLPTBService.getListTSan(listTKhai,pn);
	}
	
	public List<DmucTaiSan> getDsachTSan(HashMap listTKhai,Pagination pn) throws Exception {
		return dmucLPTBService.getDsachTSan(listTKhai,pn);
	}
	
	public String rec_existsPTien(String maPTien) throws Exception{
		return dmucLPTBService.rec_existsPTien(maPTien);
	}
	
	public void updateDanhMucPTien (DmucTaiSan dmuc) throws Exception{
		dmucLPTBService.updateDanhMucPTien(dmuc);
	}
	
	public void insertDanhMucPTien (DmucTaiSan dmuc) throws Exception{
		dmucLPTBService.insertDanhMucPTien(dmuc);
	}
	
	public void changeTthaiPTien (DmucTaiSan dmuc) throws Exception{
		dmucLPTBService.changeTthaiPTien(dmuc);
	}
	
	public int existsBGia(DmucBangGia dmuc) throws Exception{
		return dmucLPTBService.existsBGia(dmuc);
	}
	
	public DmucBangGia getBanggia(DmucBangGia dmuc) throws Exception{
		return dmucLPTBService.getBanggia(dmuc);
	}
	
	@SuppressWarnings("rawtypes")
	public List<DmucBangGia> queryListBangGiaXCDPagination(HashMap listBangGiaXCD,Pagination pn) throws Exception{   	
	    	return dmucLPTBService.queryListBangGiaXCDPagination(listBangGiaXCD, pn);
		}
}
