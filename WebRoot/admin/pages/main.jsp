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
  <title>EasyCMS 内容发布系统</title>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/base.css"/>
  <link type="text/css" rel="stylesheet" href="admin/assets/css/style.css"/>
</head>
<body>
    <div id="container">

    </div>
</body>
</html>