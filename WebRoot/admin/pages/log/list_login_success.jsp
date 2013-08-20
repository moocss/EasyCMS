<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
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
	<title>后台操作日志列表</title>
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
			window.location = "<%=basePath%>log/o_delete.do?id="+id;
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <span>后台操作日志</span>
			</div>
		</div>
		<div class="mod">
			<div class="hd">
				<form method="post" action="log/v_list_login_success.do">
					<label for="">用户: </label><input type="text" name="queryUsername"/>
					<label for="">IP: </label><input type="text" name="queryIp"/>
					<button type="submit">查询</button>
				</form>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
				<form action="log/v_list_login_success.do" method="post">
				<table class="ui-table">
					<thead>
						<tr>
							<th width="20">
								<input type="checkbox" name="ck_all" c id="ck_all" onclick="Pony.checkboxSlt('ck',this.checked);"/>
							</th>
							<th>ID</th>
							<th>用户</th>
							<th>时间</th>
							<th>IP</th>
							<th>标题</th>
							<th>内容</th>
							<th>操作选项</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="flag" items="${logPager.pageList}" varStatus="status">
	    				<c:choose>
	    					<c:when test="${status.index % 2 ==0 }">
	    					<tr>
	    					</c:when>
	    					<c:otherwise>
	    					<tr class="even">
	    					</c:otherwise>
	    				</c:choose>
							<td><input type="checkbox" value="${flag.id}" name="ids"/></td>
							<td>${flag.id}</td>
							<td>${flag.username}</td>
							<td>${flag.time}</td>
							<td>${flag.ip}</td>
							<td>${flag.title}</td>
							<td>${flag.content}</td>
							<td>
								<a href="javascript:;" class="btn" onclick="optDelete(${flag.id});">删除</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
			</div><!-- /.mod-bd -->
			<div class="mod-ft">
		    	<pg:pager items="${logPager.total}" maxPageItems="10" maxIndexPages="1" url="log/v_list_log.do" export="currentPageNo = pageNumber">
		    		<pg:index export="totalItems = itemCount">
		    		<div class="pager">
					    <pg:page export="firstItem, lastItem">
				        <span class="info">共${totalItems}条/${firstItem}-${lastItem}页</span>
				        </pg:page>
				       	<pg:first> 
				       	<a class="start" href="${pageUrl}">首页</a>
				       	</pg:first>
				       	<pg:prev>
				        <a class="prev" href="${pageUrl}">上一页</a>
				        </pg:prev>
				        <pg:pages>
				        <c:choose>
					        <c:when test="${currentPageNo eq pageNumber}">
					        	<span class="page current">${pageNumber}</span>
					        </c:when>
					        <c:otherwise>
					        <a class="page" href="${pageUrl}">${pageNumber}</a>
					        </c:otherwise>
				        </c:choose>
				        </pg:pages>
				        <pg:next>
				        <a class="next" href="${pageUrl}">下一页</a>
				        </pg:next>
				        <pg:last>
				        <a class="end" href="${pageUrl}">末页</a>
				        </pg:last>
			    	</div><!-- /.pager -->
			    	</pg:index>
			    </pg:pager>
			</div><!-- /.mod-ft -->
		</div>
		<!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>