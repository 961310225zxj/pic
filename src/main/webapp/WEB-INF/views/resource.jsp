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
    <title>Title</title>
    <%@include file="/static/common/common.jsp" %>
    <style type="text/css">
        .border_right_none{
            border-right: none;
        }
    </style>
     <script type="text/javascript" src="/static/js/resource.js"></script>
</head>
<body>
    <div id="normal_tb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="absorb">吸纳</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
     	  <span style="color: slategray;font-size: 12px">
     	  关键字:</span><input type="text" name="keyword">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" data-cmd="searchForm">查询</a>
    </div>
    
    <table id="resource_datagrid"></table>
</body>
</html>
