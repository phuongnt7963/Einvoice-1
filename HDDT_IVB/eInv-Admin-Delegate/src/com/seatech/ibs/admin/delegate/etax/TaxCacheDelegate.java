package com.seatech.ibs.admin.delegate.etax;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.corp.pojo.etax.TCS_DM_CQTHU;
import com.seatech.ibs.corp.pojo.etax.TCS_DM_KHOBAC;
import com.seatech.ibs.corp.pojo.etax.TCS_DM_LHINH;
import com.seatech.ibs.corp.pojo.etax.TCS_DM_MUC_TMUC;
import com.seatech.ibs.corp.pojo.etax.TCS_DM_NGANHANG;
import com.seatech.ibs.corp.pojo.etax.TCS_DM_XA;
import com.seatech.ibs.admin.service.etax.TaxCacheService;

public class TaxCacheDelegate {

	public static TaxCacheService getTaxCacheBean() {
        return (TaxCacheService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("taxCacheService");
    }


	public static List<TCS_DM_KHOBAC> getKhoBacCache(Map<String, Object> map)throws Exception{
		try {
			return getTaxCacheBean().getKhoBacCache(map);//new ArrayList<TCS_DM_KHOBAC>();
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<TCS_DM_CQTHU> getCQThuCache(Map<String, Object> map)throws Exception{
		try {
			return getTaxCacheBean().getCQThuCache(map);//new ArrayList<TCS_DM_CQTHU>();
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<TCS_DM_XA> getXaCache(Map<String, Object> map)throws Exception{
		try {
			return getTaxCacheBean().getXaCache(map);//new ArrayList<TCS_DM_XA>();
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<TCS_DM_MUC_TMUC> getTieuMucCache(Map<String, Object> map)throws Exception{
		try {
			return getTaxCacheBean().getTieuMucCache(map);//new ArrayList<TCS_DM_MUC_TMUC>();
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<TCS_DM_LHINH> getLHinhCache(Map<String, Object> map)throws Exception{
		try {
			return getTaxCacheBean().getLHinhCache(map);//new ArrayList<TCS_DM_LHINH>();
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<TCS_DM_XA> getXaBy(Map<String, Object> map)throws Exception{
		try {
			return getTaxCacheBean().getXaBy(map);//new ArrayList<TCS_DM_XA>();
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<TCS_DM_NGANHANG> getNganHangCache(Map<String, Object> map)throws Exception{
		try {
			return getTaxCacheBean().getNganHangCache(map);//new ArrayList<TCS_DM_XA>();
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<TCS_DM_NGANHANG> getNganHangMap(String q)throws Exception{
		try {
			return getTaxCacheBean().getNganHangMap(q);//new ArrayList<TCS_DM_XA>();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Load autocommit
	 */
	public static List<TCS_DM_CQTHU> findCQThu(String q)throws Exception{
		try {
			return getTaxCacheBean().findCQThu(q);//new ArrayList<TCS_DM_XA>();
		} catch (Exception e) {
			throw e;
		}
	}
	public static List<TCS_DM_MUC_TMUC> findNdkt(String q)throws Exception{
		try {
			return getTaxCacheBean().findNdkt(q);//new ArrayList<TCS_DM_XA>();
		} catch (Exception e) {
			throw e;
		}
	}
	public static List<TCS_DM_XA> findDbhc(String q)throws Exception{
		try {
			return getTaxCacheBean().findDbhc(q);//new ArrayList<TCS_DM_XA>();
		} catch (Exception e) {
			throw e;
		}
	}
	public static List<TCS_DM_KHOBAC> findShkb(String q)throws Exception{
		try {
			return getTaxCacheBean().findShkb(q);//new ArrayList<TCS_DM_XA>();
		} catch (Exception e) {
			throw e;
		}
	}



}
