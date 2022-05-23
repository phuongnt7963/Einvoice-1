package com.seatech.ibs.admin.delegate.systemmanagement;

import java.util.List;
import java.util.Map;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.sys.SysParameter;
import com.seatech.ibs.admin.service.systemmanagement.SysSpecialParaService;

public class SystemSpecialParameterDelegate extends DelegateBase {

	
    private static final BTTLog log=BTTLogFactory.getLog(SystemSpecialParameterDelegate.class.getName());
	
	public void changeParameter(SysParameter sysParameter){
			((SysSpecialParaService) this.getBean("sysSpecialParaService")).updateSysParameter(sysParameter);
			log.info("SysSpecialParaService is successful");
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public  SysParameter getSysParameter(Map map) {
		try {
			return ((SysSpecialParaService) this.getBean("sysSpecialParaService")).getSysParameter(map); 
		} catch (Exception e) {
			log.info("SysSpecialParaService is failed");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<SysParameter> groupSysPara() { 
		try {
			return ((SysSpecialParaService) this.getBean("sysSpecialParaService")).groupSysPara(); 
		} catch (Exception e) {
			log.info("SystemSpecialParameterDelegate find sysparamter failed::::::::"); 
			e.printStackTrace();
		}
		return null;  
	}
	
	public List<SysParameter> findSysPara(Map map) { 
		try {
			return ((SysSpecialParaService) this.getBean("sysSpecialParaService")).findSysPara(map); 
		} catch (Exception e) {
			log.info("SystemSpecialParameterDelegate find sysparamter failed::::::::"); 
			e.printStackTrace();
		}
		return null;  
	}
	
	public  SysParameter getSysParameterMB(Map mapMB) {
		try {
			return ((SysSpecialParaService) this.getBean("sysSpecialParaService")).getSysParameterMB(mapMB); 
		} catch (Exception e) {
			log.info("SysSpecialParaService is failed");
			e.printStackTrace();
		}
		return null;
	}
	 
}
