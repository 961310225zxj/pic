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

</head>

<body>
	<!-- 列表 -->
	<table id="cat_datagrid"></table>
	<!-- 按钮 -->
	<div id="tb">
		名称关键字查询: <input type="text" name="keyword" placeholder="请输入车险名称">
		时间段查询: <input id="beginDate" type="text" name="beginDate" class="easyui-datebox" />
		 <input id="endDate" type="text" name="endDate" class="easyui-datebox" />
		 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="searchChart">查询</a> 
		 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reloadChart">刷新</a>
		 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true" data-cmd="creatChartPie">生成饼状图</a>
		 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true" data-cmd="carExcel">导出Excel</a>
	</div>
	<!-- 饼状图 -->
	<div id="chartPie"></div>
	<div id="chartFunnel"></div>
	
	<div id="funnel_toolbar">
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-tip',"  data-cmd="creatChartFunnel" >切换成漏斗图</a>
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-tip',"  data-cmd="createChart1" >返回图表</a>
	</div>	
	<div id="pie_toolbar">
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-tip',"  data-cmd="creatChartPie" >切换成饼状图</a>
	    <a  class="easyui-linkbutton" data-options="iconCls:'icon-tip',"  data-cmd="createChart1" >返回图表</a>
	</div>	
</body>
<script type="text/javascript">
$(function() {
	var catDatagrid = $("#cat_datagrid");
	var chartPie = $("#chartPie");
	var chartFunnel = $("#chartFunnel");
	catDatagrid.datagrid({
		title : "车险饼图报表",
		url : '/carInsuranceChart_list.do',
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
			field : 'productName',
			title : '车险名称',
			width : 100
		},{
			field : 'creatTime',
			title : '创建时间',
			width : 100
		}, 
		{
			field : 'count',
			title : '出险份数',
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
		catDatagrid.datagrid('load', {
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
	//打开弹出层
	creatChartPie:function () {
		$.post("/chartForPie.do", function(data) {
			chartPie.dialog({
				title:'车险售出报表',
				modal : true,
				fit : true,
				closable: false,
				content : data,
				toolbar:'#funnel_toolbar'
			});
		})
	},
	//切换漏斗	
	creatChartFunnel:function(){
		$.post("/chartByFunnel.do", function(data) {
			chartFunnel.dialog({
				title:'车险售出报表',
				modal : true,
				fit : true,
				closable: false,
				content : data,
				toolbar:'#pie_toolbar'
			});
		})
	},	
	//切换饼状图
	createChart1:function(){
		window.location.href="/carInsuranceChart.do";
	},	
	//导出
		carExcel:function(){
		window.location.href = "";
	}	
}
});

</script>
</html>
