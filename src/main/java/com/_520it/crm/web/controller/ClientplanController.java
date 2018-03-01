package com._520it.crm.web.controller;

import com._520it.crm.domain.Clientplan;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClientplanQuery;
import com._520it.crm.service.IClientService;
import com._520it.crm.service.IClientplanService;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by zlb on 2017.08.28.
 */
@Controller
public class ClientplanController extends BaseController {
    @Autowired
    private IClientplanService clientplanService;
    @Autowired
    private IClientService clientService;
    @Autowired
    private IEmployeeService employeeService;

    @PermissionName("开发客户计划视图")
    @RequiresPermissions("clientplan:view")
    @RequestMapping("/clientplan")
    public String index(){
        return "clientplan";
    }

    @PermissionName("客户开发计划列表")
    @RequiresPermissions("clientplan:list")
    @RequestMapping("/clientplan_list")
    @ResponseBody
    public PageResult list(ClientplanQuery qo){
        return clientplanService.queryPageResult(qo);
    }
    @PermissionName("客户开发计划更新")
    @RequiresPermissions("clientplan:update")
    @RequestMapping("/clientplan_update")
    @ResponseBody
    public AjaxResult update(Clientplan clientplan){
        if (clientplan.getInputtime()==null){
            clientplan.setInputtime(new Date());
        }
        try {
            clientplanService.updateByPrimaryKey(clientplan);
            return  new AjaxResult(true,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"更新失败");
    }
    @PermissionName("客户开发计划列表")
    @RequiresPermissions("clientplan:delete")
    @RequestMapping("/clientplan_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            clientplanService.deleteByPrimaryKey(id);
            return  new AjaxResult(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"删除失败");
    }
    @PermissionName("客户开发计划保存")
    @RequiresPermissions("clientplan:save")
    @RequestMapping("/clientplan_save")
    @ResponseBody
    public AjaxResult save(Clientplan clientplan){
        try {
            System.out.println(clientplan.getClient()+"======================================");
            clientplan.setInputtime(new Date());
            clientplanService.insert(clientplan);
            return  new AjaxResult(true,"保存成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"保存失败");
    }
}
