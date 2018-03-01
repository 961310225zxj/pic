<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp" %>
</head>
<body class="easyui-layout">
	<div data-options="region:'west',split:true,title:'字典目录',href:'/dictionary.do'" style="width:700px;height: 100%;"></div>
	<div data-options="region:'center',title:'目录明细',href:'/dictionaryItem.do'" style="width:50%;height: 100%;"></div>
</body>
</html>