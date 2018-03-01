package com._520it.crm.web.controller;

import com._520it.crm.domain.CarInformation;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CarInformationQueryObject;
import com._520it.crm.service.ICarInformationService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarInformationController extends BaseController{
	@Autowired
	ICarInformationService carInformationService;

	@RequestMapping("/carInformation")
	@RequiresPermissions("carInformation:view")
	@PermissionName("车辆信息主页")
	public String index(){
		return "carInformation";
	}
	@RequestMapping("/carInformation_list")
	@ResponseBody
	@RequiresPermissions("carInformation:list")
	@PermissionName("车辆信息列表")
	public PageResult list(CarInformationQueryObject qo){
		PageResult pageResult = null;
		pageResult = carInformationService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/carInformation_save")
	@ResponseBody
	@RequiresPermissions("carInformation:save")
	@PermissionName("保存车辆信息")
	public AjaxResult save(CarInformation carInformation){
		AjaxResult result = null;
		try{
			carInformationService.insert(carInformation);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/carInformation_update")
	@ResponseBody
	@RequiresPermissions("carInformation:update")
	@PermissionName("更新车辆信息")
	public AjaxResult update(CarInformation carInformation){
		AjaxResult result = null;
		try{
			carInformationService.updateByPrimaryKey(carInformation);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/carInformation_delete")
	@ResponseBody
	@RequiresPermissions("carInformation:delete")
	@PermissionName("删除车辆信息")
	public AjaxResult delete(Long carInformationId){
		AjaxResult result = null;
		try{
			carInformationService.deleteByPrimaryKey(carInformationId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
