<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
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
	<title>站内信管理  - 收件箱管理</title>
	<link rel="stylesheet" type="text/css" href="admin/assets/css/base.css" />
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
	<script src="admin/assets/js/libs/jquery-1.8.3.min.js" type="text/javascript"></script>
	<script src="admin/assets/js/common.js" type="text/javascript"></script>
	<script src="admin/assets/js/message.js" type="text/javascript"></script>
	<script type="text/javascript">
		//删除一个数据
		function optDelete(id) {
			if(Pony.checkedCount("ck") <= 0) {
				alert("请选择您要操作的数据!");
				return;
			}
			if(!confirm("您确定删除吗？")) {
				return;
			}
			window.location = "<%=basePath%>message/o_delete.do?id="+id;
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">站内信管理 </a> -&gt; <span>收件箱管理</span>
			</div>
			<div class="action tr">
				<a href="<%=basePath%>message/v_list.do" class="btn" target="_self">返回列表</a>
			</div>
		</div>
		<div class="mod">
			<div class="bd">
				<form action="<%=basePath%>/message/v_send.do" method="post">
					<table class="ui-table ui-table-form">
						<tbody>
							<tr>
								<th width="150"><label for="">发件人：</label></th>
								<td>
									<input id="username"name="username"/> 
									<label for="groupId">会员组选择：</label>
									<select id="groupId" name="groupId">
										<option value="-1">请选择</option>
									</select> 
									<span class="tip">请填写收件人或者选择会员组（两者必选其一，选择会员组批量发送站内信）</span>
								</td>
							</tr>
							<tr>
								<th><span class="required">*</span>标题：</th>
								<td>
								<input type="text" class="required" name="msgTitle" maxlength="100"/>
								</td>
							</tr>
							<tr>
								<th>内容：</th>
								<td>
								<textarea name="msgContent" id="msgContent" cols="80" rows="5"></textarea>
								</td>
							</tr>
							<tr>
								<td class="tc" colspan="2">
									<button id="button1" name="button1" class="btn" type="submit">提交</button>
									<button id="button2" name="button2" class="btn" type="reset">重置</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div><!-- /.mod-bd -->
		</div><!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>
