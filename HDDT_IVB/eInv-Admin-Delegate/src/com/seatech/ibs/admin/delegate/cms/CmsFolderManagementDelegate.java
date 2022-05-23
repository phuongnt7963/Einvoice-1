package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFolder;
import com.seatech.ibs.admin.service.cms.CmsFolderManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;

import java.util.List;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CmsFolderManagementDelegate
{

    public CmsFolderManagementDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryCmsFolder(int pParentId)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        return service.queryByParentId(pParentId);
    }

    public void deleteCmsFolder(int pFileId)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        service.deleteCmsFolder(pFileId);
    }

    public CmsFolder getCmsFolder(int pFileId)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        return service.getCmsFolder(pFileId);
    }

    public void addCmsFolder(CmsFolder pCmsFolder)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        service.addCmsFolder(pCmsFolder);
    }

    public void updateCmsFolder(CmsFolder pCmsFolder)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        service.updateCmsFolder(pCmsFolder);
    }

    private CmsFolderManagementService getCmsFolderManagementBean()
    {
        return (CmsFolderManagementService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("cmsFolderManagementService");
    }

    @SuppressWarnings("rawtypes")
	public List queryAllCmsFolder(int pParentId)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        return service.queryAllByParentId(pParentId);
    }

    public CmsFolder getByNamePath(String pNamePath)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        return service.getByNamePath(pNamePath);
    }

    public int getCmsFolderId(String pNamePath)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        return service.getCmsFolderId(pNamePath);
    }

    @SuppressWarnings("rawtypes")
	public List queryByParentIdPn(int pParentId, Pagination pn)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        return service.queryByParentIdPn(pParentId, pn);
    }

    @SuppressWarnings("rawtypes")
	public List queryFolderTreeByNamePath(String pNamePath)
        throws Exception
    {
        CmsFolderManagementService service = getCmsFolderManagementBean();
        return service.queryFolderTreeByNamePath(pNamePath);
    }
}