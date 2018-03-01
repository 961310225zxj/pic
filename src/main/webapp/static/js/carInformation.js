$(function () {
    /*
     * 抽取所有需要用得元素.
     */
    var carInformationDatagrid, carInformationDialog, carInformationForm;
    carInformationDatagrid = $("#carInformation_datagrid");
    carInformationDialog = $("#carInformation_dialog");
    carInformationForm = $("#carInformation_form");
    /*
     * 初始化数据表格
     */
    carInformationDatagrid.datagrid({
        url: "/carInformation_list.do",
        fit: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        pagination: true,
        fitColumns: true,
        toolbar: '#carInformation_datagrid_tb',
        columns:[[
            {field:'carBrand',title:'汽车品牌',width:200,align:'center',formatter:carBrandformatter},
            {field:'cartypeinformation',title:'车辆型号',width:300,align:'center'},
            {field:'is_transfer',title:'是否过户',width:100,align:'center',formatter:is_transferformatter},
            {field:'is_foreignCar',title:'是否外地车',width:100,align:'center',formatter:is_foreignCarformatter},
            {field:'is_newCar',title:'是否新车',width:100,align:'center',formatter:is_newCarformatter},
            {field:'is_license',title:'是否上牌',width:100,align:'center',formatter:is_licenseformatter},
            {field:'carIdType',title:'车牌类型',width:100,align:'center'},
            {field:'carId',title:'车牌号',width:200,align:'center'},
        ]]
    });
    /*
     * 初始化新增/编辑对话框
     */
    carInformationDialog.dialog({
        width: 300,
        height: 340,
        closed: true,
        buttons: '#carInformation_dialog_bt'
    });
    /*
     * 对页面按钮进行统一监听
     */
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    /*
     * 所有的操作封装到cmdObj对象中,方便管理
     */
    var cmdObj = {
        add: function () {
            carInformationForm.form("clear");
            carInformationDialog.dialog("setTitle", "新增");
            carInformationDialog.dialog("open");
        },
        edit: function () {
            var rowData = carInformationDatagrid.datagrid("getSelected");
            if (rowData) {
                carInformationForm.form("clear");
                carInformationDialog.dialog("setTitle", "编辑");
                carInformationDialog.dialog("open");
                if (rowData.carBrand)
                    rowData["carBrand.id"] = rowData.carBrand.id;
                carInformationForm.form("load", rowData);
            } else {
                $.messager.alert("温馨提示", "请选择需要编辑的数据!", "warining");
            }
        },
        del: function () {
            var rowData = carInformationDatagrid.datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "您确定需要删除选中数据吗？", function (yes) {
                    if (yes) {
                        $.post("/carInformation_delete.do", {carInformationId: rowData.id}, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    carInformationDatagrid.datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "error");
                            }
                        })
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的数据!", "warining");
            }
        },
        reload: function () {
            carInformationDatagrid.datagrid("reload");
        },
        save: function () {
            var url;
            var idVal = $("[name='id']").val();
            if (idVal) {
                url = "/carInformation_update.do"
            } else {
                url = "/carInformation_save.do";
            }
            carInformationForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            carInformationDialog.dialog("close");
                            carInformationDatagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            });
        },
        cancel: function () {
            carInformationDialog.dialog("close");
        }
    }
});

function carBrandformatter(value, row, index) {
    if (row.carBrand) {
        return row.carBrand.name;
    } else {
        return row.carBrand;
    }
}
function is_transferformatter(value, row, index) {
    return row.is_transfer == 1 ? "是" : "否";
}
function is_foreignCarformatter(value, row, index) {
    return row.is_foreignCar == 1 ? "是" : "否";
}
function is_newCarformatter(value, row, index) {
    return row.is_newCar == 1 ? "是" : "否";
}
function is_licenseformatter(value, row, index) {
    return row.is_license == 1 ? "是" : "否";
}
