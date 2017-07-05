<%-- <%@ page contentType="text/html;charset=utf-8" language="java"
	import="java.util.*"%> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/pageuri" prefix="cc"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>盘点数据导出</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/page.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
<style type="text/css">
		table tr td {
			width: 100px;
			height: 50px;
			font-size: 12px;
		}
	/* 	select option {
			width: 180px;
			height: 25px;
		} */

		body {
			min-width: 1080px;
		}

		#list > fieldset > table tr td{
			height:30px;
			font-size: 15px;
			text-align: center;
		}

		#list > fieldset > table tr th {
			height: 30px;
		}
		fieldset{
			margin-top:20px;
			margin-bottom:10px;
			padding-left:10px;
			padding-right:10px;
		}
		legend{
			font-size:15px;
		}
</style>


<script type="text/javascript">
	function exportdata() {

		var usestate1=document.getElementById("condition").getAttribute("usestate");
			var name1=document.getElementById("condition").getAttribute("name");
			var keepdepartment1=document.getElementById("condition").getAttribute("keepdepartment");
			var  usedepartment1=document.getElementById("condition").getAttribute("usedepartment");
			var isbegin2=document.getElementById("condition").getAttribute("isbegin1");
			var state1=document.getElementById("condition").getAttribute("state");
			var code1=document.getElementById("condition").getAttribute("code");
			var keeper1=document.getElementById("condition").getAttribute("keeper");
			var user1=document.getElementById("condition").getAttribute("user");
			var ghostyear1=document.getElementById("condition").getAttribute("ghostyear");
			//alert(ghostyear1)
			var type6=document.getElementById("condition").getAttribute("type1");
			var type7=document.getElementById("condition").getAttribute("type2");
			var type8=document.getElementById("condition").getAttribute("type3");
			var type9=document.getElementById("condition").getAttribute("type4");
			var type10=document.getElementById("condition").getAttribute("type5");
			var purchasetime1=document.getElementById("condition").getAttribute("purchasetime");
			var makecardtime1=document.getElementById("condition").getAttribute("makecardtime");
			var startusetime1=document.getElementById("condition").getAttribute("startusetime");
			var value1=document.getElementById("condition").getAttribute("value");
			var abortpurchasetime1=document.getElementById("condition").getAttribute("abortpurchasetime");
			var abortmakecardtime1=document.getElementById("condition").getAttribute("abortmakecardtime");
			var abortstartusetime1=document.getElementById("condition").getAttribute("abortstartusetime");
			var abortvalue1=document.getElementById("condition").getAttribute("abortvalue");
		
		$.ajax({ 				
		     type:"POST", //表单提交类型 
		     url:"<%=basePath%>adminassetcheckdataexportcontroller/exportassetcheckdatatotext.htm", //表单提交目标 
		     data:{usestate:usestate1,name:name1,keepdepartment:keepdepartment1,usedepartment:usedepartment1,isbegin1:isbegin2,state:state1,code:code1,keeper:keeper1,user:user1,ghostyear:ghostyear1,type1:type6,type2:type7,type3:type8,type4:type9,type5:type10,purchasetime:purchasetime1,makecardtime:makecardtime1,startusetime:startusetime1,value:value1,abortpurchasetime:abortpurchasetime1,abortmakecardtime:abortmakecardtime1,abortstartusetime:abortstartusetime1,abortvalue:abortvalue1}, //表单数据
		     success:function(e){
		    	 //alert(e)
		     var  data = eval("("+e+")");
		      if(data.status == '1'){//msg 是后台调用action时，你穿过来的参数
		       		alert("写入成功！");
		      		
		      }else{
				alert("写入失败！");
		      }
		     }
		    }); 	
	}
	
	
	function submit() {
	
		document.getElementById("subForm").submit();
	}

</script>

<script type="text/javascript">
		function getInfoByPage() {
			var inputpage=document.getElementById("inputPage").value;
			
			if(inputpage.length==0){
				//alert("请输入合法数据")
				document.getElementById("inputPage").value="";
				document.getElementById("inputPage").focus();
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
					document.getElementById("inputPage").focus();
				}
			}						
		}
	</script>



