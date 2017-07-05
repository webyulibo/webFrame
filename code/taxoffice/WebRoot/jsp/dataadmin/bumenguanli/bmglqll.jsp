<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'yjbmlb.jsp' starting page</title>
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
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
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
						<a style="width:80px;margin-left:4px;" id="btnAdd" class="btn cf"> <i class="fa fa-plus"></i><span>添加部门</span></a>
					</div>
				</div>
				<div class="control-group f_l" style="float:right">
					<div class="f_l">
						<input type="text" name="typename" id=" "   class="input" value="">		
						<a class="btn" ><i class="fa fa-search"></i>查询</a>
					</div>
				</div>
			</div>	
		</div>
 		<div style="margin-top:10px;" id="list">
			<fieldset>
			<legend >部门管理</legend>
		<table id="tableinfo" class="table-hover dataTable">
			<tr>
				<th>部门代码</th>
				<th>部门名称</th>
				<th>人数</th>
				<th>状态</th>
				<th class="tab-th">查看人员</th>
				<th class="tab-th">添加人员</th>
                <th class="tab-th">操作</th>
			</tr>
			<tr>
				<td class="tab-td">001</td>
				<td class="tab-td">管理部门</td>
				<td class="tab-td">10</td>
                <td class="tab-td">启用</td>
				<td class="tab-td">
				<a id="chakan" href="jsp/dataadmin/bumenguanli/chakan.jsp" class="btn" ><i class="fa fa-search"></i>查看</a>
				</td>
				<td class="tab-td">
					<a id="tianjia" class="btn" ><i 
class="fa fa-plus"></i>添加</a>
				</td>
				<td class="tab-td">
					<a id="bianji" class="btn" ><i 
class="fa fa-edit"></i>编辑</a>
					<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem
