<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insuredPerson管理</title>
    <%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/insuredPerson.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="insuredPerson_datagrid">
	</table>
	<!-- 新增编辑对话框 -->
	<div id="insuredPerson_dialog">
		<form id="insuredPerson_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>客户名称</td>
				<td><input type="text" class="easyui-textbox" name="name"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
				 <select class="easyui-combobox" name="gender" style="width:200px;" data-options="panelHeight:'auto'">
					 <option value="1">男</option>
					 <option value="0">女</option>
				 </select>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" class="easyui-textbox" name="age"></td>
			</tr>
			<tr>
				<td>是否投保</td>
				<td>
				<select class="easyui-combobox" name="is_insured" style="width:200px;" data-options="panelHeight:'auto'">
					<option value="0">是</option>
					<option value="1">否</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>风险等级</td>
				<td><input type="text" class="easyui-textbox" name="level"></td>
			</tr>

			<tr>
				<td>是否投保人</td>
				<td>
					<select class="easyui-combobox" name="is_personal" style="width:200px;" data-options="panelHeight:'auto'">
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
				</td>
			</tr>

			<tr>
				<td>职业</td>
				<td><input type="text" class="easyui-textbox" name="profession"></td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td><input type="text" class="easyui-textbox" name="phone"></td>
			</tr>

			<tr>
				<td>证件类型</td>
				<td><input type="text" class="easyui-textbox" name="numberType"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" class="easyui-textbox" name="email"></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input type="text" class="easyui-textbox" name="number"></td>
			</tr>

			<tr>
				<td>通讯地址</td>
				<td><input type="text" class="easyui-textbox" name="address"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="insuredPerson_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="insuredPerson_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>