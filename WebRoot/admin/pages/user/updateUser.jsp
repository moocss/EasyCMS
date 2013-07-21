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
<title>会员修改</title>
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
			<form action="member/o_update.do?id=${user.id}" method="post">
				<table class="ui-table">
					<tbody>
						<tr>
							<td><label for="username">用户名:</label></td>
							<td>
								<input type="text" id="username" name="username" maxlength="100" value="${user.username}"/>
								<span class="required">*</span>
							</td>
							<td><label for="email">电子邮箱:</label></td>
							<td>
								<input type="text" size="30" id="email" name="email" value="${user.email}"/>
							</td>
						</tr>
						<tr>
							<td><label for="password">密码:</label></td>
							<td>
								<input type="password" name="password" maxlength="100" id="password" value="${user.password}"/>
								<span class="required">*</span>
							</td>
							<td><label for="qzpassword">确认密码:</label></td>
							<td>
								<input type="password" id="qzpassword" name="qzpassword" value="${user.password}"/>
								<span class="required">*</span>
							</td>
						</tr>
						<tr>
							<td><label for="groupId">会员组:</label></td>
							<td colspan="3">
								<select id="group_id" name="group_id">
								<c:forEach var="flag" items="${groups}">
									<c:choose>
										<c:when test="${user.group_id eq flag.id}">
											<option value="${flag.id}" selected="selected">${flag.name}</option>
										</c:when>
										<c:otherwise>
											<option value="${flag.id}">${flag.name}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>	
								</select>
								<span class="required">*</span>
							</td>
						</tr>
						<tr>
							<td><label for="realname">真实姓名:</label></td>
							<td>
								<input type="text" id="realname" name="realname" maxlength="100" value="${userExt.realname}"/>
							</td>
							<td>性别:</td>
							<td>
							<c:if test="${userExt.gender == 1}">
								<label for="gender_man"><input type="radio" id="gender_man" name="gender" value="1" checked="checked"/>男</label> 
								<label for="gender_woman"><input type="radio" id="gender_woman" name="gender" value="0"/>女</label> 
								<label for="gender_bm"><input type="radio" id="gender_bm" name="gender" value="2"/>保密</label>
							</c:if>
							<c:if test="${userExt.gender == 0}">
								<label for="gender_man"><input type="radio" id="gender_man" name="gender" value="1"/>男</label> 
								<label for="gender_woman"><input type="radio" id="gender_woman" name="gender" value="0" checked="checked"/>女</label> 
								<label for="gender_bm"><input type="radio" id="gender_bm" name="gender" value="2"/>保密</label>
							</c:if>
							<c:if test="${userExt.gender == 2}">
								<label for="gender_man"><input type="radio" id="gender_man" name="gender" value="1"/>男</label> 
								<label for="gender_woman"><input type="radio" id="gender_woman" name="gender" value="0"/>女</label> 
								<label for="gender_bm"><input type="radio" id="gender_bm" name="gender" value="2" checked="checked"/>保密</label>
							</c:if>
							</td>
						</tr>
						<tr>
							<td><label for="birthday">出生日期:</label></td>
							<td>
								<input type="text" id="birthday" name="birthday" value="${userExt.birthday}"/>
							</td>
							<td><label for="comefrom">来自:</label></td>
							<td>
								<input type="text" id="comefrom" name="comefrom" maxlength="150" value="${userExt.comefrom}"/>
							</td>
						</tr>
						<tr>
							<td><label for="qq">QQ:</label></td>
							<td><input type="text" id="qq" name="qq" maxlength="100" value="${userExt.qq}"/></td>
							<td><label for="msn">MSN:</label></td>
							<td><input type="text" id="msn" name="msn" maxlength="100" value="${userExt.msn}"/></td>
						</tr>
						<tr>
							<td><label for="phone">电话:</label></td>
							<td><input type="text" id="phone" name="phone" maxlength="50" value="${userExt.phone}"/></td>
							<td><label for="mobile">手机:</label></td>
							<td><input type="text" id="mobile" name="mobile" maxlength="50" value="${userExt.mobile}"/></td>
						</tr>
						<tr>
							<td><label for="intro"></label>个人介绍:</td>
							<td>
								<textarea maxlength="255" id="intro" name="intro" rows="5" cols="70">${userExt.intro}</textarea>
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
			<div class="ft"></div>
			<!-- /.mod-ft -->
		</div>
		<!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>
