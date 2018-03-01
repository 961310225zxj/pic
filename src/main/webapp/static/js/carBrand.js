$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var carBrandDatagrid,carBrandDialog,carBrandForm;
	carBrandDatagrid = $("#carBrand_datagrid");
	carBrandDialog = $("#carBrand_dialog");
	carBrandForm = $("#carBrand_form");
	/*
	 * 初始化数据表格 
	 */
	carBrandDatagrid.datagrid({
		url:"/carBrand_list.do",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#carBrand_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	carBrandDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#carBrand_dialog_bt'
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
				carBrandForm.form("clear");
				carBrandDialog.dialog("setTitle","新增");
				carBrandDialog.dialog("open");
			},
			edit:function(){
				var rowData = carBrandDatagrid.datagrid("getSelected");
				if(rowData){
					carBrandForm.form("clear");
					carBrandDialog.dialog("setTitle","编辑");
					carBrandDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					carBrandForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = carBrandDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.post("/carBrand_delete.do",{carBrandId:rowData.id},function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										carBrandDatagrid.datagrid("reload");
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
				carBrandDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/carBrand_update.do"
				}else{
					url = "/carBrand_save.do";
				}
				carBrandForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								carBrandDialog.dialog("close");
								carBrandDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				carBrandDialog.dialog("close");
			}
	}
});
