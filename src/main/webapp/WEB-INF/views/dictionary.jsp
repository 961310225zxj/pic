<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>字典目录</title>
</head>
<body>
	<!-- 只能放在body 否则加载不了,因为href属性之会加载body里面的元素 -->
	<script type="text/javascript" src="/static/js/dictionary.js"></script>
	<!-- 数据表格 -->
	<table id="dictionary_datagrid"></table>
	<!-- 编辑窗口 -->
	<div id="dictionary_dialog">
		<!-- 编辑窗口 -->
		<form id="dictionaryForm" action="" method="post">
			<input type="hidden" name="id"/>
			<table align="center" style="margin-top: 15px">
				<tr>
					<td>字典编号</td>
					<td><input type="text" name="sn"/></td>
				</tr>
				<tr>
					<td>字典名称</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>字典简介</td>
					<td>
						<textarea rows="3" cols="21" name="intro"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 按钮 -->
	<div id="dictionary_tb">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd='add'>新增</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" data-cmd='edit'>编辑</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-cmd='del'>删除</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd='reload'>刷新</a>  
	</div>
	<!-- 保存与取消 -->
	<div id="dictionary_bt">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
	</div>
</body>

</html>