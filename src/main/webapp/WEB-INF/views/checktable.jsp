<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/static/common/common.jsp"%>
<title>Insert title here</title>
<script type="text/javascript" src="/static/js/checktable.js"></script>
</head>
<body>
	<table id="check_datagrid"></table>

	<!-- 顶部按钮 -->
	<div id="check_tb">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" data-cmd="signIn">签到</a>
		<a href="#" class="easyui-linkbutton" id="emp_tb_edit"
			data-options="iconCls:'icon-add',plain:true" data-cmd="signOut">签退</a>
		<a href="#" class="easyui-linkbutton" id="emp_tb_edit"
			data-options="iconCls:'icon-add',plain:true" data-cmd="checked">补签</a>
		<a href="#" class="easyui-linkbutton" id="emp_tb_edit"
			data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
		<!-- <a href="#" class="easyui-linkbutton" id="emp_tb_edit"
			data-options="iconCls:'icon-reload',plain:true" data-cmd="exportFile">导出</a> -->
	</div>
	<!-- 底板按钮 -->
	<div id="check_btns">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
	</div>

	<div id="check_dialog">
		<form id="check_form" action="" method="post">
			<table align="center" style="margin-top: 15px">
				<tr>
					<td>员工:</td>
					<td>
						<select id="check_emp" type="text" name="employee.id"
							style="width: 144px;"></select>
						<!-- class="easyui-combobox"
							data-options="    
							        valueField: 'id',    
							        textField: 'realname',  
							        url: '/employee_listAll.do',panelHeight:'auto'" 
							        /> -->
					</td>
				</tr>
				<tr>
					<td>状态:</td>
					<td>
						<select id="cc" class="easyui-combobox" name="state"
							panelHeight='auto' style="width: 143px;" required="required">
							<option value="2">补签</option>
							<option value="0">正常</option>
							<option value="1">请假</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>签到时间:</td>
					<td>
						<input type="text" name="signintime" class="easyui-datebox" />
					</td>
				</tr>
				<tr>
					<td>签退时间:</td>
					<td>
						<input type="text" name="signouttime" class="easyui-datebox" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>