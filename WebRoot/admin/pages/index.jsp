<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!DOCTYPE html>
<!--[if IE 6]><html class="ie6 lte9 lte8 lte7" lang="zh-CN"><![endif]-->
<!--[if IE 8]><html class="ie8 lte9 lte8" lang="zh-CN"><![endif]-->
<!--[if IE 9]><html class="ie9 lte9" lang="zh-CN"><![endif]-->
<!--[if IE 7]><html class="ie7 lte9 lte8 lte7" lang="zh-CN"><![endif]-->
<!--[if !(IE 6) | !(IE 7) | !(IE 8) | !(IE 9)  ]><!--><html lang="zh-CN"><!--<![endif]-->
<head>
  <base href="<%=basePath%>"/>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
  <!--[if IE 6]>
  <meta http-equiv="refresh" content="0;url=ie6.html" />
  <![endif]-->
  <title>EasyCMS 内容发布系统</title>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/easyui.css"/>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/font-awesome.min.css"/>
  <!--[if IE 7]>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/font-awesome-ie7.min.css"/>
  <![endif]-->
  <link type="text/css" rel="stylesheet" href="admin/assets/css/base.css"/>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/style.css"/>
</head>
<body id="home" class="easyui-layout bg">
    <!--<div id="preloader">
      <div id="status">页面加载中...</div>
    </div>--><!-- /#preloader -->
    <div id="header" data-options="region:'north',border:false">
      <div id="header-inner">
        <h1 class="logo"><span>EasyCMS</span></h1>
        <ul class="top-nav group">
          <li><a href="javascript:;" title=""><i class="icon-tasks"></i><span class="badge badge-warning">4</span></a></li>
          <li><a href="javascript:;" title=""><i class="icon-volume-up"></i><span class="badge badge-important">5</span></a></li>
          <li><a href="javascript:;" title=""><i class="icon-bell-alt"></i><span class="badge badge-success">3</span></a></li>
          <li><a href="javascript:;" title="系统设置"><i class="icon-cogs"></i></a></li>
          <li><a href="javascript:;" title="系统退出" onclick="quitLogin()"><i class="icon-signout"></i></a></li>
        </ul>
        <div class="date-box-bar">
          <i class="icon-time"></i> 系统日期：<span id="timedate"></span>
        </div>
        <div class="usercount">
          <i class="icon-foursquare"></i> 当前有 <a href="#" class="badge">5</a> 条未处理的信息
        </div>
      </div><!-- /#header-inner -->
    </div><!-- /#header -->   
    <div id="sidebar" data-options="region:'west',split:false, border:false">
        <div class="sidebar-wrapper">
            <div class="mini-profile group">
                <div class="mini-user-avatar">
                  <a href="#" title="欢迎您，moocss@gmail.com !"><img class="img-circle" alt="头像" src="admin/assets/images/avatar.jpg" width="32" height="32"></a>
                </div>
                <div class="mini-profile-options">
                  <a title="系统设置" href="javascript:;"><i class="icon-cog"></i></a>
                  <a title="查看用户" href="javascript:;"><i class="icon-user"></i></a>
                  <a title="查看首页" href="javascript:;"><i class="icon-home"></i></a>
                  <a title="退出系统" href="javascript:;" onclick="quitLogin()"><i class="icon-signout"></i></a>
                </div>
            </div>
 			<%@include file="menu.jsp"%>
        </div>
    </div><!-- /#sidebar -->
    <div id="content" data-options="region:'center',border:false">
        <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false">
            <div data-options="title:'我的工作台'">
              <div id="iframe-wraper"><iframe name="mainFrame" id="mainFrame" src="admin/pages/main.jsp" frameborder="0" scrolling="auto" width="100%" height="100%"></iframe></div>
            </div>
        </div>
    </div><!-- /#content -->
    <div id="footer" data-options="region:'south',border:false">
      <div id="footer-inner" class="group">
        <p class="copyright">2013 &copy; EasyCMS Admin System</p>
        <ul class="bottom-nav">
          <li><a href="javascript:;" title="邮件"><i class="icon-envelope"></i> 邮件 <span class="badge">2</span></a></li>
          <li><a href="javascript:;" title="事务提醒"><i class="icon-bullhorn"></i> 事务提醒 <span class="badge">3</span></a></li>
          <li><a href="javascript:;" title="留言"><i class="icon-meh"></i> 留言 <span class="badge">41</span></a></li>
        </ul>
      </div><!-- /#footer-inner -->
    </div><!-- /#footer -->

    <!--javascript start-->
    <script type="text/javascript" src="admin/assets/js/libs/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="admin/assets/js/libs/jquery.easyui.custom.min.js"></script>
    <script type="text/javascript" src="admin/assets/js/jquery.easyui.extend.js"></script>
    <script type="text/javascript" src="admin/assets/js/jquery.plugins.js"></script>
    <script type="text/javascript" src="admin/assets/js/jquery.syadmin.js"></script>
    <script type="text/javascript">
        function quitLogin(){
          $.messager.confirm('系统提示', '确认退出当前系统？', function(data){
            if(data){
               window.location.href="member/logout";
            }
          });
        }

        //测试dialog
        function emailDialog(){
          $('#email-dialog').dialog({  
              title: '邮件',  
              width: 500,  
              height: 300, 
              shadow:false, 
              closed: false,  
              cache: false,  
              href: 'test.html',  
              modal: true
          });
        }
      
    </script>
    <!--javascript end-->

</body>
</html>