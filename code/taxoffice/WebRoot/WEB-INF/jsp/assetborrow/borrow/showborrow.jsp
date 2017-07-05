<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="/pageuri"  prefix="cc"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
      <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css"  href="<%=basePath %>Public/Css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/datazp.css">
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	  <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
    <title>税务局管理系统</title>
  </head>
  
  <body>
   <script type="text/javascript" src="<%=basePath%>Public/Js/table.js"></script>
    <div class="container-f">
	  	 <div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="<%=basePath %>AdminAssetBorrowController/index.htm">
				<span class="fa fa-table"></span>
				资产借用
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>AdminAssetReturnController/index.htm">
				<span class="fa fa-cog"></span>
				资产归还
				</a>
			</h3>
		</div>
		<div style="margin-top:20px;margin-left:10px;">
			<a class="btn btn-primary"
				href="<%=basePath %>AdminAssetBorrowController/index.htm">返回</a>
		</div>
		<fieldset class="search" style="margin-top:20px;">
  	<legend><span style="font-size:14px;">资产借用记录列表</span></legend>
  		<div class="show tab-lbgl">
  	<c:choose>
  	<c:when test="${not empty assetBorrowList }">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>借出单号</th>
  				<th>资产编号</th>
  				<th>资产名称</th>
  				<th>借出日期</th>
  				<th>借出部门</th>
  				<th>借出人</th>
  				<th>批准人</th>
  				<th>拟还日期</th>
  				<th>借用部门</th>
  				<th>借用人</th>
  				<th>详细</th>
  			</tr>
  			<c:forEach items="${assetBorrowList}" var="assetBorrowList" > 
  			<tr>		
  				<td>${assetBorrowList.borrownum}</td>
  				<td>${assetBorrowList.assetcode}</td>
  				<td>${assetBorrowList.assetname}</td>
  				<td><fmt:formatDate value="${assetBorrowList.borrowdate}"   pattern="yyyy-MM-dd "/></td>
  				<td>${assetBorrowList.borrowdep}</td>
  				<td>${assetBorrowList.borrowpeople}</td>
  				<td>${assetBorrowList.approvepeople}</td>
  				<td><fmt:formatDate value="${assetBorrowList.plandate}"     pattern="yyyy-MM-dd "/></td>
  				<td>${assetBorrowList.borrowusedep}</td>
  				<td>${assetBorrowList.borrowuser}</td>
  				<td>
  				<a href="javascript:void(0)" class="btn" rel="tooltip" title="查看"   onclick="getborrowresult(this.id)" id="${assetBorrowList.remark}" >
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
	<cc:page  value="${pager}"  url="${basePath}AdminAssetBorrowController/showborrow.htm"></cc:page>
	</div>
  	<div class="font">
	</div>
  	</div>
  	  <div class="pagination ue-clear" style="margin-top:20px;margin-bottom:50px;"></div>
  	 <div class="modal fade" id="modaladd">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-edit"></i>资产借用</h3></div>
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
								<span id="borrowcheck"></span>
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
<!-- 	<script type="text/javascript">
	$(function(){
		$('.pagination').pagination(100, {
			callback : function(pager) {
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
<script type="text/javascript">
	    function getborrowresult(obj){
		var result=obj;
		 $("#borrowcheck").text(result);
		 $("#modaladd").modal('show');	
	}
	</script>
  </body>
</html>
