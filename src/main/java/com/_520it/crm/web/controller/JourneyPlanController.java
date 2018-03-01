package com._520it.crm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Journeyplan;
import com._520it.crm.service.IJourneyplanService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class JourneyPlanController extends BaseController {

	@Autowired
	private IJourneyplanService service;
	
	@RequiresPermissions("journeyplan:view")
	@PermissionName("行程主页")
	@RequestMapping("/journeyplan")
	public String checktable() {
		return "journeyplan";
	}
	
	@RequiresPermissions("journeyplan:list")
	@PermissionName("行程列表")
	@RequestMapping("/journeyplan_list")
	@ResponseBody
	public List<Journeyplan> list() {
		return service.selectAll();
	}
	
	@RequiresPermissions("journeyplan:save")
	@PermissionName("新增行程")
	@RequestMapping("/journeyplan_save")
	@ResponseBody
	public AjaxResult save(Journeyplan plan) {
		try {
			service.insert(plan);
			return new AjaxResult(true, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "");
		}
	}
	
	@RequiresPermissions("journeyplan:delete")
	@PermissionName("删除行程")
	@RequestMapping("/journeyplan_delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "");
		}
	}

}
