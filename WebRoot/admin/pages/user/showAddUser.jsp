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
<title>会员添加</title>
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
							<td><label for="username">用户名:</label></td>
							<td>
								<input type="text" id="username" name="username" maxlength="100"/>
								<span class="required">*</span>
							</td>
							<td><label for="email">电子邮箱:</label></td>
							<td>
								<input type="text" size="30" id="email" name="email"/>
							</td>
						</tr>
						<tr>
							<td><label for="password">密码:</label></td>
							<td>
								<input type="password" name="password" maxlength="100" id="password" autocomplete="off"/>
								<span class="required">*</span>
							</td>
							<td><label for="qzpassword">确认密码:</label></td>
							<td>
								<input type="password" id="qzpassword" name="qzpassword" autocomplete="off"/>
								<span class="required">*</span>
							</td>
						</tr>
						<tr>
							<td><label for="group_id">会员组:</label></td>
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
							<td><label for="realname">真实姓名:</label></td>
							<td>
								<input type="text" id="realname" name="realname" maxlength="100">
							</td>
							<td>性别:</td>
							<td>
								<label><input type="radio" name="gender" value="1">男</label> 
								<label><input type="radio" name="gender" value="0">女</label> 
								<label><input type="radio" name="gender" checked="checked" value="2">保密</label>
							</td>
						</tr>
						<tr>
							<td><label for="birthday">出生日期:</label></td>
							<td>
								<input type="text" id="birthday" name="birthday"/>
							</td>
							<td><label for="comefrom">来自:</label></td>
							<td>
								<input type="text" id="comefrom" name="comefrom" maxlength="150"/>
							</td>
						</tr>
						<tr>
							<td><label for="qq">QQ:</label></td>
							<td><input type="text" id="qq" name="qq" maxlength="100"></td>
							<td><label for="msn">MSN:</label></td>
							<td><input type="text" id="msn" name="msn" maxlength="100"></td>
						</tr>
						<tr>
							<td><label for="phone">电话:</label></td>
							<td><input type="text" id="phone" name="phone" maxlength="50"></td>
							<td><label for="mobile">手机:</label></td>
							<td><input type="text" id="mobile" name="mobile" maxlength="50"></td>
						</tr>
						<tr>
							<td><label for="intro"></label>个人介绍:</td>
							<td>
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
