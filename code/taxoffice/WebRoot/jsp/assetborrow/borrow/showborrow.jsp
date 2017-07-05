<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
      <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css"  href="<%=basePath %>Public/Css/bootstrap.min.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	  <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
    <title>税务局管理系统</title>
  </head>
  
  <body>
    <div class="container-f">
	  	 <div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="<%=basePath %>jsp/assetborrow/borrow/addborrow.jsp">
				<span class="fa fa-table"></span>
				资产借用
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/assetborrow/return/addreturn.jsp">
				<span class="fa fa-cog"></span>
				资产归还
				</a>
			</h3>
		</div>
		<div style="margin-top:20px;margin-left:10px;">
			<a class="btn btn-primary"
				href="<%=basePath %>jsp/assetborrow/borrow/addborrow.jsp">返回</a>
		</div>
		<fieldset class="search" style="margin-top:20px;">
  	<legend><span style="font-size:14px;">资产借用记录列表</span></legend>
  	<div class="show tab-lbgl">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>借出单号</th>
  				<th>资产编号</th>
  				<th>资产名称</th>
  				<th>借出日期</th>
  				<th>借出部门</th>
  				<th>借出人</th>
  				<th>批准人</th>
  				<th>拟还日期</th>
  				<th>借用部门</th>
  				<th>借用人</th>
  				<th>详细</th>
  			</tr>
  			<tr>		
  				<td>1343536</td>
  				<td>1343536</td>
  				<td>电脑</td>
  				<td>2016-1-1</td>
  				<td>办公室</td>
  				<td>刘仁鹏</td>
  				<td>于海强</td>
  				<td>2016-3-4</td>
  				<td>秘书部</td>
  				<td>董浩</td>
  				<td>
  				<a href="javascript:void(0)" class="btn" rel="tooltip" title="查看" id="btncheck">
				<i class="fa fa-search"></i>查看</a>
  				</td>
  			</tr>
  		</table>
  		
  	</div>
  	  <div class="pagination ue-clear" style="margin-top:20px;margin-bottom:50px;"></div>
  	 <div class="modal fade" id="modaladd">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-edit"></i>资产借用</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<h2 style="font-weight:bold;"for="web_bg">
								<input type="hidden" value="" id="codevalue">
								<div id="text">	
									<span>csgv</span>
								</div>
									
								</h2>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div> 

     </fieldset>
	</div>
	<script type="text/javascript">
	$(function(){
		$('.pagination').pagination(100, {
			callback : function(page) {
				console.log(page + 1);
			},
			display_msg : true,
			setPageNo : true
		});
		 $("#btncheck").click(function(){
			$("#modaladd").modal("toggle");
    		
		}); 
	});
	</script>
  </body>
</html>
