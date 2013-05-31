<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
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
<title>会员管理添加</title>
<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">会员管理</a> -&gt; <span>添加</span>
			</div>
			<div class="action">
				<a href="#" class="btn">添加</a>
			</div>
		</div>
		<div class="mod">
			<div class="hd">
				<h2 class="tc">会员管理添加</h2>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
    		<table class="ui-table">
    			<thead>
    				<tr>
						<td>
							<input type="checkbox" name="" id="" />
						</td>
						<td>ID</td>
						<td>用户名</td>
						<td>电子邮箱</td>
						<td>会员组</td>
						<td>最后登录</td>
						<td>登录</td>
						<td>禁用</td>
						<td>操作选项</td>
    				</tr>
    			</thead>
    			<tbody>
    			<c:forEach var="flag" items="${pager.pageList}" varStatus="status">
    				<c:choose>
    					<c:when test="${status.index % 2 ==0 }">
    						<tr>
    					</c:when>
    					<c:otherwise>
    						<tr class="even">
    					</c:otherwise>
    				</c:choose>
    							<td><input type='checkbox' name='ck' value='${flag.id}' /></td>
								<td>${flag.id}</td>
								<td>${flag.username}</td>
								<td>${flag.email}</td>
								<td>${flag.group.name}</td>
								<td>${flag.lastLoginTime}</td>
								<td>${flag.loginCount}</td>
								<td>${flag.disabled}</td>
								<td>
									<a class="btn" href="member/v_update.do?id=${flag.id}">修改</a> | 
									<a class="btn" href="#">删除</a>
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
