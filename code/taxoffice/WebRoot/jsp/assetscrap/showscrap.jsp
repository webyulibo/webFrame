<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>税务局管理系统</title>


<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css" />

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/page.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	  <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>

</head>

<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title"></div>
	</div>
	<div style="margin:10px">
		<div style="margin-top:10px;margin-left:10px;">
			<a class="btn btn-primary"
				href="<%=basePath%>jsp/assetscrap/addscrap.jsp">返回</a>
		</div>
		<fieldset style="margin-top:10px;">
			<legend>
				<span style="font-size:14px;">报废记录列表</span>
			</legend>

			<div>
				<table class="table-hover dataTable">
					<tr>
						<th>报废单号</th>
						<th>资产编号</th>
						<th>资产名称</th>
						<th>清理日期</th>
						<th>清理方式</th>
						<th style="width:190px">备注</th>
					</tr>
					<tr style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;">
						<td>201607072222222</td>
						<td>030400000000034</td>
						<td>土地</td>
						<td>2016-7-7</td>
						<td>报损</td>
						<td>123</td>
					</tr>
					<tr style="background: rgb(243, 243, 243) none repeat scroll 0% 0%;">
						<td>201607083333333</td>
						<td>030400000000034</td>
						<td>房屋及构筑物</td>
						<td>2016-7-7</td>
						<td>报废</td>
						<td>234</td>
					</tr>
				</table>
			</div>
			<div class="pagination ue-clear" style="margin-top:30px;"></div>

		</fieldset>
	</div>
	<script type="text/javascript">
			$('.pagination').pagination(100, {
			callback : function(page) {
				console.log(page + 1);
			},
			display_msg : true,
			setPageNo : true
		});
	</script>
</body>
</html>
