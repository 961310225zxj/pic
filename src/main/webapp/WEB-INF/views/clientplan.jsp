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
    <title>客户开发计划</title>
    <%@include file="/static/common/common.jsp" %>
    <style type="text/css">
        .border_right_none{
            border-right: none;
        }
    </style>
     <script type="text/javascript" src="/static/js/clientplan.js"></script>
</head>
<body>
    <div id="normal_tb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="add">新增</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" data-cmd="edit">编辑</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-cmd="del">解除</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
       <span style="color: slategray;font-size: 12px"> 关键字:</span><input id="keyword" type="text" name="keyword" class="easyui-textbox"/>
        <span style="color: slategray;font-size: 12px"> 计划时间:</span>
        <input type="text"  name="beginDate" id="beginDate" class="easyui-datebox">- <input type="text" name="endDate"  id="endDate"  class="easyui-datebox">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="searchForm">查询</a>
    </div>

    <table id="clientplan_datagrid"></table>
    <%--会话框--%>
    <div id="clientplan_dialog" >
        <form id="clientplan_form" method="post">
            <table>
                <input type="hidden" name="id">
                <tr>
                    <td><span style="font-size: 12px">客户选择:</span>
                        <input type="text" name="client.id" class="easyui-combobox"
                               data-options="
							        valueField: 'id',
							        textField: 'name',
							        url: '/client_listAll.do',panelHeight:'auto'" />
                    </td>
                    <td><span style="font-size: 12px">计划主题:</span><input type="text" name="title" class="easyui-textbox"/></td>
                </tr>
                <tr>
                    <td><span style="font-size: 12px">计划时间:</span><input type="text" name="plantime" class="easyui-datebox"/></td>
                    <td><span style="font-size: 12px">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</span>
                        <input type="text" name="remark" class="easyui-textbox"/></td>
                </tr>
                <tr>
                    <td><span style="font-size: 12px">跟进效果:</span>
                        <select id="cc" class="easyui-combobox" name="effect" panelHeight='auto' style="width:142px;">
                            <option value="1">优</option>
                            <option value="2">良</option>
                            <option value="3">中</option>
                            <option value="4">差</option>
                        </select>
                    </td>
                    <td><span style="font-size: 12px">实施方式:</span><input type="text" name="measure" class="easyui-textbox"/></td>
                </tr>
                <tr><td colspan="2"><span style="font-size: 12px">详细计划内容:</span><textarea name="detail" style="width: 400px;height: 100px"></textarea></td></tr>
            </table>

        </form>
    </div>

    <div id="normal_bttn">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
    </div>

</body>
</html>
