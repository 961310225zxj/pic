package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Checktable;
import com._520it.crm.domain.Employee;

public interface IChecktableService {
	int deleteByPrimaryKey(Long id);

	int insert(Checktable record);

	//Checktable selectByPrimaryKey(Long id);

	List<Checktable> selectAll();

	int updateByPrimaryKey(Checktable record);
	
	int checkedTable(Checktable ct);
	
	List<Checktable> exportChecktable();
}
