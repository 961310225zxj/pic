package com._520it.crm.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClientQuery;
import com._520it.crm.service.IClientService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class Resource extends BaseController {

	@Autowired
	private IClientService clientService;

	@RequestMapping("/resource")
	@RequiresPermissions("resource:view")
	@PermissionName("客户资源池主页")
	public String index() {
		return "resource";
	}

	// 客户资源池中的列表显示
	@RequestMapping("/resource_list")
	@ResponseBody
	@RequiresPermissions("resource:list")
	@PermissionName("客户资源池列表")
	public PageResult list(ClientQuery qo) {
		qo.setState(false);
		return clientService.queryPageResult(qo);
	}

	// 吸纳客户
	@RequestMapping("/resource_adsorb")
	@ResponseBody
	@RequiresPermissions("resource:absorb")
	@PermissionName("吸纳客户")
	public AjaxResult absorb(Long id) {
		try {
			clientService.absorb(id);
			return new AjaxResult(true, "操作成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AjaxResult(true, "操作成功!");
	}
}