</head>
<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a
					href="<%=basePath%>adminassetcheckdataexportcontroller/getassetsbyusestateandbyotherwithpage.htm">
					<span class="fa fa-table"></span> 盘点数据导出
				</a>
			</h3>
			<h3>
				<a
					href="<%=basePath%>adminassetcheckresultimportcontroller/showstartpage.htm">
					<span class="fa fa-cog"></span> 盘点结果导入
				</a>
			</h3>
			<h3>
				<a
					href="<%=basePath%>admincheckresultmanagecontroller/showgetcheckresultsbyselecttermswithpage.htm">
					<span class="fa fa-bar-chart-o"></span> 盘点历史记录
				</a>
			</h3>
		</div>
		<fieldset style="height:60px;margin-left:15px;">
			<legend style="font-weight: bold;font-size: 14px;">查询条件</legend>
			<div class="row clearfix" style="margin-top:-2.5%">
				<form
					action="adminassetcheckdataexportcontroller/getassetsbyusestateandbyotherwithpage.htm"
					id="subForm"  method="post">
					<div class="control-group f_l">
						<div class="f_l">
							<table>
								<tr>
									<!-- <td style="width:30px">
									<div class="piaochecked">
										<input name="need_inv" type="checkbox"
											style="height:20px;width:20px;" class="radioclass input"
											value="1">
									</div>
								</td> -->
									<td style="width:75px"><h3>资产类型：</h3></td>
									<td><select
										style="width:150px;padding:5px 2px;cursor:pointer;"
										id="selectkey" name="selectkey">
									<c:if test="${not empty selectkey}">
										<option value="${selectkey }">${selectkey }</option>
									</c:if>		
											<option value="全部">全部</option>																							
											<option value="使用人">使用人</option>
											<option value="使用部门">使用部门</option>
											<option value="保管人">保管人</option>
											<option value="保管部门">保管部门</option>
											<option value="资产代码">资产代码</option>
											
											
									</select></td>
									<td>
										<c:choose>
											<c:when test="${not empty selectvalue }">
												<input type="text" name="selectvalue" id="selectvalue"
												style="width:163px;height:30px;" value="${selectvalue }"
												onclick="this.focus();this.select();"
												onBlur="if(this.value==''){this.value='请输入查询条件';}"> 
												<!-- <a style="margin-left:10px" onclick="submit()" class="btn cf" href="javascript:void(0)"> <i class="fa fa-search"></i><span>查询</span></a> -->
											</c:when>
											<c:otherwise>
											<input type="text" name="selectvalue" id="selectvalue"
												style="width:163px;height:30px;" value="请输入查询条件"
												onclick="this.focus();this.select();"
												onBlur="if(this.value==''){this.value='请输入查询条件';}"> 
												<!-- <a style="margin-left:10px" onclick="submit()" class="btn cf" href="javascript:void(0)"> <i class="fa fa-search"></i><span>查询</span></a> -->
											</c:otherwise>
										</c:choose>
						
									</td>
				<%-- <div style="float:left;margin-top:12px;margin-left:1%;">
					<c:choose>
						<c:when test="${not empty selectvalue }">
							<input type="text" name="selectvalue" id="selectvalue"
							style="width:163px;height:30px;" value="${selectvalue }"
							onclick="this.focus();this.select();"
							onBlur="if(this.value==''){this.value='请输入查询条件';}"> 
							<a style="margin-left:10px" onclick="submit()" class="btn cf" href="javascript:void(0)"> <i class="fa fa-search"></i><span>查询</span></a>
						</c:when>
						<c:otherwise>
						<input type="text" name="selectvalue" id="selectvalue"
							style="width:163px;height:30px;" value="请输入查询条件"
							onclick="this.focus();this.select();"
							onBlur="if(this.value==''){this.value='请输入查询条件';}"> 
							<a style="margin-left:10px" onclick="submit()" class="btn cf" href="javascript:void(0)"> <i class="fa fa-search"></i><span>查询</span></a>
						</c:otherwise>
					</c:choose>
						
							
					</div> --%>
									<td style="width:75px;padding-left:15px;"><h3>使用状态：</h3></td>
									<td><select
										style="width:150px;padding:5px 2px;cursor:pointer;"
										name="usestate" id="usestate">
										<c:if test="${not empty usestate}">
										<option value="${usestate}">${usestate }</option>
									</c:if>	
											<option value="全部">全部</option>
											<option value="在用">在用</option>
											<option value="维修">维修</option>
											<option value="报废">报废</option>
											
											
									</select></td>

									<!-- <td style="width:30px">
									<div class="piaochecked">
										<input name="need_inv" type="checkbox"
											style="height:20px;width:20px;" class="radioclass input"
											value="1">
									</div>
								</td> -->
									<td style="width:45px;padding-left:15px;"><h3>状态：</h3></td>
									<td><select
										style="width:150px;padding:5px 2px;cursor:pointer;"
										name="state" id="state">
										<c:if test="${not empty state }">
											<option>${state }</option>
										</c:if>									
											<option value="全部">全部</option>
											<option value="正常">正常</option>
											<option value="丢失">丢失</option>
											
									</select></td>
								</tr>
							</table>
						</div>
					</div>
				</form>


				<div style="float:right;margin-top:13px;">
				<a style="margin-left:10px" onclick="submit()" class="btn cf" href="javascript:void(0)"> <i class="fa fa-search"></i><span>查询</span></a>
					<a class="btn cf" onclick="exportdata()"> <i class="fa fa-edit"></i><span>导出</span></a>
				</div>
			</div>
		</fieldset>
		
		<div style="margin-top:10px;margin-left:15px;" id="list">
			<fieldset>
			<legend style="font-weight: bold;font-size: 14px;">盘点数据列表</legend>
			<c:if test="${not empty assets }" >
				<table class="table-hover dataTable">
					<tr>
						<th style="background-color:#eee;">序号</th>
						<th style="background-color:#eee;width:15%;">资产代码</th>
						<th style="background-color:#eee;">资产名称</th>
						<th style="background-color:#eee;">资产类型</th>
						<!-- <th style="background-color:#eee;">规格型号</th> -->
						<th style="background-color:#eee;">使用人</th>
						<th style="background-color:#eee;">使用部门</th>
						<th style="background-color:#eee;">保管人</th>
						<th style="background-color:#eee;">保管部门</th>
						<th style="background-color:#eee;">使用状态</th>
					</tr>
					
					<c:forEach items="${assets}" var="asset" varStatus="status">
						<tr>
						
							<td>${status.index+1 }</td>
							<td>${asset.code }</td>
							<td>${asset.name }</td>
							<td>${asset.type }</td>
							<!-- <td>${asset.model }</td> -->
							<td>${asset.user }</td>
							<td>${asset.usedepartment }</td>
							<td>${asset.keeper }</td>
							<td>${asset.keepdepartment }</td>
							<td>${asset.usestate }</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${empty assets }">
			暂无数据
			</c:if>
			<cc:page value="${page}"
			url="adminassetcheckdataexportcontroller/getassetcheckresultwithpage.htm?assetCustom=${assetCustom }"></cc:page>
			</fieldset>
			<input type="hidden" id="condition" usestate="${assetCustom.usestate }" name="${assetCustom.name }" keepdepartment="${assetCustom.keepdepartment }" usedepartment="${assetCustom.usedepartment }" isbegin1="${ assetCustom.isbegin1}" state="${assetCustom.state }" code="${assetCustom.code }" keeper="${assetCustom.keeper }" user="${assetCustom.user }" ghostyear="${assetCustom.ghostyear }" type1="${assetCustom.type1 }" type2="${assetCustom.type2 }" type3="${assetCustom.type3 }" type4="${assetCustom.type4 }" type5="${assetCustom.type5 }" purchasetime="${assetCustom.purchasetime }" makecardtime="${assetCustom.makecardtime }" startusetime="${assetCustom.startusetime }" value="${assetCustom.value }" abortpurchasetime="${assetCustom.abortpurchasetime }" abortmakecardtime="${assetCustom.abortmakecardtime }" abortstartusetime="${assetCustom.abortstartusetime }" abortvalue="${assetCustom.abortvalue }">
		</div>
	</div>
	
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<script type="text/javascript">
		function clear(x) {
			if (x.value == "请输入查询条件") {
				x.value = '';
			}
		}
		function goback(x) {
			if (x.value == '') {
				x.value = '请输入查询条件';
			}
		}

		$(".piaochecked").on(
				"click",
				function() {
					$(this).hasClass("on_check") ? $(this).removeClass(
							"on_check") : $(this).addClass("on_check");
				});
	</script>
</body>
</html>