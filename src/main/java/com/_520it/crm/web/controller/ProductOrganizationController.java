package com._520it.crm.web.controller;

import com._520it.crm.domain.ProductOrganization;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductOrganizationQueryObject;
import com._520it.crm.service.IProductOrganizationService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductOrganizationController extends BaseController{
	@Autowired
	IProductOrganizationService productOrganizationService;

	@RequestMapping("/productOrganization")
	@RequiresPermissions("productOrganization:view")
	@PermissionName("保险机构主页")
	public String index(){
		return "productOrganization";
	}
	@RequestMapping("/productOrganization_list")
	@ResponseBody
	@RequiresPermissions("productOrganization:list")
	@PermissionName("保险机构列表")
	public PageResult list(ProductOrganizationQueryObject qo){
		PageResult pageResult = null;
		pageResult = productOrganizationService.queryPage(qo);
		return pageResult;
	}

	@RequestMapping("/productOrganization_listAll")
	@ResponseBody
	@RequiresPermissions("productOrganization:listAll")
	@PermissionName("保险机构列表")
	public List<ProductOrganization> list(){
        List<ProductOrganization> list = productOrganizationService.selectAll();
        return list;
	}

	@RequestMapping("/productOrganization_save")
	@ResponseBody
	@RequiresPermissions("productOrganization:save")
	@PermissionName("保存保险机构")
	public AjaxResult save(ProductOrganization productOrganization){
		AjaxResult result = null;
		try{
			productOrganizationService.insert(productOrganization);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/productOrganization_update")
	@ResponseBody
	@RequiresPermissions("productOrganization:update")
	@PermissionName("更新保险机构")
	public AjaxResult update(ProductOrganization productOrganization){
		AjaxResult result = null;
		try{
			productOrganizationService.updateByPrimaryKey(productOrganization);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/productOrganization_delete")
	@ResponseBody
	@RequiresPermissions("productOrganization:delete")
	@PermissionName("删除保险机构")
	public AjaxResult delete(Long productOrganizationId){
		AjaxResult result = null;
		try{
			productOrganizationService.deleteByPrimaryKey(productOrganizationId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
