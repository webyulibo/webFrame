<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </head>  
<body>
<div style="float: left" id="LeftMenu" class="sdmenu">
  
  <div id="navs">
   	<div id="navs_sub">    
   	
   			<div class="collapsed" name='menu_config' item='menu'> 
                <span>系统管理
 					<i class="f_r fa fa-chevron-up"></i>
				</span> 
                <a href="<%=basePath%>jsp/systemadmin/yhgllmt/yhgllmt.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						用户管理       	
                 </a>
                 <a href="<%=basePath%>jsp/dataadmin/bumenguanli/bmglqll.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						部门管理       	
                 </a>
                 <a href="<%=basePath%>jsp/systemadmin/propertymanage/showrolemanage.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						权限管理       	
                 </a>
                 <a href="<%=basePath%>jsp/diaryadmin/indexrrn.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						日志管理       	
                 </a>
      		</div>
   	
	       <div class="collapsed" name='menu_config' item='menu'> 
                <span>资产管理
 					<i class="f_r fa fa-chevron-up"></i>
				</span> 
                <a href="<%=basePath%>jsp/assetadmin/pandianqingcha/daochu/pdsjdczp.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产盘点清查       	
                 </a>
                  <a href="<%=basePath%>jsp/assetmaintain/assetmaintain.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						故障鉴定与维修管理       	
                 </a>
                 <a href="<%=basePath%>jsp/assetscrap/addscrap.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产报废处理 	
                 </a>
                  <a href="<%=basePath%>jsp/assetborrow/borrow/addborrow.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产借用归还	
                 </a>
                   <a href="<%=basePath%>jsp/assetadmin/zichanlingyong/zclyjyg.jsp" target="mainFrame"name="menu.action" item='action'>
                     <i class="fa fa-chevron-right"></i>&nbsp;&nbsp
						资产领用	
                 </a>
      		</div>
			<div class="collapsed" >
				<span>数据管理 <i class="f_r fa fa-chevron-up"></i></span>     
			   	<a href="<%=basePath%>jsp/dataadmin/leibieadmin/main/yjlxlbqjx.jsp" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	资产类别管理
		        </a>
		        <a href="<%=basePath%>jsp/dataadmin/assetadmin/admin/indexlmy.jsp" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	资产管理	 
		        </a> 
			</div>
			<div class="collapsed" >
				<span>信息通知 <i class="f_r fa fa-chevron-up"></i></span>     
			   	<a href="<%=basePath%>jsp/informationnotice/agencyservicecenter/index.jsp" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	机关服务中心通知
		        </a>
		        <a href="<%=basePath%>jsp/informationnotice/personneldepartment/index.jsp" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	人事部门通知
		        </a> 
		        <a href="<%=basePath%>jsp/informationnotice/financialmanagement/index.jsp" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	财务管理科通知
		        </a> 
		        <a href="<%=basePath%>jsp/informationnotice/informationcenter/index.jsp" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	信息中心通知
		        </a> 
		        <a href="<%=basePath%>jsp/informationnotice/usedepartment/index.jsp" target="mainFrame">
		            <i class="fa fa-chevron-right"></i>&nbsp;&nbsp 
		            	使用部门通知
		        </a> 
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
</script> 
</div>
</div>
</body>
</html>
