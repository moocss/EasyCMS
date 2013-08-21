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
	<title>会员组管理添加</title>
	<link rel="stylesheet" type="text/css" href="admin/assets/css/base.css" />
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">会员组管理</a> -&gt; <span>添加</span>
			</div>
			<div class="action">
				<a href="<%=basePath%>group/v_list.do" class="btn" target="_self">返回列表</a>
			</div>
		</div>
		<div class="mod">
			<div class="hd">
				<h2 class="tc">会员组添加</h2>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
			<form action="group/o_update.do?id=${group.id}" method="post">
				<table class="ui-table ui-table-form">
					<tbody>
						<tr>
							<th><span class="required">*</span>名称:</th>
							<td><input type="text" name="name" id="name" value="${group.name}"/></td>
							<th><span class="required">*</span>排列顺序:</th>
							<td><input type="text" name="priority" id="priority" value="${group.priority}"/></td>
						</tr>
						<tr>
							<th><span class="required">*</span>每日附件总尺寸:</th>
							<td>
								<input type="text" name="allowPerDay" id="allowPerDay" value="${group.allowPerDay}"/>0不限制,单位(kb)
							</td>
							<th>
								<span class="required">*</span>最大附件尺寸：</th>
							<td>
								<input type="text" name="allowMaxFile" id="allowMaxFile" value="${group.allowMaxFile}"/>0不限制,单位(kb)
							</td>
						</tr>
						<tr>
							<th>允许上传的后缀：</th>
							<td colspan="3">
								<input type="text" name="allowSuffix" id="allowSuffix" value=".jpg/.jpeg/.png/.bmp"/>留空则不限制，多个用","分开
							</td>
						</tr>
						<tr>
							<th>评论需要审核：</th>
							<td>
							<c:if test="${group.needCheck == 1}">
								<label><input type="radio" name="needCheck" value="1" checked="checked"/>是 </label>
								<label><input type="radio" name="needCheck" value="0"/>否</label>
							</c:if>	
							<c:if test="${group.needCheck == 0}">
								<label><input type="radio" name="needCheck" value="1" />是 </label>
								<label><input type="radio" name="needCheck" value="0" checked="checked"/>否</label>
							</c:if>
							</td>
							<th>评论需要验证：</th>
							<td>
							<c:if test="${group.needCaptcha == 1}">
								<label><input type="radio" name="needCaptcha" value="1" checked="checked"/>是 </label>
								<label><input type="radio" name="needCaptcha" value="0"/>否</label>
							</c:if>
							<c:if test="${group.needCaptcha == 0}">
								<label><input type="radio" name="needCaptcha" value="1"/>是 </label>
								<label><input type="radio" name="needCaptcha" value="0" checked="checked"/>否</label>
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
			<div class="ft"></div>
			<!-- /.mod-ft -->
		</div>
		<!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>
