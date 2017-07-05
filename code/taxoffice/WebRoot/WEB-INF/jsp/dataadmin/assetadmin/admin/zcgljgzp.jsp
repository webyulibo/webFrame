<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/pageuri" prefix="cc"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资产管理查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/bootstrap.min.css" />
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
		div.modal-body{
			padding:0px;
		}
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
	
	function downloadPdf(){
		var isNo=false;
		$(".checkBox").each(function(){
			isNo=$(this).prop("checked");
			if(isNo){
				return false;
			}
		});
		if(isNo==true){
			var i=0;
			var data="";
			$(".checkBox").each(function(){
				if($(this).prop("checked")){
					if(i===0){
						data+=$(this).attr("value");	
					}else{
						data+=(","+$(this).attr("value"));
					}
					i++;
				}
			});
			alert(data);
			window.open("${pageContext.request.contextPath }/adminasset/createlabel.htm?data="+data);
        }else{
        	alert("您未选中任何标签！");
        }		
	}
	
	</script>
	
	
</head>
<body>
	<div class="container-f">
	 	<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="<%=basePath %>adminasset/showassetmenu.htm">
				<span class="fa fa-table"></span>
				资产管理
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>adminasset/showassetinput.htm">
				<span class="fa fa-cog"></span>
				资产信息导入
				</a>
			</h3>
			<h3 >
				<a href="<%=basePath %>adminasset/showassetoutput.htm">
				<span class="fa fa-bar-chart-o"></span>
				资产信息导出
				</a>
			</h3>
		</div> 
		<div class="box-content clearfix">
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a style="margin-top:10px;margin-left:4px;"  id="Btn"  class="btn btn-primary"  href="<%=basePath%>adminasset/showassetmenu.htm"> <i class="fa"></i><span>返回</span></a>
					</div>
				</div>
				<div class="control-group f_l" style="float:right;">
					<div class="f_l">
						<%-- <a href="<%=basePath%>adminasset/showassetadd.htm" style="margin-top:10px;margin-left:4px;" id="addBtn" class="btn cf"> <i class="fa fa-plus"></i><span>添加</span></a> --%>
						<a href="<%=basePath%>adminasset/showassetadd.htm" id="btn-add" style="margin-top:10px;margin-left:4px;" class="btn cf"> <i class="fa fa-plus"></i><span>添加</span></a>
					</div>
				</div>
			</div>	
		</div>
		<div style="margin-top:10px;" id="list">
		<fieldset>
		<legend>查询结果</legend>
		<c:if test="${not empty assets }">
			<table  class="table-hover dataTable">
				<tr>
					<th  style="background-color:#eee;width:10%"><input class="checkBoxAll" name="Fruit" type="checkbox" value="" />序号</th>
					<!-- <th style="background-color:#eee;width:6%">序号</th> -->
					<th style="background-color:#eee;width:15%;">资产代码</th>
					<th style="background-color:#eee;">资产名称</th>
					<th style="background-color:#eee;">使用人</th>
					<th style="background-color:#eee;">使用部门</th>
					<th style="background-color:#eee;">保管人</th>
					<th style="background-color:#eee;">保管部门</th>
					<th style="background-color:#eee;">使用状态</th>
					<th style="background-color:#eee;">操作</th>
				</tr>
					
  			<!-- varStatus="s" -->
  			<c:forEach items="${assets }" var="asset" varStatus="s">
  			<tr>
  			
  				<td><c:choose>
    						<c:when test="${s.count != 10}">
      							 <input class="checkBox"  name="Fruit" type="checkbox" value="${asset.id }"  style="margin-right:20px"/>
    						</c:when>
    						<c:otherwise>
        						<input class="checkBox"  name="Fruit" type="checkbox" value="${asset.id }"  style="margin-right:10px"/>
    						</c:otherwise>
						</c:choose>
  				<c:out value="${(pager.currentPage-1)*10+s.count }"></c:out></td>
  				<td>${asset.code}</td>
  				<td>${asset.name }</td>
  				<td>${asset.user }</td>
  				<td>${asset.usedepartment }</td>
  				<td>${asset.keeper }</td>
  				<td>${asset.keepdepartment }</td>
  				<td>${asset.usestate }</td>
  				<td>
  				<a href="<%=basePath%>adminasset/showassetbyid.htm?id=${asset.id}&assetCurrentPage=${pager.currentPage}" class="btn btn-edit" rel="tooltip" title="修改">
				<i class="fa fa-edit"></i>修改</a></td>
  			</tr>
  			</c:forEach>
  					
			</table>
			<div style="padding-top:20px;margin-bottom:15px;">
  	<a style="background-color:#368eff;width:100px;margin-left:10px;border-radius: 4px;  color:#FFFFFF;  text-decoration:none; font-size: 15px;  margin-bottom:25px; margin-left: 10px;  padding: 5px 15px;" id="tag" onClick="downloadPdf()" href="javascript:void(0)"><i class="fa fa-plus"></i>生成标签</a></div>
			<cc:page value="${pager}"
			url="adminasset/getassetcheckresultwithpage.htm?usestate=${assetCustom.usestate }&name=${assetCustom.name }&keepdepartment=${assetCustom.keepdepartment }&usedepartment=${assetCustom.usedepartment }&isbegin1=${ assetCustom.isbegin1}&state=${assetCustom.state }&code=${assetCustom.code }&keeper=${assetCustom.keeper }&user=${assetCustom.user }&ghostyear=${assetCustom.ghostyear }&type1=${assetCustom.type1 }&type2=${assetCustom.type2 }&type3=${assetCustom.type3 }&type4=${assetCustom.type4 }&type5=${assetCustom.type5 }&purchasetime=${assetCustom.purchasetime }&makecardtime=${assetCustom.makecardtime }&startusetime=${assetCustom.startusetime }&value=${assetCustom.value }&abortpurchasetime=${assetCustom.abortpurchasetime }&abortmakecardtime=${assetCustom.abortmakecardtime }&abortstartusetime=${assetCustom.abortstartusetime }&abortvalue=${assetCustom.abortvalue }"></cc:page>
			</c:if>
			
			<c:if test="${empty assets }">
				暂无符合条件的数据
			</c:if>
			
			<!-- <div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div> -->
		</fieldset>
		</div>
	</div>

	<div class="modal fade" id="modalAdd">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-plus"></i>添加资产</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" id="modal_add" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									序号：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_add_id" data-rule-maxlength="60"  class="input-medium ipt_require" style="height:30px;width:250px;border:1px solid #ddd;">
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									资产代码：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_add_number" data-rule-maxlength="60"  class="input-medium ipt_require" style="width:250px;height:30px;border:1px solid #ddd;">
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									资产名称：
								</label>
								<div class="controls">
									<select name="bg_img" style="height:30px;width:250px;padding:5px 2px;cursor:pointer;border:1px solid #ddd;">
										<option value=""></option>
										<option value="电脑">电脑</option>
										<option value=""></option>
										<option value=""></option>			
									</select>
								</div>
							</div>

							<div class="control-group cf clearfix">
								<label class="control-label" for="title">
									使用人：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_add_user" data-rule-maxlength="60"  class="input-medium ipt_require" style="width:250px;height:30px;border:1px solid #ddd;">
								</div>
							</div>

							<div class="control-group cf clearfix">
								<label class="control-label" for="title">
									使用部门：
								</label>
								<div class="controls">
									<select name="bg_img" style="height:30px;width:250px;padding:5px 2px;cursor:pointer;border:1px solid #ddd;">
										<option value="办公室" checked="checked">办公室</option>
										<option value="秘书室">秘书室</option>
										<option value="宣传部">宣传部</option>		
									</select>
								</div>
							</div>
							
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									保管人：	
								</div>
								<div class="controls">
									<input type="text" name="sort" id="modal_add_saver" value=""  class="input-medium ipt_require" style="width:250px;height:30px;border:1px solid #ddd;">
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									保管部门：	
								</div>
								<div class="controls">
									<select name="bg_img" style="height:30px;width:250px;padding:5px 2px;cursor:pointer;border:1px solid #ddd;">
										<option value="办公室" checked="checked">办公室</option>
										<option value="秘书室">秘书室</option>
										<option value="宣传部">宣传部</option>		
									</select>	
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									使用状态：	
								</div>
								<div class="controls">
									<select name="bg_img" style="height:30px;width:250px;padding:5px 2px;cursor:pointer;border:1px solid #ddd;">
										<option value="在用" checked="checked">在用</option>
										<option value="维修">维修</option>
										<option value="报废">报废</option>		
									</select>	
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_save" data-dismiss="modal" type="button" value="添加">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_giveUp" data-dismiss="modal" value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modalUpdate">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-edit"></i>修改资产</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" id="modal_update" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									序号：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_update_id" data-rule-maxlength="60"  class="input-medium ipt_require" style="height:30px;width:250px;border:1px solid #ddd;">
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									资产代码：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_update_number" data-rule-maxlength="60"  class="input-medium ipt_require" style="width:250px;height:30px;border:1px solid #ddd;">
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									资产名称：
								</label>
								<div class="controls">
									<select name="bg_img" style="height:30px;width:250px;padding:5px 2px;cursor:pointer;border:1px solid #ddd;">
										<option value=""></option>
										<option value="电脑">电脑</option>
										<option value=""></option>
										<option value=""></option>			
									</select>
								</div>
							</div>

							<div class="control-group cf clearfix">
								<label class="control-label" for="title">
									使用人：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_update_user" data-rule-maxlength="60"  class="input-medium ipt_require" style="width:250px;height:30px;border:1px solid #ddd;">
								</div>
							</div>

							<div class="control-group cf clearfix">
								<label class="control-label" for="title">
									使用部门：
								</label>
								<div class="controls">
									<select name="bg_img" style="height:30px;width:250px;padding:5px 2px;cursor:pointer;border:1px solid #ddd;">
										<option value="办公室" checked="checked">办公室</option>
										<option value="秘书室">秘书室</option>
										<option value="宣传部">宣传部</option>		
									</select>
								</div>
							</div>
							
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									保管人：	
								</div>
								<div class="controls">
									<input type="text" name="sort" id="modal_update_saver" value=""  class="input-medium ipt_require" style="width:250px;height:30px;border:1px solid #ddd;">
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									保管部门：	
								</div>
								<div class="controls">
									<select name="bg_img" style="height:30px;width:250px;padding:5px 2px;cursor:pointer;border:1px solid #ddd;">
										<option value="办公室" checked="checked">办公室</option>
										<option value="秘书室">秘书室</option>
										<option value="宣传部">宣传部</option>		
									</select>	
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">
									使用状态：	
								</div>
								<div class="controls">
									<select name="bg_img" style="height:30px;width:250px;padding:5px 2px;cursor:pointer;border:1px solid #ddd;">
										<option value="在用" checked="checked">在用</option>
										<option value="维修">维修</option>
										<option value="报废">报废</option>		
									</select>	
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input class="btn btn-primary modal_save" data-dismiss="modal" type="button" value="保存">
						<input class="btn btn-primary modal_giveUp" data-dismiss="modal" value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		
		$("#btn-add").attr('href','javascript:void(0)');
		$("#btn-add").attr('onclick','alert("权限不足，无法进行此操作")');
		$("#tag").attr('onclick','alert("权限不足，无法进行此操作")');	
		
		for (var i = 0; i < $(".btn-edit").length; i++) {
			$(".btn-edit").attr("href","javascript:void(0)");
			$(".btn-edit").attr("onclick","alert('权限不足，无法进行此操作')");
		}
				
		</script>	
	
	</shiro:hasPermission>
	
	
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
   <%--  <script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script> --%>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
	//alert(${pager.totalPage});
		$(".checkBoxAll").change(function(){

			 var a =$(this).prop("checked");
				if(a){
					$(".checkBox").prop("checked",true);
				}else{
					$(".checkBox").prop("checked",false);
				}
		});
	});
	function downloadPdf(){
		var isNo=false;
		$(".checkBox").each(function(){
			isNo=$(this).prop("checked");
			if(isNo){
				return false;
			}
		});
		if(isNo==true){
			var i=0;
			var data="";
		
			$(".checkBox").each(function(){
				if($(this).prop("checked")){
					if(i===0){
						data+=$(this).attr("value");	
					}else{
						data+=(","+$(this).attr("value"));
					}
					i++;
				}
			});
			if($(".checkBoxAll").prop("checked")){
				data="all";
			}
			//alert(data);
			window.open("${pageContext.request.contextPath }/adminasset/createlabel.htm?data="+data);
        }else{
        	alert("您未选中任何标签！");
        }		
	}
	
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
	</script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/bootstrap.min.js"></script>
	<script>
		$(function(){
	    	$("#addBtn").click(function(){
	        	$("#modalAdd").modal("toggle");
	    	});
	    });
	    $(function(){
	    	$(".updateBtn").click(function(){
	        	$("#modalUpdate").modal("toggle");
	    	});
	    });
	</script>
	<script>
	$("#modal_add").submit(function (){
		var modal_add_id = document.getElementById("modal_add_id").value;
	 	var modal_add_number = document.getElementById("modal_add_number").value;
		var modal_add_user = document.getElementById("modal_add_user").value;
	 	var modal_add_saver = document.getElementById("modal_add_saver").value;
	 
	 	if(modal_add_id==null||modal_add_id==""){
	 		alert("序号不能为空，请重新输入");
	 		return false;
	 	}
	 	if(modal_add_number.length<=0||modal_add_number.length>15){
	 		alert("资产代码不能超过15个字符，请重新输入");
	 		return false;
	 	}
	 	if(modal_add_user==null||modal_add_user==""){
	 		alert("使用人不能为空，请重新输入");
	 		return false;
	 	}
	 	if(modal_add_saver==null||modal_add_saver==""){
	 		alert("保管人不能为空，请重新输入");
	 		return false;
	 	}
	 });
	 $("#modal_update").submit(function (){
		var modal_add_id = document.getElementById("modal_update_id").value;
	 	var modal_add_number = document.getElementById("modal_update_number").value;
		var modal_add_user = document.getElementById("modal_update_user").value;
	 	var modal_add_saver = document.getElementById("modal_update_saver").value;
	 
	 	if(modal_update_id==null||modal_update_id==""){
	 		alert("序号不能为空，请重新输入");
	 		return false;
	 	}
	 	if(modal_update_number.length<=0||modal_update_number.length>15){
	 		alert("资产代码不能超过15个字符，请重新输入");
	 		return false;
	 	}
	 	if(modal_update_user==null||modal_update_user==""){
	 		alert("使用人不能为空，请重新输入");
	 		return false;
	 	}
	 	if(modal_update_saver==null||modal_update_saver==""){
	 		alert("保管人不能为空，请重新输入");
	 		return false;
	 	}
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
	 <!--<div class="font">
	<cc:page  value="${pager }"  url="${basePath}admincheckresultmanagecontroller/getassetdetailbyresultnumwithpage.htm?resultnum=${resultnum}"></cc:page>
	</div>-->
</body>
</html>
	