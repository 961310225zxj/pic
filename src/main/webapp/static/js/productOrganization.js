$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var productOrganizationDatagrid,productOrganizationDialog,productOrganizationForm;
	productOrganizationDatagrid = $("#productOrganization_datagrid");
	productOrganizationDialog = $("#productOrganization_dialog");
	productOrganizationForm = $("#productOrganization_form");
	/*
	 * 初始化数据表格 
	 */
	productOrganizationDatagrid.datagrid({
		url:"/productOrganization_list.do",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#productOrganization_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	productOrganizationDialog.dialog({
		width:300,
		height:220,
		closed:true,
		buttons:'#productOrganization_dialog_bt'
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
				productOrganizationForm.form("clear");
				productOrganizationDialog.dialog("setTitle","新增");
				productOrganizationDialog.dialog("open");
			},
			edit:function(){
				var rowData = productOrganizationDatagrid.datagrid("getSelected");
				if(rowData){
					productOrganizationForm.form("clear");
					productOrganizationDialog.dialog("setTitle","编辑");
					productOrganizationDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					productOrganizationForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = productOrganizationDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.post("/productOrganization_delete.do",{productOrganizationId:rowData.id},function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										productOrganizationDatagrid.datagrid("reload");
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
				productOrganizationDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/productOrganization_update.do"
				}else{
					url = "/productOrganization_save.do";
				}
				productOrganizationForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								productOrganizationDialog.dialog("close");
								productOrganizationDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				productOrganizationDialog.dialog("close");
			}
	}
});
