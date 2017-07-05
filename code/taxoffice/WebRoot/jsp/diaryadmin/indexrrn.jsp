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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/bootstrap.min.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
  </head>
  <body>
  	<form action="" class="form-horizontal ajax_form">
  	<div class="container-f">
  	  <div class="box-title clearfix tab-title">
  	  </div>
	<div class="box-content clearfix">
  	<div class="search">
  	
  	 <fieldset>
  	  <legend>
  	 <span>日志查询</span>
  	 </legend>
  		<table>
  		<tr>
  		<td style="height:50px"><span>查询条件：</span></td>
  		<td style="height:50px">
  		<select style="width: 150px;padding: 5px 2px;cursor: pointer;" >
  			<option value="1" checked="checked"/>操作人</option>
			<option value="2">操作人所属单位</option>
			<option value="3">操作时间</option>
			<option value="4">操作名称</option>
			<option value="5">操作所属权限</option>
			<option value="6">操作所属角色</option>
  		</select>
  		</td>
  		<td style="padding-right: 80px;"><input type="text" class="input-medium ipt_require" style="height:30px;"></td>
  		
  		<td style="padding-right: 80px;"><a class="btn cf" href="javascript:void(0)"><i class="fa fa-search "></i>查询 </a></td>
  		<td style="padding-right: 20px;"><a class="btn cf" href="javascript:void(0)"></i>导出 </a></td>
  		</tr>
  		</table>
  
  	</div>
  	</fieldset>
  	<fieldset  style="margin-top:30px;">
  	 <legend>
  	 <span style="font-weight: bold;font-size: 14px;">日志列表</span>
  	 </legend>
  	<div class="show tab-lbgl">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>序号</th>
  				<th>操作人</th>
  				<th>操作人所属单位</th>
  				<th>操作名称</th>
  				<th>操作所属角色</th>
  				<th>详细</th>
  			</tr>
  			<tr>
  				<td>1</td>
  				<td>030400000000034</td>
  				<td>办公室</td>
  				<td>借用</td>
  				<td>财务部门资产管理员</td>
  				<td>
					<a class="btn" id="btnset">查看</a>
				</td>
  				
  			</tr>
  				<tr>
  				<td>2</td>
  				<td>030400000000022</td>
  				<td>办公室</td>
  				<td>借用</td>
  				<td>财务部门资产管理员</td>
  				<td>
					<a class="btn" id="btnset1" >查看</a>
				</td>
  				
  			</tr>
  		</table>
  	</div>
  	<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
  	</div>
  </fieldset>	
  	
 </div>
  	</form>
  	
  	
  		
  	<div class="modal fade" id="modalset">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i></i>查看详情</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<div class="show tab-lbgl">
						
						<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" id="modal_add" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									操作时间：
								</label>
								<div class="controls">
									<label class="control-label" style="width:200px;" for="web_bg">
									2016年12月12日 12:23:12
								</label>
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									操作所属权限：
								</label>
								<div class="controls">
									<label class="control-label" for="web_bg">
									用户管理模块添加功能
								</label>
								</div>
							</div>
						</form>
				
						
						
						
						
						
						
						
						
						
  		<!-- <table class="table-hover dataTable">
  			<tr>
  				
  				<th>操作时间</th>
  				<th>操作所属权限</th>
  			</tr>
  			<tr>
  				
  				<td>2016年12月12日 12:23:12</td>
  				<td>用户管理模块添加功能</td>
  			</tr>
  	
  		</table> -->
  	
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						
						<a href="javascript:void(0)" class="btn btn-primary"  data-dismiss="modal">确定</a>
						
						<a href="javascript:void(0)" class="btn btn-primary"  data-dismiss="modal">取消</a>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript"src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
		<script type="text/javascript"src="<%=basePath%>Public/Js/bootstrap.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<script>
		$("#btnset").click(function(){
		$("#modalset").modal("toggle");
		});
	    	$("#btnset1").click(function(){
	    	$("#modalset").modal("toggle");
	    	});
		
	</script>
	<script type="text/javascript">
		$('.pagination').pagination(100, {
			callback : function(page) {
				console.log(page + 1);
			},
			display_msg : true,
			setPageNo : true
		});

	</script>
  </body>
</html>
