$(function() {
	var mydialog = $("#mydialog");
	var myform = $("#myform");
	mydialog.dialog({
		width : 300,
		height : 300,
		top : 100,
		resizable : true,
		modal : true,
		closed : true,
		buttons : "#dialogbutton"
	});

	var initialLangCode = 'zh-cn';

	$("#cancel").on("click", function() {
		$("#mydialog").dialog("close");
	});

	$("#formsave").on("click", function() {
		$("#myform").form("submit", {
			url : "journeyplan_save.do",

			success : function(data) {
				data = $.parseJSON(data);
				if (data.success) {
					// 关闭窗口,
					$("#mydialog").dialog("close");
					// 页面刷新
					window.location.reload();
				} else {
					// 说明是失败
					$("#mydialog").dialog("close");
					$.messager.alert("提示消息", data.msg, "info")
				}
			}
		})
	});
	// ============================
	// 获取所有的行程数据
	$.post("/journeyplan_list.do", function(data) {
		$('#calendar').fullCalendar(
				{
					header : {
						left : 'prev,next today',
						center : 'title',
						right : 'month,agendaWeek,agendaDay'
					},
					// defaultDate : '2016-08-12',
					lang : initialLangCode,
					buttonIcons : false, // show the prev/next text
					weekNumbers : true,
					editable : true,
					eventLimit : true, // allow "more" link when too many
					events : data,// 响应回来的数据
					dayClick : function(date, allDay, jsEvent, view, event) {
						// 把对话框打开
						$("#mydialog").dialog("open");
						$("#mydialog").dialog("setTitle", "新增日程");
						$("#myform").form("clear");
					},
					eventClick : function(event, jsEvent, view) {
						$.messager.confirm("确认", "确定要把这个日程删除?", function(ok) {
							if (ok) {
								$.get("journeyplan_delete.do?id=" + event.id,
										function(data) {
											if (data.success) {
												// $.messager.alert("提示消息",
												// data.msg,
												// "info");
												window.location.reload();
											}
										})
							}
						})
					}
				});
	});
	// ===================================

	// build the language selector's options
	$.each($.fullCalendar.langs, function(langCode) {
		$('#lang-selector').append(
				$('<option/>').attr('value', langCode).prop('selected',
						langCode == initialLangCode).text(langCode));
	});

	// when the selected option changes, dynamically change the calendar option
	$('#lang-selector').on('change', function() {
		if (this.value) {
			$('#calendar').fullCalendar('option', 'lang', this.value);
		}
	});

});
