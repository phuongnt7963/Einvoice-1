package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.questionsmanagement.ServiceProvider;
import com.seatech.ibs.admin.service.questionsmanagement.ServiceProviderService;

public class ServiceProviderDelegate extends DelegateBase {
	public List<ServiceProvider> selectByTyAndUserId() throws Exception {
		return ((ServiceProviderService) getBean("serviceProviderService")).selectByTyAndUserId();
	}
	
	public List<ServiceProvider> selectByType(String[] typeId) throws Exception {
		return ((ServiceProviderService) getBean("serviceProviderService")).selectByType(typeId);
	}
	
	public List<ServiceProvider> selectByType1(ServiceProvider serviceProvider) throws Exception {
		return ((ServiceProviderService) getBean("serviceProviderService")).selectByType1(serviceProvider);
	}
}
