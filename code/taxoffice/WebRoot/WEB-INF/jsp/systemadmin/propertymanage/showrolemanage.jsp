<%@ page contentType="text/html;charset=utf-8" language="java"
	import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/pageuri" prefix="cc"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>角色管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/page.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/themes/material/easyui.css" />

<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>




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

		//添加角色
		function addrole() {
			var rolename1=document.getElementById("modal_add_id").value;
			//alert(rolename1)
			
			$.ajax({ 				
			     type:"POST", //表单提交类型 
			     url:"<%=basePath%>AdminRoleController/addrole.htm", //表单提交目标 
			     data:{rolename:rolename1},		     
			     success:function(e){
			    	 //alert(e)
			     var  data = eval("("+e+")");
			      if(data.status == '1'){//msg 是后台调用action时，你穿过来的参数
			       		alert("添加角色成功");	
			      		window.location.href="<%=basePath%>AdminRoleController/index.htm";
			      }else if(data.status=='2'){
			    	  alert("该角色已存在，请重新添加新角色")
			      }else if(data.status=='0'){
					alert("添加角色失败");
			      }
			     }
			    }); 	
		}    
    
		
		//根据角色名字删除角色
		function delerolebyrolename(e) {
			var roleid1=e.getAttribute("roleid");
			//alert(roleid1)
			if(confirm('您确定要删除吗？')){
				$.ajax({ 				
				     type:"POST", //表单提交类型 
				     url:"<%=basePath%>AdminRoleController/deleterolebyid.htm", //表单提交目标 
				     data:{roleid:roleid1},		     
				     success:function(e){
				    	 //alert(e)
				     var  data = eval("("+e+")");
				      if(data.status == '1'){//msg 是后台调用action时，你穿过来的参数
				       		alert("删除角色成功");	
				      		window.location.href="<%=basePath%>AdminRoleController/index.htm";				 
				      }else if(data.status=='0'){
						alert("删除角色失败");
				      }
				     }
				    }); 	
				
			};
			
		}
		
		
		//重命名：
		function updaterolebyid() {
			//获取要更新的id值与对应的名称
			//var roleid=e.getAttribute("roleid");
			//alert(roleid);
			
			//alert("123")
			var roleids=document.getElementById("modal_rename_ids").value;
			
			var rolename1=document.getElementById("modal_rename_id").value;
			//alert(roleids)
			//alert(rolename1)
			$.ajax({ 				
			     type:"POST", //表单提交类型 
			     url:"<%=basePath%>AdminRoleController/updaterolebyid.htm", //表单提交目标 
			     data:{id:roleids,rolename:rolename1},		     
			     success:function(e){
			    	 //alert(e)
			     var  data = eval("("+e+")");
			      if(data.status == '1'){//msg 是后台调用action时，你穿过来的参数
			       		alert("角色重命名成功");	
			      		window.location.href="<%=basePath%>AdminRoleController/index.htm";				 
			      }else if(data.status=='0'){
					alert("角色重命名失败");
			      }
			     }
			    }); 	
			
			
		}
		
    </script>



<style type="text/css">

body {
	min-width: 700px;
}

fieldset {
	margin-top: 20px;
	margin-bottom: 10px;
	padding-top: 15px;
	padding-bottom: 5px;
	padding-left: 10px;
	padding-right: 10px;
}

legend {
	font-weight: bold;
	font-size: 14px;
}

div.modal-footer {
	padding: 0px;
}

div.modal-header {
	padding: 0px;
	padding-top: 10px;
	padding-left: 30px;
}

.modal_save,.modal_giveUp {
	height: 30px;
}

.modal_save {
	padding-top: 7px;
	padding-bottom: 8px;
	margin-left: 105px;
}

.modal_giveUp {
	padding-top: 7px;
	padding-bottom: 8px;
	margin-right: 50px;
}
</style>
<style>
.leftMenu {
	padding: 0px;
}

.leftMenu .panel-title {
	font-size: 15px;
	position: relative;
	cursor: pointer;
	padding: 7px 10px;
}

.leftMenu .panel-heading span {
	position: absolute;
	right: 10px;
}

