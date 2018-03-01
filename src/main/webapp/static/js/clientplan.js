$(function () {
    var clientplan_datagrid=$("#clientplan_datagrid");
    $("#clientplan_datagrid").datagrid({

        columns: [[
            {field: 'client', title: '潜在客户', width: 80,align: 'center',formatter : clientFormatter},
            {field: 'title', title: '开发主题', width: 80,align: 'center'},
            {field: 'plantime', title: '计划时间', width: 80,align: 'center'},
            {field: 'effect', title: '跟进效果', width: 80,align: 'center',formatter:effectFormatter},
            {field: 'detail', title: '计划内容', width: 80,align: 'center'},
            {field: 'remark', title: '备注', width: 80,align: 'center'},
            {field: 'inputtime', title: '创建时间', width: 80,align: 'center'},
            {field: 'employee', title: '创建人', width: 80,align: 'center',formatter : employeeFormatter}
        ]],
        striped: true, //是否显示斑马线效果
        fitColumns: true,
        pagination: true,//分页
        singleSelect: true,//只能选择了单行
        url: '/clientplan_list.do',
        toolbar: '#normal_bt'
    });


    //
    // 客户格式化
    function clientFormatter(value, row, index) {
        return value ? value.name : "";
    }
    // 员工格式化
    function employeeFormatter(value, row, index) {
        return value ? value.realname : "";
    }

    //跟进效果格式化
    function effectFormatter(value, row, index) {
        if(value==1){
            return '<span style="color: green">优</span>';
        }else if (value==2){
            return '<span style="color: mediumspringgreen">良</span>';
        }else if (value==3){
            return '<span style="color: #f1c85f">中</span>';
        }

            return '<span style="color: red">差</span>';


    }


    /*初始化会话框*/
    $('#clientplan_dialog').dialog({
        title: '编辑客户',
        width: 550,
        height: 300,
        closed: true,
        cache: false,
        href: '',
        // modal: true,
        buttons: '#normal_bttn'
    });
    /*初始化会话框数据表*/




    // 使用对象来统一管理方法
    var methodObj = {
        //取消
        cancel:function () {
            $("#clientplan_dialog").dialog("close");
        },
        //保存
       add :function () {
            //清空数据
            $("#clientplan_form").form("clear");
            //打开表单
          $("#clientplan_dialog").dialog("open");
            //设置对话框的标题
            $("#clientplan_dialog").dialog("setTitle","新增客户");
        },

        //编辑
       edit:function () {
            // 判断是否选中数据
            var row = $("#clientplan_datagrid").datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', '请选中一条数据!', 'info');
                return;
            }
            // 清空表单
            $("#clientplan_form").form("clear");

            row["client.id"]=row["client"].id;//回显数据同名匹配原则
            // 回显数据
            $("#clientplan_dialog").form("load", row);
            // 打开弹出框
           $("#clientplan_dialog").dialog("open");

            // 设置标题
            $("#clientplan_dialog").dialog("setTitle", "编辑客户");
        },

        // 保存
        save : function() {
            // 判断是否有id

            var url;
            if ($("[name='id']").val()) {

                url = "/clientplan_update.do";
            } else {
                url = "/clientplan_save.do";
                console.log("0");
            }

            // 提交表单
            $("#clientplan_form").form('submit', {
                url : url,
                success : function(data) {
                    // 转成json对象
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert('温馨提示', data.msg, 'info', function() {
                            // 关闭弹出框
                            $('#clientplan_dialog').dialog("close");
                            // 刷新数据表格(保持在当前页)
                            $("#clientplan_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert('温馨提示', data.msg, 'info');
                    }
                }
            });
        },

        //接触关系
        del:function(){
            // 判断是否选中数据
            var row = $("#clientplan_datagrid").datagrid("getSelected");
            if (!row) {
                $.messager.alert('温馨提示', '请选中一条数据!', 'info');
                return;
            }
            $.messager.confirm('确认对话框', '您想要删除该数据吗？', function () {

            //删除被选中的行deleteRow(只是在页面中删除,数据库中还存在,发送请求从数据库中删除)
            //$("#normalclientplan_datagrid").datagrid("deleteRow",row.id-1);
            //从数据库中删除数据
            //发送ajax请求去删除数据库中的数据
            $.post('/clientplan_delete.do',{
                id:row["id"]},
                function(data){
                    if (data.success) {
                        $.messager.alert('温馨提示', data.msg, 'info', function() {
                            // 关闭弹出框
                            $('#clientplan_dialog').dialog("close");
                            // 刷新数据表格(保持在当前页)
                            $("#clientplan_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert('温馨提示', data.msg, 'info');
                    }
            });
            //重新加载页面
            $("#clientplan_datagrid").datagrid("reload");
            });
        },


        // 高级查询
        searchForm : function() {
            // 获取关键字文本框的值
            var keyword = $("[name='keyword']").val();
            var beginDate = $("[name='beginDate']").val();
            var endDate = $("[name='endDate']").val();
            $("#clientplan_datagrid").datagrid('load', {
                keyword : keyword,
                beginDate : beginDate,
                endDate : endDate
            });
        },

        // 查询全部数据(刷新)
        reload : function() {
            // 清空查询条件的内容
            $("#keyword").textbox('setValue',null);
            $("#beginDate").combo("clear");
            $("#endDate").combo("clear");
            clientplan_datagrid.datagrid('load', {});
        }
    }

    // 统一绑定事件
    $("a[data-cmd]").on("click", function() {
        // 获取该链接需要执行的方法名字
        var methodName = $(this).data("cmd");
        // 掉用方法
        methodObj[methodName]();
    });

});




