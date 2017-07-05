<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>消息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/input.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	<style type="text/css">
		table tr td{
			width:100px;
			height:50px;
			font-size: 12px;
		}
		body{
			min-width: 1080px;
		}
		#list > table tbody tr td{
			height:50px;
			font-size: 15px;
			text-align: center;
		}
		#messagemain{
			background-color:white;
		}
		#messagemain:hover{
			background-color:#F3F3F3;
		}
	</style>
</head>
<body>
	<div class="container-f">
		 <div class="box-title clearfix tab-title">
			<h3>
				<a href="<%=basePath%>jsp/informationnotice/financialmanagement/index.jsp">
				<span class="fa fa-table"></span>
				发送通知
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath%>jsp/informationnotice/financialmanagement/list.jsp">
				<span class="fa fa-bar-chart-o"></span>
				查看通知列表
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/informationnotice/financialmanagement/staffchangenotice.jsp">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3>
		</div> 
		<div class="box-content clearfix" style="padding:10px 5px;width:100%;">
			<div style=" float:right;margin-right:20px;">
				<a href="<%=basePath%>jsp/informationnotice/financialmanagement/list.jsp" class="btn btn-primary ">返回</a>
		   </div>
		</div>
		<div style="margin-top:0px;padding:10px 5px;" id="list">
			<table class="table-hover dataTable">
				<tbody>
					<tr>
						<td style="width:30%">消息标题</td>
						<td style="width:70%">机关服务中心通知</td>
					</tr>
					<tr>
						<td>发送人</td>
						<td>刘杰</td>
					</tr>
					<tr>
						<td>发送时间</td>
						<td>2016-7-24 12:00:00</td>
					</tr>
					<tr>
						<td>所属部门</td>
						<td>资产管理部门</td>
					</tr>
					<tr>
						<td>状态</td>
						<td>已读</td>
					</tr>
					<tr>
						<td>消息概要</td>
						<td>
							<textarea id="messagemain" rows="8" style="text-align:left;width:100%;border:none;" readonly>这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息,这是一则消息，这是一则消息这是一则消息，这是一则消息这是一则消息，这是一则消息</textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript">
		function clear(x){
			if(x.value=="请输入查询条件"){
				x.value='';
			}
		}
		function goback(x){
			if (x.value=='') {
				x.value='请输入查询条件';
			}
		}
	</script>
</body>
</html>