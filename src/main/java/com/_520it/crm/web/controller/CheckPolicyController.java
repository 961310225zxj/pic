package com._520it.crm.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckQuery;
import com._520it.crm.service.IPolicyService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

/**
 * Created by Jim on 2017/8/26.
 */
@Controller
public class CheckPolicyController {

    @Autowired
    private IPolicyService service;

    @RequestMapping("/checkPolicy_list")
	@RequiresPermissions("policy:view")
	@PermissionName("待审核保单")
    @ResponseBody
    public PageResult list(CheckQuery qo){
        qo.setMoneystatus(1);
        PageResult pageResult = service.queryCheck(qo);
        return pageResult;
    }


    @RequestMapping("/submit_list")
	@RequiresPermissions("policy:submit")
	@PermissionName("已提交保单")
    @ResponseBody
    public PageResult submit_list(CheckQuery qo){
        qo.setMoneystatus(1);
        PageResult pageResult = service.queryCheck(qo);
        return pageResult;
    }

    @RequestMapping("/snapPolicy_list")
	@RequiresPermissions("policy:snap")
	@PermissionName("暂存保单")
    @ResponseBody
    public PageResult snapPolicy(CheckQuery qo){
        qo.setMoneystatus(0);
        qo.setCheckstatus(0);
        PageResult pageResult = service.queryCheck(qo);
        return pageResult;
    }

    @RequestMapping("/submitPolicy")
	@RequiresPermissions("policy:submitPolicy")
		@PermissionName("提交保单")
    public String submitPolicy(){
        return "submitPolicy";
    }

	@PermissionName("暂存保单")
    @RequestMapping("/temporary")
	@RequiresPermissions("policy:temporary")
    public String temporary(){
        return "temporary";
    }

	@RequiresPermissions("policy:checkOkPolicy")
    @RequestMapping("/checkOkPolicy")
	@PermissionName("审核保单")
    public String checkOkPolicy(){
        return "checkOkPolicy";
    }

    @RequestMapping("/checkOkPolicy_list")
	@RequiresPermissions("policy:checkOklist")
	@PermissionName("已审核保单")
    @ResponseBody
    public PageResult checkOkPolicy_list(Integer checkstatus){
        CheckQuery qo = new CheckQuery();
        qo.setCheckstatus(checkstatus);
        PageResult pageResult = service.queryOkPage(qo);
        return pageResult;
    }

    @RequestMapping("/checkPolicy")
	@PermissionName("审核保单1")
	@RequiresPermissions("policy:checkPolicy")
    public String policy(){
        return "checkPolicy";
    }

	@PermissionName("审核保单2")
    @RequestMapping("/snapPolicy")
	@RequiresPermissions("policy:snapPolicy")
    public String snapPolicy(){
        return "snapPolicy";
    }
	
	@PermissionName("审核保单3")
    @RequestMapping("/pass")
	@RequiresPermissions("policy:pass")
    public String pass(){
        return "pass";
    }
	
	@PermissionName("审核保单4")
    @RequestMapping("/refuse")
	@RequiresPermissions("policy:refuse")
    public String refuse(){
        return "refuse";
    }
	
	@PermissionName("审核保单5")
    @RequestMapping("/report")
	@RequiresPermissions("policy:report")
    public String report(){
        return "report";
    }


	@PermissionName("审核保单6")
    @RequestMapping("/policy_receive")
	@RequiresPermissions("policy:receive")
    @ResponseBody
    public AjaxResult receive(Long id){
        try {
            service.receive(id);
            return new AjaxResult(true,"接收成功");

        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"接收失败");
    }

    @RequestMapping("/policy_check")
	@PermissionName("审核保单7")
	@RequiresPermissions("policy:policy_check")
    @ResponseBody
    public AjaxResult policy_check(Long id,Integer msg,String auditAdvice){
        try {
            service.checkPolicy(id,msg,auditAdvice);
            return new AjaxResult(true,"操作成功");

        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"操作失败");
    }
}
