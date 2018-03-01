$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var recognizeeDatagrid,recognizeeDialog,recognizeeForm;
	recognizeeDatagrid = $("#recognizee_datagrid");
	recognizeeDialog = $("#recognizee_dialog");
	recognizeeForm = $("#recognizee_form");
	/*
	 * 初始化数据表格 
	 */
	recognizeeDatagrid.datagrid({
		url:"/recognizee_list.do",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#recognizee_datagrid_tb',
		columns:[[
			{field:'name',title:'客户名称',width:100,align:'center'},
			{field:'phoneNumber',title:'联系电话',width:200,align:'center'},
			{field:'numberType',title:'证件类型',width:100,align:'center'},
			{field:'number',title:'身份证号码',width:400,align:'center'},
			{field:'is_personal',title:'是否投保人',width:100,align:'center'},
			{field:'level',title:'风险等级',width:100,align:'center'},
			{field:'address',title:'通讯地址',width:400,align:'center'},
		]]

	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	recognizeeDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#recognizee_dialog_bt'
	});
	/*
	 * 对页面按钮进行统一监听
	 */
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});
	/*
	 * 所有的操作封装到cmdObj对象中,方便管理
	 */
	var cmdObj = {
			 add:function(){
				recognizeeForm.form("clear");
				recognizeeDialog.dialog("setTitle","新增");
				recognizeeDialog.dialog("open");
			},
			edit:function(){
				var rowData = recognizeeDatagrid.datagrid("getSelected");
				if(rowData){
					recognizeeForm.form("clear");
					recognizeeDialog.dialog("setTitle","编辑");
					recognizeeDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					recognizeeForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = recognizeeDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.post("/recognizee_delete.do",{recognizeeId:rowData.id},function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										recognizeeDatagrid.datagrid("reload");
									});
								}else{
									$.messager.alert("温馨提示",data.msg,"error");
								}
							})
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要删除的数据!","warining");
				}
			},
			reload:function(){
				recognizeeDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/recognizee_update.do"
				}else{
					url = "/recognizee_save.do";
				}
				recognizeeForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								recognizeeDialog.dialog("close");
								recognizeeDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				recognizeeDialog.dialog("close");
			}
	}
});
