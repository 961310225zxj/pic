package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.Department;
import com._520it.crm.domain.Employee;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);
    
}