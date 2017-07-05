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
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
     <script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
 
  </head>
  <body>
		<form action="" class="form-horizontal ajax_form">
		<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3 class="current">
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
			<h3 >
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/daochu/indexlmy.jsp">
				<span class="fa fa-bar-chart-o"></span>
				资产信息导出
				</a>
			</h3>
		</div> 
		<div class="box-content clearfix">
			<div class="add">
				<table>
					<tr>
					<td><h2>账套：</h2></td>
					<td><input type="text" placeholder="河北省秦皇岛市国家税务局国有资产 账套01" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='河北省秦皇岛市国家税务局国有资产 账套01'"></td>
					</tr>
					<tr>
					<td><h2>资产密码：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>资产名称：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>资产类型：</h2></td>
					<td>
						<select>
							<option value="1" checked="checked"/>请选择</option>
							<option value="2">桌椅类</option>
							<option value="3">电子类</option>
							<option value="4">大型设备</option>
						</select>
					</td>
					</tr>
					<tr>
					<td><h2>规格型号：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>购置日期：</h2></td>
					<td>
                	<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="申请日期" class="time-select"/> 
                	</td>
					</tr>
					<tr>
					<td><h2>资产金额：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>使用人：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>使用部门：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>备注：</h2></td>
					<td><textarea rows="3" cols="40"></textarea></td>
					</tr>
				</table>
			</div>
			<div class="add sec">
				<table>
					<tr>
					<td><h2>保管人：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60" style="width:150px"></td>
					</tr>
					<tr>
					<td><h2>保管部门：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>使用状态：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>凭证字号：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>状态：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>是否期初：</h2></td>
					<td>
					<span><input type="radio" name="qc">是</span>
					<span><input type="radio" name="qc">否</span>
					</td>
					</tr>
					<tr>
					<td><h2>报废年度：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>启用日期：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					<tr>
					<td><h2>制卡日期：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60"></td>
					</tr>
					
				</table>
			</div>
			<div style="position:absolute;left:12%;top:115%;">
				<input class="btn btn-primary" type="button" value="修改">
			</div>
	</div>
</div>
		</form>
		
  </body>
</html>
