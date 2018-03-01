package com._520it.crm.service.impl;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Policy;
import com._520it.crm.mapper.PolicyMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckQuery;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IPolicyService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PolicyServiceImpl implements IPolicyService {
    @Autowired
    private PolicyMapper policyMapper;

    public int deleteByPrimaryKey(Long id) {
        return policyMapper.deleteByPrimaryKey(id);
    }

    public int insert(Policy policy) {
        //设置保单相关信息
        //录入人
        policy.setCheckstatus(0);
        Subject subject =  SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        policy.setEmployee(employee);
        //录入时间
        policy.setInputtime(new Date());
        return policyMapper.insert(policy);
    }

    public Policy selectByPrimaryKey(Long id) {
        return policyMapper.selectByPrimaryKey(id);
    }

    public List<Policy> selectAll() {
        return policyMapper.selectAll();
    }

    public int updateByPrimaryKey(Policy record) {
        return policyMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPage(QueryObject qo) {
        Long count = policyMapper.queryPageCount(qo);
        if (count <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Policy> result = policyMapper.queryPageData(qo);
        PageResult pageResult = new PageResult(count, result);
        return pageResult;
    }

    @Override
    public void receive(Long id) {
        policyMapper.receive(id);
    }

    @Override
    public PageResult queryCheck(CheckQuery qo) {
        Long count = policyMapper.queryCheckCount(qo);
        if (count <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Policy> result = policyMapper.queryCheckData(qo);
        PageResult pageResult = new PageResult(count, result);
        return pageResult;
    }

    @Override
    public void checkPolicy(Long id,Integer checkstatus,String suggestion) {
        policyMapper.checkPolicy(id,checkstatus,suggestion);
    }

    @Override
    public PageResult queryOkPage(CheckQuery qo) {
        Long count = policyMapper.queryOkCount(qo);
        if (count <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Policy> result = policyMapper.queryOkData(qo);
        PageResult pageResult = new PageResult(count, result);
        return pageResult;
    }
}
