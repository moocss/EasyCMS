<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN" xml:lang="zh-CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色管理列表</title>
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
