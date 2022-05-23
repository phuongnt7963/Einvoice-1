package com.seatech.ibs.admin.delegate.bankparameter;

import java.util.List;
import java.util.Map;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.bank.BankOrg;
import com.seatech.ibs.admin.service.bankparameter.BankOrgService;
import com.seatech.ibs.common.constant.AppConstant;
import com.seatech.ibs.common.dto.Pagination;

public class BankOrgDelegate extends DelegateBase {

	private static final BTTLog log = BTTLogFactory.getLog(BankOrgDelegate.class.getName());

	public BankOrg getBankOrg(String id){
		try {
			return (BankOrg)((BankOrgService)this.getBean("bankOrgService")).findById(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("BankOrg findByInteger from table bk_info error::::::::"+e.getMessage());
			}
		}
		return null;
	}
	@SuppressWarnings("rawtypes")
	public List getBranchList(String bankNo){
		try {
			return ((BankOrgService)this.getBean("bankOrgService")).getBranchList(bankNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("rawtypes")
	public List findAll(){
		return ((BankOrgService)this.getBean("bankOrgService")).findAll();
	}

	public void delete(String id){
		try {
			((BankOrgService)this.getBean("bankOrgService")).delete(id);
		} catch (Exception e) {
			if(log.doError()){
				log.info("BankOrg delete error::::::::"+e.getMessage());
			}
		}
	}


	public void insert(BankOrg info) {
		try {
			((BankOrgService)this.getBean("bankOrgService")).add(info);
		} catch (Exception e) {
			if(log.doError()){
				log.info("BankOrg insert into table error::::::::"+e.getMessage());
			}
		}
	}

	public void update(BankOrg info){
		try {
			((BankOrgService)this.getBean("bankOrgService")).update(info);
		} catch (Exception e) {
			if(log.doError()){
				log.info("BankOrg update error::::::::"+e.getMessage());
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll(Pagination pn) {
		return ((BankOrgService)this.getBean("bankOrgService")).findAll(pn);
	}

    public List<BankOrg> queryBankOrgSelective(BankOrg org) throws Exception {
        BankOrgService service = (BankOrgService) this.getBean("bankOrgService");
        return service.queryBankOrgSelective(org);
    }

	@SuppressWarnings("rawtypes")
	public List findAll(String orgNo) {
		return ((BankOrgService) this.getBean("bankOrgService")).findAll(orgNo);
	}

	@SuppressWarnings("rawtypes")
	public List findAll(Pagination pn, Map map) {
		return ((BankOrgService)this.getBean("bankOrgService")).findAll(pn,map);
	}
	public Object findById(String id)throws Exception{
		return ((BankOrgService)this.getBean("bankOrgService")).findById(id);
	}

	@SuppressWarnings("rawtypes")
	public List queryAllByBSF(Pagination pn, Map map) throws Exception {
		return ((BankOrgService)this.getBean("bankOrgService")).queryAllByBSF(pn,map);
	}

	@SuppressWarnings("rawtypes")
	public List findAllByBankNo(String bankNO) throws Exception {
		return ((BankOrgService)this.getBean("bankOrgService")).findAllByBankNo(bankNO);
	}

	@SuppressWarnings("rawtypes")
	public List findAllMyBranch() throws Exception {
		return ((BankOrgService)this.getBean("bankOrgService")).findAllByBankNo(AppConstant.SYS_CURRENT_BANK_NO);
	}

	@SuppressWarnings("rawtypes")
	public List selectBankOrg(Map map) throws Exception {
		return ((BankOrgService)this.getBean("bankOrgService")).selectBankOrg(map);
	}

	@SuppressWarnings("rawtypes")
	public List findByAllByPOrgNO(Map map) throws Exception {
		return ((BankOrgService)this.getBean("bankOrgService")).findByAllByPOrgNO(map);
	}

	@SuppressWarnings("rawtypes")
	public List queryAllByBSF(Map map) throws Exception {
		return ((BankOrgService)this.getBean("bankOrgService")).queryAllByBSF(map);
	}

	@SuppressWarnings("rawtypes")
	public List<BankOrg> findByBranch(Map map) throws Exception {
		return ((BankOrgService)this.getBean("bankOrgService")).findByBranch(map);
	}
}
