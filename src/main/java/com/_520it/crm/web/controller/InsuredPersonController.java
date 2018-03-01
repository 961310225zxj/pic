package com._520it.crm.web.controller;

import com._520it.crm.domain.InsuredPerson;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.InsuredPersonQueryObject;
import com._520it.crm.service.IInsuredPersonService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InsuredPersonController extends BaseController {
	@Autowired
	IInsuredPersonService insuredPersonService;

	@RequestMapping("/insuredPerson")
	@RequiresPermissions("insuredPerson:view")
	@PermissionName("被保人主页")
	public String index(){
		return "insuredPerson";
	}
	@RequestMapping("/insuredPerson_list")
	@ResponseBody
	@RequiresPermissions("insuredPerson:list")
	@PermissionName("被保人列表")
	public PageResult list(InsuredPersonQueryObject qo){
		PageResult pageResult = null;
		pageResult = insuredPersonService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/insuredPerson_save")
	@ResponseBody
	@RequiresPermissions("insuredPerson:save")
	@PermissionName("保存被保人")
	public AjaxResult save(InsuredPerson insuredPerson){
		AjaxResult result = null;
		try{
			insuredPersonService.insert(insuredPerson);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/insuredPerson_update")
	@ResponseBody
	@RequiresPermissions("insuredPerson:update")
	@PermissionName("更新被保人")
	public AjaxResult update(InsuredPerson insuredPerson){
		AjaxResult result = null;
		try{
			insuredPersonService.updateByPrimaryKey(insuredPerson);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/insuredPerson_delete")
	@ResponseBody
	@RequiresPermissions("insuredPerson:delete")
	@PermissionName("删除被保人")
	public AjaxResult delete(Long insuredPersonId){
		AjaxResult result = null;
		try{
			insuredPersonService.deleteByPrimaryKey(insuredPersonId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
