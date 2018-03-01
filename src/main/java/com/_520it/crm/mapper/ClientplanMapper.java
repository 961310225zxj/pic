package com._520it.crm.mapper;

import com._520it.crm.domain.Clientplan;
import com._520it.crm.query.ClientplanQuery;

import java.util.List;

public interface ClientplanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Clientplan record);

    Clientplan selectByPrimaryKey(Long id);

    List<Clientplan> selectAll();

    int updateByPrimaryKey(Clientplan record);

    Long queryPageCount(ClientplanQuery qo);

    List<Clientplan> queryPageResult(ClientplanQuery qo);
}