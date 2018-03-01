package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Plan;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PlanQueryObject;

public interface IPlanService {
	int deleteByPrimaryKey(Long id);

	void marksuccess(Long id);

	void markfailed(Long id);

	int insert(Plan record);

	Plan selectByPrimaryKey(Long id);

	List<Plan> selectAll();

	int updateByPrimaryKey(Plan record);

	int updateHandleMsg(Plan record);

	PageResult pageQuery(PlanQueryObject qo);
}
