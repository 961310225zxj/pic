<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>
    <head>
        <title>投保审批单</title>
        <jsp:include page="/static/common/common.jsp"></jsp:include>
        <script type="text/javascript" src="/static/audit/js/approvalReport.js"></script>
        <style type="text/css">
            * {
                font-size: 12px;
                margin: 0;
                padding: 0;
            }

            fieldset.test {
                padding: 10px;
                /* margin:10px;*/
                height: 50%;
                width: auto;
                color: #333;
                border: #06c solid 1px;
            }

            legend {
                color: #06c;
                padding: 5px 10px;
                font-weight: 800;
                /*background:white;*/
            }

            ul {
                list-style-type: none;
                margin: 8px 0 4px 0;
            }
        </style>
    </head>
<body>

<%--<div id="tb">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="">暂存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="handIn()">提交</a>
</div>--%>
<input type="hidden" value="${policy.applicant.id}" class="idEle">
<div id="approval_tabs" class="easyui-tabs" style="width:100%;height:50%;">
    <div title="客户信息" style="padding:20px;display:none;">
        <table id="khTabel"></table>
    </div>
    <div title="车辆信息" style="overflow:auto;padding:20px;display:none;">
        <%--车辆信息--%>
        <table id="carTabel"></table>
    </div>
    <div title="险别信息" style="padding:20px;display:none;">
        <table id="productTabel"></table>
    </div>
    <div title="缴费计划" style="padding:20px;display:none;">
        项目正在构建中敬请期待
    </div>
    <div title="核保信息" style="padding:20px;display:none;">
        <span style="font-family: 微软雅黑">核保意见:</span>
        <form id="auditAdviceForm" method="post">
            <input type="hidden" name="id" value="${policy.applicant.id}">
            <input name="auditAdvice" class="easyui-textbox" data-options="multiline:true" style="width:100%;height: 70px;"><br/><br/>
            <span style="font-family: 微软雅黑">核保选项:</span>
            <select name="msg">
                <option value="2">复合</option>
                <option value="1">同意</option>
                <option value="-1">退回</option>
            </select>
        </form>
    </div>
</div>
<div id="tab-tools">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="handIn()">提交</a>
</div>

<fieldset class="test">
    <legend>历史核保信息</legend>
    <table id="approval_datagrid"></table>
</fieldset>
</body>
</html>

