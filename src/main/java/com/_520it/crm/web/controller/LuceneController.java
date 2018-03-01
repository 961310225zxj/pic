package com._520it.crm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.page.PageResult;
import com._520it.crm.util.LuceneUtil;
import com._520it.crm.util.PermissionName;
import com._520it.crm.vo.LuceneVO;

@Controller
public class LuceneController extends BaseController{
	 @RequestMapping("/lucene")
	 @RequiresPermissions("lucene:view")
	@PermissionName("高亮查询主页")
    public String index(){
        return "lucene";
    }

    private LuceneUtil luceneUtil=new LuceneUtil();
    @RequestMapping("/lucene_list")
    @RequiresPermissions("/lucene_list:list")
   	@PermissionName("高亮查询列表")
    @ResponseBody
    public PageResult Lucene(String content) throws Exception {
        PageResult pageResult = new PageResult();
        List<LuceneVO> list = luceneUtil.getLuceneVOList(content);
        pageResult.setRows(list);
        pageResult.setTotal((long)list.size());
        System.out.println(pageResult);
        return pageResult;
    }
}
