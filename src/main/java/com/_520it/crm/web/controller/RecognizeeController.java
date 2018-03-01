package com._520it.crm.web.controller;

import com._520it.crm.domain.Recognizee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.RecognizeeQueryObject;
import com._520it.crm.service.IRecognizeeService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecognizeeController extends BaseController{
	@Autowired
	IRecognizeeService recognizeeService;

	@RequestMapping("/recognizee")
	@RequiresPermissions("recognizee:view")
	@PermissionName("投保人主页")
	public String index(){
		return "recognizee";
	}
	@RequestMapping("/recognizee_list")
	@ResponseBody
	@RequiresPermissions("recognizee:list")
	@PermissionName("投保人列表")
	public PageResult list(RecognizeeQueryObject qo){
		PageResult pageResult = null;
		pageResult = recognizeeService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/recognizee_save")
	@ResponseBody
	@RequiresPermissions("recognizee:save")
	@PermissionName("保存投保人")
	public AjaxResult save(Recognizee recognizee){
		AjaxResult result = null;
		try{
			recognizeeService.insert(recognizee);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/recognizee_update")
	@ResponseBody
	@RequiresPermissions("recognizee:update")
	@PermissionName("更新投保人")
	public AjaxResult update(Recognizee recognizee){
		AjaxResult result = null;
		try{
			recognizeeService.updateByPrimaryKey(recognizee);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/recognizee_delete")
	@ResponseBody
	@RequiresPermissions("recognizee:delete")
	@PermissionName("删除投保人")
	public AjaxResult delete(Long recognizeeId){
		AjaxResult result = null;
		try{
			recognizeeService.deleteByPrimaryKey(recognizeeId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
