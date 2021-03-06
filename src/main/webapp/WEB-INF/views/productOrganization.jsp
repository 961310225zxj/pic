<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>productOrganization管理</title>
    <%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/productOrganization.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="productOrganization_datagrid">
		<thead>
			<tr>
				<th data-options="field:'sn',width:1,align:'center'">机构编码</th>
				<th data-options="field:'name',width:1,align:'center'">机构名称</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="productOrganization_dialog">
		<form id="productOrganization_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>机构编码</td>
				<td><input type="text" class="easyui-textbox" name="sn"></td>
			</tr>
			<tr>
				<td>机构名称</td>
				<td><input type="text" class="easyui-textbox" name="name"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="productOrganization_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="productOrganization_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>