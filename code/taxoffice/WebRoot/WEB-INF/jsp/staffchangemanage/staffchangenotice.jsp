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
<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
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
			<h3 class="current">
				<a href="<%=basePath%>adminmobilizepeoplecontroller/index.htm">
				<span class="fa fa-table"></span>
				人员变动通知
				</a>
			</h3>
			<h3 >
				<a href="<%=basePath%>adminmobilizepeoplecontroller/showlist.htm">
				<span class="fa fa-cog"></span>
				人员变动列表
				</a>
			</h3>
		</div>
	<div style="width:900px; margin-left:100px;margin-top:50px">  <!-- 表格 -->
	<form action="" name="return">
		<fieldset class="search" style="margin-top:20px;">
  			<legend><span style="font-size:14px;">人员变动通知</span></legend>
				<table class="table-hover dataTable" width="900px" >
			<tr>
				<td width="180px"><center>姓名：</center></td>
				<td><input  name="username"  id="username" style="width:100%;height:35px"></td>
				<td width="130px"><center>岗位变动：</center></td>
				<td><input  name="depchange" id="depchange" style="width:100%;height:35px"></td>
			</tr>
			<tr>
				<td width="130px"><center>原部门：</center></td>
				<td><input  name="originaldep" id="originaldep" style="width:100%;height:35px"></td>
				<td><center>新部门:</center></td>
				<td><input name="newdep" id="newdep" style="width:100%;height:35px"></td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>财务部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea  id="financialdep" style="width:100%;height:100%"></textarea></td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>使用部门办理情况：</center></td>
				<td colspan="3" height="140px"><textarea id="usedep"   style="width:100%;height:100%"></textarea></td>
			</tr>
			<tr>
				<td width="130px" height="140px"><center>机关服务中心办理情况：</center></td>
				<td colspan="3" height="140px"><textarea id="servicedep" style="width:100%;height:100%"></textarea></td>
			</tr>
		</table>
	</fieldset>		
		<div style="margin-left:700px;margin-top:30px;"> 
			<span> <input type="button" class="btn btn-primary" id="save"
				value="保存" onclick="javascript:void(0)">
			</span> <span style="padding-left:5px;"> <input type="button"
				class="btn btn-primary" id="clear" value="清空" onclick="javascript:void(0)">
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
	//清空对应的js代码
$("#clear").click(function clear(){
	document.getElementById("username").value="";
	document.getElementById("originaldep").value="";
	document.getElementById("newdep").value="";
	document.getElementById("depchange").value="";
	document.getElementById("financialdep").value="";
	document.getElementById("usedep").value="";
	document.getElementById("servicedep").value="";
});
	</script>
<script type="text/javascript">
	$("#save").click(function save(){
		var username=document.getElementById("username").value;
		var originaldep=document.getElementById("originaldep").value;
		var newdep=document.getElementById("newdep").value;
		var depchange=document.getElementById("depchange").value;
		var financialdep=document.getElementById("financialdep").value;
		var usedep=document.getElementById("usedep").value;
		var servicedep=document.getElementById("servicedep").value;
		var status=0;
		if(username=="")
	   		alert("姓名不能为空");
	   	else if(originaldep=="")
	   		alert("原部门不能为空");
	   	else if(originaldep.indexOf(" ")>=0)
	   	    alert("原部门不能含空格");
	    else if(newdep.indexOf(" ")>=0)
	   	    alert("原部门不能含空格");
	   	else if(username.indexOf(" ")>0)
	        alert("姓名不能含空格");
	    else if(depchange.indexOf(" ")>0)
	        alert("变动形式不能含空格");
	   	else if(depchange=="")
	   		alert("变动情况不能为空");
	    else if(depchange=="退休")
	      {    
	     if(servicedep!=""&&usedep!=""&&financialdep!="")
	   	    status=1; 
	        	$('#savelead').attr("disabled","disabled");
             	$.ajax
      		 	({
	               type:"post",
	               url:'<%=basePath %>adminmobilizepeoplecontroller/isnameandolddepiegal.htm',
		           data : {username:username,originaldep:originaldep},
		           success : function(e) 
		          	{
				    var data = eval("(" + e + ")");
					  if(data.status=='ok')
					     {
					      $.ajax({
					     type:"post",
					      url:'<%=basePath%>adminmobilizepeoplecontroller/saveMobilizepeople.htm',
                          data:{username:username,originaldep:originaldep,newdep:newdep,depchange:depchange,financialdep:financialdep,usedep:usedep,servicedep:servicedep,status:status},
					      success : function(e) 
					      {
					         var data = eval("(" + e + ")");
					         if(data.status=="ok")
					         alert("保存成功");
					         else
					         alert("保存失败");
					         location.href="<%=basePath%>adminmobilizepeoplecontroller/index.htm";
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
	   	else 
	   	{  
	   	 if(servicedep!=""&&usedep!=""&&financialdep!="")
	   	    status=1; 
	   	$('#savelead').attr("disabled","disabled");
	   	  $.ajax({ 
    		type:"post", //表单提交类型 
    	    url:'<%=basePath%>adminmobilizepeoplecontroller/isdeplegal.htm', 
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
		            data : {username:username,originaldep:originaldep},
		          	success : function(e) 
		         	{
		         	   
				    	var data = eval("(" + e + ")");
					    if(data.status=='ok')
					     {
					     $.ajax({
					     type:"post",
					     url:'<%=basePath%>adminmobilizepeoplecontroller/saveMobilizepeople.htm',
                         data:{username:username,originaldep:originaldep,newdep:newdep,depchange:depchange,financialdep:financialdep,usedep:usedep,servicedep:servicedep,status:status},
					     success : function(e) 
					     {
					     
					       var data = eval("(" + e + ")");
					        if(data.status=="ok")
					         {
					         <%-- 
					                        更新user的工作部门
					          $.ajax({
		      	                type:"post",
		                        url:'<%=basePath %>adminmobilizepeoplecontroller/updatedep.htm',
					            data : {username:username,originaldep:originaldep,newdep:newdep},
			                    });      --%>
					          alert("保存成功");
					         }
					         else
					         alert("保存失败");
					          location.href="<%=basePath%>adminmobilizepeoplecontroller/index.htm";
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
