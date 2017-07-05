<i><%@page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/pageuri" prefix="cc"%>
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
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome/css/font-awesome.css">
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
		span,legend,a,.pxofy{font-style:normal;}
	</style>
	<script type="text/javascript">
	   //跳转页面的js
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
	
	</script>
	
	<script type="text/javascript">
		function inprotmethod() {
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
			
			//var assetCustom = "${assetCustom}";
			location.href = "<%=basePath%>adminasset/getassetcheckresultoutput.htm?usestate="+usestate1+"&name="+name1+"&keepdepartment="+keepdepartment1+"&usedepartment="+usedepartment1+"&isbegin1="+isbegin2+"&state="+state1+"&code="+code1+"&keeper="+keeper1+"&user="+user1+"&ghostyear="+ghostyear1+"&type1="+type6+"&type2="+type7+"&type3="+type8+"&type4="+type9+"&type5="+type10+"&purchasetime="+purchasetime1+"&makecardtime="+makecardtime1+"&startusetime"+startusetime1+"&value="+value1+"&abortpurchasetime="+abortpurchasetime1+"&abortmakecardtime="+abortmakecardtime1+"&abortstartusetime="+abortstartusetime1+"&abortvalue="+abortvalue1;
			
			<%-- $.ajax({ 
			
		    type:"POST", //表单提交类型 
		     url:"<%=basePath%>adminasset/getassetcheckresultoutput.htm", //表单提交目标 
		     data:{usestate:usestate1,name:name1,keepdepartment:keepdepartment1,usedepartment:usedepartment1,isbegin1:isbegin2,state:state1,code:code1,keeper:keeper1,user:user1,ghostyear:ghostyear1}, //表单数据
		     success:function(e){
		    	 //alert(e)
		     var  data = eval("("+e+")");
		      if(data.status == '0'){//msg 是后台调用action时，你穿过来的参数
		       		alert("提交失败！");
		      		
		      }else{
				alert("提交成功！");
		      }
		     }
		    });  --%>
			
			
			
			
			
			
		}
	
	
	</script>
	
	
</head>
<body>
	<div class="container-f">
	 	<div class="box-title clearfix tab-title">
			<h3>
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
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a style="margin-top:10px;margin-left:4px;" id="Btn" class="btn btn-primary" href="<%=basePath%>adminasset/showassetoutput.htm"> <i class="fa"></i><span>返回</span></a>
					</div>
				</div>
				<div class="control-group f_l" style="float:right;">
					<div class="f_l">
					<!-- onclick="inprotmethod()" -->
						<a style="margin-top:10px;margin-left:4px;" onclick="inprotmethod()" id="exportBtn" class="btn cf" href="javascript:void(0)"> <i class="fa fa-edit"></i><span>导出</span></a>
					</div>
				</div>
			</div>	
		</div>
		<div style="margin-top:10px;" id="list">
		<fieldset>
		<legend>查询结果</legend>
		<c:if test="${not empty assets }">
		<table class="table-hover dataTable">
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
					<td>${asset.code}</td>				
					<td>${asset.name }</td>
					<td>${asset.user }</td>
					<td>${asset.usedepartment }</td>
					<td>${asset.keeper }</td>
					<td>${asset.keepdepartment }</td>
					<td>${asset.usestate }</td>
				</tr>
				
				</c:forEach>							
			</table>
			<input type="hidden" id="condition" usestate="${assetCustom.usestate }" name="${assetCustom.name }" keepdepartment="${assetCustom.keepdepartment }" usedepartment="${assetCustom.usedepartment }" isbegin1="${ assetCustom.isbegin1}" state="${assetCustom.state }" code="${assetCustom.code }" keeper="${assetCustom.keeper }" user="${assetCustom.user }" ghostyear="${assetCustom.ghostyear }" type1="${assetCustom.type1 }" type2="${assetCustom.type2 }" type3="${assetCustom.type3 }" type4="${assetCustom.type4 }" type5="${assetCustom.type5 }" purchasetime="${assetCustom.purchasetime }" makecardtime="${assetCustom.makecardtime }" startusetime="${assetCustom.startusetime }" value="${assetCustom.value }" abortpurchasetime="${assetCustom.abortpurchasetime }" abortmakecardtime="${assetCustom.abortmakecardtime }" abortstartusetime="${assetCustom.abortstartusetime }" abortvalue="${assetCustom.abortvalue }">
			
		<cc:page value="${pager}" url="adminasset/getassetcheckresultoutputwithpage.htm?usestate=${assetCustom.usestate }&amp;name=${assetCustom.name }&amp;keepdepartment=${assetCustom.keepdepartment }&amp;usedepartment=${assetCustom.usedepartment }&amp;isbegin1=${ assetCustom.isbegin1}&amp;state=${assetCustom.state }&amp;code=${assetCustom.code }&amp;keeper=${assetCustom.keeper }&amp;user=${assetCustom.user }&amp;ghostyear=${assetCustom.ghostyear }&amp;type1=${assetCustom.type1 }&amp;type2=${assetCustom.type2 }&amp;type3=${assetCustom.type3 }&amp;type4=${assetCustom.type4 }&amp;type5=${assetCustom.type5 }&amp;purchasetime=${assetCustom.purchasetime }&amp;makecardtime=${assetCustom.makecardtime }&amp;startusetime=${assetCustom.startusetime }&amp;value=${assetCustom.value }&amp;abortpurchasetime=${assetCustom.abortpurchasetime }&amp;abortmakecardtime=${assetCustom.abortmakecardtime }&amp;abortstartusetime=${assetCustom.abortstartusetime }&amp;abortvalue=${assetCustom.abortvalue }" />
	
		</c:if>
		<c:if test="${empty assets }">
				暂无符合条件的数据
			</c:if>
			
			<!-- <div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div> -->
		</fieldset>
		</div>
	</div>
	
	
	
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
    <%-- <script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script> --%>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	
	<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		
		window.onload=function(){
			document.getElementById("exportBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		}		
		</script>	
	</shiro:hasPermission>
	
	
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
		
		<%-- $("#exportBtn").click(function(){
  			var assetCustom = "${assetCustom}";
  			alert(assetCustom);
  			//alert("click");
  			location.href="<%=basePath%>adminasset/assetexport.htm?assetCustom='${assetCustom}'";
  			$.post(
  				'<%=basePath%>adminasset/getassetcheckresultoutput.htm',
  				{assetCustom:assetCustom},
  				function(data){
  					if(data.status=='ok'){
  						alert(data.msg);
  						
  					}else{
  						alert(data.msg);
  					}
  				},
  				'json'
  			);
  			//output(category,text,usestate,state);
  		}); --%>
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
		
		
	</script>
	 <!--<div class="font">
	<cc:page  value="${pager }"  url="${basePath}admincheckresultmanagecontroller/getassetdetailbyresultnumwithpage.htm?resultnum=${resultnum}"></cc:page>
	</div>-->
</body>
</html>
	</i>