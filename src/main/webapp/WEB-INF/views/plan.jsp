<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/static/common/common.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/static/plugins/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/css/demo.css">
<script type="text/javascript"
	src="/static/plugins/easyui/datagrid-detailview.js"></script>
<script type="text/javascript" src="/static/js/plan.js"></script>
</head>
<body>
	<table id="plan_datagrid"></table>

	<!-- 顶部按钮 -->
	<div id="plan_tb">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" data-cmd="add">分配任务</a>
		<a href="#" class="easyui-linkbutton" id="plan_tb_edit"
			data-options="iconCls:'icon-edit',plain:true" data-cmd="edit">编辑任务</a>
		<a href="#" class="easyui-linkbutton" id="plan_tb_del"
			data-options="iconCls:'icon-remove',plain:true" data-cmd="del">删除任务</a>
		<a href="#" class="easyui-linkbutton" id="plan_tb_marksuccess"
			data-options="iconCls:'icon-ok',plain:true" data-cmd="marksuccess">标记完成</a>
		<a href="#" class="easyui-linkbutton" id="plan_tb_markfailed"
			data-options="iconCls:'icon-ok',plain:true" data-cmd="markfailed">标记失败</a>
		<a href="#" class="easyui-linkbutton" id="plan_tb_handlemsg"
			data-options="iconCls:'icon-ok',plain:true" data-cmd="editmsg">编辑处理描述</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
		<br />
		名称关键字查询:
		<input type="text" name="realname" />
		时间:
		<input type="text" name="begintime" class="easyui-datebox" />
		-
		<input type="text" name="endtime" class="easyui-datebox" />
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true" data-cmd="search">查询</a>
	</div>
	<!-- 底板按钮 -->
	<div id="plan_btns">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
	</div>
	<!-- 底板按钮 -->
	<div id="plan_btnsmsg">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" data-cmd="savemsg">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancelmsg">取消</a>
	</div>

	<div id="plan_dialog">
		<form id="plan_form" action="" method="post">
			<input type="hidden" name="id" />
			<table align="center" style="margin-top: 15px">
				<tr>
					<td>员工:</td>
					<td>
						<select id="plan_emp" type="text" name="employee.id" style="width:144px;"></select>
						<!-- <input id="plan_emp" type="text" name="employee.id"
							class="easyui-combobox"
							data-options="    
							        valueField: 'id',    
							        textField: 'realname',  
							        url: '/employee_listAll.do',panelHeight:'auto'" /> -->
					</td>
				</tr>
				<tr>
					<td>任务描述:</td>
					<td>
						<textarea rows="10" cols="14" name="planmsg"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="plan_dialogmsg">
		<form id="plan_formmsg" action="" method="post">
			<input type="hidden" name="id" />
			<table align="center" style="margin-top: 15px">
				<tr>
					<td>处理描述:</td>
					<td>
						<textarea rows="10" cols="20" name="handlemsg"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>