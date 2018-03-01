package com._520it.crm.mapper;

import com._520it.crm.domain.CarInformation;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarInformationMapper {
    int deleteByPrimaryKey(Long id);
    int insert(CarInformation record);
    CarInformation selectByPrimaryKey(Long id);
    List<CarInformation> selectAll();
    int updateByPrimaryKey(CarInformation record);
	Long queryPageCount(QueryObject qo);
	List<CarInformation> queryPageData(QueryObject qo);
}