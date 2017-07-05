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
    <title>starting page</title>
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
	<link rel="stylesheet" type="text/css"href="<%=basePath%>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css"href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css"href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css"href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
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
						<a style="width:80px;margin-left:4px;" id="btnAdd" class="btn cf"> <i class="fa fa-plus"></i><span>新增备份</span></a>
					</div>
				</div>
			</div>	
		</div>
 		<div style="margin-top:10px;" id="list">
			<fieldset>
			<legend >部门管理</legend>
			<c:choose>
  	<c:when test="${not empty dbList }">
		<table id="tableinfo" class="table-hover dataTable">
			<tr>
				<th>序号</th>
				<th>备份名称</th>
				<th>备份时间</th>
				<th>备份说明</th>
                <th class="tab-th">操作</th>
			</tr>
			<c:forEach items="${dbList}" var="dbList"  varStatus="index"> 
			<tr>
				<td class="tab-td">${index.count}</td>
				<td class="tab-td">${dbList.dbname}</td>
				<td class="tab-td"><fmt:formatDate value="${dbList.dbdate}" pattern="yyyy-MM-dd "/></td></td>
                <td class="tab-td">${dbList.remark}</td>
				<td class="tab-td">
					<a href="javascript:void(0);" class="btn"  onclick="recover(this.id)"   id="${dbList.dbname}"  style="width:65px;" ><i class="fa fa-plus"></i>恢复备份</a>
					<a href="javascript:void(0);" class="btn"  onclick="deletesql(this.id)"   id="${dbList.dbname}"  style="width:65px;" ><i class="fa fa-times"></i>删除备份</a>
				</td>
			</c:forEach>			
  		</table>
  		</c:when>
  		<c:otherwise>
  		 暂无数据
  		</c:otherwise>
  		</c:choose>
  		   <div class="font">
	<cc:page  value="${pager }"  url="${basePath}AdminDbController/indexjyg.htm"></cc:page>
	</div>
				<!-- <div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div> -->
			</fieldset>   
		</div>
</div> 

<div class="container-f">
		
		<div class="box-content clearfix">
			
		</div>
		<div style="margin-top:10px;">
			
		</div>
	</div>

	<div class="modal fade" id="tianjiabeifeng">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-plus"></i>新增备份</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<table>
								<tr>
									<td>
										<label class="control-label" for="web_bg">备份名称：</label>
									</td>
									<td>
										<input type="text" class="in"  id="dbname"  name="dbname"><pbn></pbn>
									</td>
								</tr>
								<tr>
									<td>
										<label class="control-label" for="web_bg">备份说明：</label>
									</td>
									<td>
										<textarea style="width:300px;height:100px" id="remark"></textarea>
									</td>
								</tr>
								</table>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div style="margin-left:200px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary cf save_btn save" value="保存"  style="height:30px;padding-top:0px;" onclick="adddbrecord()" ></span> 
			<span style="margin-left:5px;"> <input type="button" id="clear"  style="height:30px;padding-top:0px;"class="btn btn-primary" value="取消"   data-dismiss="modal">
			</span>
		</div> 
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<!-- <script type="text/javascript">
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
	</script> -->
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/bootstrap.min.js"></script>
	<script>
		$(function(){
	    	$("#btnAdd").click(function(){
	        	$("#tianjiabeifeng").modal("toggle");
	    	});
	    });
	    
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
					if(parseInt(inputpage)>parseInt(totalPage)){
						document.getElementById("inputPage").value="";
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
	function adddbrecord(){
	 //获取本机时间
	 var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
      var dbname=document.getElementById("dbname").value;
      var remark=document.getElementById("remark").value;
      if(dbname==""){
    	  $("pbn").html("不能为空");
    	  return false;
      }
      if(dbname!=""){
    	  $("pbn").html("");
		 $.ajax({ 
				type:"POST", //表单提交类型 
				url:'<%=basePath%>AdminDbController/backupdb.htm', 
				data:{dbname:dbname,remark:remark,currentdate:currentdate}, //表单数据
				success:function(e){
									var  data = eval("("+e+")");
									if(data.status == 'ok'){
										document.getElementById("dbname").value="";
										document.getElementById("remark").value="";
										alert(data.msg);
										 location.reload();
										}
									if(data.status == 'no'){
										document.getElementById("dbname").value="";
										document.getElementById("remark").value="";
										alert(data.msge);
										 location.reload();
									}
									if(data.status == 'no1'){
										alert(data.msg1);
										document.getElementById("dbname").value="";
									}
				}
			}); 
      }
	}
	
	//关闭模态框
	   $(function () { $("#tianjiabeifeng").on('hidden.bs.modal', function () {
	document.getElementById("dbname").value="";
	document.getElementById("remark").value="";
	 $("pbn").html("");
	/*   $("p-adddepcode").html("");
	 $("p-adddepname").html(""); 
	 document.getElementById("dep-code-legal").value="false";//记录部门代码的合法性 避免保存时再进行ajax验证
	 document.getElementById("dep-name-legal").value="false";//记录部门名称的合法性 避免保存时再进行ajax验证
	$('#adddepstate').combobox({}).combobox("initClear");*/
	});
   });
	
	//还原数据库
	function recover(obj){
		 $.ajax({ 
				type:"POST", //表单提交类型 
				url:'<%=basePath%>AdminDbController/recoverdb.htm', 
				data:{dbname:obj}, //表单数据
				success:function(e){
									var  data = eval("("+e+")");
									if(data.status == 'ok'){
										alert(data.msg);
										}
									if(data.status == 'no'){
										alert(data.msge);
										}
				}
			}); 
	}
	//删除记录
	function deletesql(obj){
		 $.ajax({ 
				type:"POST", //表单提交类型 
				url:'<%=basePath%>AdminDbController/deletedb.htm', 
				data:{dbname:obj}, //表单数据
				success:function(e){
									var  data = eval("("+e+")");
									if(data.status == 'ok'){
										alert(data.msg);
										}
									if(data.status == 'no'){
										alert(data.msge);
										}
									 location.reload();
				}
			}); 
	}
	</script>
  </body>
</html>