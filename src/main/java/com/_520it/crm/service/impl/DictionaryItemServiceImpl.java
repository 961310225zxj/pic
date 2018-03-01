package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Dictionary;
import com._520it.crm.domain.DictionaryItem;
import com._520it.crm.mapper.DictionaryItemMapper;
import com._520it.crm.mapper.DictionaryMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.service.IDictionaryItemService;
@Service
public class DictionaryItemServiceImpl implements IDictionaryItemService {
	@Autowired
	private DictionaryItemMapper dictionaryItemMapper;
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	public int deleteByPrimaryKey(Long id) {
		DictionaryItem item = dictionaryItemMapper.selectByPrimaryKey(id);
		item.setState(false);
		return dictionaryItemMapper.deleteByPrimaryKey(id);
	}

	public int insert(DictionaryItem record) {
		System.out.println("名称"+record.getParent().getName());
		String name = record.getParent().getName();
		
		Dictionary parent = dictionaryMapper.selectByName(name);
		record.setParent(parent);
		record.setState(true);
		return dictionaryItemMapper.insert(record);
	}

	public int updateByPrimaryKey(DictionaryItem record) {
		return dictionaryItemMapper.updateByPrimaryKey(record);
	}
	public DictionaryItem selectByPrimaryKey(Long id) {
		return dictionaryItemMapper.selectByPrimaryKey(id);
	}

	public List<DictionaryItem> selectAll() {
		return dictionaryItemMapper.selectAll();
	}


	public PageResult queryPage(Long parentId) {
		Long count = dictionaryItemMapper.queryPageCount(parentId);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<DictionaryItem> result = dictionaryItemMapper.queryPageData(parentId);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
