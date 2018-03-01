$(function() {
	$("#client_datagrid").datagrid({

		columns : [ [ {
			field : 'name',
			title : '客户名称',
			width : 200,
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
			width : 400,
			align : 'center'
		}, {
			field : 'isInsured',
			title : '是否投保',
			width : 100,
			align : 'center',
			formatter : insuranceFormatter
		}, {
			field : 'address',
			title : '家庭地址',
			width : 400,
			align : 'center'
		}, {
			field : 'email',
			title : '邮箱',
			width : 400,
			align : 'center'
		}, {
			field : 'phone',
			title : '电话',
			width : 200,
			align : 'center'
		}, {
			field : 'inputtime',
			title : '录入时间',
			width : 200,
			align : 'center'
		}, {
			field : 'profession',
			title : '职业',
			width : 100,
			align : 'center'
		} ] ],
		fit: true,
		striped : true, // 是否显示斑马线效果
		fitColumns : true,
		pagination : true,// 分页
		singleSelect : true,// 只能选择了单行
		rownumbers: true,
		url : '/client_list.do',
		toolbar : '#normal_bt',
	});
	// 是否已投保
	function insuranceFormatter(value, row, index) {
		console.log(value);
		return value ? '<span style="color: green">是</span>'
				: '<span style="color: red">否</span>';
	}

	/* 初始化会话框 */
	$('#client_dialog').dialog({
		width : 300,
		height : 380,
		closed : true,
		buttons : '#normal_bttn'
	});
	/* 初始化会话框数据表 */

	// 使用对象来统一管理方法
	var methodObj = {
		// 取消
		cancel : function() {
			$("#client_dialog").dialog("close");
		},
		// 保存
		add : function() {
			// 清空数据
			$("#client_form").form("clear");
			// 打开表单
			$("#client_dialog").dialog("open");
			// 设置对话框的标题
			$("#client_dialog").dialog("setTitle", "新增客户");
		},

		// 编辑
		edit : function() {
			// 判断是否选中数据
			var row = $("#client_datagrid").datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', '请选中一条数据!', 'info');
				return;
			}
			
			// 清空表单
			$("#client_form").form("clear");
			// 是否投保
			if (row) {
				row["isInsured"] = row["isInsured"]==false?"否":"是";
			}
			console.log(row);
			// 回显数据
			$("#client_dialog").form("load", row);
			
			// 打开弹出框
			$("#client_dialog").dialog("open");

			// 设置标题
			$("#client_dialog").dialog("setTitle", "编辑客户");
		},

		// 保存
		save : function() {
			// 判断是否有id

			var url;
			if ($("[name='id']").val()) {

				url = "/client_update.do";
			} else {
				url = "/client_save.do";

			}

			// 提交表单
			$("#client_form").form('submit', {
				url : url,
				success : function(data) {
					// 转成json对象
					data = $.parseJSON(data);
					if (data.success) {
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 关闭弹出框
							$('#client_dialog').dialog("close");
							// 刷新数据表格(保持在当前页)
							$("#client_datagrid").datagrid("reload");
						});
					} else {
						$.messager.alert('温馨提示', data.msg, 'info');
					}
				}
			});
		},

		// 接触关系
		del : function() {
			// 判断是否选中数据
			var row = $("#client_datagrid").datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', '请选中一条数据!', 'info');
				return;
			}
			$.messager.confirm('确认对话框', '您想要删除该数据吗？', function() {

				// 删除被选中的行deleteRow(只是在页面中删除,数据库中还存在,发送请求从数据库中删除)
				// $("#client_datagrid").datagrid("deleteRow",row.id-1);
				// 从数据库中删除数据
				// 发送ajax请求去删除数据库中的数据
				$.post('/client_delete.do', {
					id : row["id"]
				}, function(data) {
					if (data.success) {
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 关闭弹出框
							$('#client_dialog').dialog("close");
							// 刷新数据表格(保持在当前页)
							$("#client_datagrid").datagrid("reload");
						});
					} else {
						$.messager.alert('温馨提示', data.msg, 'info');
					}
				});
				// 重新加载页面
				$("#client_datagrid").datagrid("reload");
			});
		},
        //导入功能
        jxlIn:function(){
			$("#ff_dialog").dialog("open");
		},
		// 客户共享
		share : function() {
			var row = $("#client_datagrid").datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', '请选中一条数据!', 'info');
				return;
			}
			$.messager.confirm('温馨提示', '确认要把客户放在共享池中吗?', function(r) {
				if (r) {
					$.post('/client_share.do', {
						id : row.id

					}, function() {
								// 关闭弹出框
								$('#client_dialog').dialog("close");
								// 刷新数据表格(保持在当前页)
								$("#client_datagrid").datagrid("reload");
					})
				}
			});
		},

		// 高级查询
		searchForm : function() {
			// 获取关键字文本框的值
			var keyword = $("[name='keyword']").val();

			$("#client_datagrid").datagrid('load', {
				keyword : keyword
			});
		},

		// 查询全部数据(刷新)
		reload : function() {
			// 清空查询条件的内容
			$("[name='keyword']").val('');

			$("#client_datagrid").datagrid('load', {});
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
