package com.seatech.ibs.admin.delegate.systemMonitoring;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.seatech.ibs.admin.pojo.systemMonitoring.TransactionMonitoringVO;
import com.seatech.ibs.admin.service.systemMonitoring.TransactionMonitoringService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;


public class TransactionMonitoringServiceDelegate {
	
	public static TransactionMonitoringService getBean()throws Exception{
		try {
			return (TransactionMonitoringService) SpringBeanDelegate.getBean("adminMonitoringTransactionService");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static List<TransactionMonitoringVO> queryResultCorp(String pUserName,String CIF,String pAccountNo,BigDecimal pFromeAmount,BigDecimal pToAmount,String channel,String status,String pTransactionType,Pagination pn,Date fromdate,Date toDate,Integer fromHour,Integer toHour)throws Exception{
		try {
			return getBean().queryResultCorp(pUserName, CIF, pAccountNo, pFromeAmount, pToAmount, channel, status, pTransactionType, pn,fromdate,toDate,fromHour,toHour);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static List<TransactionMonitoringVO> queryResultRetail(String pUserName,String CIF,String pAccountNo,BigDecimal pFromeAmount,BigDecimal pToAmount,String channel,String status,String pTransactionType,Pagination pn,Date fromDate,Date toDate,Integer fromHour,Integer toHour)throws Exception{
		try {
			return getBean().queryResultRetail(pUserName, CIF, pAccountNo, pFromeAmount, pToAmount, channel, status, pTransactionType, pn,fromDate,toDate,fromHour,toHour);
		} catch (Exception e) {
			throw e;
		}
	}

}
