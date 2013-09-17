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
	<title>会员添加</title>
	<link rel="stylesheet" type="text/css" href="admin/assets/css/base.css" />
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">会员管理</a> -&gt; <span>添加</span>
			</div>
			<div class="action">
				<a href="<%=basePath%>member/v_list.do" class="btn" target="_self">返回列表</a>
			</div>
		</div>
		<div class="mod">
			<div class="bd">
			<form action="member/o_add.do" method="post">
				<table class="ui-table">
					<tbody>
						<tr>
							<th width="120"><label for="username">用户名:</label></th>
							<td>
								<input type="text" id="username" name="username" maxlength="100"/>
								<span class="required">*</span>
							</td>
							<th width="120"><label for="email">电子邮箱:</label></th>
							<td>
								<input type="text" size="30" id="email" name="email"/>
							</td>
						</tr>
						<tr>
							<th><label for="password">密码:</label></th>
							<td>
								<input type="password" name="password" maxlength="100" id="password" autocomplete="off"/>
								<span class="required">*</span>
							</td>
							<th><label for="qzpassword">确认密码:</label></th>
							<td>
								<input type="password" id="qzpassword" name="qzpassword" autocomplete="off"/>
								<span class="required">*</span>
							</td>
						</tr>
						<tr>
							<th><label for="group_id">会员组:</label></th>
							<td colspan="3">
								<select id="gid" name="gid">
								<c:forEach var="flag" items="${groups}">
									<option value="${flag.id}">${flag.name}</option>
								</c:forEach>	
								</select>
								<span class="required">*</span>
							</td>
						</tr>
						<tr>
							<th><label for="realname">真实姓名:</label></th>
							<td>
								<input type="text" id="realname" name="realname" maxlength="100">
							</td>
							<th>性别:</th>
							<td>
								<label><input type="radio" name="gender" value="1">男</label> 
								<label><input type="radio" name="gender" value="0">女</label> 
								<label><input type="radio" name="gender" checked="checked" value="2">保密</label>
							</td>
						</tr>
						<tr>
							<th><label for="birthday">出生日期:</label></th>
							<td>
								<input type="text" id="birthday" name="birthday"/>
							</td>
							<th><label for="comefrom">来自:</label></th>
							<td>
								<input type="text" id="comefrom" name="comefrom" maxlength="150"/>
							</td>
						</tr>
						<tr>
							<th><label for="qq">QQ:</label></th>
							<td><input type="text" id="qq" name="qq" maxlength="100"></td>
							<th><label for="msn">MSN:</label></th>
							<td><input type="text" id="msn" name="msn" maxlength="100"></td>
						</tr>
						<tr>
							<th><label for="phone">电话:</label></th>
							<td><input type="text" id="phone" name="phone" maxlength="50"></td>
							<th><label for="mobile">手机:</label></th>
							<td><input type="text" id="mobile" name="mobile" maxlength="50"></td>
						</tr>
						<tr>
							<th><label for="intro"></label>个人介绍:</th>
							<td colspan="3">
								<textarea maxlength="255" id="intro" name="intro" rows="5" cols="70"></textarea>
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
