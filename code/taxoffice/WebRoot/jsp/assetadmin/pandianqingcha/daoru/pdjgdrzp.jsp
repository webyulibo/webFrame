<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>盘点结果导入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome/css/font-awesome.css" />
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.js"></script>
	<style type="text/css">
		table tr td{
			width:100px;
			height:50px;
			font-size: 12px;
		}
		body{
			min-width: 700px;
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
				<a href="<%=basePath %>jsp/assetadmin/pandianqingcha/daochu/pdsjdczp.jsp">
				<span class="fa fa-table"></span>
				盘点数据导出
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>jsp/assetadmin/pandianqingcha/daoru/pdjgdrzp.jsp">
				<span class="fa fa-cog"></span>
				盘点结果导入
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/assetadmin/pandianqingcha/jilu/pdlsjlzp.jsp">
				<span class="fa fa-bar-chart-o"></span>
				盘点历史记录
				</a>
			</h3>
		</div> 
		<div class="box-content clearfix">
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a style="margin-top:10px;margin-left:4px;" class="btn cf" href="#"> <i class="fa fa-edit"></i><span>导入</span></a>
					</div>
				</div>
			</div>	
			<div class="control-group f_l">
				<div class="f_l">
					<table>
						<tr>
							<td><h3>盘点编号:</h3></td>
							<td><input type="text" style="width:163px;height:30px;"></td>
							<td></td>
						</tr>
						<tr>
							<td><h3>盘点人:</h3></td>
							<td><input type="text" style="width:163px;height:30px;"></td>
							<td><input type="button" id="searchBtn" value="提交" class="btn btn-primary" style="margin-left:75px"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<hr/>
		<div class="box-content clearfix">
			<div class="control-group f_l">
				<div class="f_l">
					<table>
						<tr>
							<td><h3>备注:</h3></td>
							<td><textarea style="width:300px;height:100px;margin-top:20px;margin-bottom:20px;"></textarea></td> 
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div style="margin-top:10px;" id="list">
			<table  class="table-hover dataTable">
				<tr>
					<th style="background-color:#eee;">序号</th>
					<th style="background-color:#eee;">资产代码</th>
					<th style="background-color:#eee;">资产名称</th>
					<th style="background-color:#eee;">资产类型</th>
					<th style="background-color:#eee;">规格型号</th>
					<th style="background-color:#eee;">使用人</th>
					<th style="background-color:#eee;">使用部门</th>
					<th style="background-color:#eee;">保管人</th>
					<th style="background-color:#eee;">保管部门</th>
					<th style="background-color:#eee;">使用状态</th>
					<th style="background-color:#eee;">盘点结果</th>
				</tr>
				<tr>
					<td>1</td>
					<td>030400000000022</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>漏盘</td>
				</tr>
				<tr>
					<td>2</td>
					<td>030400000000034</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>漏盘</td>
				</tr>
				<tr>
					<td>3</td>
					<td>030400000000055</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>漏盘</td>
				</tr>
				<tr>
					<td>4</td>
					<td>030400000000078</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>已盘</td>
				</tr>
				<tr>
					<td>5</td>
					<td>030400000000092</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>已盘</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
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
	</script>
</body>
</html>
		
