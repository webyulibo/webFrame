<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@	taglib uri="/pageuri" prefix="cc" %>
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
				<a href="<%=basePath%>adminmobilizepeoplecontroller/index.htm">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath%>adminmobilizepeoplecontroller/showlist.htm">
				<span class="fa fa-cog"></span>
				人员变动列表
				</a>
			</h3>
		</div>
		
		<fieldset class="search" style="margin-top:20px;">
  	<legend><span style="font-size:14px;">人员变动列表</span></legend>
  	<div class="show tab-lbgl">
  	<c:choose>
  	<c:when test="${not empty TMobilizepeopleList}">
  		<table class="table-hover dataTable" style="min-width:1100px;">
  			<tr>
  				<th>序号</th>
  				<th>姓名</th>
  				<th>岗位变动</th>
  				<th>原部门</th>
  				<th>新部门</th>
  				<th>变动时间</th>
  				<th>处理详情</th>
  			</tr>
  			<c:forEach items="${TMobilizepeopleList}" var="TMobilizepeopleList" varStatus="index">
  			<tr>		
  				<td>${index.count }</td>
  				<td>${TMobilizepeopleList.username }</td>
  				<td>${TMobilizepeopleList.depchange }</td>
  				<td>${TMobilizepeopleList.originaldep }</td>
  				<td>${TMobilizepeopleList.newdep }</td>
  				<td><fmt:formatDate value="${TMobilizepeopleList.sendtime}"   pattern="yyyy-MM-dd HH:mm:ss"/></td>
  				<td>
  				<a class="btn btn-setrole btnset" rel="tooltip"   financialdep="${TMobilizepeopleList.financialdep}" usedep="${TMobilizepeopleList.usedep}" servicedep="${TMobilizepeopleList.servicedep}" >
				<i class="fa fa-search"></i>查看</a>
  				</td>
  			</tr>
  			</c:forEach>
  		</table>
  		</c:when>
  		<c:otherwise>
  		 暂无数据
  		</c:otherwise>
  		</c:choose>
  		<div class="font">
	<cc:page  value="${pager}"  url="${basePath}adminmobilizepeoplecontroller/showlist.htm"></cc:page>
	</div>
  		
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
									<span id="model1"></span>
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
<script>
		$(function(){
	    	$(".btnset").click(function(){
	    	var financialdep=$(this).attr("financialdep");
	    	var usedep=$(this).attr("usedep");
	    	var servicedep=$(this).attr("servicedep");
	    	 $("#model1").html("财务部门办理情况:"+financialdep+'<br>'+'<br>'+"使用部门办理情况:"+usedep+'<br>'+'<br>'+"机关服务中心办理情况:"+servicedep);
	         $("#modaladd").modal('show');	
	    	});
	    });
	</script>
	    <script type="text/javascript">
	    function getInfoByPage() {
			var inputpage=document.getElementById("inputPage").value;
			
			if(inputpage.length==0){
			
				document.getElementById("inputPage").value="";
				return;
			}
			else{
				
				if(!isNaN(inputpage)){
					
					var totalPage=document.getElementById("inputPage").getAttribute("totalPage");
					
					if(parseInt(inputpage)>parseInt(totalPage)){
						document.getElementById("inputPage").value="";
						document.getElementById("inputPage").focus();
						return ;
					}
					else{
						
						var urlwithpage=document.getElementById("inputPage").getAttribute("url");
						var bool=urlwithpage.indexOf('?');						
						if(bool>0){
							urlwithpage=urlwithpage+'&currentPage='+inputpage;
						}
						else{
							urlwithpage=urlwithpage+'?currentPage='+inputpage;
						}
						window.location.href=urlwithpage;
					}										
				}
				else{
					document.getElementById("inputPage").value="";
					alert("请输入合法的数字");
				}
			}						
		}
	</script>
  </body>
</html>
