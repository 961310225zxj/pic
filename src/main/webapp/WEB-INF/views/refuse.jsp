<%--
  Created by IntelliJ IDEA.
  User: Jim
  Date: 2017/8/26
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已上报保单</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/refuse.js"></script>
    <style type="text/css">
        .multieditbox{
            background: #f8f8f8;
            border-bottom: #b7b7b7 1px solid;
            border-left: #b7b7b7 1px solid;
            border-right: #b7b7b7 1px solid;
            border-top: #b7b7b7 1px solid;
            color: #000000;
            cursor: text;
            font-family: "arial";
            font-size: 9pt;
            padding: 1px;
        }
        .basic-grey  {
            color: #888;
            width: 100px;
            padding: 0px 0px 0px 5px;
            border: 1px solid #C5E2FF;
            background: #FBFBFB;
            outline: 0;
            -webkit-box-shadow:inset 0px 1px 6px #ECF3F5;
            box-shadow: inset 0px 1px 6px #ECF3F5;
            font: 200 12px/25px Arial, Helvetica, sans-serif;
            height: 30px;
            line-height:15px;
            margin: 2px 6px 16px 0px;
        }
        body {margin:0;padding:0;line-height:1.5em;font-family:"Times New Roman",Times,serif;font-size:14px;color:#000000;background:#f2e7ca}
    </style>
</head>
<body >

<%--数据列表上的菜单--%>
<div id="policy_tb" style="height:25px;line-height:25px;">

    <a  href="#" class="easyui-linkbutton"
        data-options="iconCls:'icon-edit',plain:true" data-cmd="check">查看</a>
    <%--            <a href="#" class="easyui-linkbutton" id="emp_tb_edit"
                   data-options="iconCls:'icon-clear',plain:true" data-cmd="back">退回</a>--%>
    <a  href="#" class="easyui-linkbutton"
        data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
</div>


<div id="cc" class="easyui-layout"   data-options="fit:true,border:false">
    <div class="easyui-panel" id="p" data-options="region:'north',border:false"
         style="width:100%;height:30%;background-color: #ECEADF" >
        <fieldset>
            <legend>搜索：</legend>
            <form id="editForm" method="post">
                <p/>投保人: <input type="text" name="recognizee" placeholder="投保人.."/> 被保人: <input type="text" name="insuredPerson" placeholder="被保人"/>



                <p/>编号: <input type="text" name="checkId" placeholder="编号.."/>


                <%--保险机构: <input type="text" name="organization" placeholder="保险机构.."/>--%>


                产品:
                <input id="products_combobox" name="product" type="text"  class="easyui-combobox"
                       data-options="
							        valueField: 'name',
							        textField: 'name',
							        url: '/product_listAll.do',panelHeight:'auto'" />

                <div>
                    <p/>申请时间: <input type="text" name="beginTime" class="easyui-datebox" />至
                    <input type="text" name="endTime" class="easyui-datebox"/>
                    <a  href="#" class="easyui-linkbutton"
                        data-options="iconCls:'icon-search'" style="margin-left: 100px" data-cmd="search">查询</a>
                    <a  href="#" class="easyui-linkbutton"
                        data-options="iconCls:'icon-clear'" data-cmd="reset">重置</a>
                </div>
            </form>
        </fieldset>
    </div>
    <div data-options="region:'south',border:false"
         style="height:70%;">
        <table id="policy_datagrid"></table>
    </div>
</div>



<div id="policy_dialog"   >
    <div id="approval_tabs" class="easyui-tabs" style="width:100%;height:85%;">
        <div title="投保人信息" style="padding:20px;display:none;">
            <form id="recognizeeForm">
                <table border="1px">
                    <tr>
                        <td>ID</td><td>投保人姓名</td><td>联系电话</td><td>证件类型</td>
                        <td>身份证号码</td><td>风险等级</td><td>通讯地址</td>
                    </tr>
                    <tr>
                        <td><input style="width:60px" name="recognizee.id"/></td>
                        <td><input style="width:100px" name="recognizee.name" /></td>
                        <td><input style="width:100px" name="recognizee.phoneNumber" /></td>
                        <td><input style="width:100px" name="recognizee.numberType" /></td>
                        <td><input style="width:150px" name="recognizee.number" /></td>
                        <td><input style="width:60px" name="recognizee.level" /></td>
                        <td><input style="width:300px" name="recognizee.address"/></td>
                    </tr>
                </table>
            </form>
        </div>

        <div title="被保人信息" style="overflow:auto;padding:20px;display:none;">
            <form id="insuredPersonForm">
                <table border="1px">
                    <tr>
                        <td>ID</td><td>投保人姓名</td><td>联系电话</td><td>证件类型</td>
                        <td>身份证号码</td><td>风险等级</td><td>通讯地址</td>
                    </tr>
                    <tr>
                        <td><input style="width:60px"  name="insuredPerson.id"/></td>
                        <td><input style="width:100px" name="insuredPerson.name" /></td>
                        <td><input style="width:100px" name="insuredPerson.phone" /></td>
                        <td><input style="width:100px" name="insuredPerson.numberType" /></td>
                        <td><input style="width:150px" name="insuredPerson.number"/></td>
                        <td><input style="width:60px"  name="insuredPerson.level" /></td>
                        <td><input style="width:300px" name="insuredPerson.address"/></td>
                    </tr>
                </table>
            </form>
        </div>

        <div title="车辆信息" style="padding:20px;display:none;">
            <form id="carInformationForm">
                <table border="1px">
                    <tr>
                        <td>ID</td><td>车辆型号</td><td>车牌类型</td>
                        <td>车牌号</td><td>是否新车</td><td>是否外地车</td><td>是否过户</td>
                    </tr>
                    <tr>
                        <td><input style="width:60px"  name="carInformation.id"/></td>
                        <td><input style="width:100px"  name="carInformation.cartypeinformation" /></td>
                        <td><input style="width:100px"  name="carInformation.carIdType" /></td>
                        <td><input style="width:100px"  name="carInformation.carId" /></td>
                        <td><input style="width:150px"  name="carInformation.is_newCar" /></td>
                        <td><input style="width:60px"  name="carInformation.is_foreignCar" /></td>
                        <td><input style="width:300px"  name="carInformation.is_transfer"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <div title="保单信息" style="padding:20px;display:none;">
            <form id="policyForm">
                <table border="1px">
                    <tr>
                        <td>保单编号</td><td>保险产品名称</td><td>保险价格</td><td>赔偿额度</td><td>保险年限</td>
                    </tr>
                    <tr>
                        <td><input style="width:60px"  name="id" id="policyId"/></td>
                        <td><input style="width:100px" name="product.name" /></td>
                        <td><input style="width:100px" name="product.salePrice" /></td>
                        <td><input style="width:100px" name="product.safetyDate" /></td>
                        <td><input style="width:150px" name="product.compensation" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>



<div id="tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="">提交未审核</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="">审核</a>
</div>
<div id="storePolicy_datagrid"></div>

<%--审核界面下方按钮--%>
<div id="policy_btns">

    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">关闭</a>
</div>

</body>
</html>
