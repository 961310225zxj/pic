$(function() {
	// 抽取变量
	var plan_datagrid = $("#plan_datagrid");
	var plan_dialog = $("#plan_dialog");
	var plan_dialogmsg = $("#plan_dialogmsg");
	var plan_form = $("#plan_form");
	var plan_formmsg = $("#plan_formmsg");
	//=================================
	//员工数据表格下拉框
	$("#plan_emp").combogrid({
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
	plan_datagrid.datagrid({
		url : "/plan_listAll.do",
		view : detailview,
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		rownumbers : true,
		toolbar : '#plan_tb',
		columns : [ [ {
			field : 'employee',
			title : '员工姓名',
			width : 100,
			formatter : empFormatter
		}, {
			field : 'plandate',
			title : '日期',
			width : 100,
		}, {
			field : 'planmsg',
			title : '任务描述',
			width : 100,
		}, {
			field : 'handlemsg',
			title : '处理描述',
			width : 100,
		}, {
			field : 'state',
			title : '状态',
			width : 100,
			formatter : stateFormatter
		} ] ],
		onClickRow : function(rowIndex, rowData) {
			// 如果当前行的状态是初始状态,就禁用相应按钮
			if (rowData.state != 0) {
				// 禁用按钮
				$("#plan_tb_edit").linkbutton('disable');
				$("#plan_tb_marksuccess").linkbutton('disable');
				$("#plan_tb_markfailed").linkbutton('disable');
				$("#plan_tb_del").linkbutton('disable');
				$("#plan_tb_handlemsg").linkbutton('disable');
			} else {
				// 显示按钮
				$("#plan_tb_edit").linkbutton('enable');
				$("#plan_tb_marksuccess").linkbutton('enable');
				$("#plan_tb_markfailed").linkbutton('enable');
				$("#plan_tb_del").linkbutton('enable');
				$("#plan_tb_handlemsg").linkbutton('enable');
			}
		},
		
		detailFormatter: function(rowIndex, rowData){
			return '<table><tr>' +
					'<td colspan="3" style="border:0">任务详细描述:</td>' +
					'<td style="border:0">' +
					'<p> <font  color="red">' + rowData.planmsg + '</font></p>' +
					'</td>' +
					'</tr> <tr><td colspan="3" style="border:0">处理情况详细描述:</td> <td style="border:0" ><p><font color="green">'+ rowData.handlemsg+'</font></p></td ></tr></table>';
		},
	});

	// 对话框
	plan_dialog.dialog({
		width : 300,
		height : 400,
		closed : true,
		buttons : "#plan_btns"
	});

	// 处理描述专用
	plan_dialogmsg.dialog({
		width : 300,
		height : 350,
		closed : true,
		buttons : "#plan_btnsmsg"
	});

	function empFormatter(value, row, index) {
		return value ? value.realname : "";
	}
	;

	function stateFormatter(value, row, index) {
		if (value == 0) {
			return "<font color='blue'>初始状态</font>";
		} else if (value == 1) {
			return "<font color='green'>成功</font>";
		} else {
			return "<font color='red'>失败</font>";
		}
	}
	;

	var methodObj = {
		add : function() {
			// 打开对话框
			plan_dialog.dialog("open");
			// 清空
			plan_dialog.form("clear");
			// 设置标题
			plan_dialog.dialog("setTitle", "分配任务");
		},

		// 刷新
		reload : function() {
			plan_datagrid.datagrid("reload");
		},

		// 取消保存
		cancel : function() {
			// 关闭窗口
			plan_dialog.dialog("close");
		},
		cancelmsg : function() {
			// 关闭窗口
			plan_dialogmsg.dialog("close");
		},

		del : function() {
			// 选中数据
			var row = plan_datagrid.datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', "请选择要删除的数据", 'info');
				return;
			}
			;
			$.messager.confirm('温馨提示', '确定要删除吗？', function(r) {
				if (r) {
					$.post("/plan_delete.do", {
						id : row.id
					}, function(data) {
						$.messager.alert('温馨提示', "删除成功", 'info', function() {
							// 关闭弹出后刷新页面
							plan_datagrid.datagrid("reload");
						});
					});
				}
			});
		},
		// 标记完成
		marksuccess : function() {
			var row = plan_datagrid.datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', "请选择要设置状态的数据", 'info');
				return;
			}
			;
			$.messager.confirm('温馨提示', '确定要标记完成吗？', function(r) {
				if (r) {
					$.post("/plan_marksuccess.do", {
						id : row.id
					}, function(data) {
						$.messager.alert('温馨提示', "操作成功", 'info', function() {
							// 关闭弹出后刷新页面
							plan_datagrid.datagrid("reload");
						});
					});
				}
			});
		},
		// 标记失败
		markfailed : function() {
			var row = plan_datagrid.datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', "请选择要设置状态的数据", 'info');
				return;
			}
			;
			$.messager.confirm('温馨提示', '确定要标记失败吗？', function(r) {
				if (r) {
					$.post("/plan_markfailed.do", {
						id : row.id
					}, function(data) {
						$.messager.alert('温馨提示', "操作成功", 'info', function() {
							// 关闭弹出后刷新页面
							plan_datagrid.datagrid("reload");
						});
					});
				}
			});
		},

		// 查询
		search : function() {
			var realname = $("[name='realname']").val();
			var begintime = $("[name='begintime']").val();
			var endtime = $("[name='endtime']").val();

			plan_datagrid.datagrid("load", {
				realname : realname,
				begintime : begintime,
				endtime : endtime
			});
		},

		// 保存
		save : function() {
			var url;
			if ($("[name='id']").val()) {
				url = "/plan_update.do";
			} else {
				url = "/plan_save.do";
			}

			// 提交表单
			plan_form.form('submit', {
				url : url,
				success : function(data) {
					// 转成json对象
					data = $.parseJSON(data);
					if (data.success) {
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 关闭弹出框
							plan_dialog.dialog("close");
							// 刷新数据表格(保持在当前页)
							plan_datagrid.datagrid("reload");
						});
					} else {
						$.messager.alert('温馨提示', data.msg, 'info');
					}
				}
			});
		},
		savemsg : function() {
			// 提交表单
			plan_formmsg.form('submit', {
				url : "/plan_updatemsg.do",
				success : function(data) {
					// 转成json对象
					data = $.parseJSON(data);
					if (data.success) {
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 关闭弹出框
							plan_dialogmsg.dialog("close");
							// 刷新数据表格(保持在当前页)
							plan_datagrid.datagrid("reload");
						});
					} else {
						$.messager.alert('温馨提示', data.msg, 'info');
					}
				}
			});
		},

		// 编辑
		edit : function() {
			// 选中数据
			var row = plan_datagrid.datagrid("getSelected");
			if (!row) {
				$.messager.alert('温馨提示', "请选择一条数据", 'info');
				return;
			}
			// 判断是否是今天的任务
			var date = row.plandate.substring(0, 10).split('-');
			if (parseInt(date[2]) != new Date().getDate() || row.state != 0) {
				$.messager.alert('温馨提示', "不是今天的任务或任务不处于初始状态", 'info');
				return;
			}
			// 打开对话框
			plan_dialog.dialog("open");
			// 情况表单信息
			plan_dialog.form("clear");
			// 回显员工信息
			row["employee.id"] = row["employee"].id;
			plan_dialog.dialog("setTitle", "编辑任务");
			// 回显数据
			plan_dialog.form("load", row);
		},

		// 编辑处理描述
		editmsg : function() {
			// 选中数据
			var row = plan_datagrid.datagrid("getSelected");
			console.log(row);
			if (!row) {
				$.messager.alert('温馨提示', "请选择一条数据", 'info');
				return;
			}
			// 打开对话框
			plan_dialogmsg.dialog("open");
			// 清空表单信息
			plan_dialogmsg.form("clear");
			plan_dialogmsg.dialog("setTitle", "编辑处理");
			// 回显数据
			plan_dialogmsg.form("load", row);
		},
	};

	// 统一绑定事件
	$("a[data-cmd]").on("click", function() {
		// 获取该链接需要执行的方法名字
		var methodName = $(this).data("cmd");
		// 调用方法
		methodObj[methodName]();
	});
})
