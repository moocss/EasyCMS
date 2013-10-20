<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<title>后台操作日志列表</title>
	<link rel="stylesheet" type="text/css" href="admin/assets/css/base.css" />
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
			window.location = "<%=basePath%>log/o_delete_login_success.do?id="+id;
		}
		//批量删除数据
		function optDeleteIn(type) {
			if(Pony.checkedCount("ck") <= 0) {
				alert("请选择您要操作的数据!");
				return;
			}
			if(!confirm("您确定删除吗？")) {
				return;
			}
			
			var ids = Pony.checkIn("ck");
			//console.log(ids);
			window.location = "<%=basePath%>log/o_delete_login_success_in.do?ids="+ids;
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
				<form class="search-form" method="post" action="log/find_log_success.do">
					<label for="username">用户: </label><input class="ipt" type="text" id="username" name="username" value="${username}"/>
					<label for="ip">IP: </label><input class="ipt" type="text" id="ip" name="ip"  value="${ip}"/>
					<button class="btn" type="submit">查询</button>
				</form>
			</div>
			<!-- /.mod-hd -->
			<div class="bd">
				<table class="ui-table">
					<thead>
						<tr>
							<th width="20">
								<input type="checkbox" name="ck_all" id="ck_all" onclick="Pony.checkboxSlt('ck',this.checked);"/>
							</th>
							<th width="60">ID</th>
							<th width="150">用户</th>
							<th width="150">时间</th>
							<th width="100">IP</th>
							<th>标题</th>
							<th width="80">操作选项</th>
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
							<td class="tc"><input type="checkbox" value="${flag.id}" name="ck"/></td>
							<td class="tc">${flag.id}</td>
							<td class="tc">${flag.username}</td>
							<td class="tc"><fmt:formatDate value="${flag.time}" type="both"/></td>
							<td class="tc">${flag.ip}</td>
							<td>${flag.title}</td>
							<td class="tc">
								<a href="javascript:;" class="btn" onclick="optDelete(${flag.id});">删除</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="7">
								<a class="btn" href="javascript:;" onclick="optDeleteIn('1');">批量删除</a>
							</td>
						</tr>
					</tfoot>
				</table>
			</div><!-- /.mod-bd -->
			<div class="mod-ft">
		    	<pg:pager items="${logPager.total}" maxPageItems="10" maxIndexPages="10" url="log/find_log_success.do" export="currentPageNo = pageNumber">
		    		<pg:param name="id" value="${ip}"/>
		    		<pg:param name="username" value="${username}"/>
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
