<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html>
<!--[if IE 6]><html class="ie6 lte9 lte8 lte7" lang="zh-CN"><![endif]-->
<!--[if IE 8]><html class="ie8 lte9 lte8" lang="zh-CN"><![endif]-->
<!--[if IE 9]><html class="ie9 lte9" lang="zh-CN"><![endif]-->
<!--[if IE 7]><html class="ie7 lte9 lte8 lte7" lang="zh-CN"><![endif]-->
<!--[if !(IE 6) | !(IE 7) | !(IE 8) | !(IE 9)  ]><!--><html lang="zh-CN"><!--<![endif]-->
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理员（本站）列表</title>
	<link rel="stylesheet" type="text/css" href="admin/assets/css/base.css" />
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">管理员（本站）</a> -&gt; <span>列表</span>
			</div>
			<div class="action">
				<a href="#" class="btn">添加</a>
			</div>
		</div>
		<div class="mod">
			<div class="hd">
				<h2 class="tc">管理员（本站）列表</h2>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
				<table class="ui-table">
					<thead class="pn-lthead">
						<tr>
							<th>
								<input type="checkbox" name="" id="" />
							</th>
							<th>ID</th>
							<th>用户名</th>
							<th>角色</th>
							<th>会员组</th>
							<th>等级</th>
							<th>最后登录</th>
							<th>登录</th>
							<th>禁用</th>
							<th>操作选项</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="checkbox" value="40" name="ids"/>
							</td>
							<td>40</td>
							<td>
								test1(test)
							</td>
							<td>测试角色</td>
							<td>jeecms子站信息发布组</td>
							<td>8</td>
							<td>2013-05-27 11:35:14<br>110.189.88.231</td>
							<td>30512</td>
							<td>否</td>
							<td>
								<a class="btn" href="#">修改</a> 
								<a class="btn" href="#">删除</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- /.mod-bd -->
			<div class="ft"></div>
			<!-- /.mod-ft -->
		</div>
		<!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>
