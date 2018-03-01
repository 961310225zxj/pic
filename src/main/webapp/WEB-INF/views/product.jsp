<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>product管理</title>
    <%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/product.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="product_datagrid">
		<%--<thead>
			<tr>
				<th data-options="field:'name',width:1.5,align:'center'">保险产品名称</th>
				<th data-options="field:'salePrice',width:1,align:'center'">保险价格</th>
				<th data-options="field:'compensation',width:1,align:'center'">赔偿额度</th>
				<th data-options="field:'safetyDate',width:1,align:'center'">保险年限</th>
				<th data-options="field:'productOrganization',width:1.5,align:'center',formatter:productOrganizationformatter">机构名称</th>
				<th data-options="field:'introduce',width:4,align:'center'">保险介绍</th>
			</tr>
		</thead>--%>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="product_dialog">
		<form id="product_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">

			<tr>
				<td>保险产品名称</td>
				<td><input type="text" class="easyui-textbox" name="name"></td>
			</tr>

			<tr>
				<td>保险价格</td>
				<td><input type="text" class="easyui-textbox" name="salePrice"></td>
			</tr>

			<tr>
				<td>赔偿额度</td>
				<td><input type="text" class="easyui-textbox" name="compensation"></td>
			</tr>

			<tr>
				<td>保险年限</td>
				<td><input type="text" class="easyui-textbox" name="safetyDate"></td>
			</tr>

			<tr>
				<td>保险介绍</td>
				<td><input type="text" class="easyui-textbox" name="introduce"></td>
			</tr>

			<tr>
				<td>机构名称</td>
				<td>
                    <input type="text" class="easyui-combobox" name="productOrganization.id"
                           data-options="valueField:'id',textField:'name',url:'/productOrganization_listAll.do',panelHeight:'auto'"
                    >
                </td>
			</tr>

		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="product_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="product_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>