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

<title>发送消息</title>

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
<style>
.tab td {
	height: 50px;
	vertical-align: middle;
	padding-top: 20px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	padding-right:20px;
}
</style>

</head>
<body onload="load()">
	<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="javascript:void(0)">
				<span class="fa fa-table"></span>
				发送通知
				</a>
			</h3>
			<h3>
				<a href="<%=basePath%>adminmessagecontroller/getacceptmessagepageofagencyservicecenter.htm?depcode=${depcode}">
				<span class="fa fa-bar-chart-o"></span>
				查看通知列表
				</a>
			</h3>
		</div> 
	<div class="control-group f_l" style="min-width:1100px">
	<form action="" name="borrow">
	<div style="margin-top:30px;margin-left:100px;">
		<div>
			<table class="tab">
				<tr>
					<td>消息标题：</td>
					<td><input type="text" class="in" name="title" id="title"></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td style="padding-left:15px;">发送人：</td>
					<td width="250px">
						<select class="easyui-combobox" name="sendpeople" id="sendpeople" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
						<tr>
					<td width="100px">所属部门：</td>
					<td width="250px">
						<select class="easyui-combobox" name="senddep" id="senddep" editable="false" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
						<option value="${depcode }">${depname }</option>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td width="100px">接收部门：</td>
					<td width="250px">
						<select class="easyui-combobox" name="acceptdep" id="acceptdep" editable="false" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td align="left" valign="top">消息概要：</td>
					<td colspan="3">
						<textarea rows="4" style="width:550px" value="" id="msg" name="msg"></textarea>
					</td>
				</tr>
			</table>
			
		</div>
		<div style="margin-left:625px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary" id="edit"
				value="发送" onclick="sendmsg()">
			</span> 
		</div>
	</div>
	</form>
	<input type="hidden" id="depcode" name="depcode" value="${depcode }"/>
	</div>
</div>
 <script>
  function load(){
  	 var depcode = $('#senddep').combobox('getValue'); 
     $('#sendpeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>admindepartmentcontroller/getusernamebydepcode.htm?depcode='+depcode,
      		    valueField:'username', //设置combobox的value
      		    textField:'username',//设置combobox显示的text
      		    editable:true
      		    });
  	$('#acceptdep').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminusermanagercontroller/getdepjson.htm',
      		    valueField:'depcodevalue', //设置combobox的value
      		    textField:'depnametext',//设置combobox显示的text
      		    editable:false//在此处是不能够添加部门的
      		    });
  }
  </script>
    <script>
  function sendmsg(){

    var title = document.getElementById("title").value;
  	var sendpeople = $('#sendpeople').combobox('getValue'); 
  	var senddepcode = document.getElementById("depcode").value;
  	var acceptdepcode = $('#acceptdep').combobox('getValue');
  	var msg=document.getElementById("msg").value;
  	if(title==""||title==null){
  		alert("请填写消息标题！");
  	}else{
  		 	if(sendpeople==""||sendpeople==null){
  				alert("请选择发送人！");
  			}else{
  				if(acceptdepcode==""||acceptdepcode==null){
  					alert("请选择接收部门！");
  				}else{
  					if(msg==""||msg==null){
  						alert("请填写消息概要！");
  					}else{
  					var co=confirm('确定发送？');
  					if(co==true){
  					  
  						 		$.ajax({ 
     									type:"POST", //表单提交类型 
     									url:'<%=basePath%>adminmessagecontroller/sendmessage.htm', 
    									data:{title:title, sendpeople:sendpeople, senddepcode:senddepcode, acceptdepcode:acceptdepcode, msg:msg,status:0}, //表单数据
  										success:function(e){
	 												var  data = eval("("+e+")");
      												if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       												alert(data.msg);
       												location.href="<%=basePath%>adminmessagecontroller/getsendmessagepageofusedepartment.htm?depcode="+senddepcode;
       									 			}else{
														alert(data.msg);//添加失败重新对表单进行赋值
     										 		}
	
     											}
 									}); 
 								}
  					}
  				}
  			}
  	}
 
  }
  </script>
<script type="text/javascript">
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo'});//绑定元素
		}();
</script>
</body>
</html>
