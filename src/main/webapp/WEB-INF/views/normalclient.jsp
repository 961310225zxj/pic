<%--
  Created by IntelliJ IDEA.
  User: zlb
  Date: 2017.08.26
  Time: 下午 04:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>正式客户</title>
    <%@include file="/static/common/common.jsp" %>
    <style type="text/css">
        .border_right_none{
            border-right: none;
        }
    </style>
     <script type="text/javascript" src="/static/js/normalclient.js"></script>
</head>
<body>
    <div id="normal_tb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" data-cmd="edit">编辑</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-cmd="del">解除</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-cmd="export">导出到execel</a>
       <span style="color: slategray;font-size: 12px"> 客户名称:</span><input type="text" id="keyword" name="keyword" class="easyui-textbox" placeholder="用户名/职业/性别"/>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="searchForm">查询</a>
    </div>

    <table id="normalclient_datagrid"></table>
    <%--会话框--%>
    <div id="normalclient_dialog" >
        <form id="normalclient_form" method="post">
            <table>
                <input type="hidden" name="id">
                <tr><td>客户姓名:<input type="text" name="name" class="easyui-textbox"/></td></tr>
                <tr><td>客户性别:<input type="text" name="gender" class="easyui-textbox"/></td></tr>
                <tr><td>客户年龄:<input type="text" name="age" class="easyui-textbox"/></td></tr>
                <tr><td>身份证码:<input type="text" name="number" class="easyui-textbox"/></td></tr>
                <tr><td>是否投保:<select id="cc" class="easyui-combobox" name="isInsured" panelHeight='auto' style="width:162px;">
                    <option value="true">是</option>
                    <option value="false">否</option>
                </select> </td></tr>
                <tr><td>家庭住址:<input type="text" name="address" class="easyui-textbox"/></td></tr>
                <tr><td>客户邮箱:<input type="text" name="email" class="easyui-textbox"/></td></tr>
                <tr><td>联系电话:<input type="text" name="phone" class="easyui-textbox"/></td></tr>
               <%-- <tr><td>录入时间:<input type="text" name="inputtime" class="easyui-datebox"/></td></tr>--%>
                <tr><td>客户职业:<input type="text" name="profession" class="easyui-textbox"/></td></tr>
            </table>

        </form>
    </div>

    <div id="normal_bttn">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
    </div>

</body>
</html>
