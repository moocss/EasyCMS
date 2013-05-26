<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分页列表页面测试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css">
  </head>
  
  <body>
  
    <div class="mod">
    	<div class="hd">
    		<h2 class="tc">数据列表</h2>
    	</div><!-- /.mod-hd -->
    	<div class="bd">
    		<table class="ui-table">
    			<thead>
    				<tr>
    					<th width="60">编号</th>
    					<th>用户名</th>
    					<th>密码</th>
    					<th width="120">操作</th>
    				</tr>
    			</thead>
    			<tbody>
    			<c:forEach var="flag" items="${pager.pageList}" varStatus="status">
    				<c:choose>
    					<c:when test="${status.index % 2 ==0 }">
    						<tr>
    					</c:when>
    					<c:otherwise>
    						<tr class="even">
    					</c:otherwise>
    				</c:choose>
	    				<td class="tc">${flag.id}</td>
	    				<td>${flag.username}</td>
	    				<td>${flag.password}</td>
	    				<td class="tc"><a href="javascript:;">修改</a></td>
	    			</tr>
    			</c:forEach>
    			</tbody>
    		</table>
    	</div><!-- /.mod-bd -->
    	<div class="ft">
    	<pg:pager items="${pager.total}" maxPageItems="10" maxIndexPages="5" url="account/pager" export="currentPageNo = pageNumber">
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
    </div><!-- /.mod -->
    
  </body>
</html>
