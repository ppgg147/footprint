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
<script type="text/javascript" src="<%=basePath %>public/js/my_loading.js"></script>
<script type="text/javascript">
$(function (){
	$("a").click(function (){
		$("#loadingDialog").css("display", "block");
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