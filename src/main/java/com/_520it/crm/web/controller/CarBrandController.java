package com._520it.crm.web.controller;

import com._520it.crm.domain.CarBrand;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CarBrandQueryObject;
import com._520it.crm.service.ICarBrandService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarBrandController extends BaseController{
	@Autowired
	ICarBrandService carBrandService;

	@RequestMapping("/carBrand")
	@RequiresPermissions("carBrand:view")
	@PermissionName("汽车品牌主页")
	public String index(){
		return "carBrand";
	}
	@RequestMapping("/carBrand_list")
	@ResponseBody
	@RequiresPermissions("carBrand:list")
	@PermissionName("汽车品牌列表")
	public PageResult list(CarBrandQueryObject qo){
		PageResult pageResult = null;
		pageResult = carBrandService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/carBrand_save")
	@ResponseBody
	@RequiresPermissions("carBrand:save")
	@PermissionName("保存汽车品牌")
	public AjaxResult save(CarBrand carBrand){
		AjaxResult result = null;
		try{
			carBrandService.insert(carBrand);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/carBrand_update")
	@ResponseBody
	@RequiresPermissions("carBrand:update")
	@PermissionName("更新汽车品牌")
	public AjaxResult update(CarBrand carBrand){
		AjaxResult result = null;
		try{
			carBrandService.updateByPrimaryKey(carBrand);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/carBrand_delete")
	@ResponseBody
	@RequiresPermissions("carBrand:delete")
	@PermissionName("删除汽车品牌")
	public AjaxResult delete(Long carBrandId){
		AjaxResult result = null;
		try{
			carBrandService.deleteByPrimaryKey(carBrandId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
