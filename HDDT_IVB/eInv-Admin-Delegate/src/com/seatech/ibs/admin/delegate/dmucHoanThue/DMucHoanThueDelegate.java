package com.seatech.ibs.admin.delegate.dmucHoanThue;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.hoanthue.DKyHoanThue;
import com.seatech.ibs.admin.pojo.taxPayer.BKTaxPayerDel;
import com.seatech.ibs.admin.service.dmucHoanThue.DMucHoanThueService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.etax.enumeration.DMucBKeBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DMucTBaoBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTBaoBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTKhaiBean;

public class DMucHoanThueDelegate {
	DMucHoanThueService adminHoanThueService = (DMucHoanThueService) WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext())
			.getBean("adminHoanThueService");

	public Collection getDSachTBaoHoan(HashMap mapParam, Pagination pn, int maxSelectResult) throws Exception {
		return adminHoanThueService.getDSachTBaoHoan(mapParam, pn, maxSelectResult);
	}

	public Collection getDsachTKhai(HashMap mapParam, Pagination pn,int maxSelectResult) throws Exception {
		return adminHoanThueService.getDSachTKhai(mapParam, pn, maxSelectResult);
	}
	
	public Collection getDSachLoaiTBao() throws Exception {
		return adminHoanThueService.getDSachLoaiTBao();
	}	
	
	public Collection xemTBaoDNH(HashMap mapParam, Pagination pn, int maxSelectResult) throws Exception {
		return adminHoanThueService.xemTBaoDNH(mapParam, pn, maxSelectResult);
	}	
	
	public void insertTBao(HashMap mapParam) throws Exception {
		adminHoanThueService.insertTBao(mapParam);
	}
	
	public Collection getDSachTBaoHoanExcel(HashMap mapParam) throws Exception {
		return adminHoanThueService.getDSachTBaoHoanExcel(mapParam);
	}	
	
	public Collection getDSachLoaiTBaoKhac() throws Exception {
		return adminHoanThueService.getDSachLoaiTBaoKhac();
	}	
	
	public int checkExistMSTInUserId(HashMap mapParam) throws Exception {
		return adminHoanThueService.checkExistMSTInUserId(mapParam);
	}	
	
	public void insertTBaoKhac(HashMap mapParam) throws Exception {
		adminHoanThueService.insertTBaoKhac(mapParam);
	}	
	
	public void insertDSachHThue(DKyHoanThue dKy) throws Exception {
		adminHoanThueService.insertDSachHThue(dKy);
	}
	
	public String getCountMST(String tin) throws Exception {
		return adminHoanThueService.getCountMST(tin);
	}
	
	public BKTaxPayerDel getTaxPayerDelByTin(String tin) throws Exception {
		return adminHoanThueService.getTaxPayerDelByTin(tin);
	}
	public List<DSachTBaoBean> queryListTbao(Map map) throws Exception {
		return adminHoanThueService.queryListTbao(map);
	}
	public List<DMucTBaoBean> queryDMucTBaoHoanThue() throws Exception {
		return adminHoanThueService.queryDMucTBaoHoanThue();
	}
	public DSachTBaoBean getMaEcmHoanThue(Long id) throws Exception {
		return adminHoanThueService.getMaEcmHoanThue(id);
	}
	public Collection getAllDSachLoaiTBao(Map map) throws Exception {
        return adminHoanThueService.getAllDSachLoaiTBao(map);
    }
	
	public Collection getDmucBKeById(String id_tkhai) throws Exception {
		return adminHoanThueService.getDmucBKeById(id_tkhai);
	}
	
	public void uploadFile (DMucBKeBean BKeBean) throws Exception{
		adminHoanThueService.uploadFile(BKeBean);
	}
	
	public void insertFileBke(DSachTKhaiBean dsachTKhaiBean) throws Exception{
		adminHoanThueService.insertFileBke(dsachTKhaiBean);
	}
	
	public String countNumberBKe(Map ttinBke) throws Exception{
        return adminHoanThueService.countNumberBKe(ttinBke);
    }
	
	public void changStatusHThue (Map bean) throws Exception{
		adminHoanThueService.changStatusHThue(bean);
	}
	public DKyHoanThue findDSachHTByTin(String tin) throws Exception {
		return adminHoanThueService.findDSachHTByTin(tin);
	}
	public void updateDSachHThueByTin(DKyHoanThue dKy) throws Exception {
		adminHoanThueService.updateDSachHThueByTin(dKy);
	}
	public List<DKyHoanThue> findDSachHoanThueEXP(Map map) throws Exception {
		return adminHoanThueService.findDSachHoanThueEXP(map);
	}
	
	public void insertCTietLoi(Map map) throws Exception{
		adminHoanThueService.insertCTietLoi(map);
	}
}
