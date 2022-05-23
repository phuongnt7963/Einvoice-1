package com.seatech.ibs.admin.delegate.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.delegate.account.BCRelatedAccountDelegate;
import com.seatech.ibs.admin.delegate.messagetemplate.MessageTransmitterDelegate;
import com.seatech.ibs.admin.pojo.account.AccountInfo;
import com.seatech.ibs.admin.pojo.bank.CIF;
import com.seatech.ibs.admin.pojo.user.CertType;
import com.seatech.ibs.admin.service.account.BKAccountInfoService;
import com.seatech.ibs.admin.service.certtype.CertTypeService;
import com.seatech.ibs.admin.service.cif.CifService;
import com.seatech.ibs.admin.service.user.BCUserInfoService;
import com.seatech.ibs.admin.service.user.RetailActiveCodeService;
import com.seatech.ibs.common.MD5Password;
import com.seatech.ibs.common.config.SysConfigure;
import com.seatech.ibs.common.constant.AppConstant;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.DateTimeUtil;
import com.seatech.ibs.common.util.SpringBeanDelegate;
import com.seatech.ibs.retail.pojo.account.RelatedAccount;
import com.seatech.ibs.retail.pojo.user.ActiveCode;
import com.seatech.ibs.retail.pojo.user.UserInfo;
import com.seatech.ibs.service.exception.IBSServiceException;


public class BCUserInfoDelegate {

