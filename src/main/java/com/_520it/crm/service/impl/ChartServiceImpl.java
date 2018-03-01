package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.mapper.ChartMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ChartQueryObject;
import com._520it.crm.service.IChartService;
import com._520it.crm.vo.ChartVO;
@Service
public class ChartServiceImpl implements IChartService{

	@Autowired
	private ChartMapper chartMapper;
	
	@Override
	public PageResult queryRealChart(ChartQueryObject qo) {
		qo.setState(ChartQueryObject.REAL_STATE);
		List<ChartVO> list = chartMapper.queryRealChart(qo);
		Long rows = new Integer(list.size()).longValue();
		return new PageResult(rows, list);
	}

	@Override
	public PageResult queryPotentialChart(ChartQueryObject qo) {
		qo.setState(ChartQueryObject.POTENTIAL_STATE);
		List<ChartVO> list = chartMapper.queryPotentialChart(qo);
		Long rows = new Integer(list.size()).longValue();
		return new PageResult(rows, list);
	}

	@Override
	public PageResult queryCarChart(ChartQueryObject qo) {
		List<ChartVO> list = chartMapper.queryCarChart(qo);
		Long rows = new Integer(list.size()).longValue();
		return new PageResult(rows, list);
	}


}
