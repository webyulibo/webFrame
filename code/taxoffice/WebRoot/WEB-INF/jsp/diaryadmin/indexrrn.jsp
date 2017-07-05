<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@	taglib uri="/pageuri" prefix="cc" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/bootstrap.min.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
  </head>
  <body onload="load()">
  	<form action="" class="form-horizontal ajax_form">
  	<div class="container-f">
  	  <div class="box-title clearfix tab-title">
  	  </div>
	<div class="box-content clearfix">
  	<div class="search">

  	 <fieldset>
  	  <legend>
  	 <span>日志查询</span>
  	 </legend>
  		<table>
  		<tr>
  		<td style="height:50px"><span>查询条件：</span></td>
  		<td style="height:50px">
  			<select class="easyui-combobox" id="condition1" editable=false name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px" >     
					<option value="operatorpeople">操作人 </option>  
					<option value="peopledep">操作人所属单位 </option>     
					<option value="operatorname">操作名称</option>     
					</select>    
  		</td>
  		<td style="padding-right: 80px;"><select class="easyui-combobox" id="condition2" name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">        
											</select>    </td>
  		
  		<td style="padding-right: 80px;"><a class="btn cf" onclick="findLog()" href="javascript:void(0)"><i class="fa fa-search "></i>查询 </a></td>
  		<td style="padding-right: 20px;"><a class="btn log-export cf" href="javascript:void(0)" onclick="logexport()"></i>导出 </a></td>
  		</tr>
  		</table>
  
  	</div>
  	</fieldset>
  	<fieldset  style="margin-top:30px;">
  	 <legend>
  	 <span style="font-weight: bold;font-size: 14px;">日志列表</span>
  	 </legend>
  	<div class="show tab-lbgl">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>序号</th>
  				<th>操作人</th>
  				<th>操作人所属单位</th>
  				<th>操作名称</th>
  				<th>操作时间</th>
  				<th>详细</th>
  			</tr>
  		<c:forEach items="${tLogsList }" var="tLog" varStatus="index">
  			<tr>
  				<td>${index.count}</td>
  				<td>${tLog.operatorpeople}</td>
  				<td>${tLog.peopledep}</td>
  				<td>${tLog.operatorname}</td>
  				<td><fmt:formatDate value="${tLog.operatortime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
  				<td>
					<a class="btn btnset" tlog-operatorrole="${tLog.operatorrole}"   tlog-operatorautho="${tLog.operatorautho}"  >查看</a>
				</td>
			</tr>
			</c:forEach>
  		</table>
  		<c:if test="${tLogsList.size()==0 }">
			                   <br/>
			     &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp 暂无数据
			     			<br/><br/>
			</c:if>	
  	</div>
  	<cc:page url="${basePath}adminlogcontroller/gettlogbyconditionwithpage.htm?condition=${condition }&text=${text }" value="${pager}" />
  	</div>
  	
  </fieldset>	
  	
 </div>
  	</form>
  	
  	
  		
  	<div class="modal fade" id="modalset">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l "><h3><i></i>查看详情</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<div class="show tab-lbgl">
						
						<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" id="modal_add" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									操作所属角色：
								</label>
								<div class="controls">
									<label class="control-label" id="operatorrole" style="width:200px;" for="web_bg">
									
								</label>
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									操作所属权限：
								</label>
								<div class="controls">
									<label class="control-label" id="operatorautho" for="web_bg">
									
								</label>
								</div>
							</div>
						</form>

  	
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						
						<a href="javascript:void(0)" class="btn btn-primary"  data-dismiss="modal">确定</a>
						
						<a href="javascript:void(0)" class="btn btn-primary"  data-dismiss="modal">取消</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" id="precondition" value="${condition }">
	<input type="hidden" id="pretext" value="${text }">
<script type="text/javascript"src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
		<script type="text/javascript"src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>

	<!-- 显示详细的模态框内容的赋值 -->
	<script>
		$(".btnset").click(function(){
		var operatorrole=$(this).attr("tlog-operatorrole");
		var operatorautho=$(this).attr("tlog-operatorautho");
		document.getElementById("operatorrole").innerText=operatorrole;
		document.getElementById("operatorautho").innerText=operatorautho;
		$("#modalset").modal("toggle");
		});
	</script>
		<!-- 根据第一个的查询条件，远程绑定第二个combobox中的数据 -->
	<script>
	$('#condition1').combobox({  
        onSelect:function(){  
       	 var condition= $('#condition1').combobox('getValue'); 
       	 $('#condition2').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
       		    url:'<%=basePath%>adminlogcontroller/getlogjson.htm?condition='+condition,
       		    valueField:'value', //设置combobox的value
       		    textField:'text',//设置combobox显示的text
       		    editable:true
       		    });
       	 } 
});  
	</script>
		<script>
	//进行查询操作
	function findLog(){
		var condition = $('#condition1').combobox('getValue');
		var text = $('#condition2').combobox('getValue');
		location.href="<%=basePath%>adminlogcontroller/findtlogbyconditionwithpage.htm?condition="+condition+"&text="+text;
	}
	//查询条件的回显
	function load(){//在加载完成后将combobox的默认选项设置为先前的条件，若第一次访问则设置成为默认用户名
		var precondition=document.getElementById("precondition").value;
		var pretext=document.getElementById("pretext").value;
		$('#condition1').combobox('select',precondition);
		/* $('#condition2').combobox('setValue','pretext').combobox('setText','pretext');
		$('#condition2').combobox('setValue','aaa').combobox('setText','aaa');
		$('#condition2').combobox('setValue','bbb').combobox('setText','bbb'); */
		 var condition= $('#condition1').combobox('getValue'); 
      	 $('#condition2').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminlogcontroller/getlogjson.htm?condition='+condition,
      		    valueField:'value', //设置combobox的value
      		    textField:'text',//设置combobox显示的text
      		    editable:true
      		    });
		$('#condition2').combobox('select',pretext);
	}
	</script>
	<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		//设置导出按钮权限
		 $(".log-export").attr("onclick","alert('权限不足，无法进行此操作')");
		</script>	
</shiro:hasPermission>
	<script>
	function logexport(){
	var co=confirm('确定导出当前查询条件下的日志信息？');
		if(co==true){
		var precondition=document.getElementById("precondition").value;
		var pretext=document.getElementById("pretext").value;
		location.href="<%=basePath%>adminlogcontroller/logexport.htm?condition="+precondition+"&text="+pretext;
	}
	}
	$('.dataTable tr:even').css('background','#F3F3F3');
	$('.dataTable tr:odd').css('background','#ffffff');
	</script>
  </body>
</html>
