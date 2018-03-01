$(function(){
	/**
	 * 抽取需要共同元素
	 */
	var dictionaryItemDatagrid = $("#dictionaryItem_datagrid");
	var dictionaryItemDialog = $("#dictionaryItem_dialog");
	var dictionaryItemForm = $("#dictionaryItemForm");
	/**
	 * 初始化数据表格
	 */
	dictionaryItemDatagrid.datagrid({
		url:'/dictionaryItem_list.do',
		fit:true,
		fitColumns:true,
		singleSelect:true,
		striped : true,
		rownumbers : true,
		toolbar : '#dictionaryItem_tb',
		columns : [ [ {
			field : 'id',
			title : '字典明细编号',
			width : 100,
			align : 'center'
		}, {
			field : 'name',
			title : '字典明细名称',
			width : 100,
			align : 'center'
		}, {
			field : 'intro',
			title : '字典明细简介',
			width : 100,
			align : 'center'
		} ,{
			field : 'parent',
			title : '字典目录',
			width : 100,
			align : 'center',
			formatter : parentFormatter
		}
		] ]
	});
	//格式化
	function parentFormatter(value,row,index){
		return value ? value.name : null;
	};
	/**
	 * 初始化对话框表格
	 */
	dictionaryItemDialog.dialog({
		 title: '新增',    
		    width: 320,    
		    height: 250,    
		    closed: true,    
		    modal: true ,
		    buttons:'#dictionaryItem_bt'
	});
	/**
	 * 方法统一管理
	 */
	$("a[data-item]").on("click",function(){
		//获取方法
		var item = $(this).data("item");
		cmdObjItem[item]();
	});
	//绑定方法
	var cmdObjItem = {
		addItem : function(){
			//清楚数据
			dictionaryItemForm.form("clear");
			//显示目录
			var rowData = $("#dictionary_datagrid").datagrid("getSelected");
			
			if(rowData){
				$("#parentName").val(rowData.name);
				dictionaryItemDialog.dialog("open");
				dictionaryItemDialog.dialog("setTitle","新增");
			}else{
				$.messager.alert('温馨提示','请选择需要新增在哪个字典目录下','warning');
			}
		},
		editItem : function(){
			var rowData = dictionaryItemDatagrid.datagrid("getSelected");
			if(rowData){
				console.log(rowData);
				//清楚数据
				dictionaryItemForm.form("clear");
				if(rowData.parent){
					rowData['parent.name'] = rowData['parent'].name;
				}
				//回显数据
				dictionaryItemForm.form('load',rowData);
				dictionaryItemDialog.dialog("open");
				dictionaryItemDialog.dialog("setTitle","编辑");
			}else{
				$.messager.alert('温馨提示','请,选择一条你需要编辑的数据','warning');
			}
		},
		delItem : function(){
			var rowData = dictionaryItemDatagrid.datagrid("getSelected");
			if(rowData){
				$.messager.confirm('温馨提示','您确认想要禁用该数据吗？',function(r){    
				    if (r){    
				    	$.post("/dictionaryItem_delete.do",{id:rowData.id},function(data){
				    		if(data.success){
				    			$.messager.alert('温馨提示',data.msg,'info',function(){
				    				//刷新
				    				dictionaryItemDatagrid.datagrid("load");
				    			});
				    		}else{
				    			$.messager.alert('温馨提示',data.msg,'warning');
				    		}
				    	});
				    }    
				});  
			}else{
				$.messager.alert('温馨提示','请,选择一条你需要禁用的数据','warning');
			}
		},
		reloadItem : function(){
			//刷新
			dictionaryItemDatagrid.datagrid("load");
		},
		saveItem : function(){
			var url;
			if($("#hiddenId").val()){
				url = '/dictionaryItem_update.do';
			}else{
				url = '/dictionaryItem_save.do';
			}
			dictionaryItemForm.form('submit', {    
			    url:url,      
			    success:function(data){    
			    	data = eval("("+data+")")
			        if(data.success){
			        	$.messager.alert('温馨提示',data.msg,'info',function(){
			        		dictionaryItemDialog.dialog("close");
			        		dictionaryItemDatagrid.datagrid("load");
			        	});
			        }else{
			        	$.messager.alert('温馨提示',data.msg,'warning',function(){
			        		
			        		dictionaryItemDialog.dialog("close");
			        	});
			        }    
			    }    
			});  
		},
		cancelItem : function(){
			dictionaryItemDialog.dialog("close");
		}
			
	}

});