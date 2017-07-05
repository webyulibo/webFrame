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

<title>发送消息</title>

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
<style>
.tab td {
	height: 50px;
	vertical-align: middle;
	padding-top: 20px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	padding-right:20px;
}
</style>

</head>
<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="<%=basePath%>jsp/informationnotice/informationcenter/index.jsp">
				<span class="fa fa-table"></span>
				发送通知
				</a>
			</h3>
			<h3>
				<a href="<%=basePath%>jsp/informationnotice/informationcenter/list.jsp">
				<span class="fa fa-bar-chart-o"></span>
				查看通知列表
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/informationnotice/informationcenter/staffchangenotice.jsp">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3>
		</div> 
	<div class="control-group f_l" style="min-width:1100px">
	<form action="" name="borrow">
	<div style="margin-top:30px;margin-left:100px;">
		<div>
			<table class="tab">
				<tr>
					<td>消息标题：</td>
					<td><input type="text" class="in" name="purchasedata"></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td style="padding-left:15px;">发送人：</td>
					<td width="250px">
						<select class="easyui-combobox" name="id" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td width="100px">所属部门：</td>
					<td width="250px">
						<select class="easyui-combobox" name="name" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td width="100px">接收部门：</td>
					<td width="250px">
						<select class="easyui-combobox" name="name" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td align="left" valign="top">消息概要：</td>
					<td colspan="3">
						<textarea rows="4" style="width:550px" value="" name="dealresult"></textarea>
					</td>
				</tr>
			</table>
			
		</div>
		<div style="margin-left:565px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary" id="edit"
				value="发送" onclick="javascript:void(0)">
			</span> <span style="padding-left:5px;"> <input type="button"
				class="btn btn-primary" id="edit" value="清空" onclick="javascript:void(0)">
			</span>
		</div>
	</div>
	</form>
	</div>
</div>
<script type="text/javascript">
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo'});//绑定元素
		}();
</script>
</body>
</html>
