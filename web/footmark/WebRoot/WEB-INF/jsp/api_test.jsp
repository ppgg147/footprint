<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>移动端接口测试页面</title>
<link rel="shortcut icon" href="<%=basePath%>public/img/foot.png"
	type="image/x-icon" />
<link rel="icon" href="<%=basePath%>public/img/foot.png"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>public/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>public/css/api.css" />
<script type="text/javascript"
	src="<%=basePath%>public/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>public/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="title">
		<label class="logo1">足迹</label><label class="logo2">移动端接口测试页面</label>
	</div>
	<div style="margin: 20px;">
		<div class="notice">
			<p>success:请求是否成功 &nbsp;&nbsp;data:返回数据实体&nbsp;&nbsp;
				datas:返回数据实体数组&nbsp;&nbsp;info:反馈信息</p>
		</div>
		<div>
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#user" data-toggle="tab">User</a></li>
				<li><a href="#active" data-toggle="tab">Active</a></li>
				<li><a href="#group" data-toggle="tab">Group</a></li>
				<li><a href="#groupMember" data-toggle="tab">GroupMember</a></li>
				<li><a href="#notice" data-toggle="tab">Notice</a></li>
			</ul>
		</div>
		<div style="text-align: left;color: red;margin: 10px;">
			<a href="<%=basePath%>api" style="color:red;">返回接口列表页面</a>
		</div>

		<div id="myTabContent" class="tab-content" style="margin-top: 50px;">
			<!-- 用户 -->
			<div class="tab-pane fade in active" id="user">
				<div class="panel panel-success"
					style="width: 30%;padding-top: 0px;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">登录页面</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							action="user_login" method="post">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">mobilePhone</span> <input
									type="text" name="mobilePhone" class="form-control"
									placeholder="手机号码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">password</span> <input
									type="text" name="password" class="form-control"
									placeholder="密码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>
				<!-- 登录 -->
				<div class="panel panel-success"
					style="width: 30%;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">注册</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							action="user_regist" method="post">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">mobilePhone</span> <input
									type="text" name="mobilePhone" class="form-control"
									placeholder="手机号码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">password</span> <input
									type="text" name="password" class="form-control"
									placeholder="密码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>

				<div class="panel panel-success"
					style="width: 30%;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">获取个人信息</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							action="user_info" method="post">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">mobilePhone</span> <input
									type="text" name="mobilePhone" class="form-control"
									placeholder="手机号码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">token</span> <input type="text"
									name="token" class="form-control" placeholder="token">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>
				<div class="panel panel-success"
					style="width: 30%;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">更新头像</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							enctype="multipart/form-data" action="user_updateHead"
							method="post">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">mobilePhone</span> <input
									type="text" name="mobilePhone" class="form-control"
									placeholder="手机号码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">token</span> <input type="text"
									name="token" class="form-control" placeholder="Token">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">file</span> <input type="file"
									name="file" class="form-control" placeholder="文件">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>

				<div class="panel panel-success"
					style="width: 30%;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">更新个人信息</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							action="user_update" method="post">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">mobilePhone</span> <input
									type="text" name="MobilePhone" class="form-control"
									placeholder="手机号码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">token</span> <input type="text"
									name="token" class="form-control" placeholder="Token">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">nickName</span> <input
									type="text" name="nickName" class="form-control"
									placeholder="昵称">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">sex</span> <input type="text"
									name="sex" class="form-control" placeholder="性别">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">realName</span> <input
									type="text" name="realName" class="form-control"
									placeholder="真实姓名">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">birthday</span> <input
									type="text" name="birthday" class="form-control"
									placeholder="生日（日期）">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">address</span> <input
									type="text" name="address" class="form-control"
									placeholder="地址">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">age</span> <input type="text"
									name="age" class="form-control" placeholder="年龄">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">email</span> <input type="text"
									name="email" class="form-control" placeholder="邮箱">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">individualSignature</span> <input
									type="text" name="individualSignature" class="form-control"
									placeholder="个性签名">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>
			</div>

			<!-- 活动 -->
			<div class="tab-pane fade" id="active">
				<div class="panel panel-success"
					style="width: 30%;padding-top: 0px;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">获取活动列表（分页）</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							action="active_api_list" method="post">							
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">province</span> <input
									type="text" name="province" class="form-control"
									placeholder="省份">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">from</span> <input type="text"
									name="from" class="form-control" placeholder="数据开始加载下标">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">pagerCount</span> <input
									type="text" name="pagerCount" class="form-control"
									placeholder="数据加载的长度">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>
				<!--添加活动-->
				<div class="panel panel-success"
					style="width: 30%;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">添加活动</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							action="active_add" method="post">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">mobilePhone</span> <input
									type="text" name="mobilePhone" class="form-control"
									placeholder="手机号码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">token</span> <input type="text"
									name="token" class="form-control" placeholder="token">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">name</span> <input type="text"
									name="name" class="form-control" placeholder="活动名称">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">province</span> <input
									type="text" name="province" class="form-control"
									placeholder="省份">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">collectionSite</span> <input
									type="text" name="collectionSite" class="form-control"
									placeholder="集合地点">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">activitySite</span> <input
									type="text" name="activitySite" class="form-control"
									placeholder="活动地点">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">beginTime</span> <input
									type="text" name="beginTime" class="form-control"
									placeholder="开始时间">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">endTime</span> <input
									type="text" name="endTime" class="form-control"
									placeholder="结束时间">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">personMaxNum</span> <input
									type="text" name="personMaxNum" class="form-control"
									placeholder="最大人数">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">activityLongitude</span> <input
									type="text" name="activityLongitude" class="form-control"
									placeholder="活动地点经度">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">activityLatitude</span> <input
									type="text" name="activityLatitude" class="form-control"
									placeholder="活动地点纬度">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">description</span> <input
									type="text" name="description" class="form-control"
									placeholder="描述">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">imagePaths</span> <input
									type="text" name="imagePaths" class="form-control"
									placeholder="图片路径（用 ‘ ; ‘ 分隔）">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>

				<div class="panel panel-success"
					style="width: 30%;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">上传图片</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							enctype="multipart/form-data" action="api_active_uploadpic"
							method="post">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">mobilePhone</span> <input
									type="text" name="mobilePhone" class="form-control"
									placeholder="手机号码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">token</span> <input type="text"
									name="token" class="form-control" placeholder="Token">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">fileName</span> <input
									type="text" name="fileName" class="form-control"
									placeholder="图片名">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">picture</span> <input
									type="text" name="picture" class="form-control"
									placeholder="base64">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>

				<div class="panel panel-success"
					style="width: 30%;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">根据Id获取活动信息</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							enctype="multipart/form-data" action="active_info"
							method="post">		
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">id</span> <input type="text"
									name="id" class="form-control" placeholder="活动Id">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>
				<div class="panel panel-success"
					style="width: 30%;float: left;margin: 20px;">
					<div class="panel-heading">
						<h5 class="panel-title">申请加入活动</h5>
					</div>
					<div class="panel-body">
						<form class="bs-example bs-example-form" role="form"
							enctype="multipart/form-data" action="api_group_adduser"
							method="post">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">mobilePhone</span> <input
									type="text" name="mobilePhone" class="form-control"
									placeholder="手机号码">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">token</span> <input type="text"
									name="token" class="form-control" placeholder="Token">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<span class="input-group-addon">activeId</span> <input
									type="text" name="activeId" class="form-control"
									placeholder="活动Id">
							</div>
							<div class="input-group input-group-sm" style="padding-top: 5px;">
								<input type="submit" value="提交" class="form-control">
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="tab-pane fade" id="group"></div>

			<div class="tab-pane fade" id="groupMember"></div>

			<div class="tab-pane fade" id="notice"></div>
		</div>
	</div>
</body>
</html>