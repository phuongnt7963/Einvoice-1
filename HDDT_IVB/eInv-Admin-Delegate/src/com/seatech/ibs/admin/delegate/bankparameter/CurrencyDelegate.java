package com.seatech.ibs.admin.delegate.bankparameter;

 
import java.util.List;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.bank.Currucy;
import com.seatech.ibs.admin.service.bankparameter.CurrencyService;
import com.seatech.ibs.common.dto.Pagination;

public class CurrencyDelegate extends DelegateBase{

	private static final BTTLog log = BTTLogFactory.getLog(CurrencyDelegate.class.getName());
	
	public Currucy getCurrency(Integer id){
		try {
			return (Currucy)((CurrencyService)this.getBean("currencyService")).findById(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("currency findByInteger from table bk_currucy error::::::::"+e.getMessage());
			}
		} 
		return null;
	}
	
	public Currucy getCurrency(String id){
		try {
			return (Currucy)((CurrencyService)this.getBean("currencyService")).findById(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("currency findByInteger from table bk_currucy error::::::::"+e.getMessage());
			}
		} 
		return null;
	}
	
	
	public void update(Currucy c){ 
		try {
			((CurrencyService)this.getBean("currencyService")).update(c);
		} catch (Exception e) {
			if(log.doError()){
				log.info("currency update error::::::::"+e.getMessage());
			}
		} 
	}
	
	public void delete(String id){ 
		try {
			((CurrencyService)this.getBean("currencyService")).delete(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("currency delete error::::::::"+e.getMessage());
			}
		} 
	}
	
	@SuppressWarnings("rawtypes")
	public List findAll(){ 
		return ((CurrencyService)this.getBean("currencyService")).findAll();
	}

	public void insert(Currucy c) { 
		try {
			((CurrencyService)this.getBean("currencyService")).add(c);
		} catch (Exception e) {
			if(log.doError()){
				log.info("currency insert into table error::::::::"+e.getMessage());
			}
		} 
	}

	@SuppressWarnings("rawtypes")
	public List findAll(Pagination pn) {
		return ((CurrencyService)this.getBean("currencyService")).findAll(pn);
	}
}
