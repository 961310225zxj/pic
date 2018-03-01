package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Journeyplan;
import com._520it.crm.mapper.JourneyplanMapper;
import com._520it.crm.service.IJourneyplanService;

@Service
public class JourneyplanServiceImpl implements IJourneyplanService {
	
	@Autowired
	private JourneyplanMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Journeyplan record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public Journeyplan selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Journeyplan> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Journeyplan record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

}
