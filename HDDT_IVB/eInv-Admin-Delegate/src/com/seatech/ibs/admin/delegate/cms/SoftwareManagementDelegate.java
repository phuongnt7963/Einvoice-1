package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFile;
import com.seatech.ibs.admin.service.cms.SoftwareManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class SoftwareManagementDelegate
{

    public SoftwareManagementDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryCmsFile(int pFolderId)
        throws Exception
    {
        SoftwareManagementService service = getSoftwareManagementBean();
        return service.queryCmsFile(pFolderId);
    }

    public void deleteCmsFile(int pFileId)
        throws Exception
    {
        SoftwareManagementService service = getSoftwareManagementBean();
        service.deleteCmsFile(pFileId);
    }

    public CmsFile getCmsFile(int pFileId)
        throws Exception
    {
        SoftwareManagementService service = getSoftwareManagementBean();
        return service.getCmsFile(pFileId);
    }

    public void addCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        SoftwareManagementService service = getSoftwareManagementBean();
        service.addCmsFile(pCmsFile);
    }

    public void updateCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        SoftwareManagementService service = getSoftwareManagementBean();
        service.updateCmsFile(pCmsFile);
    }

    @SuppressWarnings("rawtypes")
	public List queryByFolderIdPn(String pFolderId, String channelCode, String language, Pagination pn)
        throws Exception
    {
        SoftwareManagementService service = getSoftwareManagementBean();
        return service.queryByFolderIdPn(pFolderId, channelCode, language, pn);
    }

    private SoftwareManagementService getSoftwareManagementBean()
    {
        return (SoftwareManagementService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("softwareManagementService");
    }
}