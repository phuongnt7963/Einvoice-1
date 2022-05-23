package com.seatech.ibs.admin.delegate.questionsmanagement;

import java.util.List;

import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.user.UserRole;
import com.seatech.ibs.admin.service.user.BBUserRoleService;

public class UserRoleDelegate extends DelegateBase {
	public List<UserRole> selectRoleByTaxID(String taxOrg) throws Exception {
		return ((BBUserRoleService) getBean("userRoleService")).selectRoleByTaxID(taxOrg);
	}
}
