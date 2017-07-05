<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@	taglib uri="/pageuri" prefix="cc" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
			<a href="${basePath}admindepartmentcontroller/getdepbyconditionwithpage.htm?depcode=${depcode }&condition=${precondition }&text=${pretext }&currentPage=${precurrentPage}" value="${pager}" class="btn btn-primary " >返回</a>
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
                <th class="tab-th" style="width:18%">权限</th>
                <th class="tab-th">操作</th>
			</tr>
			<c:forEach items="${tUserExtendsList }" var="tUserExtend">
			<tr>
				<td class="tab-td">${tUserExtend.useraccount}</td>
				<td class="tab-td">${tUserExtend.usercode}</td>
				<td class="tab-td">${tUserExtend.username}</td>
                <td class="tab-td">${tUserExtend.userduty}</td>
				<td class="tab-td">${tUserExtend.usertype}</td>
				<td class="tab-td">${tUserExtend.usersex}</td>
				<td class="tab-td">${tUserExtend.userstate}</td>
				<td class="tab-td">${tUserExtend.userroleString}</td>
				<td class="tab-td">
				<a href="javascript:void(0)" onclick="deleteUser(${tUserExtend.id})"  class="btn delete-user"  ><i class="fa fa-times"></i>删除</a>
			    </td>
			</tr>
			</c:forEach>


			
		</table>
			<c:if test="${tUserExtendsList.size()==0 }">
			                   <br/>
			     &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp 暂无数据
			     			<br/><br/>
			</c:if>	
	<cc:page url="${basePath}admindepartmentcontroller/getuserbydep.htm?depcode=${depcode }&precondition=${precondition }&pretext=${pretext }" value="${pager}" />
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
	
	<input type="hidden" id="currentPage" value="${pager.currentPage }"/><%-- 记录当前页数  以便在js中调用，否则用${pager.currentPage} 不能对js直接进行赋值 --%>
	<input type="hidden" id="depcode" value="${depcode }"/>
	
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
   <script type="text/javascript">
	function deleteUser(userid){
		var co=confirm('确定删除？');
		var currentPage=document.getElementById("currentPage").value;
		var depcode=document.getElementById("depcode").value;
		if(co==true){
			 $.ajax({ 
     	type:"POST", //表单提交类型 
    	 url:'<%=basePath%>admindepartmentcontroller/deleteuserbydep.htm', 
     	data:{userid:userid,currentPage:currentPage,depcode:depcode}, //表单数据
  		success:function(e){
	 	 var  data = eval("("+e+")");
      	if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
       		if(data.issubcurrentPage == 'ok'){
      		 location.href="<%=basePath%>admindepartmentcontroller/getuserbydep.htm?depcode=${depcode }&precondition=${precondition }&pretext=${pretext }&currentPage=${pager.currentPage-1}&precurrentPage=${precurrentPage}";
     	 	}else{
     	 	  location.href="<%=basePath%>admindepartmentcontroller/getuserbydep.htm?depcode=${depcode }&precondition=${precondition }&pretext=${pretext }&currentPage=${pager.currentPage}&precurrentPage=${precurrentPage}";
     	 	}
     	 }else{
			alert(data.msg);
     	 }
     }
    }); 
	}
}
	
	</script>
	<!-- 设置权限 -->
  <shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		//设置保存按钮权限
		 $(".delete-user").attr("onclick","alert('权限不足，无法进行此操作')");
		</script>	
</shiro:hasPermission>
  </body>
</html>
