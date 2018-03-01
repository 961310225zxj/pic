//弹出对话框
function productAdd() {
    $("#policy_product").dialog("open");
}
function carInformationAdd() {
    $("#policy_carInformation").dialog("open");
}
function insuredPersonAdd() {
    $("#policy_insuredPerson").dialog("open");
}
function recognizeeAdd() {
    $("#policy_recognizee").dialog("open");
}

function saveproduct() {
   // alert("saveproduct");
   // console.log(row);
    var row = $("#product_datagrid").datagrid("getSelected");
    if (row) {
        row['productOrganization.name'] = row['productOrganization'].name;
        $("#productForm").form("load", row);
        $.messager.alert("温馨提示", "选择成功", "info", function () {
            $("#policy_product").dialog("close");
        });
    }
    $("#policy_product").dialog("close");
}

function savecarInformation() {
    //alert("savecarInformation");
   // console.log(row);
    var row = $("#carInformation_datagrid").datagrid("getSelected");
    if (row) {
        row['carBrand.name'] = row['carBrand'].name;
        row.is_license = row.is_license == 1 ? "是" : "否";
        row.is_newCar = row.is_newCar == 1 ? "是" : "否";
        row.is_foreignCar = row.is_foreignCar == 1 ? "是" : "否";
        row.is_transfer = row.is_transfer == 1 ? "是" : "否";
        $("#carInformationForm").form("load", row);
        $.messager.alert("温馨提示", "选择成功", "info", function () {
            $("#policy_carInformation").dialog("close");
        });
    }
    $("#policy_carInformation").dialog("close");
}


function saveinsuredPerson() {
    //alert("saveinsuredPerson");
   // console.log(row);
    var row = $("#insuredPerson_datagrid").datagrid("getSelected");
    if (row) {
        row.is_personal = row.is_personal == 1 ? "是" : "否";
        $("#insuredPersonForm").form("load", row);
        $.messager.alert("温馨提示", "选择成功", "info", function () {
            $("#policy_insuredPerson").dialog("close");
        });
    }
    $("#policy_insuredPerson").dialog("close");
}

function saverecognizee() {
    //alert("saverecognizee");
   // console.log(row);
    var row = $("#recognizee_datagrid").datagrid("getSelected");
    if (row) {
        row.is_personal = row.is_personal == 1 ? "是" : "否";
        $("#recognizeeForm").form("load", row);
        $.messager.alert("温馨提示", "选择成功", "info", function () {
            $("#policy_recognizee").dialog("close");
        });
    }
    $("#policy_recognizee").dialog("close");
}

function cancelproduct() {
    $("#policy_product").dialog("close");
}

function cancelcarInformation() {
    $("#policy_carInformation").dialog("close");
}

function cancelinsuredPerson() {
    $("#policy_insuredPerson").dialog("close");
}

function cancelrecognizee() {
    $("#policy_recognizee").dialog("close");
}

function submitPolicy() {

    var recognizee_id = $("input[id='recognizee']").val();
    var insuredperson_id = $("input[id='insuredPerson']").val();
    var carinformation_id = $("input[id='carInformation']").val();
    var product_id = $("input[id='product']").val();
    var moneystatus = $("[name='moneystatus']").val();
    /*console.log("-----------");
    console.log("缴费状态"+moneystatus);*/
  /*  console.log("投保人"+recognizee_id);
    console.log("-----------");
    console.log("被保人"+insuredperson_id);
    console.log("-----------");
    console.log("车辆信息"+carinformation_id);
    console.log("-----------");
    console.log("保险"+product_id);
    console.log("-----------");*/
    $.messager.confirm("温馨提示","您确定需要保单？",function(yes){
        if(yes){
            $.post("/policy_save.do",{
                'recognizee.id':recognizee_id,
                'insuredPerson.id':insuredperson_id,
                'carInformation.id':carinformation_id,
                'product.id':product_id,
                'moneystatus':moneystatus
            },function(data){
                if(data.success){
                    $.messager.alert("温馨提示",data.msg,"info",function(){
                        $("form").form("clear");
                    });
                }else{
                    $.messager.alert("温馨提示",data.msg,"error");
                }
            })
        }
    });
}

