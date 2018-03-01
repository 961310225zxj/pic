package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.ProductOrganization;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IProductOrganizationService {
	int deleteByPrimaryKey(Long id);
    int insert(ProductOrganization record);
    ProductOrganization selectByPrimaryKey(Long id);
    List<ProductOrganization> selectAll();
    int updateByPrimaryKey(ProductOrganization record);
	PageResult queryPage(QueryObject qo);
}