    public void auditBCUserInfo(UserInfo userInfo) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        service.auditBCUserInfo(userInfo);
    }

    public void auditBKUserInfo(UserInfo userInfo, String currentStatus) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        service.auditBKUserInfo(userInfo, currentStatus);
    }

    public void deleteBCUserInfo(int pCorpId) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        service.deleteBCUserInfo(pCorpId);
    }

    public UserInfo getUserId(int userId) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.getUserId(userId);
    }
    public UserInfo getUserIdActive(int userId) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.getUserIdActive(userId);
    }

    public void insertBCUserInfo(UserInfo userInfo) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        service.insertBCUserInfo(userInfo);
    }


    @SuppressWarnings("unused")
	public int insertBCUserInfo(UserInfo userInfo, String cifNo, int curUserId, List<AccountInfo> acctList) throws Exception {
        List<RelatedAccount> relatedAccountList = null;
        if (acctList != null && acctList.size() > 0) {
            relatedAccountList = new ArrayList<RelatedAccount>();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            for (int i = 0; i < acctList.size(); i++) {
                AccountInfo accountInfo = acctList.get(i);
                String acctNo = accountInfo.getAcctNo();
                String status = accountInfo.getStatus();
                if (acctNo == null || "".equals(acctNo) || status==null || !AppConstant.ACCOUNT_STATUS_ACTV.equalsIgnoreCase(status))
                    continue;
                RelatedAccount relatedAccount = new RelatedAccount();
                relatedAccount.setAcctNo(accountInfo.getAcctNo());
                relatedAccount.setAcctType(accountInfo.getAcctType());
                relatedAccount.setIsMaster("N");
                relatedAccount.setAlias(accountInfo.getAcctName());
                relatedAccount.setStatus(accountInfo.getStatus());
                relatedAccount.setCreateBy(curUserId);
                relatedAccount.setCreateTime(timestamp);
                relatedAccount.setUpdateBy(-1);
                relatedAccountList.add(relatedAccount);
            }
        }
        BCUserInfoService service = this.getUserInfoBean();
        return service.insertBCUserInfo(userInfo, relatedAccountList);
    }

    public List<UserInfo> selectBCUserInfo(UserInfo userInfo, Pagination pn) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.selectBCUserInfo(userInfo, pn);
    }


    public void updateBCUserInfoChange(UserInfo userInfo) throws Exception {
    	BCUserInfoService service = this.getUserInfoBean();
    	service.updateBCUserInfoChange(userInfo);
    }

    public void updateBKUserInfoChange(UserInfo userInfo) throws Exception {
    	BCUserInfoService service = this.getUserInfoBean();
    	service.updateBKUserInfoChange(userInfo);
    }

    public int updateBCUserInfo(UserInfo userInfo) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.updateBCUserInfoBySelectField(userInfo);
    }

    public void updateBCUserInfoByMaker(UserInfo userInfo) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        service.updateBCUserInfoForMaker(userInfo);
    }

    public void updateBKUserInfo(UserInfo userInfo) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        service.updateBKBySelectField(userInfo);
    }

    public void createEmail(UserInfo userInfo, String pPassword, String url, String receiveId,
    						String emailTitle, String bankTitle, String templateCode) throws Exception {
        Map<String, Object> params2 = new HashMap<String, Object>();
        params2.put("%receiverId%", receiveId);
        params2.put("%email%", userInfo.getEmail());
        params2.put("%userName%", userInfo.getUserName());
        params2.put("%emailTitle%", emailTitle);
        params2.put("%password%", pPassword);
        params2.put("%bankTitle%", bankTitle);
        params2.put("%serviceType%", templateCode);
        params2.put("%dateTime%", DateTimeUtil.getCurrentDateTime());
        params2.put("%url%", url);
        params2.put("%userId%", userInfo.getUserId());
        params2.put("%userGroup%", templateCode);
        new MessageTransmitterDelegate().createEmail(params2);

    }

    public void savePrintedInfo(UserInfo userInfo,Integer checkerId, String pPassword, String tradePassword, String templateCode)
    throws Exception {
    	String url = SysConfigure.getWebSite("retailURL");
		Map<String, Object> params2 = new HashMap<String, Object>();
		params2.put("%user_name%", userInfo.getUserName());
		params2.put("%password%", pPassword);
		params2.put("%trade_password%", tradePassword);
		params2.put("%serviceType%", templateCode);
		params2.put("%userId%", userInfo.getUserId());
		params2.put("%sysCode%", AppConstant.SYS_CODE_BC);
		params2.put("%groupId%", userInfo.getGroupId());
		params2.put("%groupMbsId%", userInfo.getGroupIdMBS());
		params2.put("%groupSmsId%", userInfo.getGroupIdSMS());
		params2.put("%create_by%", checkerId);
		params2.put("%link%", url);
		params2.put("%email%", userInfo.getEmail());
		 params2.put("%userGroup%", templateCode);
		new MessageTransmitterDelegate().savePrintedInfo(params2);

	}

    public String getActiveUrl(int pUserId) throws Exception {
        RetailActiveCodeService retailActiveCodeService = (RetailActiveCodeService) SpringBeanDelegate.getBean("adminRetailActiveCodeService");
        ActiveCode aActiveCode = new ActiveCode();
        UserInfo userInfo = getUserId(pUserId);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String code = MD5Password.SHA256Pwd((userInfo.getUserId() + userInfo.getUserName() + userInfo.getCreateTime() + userInfo.getEmail() + ts.toString()).toUpperCase());
        aActiveCode.setCode(code);
        aActiveCode.setEmail(userInfo.getEmail());
        aActiveCode.setUserId(userInfo.getUserId());
        aActiveCode.setCreateTime(ts);
        aActiveCode.setActiveTime(ts);
        aActiveCode.setStatus("NUSE");

        retailActiveCodeService.updateActiveCode(aActiveCode);

        String url = SysConfigure.getWebSite("retailURL");
        //url = url + "active?code=" + code;
        return url;
    }


    public List<UserInfo> queryBcUserInfoSelective(UserInfo userInfo) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.queryBcUserInfoSelective(userInfo);
    }


    public List<UserInfo> queryUserInfoByParameter(String parameter, Pagination pn) throws IBSServiceException {
        BCUserInfoService service = this.getUserInfoBean();
        return service.queryUserInfoByParameter(parameter, pn);
    }

    public boolean checkCifNo(String cifNo) throws Exception {
        CifService cifService = this.getCifServiceBean();
        CIF cif = cifService.selectByPrimaryKey(cifNo);
        if (cif != null) {
            return true;
        }
        else {
            return false;
        }

    }


    public boolean checkIsUserExistByCifNo(String cifNo) throws Exception {

        UserInfo userInfo = new UserInfo();
        userInfo.setCifNo(cifNo);
        List<UserInfo> userList = queryBcUserInfoSelective(userInfo);
        if (userList != null && userList.size() > 0) {
            return true;
        }
        else {
            return false;
        }

    }


    public boolean checkIsUserHaveSetRelatedAccount(Integer userId) throws Exception {
        boolean haveSetRelatedAccount = false;
        if (userId == null) {
            return haveSetRelatedAccount;
        }
        BCRelatedAccountDelegate accountDelegate = new BCRelatedAccountDelegate();
        RelatedAccount relatedAccount = new RelatedAccount();
        relatedAccount.setUserId(userId);
        List<RelatedAccount> list = accountDelegate.queryBCRelatedAccountDynamic(relatedAccount);
        if (list != null && list.size() > 0) {
            haveSetRelatedAccount = true;
        }
        return haveSetRelatedAccount;
    }

    public void freezedBCUser(Map<String, Object> map) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        service.freezedBCUser(map);
    }


    public List<AccountInfo> getAccountByCifNo(String cifNo) throws Exception {
        BKAccountInfoService accountInfoService = this.getAccountInfoServiceBean();
        List<AccountInfo> list = accountInfoService.selectAccountListByCifNo(cifNo);
        return list;
    }

    public List<CertType> getCertTypeList(CertType certType) throws Exception {
        return getCertTypeServiceBean().queryCertTypeSelective(certType);
    }

    public List<UserInfo> queryBcUserInfoByCondition(Criterion pCriterion) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.queryBcUserInfoByCondition(pCriterion);
    }
    public List<UserInfo> queryBcUserInfoBkByCondition(Criterion pCriterion) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.queryBcUserInfoBkByCondition(pCriterion);
    }

    private BCUserInfoService getUserInfoBean() {
        return (BCUserInfoService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("userInfoRetailService");
    }

    private CifService getCifServiceBean() {
        return (CifService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("cifService");
    }

    private CertTypeService getCertTypeServiceBean() {
        return (CertTypeService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("adminCertTypeService");
    }

    private BKAccountInfoService getAccountInfoServiceBean() {
        return (BKAccountInfoService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("accountInfoService");
    }


    public UserInfo getUserInfoByUserName(String userName) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.getUserInfoByUserName(userName);
    }
    @SuppressWarnings("rawtypes")
	public void deleteBK(Map map) throws Exception{
    	 BCUserInfoService service = this.getUserInfoBean();
	      service.deleteBK(map);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void delete(int userId,String status) throws Exception{
      	 BCUserInfoService service = this.getUserInfoBean();
      	 Map map = new HashMap<String, Object>();
		 map.put("userId", userId);
		 map.put("status", status);
   	      service.delete(map);
      }
    public void deleteBK(int userId,String status) throws Exception{
   	 BCUserInfoService service = this.getUserInfoBean();
	      service.deleteBK(userId,status);
   }
	public void updateBK(UserInfo userInfo) throws Exception{
		  BCUserInfoService service = this.getUserInfoBean();
	      service.updateBK(userInfo);
	    }
	@SuppressWarnings("rawtypes")
	public List<UserInfo> getBK(Map map) throws Exception{
		  BCUserInfoService service = this.getUserInfoBean();
	      return service.getBK(map);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UserInfo getBK(int userId,String status) throws Exception{
		  Map map = new HashMap<String, Object>();
		  map.put("userId", userId);
		  map.put("status", status);
		  BCUserInfoService service = this.getUserInfoBean();
		  List<UserInfo> list = service.getBK(map);
		  if(list.size()>0){
			  return list.get(0);
		  }
		  return null;
	}

	public int checkUserNameExits(String userName) throws Exception{
		BCUserInfoService service = this.getUserInfoBean();
		return service.checkUserExits(userName);
	}

	@SuppressWarnings("rawtypes")
	public List<UserInfo> queryBcUserInfoBkByConditionForApprove(Map map) throws Exception{
		  BCUserInfoService service = this.getUserInfoBean();
	      return service.queryBcUserInfoBkByConditionForApprove(map);
	}

	public void deleteAllBKRecordByUserID(int userId) throws Exception {
		BCUserInfoService service = this.getUserInfoBean();
		service.deleteAllBKRecordByUserID(userId);
	}
	public UserInfo selectBCUserInfoForEdit(UserInfo userInfo) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.selectBCUserInfoForEdit(userInfo);
    }

	public List<UserInfo> selectBCUserInfoForMaker(UserInfo userInfo, Pagination pn) throws Exception {
        BCUserInfoService service = this.getUserInfoBean();
        return service.selectBCUserInfoForMaker(userInfo, pn);
    }

//	public int createLog(UserInfo userInfo, int userId, String changeType, String oldContent, String newContent) throws Exception
//	{
//		BCUserInfoService service = this.getUserInfoBean();
//        return service.createLog(userInfo, userId, changeType, oldContent, newContent);
//	}

	public void generateLog(UserInfo userInfo) throws Exception
	{
		BCUserInfoService service = this.getUserInfoBean();
        service.generateLog(userInfo);
	}

	public int updateLog(int userId, String changeType, int approveId, String approveStatus, int appLogId) {
		BCUserInfoService service = this.getUserInfoBean();
        return service.updateLog(userId, changeType, approveId, approveStatus, appLogId);
	 }
}
