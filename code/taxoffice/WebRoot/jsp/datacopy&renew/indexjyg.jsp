<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<link rel="stylesheet" type="text/css"href="<%=basePath%>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css"href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css"href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css"href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	<style type="text/css">
		table tr td {
			width: 100px;
			height: 50px;
			font-size: 12px;
		}

		body {
			min-width: 700px;
		}


		#list > fieldset > table tr td{
			height:30px;
			font-size: 15px;
			text-align: center;
		}
		#list > fieldset > table tr th{
			height:30px;
			font-size: 15px;
		}
		fieldset{
			margin-top:20px;
			margin-bottom:10px;
			padding-top:15px;
			padding-bottom:5px;
			padding-left:10px;
			padding-right:10px;
		}
		legend{
			font-weight: bold;
			font-size: 14px;
		}
</style>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
     <style>
     
		div.modal-footer{
			padding:0px;
		}
		div.modal-header{
			padding:0px;
			padding-top:10px;
			padding-left:30px;
		}
		.modal_save,.modal_giveUp{
			height:30px;
		}
		.modal_save{
			padding-top:5px;
			margin-left:105px;
			padding-bottom:10px;
		}
		.modal_giveUp{
			padding-top:7px;
			padding-bottom:8px;
			margin-right:50px;
		}
		.hr{
 		 border-bottom:1px solid #ddd; padding: 5px 3px 15px; min-height:30px
  		}
     
     </style>
  </head>
  
  <body>
        <div class="container-f">
		<div class="hr"></div>
		<br />
  <div class="container-f">
		<div class="box-content clearfix">
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a style="width:80px;margin-left:4px;" id="btnAdd" class="btn cf"> <i class="fa fa-plus"></i><span>新增备份</span></a>
					</div>
				</div>
			</div>	
		</div>
 		<div style="margin-top:10px;" id="list">
			<fieldset>
			<legend >部门管理</legend>
		<table id="tableinfo" class="table-hover dataTable">
			<tr>
				<th>序号</th>
				<th>备份名称</th>
				<th>备份时间</th>
				<th>备份说明</th>
                <th class="tab-th">操作</th>
			</tr>
			<tr>
				<td class="tab-td">001</td>
				<td class="tab-td">管理部门</td>
				<td class="tab-td">10</td>
                <td class="tab-td">启用</td>
				<td class="tab-td">
					<a href="javascript:if(confirm('确定要恢复此备份吗?')){deleteItem('rr')}else{}"  class="btn" style="width:65px;"><i class="fa fa-plus"></i>恢复备份</a>
					<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem('rr')}else{}" class="btn"style="width:65px;" ><i class="fa fa-times"></i>删除备份</a>
				</td>
			</tr>
			<tr>
				<td class="tab-td">001</td>
				<td class="tab-td">管理部门</td>
				<td class="tab-td">10</td>
                <td class="tab-td">启用</td>
				<td class="tab-td">
					<a href="javascript:if(confirm('确定要恢复此备份吗?')){deleteItem('rr')}else{}"  class="btn"  style="width:65px;"><i class="fa fa-plus"></i>恢复备份</a>
					<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem('rr')}else{}" class="btn" style="width:65px;"><i class="fa fa-times"></i>删除备份</a>
				</td>
			</tr>				
		</table>
				<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
			</fieldset>
		</div>
</div> 
<div class="container-f">
		
		<div class="box-content clearfix">
			
		</div>
		<div style="margin-top:10px;">
			
		</div>
	</div>

	<div class="modal fade" id="tianjiabeifeng">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-plus"></i>新增备份</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									备份名称：
								</label>
								<input type="text" class="in"  id=""  >
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div style="margin-left:200px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary cf save_btn save" value="保存"  style="height:30px;padding-top:0px;" onclick="javascript:void(0)">
			</span> <span style="margin-left:5px;"> <input type="button" id="clear"  style="height:30px;padding-top:0px;"class="btn btn-primary" value="清空" onclick="javascript:void(0)">
			</span>
		</div> 
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<script type="text/javascript">
		$('.pagination').pagination(100, {
			callback : function(page) {
				console.log(page + 1);
			},
			display_msg : true,
			setPageNo : true
		});
		function clear(x) {
			if (x.value == "请输入查询条件") {
				x.value = '';
			}
		}
		function goback(x) {
			if (x.value == '') {
				x.value = '请输入查询条件';
			}
		}
	</script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/bootstrap.min.js"></script>
	<script>
		$(function(){
	    	$("#btnAdd").click(function(){
	        	$("#tianjiabeifeng").modal("toggle");
	    	});
	    });
	    
	</script>
   
  </body>
</html>

       
  
  </div >