('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
				</td>
			</tr>
			<tr>
				<td class="tab-td">001</td>
				<td class="tab-td">管理部门</td>
				<td class="tab-td">10</td>
                <td class="tab-td">启用</td>
				<td class="tab-td">
					<a id="chakan" href="jsp/dataadmin/bumenguanli/chakan.jsp" class="btn" ><i class="fa fa-search"></i>查看</a>
				</td>
				
				<td class="tab-td">
					<a id="tianjia" class="btn" ><i 

class="fa fa-plus"></i>添加</a>
				</td>
				<td class="tab-td">
					<a id="bianji" class="btn" ><i 

class="fa fa-edit"></i>编辑</a>
					<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem

('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
				</td>
			</tr>
			<tr>
				<td class="tab-td">001</td>
				<td class="tab-td">管理部门</td>
				<td class="tab-td">10</td>
                <td class="tab-td">启用</td>
				<td class="tab-td">
					<a id="chakan" href="jsp/dataadmin/bumenguanli/chakan.jsp" class="btn" ><i class="fa fa-search"></i>查看</a>
				</td>
				
				<td class="tab-td">
					<a id="tianjia" class="btn" ><i 

class="fa fa-plus"></i>添加</a>
				</td>
				<td class="tab-td">
					<a id="bianji" class="btn" ><i 

class="fa fa-edit"></i>编辑</a>
					<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem

('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
				</td>
			</tr>
			<tr>
				<td class="tab-td">001</td>
				<td class="tab-td">管理部门</td>
				<td class="tab-td">10</td>
                <td class="tab-td">启用</td>
				<td class="tab-td">
					<a id="chakan" href="jsp/dataadmin/bumenguanli/chakan.jsp" class="btn" ><i class="fa fa-search"></i>查看</a>
				</td>
				
				<td class="tab-td">
					<a id="tianjia" class="btn" ><i 

class="fa fa-plus"></i>添加</a>
				</td>
				<td class="tab-td">
					<a id="bianji" class="btn" ><i 

class="fa fa-edit"></i>编辑</a>
					<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem

('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
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

	<div class="modal fade" id="tianjiabumen">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-plus"></i>添加部门</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									部门代码：
								</label>
								<div class="controls">
									<input type="text" name="title" id="title" data-rule-maxlength="60"  class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;">
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									部门名称：
								</label>
								<div class="controls"><input type="text" name="title" id="title" data-rule-maxlength="60"  class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;">
									
								</div>
							</div>

							<div class="control-group cf clearfix">
								<label class="control-label" for="title">
									员工人数：
								</label>
								<div class="controls">
									<input type="text" name="title" id="title" data-rule-maxlength="60"  class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;">
								</div>
							</div>

							<div class="control-group cf clearfix">
								<label class="control-label" for="title">
									状态：
								</label>
								<div class="controls">
									 <select id=""  style="width: 150px;padding: 5px 2px;cursor: pointer; border:1px solid #ddd;onchange="this.parentNode.nextSibling.value=this.value">
  						<option value="启用">启用</option>
  						<option value="关闭">关闭</option>
					                 </select> 
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_save" style="margin-left:175px;" data-dismiss="modal"  value="添加">
					    <input class="btn btn-primary modal_save" style="margin-left:10px;"  data-dismiss="modal" value="取消">
						
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="chakanbumen">
	    
	</div>
	
<div class="modal fade" id="tianjiarenyuan">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-plus"></i>添加人员</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix">
								<label class="control-label" for="title">
									人员代码：
								</label>
								<div class="controls">
									<input type="text" name="title" id="title" data-rule-maxlength="60"  class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;" value="">
								</div>
							</div>
							
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									人员姓名：	
								</div>
								<div class="controls">
									<input type="text" name="sort" id="sort" value=""  class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;" value="">
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									职务：	
								</div>
								<div class="controls">
									<select class="easyui-combobox"name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										
										<option value="部门经理 ">部门经理 </option>
										<option value="公司职员"> 公司职员</option>
										
									</select>
				
								</div>
							</div>
											<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									人员类别：	
								</div>
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
											<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									性别：	
								</div>
								<div class="controls">
									 <label class="la">男性：<input type="radio" checked="checked" name="Sex" value="male" />
								               女性：<input type="radio" name="Sex" value="female" /></label>
								
								</div>
							</div>
											<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									状态：	
								</div>
								<div class="controls">
										 <select id=""  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;cursor: pointer;" onchange="this.parentNode.nextSibling.value=this.value">
  						<option value="启用">在职</option>
  						<option value="关闭">离职</option>
					  </select> 
								</div>
							</div>
											<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									用户名：	
								</div>
								<div class="controls">
									<input type="text" name="sort" id="sort" class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;" value="">
								</div>
							</div>
											<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									密码：	
								</div>
								<div class="controls">
									<input type="text" name="sort" id="sort" class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;" value="">
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									确认密码：	
								</div>
								<div class="controls">
									<input type="text" name="sort" id="sort" class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;" value="">
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_save" style="margin-left:175px;" data-dismiss="modal"  value="添加">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_save" style="margin-left:10px;"  data-dismiss="modal" value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="bianjibumen">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-edit"></i>编辑部门</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									部门代码：
								</label>
								<div class="controls">
									<input type="text" name="title" id="title" data-rule-maxlength="60"  class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;" value="">
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									部门名称：
								</label>
								<div class="controls"><input type="text" name="title" id="title" data-rule-maxlength="60"  class="input-medium ipt_require"  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;" value="">
									
								</div>
							</div>

							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									状态：	
								</div>
								<div class="controls">
										 <select id=""  style="width: 150px;padding: 5px 2px;border:1px solid #ddd;cursor: pointer;" onchange="this.parentNode.nextSibling.value=this.value">
  						<option value="启用">启用</option>
  						<option value="关闭">关闭</option>
					  </select> 
								</div>
							</div>
							
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_save" style="margin-left:175px;" data-dismiss="modal"  value="保存">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_save" style="margin-left:10px;"  data-dismiss="modal" value="取消">
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
	        	$("#tianjiabumen").modal("toggle");
	    	});
	    });
	  
	    $(function(){
	    	$("#tianjia").click(function(){
	        	$("#tianjiarenyuan").modal("toggle");
	    	});
	    });
	    $(function(){
	    	$("#bianji").click(function(){
	        	$("#bianjibumen").modal("toggle");
	    	});
	    });
	</script>
   
  </body>
</html>

       
  
  </div >