<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.border_right_none{
			border-right: none;
		}
	</style>
	<%@include file="/static/common/common.jsp" %>
	<script type="text/javascript" src="/static/js/index.js"></script>
	<script type="text/javascript" src="/static/js/mystyle.js"></script>
	<link rel="stylesheet" type="text/css"href="/static/css/font_style.css">
	<link rel="stylesheet" type="text/css"href="/static/css/mystyle.css">
</head>
<body>
<div id="cc" class="easyui-layout"   data-options="
	fit:true,
	border:false
	">
	
	<div data-options="region:'north',border:false"
		 style="height:120px; background:#EFF5FF;" >
		<div style="position: relative; float: left; left: 35%;"><font class="elegant2">小码哥车险管理系统</font></div>
		<div style="position: relative; height:100%; float: right;line-height:40px;">
			<div style="margin-left: 50px">
				<img width="20px" height="20px" src="/static/css/me.png" alt="abc">
				<font style="font-family: impact, sans-serif;font-size: 1.2em;font-style: italic;word-spacing: -3pt;">当前用户:</font>
				<font style="color: #2C98AB; font-family: impact, sans-serif;font-size: 1.2em;font-style: italic;word-spacing: -3pt;"><shiro:principal property="realname"/></font>
				<a id="pwd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改密码</a>
				<a href="/logout" style="text-decoration: none;"><font style="font-family: impact, sans-serif;font-size: 1.2em;word-spacing: -3pt;"> 退出系统</font></a>
			</div>
			<div>
			  <iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=2&num=3" width="440" height="70"
                    frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
			</div>
		</div>
	</div>
	
	<div style="float: right;line-height:40px;background-color: red">
	 	<!-- <div style="margin-top:20px;margin-right:10px;float: left;">
			
		</div>  -->
		
	</div>
	
	<div data-options="region:'south',border:false"
		 style="height:30px;line-height: 30px;background:#EFF5FF; ">
		<center>©版权所有:广州小码哥科技教育有限公司</center>
	</div>
	<div data-options="region:'west',title:'系统菜单'"
		 style="width:180px;border-right: solid 2px #9EB9E6">
		<%--<ul id="index_tree"></ul>--%>
		<div id="menu" class="easyui-accordion"></div>
	</div>
	<div data-options="region:'center'"  style="padding:1px;background:#eee;" >
		<div id="index_tabs" class="easyui-tabs" data-options="fit:true,border:false" >
			<div title="系统首页" >
				<div style="width: auto;height: 70%" class="bg_auto"></div>
				<div id="div1" style="width: auto;height: 30%" >
					<ul>
						<li><img src="img/1.jpg" /></li>
						<li><img src="img/2.jpg" /></li>
						<li><img src="img/3.jpg" /></li>
						<li><img src="img/4.jpg" /></li>
						<li><img src="img/5.jpg" /></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div id="pwd_dialog">
		<form id="pwdForm" action="" method="post">
			 <table align="center" style="margin-top: 15px">
				<tr>
					<td>原密码</td>
					<td><input id="opwd" name="password" type="password" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input id="pwd" name="newpwd" type="password" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>确认新密码</td>
					<td>
						<input id="rpwd" name="rNewpwd" type="password" class="easyui-validatebox" required="required" validType="equals['#pwd']" />  
					</td>
				</tr>
			</table> 
		</form>
	</div>
	<div id="pwd_btns">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
	</div>
</div>
</body>
</html>