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
	String url = basePath + "active_";
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
<link rel="stylesheet"
	href="https://at.alicdn.com/t/font_234130_nem7eskcrkpdgqfr.css">
<script type="text/javascript" src="<%=basePath %>public/js/my_loading.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
}

#schedule-box {
	width: 320px;
	margin: 0 auto;
	padding: 35px 20px;
	font-size: 13px;
}

.schedule-hd {
	display: flex;
	justify-content: space-between;
	padding: 0 15px;
}

.today {
	flex: 1;
	text-align: center;
}

.ul-box {
	overflow: hidden;
}

.ul-box>li {
	float: left;
	width: 14.28%;
	text-align: center;
	padding: 5px 0;
}

.other-month {
	color: #999999;
}

.current-month {
	color: #333333;
}

.today-style {
	border-radius: 50%;
	background: #58d321;
}

.arrow {
	cursor: pointer;
}

.dayStyle {
	display: inline-block;
	width: 35px;
	height: 35px;
	border-radius: 50%;
	text-align: center;
	line-height: 35px;
	cursor: pointer;
}

.current-month>.dayStyle:hover {
	background: #00BDFF;
	color: #ffffff;
}

.today-flag {
	background: #00C2B1;
	color: #fff;
}

.boxshaw {
	box-shadow: 2px 2px 15px 2px #e3e3e3;
}

.selected-style {
	background: #00BDFF;
	color: #ffffff;
}

#h3Ele {
	text-align: center;
	padding: 10px;
}
</style>
<script type="text/javascript">
		$(function() {
			$("a").click(function (){
			$("#loadingDialog").css("display", "block");
		});
		$.getJSON('<%=basePath%>public/json/city.json', function(result) {
			$.each(result, function(i, field) {
				var jsonArray = field.sort(function(a, b) {
					return a.localeCompare(b);
				});
				for (var i = 0; i < jsonArray.length; i++) {
					$("#province").append(
							"<option value='"+jsonArray[i]+"'>" + jsonArray[i]
									+ "</option>");
				}
			});
		});
		var isclickCb1 = false;
		var beginSchedule = new Schedule({
			el : '#schedule-box', //指定包裹元素（可选）
			clickCb : function(y, m, d) {
				isclickCb1 = true;
				$("#beginTime").val(y + '-' + m + '-' + d);
				$("#schedule-box").css("display", "none");
				isclickCb1 = false;
			},
			nextMonthCb : function(y, m, d) {
				isclickCb1 = false;
				console.log("nextMonthCb");
				$("#beginTime").val(y + '-' + m + '-' + d);
			},
			nextYeayCb : function(y, m, d) {
				isclickCb1 = false;
				console.log("nextYeayCb");
				$("#beginTime").val(y + '-' + m + '-' + d);
			},
			prevMonthCb : function(y, m, d) {
				isclickCb1 = false;
				console.log("prevMonthCb");
				$("#beginTime").val(y + '-' + m + '-' + d);
			},
			prevYearCb : function(y, m, d) {
				isclickCb1 = false;
				console.log("prevYearCb");
				$("#birthday").val(y + '-' + m + '-' + d);
			}
		});
		$("#beginTime").click(function() {
			$("#schedule-box").css("display", "block");
		});
		$("#beginTime").blur(function() {
			if ($(this).val().length != 0 && isclickCb1)
				$("#schedule-box").css("display", "none");
		});

		var isclickCb2 = false;
		var endSchedule = new Schedule({
			el : '#schedule-box2', //指定包裹元素（可选）
			clickCb : function(y, m, d) {
				isclickCb2 = true;
				$("#endTime").val(y + '-' + m + '-' + d);
				$("#schedule-box2").css("display", "none");
				isclickCb2 = false;
			},
			nextMonthCb : function(y, m, d) {
				isclickCb2 = false;
				console.log("nextMonthCb");
				$("#endTime").val(y + '-' + m + '-' + d);
			},
			nextYeayCb : function(y, m, d) {
				isclickCb2 = false;
				console.log("nextYeayCb");
				$("#beginTime").val(y + '-' + m + '-' + d);
			},
			prevMonthCb : function(y, m, d) {
				isclickCb2 = false;
				console.log("prevMonthCb");
				$("#endTime").val(y + '-' + m + '-' + d);
			},
			prevYearCb : function(y, m, d) {
				isclickCb2 = false;
				console.log("prevYearCb");
				$("#endTime").val(y + '-' + m + '-' + d);
			}
		});
		$("#endTime").click(function() {
			$("#schedule-box2").css("display", "block");
		});
		$("#endTime").blur(function() {
			if ($(this).val().length != 0 && isclickCb2)
				$("#schedule-box2").css("display", "none");
		});
	});
</script>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="#">活动管理</a></li>
		<li class="active">活动编辑</li>
	</ol>
	<div class="panelBox">
		<div class="title"></div>
		<div class="form">
			<form class="form-horizontal" role="form" action="<%=url%>save"
				method="post">
				<input type="hidden" name="active.id" id="id" value="${active.id}" />
				<input type="hidden" name="active.activityLongitude"
					value="${active.activityLongitude}" /> <input type="hidden"
					name="active.createTime" value="${active.createTime}" /> <input
					type="hidden" name="active.imagePaths" value="${active.imagePaths}" />
				<div class="form-group">
					<label for="userId" class="col-sm-2 control-label">创建人Id</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="userId"
							placeholder="请输入创建人Id" name="userId"
							value="${active.user.id}">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname1" class="col-sm-2 control-label">活动名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname1"
							placeholder="请输入活动名称" name="active.name" value="${active.name}">
					</div>
				</div>
				<div class="form-group">
					<label for="province" class="col-sm-2 control-label"><span
						id="check"></span>省份</label>
					<div class="col-sm-10">
						<select id="province" name="active.province" class="form-control"
							value="${active.province}">
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="firstname3" class="col-sm-2 control-label">集合地点</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname3"
							placeholder="请输入集合地点" name="active.collectionSite"
							value="${active.collectionSite}">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname4" class="col-sm-2 control-label">活动地点</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname4"
							placeholder="请输入活动地点" name="active.activitySite"
							value="${active.activitySite}">
					</div>
				</div>
				<div class="form-group">
					<label for="beginTime" class="col-sm-2 control-label">开始时间</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="beginTime"
							placeholder="请选择开始时间" readonly="readonly" name="active.beginTime"
							value="${active.beginTime}">
						<div id='schedule-box' style="display: none" class="boxshaw">

						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="endTime" class="col-sm-2 control-label">结束时间</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="endTime"
							placeholder="请选择结束时间" readonly="readonly" name="active.endTime"
							value="${active.endTime}">
						<div id='schedule-box2' style="display: none" class="boxshaw">

						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="firstname7" class="col-sm-2 control-label">最大人数</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstname7"
							placeholder="请输入最大人数" name="active.personMaxNum"
							value="${active.personMaxNum}">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname8" class="col-sm-2 control-label">描述</label>
					<div class="col-sm-10">
						<textarea type="text" class="form-control" id="firstname8"
							placeholder="请输入活动描述" name="active.description">${active.description}
						</textarea>
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