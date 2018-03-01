package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.InsuredPerson;
import com._520it.crm.mapper.InsuredPersonMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IInsuredPersonService;
@Service
public class InsuredPersonServiceImpl implements IInsuredPersonService {
	@Autowired
	private InsuredPersonMapper insuredPersonMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return insuredPersonMapper.deleteByPrimaryKey(id);
	}

	public int insert(InsuredPerson record) {
		return insuredPersonMapper.insert(record);
	}

	public InsuredPerson selectByPrimaryKey(Long id) {
		return insuredPersonMapper.selectByPrimaryKey(id);
	}

	public List<InsuredPerson> selectAll() {
		return insuredPersonMapper.selectAll();
	}

	public int updateByPrimaryKey(InsuredPerson record) {
		return insuredPersonMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = insuredPersonMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<InsuredPerson> result = insuredPersonMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
