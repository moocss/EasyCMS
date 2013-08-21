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
  <link type="text/css" rel="stylesheet" href="admin/assets/css/base.css"/>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/login.css"/>
</head>
<body>
    <div id="login" class="group">
        <div id="login-inner" data-active="login">
            <h1 class="logo-mini">EasyCMS 内容发布系统</h1>
            <div id="login-box">
                <form id="login-form" action="member/login.do" id="login" name="login" method="post">
                    <p class="control-group">
                        <label for="">用户名：</label>
                        <input type="text"  placeholder="用户名" id="username" name="username"/>
                    </p>
                    <p class="control-group">
                        <label for="">密码：</label>
                        <input type="password" placeholder="密码" id="password" name="password"/>
                    </p>
                    <p class="control-group">
                        <label for="">验证码：</label>
                        <input type="text" placeholder="验证码" id="verifyCode" name="verifyCode"/>
                        <img id="img_vcode" alt="..." src="captcha?complexity=99&size=36&length=4" width="80" height="36"/>
                        <script language='javascript'>
                          function _rvi(){document.getElementById('img_vcode').src = 'captcha?complexity=80&size=36&length=4&t='+Math.random(1000);}
                        </script>
                        <a href="javascript:_rvi()">换一张图</a>
                    </p>
                    <p class="form-actions">
                        <button type="submit">现在登录</button>
                        <a href="#">找回登录密码?</a>
                    </p>
                </form>
                <p> 没有帐号? <a id="register" href="#">注册新用户</a></p>
            </div>
            <div id="register-box">
                <form id="register-form" action="">
                    <p class="control-group">
                        <label for="">用户名：</label>
                        <input type="text"  placeholder="用户名" id="username" name="username"/>
                    </p>
                    <p class="control-group">
                        <label for="">密码：</label>
                        <input type="password" placeholder="密码" id="password" name="password"/>
                    </p>
                    <p class="control-group">
                        <label for="">确认密码：</label>
                        <input type="password" placeholder="密码" id="password-again" name="password"/>
                    </p>
                    <p class="control-group">
                        <label for="">电子邮箱：</label>
                        <input type="text" placeholder="电子邮箱" id="email" name="email"/>
                    </p>
                    <p class="control-group">
                        <label for="">验证码：</label>
                        <input type="text" placeholder="验证码" id="verifyCode" name="verifyCode"/>
                        <img id="img_vcode" alt="..." src="captcha?complexity=99&size=36&length=4" width="80" height="36"/>
                        <script language='javascript'>
                          function _rvi(){document.getElementById('img_vcode').src = 'captcha?complexity=80&size=36&length=4&t='+Math.random(1000);}
                        </script>
                        <a href="javascript:_rvi()">换一张图</a>
                    </p>
                    <p class="form-actions">
                        <button type="submit">注册新用户</button>
                    </p>
                </form>
            </div>
            <div id="forgot-box">
                <form id="forgot-form" action="">
                    <p class="control-group">
                        <label for="">用户名：</label>
                        <input type="text"  placeholder="用户名" id="username" name="username"/>
                    </p>
                    <p class="control-group">
                        <label for="">邮箱：</label>
                        <input type="text"  placeholder="邮箱" id="email" name="email"/>
                    </p>
                    <p class="control-group">
                        <label for="">验证码：</label>
                        <input type="text" placeholder="验证码" id="verifyCode" name="verifyCode"/>
                        <img id="img_vcode" alt="..." src="captcha?complexity=99&size=36&length=4" width="80" height="36"/>
                        <script language='javascript'>
                          function _rvi(){document.getElementById('img_vcode').src = 'captcha?complexity=80&size=36&length=4&t='+Math.random(1000);}
                        </script>
                        <a href="javascript:_rvi()">换一张图</a>
                    </p>
                    <div class="form-actions"> 
                        <button class="btn btn-large btn-block btn-success" type="submit">给我发送找回密码的链接 &gt;</button> 
                    </div>
                </form>
            </div>
        </div><!-- /#login-inner -->
        <ul id="login-bar" data-active="login">
            <li><a href="#">登录</a></li>
            <li><a href="#">注册</a></li>
            <li><a href="#">找回密码</a></li>
        </ul><!-- /#login-bar -->
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