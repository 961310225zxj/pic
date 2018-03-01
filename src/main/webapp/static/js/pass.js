$(function () {
    //数据列表
    $("#policy_datagrid").datagrid({
        url : "/policy_list.do",
        fitColumns : true,
        striped : true,
        fit : true,
        pagination : true,
        singleSelect : true,
        toolbar : '#policy_tb',
        columns : [ [ {
            field : 'id',
            title : '编号',
            width : 100
        }, {
            field : 'recognizee',
            title : '被保人',
            width : 100
        }, {
            field : 'insuredperson',
            title : '投保人',
            width : 100
        }, {
            field : 'carperson',
            title : '车主',
            width : 100
        }, {
            field : 'carinformation',
            title : '车辆信息',
            width : 100
        }, {
            field : 'product',
            title : '车保产品',
            width : 100,

        } ] ],onDblClickRow : function(rowIndex, rowData) {
            if(rowData){
                $("#policy_form").form("clear");
                $("#policy_dialog").dialog("open");
                $("#policy_dialog").dialog("setTitle","详情界面");
            }
        }
    });

    //方法
    var methodObj = {
        searchForm:function () {
            alert("查询中...")
        },reload:function () {
            
        }
    }

   //启用方法
    $("a[data-cmd]").on("click", function() {
        var methodName = $(this).data("cmd");
        methodObj[methodName]();
    })

    //详情界面
    $("#policy_dialog").dialog({
        width : 1000,
        height : 600,
        closed : true
    })


})