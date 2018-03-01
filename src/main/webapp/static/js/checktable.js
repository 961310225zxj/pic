$(function() {
	// 抽取变量
	var check_datagrid = $("#check_datagrid");
	var check_dialog = $("#check_dialog");
	var check_form = $("#check_form");
	// =================================
	// 员工数据表格下拉框
	$("#check_emp").combogrid({
		panelWidth : 500,
		idField : 'id',
		textField : 'realname',
		url : '/employee_list.do',
		method : 'post',
		columns : [ [ {
			field : 'realname',
			title : '员工姓名',
			align : 'center',
			width : 100
		}, {
			field : 'tel',
			title : '联系电话',
			align : 'center',
			width : 100
		}, {
			field : 'email',
			title : 'email',
			align : 'center',
			width : 100
		}, {
			field : 'dept',
			title : '所在部门',
			width : 100,
			align : 'center',
			formatter : deptFormatter
		} ] ],
		fitColumns : true
	});
	// 部门格式化
	function deptFormatter(value, row, index) {
		return value ? value.name : "";
	}
	// =================================

	// 初始化数据表格
	check_datagrid.datagrid({
		url : "/check_list.do",
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		toolbar : '#check_tb',
		columns : [ [ {
			field : 'id',
			title : '编号',
			width : 100
		}, {
			field : 'employee',
			title : '姓名',
			width : 100,
			formatter : empFormatter
		}, {
			field : 'employeeip',
			title : '签到IP',
			width : 100
		}, {
			field : 'signintime',
			title : '签到时间',
			width : 100,
			formatter : signintimeFormatter
		}, {
			field : 'signouttime',
			title : '签退时间',
			width : 100,
			formatter : signouttimeFormatter
		}, {
			field : 'state',
			title : '状态',
			width : 100,
			formatter : stateFormatter
		}, {
			field : 'checked',
			title : '补签人',
			width : 100,
			formatter : checkFormatter
		}, {
			field : 'checkedTime',
			title : '补签时间',
			width : 100,
		} ] ],
	});

	// d对话框
	check_dialog.dialog({

		width : 250,
		height : 280,
		closed : true,
		buttons : "#check_btns"
	});

	function empFormatter(value, row, index) {
		return value ? value.realname : "";
	}
	;

	function checkFormatter(value, row, index) {
		return value ? value.realname : "";
	}
	;
	function signintimeFormatter(value, row, index) {
		if (!value) {
			// 没有值就返回
			return;
		}
		// 将后台传递过来的时间打断并转成数组
		var timeArr = value.substring(11, 16).split(':');
		// 迟到:将时间变为红色
		if ((parseInt(timeArr[0]) == 8 && parseInt(timeArr[1]) > 30)
				|| parseInt(timeArr[0]) > 8) {
			return "<font color='red'>" + value + "</font>";
		} else {
			return value;
		}
	}
	;
	function signouttimeFormatter(value, row, index) {
		if (!value) {
			return;
		}
		var timeArr = value.substring(11, 16).split(':');
		if ((parseInt(timeArr[0]) == 17 && parseInt(timeArr[1]) < 30)
				|| parseInt(timeArr[0]) < 17) {
			return "<font color='red'>" + value + "</font>";
		} else {
			return value;
		}
	}

	function stateFormatter(value, row, index) {
		if (value == 0) {
			return "<font color='green'>正常</font>";
		} else if (value == 1) {
			return "<font color='red'>请假</font>";
		}
		return "<font color='blue'>补签</font>";
	}
	;

	var methodObj = {
		// 签到
		signIn : function() {
			$.post("/check_signIn.do", function(data) {
				if (data.success) {
					$.messager.alert('温馨提示', data.msg, 'info', function() {
						// 刷新数据表格(保持在当前页)
						check_datagrid.datagrid("reload");
					});
				} else {
					$.messager.alert('温馨提示', data.msg, 'info');
				}
			});
		},
		// 签退
		signOut : function() {
			$.post("/check_signOut.do", function(data) {
				if (data.success) {
					$.messager.alert('温馨提示', data.msg, 'info', function() {
						// 刷新数据表格(保持在当前页)
						check_datagrid.datagrid("reload");
					});
				} else {
					$.messager.alert('温馨提示', data.msg, 'info');
				}
			});
		},
		// 刷新
		reload : function() {
			check_datagrid.datagrid("reload");
		},

		// 取消保存
		cancel : function() {
			// 关闭窗口
			check_dialog.dialog("close");
		},

		// 补签
		checked : function() {
			check_dialog.dialog("center");
			check_dialog.dialog("open");
			// 清空表单
			check_dialog.form("clear");
			// 设置标题
			check_dialog.dialog("setTitle", "补签");

		},

		// 保存
		save : function() {
			// 提交表单
			check_form.form('submit', {
				url : "/check_checked.do",
				// onSubmit : function(param) {
				/*
				 * // 设置的签到时间 var signintime = $("[name='signintime']").val(); //
				 * 获取下拉框的值(要设置的员工的id) var id =
				 * $("#check_emp").combobox("getValue");
				 * 
				 * var rows = check_datagrid.datagrid("getRows"); for ( var i =
				 * 0; i < rows.length; i++) { if (rows[i]["employee"].id == id &&
				 * rows[i]["signintime"] == signintime) { console.log(id); } }
				 */
				// },
				success : function(data) {
					// 转成json对象
					data = $.parseJSON(data);
					if (data.success) {
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 关闭弹出框
							check_dialog.dialog("close");
							// 刷新数据表格(保持在当前页)
							check_datagrid.datagrid("reload");
						});
					} else {
						$.messager.alert('温馨提示', data.msg, 'info');
					}
				}
			});
		},

		// 导出文件 ,
		exportFile : function() {
			window.location.href = "/check_export.do";
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
