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
<title>管理员（全站）</title>
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
				<h2 class="tc">会员列表</h2>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
				<table class="ui-table">
					<thead>
						<tr>
							<th><input type="checkbox" name="" id="" /></th>
							<th>ID</th>
							<th>名称</th>
							<th>每日附件总尺寸</th>
							<th>最大附件尺寸</th>
							<th>排列顺序</th>
							<th>默认组</th>
							<th>评论需要审核</th>
							<th>评论需要验证码</th>
							<th>操作选项</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" name="" id="" /></td>
							<td>1</td>
							<td>普通会员</td>
							<td>4096 KB</td>
							<td>1024 KB</td>
							<td><input type="text" value="10" name="priority" /> <input
								type="hidden" value="1" name="wids" /></td>
							<td><input type="radio" checked="checked" value="1"
								name="regDefId" /></td>
							<td>是</td>
							<td>是</td>
							<td><a href="#" class="btn">修改</a> <a href="#" class="btn">删除</a>
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
