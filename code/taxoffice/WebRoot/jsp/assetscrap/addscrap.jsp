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
	href="<%=basePath%>Public/Css/input.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/themes/material/easyui.css" />
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
<style>
.td {
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	width:80px;
}

.tab td {
	height: 50px;
	vertical-align: top;
	padding-right:20px;
	font-size: 15px;
	min-width:100px;
}

.fbtn {
	width: 120px;
}
</style>

</head>
<script type="text/javascript">

		Date.prototype.format = function(partten)
		{

			if(partten ==null||partten=='')

			{

				partten = 'y-m-d'	;

			}

			var y = this.getFullYear();

			var m = this.getMonth()+1;

			var d = this.getDate();

			var r = partten.replace(/y+/gi,y);

			r = r.replace(/m+/gi,(m<10?"0":"")+m);

			r = r.replace(/d+/gi,(d<10?"0":"")+d);

			return r; 

		}

		//调用方式
		//alert((new Date()).format("ymd"));
		//var my = document.getElementById("aaaa");
		//alert(my.value);
		//document.getElementById("scrapNum").value = (new Date()).format('ymd');
		
	</script>

<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title"></div>
	</div>
	<div style="margin-top:40px;margin-left:100px;">
		<a class="btn fbtn" href="<%=basePath%>jsp/assetscrap/showscrap.jsp">
			<i class="fa fa-plus"></i><span>查看报废记录列表</span>
		</a>
	</div>
	<div style="margin-top:50px;margin-left:100px;min-width:1100px;">
		<div>
			<table class="tab">
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">报废单号：</td>
					<td width="250px"><input type="text" class="in"    name="scrapNum" readonly="readonly" id="scrapNum" value="aa"></td><!-- scrapNum -->
					<td class="td" ALIGN="left" VALIGN="top">资产名称：</td>
					<td><input type="text" class="in"></td>
				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">资产编号：</td>
					<td><select class="easyui-combobox" name="state"
						style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
					</select></td>
					<td class="td" ALIGN="left" VALIGN="top">清理方式：</td>
					<td><select name="state"
						style="width:150px;height:30px;border:solid 1px #ddd;padding-left:7px;">
							<option value="报损">报损</option>
							<option value="报废">报废</option>
					</select></td>
				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">清理日期：</td>
					<td><input type="text"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="申请日期"
						class="laydate-icon" id="demo" value=" 2016-06-15 "
						name="purchasetime"
						style="text-align:center;height:25px;width:150px;"></td>

				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top" ">备注：</td>
					<td colspan="3"><textarea rows="4" style="width:545px;"
							value="" name="remark"></textarea></td>
				</tr>
			</table>
		</div>
		<div style="margin-left:560px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary" value="保存" onclick="javascript:void(0)">
			</span> <span style="margin-left:5px;"> <input type="button"
				class="btn btn-primary" value="清空" onclick="javascript:void(0)">
			</span>
		</div>
	</div>
	<script type="text/javascript">
		!function() {
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({
				elem : '#demo'
			});//绑定元素
		}();
		
		$("#scrapNum").val( (new Date()).format('ymd')+Math.floor(Math.random()*8999999+1000000).toString());	
	</script>
</body>
</html>
