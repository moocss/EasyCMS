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
	<link type="text/css" rel="stylesheet" href="admin/assets/css/font-awesome.min.css"/>
	<!--[if IE 7]>
	  <link type="text/css" rel="stylesheet" href="admin/assets/css/font-awesome-ie7.min.css"/>
	<![endif]-->
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
				<a href="#">站内信管理 </a> -&gt; <span>发送站内信</span>
			</div>
			<div class="action tr">
				<a class="btn send-message" href="<%=basePath%>/message/v_add.do"><i class="icon-envelope"></i> 发送站内信</a>
				<a class="btn inbox" href="<%=basePath%>/message/v_list.do?box=0"><i class="icon-envelope"></i> 收件箱管理</a>
				<a class="btn sendbox" href="<%=basePath%>/message/v_list.do?box=1"><i class="icon-envelope"></i> 发件箱管理</a>
				<a class="btn trash" href="<%=basePath%>/message/v_list.do?box=3"><i class="icon-trash"></i> 垃圾箱管理</a>
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
						<th>标题</th>
						<th>发件人</th>
						<th>发送时间</th>
						<th>操作</th>
    				</tr>
    			</thead>
    			<tbody>
    			<c:forEach var="flag" items="${pagers.pageList}" varStatus="status">
    				<c:choose>
    					<c:when test="${status.index % 2 ==0 }">
    						<tr>
    					</c:when>
    					<c:otherwise>
    						<tr class="even">
    					</c:otherwise>
    				</c:choose>
    							<td class="tc"><input type='checkbox' name='ck' value='${flag.receiverId}' /></td>
								<td>${flag.receiverId}</td>
								<td>${flag.msgTitle}</td>
								<td>${flag.msgSendUser.username}</td>
								<td>${flag.sendTime}</td>
								<td>
									<a href="#">查看</a>
									<a href="#">删除</a>
								</td>
	    					</tr>
    			</c:forEach>
    			</tbody>
    		</table>
			</div>
			<!-- /.mod-bd -->
			<div class="ft">
		    	<pg:pager items="${pagers.total}" maxPageItems="10" maxIndexPages="10" url="message/v_list.do" export="currentPageNo = pageNumber">
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
