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
  <link type="text/css" rel="stylesheet" href="admin/assets/css/error.css"/>
	<script type="text/javascript">
		function showErrors() {
			var err_el = document.getElementById('errors');
			if (err_el.style.display == 'none') {
				err_el.style.display = '';
			} else {
				err_el.style.display = 'none';
			}
		}
	</script>
</head>
<body>
	<div class="exception">
		<div class="exception-hd">
			<pre>${exception.message}</pre>
		</div>
		<div class="exception-action">
		         您可以
			<a href="javascript:showErrors();">查看详情</a> 或直接
			<a href="javascript:history.go(-1);">返回</a>。
		</div>	
		<div class="exception-bd" id="errors">
			<c:forEach items="${exception.stackTrace}" var="e">
		${e }<br />
			</c:forEach>
		</div>
	</div>
</body>
</html>