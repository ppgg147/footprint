<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String url = basePath + "user_";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=basePath%>public/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>public/css/common.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>public/css/loading.css">	
<script src="<%=basePath%>public/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>public/js/bootstrap.min.js"></script>
<script src="<%=basePath%>public/js/schedule.js"></script>
	<link rel="stylesheet" href="https://at.alicdn.com/t/font_234130_nem7eskcrkpdgqfr.css">
	<style>
		*{
			margin: 0;
			padding: 0;
		}
		ul{
			list-style: none;
		}
		#schedule-box{
			width: 320px;
			margin: 0 auto;
			padding: 35px 20px;
			font-size: 13px;
		}
		.schedule-hd{
			display: flex;
			justify-content: space-between;
			padding: 0 15px;
		}
		.today{
			flex: 1;
			text-align: center;
		}
		.ul-box{
			overflow: hidden;
		}
		.ul-box > li{
			float: left;
			width: 14.28%;
			text-align: center;
			padding: 5px 0;
		}
		.other-month{
			color: #999999;
		}
		.current-month{
			color: #333333;
		}
		.today-style{
			border-radius: 50%;
			background: #58d321;
		}
		.arrow{
			cursor: pointer;
		}
		.dayStyle{
			display: inline-block;
			width: 35px;
			height: 35px;
			border-radius: 50%;
			text-align: center;
			line-height: 35px;
			cursor: pointer;
		}
		.current-month > .dayStyle:hover{
			background: #00BDFF;
			color: #ffffff;
		}
		.today-flag{
			background: #00C2B1;
			color: #fff;
		}
		.boxshaw{
			box-shadow: 2px 2px 15px 2px #e3e3e3;
		}
		.selected-style {
			background: #00BDFF;
			color: #ffffff;
		}
		#h3Ele{
			text-align: center;
			padding: 10px;
		}
	</style>

<script type="text/javascript" src="<%=basePath %>public/js/my_loading.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(function (){
			$("#loadingDialog").css("display", "block");
		});
		if($("#sex").val()=="女"){
			$("#sexWoman").attr("checked",true);
		}
		var isclickCb=false;
		var mySchedule = new Schedule({
		    el: '#schedule-box', //指定包裹元素（可选）
		    clickCb: function (y,m,d) {
		    	isclickCb=true;
		    	console.log("clickCb");
		    	$("#birthday").val(y+'-'+m+'-'+d);
		    	$("#schedule-box").css("display","none");
		    	isclickCb=false;
			},
			nextMonthCb: function (y,m,d) {
				isclickCb=false;
				console.log("nextMonthCb");
				$("#birthday").val(y+'-'+m+'-'+d);
			},
			nextYeayCb: function (y,m,d) {
				isclickCb=false;
				console.log("nextYeayCb");
				$("#birthday").val(y+'-'+m+'-'+d);
			},
			prevMonthCb: function (y,m,d) {
				isclickCb=false;
				console.log("prevMonthCb");
				$("#birthday").val(y+'-'+m+'-'+d);
			},
			prevYearCb: function (y,m,d) {
				isclickCb=false;
				console.log("prevYearCb");	
				$("#birthday").val(y+'-'+m+'-'+d);	
			}
		});
		$("#birthday").click(function(){
			$("#schedule-box").css("display","block");
		});
		$("#birthday").blur(function() {
			if($(this).val().length!=0&&isclickCb)
			$("#schedule-box").css("display","none");
		});
		$('#mobilePhone').bind('input propertychange', function() {		
			 $(this).css("background-color","");	
			if($(this).val().length==11){
				var myreg = /^(((13[0-9]{1})|(17[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
				if(!myreg.test($(this).val())) { 
				    $("#check").css("color","red");
				    $(this).focus();
				    $("#check").html("(*格式错误)");
				    $(this).css("background-color","#ffffcc");
				    return false; 
				} 
				var data = {
					"mobilePhone": $(this).val()
				};
				$.ajax({
		            type: "POST",
		            url: "<%=url%>check",
									data : data,
									dataType : "json",
									success : function(data) {
										if (data.success) {
											$("#check").css("color", "green");
											$("#check").html("(*可用)");
										} else {
											$("#check").css("color", "red");
											$("#check").html("(*已被注册)");
											alert(data.info);
										}
									},
									error : function(result, status) {
									}
								});
							}
						});
		$("#mobilePhone").blur(function() {
			if ($(this).val().length != 11) {
				 $("#check").css("color","red");
				 $(this).focus();
				 $("#check").html("(*格式错误)");
				 $(this).css("background-color","#ffffcc");
			}
		});
	});
</script>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="#">用户管理</a></li>
		<li class="active">用户编辑</li>
	</ol>
	<div class="panelBox">
		<div class="title"></div>
		<div class="form">
			<form class="form-horizontal" role="form" action="<%=url%>save"
				method="post">
				<input type="hidden" name="user.id" id="mT_User" value="${user.id}" />
				<input type="hidden" id="sex" value="${user.sex}" />
				<input type="hidden" name="user.password" value="${user.password}" />
				<input type="hidden" name="user.token" value="${user.token}" /> <input
					type="hidden" name="user.headPicture" value="${user.headPicture}" />
				<input type="hidden" name="user.registerTime"
					value="${user.registerTime}" /> <input type="hidden"
					name="user.currentlyActiveId" value="${user.currentlyActiveId}" />
				<input type="hidden" name="user.lastLoginTime"
					value="${user.lastLoginTime}" />

				<div class="form-group">
					<label for="firstname1" class="col-sm-2 control-label">昵称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname1"
							placeholder="请输入昵称" name="user.nickName" value="${user.nickName}">
					</div>
				</div>
				<div class="form-group">
					<label for="mobilePhone" class="col-sm-2 control-label"><span
						id="check"></span>手机号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" maxlength="11" id="mobilePhone"
							placeholder="请输入手机号码"  name="user.mobilePhone"
							value="${user.mobilePhone}">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname3" class="col-sm-2 control-label">地址</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname3"
							placeholder="请输入地址" name="user.address" value="${user.address}">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname4" class="col-sm-2 control-label">性别</label>
					<div class="col-sm-10">					
						<label class="radio-inline">
				       	 <input type="radio" name="user.sex" id="sexMax" value="男" checked>男
					    </label>
					    <label class="radio-inline">
					        <input type="radio" name="user.sex" id="sexWoman"  value="女">女
					    </label>						
					</div>
				</div>
				<div class="form-group">
					<label for="firstname5" class="col-sm-2 control-label">真实姓名</label>
					<div class="col-sm-10">					
						<input type="text" class="form-control" id="firstname5"
							placeholder="请输入姓名" name="user.realName" value="${user.realName}">
					</div>
				</div>
				<div class="form-group">
					<label for="birthday" class="col-sm-2 control-label">生日（日期）</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="birthday"
							placeholder="请选择生日日期" readonly="readonly" name="user.birthday"
							value="${user.birthday}">
						<div id='schedule-box' style="display: none" class="boxshaw">
		
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="firstname7" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname7"
							placeholder="请输入邮箱" name="user.email" value="${user.email}">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname8" class="col-sm-2 control-label">个性签名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname8"
							placeholder="请输入个性签名" name="user.individualSignature"
							value="${user.individualSignature}">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-sm">提交</button>
						<button type="button" style="margin-left: 20px;"
							onclick="javascript:history.go(-1);"
							class="btn btn-default btn-sm">返回</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>