package com.seatech.ibs.admin.delegate.discount;

import java.util.List;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.fee.ServiceFeeGroup;
import com.seatech.ibs.admin.service.fee.CorpFeeGroupService;
import com.seatech.ibs.common.dto.Pagination;

public class CorpFeeGroupDelegate extends DelegateBase {

	public void addCorpFeeGroup(ServiceFeeGroup fg){
		((CorpFeeGroupService)this.getBean("corpFeeGroupService")).add(fg);
	}
	
	public void updateCorpFeeGroup(ServiceFeeGroup fg){
		((CorpFeeGroupService)this.getBean("corpFeeGroupService")).update(fg);
	}
	
	public void deleteCorpFeeGroup(Integer id){
		((CorpFeeGroupService)this.getBean("corpFeeGroupService")).deleteFeeGroup(id);
	}
	 
	public List<ServiceFeeGroup> getAllByCode(String code,Pagination pn){
		return ((CorpFeeGroupService)this.getBean("corpFeeGroupService")).findAllFeeGroup(code, pn);
	}
	
	public ServiceFeeGroup getCorpFeeGroup(Integer id){
		return ((CorpFeeGroupService)this.getBean("corpFeeGroupService")).findFeeGroup(id);
	}

	public ServiceFeeGroup getCorpFeeGroup(String groupName) { 
		return ((CorpFeeGroupService)this.getBean("corpFeeGroupService")).getCorpFeeGroup(groupName);
	}
}
