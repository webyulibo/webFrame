<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>  
<%
request.setCharacterEncoding("UTF-8");
String num=(String)application.getAttribute("num");
if(num==null){
	application.setAttribute("num", String.valueOf(0));
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">  
      
    <title>税务局登陆系统 </title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <link rel="stylesheet" type="text/css" href="Public/Css/index.css" media="all">
	<link rel="stylesheet" type="text/css" href="Public/Css/style.css" />
	<link rel="stylesheet" type="text/css" href="Public/Css/total.css" />
	<script type="text/javascript" src="Public/Js/jquery.js"></script>
	
	<script type="text/javascript">	
		function change() {
			var checkImg=document.getElementById("checkImg");
			checkImg.src="<%=basePath%>checkImg.htm?"+new Date().getTime();checkImg.src="<%=basePath%>checkImg.htm?"+new Date().getTime();
		}	
	</script>
	
	<script type="text/javascript">
	
	function validate(){
		
		var username=document.getElementById("username").value;
		var password=document.getElementById("LoginPwd").value;
		//alert(username.length);
		if(username.length<=0||username==""||username==null){
			alert("用户名不能为空！！");
			
			return false;
		}
		
		else if(password==""||password==null){
			alert("密码不能为空");
			return false;
		}
		else{
			document.getElementById("subForm").submit();
		}
				
	}
	
	$(document).keydown(function(event){
		if(event.keyCode==13){
		
			document.getElementById("loginBtn").click();
		}
		
	})
	/* function keyLogin(event) {
		
		
	} */
	
	</script>
	<style>
        h2 {
            display: inline;
            font: 700 35px/96px "Microsoft YaHei";
            color: #392722;
            white-space: nowrap;
        }
        div.login_header>img{
            vertical-align: middle;
            margin-right: 20px;
        }
    </style>
	
	
</head>
<body>
 <body>
    <div class="login_main">
        <div class="login_header"><img src="Public/Images/logo.png" width="80px" height="74px">
            <h2>
            <font id="titleFont">秦皇岛市国家税务局</font>
            <span style="font-weight:normal;"> | 资产管理系统</span>
            </h2>
        </div>
        <div>
            <div class="login_left"><img src="Public/Images/left.png" width="520px" height="300px"></div>
            <div class="login_right">
               
                    <form id="subForm" action="<%=basePath %>loginCheck.htm" method="post">
                        <table>
                            <tr>
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td style="width:20%;text-align:center;">用户名:</td>
                                <td style="width:80%;"><input type="text" id="username" value="${username }" name="username" id="LoginCode" class="login-text wid_ipt" placeholder="用户名" /></td>
                            </tr>
                            <tr>
                                <td style="width:20%;text-align:center;">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                                <td style="width:80%;"><input type="password"  name="password"  id="LoginPwd" value="${password }" class="login-text wid_ipt" placeholder="密码" /></td>
                                
                            </tr>
                            <tr>
                            	<td colspan="2" style="text-align:center;color:red;">${errormsg }</td>
                            </tr>
                                                    
                            <tr>
                                <td colspan="2" style="text-align:center">
                                   <input id="loginBtn" type="button" value="登录" onclick="validate()">
                                </td>

                            </tr>
                        </table>
                    </form>
                
            </div>
        </div>
    </div>
    <div id="login_foot"></div>
	<div class="a" style="text-align:center;font:12px/150% Arial,Verdana,'宋体';padding-top:20px;height:80px;">
		<P>@技术支持 秦皇岛鸿大科技开发有限公司</P> 
 		<P>售后服务电话：  &nbsp13230381187  &nbsp&nbsp&nbsp&nbsp18713595076</P>
	</div>



</body>
</html>