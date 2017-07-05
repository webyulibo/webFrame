<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>	
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/themes/material/easyui.css" />
    <link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	<style type="text/css">
	.table tr td{
			width:120px;
			height:50px;
			font-size:12px;
		}
   .table td {
	height: 50px;
	vertical-align: top;
	padding-top: 20px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	padding-right:20px;
}
 
  .la {
    font-size: 15px;
    font-weight: bold;
}
.hr{
 		 border-bottom:1px solid #ddd; padding: 5px 3px 15px; min-height:30px
  		}
#save{
position:absolute;
top:400px;
left:790px;
}
	</style>
  </head>
  <body onload="load()">
  <div class="container-f">
		<div class="hr"></div>
		<br />
			<div class="returnbtn" style="margin-left:90px;margin-top:10px;">
				<a href="<%=basePath%>adminusermanagercontroller/getuserbyconditionwithpage.htm?currentPage=${precurrentPage}&condition=${condition}&text=${text}" class="btn btn-primary">返回</a>

			</div>
           <div class="form">
			<form id="subForm" method="post" action=" ">
					<table class="table">
						<tbody  style="position:relative;left:90px;top:40px;">
							<tr>
								<td>
								<label class="la">性别：</label>
								<!-- 隐藏用户的信息等待js调用 -->
								<input type="hidden" id="user-id" name="user-id" value="${tUser.id}">
								<input type="hidden" id="user-sex" name="user-sex" value="${tUser.usersex}">
								<input type="hidden" id="user-dep" name="user-dep" value="${tUser.userdep}">
								<input type="hidden" id="user-duty" name="user-duty" value="${tUser.userduty}">
								<input type="hidden" id="user-type" name="user-type" value="${tUser.usertype}">
								<input type="hidden" id="user-state" name="user-state" value="${tUser.userstate}">
								<input type="hidden" id="user-account" name="user-account" value="${tUser.useraccount}">
								<input type="hidden" id="user-code" name="user-code" value="${tUser.usercode}">
								<input type="hidden" id="user-code-legal" name="user-code-legal" value="true">
								<input type="hidden" id="user-account-legal" name="user-account-legal" value="true">
								</td>
								<td colspan="4">
					   	     		<input type="radio" checked="checked" name="Sex" value="男" style="margin-top:-4px;" />
					   			    <label class="la">男性</label>&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="Sex" value="女" style="margin-top:-4px;"/>
								     <label class="la">女性</label>
						
								</td>
							</tr>
							<tr>
								<td>
								<label class="la"> 用户名： </label> 
								</td>
								<td>
									<input type="text" name="name" id="name" class="input" value="${tUser.useraccount}">
						
								</td>
								<td><p-useraccount style="font-size:12px;font-weight:normal;line-height:30px;margin-left:-20px;"></p-useraccount></td>
					            <td><label class="la">所属部门:</label></td>
							<td>
							 <select class="easyui-combobox" name="state" id="dep" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<!-- <option value="局领导">局领导</option>
										<option value="办公室">办公室</option>
										<option value="纳税服务科">纳税服务科</option>
										<option value="监察室">监察室 </option>
										<option value="进出口税收管理科 ">进出口税收管理科 </option>
										<option value="信息中心"> 信息中心</option>
										<option value="财务管理科">财务管理科 </option>
										<option value="票证中心">票证中心 </option>
										<option value="货物和劳务税科">货物和劳务税科 </option>
										<option value="收入核算科">收入核算科 </option>
										<option value="所得税科">所得税科 </option>
										<option value="机关生活服务中心"> 机关生活服务中心</option>
										<option value="系统工会 "> 系统工会 </option>
										<option value="车购税管理分局办  "> 车购税管理分局办 </option>
										<option value="机关党委办公室">机关党委办公室 </option>
										<option value="政策法规科">政策法规科 </option>
										<option value="征收管理科">征收管理科 </option>
										<option value="稽查局 ">稽查局 </option>
										<option value="老干部科 ">老干部科 </option>
										<option value="人事教育科">人事教育科</option>
										<option value="大企业一科  ">大企业一科 </option>
										<option value="大企业二科 ">大企业二科 </option>
										<option value="北戴河新区 ">北戴河新区 </option>
										<option value="进出口分局 ">进出口分局 </option>
										<option value="涉外分局 ">涉外分局 </option>
										 -->
									</select>
                               </td>
							</tr>
							<tr>
							<td>
							<label class="la">密码：</label>
							</td>
							
							<td><input type="text" name="pwd" id="pwd" class="input"value="${tUser.userpassword}"></td>
								
							<td></td>
							<td><label class="la">职务：</label></td>
							<td>
							
									<span style="overflow:hidden;">
				    					 <select class="easyui-combobox" name="duty" id="duty"  style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
										</select> 
					                     </span>
									</td>
							</tr>
							<tr>
							<td>
								<label class="la">人员姓名：</label> 
								</td>
								<td>
									<input type="text" name="username" id="username" class="input"value="${tUser.username}">
								</td>
							
							<td></td>
							<td><label class="la">人员类别：</label></td>
							<td>
								<select class="easyui-combobox" name="state" id="type"  editable="false" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
									<option value="在职人员">在职人员</option>
										<option value="离休人员">离休人员</option>
										<option value="退休人员">退休人员</option>
										
									</select>
 
							</td>
								
							</tr>
							<tr>
							<td>
							<label class="la">人员代码：</label>
							</td>
							<td><input type="text" name="num" id="num" class="input" value="${tUser.usercode}"></td>
							<td><p-usercode style="font-size:12px;font-weight:normal;line-height:30px;margin-left:-20px;"></p-usercode></td>
							<td><label class="la">状态：</label></td>
								<td>
									<select  class="easyui-combobox"name="state" id="state" editable="false" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="启用">启用</option>
										<option value="关闭"> 关闭</option>
									</select>
							</td>
							</tr>
			     </tbody>
		    </table>
	   			<div class="form-actions" id="baocun">

						<a href="javascript:void(0)" onclick="onsave()" class="btn btn-primary" id="save" style="margin-top:50px;">保存</a>

					</div>	
	    </form>
	   
     </div>
       <script>
  function load(){//加载完即对性别进行赋值
  
  	var usersex=document.getElementById("user-sex").value;
  	var userdep=document.getElementById("user-dep").value;
  	var userduty=document.getElementById("user-duty").value;
  	var usertype=document.getElementById("user-type").value;
  	var userstate=document.getElementById("user-state").value;
  	//alert(sex);
  	if(usersex=="男"){
  		$("input:radio[name='Sex']")[0].checked = true;
  	}else{
  		$("input:radio[name='Sex']")[1].checked = true;
  	}
  	//alert($("input:radio[name='Sex']:checked").val());
  	$('#dep').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminusermanagercontroller/getdepjson.htm',
      		    valueField:'depcodevalue', //设置combobox的value
      		    textField:'depnametext',//设置combobox显示的text
      		    editable:false//在此处是不能够添加部门的
      		    });
    $('#duty').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminusermanagercontroller/getdutyjson.htm',
      		    valueField:'value', //设置combobox的value
      		    textField:'text',//设置combobox显示的text
      		    editable:true
      		    });
     $('#dep').combobox('select',userdep);
     $('#duty').combobox('select',userduty);
     $('#type').combobox('select',usertype);
     $('#state').combobox('select',userstate);
	 var t=$("#name").val();
   	 $("#name").val("").focus().val(t);//使用重新赋值重新聚焦的方法
  }
  </script>
