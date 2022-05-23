package com.seatech.ibs.admin.delegate.relcorp;

import java.util.List;
import java.util.Map;

import com.seatech.ibs.admin.service.relcorp.BbRelCorpAcctService;
import com.seatech.ibs.admin.service.relcorp.BbRelCorpCfService;
import com.seatech.ibs.admin.service.relcorp.BbRelCorpService;
import com.seatech.ibs.admin.service.relcorp.BbRelCorpTypeService;
import com.seatech.ibs.corp.pojo.account.RelatedAccount;
import com.seatech.ibs.corp.pojo.company.MemberCompany;
import com.seatech.ibs.corp.pojo.corp.CorpInfo;
import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.corp.pojo.relcorp.BbRelCorp;
import com.seatech.ibs.corp.pojo.relcorp.BbRelCorpAcct;
import com.seatech.ibs.corp.pojo.relcorp.BbRelCorpType;

public class BbRelCorpDelegate {

	public BbRelCorpDelegate() {
		
	}
	public void deleteMother(String cif){
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		service.deleteMother(cif);
	}
	private static final BTTLog log = BTTLogFactory.getLog(com.seatech.ibs.admin.delegate.relcorp.BbRelCorpDelegate.class.getName());
	
	private BbRelCorpService getBbRelCorpServiceBean(){
		try{
			return (BbRelCorpService)SpringBeanDelegate.getBean("bbRelCorpService");
		}
		catch(Exception ex){
			ex.printStackTrace();
			log.info("-----------getServiceBean() error---------");
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	private BbRelCorpCfService getBbRelCorpCfServiceBean(){
		try{
			return (BbRelCorpCfService)SpringBeanDelegate.getBean("bbRelCorpCfService");
		}
		catch(Exception ex){
			ex.printStackTrace();
			log.info("-----------getServiceBean() error---------");
			return null;
		}
	}
	
	private BbRelCorpAcctService getBbRelCorpAcctServiceBean(){
		try{
			return (BbRelCorpAcctService)SpringBeanDelegate.getBean("bbRelCorpAcctService");
		}
		catch(Exception ex){
			ex.printStackTrace();
			log.info("-----------getServiceBean() error---------");
			return null;
		}
	}
	
	private BbRelCorpTypeService getBbRelCorpTypeServiceBean(){
		try{
			return (BbRelCorpTypeService)SpringBeanDelegate.getBean("bbRelCorpTypeService");
		}
		catch(Exception ex){
			ex.printStackTrace();
			log.info("-----------getServiceBean() error---------");
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<BbRelCorp> selectInformationRelCorp(Map map, Pagination pn){
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		return service.selectInformationRelCorp(map, pn);
	}
	@SuppressWarnings("rawtypes")
	public  List<List<BbRelCorp>> selectMembers(Map map){
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		return service.selectMembers(map);
	}
	
	public void insert(BbRelCorp record){
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		service.insert(record);
	}
	
	@SuppressWarnings("rawtypes")
	public CorpInfo selectCorpInfo(Map map){
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		return service.selectCorpInfo(map);
	}
	
	@SuppressWarnings("rawtypes")
	public List<RelatedAccount> getBBRelatedAccount(Map map) {
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		return service.getBBRelatedAccount(map);
	}
	
	public BbRelCorpType selectBbRelCorpType(String type){
		BbRelCorpTypeService service = this.getBbRelCorpTypeServiceBean();
		return service.selectByPrimaryKey(type);
	}
	
	public List<BbRelCorpType> selectBbRelCorpTypeByParent(String parentType){
		BbRelCorpTypeService service = this.getBbRelCorpTypeServiceBean();
		return service.selectByParentKey(parentType);
	}
	
	public void insert(BbRelCorpAcct record) {
		BbRelCorpAcctService service = this.getBbRelCorpAcctServiceBean();
		service.insert(record);
	}

	public void insertSelective(BbRelCorpAcct record) {
		BbRelCorpAcctService service = this.getBbRelCorpAcctServiceBean();
		service.insertSelective(record);
	}
	
	public BbRelCorp selectByPrimaryKey(Long id){
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		return service.selectByPrimaryKey(id);
	}
	
	public List<BbRelCorpAcct> selectAccountByCifNo(String cifNo) {
		BbRelCorpAcctService service = this.getBbRelCorpAcctServiceBean();
		return service.selectAccountByCifNo(cifNo);
	}
	
	public void updateRelationCorp(BbRelCorp bbRelCorp,
			List<BbRelCorpAcct> insertList, List<BbRelCorpAcct> updateList,
			List<BbRelCorpAcct> removeList) {
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		service.updateRelationCorp(bbRelCorp, insertList, updateList, removeList);
	}
	
	public void removeRelationCorp(BbRelCorp bbRelCorp,
			List<BbRelCorpAcct> removeList) {
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		service.removeRelationCorp(bbRelCorp, removeList);
	}

	public List<MemberCompany> getListRelCorps(Map<Object, Object> map2) {
		BbRelCorpService service = this.getBbRelCorpServiceBean();
		return service.getListRelCorps(map2);
		
	}
}
