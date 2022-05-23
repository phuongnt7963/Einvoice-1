
package com.seatech.ibs.admin.delegate.corp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.delegate.messagetemplate.MessageTransmitterDelegate;
import com.seatech.ibs.admin.delegate.sys.SysParameterDelegate;
import com.seatech.ibs.admin.pojo.sys.SysParameter;
import com.seatech.ibs.admin.service.corp.BBCorpInfoService;
import com.seatech.ibs.admin.service.user.BBUserInfoService;
import com.seatech.ibs.admin.service.user.CorpActiveCodeService;
import com.seatech.ibs.common.MD5Password;
import com.seatech.ibs.common.config.SysConfigure;
import com.seatech.ibs.common.constant.AdminAppConstant;
import com.seatech.ibs.common.constant.AppConstant;
import com.seatech.ibs.common.constant.CorpAppConstant;
import com.seatech.ibs.common.dto.Criterion;
import com.seatech.ibs.common.dto.Pagination;
import com.seatech.ibs.common.util.DateTimeUtil;
import com.seatech.ibs.common.util.RandomPasswordUtil;
import com.seatech.ibs.corp.pojo.account.RelatedAccount;
import com.seatech.ibs.corp.pojo.corp.CorpInfo;
import com.seatech.ibs.corp.pojo.user.ActiveCode;
import com.seatech.ibs.corp.pojo.user.UserInfo;
import com.seatech.ibs.service.exception.IBSServiceException;


public class BBCorpInfoDelegate {

	public Integer getCorpSeq() throws Exception {
		BBCorpInfoService service = this.getCorpInfoBean();
        return service.getCorpSeq();
	}

