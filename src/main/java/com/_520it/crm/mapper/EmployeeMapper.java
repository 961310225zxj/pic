package com._520it.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.Employee;
import com._520it.crm.query.EmployeeQuery;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Long queryPageCount(EmployeeQuery qo);

    List<Employee> queryPageResult(EmployeeQuery qo);

    void changeState(Long id);

    void insertRelation(@Param("employeeId")Long employeeId,@Param("roleId")Long roleId);

    void deleteRelation(Long employeeId);

    Employee getEmployeeByUsername(String username);
    //获取所有的经理
    List<Employee> getManagers();
    
    List<Employee> exportEmployee();
    //更新密码
	void updateByEmpPwd(@Param("newpwd") String newpwd, @Param("empId") Long empId);
}