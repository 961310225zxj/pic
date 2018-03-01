package com._520it.crm.mapper;

import com._520it.crm.domain.Salary;
import com._520it.crm.query.SalaryQueryObject;

import java.util.List;

public interface SalaryMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Salary record);

	Salary selectByPrimaryKey(Long id);

	List<Salary> selectAll();

	int updateByPrimaryKey(Salary record);
	
	List<Salary> selectQo(SalaryQueryObject qo);
	
	Long countQo(SalaryQueryObject qo);
}