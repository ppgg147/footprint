<%@page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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
	int index = 1;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=basePath%>public/css/common.css">
<link rel="stylesheet"
	href="<%=basePath%>public/css/bootstrap.min.css">
<link
	href="<%=basePath%>public/css/font-awesome.min.css"
	rel="stylesheet">
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
	<div id="table">
		<table class="table table-hover  table-bordered"
			style="margin-bottom: 10px">
			<div class="action-bar">
				<ol class="breadcrumb" style="text-align: left;margin-bottom: 0px">
					<li><a id="test" href="#">用户管理</a></li>
					<li class="active">用户列表</li>
				</ol>
				<div id="serachBar">
					<form action="<%=url%>list" method="post">
						<div style="width: 400px;height: 30px;">
							<input type="text" class="form-control" name="serachStr"
								value="${serachStr}" placeholder="请输入您要搜索的内容...">
						</div>
					</form>
					<div class="right">
						<a href="<%=url%>list"
							style="margin-right: 10px;color: rgb(212, 106, 64);"> <span
							class="glyphicon glyphicon-refresh"></span>
						</a> <a href="<%=url%>edit" style="margin-right: 10px;"> <span
							class="glyphicon glyphicon-plus"></span>
						</a>
					</div>
				</div>
			</div>
			<thead>
				<tr>
					<th>序号</th>
					<th>ID</th>
					<th>电话号码</th>
					<th>真实姓名</th>
					<th>昵称</th>
					<th>地址</th>
					<th>性别</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="userList">
					<tr>
						<td><%=index++%></td>
						<td><s:property value="id" /></td>
						<td><s:property value="mobilePhone" /></td>
						<td><s:property value="realName" /></td>
						<td><s:property value="nickName" /></td>
						<td><s:property value="address" /></td>
						<td><s:property value="sex" /></td>

						<td><a href="<%=url%>edit?id=<s:property value='id'/>">修改</a>
							&nbsp;|&nbsp; <a
							href="<%=url%>delete?id=<s:property value='id'/>">删除</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<div class="footBox">
			<s:if test="totalCount>0">
				<ul class="pagination pagination-sm"
					style="margin: 0;padding-bottom: 30px;">
					<s:if test="pageNum==1">
						<li class="disabled"><a href="">&laquo;</a></li>
					</s:if>
					<s:else>
						<li><a href="<%=url%>list?pageNum=${pageNum-1}">&laquo;</a></li>
					</s:else>
					<c:forEach var="index" begin="1" end="${pageCount}">
						<c:if test="${(index==pageNum)}">
							<li class="active"><a href="<%=url%>list?pageNum=${index}">${index}</a></li>
						</c:if>
						<c:if test="${(index!=pageNum)}">
							<li><a href="<%=url%>list?pageNum=${index}">${index}</a></li>
						</c:if>
					</c:forEach>
					<s:if test="pageNum==pageCount">
						<li class="disabled"><a>&raquo;</a></li>
					</s:if>
					<s:else>
						<li><a href="<%=url%>list?pageNum=${pageNum+1}">&raquo;</a></li>
					</s:else>
				</ul>
			</s:if>
			<s:else>
				<div style="width: 100%;text-align: center;">
				<img alt="无数据" width="100px" height="100px" src="<%=basePath%>public/img/nodata.png">
						<br/>暂无数据</div>
			</s:else>
		</div>
	</div>
</body>
</html>