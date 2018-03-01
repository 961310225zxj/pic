package com._520it.crm.service;

import com._520it.crm.domain.NormalClient;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.NormalClientQuery;

import java.util.List;

/**
 * Created by zlb on 2017.08.28.
 */
public interface INormalClientService {
    //正式客户(已经投保的人),潜在客户(已经提交保单未缴费的)
    int deleteByPrimaryKey(Long id);

    int insert(NormalClient record);

    NormalClient selectByPrimaryKey(Long id);

    List<NormalClient> selectAll();

    int updateByPrimaryKey(NormalClient record);

   PageResult queryPageResult(NormalClientQuery qo);


}
