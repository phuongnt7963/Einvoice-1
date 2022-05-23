package com.seatech.ibs.admin.delegate.invoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.invoice.TaoMauHDonCorpService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.corp.CorpInvTemplate;
import com.seatech.ics.pojo.IccInvTemplateCodeReg;

public class TaoMauHDonCorpDelegate {
	TaoMauHDonCorpService taoMauHDonCorpService;

	public TaoMauHDonCorpDelegate() {

		try {
			taoMauHDonCorpService = (TaoMauHDonCorpService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("taoMauHDonAdminService");
		} catch (Exception e) {
			try {
				taoMauHDonCorpService = (TaoMauHDonCorpService) SpringBeanDelegate.getBean("taoMauHDonAdminService");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void insertMauHDonCorp(CorpInvTemplate corpInvTpl) throws Exception {
		// TODO Auto-generated method stub
		taoMauHDonCorpService.insertMauHDonCorp(corpInvTpl);
	}

	public void updateMauHDonCorp(CorpInvTemplate corpInvTpl) throws Exception {
		// TODO Auto-generated method stub
		taoMauHDonCorpService.updateMauHDonCorp(corpInvTpl);
	}

	public List<IccInvTemplateCodeReg> getIccInvCodeReg(Map<String, Object> mapValue) throws Exception {
		try {
			return taoMauHDonCorpService.getIccInvCodeReg(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<IccInvTemplateCodeReg> getIccInvCodeRegDestroy(Map<String, Object> mapValue) throws Exception {
		try {
			return taoMauHDonCorpService.getIccInvCodeRegDestroy(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<IccInvTemplateCodeReg> getMaxSoHD(Map<String, Object> mapValue) throws Exception {
		try {
			return taoMauHDonCorpService.getMaxSoHD(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<CorpInvTemplate> getIccInvTemplate(Map<String, Object> mapValue) throws Exception {
		try {
			return taoMauHDonCorpService.getIccInvTemplate(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public CorpInvTemplate getImageLogoTemplate(Map mapVal) throws Exception {
		try {
			return taoMauHDonCorpService.getImageLogoTemplate(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public CorpInvTemplate getImageBackgroundTemplate(Map mapVal) throws Exception {
		try {
			return taoMauHDonCorpService.getImageBackgroundTemplate(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void insertIccInvCodeReg(IccInvTemplateCodeReg iccInvTpl) throws Exception {
		try {
			taoMauHDonCorpService.insertIccInvCodeReg(iccInvTpl);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean checkMauvaKHieu(CorpInvTemplate corpInvTpl) throws Exception {
		// TODO Auto-generated method stub
		try {
			return taoMauHDonCorpService.checkMauvaKHieu(corpInvTpl);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateStatusTBPH(HashMap map) throws Exception {
		// TODO Auto-generated method stub
		try {
			taoMauHDonCorpService.updateStatusTBPH(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void removeIccInvCodeReg(IccInvTemplateCodeReg iccInvTpl) throws Exception {
		try {
			taoMauHDonCorpService.removeIccInvCodeReg(iccInvTpl);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateIccInvCodeReg(IccInvTemplateCodeReg iccInvTpl) throws Exception {
		try {
			taoMauHDonCorpService.updateIccInvCodeReg(iccInvTpl);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void removeIccInvTemplate(CorpInvTemplate iccInvTpl) throws Exception {
		try {
			taoMauHDonCorpService.removeIccInvTemplate(iccInvTpl);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateStatusIccInvTemplate(Map<String, Object> mapValue) throws Exception {
		try {
			taoMauHDonCorpService.updateStatusIccInvTemplate(mapValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
