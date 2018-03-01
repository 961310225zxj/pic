package com._520it.crm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Salary;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.query.SalaryQueryObject;
import com._520it.crm.service.ISalaryService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class SalaryController extends BaseController{

	@Autowired
	private ISalaryService service;

	// 工资主页显示
	@RequiresPermissions("salary:view")
	@PermissionName("工资主页")
	@RequestMapping("/salary")
	public String index() {
		return "salary";
	}

	// 查询全部工资
	@RequestMapping("/salary_listAll")
	@ResponseBody
	public List<Salary> list() {
		return service.selectAll();
	}

	// 查询全部工资
	@RequiresPermissions("salary:list")
	@PermissionName("工资列表")
	@RequestMapping("/salary_listqo")
	@ResponseBody
	public PageResult listqo(SalaryQueryObject qo) {
		System.out.println(qo);
		return service.pageQuery(qo);
	}

	@RequiresPermissions("salary:save")
	@PermissionName("工资新增")
	@RequestMapping("/salary_save")
	@ResponseBody
	public AjaxResult save(Salary salary) {

		try {
			service.insert(salary);
			return new AjaxResult(true, "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "保存失败!");
		}
	}

	@RequiresPermissions("salary:update")
	@PermissionName("工资修改")
	@RequestMapping("/salary_update")
	@ResponseBody
	public AjaxResult update(Salary salary) {

		try {
			service.updateByPrimaryKey(salary);
			return new AjaxResult(true, "更新成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "更新失败!");
		}
	}

	@RequiresPermissions("salary:delete")
	@PermissionName("工资删除")
	@RequestMapping("/salary_delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "删除失败!");
		}
	}

}
