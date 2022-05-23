package com.seatech.ibs.admin.delegate.customermanagement;

import com.ibm.btt.base.BTTServerOperation;
import com.seatech.ibs.admin.pojo.cert.BBCorpCert;
import com.seatech.ibs.admin.pojo.cert.BBCorpCertService;
import com.seatech.ibs.admin.service.customermanagement.NNTInfoService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.corpservice.BbCorpService;
import com.seatech.ibs.corp.pojo.corpservice.BbFileContent;
import com.seatech.ibs.corp.pojo.etax.NNTBean;
import com.seatech.ics.pojo.IccInvTbaoThue;
import com.seatech.ics.pojo.IccInvTbaoThueBuffer;

public class TaxHoaDonInfoDelegate {
	
	public NNTInfoService getNntInfoService() {
		return nntInfoService;
	}
	public void setNntInfoService(NNTInfoService nntInfoService) {
		this.nntInfoService = nntInfoService;
	}

	private NNTInfoService nntInfoService;

	public TaxHoaDonInfoDelegate(){
		  try {
			  nntInfoService = (NNTInfoService) SpringBeanDelegate.getBean("nntInfoService");
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	public NNTBean getTaxHoaDonInfo(String tin) throws Exception {
		return nntInfoService.getTaxHoaDonInfo(tin);
	}
	
	public void execute(BTTServerOperation request, IccInvTbaoThue iccInvTbaoThue, BbCorpService corpService, BBCorpCert corpCert,
			BBCorpCertService corpCertService, BbFileContent bbFileContent, IccInvTbaoThueBuffer iccInvTbaoThueBuffer ) throws Exception{
		nntInfoService.execute(request, iccInvTbaoThue, corpService, corpCert, corpCertService, bbFileContent, iccInvTbaoThueBuffer);
	  }
	
	public byte[] getBbFileContent (BbFileContent bbFileContent)throws Exception {
		return nntInfoService.getBbFileContent(bbFileContent);
	}
}
