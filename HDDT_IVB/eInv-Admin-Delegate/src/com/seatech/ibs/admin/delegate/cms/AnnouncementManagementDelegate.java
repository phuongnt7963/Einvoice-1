package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFile;
import com.seatech.ibs.admin.service.cms.AnnouncementManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;

import java.util.List;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AnnouncementManagementDelegate
{

    public AnnouncementManagementDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryCmsFile(int pFolderId)
        throws Exception
    {
        AnnouncementManagementService service = getAnnouncementManagementBean();
        return service.queryCmsFile(pFolderId);
    }

    public void deleteCmsFile(int pFileId)
        throws Exception
    {
        AnnouncementManagementService service = getAnnouncementManagementBean();
        service.deleteCmsFile(pFileId);
    }

    public CmsFile getCmsFile(int pFileId)
        throws Exception
    {
        AnnouncementManagementService service = getAnnouncementManagementBean();
        return service.getCmsFile(pFileId);
    }

    public void addCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        AnnouncementManagementService service = getAnnouncementManagementBean();
        service.addCmsFile(pCmsFile);
    }

    public void updateCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        AnnouncementManagementService service = getAnnouncementManagementBean();
        service.updateCmsFile(pCmsFile);
    }

    @SuppressWarnings("rawtypes")
	public List queryByFolderIdPn(String pFolderId, Pagination pn)
        throws Exception
    {
        AnnouncementManagementService service = getAnnouncementManagementBean();
        return service.queryByFolderIdPn(pFolderId, pn);
    }

    private AnnouncementManagementService getAnnouncementManagementBean()
    {
        return (AnnouncementManagementService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("announcementManagementService");
    }
}