package com.seatech.ibs.admin.delegate.notification;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.notification.NotificationApp;
import com.seatech.ibs.admin.service.notification.NotificationAppService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.service.exception.IBSServiceException;


public class NotificationAppDelegate {
	
	public void addMessageBoard(NotificationApp notification) throws Exception{
		NotificationAppService service=this.getNotificationAppBean();
		service.addNotificationApp(notification);
	}
	
	public void removeNotificationApp(int applicationId) throws Exception{
		NotificationAppService service=this.getNotificationAppBean();
		service.removeNotificationApp(applicationId);
	}
	
	public NotificationApp getNotificationAppById(int applicationId) throws Exception {
		NotificationAppService service=this.getNotificationAppBean();
		return service.getNotificationAppById(applicationId);
	}
	
	public void modifyNotificationApp(NotificationApp notification) throws Exception {
		NotificationAppService service=this.getNotificationAppBean();
		service.modifyNotificationApp(notification);
	}
	
	public List<NotificationApp> queryNotificationAppList(NotificationApp notification) throws Exception {
		NotificationAppService service=this.getNotificationAppBean();
		return service.queryNotificationAppList(notification);
	}

    public List<NotificationApp> queryNotificationAppListPagination(NotificationApp notification,Pagination pn) throws IBSServiceException {
    	NotificationAppService service=this.getNotificationAppBean();
    	return service.queryNotificationAppListPagination(notification, pn);
	}
    
    private NotificationAppService getNotificationAppBean(){
		return  (NotificationAppService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminNotificationAppService");
	}
}
