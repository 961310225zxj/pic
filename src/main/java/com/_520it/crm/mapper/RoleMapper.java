package com._520it.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.Role;
import com._520it.crm.query.QueryObject;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    void insertRelation(@Param("roleId")Long roleId,@Param("permissionId")Long permissionId);

    void deleteRelation(Long roleId);

    Long queryPageCount(QueryObject qo);

    List<Role> queryPageResult(QueryObject qo);

    List<Long> getRolesIdByEmployeeId(Long employeeId);

    List<String> getRoleSnByEmployeeId(Long employeeId);
}