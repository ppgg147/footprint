<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>  
<html>  
<head>  
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />  
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<title>Hello, World</title>  
<style type="text/css">  
html{height:100%}  
body{height:100%;margin:0px;padding:0px}  
#container{height:100%}  
</style>  
<!--  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=fYXCDab86mqTtviERFhRMkTThZaGndlO">
//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=fYXCDab86mqTtviERFhRMkTThZaGndlO"
//v1.4版本及以前版本的引用方式：src="http://api.map.baidu.com/api?v=1.4&key=您的密钥&callback=initialize"
</script>
-->
</head>  
 
<body>  
<div id="container"></div> 


<script type="text/javascript"> 

	//百度地图API功能
	function loadJScript() {
		var script = document.createElement("script");
		script.type = "text/javascript";
		script.src = "http://api.map.baidu.com/api?v=2.0&ak=fYXCDab86mqTtviERFhRMkTThZaGndlO&callback=init";
		document.body.appendChild(script);
	}
	function init() {
		var map = new BMap.Map("container");          // 创建地图实例                  
		map.centerAndZoom(new BMap.Point(106.536181, 29.464136), 16);    // 初始化地图，设置中心点坐标和地图级别
		map.addControl(new BMap.NavigationControl()); 
		var point = new BMap.Point(106.536181, 29.464136);   
		var marker = new BMap.Marker(point);        // 创建标注    
		map.addOverlay(marker);    
//		var map = new BMap.Map("allmap");            // 创建Map实例
//		var point = new BMap.Point(116.404, 39.915); // 创建点坐标                
		map.enableScrollWheelZoom();                 //启用滚轮放大缩小
		
	}  
	window.onload = loadJScript;  //异步加载地图
</script>  
</body>  
</html>
