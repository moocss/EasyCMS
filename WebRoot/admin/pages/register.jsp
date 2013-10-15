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
  <title>EasyCMS 用户注册</title>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/font-awesome.min.css"/>
  <!--[if IE 7]>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/font-awesome-ie7.min.css"/>
  <![endif]-->
  <link type="text/css" rel="stylesheet" href="admin/assets/css/base.css"/>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/login.css"/>
</head>
<body>
    <div id="login" class="group">
        <div id="login-inner" data-active="register">
            <h1 class="logo-mini"><span>EasyCMS</span> Content Admin System</h1>
            <div id="register-box" class="box">
            	<div class="hd">
            		<h2>用户注册</h2>
            	</div>
            	<div class="bd">
                <form id="register-form" action="member/register.do" method="post">
                    <input type="hidden" name="gid" id="gid" value="3"/>
                    <p class="control-group">
                        <label for="username"><i class="icon-user"></i><span>用户名：</span></label>
                        <input class="ipt w278" type="text"  placeholder="用户名" id="username" name="username"/>
                    </p>
                    <p class="control-group">
                        <label for="password"><i class="icon-lock"></i><span>密码：</span></label>
                        <input class="ipt w278" type="password" placeholder="密码" id="password" name="password"/>
                    </p>
                    <p class="control-group">
                        <label for="qzpassword"><i class="icon-lock"></i><span>确认密码：</span></label>
                        <input class="ipt w278" type="password" placeholder="密码" id="qzpassword" name="qzpassword"/>
                    </p>
                    <p class="control-group">
                        <label for="email"><i class="icon-envelope"></i><span>电子邮箱：</span></label>
                        <input class="ipt w278" type="email" placeholder="电子邮箱" id="email" name="email"/>
                    </p>
                    <p class="control-group">
                        <label for="verifyCode"><i class="icon-key"></i><span>验证码：</span></label>
                        <input class="ipt w191" type="text" placeholder="验证码" id="verifyCode" name="verifyCode"/>
	                    <img id="img_vcode" alt="..." src="captcha?complexity=99&size=30&length=4" width="80" height="30" onclick="javascript:_rvi()"/>
	                    <script language='javascript'>
	                        function _rvi(){document.getElementById('img_vcode').src = 'captcha?complexity=80&size=36&length=4&t='+Math.random(1000);}
	                    </script>
                    </p>
                    <p class="form-actions tc">
                        <button class="btn" type="submit">注册新用户</button>
                    </p>
	                <p class="line tc"> 
						<a href="member/login.do">返回登录页面？</a>
	                </p>
                </form>
                </div>
            </div>
        </div><!-- /#login-inner -->
    </div><!-- /#login -->
    <!--javascript start-->
    <script type="text/javascript" src="admin/assets/js/libs/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
      jQuery(document).ready(function(){
        
      });
    </script>
    <!--javascript end-->
</body>
</html>