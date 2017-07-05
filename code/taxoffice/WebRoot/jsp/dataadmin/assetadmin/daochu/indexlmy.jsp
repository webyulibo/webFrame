<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
  </head>
  <body>
  	<form action="" class="form-horizontal ajax_form">
  	<div class="container-f">
  	 <div class="box-title clearfix tab-title">
			<h3 >
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/admin/indexlmy.jsp">
				<span class="fa fa-table"></span>
				资产管理
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/daoru/indexkw.jsp">
				<span class="fa fa-cog"></span>
				资产信息导入
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/daochu/indexlmy.jsp">
				<span class="fa fa-bar-chart-o"></span>
				资产信息导出
				</a>
			</h3>
		</div> 
	<div class="box-content clearfix">
  	<div class="search">
  		<div class="searchty"> 		
  		<input type="checkbox" name="option"><span>资产类型：</span>
  		<select >
  			<option value="1" checked="checked"/>使用人</option>
			<option value="2">使用部门</option>
			<option value="3">保管人</option>
			<option value="4">保管部门</option>
			<option value="5">资产代码</option>
			<option value="6">全部</option>
  		</select>
  		<input type="text" class="input-medium ipt_require" style="height:25px;">
  		</div>	
  		<div class="searchty">
  		<input type="checkbox" name="option"/><span>使用状态：</span>
  		<select >
  			<option value="1" checked="checked">在用</option>
			<option value="2">维修</option>
			<option value="3">报废</option>
			<option value="4">全部</option>
  		</select>
  		</div>
  		<div class="searchty">
  		<input type="checkbox" name="option"/><span>状态：</span>
  		<select >
  			<option value="1" checked="checked">正常</option>
			<option value="2">丢失</option>
			<option value="3">全部</option>
  		</select>
  		</div>
  		<a class="btn cf" href="javascript:void(0)">导出 </a>
  	</div>
  	<div class="show tab-lbgl">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>序号</th>
  				<th>资产编号</th>
  				<th>资产名称</th>
  				<th>使用人</th>
  				<th>使用部门</th>
  				<th>保管人</th>
  				<th>保管部门</th>
  				<th>使用状态</th>
  				<th>操作</th>
  				<th>生成标签</th>
  			</tr>
  			<tr>
  				<td>1</td>
  				<td>030400000000034</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>
  				<a href="<%=basePath%>jsp/dataadmin/assetadmin/daochu/editlmy.jsp" class="btn" rel="tooltip" title="修改" target="mainFrame">
				<i class="fa fa-edit"></i>修改</a></td>
  				<td>
  				<a href="javascript:void(0)" class="btn" rel="tooltip" title="生成">
				<i class="fa fa-plus"></i>生成</a>
  				</td>
  			</tr>
  				<tr>
  				<td>2</td>
  				<td>030400000000022</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>1</td>
  				<td>
  				<a href="<%=basePath%>jsp/dataadmin/assetadmin/daochu/editlmy.jsp" class="btn" rel="tooltip" title="修改" target="mainFrame">
				<i class="fa fa-edit"></i>修改</a></td>
  				<td>
  				<a href="javascript:void(0)" class="btn" rel="tooltip" title="生成">
				<i class="fa fa-plus"></i>生成</a>
  				</td>
  			</tr>
  		</table>
  	</div>
  </div>
</div> 
  	</form>
  </body>
</html>
