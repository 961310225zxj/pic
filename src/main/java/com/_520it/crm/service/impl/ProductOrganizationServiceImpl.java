package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.ProductOrganization;
import com._520it.crm.mapper.ProductOrganizationMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IProductOrganizationService;
@Service
public class ProductOrganizationServiceImpl implements IProductOrganizationService {
	@Autowired
	private ProductOrganizationMapper productOrganizationMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return productOrganizationMapper.deleteByPrimaryKey(id);
	}

	public int insert(ProductOrganization record) {
		return productOrganizationMapper.insert(record);
	}

	public ProductOrganization selectByPrimaryKey(Long id) {
		return productOrganizationMapper.selectByPrimaryKey(id);
	}

	public List<ProductOrganization> selectAll() {
		return productOrganizationMapper.selectAll();
	}

	public int updateByPrimaryKey(ProductOrganization record) {
		return productOrganizationMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = productOrganizationMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<ProductOrganization> result = productOrganizationMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
