$(function () {
    //数据列表
    $("#policy_datagrid").datagrid({
        url: "/snapPolicy_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        toolbar: '#policy_tb',
        columns: [[{
            field: 'id',
            title: '编号',
            width: 100
        }, {
            field: 'recognizee',
            title: '投保人',
            width: 100,
            formatter: recognizeeFormatter
        }, {
            field: 'insuredPerson',
            title: '被保人',
            width: 100,
            formatter: insuredPersonFormatter
        }, {
            field: 'products',
            title: '车保产品',
            width: 100,
            formatter: productsFormatter

        }, {
            field: 'employee',
            title: '提交人',
            width: 100,
            formatter: inputPersonFormatter

        }, {
            field: 'inputtime',
            title: '提交日期',
            width: 100
        }, {
            field: 'moneystatus',
            title: '缴费状态',
            width: 100,
            formatter: moneystatusFormatter

        }, {
            field: 'checkstatus',
            title: '审核状态',
            width: 100,
            formatter: checkstatusFormatter

        }]]
    });

    function insuredPersonFormatter(value, row, index) {
        return value ? value.name : "";
    }

    function recognizeeFormatter(value, row, index) {
        return value ? value.name : "";
    }

    function carInformationFormatter(value, row, index) {
        return value ? value.cartypeinformation : "";
    }

    function productsFormatter(value, row, index) {
        return row.product ? row.product.name : "";
    }

    function inputPersonFormatter(value, row, index) {
        return value ? value.username : "";
    }

    function moneystatusFormatter(value, row, index) {
        return value == 0 ? "<font color='red'>未缴费</font>" : "<font color='green'>已缴费</font>";
    }

    function checkstatusFormatter(value, row, index) {
        return value == 0 ? "<font color='red'>未审核</font>" : "<font color='green'>已审核</font>";
    }

    //方法
    var methodObj = {
        search: function () {
            // 获取关键字文本框的值
            var recognizee = $("[name='recognizee']").val();
            var insuredPerson = $("[name='insuredPerson']").val();
            var checkId = $("[name='checkId']").val();
            var product = $("[name='product']").val();
            var beginTime = $("[name='beginTime']").val();
            var endTime = $("[name='endTime']").val();
            $("#policy_datagrid").datagrid('load', {
                recognizee: recognizee, insuredPerson: insuredPerson,
                checkId: checkId, product: product, beginTime: beginTime, endTime: endTime
            });
        }, reset: function () {
            $("#editForm").form("clear");
        }, reload: function () {
            $("#editForm").form("clear");
            window.location.reload();
        }, cancel: function () {
            $("#policy_dialog").dialog("close");
        }, save: function () {
            alert("保存中...")
        }, del: function () {
            var rowData = $("#policy_datagrid").datagrid("getSelected");
            if (!rowData) {
                $.messager.alert("温馨提示", "请选择一条数据!");
                return;
            }
            var policyId = rowData.id;
            $.messager.confirm("确认提示", "确认进行删除操作吗?", function (r) {
                if (r) {
                    $.post("/policy_delete.do", {
                        policyId: policyId
                    }, function (data) {
                        $.messager.alert('温馨提示', data.msg, 'info', function () {
                            $("#policy_datagrid").datagrid("reload");
                        });
                    })
                }
            })
        }, edit: function () {
            var rowData = $("#policy_datagrid").datagrid("getSelected");
            if (!rowData) {
                $.messager.alert("温馨提示", "请选择一条数据!");
                return;
            }
            var id = rowData.id;
            window.location.href = "/policy_update.do?id=" + id;
        }, check: function () {
            var rowData = $("#policy_datagrid").datagrid("getSelected");
            if (rowData.checkstatus != 1) {
                $.messager.alert("温馨提示", "请接收保单后再进行审核!");
                return;
            }
            $("#policy_dialog").dialog("open");
            if (rowData.recognizee) {
                rowData["recognizee.id"] = rowData.recognizee.id;
                rowData["recognizee.name"] = rowData.recognizee.name;
                rowData["recognizee.numberType"] = rowData.recognizee.numberType;
                rowData["recognizee.phoneNumber"] = rowData.recognizee.phoneNumber;
                rowData["recognizee.number"] = rowData.recognizee.number;
                rowData["recognizee.level"] = rowData.recognizee.level;
                rowData["recognizee.address"] = rowData.recognizee.address;
            }
            $("#recognizeeForm").form("load", rowData);
            if (rowData.product) {
                rowData["product.name"] = rowData.product.name;
                rowData["product.salePrice"] = rowData.product.salePrice;
                rowData["product.safetyDate"] = rowData.product.safetyDate;
                rowData["product.compensation"] = rowData.product.compensation;
            }
            $("#policyForm").form("load", rowData);
            if (rowData.insuredPerson) {
                console.log(rowData.insuredPerson)
                rowData["insuredPerson.name"] = rowData.insuredPerson.name;
                rowData["insuredPerson.id"] = rowData.insuredPerson.id;
                rowData["insuredPerson.numberType"] = rowData.insuredPerson.numberType;
                rowData["insuredPerson.phone"] = rowData.insuredPerson.phone;
                rowData["insuredPerson.number"] = rowData.insuredPerson.number;
                rowData["insuredPerson.level"] = rowData.insuredPerson.level;
                rowData["insuredPerson.address"] = rowData.insuredPerson.address;
            }
            $("#insuredPersonForm").form("load", rowData);
            if (rowData.carInformation) {
                console.log(rowData.carInformation);
                rowData["carInformation.id"] = rowData.carInformation.id;
                rowData["carInformation.cartypeinformation"] = rowData.carInformation.cartypeinformation;
                rowData["carInformation.carIdType"] = rowData.carInformation.carIdType;
                rowData["carInformation.carId"] = rowData.carInformation.carId;
                rowData["carInformation.is_newCar"] = rowData.carInformation.is_newCar;
                rowData["carInformation.is_foreignCar"] = rowData.carInformation.is_foreignCar;
                rowData["carInformation.is_transfer"] = rowData.carInformation.is_transfer;
            }
            $("#carInformationForm").form("load", rowData);

            $("#policy_dialog").dialog("setTitle", "审核界面");
        }, receive: function () {
            var rowData = $("#policy_datagrid").datagrid("getSelected");
            if (!rowData) {
                $.messager.alert("温馨提示", "请选择一条数据..");
                return;
            }
            if (rowData.checkstatus != 0) {
                $.messager.alert("温馨提示", "这条数据已接收..");
                return;
            } else {
                $.post("/policy_receive.do", {
                    id: rowData.id
                }, function (data) {
                    $.messager.alert('温馨提示', data.msg, 'info', function () {
                        // 刷新数据表格(保持在当前页)
                        $("#policy_datagrid").datagrid("reload");
                    });
                })
            }

        }, back: function () {
            var rowData = $("#policy_datagrid").datagrid("getSelected");
            if (!rowData) {
                $.messager.alert("温馨提示", "请选择一条数据..");
                return;
            }
        }
    }

    //启用方法
    $("a[data-cmd]").on("click", function () {
        var methodName = $(this).data("cmd");
        methodObj[methodName]();
    })

    //审核界面
    $("#policy_dialog").dialog({
        width: 1000,
        height: 600,
        buttons: '#policy_btns',
        closed: true
    })
})



