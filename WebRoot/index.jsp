<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EasyCMS 首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<div class="login-box">
  		<form action="account/add" method="post">
  			<p>
  				<label for="username">用户名：</label>
  				<input type="text" id="username" name="username"/>
  			</p>
  			<p>
  				<label for="password">&emsp;密码：</label>
  				<input type="password" id="password" name="password"/>
  			</p>
  			<p>
  			<button type="submit">登录</button>
  			</p>
  		</form>
  	</div>
  	<p><a href="account/pager">用户列表</a></p>
  	<p><a href="admin/pages/index.jsp">后台</a></p>
  </body>
</html>
