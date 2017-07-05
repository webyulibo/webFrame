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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
  	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
  </head>
  <body>
  	<form action="" class="form-horizontal ajax_form">
  	<div class="container-f">
  	 <div class="box-title clearfix tab-title">
			<h3 class="current">
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
			<h3 >
				<a href="<%=basePath %>adminasset/showassetoutput.htm">
				<span class="fa fa-bar-chart-o"></span>
				资产信息导出
				</a>
			</h3>
		</div> 
	<div class="box-content clearfix">
	<fieldset class="search" >
	<legend><span>资产管理查询</span></legend>
	<div style="width:1030px;">
  	<div class="search">
  		<div class="searchty">
  		<!-- <input type="checkbox" name="option" class="checkbox1"><span>资产类型：</span> -->
  		<span>资产类型：</span>
  		<c:if test="${category=='全部'||category==null||category==''}">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option1">
  			<option value="全部" checked="checked">全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
		</select>
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option1">
  			<option value="全部" checked="checked">全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
  		</select> -->
  		</c:if>
  		<c:if test="${category=='使用人' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option1">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option1"> -->
  			<option value="使用人" checked="checked"/>使用人</option>
  			<option value="全部" >全部</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='使用部门' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option1">
  	<!-- 	<select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option1"> -->
			<option value="使用部门" checked="checked">使用部门</option>
  			<option value="全部" >全部</option>
  			<option value="使用人" />使用人</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='保管人' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option1">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option1"> -->
			<option value="保管人" checked="checked">保管人</option>
  			<option value="全部" >全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管部门">保管部门</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='保管部门' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option1">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" i -->
			<option value="保管部门" checked="checked">保管部门</option>
  			<option value="全部" >全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="资产代码">资产代码</option>
  		</select>
  		</c:if>
  		<c:if test="${category=='资产代码' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option1">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option1"> -->
			<option value="资产代码" checked="checked">资产代码</option>
  			<option value="全部" >全部</option>
  			<option value="使用人" />使用人</option>
			<option value="使用部门">使用部门</option>
			<option value="保管人">保管人</option>
			<option value="保管部门">保管部门</option>
  		</select>
  		</c:if>
  		
  		<c:if test="${text!=null }">
  		<input type="text" class="input-medium ipt_require" style="height:31px;margin-top:-1%" id="searchtext" value="${text }">
  		</c:if>
  		<c:if test="${text==null }">
  		<input type="text" class="input-medium ipt_require" style="height:31px;margin-top:-1%" id="searchtext">
  		</c:if>
  		</div>	
  		<div class="searchty">
  		<!-- <input type="checkbox" name="option" class="checkbox2"/><span>使用状态：</span> -->
  		<span>使用状态：</span>
  		<c:if test="${usestate=='全部'||usestate==null||usestate=='' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"id="option2">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option2"> -->
  			<option value="全部" checked="checked">全部</option>
  			<option value="在用" >在用</option>
			<option value="闲置">闲置</option>
			<option value="损坏不能用">损坏不能用</option>
  		</select>
  		</c:if>
  		<c:if test="${usestate=='在用' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"id="option2">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option2"> -->
  			<option value="在用" checked="checked">在用</option>
  			<option value="全部" >全部</option>
			<option value="闲置">闲置</option>
			<option value="损坏不能用">损坏不能用</option>
  		</select>
  		</c:if>
  		<c:if test="${usestate=='闲置' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"id="option2">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option2"> -->
			<option value="闲置" checked="checked">闲置</option>
  			<option value="全部" >全部</option>
  			<option value="在用" >在用</option>
			<option value="损坏不能用">损坏不能用</option>
  		</select>
  		</c:if>
  		<c:if test="${usestate=='损坏不能用' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"id="option2">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option2"> -->
			<option value="损坏不能用" checked="checked">损坏不能用</option>
  			<option value="全部" >全部</option>
  			<option value="在用" >在用</option>
			<option value="闲置">闲置</option>
  		</select>
  		</c:if>
  		</div>
  		<div class="searchty">
