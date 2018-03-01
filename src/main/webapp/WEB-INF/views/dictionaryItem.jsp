<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>字典明细</title>
</head>
<body>
	<script type="text/javascript" src="/static/js/dictionaryItem.js"></script>
	<table id="dictionaryItem_datagrid"></table>
<!-- 	 <thead>
		<tr>
			<th data-options="field:'id',width:100,align:'center'">字典明细编号</th>
			<th data-options="field:'name',width:100,align:'center'">字典明细名称</th>
			<th data-options="field:'intro',width:100,align:'center'">字典明细简介</th>
			<th data-options="field:'parent',width:100,align:'center'">字典目录</th>
		</tr>
	</thead> -->
	
	
	<!-- 编辑窗口 -->
	<div id="dictionaryItem_dialog">
		<form id="dictionaryItemForm" action="" method="post">
		<input type="hidden" name="id" id="hiddenId"/>
			<table align="center" style="margin-top: 15px">
				<tr>
					<td>字典目录</td>
					<td><input type="text" name="parent.name" id="parentName" readonly style="background: grey"/></td>
				</tr>
				<tr>
					<td>明细名称</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>明细简介</td>
					<td>
						<textarea rows="3" cols="21" name="intro"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 按钮 -->
	<div id="dictionaryItem_tb">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-item='addItem'>新增</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" data-item='editItem'>编辑</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-item='delItem'>禁用</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-item='reloadItem'>刷新</a>  
	</div>
	<!-- 保存与取消 -->
	<div id="dictionaryItem_bt">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-item='saveItem'>保存</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-item='cancelItem'>取消</a>  
	</div>
</body>
</html>