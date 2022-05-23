package com.seatech.ibs.admin.delegate.operationLog;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.pojo.operationLog.OperationLog;
import com.seatech.ibs.admin.service.operationLog.BKOperationLogService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;


public class BKOperationLogDelegate {
	
	public String getTranSN(String pTransn) throws Exception{
		BKOperationLogService bkOperationLogService = (BKOperationLogService) SpringBeanDelegate.getBean("bkOperationLogService");	
		return bkOperationLogService.getTranSN(pTransn);
	}
	
	public void insert(OperationLog bkOperationLog) throws Exception{
		BKOperationLogService bkOperationLogService = (BKOperationLogService) SpringBeanDelegate.getBean("bkOperationLogService");	
		bkOperationLogService.insert(bkOperationLog);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryBKLog(Map map)throws Exception{
		BKOperationLogService bkOperationLogService = (BKOperationLogService) SpringBeanDelegate.getBean("bkOperationLogService");	
		return bkOperationLogService.queryBKLog(map);
	}
	
	public Timestamp findBCLastLoginTime(int pModuleId) throws Exception{
		BKOperationLogService bkOperationLogService = (BKOperationLogService)SpringBeanDelegate.getBean("bkOperationLogService");
		return bkOperationLogService.findBCLastLoginTime(pModuleId);
	}
	
	@SuppressWarnings("rawtypes")
	public List<OperationLog> queryBKOperationLog(Pagination pn,Map pMap) throws Exception{
		BKOperationLogService bkOperationLogService = (BKOperationLogService)SpringBeanDelegate.getBean("bkOperationLogService");
		return bkOperationLogService.queryBKOperationLog(pn, pMap);
	}
}
