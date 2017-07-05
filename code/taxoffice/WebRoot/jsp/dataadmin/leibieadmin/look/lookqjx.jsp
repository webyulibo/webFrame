<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看子类型</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/lbglqjx.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	
	<script>
		function csave(){
			var co=confirm('确定保存？');
			if(co){
				location.href=history.back();
			}
		}
</script>
	

  </head>
  
  <body>
    <div class="lbgl">
	<div class="top-hx tab-title"></div>
	
	<fieldset>
		<legend>
			<span style="font-size:14px;">父级菜单名称</span>
		</legend>
		<div class="lbgl-top" style="padding-top:0px;margin-top:10px;">
		<div class="lbgl-top-left f_1" style="width:100px;">
		
		<input type="button" class="btn btn-primary" value="返回" onclick="javascript:location='jsp/dataadmin/leibieadmin/main/yjlxlbqjx.jsp'">
		</div>
		<div class="lbgl-top-right">
		</div>
	</div>
		<div class="tab-lbgl" style="margin-top:50px;">
		<table class="tab dataTable">
			<tr class="tab-tr">
				<th class="tab-th">类型名称</th>
				<th class="tab-th">计量单位</th>
				<th class="tab-th">资产金额</th>
				<th class="tab-th">查看子类型</th>
				<th class="tab-th">添加子类型</th>
				<th class="tab-th">操作</th>
			</tr>
			<tr class="tab-tr">
				<td class="tab-td"></td>
				<td class="tab-td"></td>
				<td class="tab-td"></td>
				<td class="tab-td">
					<a href="jsp/dataadmin/leibieadmin/look/lookqjx.jsp" class="btn" ><i class="fa fa-search"></i>查看</a>
				</td>
				<td class="tab-td">
					<a href="jsp/dataadmin/leibieadmin/add/tjzlxlmt.jsp" class="btn" ><i class="fa fa-plus"></i>添加</a>
				</td>
				<td class="tab-td">
					<a href="jsp/dataadmin/leibieadmin/edit/editqjx.jsp" class="btn" ><i class="fa fa-edit"></i>修改</a>
					<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
				</td>
			</tr>
			<tr class="tab-tr">
				<td class="tab-td"></td>
				<td class="tab-td"></td>
				<td class="tab-td"></td>
				<td class="tab-td">
					<a href="jsp/dataadmin/leibieadmin/look/lookqjx.jsp" class="btn" ><i class="fa fa-search"></i>查看</a>
				</td>
				<td class="tab-td">
					<a href="jsp/dataadmin/leibieadmin/add/tjzlxlmt.jsp" class="btn" ><i class="fa fa-plus"></i>添加</a>
				</td>
				<td class="tab-td">
					<a href="jsp/dataadmin/leibieadmin/edit/editqjx.jsp" class="btn" ><i class="fa fa-edit"></i>修改</a>
					<a href="javascript:if(confirm('您确定要删除吗?')){deleteItem('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
				</td>
			</tr>
		</table>
	</div>
	</fieldset>
	
</div>
  </body>
</html>
