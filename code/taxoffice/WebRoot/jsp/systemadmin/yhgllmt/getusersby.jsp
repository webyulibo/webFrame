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
     <link rel="stylesheet" type="text/css" 
    href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css"
	 href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/themes/material/easyui.css" />
    <link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" 
	href="<%=basePath %>Public/Css/bootstrap.min.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	  <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<style type="text/css">
	.table tr td{
			width:100px;
			height:50px;
			font-size:12px;
		}
 	.hr{
 		 border-bottom:1px solid #ddd; padding: 5px 3px 15px; min-height:30px
  		}
  	.container-f{min-width:80px}
	</style>
  </head>
  <body>
  <div class="container-f">
  	<div class="hr"></div>
 	<br />
    <fieldset style="height:80px;margin-left:15px;">
      <legend style="font-weight: bold;font-size: 14px;">用户查询</legend>
      <div class="row clearfix" style="margin-top:-2.5%">
			<form id="subForm" method="post" action=" ">
				<div class="control-group f_l">
					<div style="margin:0 auto;">
					<table class="table">
					<tbody  style="position:absolute;left:30px;top:95px;">
					<tr>
						<td style="width:75px">
							<h3>查询条件：</h3>
						</td>
						<td>
							<div style="position:relative;">   
								<select class="easyui-combobox"name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px" >     
								<option value="用户名">用户名 </option>  
								<option value="人员代码">人员代码 </option>     
								<option value="人员姓名">人员姓名</option>     
								<option value="所属部门">所属部门 </option>  
								<option value="职务">职务 </option> 
								<option value="人员类别">人员类别</option>     
								<option value="性别">性别 </option>  
								<option value="状态">状态 </option>
								</select>    
							</div>     
					 </td>
					<td>
						<div style="position:relative;">  
							<select class="easyui-combobox"name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">     
							<option value=" ">  </option>  
							<option value=" ">  </option>     
							<option value=" "> </option>     
							</select>    
						</div>     
					</td>
				</tr>
				</tbody>
				</table>
				</div>
			
		</div>
		<div style="float:right;position:absolute;top:110px;left:650px;">
				<a class="btn cf" href="javascript:void(0)" onclick="submit()">
				<i class="fa fa-search"></i>
				<span>查询</span>
				</a>
			</div>
		</form>
	 </div>
	</fieldset>
<br />

	<fieldset  style="margin-left:15px;">
		<legend style="font-weight: bold;font-size: 14px;">查询结果</legend>
		<table class="table-hover dataTable">
			<tr style="background: rgb(243, 243, 243) none repeat scroll 0% 0%;">
				<th style="background-color:#eee;">用户名</th>
				<th style="background-color:#eee;width:15%;">人员代码</th>
				<th style="background-color:#eee;">人员姓名</th>
				<th style="background-color:#eee;">所属部门</th>
				<th style="background-color:#eee;">职务</th>
				<th style="background-color:#eee;">人员类别</th>
				<th style="background-color:#eee;">性别</th>
				<th style="background-color:#eee;">状态</th>
				<th style="background-color:#eee;">设置权限</th>
				<th style="background-color:#eee;">操作</th>
		</tr>
		<tr style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;">
				<td>散散</td>
				<td>001</td>
				<td>张三</td>
				<td>局领导</td>
				<td>部门经理</td>
				<td>在职人员</td>
				<td>男</td>
				<td>启用</td>
				<td>
					<a class="btn" id="btnset" >设置</a>
				</td>
				<td class="tab-td">
					<a href="jsp/systemadmin/yhgllmt/edituser.jsp" class="btn" ><i class="fa fa-edit"></i>修改</a>
					
				</td>

		</tr>
		<tr style="background: rgb(243, 243, 243) none repeat scroll 0% 0%;">
				<td>思思</td>
				<td>002</td>
				<td>张四</td>
				<td>信息中心</td>
				<td>部门经理</td>
				<td>离休人员</td>
				<td>男</td>
				<td>关闭</td>
				<td>
					<a class="btn" id="btnset1" >设置</a>
				</td>
				<td class="tab-td">
					<a href="jsp/systemadmin/yhgllmt/edituser.jsp" class="btn" ><i class="fa fa-edit"></i>修改</a>
					
				</td>

		</tr>
	</table>
	<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
</fieldset>
<div class="modal fade" id="modalset">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i></i>请选择该员工角色</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" style="font-size:15px;"for="web_bg">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;角色：
								</label>
								
								<div class="controls">
									<select class="easyui-combobox"name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="系统管理员">系统管理员</option>
										<option value="财务部门资产管理员">财务部门资产管理员</option>
										<option value="实物部门资产管理员">实物部门资产管理员</option>
										<option value="信息中心资产管理员">信息中心资产管理员</option>	
										<option value="人事部门资产管理员">人事部门资产管理员</option>
										<option value="使用部门资产管理员">使用部门资产管理员</option>
												
									</select>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id">
						<input style="height:30px;" class="btn btn-primary modal_save" data-dismiss="modal" value="确定">
						<input type="hidden" name="id">
						<input style="height:30px;"  class="btn btn-primary modal_giveUp" data-dismiss="modal" value="取消">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script>
		$(function(){
	    	$("#btnset").click(function(){
	        	$("#modalset").modal("toggle");
	    	});
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
</body>
</html>
