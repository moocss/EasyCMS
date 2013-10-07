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
	<title>会员管理添加</title>
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
			window.location = "<%=basePath%>member/o_delete.do?id="+id;
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">会员管理</a> -&gt; <span>添加</span>
			</div>
			<div class="action">
				<a href="member/v_add.do" class="btn" target="_self">添加</a>
			</div>
		</div>
		<div class="mod">
			<div class="bd">
    		<table class="ui-table">
    			<thead>
    				<tr>
						<th width="30">
							<input type="checkbox" name="ck_all" id="ck_all" onclick="Pony.checkboxSlt('ck',this.checked);"/>
						</th>
						<th>ID</th>
						<th>用户名</th>
						<th>电子邮箱</th>
						<th>会员组</th>
						<th>最后登录</th>
						<th>登录</th>
						<th>禁用</th>
						<th width="140">操作选项</th>
    				</tr>
    			</thead>
    			<tbody>
    			<c:forEach var="flag" items="${userPager.pageList}" varStatus="status">
    				<c:choose>
    					<c:when test="${status.index % 2 ==0 }">
    						<tr>
    					</c:when>
    					<c:otherwise>
    						<tr class="even">
    					</c:otherwise>
    				</c:choose>
    							<td class="tc"><input type='checkbox' name='ck' value='${flag.id}' /></td>
								<td>${flag.id}</td>
								<td>${flag.username}</td>
								<td>${flag.email}</td>
								<td>${flag.userGroup.name}</td>
								<td>${flag.lastLoginTime}</td>
								<td>${flag.loginCount}</td>
								<td>${flag.disabled}</td>
								<td>
									<a class="btn" href="member/v_update.do?id=${flag.id}">修改</a>
									<a href="javascript:;" class="btn" onclick="optDelete(${flag.id});">删除</a>
								</td>
	    					</tr>
    			</c:forEach>
    			</tbody>
    		</table>
			</div>
			<!-- /.mod-bd -->
			<div class="ft">
		    	<pg:pager items="${userPager.total}" maxPageItems="10" maxIndexPages="10" url="member/v_list.do" export="currentPageNo = pageNumber">
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
			</div>
			<!-- /.mod-ft -->
		</div>
		<!-- /.mod -->
	</div>
	<!-- /.container  -->
</body>
</html>
