package com.seatech.ibs.admin.delegate.bankparameter;

import java.util.List;
import java.util.Map;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.bank.BankInfo;
import com.seatech.ibs.admin.service.bankparameter.BankInfoService;
import com.seatech.ibs.common.dto.Pagination;

public class BankInfoDelegate extends DelegateBase {

	private static final BTTLog log = BTTLogFactory.getLog(BankInfoDelegate.class.getName());
	
	public BankInfo getBankInfo(String id){
		try {
			return (BankInfo)((BankInfoService)this.getBean("bankInfoService")).findById(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("info findByInteger from table bk_info error::::::::"+e.getMessage());
			}
		} 
		return null;
	}
	public BankInfo getBankInfoBySmlId(String id){
		try {
			return (BankInfo)((BankInfoService)this.getBean("bankInfoService")).findBySmlId(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("info findByInteger from table bk_info error::::::::"+e.getMessage());
			}
		} 
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public List findAll(){ 
		return ((BankInfoService)this.getBean("bankInfoService")).findAll();
	}
	
	public void delete(String id){ 
		try {
			((BankInfoService)this.getBean("bankInfoService")).delete(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("info delete error::::::::"+e.getMessage());
			}
		} 
	}
	
	
	public void insert(BankInfo info) { 
		try {
			((BankInfoService)this.getBean("bankInfoService")).add(info);
		} catch (Exception e) {
			if(log.doError()){
				log.info("info insert into table error::::::::"+e.getMessage());
			}
		} 
	}
	
	public void update(BankInfo info){ 
		try {
			((BankInfoService)this.getBean("bankInfoService")).update(info);
		} catch (Exception e) {
			if(log.doError()){
				log.info("info update error::::::::"+e.getMessage());
			}
		} 
	}

	@SuppressWarnings("rawtypes")
	public List findAll(Pagination pagination) {
		return ((BankInfoService)this.getBean("bankInfoService")).findAll(pagination);
	}

	@SuppressWarnings("rawtypes")
	public List findAll(Pagination pagination, Map map) {
		return ((BankInfoService)this.getBean("bankInfoService")).findAll(pagination,map);
	}
	
	@SuppressWarnings("rawtypes")
	public List findByAll(Map map) {
		return ((BankInfoService)this.getBean("bankInfoService")).findAll(map);
	}
	
}
