/**
 *
 */
package com.seatech.ibs.admin.delegate.tax;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.corp.pojo.tax.CtuHeader;
import com.seatech.ibs.corp.pojo.tax.CtuHeaderExample;
import com.seatech.ibs.admin.service.tax.CtuHeaderService;
import com.seatech.ibs.service.exception.IBSServiceException;

/**
 * @author le
 *
 */
public class CtuHeaderDelegate {
	private CtuHeaderService getCtuHeaderDelegate() {
		return (CtuHeaderService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("CtuHeaderService");
	}

	public int countCtuHeaderByExample(CtuHeaderExample example) throws IBSServiceException {
		return getCtuHeaderDelegate().countCtuHeaderByExample(example);
	}

	public int deleteCtuHeaderByExample(CtuHeaderExample example) throws IBSServiceException {
		return getCtuHeaderDelegate().deleteCtuHeaderByExample(example);
	}

	public int deleteCtuHeaderByPrimaryKey(String maDthu, Integer maNv, Integer ngayKb, String shkb, Integer soBt) throws IBSServiceException {
		return getCtuHeaderDelegate().deleteCtuHeaderByPrimaryKey(maDthu, maNv, ngayKb, shkb, soBt);
	}

	public void insertCtuHeader(CtuHeader record) throws IBSServiceException {
		getCtuHeaderDelegate().insertCtuHeader(record);
	}

	public void insertCtuHeaderSelective(CtuHeader record) throws IBSServiceException {
		getCtuHeaderDelegate().insertCtuHeaderSelective(record);

	}

	public List<CtuHeader> selectCtuHeaderByExample(CtuHeaderExample example) throws IBSServiceException {
		return getCtuHeaderDelegate().selectCtuHeaderByExample(example);
	}

	public CtuHeader selectCtuHeaderByPrimaryKey(String maDthu, Integer maNv, Integer ngayKb, String shkb, Integer soBt) throws IBSServiceException {
		return getCtuHeaderDelegate().selectCtuHeaderByPrimaryKey(maDthu, maNv, ngayKb, shkb, soBt);
	}

	public int updateCtuHeaderByExampleSelective(CtuHeader record, CtuHeaderExample example) throws IBSServiceException {
		return getCtuHeaderDelegate().updateCtuHeaderByExampleSelective(record, example);
	}

	public int updateCtuHeaderByExample(CtuHeader record, CtuHeaderExample example) throws IBSServiceException {
		return getCtuHeaderDelegate().updateCtuHeaderByExample(record, example);
	}

	public int updateCtuHeaderByPrimaryKeySelective(CtuHeader record) throws IBSServiceException {
		return getCtuHeaderDelegate().updateCtuHeaderByPrimaryKeySelective(record);
	}

	public int updateCtuHeaderByPrimaryKey(CtuHeader record) throws IBSServiceException {
		return getCtuHeaderDelegate().updateCtuHeaderByPrimaryKey(record);
	}
}
