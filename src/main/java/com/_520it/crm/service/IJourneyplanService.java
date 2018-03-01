package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Journeyplan;

public interface IJourneyplanService {
	int deleteByPrimaryKey(Long id);

	int insert(Journeyplan record);

	Journeyplan selectByPrimaryKey(Long id);

	List<Journeyplan> selectAll();

	int updateByPrimaryKey(Journeyplan record);
}
