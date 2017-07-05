<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
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
    
    <title>盘点历史记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome/css/font-awesome.css" />
	<script type="text/javascript" src="<%=basePath %>Public/Js/laydate.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/vue.js"></script>

	<style type="text/css">
		table tr td{
			width:100px;
			height:50px;
			font-size: 12px;
		}
		#list > table tr td{
			height:30px;
			font-size: 15px;
			text-align: center;
		}
		#list > table tr th{
			height:30px;
			font-size: 15px;
		}
		body{
			min-width: 700px;
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
	
	function submit(){
		
	}
	
	
	$("#searchBtn").click(function(){
		alert("asdf");
		var checktimestart = document.getElementByName("checktimestart").value;
		var checktimeend= document.getElementByName("checktimeend").value;
		var checkpeople =document.getElementById("checkpeople").value;
		var resultnum = document.getElementById("resultnum").value;
		location.href = '<%=basePath %>admincheckresultmanagecontroller/getcheckresultsbyselecttermswithpage.htm?checktimestart=' + checktimestart+'&checktimeend='+checktimeend+'&checkpeople='+checkpeople+'&resultnum='+resultnum;
		return false;
	});
	$("#exportBtn").click(function(){
		var checktimestart = document.getElementByName("checktimestart").value;
		var checktimeend= document.getElementByName("checktimeend").value;
		var checkpeople =document.getElementById("checkpeople").value;
		var resultnum = document.getElementById("resultnum").value;
		$.ajax({
			type:"post",
			url:'<%=basePath %>admincheckresultmanagecontroller/exportchectresulttuexcel.htm',
			data:{ checktimestart:checktimestart ,checktimeend:checktimeend,checkpeople:checkpeople,resultnum: resultnum},
			success:function(e){
				var data=eval("("+e+")");
					alert(data.msg);	
			}
		});
		return false;
	});
	function remark(){
		var resultnum=document.getElementById("resultnum").value;
		$.ajax({
			type:"post",
			url:'<%=basePath%>admincheckresultmanagecontroller/getcheckresultsremarkbyresultnum.htm',
			data:{ resultnum: resultnum},
			success:function(e){
				var data=eval("("+e+")");
					alert(data.msg);	
			}
		});
		return false;
	}
	</script>	
	
	
	
</head>

<body id="app">
	<script type="x/template" id="modal-template1">
		<div class="modal-mask" v-show="show" transition="modal">
		    <div class="modal-wrapper">
			    <div class="modal-container">
			        <div class="modal-header">
			            <slot name="header"></slot>
			        </div>
			        
			        <div class="modal-body">
				        <slot name="body"> this is my jsp page! </slot>
			        </div>

			        <div class="modal-footer">
				        <slot name="footer">
				        	<div class="form-actions">
								<input type="hidden" name="id">
								<input class="btn btn-primary" style="margin-left:0px;" type="button" @click="show = false" value="确定">
							</div>
				        </slot>
			        </div>
			    </div>
		    </div>
		</div>
	</script>
	
	<div class="container-f">
		 <div class="box-title clearfix tab-title">
			<h3>
				<a href="<%=basePath %>jsp/assetadmin/pandianqingcha/daochu/pdsjdczp.jsp">
				<span class="fa fa-table"></span>
				盘点数据导出
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/assetadmin/pandianqingcha/daoru/pdjgdrzp.jsp">
				<span class="fa fa-cog"></span>
				盘点结果导入
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>jsp/assetadmin/pandianqingcha/jilu/pdlsjlzp.jsp">
				<span class="fa fa-bar-chart-o"></span>
				盘点历史记录
				</a>
			</h3>
		</div> 
		<div class="box-content clearfix">
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
	 <form action= "<%=basePath %>admincheckresultmanagecontroller/getcheckresultsbyselecttermswithpage.htm"   method="post">
						<table>
							<tr>
								<td style="width:30px">
									<div class="piaochecked">
						        		<input name="need_inv" type="checkbox" style="height:20px;width:20px;" class="radioclass input" value="1">
						    		</div>
								</td>
								<td>
									<h3 style="width:100px">提交时间：</h3>
								</td>
								<td>
									<input class="laydate-icon" id="demo" style="width:163px;height:30px;" name="checktimestart"  value="${checktimestart}"> 
								</td>
								<td style="text-align:center;width:30px"><h3>到</h3></td>
								<td colspan="2">
									<input class="laydate-icon" id="demo1" style="width:163px;height:30px;"  name="checktimeend" value="${checktimeend}">
								</td>
							</tr>
							<tr>
								<td style="width:30px">
									<div class="piaochecked">
						        		<input name="need_inv" type="checkbox" style="height:20px;width:20px;" class="radioclass input" value="1">
						    		</div>
								</td>
								<td><h3 style="width:100px">盘点人：</h3></td>
								<td><input type="text" style="width:163px;height:30px;" id="checkpeople" value="${checkpeople}" name="checkpeople"></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td style="width:30px">
									<div class="piaochecked">
						        		<input name="need_inv" type="checkbox" style="height:20px;width:20px;" class="radioclass input" value="1">
						    		</div>
								</td>
								<td><h3 style="width:100px">盘点编号：</h3></td>
								<td><input type="text" style="width:163px;height:30px;"  id="resultnum" value="${resultnum}"  name="resultnum"></td>
								<td></td>
								<td style="text-align:left;">
									<input type="submit"  id="searchBtn"  value="查询" class="btn cf"  style="margin-left:10px"  onclick="search()">
								</td>
								<td style="text-align:left;">
									<input type="button" id="exportBtn" value="导出" class="btn cf">
								</td>
							</tr>
						</table>
			</form>
					</div>
				</div>
				
			</div>	
		</div>
		<div style="margin-top:10px;" id="list">
			<table  class="table-hover dataTable">
				<tr>
					<th style="background-color:#eee;">
						<div id="allselect" class="piaochecked">
        					<input name="need_inv" type="checkbox" style="height:20px;width:20px;" class="radioclass input" value="1">
    					</div>
					</th>
					<th style="background-color:#eee;">序号</th>
					<th style="background-color:#eee;">盘点编号</th>
					<th style="background-color:#eee;">提交人</th>
					<th style="background-color:#eee;">盘点时间</th>
					<th style="background-color:#eee;">详情</th>
					<th style="background-color:#eee;">备注</th>
				</tr>
				<c:forEach items="${checkResultList}" var="checkResultList"  varStatus="index">  
				<tr>
					<td><input style="width:20px;height:15px" type="checkbox" /></td>
					<td>${index.count}</td> 
					<td>${checkResultList.resultnum}</td>
					<td>${checkResultList.checkpeople}</td>
					<td><fmt:formatDate value="${checkResultList.checktime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<a href="<%=basePath %>admincheckresultmanagecontroller/getassetdetailbyresultnumwithpage.htm?resultnum=${checkResultList.resultnum}" class="btn" rel="tooltip" title="详情">
							<i class="fa fa-plus"></i>详情
						</a>
					</td>
					<td>
						<a href="javascript:remark();" onclick="remark()"class="remarkbtn" rel="tooltip" title="查看"  ids="${checkResultList.resultnum}" >
							<i class="fa fa-plus"></i>查看
						</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
	<!--<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>  -->
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript">
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
		
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo'});//绑定元素
		}();
		
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo1'});//绑定元素
		}();
		
		$(".piaochecked").on("click",function(){
		    $(this).hasClass("on_check")? $(this).removeClass("on_check"):$(this).addClass("on_check");
		});
		
		$("#allselect").on("click",function(){
			$(this).hasClass("on_check")? $(this).removeClass("on_check"):$(this).addClass("on_check");
			var smselect=document.getElementsByClassName("piaochecked");
			if($(this).hasClass("on_check")){
				$(this).removeClass("on_check");
				for(var i=3;i<smselect.length;i++){
					smselect[i].className="piaochecked";
				}
			}else{
				$(this).addClass("on_check");
				for(var i=3;i<smselect.length;i++){
					smselect[i].className="piaochecked on_check";
				}
			}
		});
		Vue.component('modal', {
				template: '#modal-template1',
				props: {
				    show: {
				        type: Boolean,
				        required: true,
				        twoWay: true    
				    }
				}
			});
		
		// start app
		new Vue({
		    el: '#app',
		    data: {
		    	showModal: false
		    }
		});
	</script>
	
   <div class="font">
	<cc:page  value="${pager }"  url="${basePath}admincheckresultmanagecontroller/getcheckresultsbyselecttermswithpage.htm"></cc:page>
	</div>
</body>
</html>
	
	
	