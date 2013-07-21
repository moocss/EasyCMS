<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>EasyCMS 用户登录</title>
	<link type="text/css" rel="stylesheet" href="admin/assets/css/style.css"/>
  </head>
  
  <body>
  	<div class="login-box">
  		<form action="member/login.do" method="post">
  			<p>
  				<label for="username">用户名：</label>
  				<input type="text" id="username" name="username"/>
  			</p>
  			<p>
  				<label for="password">&emsp;密码：</label>
  				<input type="password" id="password" name="password"/>
  			</p>
  			<p>
  				<label for="password">&emsp;验证码：</label>
  				<input type="text" maxlength="4" id="verifyCode" name="verifyCode"/>
  				<img id="img_vcode" alt="..." src="captcha?complexity=99&size=36&length=4" width="80" height="36"/>
            	<script language='javascript'>function _rvi(){document.getElementById('img_vcode').src = 'captcha?complexity=80&size=36&length=4&t='+Math.random(1000);}</script>
  				
  				<span><a href="javascript:_rvi()">换一张图</a></span>
  				
  			</p>
  			<p class="tc">
  			<button type="submit">登录</button>
  			</p>
  		</form>
  	</div>
  </body>
</html>
