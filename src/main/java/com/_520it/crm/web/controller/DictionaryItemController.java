package com._520it.crm.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.DictionaryItem;
import com._520it.crm.page.PageResult;
import com._520it.crm.service.IDictionaryItemService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class DictionaryItemController extends BaseController{
	
	@Autowired
	private IDictionaryItemService dictionaryItemService;
	
	@RequestMapping("/dictionaryItem")
	@RequiresPermissions("dictionaryItem:view")
	@PermissionName("字典明细主页")
	public String index(){
		return "dictionaryItem";
	}
	
	
	@RequestMapping("/dictionaryItem_list")
	@ResponseBody
	@RequiresPermissions("dictionaryItem:list")
	@PermissionName("字典明细列表")
	public PageResult list(Long id){
		System.out.println("parentId="+id);
		PageResult pageResult = null;
		pageResult = dictionaryItemService.queryPage(id);
		return pageResult;
	}
	@RequestMapping("/dictionaryItem_save")
	@ResponseBody
	@RequiresPermissions("dictionaryItem:save")
	@PermissionName("保存字典明细")
	public AjaxResult save(DictionaryItem dictionaryItem){
		AjaxResult result = null;
		try{
			dictionaryItemService.insert(dictionaryItem);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/dictionaryItem_update")
	@ResponseBody
	@RequiresPermissions("dictionaryItem:update")
	@PermissionName("更新字典明细")
	public AjaxResult update(DictionaryItem dictionaryItem){
		AjaxResult result = null;
		try{
			dictionaryItemService.updateByPrimaryKey(dictionaryItem);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/dictionaryItem_delete")
	@ResponseBody
	@RequiresPermissions("dictionaryItem:delete")
	@PermissionName("禁用字典明细")
	public AjaxResult delete(Long id){
		AjaxResult result = null;
		try{
			dictionaryItemService.deleteByPrimaryKey(id);
			result = new AjaxResult(true,"禁用成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"禁用失败,请联系管理员！");
		}
		return result;
	}
}
