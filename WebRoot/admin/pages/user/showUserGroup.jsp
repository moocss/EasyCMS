<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<a href="group/v_add.do" class="btn" target="_self">添加</a>
			</div>
		</div>
		<div class="mod">
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
					<c:forEach var="flag" items="${groups}">
						<tr>
							<td><input type="checkbox" name="" id="" /></td>
							<td>${flag.id}</td>
							<td>${flag.name}</td>
							<td>${flag.allowPerDay}</td>
							<td>${flag.allowMaxFile}</td>
							<td>
								<input type="text" value="${flag.priority}" name="priority" maxlength="5"/> 
							</td>
							<td>
								<input type="radio" checked="checked" value="1" name="${flag.regDef}" />
							</td>
							<td>${flag.needCheck}</td>
							<td>${flag.needCaptcha}</td>
							<td class="tc">
								<a href="group/v_update.do?id=${flag.id}" class="btn" target="_self">修改</a> 
								<a href="group/o_delete.do?id=${flag.id}" class="btn" target="_self">删除</a>
							</td>
						</tr>
					</c:forEach>	
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
