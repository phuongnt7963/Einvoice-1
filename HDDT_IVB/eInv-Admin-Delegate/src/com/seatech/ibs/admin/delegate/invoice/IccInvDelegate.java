package com.seatech.ibs.admin.delegate.invoice;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.invoice.IccInvService;
import com.seatech.ibs.corp.pojo.etax.enumeration.DSachTKhaiBean;
import com.seatech.ics.pojo.IccInv;
import com.seatech.ics.pojo.IccInvDtl;
import com.seatech.ics.pojo.IccInvHdr;

public class IccInvDelegate {

	public static IccInvService getIccInvBean() {
        return (IccInvService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpIccInvService");
    }

	public List<IccInv> getAllIccInv(Map mapVal) throws Exception {
		try {
			return getIccInvBean().getAllIccInv(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IccInvDtl> getIccInvDtl(Map mapVal) throws Exception {
		try {
			return getIccInvBean().getIccInvDtl(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public DSachTKhaiBean downloadIccInvFile(Map mapVal) throws Exception{
		try {
			return getIccInvBean().downloadIccInvFile(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer getAllIccInvCount(Map mapVal) throws Exception{
		try {
			return getIccInvBean().getAllIccInvCount(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//HoanNC - start
	// Dem so luong hoa don co the thay the
	public Integer getAllIccInvReplaceCount(Map mapVal) throws Exception {
		try {
			return getIccInvBean().getAllIccInvReplaceCount(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IccInv> getAllIccInvReplace(Map mapVal) throws Exception {
		try {
			return getIccInvBean().getAllIccInvReplace(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer getAllIccInvAdjustmentCount(Map mapVal) throws Exception {
		try {
			return getIccInvBean().getAllIccInvAdjustmentCount(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<IccInv> getAllIccInvAdjustment(Map mapVal) throws Exception {
		try {
			return getIccInvBean().getAllIccInvAdjustment(mapVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public byte[] getContentHoaDonCore(IccInvHdr icsInvoice) throws Exception {
		try {
			return getIccInvBean().getContentHoaDonCore(icsInvoice);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//HoanNC - end

	//Sondt - start
	public List<IccInvHdr> getListContentHoaDonCore(Map<String, Object> params) throws Exception{
		try{
			return getIccInvBean().getListContentHoaDonCore(params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//Sondt -end

    // Seatech DanLV 12/10/2017 update start
    public List<IccInv> getAllIccInvRemoveFromCore(Map<String, Object> mapVal) throws Exception {
        try {
            return getIccInvBean().getAllIccInvRemoveFromCore(mapVal);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Seatech DanLV 12/10/2017 update end

    public int insertIccInvDtl(List<IccInvDtl> listIccInvDtl) throws Exception {
		try {
			return getIccInvBean().insertIccInvDtl(listIccInvDtl);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
