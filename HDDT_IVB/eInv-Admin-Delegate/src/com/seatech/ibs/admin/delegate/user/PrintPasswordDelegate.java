package com.seatech.ibs.admin.delegate.user;

import java.util.Map;

import com.seatech.ibs.admin.pojo.user.PrintPasswordInfo;
import com.seatech.ibs.admin.service.user.PrintPasswordService;
import com.seatech.ibs.common.util.SpringBeanDelegate;


public class PrintPasswordDelegate {

	public void insert(PrintPasswordInfo passwordInfo) throws Exception {
		PrintPasswordService printService = (PrintPasswordService) SpringBeanDelegate.getBean("adminPrintPasswordService");
		printService.insert(passwordInfo);
	}
	
	public PrintPasswordInfo query(Map<String, Object> map) throws Exception{
		PrintPasswordService printService = (PrintPasswordService) SpringBeanDelegate.getBean("adminPrintPasswordService");
		return printService.query(map);
	}
	
}
