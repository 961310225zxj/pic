package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Plan;
import com._520it.crm.mapper.PlanMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PlanQueryObject;
import com._520it.crm.service.IPlanService;

@Service
public class PlanServiceImpl implements IPlanService {
	@Autowired
	private PlanMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Plan p) {
		p.setPlandate(new Date());
		p.setState(0);
		return mapper.insert(p);
	}

	@Override
	public Plan selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Plan> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Plan p) {
		p.setPlandate(new Date());
		p.setState(0);
		return mapper.updateByPrimaryKey(p);
	}

	@Override
	public void marksuccess(Long id) {
		mapper.marksuccess(id);
	}

	@Override
	public void markfailed(Long id) {

		mapper.markfailed(id);
	}

	@Override
	public int updateHandleMsg(Plan p) {
		return mapper.updateHandleMsg(p);
	}

	@Override
	public PageResult pageQuery(PlanQueryObject qo) {
		Long count = mapper.countQo(qo);
		if (count == 0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}
		return new PageResult(count, mapper.listQo(qo));
	}
}
