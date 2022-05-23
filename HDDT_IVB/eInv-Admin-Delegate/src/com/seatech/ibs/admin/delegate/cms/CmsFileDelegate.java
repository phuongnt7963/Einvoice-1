package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFile;
import com.seatech.ibs.admin.service.cms.CmsFileService;
import com.ibm.btt.sm.HttpSessionInfoHolder;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class CmsFileDelegate
{

    public CmsFileDelegate()
    {
    }

    public CmsFile getCmsFile(int pFileId)
        throws Exception
    {
        CmsFileService service = getCmsFileServiceBean();
        return service.getCmsFile(pFileId);
    }

    public CmsFile getTopOneByFolderId(int pFolderId,String channelCode)
        throws Exception
    {
        CmsFileService service = getCmsFileServiceBean();
        return service.getTopOneByFolderId(pFolderId,channelCode);
    }

    private CmsFileService getCmsFileServiceBean()
    {
        return (CmsFileService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("cmsFileService");
    }
}