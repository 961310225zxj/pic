$(function() {
	$("#tr_datagrid").datagrid({
		url : '/transferrecord_list.do',
		columns : [ [ {
			field : 'client',
			title : '客户名称',
			width : 100,
			formatter : clientFormatter
		}, {
			field : 'transferdate',
			title : '移交时间',
			width : 100
		}, {
			field : 'marketList',
			title : '市场专员',
			width : 100,
			formatter : marketFormatter
		}, {
			field : 'transferreson',
			title : '移交原因',
			width : 100
		}, {
			field : 'operator',
			title : '操作人',
			width : 100,
			formatter : operatFormatter
		} ] ],
		fit : true,
		fitColumns : true,
		pagination : true,
		singleSelect : true,
		toolbar : "#tb"
	});
	$("#tr_dialog").dialog({
		width : 280,
		height : 260,
		closed : true,
		buttons : "#bt"
	});

})

function clientFormatter(value, row, index) {
	return value ? value.name : "";
}

function marketFormatter(value, row, index) {
	return value ? value.realname : "";
}

function operatFormatter(value, row, index) {
	return value ? value.realname : "";
}

function add() {
	$("#tr_dialog").dialog('open');
	$("#editForm").form('clear');
	$("#tr_dialog").dialog('setTitle', '移交客户');

}

function cancel() {
	$("#tr_dialog").dialog('close');
}

function save() {
	$("#editForm").form('submit', {
		url : '/transferrecord_insert.do',
		success : function(data) {
			data = $.parseJSON(data);
			if (data.success) {
				$.messager.alert('温馨提示', data.msg, 'info', function() {
					$("#tr_dialog").dialog('close');
					$("#tr_datagrid").datagrid('reload');
				});
			}
		}
	});
}

function reload() {

	$("[name='keyword']").val('');
	$("[name='beginDate']").val('');
	$("[name='endDate']").val('');
	$("#tr_datagrid").datagrid('reload', {});

}



function searchForm() {
	
	var keyword = $("[name='keyword']").val();
	var beginDate = $("[name='beginDate']").val();
	var endDate = $("[name='endDate']").val();
	
	$("#tr_datagrid").datagrid('load',{
		keyword:keyword,
		beginDate:beginDate,
		endDate:endDate
	});
}
