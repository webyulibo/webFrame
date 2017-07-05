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



.tab td {
	height: 50px;
	vertical-align: top;
	padding-top: 20px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	padding-right:20px;
}
	input[readonly]{
		background-color:white;
	}

/* .btn {
	padding: 3px 8px 0px 8px;
} */
</style>

</head>
<body>
		<div class="container-f">
		<div class="lbgl-top-left f_1" style="margin-top:60px;margin-left:100px;">
			<a href="<%=basePath %>jsp/assetmaintain/showmaintain.jsp" class="btn btn-add" style="width:110px;">
			<i class="fa fa-plus"></i><span>查看维修记录列表</span>
			</a>
		</div>
	<div class="control-group f_l" style="min-width:1100px">
	<form action="" name="borrow">
	<div style="margin-top:30px;margin-left:100px;">
		<div>
			<table class="tab">
				<tr>
					<td>资产编号：</td>
					<td width="250px">
						<select class="easyui-combobox" name="id" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
						</select>
					</td>
				
					<td width="100px">资产名称：</td>
					<td width="250px">
						<select class="easyui-combobox" name="name" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
						</select>
					</td>
				</tr>
				<tr>
					<td>购置日期：</td>
					<td><input type="text" readonly="true" class="in" name="purchasedata"></td>
				
					<td>规格型号：</td>
					<td><input type="text" readonly="readonly" class="in" name="model"></td>
				</tr>
				<tr>
					<td>报废年限：</td>
					<td><input type="text" readonly="true" class="in" name="discarded"></td>
					<td>经手人：</td>
					<td>
						<select class="easyui-combobox" name="guy" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value="小红">小红</option>
							<option value="小黑">小黑</option>
							<option value="小绿">小率</option>
						</select>
					</td>
					
				</tr>
				<tr>
					<td>送修日期：</td>
					<td>
						<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
						placeholder="送修日期" class="laydate-icon" id="demo2" value=" 2016-06-15 " 
						name="senddate" style="text-align:center;height:25px;">
					</td>
				<tr>
					<td align="left" anlign="top">故障描述：</td>
					<td colspan="3">
						<textarea rows="4" style="width:550px" value="" name="faultdescription"></textarea>
					</td>
				</tr>
				<tr>
					<td align="left" valign="top">办理结果：</td>
					<td colspan="3">
						<textarea rows="4" style="width:550px" value="" name="dealresult"></textarea>
					</td>
				</tr>
			</table>
			
		</div>
		<div style="margin-left:565px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary" id="edit"
				value="保存" onclick="javascript:void(0)">
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
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo2'});//绑定元素
		}();
</script>
</body>
</html>
