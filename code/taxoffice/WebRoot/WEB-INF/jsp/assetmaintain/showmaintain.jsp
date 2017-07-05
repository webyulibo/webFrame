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
	  	 
		<div style="margin-top:20px;margin-left:10px;">
			<a class="btn btn-primary"
				href="<%=basePath %>adminassetmaintaincontroller/index.htm">返回</a>
		</div>
		<fieldset class="search" style="margin-top:20px;">
  	<legend><span style="font-size:14px;">资产维修记录列表</span></legend>
  	<div class="show tab-lbgl">
  	    <c:choose>
  	<c:when test="${not empty maintainList }">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>序号</th>
  				<th>资产编号</th>
  				<th>资产名称</th>
  				<th>规格型号</th>
  				<th>经手人</th>
  				<th>购置日期</th>
  				<th>报废年限</th>
  				<th>送修日期</th>
  				<th>详细</th>
  			</tr>		
  				<c:forEach items="${maintainList}" var="maintainList" varStatus="index">
  			<tr style="width: 279px; ">		
  				<td>${index.count }</td>
  				<td>${maintainList.code }</td>
  				<td>${maintainList.name }</td>
  				<td>${maintainList.model }</td>
  				<td>${maintainList.guy }</td>
  				<td><fmt:formatDate value="${maintainList.purchasedata }"   pattern="yyyy-MM-dd"/></td>
  				<td>${maintainList.ghostyears }</td>
  				<td><fmt:formatDate value="${maintainList.senddate }"   pattern="yyyy-MM-dd"/></td>
  				<td>
  				<a rel="tooltip" class="btn btn-setrole btnset" faultdescription="${maintainList.faultdescription}" dealresult="${maintainList.dealresult}">
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
	<cc:page  value="${pager}"  url="${basePath}adminassetmaintaincontroller/showmaintainlist.htm"></cc:page>
	</div>
  	<div class="font">
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
							<div class="f_l"><h3><i class="fa fa-edit"></i>资产维修</h3></div>
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
									<span id="look"></span>
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
<script>
		$(function(){
	    	$(".btnset").click(function(){
	    	var dealresult=$(this).attr("dealresult");
	    	var faultdescription=$(this).attr("faultdescription");
	    	 $("#look").html("故障描述:"+dealresult+'<br>'+'<br>'+"办理结果:"+faultdescription);
	         $("#modaladd").modal('show');	
	    	});
	    	$('.dataTable tr:even').css('background','#F3F3F3');
	    	$('.dataTable tr:odd').css('background','#ffffff');
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
