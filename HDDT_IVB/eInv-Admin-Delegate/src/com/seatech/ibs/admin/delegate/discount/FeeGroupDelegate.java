package com.seatech.ibs.admin.delegate.discount;


import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.fee.FeeMaintain;
import com.seatech.ibs.admin.pojo.fee.FeeQuery;
import com.seatech.ibs.admin.pojo.fee.FeeServiceQuery;
import com.seatech.ibs.admin.pojo.fee.ServiceFeeGroup;
import com.seatech.ibs.admin.service.fee.FeeGroupNameExistedException;
import com.seatech.ibs.admin.service.fee.FeeGroupNotFoundException;
import com.seatech.ibs.admin.service.fee.FeeGroupRelatedException;
import com.seatech.ibs.admin.service.fee.FeeGroupService;
import com.seatech.ibs.common.constant.AdminAppConstant;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.dao.exception.IBSDataAccessException;
import com.seatech.ibs.service.exception.IBSServiceException;

public class FeeGroupDelegate  {
	
	public List<FeeQuery> actionFeeQuery(FeeQuery feeQuery) throws  IBSServiceException{
		FeeGroupService service=this.getFeeGroupBean();
		return service.actionFeeQuery(feeQuery);
	}
	public List<FeeServiceQuery> actionFeeServiceQuery(FeeServiceQuery feeServiceQuery) throws  IBSServiceException{
		FeeGroupService service=this.getFeeGroupBean();
		return service.actionFeeServiceQuery(feeServiceQuery);
	}
	public List<FeeMaintain> actionFeeMaintain(FeeMaintain feeMaintain) throws  IBSServiceException{
		FeeGroupService service=this.getFeeGroupBean();
		return service.actionFeeMaintain(feeMaintain);
	}
	
	public int addFeeGroup(ServiceFeeGroup ServiceFeeGroup) throws FeeGroupNameExistedException,IBSServiceException {
		FeeGroupService service=this.getFeeGroupBean();
		return service.addFeeGroup(ServiceFeeGroup);
	}
	
	public boolean removeFeeGroup(ServiceFeeGroup fee) throws FeeGroupRelatedException,IBSServiceException {
		FeeGroupService service=this.getFeeGroupBean();
		return service.removeFeeGroup(fee);
	}
	public void removeFeeGroup(int id) throws FeeGroupRelatedException,IBSServiceException {
		FeeGroupService service=this.getFeeGroupBean();
		service.removeFeeGroup(id);
	}
	
	public void modifyFeeGroup(ServiceFeeGroup ServiceFeeGroup) throws FeeGroupNotFoundException,FeeGroupNameExistedException,IBSServiceException {
		FeeGroupService service=this.getFeeGroupBean();
		service.modifyFeeGroup(ServiceFeeGroup);
	}
	
    public List<ServiceFeeGroup> queryFeeGroup(Map condition,Pagination pn) throws IBSServiceException {
    	FeeGroupService service= this.getFeeGroupBean();
 	    return service.queryFeeGroup(condition, pn);
	}
    
    public List<ServiceFeeGroup> querySelectiveServiceFeeGroupBySyscode(Map condition,Pagination pn) throws IBSServiceException {
    	FeeGroupService service= this.getFeeGroupBean();
 	    return service.queryFeeGroup(condition, pn);
	}
    
	public ServiceFeeGroup getFeeGroupByID(int id) throws FeeGroupNotFoundException,IBSServiceException {
		FeeGroupService service=this.getFeeGroupBean();
		return service.getFeeGroupById(id);
	}
	
	private FeeGroupService getFeeGroupBean(){
		return  (FeeGroupService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean(AdminAppConstant.SERVICE_FEE_GROUP);
	}
	
	public List<ServiceFeeGroup> getFeeGroupByName(String name) throws IBSDataAccessException {
		FeeGroupService service=this.getFeeGroupBean();
		return service.getFeeGroupByName(name);
	}
	public void feeApproveProcess(Map<String, Object> map) {
		FeeGroupService service=this.getFeeGroupBean();
		service.feeApproveProcess(map);
	}
	
	public List<ServiceFeeGroup> selectServiceFeeGroupBySyscode(Map condition,Pagination pn) throws IBSServiceException {
    	FeeGroupService service= this.getFeeGroupBean();
 	    return service.querySelectiveServiceFeeGroupBySyscode(condition, pn);
	}
	
	public ServiceFeeGroup getFeeGroupApproveById(int id) throws IBSDataAccessException {
		FeeGroupService service=this.getFeeGroupBean();
		return service.getFeeGroupApproveById(id);
	}
	public void deleteDetailBK(Integer processId) throws IBSDataAccessException {
		FeeGroupService service=this.getFeeGroupBean();
		service.deleteDetailBK(processId);
	}
	public void updateFeeGroupBK(ServiceFeeGroup serviceFeeGroup) throws Exception {
		FeeGroupService service=this.getFeeGroupBean();
		service.updateFeeGroupBK(serviceFeeGroup);
	}
	
	public ServiceFeeGroup querySelectiveServiceFeeGroupById(int no) throws IBSDataAccessException {
		FeeGroupService service=this.getFeeGroupBean();
		return service.querySelectiveServiceFeeGroupById(no);
	}
	public List<FeeServiceQuery> actionFeeServiceQueryBK(FeeServiceQuery condition) throws IBSServiceException {
		FeeGroupService service=this.getFeeGroupBean();
		return service.actionFeeServiceQueryBK(condition);
	}
	public List<FeeMaintain> actionFeeMaintainBK(FeeMaintain feeMaintain) {
		FeeGroupService service=this.getFeeGroupBean();
		return service.actionFeeMaintainBK(feeMaintain);
	}
	public ServiceFeeGroup getFeeGroupBKByID(Integer id) throws FeeGroupNotFoundException, IBSServiceException {
		FeeGroupService service=this.getFeeGroupBean();
		return service.getFeeGroupBKById(id);
	}
}
