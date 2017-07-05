<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
  </head>
  <body>
  	<form action="" class="form-horizontal ajax_form">
  	<div class="container-f">
  	 <div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/admin/indexlmy.jsp">
				<span class="fa fa-table"></span>
				资产管理
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/daoru/indexkw.jsp">
				<span class="fa fa-cog"></span>
				资产信息导入
				</a>
			</h3>
			<h3 >
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/daochu/indexlmy.jsp">
				<span class="fa fa-bar-chart-o"></span>
				资产信息导出
				</a>
			</h3>
		</div> 
	<div class="box-content clearfix">
  	<div class="search">
  		<div class="searchty">
  		<input type="checkbox" name="option" class="checkbox"><span>资产类型：</span>
  		<select style="width: 150px;padding: 5px 2px;cursor: pointer;" >
  			<option value="1" checked="checked"/>使用人</option>
			<option value="2">使用部门</option>
			<option value="3">保管人</option>
			<option value="4">保管部门</option>
			<option value="5">资产代码</option>
			<option value="6">全部</option>
  		</select>
  		<input type="text" class="input-medium ipt_require" style="height:30px;">
  		</div>	
  		<div class="searchty">
  		<input type="checkbox" name="option" class="checkbox"/><span>使用状态：</span>
  		<select style="width: 150px;padding: 5px 2px;cursor: pointer;">
  			<option value="1" checked="checked">在用</option>
			<option value="2">维修</option>
			<option value="3">报废</option>
			<option value="4">全部</option>
  		</select>
  		</div>
  		<div class="searchty">
  		<input type="checkbox" name="option" class="checkbox"/><span>状态：</span>
  		<select style="width: 150px;padding: 5px 2px;cursor: pointer;">
  			<option value="1" checked="checked">正常</option>
			<option value="2">丢失</option>
			<option value="3">全部</option>
  		</select>
  		</div>
  		<a class="btn cf" href="javascript:void(0)">查询 </a>
  		<a class="btn cf" href="<%=basePath%>jsp/dataadmin/assetadmin/admin/addlmy.jsp"  style="margin-left:10px;">添加</a>
  	</div>
  	<div class="show tab-lbgl">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>序号</th>
  				<th>资产编号</th>
  				<th>资产名称</th>
  				<th>使用人</th>
  				<th>使用部门</th>
  				<th>保管人</th>
  				<th>保管部门</th>
  				<th>使用状态</th>
  				<th>操作</th>
  				<th>生成标签</th>
  			</tr>
  			<tr>
  				<td>1</td>
  				<td>030400000000034</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>
  				<a href="<%=basePath%>jsp/dataadmin/assetadmin/admin/editlmy.jsp" class="btn" rel="tooltip" title="修改">
				<i class="fa fa-edit"></i>修改</a></td>
  				<td>
  				<a href="javascript:void(0)" class="btn" rel="tooltip" title="生成">
				<i class="fa fa-plus"></i>生成</a>
  				</td>
  			</tr>
  				<tr>
  				<td>2</td>
  				<td>030400000000022</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>
  				<a href="<%=basePath%>jsp/dataadmin/assetadmin/admin/editlmy.jsp" class="btn" rel="tooltip" title="修改" >
				<i class="fa fa-edit"></i>修改</a></td>
  				<td>
  				<a href="javascript:void(0)" class="btn" rel="tooltip" title="生成">
				<i class="fa fa-plus"></i>生成</a>
  				</td>
  			</tr>
  		</table>
  	</div>
  	<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
  	</div>
 </div>
  	</form>
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
		$(document).ready(function(){	
			var mycheckbox = $('.checkbox');
			if(mycheckbox.checked==true){
				alert('d');
			}
		});
	</script>
  </body>
</html>
