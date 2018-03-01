<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>policy管理</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/policy.js"></script>
</head>
<body>

<form action="" method="post">

    <div>
        <h3 align="center">投保人</h3>
        <table align="center">
            <tr>
                <td>姓名</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
                <td>性别</td>
                <td>
                    <select class="easyui-combobox" name=""
                            panelHeight='auto' style="width: 143px;" required="required">
                        <option value="0">女</option>
                        <option value="1">男</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>身份证</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
                <td>联系方式</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
            </tr>
            <tr>
                <td>联系地址</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
            </tr>
        </table>
    </div>

    <div>
        <h4 align="center">被保人</h4>
        <table align="center">
            <tr>
                <td>姓名</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
                <td>性别</td>
                <td>
                    <select class="easyui-combobox" name=""
                            panelHeight='auto' style="width: 143px;" required="required">
                        <option value="0">女</option>
                        <option value="1">男</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>身份证</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
                <td>联系方式</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
            </tr>
            <tr>
                <td>联系地址</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
            </tr>
        </table>
    </div>

    <div>
        <h2 align="center">车辆信息</h2>
        <table align="center">
            <tr>
                <td>姓名</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
                <td>性别</td>
                <td>
                    <select class="easyui-combobox" name=""
                            panelHeight='auto' style="width: 143px;" required="required">
                        <option value="0">女</option>
                        <option value="1">男</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>身份证</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
                <td>联系方式</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
            </tr>
            <tr>
                <td>联系地址</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
            </tr>
        </table>
    </div>

    <div>
        <h2 align="center">保险信息</h2>
        <table align="center">
            <tr>
                <td>姓名</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
                <td>性别</td>
                <td>
                    <select class="easyui-combobox" name=""
                            panelHeight='auto' style="width: 143px;" required="required">
                        <option value="0">女</option>
                        <option value="1">男</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>身份证</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
                <td>联系方式</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
            </tr>
            <tr>
                <td>联系地址</td>
                <td><input type="text" class="easyui-textbox" name=""></td>
            </tr>
        </table>
    </div>


</form>
<%--<!-- 数据表格 -->
<table id="policy_datagrid">
    <thead>
        <tr>
            <th data-options="field:'recognizee_id',width:1,align:'center'">recognizee_id</th>
            <th data-options="field:'carInformation_id',width:1,align:'center'">carInformation_id</th>
            <th data-options="field:'carPerson_id',width:1,align:'center'">carPerson_id</th>
            <th data-options="field:'insuredPerson_id',width:1,align:'center'">insuredPerson_id</th>
            <th data-options="field:'product_id',width:1,align:'center'">product_id</th>
        </tr>
    </thead>
</table>
<!-- 新增编辑对话框 -->
<div id="policy_dialog">
    <form id="policy_form" method="post">
    <table align="center" style="margin-top: 15px;">
        <input type="hidden" name="id">
        <tr>
            <td>recognizee_id</td>
            <td><input type="text" class="easyui-textbox" name="recognizee_id"></td>
        </tr>
        <tr>
            <td>carInformation_id</td>
            <td><input type="text" class="easyui-textbox" name="carInformation_id"></td>
        </tr>
        <tr>
            <td>carPerson_id</td>
            <td><input type="text" class="easyui-textbox" name="carPerson_id"></td>
        </tr>
        <tr>
            <td>insuredPerson_id</td>
            <td><input type="text" class="easyui-textbox" name="insuredPerson_id"></td>
        </tr>
        <tr>
            <td>product_id</td>
            <td><input type="text" class="easyui-textbox" name="product_id"></td>
        </tr>
    </table>
    </form>
</div>

<!-- 对话框保存取消按钮 -->
<div id="policy_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
</div>--%>
</body>
</html>