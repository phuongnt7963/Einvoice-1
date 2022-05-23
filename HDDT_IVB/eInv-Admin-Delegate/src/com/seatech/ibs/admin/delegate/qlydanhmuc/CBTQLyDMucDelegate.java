package com.seatech.ibs.admin.delegate.qlydanhmuc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.dmucTkhai.DMucTKhai;
import com.seatech.ibs.admin.pojo.etaxcn.ICNDMucTSan;
import com.seatech.ibs.admin.pojo.etaxcn.ICNTyLe;
import com.seatech.ibs.admin.pojo.notification.CatalogueNotification;
import com.seatech.ibs.admin.pojo.qlydanhmuc.BkMapBankGip;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucBCao;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucCQT;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucCQThu;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucChuong;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucHuyen;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucKhoBac;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucNDKT;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucNganHang;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucNgayNghi;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucTKNSNN;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucTThaiCTu;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucTVAN;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucThamSoHT;
import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucTinh;
import com.seatech.ibs.admin.service.qlydanhmuc.CBTQlyDMucService;
import com.seatech.ibs.common.dto.Pagination;

public class CBTQLyDMucDelegate {

	CBTQlyDMucService cBTQlyDMucService = (CBTQlyDMucService) WebApplicationContextUtils
			.getWebApplicationContext(
					HttpSessionInfoHolder.getHttpSession().getServletContext())
			.getBean("cBTQLyDMucService");

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucChuong> queryDMucChuong(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucChuong(pn, pMap);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucKhoBac> queryDMucKhoBac(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucKhoBac(pn, pMap);
	}

	public List<DanhMucKhoBac> queryListDMucKhoBac(DanhMucKhoBac dmKhoBac)
			throws Exception {
		return this.cBTQlyDMucService.queryListDMucKhoBac(dmKhoBac);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucTinh> queryDMucTinh(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucTinh(pn, pMap);
	}

	public List<DanhMucTinh> queryListDMucTinh(DanhMucTinh dmTinh)
			throws Exception {
		return this.cBTQlyDMucService.queryListDMucTinh(dmTinh);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucNganHang> queryDMucNganHang(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucNganHang(pn, pMap);
	}

	public List<DanhMucNganHang> queryListDMucNganHang(
			DanhMucNganHang dmNganHang) throws Exception {
		return this.cBTQlyDMucService.queryListDMucNganHang(dmNganHang);
	}

	public List<DanhMucNganHang> queryInfoNganHangByMa(
			DanhMucNganHang dmNganHang) throws Exception {
		return this.cBTQlyDMucService.queryInfoNganHangByMa(dmNganHang);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucHuyen> queryDMucHuyen(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucHuyen(pn, pMap);
	}

	public List<DanhMucHuyen> queryListDMucHuyen(DanhMucHuyen dmHuyen)
			throws Exception {
		return this.cBTQlyDMucService.queryListDMucHuyen(dmHuyen);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucCQThu> queryDMucCQThu(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucCQThu(pn, pMap);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucCQThu> queryListCQThu(Map pMap) throws Exception {
		return this.cBTQlyDMucService.queryListCQThu(pMap);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucTKNSNN> queryDMucTKNSNN(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucTKNSNN(pn, pMap);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucNDKT> queryDMucNDKT(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucNDKT(pn, pMap);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucNgayNghi> queryDMucNgayNghi(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucNgayNghi(pn, pMap);
	}

	public void addDMucNgayNghi(DanhMucNgayNghi dmNgayNghi) throws Exception {
		this.cBTQlyDMucService.addDMucNgayNghi(dmNgayNghi);
	}

	public List<DanhMucNgayNghi> queryListDMucNgayNghi(
			DanhMucNgayNghi dmNgayNghi) throws Exception {
		return this.cBTQlyDMucService.queryListDMucNgayNghi(dmNgayNghi);
	}
	
	public int countNgayNghi (DanhMucNgayNghi dmNgayNghi) throws Exception{
		return this.cBTQlyDMucService.countNgayNghi(dmNgayNghi);
	}

	public void modifyDMucNgayNghi(DanhMucNgayNghi dmNgayNghi) throws Exception {
		this.cBTQlyDMucService.modifyDMucNgayNghi(dmNgayNghi);
	}

	public void removeDMucNgayNghi(int id) throws Exception {
		this.cBTQlyDMucService.removeDMucNgayNghi(id);
	}

	@SuppressWarnings({ "rawtypes" })
	public List<DanhMucThamSoHT> queryDMucThamSoHT(Pagination pn, Map pMap)
			throws Exception {
		return this.cBTQlyDMucService.queryCBTDMucThamSoHT(pn, pMap);
	}

	public List<DanhMucThamSoHT> queryListDMucThamSoHT(
			DanhMucThamSoHT dmThamSoHT) throws Exception {
		return this.cBTQlyDMucService.queryListDMucThamSoHT(dmThamSoHT);
	}

	public void addDMucThamSoHT(DanhMucThamSoHT dmThamSoHT) throws Exception {
		this.cBTQlyDMucService.addDMucThamSoHT(dmThamSoHT);
	}

	public void modifyDMucThamSoHT(DanhMucThamSoHT dmThamSoHT) throws Exception {
		this.cBTQlyDMucService.modifyDMucThamSoHT(dmThamSoHT);
	}

	public void removeDMucThamSoHT(String maThamSo) throws Exception {
		this.cBTQlyDMucService.removeDMucThamSoHT(maThamSo);
	}

	public List<CatalogueNotification> queryListCatalogueNotification(
			CatalogueNotification catalogueNotification) throws Exception {
		return this.cBTQlyDMucService
				.queryListCatalogueNotification(catalogueNotification);
	}

	public List<DanhMucCQT> queryDMucCQT(DanhMucCQT danhMucCQT)
			throws Exception {
		return this.cBTQlyDMucService.queryDMucCQT(danhMucCQT);
	}

	public DanhMucCQT queryCQTByMaCQT(Map map) throws Exception {
		return this.cBTQlyDMucService.queryCQTByMaCQT(map);
	}
	
	public DanhMucCQT queryDMucCQTByMa(String maCQT) throws Exception {
		return this.cBTQlyDMucService.queryDMucCQTByMa(maCQT);
	}	

	public List<DanhMucTVAN> queryDSachVan() throws Exception {
		return this.cBTQlyDMucService.queryDSachVan();
	}

	public DanhMucTVAN getTVAN(String id) throws Exception {
		return this.cBTQlyDMucService.getTVAN(id);
	}

	public List<DanhMucTThaiCTu> queryListDMucTThaiCTu(DanhMucTThaiCTu tthai)
			throws Exception {
		return this.cBTQlyDMucService.queryListDMucTThaiCTu(tthai);
	}

	public List<DanhMucBCao> queryListDMucBCao(DanhMucBCao dmucBCao)
			throws Exception {
		return this.cBTQlyDMucService.queryDMucBCao(dmucBCao);
	}

	public List<DanhMucCQT> queryDMucCQTByMaTinh(DanhMucCQT danhMucCQT)
			throws Exception {
		return this.cBTQlyDMucService.queryDMucCQTByMaTinh(danhMucCQT);
	}

	public List<DanhMucCQT> queryListCQT(DanhMucCQT danhMucCQT)
			throws Exception {
		return this.cBTQlyDMucService.queryListCQT(danhMucCQT);
	}

	public List<DanhMucTVAN> queryVanActive() throws Exception {
		return this.cBTQlyDMucService.queryVanActive();
	}
	
	public List<DanhMucCQT> queryCQTForStatisticReport()
			throws Exception {
		return this.cBTQlyDMucService.queryCQTForStatisticReport();
	} 
	
	public List<DanhMucCQT> queryCCTForStatisticReport(Map map)
			throws Exception {
		return this.cBTQlyDMucService.queryCCTForStatisticReport(map);
	}
	
	public int countRegisterCondition1(Map map)
			throws Exception {
		return this.cBTQlyDMucService.countRegisterCondition1(map);
	}
	
	public int countRegisterCondition2(Map map)
			throws Exception {
		return this.cBTQlyDMucService.countRegisterCondition2(map);
	}
	
	public int countRegisterCondition3(Map map)
			throws Exception {
		return this.cBTQlyDMucService.countRegisterCondition3(map);
	}
	
	public int countRegisterCondition4(Map map)
			throws Exception {
		return this.cBTQlyDMucService.countRegisterCondition4(map);
	}
	
	public List<DanhMucCQT> queryCQTForGNTReport(Map map)
			throws Exception {
		return this.cBTQlyDMucService.queryCQTForGNTReport(map);
	}
	
	public int countMST(Map map) throws Exception {
		return this.cBTQlyDMucService.countMST(map);
	}
	
	public int countSoGNT(Map map) throws Exception {
		return this.cBTQlyDMucService.countSoGNT(map);
	}
	
	public BigDecimal countTongTien(Map map) throws Exception {
		return this.cBTQlyDMucService.countTongTien(map);
	}
	
	public List<DMucTKhai> queryListDMucTKhai()
			throws Exception {
		return this.cBTQlyDMucService.queryListDMucTKhai();
	}

	public List<ICNDMucTSan> findAllDMucTSan() throws Exception {
		// TODO Auto-generated method stub
		return this.cBTQlyDMucService.findAllDMucTSan();
	}

	public List<ICNTyLe> queryICNTyle(Pagination pn, Map map) throws Exception {
		// TODO Auto-generated method stub
		return this.cBTQlyDMucService.queryICNTyle(pn, map);
	}

	public void insertDMucTyLe(ICNTyLe icnTyLe) throws Exception {
		// TODO Auto-generated method stub
		this.cBTQlyDMucService.insertDMucTyLe(icnTyLe);
	}
	
	public void updateDMucTyLe(ICNTyLe icnTyLe) throws Exception {
		this.cBTQlyDMucService.updateDMucTyLe(icnTyLe);
	}

	public void updateTrangThaiDMucTyLe(ICNTyLe icnTyLe) throws Exception {
		// TODO Auto-generated method stub
		this.cBTQlyDMucService.updateTrangThaiDMucTyLe(icnTyLe);
	}

	public List<BkMapBankGip> findListMapBankGip(BkMapBankGip mapBankGip) throws Exception {
		// TODO Auto-generated method stub
		return this.cBTQlyDMucService.findListMapBankGip(mapBankGip);
	}
}
