<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/static/common/common.jsp" %>
<style>
.alt td {
	background: black !important;
}
</style>
<script type="text/javascript">
$(function() {
	var easyui_datagrid = $("#easyui_datagrid");
	var chartBar = $("#chartBar");
	var chartLine = $("#chartLine");
	easyui_datagrid.datagrid({
		title : "潜在客户报表",
		url : '/potentialChart_list.do',
		fit : true,
		fitColumns : true,
		toolbar : "#tb",
		pagination : true,
		singleSelect : true,
		columns : [ [ {
			field : 'id',
			title : '编号',
			width : 100
		},  {
			field : 'realname',
			title : '员工姓名',
			width : 100
		},{
			field : 'creatTime',
			title : '创建时间',
			width : 100
		}, 
		{
			field : 'count',
			title : '潜在客户新增数量',
			width : 100
		} ] ]
	});

	//方法统一管理
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd](); 
		}
	});
	var cmdObj = {
			//查询
			searchChart:function () {
				var keyword = $("input[name=keyword]").val();
				var beginDate = $('#beginDate').datebox('getValue');
				var endDate = $('#endDate').datebox('getValue');
				$('#easyui_datagrid').datagrid('load', {
					keyword : keyword,
					beginDate : beginDate,
					endDate : endDate
				});
			},
	//刷新
	reloadChart:function () {
		$("[name=keyword]").val("");
		$('#beginDate').datebox('clear');
		$('#endDate').datebox('clear');
		easyui_datagrid.datagrid('load',{});
	},
	//柱状图
	 makeBar:function () {
		$.post("/chartForBar.do", {state : "potential"}, function(data) {
			chartBar.dialog({
				title : '潜在新增客户报表',
				modal : true,
				closable: false,
				fit : true,
				content : data,
				toolbar:'#client_toolline'
			});
		})
	}, 
	//折线图
	 makeLine:function () {
		  $.post("/chartForLine.do", {state: "potential"}, function (data) {
			  chartLine.dialog({
	              title: '潜在新增客户报表',
	              modal: true,
	              fit: true,
	              closable: false,
	              content: data,
	              toolbar:'#client_toolbar'
	          });
	      })
		}, 
	createChartBar:function(){
		$.post("/chartForBar.do", {state : "potential"}, function(data) {
			chartBar.dialog({
				title : '潜在新增客户报表',
				modal : true,
				closable: false,
				fit : true,
				content : data,
				toolbar:'#client_toolline'
			});
		})
	},	
	createChartLine:function(){
		 $.post("/chartForLine.do", {state: "potential"}, function (data) {
			  chartLine.dialog({
	              title: '潜在新增客户报表',
	              modal: true,
	              fit: true,
	              closable: false,
	              content: data,
	              toolbar:'#client_toolbar'
	          });
	      })
		
	},	
	createChart1:function(){
		window.location.href="/potentialChart.do";
		
	},	
	//导出
		potenitialExcel:function(){
		window.location.href = "";
	}		
	}
});

</script>
</head>

<body>
	<!-- 列表 -->
	<table id="easyui_datagrid"></table>
	<!-- 按钮 -->
	<div id="tb">
		名称关键字查询: <input type="text" name="keyword" placeholder="请输入关键字">
		时间段查询: <input id="beginDate" type="text" name="beginDate" class="easyui-datebox" />
		 <input id="endDate" type="text" name="endDate" class="easyui-datebox" />
		 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="searchChart">查询</a> 
		 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reloadChart">刷新</a>
		 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true" data-cmd="makeBar">生成柱状图</a>
		 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true" data-cmd="makeLine">生成折线图</a>
		  <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true" data-cmd="potenitialExcel">导出Excel</a>
	</div>
	<!-- 柱状图 -->
	<div id="chartBar"></div>
	<!-- 折线图 -->
	<div id="chartLine"></div>
	<div id="client_toolbar">
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-tip',"  data-cmd="createChartBar" >切换为柱状图</a>
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-tip',"  data-cmd="createChart1" >返回图表</a>
	</div>	
	<div id="client_toolline">
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-tip',"  data-cmd="createChartLine" >切换为折线图</a>
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-tip',"  data-cmd="createChart1" >返回图表</a>
	</div>	
</body>
</html>