.leftMenu .list-group .list-group-item {
	padding: 5px;
	padding-left: 35px;
	text-align: left;
	border: none;
	border-radius: 1px;
	cursor: pointer;
	font-size: 15px;
}

.leftMenu .list-group-item:hover,.look_res {
	background: #368ee0;
	border: none;
	color: white;
}

.activeList {
	background: #efe;
	border: none;
	color: black;
}

.listGroupItem0,.listGroupItem01 {
	padding: 5px;
	padding-left: 20px;
	text-align: left;
	border: none;
	border-radius: 1px;
	cursor: pointer;
	font-size: 15px;
}

.listGroupItem0:hover {
	background: #368ee0;
	border: none;
	color: white;
}

.fa-times {
	padding: 2.5px;
}

#middleImage {
	width: 15px;
	height: 30px;
	opacity: 0.2;
	cursor: pointer;
}

#listGroupItemUl,#listGroupItemUl0 {
	height: 300px;
	overflow: auto;
}
</style>

</head>
<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="<%=basePath%>AdminRoleController/index.htm"> <span
					class="fa fa-table"></span> 角色管理
				</a>
			</h3>
			<h3>
				<a
					href="<%=basePath%>AdminAuthController/showpropertymanagewithpage.htm">
					<span class="fa fa-cog"></span> 权限管理
				</a>
			</h3>
		</div>
		<div class="box-content clearfix">
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a style="width:80px;margin-top:10px;margin-left:4px;" id="addBtn"
							class="btn cf"> <i class="fa fa-plus"></i><span>添加角色</span></a>
					</div>
				</div>
			</div>
		</div>
		<div style="margin-top:10px;" id="list">
			<fieldset>
				<legend>角色管理</legend>
				<c:if test="${not empty roles  }">
					<table class="table-hover dataTable">
						<tr>
							<th style="background-color:#eee;">序号</th>
							<th style="background-color:#eee;">角色名称</th>
							<th style="background-color:#eee;">查看权限</th>
							<th style="background-color:#eee;">编辑权限</th>
							<th style="background-color:#eee;">重命名</th>
							<th style="background-color:#eee;">删除</th>
						</tr>
						<c:forEach items="${roles }" var="role" varStatus="index">
							<tr>
								<td>${index.count }</td>
								<td>${role.rolename }</td>
								<td><a id="Btn" class="btn cf lookBtn" roleid="${role.id }"
									style="padding-top:7px;"> <i class="fa fa-search"></i> <span>查看</span>
								</a></td>
								<td><a id="Btn" class="btn cf updateBtn"
									style="padding-top:7px;" rolename="${role.rolename }"> <i
										class="fa fa-edit"></i> <span>编辑</span>
								</a></td>
								<td><a id="Btn" class="btn cf renameBtn"
									style="padding-top:7px;width:60px;"
									rolename="${role.rolename }" roleid="${role.id }"> <i
										class="fa fa-edit"></i> <span>重命名</span>
								</a></td>

								<td><a id="Btn" class="btn cf" style="padding-top:7px;"
									roleid="${role.id }" onclick="delerolebyrolename(this)"> <i
										class="fa fa-times"></i> <span>删除</span>
								</a></td>
							</tr>
						</c:forEach>

					</table>
					<cc:page value="${pager}" url="AdminRoleController/index.htm"></cc:page>
				</c:if>
				<c:if test="${empty roles }">
					暂无数据
				</c:if>
			</fieldset>
		</div>
	</div>

	<div class="modal fade" id="modalAdd">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix"
							style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l">
								<h3>
									<i class="fa fa-plus"></i>添加角色
								</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body" style="padding:0px;">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" id="modal_add"
							class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg"> 角色名称： </label>
								<div class="controls">
									<input type="text" name="title" id="modal_add_id"
										data-rule-maxlength="60" class="input-medium ipt_require"
										style="height:30px;width:250px;border:1px solid #ddd;">
								</div>
							</div>

						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input class="btn btn-primary modal_save" data-dismiss="modal"
							onclick="addrole()" value="添加"> <input
							class="btn btn-primary modal_giveUp" data-dismiss="modal"
							value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="modalLook">
		<div class="modal-dialog" style="width:500px">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix"
							style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l">
								<h3>
									<i class="fa fa-search"></i>查看权限
								</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body" style="padding:0px;">
					<table
						style="font-size:18px;width:400px;margin-top:20px;margin-left:50px;"
						cellspacing="0" cellpadding="0">
						<tr>
							<td
								style="border:solid 1px #eee;font-size:15px;font-weight:bold;">
								<p style="padding-left:10px;">权限列表&nbsp;></p>
							</td>
						</tr>
						<tr>
							<td style="border:solid 1px #eee;background-color:#eee">
								<ul id="listGroupItemUl0" style="height:200px;">
									<!-- <li class="listGroupItem01">系统管理员添加功能</li>
									<li class="listGroupItem01">系统管理员修改功能</li>
									<li class="listGroupItem01">系统管理员添加功能</li>
									<li class="listGroupItem01">系统管理员修改功能</li>
									<li class="listGroupItem01">系统管理员添加功能</li>
									<li class="listGroupItem01">系统管理员修改功能</li>
									<li class="listGroupItem01">系统管理员添加功能</li>
									<li class="listGroupItem01">系统管理员修改功能</li>
									<li class="listGroupItem01">系统管理员添加功能</li>
									<li class="listGroupItem01">系统管理员修改功能</li> -->
								</ul>
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input class="btn btn-primary modal_save"
							style="margin-right:25px;" data-dismiss="modal" value="确定" >
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modalUpdate">
		<div class="modal-dialog" style="width:800px;">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix"
							style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l">
								<h3>
									<i class="fa fa-edit"></i>编辑权限
								</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body"
					style="padding-top:20px;padding-bottom:20px;">
					<table style="width:100%;font-size:18px;" cellspacing="0"
						cellpadding="0">
						<tr>
							<td
								style="width:44%;border:solid 1px #eee;font-size:15px;font-weight:bold;">
								<p style="padding-left:10px;">权限列表&nbsp;></p>
							</td>
							<td style="width:12%" rowspan="3" valign="middle" align="center">
								<img id="middleImage"
								src="<%=basePath%>Public/Images/right00.png" />
							</td>
							<td
								style="width:44%;border:solid 1px #eee;font-size:15px;font-weight:bold;">
								<p style="padding-left:10px;">已选权限&nbsp;></p>
							</td>
						</tr>
						<tr valign="top">
							<td style="border:solid 1px #eee;background-color:#eee">
								<div class="panel-group table-responsive" role="tablist"
									style="height:300px;overflow:auto;">
									<div class="panel panel-primary leftMenu">
										<div class="panel-heading" id="collapseListGroupHeading1"
											data-toggle="collapse" data-target="#collapseListGroup1"
											role="tab">
											<h4 class="panel-title">
												<font class="tran">></font>&nbsp;<label id="namerole"
													style="cursor:pointer;"></label>
											</h4>
										</div>
										<div id="collapseListGroup1" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="collapseListGroupHeading1">
											<ul class="list-group">
												<li class="list-group-item" id="item_11">系统管理权限</li>
												<li class="list-group-item" id="item_12">资产管理权限</li>
												<li class="list-group-item" id="item_13">故障与维修权限</li>
												<li class="list-group-item" id="item_14">查询权限</li>
												 <li class="list-group-item" id="item_15">人员变动通知权限</li>
												<!-- <li class="list-group-item" id="item_16">资产管理模块全部功能</li>
												<li class="list-group-item" id="item_17">数据管理模块查询功能</li>
												<li class="list-group-item" id="item_18">数据管理模块其他功能</li>
												<li class="list-group-item" id="item_19">数据管理模块全部功能</li> --> 
											</ul>
										</div>
									</div>
									
								</div>
							</td>
							<td style="border:solid 1px #eee;background-color:#eee">
								<ul id="listGroupItemUl">
									<!--<li class="listGroupItem0">系统管理员添加功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员修改功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员删除功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员查询功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员导入导出功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员其他功能<i class="fa" style="float:right"></i></li>-->
								</ul>
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input class="btn btn-primary modal_save" data-dismiss="modal"
							value="保存" onclick="return resl()"> <input
							class="btn btn-primary modal_giveUp" data-dismiss="modal"
							value="取消" onclick="return resl_up()">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modalRename">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix"
							style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l">
								<h3>
									<i class="fa fa-edit"></i>重命名角色
								</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body" style="padding:0px;">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" id="modal_add"
							class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg"> 角色名称： </label>
								<div class="controls">
									<input type="hidden" id="modal_rename_ids"> <input
										type="text" name="title" id="modal_rename_id"
										data-rule-maxlength="60" class="input-medium ipt_require"
										style="height:30px;width:250px;border:1px solid #ddd;">
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id"> <input
							class="btn btn-primary modal_save" data-dismiss="modal"
							onclick="updaterolebyid()" value="保存"> <input
							type="hidden" name="id"> <input
							class="btn btn-primary modal_giveUp" data-dismiss="modal"
							value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/table.js"></script>
	<script>
		$(document).ready(function(){
			//编辑模态框功能的实现
			$(".panel-heading").click(function(){
				if($(this).find("font").hasClass("tran")){
					$(this).find("font").html("v");
					$(this).find("font").removeClass("tran");
				}else{
					$(this).find("font").html(">");
					$(this).find("font").addClass("tran");
				}
            });
            
			$(".list-group-item").click(function(){
				//$(".list-group-item").removeClass("activeList");
				//$(this).addClass("activeList");
				var conten=$(this).html();
				var cont="<li class='listGroupItem0' id='"+$(this).attr('id')+"'><label>"+conten+"</label><i class='fa' style='float:right;'></i></li>";
				
				//$("#listGroupItemUl").remove(cont);
				if(!($(this).hasClass("activeList"))){
					$(this).addClass("activeList");
					$("#listGroupItemUl").append(cont);
				}
				
				$(".listGroupItem0").mouseover(function(){
					$(this).find("i.fa").addClass("fa-times");
				});
				$(".listGroupItem0").mouseout(function(){
					$(this).find("i.fa").removeClass("fa-times");
				});
				$("i.fa").click(function(){
					var results=$(this).parents(".listGroupItem0").attr("id");
					$(".list-group").find("#"+results).removeClass("activeList");
					$(this).parents(".listGroupItem0").hide();
				});
			});
			$(".listGroupItem0").mouseover(function(){
				$(this).find("i.fa").addClass("fa-times");
			});
			$(".listGroupItem0").mouseout(function(){
				$(this).find("i.fa").removeClass("fa-times");
			});
			$("i.fa").click(function(){
				var resulted=$(this).parents(".listGroupItem0").attr("id");
				$(".list-group").find("#"+resulted).removeClass("activeList");
				$(this).parents(".listGroupItem0").hide();
			});
			
			//查询功能的实现
			$("#look_btn").click(function(){
				if($("#query_btn").val() && $("#query_btn").val()!=''){
					$(".panel-heading").removeClass("collapsed");
					$(".panel-heading").find("font").html(">");
					$(".panel-heading").find("font").addClass("tran");
					$(".panel-collapse").removeClass("in");
					$(".panel-collapse").height("auto");
					$(".list-group-item").each(function(){
						if($(this).html().indexOf($("#query_btn").val()) >=0){
							$(this).parent().parent().parent().children(".panel-heading").addClass("collapsed");
							$(this).parent().parent().parent().children(".panel-heading").find("font").html("v");
							$(this).parent().parent().parent().children(".panel-heading").find("font").removeClass("tran");
							$(this).parent().parent().addClass("in");
							$(this).parent().parent().height("auto");
							
						}
					});
					
				}
				else{
					alert("请输入查询内容！");
					$("#query_btn").focus();
				}
			});
		});
		
		function resl_up(){
			$("#listGroupItemUl").html("");
			for(var j=0;j<$(".list-group-item").length;j++){
				$(".list-group-item:eq("+j+")").removeClass("activeList");
			}
			$(".panel-heading").removeClass("collapsed");
			$(".panel-heading").find("font").html(">");
			$(".panel-heading").find("font").addClass("tran");
			$(".panel-collapse").removeClass("in");
			$(".panel-collapse").height("auto");
		}
		
		function resl(){
			var save_length=$(".listGroupItem0").find("label").length;
			var saveStr="";
			//var save_array=new array(100);
			//var save_array=new Array();
			for(var i=0;i<save_length;i++){
				//save_array[i]=$(".listGroupItem0:eq("+i+")").find("label").html();
				saveStr+=$(".listGroupItem0:eq("+i+")").find("label").html()+";";
			}
			var rolename1=document.getElementById("namerole").innerText;
			
			$("#listGroupItemUl").html("");
			
			for(var j=0;j<$(".list-group-item").length;j++){
				$(".list-group-item:eq("+j+")").removeClass("activeList");
			}
			$.ajax({ 				
			     type:"POST", //表单提交类型 
			     url:"<%=basePath%>AdminRoleController/addauthtorole.htm", //表单提交目标 
			     data:{authStr:saveStr,rolename:rolename1},		     
			     success:function(e){
			    	
			     var  data = eval("("+e+")");
			      if(data.status == '1'){//msg 是后台调用action时，你穿过来的参数
			       		alert("角色编辑权限成功");	
			      		//window.location.href="<%=basePath%>AdminRoleController/index.htm";
			      }else if(data.status=='0'){
					alert("角色编辑权限失败");
			      }
			     }
			    });
			
		}
		
	</script>
	<script type="text/javascript">
		/* $('.pagination').pagination(100, {
			callback : function(page) {
				console.log(page + 1);
			},
			display_msg : true,
			setPageNo : true
		}); */
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
	</script>
	<script type="text/javascript"
		src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	<script>
		var modaling=document.getElementsByClassName("modal-dialog");
		$(function(){
	    	$("#addBtn").click(function(){
	        	$("#modalAdd").modal("toggle");
	        	modaling[0].style.marginTop=($(window).height())/4+"px";
	    	});
	    	$('#modalAdd').on('shown.bs.modal', function () {
	    		var add_value=$('#modal_add_id').val();
			  	$('#modal_add_id').val("").focus().val(add_value);
			});
	    });
	    
	    $(function(){
	    	var roleid1="";
	    	$(".lookBtn").click(function(){
	    		roleid1=$(this).attr("roleid");
	    		/* alert(roleid1); */
	        	$("#modalLook").modal("toggle");
	    	});
	    	
			$('#modalLook').on('shown.bs.modal', function () {
				document.getElementById("listGroupItemUl0").innerHTML="";
	    		//see_authority_res="";
				$.ajax({ 				
				     type:"POST", //表单提交类型 
				     url:"<%=basePath%>AdminRoleController/getauthnamesbyroleid.htm", //表单提交目标 
											data : {
												roleid : roleid1
											},
											success : function(e) {
											
												var data = eval("(" + e + ")");
												if (data.status == '0') {//msg 是后台调用action时，你穿过来的参数
													document.getElementById("listGroupItemUl0").innerHTML="该角色暂时没有被分配权限";

												} else {
													var resuleStr = data.status;

													var arr = resuleStr
															.split(";");
													for (var i = 0; i < arr.length - 1; i++) {
														
														document.getElementById("listGroupItemUl0").innerHTML+="<li class='listGroupItem01'>"+arr[i]+"</li>";
													}
												}
											}
										});
							});

		});

		$(function() {
			var namerole1 = "";
			$(".updateBtn").click(function() {
				namerole1 = $(this).attr("rolename");
				$("#modalUpdate").modal("toggle");
			});
			$('#modalUpdate').on('shown.bs.modal', function() {

				$('#namerole').text(namerole1);
				var query_value = $('#query_btn').val();
				$('#query_btn').val("").focus().val(query_value);
			});
		});
		$(function() {
			var rolename1 = '';
			var roleid1 = "";
			$(".renameBtn").click(function() {

				rolename1 = $(this).attr('rolename');
				roleid1 = $(this).attr('roleid');

				$("#modalRename").modal("toggle");
				modaling[2].style.marginTop = ($(window).height()) / 4 + "px";
			});
			$('#modalRename').on('shown.bs.modal', function() {

				//var modal_value=$('#modal_rename_id').val();
				$('#modal_rename_ids').val("").focus().val(roleid1);
				$('#modal_rename_id').val("").focus().val(rolename1);
				/* $('#modal_rename_id').val(rolename1).focus().val(modal_value); */
			});
		});
	</script>
</body>
</html>

