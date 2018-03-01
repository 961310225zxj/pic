package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.CarInformation;
import com._520it.crm.mapper.CarInformationMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.ICarInformationService;
@Service
public class CarInformationServiceImpl implements ICarInformationService {
	@Autowired
	private CarInformationMapper carInformationMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return carInformationMapper.deleteByPrimaryKey(id);
	}

	public int insert(CarInformation record) {
		return carInformationMapper.insert(record);
	}

	public CarInformation selectByPrimaryKey(Long id) {
		return carInformationMapper.selectByPrimaryKey(id);
	}

	public List<CarInformation> selectAll() {
		return carInformationMapper.selectAll();
	}

	public int updateByPrimaryKey(CarInformation record) {
		return carInformationMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = carInformationMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<CarInformation> result = carInformationMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
