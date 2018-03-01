package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.CarInformation;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface ICarInformationService {
	int deleteByPrimaryKey(Long id);
    int insert(CarInformation record);
    CarInformation selectByPrimaryKey(Long id);
    List<CarInformation> selectAll();
    int updateByPrimaryKey(CarInformation record);
	PageResult queryPage(QueryObject qo);
}
