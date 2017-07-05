<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
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
    
    <title>消息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/input.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
	<style type="text/css">
		table tr td{
			width:100px;
			height:50px;
			font-size: 12px;
		}
		body{
			min-width: 1080px;
		}
		#list > table tr td{
			height:30px;
			font-size: 15px;
			text-align: center;
		}
		#list > table tr th{
			height:30px;
			font-size: 15px;
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
	
	</script>
	
</head>
<body onload="load()">
	<div class="container-f">
		 <div class="box-title clearfix tab-title">
			<h3>
				<a href="<%=basePath%>adminmessagecontroller/getsendmessagepageoffinancialmanagement.htm?depcode=${depcode }">
							<span class="fa fa-table"></span>
				发送通知
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath%>adminmessagecontroller/getacceptmessagepageoffinancialmanagement.htm?depcode=${depcode}">
				<span class="fa fa-bar-chart-o"></span>
				查看通知列表
				</a>
			</h3>
		</div> 
		<div class="box-content clearfix" style="padding:10px 5px;">
			<fieldset>
				<legend><span style="font-size:14px;">查询条件</span></legend>
				<table style="width:100%;">
					<tr>
						<td align="right"><h3>消息标题：</h3></td>
						<td><input type="text" class="in" name="msgtitle" id="msgtitle"></td>
						<td style="" align="right"><h3>发送人：</h3></td>
						<td width="250px">
							<select class="easyui-combobox" name="sendpeople" id="sendpeople" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							</select>
						</td>
						<td align="right"><h3>状态：</h3></td>
						<td width="250px">
							<select class="easyui-combobox" name="status" id="status" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value="">全部</option>
								<option value='true'>已读/已处理完毕</option>
								<option value='false'>未读/未处理完毕</option>
							</select>
						</td> 
						<td align="right" style=""><h3>所属部门：</h3></td>
						<td width="250px">
							<select class="easyui-combobox" name="senddepartment" id="senddepartment" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">

							</select>
						</td>
						<td>
							<a href="javascript:void(0)" class="btn" rel="tooltip" title="查询" id="btncheck" onclick="findmsg()" style="height:20px;padding-top:5px;margin-left:17px;">
								<i class="fa fa-search"></i>查询
							</a>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div style="margin-top:10px;padding:10px 5px;" id="list">
			<fieldset>
				<legend><span style="font-size:14px;">消息列表</span></legend>
				<table  class="table-hover dataTable">
					<tr style="height:50px;">
						<th style="background-color:#eee;">序号</th>
						<th style="background-color:#eee;">消息标题</th>
						<th style="background-color:#eee;">发送人</th>
						<th style="background-color:#eee;">发送时间</th>
						<th style="background-color:#eee;">所属部门</th>
						<th style="background-color:#eee;">状态</th>
						<th style="background-color:#eee;width:20%;">操作</th>
					</tr>
					<c:forEach items="${tMessageListWithMobilizePeoplesList }" var="messageListwithmobilize" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${messageListwithmobilize.title}</td>
						<td>${messageListwithmobilize.sendpeople}</td>
						<td><fmt:formatDate value="${messageListwithmobilize.sendtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${messageListwithmobilize.senddepname}</td>
						<td>
						<c:if test="${messageListwithmobilize.mark=='1'}">
						<c:if test="${messageListwithmobilize.status==true}">已处理完毕</c:if> 
						<c:if test="${messageListwithmobilize.status==false}">未处理完毕</c:if>
						</c:if>
						<c:if test="${messageListwithmobilize.mark=='0'}">
						<c:if test="${messageListwithmobilize.status==true}">已读</c:if> 
						<c:if test="${messageListwithmobilize.status==false}">未读</c:if>
						</c:if>
						</td>
						<td>
							<a  id="chakan" msg-mark="${messageListwithmobilize.mark }" msg-sid="${messageListwithmobilize.sid}" href="javascript:void(0)" class="btn findbtn" style="height:20px;padding-top:5px;">
								<i class="fa fa-search"></i>查看
							</a>
							<a id="deletemsg" msg-mark="${messageListwithmobilize.mark }" msg-sid="${messageListwithmobilize.sid}" class="btn deletebtn" style="height:20px;padding-top:5px;">
								<i class="fa fa-times"></i>删除
							</a>
						</td>
					</tr>
					</c:forEach>

				</table>
				<div class="pagination ue-clear" style="margin-top:10px;margin-bottom:10px;"></div>
					<c:if test="${tMessageListWithMobilizePeoplesList==null}">
			                   <br/>
			     &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp 暂无数据
			     			<br/><br/>
			</c:if>
				<c:if test="${tMessageListWithMobilizePeoplesList.size()==0 }">
			                   <br/>
			     &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp 暂无数据
			     			<br/><br/>
			</c:if>	
	<cc:page url="${basePath}adminmessagecontroller/findacceptmessagepageoffinancialmanagementbycondition.htm?depcode=${depcode }&status=${status }&title=${title }&sendpeople=${sendpeople }&senddepname=${senddepname }" value="${pager}" />
			</fieldset>
		</div>
	</div>
		<input type="hidden" id="depcode" name="depcode" value="${depcode }"/>
		<input type="hidden" id="currentPage" name="currentPage" value="${pager.currentPage }"/>
		<input type="hidden" id="pretitle" value="${title }"/>
		<input type="hidden" id="presendpeople" value="${sendpeople }"/>
		<input type="hidden" id="prestatus" value="${status }"/>
		<input type="hidden" id="presenddepname" value="${senddepname }"/>
		
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	<script>
	//初始页面中的查询条件的加载
	function load(){//在加载完成后将combobox的默认选项设置为先前的条件，若第一次访问则设置成为默认用户名
		var pretitle=document.getElementById("pretitle").value;
		var presendpeople=document.getElementById("presendpeople").value;
		var prestatus=document.getElementById("prestatus").value;
		var presenddepname=document.getElementById("presenddepname").value;
		//title
		document.getElementById("msgtitle").value=pretitle;
		//状态
		$('#status').combobox('select',prestatus);
		//发送人
      	 $('#sendpeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminmessagecontroller/getallusername.htm',
      		    valueField:'username', //设置combobox的value
      		    textField:'username',//设置combobox显示的text
      		    editable:true
      		    });
      		$('#sendpeople').combobox('select',presendpeople);
      	//发送人所属 部门	
      	$('#senddepartment').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminusermanagercontroller/getdepjson.htm',
      		    valueField:'depnametext', //设置combobox的value
      		    textField:'depnametext',//设置combobox显示的text
      		    editable:true//在此处是不能够添加部门的
      		    });
			$('#senddepartment').combobox('select',presenddepname);
	}
	//进行查询操作
	function findmsg(){
	 var title=document.getElementById("msgtitle").value;
	 var sendpeople= $('#sendpeople').combobox('getValue');
	 var status= $('#status').combobox('getValue');
	 var senddepname= $('#senddepartment').combobox('getValue');
	 var depcode=document.getElementById("depcode").value;
	 location.href="<%=basePath%>adminmessagecontroller/findacceptmessagepageoffinancialmanagementbycondition.htm?depcode="+depcode+"&status="+status+"&title="+title+"&sendpeople="+sendpeople+"&senddepname="+senddepname;
	}
	//查询通知的详情
	$(function(){
	    	$(".findbtn").click(function(){
	    	var mark=$(this).attr("msg-mark");//取出辨识其是通知单还是普通通知的mark
	    	var id=$(this).attr("msg-sid");//取出其在对应表中的id
	    	
			var pretitle=document.getElementById("pretitle").value;
			var presendpeople=document.getElementById("presendpeople").value;
			var prestatus=document.getElementById("prestatus").value;
			var presenddepname=document.getElementById("presenddepname").value;

	    	var currentPage=document.getElementById("currentPage").value;
			var depcode=document.getElementById("depcode").value;
	       	if(mark==true){//去查看t_mobilizepeople表
	       		location.href="<%=basePath%>adminmessagecontroller/getpersonchangesdetailpageoffinancialmanagement.htm?depcode="+depcode+"&id="+id+"&currentPage="+currentPage+"&status="+prestatus+"&title="+pretitle+"&sendpeople="+presendpeople+"&senddepname="+presenddepname;
	       	}else{//去查看普通通知表
	       		location.href="<%=basePath%>adminmessagecontroller/getacceptmessagedetailpageoffinancialmanagement.htm?depcode="+depcode+"&id="+id+"&currentPage="+currentPage+"&status="+prestatus+"&title="+pretitle+"&sendpeople="+presendpeople+"&senddepname="+presenddepname;
	       	}
	    	});
	    });
	    //删除对应的通知
	    	$(function(){
	    	$(".deletebtn").click(function(){
	    	var co=confirm('确定删除？');
	    	if(co==true){
	    	var mark=$(this).attr("msg-mark");//取出辨识其是通知单还是普通通知的mark
	    	var id=$(this).attr("msg-sid");//取出其在对应表中的id
	    	
			var pretitle=document.getElementById("pretitle").value;
			var presendpeople=document.getElementById("presendpeople").value;
			var prestatus=document.getElementById("prestatus").value;
			var presenddepname=document.getElementById("presenddepname").value;

	    	var currentPage=document.getElementById("currentPage").value;
			var depcode=document.getElementById("depcode").value;
	       	if(mark==true){//去查看t_mobilizepeople表
	       		$.ajax({ 
					     	type:"POST", //表单提交类型 
					    	 url:'<%=basePath%>adminmessagecontroller/deletepeoplechangemessageoffinancialmanagement.htm', 
					     	data:{id:id,currentPage:currentPage,depcode:depcode,title:pretitle,sendpeople:presendpeople,senddepname:presenddepname,status:prestatus}, //表单数据
					  		success:function(e){
						 	 var  data = eval("("+e+")");
					      	if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
					       		alert(data.msg);
					       		if(data.issubcurrentPage == 'ok'){
					      		 location.href="<%=basePath%>adminmessagecontroller/findacceptmessagepageoffinancialmanagementbycondition.htm?depcode="+depcode+"&status="+prestatus+"&title="+pretitle+"&sendpeople="+presendpeople+"&senddepname="+presenddepname+"&currentPage=${pager.currentPage-1}";
					     	 	}else{
					     	 	  location.href="<%=basePath%>adminmessagecontroller/findacceptmessagepageoffinancialmanagementbycondition.htm?depcode="+depcode+"&status="+prestatus+"&title="+pretitle+"&sendpeople="+presendpeople+"&senddepname="+presenddepname+"&currentPage=${pager.currentPage}";
					     	 	}
					     	 }else{
								alert(data.msg);
					     	 }
					     }
				    }); 
	       	}else{//去查看普通通知表
	       		$.ajax({ 
					     	type:"POST", //表单提交类型 
					    	 url:'<%=basePath%>adminmessagecontroller/deleteacceptmessagepageoffinancialmanagement.htm', 
					     	data:{id:id,currentPage:currentPage,depcode:depcode,title:pretitle,sendpeople:presendpeople,senddepname:presenddepname,status:prestatus}, //表单数据
					  		success:function(e){
						 	 var  data = eval("("+e+")");
					      	if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
					       		alert(data.msg);
					       		if(data.issubcurrentPage == 'ok'){
					      		 location.href="<%=basePath%>adminmessagecontroller/findacceptmessagepageoffinancialmanagementbycondition.htm?depcode="+depcode+"&status="+prestatus+"&title="+pretitle+"&sendpeople="+presendpeople+"&senddepname="+presenddepname+"&currentPage=${pager.currentPage-1}";
					     	 	}else{
					     	 	  location.href="<%=basePath%>adminmessagecontroller/findacceptmessagepageoffinancialmanagementbycondition.htm?depcode="+depcode+"&status="+prestatus+"&title="+pretitle+"&sendpeople="+presendpeople+"&senddepname="+presenddepname+"&currentPage=${pager.currentPage}";
					     	 	}
					     	 }else{
								alert(data.msg);
					     	 }
					     }
				    }); 
	       	}
	       	}
	    	});
	    });

	function checkmsg(id){
	var currentPage=document.getElementById("currentPage").value;
	var depcode=document.getElementById("depcode").value;
	location.href="<%=basePath%>adminmessagecontroller/getacceptmessagedetailpageofusedepartment.htm?depcode="+depcode+"&id="+id+"&currentPage="+currentPage;
	}
	$('.dataTable tr:even').css('background','#F3F3F3');
	$('.dataTable tr:odd').css('background','#ffffff');
	</script>
	
</body>
</html>