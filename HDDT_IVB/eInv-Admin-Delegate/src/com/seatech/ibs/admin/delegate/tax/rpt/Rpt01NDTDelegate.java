/**
 *
 */
package com.seatech.ibs.admin.delegate.tax.rpt;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.tax.rpt.Rpt01NDTService;
import com.seatech.ibs.admin.tax.rpt.Rpt01NDT;
import com.seatech.ibs.admin.tax.rpt.Rpt01NDTExample;

/**
 * @author le
 *
 */
public class Rpt01NDTDelegate {

	private static final BTTLog log = BTTLogFactory.getLog(Rpt01NDTDelegate.class.getName());

	private Rpt01NDTService getRpt01NDTService() {
		return (Rpt01NDTService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("Rpt01NDTService");
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt01NDTService#countRpt01NDTByExample(com.seatech.ibs.admin.tax.rpt.Rpt01NDTExample)
	 */

	public int countRpt01NDTByExample(Rpt01NDTExample example) {
		return getRpt01NDTService().countRpt01NDTByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt01NDTService#deleteRpt01NDTByExample(com.seatech.ibs.admin.tax.rpt.Rpt01NDTExample)
	 */

	public int deleteRpt01NDTByExample(Rpt01NDTExample example) {
		return getRpt01NDTService().deleteRpt01NDTByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt01NDTService#insertRpt01NDT(com.seatech.ibs.admin.tax.rpt.Rpt01NDT)
	 */

	public void insertRpt01NDT(Rpt01NDT record) {
		getRpt01NDTService().insertRpt01NDTSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt01NDTService#insertRpt01NDTSelective(com.seatech.ibs.admin.tax.rpt.Rpt01NDT)
	 */

	public void insertRpt01NDTSelective(Rpt01NDT record) {
		getRpt01NDTService().insertRpt01NDTSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt01NDTService#selectRpt01NDTByExample(com.seatech.ibs.admin.tax.rpt.Rpt01NDTExample)
	 */

	public List<Rpt01NDT> selectRpt01NDTByExample(Rpt01NDTExample example) {
		return getRpt01NDTService().selectRpt01NDTByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt01NDTService#updateRpt01NDTByExampleSelective(com.seatech.ibs.admin.tax.rpt.Rpt01NDT, com.seatech.ibs.admin.tax.rpt.Rpt01NDTExample)
	 */

	public int updateRpt01NDTByExampleSelective(Rpt01NDT record, Rpt01NDTExample example) {
		return getRpt01NDTService().updateRpt01NDTByExampleSelective(record, example);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt01NDTService#updateRpt01NDTByExample(com.seatech.ibs.admin.tax.rpt.Rpt01NDT, com.seatech.ibs.admin.tax.rpt.Rpt01NDTExample)
	 */

	public int updateRpt01NDTByExample(Rpt01NDT record, Rpt01NDTExample example) {
		return getRpt01NDTService().updateRpt01NDTByExample(record, example);
	}


}