<!--用户名合法性验证 -->
  <script>
           $(function(){
            $("#name").bind("input propertychange",function(){
                var useraccount=document.getElementById("name").value;
                var preuseraccount=document.getElementById("user-account").value;
				  if(useraccount==""||useraccount==null){
                    $("p-useraccount").html("用户名不能为空！");
                }else{
                 if(useraccount.indexOf(" ")>=0){
                	$("p-useraccount").html("输入有空格！");
                }else{
                   $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 url:'<%=basePath%>adminusermanagercontroller/isuseraccountlegal.htm', 
    					 data:{useraccount:useraccount,preuseraccount:preuseraccount}, //表单数据
 					 	success:function(e){
	 							 var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 						document.getElementById("user-account-legal").value="true";
      		 						$("p-useraccount").html("");
      						}else{
      						document.getElementById("user-account-legal").value="false";
								$("p-useraccount").html(data.msg);
    							 }
   								            }
   							 }); 
                }
             
               		
                }
            });
        });
  </script>
  <!--人员代码合法性验证 -->
  <script>
           $(function(){
            $("#num").bind("input propertychange",function(){
                var usercode=document.getElementById("num").value;
                var preusercode=document.getElementById("user-code").value;
				  if(usercode==""||usercode==null){
                    $("p-usercode").html("人员代码不能为空！");
                }else{
                if(usercode.indexOf(" ")>=0){//如果人员代码包含空格
                		usercode = usercode.replace(/\s/g, "");
                	}
                	if((/^\d{5}$/).test(usercode)==false){
                		$("p-usercode").html("人员代码须为五位数字！");
                	}else{
				                 if(usercode.indexOf(" ")>=0){
				                	$("p-usercode").html("输入有空格！");
				                }else{
				                   $.ajax({ 
				    					 type:"POST", //表单提交类型 
				    					 url:'<%=basePath%>adminusermanagercontroller/isusercodelegal.htm', 
				    					 data:{usercode:usercode,preusercode:preusercode}, //表单数据
				 					 	success:function(e){
					 							 var  data = eval("("+e+")");
				      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
				      							document.getElementById("user-code-legal").value="true";
				      		 						$("p-usercode").html("");
				      						}else{
				      						document.getElementById("user-code-legal").value="false";
												$("p-usercode").html(data.msg);
				    							 }
				   								            }
				   							 }); 
				                }
            			 }
               		
                }
            });
        });
  </script>
