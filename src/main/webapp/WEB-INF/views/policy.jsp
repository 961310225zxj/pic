<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>policy管理</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/policy.js"></script>
    <script type="text/javascript" src="/static/js/product.js"></script>
    <script type="text/javascript" src="/static/js/carInformation.js"></script>
    <script type="text/javascript" src="/static/js/insuredPerson.js"></script>
    <script type="text/javascript" src="/static/js/recognizee.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="border:false" style="background-color: #ECEADF;width: 1140px;">
    <fieldset>
        <legend>保单信息：</legend>缴费状态
        <select class="easyui-combobox" name="moneystatus" style="width:200px;" data-options="panelHeight:'auto'">
            <option value="0">未交</option>
            <option value="1">已交</option>
        </select>
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="submitPolicy()">提交保单</a>
        <button onclick="recognizeeAdd()">添加投保人</button>
        <form id="recognizeeForm" action="" method="post">
            <div style="border-bottom:1px dashed darkslategray">
                <div><h3 align="left">>>投保人</h3></div>
                <div style="margin-left: 100px;margin-bottom:20px;">
                    <table>
                        <tr>
                            <td>投保人ID</td>
                            <td><input id="recognizee" type="text" class="easyui-textbox" name="id"></td>
                            <td>客户名称</td>
                            <td><input type="text" class="easyui-textbox" name="name"></td>
                            <td>联系电话</td>
                            <td><input type="text" class="easyui-textbox" name="phoneNumber"></td>
                            <td>证件类型</td>
                            <td><input type="text" class="easyui-textbox" name="numberType"></td>
                        </tr>
                        <tr>
                            <td>身份证号码</td>
                            <td><input type="text" class="easyui-textbox" name="number"></td>
                            <td>是否投保人</td>
                            <td><input type="text" class="easyui-textbox" name="is_personal"></td>
                            <td>风险等级</td>
                            <td><input type="text" class="easyui-textbox" name="level"></td>
                            <td>通讯地址</td>
                            <td><input type="text" class="easyui-textbox" name="address"></td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>

        <button onclick="insuredPersonAdd()">添加被保人</button>
        <form id="insuredPersonForm" action="" method="post">
            <div style="border-bottom:1px dashed darkslategray">
                <div><h3 align="left">>>被保人</h3></div>
                <div style="margin-left: 100px;margin-bottom:20px;">
                    <table>
                        <tr>
                            <td>被保人ID</td>
                            <td><input id="insuredPerson" type="text" class="easyui-textbox" name="id"></td>
                            <td>客户名称</td>
                            <td><input type="text" class="easyui-textbox" name="name"></td>
                            <td>联系电话</td>
                            <td><input type="text" class="easyui-textbox" name="phone"></td>
                            <td>证件类型</td>
                            <td><input type="text" class="easyui-textbox" name="numberType"></td>
                        </tr>
                        <tr>
                            <td>身份证号码</td>
                            <td><input type="text" class="easyui-textbox" name="number"></td>
                            <td>是否投保人</td>
                            <td><input type="text" class="easyui-textbox" name="is_personal"></td>
                            <td>风险等级</td>
                            <td><input type="text" class="easyui-textbox" name="level"></td>
                            <td>通讯地址</td>
                            <td><input type="text" class="easyui-textbox" name="address"></td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>

        <button onclick="carInformationAdd()">添加车辆信息</button>
        <form id="carInformationForm" action="" method="post">
            <div style="border-bottom:1px dashed  darkslategray">
                <div><h3 align="left">>>车辆信息</h3></div>
                <div style="margin-left: 100px;margin-bottom:20px;">
                    <table>
                        <tr>
                            <td>车辆信息ID</td>
                            <td><input id="carInformation" type="text" class="easyui-textbox" name="id"></td>
                            <td>汽车品牌</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="carBrand.name">
                                <%--<select class="easyui-combobox" name="carBrand.id" style="width:200px;" data-options="panelHeight:'auto'">
                                    <option value="1">奔驰</option>
                                    <option value="2">宝马</option>
                                    <option value="3">路虎</option>
                                    <option value="4">保时捷</option>
                                    <option value="5">奥迪</option>
                                </select>--%>
                            </td>
                            <td>车辆型号</td>
                            <td><input type="text" class="easyui-textbox" name="cartypeinformation"></td>
                        </tr>

                        <tr>

                            <td>车牌类型</td>
                            <td><input type="text" class="easyui-textbox" name="carIdType"></td>
                            <td>车牌号</td>
                            <td><input type="text" class="easyui-textbox" name="carId"></td>

                        </tr>

                        <tr>
                            <td>是否上牌</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="is_license">
                               <%-- <select class="easyui-combobox" name="is_license" style="width:200px;" data-options="panelHeight:'auto'">
                                    <option value="0">否</option>
                                    <option value="1">是</option>
                                </select>--%>
                            </td>
                            <td>是否新车</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="is_newCar">
                                <%--<select class="easyui-combobox" name="is_newCar" style="width:200px;" data-options="panelHeight:'auto'">
                                    <option value="0">否</option>
                                    <option value="1">是</option>
                                </select>--%>
                            </td>
                            <td>是否外地车</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="is_foreignCar">
                               <%-- <select class="easyui-combobox" name="is_foreignCar" style="width:200px;" data-options="panelHeight:'auto'">
                                    <option value="0">否</option>
                                    <option value="1">是</option>
                                </select>--%>
                            </td>
                            <td>是否过户</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="is_transfer">
                                <%--<select class="easyui-combobox" name="is_transfer" style="width:200px;" data-options="panelHeight:'auto'">
                                    <option value="0">否</option>
                                    <option value="1">是</option>
                                </select>--%>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>

        <button onclick="productAdd()">添加保险信息</button>
        <form id="productForm" action="" method="post">
            <div style="border-bottom:1px solid  darkslategray">
                <div><h3 align="left">>>保险信息</h3> </div>
                <div style="margin-left: 100px;margin-bottom:20px;">
                    <table>
                        <tr>
                            <td>保险产品ID</td>
                            <td><input id="product" type="text" class="easyui-textbox" name="id"></td>
                            <td>保险产品名称</td>
                            <td><input type="text" class="easyui-textbox" name="name"></td>
                            <td>保险价格</td>
                            <td><input type="text" class="easyui-textbox" name="salePrice"></td>
                            <td>机构名称</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="productOrganization.name">
                                <%--<input type="text" class="easyui-combobox" name="productOrganization.id"
                                       data-options="valueField:'id',textField:'name',url:'/productOrganization_listAll.do',panelHeight:'auto'"
                                >--%>
                            </td>
                        </tr>
                        <tr>
                            <td>赔偿额度</td>
                            <td><input type="text" class="easyui-textbox" name="compensation"></td>
                            <td>保险年限</td>
                            <td><input type="text" class="easyui-textbox" name="safetyDate"></td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>

        <%--新增投保人信息--%>
