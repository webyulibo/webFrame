<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>添加子类型</title>
   
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/lbgllmt.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
  </head>
  
  <body>
    <div class="container-f">
  <div class="hr"></div>
  <div class="box-title clearfix tab-title"  class="input-xlarge">
  
  <div class="returnbtn">

             <label class="name">
			 父级菜单名称
			 </label>
			 <br />
			 <br />
				<a href="jsp/dataadmin/leibieadmin/look/lookqjx.jsp" class="btn btn-primary" >返回</a>
				
  </div>
   <form action=" " method="post" class="form" >
		<div class="control-group cf clearfix " >
					<label class="control-label" for="web_bg">
					    类型名称：
					</label>
					
						<input type="text" name="typename" id=" "   class="input" style="padding: 5px 2px;" "value="">
					
					
		</div>
		<div class="control-group cf clearfix " >
					<label class="control-label" for="web_bg">
					    计量单位：
					</label>
				
					<select id="option1"  style="width: 150px;padding: 5px 2px;cursor: pointer;">
  						<option value="平方米">平方米</option>
  						<option value="台">台</option>
  						<option value="套">套</option>
  						<option value="辆">辆</option>
  						<option value="部">部</option>
  						<option value="件">件</option>
  						<option value="个">个</option>
					</select>

					
		</div>
		<div class="control-group cf clearfix " >
					<label class="control-label" for="web_bg">
					    资产金额：
					</label>
					
						<input type="text" name=" " id="sum"  class="input" style="padding: 5px 2px; " placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='小数点后最多保留两位'">
					
		</div>
		<div class="form-actions" >
					
					<a href="javascript:void(0)" class="btn btn-primary" class="fa fa-plus" ><i class="fa fa-plus"></i>添加</a>
				
				</div>
  </form>
  </div >
  </div>
  </body>
</html>
