<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp"%>

<script type="text/javascript" src="/static/js/transferrecord.js"></script>
</head>
<body>
	<table id="tr_datagrid"></table>


	<div id="tr_dialog">
		<form action="" method="post" id="editForm">
			<input type="hidden" name="id">
			<table align="center" style="margin: 17px">
				<tr>
					<td>客户名称:</td>
					<td><input type="text" name="client.id" required="required"
						class="easyui-combobox"
						data-options="valueField:'id', textField:'name',    
				        url: '/client_listAll.do',panelHeight:'auto'"></td>
				</tr>
				<tr>
					<td>移交时间:</td>
					<td><input type="text" name="transferdate"
						class="easyui-datebox"></td>
				</tr>
				<tr>
					<td>市场专员:</td>
					<td><input type="text" name="marketList.id"
						class="easyui-combobox" required="required"
						data-options=" valueField: 'id', textField: 'realname',    
						url: '/employee_listAll.do' ,panelHeight:'auto'" />
					</td>
				</tr>
				<tr>
					<td>移交原因:</td>
					<td><input type="text" name="transferreson"></td>
				</tr>
				<tr>
					<td>操作人:</td>
					<td><input type="text" name="operator.id"
						class="easyui-combobox"
							required="required"
						data-options="valueField: 'id',textField: 'realname',    
			        url: '/employee_listAll.do' ,panelHeight:'auto'"></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="tb">
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onClick="add()">创建移交客户</a>
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true" onClick="reload()">查询全部</a>
			客户名称:<input type="text" name="keyword">
		 	移交时间:<input type="text" name="beginDate" class="easyui-datebox">-<input
			type="text" name="endDate" class="easyui-datebox"> 
			<a class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true" onclick="searchForm()">查询</a>
	</div>

	<div id="bt">
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onClick="save()">保存</a>
		<a class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" onClick="cancel()">取消</a>
	</div>

</body>
</html>