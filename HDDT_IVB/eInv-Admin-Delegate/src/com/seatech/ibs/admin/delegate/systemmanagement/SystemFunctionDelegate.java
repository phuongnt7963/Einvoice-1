package com.seatech.ibs.admin.delegate.systemmanagement;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.sys.SysConfig;
import com.seatech.ibs.admin.service.systemmanagement.SystemFunctionService;

public class SystemFunctionDelegate extends DelegateBase{

	public void changeStatus(SysConfig sysCfg){
		((SystemFunctionService)this.getBean("systemFunctionService")).update(sysCfg);
	}
	
	public SysConfig getSysConfig(){
		return ((SystemFunctionService)this.getBean("systemFunctionService")).getSysConfig();
	}
	
	public SysConfig getSysConfigMB(){
		return ((SystemFunctionService)this.getBean("systemFunctionService")).getSysConfigMB();
	}
}
