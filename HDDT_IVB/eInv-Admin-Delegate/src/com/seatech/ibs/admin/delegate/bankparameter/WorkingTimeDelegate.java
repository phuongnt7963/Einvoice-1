package com.seatech.ibs.admin.delegate.bankparameter;

import java.util.List;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.service.bankparameter.WorkingTimeService;

public class WorkingTimeDelegate extends DelegateBase {

	@SuppressWarnings("rawtypes")
	public void saveWorkingTime(List workHoursList) {
		((WorkingTimeService)this.getBean("workingTimeService")).add(workHoursList);
		
	}

}
