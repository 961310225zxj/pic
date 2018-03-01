<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><bgsound src=china.mid loop="-1">
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
	<%--<script type="text/javascript" src="/static/js/mystyle.js"></script>--%>
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
			<div title="系统首页" class="bg_auto">
				<div style="width: auto;height: 70%" class="bg_auto"></div>
				<div id="div1" style="width: auto;height: 30%" >
					<ul>
						<li><img src="/static/image/1.png" /></li>
						<li><img src="/static/image/1.png" /></li>
						<li><img src="/static/image/1.png" /></li>
						<li><img src="/static/image/1.png" /></li>
						<li><img src="/static/image/1.png" /></li>
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

<script type="text/javascript">
	var oDiv1 = document.getElementById('div1');
	var oUl = oDiv1.children[0];
	var aLi = oUl.children;
	var speed = 2;

	oUl.innerHTML += oUl.innerHTML;
	oUl.style.width = aLi[0].offsetWidth * aLi.length + "px"; //设置ul的宽度，使它能够容纳所有的li，不至于li换行

	var timer = setInterval(move, 30);

	function move() {
		//左滚动：如果ul滚动到其宽度的一半时，调整其左边距为0
		if (oUl.offsetLeft < -oUl.offsetWidth / 2) {
			oUl.style.left = "0";
		}

		//右滚动：如果ul滚动距离左边距大于0时，调整其左边距位置为其宽度的一半
		if (oUl.offsetLeft > 0) {
			oUl.style.left = -oUl.offsetWidth / 2 + "px";
		}

		oUl.style.left = oUl.offsetLeft + speed + "px";
	}

	oDiv1.onmouseover = function() {
		clearInterval(timer);
	};
	oDiv1.onmouseout = function() {
		timer = setInterval(move, 30);
	};

	var oDiv2 = document.getElementById('div2');
	oDiv2.children[0].onclick = function() {
		speed = -Math.abs(speed);
	};

	oDiv2.children[1].onclick = function() {
		speed = Math.abs(speed);
	};
</script>




</body>
</html>