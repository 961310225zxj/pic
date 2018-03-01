package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.CarBrand;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface ICarBrandService {
	int deleteByPrimaryKey(Long id);
    int insert(CarBrand record);
    CarBrand selectByPrimaryKey(Long id);
    List<CarBrand> selectAll();
    int updateByPrimaryKey(CarBrand record);
	PageResult queryPage(QueryObject qo);
}
