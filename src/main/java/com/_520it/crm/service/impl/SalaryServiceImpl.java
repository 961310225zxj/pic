package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Salary;
import com._520it.crm.mapper.SalaryMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SalaryQueryObject;
import com._520it.crm.service.ISalaryService;

@Service
public class SalaryServiceImpl implements ISalaryService {
	@Autowired
	private SalaryMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Salary record) {
		return mapper.insert(record);
	}

	@Override
	public Salary selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Salary> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Salary record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult pageQuery(SalaryQueryObject qo) {
		Long count = mapper.countQo(qo);
		if(count == 0){
			return new PageResult(count, Collections.EMPTY_LIST);
		}
		return new PageResult(count, mapper.selectQo(qo));
	}
}
