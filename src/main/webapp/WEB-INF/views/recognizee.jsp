<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>recognizee管理</title>
    <%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/recognizee.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="recognizee_datagrid">
	</table>
	<!-- 新增编辑对话框 -->
	<div id="recognizee_dialog">
		<form id="recognizee_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>客户名称</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>联系电话</td>
				<td><input type="text" name="phoneNumber"></td>
			</tr>

			<tr>
				<td>证件类型</td>
				<td><input type="text" name="numberType"></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input type="text" name="number"></td>
			</tr>

			<tr>
				<td>是否投保人</td>
				<td><input type="text" name="is_personal"></td>
			</tr>
			<tr>
				<td>风险等级</td>
				<td><input type="text" name="level"></td>
			</tr>

			<tr>
				<td>通讯地址</td>
				<td><input type="text" name="address"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="recognizee_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="recognizee_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>