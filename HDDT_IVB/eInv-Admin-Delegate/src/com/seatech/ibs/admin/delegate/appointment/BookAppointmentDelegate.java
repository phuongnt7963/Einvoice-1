package com.seatech.ibs.admin.delegate.appointment;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seatech.ibs.admin.pojo.appointment.BookAppointment;
import com.seatech.ibs.admin.service.appointment.BookAppointmentService;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.service.exception.IBSServiceException;

public class BookAppointmentDelegate {
	
	public void addBookAppointment(BookAppointment appointment) throws Exception{
		BookAppointmentService service=this.getBookAppointmentBean();
		service.addBookAppointment(appointment);
	}
	
	public void removeBookAppointment(int appointmentId) throws Exception{
		BookAppointmentService service=this.getBookAppointmentBean();
		service.removeBookAppointment(appointmentId);
	}
	
	public BookAppointment getBookAppointmentById(int appointmentId) throws Exception {
		BookAppointmentService service=this.getBookAppointmentBean();
		return service.getBookAppointmentById(appointmentId);
	}
	
	public void modifyBookAppointment(BookAppointment appointment) throws Exception {
		BookAppointmentService service=this.getBookAppointmentBean();
		service.modifyBookAppointment(appointment);
	}
	
	public List<BookAppointment> queryBookAppointmentList(BookAppointment appointment) throws Exception {
		BookAppointmentService service=this.getBookAppointmentBean();
		return service.queryBookAppointmentList(appointment);
	}

    public List<BookAppointment> queryBookAppointmentListPagination(BookAppointment appointment,Pagination pn) throws IBSServiceException {
    	BookAppointmentService service=this.getBookAppointmentBean();
    	return service.queryBookAppointmentListPagination(appointment, pn);
	}
    
    private BookAppointmentService getBookAppointmentBean(){
		return  (BookAppointmentService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminBookAppointmentService");
	}
    
}
