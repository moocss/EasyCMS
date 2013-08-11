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
	<title>角色添加</title>
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css" />
	<script src="admin/assets/js/common.js" type="text/javascript"></script>
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
			window.location = "<%=basePath%>role/o_delete.do?id="+id;
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">角色管理</a> -&gt; <span>列表</span>
			</div>
			<div class="action">
				<a href="role/v_add.do" class="btn" target="_self">添加</a>
			</div>
		</div>
		<div class="mod">
			<div class="bd">
				<table class="ui-table">
					<thead>
						<tr>
							<th width="20">
								<input type="checkbox" name="ck_all" c id="ck_all" onclick="Pony.checkboxSlt('ck',this.checked);"/>
							</th>
							<th>ID</th>
							<th>角色名</th>
							<th>排列顺序</th>
							<th>操作选项</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="flag" items="${roles}" varStatus="status">
    				<c:choose>
    					<c:when test="${status.index % 2 ==0 }">
    					<tr>
    					</c:when>
    					<c:otherwise>
    					<tr class="even">
    					</c:otherwise>
    				</c:choose>
							<td class="tc">
								<input type="checkbox" name="ck" value="${flag.id}"/>
							</td>
							<td>${flag.id}</td>
							<td>${flag.name}</td>
							<td>${flag.priority}</td>
							<td>
								<a class="btn" href="role/v_update.do?id=${flag.id}">修改</a>
								<a href="javascript:;" class="btn" onclick="optDelete(${flag.id});">删除</a>
								<a class="btn" href="#">授权</a>
							</td>
						</tr>
					</c:forEach>	
					</tbody>
				</table>
			</div>
			<!-- /.mod-bd -->
		</div>
		<!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>
