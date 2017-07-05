<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<%@	taglib uri="/pageuri" prefix="cc" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/left.css" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css">
  	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
  	<script type="text/javascript" src="<%=basePath%>Public/Js/sdmenu.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
  </head>  
<body>
<div style="float: left" id="LeftMenu" class="sdmenu">
  
  <div id="navs">
   	<div id="navs_sub">    
   	
   			<div class="collapsed" name='menu_config' item='menu'> 
                <span>系统管理 
 					<i class="f_r fa fa-chevron-up"></i>
				</span> 
                <a class="all" href="<%=basePath%>adminusermanagercontroller/getuserbyconditionwithpage.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						用户管理       	
                 </a>
                 <a class="all" href="<%=basePath %>admindepartmentcontroller/getdepbyconditionwithpage.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						部门管理       	
                 </a>
                 <a class="all" href="<%=basePath %>AdminRoleController/index.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						权限管理       	
                 </a>
                 <a class="all" href="<%=basePath %>adminlogcontroller/gettlogbyconditionwithpage.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						日志管理       	
                 </a>
      		</div>
   	
	       <div class="collapsed" name='menu_config' item='menu'> 
                <span>资产管理
 					<i class="f_r fa fa-chevron-up"></i>
				</span> 
				<!-- <a class="all" href="javascript:void(0);" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产调入       	
                 </a> -->
                 <a class="all" href="<%=basePath%>AdminAssetLeadController/index.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产领用       	
                 </a>
                 <a class="all" href="<%=basePath %>AdminAssetBorrowController/index.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产借用归还       	
                 </a>
                 <a class="all" href="<%=basePath %>adminassetmaintaincontroller/index.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						故障鉴定与维修管理       	
                 </a>
                 <a class="all" href="<%=basePath%>AdminScrapController/index.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产报废处理       	
                 </a>
                  <a class="all" href="<%=basePath%>adminassetcheckdataexportcontroller/getassetspageshow.htm" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产盘点清查       	
                </a>
                 <!-- <a class="all" href="javascript:void(0);" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						闲置固定资产管理       	
                 </a> -->
                <!--  <a class="all" href="javascript:void(0);" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						固定资产处置管理       	
                 </a>  -->
                <!--  <a class="all" href="javascript:void(0);" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						固定资产变动登记       	
                 </a> -->
               
      		</div>
			<div class="collapsed" >
				<span>数据管理 <i class="f_r fa fa-chevron-up"></i></span>     
			   	<a class="all" href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	资产类别管理
		        </a>
		        <a class="all current" href="<%=basePath%>adminasset/showassetmenu.htm" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	资产管理	 
		        </a> 
		        <a class="all" href="<%=basePath%>AdminDbController/indexjyg.htm" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	数据备份与恢复
		        </a>
		        <!-- <a class="all" href="javascript:void(0)" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
						二维码管理
		        </a> -->
			</div>
			<div class="collapsed" >
				<span>信息通知 <i class="f_r fa fa-chevron-up"></i></span>   
				<c:if test="${userdepnameString=='机关生活服务中心' }"> 
				       <a class="all" href="<%=basePath%>adminmessagecontroller/getsendmessagepageofagencyservicecenter.htm?depcode=${userdepcode }" target="mainFrame">
			            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
			            	机关服务中心通知
			        	</a>
				 </c:if>	 
			   	 <c:if test="${userdepnameString=='人事教育科' }"> 
				        <a class="all" href="<%=basePath%>adminmessagecontroller/getsendmessagepageofpersonneldepartment.htm?depcode=${userdepcode }" target="mainFrame">
		            		<i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            			人事部门通知
		       			 </a> 
				 </c:if> 
		      	<c:if test="${userdepnameString=='财务管理科' }"> 
				        <a class="all" href="<%=basePath%>adminmessagecontroller/getsendmessagepageoffinancialmanagement.htm?depcode=${userdepcode }" target="mainFrame">
		            	<i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	财务管理科通知
		        		</a> 
				 </c:if>		
		          <c:if test="${userdepnameString!='机关生活服务中心'&&userdepnameString!='人事教育科'&&userdepnameString!='财务管理科'}">
				       <a class="all" href="<%=basePath%>adminmessagecontroller/getsendmessagepageofusedepartment.htm?depcode=${userdepcode }" target="mainFrame">
		           	   <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	使用部门通知
		       		   </a>
				 </c:if> 
		         
			</div>
		</div>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("LeftMenu");
		myMenu.init();
		menu_init();
	};
	// ]]>
	function menu_init()
	{
		$("#LeftMenu #navs_sub>div>a").each(
		function(index){
			if(!$(this).attr("href")||$(this).attr("href")=='')
			{
				alert("链接不存在！");
			}
			else
			{
				if($(this).next().attr("class")=='none')
				{
					$(this).bind("click",function(){
						$("#LeftMenu a").removeClass("current");
						$(this).addClass("current");
						var sub_menu = $(this).next();
						//$(this).attr("href","javascript:;");
						//$(parent.frames["mainFrame"].src) = $(this).attr("href");
						var mainframe = $(parent.frames["mainFrame"].document);
						if(mainframe.find(".top_menu").length ==0)
						{
							//var body_main = mainframe;							
							mainframe.find("body").css("overflow","hidden");
							
							var iframe = document.createElement('iframe');
							iframe.id = 'body_main';
							iframe.name = 'body_main';
							iframe.height= $(window.parent.frames["mainFrame"]).height()-40;
							iframe.width = "100%";
							iframe.frameBorder = "0";
							iframe.marginwidth='0';
							iframe.marginheight='0';
							
							//mainframe.find("body").html("<ul class='top_menu'>"+sub_menu.html()+"</ul>");
							
							//mainframe.find("body").append(iframe);
						}
						else
						{
							mainframe.find(".top_menu").html(sub_menu.html());
						}
						var body_right = mainframe.find("body");
						var top_menu = body_right.find(".top_menu");
						
						var thisHref = $(this).attr("href");
						
						
						top_menu.find("a").each(function(){
								$(this).click(function(){
									$(this).closest(".top_menu").find("li").removeClass("active");
									$(this).closest("li").addClass("active");
									
									//alert($(this).attr("href"));
									//$(this).closest("body").find("#body_main").attr("src",$(this).attr("href"));

									$(this).closest("body").find("#body_main").attr("src",thisHref);
									
									return false;
								});
							}
						);
						top_menu.find("a")[0].click();
						$(this).removeAttr("target");
						return false;
					});
				}
			/* 	else
				{
					//$(this).attr("href","javascript:;");
					$(this).bind("click",function(){
						
						return false;
					});
					$(this).removeAttr("target");
				} */
			}
		});
	}
	
	$("a").click(function(){
		for(var i=0;i<$("a").length;i++){
			$("a").removeClass("current");
			/* $("a").css({"backgroundColor":"#f1f1f1"}); */
		}
		$(this).addClass("current");
	});
	
	/*
	$("a").hover(function(){
		$(this).css("backgroundColor","white");
	},function(){
		$(this).css("backgroundColor","#f1f1f1");
	}); */
	
</script> 
</div>
</div>
</body>
</html>