<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/pageuri" prefix="cc"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page : testlist.jsp. <br>
    <hr>
    
    <form action="${basePath}adminassetcheckdataexportcontroller/getassetsbyusestateandbyotherwithpage.htm"	id="subform" method="post">
    	<select name="selectkey">
    	<option>${selectkey }</option>
    		<option>使用人</option>
    		<option>使用部门</option>
    		<option>保管人</option>
    		<option>保管部门</option>
    		<option>资产代码</option>
    	</select>
    	<input type="text" value="${selectvalue }" name="selectvalue"><br>
     <label>使用状态</label>
    	 <select name="usestate">
    	 <option>${usestate }</option>
    	 <option>在用</option>
    		<option>报废</option>
    		<option>维修</option>
    		<option>全部</option>
    	</select> 
    	
    	<label>状态</label>
    	<select name="state">
    	<option>${state }</option>
    		<option>丢失</option>
    		<option>正常</option>    		
    		<option>全部</option>
    	</select>
    	
    	<br>
    	   <input type="submit" value="查询"> 	   	  
    </form>
    
    <hr>
    <c:if test="${not empty assets }">
    	<table class="table-hover dataTable" id="table">
			<tr>
				<th>序号</th>
				<th>资产代码</th>
				<th>资产名称</th>
				<th>资产类型</th>
				<th>规格型号</th>
				<th>使用人</th>
				<th>使用部门</th>
				<th>保管人</th>
				<th>保管部门</th>
				<th>使用状态</th>
			</tr>
			
			<c:forEach items="${assets }" var="asset" >
			
            <form>
            <tr>
               <td>${asset.id }</td>
			   <td>${asset.code }</td>
			   <td>${asset.name }</td>
			   <td>${asset.type }</td>
			   <td>${asset.model }</td>
               <td>${asset.user }</td>
               <td>${asset.usedepartment }</td>
               <td>${asset.keeper }</td>
               <td>${asset.keepdepartment }</td>
               <td>${asset.usestate }</td>
            </tr>
            </form>
            </c:forEach>
			
		</table>
   	</c:if>
	<c:if test="${empty assets }">
	暂无数据
	</c:if>
	<div class="font">
          <cc:page value="${pager}" url="${basePath}testcontent/testlist.htm?"></cc:page>
    	</div>
  </body>
</html>
