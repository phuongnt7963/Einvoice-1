package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFile;
import com.seatech.ibs.admin.service.cms.UploadDownloadManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;

import java.util.List;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class UploadDownloadManagementDelegate
{

    public UploadDownloadManagementDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryCmsFile(int pFolderId)
        throws Exception
    {
        UploadDownloadManagementService service = getUploadDownloadManagementBean();
        return service.queryCmsFile(pFolderId);
    }

    public void deleteCmsFile(int pFileId)
        throws Exception
    {
        UploadDownloadManagementService service = getUploadDownloadManagementBean();
        service.deleteCmsFile(pFileId);
    }

    public CmsFile getCmsFile(int pFileId)
        throws Exception
    {
        UploadDownloadManagementService service = getUploadDownloadManagementBean();
        return service.getCmsFile(pFileId);
    }

    public void addCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        UploadDownloadManagementService service = getUploadDownloadManagementBean();
        service.addCmsFile(pCmsFile);
    }

    public void updateCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        UploadDownloadManagementService service = getUploadDownloadManagementBean();
        service.updateCmsFile(pCmsFile);
    }

    @SuppressWarnings("rawtypes")
	public List queryByFolderIdPn(String pFolderId, Pagination pn)
        throws Exception
    {
        UploadDownloadManagementService service = getUploadDownloadManagementBean();
        return service.queryByFolderIdPn(pFolderId, pn);
    }

    private UploadDownloadManagementService getUploadDownloadManagementBean()
    {
        return (UploadDownloadManagementService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("uploadDownloadManagementService");
    }
}