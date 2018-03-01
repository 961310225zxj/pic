$(function() {
	// 抽取变量
	var dept_datagrid = $("#dept_datagrid");
	var dept_dialog = $("#dept_dialog");
	var dept_form = $('#dept_form');

	// 初始化数据表格
	dept_datagrid.datagrid({
		url : "/dept_listAll.do",
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		toolbar : '#dept_tb',
		columns : [ [ {
			field : 'name',
			title : '部门名称',
			align : 'center',
			width : 100
		}, {
			field : 'sn',
			title : '部门编号',
			align : 'center',
			width : 100
		}, {
			field : 'manager',
			title : '部门经理',
			align : 'center',
			width : 100,
			formatter : mgerFormatter
		}, {
			field : 'parent',
			title : '上级部门',
			align : 'center',
			width : 100,
			formatter : deptFormatter
		}, {
			field : 'state',
			title : '状态',
			align : 'center',
			width : 100,
			formatter : stateFormatter
		} ] ]
	});
	dept_dialog.dialog({
		width : 300,
		height : 250,
		buttons : '#dept_btns',
		closed : true
	});

	// 部门格式化
	function stateFormatter(value, row, index) {
		return value ? "异常" : "正常";
	}

	function mgerFormatter(value, row, index) {
		return value ?value.realname: "";
	}
	
	function deptFormatter(value, row, index) {
		return value ?value.name: "";
	}

	// 使用对象来统一管理方法
	var methodObj = {
		// 新增
		add : function() {
			// 打开弹出框
			dept_dialog.dialog("open");
			// 清空表单
			dept_form.form('clear');
			// 设置标题
			dept_dialog.dialog("setTitle", "新增");
		},

		// 编辑
		edit : function() {
			// 判断是否选中数据
			var row = dept_datagrid.datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', '请选中一条数据!', 'info');
				return;
			}

			// 清空表单
			dept_form.form("clear");

			if(row["manager"]){
				row["manager.id"]=row["manager"].id;
			}
			
			if(row["parent"]){
				row["parent.id"]=row["parent"].id;
			}
			
			// 回显数据
			dept_form.form("load", row);

			// 打开弹出框
			dept_dialog.dialog("open");
			// 设置标题
			dept_dialog.dialog("setTitle", "编辑员工");

		},

		// 取消保存
		cancel : function() {
			// 关闭窗口
			dept_dialog.dialog("close");
		},

		// 保存
		save : function() {
			// 判断是否有id
			var url;
			if ($("[name='id']").val()) {
				url = "/dept_update.do";
			} else {
				url = "/dept_save.do";
			}

			// 提交表单
			dept_form.form('submit', {
				url : url,
				success : function(data) {
					// 转成json对象
					data = $.parseJSON(data);
					if (data.success) {
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 关闭弹出框
							dept_dialog.dialog("close");
							// 刷新数据表格(保持在当前页)
							dept_datagrid.datagrid("reload");
						});
					} else {
						$.messager.alert('温馨提示', data.msg, 'info');
					}
				}
			});
		},

		// 设置为离职
		deleteDept : function() {
			// 判断是否选中数据
			var row = dept_datagrid.datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', '请选中一条数据!', 'info');
				return;
			}
			// 弹出确认框
			$.messager.confirm('确认对话框', '确认要删除部门吗？', function(r) {
				if (r) {
					$.post("/dept_delete.do", {
						id : row.id
					}, function(data) {
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 刷新数据表格(保持在当前页)
							dept_datagrid.datagrid("reload");
						});
					})
				}
			});

		},
		
		// 查询全部数据
		reload : function() {
			// 清空查询条件的内容
			$("[name='keyword']").val('');

			dept_datagrid.datagrid('load', {});
		}

	}
	// 统一绑定事件
	$("a[data-cmd]").on("click", function() {
		// 获取该链接需要执行的方法名字
		var methodName = $(this).data("cmd");
		// 掉用方法
		methodObj[methodName]();
	})

})
