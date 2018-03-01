package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.CarBrand;
import com._520it.crm.mapper.CarBrandMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.ICarBrandService;
@Service
public class CarBrandServiceImpl implements ICarBrandService {
	@Autowired
	private CarBrandMapper carBrandMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return carBrandMapper.deleteByPrimaryKey(id);
	}

	public int insert(CarBrand record) {
		return carBrandMapper.insert(record);
	}

	public CarBrand selectByPrimaryKey(Long id) {
		return carBrandMapper.selectByPrimaryKey(id);
	}

	public List<CarBrand> selectAll() {
		return carBrandMapper.selectAll();
	}

	public int updateByPrimaryKey(CarBrand record) {
		return carBrandMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = carBrandMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<CarBrand> result = carBrandMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
