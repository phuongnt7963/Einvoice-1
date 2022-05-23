package com.seatech.ibs.admin.delegate.corpLimit;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.corpLimit.CorpLimitInfoService;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.corp.pojo.limit.BbLimitInfo;
public class CorpLimitInfoDelegate {

    public BbLimitInfo getLimitInfo(int corpId) throws RuntimeException {
        CorpLimitInfoService service = this.getLimitInfoBean();
        return service.getLimitInfoByCorpId(corpId);
    }

    public void insertLimitInfo(BbLimitInfo limitInfo) throws Exception {
        CorpLimitInfoService service = this.getLimitInfoBean();
        service.insertLimitInfo(limitInfo);
    }

    public void updateLimitInfo(BbLimitInfo limitInfo) throws Exception {
        CorpLimitInfoService service = this.getLimitInfoBean();
        service.updateLimitInfo(limitInfo);
    }

    public List<BbLimitInfo> selectBbLimitInfo(BbLimitInfo limitInfo, Pagination pn) throws Exception {
    	CorpLimitInfoService service = this.getLimitInfoBean();
        return service.queryBbLimitInfoList(limitInfo, pn);
    }

    private CorpLimitInfoService getLimitInfoBean() {
        return (CorpLimitInfoService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpLimitInfoService");
    }

	public BbLimitInfo getLimitInfoById(int id) throws RuntimeException {
        CorpLimitInfoService service = this.getLimitInfoBean();
        return service.getLimitInfo(id);
    }

	public void sendApprove(BbLimitInfo limitInfo, Map<String, Object> map) throws RuntimeException {
        CorpLimitInfoService service = this.getLimitInfoBean();
        service.sendApprove(limitInfo, map);
	}

	public BbLimitInfo getLimitInfoByIdBk(Integer id) {
        CorpLimitInfoService service = this.getLimitInfoBean();
        return service.getLimitInfoByIdBk(id);
	}

	public void updateLimitInfoBk(BbLimitInfo limitInfoBK) {
        CorpLimitInfoService service = this.getLimitInfoBean();
        service.updateLimitInfoBk(limitInfoBK);
	}

}
