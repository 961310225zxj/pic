package com._520it.crm.web.controller;

import com._520it.crm.domain.NormalClient;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.NormalClientQuery;
import com._520it.crm.service.INormalClientService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zlb on 2017.08.28.
 */
@Controller
public class NormalClientController extends BaseController {
    @Autowired
    private INormalClientService normalClientService;

    @RequestMapping("/normalclient")
    @PermissionName("正式客户视图")
    @RequiresPermissions("normalclient:view")
    public String index(){

        return "normalclient";
    }
    @RequestMapping("/normalclient_list")
    @ResponseBody
    @PermissionName("正式客户列表")
    @RequiresPermissions("normalclient:list")
    public PageResult list(NormalClientQuery qo){
        System.out.println(qo);
        return normalClientService.queryPageResult(qo);
    }
    @RequestMapping("/normalclient_update")
    @ResponseBody
    @PermissionName("正式客户编辑")
    @RequiresPermissions("normalclient:update")
    public AjaxResult update(NormalClient client){
        try {
            normalClientService.updateByPrimaryKey(client);
            return  new AjaxResult(true,"编辑成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new AjaxResult(false,"编辑失败");
    }
    @RequestMapping("/normalclient_delete")
    @ResponseBody
    @PermissionName("正式客户删除")
    @RequiresPermissions("normalclient:delete")
    public AjaxResult delete(Long id){
        try {
            normalClientService.deleteByPrimaryKey(id);
            return  new AjaxResult(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new AjaxResult(false,"删除失败");
    }

}
