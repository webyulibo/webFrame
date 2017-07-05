<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/pageuri" prefix="cc"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	
	<title>权限管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	
	<script type="text/javascript">
	function getInfoByPage() {
		var inputpage=document.getElementById("inputPage").value;
		
		if(inputpage.length==0){
		
			document.getElementById("inputPage").value="";
			return;
		}
		else{
			
			if(!isNaN(inputpage)){
				
				var totalPage=document.getElementById("inputPage").getAttribute("totalPage");
				
				if(parseInt(inputpage)>parseInt(totalPage)){
					document.getElementById("inputPage").value="";
					document.getElementById("inputPage").focus();
					return ;
				}
				else{
					
					var urlwithpage=document.getElementById("inputPage").getAttribute("url");
					var bool=urlwithpage.indexOf('?');						
					if(bool>0){
						urlwithpage=urlwithpage+'&currentPage='+inputpage;
					}
					else{
						urlwithpage=urlwithpage+'?currentPage='+inputpage;
					}
					window.location.href=urlwithpage;
				}										
			}
			else{
				document.getElementById("inputPage").value="";
				alert("请输入合法的数字");
			}
		}						
	}
	</script>
	
	
	<style type="text/css">
		body {
			min-width: 700px;
		}
		
		fieldset{
			margin-top:20px;
			margin-bottom:10px;
			padding-top:15px;
			padding-bottom:5px;
			padding-left:10px;
			padding-right:10px;
		}
		legend{
			font-weight: bold;
			font-size: 14px;
		}
</style>
</head>
<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3>
				<a href="<%=basePath %>AdminRoleController/index.htm">
					<span class="fa fa-table"></span> 角色管理
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>AdminAuthController/showpropertymanagewithpage.htm">
					<span class="fa fa-cog"></span> 权限管理
				</a>
			</h3>
		</div>
		<div style="margin-top:10px;" id="list">
			<fieldset>
			<legend>权限管理</legend>
				<table id="tableinfo" class="table-hover dataTable">
					<tr>
						<th style="background-color:#eee;width:25% ">权限名称</th>
						<th style="background-color:#eee;width:75%">权限描述</th>
					</tr>
					<c:if test="${not empty authorities }">
						<c:forEach items="${authorities }" var="authority">
						<tr>
						<td>${authority.authorityname}</td>
						<td>${authority.authorityremark}</td>
						</tr>						
						</c:forEach>					
					</c:if>
					<c:if test="${empty authorities }">
						暂无数据
					</c:if>					
				</table>
				
				<cc:page value="${pager}" url="AdminAuthController/showpropertymanagewithpage.htm"></cc:page>	
				
				<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
			</fieldset>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<script type="text/javascript">
		/* $('.pagination').pagination(100, {
			callback : function(page) {
				console.log(page + 1);
			},
			display_msg : true,
			setPageNo : true
		}); */
		function clear(x) {
			if (x.value == "请输入查询条件") {
				x.value = '';
			}
		}
		function goback(x) {
			if (x.value == '') {
				x.value = '请输入查询条件';
			}
		}
		
	</script>
</body>
</html>

