package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.Permission;
import com._520it.crm.query.QueryObject;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<Permission> getPermissionsByRoleId(Long rid);

    List<String> getAllResource();

    List<String> getResourceByEmployeeId(Long employeeId);
    
   Long queryCount(QueryObject qo);
   
   List<Permission> queryList(QueryObject qo);
    
}