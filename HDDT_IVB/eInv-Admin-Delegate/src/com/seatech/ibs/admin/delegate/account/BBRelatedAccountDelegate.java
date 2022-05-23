package com.seatech.ibs.admin.delegate.account;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.account.BBRelatedAccountService;
import com.seatech.ibs.corp.pojo.account.RelatedAccount;

public class BBRelatedAccountDelegate {

	
	public void deleteBBRelatedAccount(String relationId) throws Exception {
		BBRelatedAccountService relatedAccountService =(BBRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountService");
		relatedAccountService.deleteBBRelatedAccount(relationId);//yayaya
	}
	

	public RelatedAccount getRelationId(String relationId) throws Exception{
		BBRelatedAccountService relatedAccountService =(BBRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountService");
		return relatedAccountService.getRelationId(relationId);
	}
	
	public void insertBBRelatedAccount(RelatedAccount relatedAccount) throws Exception {
		BBRelatedAccountService relatedAccountService =(BBRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountService");
		relatedAccountService.insertBBRelatedAccount(relatedAccount);
	}
	
	public List<RelatedAccount> selectBBRelatedAccount(RelatedAccount relatedAccount)
			throws Exception {
		BBRelatedAccountService relatedAccountService =(BBRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountService");
		return relatedAccountService.selectBBRelatedAccount(relatedAccount);
	}

	public void updateBBRelatedAccount(RelatedAccount corpInfo) throws Exception{
		BBRelatedAccountService relatedAccountService =(BBRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountService");
		relatedAccountService.updateBBRelatedAccount(corpInfo);
	}


}
