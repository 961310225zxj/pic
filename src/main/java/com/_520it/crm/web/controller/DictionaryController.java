package com._520it.crm.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Dictionary;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.DictionaryQueryObject;
import com._520it.crm.service.IDictionaryService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class DictionaryController extends BaseController{
	@Autowired
	private IDictionaryService dictionaryService;
	
	@RequestMapping("/dictionary")
	@RequiresPermissions("dictionary:view")
	@PermissionName("字典主页")
	public String index(){
		return "dictionary";
	}
	
	
	@RequestMapping("/dictionary_list")
	@ResponseBody
	@RequiresPermissions("dictionary:list")
	@PermissionName("字典列表")
	public PageResult list(DictionaryQueryObject qo){
		PageResult pageResult = null;
		pageResult = dictionaryService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/dictionary_save")
	@ResponseBody
	@RequiresPermissions("dictionary:save")
	@PermissionName("保存字典")
	public AjaxResult save(Dictionary dictionary){
		AjaxResult result = null;
		try{
			dictionaryService.insert(dictionary);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/dictionary_update")
	@ResponseBody
	@RequiresPermissions("dictionary:update")
	@PermissionName("更新字典")
	public AjaxResult update(Dictionary dictionary){
		AjaxResult result = null;
		try{
			dictionaryService.updateByPrimaryKey(dictionary);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/dictionary_delete")
	@ResponseBody
	@RequiresPermissions("dictionary:delete")
	@PermissionName("删除字典")
	public AjaxResult delete(Long id){
		AjaxResult result = null;
		try{
			dictionaryService.deleteByPrimaryKey(id);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
