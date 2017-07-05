<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lrptest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/tablezp.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
     <script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
      <script type="text/javascript" src="<%=basePath %>Public/Js/laydate.js"></script>
      
      <script src="Public/Js/jquery-2.1.4.js" type="<%=basePath %>text/javascript"></script>
      <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
      <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>

  </head>
  
  <body>
    This is my JSP page. <br>
    
    <form action="<%=basePath%>testlrpcontroller/testselect.htm" >
    
    	<table>
    		<tr>
    			<td>
    				<table>
		    			<select class="easyui-combobox" name="isbegin" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value="电脑">电脑 </option>
							<option value="csdn">csdn </option>
							<option value="123">123</option>
						</select>
		    		</table>
    			</td>
    		</tr>    		
    	</table>

    	<input type="submit"  value="提交" />
    
    </form>
    
  </body>
</html>
