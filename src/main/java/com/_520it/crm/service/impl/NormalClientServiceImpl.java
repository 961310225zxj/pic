package com._520it.crm.service.impl;

import com._520it.crm.domain.NormalClient;
import com._520it.crm.mapper.NormalClientMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.NormalClientQuery;
import com._520it.crm.service.INormalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zlb on 2017.08.28.
 */
@Service
public class NormalClientServiceImpl implements INormalClientService{
    @Autowired
    private NormalClientMapper clientMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return clientMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(NormalClient record) {
        return clientMapper.insert(record);
    }

    @Override
    public NormalClient selectByPrimaryKey(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NormalClient> selectAll() {
        return clientMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(NormalClient record) {
        return clientMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(NormalClientQuery qo) {
        Long count = clientMapper.queryPageCount(qo);
        return new PageResult(count,clientMapper.queryPageResult(qo));
    }
}