<!--执行修改的操作 -->
  <script>
  function onsave(){
  	var userid=document.getElementById("user-id").value;
	var useraccount=document.getElementById("name").value;
	var userpassword=document.getElementById("pwd").value;
	var username=document.getElementById("username").value;
	var usercode=document.getElementById("num").value;
	
	var usersex=$("input:radio[name='Sex']:checked").val();
  	var userdep=$('#dep').combobox('getValue');
  	var userduty=$('#duty').combobox('getValue');
  	var usertype=$('#type').combobox('getValue');
  	var userstate=$('#state').combobox('getValue');
  	
  	/* alert(userid);alert(useraccount);alert(userpassword);alert(username);alert(usercode);
  	alert(usersex);alert(userdep);alert(userduty);alert(usertype);alert(userstate); */
	if(useraccount==""){
		alert("用户名不能为空，请重新输入！");
	}else{
		if(userpassword==""){
			alert("密码不能为空，请重新输入！");
		}else{
			if(username==""){
				alert("人员姓名不能为空，请重新输入！");
			}else{
				if(usercode==""){
					alert("人员代码不能为空，请重新输入！");
				}else{
					if(useraccount.indexOf(" ")>=0){//如果用户名包含空格
                		useraccount = useraccount.replace(/\s/g, "");
                	}
                	if(userpassword.indexOf(" ")>=0){//如密码包含空格
                		userpassword = userpassword.replace(/\s/g, "");
                	}
                	if(username.indexOf(" ")>=0){//如果人员姓名包含空格
                		username = username.replace(/\s/g, "");
                	}
                	if(usercode.indexOf(" ")>=0){//如果人员代码包含空格
                		usercode = usercode.replace(/\s/g, "");
                	}
                	if((/^\d{5}$/).test(usercode)==false){
                		alert("人员代码必须为五位数字！");
                	}else{
                	if(document.getElementById("user-account-legal").value=="false"){
                		alert("该用户名已存在，请重新输入！");
                	}else{
                			if(document.getElementById("user-code-legal").value=="false"){
                				alert("该人员代码已存在，请重新输入！");
                			}else{
                				$.ajax({ 
     							type:"POST", //表单提交类型 
     							url:'<%=basePath%>adminusermanagercontroller/updateuser.htm', 
    							 data:{userid:userid, useraccount:useraccount, userpassword:userpassword, username:username, usercode:usercode, usersex:usersex, userdep:userdep, userduty:userduty, usertype:usertype, userstate:userstate}, //表单数据
  								success:function(e){
	 									 var  data = eval("("+e+")");
      									if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       											alert(data.msg);
       										location.href="<%=basePath%>adminusermanagercontroller/getuserbyconditionwithpage.htm?currentPage=${precurrentPage}&condition=${condition}&text=${text}";
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
			 
			  
  }	
}
  </script>
<!-- 设置权限 -->
  <shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		//设置保存按钮权限
		 $(".btn-primary").click(function(){alert("权限不足，无法进行此操作");});
		</script>	
</shiro:hasPermission>
   </body>
</html>