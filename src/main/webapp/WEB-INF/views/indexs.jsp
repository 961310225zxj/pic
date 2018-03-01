<%@ page language="java" contentType="text/html;charset=utf-8"%>
<html>
<head>
    <title>Flat Admin V.2 - Free Bootstrap Admin Templates</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/static/common/common.jsp" %>
    <!-- Fonts -->
    <link rel="stylesheet" type="text/css" href="../../static1/fonts.css">
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="../../static1/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../static1/lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../../static1/lib/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="../../static1/lib/css/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="../../static1/lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="../../static1/lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="../../static1/lib/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../static1/lib/css/select2.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="../../static1/css/style.css">
    <link rel="stylesheet" type="text/css" href="../../static1/css/themes/flat-blue.css">
    <link rel="stylesheet" type="text/css"
          href="/static/plugins/easyui/themes/ui-cupertino/easyui.css">
    <!--样式文件-->
    <link rel="stylesheet" type="text/css"
          href="/static/plugins/easyui/themes/icon.css">
    <!--图标样式-->
    <script type="text/javascript"
            src="/static/plugins/easyui/jquery.min.js"></script>
    <!--特定版本的jQuery的核心文件-->
    <script type="text/javascript"
            src="/static/plugins/easyui/jquery.easyui.min.js"></script>
    <!-- easyui的核心包-->
    <script type="text/javascript"
            src="/static/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
    <!--语言支持包-->
    <script type="text/javascript"
            src="/static/js/base.js"></script>
    <style type="text/css">
        .panel-header, .panel-body {
            border-width: 0px;
        }
        .datagrid,.combo-p{
            border:solid 1px #D4D4D4;
        }
        .datagrid *{
            -webkit-box-sizing: content-box;
            -moz-box-sizing: content-box;
            box-sizing: content-box;
        }
    </style>

</head>

