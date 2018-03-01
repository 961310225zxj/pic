package com._520it.crm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Department;
import com._520it.crm.domain.Employee;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.IDepartmentService;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class DepartmentController extends BaseController {

	@Autowired
	private IDepartmentService service;

	@Autowired
	private IEmployeeService empService;

	// 部门主页显示
	@RequestMapping("/department")
	@RequiresPermissions("department:view")
	@PermissionName("部门主页")
	public String index() {
		return "department";
	}

	// 查询全部部门
	@RequestMapping("/dept_listAll")
	@ResponseBody
	@RequiresPermissions("dept:list")
	@PermissionName("部门列表")
	public List<Department> list(EmployeeQuery qo) {
		return service.selectAll();
	}

	@RequestMapping("/dept_save")
	@ResponseBody
	@RequiresPermissions("dept:save")
	@PermissionName("部门保存")
	public AjaxResult save(Department dept	) {

		try {
			service.insert(dept);
			return new AjaxResult(true, "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "保存失败!");
		}
	}
	@RequestMapping("/dept_update")
	@ResponseBody
	@RequiresPermissions("dept:update")
	@PermissionName("部门更新")
	public AjaxResult update(Department dept) {
		
		try {
			service.updateByPrimaryKey(dept);
			return new AjaxResult(true, "更新成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "更新失败!");
		}
	}
	
	@RequestMapping("/dept_delete")
	@ResponseBody
	@RequiresPermissions("dept:delete")
	@PermissionName("部门删除")
	public AjaxResult delete(Long id) {
		
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "删除失败!");
		}
	}

	@RequestMapping("/dept_manager")
	@ResponseBody
	public List<Employee> getManagers() {
		List<Employee> lsit = empService.selectAll();
		return lsit ;
		
	}
}
