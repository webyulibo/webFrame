<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<%@	taglib uri="/pageuri" prefix="cc" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>税务局管理系统</title>

<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/input.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
<style>
.td {
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	vertical-align: top;
	height:50px;
}

.tab td {
	padding-top: 20px;
		padding-right:20px;	
}
</style>

</head>
<body>
	<div class="container-f">
	  	 <div class="box-title clearfix tab-title"> <!-- 标题 -->
			<h3>
				<a href="<%=basePath%>adminmessagecontroller/getsendmessagepageofusedepartment.htm?depcode=${depcode }">
				<span class="fa fa-table"></span>
				发送通知
				</a>
			</h3>
			<h3>
				<a href="<%=basePath%>adminmessagecontroller/getacceptmessagepageofusedepartment.htm?depcode=${depcode}">
				<span class="fa fa-bar-chart-o"></span>
				查看通知列表
				</a>
			</h3>
			<%-- <h3 class="current">
				<a href="<%=basePath %>jsp/informationnotice/usedepartment/staffchangenotice.jsp">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3> --%>
		</div>
			<div class="box-content clearfix" style="padding:10px 5px;width:100%;">
			<div style=" float:left;margin-left:20px;">
				<a href="<%=basePath%>adminmessagecontroller/findacceptmessagepageofusedepartmentbycondition.htm?depcode=${depcode}&currentPage=${currentPage}&title=${title}&sendpeople=${sendpeople}&status=${status}&senddepname=${senddepname}" class="btn btn-primary ">返回</a>
		   </div>
		</div>
	<div style="width:900px; margin-left:100px;margin-top:10px">  <!-- 表格 -->
	<form action="" name="return">
		<fieldset class="search" style="margin-top:20px;">
  			<legend><span style="font-size:14px;">人员变动通知</span></legend>
				<table class="table-hover dataTable" width="900px" >
			<tr>
				<td style="width:22%;"><center>姓名：</center></td>
				<td style="width:28%;">
					<select class="easyui-combobox" name="username"  editable="false" id="username" style="width:100%;height:100%;border:solid 1px gray;padding-left:7px;">
						<option value="${tMobilizepeople.username }">${tMobilizepeople.username }</option>
					</select>
					<script>$(".textbox").width("100%");</script>
				</td>
				<td style="width:20%;"><center>岗位变动：</center></td>
				<td style="width:30%;">
					<select class="easyui-combobox" name="depchange" editable="false" id="depchange"  style="width:100%;height:100%;border:solid 1px gray;padding-left:7px;">
						<option value="${tMobilizepeople.depchange }">${tMobilizepeople.depchange }</option>
					</select>
					<script>$(".textbox").width("100%");</script>
				</td>
			</tr>
			<tr>
				<td width="130px"><center>原部门：</center></td>
				<td>
					<select class="easyui-combobox" name="originaldep" editable="false" id="originaldep" style="width:100%;height:100%;border:solid 1px gray;padding-left:7px;">
						<option value="${tMobilizepeople.originaldep }">${tMobilizepeople.originaldep }</option>
					</select>
					<script>$(".textbox").width("100%");</script>
				</td>
				<td><center>新部门:</center></td>
				<td>
					<select class="easyui-combobox" name="newdep" editable="false" id="newdep" style="width:100%;height:100%;border:solid 1px gray;padding-left:7px;">
						<option value="${tMobilizepeople.newdep }">${tMobilizepeople.newdep }</option>
					</select>
					<script>$(".textbox").width("100%");</script>
				</td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>财务部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea  id="financialdep" style="width:100%;height:100%" readonly>${tMobilizepeople.financialdep }</textarea></td>
			</tr>
			<tr>
				 <c:if test="${tMobilizepeople.status==true }"> 
				<td width="130px" height="140px"><center>使用部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea id="usedep" style="width:100%;height:100%" readonly>${tMobilizepeople.usedep }</textarea></td>
				 </c:if>	
				<c:if test="${tMobilizepeople.status==false }"> 
				<td width="130px" height="140px"><center>使用部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea id="usedep" style="width:100%;height:100%" >${tMobilizepeople.usedep }</textarea></td>
				 </c:if>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>机关服务中心办理情况：</center></td>
				<td colspan="3" height="140px"><textarea id="servicedep" style="width:100%;height:100%" readonly>${tMobilizepeople.servicedep }</textarea></td>
			</tr>
		</table>
	</fieldset>		
		<div style="margin-left:830px;margin-top:30px;"> <!-- 保存 -->
		<c:if test="${tMobilizepeople.status==false }"> 
		 <input type="button" class="btn btn-primary" id="save" value="办理" onclick="return btnsave()">
		 </c:if>
		 <c:if test="${tMobilizepeople.status==true }"> 
		 <input type="button" class="btn btn-primary" id="save" disable value="办理" />
		 </c:if>
		</div>
	</form>
	<input type="hidden" id="tMobilizepeople-id" value="${tMobilizepeople.id }"/>
	</div>
</div>
<script>
//此处将向后台只需要传递  id以及该使用部门更新内容！  并且更新其处理状态        (如此操作是为了防止两个部门同时操作造成数据库中信息不对应)
function btnsave(){
	var id=document.getElementById("tMobilizepeople-id").value;
	var userdep=document.getElementById("usedep").value;
	if(userdep==null||userdep==""){
		alert("请填写使用部门办理情况！");
	}else{
			$.ajax({ 
	     	type:"POST", //表单提交类型 
	    	 url:'<%=basePath%>adminmessagecontroller/savepeoplechangesmsg.htm', 
	     	data:{id:id,userdep:userdep}, //表单数据
	  		success:function(e){
		 	var  data = eval("("+e+")");
	      	if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
	       		alert(data.msg);
	       		location.href="<%=basePath%>adminmessagecontroller/findacceptmessagepageofusedepartmentbycondition.htm?depcode=${depcode}&currentPage=${currentPage}&title=${title}&sendpeople=${sendpeople}&status=${status}&senddepname=${senddepname}";
	     	 }else{
				alert(data.msg);
	     	 }
	     }
    }); 
	}

}


</script>
<script type="text/javascript">
		
		$(function(){//使得combobox的editable的背景充满整个组合框
			$(".validatebox-text").css({"width":"100%","marginRight":"0px"});
		});
		
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo'});//绑定元素
		}();
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo2'});//绑定元素
		}();
</script>
<script type="text/javascript">
</script>
</body>
</html>
