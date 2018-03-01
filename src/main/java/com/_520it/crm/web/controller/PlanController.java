package com._520it.crm.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Plan;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PlanQueryObject;
import com._520it.crm.service.IPlanService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class PlanController extends BaseController{

	@Autowired
	private IPlanService service;
	
	@RequiresPermissions("plan:view")
	@PermissionName("今日任务主页")
	@RequestMapping("/plan")
	public String index() {
		return "plan";
	}

	// 查询全部计划
	@RequiresPermissions("plan:list")
	@PermissionName("今日任务列表")
	@RequestMapping("/plan_listAll")
	@ResponseBody
	public PageResult list(PlanQueryObject qo) {
		return service.pageQuery(qo);
	}

	// 查询全部计划
	@RequestMapping("/plan_listone")
	@ResponseBody
	public Plan listone(Long id) {
		return service.selectByPrimaryKey(id);
	}

	// 保存
	@RequiresPermissions("plan:save")
	@PermissionName("今日任务新增")
	@RequestMapping("/plan_save")
	@ResponseBody
	public AjaxResult save(Plan p) {
		try {
			service.insert(p);
			return new AjaxResult(true, "分配成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "分配失败");
		}
	}

	// 编辑
	@RequiresPermissions("plan:update")
	@PermissionName("今日任务编辑")
	@RequestMapping("/plan_update")
	@ResponseBody
	public AjaxResult update(Plan p) {
		try {
			service.updateByPrimaryKey(p);
			return new AjaxResult(true, "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "更新失败");
		}
	}

	// 编辑处理信息
	@RequiresPermissions("plan:updatemsg")
	@PermissionName("今日任务处理编辑")
	@RequestMapping("/plan_updatemsg")
	@ResponseBody
	public AjaxResult updatemsg(Plan p) {
		try {
			System.out.println(p);
			service.updateHandleMsg(p);
			return new AjaxResult(true, "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "更新失败");
		}
	}

	// 删除
	@RequiresPermissions("plan:delete")
	@PermissionName("今日任务删除")
	@RequestMapping("/plan_delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "删除失败");
		}
	}

	// 标记成功
	@RequiresPermissions("plan:marksuccess")
	@PermissionName("今日任务标记成功")
	@RequestMapping("/plan_marksuccess")
	@ResponseBody
	public AjaxResult marksuccess(Long id) {
		try {
			service.marksuccess(id);
			return new AjaxResult(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "删除失败");
		}
	}

	// 标记失败
	@RequiresPermissions("plan:markfailed")
	@PermissionName("今日任务标记失败")
	@RequestMapping("/plan_markfailed")
	@ResponseBody
	public AjaxResult markfailed(Long id) {
		try {
			service.markfailed(id);
			return new AjaxResult(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "删除失败");
		}
	}
}
