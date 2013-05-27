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
<title>角色添加</title>
<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">角色管理</a> -&gt; <span>列表</span>
			</div>
			<div class="action">
				<a href="#" class="btn">添加</a>
			</div>
		</div>
		<div class="mod">
			<div class="hd">
				<h2 class="tc">角色管理列表</h2>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
				<table class="ui-table">
					<thead>
						<tr>
							<th width="20">
								<input type="checkbox" name="" id="" />
							</th>
							<th>ID</th>
							<th>角色名</th>
							<th>排列顺序</th>
							<th>操作选项</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="checkbox" value="2" name="ids"/>
							</td>
							<td>2</td>
							<td>信息发布员角色</td>
							<td>1</td>
							<td>
								<a class="btn" href="#">修改</a>
								<a class="btn" href="#">删除</a>
								<a class="btn" href="#">成员管理</a>
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
