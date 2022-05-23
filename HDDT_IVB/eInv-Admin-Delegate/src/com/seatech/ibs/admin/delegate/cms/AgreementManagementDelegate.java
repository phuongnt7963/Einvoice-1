package com.seatech.ibs.admin.delegate.cms;

import com.seatech.ibs.admin.pojo.cms.CmsFile;
import com.seatech.ibs.admin.service.cms.AgreementManagementService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;

import java.util.List;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AgreementManagementDelegate
{

    public AgreementManagementDelegate()
    {
    }

    @SuppressWarnings("rawtypes")
	public List queryCmsFile(int pFolderId)
        throws Exception
    {
        AgreementManagementService service = getAgreementManagementBean();
        return service.queryCmsFile(pFolderId);
    }

    public void deleteCmsFile(int pFileId)
        throws Exception
    {
        AgreementManagementService service = getAgreementManagementBean();
        service.deleteCmsFile(pFileId);
    }

    public CmsFile getCmsFile(int pFileId)
        throws Exception
    {
        AgreementManagementService service = getAgreementManagementBean();
        return service.getCmsFile(pFileId);
    }

    public void addCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        AgreementManagementService service = getAgreementManagementBean();
        service.addCmsFile(pCmsFile);
    }

    public void updateCmsFile(CmsFile pCmsFile)
        throws Exception
    {
        AgreementManagementService service = getAgreementManagementBean();
        service.updateCmsFile(pCmsFile);
    }

    @SuppressWarnings("rawtypes")
	public List queryByFolderIdPn(String pFolderId, String channelCode, String language,  Pagination pn)
        throws Exception
    {
        AgreementManagementService service = getAgreementManagementBean();
        return service.queryByFolderIdPn(pFolderId, channelCode, language, pn);
    }

    private AgreementManagementService getAgreementManagementBean()
    {
        return (AgreementManagementService)WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("agreementManagementService");
    }
}