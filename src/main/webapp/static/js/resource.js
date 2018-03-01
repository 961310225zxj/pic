$(function() {
	$("#resource_datagrid").datagrid({

		columns : [ [ {
			field : 'name',
			title : '客户名称',
			width : 100,
			align : 'center'
		}, {
			field : 'gender',
			title : '性别',
			width : 100,
			align : 'center'
		}, {
			field : 'age',
			title : '客户年龄',
			width : 100,
			align : 'center'
		}, {
			field : 'number',
			title : '身份证号',
			width : 100,
			align : 'center'
		}, {
			field : 'address',
			title : '家庭地址',
			width : 100,
			align : 'center'
		}, {
			field : 'email',
			title : '邮箱',
			width : 100,
			align : 'center'
		}, {
			field : 'phone',
			title : '电话',
			width : 100,
			align : 'center'
		}, {
			field : 'inputtime',
			title : '录入时间',
			width : 100,
			align : 'center'
		}, {
			field : 'profession',
			title : '职业',
			width : 100,
			align : 'center'
		} ] ],
		striped : true, // 是否显示斑马线效果
		fitColumns : true,
		pagination : true,// 分页
		singleSelect : true,// 只能选择了单行
		url : '/resource_list.do',
		fit : true,
		toolbar : '#normal_bt'
	});

	// 使用对象来统一管理方法
	var methodObj = {

		absorb : function() {
			var row = $("#resource_datagrid").datagrid('getSelected');
			if (!row) {
				$.messager.alert('温馨提示', '请选择一条数据', 'info');
				return;
			}

			$.messager.confirm('温馨提示', '确认要执行该操作吗?', function(r) {
				if (r) {
					$.post('/resource_adsorb.do', {
						id : row.id
					}, function(data) {
						if (data.success) {
							$.messager.alert('温馨提示', data.msg, 'info',
									function() {
										$("#resource_datagrid").datagrid('reload');
									});
						} else {
							$.messager.alert('温馨提示', data.msg, 'info');
						}
					});
				}
			})
		},

		// 高级查询
		searchForm : function() {
			// 获取关键字文本框的值
			var keyword = $("[name='keyword']").val();

			$("#resource_datagrid").datagrid('load', {
				keyword : keyword
			});
		},

		// 查询全部数据(刷新)
		reload : function() {
			// 清空查询条件的内容
			$("[name='keyword']").val('');

			$("#resource_datagrid").datagrid('load', {});
		}
	}

	// 统一绑定事件
	$("a[data-cmd]").on("click", function() {
		// 获取该链接需要执行的方法名字
		var methodName = $(this).data("cmd");
		// 掉用方法
		methodObj[methodName]();
	});

});