<div id="policy_recognizee" class="easyui-dialog" data-options="
    title:'新增车辆信息',
    width: 1200,
    height: 400,
    closed: true,
    buttons:'#recognizee_dialog_bt',
">
    <table id="recognizee_datagrid"></table>
</div>
        <%--新增被保人信息--%>
<div id="policy_insuredPerson" class="easyui-dialog" data-options="
    title:'新增车辆信息',
    width: 1200,
    height: 400,
    closed: true,
    buttons:'#insuredPerson_dialog_bt',
">
    <table id="insuredPerson_datagrid"></table>
</div>
        <%--新增车辆信息--%>
<div id="policy_carInformation" class="easyui-dialog" data-options="
    title:'新增车辆信息',
    width: 1200,
    height: 400,
    closed: true,
    buttons:'#carInformation_dialog_bt',
">
    <table id="carInformation_datagrid"></table>
</div>
<%--新增保险信息--%>
<div id="policy_product" class="easyui-dialog" data-options="
    title:'新增保险信息',
    width: 1200,
    height: 400,
    closed: true,
    buttons:'#product_dialog_bt',
">
    <table id="product_datagrid"></table>
</div>

    </fieldset>
</div>


<div id="recognizee_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saverecognizee()">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="cancelrecognizee()">取消</a>
</div>

<div id="insuredPerson_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saveinsuredPerson()">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="cancelinsuredPerson()">取消</a>
</div>

<div id="carInformation_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="savecarInformation()">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="cancelcarInformation()">取消</a>
</div>

<div id="product_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saveproduct()">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="cancelproduct()">取消</a>
</div>



</body>
</html>