/**
 *
 */
package com.seatech.ibs.admin.delegate.tax.rpt;

import java.util.List;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.base.BTTLog;
import com.ibm.btt.base.BTTLogFactory;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.service.tax.rpt.Rpt02NDTService;
import com.seatech.ibs.admin.tax.rpt.Rpt02NDT;
import com.seatech.ibs.admin.tax.rpt.Rpt02NDTExample;

/**
 * @author le
 *
 */
public class Rpt02NDTDelegate {

	private static final BTTLog log = BTTLogFactory.getLog(Rpt02NDTDelegate.class.getName());

	private Rpt02NDTService getRpt02NDTService() {
		return (Rpt02NDTService) WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean("Rpt02NDTService");
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt02NDTService#countRpt02NDTByExample(com.seatech.ibs.admin.tax.rpt.Rpt02NDTExample)
	 */

	public int countRpt02NDTByExample(Rpt02NDTExample example) {
		return getRpt02NDTService().countRpt02NDTByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt02NDTService#deleteRpt02NDTByExample(com.seatech.ibs.admin.tax.rpt.Rpt02NDTExample)
	 */

	public int deleteRpt02NDTByExample(Rpt02NDTExample example) {
		return getRpt02NDTService().deleteRpt02NDTByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt02NDTService#insertRpt02NDT(com.seatech.ibs.admin.tax.rpt.Rpt02NDT)
	 */

	public void insertRpt02NDT(Rpt02NDT record) {
		getRpt02NDTService().insertRpt02NDTSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt02NDTService#insertRpt02NDTSelective(com.seatech.ibs.admin.tax.rpt.Rpt02NDT)
	 */

	public void insertRpt02NDTSelective(Rpt02NDT record) {
		getRpt02NDTService().insertRpt02NDTSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt02NDTService#selectRpt02NDTByExample(com.seatech.ibs.admin.tax.rpt.Rpt02NDTExample)
	 */

	public List<Rpt02NDT> selectRpt02NDTByExample(Rpt02NDTExample example) {
		return getRpt02NDTService().selectRpt02NDTByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt02NDTService#updateRpt02NDTByExampleSelective(com.seatech.ibs.admin.tax.rpt.Rpt02NDT, com.seatech.ibs.admin.tax.rpt.Rpt02NDTExample)
	 */

	public int updateRpt02NDTByExampleSelective(Rpt02NDT record, Rpt02NDTExample example) {
		return getRpt02NDTService().updateRpt02NDTByExampleSelective(record, example);
	}

	/* (non-Javadoc)
	 * @see com.seatech.ibs.admin.service.tax.rpt.Rpt02NDTService#updateRpt02NDTByExample(com.seatech.ibs.admin.tax.rpt.Rpt02NDT, com.seatech.ibs.admin.tax.rpt.Rpt02NDTExample)
	 */

	public int updateRpt02NDTByExample(Rpt02NDT record, Rpt02NDTExample example) {
		return getRpt02NDTService().updateRpt02NDTByExample(record, example);
	}


}