<body class="flat-blue">

    <div class="app-container">
        <div class="row content-container">
            <div id="cc" class="easyui-layout" style="background-color: #22A7F0"  data-options="
            fit:true,
            border:false
            ">
            <%--上面的导航栏===============================================================--%>
                <div data-options="region:'north';width:100%;height:9%">

            <nav class="navbar navbar-default navbar-fixed-top navbar-top" >
                <div class="container-fluid"  >
                    <div class="navbar-header">
                        <button type="button" class="navbar-expand-toggle">
                            <i class="fa fa-bars icon"></i>
                        </button>
                        <ol class="breadcrumb navbar-breadcrumb">
                            <li class="active">车险</li>
                        </ol>
                        <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                            <i class="fa fa-th icon"></i>
                        </button>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                            <i class="fa fa-times icon"></i>
                        </button>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-comments-o" style="margin-top: 20px"></i></a>
                            <ul class="dropdown-menu animated fadeInDown">
                                <li class="title">
                                    所有的消息 <span class="badge pull-right">0</span>
                                </li>
                                <li class="message">
                                    没有新的消息
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown danger">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-star-half-o"></i> 4</a>
                            <ul class="dropdown-menu danger  animated fadeInDown">
                                <li class="title">
                                   系统提示 <span class="badge pull-right">4</span>
                                </li>
                                <li>
                                    <ul class="list-group notifications">
                                        <a href="#">
                                            <li class="list-group-item">
                                                <span class="badge">1</span> <i class="fa fa-exclamation-circle icon"></i> 新的提示
                                            </li>
                                        </a>
                                        <a href="#">
                                            <li class="list-group-item">
                                                <span class="badge success">1</span> <i class="fa fa-check icon"></i> 新的保单
                                            </li>
                                        </a>
                                        <a href="#">
                                            <li class="list-group-item">
                                                <span class="badge danger">2</span> <i class="fa fa-comments icon"></i> 客户信息
                                            </li>
                                        </a>
                                        <a href="#">
                                            <li class="list-group-item message">
                                                查询所有
                                            </li>
                                        </a>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown profile">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">个人中心<span class="caret"></span></a>
                            <ul class="dropdown-menu animated fadeInDown">
                                <li class="profile-img">
                                    <img src="../../static1/img/profile/picjumbo.com_HNCK4153_resize.jpg" class="profile-img">
                                </li>
                                <li>
                                    <div class="profile-info">
                                        <h4 class="username">Emily Hart</h4>
                                        <p>emily_hart@email.com</p>
                                        <div class="btn-group margin-bottom-2x" role="group">
                                            <button type="button" class="btn btn-default"><i class="fa fa-user"></i>修改密码</button>
                                            <button type="button" class="btn btn-default"><i class="fa fa-sign-out"></i> 注销</button>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
                </div>

            <%--左边导航栏--%>
                <div class="side-menu sidebar-inverse" data-options="region:'west'" style="width:15%;margin-top: 60px;">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="side-menu-container">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                <%--<div class="icon fa fa-paper-plane"></div>--%>
                                <%--<div class="title">所有菜单</div>--%>
                                <div ><center>所有菜单</center></div>
                            </a>
                            <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                                <i class="fa fa-times icon"></i>
                            </button>
                        </div>
                        <ul class="nav navbar-nav">
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#dropdown-icon">
                                    <span class="icon fa fa-archive"></span><span class="title" >系统管理</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="dropdown-icon" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li onclick="tabs()"><a href="#" >员工管理</a>
                                            </li>
                                            <li><a href="">部门管理</a>
                                            </li>
                                            <li><a href="">角色管理</a>
                                            </li>
                                            <li><a href="">角色管理</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#dropdown-element">
                                    <span class="icon fa fa-desktop"></span><span class="title">客户管理</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="dropdown-element" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="ui-kits/alert.html">Alerts & Toasts</a>
                                            </li>
                                            <li><a href="ui-kits/panel.html">Panels</a>
                                            </li>
                                            <li><a href="ui-kits/loader.html">Loaders</a>
                                            </li>
                                            <li><a href="ui-kits/step.html">Tabs & Steps</a>
                                            </li>
                                            <li><a href="ui-kits/other.html">Other</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#dropdown-table">
                                    <span class="icon fa fa-table"></span><span class="title">报表管理</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="dropdown-table" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="table/table.html">Table</a>
                                            </li>
                                            <li><a href="table/datatable.html">Datatable</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#dropdown-form">
                                    <span class="icon fa fa-file-text-o"></span><span class="title">投保管理</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="dropdown-form" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="form/ui-kits.html">Form UI Kits</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            
                            <!-- Dropdown-->
                            <li class="panel panel-default dropdown">
                                <a data-toggle="collapse" href="#component-example">
                                    <span class="icon fa fa-cubes"></span><span class="title">核保管理</span>
                                </a>
                                <!-- Dropdown level 1 -->
                                <div id="component-example" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="components/pricing-table.html">计划管理</a>
                                            </li>
                                            <li><a href="components/chartjs.html">Chart.JS</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>
            </div>


            <div class="copyrights" data-options="region:'south'" >
                Collect from <a href="http://www.cssmoban.com/" >平安车险</a>
            </div>




            <!-- Main Content ================================================================-->
            <div  data-options="region:'center'" style="height: 91%;" >
                    <iframe id="index_iframe" frameborder=0  width='85%' height="100%"
						src="/checkOkPolicy.do" allowfullscreen="allowfullscreen" align="right"  style="margin-top: 60px;"></iframe>
            </div>
<%--        </div>
        <footer class="app-footer">
            <div class="wrapper">
                <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span> © 2015 Copyright. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
            </div>
        </footer>
        <div>--%>
            <!-- Javascript Libs -->
            <script type="text/javascript" src="../../static1/lib/js/jquery.min.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/Chart.min.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/bootstrap-switch.min.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/jquery.matchHeight-min.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/jquery.dataTables.min.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/dataTables.bootstrap.min.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/select2.full.min.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/ace/ace.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/ace/mode-html.js"></script>
            <script type="text/javascript" src="../../static1/lib/js/ace/theme-github.js"></script>
            <!-- Javascript -->
            <script type="text/javascript" src="../../static1/js/app.js"></script>
            <script type="text/javascript" src="../../static1/js/index.js"></script>
            <script type="text/javascript" src="/static/js/index.js"></script>
        </div>
    </div>
</div>
</body>

</html>
