<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>carInformation管理</title>
    <%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/carInformation.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="carInformation_datagrid">
	</table>
	<!-- 新增编辑对话框 -->
	<div id="carInformation_dialog">
		<form id="carInformation_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>车牌号</td>
				<td><input type="text" class="easyui-textbox" name="carId"></td>
			</tr>
			<tr>
				<td>车牌类型</td>
				<td><input type="text" class="easyui-textbox" name="carIdType"></td>
			</tr>
			<tr>
				<td>是否过户</td>
				<td>
					<select class="easyui-combobox" name="is_transfer" style="width:200px;" data-options="panelHeight:'auto'">
						<option value="0">否</option>
						<option value="1">是</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>车辆型号</td>
				<td><input type="text" class="easyui-textbox" name="cartypeinformation"></td>
			</tr>
			<tr>
				<td>汽车品牌</td>
				<td>
					<select class="easyui-combobox" name="carBrand.id" style="width:200px;" data-options="panelHeight:'auto'">
						<option value="1">奔驰</option>
						<option value="2">宝马</option>
						<option value="3">路虎</option>
						<option value="4">保时捷</option>
						<option value="5">奥迪</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>是否上牌</td>
				<td>
					<select class="easyui-combobox" name="is_license" style="width:200px;" data-options="panelHeight:'auto'">
						<option value="0">否</option>
						<option value="1">是</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>是否外地车</td>
				<td>
					<select class="easyui-combobox" name="is_foreignCar" style="width:200px;" data-options="panelHeight:'auto'">
						<option value="0">否</option>
						<option value="1">是</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>是否新车</td>
				<td>
					<select class="easyui-combobox" name="is_newCar" style="width:200px;" data-options="panelHeight:'auto'">
						<option value="0">否</option>
						<option value="1">是</option>
					</select>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="carInformation_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="carInformation_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>