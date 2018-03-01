<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp"%>

<script type="text/javascript" src="/static/js/permission.js"></script>
</head>
<body>
	<table id="per_datagrid"></table>

	<div id="tb">
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true" onClick="reload()">加载权限</a>
	</div>


</body>
</html>