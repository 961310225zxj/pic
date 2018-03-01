package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.InsuredPerson;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IInsuredPersonService {
	int deleteByPrimaryKey(Long id);
    int insert(InsuredPerson record);
    InsuredPerson selectByPrimaryKey(Long id);
    List<InsuredPerson> selectAll();
    int updateByPrimaryKey(InsuredPerson record);
	PageResult queryPage(QueryObject qo);
}
