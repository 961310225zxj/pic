package com._520it.crm.mapper;

import com._520it.crm.domain.Checktable;
import com._520it.crm.domain.Employee;

import java.util.List;

public interface ChecktableMapper {

	int deleteByPrimaryKey(Long id);

	/**
	 * 新增签到信息
	 * @param record
	 * @return
	 */
	int insert(Checktable record);

	/**
	 * 根据员工id查询该员工的签到信息
	 * @param id
	 * @return
	 */
	// Checktable selectByPrimaryKey(Long id);

	/**
	 * 根据员工id查询该员工的所有签到信息
	 * @param id
	 * @return
	 */
	List<Checktable> selectByEmpId(Long id);

	/**
	 * 查询所有的签到信息
	 * @return
	 */
	List<Checktable> selectAll();
	
	/**
	 * 导出考勤表
	 * @return
	 */
	List<Checktable> exportChecktable();

	/**
	 * 更新签到信息
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Checktable record);
}