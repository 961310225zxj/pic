$(function(){
		/**
		 * 抽取需要共同元素
		 */
		var dictionaryDatagrid = $("#dictionary_datagrid");
		var dictionaryDialog = $("#dictionary_dialog");
		var dictionaryForm = $("#dictionaryForm");
		/**
		 * 初始化表格数据
		 */
		dictionaryDatagrid.datagrid({
			url:'/dictionary_list.do',
			fit : true,
			fitColumns : true,
			singleSelect : true,
			striped : true,
			rownumbers : true,
			toolbar : '#dictionary_tb',
			columns : [ [ {
				field : 'sn',
				title : '字典编号',
				width : 100,
				align : 'center'
			}, {
				field : 'name',
				title : '字典名称',
				width : 100,
				align : 'center'
			}, {
				field : 'intro',
				title : '字典简介',
				width : 100,
				align : 'center'
			} ] ],
			onClickRow : function(rowIndex, rowData){
				console.log(rowData);
				$("#dictionaryItem_datagrid").datagrid("load",{
					id : rowData.id
				});
			}

		});
		//初始化
		dictionaryDialog.dialog({
		    title: '新增',    
		    width: 300,    
		    height: 250,    
		    closed: true,    
		    modal: true ,
		    buttons:'#dictionary_bt'
		});
		/**
		 * 方法统一管理
		 */
		$("a[data-cmd]").on("click",function(){
			//获取方法
			var cmd = $(this).data("cmd");
			cmdObj[cmd]();
		});
		//绑定方法
		var cmdObj = {
			add : function(){
				//清楚数据
				dictionaryForm.form("clear");
				dictionaryDialog.dialog("open");
				dictionaryDialog.dialog("setTitle","新增");
			},
			edit : function(){
				var rowData = dictionaryDatagrid.datagrid("getSelected");
				if(rowData){
					//清楚数据
					dictionaryForm.form("clear");
					//回显数据
					dictionaryForm.form('load',rowData);
					dictionaryDialog.dialog("open");
					dictionaryDialog.dialog("setTitle","编辑");
				}else{
					$.messager.alert('温馨提示','请,选择一条你需要编辑的数据','warning');
				}
			},
			del: function(){
				var rowData = dictionaryDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm('温馨提示','您确认想要删除该数据吗？',function(r){    
					    if (r){    
					    	$.post("/dictionary_delete.do",{id:rowData.id},function(data){
					    		if(data.success){
					    			$.messager.alert('温馨提示',data.msg,'info',function(){
					    				//刷新
					    				dictionaryDatagrid.datagrid("load");
					    				$("#dictionaryItem_datagrid").datagrid("load");
					    			});
					    		}else{
					    			$.messager.alert('温馨提示',data.msg,'warning');
					    		}
					    	});
					    }    
					});  
				}else{
					$.messager.alert('温馨提示','请,选择一条你需要删除的数据','warning');
				}
			},
			reload : function(){
				//刷新
				dictionaryDatagrid.datagrid("load");
			},
			save : function(){
				var url = null;
				if($("input[name=id]").val()){
					url = '/dictionary_update.do';
				}else{
					url = '/dictionary_save.do';
				}
				dictionaryForm.form('submit', {    
				    url:url,      
				    success:function(data){    
				    	data = eval("("+data+")")
				        if(data.success){
				        	$.messager.alert('温馨提示',data.msg,'info',function(){
				        		dictionaryDialog.dialog("close");
				        		dictionaryDatagrid.datagrid("load");
				        	});
				        }else{
				        	$.messager.alert('温馨提示',data.msg,'warning');
				        }    
				    }    
				});  
			},
			cancel : function(){
				dictionaryDialog.dialog("close");
			}
				
		}

});