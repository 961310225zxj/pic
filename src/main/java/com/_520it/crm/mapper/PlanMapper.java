package com._520it.crm.mapper;

import com._520it.crm.domain.Plan;
import com._520it.crm.query.PlanQueryObject;

import java.util.List;

public interface PlanMapper {
	int deleteByPrimaryKey(Long id);

	void marksuccess(Long id);

	void markfailed(Long id);

	int insert(Plan record);

	Plan selectByPrimaryKey(Long id);

	List<Plan> selectAll();

	List<Plan> listQo(PlanQueryObject qo);

	Long countQo(PlanQueryObject qo);

	int updateByPrimaryKey(Plan record);

	int updateHandleMsg(Plan record);
}