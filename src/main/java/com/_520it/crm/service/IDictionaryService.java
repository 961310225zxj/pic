package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.Dictionary;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IDictionaryService {
	int deleteByPrimaryKey(Long id);
    int insert(Dictionary record);
    Dictionary selectByPrimaryKey(Long id);
    List<Dictionary> selectAll();
    int updateByPrimaryKey(Dictionary record);
	PageResult queryPage(QueryObject qo);
}
