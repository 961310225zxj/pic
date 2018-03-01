package com._520it.crm.service;

import com._520it.crm.domain.Policy;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckQuery;
import com._520it.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPolicyService {


    int insert(Policy record);

    int deleteByPrimaryKey(Long id);

    Policy selectByPrimaryKey(Long id);

    List<Policy> selectAll();

    int updateByPrimaryKey(Policy record);

    PageResult queryPage(QueryObject qo);

    void receive(Long id);

    PageResult queryCheck(CheckQuery qo);

    void checkPolicy(Long id,Integer checkstatus,String suggestion);

    PageResult queryOkPage(CheckQuery qo);
}
