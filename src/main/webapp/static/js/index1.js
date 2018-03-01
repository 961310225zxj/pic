$(function(){
	//修改密码
	$('#pwd').bind('click',function(){
		$("#pwd_dialog").dialog("open");
	});
	//初始化密码弹出框
	$("#pwd_dialog").dialog({
		title:'修改密码',
		width:300,
		height:200,
		modal:true,
		closed:true,
		buttons:'#pwd_btns'
	})
	//==============================================
	//签到签退
	var methodObj = {
		// 签到
		signIn : function() {
			$.post("/check_signIn.do", function(data) {
				if (data.success) {
					$.messager.alert('温馨提示', data.msg, 'info');
				} else {
					$.messager.alert('温馨提示', data.msg, 'info');
				}
			});
		},
		// 签退
		signOut : function() {
			$.post("/check_signOut.do", function(data) {
				if (data.success) {
					$.messager.alert('温馨提示', data.msg, 'info');
				} else {
					$.messager.alert('温馨提示', data.msg, 'info');
				}
			});
		}
	};
	// 统一绑定事件
	$("a[data-cmd]").on("click", function() {
		// 获取该链接需要执行的方法名字
		var methodName = $(this).data("cmd");
		// 调用方法
		methodObj[methodName]();
	});
	//===========================================
	
	
	
	$(document).ready(function() {
	        $.ajax({
	            type: 'POST',
	            dataType: "json",
	            url:'/menu_list.do',
	            success: function(data){
	                $.each(data,function(i,n){
	                    $('#menu').accordion('add',{
	                        title: n.text,
	                        selected: false,
	                        content:'<div style="padding:10px"><ul name="'+n.text+'"></ul></div>',
	                    });
	                });
	            }
	        });
	
	        $('#menu').accordion({
	            onSelect: function(title,index){
	                $("ul[name='"+title+"']").tree({
	                    url: '/children.do?menuName='+title,
	                    animate:true,
	                    onClick:function(node){
	                        console.log(node);
	                        //判断选项卡是否存在,如果存在,就选中该选项卡,否则,就添加一个选项卡
	                        if($("#index_tabs").tabs("exists",node.text)){//存在
	                            $("#index_tabs").tabs("select",node.text);//选中
	                        }else{//不存在
	                            $("#index_tabs").tabs("add",{
	                                title:node.text,
	                                closable:true,
	//					href:node.attributes.url,
	                                content:"<iframe frameborder=0 height='100%' width='100%' src="+node.url+"></iframe>"
	                            })
	                        }
	                    }
	                });
	            }
	        });
	    });


});
//保存密码
function save(){
	var url = "/employee_changepwd.do";
	$("#pwdForm").form('submit', {
		url : url,
		success : function(data) {
			// 转成json对象
			data = $.parseJSON(data);
			if (data.success) {
				$.messager.alert('温馨提示', data.msg, 'info', function() {
					$.get("/clearSession.do",function(xx){
						// 关闭弹出框
						$("#pwd_dialog").dialog("close");
						$.messager.alert('温馨提示', "请从新登录", 'info',function(){
							window.location.reload();
						});
					});
				});
			} else {
				$.messager.alert('温馨提示', data.msg, 'info');
			}
		}
	});
}
//取消
function cancel(){
	$("#pwd_dialog").dialog("close");
}