<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<title>管理员（全站）</title>
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
							<th width="30"><input type="checkbox" name="ck_all" c id="ck_all" onclick="Pony.checkboxSlt('ck',this.checked);"/></th>
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
								<a href="javascript:;" class="btn">批量删除</a>
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