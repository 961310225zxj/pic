<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="/static/mystyle/style.css" rel='stylesheet' type='text/css' />
    <!--webfonts-->
   
<title>小码哥客户关系管理系统</title>
<link rel="stylesheet" href="/static/mystyle/style.css">
<script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script> 
<script type="text/javascript">
	function submitForm(){
		if($("[name='username']").val()&&$("[name='password']").val()){
			$("form").submit();
		}
	}
	
	//按回车键直接提交表单
	$(document).keyup(function(event){
		//判断是否是回车键
		if(event.keyCode==13){
			//提交表单
			submitForm();
		}
	});
	$(function(){
		//判断是否有错误信息
		var msg = '${errorMsg}';
		if(msg){
			alert(msg);
		}
	})

</script>
</head>

<body style="overflow: scroll;overflow-y:hidden">
<script>
    $(document).ready(function(c) {
    $('.close').on('click', function(c){
        $('.login-form').fadeOut('slow', function(c){
            $('.login-form').remove();
        });
    });
});
</script>
<!--SIGN UP-->

<%--<h4>PICC保险集团</h4>--%>
<div class="login-form" style="margin-top:50px;">
    <div class="close"> </div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div class="avtar">
        <img src="/static/image/avtar.png" />
    </div>
    <form method="post" action="/login.do">

        <input type="text" class="text" value="用户名" name="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}" >
        <div >
            <input type="password" value="Password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        </div>
    </form>
    <div class="signin">
        <input type="submit" value="Login" onclick="submitForm()">
    </div>
</div>
<div class="copy-rights">
    <p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.mycodes.net/" target="_blank" title="十四期java大神班">十四期java大神班</a></p>
</div>
<script type="text/javascript">

</script>
 </body>
</html>