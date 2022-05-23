package com.seatech.ibs.admin.delegate.tkhai;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import vn.com.msb.otpcalculator.OtpICN;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.dmucTkhai.DMucTKhai;
import com.seatech.ibs.admin.pojo.dmucTkhai.DSachBKe;
import com.seatech.ibs.admin.pojo.dmucTkhai.DSachTKhai;
import com.seatech.ibs.admin.pojo.dmucTkhai.TKhaiFileContent;
import com.seatech.ibs.admin.pojo.dmucTthai.DMucTThai;
import com.seatech.ibs.admin.pojo.etaxcn.DMucCqtCN;
import com.seatech.ibs.admin.pojo.etaxcn.DMucCqthu;
import com.seatech.ibs.admin.pojo.etaxcn.DSachBKeCN;
import com.seatech.ibs.admin.pojo.etaxcn.DSachTBaoCN;
import com.seatech.ibs.admin.pojo.etaxcn.DSachTKhaiCN;
import com.seatech.ibs.admin.pojo.etaxcn.ETaxCnUserInfo;
import com.seatech.ibs.admin.pojo.etaxcn.FileContent;
import com.seatech.ibs.admin.pojo.etaxcn.TBaoThue;
import com.seatech.ibs.admin.pojo.etaxcn.TBaoThueBufferCn;
import com.seatech.ibs.admin.pojo.hoanthue.DKyHoanThue;
import com.seatech.ibs.admin.service.tkhai.AdminTKhaiService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.corp.pojo.etax.NNTBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DMucBKeBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DMucLoiBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DMucTBaoBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachHThueBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTBaoBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTBao_ChuaKyBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTKhaiBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.IcnDMucTKhaiBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.IcnDMucTThaiBean;

