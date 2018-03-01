package com._520it.crm.service;

import com._520it.crm.domain.Product;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface IProductService {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    Product selectByPrimaryKey(Long id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    PageResult queryPage(QueryObject qo);

    List<Product> listAll();
}
