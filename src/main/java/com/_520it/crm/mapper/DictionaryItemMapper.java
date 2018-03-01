package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.DictionaryItem;

public interface DictionaryItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictionaryItem record);

    DictionaryItem selectByPrimaryKey(Long id);

    List<DictionaryItem> selectAll();

    int updateByPrimaryKey(DictionaryItem record);

	Long queryPageCount(Long parentId);

	List<DictionaryItem> queryPageData(Long parentId);

	void deleteByParentId(Long id);

}