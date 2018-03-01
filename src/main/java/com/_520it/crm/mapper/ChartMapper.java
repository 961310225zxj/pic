package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.query.ChartQueryObject;
import com._520it.crm.vo.ChartVO;

//FormalClient 正式客户
//LatentClient 潜在客户
public interface ChartMapper {
	/**
	 * 高级查询接口
	 * @return
	 */
	//真实客户
	List<ChartVO> queryRealChart(ChartQueryObject qo);
	//潜在客户
	List<ChartVO> queryPotentialChart(ChartQueryObject qo);
	
	//饼图接口
	List<ChartVO> queryCarChart(ChartQueryObject qo);
}
