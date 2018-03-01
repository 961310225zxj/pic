$(function(){
	/**
	 * 抽取所有需要的元素
	 */
	var lucene_datagrid = $("#lucene_datagrid");  
	//===================================
	/**
	 * 初始化数据表格
	 */
	lucene_datagrid.datagrid({
	 url: "/lucene_list.do",
        fit: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        pagination: true,
        fitColumns: true,
        toolbar: '#lucene_datagrid_tb'
	});
});
//搜索方法
function searchCcontent(){
	var content = $("input[name='content']").val();
	$("#lucene_datagrid").datagrid("load",{
		content : content
	});
}