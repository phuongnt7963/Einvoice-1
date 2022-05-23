package com.seatech.ibs.admin.delegate.notification;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.pojo.notification.NotificationBean;
import com.seatech.ibs.admin.service.notification.NotificationEtaxService;
import com.seatech.ibs.common.dto.Pagination;


public class AdminNotificationEtaxDelegate {
	NotificationEtaxService notifiEtaxService = (NotificationEtaxService) WebApplicationContextUtils
			.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
					.getServletContext()).getBean("notifiEtaxService");

	public List<NotificationBean> queryNotificationAppListPaginationTTXL(Pagination pn, NotificationBean notification) throws Exception {

        return notifiEtaxService.queryListNotificationTTXL(pn, notification);
    }

	 public byte[] queryContentNotificationTTXL(NotificationBean notification) throws Exception{

        return notifiEtaxService.queryContentNotificationTTXL(notification);
    }
}
