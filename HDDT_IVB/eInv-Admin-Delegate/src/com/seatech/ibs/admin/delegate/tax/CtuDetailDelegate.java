/**
 *
 */
package com.seatech.ibs.admin.delegate.tax;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.corp.pojo.tax.CtuDetail;
import com.seatech.ibs.corp.pojo.tax.CtuDetailExample;
import com.seatech.ibs.admin.service.tax.CtuDetailService;

/**
 * @author le
 *
 */
public class CtuDetailDelegate {

	private CtuDetailService getCtuDetailDelegate() {
		return (CtuDetailService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("CtuDetailService");
	}

	public int countCtuDetailByExample(CtuDetailExample example) {
		return getCtuDetailDelegate().countCtuDetailByExample(example);
	}

	public int deleteCtuDetailByExample(CtuDetailExample example) {
		return getCtuDetailDelegate().deleteCtuDetailByExample(example);
	}

	public int deleteCtuDetailByPrimaryKey(Long id, String maDthu, Integer maNv, Integer ngayKb, String shkb, Integer soBt) {
		return getCtuDetailDelegate().deleteCtuDetailByPrimaryKey(id, maDthu, maNv, ngayKb, shkb, soBt);
	}

	public void insertCtuDetail(CtuDetail record) {
		getCtuDetailDelegate().insertCtuDetail(record);
	}

	public void insertCtuDetailSelective(CtuDetail record) {
		getCtuDetailDelegate().insertCtuDetailSelective(record);
	}

	public List<CtuDetail> selectCtuDetailByExample(CtuDetailExample example) {
		return getCtuDetailDelegate().selectCtuDetailByExample(example);
	}

	public CtuDetail selectCtuDetailByPrimaryKey(Long id, String maDthu, Integer maNv, Integer ngayKb, String shkb, Integer soBt) {
		return getCtuDetailDelegate().selectCtuDetailByPrimaryKey(id, maDthu, maNv, ngayKb, shkb, soBt);
	}

	public int updateCtuDetailByExampleSelective(CtuDetail record, CtuDetailExample example) {
		return getCtuDetailDelegate().updateCtuDetailByExampleSelective(record, example);
	}

	public int updateCtuDetailByExample(CtuDetail record, CtuDetailExample example) {
		return getCtuDetailDelegate().updateCtuDetailByExample(record, example);
	}

	public int updateCtuDetailByPrimaryKeySelective(CtuDetail record) {
		return getCtuDetailDelegate().updateCtuDetailByPrimaryKeySelective(record);
	}

	public int updateCtuDetailByPrimaryKey(CtuDetail record) {
		return getCtuDetailDelegate().updateCtuDetailByPrimaryKey(record);
	}
}
