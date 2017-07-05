<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/pageuri" prefix="cc"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
	 <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
  </head>
  <body>
  	<form action="" class="form-horizontal ajax_form">
  	<div class="container-f">
  	 <div class="box-title clearfix tab-title">
			<h3 >
				<a href="<%=basePath %>adminasset/showassetmenu.htm">
				<span class="fa fa-table"></span>
				资产管理
				</a>
			</h3>
			<h3>
				<a href="<%=basePath %>adminasset/showassetinput.htm">
				<span class="fa fa-cog"></span>
				资产信息导入
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>adminasset/showassetoutput.htm">
				<span class="fa fa-bar-chart-o"></span>
				资产信息导出
				</a>
			</h3>
		</div> 
	<div class="box-content clearfix">
	<fieldset class="search" >
	<legend><span>资产信息导出查询</span></legend>
	<div style="width:1030px;">
  	<div class="search">
  		<div class="searchty"> 		
  		<!-- <input type="checkbox" name="option" class="checkbox1" value='s' id="checkbox1" checked="checked"/> -->
  		<span>资产类型：</span>
  		<c:if test="${category=='全部'||category==null }">
  		<select class="sel easyui-combobox" name="type2" id="option1" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option1"> -->
  			<option value="全部" checked="checked">全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='使用人' }">
  		<select class="sel easyui-combobox" name="type2" id="option1" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option1"> -->
  			<option value="使用人" checked="checked"/>使用人</option>
  			<option value="全部" >全部</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='使用部门' }">
  		<select class="sel easyui-combobox" name="type2" id="option1" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option1"> -->
			<option value="使用部门" checked="checked">使用部门</option>
  			<option value="全部" >全部</option>
  			<option value="使用人" />使用人</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='保管人' }">
  		<select class="sel easyui-combobox" name="type2" id="option1" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option1"> -->
			<option value="保管人" checked="checked">保管人</option>
  			<option value="全部">全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='保管部门' }">
  		<select class="sel easyui-combobox" name="type2" id="option1" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option1"> -->
			<option value="保管部门" checked="checked">保管部门</option>
  			<option value="全部">全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='资产代码'}">
  		<select class="sel easyui-combobox" name="type2" id="option1" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option1"> -->
			<option value="资产代码" checked="checked">资产代码</option>
  			<option value="全部">全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
  		</select>
  		</c:if>
  		<c:if test="${text==null }">
  		<input type="text" class="input-medium ipt_require" style="height:25px;" id="searchtext">
  		</c:if>
  		<c:if test="${text!=null }">
  		<input type="text" class="input-medium ipt_require" style="height:25px;" id="searchtext" value="${text }">
  		</c:if>
  		</div>	
  		<div class="searchty">
  		<!-- <input type="checkbox" name="option" class="checkbox2"/><span>使用状态：</span> -->
  		<span>使用状态：</span>
  		<c:if test="${usestate=='全部'||usestate==null }">
  		<select class="sel easyui-combobox" name="type2" id="option2" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option2"> -->
  			<option value="全部" checked="checked">全部</option>
  			<option value="在用" >在用</option>
			<option value="闲置">闲置</option>
			<option value="损坏不能用">损坏不能用</option>
  		</select>
  		</c:if>
  		<c:if test="${usestate=='在用'}">
  		<select class="sel easyui-combobox" name="type2" id="option2" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option2"> -->
  			<option value="在用" checked="checked">在用</option>
  			<option value="全部">全部</option>
			<option value="闲置">闲置</option>
			<option value="损坏不能用">损坏不能用</option>
  		</select>
  		</c:if>
  		<c:if test="${usestate=='闲置' }">
  		<select class="sel easyui-combobox" name="type2" id="option2" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option2"> -->
			<option value="闲置"  checked="checked">闲置</option>
  			<option value="全部">全部</option>
  			<option value="在用" >在用</option>
			<option value="报废">报废</option>
  		</select>
  		</c:if>
  		<c:if test="${usestate=='损坏不能用'}">
  		<select class="sel easyui-combobox" name="type2" id="option2" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  	<!-- 	<select id="option2"> -->
			<option value="损坏不能用" checked="checked">损坏不能用</option>
  			<option value="全部">全部</option>
  			<option value="在用" >在用</option>
			<option value="闲置">闲置</option>
  		</select>
  		</c:if>
  		</div>
  		<div class="searchty">
  		<!-- <input type="checkbox" name="option" class="checkbox3"/><span>状态：</span> -->
  		<span>状态：</span>
  		<c:if test="${state=='全部'||state==null }">
  		<select class="sel easyui-combobox" name="type2" id="option3" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option3"> -->
  			<option value="全部" checked="checked">全部</option>
  			<option value="正常" >正常</option>
			<option value="盘亏">盘亏</option>
  		</select>
  		</c:if>
  		<c:if test="${state=='正常' }">
  		<select class="sel easyui-combobox" name="type2" id="option3" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option3" > -->
  			<option value="正常" checked="checked">正常</option>
  			<option value="全部">全部</option>
			<option value="盘亏">盘亏</option>
  		</select>
  		</c:if>
  		<c:if test="${state=='丢失' }">
  		<select class="sel easyui-combobox" name="type2" id="option3" value='1' style="display:block;width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
  		<!-- <select id="option3" > -->
			<option value="盘亏" checked="checked">盘亏</option>
  			<option value="全部" >全部</option>
  			<option value="正常" >正常</option>
  		</select>
  		</c:if>
  		
  		</div>
  		<a class="btn cf" href="javascript:void(0)" id="search1"><i class="fa fa-search "></i>查询 </a>
  		<!-- onclick="output()" -->
  		<a class="btn cf" href="javascript:void(0)" id="output" ><i class="fa fa-edit "></i>导出 </a>
  	</div>
  	</div>
  	</fieldset>
  	<fieldset class="search" style="margin-top:20px;">
  	<legend><span>资产信息导出结果</span></legend>
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
  			</tr>
  			<c:forEach items="${list}" var="asset" varStatus="s">
  			<tr>
  				<td><c:out value="${(pager.currentPage-1)*10+s.count }"></c:out></td>
  				<td>${asset.code }</td>
  				<td>${asset.name }</td>
  				<td>${asset.user }</td>
  				<td>${asset.usedepartment }</td>
  				<td>${asset.keeper }</td>
  				<td>${asset.keepdepartment }</td>
  				<td>${asset.usestate }</td>
  			</tr>
  			</c:forEach>
  		</table>
  	</div>
  <div class="font">
          <cc:page value="${pager}" url="${basePath}adminasset/showassetoutput.htm?category=${category }&text=${text }&usestate=${usestate }&state=${state }"></cc:page>
   </div>
  </fieldset>
