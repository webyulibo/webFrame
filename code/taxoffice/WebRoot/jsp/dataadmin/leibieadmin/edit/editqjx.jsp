<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
   
    <title>修改</title>
   
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/lbglqjx.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	
	<script>
		function csave(){
			var co=confirm('确定修改？');
			if(co){
				location="jsp/dataadmin/leibieadmin/main/yjlxlbqjx.jsp";
			}
		}
		
</script>
	
 </head>
  
  <body>
  <div class="cz-edit">
		<div class="top-hx table-title"></div>
		<div class="form-edit">
			<form action="" class="form">
				<div class="form-row">
					<label for="" class="form-lb">类型名称：</label>
					<input type="text" class="form-text">
				</div>
				<div class="form-row">
					<label for="" class="form-lb">计量单位：</label>
					<!-- <input type="text" class="form-text"> -->
					<select style="cursor: pointer;margin-left:5px;">
						<option value="11">平方米</option>
						<option value="22">台</option>
						<option value="33">套</option>
						<option value="44">辆</option>
						<option value="55">部</option>
						<option value="66">件</option>
						<option value="77">个</option>
					</select>
				</div>
				<div class="form-row">
					<label for="" class="form-lb">资产金额：</label>
					<input type="text" class="form-text" placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='小数点后最多保留两位'">
				</div>
			</form>
		</div>
		<div class="bottom">
			
			<button class="btn btn-primary" onclick="csave()"><i class="fa fa-edit"></i>修改</button>
			<button class="btn btn-primary" onclick="javascript:location='jsp/dataadmin/leibieadmin/main/yjlxlbqjx.jsp'">返回</button>
		</div>
	</div>
  </body>
</html>
