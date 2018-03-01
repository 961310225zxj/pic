package com._520it.crm.service;

import com._520it.crm.domain.Client;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClientQuery;

import java.util.List;

/**
 * Created by zlb on 2017.08.27.
 */
public interface IClientService {

    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    Client selectByPrimaryKey(Long id);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);

    PageResult queryPageResult(ClientQuery qo);
    
    void changeState(Long clientId);
    
    void absorb(Long clientId);
}
