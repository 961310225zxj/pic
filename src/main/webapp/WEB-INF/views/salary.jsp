<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/static/common/common.jsp"%>
<title>Insert title here</title>
<script type="text/javascript" src="/static/js/salary.js"></script>
</head>
<body>
	<table id="salary_datagrid"></table>

	<!-- 顶部按钮 -->
	<div id="salary_tb">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" data-cmd="add">新增</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" data-cmd="edit">编辑</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" data-cmd="del">删除</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
		<br />
		年份:
		<input type="text" name="years" id="year" />
		月份:
		<select id="cc" name="months" style="width: 200px;">
			<option value="-1">全部</option>
			<option value="01">一月</option>
			<option value="02">二月</option>
			<option value="03">三月</option>
			<option value="04">四月</option>
			<option value="05">五月</option>
			<option value="06">六月</option>
			<option value="07">七月</option>
			<option value="08">八月</option>
			<option value="09">九月</option>
			<option value="10">十月</option>
			<option value="11">十一月</option>
			<option value="12">十二月</option>
		</select>
		员工:
		<input type="text" name="realname" />
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true" data-cmd="search">查询</a>
	</div>
	<!-- 底板按钮 -->
	<div id="salary_btns">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
	</div>

	<div id="salary_dialog">
		<form id="salary_form" action="" method="post">
			<input type="hidden" name="id" />
			<table id="salary_table" align="center" style="margin-top: 15px">
				<tr>
					<td>员工:</td>
					<td>
						<select id="salary_emp" type="text" name="employee.id" style="width:144px;"></select>
						<!-- <input id="salary_emp" type="text" name="employee.id"
							class="easyui-combobox"
							data-options="    
							        valueField: 'id',    
							        textField: 'realname',  
							        url: '/employee_listAll.do',panelHeight:'auto'" /> -->
					</td>
				</tr>
				<tr>
					<td>基本工资:</td>
					<td>
						<input type="number" name="salary" />
					</td>
				</tr>
				<tr>
					<td>奖金:</td>
					<td>
						<input type="number" name="bonus" />
					</td>
				</tr>
				<tr>
					<td>年份:</td>
					<td>
						<input type="text" name="year" id="year" />
					</td>
				</tr>
				<tr>
					<td>月份:</td>
					<td>
						<input type="text" name="month" id="month" />
					</td>
				</tr>
				<tr>
					<td>工资总计:</td>
					<td>
						<input type="number" name="total" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>