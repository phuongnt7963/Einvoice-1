package com.seatech.ibs.admin.delegate.corelog;

import java.util.Map;

import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.core.pojo.log.BKDefError;
import com.seatech.ibs.admin.service.corelog.BKDefErrorService;

public class BKDefErrorDelegate {

	public BKDefErrorDelegate() {
	}
	
	public BKDefError getBKDefError(Map<String, Object> map) throws Exception{
		return getBean().getBKDefError(map);
	}
	
	public BKDefErrorService getBean() throws Exception {
		return (BKDefErrorService) SpringBeanDelegate.getBean("bkDefErrorService");
	}
}
