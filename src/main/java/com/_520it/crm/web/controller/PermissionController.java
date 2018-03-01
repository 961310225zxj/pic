package com._520it.crm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Permission;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IPermissionService;
import com._520it.crm.util.PermissionName;

@Controller
public class PermissionController extends BaseController{

	@Autowired
	private IPermissionService service;

	@RequestMapping("/permission")
	@RequiresPermissions("permission:view")
	@PermissionName("权限主页")
	public String index() {
		return "permission";
	}

	@RequestMapping("/permission_listAll")
	@ResponseBody
	@RequiresPermissions("permission:list")
	@PermissionName("权限列表")
	public PageResult listAll(QueryObject qo) {
		
		return service.queryList(qo);
	}

	@RequestMapping("/getPermissionsByRoleId")
	@ResponseBody
	public List<Permission> getPermissionsByRoleId(Long rid) {
		return service.getPermissionsByRoleId(rid);
	}

	@RequestMapping("/loadPermission")
	@ResponseBody
	@RequiresPermissions("permission:load")
	@PermissionName("加载权限")
	public void load() {
		service.load();
	}
	
	@RequestMapping("/permission_all")
	@ResponseBody
	public List<Permission> list(){
		return service.selectAll();
	}
}
