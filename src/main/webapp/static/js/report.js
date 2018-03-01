$(function () {
    //数据列表
    $("#policy_datagrid").datagrid({
        url : "/checkOkPolicy_list.do?checkstatus=3",
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
            title : '投保人',
            width : 100,
            formatter:recognizeeFormatter
        }, {
            field : 'insuredPerson',
            title : '被保人',
            width : 100,
            formatter:insuredPersonFormatter
        }, {
            field : 'products',
            title : '车保产品',
            width : 100,
            formatter:productsFormatter

        }, {
            field : 'employee',
            title : '提交人',
            width : 100,
            formatter:inputPersonFormatter

        }, {
            field : 'inputtime',
            title : '提交日期',
            width : 100
        }, {
            field : 'suggestion',
            title : '上报原因',
            width : 100,
        }  ] ]
    });

    function insuredPersonFormatter(value, row, index) {
        return value?value.name:"";
    }
    function recognizeeFormatter(value, row, index) {
        return value?value.name:"";
    }
    function carInformationFormatter(value, row, index) {
        return value?value.cartypeinformation:"";
    }
    function productsFormatter(value, row, index) {
        return row.product?row.product.name:"";
    }
    function inputPersonFormatter(value, row, index) {
        return value?value.username:"";
    }

    //方法
    var methodObj = {
        search: function() {
            // 获取关键字文本框的值
            var recognizee = $("[name='recognizee']").val();
            var insuredPerson = $("[name='insuredPerson']").val();
            var checkId = $("[name='checkId']").val();
            var product = $("[name='product']").val();
            var beginTime = $("[name='beginTime']").val();
            var endTime = $("[name='endTime']").val();
            $("#policy_datagrid").datagrid('load', {
                recognizee:recognizee,insuredPerson:insuredPerson,
                checkId:checkId,product:product,beginTime:beginTime,endTime:endTime
            });
        },reset:function () {
            $("#editForm").form("clear");
        },reload:function () {
            $("#editForm").form("clear");
            window.location.reload();
        },cancel:function () {
            $("#policy_dialog").dialog("close");
        },save:function () {
            var policyId=$("#policyId").val();
            var auditAdvice=$("#auditAdvice").val();
            var msg=$("#msg").val();
            $.post("/policy_check.do", {
                id :policyId,auditAdvice:auditAdvice,msg:msg
            }, function(data) {
                $.messager.alert('温馨提示', data.msg, 'info', function() {
                    $("#auditAdviceForm").form("clear");
                    $("#policy_dialog").dialog("close");
                    $("#policy_datagrid").datagrid("reload");
                });
            })


        },check:function () {
            var rowData= $("#policy_datagrid").datagrid("getSelected");
            if(!rowData){
                $.messager.alert("温馨提示","请选择一条数据查看!");
                return;
            }
            $("#policy_dialog").dialog("open");
            if(rowData.recognizee) {
                rowData["recognizee.id"] = rowData.recognizee.id;
                rowData["recognizee.name"] = rowData.recognizee.name;
                rowData["recognizee.numberType"] = rowData.recognizee.numberType;
                rowData["recognizee.phoneNumber"] = rowData.recognizee.phoneNumber;
                rowData["recognizee.number"] = rowData.recognizee.number;
                rowData["recognizee.level"] = rowData.recognizee.level;
                rowData["recognizee.address"] = rowData.recognizee.address;
            }
            $("#recognizeeForm").form("load",rowData);
            if(rowData.product){
                rowData["product.name"] = rowData.product.name;
                rowData["product.salePrice"] = rowData.product.salePrice;
                rowData["product.safetyDate"] = rowData.product.safetyDate;
                rowData["product.compensation"] = rowData.product.compensation;
            }
            $("#policyForm").form("load",rowData);
            if(rowData.insuredPerson) {
                console.log(rowData.insuredPerson)
                rowData["insuredPerson.name"] = rowData.insuredPerson.name;
                rowData["insuredPerson.id"] = rowData.insuredPerson.id;
                rowData["insuredPerson.numberType"] = rowData.insuredPerson.numberType;
                rowData["insuredPerson.phone"] = rowData.insuredPerson.phone;
                rowData["insuredPerson.number"] = rowData.insuredPerson.number;
                rowData["insuredPerson.level"] = rowData.insuredPerson.level;
                rowData["insuredPerson.address"] = rowData.insuredPerson.address;
            }
            $("#insuredPersonForm").form("load",rowData);
            if(rowData.carInformation) {
                console.log(rowData.carInformation);
                rowData["carInformation.id"] = rowData.carInformation.id;
                rowData["carInformation.cartypeinformation"] = rowData.carInformation.cartypeinformation;
                rowData["carInformation.carIdType"] = rowData.carInformation.carIdType;
                rowData["carInformation.carId"] = rowData.carInformation.carId;
                if(rowData.carInformation.is_foreignCar==1){
                    rowData["carInformation.is_foreignCar"]="是";
                }else{
                    rowData["carInformation.is_foreignCar"]="否";
                }
                if(rowData.carInformation.is_transfer==1){
                    rowData["carInformation.is_transfer"]="是";
                }else{
                    rowData["carInformation.is_transfer"]="否";
                }
                if(rowData.carInformation.is_newCar==1){
                    rowData["carInformation.is_newCar"]="是";
                }else{
                    rowData["carInformation.is_newCar"]="否";
                }
            }
            $("#carInformationForm").form("load",rowData);

            $("#policy_dialog").dialog("setTitle","保单编号:"+rowData.id);
        },receive:function () {
            var rowData= $("#policy_datagrid").datagrid("getSelected");
            if(!rowData){
                $.messager.alert("温馨提示","请选择一条数据..");
                return;
            }
            if(rowData.checkstatus!=0){
                $.messager.alert("温馨提示","这条数据已接收..");
                return;
            }else {
                $.post("/policy_receive.do", {
                    id : rowData.id
                }, function(data) {
                    $.messager.alert('温馨提示', data.msg, 'info', function() {
                        // 刷新数据表格(保持在当前页)
                        $("#policy_datagrid").datagrid("reload");
                    });
                })
            }

        },back:function () {
            var rowData= $("#policy_datagrid").datagrid("getSelected");
            if(!rowData){
                $.messager.alert("温馨提示","请选择一条数据..");
                return;
            }
        }
    }

    //启用方法
    $("a[data-cmd]").on("click", function() {
        var methodName = $(this).data("cmd");
        methodObj[methodName]();
    })

    //审核界面
    $("#policy_dialog").dialog({
        width : 1000,
        height : 350,
        buttons : '#policy_btns',
        closed : true
    })


})



