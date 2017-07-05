<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="/pageuri"  prefix="cc"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>盘点历史记录详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome/css/font-awesome.css" />
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.js"></script>
	
	
	
	
	<style type="text/css">
		table tr td{
			width:100px;
			height:50px;
			font-size: 12px;
		}
		body{
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
		
		.piaochecked {
			width: 20px;
			height: 20px;
			text-align:center;
			cursor: pointer;
			text-align: center;
			background-image: url("<%=basePath %>Public/Images/checkbox_01.gif");
			background-repeat: no-repeat;
			background-position: 0 0;
		}
		.on_check {
			background-position: 0 -21px;
		}
		.radioclass {
			opacity: 0;
			cursor: pointer;
			-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
			filter: alpha(opacity=0);
		}
		fieldset{
			margin-top:0px;
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
	
	
	
	
	<script type="text/javascript">
		function getInfoByPage() {
			var inputpage=document.getElementById("inputPage").value;
			
			if(inputpage.length==0){
				alert("请输入合法数据")
			}
			else{
				if(!isNaN(inputpage)){
					var urlwithpage=document.getElementById("inputPage").getAttribute("url");
					urlwithpage=urlwithpage+'&currentPage='+inputpage;
					window.location.href=urlwithpage;
					
					
				}
				else{
					alert("请输入合法的数字");
				}
			}
			
			
		}
	
	</script>
	
	
</head>
<body>
	<div class="container-f">
	 	<div class="box-title clearfix tab-title">
			<h3>
				<a
					href="<%=basePath%>adminassetcheckdataexportcontroller/getassetspageshow.htm">
					<span class="fa fa-table"></span> 盘点数据导出
				</a>
			</h3>
			<h3>
				<a
					href="<%=basePath%>adminassetcheckresultimportcontroller/showstartpage.htm">
					<span class="fa fa-cog"></span> 盘点结果导入
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath%>admincheckresultmanagecontroller/showgetcheckresultsbyselecttermswithpage.htm">
				<span class="fa fa-bar-chart-o"></span>
				盘点历史记录
				</a>
			</h3>
		</div> 
		<div class="box-content clearfix">
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a style="margin-top:10px;margin-left:4px;"  id="exportBtn"  class="btn cf"  href="<%=basePath %>admincheckresultmanagecontroller/exportassetresulttuexcel.htm?resultnum=${resultnum}"> <i class="fa fa-edit"></i><span>导出</span></a>
					</div>
				</div>
				<div class="control-group f_l" style="float:right;">
					<div class="f_l">
						<a style="margin-top:10px;margin-left:4px;" id="backBtn"  class="btn btn-primary" href="<%=basePath %>admincheckresultmanagecontroller/backgetcheckresultsbyselecttermswithpage.htm"> <i class="fa"></i><span>返回</span></a>
					</div>
				</div>
			</div>	
		</div>
		<div style="margin-top:10px;" id="list">
		<fieldset>
		<legend>历史记录详情列表</legend>
		<c:choose>
			<c:when test="${not empty  assetN}">
			<table  class="table-hover dataTable">
				<tr>
					<th style="background-color:#eee;width:6%">序号</th>
					<th style="background-color:#eee;width:15%;">资产代码</th>
					<th style="background-color:#eee;">资产名称</th>
					<th style="background-color:#eee;">资产类型</th>
					<th style="background-color:#eee;">使用人</th>
					<th style="background-color:#eee;">使用部门</th>
					<th style="background-color:#eee;">保管人</th>
					<th style="background-color:#eee;">保管部门</th>
					<th style="background-color:#eee;">使用状态</th>
					<th style="background-color:#eee;">盘点结果</th>
				</tr>
				<c:forEach items="${assetN}" var="assetList"  varStatus="index">
				<tr>
					<td>${index.count}</td>				
					<td>${assetList.code}</td>
					<td>${assetList.name}</td>
					<td>${assetList.type}</td>
					<td>${assetList.user}</td>
					<td>${assetList.usedepartment}</td>
					<td>${assetList.keeper}</td>
					<td>${assetList.keepdepartment}</td>
					<td>${assetList.usestate}</td>
					<td>${resultList[index.count-1]}</td>
				</tr>	
				</c:forEach>		
			</table>
			</c:when>
			<c:otherwise>
				暂无数据
			</c:otherwise>
		
		</c:choose>
		<div class="font">
	<cc:page  value="${pager }"  url="${basePath}admincheckresultmanagecontroller/getassetdetailbyresultnumwithpage.htm?resultnum=${resultnum}"></cc:page>
	</div>
		</fieldset>
		</div>
	</div>
		<shiro:hasPermission name="checkauth">
		<script type="text/javascript">

			document.getElementById("exportBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("exportBtn").setAttribute("href","javascript:void(0)");
		</script>
	</shiro:hasPermission>
			<shiro:hasPermission name="faultauth">
		<script type="text/javascript">

			document.getElementById("exportBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("exportBtn").setAttribute("href","javascript:void(0)");
		</script>
	</shiro:hasPermission>
			<shiro:hasPermission name="movepeoauth">
		<script type="text/javascript">

			document.getElementById("exportBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("exportBtn").setAttribute("href","javascript:void(0)");
		</script>
	</shiro:hasPermission>
	<!-- <div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div> -->
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
<!-- 	<script type="text/javascript">
		$('.pagination').pagination(100,{
			callback: function(page){
				console.log(page+1);	
			},
			display_msg: true,
			setPageNo: true
		});
		function clear(x){
			if(x.value=="请输入查询条件"){
				x.value='';
			}
		}
		function goback(x){
			if (x.value=='') {
				x.value='请输入查询条件';
			}
		}
		
		$(".piaochecked").on("click",function(){
		    $(this).hasClass("on_check")? $(this).removeClass("on_check"):$(this).addClass("on_check");
		});
		
		$("#allselect").on("click",function(){
			$(this).hasClass("on_check")? $(this).removeClass("on_check"):$(this).addClass("on_check");
			var smselect=document.getElementsByClassName("piaochecked");
			if($(this).hasClass("on_check")){
				$(this).removeClass("on_check");
				for(var i=1;i<smselect.length;i++){
					smselect[i].className="piaochecked";
				}
			}else{
				$(this).addClass("on_check");
				for(var i=1;i<smselect.length;i++){
					smselect[i].className="piaochecked on_check";
				}
			}
		});
		
	</script> -->
<%-- 		<script type="text/javascript">
	$("#backBtn").click(function(){
		location.href = '<%=basePath %>admincheckresultmanagecontroller/showgetcheckresultsbyselecttermswithpage.htm';
	});
	$("#exportBtn").click(function(){
		var resultnum=${resultnum};
		   location.href = '<%=basePath %>admincheckresultmanagecontroller/exportassetresulttuexcel.htm?resultnum='+resultnum;
		return false;
	});
	</script>	 --%>
	<script type="text/javascript">
	function getInfoByPage() {
		var inputpage=document.getElementById("inputPage").value;
		
		if(inputpage.length==0){
			//alert("请输入合法数据")
	
			document.getElementById("inputPage").value="";
			document.getElementById("inputPage").focus();
			return;
		}
		else{
			if(!isNaN(inputpage)){
		
				var totalPage=document.getElementById("inputPage").getAttribute("totalPage");
				
				if(inputpage>totalPage){
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
	
	