package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFile;
import com.seatech.ibs.admin.service.cms.HelpManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;

import java.util.List;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class HelpManagementDelegate
{

    public HelpManagementDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryCmsFile(int pFolderId)
        throws Exception
    {
        HelpManagementService service = getHelpManagementBean();
        return service.queryCmsFile(pFolderId);
    }

    public void deleteCmsFile(int pFileId)
        throws Exception
    {
        HelpManagementService service = getHelpManagementBean();
        service.deleteCmsFile(pFileId);
    }

    public CmsFile getCmsFile(int pFileId)
        throws Exception
    {
        HelpManagementService service = getHelpManagementBean();
        return service.getCmsFile(pFileId);
    }

    public void addCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        HelpManagementService service = getHelpManagementBean();
        service.addCmsFile(pCmsFile);
    }

    public void updateCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        HelpManagementService service = getHelpManagementBean();
        service.updateCmsFile(pCmsFile);
    }

    @SuppressWarnings("rawtypes")
	public List queryByFolderIdPn(String pFolderId, Pagination pn)
        throws Exception
    {
        HelpManagementService service = getHelpManagementBean();
        return service.queryByFolderIdPn(pFolderId, pn);
    }

    private HelpManagementService getHelpManagementBean()
    {
        return (HelpManagementService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("helpManagementService");
    }
}