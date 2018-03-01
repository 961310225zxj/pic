<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8' />
<link rel='stylesheet' href="/static/css/journeyplan/jquery-ui.min.css" />
<link href='/static/css/journeyplan/fullcalendar.css' rel='stylesheet' />
<link href='/static/css/journeyplan/fullcalendar.print.css'
	rel='stylesheet' media='print' />

<script src="/static/plugins/journeyplan/moment.min.js"></script>
<script src="/static/plugins/journeyplan/jquery.min.js"></script>
<script src="/static/plugins/journeyplan/fullcalendar.min.js"></script>
<script src="/static/plugins/journeyplan/lang-all.js"></script>

<script type="text/javascript"
	src="/static/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="/static/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="/static/plugins/easyui/themes/ui-pepper-grinder/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/static/plugins/easyui/themes/icon.css">

<script type="text/javascript" src="/static/js/calendar.js"></script>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#top {
	background: #eee;
	border-bottom: 1px solid #ddd;
	padding: 0 10px;
	line-height: 40px;
	font-size: 12px;
}

#calendar {
	max-width: 900px;
	margin: 40px auto;
	padding: 0 10px;
}
</style>
</head>
<body>
	<div id='calendar'></div>
	<!-- 对话框按钮 -->
	<div id="mydialog">
		<form id="myform" method="post" action="">
			<input type="hidden" name=id />
			<table align="center" style="margin-top: 30px;">
				<tr>
					<th>标题</th>
					<th>
						<input type="text" name="title" />
					</th>
				</tr>
				<tr>
					<th>是否全天</th>
					<th>
						<select name="allDay">
							<option value="false">--请选择--</option>
							<option value=true>是</option>
							<option value=false>否</option>
						</select>
					</th>
				</tr>
				<tr>
					<th>开始时间</th>
					<th>
						<input class="easyui-datetimebox" name="start"
							data-options="required:true,showSeconds:true"
							value="3/4/2010 2:3" style="width: 150px">
					</th>
				</tr>
				<tr>
					<th>结束时间</th>
					<th>
						<input class="easyui-datetimebox" name="end"
							data-options="showSeconds:true" value="3/4/2010 2:3"
							style="width: 150px">
					</th>
				</tr>
				<tr>
					<th>链接地址</th>
					<th>
						<input type="text" name="url" />
					</th>
				</tr>
				<tr>
					<th>标记颜色</th>
					<th>
						<select name="color">
							<option value="red">红色</option>
							<option value="blue">蓝色</option>
							<option value="gray">灰色</option>
						</select>
					</th>
				</tr>
			</table>
		</form>
	</div>

	<div id="dialogbutton" style="text-align: center">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save' , plain:true" id="formsave">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel' , plain:true" id="cancel">取消</a>
	</div>
</body>
</html>
