package com._520it.crm.mapper;

import com._520it.crm.domain.Dictionary;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);

    List<Dictionary> selectAll();

    int updateByPrimaryKey(Dictionary record);

	Long queryPageCount(QueryObject qo);

	List<Dictionary> queryPageData(QueryObject qo);

	Dictionary selectByName(String name);
}