package com.seatech.ibs.admin.delegate.account;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.account.BCRelatedAccountService;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.retail.pojo.account.RelatedAccount;

public class BCRelatedAccountDelegate {

    
    public void deleteBCRelatedAccount(String relationId) throws Exception {
        BCRelatedAccountService relatedAccountRetailService =(BCRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountRetailService");
        relatedAccountRetailService.deleteBCRelatedAccount(relationId);
    }
    

    public RelatedAccount getRelationId(String relationId) throws Exception{
        BCRelatedAccountService relatedAccountRetailService =(BCRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountRetailService");
        return relatedAccountRetailService.getRelationId(relationId);
    }
    
    public void insertBCRelatedAccount(RelatedAccount relatedAccount) throws Exception {
        BCRelatedAccountService relatedAccountRetailService =(BCRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountRetailService");
        relatedAccountRetailService.insertBCRelatedAccount(relatedAccount);
    }
    
    public List<RelatedAccount> selectBCRelatedAccount(RelatedAccount relatedAccount)
            throws Exception {
        BCRelatedAccountService relatedAccountRetailService =(BCRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountRetailService");
        return relatedAccountRetailService.selectBCRelatedAccount(relatedAccount);
    }

    public void updateBCRelatedAccount(RelatedAccount corpInfo) throws Exception{
        BCRelatedAccountService relatedAccountRetailService =(BCRelatedAccountService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountRetailService");
        relatedAccountRetailService.updateBCRelatedAccount(corpInfo);
    }
    
    @SuppressWarnings("unchecked")
    public List<RelatedAccount> queryRelatedAccount(Integer userId)throws Exception{
        try {
            BCRelatedAccountService bCRelatedAccountService = (BCRelatedAccountService) SpringBeanDelegate.getBean("relatedAccountRetailService");
            return bCRelatedAccountService.queryRelatedAccount(userId);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<RelatedAccount> queryBCRelatedAccountDynamic(RelatedAccount relatedAccount) throws Exception {
        BCRelatedAccountService relatedAccountRetailService = (BCRelatedAccountService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("relatedAccountRetailService");
        return relatedAccountRetailService.queryBCRelatedAccountDynamic(relatedAccount);
    }

}
