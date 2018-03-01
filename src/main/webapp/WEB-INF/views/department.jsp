<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp"%>

<script type="text/javascript" src="/static/js/department.js"></script>
</head>
<body>
	<table id="dept_datagrid"></table>

	<div id="dept_dialog">
		<form id="dept_form" method="post">
			<input type="hidden" name="id" />
			<table align="center" style="margin-top: 15px">
				<tbody>
					<tr>
						<td>部门名称:</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>部门编号:</td>
						<td><input type="text" name="sn" /></td>
					</tr>

					<tr>
						<td>上级部门:</td>
						<td><input id="parent_combox" type="text" name="parent.id"
							class="easyui-combobox"
							data-options="    
					        valueField: 'id',    
					        textField: 'name',    
					        url: '/dept_listAll.do',panelHeight:'auto'" />
						</td>
					</tr>
					<tr>
						<td>部门经理:</td>
						<td><input id="manager_combox" type="text" name="manager.id"
							class="easyui-combobox"
							data-options="    
					        valueField: 'id',    
					        textField: 'realname',    
					        url: '/dept_manager.do',panelHeight:'auto'" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

	<div id="dept_tb">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="add">新增</a>
		<a href="#" class="easyui-linkbutton" id="dept_tb_edit" data-options="iconCls:'icon-edit',plain:true" data-cmd="edit">编辑</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" id="dept_tb_cs" data-cmd="deleteDept">删除</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" id="dept_tb_cs" data-cmd="reload">查询全部</a>
	</div>

	<div id="dept_btns">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
	</div>
	
</body>
</html>