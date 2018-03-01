package com._520it.crm.web.controller;

import com._520it.crm.domain.Client;
import com._520it.crm.domain.NormalClient;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClientQuery;
import com._520it.crm.service.IClientService;
import com._520it.crm.service.IInsuredPersonService;
import com._520it.crm.service.INormalClientService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by zlb on 2017.08.26.
 */
@Controller
public class ClientController extends BaseController {
    @Autowired
    private IClientService clientService;
    @Autowired
    private IInsuredPersonService insuredPersonService;
    @Autowired
    private INormalClientService normalClientService;
    @RequestMapping("/client")
    @PermissionName("潜在客户主页")
    @RequiresPermissions("client:view")
    public String index(){
        return "client";
    }

    @RequestMapping("/client_list")
    @ResponseBody
    @PermissionName("潜在客户列表")
    @RequiresPermissions("client:list")
    public PageResult list(ClientQuery qo){
        return clientService.queryPageResult(qo);
    }

    @RequestMapping("/client_listAll")
    @ResponseBody
    @PermissionName("潜在客户列表")
    @RequiresPermissions("client:list")
    public List<Client> list(){
        return clientService.selectAll();
    }

    @RequestMapping("/client_update")
    @ResponseBody
    @PermissionName("潜在客户编辑")
    @RequiresPermissions("client:update")
    public AjaxResult update(Client client){
        try {
            clientService.updateByPrimaryKey(client);
            //如果已经投保则保存到正式客户表中去
            if (client.getIsInsured()){
                NormalClient normalClient = new NormalClient();
                normalClient.setName(client.getName());
                normalClient.setIsPersonal((byte)1);
                normalClient.setNumbertype("身份证");
                normalClient.setLevel("高级");
                normalClient.setAddress(client.getAddress());
                normalClient.setNumber(client.getNumber().toString());
                normalClient.setIsInsured(client.getIsInsured());
                normalClient.setGender(client.getGender());
                normalClient.setAge(client.getAge());
                normalClient.setEmail(client.getEmail());
                normalClient.setProfession(client.getProfession());
                normalClient.setPhone(client.getPhone().toString());
                normalClientService.insert(normalClient);
            }
            return  new AjaxResult(true,"编辑成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"编辑失败");
    }
    @RequestMapping("/client_save")
    @ResponseBody
    @PermissionName("潜在客户保存")
    @RequiresPermissions("client:save")
    public AjaxResult save(Client client){
        try {
            clientService.insert(client);
            return  new AjaxResult(true,"保存成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"保存失败");
    }
    @RequestMapping("/client_delete")
    @ResponseBody
    @PermissionName("删除潜在客户")
    @RequiresPermissions("client:delete")
    public AjaxResult delete(Long id){
        try {
            clientService.deleteByPrimaryKey(id);
            return  new AjaxResult(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"删除失败");
    }
    //共享客户
    @RequestMapping("/client_share")
    @ResponseBody
    @PermissionName("共享潜在客户")
    @RequiresPermissions("client:share")
    public AjaxResult share(Long id){
        try {
            clientService.changeState(id);
            return  new AjaxResult(true,"共享成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"共享失败");
    }

    @RequestMapping("/jxlIn")
    public void jxlIn(MultipartFile file) throws Exception {
        Workbook workbook=Workbook.getWorkbook(file.getInputStream());
        Sheet sheet=workbook.getSheet(0);
        int rows=sheet.getRows();
        for (int i = 0; i <rows; i++) {
            Client c=new Client();
            c.setAge(Integer.valueOf(sheet.getCell(0,i).getContents()));
            c.setAddress(sheet.getCell(1,i).getContents());
            clientService.insert(c);
        }
        workbook.close();
    }


}
