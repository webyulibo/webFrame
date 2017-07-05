<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
				<a href="<%=basePath%>jsp/informationnotice/usedepartment/index.jsp">
				<span class="fa fa-table"></span>
				发送通知
				</a>
			</h3>
			<h3>
				<a href="<%=basePath%>jsp/informationnotice/usedepartment/list.jsp">
				<span class="fa fa-bar-chart-o"></span>
				查看通知列表
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>jsp/informationnotice/usedepartment/staffchangenotice.jsp">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3>
		</div>
	<div style="width:900px; margin-left:100px;margin-top:50px">  <!-- 表格 -->
	<form action="" name="return">
		<fieldset class="search" style="margin-top:20px;">
  			<legend><span style="font-size:14px;">人员变动通知</span></legend>
				<table class="table-hover dataTable" width="900px" >
			<tr>
				<td style="width:22%;"><center>姓名：</center></td>
				<td style="width:28%;">
					<select class="easyui-combobox" name="id" style="width:100%;height:100%;border:solid 1px gray;padding-left:7px;">
						<option value=""></option>
						<option value=""></option>
						<option value=""></option>
					</select>
					<script>$(".textbox").width("100%");</script>
				</td>
				<td style="width:20%;"><center>岗位变动：</center></td>
				<td style="width:30%;">
					<select class="easyui-combobox" name="id" style="width:100%;height:100%;border:solid 1px gray;padding-left:7px;">
						<option value=""></option>
						<option value=""></option>
						<option value=""></option>
					</select>
					<script>$(".textbox").width("100%");</script>
				</td>
			</tr>
			<tr>
				<td width="130px"><center>原部门：</center></td>
				<td>
					<select class="easyui-combobox" name="id" style="width:100%;height:100%;border:solid 1px gray;padding-left:7px;">
						<option value=""></option>
						<option value=""></option>
						<option value=""></option>
					</select>
					<script>$(".textbox").width("100%");</script>
				</td>
				<td><center>新部门:</center></td>
				<td>
					<select class="easyui-combobox" name="id" style="width:100%;height:100%;border:solid 1px gray;padding-left:7px;">
						<option value=""></option>
						<option value=""></option>
						<option value=""></option>
					</select>
					<script>$(".textbox").width("100%");</script>
				</td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>财务部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea  id="asset" style="width:100%;height:100%"></textarea></td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>使用部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea style="width:100%;height:100%"></textarea></td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>机关服务中心办理情况：</center></td>
				<td colspan="3" height="140px"><textarea style="width:100%;height:100%"></textarea></td>
			</tr>
		</table>
	</fieldset>		
		<div style="margin-left:700px;margin-top:30px;"> <!-- 保存&清空  -->
			<span> <input type="button" class="btn btn-primary" id="save"
				value="保存" onclick="javascript:void(0)">
			</span> <span style="padding-left:5px;"> <input type="button"
				class="btn btn-primary" id="edit" value="清空" onclick="javascript:void(0)">
			</span>
		</div>
	</form>
	</div>
</div>
<script type="text/javascript">
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
	$("#save").click(function save(){
		var name=document.getElementById("name").value;
		var olddep=document.getElementById("olddep").value;
		var newdep=document.getElementById("newdep").value;
		var depchange=document.getElementById("depchange").value;
		var asset=document.getElementById("asset").innerHTML;
		if(name=="")
	   		alert("姓名不能为空");
	   	else if(olddep=="")
	   		alert("原部门不能为空");
	   	else if(olddep.indexOf(" ")>=0)
	   	    alert("原部门不能含空格");
	   	else if(name.indexOf(" ")>0)
	        alert("姓名不能含空格");
	    else if(depchange.indexOf(" ")>0)
	        alert("变动形式不能含空格");
	   	else if(depchange=="")
	   		alert("变动情况不能为空");
	    else
	      if(depchange=="退休")
	      {
	        	$('#savelead').attr("disabled","disabled");
             	$.ajax
      		 						({
		      	                        type:"post",
		                              	url:'<%=basePath %>adminmobilizepeoplecontroller/isnameandolddepiegal.htm',
		                              	data : {name:name,olddep:olddep},
		                               	success : function(e) 
		                               	{
				                         	var data = eval("(" + e + ")");
					                        if(data.status=='ok')
					                         {
					                            $.ajax({
					                            type:"POST",
					                            url:'<%=basePath%>adminmobilizepeoplecontroller/saveleadasset.htm',
                                                data:{},
					                            });
					                         }
					                        else
					                         {
					                            alert(data.msg);
					                         }
					                     }
		                             });        	//阿贾克斯无需验证新部门
	      }
	      //阿贾克斯必须验证新部门
	   	else 
	   	{  
	   	$('#savelead').attr("disabled","disabled");
	   	  $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 url:'<%=basePath%>adminmobilizepeoplecontroller/isnewdepiegal.htm', 
    					 data:{newdep:newdep}, //表单数据
 					 	success:function(e)
 					 	{
	 							var  data = eval("("+e+")");
      							if(data.status == 'ok')
      							{//msg 是后台调用action时，你穿过来的参数
      		 						$.ajax
      		 						({
		      	                        type:"post",
		                              	url:'<%=basePath %>adminmobilizepeoplecontroller/isnameandolddepiegal.htm',
		                              	data : {name:name,olddep:olddep},
		                               	success : function(e) 
		                               	{
				                         	var data = eval("(" + e + ")");
					                        if(data.status=='ok')
					                         {
					                            $.ajax({
					                            type:"POST",
					                            url:'<%=basePath%>adminmobilizepeoplecontroller/saveleadasset.htm',
                                                data:{},
					                            });
					                         }
					                        else
					                         {
					                            alert(data.msg);
					                         }
					                     }
		                             });
      					    	}
      					    	else
      					    	{
								  alert(data.msg);
    						    }
   					   }
   			   });   
	      
		}
		
	});
</script>
</body>
</html>
