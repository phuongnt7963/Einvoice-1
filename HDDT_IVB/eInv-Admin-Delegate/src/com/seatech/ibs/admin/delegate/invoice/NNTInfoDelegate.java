package com.seatech.ibs.admin.delegate.invoice;

import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.pojo.qlydanhmuc.DanhMucNganHang;
import com.seatech.ibs.admin.service.customermanagement.NNTInfoService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.corpservice.BbFileContent;
import com.seatech.ibs.corp.pojo.etax.NNTBean;
import com.seatech.ibs.corp.pojo.etax.PhienBanXMLBean;
import com.seatech.ibs.corp.pojo.etax.enumeration.ContractTinBean;
import com.seatech.ics.pojo.IcsProduct;


public class NNTInfoDelegate {
//	NNTInfoService nntInfoService = (NNTInfoService) WebApplicationContextUtils
//			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
//					.getServletContext()).getBean("nntInfoService");

	@SuppressWarnings({ "rawtypes" })
	public NNTBean getTaxPayerInfoByTIN(String tin) throws Exception{
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.getTaxPayerInfoByTIN(tin);
	}
	@SuppressWarnings({ "rawtypes" })
	public DanhMucNganHang queryInfoNganHangByMa(DanhMucNganHang nganHang) throws Exception{
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.queryInfoNganHangByMa(nganHang);
	}
	@SuppressWarnings({ "rawtypes" })
	public int findCorpIdByTaxCode(String tin) throws Exception{
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.findCorpIdByTaxCode(tin);
	}
	@SuppressWarnings({ "rawtypes" })
	public PhienBanXMLBean getPbanXMlInfo() throws Exception{
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.getPbanXMlInfo();
	}

	public NNTBean getTaxPayerInfo(String tin) throws Exception{
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.getTaxPayerInfo(tin);
	}
	public List<ContractTinBean> getMaNThauFromTIN(String tin) throws Exception {
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.getMaNThauFromTIN(tin);
	}
	@SuppressWarnings({ "rawtypes" })
	public int checkTinMV(String tin) throws Exception{
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.checkTinMV(tin);
	}

	@SuppressWarnings({ "rawtypes" })
	public int checkTinDLTMV(Map map) throws Exception{
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.checkTinDLTMV(map);
	}
	public NNTBean getTaxHoaDonInfo(String tin) throws Exception {
		NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
		return nntInfoService.getTaxHoaDonInfo(tin);
	}

	public byte[] getBbFileContent(BbFileContent bbFileContent) throws Exception {
		try{
			NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
			return nntInfoService.getBbFileContent(bbFileContent);
		}catch(Exception e){
			throw e;
		}
	}

    public void updateSellerInfo(NNTBean nNTBean) throws Exception {
        // TODO Auto-generated method stub
        try {
            NNTInfoService nntInfoService = (NNTInfoService) SpringBeanDelegate.getBean("nntInfoService");
            nntInfoService.updateSellerInfo(nNTBean);
        }
        catch (Exception e) {
            throw e;
        }
    }
	public NNTBean getMvTaxInfoByTIN(String mst) throws Exception{
		try {
			NNTInfoService nntInfoService = (NNTInfoService)SpringBeanDelegate.getBean("nntInfoService");
			return nntInfoService.getMvTaxInfoByTIN(mst);
		}
	    catch (Exception e) {
	        throw e;
	    }
	}
}