public class AdminTKhaiDelegate {
    AdminTKhaiService adminTKhaiService = (AdminTKhaiService) WebApplicationContextUtils.getWebApplicationContext(
            HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminTKhaiService");

    @SuppressWarnings("rawtypes")
    public HashMap getDMucLoi() throws Exception {
        return adminTKhaiService.getDMucLoi();
    }

    public List<DMucLoiBean> getById_Tkhai(String id_tkhai) throws Exception {
        return adminTKhaiService.getById_Tkhai(id_tkhai);
    }

    public List<DMucTThai> findAllTThai() throws Exception {
        return this.adminTKhaiService.findAllTThai();
    }

    public List<DMucTKhai> findAllTKhai() throws Exception {
        return this.adminTKhaiService.findAllTKhai();
    }

    public List<DMucTKhai> findAllTKhai(Map map) throws Exception {
        return this.adminTKhaiService.findAllTKhai(map);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachTKhai> findDSachTKhai(Pagination pn, Map map) throws Exception {
        return this.adminTKhaiService.findDSachTKhai(pn, map);
    }

    public String getRegRinTestTVAN() throws Exception {
        return this.adminTKhaiService.getRegRinTestTVAN();
    }

    @SuppressWarnings("rawtypes")
    public List<DSachTKhai> findAllDSachTKhai(Map map) throws Exception {
        return this.adminTKhaiService.findAllDSachTKhai(map);
    }

    public DSachTKhaiBean downTkhai(DSachTKhaiBean bean) throws Exception {
        return this.adminTKhaiService.downTkhai(bean);
    }

    public List<DMucTBaoBean> findALlDmucTBao() throws Exception {
        return this.adminTKhaiService.findALlDmucTBao();
    }

    @SuppressWarnings("rawtypes")
    public List<DSachTBaoBean> findDSachTBao(Pagination pn, Map aMap) throws Exception {
        return this.adminTKhaiService.findDSachTBao(pn, aMap);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachBKe> findDSachBKe(Map aMap) throws Exception {
        return this.adminTKhaiService.findDSachBKe(aMap);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachBKe> findAllDSachBKe(Map aMap) throws Exception {
        return this.adminTKhaiService.findAllDSachBKe(aMap);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachTKhai> findDSachTKhaiDLT(Pagination pn, Map aMap) throws Exception {
        return this.adminTKhaiService.findDSachTKhaiDLT(pn, aMap);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachTKhai> findAllDSachTKhaiDLT(Map aMap) throws Exception {
        return this.adminTKhaiService.findAllDSachTKhaiDLT(aMap);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachBKe> findDSachBKeDLT(Map aMap) throws Exception {
        return this.adminTKhaiService.findDSachBKeDLT(aMap);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachBKe> findAllDSachBKeDLT(Map aMap) throws Exception {
        return this.adminTKhaiService.findAllDSachBKeDLT(aMap);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachTBaoCN> findDSachTBaoCN(Pagination pn, Map aMap) throws Exception {
        return this.adminTKhaiService.findDSachTBaoCN(pn, aMap);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachTKhaiCN> findDSachTKhaiCN(Pagination pn, Map map) throws Exception {
        return this.adminTKhaiService.findDSachTKhaiCN(pn, map);
    }

    @SuppressWarnings("rawtypes")
    public List<ETaxCnUserInfo> findListAccountCN(Pagination pn, Map aMap) throws Exception {
        return this.adminTKhaiService.findListAccountCN(pn, aMap);
    }

    public void updateUserInfoRetail(ETaxCnUserInfo userInfo) throws Exception {
        this.adminTKhaiService.updateUserInfoRetail(userInfo);
    }

    public DSachTKhaiCN findFileContentCNByTblId(String tblId) throws Exception {
        return this.adminTKhaiService.findFileContentCNByTblId(tblId);
    }

    public void updatePwdUserInfoRetail(ETaxCnUserInfo userInfo) throws Exception {
        this.adminTKhaiService.updatePwdUserInfoRetail(userInfo);
    }

    @SuppressWarnings("rawtypes")
    public List<TKhaiFileContent> downTKhaiContent(Map aMap) throws Exception {
        return this.adminTKhaiService.downTKhaiContent(aMap);
    }

    public DMucBKeBean getFile_format(Map ttinBke) throws Exception {
        return this.adminTKhaiService.getFile_format(ttinBke);
    }

    public DMucBKeBean downBke(Map ttinBke) throws Exception {
        return this.adminTKhaiService.downBke(ttinBke);
    }

    @SuppressWarnings("rawtypes")
    public List<TKhaiFileContent> downTBaoContent(Map aMap) throws Exception {
        return this.adminTKhaiService.downTBaoContent(aMap);
    }

    public DSachTKhai getTKhaiById(long idTkhai) throws Exception {
        return this.adminTKhaiService.getTKhaiById(idTkhai);
    }

    public NNTBean getTaxPayerInfo(String tin) throws Exception {
        return this.adminTKhaiService.getTaxPayerInfo(tin);
    }

    public void insertTKhaiXMLBuffer(DSachTKhai dsachTkhai) throws Exception {
        adminTKhaiService.insertTKhaiXMLBuffer(dsachTkhai);
    }

    public void updateTThaiTKhai(DSachTKhai dsachTkhai) throws Exception {
        adminTKhaiService.updateTThaiTKhai(dsachTkhai);
    }

    public String getMaECMTKhai(long idTkhai) throws Exception {
        return adminTKhaiService.getMaECMTKhai(idTkhai);
    }

    public String getMaECMTBao(long idTBao) throws Exception {
        return adminTKhaiService.getMaECMTBao(idTBao);
    }

    public String getMaECMBKe(long idBKe) throws Exception {
        return adminTKhaiService.getMaECMBKe(idBKe);
    }

    public String getMaECMHoSo(long idHSo) throws Exception {
        return adminTKhaiService.getMaECMHoSo(idHSo);
    }

    // Truonglm
    public DSachTBaoCN downLoadXml(String id) throws Exception {
        return adminTKhaiService.downLoadXml(id);
    }

    public List<IcnDMucTKhaiBean> getListDMucTKhai() throws Exception {
        return adminTKhaiService.getListDMucTKhai();
    }

    public List<IcnDMucTThaiBean> getListDMucTThai() throws Exception {
        return adminTKhaiService.getListDMucTThai();
    }

    @SuppressWarnings("rawtypes")
    public List<DSachTKhaiCN> findDSachTKhaiTTS(Pagination pn, Map map) throws Exception {
        return adminTKhaiService.findDSachTKhaiTTS(pn, map);
    }

    public List<DSachTKhaiCN> findDSachTKhaiTTS(Map map) throws Exception {
        return adminTKhaiService.findDSachTKhaiTTS(map);
    }

    public List<DMucTBaoBean> findALlDmucTBaoCN() throws Exception {
        return adminTKhaiService.findALlDmucTBaoCN();
    }

    public List<DSachTKhaiCN> getDSachBKeCn() throws Exception {
        return adminTKhaiService.getDSachBKeCn();
    }

    public DSachTKhaiCN downloaXmlBKe(String id) throws Exception {
        return adminTKhaiService.downloaXmlBKe(id);
    }

    public DSachBKeCN getFileFormatBKe(String id) throws Exception {
        return adminTKhaiService.getFileFormatBKe(id);
    }

    public DMucCqtCN getMaCqt(String tenTat) throws Exception {
        return adminTKhaiService.getMaCqt(tenTat);
    }

    public List<DSachTKhaiCN> findDSachTKhaiCnByMaHDong(Pagination pn, Map map) throws Exception {
        return adminTKhaiService.findDSachTKhaiCnByMaHDong(pn, map);
    }

    public void insertUser(TBaoThueBufferCn tBaoBuffer) throws Exception {
        adminTKhaiService.insertUser(tBaoBuffer);
    }

    public List<ETaxCnUserInfo> findListAccountNNTCN(Pagination pn, Map pMap) throws Exception {
        return adminTKhaiService.findListAccountNNTCN(pn, pMap);
    }

    public ETaxCnUserInfo selectUserInfoCount(Map map) throws Exception {
        return adminTKhaiService.selectUserInfoCount(map);
    }

    public DMucCqthu getDmucbyMacqthu(String macqthu) throws Exception {
        return adminTKhaiService.getDmucbyMacqthu(macqthu);
    }

    public void insertResgiterUser(ETaxCnUserInfo userInfo) throws Exception {
        adminTKhaiService.insertResgiterUser(userInfo);
    }

    public void updateStatusRegister(ETaxCnUserInfo userInfo) throws Exception {
        adminTKhaiService.updateStatusRegister(userInfo);
    }

    public BigDecimal insertTBaoThue(TBaoThue tbao) throws Exception {
        return adminTKhaiService.insertTBaoThue(tbao);
    }

    public Date getSysDate() throws Exception {
        return adminTKhaiService.getSysDate();
    }

    public void updateStatusUserInfo(ETaxCnUserInfo userInfo) throws Exception {
        adminTKhaiService.updateStatusUserInfo(userInfo);
    }

    public ETaxCnUserInfo getUserInfoByUserName(String pUserName) throws Exception {
        return adminTKhaiService.getUserInfoByUserName(pUserName);
    }

    public String getNoidung(String ma) throws Exception {
        return adminTKhaiService.getNoidung(ma);
    }

    public BigDecimal insertRetailOtp(OtpICN _otp) throws Exception {
        return adminTKhaiService.insertRetailOtp(_otp);
    }

    @SuppressWarnings("rawtypes")
    public FileContent getMaEcm(Map map) throws Exception {
        return adminTKhaiService.getMaEcm(map);
    }

    @SuppressWarnings("rawtypes")
    public List<ETaxCnUserInfo> findListAccountTaoTKCn(Pagination pn, Map pMap) throws Exception {
        return adminTKhaiService.findListAccountTaoTKCn(pn, pMap);
    }

    public DSachTBaoCN downLoadXmlByTin(String tin) throws Exception {
        return adminTKhaiService.downLoadXmlByTin(tin);
    }

    @SuppressWarnings("rawtypes")
    public List<DSachHThueBean> queryListTKhaiHThuePagination(HashMap listTKhaiHThue, Pagination pn) throws Exception {
        return adminTKhaiService.queryListTKhaiHThuePagination(listTKhaiHThue, pn);
    }

    public DSachHThueBean downTkhai(DSachHThueBean bean) throws Exception {
        return adminTKhaiService.downTkhai(bean);
    }

    @SuppressWarnings("rawtypes")
    public List<DKyHoanThue> findListDSachHThue(Pagination pn, Map map) throws Exception {
        return adminTKhaiService.findListDSachHThue(pn, map);
    }

    public DSachTKhaiBean getTkhai(DSachTKhaiBean bean) throws Exception {
        return adminTKhaiService.getTkhai(bean);
    }
    
    public DSachTKhaiBean getTKhaiByID(String id) throws Exception {
        return adminTKhaiService.getTKhaiByID(id);
    }

    public long getMaGDichDTu() throws Exception {
        return adminTKhaiService.getMaGDichDTu();
    }

    public DMucBKeBean getBKeTheoMa(String maBKe) throws Exception {
        return adminTKhaiService.getBKeTheoMa(maBKe);
    }
    
    public void insertTBaoChuaKy (DSachTBao_ChuaKyBean tbao) throws Exception{
    	 adminTKhaiService.insertTBaoChuaKy(tbao);
    }
    public DMucTBaoBean queryDMucTBaoCN(String maTBao) throws Exception {
    	return adminTKhaiService.queryDMucTBaoCN(maTBao);
    }
    public DSachTBao_ChuaKyBean downLoadXmlChuaKyByTin(String tin) throws Exception {
    	return adminTKhaiService.downLoadXmlChuaKyByTin(tin);
    }
    
    public long getMaGDichDTu(String app_key) throws Exception {
        return adminTKhaiService.getMaGDichDTu(app_key);
    }
}
