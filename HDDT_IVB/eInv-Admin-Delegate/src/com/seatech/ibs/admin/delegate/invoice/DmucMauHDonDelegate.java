package com.seatech.ibs.admin.delegate.invoice;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.invoice.DmucMauHDonService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ics.pojo.TTinMauHDon;

public class DmucMauHDonDelegate {
	DmucMauHDonService dmucMauHDonService;

	public DmucMauHDonDelegate() {

		try {
			dmucMauHDonService = (DmucMauHDonService) WebApplicationContextUtils
					.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext())
					.getBean("dmucMauHDonService");
		} catch (Exception e) {
			try {
				dmucMauHDonService = (DmucMauHDonService) SpringBeanDelegate.getBean("dmucMauHDonService");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// Lay danh muc Mau so Hoa Don
	public List<TTinMauHDon> getDmucMauHDon(String invType) throws Exception {
		try {
			return dmucMauHDonService.getDmucMauHDon(invType);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// Lay danh muc Mau so Hoa Don
	public List<TTinMauHDon> getKHieuHD(String mauHD) throws Exception {
		try {
			return dmucMauHDonService.getKHieuHD(mauHD);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
