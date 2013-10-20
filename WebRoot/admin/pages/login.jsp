<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!DOCTYPE html>
<html lang="zh-CN">
<head>
  <base href="<%=basePath%>"/>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
  <title>EasyCMS 登录</title>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/font-awesome.min.css"/>
  <!--[if IE 7]>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/font-awesome-ie7.min.css"/>
  <![endif]-->
  <link type="text/css" rel="stylesheet" href="admin/assets/css/base.css"/>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/login.css"/>
</head>
<body>
    <div id="login" class="group">
        <div id="login-inner" data-active="login">
            <h1 class="logo-mini"><span>EasyCMS</span> Content Admin System</h1>
            <div id="login-box" class="box">
            	<div class="hd">
            		<h2>用户登录</h2>
            	</div>
            	<div class="bd">
	                <form id="login-form" action="member/login.do" name="login" method="post" novalidate="true">
	                    <p class="control-group">
	                        <label for="username"><i class="icon-user"></i><span>用户名：</span></label>
	                        <input class="ipt w278" type="text" placeholder="用户名" id="username" name="username" value="fuxin" required maxlength="20"/>
	                    </p>
	                    <p class="control-group">
	                        <label for="password"><i class="icon-lock"></i><span>密码：</span></label>
	                        <input class="ipt w278" type="password" placeholder="密码" id="password" name="password" value="123456" required maxlength="15"/>
	                    </p>
	                    <p class="control-group">
	                        <label for="verifyCode"><i class="icon-key"></i><span>验证码：</span></label>
	                        <input class="ipt w191" type="text" placeholder="验证码" id="verifyCode" name="verifyCode" required min="1" max="4" maxlength="4"/>
	                        <img id="img_vcode" alt="..." src="captcha?complexity=99&size=30&length=4" width="80" height="30" onclick="javascript:_rvi()"/>
	                        <script language='javascript'>
	                          function _rvi(){document.getElementById('img_vcode').src = 'captcha?complexity=80&size=36&length=4&t='+Math.random(1000);}
	                        </script>
	                    </p>
	                    <p class="form-actions tc">
	                        <button class="btn" type="submit">现在登录</button>
	                    </p>
	                </form>
	                <p class="line tc"> 
		                <a class="forgot-link" href="member/forgot">找回登录密码?</a>
		                &emsp;&emsp;
		                <a id="register" href="member/register">注册新用户?</a>
	                </p>
            	</div>
            </div>
        </div><!-- /#login-inner -->
    </div><!-- /#login -->
    <!--javascript start-->
    <script type="text/javascript" src="admin/assets/js/libs/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="admin/assets/js/validator.js"></script>
    <script type="text/javascript">
      jQuery(document).ready(function(){
		  $('#login-form').validator();
      });
    </script>
    <!--javascript end-->
</body>
</html>