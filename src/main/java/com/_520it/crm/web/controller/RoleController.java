package com._520it.crm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IRoleService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class RoleController extends BaseController{

	@Autowired
	private IRoleService service;

	@RequestMapping("/role")
	@RequiresPermissions("role:view")
	@PermissionName("角色主页")
	public String index() {
		return "role";
	}

	@RequestMapping("/role_save")
	@RequiresPermissions("role:save")
	@PermissionName("角色保存")
	@ResponseBody
	public AjaxResult save(Role role) {
		try {
			service.insert(role);
			return new AjaxResult(true, "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AjaxResult(false, "保存失败!");
	}

	@RequestMapping("/role_list")
	@RequiresPermissions("role:list")
	@PermissionName("角色列表")
	@ResponseBody
	public PageResult list(QueryObject qo) {
		return service.queryPageResult(qo);
	}

	@RequestMapping("/role_listAll")
	@ResponseBody
	public List<Role> selectAll() {
		return service.selectAll();
	}

	@RequestMapping("/role_update")
	@ResponseBody
	@RequiresPermissions("role:update")
	@PermissionName("角色编辑")
	public AjaxResult update(Role role) {
		try {
			service.updateByPrimaryKey(role);
			return new AjaxResult(true, "更新成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AjaxResult(false, "更新失败!");
	}

	@RequestMapping("/getRolesIdByEmployeeId")
	@ResponseBody
	public List<Long> getRolesIdByEmployeeId(Long employeeId) {
		return service.getRolesIdByEmployeeId(employeeId);
	}

	@RequestMapping("/role_delete")
	@ResponseBody
	@PermissionName("删除角色")
	@RequiresPermissions("role:delete")
	public AjaxResult delete(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AjaxResult(true, "删除失败!");

	}
}
