$(function() {
	
	$("#per_datagrid").datagrid({
		url : '/permission_listAll.do',
		columns : [ [ {
			field : 'name',
			title : '权限名称',
			align : 'center',
			width : 100
		}, {
			field : 'resource',
			title : '权限表达式',
			align : 'center',
			width : 100
		} ] ],
		fit : true,
		fitColumns : true,
		pagination : true,
		singleSelect : true,
		toolbar : '#tb'
	});

})

function reload() {
	
	$("#per_datagrid").datagrid({
		url:'/loadPermission.do'
	})
	
	$("#per_datagrid").datagrid('reload');
	
}