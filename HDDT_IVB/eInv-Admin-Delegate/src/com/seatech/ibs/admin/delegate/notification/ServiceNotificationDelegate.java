package com.seatech.ibs.admin.delegate.notification;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.notification.NotificationService;
import com.seatech.ibs.admin.service.notification.ServiceNotificationService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.service.exception.IBSServiceException;


public class ServiceNotificationDelegate {
	
	public void addMessageBoard(NotificationService notification) throws Exception{
		ServiceNotificationService service=this.getNotificationServiceBean();
		service.addNotificationService(notification);
	}
	
	public void removeNotificationService(int serviceId) throws Exception{
		ServiceNotificationService service=this.getNotificationServiceBean();
		service.removeNotificationService(serviceId);
	}
	
	public NotificationService getNotificationServiceById(int serviceId) throws Exception {
		ServiceNotificationService service=this.getNotificationServiceBean();
		return service.getNotificationServiceById(serviceId);
	}
	
	public void modifyNotificationService(NotificationService notification) throws Exception {
		ServiceNotificationService service=this.getNotificationServiceBean();
		service.modifyNotificationService(notification);
	}
	
	public List<NotificationService> queryNotificationServiceList(NotificationService notification) throws Exception {
		ServiceNotificationService service=this.getNotificationServiceBean();
		return service.queryNotificationServiceList(notification);
	}

    public List<NotificationService> queryNotificationServiceListPagination(NotificationService notification,Pagination pn) throws IBSServiceException {
    	ServiceNotificationService service=this.getNotificationServiceBean();
    	return service.queryNotificationServiceListPagination(notification, pn);
	}
    
    private ServiceNotificationService getNotificationServiceBean(){
		return  (ServiceNotificationService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminServiceNotificationService");
	}
}
