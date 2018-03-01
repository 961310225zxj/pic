package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Dictionary;
import com._520it.crm.mapper.DictionaryItemMapper;
import com._520it.crm.mapper.DictionaryMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IDictionaryService;
@Service
public class DictionaryServiceImpl implements IDictionaryService {
	@Autowired
	private DictionaryMapper dictionaryMapper;
	@Autowired
	private DictionaryItemMapper dictionaryItemMapper;
	public int deleteByPrimaryKey(Long id) {
		//根据父id删除外键
		dictionaryItemMapper.deleteByParentId(id);
		return dictionaryMapper.deleteByPrimaryKey(id);
	}

	public int insert(Dictionary record) {
		return dictionaryMapper.insert(record);
	}

	public Dictionary selectByPrimaryKey(Long id) {
		return dictionaryMapper.selectByPrimaryKey(id);
	}

	public List<Dictionary> selectAll() {
		return dictionaryMapper.selectAll();
	}

	public int updateByPrimaryKey(Dictionary record) {
		return dictionaryMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = dictionaryMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Dictionary> result = dictionaryMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
	
}
