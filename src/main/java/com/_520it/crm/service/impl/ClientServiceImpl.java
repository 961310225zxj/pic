package com._520it.crm.service.impl;

import com._520it.crm.domain.Client;
import com._520it.crm.mapper.ClientMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClientQuery;
import com._520it.crm.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zlb on 2017.08.27.
 */
@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return clientMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Client record) {
        return clientMapper.insert(record);
    }

    @Override
    public Client selectByPrimaryKey(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Client> selectAll() {
        return clientMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Client record) {
        return clientMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(ClientQuery qo) {
        Long count = clientMapper.queryPageCount(qo);
        System.out.println(count);
        return new PageResult(count,clientMapper.queryPageResult(qo));
    }

	@Override
	public void changeState(Long clientId) {
		clientMapper.changeState(clientId);
		
	}

	@Override
	public void absorb(Long clientId) {
		
		clientMapper.absorb(clientId);	
	}
}
