package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFile;
import com.seatech.ibs.admin.service.cms.AdvertisementManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class AdvertisementDelegate
{

    public AdvertisementDelegate()
    {
    }
    
	public Integer getFileSeq() throws Exception {
    	AdvertisementManagementService service = getAdvertisementRetailBean();
    	return service.getFileSeq();
	}
    
    @SuppressWarnings("rawtypes")
	public List queryCmsFile(int pFolderId)
        throws Exception
    {
        AdvertisementManagementService service = getAdvertisementRetailBean();
        return service.queryCmsFile(pFolderId);
    }

    public void deleteCmsFile(int pFileId)
        throws Exception
    {
        AdvertisementManagementService service = getAdvertisementRetailBean();
        service.deleteCmsFile(pFileId);
    }

    public CmsFile getCmsFile(int pFileId)
        throws Exception
    {
        AdvertisementManagementService service = getAdvertisementRetailBean();
        return service.getCmsFile(pFileId);
    }

    public void addCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        AdvertisementManagementService service = getAdvertisementRetailBean();
        service.addCmsFile(pCmsFile);
    }

    public void updateCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        AdvertisementManagementService service = getAdvertisementRetailBean();
        service.updateCmsFile(pCmsFile);
    }

    @SuppressWarnings("rawtypes")
	public List queryByFolderIdPn(String pFolderId, String channelCode, String language, Pagination pn)
        throws Exception
    {
        AdvertisementManagementService service = getAdvertisementRetailBean();
        return service.queryByFolderIdPn(pFolderId, channelCode, language, pn);
    }

    private AdvertisementManagementService getAdvertisementRetailBean()
    {
        return (AdvertisementManagementService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("advertisementManagementService");
    }
}