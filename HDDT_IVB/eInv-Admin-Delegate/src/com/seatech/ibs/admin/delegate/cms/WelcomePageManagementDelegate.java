package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFile;
import com.seatech.ibs.admin.service.cms.WelcomePageManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;

import java.util.List;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WelcomePageManagementDelegate
{

    public WelcomePageManagementDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryCmsFile(int pFolderId)
        throws Exception
    {
        WelcomePageManagementService service = getWelcomePageManagementBean();
        return service.queryCmsFile(pFolderId);
    }

    public void deleteCmsFile(int pFileId)
        throws Exception
    {
        WelcomePageManagementService service = getWelcomePageManagementBean();
        service.deleteCmsFile(pFileId);
    }

    public CmsFile getCmsFile(int pFileId)
        throws Exception
    {
        WelcomePageManagementService service = getWelcomePageManagementBean();
        return service.getCmsFile(pFileId);
    }

    public void addCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        WelcomePageManagementService service = getWelcomePageManagementBean();
        service.addCmsFile(pCmsFile);
    }

    public void updateCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        WelcomePageManagementService service = getWelcomePageManagementBean();
        service.updateCmsFile(pCmsFile);
    }

    @SuppressWarnings("rawtypes")
	public List queryByFolderIdPn(String pFolderId, Pagination pn)
        throws Exception
    {
        WelcomePageManagementService service = getWelcomePageManagementBean();
        return service.queryByFolderIdPn(pFolderId, pn);
    }

    private WelcomePageManagementService getWelcomePageManagementBean()
    {
        return (WelcomePageManagementService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("welcomePageManagementService");
    }
}