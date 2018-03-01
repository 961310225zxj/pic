<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>policy管理</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/policy_update.js"></script>
    <script type="text/javascript" src="/static/js/product.js"></script>
    <script type="text/javascript" src="/static/js/carInformation.js"></script>
    <script type="text/javascript" src="/static/js/insuredPerson.js"></script>
    <script type="text/javascript" src="/static/js/recognizee.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="border:false" style="background-color: #ECEADF">
    <fieldset>
        <legend>保单信息：</legend>
        缴费状态
        <select class="easyui-combobox" name="moneystatus" style="width:200px;" data-options="panelHeight:'auto'">
            <option value="0">未交</option>
            <option value="1">已交</option>
        </select>
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="submitPolicy()">提交保单</a>
        <button onclick="recognizeeAdd()">添加投保人</button>
        <input id="policy_id" type="hidden" value="${policy.id}">
        <form id="recognizeeForm" action="" method="post">
            <div style="border-bottom:1px dashed darkslategray">
                <div><h3 align="left">>>投保人</h3></div>
                <div style="margin-left: 100px;margin-bottom:20px;">
                    <table>
                        <tr>
                            <td>投保人ID</td>
                            <td><input id="recognizee" type="text" class="easyui-textbox" name="id" value="${recognizee.id}"></td>
                            <td>客户名称</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="name" value="${recognizee.name}">
                                <%--<input type="text" class="easyui-textbox" name="name">--%>
                            </td>
                            <td>联系电话</td>
                            <td><input type="text" class="easyui-textbox" name="phoneNumber" value=" ${recognizee.phoneNumber}"></td>
                            <td>证件类型</td>
                            <td><input type="text" class="easyui-textbox" name="numberType" value=" ${recognizee.numberType}"></td>
                        </tr>
                        <tr>
                            <td>身份证号码</td>
                            <td><input type="text" class="easyui-textbox" name="number" value="${recognizee.number}"></td>
                            <td>是否投保人</td>
                            <c:choose>
                                <c:when test="${recognizee.is_personal}==1">
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="是"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="否"></td>
                                </c:otherwise>
                            </c:choose>
                            <td>风险等级</td>
                            <td><input type="text" class="easyui-textbox" name="level" value="${recognizee.level}"></td>
                            <td>通讯地址</td>
                            <td><input type="text" class="easyui-textbox" name="address" value="${recognizee.address}"></td>
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
                            <td><input id="insuredPerson" type="text" class="easyui-textbox" name="id" value="${insuredPerson.id}"></td>
                            <td>客户名称</td>
                            <td><input type="text" class="easyui-textbox" name="name" value="${insuredPerson.name}"></td>
                            <td>联系电话</td>
                            <td><input type="text" class="easyui-textbox" name="phone" value="${insuredPerson.phone}"></td>
                            <td>证件类型</td>
                            <td><input type="text" class="easyui-textbox" name="numberType" value="${insuredPerson.numberType}"></td>
                        </tr>
                        <tr>
                            <td>身份证号码</td>
                            <td><input type="text" class="easyui-textbox" name="number" value="${insuredPerson.number}"></td>
                            <td>是否投保人</td>
                            <c:choose>
                                <c:when test="${insuredPerson.is_personal}==1">
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="是"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="否"></td>
                                </c:otherwise>
                            </c:choose>
                            <td>风险等级</td>
                            <td><input type="text" class="easyui-textbox" name="level" value="${insuredPerson.level}"></td>
                            <td>通讯地址</td>
                            <td><input type="text" class="easyui-textbox" name="address" value="${insuredPerson.address}"></td>
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
                            <td><input id="carInformation" type="text" class="easyui-textbox" name="id" value="${carInformation.id}"></td>
                            <td>汽车品牌</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="carBrand.name" value="${carInformation.carBrand.name}">
                            </td>
                            <td>车辆型号</td>
                            <td><input type="text" class="easyui-textbox" name="cartypeinformation" value="${carInformation.cartypeinformation}"></td>
                        </tr>

                        <tr>

                            <td>车牌类型</td>
                            <td><input type="text" class="easyui-textbox" name="carIdType" value="${carInformation.carIdType}"></td>
                            <td>车牌号</td>
                            <td><input type="text" class="easyui-textbox" name="carId" value="${carInformation.carId}"></td>

                        </tr>

                        <tr>
                            <td>是否上牌</td>
                            <c:choose>
                                <c:when test="${carInformation.is_license}==1">
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="是"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="否"></td>
                                </c:otherwise>
                            </c:choose>
                            <td>是否新车</td>
                            <c:choose>
                                <c:when test="${carInformation.is_newCar}==1">
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="是"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="否"></td>
                                </c:otherwise>
                            </c:choose>
                            <td>是否外地车</td>
                            <c:choose>
                                <c:when test="${carInformation.is_foreignCar}==1">
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="是"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="否"></td>
                                </c:otherwise>
                            </c:choose>
                            <td>是否过户</td>
                            <c:choose>
                                <c:when test="${carInformation.is_transfer}==1">
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="是"></td>
                                </c:when>
                                <c:otherwise>
                                    <td><input type="text" class="easyui-textbox" name="is_personal" value="否"></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </table>
                </div>
            </div>
        </form>

        <button onclick="productAdd()">添加保险信息</button>
        <form id="productForm" action="" method="post">
            <div style="border-bottom:1px solid  darkslategray">
                <div><h3 align="left">>>保险信息</h3></div>
                <div style="margin-left: 100px;margin-bottom:20px;">
                    <table>
                        <tr>
                            <td>保险产品ID</td>
                            <td><input id="product" type="text" class="easyui-textbox" name="id" value="${product.id}"></td>
                            <td>保险产品名称</td>
                            <td><input type="text" class="easyui-textbox" name="name" value="${product.name}"></td>
                            <td>保险价格</td>
                            <td><input type="text" class="easyui-textbox" name="salePrice" value="${product.salePrice}"></td>
                            <td>机构名称</td>
                            <td>
                                <input type="text" class="easyui-textbox" name="productOrganization.name" value="${product.productOrganization.name}">
                            </td>
                        </tr>
                        <tr>
                            <td>赔偿额度</td>
                            <td><input type="text" class="easyui-textbox" name="compensation" value="${product.compensation}"></td>
                            <td>保险年限</td>
                            <td><input type="text" class="easyui-textbox" name="safetyDate" value="${product.safetyDate}"></td>
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