</div> 
	
  	</form>
  	<script type="text/javascript">
  	//分页跳转的js
  	function getInfoByPage() {
			var inputpage=document.getElementById("inputPage").value;
			
			if(inputpage.length==0){
			
				document.getElementById("inputPage").value="";
				return;
			}
			else{
				
				if(!isNaN(inputpage)){
					
					var totalPage=document.getElementById("inputPage").getAttribute("totalPage");
					
					if(parseInt(inputpage)>parseInt(totalPage)){
						document.getElementById("inputPage").value="";
						document.getElementById("inputPage").focus();
						return ;
					}
					else{
						
						var urlwithpage=document.getElementById("inputPage").getAttribute("url");
						var bool=urlwithpage.indexOf('?');						
						if(bool>0){
							urlwithpage=urlwithpage+'&currentPage='+inputpage;
						}
						else{
							urlwithpage=urlwithpage+'?currentPage='+inputpage;
						}
						window.location.href=urlwithpage;
					}										
				}
				else{
					document.getElementById("inputPage").value="";
					alert("请输入合法的数字");
				}
			}						
		}
  	
  	
  	
  	
  	
  		$("#output").click(function(){
  			var category = document.getElementById("option1").value;
  			var text = document.getElementById("searchtext").value;
  			var usestate = document.getElementById("option2").value;
  			var state = document.getElementById("option3").value;
  			//alert("click");
  			location.href="<%=basePath%>adminasset/outputasset.htm?category="+category+"&text="+text+"&usestate="+usestate+"&state="+state;
  			//output(category,text,usestate,state);
  		});
  		<%-- function output(category,text,usestate,state){
  			//alert("output");
  			$.post(
  				'<%=basePath%>adminasset/outputasset.htm',
  				{category:category,text:text,usestate:usestate,state:state},
  				function(data){
  					if(data.status=='ok'){
  						alert(data.msg);
  						
  					}else{
  						alert(data.msg);
  					}
  				},
  				'json'
  			);
  		} --%>
  		
  		$("#search1").click(function(){
			//var currentPage = ${page};
			//alert("${pager}");
			var category = document.getElementById("option1").value;
			var text = document.getElementById("searchtext").value;
			var usestate = document.getElementById("option2").value;
			var state = document.getElementById("option3").value;
			var currentPage = "${pager.currentPage}";
			
			
			//alert("这是"+text+"结束");
			
			//alert(usestate);
			/* if($('.checkbox1').checked){
				category = document.getElementById("option1").value;
				text = document.getElementById("searchtext").value;
				//alert("null");
			}
			if($('.checkbox2').checked){
				usestate = document.getElementById("option2").value;
			}
			if($('.checkbox3').checked){
				state = document.getElementById("option3").value;
			} */
			//alert(usestate);
			search(category,text,usestate,state,currentPage);
			
		});
		function search(category,text,usestate,state,currentPage){
		
			<%-- location.href = '<%=basePath%>adminasset/showassetmenu.htm?category='+category+'&text='+text+'&usestate='+usestate+'&state='+state+'&currentPage='+currentPage; --%>
			location.href = "${basePath}adminasset/showassetoutput.htm?category="+category+"&text="+text+"&usestate="+usestate+"&state="+state+"&currentPage="+currentPage;
		}
  		
  		
  	</script>
  </body>
</html>
