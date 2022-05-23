package com.seatech.ibs.admin.delegate.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.customermanagement.BBUserInfo;
import com.seatech.ibs.admin.service.invoice.LapHoaDonService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ics.pojo.IccInv;
import com.seatech.ics.pojo.IccInvCategory;
import com.seatech.ics.pojo.IccInvHdr;
import com.seatech.ics.pojo.IccInvHdrReport;
import com.seatech.ics.pojo.PortalInvoiceDtlTbao;
import com.seatech.ics.pojo.PortalInvoiceHdrTbao;
import com.seatech.ics.pojo.TTinChungNNT;
import com.seatech.ics.pojo.Tracuutbao;

public class LapHoaDonDelegate {
	LapHoaDonService  lapHoaDonService ;
	public LapHoaDonDelegate(){

		try{
		  lapHoaDonService = (LapHoaDonService) WebApplicationContextUtils
				.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
						.getServletContext()).getBean("lapHoaDonService");
		}catch(Exception e){
			try {
				lapHoaDonService = (LapHoaDonService) SpringBeanDelegate.getBean("lapHoaDonService");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public Collection getDmucHoaDon() throws Exception{
		try {
			return lapHoaDonService.getDmucHoaDon();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String getSoHDon(HashMap map){
		String soHDon = "";
		soHDon = lapHoaDonService.getSoHDon( map);
		return soHDon;
	}

	public long insertLapHoaDonHdr(IccInvHdr iccInv) throws Exception{
		 return lapHoaDonService.insertLapHoaDonHdr(iccInv);
	}

	public void saveBNhapHoaDon(IccInvHdr iccInv)throws Exception{
		try {
			 lapHoaDonService.saveBNhapHoaDon(iccInv);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public byte[] getContentBNhapHoaDon(IccInvHdr iccInv)throws Exception{
		try {
			 return lapHoaDonService.getContentBNhapHoaDon(iccInv);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public IccInv getSoHoaDonObj(Map mapVal) throws Exception {
		return lapHoaDonService.getSoHoaDonObj(mapVal);
	}
	public PortalInvoiceHdrTbao getSoTBaoObj(Map mapVal) throws Exception {
		return lapHoaDonService.getSoTBaoObj(mapVal);
	}
	public void deleteBNhap(IccInvHdr iccInv)throws Exception{
		try {
			 lapHoaDonService.deleteBNhap(iccInv);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void insertContentHDon (IccInvHdr iccInv)throws Exception{
		try {
			  lapHoaDonService.insertContentHDon(iccInv);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateHoaDonHdr (IccInvHdr iccInvHdr) throws Exception{
		try {
			 lapHoaDonService.updateHoaDonHdr(iccInvHdr);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void insertContentHDonReceive (IccInvHdr iccInvHdr) throws Exception{
		try {
			 lapHoaDonService.insertContentHDonReceive(iccInvHdr);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	public IccInvCategory getByMaHoaDon (String maHoaDon) throws Exception{
		try {
			 return lapHoaDonService.getByMaHoaDon(maHoaDon);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void updateLuuHoaDonHdr(IccInvHdr iccInv) throws Exception{
		try {
			  lapHoaDonService.updateLuuHoaDonHdr(iccInv);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public void updateContentHDon(IccInvHdr iccInv) throws Exception{
		try {
			  lapHoaDonService.updateContentHDon(iccInv);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public BBUserInfo checkCreateByOfUserId(HashMap hmap) throws Exception{
		try {
			return  lapHoaDonService.checkCreateByOfUserId(hmap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public int getAllIccInvCountPortal(HashMap map) throws Exception{
		try {
			return  lapHoaDonService.getAllIccInvCountPortal(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public ArrayList<IccInvHdr> getAllIccInvHdr(HashMap hmap) throws Exception{
		try {
			return  lapHoaDonService.getAllIccInvHdr(hmap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void deleteIccInvHdrById(HashMap hmap) throws Exception{
		try {
			  lapHoaDonService.deleteIccInvHdrById(hmap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void deleteIccInvContentById(HashMap hmap) throws Exception{
		try {
			  lapHoaDonService.deleteIccInvContentById(hmap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<IccInvHdr> getDanhSachHoaDon(Map mapVal,Pagination pn) throws Exception{
		try {
			 return lapHoaDonService.getDanhSachHoaDon(mapVal,pn);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public byte[] getContentHoaDon(Map mapVal) throws Exception{
		try {
			 return lapHoaDonService.getContentHoaDon(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public IccInvHdr getIccInvHdrAllProperties(IccInvHdr iccinv) throws Exception{
		try {
			 return lapHoaDonService.getIccInvHdrAllProperties(iccinv);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateTrangThaiHDonBiTThe(Map<String, String> mapValue)  throws Exception{
		try {
			 lapHoaDonService.updateTrangThaiHDonBiTThe(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String getNgayLapHDonGocStr(Map<String, String> mapValue) throws Exception{
		// TODO Auto-generated method stub
		try {
			 return lapHoaDonService.getNgayLapHDonGocStr(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean checkExistsReplacing(Map<String, String> mapValue) throws Exception{
		try {
			 return lapHoaDonService.checkExistsReplacing(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ArrayList<String> getTypeOfBill() throws Exception {
		try {

			return lapHoaDonService.getTypeOfBill();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<IccInvHdr> getListContentHoaDon(Map<String, Object> params) throws Exception {
		try {

			return lapHoaDonService.getListContentHoaDon(params);
		} catch (Exception e) {
			throw e;
		}
	}

	public void deleteListHoadonContent(Map map) throws Exception {
		try {

			 lapHoaDonService.deleteListHoadonContent(map);
		} catch (Exception e) {
			throw e;
		}
	}

	public void deleteListHoadon(Map map) throws Exception {
		try {

			 lapHoaDonService.deleteListHoadon(map);
		} catch (Exception e) {
			throw e;
		}
	}

	public long insertLapHdrTbao(PortalInvoiceHdrTbao portalInvoiceHdrTbao) throws Exception{
		 return lapHoaDonService.insertLapHdrTbao(portalInvoiceHdrTbao);
	}

	public void insertContentHdrTbao (PortalInvoiceHdrTbao portalInvoiceHdrTbao)throws Exception{
		try {
			  lapHoaDonService.insertContentHdrTbao(portalInvoiceHdrTbao);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void updateLuuHdrTbao(PortalInvoiceHdrTbao portalInvoiceHdrTbao) throws Exception{
		try {
			  lapHoaDonService.updateLuuHdrTbao(portalInvoiceHdrTbao);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public void updateContentTbao(PortalInvoiceHdrTbao portalInvoiceHdrTbao) throws Exception{
		try {
			  lapHoaDonService.updateContentTbao(portalInvoiceHdrTbao);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public int getAllIccInvAdjustmentCount(Map<String, Object> mapValue) throws Exception{
		try {
			 return lapHoaDonService.getAllIccInvAdjustmentCount(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public long insertInvDtlTbao (PortalInvoiceDtlTbao portalInvoiceDtlTbao)throws Exception{
		try {
			  return lapHoaDonService.insertInvDtlTbao(portalInvoiceDtlTbao);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public List<IccInvHdr> getAllIccInvAdjustment(Map<String, Object> mapValue) throws Exception{
		try {
			 return lapHoaDonService.getAllIccInvAdjustment(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	//Kiem tra bo ky hieu hoa don giay
	public List<IccInvHdr> getAllIccInvAdjustmentForPaper(Map<String, Object> mapValue) throws Exception{
		try {
			 return lapHoaDonService.getAllIccInvAdjustmentForPaper(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public IccInvHdr getContentReceived(Map mapVal) throws Exception{
		try {
			 return lapHoaDonService.getContentReceived(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<IccInvHdr> getListContentReceived(Map<String, Object> params) throws Exception {
		try {

			return lapHoaDonService.getListContentReceived(params);
		} catch (Exception e) {
			throw e;
		}
	}
	 // Seatech DanLV 24/10/2017 update start
    public boolean checkExistsTbaoXoaBo(Map<String, String> mapValue) throws Exception {
        try {
            return lapHoaDonService.checkExistsTbaoXoaBo(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<IccInvHdr> getAllIccInvHdrReplace(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.getAllIccInvHdrReplace(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void insertContentTbaoReceive(PortalInvoiceHdrTbao portalInvoiceHdrTbao) throws Exception {
        try {
            lapHoaDonService.insertContentTbaoReceive(portalInvoiceHdrTbao);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<IccInvHdr> getAllIccInvHdrRemove(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.getAllIccInvHdrRemove(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.seatech.ibs.corp.service.ics.laphoadon.LapHoaDonService#getIccInvHdrSellerReport(java.util.Map)
     */
    public List<IccInvHdr> getIccInvHdrSellerReport(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.getIccInvHdrSellerReport(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.seatech.ibs.corp.service.ics.laphoadon.LapHoaDonService#totalIccInvHdrSellerReport(java.util.Map)
     */
    public List<IccInvHdrReport> totalIccInvHdrSellerReport(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.totalIccInvHdrSellerReport(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.seatech.ibs.corp.service.ics.laphoadon.LapHoaDonService#countIccInvHdrSellerReport(java.util.Map)
     */
    public Integer countIccInvHdrSellerReport(Map<String, Object> mapValue) throws Exception {
        // TODO Auto-generated method stub
        return lapHoaDonService.countIccInvHdrSellerReport(mapValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.seatech.ibs.corp.service.ics.laphoadon.LapHoaDonService#sumTotalIccInvHdrSellerReport(java.util.Map)
     */
    public BigDecimal sumTotalIccInvHdrSellerReport(Map<String, Object> mapValue) throws Exception {
        // TODO Auto-generated method stub
        return lapHoaDonService.sumTotalIccInvHdrSellerReport(mapValue);
    }

    public List<IccInvHdr> getAllIccInvHdrSellerReport(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.getAllIccInvHdrSellerReport(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    public List<IccInvHdr> getAllIccInvHdrSellerReport1(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.getAllIccInvHdrSellerReport1(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    public List<IccInvHdr> getAllIccInvHdrBuyerReport(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.getAllIccInvHdrBuyerReport(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    public List<Tracuutbao> getQueryNotiTax(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.getQueryNotiTax(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    public List<Tracuutbao> getContentxml(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.getContentxml(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    public List<PortalInvoiceDtlTbao> ckeckkey(Map<String, Object> mapValue) throws Exception {
        try {
            return lapHoaDonService.ckeckkey(mapValue);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    // Seatech DanLV 24/10/2017 update end
	public String getContentTbao(PortalInvoiceHdrTbao portalInvoiceHdrTbao)throws Exception{
		try {
			 return lapHoaDonService.getContentTbao(portalInvoiceHdrTbao);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateTbaoHdr(PortalInvoiceHdrTbao portalInvoiceHdrTbao) throws Exception{
		try {
			  lapHoaDonService.updateTbaoHdr(portalInvoiceHdrTbao);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public IccInvHdr getHoadonGoc(Map<String, String> mapVal) throws Exception{
		try {
			  return lapHoaDonService.getHoadonGoc(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public void updateHdrDtlTbao(PortalInvoiceDtlTbao portalInvoiceDtlTbao) throws Exception{
		try {
			  lapHoaDonService.updateHdrDtlTbao(portalInvoiceDtlTbao);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public void updateSoHDDnghiep(Map mapVal) throws Exception{
		try {
			  lapHoaDonService.updateSoHDDnghiep(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public void updateSoTBaoDnghiep(Map mapVal) throws Exception{
		try {
			  lapHoaDonService.updateSoTBaoDnghiep(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public List<IccInvHdr> getAllIccInvHdrAdjustIdent(Map mapForQueryIccPorTal) throws Exception{
		try {
			return  lapHoaDonService.getAllIccInvHdrAdjustIdent(mapForQueryIccPorTal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public IccInvHdr getID_by_MGD(String mgd) throws Exception {
		// TODO Auto-generated method stub
		try{
			return lapHoaDonService.getID_by_MGD(mgd);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	public void insertPORTAL_MSG_CBT_RECEIVE_CONTENT(Tracuutbao tracuutbao) throws Exception {
		try{
			 lapHoaDonService.insertPORTAL_MSG_CBT_RECEIVE_CONTENT(tracuutbao);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	public int getById_NguoiLap(HashMap<String, Object> hashMap) throws Exception {
		try{
			return lapHoaDonService.getById_NguoiLap(hashMap);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

    public boolean checkTrungHDonGiay(IccInvHdr iccInvHdr) throws Exception {
        // TODO Auto-generated method stub
        return lapHoaDonService.checkTrungHDonGiay(iccInvHdr);
    }

	public int checkKeyHDG(HashMap<String, Object> hashMap) throws Exception{
		try{
			return lapHoaDonService.checkKeyHDG(hashMap);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	//quyen vx lay danh sach ngan hang
	@SuppressWarnings("rawtypes")
	public Collection getDSachNHang() throws Exception{
		try {
			return lapHoaDonService.getDSachNHang();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public ArrayList<TTinChungNNT> listOfNnt(HashMap map) throws Exception {
		// TODO Auto-generated method stub
		try {
			return lapHoaDonService.listOfNNT(map);
		} catch (Exception e) {
			throw e;
		}
	}

	//Danh muc khach hang
	public ArrayList<TTinChungNNT> listKH(HashMap map) throws Exception {
		// TODO Auto-generated method stub
		try {
			return lapHoaDonService.listKH(map);
		} catch (Exception e) {
			throw e;
		}
	}

	//List code khach hang
	@SuppressWarnings("rawtypes")
	public List<String> listCodeKH(String code) throws Exception {
		try {

			return lapHoaDonService.listCodeKH(code);
		} catch (Exception e) {
			throw e;
		}
	}
	//Lay danh muc Mau so Hoa Don
	@SuppressWarnings("rawtypes")
	public Collection getDmucMauHDon(String invType) throws Exception{
		try {
			return lapHoaDonService.getDmucMauHDon(invType);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public IccInvHdr getContentDownloadXml(Map mapVal) throws Exception{
		try {
			 return lapHoaDonService.getContentXml(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
