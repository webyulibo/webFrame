<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>税务局管理系统</title>
  </head>
  <frameset rows="40,*" frameborder="no" border="0" framespacing="0">
	<frame src="jsp/manage/top.jsp" name="topFrame" id="topFrame" noresize="noresize" />
	<frameset id="bodyFrameset" cols="200,*"frameborder="no" border="0" framespacing="0"  scrolling="auto">
		<frame src="jsp/manage/left.jsp" name="leftFrame" scrolling="auto" noresize="noresize" id="leftFrame" />
		<frame src="jsp/dataadmin/assetadmin/admin/indexlmy.jsp" name="mainFrame" id="mainFrame" frameborder="0" scrolling="auto" marginwidth="0" marginheight="0" />
	</frameset>
 </frameset> 
<noframes>
<body style="padding:0">
</body>
</noframes>
</html>
