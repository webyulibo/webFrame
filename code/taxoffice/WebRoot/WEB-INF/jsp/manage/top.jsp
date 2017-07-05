<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<%@	taglib uri="/pageuri" prefix="cc" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<base href="<%=basePath%>">
  <head>
    <title>Top</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/style.css" />
  	<link rel="stylesheet" href="<%=basePath %>Public/Css/font-awesome/css/font-awesome.css">
  	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.js"></script>
  	</head>
  	<style>
  	body{
  		margin:0px;
  		overflow-y:hidden;
  	}
  	.messagenumberon{
  		background-color:red;
  		opciaty:1;
  	}
  	.messagenumber{
  		background-color:white;
  		opciaty:1;
  	}
  	</style>
<body>
 <div id="frmheader" class="clearfix">
	<div class="container">
		<div class="f_1">
			<a href="javascript:void(0);" target="_self" class="toggle-nav" id="toggle-nav" title="Toggle navigation" onclick="hide_left_menu(this);">
				<i class="fa fa-bars"></i>
			</a>
		</div>
		<ul class="main-nav f_l">
            <li class="def active">
                <a href="javascript:void(0)" target="_top">
                	管理平台
                </a>
            </li>
        </ul>
        <div class="login_info">
        
				<c:if test="${userdepnameString=='机关生活服务中心' }"> 
				    <a href="<%=basePath%>adminmessagecontroller/getacceptmessagepageofagencyservicecenter.htm?depcode=${depcode}" style="margin-right:30px;text-decoration:none;"  target="mainFrame">消息&nbsp;<span id="information" class="messagenumberon" style="padding:0px 2px;border-radius:50%;color:black;"></span></a>
        				欢迎您： <shiro:principal/>&nbsp;&nbsp;|&nbsp;&nbsp;
					<a href="javascript:void(0)" onclick="logout()">退出</a>
				 </c:if>	 
			   	 <c:if test="${userdepnameString=='人事教育科' }"> 
				    <a href="<%=basePath%>adminmessagecontroller/getacceptmessagepageofpersonneldepartment.htm?depcode=${depcode}" style="margin-right:30px;text-decoration:none;"  target="mainFrame">消息&nbsp;<span id="information" class="messagenumberon" style="padding:0px 2px;border-radius:50%;color:black;"></span></a>
        				欢迎您： <shiro:principal/>&nbsp;&nbsp;|&nbsp;&nbsp;
					<a href="javascript:void(0)" onclick="logout()">退出</a>
				 </c:if> 
		      	<c:if test="${userdepnameString=='财务管理科' }"> 
				    <a href="<%=basePath%>adminmessagecontroller/getacceptmessagepageoffinancialmanagement.htm?depcode=${depcode}" style="margin-right:30px;text-decoration:none;"  target="mainFrame">消息&nbsp;<span id="information" class="messagenumberon" style="padding:0px 2px;border-radius:50%;color:black;"></span></a>
        				欢迎您： <shiro:principal/>&nbsp;&nbsp;|&nbsp;&nbsp;
					<a href="javascript:void(0)" onclick="logout()">退出</a>
				 </c:if>		
		          <c:if test="${userdepnameString!='机关生活服务中心'&&userdepnameString!='人事教育科'&&userdepnameString!='财务管理科'}">
				    <a href="<%=basePath%>adminmessagecontroller/getacceptmessagepageofusedepartment.htm?depcode=${depcode }" style="margin-right:30px;text-decoration:none;"  target="mainFrame">消息&nbsp;<span id="information" class="messagenumberon" style="padding:0px 2px;border-radius:50%;color:black;"></span></a>
        				欢迎您： <shiro:principal/>&nbsp;&nbsp;|&nbsp;&nbsp;
					<a href="javascript:void(0)" onclick="logout()">退出</a>
				 </c:if> 
				 
        </div>
        <input type="hidden" id="useraccount" value="${useraccount }"/>
	</div>
</div>
<script type="text/javascript">


	/* function show(){
				$("#information").toggleClass("messagenumber");
			}
	 */
	$(function(){
		setInterval(getMsgCount,1000); 

	});
	function getMsgCount(){
			var useraccount=document.getElementById("useraccount").value;
		  		$.ajax({ 
					     	type:"POST", //表单提交类型 
					     	dataType: "html",
					    	 url:'<%=basePath%>adminmessagecontroller/msgtodealwithcount.htm', 
					     	data:{useraccount:useraccount}, //表单数据
					  		success:function(e){
						 	 var  data = eval("("+e+")");
					      	if(data.msgTotalCount > 0){//msg 是后台调用action时，你穿过来的参数
					       		document.getElementById("information").innerHTML=data.msgTotalCount;
					       		$("#information").toggleClass("messagenumber");
					     	 }else{
					     	 document.getElementById("information").innerHTML=data.msgTotalCount;
								$("#information").addClass("messagenumber");
								
					     	 }
					     }
				    }); 
	}
 	

	function logout() {
		<%-- window.location.href="<%=basePath %>logout.htm"; --%>
		parent.location="<%=basePath %>logout.htm";
	}

	function hide_left_menu(obj){
		if($(window.parent.document).find("#bodyFrameset").attr("cols")=="200,*"){
			$(window.parent.document).find("#bodyFrameset").attr("cols","0,*");
		} 
		else{
			$(window.parent.document).find("#bodyFrameset").attr("cols","200,*");
		}
		return false;
	}
	$(function(){
		$("#frmheader .main-nav a").click(function(){
			$("#frmheader .main-nav li").removeClass("active");
			$(this).parent().addClass("active");
		});
	});
</script> 
</body>
</html>
