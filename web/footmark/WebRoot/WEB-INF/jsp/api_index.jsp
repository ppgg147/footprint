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
<title>移动端接口列表</title>
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
		<label class="logo1">足迹</label><label class="logo2">移动端接口列表</label>
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
				<li><a href="#model" data-toggle="tab">Model</a></li>
			</ul>
		</div>
		<div style="text-align: center;color: red;margin: 10px;">
			<a href="<%= basePath%>test" style="color:red;">测试页面</a>
		</div>
		
		<div id="myTabContent" class="tab-content" style="margin-top: 50px;">
			<!-- 用户 -->
			<div class="tab-pane fade in active" id="user">
				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>客户登录</h2>
						</p>
						路径：<small>/user_login</small> 参数：
						<pre>
mobilePhone :手机号
password：密码(需MD5加密)
                    </pre>
						返回值：
						<pre>
Json(new { success=true, data = new { User = User}, info = info  })
Json(new { success=false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>

				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>注册</h2>
						</p>
						路径：<small>/user_regist</small> 参数：
						<pre>
mobilePhone :手机号
password:密码(需MD5加密)
                    </pre>
						返回值：
						<pre>
Json(new { success=true, data = new { User = User}, info = info  })
Json(new { success=false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>

				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>获取个人信息</h2>
						</p>
						路径：<small>/user_info</small> 参数：
						<pre>
mobilePhone :手机号
token：Token
                    </pre>
						返回值：
						<pre>
Json(new { success=true, data = new { User = User}, info = info  })
Json(new { success=false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>

				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>更新头像</h2>
						</p>
						路径：<small>/user_updateHead</small> 参数：
						<pre>
mobilePhone :手机号
file:图片file
token:token值
                    </pre>
						返回值：
						<pre>
Json(new { success=true, data = new { User = User}, info = info  })
Json(new { success=false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>

				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>更新个人信息</h2>
						</p>
						路径：<small>/user_update</small> 参数：
						<pre>
mobilePhone :手机号
token：Token
nickName：昵称
realName;真实姓名
sex;性别
age;年龄
qq;QQ
email;邮箱
individualSignature;个性签名
                    </pre>
						返回值：
						<pre>
Json(new { success=true, data = new { User = User}, info = info  })
Json(new { success=false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>
			</div>

			<!-- 活动 -->
			<div class="tab-pane fade" id="active">
				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>获取活动列表(分页)</h2>
						</p>
						路径：<small>/active_api_list</small> 参数：
						<pre>
from：数据开始加载下标
pagerCount:数据加载的长度  
token：token
                    </pre>
						返回值：
						<pre>
Json(new { success = true, data = new { modelList  = modelList}, info = info  })
Json(new { success = false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>

				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>添加</h2>
						</p>
						路径：<small>/active_add</small> 参数：
						<pre>
mobilePhone://手机号
token://token
name;//活动名称
province;//省份
collectionSite;//集合地点
activitySite;//活动地点
beginTime;//开始时间
endTime;//结束时间
personMaxNum;//最大人数
activityLongitude;//活动地点经度
activityLatitude;//活动地点纬度
description;//描述
imagePaths;//图片路径（用 ‘ ; ‘ 分隔）
                    </pre>
						返回值：
						<pre>
Json(new { success = true, data = new { active  = active}, info = info  })
Json(new { success = false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>

				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>上传图片</h2>
						</p>
						路径：<small>/active_uploadpic</small> 参数：
						<pre>
mobilePhone :手机号
token:token值
picture:Base64位图片字符串
                    </pre>
						返回值：
						<pre>
Json(new { success = true, data = new { model  = model}, info = info  })
Json(new { success = false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>
				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>获取活动详细信息</h2>
						</p>
						路径：<small>/active_info</small> 参数：
						<pre>
mobilePhone :手机号
token:token值
id :id
userId:创建人（Active模型中）
                    </pre>
						返回值：
						<pre>
Json(new { success = true, data = new { model  = model}, info = info  })
Json(new { success = false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>
				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>申请加入活动</h2>
						</p>
						路径：<small>/group_adduser</small> 参数：
						<pre>
mobilePhone :手机号
token:token值
activeId :活动Id
                    </pre>
						返回值：
						<pre>
Json(new { success = true, data = new { group  = group}, info = info  })
Json(new { success = false, data = new { info = info } });
                    </pre>
					</blockquote>
				</div>
			</div>

			<div class="tab-pane fade" id="group"></div>

			<div class="tab-pane fade" id="groupMember"></div>

			<div class="tab-pane fade" id="notice"></div>
			<!-- 模型展示 -->
			<div class="tab-pane fade" id="model">
				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>User(用户)</h2>
						</p>
						<pre>
private Integer id=0;// /自增Id
private String mobilePhone;// 手机号（登录Id）(唯一)
private int flag=0;//是否是管理员(66为管理员)
private String uuid;// 环信Id
private String password;// 登录密码
private String headPicture;// 头像（存储路径）
private String nickName;// 昵称
private String realName;// 真实姓名
private String sex;// 性别
private String birthday;// 生日
private String address;// 地址
private String email;// 邮箱
private Date lastLoginTime;// 上次登录时间
private Date registerTime;// 注册时间
private String token;// Token
private String individualSignature;// 个性签名
private Integer currentlyActiveId=0;// 当前活动Id
                    </pre>
					</blockquote>
				</div>

				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>Active(活动)</h2>
						</p>
						<pre>
private Integer id=0;//iD自增
private String name;//活动名称
private String province;//省份
private String collectionSite;//集合地点
private String activitySite;//活动地点
private Date beginTime;//开始时间
private Date endTime;//结束时间
private int personMaxNum;//最大人数
private double activityLongitude;//活动地点经度
private double activityLatitude;//活动地点经度
private String description;//描述
private String imagePaths;//图片路径（用 ‘ ; ‘ 分隔）
private Date createTime;//创建时间
private User user;//创建人
                    </pre>
					</blockquote>
				</div>

				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>Group(群组)</h2>
						</p>
						<pre>
private Integer sqlId;//自增Id	
private String headpicture;//群头像（存储路径）
private String id;//群组 ID，群组唯一标识符，由环信服务器生成
private String name;//群名称	
private boolean Public;//群组类型：true：公开群，false：私有群。	
private boolean membersonly;//是否只有群成员可以进来发言。true：是，false：否
private boolean allowinvites;//是否允许群成员邀请别人加入此群
private Integer maxusers;//群成员上限
private Integer affiliations_count;//现有成员总数
private String owner;//群主的环信 Id
private Date createTime;//创建
private String description;//群描述
private boolean invite_need_confirm;//邀请加群，被邀请人是否需要确认
private Integer refreshSecond;//刷新时间间隔（秒）
private Integer activeId;//对应的活动Id
                    </pre>
					</blockquote>
				</div>
				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>Notice(公告)</h2>
						</p>
						<pre>
private int id;//
private Integer groupId;//群号
private String name;//公告名称
private String content;//公告内容
private String createTime;//创建时间
                    </pre>
					</blockquote>
				</div>
				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>GroupMember(群组成员)</h2>
						</p>
						<pre>
private Integer id;
private Integer groupId;//群组Id
private Integer userId;//用户Id
private Date joinTime;//时间（加入时间）
private String states;//状态（未审核、通过、不通过）
private String statesIntroduce;//状态说明
private Date checkTime;//审核时间
                    </pre>
					</blockquote>
				</div>
				<div class="col-xs-6">
					<blockquote>
						<p>
							<h2>Trail(位置信息)</h2>
						</p>
						<pre>
private Integer id;//自增ID
private Integer groupId;//群组Id
private Integer userId;//用户Id
private String longitude;//经度
private String latitude;//维度
private Date createTime;//创建地点的时间
                    </pre>
					</blockquote>
				</div>
			</div>
		</div>
	</div>
</body>
</html>