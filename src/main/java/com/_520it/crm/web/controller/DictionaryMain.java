package com._520it.crm.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com._520it.crm.util.PermissionName;

@Controller
public class DictionaryMain extends BaseController{
	
	@RequestMapping("/dictionaryMain")
	@RequiresPermissions("dictionaryMain:view")
	@PermissionName("字典菜单主页")
	public String index(){
		return "dictionaryMain";
	}
}
