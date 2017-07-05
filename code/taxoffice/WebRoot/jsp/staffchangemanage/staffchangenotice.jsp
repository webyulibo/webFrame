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

<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/input.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
<style>
.td {
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	vertical-align: top;
	height:50px;
}

.tab td {
	padding-top: 20px;
		padding-right:20px;	
}

/* .btn {
	padding: 3px 8px 0px 8px;
} */
</style>

</head>
<body>
	<div class="container-f">
	  	 <div class="box-title clearfix tab-title"> <!-- 标题 -->
			<h3 class="current">
				<a href="<%=basePath %>jsp/staffchangemanage/staffchangenotice.jsp">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3>
			<h3 >
				<a href="<%=basePath %>jsp/staffchangemanage/staffchangelist.jsp">
				<span class="fa fa-cog"></span>
				人员变动列表
				</a>
			</h3>
		</div>
	<div style="width:900px; margin-left:200px;margin-top:50px">  <!-- 表格 -->
	<form action="" name="return">
		<fieldset class="search" style="margin-top:20px;">
  			<legend><span style="font-size:14px;">人员变动通知</span></legend>
				<table class="table-hover dataTable" width="900px" >
			<tr>
				<td width="180px"><center>姓名：</center></td>
				<td><input type="" name="" style="width:100%;height:35px"></td>
				<td width="130px"><center>岗位变动：</center></td>
				<td><input type="" name="" style="width:100%;height:35px"></td>
			</tr>
			<tr>
				<td width="130px"><center>原部门：</center></td>
				<td><input type="" name="" style="width:100%;height:35px"></td>
				<td><center>新部门:</center></td>
				<td><input type="" name="" style="width:100%;height:35px"></td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>财务部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea  style="width:100%;height:100%"></textarea></td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>使用部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea style="width:100%;height:100%"></textarea></td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>机关服务中心办理情况：</center></td>
				<td colspan="3" height="140px"><textarea style="width:100%;height:100%"></textarea></td>
			</tr>
		</table>
	</fieldset>		
		<div style="margin-left:700px;margin-top:30px;"> <!-- 保存&清空  -->
			<span> <input type="button" class="btn btn-primary" id="edit"
				value="保存" onclick="javascript:void(0)">
			</span> <span style="padding-left:5px;"> <input type="button"
				class="btn btn-primary" id="edit" value="清空" onclick="javascript:void(0)">
			</span>
		</div>
	</form>
	</div>
</div>
<script type="text/javascript">
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo'});//绑定元素
		}();
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo2'});//绑定元素
		}();
</script>
</body>
</html>
