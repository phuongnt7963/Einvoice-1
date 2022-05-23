package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.fee.ServiceFeeGroup;
import com.seatech.ibs.admin.service.customermanagement.FeeGroupRetailServices;
import com.ibm.btt.sm.HttpSessionInfoHolder;


public class FeeGroupRetailDelegate  {
    public List<ServiceFeeGroup> selectFeeGroup() throws RuntimeException {
    	FeeGroupRetailServices service= this.getFeeGroupBean();
 	    return service.selectFeeGroup();
	}
    
	public ServiceFeeGroup getFeeGroup(int id) throws RuntimeException {
		FeeGroupRetailServices service=this.getFeeGroupBean();
		return service.getFeeGroup(id);
	}

	public void deleteServiceFeeGroup(int id) throws RuntimeException {
		FeeGroupRetailServices service=this.getFeeGroupBean();
		service.deleteServiceFeeGroup(id);
	}
	public void addServiceFeeGroup(ServiceFeeGroup bKServiceFeeGroupInfo) throws RuntimeException {
		FeeGroupRetailServices service=this.getFeeGroupBean();
		service.addServiceFeeGroup(bKServiceFeeGroupInfo);
	}

	public void updateServiceFeeGroup(ServiceFeeGroup bKServiceFeeGroupInfo)
			throws RuntimeException {
		FeeGroupRetailServices service=this.getFeeGroupBean();
		service.updateServiceFeeGroup(bKServiceFeeGroupInfo);
	}
	private FeeGroupRetailServices getFeeGroupBean(){
		return  (FeeGroupRetailServices) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("feeGroupRetailServices");
	}
}
