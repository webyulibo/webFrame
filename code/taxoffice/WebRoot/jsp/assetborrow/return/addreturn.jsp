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
	  	 <div class="box-title clearfix tab-title">
			<h3 >
				<a href="<%=basePath %>jsp/assetborrow/borrow/addborrow.jsp">
				<span class="fa fa-table"></span>
				资产借用
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>jsp/assetborrow/return/addreturn.jsp">
				<span class="fa fa-cog"></span>
				资产归还
				</a>
			</h3>
		</div>
	<div class="lbgl-top-left f_1" style="margin-top:60px;margin-left:100px;">
			<a href="<%=basePath %>jsp/assetborrow/return/showreturn.jsp" class="btn btn-add" style="width:110px;">
			<i class="fa fa-plus"></i><span>查看归还记录列表</span>
			</a>
		</div>
	<form action="" name="return">
	<div style="margin-top:30px;margin-left:100px;min-width:1100px">
		<div>
			<table class="tab">
				<tr>
					<td class="td">归还编号：</td>
					<td width="250px"><input type="text" class="in"></td>
					<td class="td">借出单号：</td>
					<td><input type="text" class="in"></td>
				</tr>
				<tr>
					<td class="td">归还日期：</td>
					<td>
						<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
						placeholder="申请日期" class="laydate-icon" id="demo" value=" 2016-06-15 " 
						name="purchasetime" style="text-align:center;height:25px;">
					</td>
					<td class="td">资产编号：</td>
					<td><input type="text" class="in"></td>
				</tr>
				<tr>
					<td class="td">归还人：</td>
					<td>
						<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value="办公室">小红</option>
							<option value="秘书部">小绿</option>
						</select>
					</td>
					<td class="td">资产名称：</td>
					<td>
						<input type="text" class="in">
					</td>
				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">备注：</td>
					<td colspan="3">
						<textarea rows="4" style="width:545px" value="" name="remark"></textarea>
					</td>
				</tr>
			</table>
		</div>
		<div style="margin-left:560px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary" id="edit"
				value="保存" onclick="javascript:void(0)">
			</span> <span style="padding-left:5px;"> <input type="button"
				class="btn btn-primary" id="edit" value="清空" onclick="javascript:void(0)">
			</span>
		</div>
	</div>
	</form>
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
