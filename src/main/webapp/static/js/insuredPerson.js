$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var insuredPersonDatagrid,insuredPersonDialog,insuredPersonForm;
	insuredPersonDatagrid = $("#insuredPerson_datagrid");
	insuredPersonDialog = $("#insuredPerson_dialog");
	insuredPersonForm = $("#insuredPerson_form");
	/*
	 * 初始化数据表格 
	 */
	insuredPersonDatagrid.datagrid({
		url:"/insuredPerson_list.do",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#insuredPerson_datagrid_tb',
		columns:[[
			{field:'name',title:'客户名称',width:100,align:'center'},
			{field:'gender',title:'性别',width:100,align:'center'},
			{field:'age',title:'年龄',width:100,align:'center'},
			{field:'is_insured',title:'是否投保',width:100,align:'center',formatter:is_insuredformatter},
			{field:'level',title:'风险等级',width:100,align:'center'},
			{field:'is_personal',title:'是否投保人',width:100,align:'center',formatter:is_personalformatter},
			{field:'profession',title:'职业',width:200,align:'center'},
			{field:'phone',title:'联系电话',width:200,align:'center'},
			{field:'numberType',title:'证件类型',width:100,align:'center'},
			{field:'email',title:'邮箱',width:200,align:'center'},
			{field:'number',title:'身份证号码',width:400,align:'center'}
		]]
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	insuredPersonDialog.dialog({
		width:320,
		height:460,
		closed:true,
		buttons:'#insuredPerson_dialog_bt'
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
				insuredPersonForm.form("clear");
				insuredPersonDialog.dialog("setTitle","新增");
				insuredPersonDialog.dialog("open");
			},
			edit:function(){
				var rowData = insuredPersonDatagrid.datagrid("getSelected");
				if(rowData){
					insuredPersonForm.form("clear");
					insuredPersonDialog.dialog("setTitle","编辑");
					insuredPersonDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					insuredPersonForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = insuredPersonDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.post("/insuredPerson_delete.do",{insuredPersonId:rowData.id},function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										insuredPersonDatagrid.datagrid("reload");
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
				insuredPersonDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/insuredPerson_update.do"
				}else{
					url = "/insuredPerson_save.do";
				}
				insuredPersonForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								insuredPersonDialog.dialog("close");
								insuredPersonDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				insuredPersonDialog.dialog("close");
			}
	}
});
function is_insuredformatter(value, row, index) {
	return row.is_insured == 1 ? "是" : "否";
}
function is_personalformatter(value, row, index) {
	return row.is_personal == 1 ? "是" : "否";
}