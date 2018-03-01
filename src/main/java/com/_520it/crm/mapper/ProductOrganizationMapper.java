package com._520it.crm.mapper;

import com._520it.crm.domain.ProductOrganization;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductOrganizationMapper {
    int deleteByPrimaryKey(Long id);
    int insert(ProductOrganization record);
    ProductOrganization selectByPrimaryKey(Long id);
    List<ProductOrganization> selectAll();
    int updateByPrimaryKey(ProductOrganization record);
	Long queryPageCount(QueryObject qo);
	List<ProductOrganization> queryPageData(QueryObject qo);
}