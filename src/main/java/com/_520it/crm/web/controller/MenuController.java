package com._520it.crm.web.controller;

import com._520it.crm.service.IMenuService;
import com._520it.crm.util.CheckMenuUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MenuController {

	@Autowired
	private IMenuService service;


	@RequestMapping("/menu_list")
	@ResponseBody
	public Object list(){
		//把菜单缓存起来
		Session session = SecurityUtils.getSubject().getSession();
		//判断session中是否已经存在该用户的菜单,如果存在就直接取,不存在就查询数据库再放进去
		Object menus = session.getAttribute("MENU_IN_SESSION");
		if(menus==null){
			//查询所有的菜单
			menus = service.getRootMenu();
			//过滤菜单,如果没有权限的菜单,就从集合中移除掉
			CheckMenuUtil.checkMenu((List)menus);
			//放入session中
			session.setAttribute("MENU_IN_SESSION",menus);
		}
		return menus;
	}



	@RequestMapping("/children")
	@ResponseBody
	public Object childrenTree(String menuName)throws Exception{
		//String menu = new String(request.getParameter("menuName").getBytes("ISO8859-1"), "utf-8");ServletRequest request
		Object menus =service.getChildrenMenuByName(menuName);
		return menus;
	}

	@RequestMapping("/indexs")
	public String indexs(){
		return "indexs";
	}
}