	public CorpInfo getCorpInfoById(int corpId) throws Exception {
		BBCorpInfoService service = this.getCorpInfoBean();
        return service.getCorpInfoById(corpId);
	}
	public String getTaxCod(String cif) throws Exception {
		BBCorpInfoService service = this.getCorpInfoBean();
		String taxCode= service.getTaxCod(cif);
		if(taxCode==null){
			return "";
		}
		return taxCode;

	}
    public void auditBBCorpInfo(CorpInfo corpInfo) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        service.auditBBCorpInfo(corpInfo);
    }

    public void auditBBCorpInfoBK(CorpInfo corpInfo, String currentStatus) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        service.auditBBCorpInfoBK(corpInfo, currentStatus);
    }

    public void deleteBBCorpInfo(int pCorpId) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        service.deleteBBCorpInfo(pCorpId);
    }

    public void deleteBBCorpInfoBK(int pCorpId, String status) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("pCorpId", pCorpId);
		map.put("pStatus", status);
        BBCorpInfoService service = this.getCorpInfoBean();
        service.deleteBBCorpInfoBK(map);
    }

    public List<CorpInfo> selectCorpListPending(CorpInfo corpInfo, Pagination pn)
    throws Exception {
    	BBCorpInfoService service = this.getCorpInfoBean();
    	return service.selectCorpListPending(corpInfo, pn);
    }

    public CorpInfo getCorpForEdit(int corpId) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.getCorpForEdit(corpId);
    }

    public CorpInfo getCorpId(int corpId) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.getCorpId(corpId);
    }

    public void insertBBCorpInfoBK(CorpInfo corpInfo) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        service.insertBBCorpInfoBK(corpInfo);
    }

    public List<Map<String, Object>> insertBBCorpInfo(CorpInfo corpInfo, List<UserInfo> userList, List<RelatedAccount> accountList) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.insertCorpRegisterInfo(corpInfo, userList, accountList);
    }
    public boolean insertRelatedAccount(int corpId, int userIdAdmin, List<String> accountList) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.insertRelatedAccount(corpId, userIdAdmin, accountList);
    }

    public List<CorpInfo> selectBBCorpInfo(CorpInfo corpInfo, Pagination pn) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.selectBBCorpInfo(corpInfo, pn);
    }

    public void updateBBCorpInfo(CorpInfo corpInfo) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        service.updateBBCorpInfo(corpInfo);
    }

    public void updateBKCorpInfo(CorpInfo corpInfo) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        service.updateBKCorpInfo(corpInfo);
    }

    @SuppressWarnings("rawtypes")
	public List findGroupIdNameList() throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.findGroupIdNameList();
    }


    public int findIdByName(String pCorpName) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.findIdByName(pCorpName);
    }


    public int findIdByUserNamePwd(String pUserName, String pPassword) throws Exception {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.findIdByNamePwd(pUserName, pPassword);
    }


    public List<CorpInfo> queryCorpInfoByParameter(String parameter, Pagination pn) throws IBSServiceException {
        BBCorpInfoService service = this.getCorpInfoBean();
        return service.queryCorpInfoByParameter(parameter, pn);
    }


    public void createEmailToAllUser(List<Map<String, Object>> userAndActiveCodeList, String receiveId, String templateCode) throws Exception {
        for (int i = 0; i < userAndActiveCodeList.size(); i++) {
            Map<String, Object> userInfoAndActiveCodeMap = userAndActiveCodeList.get(i);
            UserInfo userInfo = (UserInfo) userInfoAndActiveCodeMap.get("userInfo");
            BBUserInfoService service = this.getBBUserInfoService();

                ActiveCode activeCode = createActiveCodeByUserInfo(userInfo);
                String noMd5Password = (String) userInfoAndActiveCodeMap.get("noMd5Password");
                String url = SysConfigure.getWebSite("corpURL");
                url = url + "active?code=" + activeCode.getCode();
                String userRoleName = service.getUserRoleByUserRoleId(userInfo.getRoleId()).getRoleName();
                createEmail(userInfo, receiveId, noMd5Password, url,userRoleName, templateCode);

        }
    }

    public void createEmailToSingleUser(UserInfo userInfo, Integer checkerId, String noMd5Password, String noMd5TradePassword, String receiveId, String templateCode) throws Exception {
        CorpInfo corpInfo = getCorpId(userInfo.getCorpId());
    	BBUserInfoService service = this.getBBUserInfoService();
        ActiveCode activeCode = createActiveCodeByUserInfo(userInfo);
        String url = SysConfigure.getWebSite("corpURL");
        url = url + "active?code=" + activeCode.getCode();
        String userRoleName = service.getUserRoleByUserRoleId(userInfo.getRoleId()).getRoleName();
        createEmail(userInfo, receiveId, noMd5Password, url, userRoleName, templateCode);
        if(templateCode.equals(AdminAppConstant.SYS_EMAIL_CORP_REGISTER_CODE) || templateCode.equals(AdminAppConstant.SYS_EMAIL_RESET_PASSWORD_CODE))
        	savePrintedInfo(userInfo, corpInfo, checkerId, noMd5Password, noMd5TradePassword, AdminAppConstant.SYS_PRINT_PASSWORD_CODE);
    }


    public void createEmailToAllCorpUser(List<UserInfo> userInfoList,CorpInfo corpInfo, Integer checkerId, String receiveId, String templateCode) throws Exception {

        BBUserInfoService service = this.getBBUserInfoService();

        for (int i = 0; i < userInfoList.size(); i++) {
            UserInfo userInfo = userInfoList.get(i);
            UserInfo newUserInfo = new UserInfo();
            String randomPwd = RandomPasswordUtil.getMixRandom(8);
            String tradePwd = RandomPasswordUtil.getMixRandom(8);
            String md5Password = MD5Password.SHA256Pwd(randomPwd);
            String md5TradePassword = MD5Password.SHA256Pwd(tradePwd);
            newUserInfo.setUserId(userInfo.getUserId());
            newUserInfo.setLoginPwd(md5Password);
            newUserInfo.setTradePwd(md5TradePassword);
            service.updateUserInfoSelective(newUserInfo);
            ActiveCode activeCode = createActiveCodeByUserInfo(userInfo);
            String userRoleName = service.getUserRoleByUserRoleId(userInfo.getRoleId()).getRoleName();
            /*
             * ANHLD.13.09.2018
             * Change to query active url from bk_sys_parameter (type='app_url', code='PORTAL_ACTIVE_ACCT')
             */
            SysParameterDelegate paraDelegate = new SysParameterDelegate();
            SysParameter sysParameter = paraDelegate.getSysParameterByTypeCode("IB", "app_url", "PORTAL_ACTIVE_ACCT");
//            String url = SysConfigure.getWebSite("corpURL");
            String url = sysParameter.getName();
            url = url + activeCode.getCode();
            createEmail(userInfo, receiveId, randomPwd, url, userRoleName, templateCode);
            savePrintedInfo(userInfo, corpInfo, checkerId, randomPwd, tradePwd, AdminAppConstant.SYS_PRINT_PASSWORD_CODE);
        }

    }

    public void savePrintedInfo(UserInfo userInfo,CorpInfo bbCorpInfo,Integer checkerId, String pPassword, String tradePassword, String templateCode)
    throws Exception {
			Map<String, Object> params2 = new HashMap<String, Object>();
			params2.put("%user_name%", userInfo.getUserName());
			params2.put("%password%", pPassword);
			params2.put("%trade_password%", tradePassword);
			params2.put("%serviceType%", templateCode);
			params2.put("%userId%", userInfo.getUserId());
			params2.put("%sysCode%", AppConstant.SYS_CODE_BB);
			params2.put("%groupId%", bbCorpInfo.getGroupId());
			params2.put("%groupMbsId%", bbCorpInfo.getGroupIdMBS());
			params2.put("%groupSmsId%", bbCorpInfo.getGroupIdSMS());
			params2.put("%create_by%", checkerId);
			params2.put("%email%", userInfo.getEmail());
			params2.put("%userGroup%", templateCode);
			new MessageTransmitterDelegate().savePrintedInfo(params2);
	}

    public void createEmail(UserInfo userInfo, String receiveId, String password, String activeUrl, String userRoleName, String templateCode) throws Exception {

        Map<String, Object> params2 = new HashMap<String, Object>();
        params2.put("%receiverId%", receiveId);
        params2.put("%userName%", userInfo.getUserName());
        params2.put("%email%", userInfo.getEmail());
        params2.put("%emailTitle%", CorpAppConstant.EMAIL_EMAILTITLE);
        params2.put("%password%", password);
        params2.put("%bankTitle%", CorpAppConstant.EMAIL_BANKTITLE);

        params2.put("%serviceType%", templateCode);
        params2.put("%dateTime%", DateTimeUtil.getCurrentDateTime());
        params2.put("%url%", activeUrl);
        params2.put("%roleName%", userRoleName);
        params2.put("%userId%", userInfo.getUserId());
        params2.put("%userGroup%", templateCode);
        new MessageTransmitterDelegate().createEmail(params2);
    }


    public List<UserInfo> queryAllUserInfoByCorpId(int pCorpId) throws Exception {
        return getCorpInfoBean().queryAllUserInfoByCorpId(pCorpId);
    }

    public ActiveCode queryActiveCodeByUserId(int pUserId) throws Exception {
        CorpActiveCodeService corpActiveCodeService = (CorpActiveCodeService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean(
                "adminCorpActiveCodeService");
        return corpActiveCodeService.queryActiveCodeByUserId(pUserId);
    }

    public ActiveCode createActiveCodeByUserInfo(UserInfo pUserInfo) throws Exception {
        CorpActiveCodeService corpActiveCodeService = (CorpActiveCodeService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean(
                "adminCorpActiveCodeService");
        return corpActiveCodeService.getActiveCodeByUserInfo(pUserInfo);
    }


    public List<CorpInfo> queryBBCorpInfoSelective(Criterion criterion) throws Exception {
        List<CorpInfo> list = (List<CorpInfo>) getCorpInfoBean().queryBBCorpInfoSelective(criterion);
        return list;
    }

    public List<CorpInfo> queryBBCorpInfoSelectiveBK(Criterion criterion) throws Exception {
        List<CorpInfo> list = (List<CorpInfo>) getCorpInfoBean().queryBBCorpInfoSelectiveBK(criterion);
        return list;
    }

    public int updtBBCorpInfoSelective(CorpInfo corpInfo) throws Exception {
        int rows = getCorpInfoBean().updtBBCorpInfoSelective(corpInfo);
        return rows;
    }

    public void updateCorpInfoSelective(CorpInfo corpInfo) throws Exception {
        getCorpInfoBean().updateCorpInfoSelective(corpInfo);
    }

    public void updtCorpInfoAndUserInfoStatus(CorpInfo corpInfo) throws Exception {
        getCorpInfoBean().updtCorpAndUserStatus(corpInfo);
    }

    public void updateMakerChange(CorpInfo corpInfo)throws Exception {
    	getCorpInfoBean().updateMakerChange(corpInfo);
    }

    public void generateLog(CorpInfo corpInfo)throws Exception{
    	getCorpInfoBean().generateLog(corpInfo);
    }

    public void createLog (CorpInfo corpInfo, String changeType, String oldContent, String newContent) throws Exception {
    	getCorpInfoBean().createLog(corpInfo, changeType, oldContent, newContent);
    }

    public void updateLog(int userId, String changeType, int approveId, String approveStatus, int appLogId) throws Exception {
    	getCorpInfoBean().updateLog(userId, changeType, approveId, approveStatus, appLogId);
    }

    public void enableBBCorpInfo(CorpInfo corpInfo) throws Exception {
    	getCorpInfoBean().enableBBCorpInfo(corpInfo);
	}

    private BBCorpInfoService getCorpInfoBean() {
        return (BBCorpInfoService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("corpInfoService");
    }

    private BBUserInfoService getBBUserInfoService() {
        return (BBUserInfoService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("userInfoService");
    }




}
