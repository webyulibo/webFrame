<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  	}
  	.messagenumberon{
  		background-color:orange;
  		opciaty:1;
  	}
  	</style>
<body>
 <div id="frmheader" class="clearfix">
	<div class="container">
		<div class="f_1">
		<!-- 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
			
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
        	<a href="javascript:void(0)" style="margin-right:30px;text-decoration:none;">消息&nbsp;<span class="messagenumber" style="padding:2px 5px;border-radius:50%;background-color:white;color:black;opciaty:0.5;">20</span></a>
        	欢迎您：  admin&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="javascript:void(0)">退出</a>
        </div>
	</div>
</div>
<script type="text/javascript">
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
