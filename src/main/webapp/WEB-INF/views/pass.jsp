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
    <title>核保已通过</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/pass.js"></script>

</head>
<body>
        <%--数据列表上的菜单--%>
        <div id="policy_tb" style="height:25px;line-height:25px;">
            <a href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-reload',plain:true" data-cmd="">刷新</a>
        </div>

        <%--已通过核保主界面--%>
        <div id="cc" class="easyui-layout"   data-options="fit:true,border:false">
            <div class="easyui-panel" id="p" data-options="region:'north',border:false"
                 style="width:100%;height:30%;background-color: #ECEADF" >
                <fieldset>
                    <legend>待审核保单：</legend>
                    <form id="editForm">
                        <p/>投保人: <input type="text" placeholder="投保人.."/> 被保人: <input type="text" placeholder="被保人"/>



                        <p/>受益人: <input type="text" placeholder="受益人.."/>


                        保险机构: <input type="text" placeholder="保险机构.."/>


                        产品:
                        <select id="product_list" class="easyui-combobox"  panelHeight='auto' style="width:170px;height:22px">
                            <option >被盗险</option>
                            <option >划伤险</option>
                        </select>

                        <div>
                            <p/>申请时间: <input type="text" name="beginTime" class="easyui-datebox" />至
                            <input type="text" name="endTime" class="easyui-datebox"/>
                        </div>
                        <a  href="#" class="easyui-linkbutton"
                            data-options="iconCls:'icon-search'" data-cmd="search">查询</a>
                        <a  href="#" class="easyui-linkbutton"
                            data-options="iconCls:'icon-clear'" data-cmd="reset">重置</a>
                    </form>
                </fieldset>
            </div>
            <div data-options="region:'south',border:false"
                 style="height:70%;">
                <table id="policy_datagrid"></table>
            </div>
        </div>

        <%--详情界面--%>
        <div id="policy_dialog">
            这里是详细信息....
        </div>
</body>
</html>
