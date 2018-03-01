package com._520it.crm.web.controller;

import com._520it.crm.domain.*;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PolicyQueryObject;
import com._520it.crm.service.*;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PolicyController extends BaseController{
	@Autowired
	IPolicyService policyService;
	@Autowired
	IRecognizeeService recognizeeService;
	@Autowired
	IInsuredPersonService insuredPersonService;
	@Autowired
	ICarInformationService carInformationService;
	@Autowired
	IProductService productService;

	@RequestMapping("/policy")
	@RequiresPermissions("policy:view")
	@PermissionName("保单主页")
	public String index(){
		return "policy";
	}

	@RequestMapping("/policy_update")
	@RequiresPermissions("policy_update:view")
	@PermissionName("保单主页")
	public ModelAndView policy_update(Long id){
		ModelAndView mv = new ModelAndView();
		Policy policy = policyService.selectByPrimaryKey(id);
		//投保人
		Long recognizeeId = policy.getRecognizee().getId();
		Recognizee recognizee = recognizeeService.selectByPrimaryKey(recognizeeId);
		//被保人
		Long insuredPersonId = policy.getInsuredPerson().getId();
		InsuredPerson insuredPerson = insuredPersonService.selectByPrimaryKey(recognizeeId);
		//车辆信息
		Long carInformationId = policy.getCarInformation().getId();
		CarInformation carInformation = carInformationService.selectByPrimaryKey(carInformationId);
		//保险信息
		Long productId = policy.getProduct().getId();
		Product product = productService.selectByPrimaryKey(productId);
		mv.addObject("policy",policy);
		mv.addObject("recognizee",recognizee);
		mv.addObject("insuredPerson",insuredPerson);
		mv.addObject("carInformation",carInformation);
		mv.addObject("product",product);
		//设置视图
		mv.setViewName("/policy_update");
		return mv;
	}

	@RequestMapping("/policy_list")
	@ResponseBody
	@RequiresPermissions("policy:list")
	@PermissionName("保单列表")
	public PageResult list(PolicyQueryObject qo){
		PageResult pageResult = null;
		pageResult = policyService.queryPage(qo);
		return pageResult;
	}

	@RequestMapping("/policy_save")
	@ResponseBody
	@RequiresPermissions("policy:save")
	@PermissionName("保存保单")
	public AjaxResult save(Policy policy){
		/*System.out.println("-----");
		System.out.println(policy.getProduct().getId());
		System.out.println(policy.getCarInformation().getId());
		System.out.println(policy.getInsuredPerson().getId());
		System.out.println(policy.getRecognizee().getId());
		System.out.println("-----");*/
		AjaxResult result = null;
		try{
			policyService.insert(policy);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/policy_update1")
	@ResponseBody
	@RequiresPermissions("policy_update1:update")
	@PermissionName("更新保单")
	public AjaxResult update(Policy policy){
		/*System.out.println("-----");
		System.out.println(policy.getProduct().getId());
		System.out.println(policy.getCarInformation().getId());
		System.out.println(policy.getInsuredPerson().getId());
		System.out.println(policy.getRecognizee().getId());
		System.out.println(policy.getMoneystatus());
		System.out.println("-----");*/
		AjaxResult result = null;
		try{
			policyService.updateByPrimaryKey(policy);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/policy_delete")
	@ResponseBody
	@RequiresPermissions("policy:delete")
	@PermissionName("删除保单")
	public AjaxResult delete(Long policyId){
		AjaxResult result = null;
		try{
			policyService.deleteByPrimaryKey(policyId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
