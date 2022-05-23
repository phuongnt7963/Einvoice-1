package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFileAttachment;
import com.seatech.ibs.admin.service.cms.CmsFileAttachmentService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import java.util.List;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CmsFileAttachmentDelegate
{

    public CmsFileAttachmentDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryByFileId(int pFileId)
        throws Exception
    {
        CmsFileAttachmentService service = getCmsFileAttachmentServiceBean();
        return service.queryByFileId(pFileId);
    }

    public CmsFileAttachment queryByAttachmentId(int pAttachmentId)
        throws Exception
    {
        CmsFileAttachmentService service = getCmsFileAttachmentServiceBean();
        return service.getByAttachmentId(pAttachmentId);
    }

    public void deleteAttachment(int pAttachmentId)
        throws Exception
    {
        CmsFileAttachmentService service = getCmsFileAttachmentServiceBean();
        service.deleteAttachment(pAttachmentId);
    }

    public void updateAttachment(CmsFileAttachment pCmsFileAttachment)
        throws Exception
    {
        CmsFileAttachmentService service = getCmsFileAttachmentServiceBean();
        service.updateAttachment(pCmsFileAttachment);
    }

    public void addAttachment(CmsFileAttachment pCmsFileAttachment)
        throws Exception
    {
        CmsFileAttachmentService service = getCmsFileAttachmentServiceBean();
        service.addAttachment(pCmsFileAttachment);
    }

    public void deleteAttachmentByFileId(int pFileId)
        throws Exception
    {
        CmsFileAttachmentService service = getCmsFileAttachmentServiceBean();
        service.deleteAttachmentByFileId(pFileId);
    }

    public String addAttachment(String pContent, int pFileId, String pRealPath)
        throws Exception
    {
        CmsFileAttachmentService service = getCmsFileAttachmentServiceBean();
        return service.addAttachment(pContent, pFileId, pRealPath);
    }

    private CmsFileAttachmentService getCmsFileAttachmentServiceBean()
    {
        return (CmsFileAttachmentService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("cmsFileAttachmentService");
    }
}