package com.seatech.ibs.admin.delegate.bankparameter;

import java.util.List;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.bank.Region;
import com.seatech.ibs.admin.service.bankparameter.RegionService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;

public class RegionDelegate extends DelegateBase {

	private static final BTTLog log = BTTLogFactory.getLog(RegionDelegate.class.getName());
	
	public Region getRegion(Integer id){
		try {
			return (Region)((RegionService)this.getBean("regionService")).findById(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("region findByInteger from table bk_region error::::::::"+e.getMessage());
			}
		} 
		return null;
	}
	
	public Region getRegion(String id){
		try {
			return (Region)((RegionService)this.getBean("regionService")).findById(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("region findByInteger from table bk_region error::::::::"+e.getMessage());
			}
		} 
		return null;
	}
	
	
	public void update(Region c){ 
		try {
			((RegionService)this.getBean("regionService")).update(c);
		} catch (Exception e) {
			if(log.doError()){
				log.info("region update error::::::::"+e.getMessage());
			}
		} 
	}
	
	public void delete(String id){ 
		try {
			((RegionService)this.getBean("regionService")).delete(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("region delete error::::::::"+e.getMessage());
			}
		} 
	}
	
	@SuppressWarnings("rawtypes")
	public List findAll(){ 
		return ((RegionService)this.getBean("regionService")).findAll();
	}

	public void insert(Region region) { 
		try {
			((RegionService)this.getBean("regionService")).add(region);
		} catch (Exception e) {
			if(log.doError()){
				log.info("region insert into table error::::::::"+e.getMessage());
			}
		} 
	}

	@SuppressWarnings("rawtypes")
	public List findAll(Pagination pagination) {
		return  ((RegionService)this.getBean("regionService")).findAll(pagination);
	}
	
    public List<Region> queryRegionDynamic(Region pRegion) throws Exception {
        RegionService aRegionService = (RegionService) SpringBeanDelegate.getBean("regionService");
        return aRegionService.queryRegionDynamic(pRegion);
    }
	
}
