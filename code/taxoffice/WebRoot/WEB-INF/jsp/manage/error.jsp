<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>error</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	<style>
	html,body{height:100%;overflow-y:hidden;}
		#outer{
			width:620px;
			height:310px;
			margin:0 auto;
			border:10px solid #ddd;
		}
		#outer>h1{
			position:relative;
			float:left;
			left:65px;
			top:110px;
			font-size:30px;
		}
		#image{
			position:relative;
			float:left;
			width:90px;height:90px;
			left:30px;
			top:105px;
		}
	</style>
  </head>
  
  <body>
    <div id="outer">
    	<img id="image" src="<%=basePath%>Public/Images/info.jpg"/>
    	<h1>抱歉，您没有权限访问该模块！</h1>
    </div>
    <script>
        window.onload=showmiddle;
        window.onresize=showmiddle;
        function showmiddle(){
            var theTop=document.getElementById("outer").style;
            theTop.marginTop=($(window).height()-$("#outer").height())/2+"px";
        }
    </script>
  </body>
</html>
