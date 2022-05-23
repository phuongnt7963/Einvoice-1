package com.seatech.ibs.admin.delegate.customerService;

import java.util.List;
import java.util.Map;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.customer.Customer;
import com.seatech.ibs.admin.service.customerService.RegisterOnlineService;

public class CorpRegisterOnlineDelegate {
	private static final BTTLog log = BTTLogFactory.getLog(CorpRegisterOnlineDelegate.class.getName());

	public void insert(Customer customer) {
		try {
			RegisterOnlineService onlineService = this.getRegisterOnlineServiceBean();
			onlineService.add(customer);
		} catch (Exception e) {
			if (log.doError()) {
				log.info("info insert into table error::::::::" + e.getMessage());
			}
		}
	}


	public List<Customer> queryLogBycondition(Pagination pn,Map<String, Object> queryCondition) throws Exception {
		RegisterOnlineService service = getRegisterOnlineServiceBean();
		return service.queryLogBycondition(pn, queryCondition);
	}


	public void updateStatus(Map<String, Object> map) throws Exception {
		RegisterOnlineService service = getRegisterOnlineServiceBean();
		service.updateStatus(map);
	}


	private RegisterOnlineService getRegisterOnlineServiceBean() throws Exception {
		return (RegisterOnlineService) SpringBeanDelegate.getBean("corpRegisterOnlineService");
	}
}
