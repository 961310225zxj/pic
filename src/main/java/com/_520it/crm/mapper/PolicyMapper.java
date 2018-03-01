package com._520it.crm.mapper;

import com._520it.crm.domain.Policy;
import com._520it.crm.query.CheckQuery;
import com._520it.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PolicyMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Policy record);

    Policy selectByPrimaryKey(Long id);

    List<Policy> selectAll();

    int updateByPrimaryKey(Policy record);

    Long queryPageCount(QueryObject qo);

    List<Policy> queryPageData(QueryObject qo);

    void receive(Long id);

    List<Policy> queryCheckData(CheckQuery qo);

    Long queryCheckCount(CheckQuery qo);

    void checkPolicy(@Param("id")Long id,@Param("checkstatus")Integer checkstatus,@Param("suggestion")String suggestion);

    List<Policy> queryOkData(CheckQuery qo);

    Long queryOkCount(CheckQuery qo);
}