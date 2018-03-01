package com._520it.crm.mapper;

import com._520it.crm.domain.CarBrand;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarBrandMapper {
    int deleteByPrimaryKey(Long id);
    int insert(CarBrand record);
    CarBrand selectByPrimaryKey(Long id);
    List<CarBrand> selectAll();
    int updateByPrimaryKey(CarBrand record);
	Long queryPageCount(QueryObject qo);
	List<CarBrand> queryPageData(QueryObject qo);
}