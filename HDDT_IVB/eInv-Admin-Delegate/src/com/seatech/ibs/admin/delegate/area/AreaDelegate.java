package com.seatech.ibs.admin.delegate.area;

import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.area.AreaInfo;
import com.seatech.ibs.admin.service.area.AreaService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;

public class AreaDelegate extends DelegateBase{
	public List<AreaInfo> getByParamArea(Pagination pn,Map map) throws Exception{
		AreaService areaService = (AreaService) SpringBeanDelegate.getBean("areaService");
		return areaService.getByParamArea(pn,map);	
	}
	
	public void deleteAreaInfo(String area_code) { 
		try {
			((AreaService)this.getBean("areaService")).deleteAreaInfo(area_code);
		} catch (Exception e) {
					e.getMessage();
			}
		 
	}
	public void insertAreaInfo(AreaInfo areaInfo) { 
		try {
			((AreaService)this.getBean("areaService")).insertAreaInfo(areaInfo);
		} catch (Exception e) {
			 e.getMessage();
			
		} 
	}
	public void updateAreaInfo(AreaInfo areaInfo) { 
		try {
			((AreaService)this.getBean("areaService")).updateAreaInfo(areaInfo);
		} catch (Exception e) {
			 e.getMessage();
			
		} 
	}
}
