package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Recognizee;
import com._520it.crm.mapper.RecognizeeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IRecognizeeService;
@Service
public class RecognizeeServiceImpl implements IRecognizeeService {
	@Autowired
	private RecognizeeMapper recognizeeMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return recognizeeMapper.deleteByPrimaryKey(id);
	}

	public int insert(Recognizee record) {
		return recognizeeMapper.insert(record);
	}

	public Recognizee selectByPrimaryKey(Long id) {
		return recognizeeMapper.selectByPrimaryKey(id);
	}

	public List<Recognizee> selectAll() {
		return recognizeeMapper.selectAll();
	}

	public int updateByPrimaryKey(Recognizee record) {
		return recognizeeMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = recognizeeMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Recognizee> result = recognizeeMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
