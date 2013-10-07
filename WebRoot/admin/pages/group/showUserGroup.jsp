<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<title>管理员（全站）</title>
	<link rel="stylesheet" type="text/css" href="admin/assets/css/base.css" />
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css"/>
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
			window.location = "<%=basePath%>group/o_delete.do?id="+id;
		}
		//批量删除数据
		function optDeleteIn() {
			if(Pony.checkedCount("ck") <= 0) {
				alert("请选择您要操作的数据!");
				return;
			}
			if(!confirm("您确定删除吗？")) {
				return;
			}
			
			var ids = Pony.checkIn("ck");
			console.log(ids);
			window.location = "<%=basePath%>group/o_delete_in.do?ids="+ids;
		}
		//排序
		function optPriority() {
			var ck = document.getElementsByName("ck");
	        var priority = document.getElementsByName("priority");
			if(Pony.checkedCount("ck") <= 0) {
				alert("请选择您要操作的数据!");
				return;
			}else{
		        for(var i=0;i<ck.length;i++) {
		           if(ck[i].checked) {
		            	window.location = "<%=basePath%>group/o_priority.do?id="+ck[i].value+"&priority="+priority[i].value;
		           }
		        }
			}
		}
		
	</script>
</head>
<body>
	<div class="container">
		<div class="toolbar">
			<div class="crumbs">
				<a href="#">用户管理</a> -&gt; <a href="#">管理员（全站）</a> -&gt; <span>列表</span>
			</div>
			<div class="action">
				<a href="group/v_add.do" class="btn" target="_self">添加</a>
			</div>
		</div>
		<div class="mod">
			<div class="bd">
				<table class="ui-table">
					<thead>
						<tr>
							<th width="30"><input type="checkbox" name="ck_all" id="ck_all" onclick="Pony.checkboxSlt('ck',this.checked);"/></th>
							<th>ID</th>
							<th>名称</th>
							<th>每日附件总尺寸</th>
							<th>最大附件尺寸</th>
							<th>排列顺序</th>
							<th>默认组</th>
							<th>评论需要审核</th>
							<th>评论需要验证码</th>
							<th width="140">操作选项</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="flag" items="${groups}">
						<tr>
							<td class="tc"><input type="checkbox" name="ck" value="${flag.id}"/></td>
							<td>${flag.id}</td>
							<td>${flag.name}</td>
							<td>${flag.allowPerDay}</td>
							<td>${flag.allowMaxFile}</td>
							<td>
								<input type="text" value="${flag.priority}" name="priority" maxlength="8" class="w40"/> 
							</td>
							<td class="tc">
							<c:choose>
								<c:when test="${flag.regDef == 1}">
									<input type="radio" name="regDef_${flag.id}" value="${flag.id}" checked="checked"/>
								</c:when>
								<c:otherwise>
									<input type="radio" name="regDef_${flag.id}" value="${flag.id}"/>
								</c:otherwise>
							</c:choose>	
							</td>
							<td class="tc">
							<c:choose>
								<c:when test="${flag.needCheck == 1}">
									是
								</c:when>
								<c:otherwise>
									否
								</c:otherwise>
							</c:choose>
							</td>
							<td class="tc">
							<c:choose>
								<c:when test="${flag.needCaptcha == 1}">
									是
								</c:when>
								<c:otherwise>
									否
								</c:otherwise>
							</c:choose>
							
							</td>
							<td class="tc">
								<a href="group/v_update.do?id=${flag.id}" class="btn">修改</a> 
								<a href="javascript:;" class="btn" onclick="optDelete(${flag.id});">删除</a>
							</td>
						</tr>
					</c:forEach>	
					</tbody>
					<tfoot>
						<tr>
							<td colspan="10">
								<a href="javascript:;" class="btn" onclick="optDeleteIn();">批量删除</a>
								<a href="javascript:;" class="btn" onclick="optPriority();">保存排列顺序</a>
							</td>
						</tr>
					</tfoot>
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