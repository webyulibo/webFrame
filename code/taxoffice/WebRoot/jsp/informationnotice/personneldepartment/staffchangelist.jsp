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
			<h3>
				<a href="<%=basePath%>jsp/informationnotice/personneldepartment/index.jsp">
				<span class="fa fa-table"></span>
				发送通知
				</a>
			</h3>
			<h3>
				<a href="<%=basePath%>jsp/informationnotice/personneldepartment/list.jsp">
				<span class="fa fa-bar-chart-o"></span>
				查看通知列表
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/informationnotice/personneldepartment/staffchangenotice.jsp">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>jsp/informationnotice/personneldepartment/staffchangelist.jsp">
				<span class="fa fa-cog"></span>
				人员变动列表
				</a>
			</h3>
		</div>
		
		<fieldset class="search" style="margin-top:20px;">
  	<legend><span style="font-size:14px;">人员变动列表</span></legend>
  	<div class="show tab-lbgl">
  		<table class="table-hover dataTable" style="min-width:1100px;">
  			<tr>
  				<th>序号</th>
  				<th>姓名</th>
  				<th>岗位变动</th>
  				<th>原部门</th>
  				<th>新部门</th>
  				<th>处理详情</th>
  			</tr>
  			<tr>		
  				<td>1343536</td>
  				<td>周杰伦</td>
  				<td>升职</td>
  				<td>财务科</td>
  				<td>办公室</td>
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
	             <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-edit"></i>人员变动记录表</h3></div>
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
									<span>这里是详情</span>
								</div>
									
								</h2>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
<!-- 						<a href="javascript:void(0)" class="btn btn-primary btn-tck2" onclick="f()" data-dismiss="modal">返回</a>
 -->	
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
