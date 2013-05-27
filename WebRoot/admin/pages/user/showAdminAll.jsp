<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN" xml:lang="zh-CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员（全站）列表</title>
<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">管理员（全站）</a> -&gt; <span>列表</span>
			</div>
			<div class="action">
				<a href="#" class="btn">添加</a>
			</div>
		</div>
		<div class="mod">
			<div class="hd">
				<h2 class="tc">管理员（全站）列表</h2>
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
							<th>站点</th>
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
								test1 (test)
							</td>
							<td>
								JEECMS主站
							</td>
							<td>jeecms子站信息发布组</td>
							<td>8</td>
							<td>2013-05-27 11:29:22<br>116.205.74.250</td>
							<td>30511</td>
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
