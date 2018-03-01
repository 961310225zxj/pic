<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<%@include file="/static/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全文检索</title>
<script type="text/javascript" src="/static/js/lucene.js"></script>
</head>
<body>
	<table id="lucene_datagrid">
		<thead>
			<tr>
				<th data-options="field:'title',width:1,align:'center'">标题</th>
				<th data-options="field:'content',width:1,align:'center'">内容</th>
				<th data-options="field:'highLight',width:1,align:'center'">高亮</th>
			</tr>
		</thead>
	</table>
	<div id="lucene_datagrid_tb">
		关键字:<input type="text" name="content" placeholder="内容"/>
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchCcontent()"></a>
	</div>
</body>
</html>