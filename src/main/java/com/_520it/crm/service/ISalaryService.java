package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Salary;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SalaryQueryObject;

public interface ISalaryService {
	int deleteByPrimaryKey(Long id);

	int insert(Salary record);

	Salary selectByPrimaryKey(Long id);

	List<Salary> selectAll();

	int updateByPrimaryKey(Salary record);
	
	PageResult pageQuery(SalaryQueryObject qo);
}
