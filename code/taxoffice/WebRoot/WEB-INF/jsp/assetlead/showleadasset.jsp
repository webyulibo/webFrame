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
  <script type="text/javascript" src="<%=basePath%>Public/Js/table.js"></script>
   <div class="container-f">
		<div class="box-title clearfix tab-title"></div>
	</div>
		<div style="margin-top:20px;margin-left:10px;">
			<a class="btn btn-primary"
				href="<%=basePath%>AdminAssetLeadController/index.htm">返回</a>
		</div>
		<fieldset class="search" style="margin-top:20px;">
  	<legend><span style="font-size:14px;">资产领用记录列表</span></legend>
  	<div class="show tab-lbgl">
  		<c:choose>
  	<c:when test="${not empty TAssetPossessList }">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>领用单号</th>
  				<th>资产编号</th>
  				<th>领用人</th>
  				<th>领用部门</th>
  				<th>领用日期</th>
  				<th>备注</th>
  			</tr>
  			<c:forEach items="${TAssetPossessList}" var="TAssetPossessList">
  			<tr style="width: 279px; ">		
  				<td>${TAssetPossessList.assetcode }</td>
  				<td>${TAssetPossessList.code }</td>
  				<td>${TAssetPossessList.possesspeople }</td>
  				<td>${TAssetPossessList.possessdepartment }</td>
  				<td><fmt:formatDate value="${TAssetPossessList.possessdate}"   pattern="yyyy-MM-dd"/></td>
  				<td>
  				<a href="javascript:void(0)" class="btn" rel="tooltip" title="查看" id="${TAssetPossessList.possessremark}" onclick="showlist(this.id)">
				<i class="fa fa-search"></i>详情</a>
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
	<cc:page  value="${pager}"  url="${basePath}AdminAssetLeadController/showleadasset.htm"></cc:page>
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
							<div class="f_l"><h3><i class="fa fa-edit"></i>资产领用</h3></div>
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
									<span id="possessremark"></span>
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
     <script type="text/javascript">
	    function showlist(obj){
		var result=obj;
		 $("#possessremark").text(result);
		 $("#modaladd").modal('show');	
	}
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
     <!-- 
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
	</script> -->
	
  </body>
</html>