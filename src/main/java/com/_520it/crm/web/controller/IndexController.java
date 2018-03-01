package com._520it.crm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.DataBaseBackUp;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class IndexController extends BaseController {
	@RequestMapping("/index")
	public String index() {
		//获取当前登录的员工对象
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject.getPrincipal());

		return "index_a";
	}

	//备份
	@RequestMapping("/index_backup")
	@ResponseBody
	public AjaxResult backupIn() {
		try {
			DataBaseBackUp.backup();
			return new AjaxResult(true, "成功备份至d盘");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "备份失败");
		}
	}

	//还原
	@RequestMapping("/index_backupin")
	@ResponseBody
	public AjaxResult backupOut(HttpServletRequest request,MultipartFile file) {
		try {
			CommonsMultipartFile cf= (CommonsMultipartFile)file;
			DiskFileItem fi = (DiskFileItem)cf.getFileItem();
			File f = fi.getStoreLocation();
			FileInputStream in=new FileInputStream(f);
			DataBaseBackUp.restore(in);
			return new AjaxResult(true, "数据库还原成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "数据库还原失败");
		}
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest req) {
		//获取用户认证结果
		Subject subject = SecurityUtils.getSubject();
		System.out.println("认证结果:" + subject.isAuthenticated());

		//获取认证失败的异常信息
		String failure = (String) req.getAttribute("shiroLoginFailure");
		System.out.println(failure);

		//根据不同的异常信息来提示不同的错误文字信息
		if (UnknownAccountException.class.getName().equals(failure)) {
			req.setAttribute("errorMsg", "账号不存在!");
		} else if (IncorrectCredentialsException.class.getName().equals(failure)) {
			req.setAttribute("errorMsg", "密码错误!");
		} else {
			req.setAttribute("errorMsg", "网络繁忙,请稍后再试!");
		}
		//请求转发到登录页面
		return "forward:login.jsp";
	}

}
