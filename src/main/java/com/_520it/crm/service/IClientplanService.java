package com._520it.crm.service;

import com._520it.crm.domain.Clientplan;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClientplanQuery;

import java.util.List;

/**
 * Created by zlb on 2017.08.28.
 */
public interface IClientplanService {
    int deleteByPrimaryKey(Long id);

    int insert(Clientplan record);

    Clientplan selectByPrimaryKey(Long id);

    List<Clientplan> selectAll();

    int updateByPrimaryKey(Clientplan record);

    PageResult queryPageResult(ClientplanQuery qo);
}
