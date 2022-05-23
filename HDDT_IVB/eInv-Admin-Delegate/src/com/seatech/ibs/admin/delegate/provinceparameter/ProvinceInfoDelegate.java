package com.seatech.ibs.admin.delegate.provinceparameter;

import java.util.List;
import java.util.Map;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.bank.BankInfo;
import com.seatech.ibs.admin.pojo.province.ProvinceInfo;
import com.seatech.ibs.admin.service.bankparameter.BankInfoService;
import com.seatech.ibs.admin.service.provinceparameter.ProvinceInfoService;
import com.seatech.ibs.common.dto.Pagination;

public class ProvinceInfoDelegate extends DelegateBase {
	private static final BTTLog log = BTTLogFactory.getLog(ProvinceInfoDelegate.class.getName());
	
	@SuppressWarnings("rawtypes")
	public List<ProvinceInfo> findAll(Pagination pagination, Map map) {
		try {
			return ((ProvinceInfoService)this.getBean("provinceInfoService")).findAll(pagination,map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("rawtypes")
	public List<ProvinceInfo> findAll(Map map) {
		try {
			return ((ProvinceInfoService)this.getBean("provinceInfoService")).findAll(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void delete(String id){ 
		try {
			((ProvinceInfoService)this.getBean("provinceInfoService")).delete(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("info delete error::::::::"+e.getMessage());
			}
		} 
	}
	public void insert(ProvinceInfo info) { 
		try {
			((ProvinceInfoService)this.getBean("provinceInfoService")).add(info);
		} catch (Exception e) {
			if(log.doError()){
				log.info("info insert into table error::::::::"+e.getMessage());
			}
		} 
	}
	public void update(ProvinceInfo info){ 
		try {
			((ProvinceInfoService)this.getBean("provinceInfoService")).update(info);
		} catch (Exception e) {
			if(log.doError()){
				log.info("info update error::::::::"+e.getMessage());
			}
		} 
	}
}
