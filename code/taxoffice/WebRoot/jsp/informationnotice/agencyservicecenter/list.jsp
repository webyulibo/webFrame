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
		#list > table tr td{
			height:30px;
			font-size: 15px;
			text-align: center;
		}
		#list > table tr th{
			height:30px;
			font-size: 15px;
		}
	</style>
</head>
<body>
	<div class="container-f">
		 <div class="box-title clearfix tab-title">
			<h3>
				<a href="<%=basePath%>jsp/informationnotice/agencyservicecenter/index.jsp">
				<span class="fa fa-table"></span>
				发送通知
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath%>jsp/informationnotice/agencyservicecenter/list.jsp">
				<span class="fa fa-bar-chart-o"></span>
				查看通知列表
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/informationnotice/agencyservicecenter/staffchangenotice.jsp">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3>
		</div> 
		<div class="box-content clearfix" style="padding:10px 5px;">
			<fieldset>
				<legend><span style="font-size:14px;">查询条件</span></legend>
				<table style="width:100%;">
					<tr>
						<td align="right"><h3>消息标题：</h3></td>
						<td><input type="text" class="in" name="purchasedata"></td>
						<td style="" align="right"><h3>发送人：</h3></td>
						<td width="250px">
							<select class="easyui-combobox" name="id" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
								<option value=""></option>
								<option value=""></option>
								<option value=""></option>
							</select>
						</td>
						<td align="right"><h3>状态：</h3></td>
						<td width="250px">
							<select class="easyui-combobox" name="id" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
								<option value=""></option>
								<option value=""></option>
								<option value=""></option>
							</select>
						</td>
						<td align="right" style=""><h3>所属部门：</h3></td>
						<td width="250px">
							<select class="easyui-combobox" name="id" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
								<option value=""></option>
								<option value=""></option>
								<option value=""></option>
							</select>
						</td>
						<td>
							<a href="javascript:void(0)" class="btn" rel="tooltip" title="查询" id="btncheck" style="height:20px;padding-top:5px;margin-left:17px;">
								<i class="fa fa-search"></i>查询
							</a>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div style="margin-top:10px;padding:10px 5px;" id="list">
			<fieldset>
				<legend><span style="font-size:14px;">消息列表</span></legend>
				<table  class="table-hover dataTable">
					<tr style="height:50px;">
						<th style="background-color:#eee;">序号</th>
						<th style="background-color:#eee;">消息标题</th>
						<th style="background-color:#eee;">发送人</th>
						<th style="background-color:#eee;">发送时间</th>
						<th style="background-color:#eee;">所属部门</th>
						<th style="background-color:#eee;">状态</th>
						<th style="background-color:#eee;">操作</th>
					</tr>
					<tr>
						<td>1</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<a id="chakan" href="<%=basePath%>jsp/informationnotice/agencyservicecenter/detail.jsp" class="btn" style="height:20px;padding-top:5px;">
								<i class="fa fa-search"></i>查看
							</a>
							<a onclick="if(confirm('您确定要删除吗?')){alert('消息删除成功！');}else{return;}" class="btn" style="height:20px;padding-top:5px;">
								<i class="fa fa-times"></i>删除
							</a>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<a id="chakan" href="<%=basePath%>jsp/informationnotice/agencyservicecenter/detail.jsp" class="btn" style="height:20px;padding-top:5px;">
								<i class="fa fa-search"></i>查看
							</a>
							<a onclick="if(confirm('您确定要删除吗?')){alert('消息删除成功！');}else{return;}" class="btn" style="height:20px;padding-top:5px;">
								<i class="fa fa-times"></i>删除
							</a>
						</td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<a id="chakan" href="<%=basePath%>jsp/informationnotice/agencyservicecenter/detail.jsp" class="btn" style="height:20px;padding-top:5px;">
								<i class="fa fa-search"></i>查看
							</a>
							<a onclick="if(confirm('您确定要删除吗?')){alert('消息删除成功！');}else{return;}" class="btn" style="height:20px;padding-top:5px;">
								<i class="fa fa-times"></i>删除
							</a>
						</td>
					</tr>
				</table>
				<div class="pagination ue-clear" style="margin-top:10px;margin-bottom:10px;"></div>
			</fieldset>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript">
		$('.pagination').pagination(100,{
			callback: function(page){
				console.log(page+1);	
			},
			display_msg: true,
			setPageNo: true
		});
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
		
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo'});//绑定元素
		}();
	</script>
</body>
</html>