package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.Recognizee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IRecognizeeService {
	int deleteByPrimaryKey(Long id);
    int insert(Recognizee record);
    Recognizee selectByPrimaryKey(Long id);
    List<Recognizee> selectAll();
    int updateByPrimaryKey(Recognizee record);
	PageResult queryPage(QueryObject qo);
}
