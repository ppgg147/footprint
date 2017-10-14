<%@page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Object IsLog = request.getSession().getAttribute("isLogin");
	Object nickName=request.getSession().getAttribute("nickName"); 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>足迹-后台管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests"> <!--安全链接-->
<meta http-equiv="description" content="This is my page">
<!-- favicon -->
<link rel="shortcut icon" href="<%=basePath %>public/img/foot.png"
	type="image/x-icon">
	<link rel="icon" href="<%=basePath %>public/img/foot.png"
	type="image/x-icon">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>public/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>public/css/loading.css">	
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>public/css/main.css">
<link rel="stylesheet" href="<%=basePath%>public/css/common.css">
<script type="text/javascript"
	src="<%=basePath%>public/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		if(!<%=IsLog%>){			
			window.location.href='<%=basePath%>index';
		}
		$(".menuBar").click(function() {
			$(this).addClass("list") //给当前元素添加"current"样式
			.next().show() //下一个元素显示
			.parent().siblings().children("a").removeClass("list")
			//父元素的兄弟元素的子元素<a>移除"current"样式
			.next().hide(); //它们的下一个元素隐藏
			return false;
		});
	});
</script>
</head>
<body>
	<div id="header">
			<div class="left"><label class="logo1">足迹</label><label class="logo2">后台管理系统</label></div>
			<div class="hright">
				<div class="top">
					<p><%=nickName %></p>
					<a>修改密码</a>
				</div>
				<div class="bottom">
					<a href="<%=basePath %>user_quit">退出登录</a>
				</div>
			</div>
		</div>
	<div id="box">	
		<div id="menu">
			<ul>
				<li class="home">
					<a href="javascript:clickMenu('<%=basePath%>welcome');">首页</a>
				</li>
				<li class="user"><a class="menuBar" href="javascript:void(0)">用户管理</a>
					<ul class="none">
						<li class="right"><a href="javascript:clickMenu('<%=basePath%>user_list');">用户列表</a></li>
					</ul>
				</li>
				<li class="active"><a class="menuBar" href="javascript:void(0)">活动管理</a>
					<ul class="none">
						<li class="right"><a href="javascript:clickMenu('<%=basePath%>active_list');">活动列表</a></li>
					</ul>
				</li>
				<li class="group"><a class="menuBar" href="javascript:void(0)">群组管理</a>
					<ul class="none">
						<li class="right"><a href="javascript:clickMenu('<%=basePath%>group_list');">群组列表</a></li>
					</ul>
				</li>
				<li class="notice"><a class="menuBar" href="javascript:void(0)">群公告管理</a>
					<ul class="none">
						<li class="right"><a href="javascript:clickMenu('<%=basePath%>notice_list');">群公告列表</a></li>
					</ul>
				</li>
				<li class="taril"><a class="menuBar" href="javascript:void(0)">轨迹管理</a>
					<ul class="none">
						<li class="right"><a href="javascript:clickMenu('<%=basePath%>quota/list');">轨迹列表</a></li>
					</ul>
				</li>
				<li class="map"><a class="menuBar" href="javascript:void(0)">地图管理</a>
					<ul class="none">
						<li class="right"><a href="javascript:clickMenu('<%=basePath%>map');">地图管理</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="content">
			<iframe id="iframe" width="100%" style="border: 0px;" height="100%;"
				frameborder="0" scrolling="auto" src="<%=basePath%>welcome"></iframe>
			<div id="loadingDialog">
			  <div class="double-bounce1"></div>
			  <div class="double-bounce2"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function clickMenu(url) {
			$("#loadingDialog").css("display", "block");
			$('#iframe').attr('src', url);
		}
		$(document).ready(function(e){    
    	 	var iframe =document.getElementById("iframe");      
	        if (iframe.attachEvent) {    
	        	//加载完成  
	            iframe.attachEvent("onload", function() {      
	            	$("#loadingDialog").css("display", "none");
	            });      
	        } else {      
	            iframe.onload = function() {      
	            	$("#loadingDialog").css("display", "none");
	            };      
	        }    
	    });
	</script>
</body>
</html>