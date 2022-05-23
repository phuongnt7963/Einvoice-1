package com.seatech.ibs.admin.delegate.account;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.account.AccountInfo;
import com.seatech.ibs.admin.service.account.BKAccountInfoService;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Pagination;

public class BKAccountInfoDelegate {
	public List<AccountInfo> selectAccountInfoByCif(String cifNo)
		throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		return accountInfoService.selectAccountListByCifNo(cifNo);
	}
	public List<AccountInfo> selectAllAccountInfoByCif(String cifNo)
	throws Exception{
	BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
	return accountInfoService.selectAllAccountListByCifNo(cifNo);
}
	
	public void deleteBKAccountInfo(String pAcctNo) throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		accountInfoService.deleteBKAccountInfo(pAcctNo);
	}
	

	public AccountInfo getAcctNo(String pAcctNo) throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		return accountInfoService.getAcctNo(pAcctNo);
	}
	
	public void insertBKAccountInfo(AccountInfo accountInfo) throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		accountInfoService.insertBKAccountInfo(accountInfo);
	}
	
	public List<AccountInfo> selectBKAccountInfo(AccountInfo accountInfo , Pagination pn)
			throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		return accountInfoService.selectBKAccountInfo(accountInfo,pn);
	}
	
	public List<AccountInfo> selectBKAccountInfoForRetail(AccountInfo accountInfo , Pagination pn)
	throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		return accountInfoService.selectBKAccountInfoForRetail(accountInfo,pn);
	}
	
	public List<AccountInfo> selectBKAccountInfoForCorp(AccountInfo accountInfo , Pagination pn)
		throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		return accountInfoService.selectBKAccountInfoForCorp(accountInfo,pn);
	}

	public void updateBKAccountInfo(AccountInfo accountInfo) throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		accountInfoService.updateBKAccountInfo(accountInfo);
	}
	
	public List<String> insertOrUpdate(List<AccountInfo> pList)throws Exception{
		BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
		return accountInfoService.insertOrUpdate(pList);
	}
	
	
	public List<AccountInfo> queryAccountWithinCIF(String pCIF)throws Exception{
		try {
			BKAccountInfoService accountInfoService =(BKAccountInfoService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
			return accountInfoService.queryAccountWithinCIF(pCIF);
		} catch (Exception e) {
			throw e;
		}
	}

    public List<AccountInfo> selectByCriterion(Criterion criterion) throws Exception {
        try {
            BKAccountInfoService accountInfoService = (BKAccountInfoService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean(
                    "accountInfoService");
            return accountInfoService.selectByCriterion(criterion);
        }
        catch (Exception e) {
            throw e;
        }
    }
    public Integer checkExistAccountInfo(String accountNo) throws Exception {
        try {
            BKAccountInfoService accountInfoService = (BKAccountInfoService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean(
                    "accountInfoService");
            return accountInfoService.checkExistAccountInfo(accountNo);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
