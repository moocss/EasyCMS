<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>会员管理添加</title>
<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">会员管理</a> -&gt; <span>添加</span>
			</div>
			<div class="action">
				<a href="#" class="btn">添加</a>
			</div>
		</div>
		<div class="mod">
			<div class="hd">
				<h2 class="tc">会员管理添加</h2>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
				<table class="ui-table">
					<tbody>
						<tr>
							<td><span
								class="pn-frequired">*</span>用户名:</td>
							<td><input
								type="text"
								name="username" maxlength="100"></td>
							<td>电子邮箱:</td>
							<td><input
								type="text" size="30" class="email" name="email"></td>
						</tr>
						<tr>
							<td><span
								class="pn-frequired">*</span>密码:</td>
							<td><input
								type="password" class="required" name="password" maxlength="100"
								id="password" autocomplete="off"></td>
							<td><span
								class="pn-frequired">*</span>确认密码:</td>
							<td><input
								type="password" equalto="#password" autocomplete="off"></td>
						</tr>
						<tr>
							<td><span
								class="pn-frequired">*</span>会员组:</td>
							<td><select
								name="groupId"><option value="1">普通会员</option>
									<option value="2">主站信息管理员组</option>
									<option value="3">jeecms子站信息发布组</option></select></td>
						</tr>
						<tr>
							<td>真实姓名:</td>
							<td><input
								type="text" name="realname" maxlength="100"></td>
							<td>性别:</td>
							<td><label><input
									type="radio" name="gender" value="true">男</label> <label><input
									type="radio" name="gender" value="false">女</label> <label><input
									type="radio" name="gender" checked="checked" value="">保密</label></td>
						</tr>
						<tr>
							<td>出生日期:</td>
							<td><input
								type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								class="Wdate" name="birthday"></td>
							<td>来自:</td>
							<td><input
								type="text" name="comefrom" maxlength="150"></td>
						</tr>
						<tr>
							<td>QQ:</td>
							<td><input
								type="text" name="qq" maxlength="100"></td>
							<td>MSN:</td>
							<td><input
								type="text" name="msn" maxlength="100"></td>
						</tr>
						<tr>
							<td>电话:</td>
							<td><input
								type="text" name="phone" maxlength="50"></td>
							<td>手机:</td>
							<td><input
								type="text" name="mobile" maxlength="50"></td>
						</tr>
						<tr>
							<td>来自:</td>
							<td><input
								type="text" size="70" name="comefrom" maxlength="150"></td>
						</tr>
						<tr>
							<td>个人介绍:</td>
							<td><textarea
									maxlength="255" name="intro" rows="5" cols="70"></textarea></td>
						</tr>
						<tr>
							<td><input type="submit"
								class="submit" value="提交"> &nbsp; <input type="reset"
									class="reset" value="重置"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- /.mod-bd -->
			<div class="ft"></div>
			<!-- /.mod-ft -->
		</div>
		<!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>
