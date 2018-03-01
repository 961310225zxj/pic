package com._520it.crm.service.impl;

import com._520it.crm.domain.Clientplan;
import com._520it.crm.mapper.ClientplanMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClientplanQuery;
import com._520it.crm.service.IClientplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zlb on 2017.08.28.
 */
@Service
public class ClientplanServiceImpl implements IClientplanService {
    @Autowired
    private ClientplanMapper clientplanMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return clientplanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Clientplan record) {
        return clientplanMapper.insert(record);
    }

    @Override
    public Clientplan selectByPrimaryKey(Long id) {
        return clientplanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Clientplan> selectAll() {
        return clientplanMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Clientplan record) {
        return clientplanMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(ClientplanQuery qo) {
        Long count = clientplanMapper.queryPageCount(qo);

        return new PageResult(count,clientplanMapper.queryPageResult(qo));
    }
}
