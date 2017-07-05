<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	 
	<base href="<%=basePath%>">
	<%-- 
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/bootstrap.css"/> --%>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css"/>
    <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	 
	<link rel="stylesheet" href="<%=basePath%>kindeditor-4.1.7/themes/default/default.css" />
	<link rel="stylesheet" href="<%=basePath%>kindeditor-4.1.7/plugins/code/prettify.css" />
	<script charset="utf-8" src="<%=basePath%>kindeditor-4.1.7/kindeditor.js"></script>
	<script charset="utf-8" src="<%=basePath%>kindeditor-4.1.7/lang/zh_CN.js"></script>
	<script charset="utf-8" src="<%=basePath%>kindeditor-4.1.7/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '<%=basePath%>kindeditor-4.1.7/plugins/code/prettify.css',
				uploadJson : '<%=basePath%>kindeditor-4.1.7/jsp/upload_json.jsp',
				fileManagerJson : '<%=basePath%>kindeditor-4.1.7/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body>
	<%=htmlData%>
	<div class="container-f">
    <div class="box-title clearfix tab-title">
        <a href="#">
            <div class="f_l f_10">
                <h3>
                    <i class="fa fa-cog"></i>
                    业务介绍列表
                </h3>
				<h3>
                    <i class="fa fa-cog"></i>
                    修改业务介绍
                </h3>
            </div>
        </a>
    </div>
<div class="container">
<div class="form_div">
<form name="example" method="post" action="demo.jsp">
		<textarea name="content1" cols="100" rows="8" style="width:1000px;height:600px;visibility:hidden;"></textarea>
		<br />
		<div class="row">
		<div class="col-md-8">
		</div>
		<div class="col-md-4">
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
		</div>
		</div>
	</form>
</div>
</div>
    
</div>
	
	
	<!--  
	<form name="example" method="post" action="demo.jsp">
		<textarea name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
	</form>
	-->
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>