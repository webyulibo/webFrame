<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/pageuri" prefix="cc"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资产管理查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome/css/font-awesome.css" />
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.js"></script>
	
	<style type="text/css">
		table tr td{
			width:100px;
			height:50px;
			font-size: 12px;
		}
		body{
			min-width: 700px;
		}
		
		#list > fieldset > table tr td{
			height:30px;
			font-size: 15px;
			text-align: center;
		}
		#list > fieldset > table tr th{
			height:30px;
			font-size: 15px;
		}
		
		fieldset{
			margin-top:0px;
			margin-bottom:10px;
			padding-top:15px;
			padding-bottom:5px;
			padding-left:10px;
			padding-right:10px;
		}
		legend{
			font-weight: bold;
			font-size: 14px;
		}
		div.modal-body{
			padding:0px;
		}
		div.modal-footer{
			padding:0px;
		}
		div.modal-header{
			padding:0px;
			padding-top:10px;
			padding-left:30px;
		}
		.modal_save,.modal_giveUp{
			height:30px;
		}
		.modal_save{
			padding-top:5px;
			margin-left:105px;
			padding-bottom:10px;
		}
		.modal_giveUp{
			padding-top:7px;
			padding-bottom:8px;
			margin-right:50px;
		}
		a{
			text-decoration:none;
		}
	</style>
	<script type="text/javascript">
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
		
			
			location.href = "<%=basePath%>adminassetcheckdataexportcontroller/exportassetcheckdatatotext.htm?usestate="+usestate1+"&name="+name1+"&keepdepartment="+keepdepartment1+"&usedepartment="+usedepartment1+"&isbegin1="+isbegin2+"&state="+state1+"&code="+code1+"&keeper="+keeper1+"&user="+user1+"&ghostyear="+ghostyear1+"&type1="+type6+"&type2="+type7+"&type3="+type8+"&type4="+type9+"&type5="+type10+"&purchasetime="+purchasetime1+"&makecardtime="+makecardtime1+"&startusetime"+startusetime1+"&value="+value1+"&abortpurchasetime="+abortpurchasetime1+"&abortmakecardtime="+abortmakecardtime1+"&abortstartusetime="+abortstartusetime1+"&abortvalue="+abortvalue1;
		<%-- $.ajax({ 				
		     type:"POST", //表单提交类型 
		     url:"<%=basePath%>adminassetcheckdataexportcontroller/exportassetcheckdatatotext.htm", //表单提交目标 
		     data:{usestate:usestate1,name:name1,keepdepartment:keepdepartment1,usedepartment:usedepartment1,isbegin1:isbegin2,state:state1,code:code1,keeper:keeper1,user:user1,ghostyear:ghostyear1,type1:type6,type2:type7,type3:type8,type4:type9,type5:type10,purchasetime:purchasetime1,makecardtime:makecardtime1,startusetime:startusetime1,value:value1,abortpurchasetime:abortpurchasetime1,abortmakecardtime:abortmakecardtime1,abortstartusetime:abortstartusetime1,abortvalue:abortvalue1}, //表单数据
		     success:function(e){
		    	 //alert(e)
		     var  data = eval("("+e+")");
		      if(data.status != ''&&data.status!=null){//msg 是后台调用action时，你穿过来的参数
		      	var filepath="导出成功，请先到桌面中查找assetcheckdata.txt文件再进行盘点数据导入";
		       		alert(filepath);
		      		
		      }else{
				alert("写入失败！");
		      }
		     }
		    }); 	 --%>
	}
		
		
		<%-- function exportdata() {

		var selectkey1=document.getElementById("selectkey").value;
		var selectvalue1=document.getElementById("selectvalue").value;
		var usestate1=document.getElementById("usestate").value;
		var state1=document.getElementById("state").value;
		
		$.ajax({ 
			
		     type:"POST", //表单提交类型 
		     url:"<%=basePath%>adminassetcheckdataexportcontroller/exportassetcheckdatatotext.htm", //表单提交目标 
		     data:{selectkey:selectkey1,selectvalue:selectvalue1,usestate:usestate1,state:state1}, //表单数据
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
	} --%>
		
	
	</script>
	
	
</head>
<body>
	<div class="container-f">
	 	<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a
					href="<%=basePath%>adminassetcheckdataexportcontroller/getassetspageshow.htm">
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
		<div class="box-content clearfix">
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a style="margin-top:10px;margin-left:4px;"  id="Btn"  class="btn btn-primary"  href="<%=basePath%>adminassetcheckdataexportcontroller/getassetspageshow.htm"> <i class="fa"></i><span>返回</span></a>
					</div>
				</div>
				<div class="control-group f_l" style="float:right;">
					<div class="f_l">
						<a style="margin-top:10px;margin-left:4px;" id="exportBtn" class="btn cf" href="javascript:void(0);" onclick="exportdata()"> <i class="fa fa-edit"></i><span>导出</span></a>
					</div>
				</div>
			</div>	
		</div>
		<div style="margin-top:10px;" id="list">
		
		<fieldset>
		<legend>查询结果</legend>
		<c:if test="${not empty assets }">
		<table  class="table-hover dataTable">
				<tr>
					<th style="background-color:#eee;width:6%">序号</th>
					<th style="background-color:#eee;width:15%;">资产代码</th>
					<th style="background-color:#eee;">资产名称</th>
					<th style="background-color:#eee;">使用人</th>
					<th style="background-color:#eee;">使用部门</th>
					<th style="background-color:#eee;">保管人</th>
					<th style="background-color:#eee;">保管部门</th>
					<th style="background-color:#eee;">使用状态</th>
				</tr>
				<c:forEach items="${assets }" var="asset" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${asset. code}</td>				
					<td>${asset.name }</td>
					<td>${asset.user }</td>
					<td>${asset.usedepartment }</td>
					<td>${asset.keeper }</td>
					<td>${asset.keepdepartment }</td>
					<td>${asset.usestate }</td>
				</tr>
				
				</c:forEach>							
			</table>
		<cc:page value="${pager}"
			url="adminassetcheckdataexportcontroller/getassetcheckresultwithpage.htm?usestate=${assetCustom.usestate }&name=${assetCustom.name }&keepdepartment=${assetCustom.keepdepartment }&usedepartment=${assetCustom.usedepartment }&isbegin1=${ assetCustom.isbegin1}&state=${assetCustom.state }&code=${assetCustom.code }&keeper=${assetCustom.keeper }&user=${assetCustom.user }&ghostyear=${assetCustom.ghostyear }&type1=${assetCustom.type1 }&type2=${assetCustom.type2 }&type3=${assetCustom.type3 }&type4=${assetCustom.type4 }&type5=${assetCustom.type5 }&purchasetime=${assetCustom.purchasetime }&makecardtime=${assetCustom.makecardtime }&startusetime=${assetCustom.startusetime }&value=${assetCustom.value }&abortpurchasetime=${assetCustom.abortpurchasetime }&abortmakecardtime=${assetCustom.abortmakecardtime }&abortstartusetime=${assetCustom.abortstartusetime }&abortvalue=${assetCustom.abortvalue }"></cc:page>
	
		</c:if>
		<c:if test="${empty assets }">
				暂无符合条件的数据
			</c:if>
			
		
			<!-- <div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div> -->
		</fieldset>
		</div>
	</div>
	<input type="hidden" id="condition" usestate="${assetCustom.usestate }" name="${assetCustom.name }" keepdepartment="${assetCustom.keepdepartment }" usedepartment="${assetCustom.usedepartment }" isbegin1="${ assetCustom.isbegin1}" state="${assetCustom.state }" code="${assetCustom.code }" keeper="${assetCustom.keeper }" user="${assetCustom.user }" ghostyear="${assetCustom.ghostyear }" type1="${assetCustom.type1 }" type2="${assetCustom.type2 }" type3="${assetCustom.type3 }" type4="${assetCustom.type4 }" type5="${assetCustom.type5 }" purchasetime="${assetCustom.purchasetime }" makecardtime="${assetCustom.makecardtime }" startusetime="${assetCustom.startusetime }" value="${assetCustom.value }" abortpurchasetime="${assetCustom.abortpurchasetime }" abortmakecardtime="${assetCustom.abortmakecardtime }" abortstartusetime="${assetCustom.abortstartusetime }" abortvalue="${assetCustom.abortvalue }">
	
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
    <%-- <script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script> --%>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	
	<script type="text/javascript">
		$('.pagination').pagination(100,{
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
					
					if(inputpage>totalPage){
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
	</script>
	 <!--<div class="font">
	<cc:page  value="${pager }"  url="${basePath}admincheckresultmanagecontroller/getassetdetailbyresultnumwithpage.htm?resultnum=${resultnum}"></cc:page>
	</div>-->
	
	<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		
		window.onload=function(){
			document.getElementById("exportBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		}		
		</script>	
	</shiro:hasPermission>
	
</body>
</html>
	