/**
 * COPYRIGHT (C) 2011 GEONG. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of GEONG.
 */
package com.seatech.ibs.admin.delegate.fee;

import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.fee.ServiceFee;
import com.seatech.ibs.admin.pojo.fee.ServiceFeeDetail;
import com.seatech.ibs.admin.service.customermanagement.CorpFeeService;
import com.seatech.ibs.admin.service.fee.CorpFeeGroupDetailService;
import com.seatech.ibs.common.dto.Pagination;

public class BKFeeGroupDetailDelegate extends DelegateBase {

	
	public void addCorpFeeGroupDetail(ServiceFeeDetail fd){
		((CorpFeeGroupDetailService)this.getBean("corpFeeGroupDetailService")).add(fd);
	}
	
	public void updateCorpFeeGroupDetail(ServiceFeeDetail fd){
		((CorpFeeGroupDetailService)this.getBean("corpFeeGroupDetailService")).update(fd);
	}
	
	public void deleteCorpFeeGroupDetail(Integer id){
		((CorpFeeGroupDetailService)this.getBean("corpFeeGroupDetailService")).delete(id);
	}
	 
	public List<ServiceFeeDetail> getAllDetail(){
		return ((CorpFeeGroupDetailService)this.getBean("corpFeeGroupDetailService")).findAll();
	}
	 
	public ServiceFeeDetail getCorpFeeGroupDetail(Integer id){
		return (ServiceFeeDetail) ((CorpFeeGroupDetailService)this.getBean("corpFeeGroupDetailService")).findById(id);
	}

	/**
	 * @param mid
	 * @param gid
	 * @return
	 */
	public List getFeeDetailByMidAndGid(String mid, String gid) {
		return ((CorpFeeGroupDetailService)this.getBean("corpFeeGroupDetailService")).queryFeeDetails(mid,gid);
	}

	/**
	 * @param fee
	 */
	public Integer addCorpFee(ServiceFee fee) {
		return ((CorpFeeService)this.getBean("corpFeeService")).add(fee);
	}
	

	/**
	 * @param parseInt
	 * @param parseInt2
	 * @return
	 */
	public List queryCorpFee(int gid, int mid) { 
		return ((CorpFeeService)this.getBean("corpFeeService")).queryCorpFee(gid,mid);
	}

	public List<ServiceFee> getDetailGroupFee(Map<String, Object> map, Pagination pn) {
		return ((CorpFeeService)this.getBean("corpFeeService")).getServiceFee(map, pn);
	}
	public void updateDetailGroupFee(ServiceFee fee) {
		((CorpFeeService)this.getBean("corpFeeService")).updateDetailGroupFee(fee);
	}
	public List<ServiceFeeDetail> getFeeDetail(int id) {
		return ((CorpFeeService)this.getBean("corpFeeService")).getFeeDetail(id);
	}
	public Integer addGroupFeeDetail(ServiceFee fee){
		return ((CorpFeeService)this.getBean("corpFeeService")).addGroupFeeDetail(fee);
	}
	public void removeFeeDetail(int feeId){
		((CorpFeeService)this.getBean("corpFeeService")).removeFeeDetail(feeId);
	}
	public void removeFeeService(int feeId){
		((CorpFeeService)this.getBean("corpFeeService")).removeFeeService(feeId);
	}
	public void removeFeeServiceByGroup(int groupId){
		((CorpFeeService)this.getBean("corpFeeService")).removeFeeServiceByGroup(groupId);
	}
	
	public List<ServiceFeeDetail> getFeeAnnual(int groupId) {
		return ((CorpFeeService)this.getBean("corpFeeService")).getFeeAnnual(groupId);
	}
	public List<ServiceFee> getFeeModule(int groupId) {
		return ((CorpFeeService)this.getBean("corpFeeService")).getFeeModule(groupId);
	}

	public List<ServiceFee> getFeeModuleBK(Integer groupId) {
		return ((CorpFeeService)this.getBean("corpFeeService")).getFeeModuleBK(groupId);
	}
	
	public List<String> getServiceFeeAssigned() {
		return ((CorpFeeService)this.getBean("corpFeeService")).getServiceFeeAssigned();
	}
}
