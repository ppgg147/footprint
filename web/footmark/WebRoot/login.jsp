<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>足迹-后台登录</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="<%=basePath %>public/img/foot.png"
	type="image/x-icon">
	<link rel="icon" href="<%=basePath %>public/img/foot.png"
	type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>public/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>public/css/login.css">
	<script type="text/javascript" src="<%=basePath %>public/js/md5.js"></script>
  </head>
  <body>
  <!-- 1296db  bfbfbf -->
  	<div class="box">
  		<div class="b_panel">
  			<div class="login_box">
				<div class="top">登录</div>
				<div class="input">
					<img src="<%=basePath %>public/img/user_select.png" />
					<input type="text" id="userName"  placeholder="用户名">
				</div>
				<div class="input">
					<img src="<%=basePath %>public/img/psw_select.png" />
					<input type="password" id="password"  placeholder="密码">
				</div>
				<div id="prompt">用户名不能为空</div>
				<input type="button" id="sumbit" value="登录">
			</div>
  		</div>
  	</div>
  	<script type="text/javascript" src="<%=basePath%>public/js/jquery-2.1.4.min.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$("#userName").focus();
  			//回车事件监听
  			$(document).keyup(function(event){
				  if(event.keyCode ==13){
				    $("#sumbit").trigger("click");
				  }
			});
  			$("#sumbit").click(function(){
  				var userName=$("#userName").val()+"";
  				if(userName==""){
  					$("#userName").focus();
  					$("#prompt").text('用户名不能为空');
  					$("#prompt").css("display","block");
  					return;
  				}
  				var password=$("#password").val()+"";
  				if(password==""){
  					$("#password").focus();
  					$("#prompt").text('密码不能为空');
  					$("#prompt").css("display","block");
  					return;
  				}
  				$("#sumbit").val("登录中");
  				password=hex_md5(password);
  				var data = {
					"mobilePhone": userName,
					"password": password
				};
  				$.ajax({
                type: "POST",
                url: "<%=basePath%>user_login",
                data: data,
                dataType: "json",
                success: function (data) {
                	 if(data.success){
                	 	$("#prompt").css("display","block");	
	                	 if(data.data.flag==66){
	                		$("#prompt").text('登录成功');		  					
							window.location.href='<%=basePath%>main';
	                	 }else {
	                	 	$("#userName").val('');
							$("#password").val('');
							$("#prompt").text("您暂未登录后台权限");
	                	 }						
					 } else {
						$("#userName").val('');
						$("#password").val('');
						$("#prompt").text(data.info);
	  					$("#prompt").css("display","block");
					}
					$("#sumbit").val("登录");
                },
                error: function (result, status) {
               		$("#prompt").text("网络错误");
                	$("#sumbit").val("登录");
                }
           		});
   			});
  		});
  	</script>
  </body>
</html>
