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
    
    <title>盘点历史记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css"  href="<%=basePath %>Public/Css/bootstrap.min.css" />
	<script type="text/javascript" src="<%=basePath %>Public/Js/laydate.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>

	<style type="text/css">
		table tr td{
			width:100px;
			height:50px;
			font-size: 12px;
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
		body{
			min-width: 1170px;
		}
		.piaochecked{
			width: 20px;
			height: 20px;
			text-align:center;
			cursor: pointer;
			text-align: center;
			background-image: url("<%=basePath%>Public/Images/checkbox_01.gif");
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
		.modal-mask {
			position: fixed;
			z-index: 9998;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			background-color: rgba(0, 0, 0, 0.2);
			display: table;
			transition: opacity 0.3s ease;
		}
		.modal-wrapper {
			display: table-cell;
			vertical-align: middle;
		}
		.modal-container {
			width: 400px;
			margin: 0px auto;
			padding: 10px 10px;
			background-color: #fff;
			border-radius: 2px;
			box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
			transition: all 0.3s ease;
			font-family: Helvetica, Arial, sans-serif;
		}
		.modal-header h3 {
			margin-top: 0;
			color: #333;
			font-weight:bold;
		}
		.modal-body {
			margin: 10px 0;
		}
		.modal-default-button {
			float: right;
		}
		.modal-enter, .modal-leave {
			opacity: 0;
		}
		.modal-enter .modal-container,
		.modal-leave .modal-container {
			-webkit-transform: scale(1.1);
			transform: scale(1.1);
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

<body id="app">
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
		<fieldset style="height:60px;">
			<legend>查询条件</legend>
			<div class="row clearfix"  style="margin-top:-1%;margin-left:-1%">
				<div class="control-group f_l">
					<div class="f_l">
					<form style="margin-bottom:0px;" method="post">
						<table>
							<tr>
								<td style="width:30px">
									<!-- <div class="piaochecked">
						        		<input name="need_inv" type="checkbox" style="height:20px;width:20px;" class="radioclass input" value="1">
						    		</div> -->
								</td>
								<td>
									<h3 style="width:80px">提交时间：</h3>
								</td>
								<td>
									<input class="laydate-icon" id="demo" style="width:163px;height:30px;"name="checktimestart"  value="${checktimestart}"> 
								</td>
								<td style="text-align:center;"><h3>到</h3></td>
								<td colspan="2">
									<input class="laydate-icon" id="demo1" style="width:163px;height:30px;"  name="checktimeend" value="${checktimeend}">
								</td>
							
								<td style="width:30px">
									<!-- <div class="piaochecked">
						        		<input name="need_inv" type="checkbox" style="height:20px;width:20px;" class="radioclass input" value="1">
						    		</div> -->
								</td>
								<td><h3 style="width:60px">盘点人：</h3></td>
								<td><input type="text" style="width:163px;height:30px;" name="checkpeople"   id="checkpeople" value="${checkpeople}"></td>
								
								<td style="width:30px">
									<!-- <div class="piaochecked">
						        		<input name="need_inv" type="checkbox" style="height:20px;width:20px;" class="radioclass input" value="1">
						    		</div> -->
								</td>
								<td><h3 style="width:80px">盘点编号：</h3></td>
								<td><input type="text" style="width:163px;height:30px;"  name="resultnum"  id="resultnum" value="${resultnum}"></td>
								
								<td style="text-align:left;">
									<a style="margin-left:10px;height:25px;padding-top:5px;"  type="submit" class="btn cf" href="#" id="searchBtn" onclick="javascript:searchBtn();"> <i class="fa fa-search"></i><span>查询</span></a>
								</td>
								<td style="text-align:left;">
									<a id="exportBtn" class="btn cf" href="#" style="height:25px;padding-top:5px;" onclick="javascript:exportBtn();"> <i class="fa fa-edit"></i><span>导出</span></a>
								</td>
							</tr>
						</table>
						</form>
					</div>
				</div>			
			</div>	
		</fieldset>
		<div style="margin-top:10px;" id="list">
		<fieldset>
		<legend>历史记录列表</legend>
		<c:choose>
			<c:when test="${not empty  checkResultList}">
			<table  class="table-hover dataTable">
				<tr>
					<th style="background-color:#eee;width:8%;">
						<div >
        					<input   class="checkBoxAll"  name="need_inv" type="checkbox" style="height:20px;width:20px;"value="1">
    					</div>
					</th>
					<th style="background-color:#eee;width:8%">序号</th>
					<th style="background-color:#eee;">盘点编号</th>
					<th style="background-color:#eee;">提交人</th>
					<th style="background-color:#eee;width:20%">盘点时间</th>
					<th style="background-color:#eee;">详情</th>
					<th style="background-color:#eee;">备注</th>
				</tr>
				<c:forEach items="${checkResultList}" var="checkResultList"  varStatus="index"> 
				<tr>
				<td>
						<div >
						     <input class="checkBox"  name="resultnumcheckbox" type="checkbox" style="height:20px;width:20px;" value="${checkResultList.resultnum}">
						</div>
					</td>
					<td>${index.count}</td> 
					<td >${checkResultList.resultnum}</td>
					<td>${checkResultList.checkpeople}</td>
					<td><fmt:formatDate value="${checkResultList.checktime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<a href="<%=basePath %>admincheckresultmanagecontroller/getassetdetailbyresultnumwithpage.htm?resultnum=${checkResultList.resultnum}&currentPage=${pager.currentPage}" class="btn" rel="tooltip" title="详情"  >
							<i class="fa fa-plus"></i>详情
						</a>
					</td>
					<td>
						<a href="javascript:void(0);"  class="remarkbtn btn"  onclick="getborrowresult(this.id)"  rel="tooltip" title="查看"    id="${checkResultList.resultnum}"  value="${checkResultList.resultnum}" >
							<i class="fa fa-plus"></i>查看
						</a>
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
	<cc:page  value="${pager }"  url="${basePath}admincheckresultmanagecontroller/showgetcheckresultsbyselecttermswithpage.htm?checktimestart=${checktimestart}&checktimeend=${checktimeend}&checkpeople=${checkpeople}&resultnum=${resultnum}"></cc:page>
	</div>
		</fieldset>
		</div>
	<div>
	<input type="hidden" id="hide">
	<input type="hidden" id="hide1">
	<input type="hidden" id="hide2">
	</div>
	</div>
	
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
	
	
		<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
			document.getElementById("exportBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("hide").value="fe";
		</script>
	</shiro:hasPermission>
		<shiro:hasPermission name="faultauth">
		<script type="text/javascript">
		
			document.getElementById("exportBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("hide1").value="fe";
			
			document.getElementById("searchBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			
			document.getElementByClassName("btn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementByClassName("btn").setAttribute("href","javascript:void(0)");
		
		</script>
	</shiro:hasPermission>
		<shiro:hasPermission name="movepeoauth">
		<script type="text/javascript">
		
			document.getElementById("exportBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("hide2").value="fe";
			
			document.getElementById("searchBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");

		</script>
	</shiro:hasPermission>
	<script type="text/javascript">
/* 		$('.pagination').pagination(100,{
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
		*/
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			var start1 = {
					elem: '#demo',
					format: 'YYYY-MM-DD',
					max: '2099-06-16', //最大日期
					istime: true,
					istoday: false,
					choose: function(datas){
					     end1.min = datas; //开始日选好后，重置结束日的最小日期
					     end1.start = datas; //将结束日的初始值设定为开始日
					}
				};

				var end1 = {
					elem: '#demo1',
					format: 'YYYY-MM-DD',
					max: '2099-06-16',
					istime: true,
					istoday: false,
					choose: function(datas){
					    start1.max = datas; //结束日选好后，充值开始日的最大日期
					}
				};
				laydate(start1);
				laydate(end1);
		}();
		/* var res;
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
					res+=$(this).find("input").val();
				}
			}else{
				$(this).addClass("on_check");
				for(var i=1;i<smselect.length;i++){
					smselect[i].className="piaochecked on_check";
					res+=$(this).find("input").val();
				}
			}
			alert(res);
		}); */
		
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".checkBoxAll").change(function(){

			 var a =$(this).prop("checked");
				if(a){
					$(".checkBox").prop("checked",true);
				}else{
					$(".checkBox").prop("checked",false);
				}
		});
	});
	$("#exportBtn").click(function(){
		if($(".checkBoxAll").prop("checked")&&document.getElementById("hide").value!="fe"&&document.getElementById("hide1").value!="fe"&&document.getElementById("hide2").value!="fe"){
			var checktimestart = document.getElementById("demo").value;
			var checktimeend= document.getElementById("demo1").value;
			var checkpeople =document.getElementById("checkpeople").value;
			var resultnum = document.getElementById("resultnum").value;
			   location.href = '<%=basePath %>admincheckresultmanagecontroller/exportchectresulttuexcel.htm?checktimestart='+checktimestart+'&checktimeend='+checktimeend+'&checkpeople='+checkpeople+'&resultnum='+resultnum;
			return false;
		}
		 var obj=$(".checkBox");  
		  //取到对象数组后，我们来循环检测它是不是被选中
		  var s='';
		  for(var i=0; i<obj.length; i++){
		    if(obj[i].checked) s+=obj[i].value+',';  //如果选中，将value添加到变量s中
		  }
		  //那么现在来检测s的值就知道选中的复选框的值了
		  if(s!=""&&document.getElementById("hide").value!="fe"&&document.getElementById("hide1").value!="fe"&&document.getElementById("hide2").value!="fe"){
		  location.href = '<%=basePath %>admincheckresultmanagecontroller/exportchectresulttuexcelbycheckbox.htm?s='+s;
		  return false;
		  }
		  if(s==""&&document.getElementById("hide").value!="fe"&&document.getElementById("hide1").value!="fe"&&document.getElementById("hide2").value!="fe"){
			  alert("你未选择任何需要导出的数据");
			  return false;
			  }
	return false;
	});
	$("#searchBtn").click(function(){
		if(document.getElementById("hide1").value!="fe"&&document.getElementById("hide2").value!="fe"){
			var checktimestart = document.getElementById("demo").value;
			var checktimeend= document.getElementById("demo1").value;
			var checkpeople =document.getElementById("checkpeople").value;
			var resultnum = document.getElementById("resultnum").value;
			   location.href = '<%=basePath %>admincheckresultmanagecontroller/showgetcheckresultsbyselecttermswithpage.htm?checktimestart='+checktimestart+'&checktimeend='+checktimeend+'&checkpeople='+checkpeople+'&resultnum='+resultnum;
			   return false;
		}
		return false;
	});
	function remark(obj){	
		var resultnum =obj;
		$.ajax({
			type:"post",
			url:'<%=basePath %>admincheckresultmanagecontroller/getcheckresultsremarkbyresultnum.htm',
			data:{ resultnum: resultnum},
			success:function(e){
				var data=eval("("+e+")");
					alert(data.msg);	
			}
		});
		return false;
	}
	</script>	
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
		function getborrowresult(obj){
			var resultnum =obj;
			$.ajax({
				type:"post",
				url:'<%=basePath %>admincheckresultmanagecontroller/getcheckresultsremarkbyresultnum.htm',
				data:{ resultnum: resultnum},
				success:function(e){
					var data=eval("("+e+")");
						//alert(data.msg);	
					$("#borrowcheck").text(data.msg);
					 $("#modaladd").modal('show');	
				}
			});
		}
	</script>
</body>
</html>
	
	
	