package com._520it.crm.service;
import java.util.List;

import com._520it.crm.domain.DictionaryItem;
import com._520it.crm.page.PageResult;

public interface IDictionaryItemService {
	int deleteByPrimaryKey(Long id);
    int insert(DictionaryItem record);
    DictionaryItem selectByPrimaryKey(Long id);
    List<DictionaryItem> selectAll();
    int updateByPrimaryKey(DictionaryItem record);
	PageResult queryPage(Long parentId);
}
