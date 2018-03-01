package com._520it.crm.mapper;

import com._520it.crm.domain.Journeyplan;
import java.util.List;

public interface JourneyplanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Journeyplan record);

    Journeyplan selectByPrimaryKey(Long id);

    List<Journeyplan> selectAll();

    int updateByPrimaryKey(Journeyplan record);
}