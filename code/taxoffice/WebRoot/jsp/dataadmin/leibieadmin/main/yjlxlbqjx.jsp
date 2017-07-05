<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>一级类型列表</title>
 	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/lbglqjx.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
</head>
  <body>
  <div class="lbgl">
	<div class="top-hx tab-title"></div>
	<fieldset>
		<legend>
			<span style="font-size:14px;">
				一级类型列表
			</span>
		</legend>
		<div class="lbgl-top">
		<div class="lbgl-top-left f_1">
			<a href="jsp/dataadmin/leibieadmin/add/tjyjlbqll.jsp" class="btn btn-add" style="width:110px;">
			<i class="fa fa-plus"></i><span>添加一级类型</span>
			</a>
		</div>
		<div class="lbgl-top-right"><form action="">
			<input type="text" class="lbgl-search" placeholder="类别名称" style="width: 220px; height: 30px;"
			onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='类别名称'">
			<button class="btn btn-primary" style="width:90px;"><i class="fa fa-search"></i>查询</button>
		</form>
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
					<a href="javascript:if(confirm('确定要删除?')){deleteItem('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
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
					<a href="javascript:if(confirm('确定要删除?')){deleteItem('rr')}else{}" class="btn" ><i class="fa fa-times"></i>删除</a>
				</td>
			</tr>
		</table>
	</div>
	</fieldset>
	
	
	
	
</div>
  </body>
</html>
