package com._520it.crm.web.controller;

import com._520it.crm.domain.Product;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductQueryObject;
import com._520it.crm.service.IProductService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController extends BaseController{
    @Autowired
    IProductService productService;

    @RequestMapping("/product")
    @RequiresPermissions("product:view")
    @PermissionName("保险产品主页")
    public String index() {
        return "product";
    }


    @RequestMapping("/product_list")
    @ResponseBody
    @RequiresPermissions("product:list")
    @PermissionName("保险产品列表")
    public PageResult list(ProductQueryObject qo) {
        PageResult pageResult = null;
        pageResult = productService.queryPage(qo);
        return pageResult;
    }

    @RequestMapping("/product_listAll")
    @ResponseBody
    @RequiresPermissions("product:listAll")
    @PermissionName("产品列表")
    public List<Product> listAll() {
        return productService.listAll();
    }


    @RequestMapping("/product_save")
    @ResponseBody
    @RequiresPermissions("product:save")
    @PermissionName("保存保险产品")
    public AjaxResult save(Product product) {
        AjaxResult result = null;
        try {
            productService.insert(product);
            result = new AjaxResult(true, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "保存失败,请联系管理员！");
        }
        return result;
    }

    @RequestMapping("/product_update")
    @ResponseBody
    @RequiresPermissions("product:update")
    @PermissionName("更新保险产品")
    public AjaxResult update(Product product) {
        AjaxResult result = null;
        try {
            productService.updateByPrimaryKey(product);
            result = new AjaxResult(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "更新失败,请联系管理员！");
        }
        return result;
    }

    @RequestMapping("/product_delete")
    @ResponseBody
    @RequiresPermissions("product:delete")
    @PermissionName("删除保险产品")
    public AjaxResult delete(Long productId) {
        AjaxResult result = null;
        try {
            productService.deleteByPrimaryKey(productId);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "删除失败,请联系管理员！");
        }
        return result;
    }
}
