<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN" xml:lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>EasyCMS</title>
  <link type="text/css" rel="stylesheet" href="../assets/css/easyui.css"/>
  <link type="text/css" rel="stylesheet" href="../assets/css/style.css"/>
  <!--javascript start-->
  <script type="text/javascript" src="../assets/js/libs/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="../assets/js/libs/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="../assets/js/jquery.custom.js"></script>
  <!--javascript end-->
</head>
<body id="home" class="easyui-layout">
    <div id="header" data-options="region:'north',border:false">
        <h1 class="logo">EasyCMS</h1>
        <div class="dl-log">
          欢迎您，<span class="dl-log-user">moocss@gmail.com</span>
          <a class="dl-log-quit" title="退出系统" href="###">[退出]</a>
      </div>
    </div><!-- /#header -->   
    <div id="sidebar" data-options="region:'west',split:true,title:'2013年5月26日 星期日'">
      <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="我的工作台" data-options="iconCls:'icon-home'">
          <ul class="menu-list">
            <li><a href="javascript:;" data-url="main.html">我的工作台</a></li>
            <li><a href="javascript:;" data-url="我的信息.html">我的信息</a></li>
          </ul><!-- /.menu-list -->
        </div>

        <div title="用户管理" data-options="iconCls:'icon-home'">
          <ul class="menu-list">
            <li><a  href="javascript:;" data-url="user/showUser.jsp">会员管理</a></li>
            <li><a  href="javascript:;" data-url="<%=basePath%>/group/list.do">会员组管理</a></li>
            <li><a  href="javascript:;" data-url="用户.html">管理员(全站)</a></li>
            <li><a  href="javascript:;" data-url="用户.html">管理员(本站)</a></li>
            <li><a  href="javascript:;" data-url="用户.html">角色管理</a></li>
            <li><a  href="javascript:;" data-url="用户.html">部门管理</a></li>
            <li><a  href="javascript:;" data-url="用户.html">后台操作日志</a></li>
            <li><a  href="javascript:;" data-url="用户.html">登录成功日志</a></li>
            <li><a  href="javascript:;" data-url="用户.html">登录失败日志</a></li>
            <li><a  href="javascript:;" data-url="用户.html">站内信管理</a></li>
          </ul><!-- /.menu-list -->
        </div>
        <div title="站点管理" data-options="iconCls:'icon-home'">
                <ul class="menu-list">
            <li><a  href="javascript:;" data-url="站点管理.html">站点管理</a></li>
          </ul><!-- /.menu-list -->
        </div>
        <div title="网站管理" data-options="iconCls:'icon-home'">
   		 <ul class="menu-list">
            <li><a href="javascript:;" data-url="网站管理.html">网站管理</a></li> 
            
          </ul><!-- /.menu-list -->
        </div>
        <div title="栏目管理" data-options="iconCls:'icon-home'">
          <ul class="menu-list">
            <li><a  href="javascript:;" data-url="栏目操作.html">栏目操作</a></li>
          </ul><!-- /.menu-list -->
        </div>
        <div title="模板管理" data-options="iconCls:'icon-home'">
          <ul class="menu-list">
            <li><a  href="javascript:;" data-url="模板管理.html">模板管理</a></li>
          </ul><!-- /.menu-list -->
        </div>
        <div title="内容管理" data-options="iconCls:'icon-home'">
                   <ul class="menu-list">
            <li><a href="javascript:;" data-url="内容管理.html">内容管理</a></li>
            <li><a href="javascript:;" data-url="新增稿件.html">内容恢复</a></li>
            <li><a href="javascript:;" data-url="退回稿件.html">物理删除</a></li>
          </ul><!-- /.menu-list -->
        </div>
        <div title="统计管理" data-options="iconCls:'icon-home'">
           <ul class="menu-list">
            <li><a href="javascript:;" data-url="稿件数量统计.html">稿件数量统计</a></li>
            <li><a href="javascript:;" data-url="访问量统计.html">访问量统计</a></li>
            <li><a href="javascript:;" data-url="审稿数统计.html">审稿数统计</a></li>
            <li><a href="javascript:;" data-url="专题统计.html">专题统计</a></li>
            
          </ul><!-- /.menu-list -->
        </div>
        <div title="系统设置" data-options="iconCls:'icon-home'">
          <ul class="menu-list">
            <li><a href="javascript:;" data-url="用户管理.html"> 用户管理</a></li>
            <li><a href="javascript:;" data-url="角色管理.html">角色管理</a></li>
            <li><a href="javascript:;" data-url="权限管理.html">权限管理</a></li>
            <li><a href="javascript:;" data-url="资源管理.html">资源管理</a></li>
            <li><a href="javascript:;" data-url="热词管理.html">热词管理</a></li>
            <li><a href="javascript:;" data-url="模块管理.html">模块管理</a></li>
            <li><a href="javascript:;" data-url="日志管理.html">系统日志</a></li>
          </ul><!-- /.menu-list -->
        </div>
      </div>
    </div><!-- /#sidebar -->
    <div id="main-content" data-options="region:'center'">
          <div id="tabs" class="easyui-tabs"  fit="true" border="false">
            <div data-options="title:'我的工作台'"> 
                <iframe name="mainFrame" id="mainFrame" src="main.jsp" frameborder="0" scrolling="no" width="100%" height="100%"></iframe>
            </div>
        </div>
    </div><!-- /#main-content -->
    <div id="footer" data-options="region:'south',border:false">
    	<p class="copyright">技术支持</p>
    </div><!-- /#footer -->
</body>
</html>