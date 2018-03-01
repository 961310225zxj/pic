package com._520it.crm.service;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.ChartQueryObject;

public interface IChartService {
	/**
	 *真实客户
	 * @return
	 */
	PageResult queryRealChart(ChartQueryObject qo);
	/**
	 *潜在客户
	 * @return
	 */
	PageResult queryPotentialChart(ChartQueryObject qo);
	//饼图接口
	PageResult queryCarChart(ChartQueryObject qo);
}
