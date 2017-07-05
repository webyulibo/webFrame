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
		.hr{
 		 border-bottom:1px solid #ddd; padding: 5px 3px 15px; min-height:30px
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
     
     </style>
  </head>
  
  <body>
   <div class="container-f">
		<div class="hr"></div>
		<br />
  <div  style=" float:left;position:absolute;left:20px;">
			<a href="jsp/dataadmin/bumenguanli/bmglqll.jsp" class="btn btn-primary " >返回</a>
   </div>
   <br>
  <div class="container-f">
		
 		<div style="margin-top:10px;" id="list">
			<fieldset>
			<legend>部门人员</legend>
		<table id="tableinfo" class="table-hover dataTable">
			<tr>
				<th>用户名</th>
				<th>人员代码</th>
				<th>人员姓名</th>
				<th>职务</th>
				<th class="tab-th">人员类别</th>
				<th class="tab-th">性别</th>
                <th class="tab-th">状态</th>
                <th class="tab-th">密码</th>
                <th class="tab-th">操作</th>
			</tr>
			<tr>
				<td class="tab-td">张三</td>
				<td class="tab-td">001</td>
				<td class="tab-td">张三</td>
                <td class="tab-td">会计</td>
				<td class="tab-td">在职人员</td>
				<td class="tab-td">男</td>
				<td class="tab-td">启用</td>
				<td class="tab-td">123456</td>
				<td class="tab-td">
				<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem
('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
			    </td>
			</tr>
			<tr>
				<td class="tab-td">张三</td>
				<td class="tab-td">001</td>
				<td class="tab-td">张三</td>
                <td class="tab-td">会计</td>
				<td class="tab-td">在职人员</td>
				<td class="tab-td">男</td>
				<td class="tab-td">启用</td>
				<td class="tab-td">123456</td>
				<td class="tab-td">
				<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem
('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
			    </td>
			</tr>
			<tr>
				<td class="tab-td">张三</td>
				<td class="tab-td">001</td>
				<td class="tab-td">张三</td>
                <td class="tab-td">会计</td>
				<td class="tab-td">在职人员</td>
				<td class="tab-td">男</td>
				<td class="tab-td">启用</td>
				<td class="tab-td">123456</td>
				<td class="tab-td">
				<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem
('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
			    </td>
			</tr>
			<tr>
				<td class="tab-td">张三</td>
				<td class="tab-td">001</td>
				<td class="tab-td">张三</td>
                <td class="tab-td">会计</td>
				<td class="tab-td">在职人员</td>
				<td class="tab-td">男</td>
				<td class="tab-td">启用</td>
				<td class="tab-td">123456</td>
				<td class="tab-td">
				<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem
('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
			    </td>
			</tr>
			
		</table>
				<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
			</fieldset>
		</div>

	<div class="modal fade" id="tianjiabumen">
	    
	</div>

	<div class="modal fade" id="chakanbumen">
	    
	</div>
	
<div class="modal fade" id="tianjiarenyuan">
	    <div class="modal-dialog">
	        
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
		
	
	    $(function(){
	    	$("#chakan").click(function(){
	        	$("#chakanbumen").modal("toggle");
	    	});
	    });
	   
	</script>
   
  </body>
</html>
