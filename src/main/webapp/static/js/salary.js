$(function() {
	// 抽取变量
	var salary_datagrid = $("#salary_datagrid");
	var salary_dialog = $("#salary_dialog");
	var salary_form = $("#salary_form");
	//=================================
	//员工数据表格下拉框
	$("#salary_emp").combogrid({
        panelWidth: 500,
        idField: 'id',
        textField: 'realname',
        url: '/employee_list.do',
        method: 'post',
        columns: [[
            {field:'realname',title:'员工姓名',align : 'center',width:100},
            {field:'tel',title:'联系电话',align : 'center',width:100},
            {field:'email',title:'email',align : 'center',width:100},
            {field:'dept',title:'所在部门',width:100,align : 'center',formatter : deptFormatter}
        ]],
        fitColumns: true
	});
	// 部门格式化
	function deptFormatter(value, row, index) {
		return value ? value.name : "";
	}
	//=================================
	
	// 初始化数据表格
	salary_datagrid.datagrid({
		url : "/salary_listqo.do",
		
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		rownumbers : true,
		toolbar : '#salary_tb',
		columns : [ [ {
			field : 'id',
			title : '编号',
			width : 100,
		}, {
			field : 'employee',
			title : '员工姓名',
			width : 100,
			formatter : empNameFormatter
		}, {
			field : 'salary',
			title : '基本工资',
			width : 100
		}, {
			field : 'bonus',
			title : '奖金',
			width : 100
		}, {
			field : 'year',
			title : '年份',
			width : 100
		}, {
			field : 'month',
			title : '月份',
			width : 100
		}, {
			field : 'total',
			title : '工资总计',
			width : 100
		} ] ]
	});

	$("#year").numberbox({
		min : 1,
	});
	$("#month").numberbox({
		min : 1,
		max : 12
	});

	// d对话框
	salary_dialog.dialog({

		width : 250,
		height : 280,
		closed : true,
		buttons : "#salary_btns"
	});

	function empNameFormatter(value, row, index) {
		return value ? value.realname : "";
	}
	;

	var methodObj = {
		// 刷新
		reload : function() {
			salary_datagrid.datagrid("reload");
		},

		// 取消保存
		cancel : function() {
			// 关闭窗口
			salary_dialog.dialog("close");
		},

		// 新增
		add : function() {
			// 打开对话框
			salary_dialog.dialog("open");
			// 清空表单
			salary_form.form("clear");
			// 设置标题
			salary_dialog.dialog("setTitle", "新增工资信息");
		},

		// 保存
		save : function() {
			var url;
			if ($("[name='id']").val()) {
				url = "/salary_update.do";
			} else {
				url = "/salary_save.do";
			}

			// 提交表单
			salary_form.form('submit', {
				url : url,
				success : function(data) {
					// 转成json对象
					data = $.parseJSON(data);
					if (data.success) {
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 关闭弹出框
							salary_dialog.dialog("close");
							// 刷新数据表格(保持在当前页)
							salary_datagrid.datagrid("reload");
						});
					} else {
						$.messager.alert('温馨提示', data.msg, 'info');
					}
				}
			});
		},

		edit : function() {
			// 选中数据
			var row = salary_datagrid.datagrid("getSelected");
			console.log(row);
			if (!row) {
				$.messager.alert('温馨提示', "请选择一条数据", 'info');
				return;
			}
			// 打开对话框
			salary_dialog.dialog("open");
			// 清空表单信息
			salary_dialog.form("clear");
			salary_dialog.dialog("setTitle", "编辑工资");
			row["employee.id"] = row["employee"].id;
			// 回显数据
			salary_dialog.form("load", row);
		},
		// 删除
		del : function() {
			// 选中数据
			var row = salary_datagrid.datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', "请选择一条数据", 'info');
				return;
			}

			$.messager.confirm('温馨提示', '确定要删除吗？', function(r) {
				if (r) {
					$.post("/salary_delete.do", {
						id : row.id
					}, function(data) {
						console.log(data);
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 刷新数据表格(保持在当前页)
							salary_datagrid.datagrid("reload");
						});
					})
				}
			});
		},

		// 查询
		search : function() {
			var years = $("[name='years']").val();
			var months = $("[name='months']").val();
			var realname = $("[name='realname']").val();
			salary_datagrid.datagrid('load', {
				years : years,
				months : months,
				realname : realname
			});
		}
	};

	// 统一绑定事件
	$("a[data-cmd]").on("click", function() {
		// 获取该链接需要执行的方法名字
		var methodName = $(this).data("cmd");
		// 调用方法
		methodObj[methodName]();
	});
})
