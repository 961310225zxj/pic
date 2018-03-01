package com._520it.crm.mapper;

import com._520it.crm.domain.Client;
import com._520it.crm.domain.NormalClient;
import com._520it.crm.query.NormalClientQuery;

import java.util.List;

public interface NormalClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NormalClient record);

    NormalClient selectByPrimaryKey(Long id);

    List<NormalClient> selectAll();

    int updateByPrimaryKey(NormalClient record);

    Long queryPageCount(NormalClientQuery qo);

    List<Client> queryPageResult(NormalClientQuery qo);

}