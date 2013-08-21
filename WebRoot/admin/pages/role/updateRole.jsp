<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html>
<!--[if IE 6]><html class="ie6 lte9 lte8 lte7" lang="zh-CN"><![endif]-->
<!--[if IE 8]><html class="ie8 lte9 lte8" lang="zh-CN"><![endif]-->
<!--[if IE 9]><html class="ie9 lte9" lang="zh-CN"><![endif]-->
<!--[if IE 7]><html class="ie7 lte9 lte8 lte7" lang="zh-CN"><![endif]-->
<!--[if !(IE 6) | !(IE 7) | !(IE 8) | !(IE 9)  ]><!--><html lang="zh-CN"><!--<![endif]-->
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>角色管理列表</title>
	<link rel="stylesheet" type="text/css" href="admin/assets/css/base.css" />
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">角色管理</a> -&gt; <span>添加</span>
			</div>
			<div class="action">
				<a href="<%=basePath%>role/v_list.do" class="btn" target="_self">返回列表</a>
			</div>
		</div>
		<div class="mod">
			<div class="hd">
				<h2 class="tc">角色管理列表</h2>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
				<form action="role/o_update.do?id=${role.id}" method="post">
				  <table class="ui-table">
				    <tbody>
				      <tr>
				        <td><label for="name">角色名:</label></td>
				        <td>
				        	<input type="text" id="name" name="name" maxlength="100" value="${role.name}"/>
				        	<span class="required">*</span>
				        </td>
				        <td><label for="priority">排列顺序:</label></td>
				        <td>
				        	<input type="text" id="priority" name="priority" maxlength="5"  value="${role.priority}"/>
				        	<span class="required">*</span>
				        </td>
				      </tr>
				      <tr>
				        <td>拥有所有权限:</td>
				        <td colspan="3">
				          <c:if test="${role.m_super == 'true'}">
				          <label><input type="radio" name="m_super" value="1"/>是</label>
				          <label><input type="radio" name="m_super" checked="checked" value="0"/>否</label>
				          </c:if>
				          <c:if test="${role.m_super == 'false'}">
				          <label><input type="radio" name="m_super" checked="checked" value="1"/>是</label>
				          <label><input type="radio" name="m_super" value="0"/>否</label>
				          </c:if>
				        </td>
				      </tr>
				      <tr>
						<td colspan="4" class="tc">
						  <button type="submit" class="btn" name="button1" id="button1">提交</button>
						  <button type="reset" class="btn" name="button2" id="button2">重置</button>
						</td>
					  </tr>		
				   	</tbody>
				   </table>
				</form>
			</div>
			<!-- /.mod-bd -->
		</div>
		<!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>
