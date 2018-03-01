package com._520it.crm.mapper;

import com._520it.crm.domain.InsuredPerson;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuredPersonMapper {
    int deleteByPrimaryKey(Long id);
    int insert(InsuredPerson record);
    InsuredPerson selectByPrimaryKey(Long id);
    List<InsuredPerson> selectAll();
    int updateByPrimaryKey(InsuredPerson record);
	Long queryPageCount(QueryObject qo);
	List<InsuredPerson> queryPageData(QueryObject qo);
}