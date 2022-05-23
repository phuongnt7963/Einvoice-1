package com.seatech.ibs.admin.delegate.customermanagement;

import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.service.customermanagement.RetailRelatedAcctService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.retail.pojo.account.RelatedAccountBK;
import com.seatech.ibs.retail.pojo.user.UserInfo;

public class RetailRelatedAcctServiceDelegate {
	
	@SuppressWarnings("rawtypes")
	public static void createOrUpdateRelatedAcct(Integer pOperatorID,Integer pUserID,List pSelectedAcctList)throws Exception{
		RetailRelatedAcctService aRetailRelatedAcctService = (RetailRelatedAcctService) SpringBeanDelegate.getBean("adminRetailRelatedAcctService");
		aRetailRelatedAcctService.createOrUpdateRelatedAcct(pOperatorID, pUserID, pSelectedAcctList);
	}
	public static void insertBK(RelatedAccountBK related)throws Exception{
		RetailRelatedAcctService aRetailRelatedAcctService = (RetailRelatedAcctService) SpringBeanDelegate.getBean("adminRetailRelatedAcctService");
		aRetailRelatedAcctService.insertRelatedAccountBK(related);
	}
	public static RelatedAccountBK selectBK(int userId)throws Exception{
		RetailRelatedAcctService aRetailRelatedAcctService = (RetailRelatedAcctService) SpringBeanDelegate.getBean("adminRetailRelatedAcctService");		
		return aRetailRelatedAcctService.getListRelatedBKByUserId(userId);
	}
	public static void deleteBK(int userId)throws Exception{
		RetailRelatedAcctService aRetailRelatedAcctService = (RetailRelatedAcctService) SpringBeanDelegate.getBean("adminRetailRelatedAcctService");
		aRetailRelatedAcctService.deleteBK(userId);
	}
	public static  List<Integer>  getAllBk()throws Exception{
		RetailRelatedAcctService aRetailRelatedAcctService = (RetailRelatedAcctService) SpringBeanDelegate.getBean("adminRetailRelatedAcctService");
		return aRetailRelatedAcctService.getAllBk();
	}
	
	@SuppressWarnings("rawtypes")
	public List<UserInfo> selectRelateAccountUserInfo(Map map) throws Exception {
		RetailRelatedAcctService aRetailRelatedAcctService = (RetailRelatedAcctService) SpringBeanDelegate.getBean("adminRetailRelatedAcctService");
		return aRetailRelatedAcctService.selectRelateAccountUserInfo(map);
	}
	
	
	

}