<!--   		<input type="checkbox" name="option" class="checkbox3"/><span>状态：</span> -->
		<span>状态：</span>
		<c:if test="${state=='全部'||state==null||state==''}">
		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option3">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option3"> -->
  			<option value="全部" checked="checked">全部</option>
  			<option value="正常" >正常</option>
			<option value="盘亏">盘亏</option>
  		</select>
  		</c:if>
  		<c:if test="${state=='正常' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option3">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option3"> -->
  			<option value="正常" checked="checked">正常</option>
  			<option value="全部" >全部</option>
			<option value="盘亏">盘亏</option>
  		</select>
  		</c:if>
  		<c:if test="${state=='盘亏' }">
  		<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="option3">
  		<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="option3"> -->
			<option value="盘亏" checked="checked">盘亏</option>
  			<option value="全部" >全部</option>
  			<option value="正常" >正常</option>
  		</select>
  		</c:if>
  		</div>
  		<div style="float:right;">
  		<a class="btn cf" href="javascript:void(0)" id="search1"><i class="fa fa-search "></i>查询 </a>
  		<a class="btn cf" href="<%=basePath%>adminasset/showassetadd.htm" ><i class="fa fa-plus"></i>添加</a>
  		</div>
  	</div>
  	</div>
  	</fieldset>
  	<fieldset class="search" style="margin-top:20px;">
  	<legend><span>资产管理查询结果</span></legend>
  	<div class="show tab-lbgl">
  		<table class="table-hover dataTable">
  			<tr>
  				<th><input class="checkBoxAll" name="Fruit" type="checkbox" value="" />序号</th>
  				<th>资产编号</th>
  				<th>资产名称</th>
  				<th>使用人</th>
  				<th>使用部门</th>
  				<th>保管人</th>
  				<th>保管部门</th>
  				<th>使用状态</th>
  				<th>操作</th>
  				
  			</tr>
  			<c:if test="${not empty list}">
  			<!-- varStatus="s" -->
  			<c:forEach items="${list }" var="asset" varStatus="s">
  			<tr>
  			
  				<td><c:choose>
    						<c:when test="${s.count != 10}">
      							 <input class="checkBox"  name="Fruit" type="checkbox" value="${asset.id }"  style="margin-right:20px"/>
    						</c:when>
    						<c:otherwise>
        						<input class="checkBox"  name="Fruit" type="checkbox" value="${asset.id }"  style="margin-right:10px"/>
    						</c:otherwise>
						</c:choose>
  				<c:out value="${(pager.currentPage-1)*10+s.count }"></c:out></td>
  				<td>${asset.code}</td>
  				<td>${asset.name }</td>
  				<td>${asset.user }</td>
  				<td>${asset.usedepartment }</td>
  				<td>${asset.keeper }</td>
  				<td>${asset.keepdepartment }</td>
  				<td>${asset.usestate }</td>
  				<td>
  				<a href="<%=basePath%>adminasset/showassetbyid.htm?id=${asset.id}" class="btn" rel="tooltip" title="修改">
				<i class="fa fa-edit"></i>修改</a></td>
  			</tr>
  			</c:forEach>
  			</c:if>
  				
  		</table>
  	</div>
  	<div style="padding-top:20px">
  	<a style="background-color:#368eff;width:100px;margin-left:10px;border-radius: 4px;  color:#FFFFFF;  text-decoration:none; font-size: 15px;   margin-left: 10px;  padding: 5px 15px;" onClick="downloadPdf()"><i class="fa fa-plus"></i>生成标签</a></div>
  	<!-- <div class="pagination ue-clear" style="margin-top:0px;"></div> -->
  	<div class="font">
          <cc:page value="${pager}" url="${basePath}adminasset/showassetmenu.htm?category=${category }&text=${text }&usestate=${usestate }&state=${state }"></cc:page>
    </div>
     </fieldset>
  	</div>
  	
 </div>

  	</form>
  	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.media.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".checkBoxAll").change(function(){

			 var a =$(this).prop("checked");
				if(a){
					$(".checkBox").prop("checked",true);
				}else{
					$(".checkBox").prop("checked",false);
				}
		});
	});
	function downloadPdf(){
		var isNo=false;
		$(".checkBox").each(function(){
			isNo=$(this).prop("checked");
			if(isNo){
				return false;
			}
		});
		if(isNo==true){
			var i=0;
			var data="";
			$(".checkBox").each(function(){
				if($(this).prop("checked")){
					if(i===0){
						data+=$(this).attr("value");	
					}else{
						data+=(","+$(this).attr("value"));
					}
					i++;
				}
			});
			alert(data);
			window.open("${pageContext.request.contextPath }/adminasset/createlabel.htm?data="+data);
        }else{
        	alert("您未选中任何标签！");
        }		
	}
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
		/* $('.pagination').pagination(100,{
			callback: function(page){
				console.log(page+1);	
			},
			display_msg: true,
			setPageNo: true
		});
		function clear(x){
			if(x.value=="请输入查询条件"){
				x.value='';
			}
		}
		function goback(x){
			if (x.value=='') {
				x.value='请输入查询条件';
			}
		} */
		
		//alert("${pager}");
		//alert("");
		//查询
		//实现有问题
		$("#search1").click(function(){
		//alert("search");
			var category = document.getElementById("option1").value;
			var text = document.getElementById("searchtext").value;
			var usestate = document.getElementById("option2").value;
			var state = document.getElementById("option3").value;
			
			search(category,text,usestate,state);
			
		});
		function search(category,text,usestate,state){
			location.href = "${basePath}adminasset/showassetmenu.htm?category="+category+"&text="+text+"&usestate="+usestate+"&state="+state;
		}
		
		
		//alert("");
	</script>
  </body>
</html>
