<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@	taglib uri="/pageuri" prefix="cc" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>	
     <link rel="stylesheet" type="text/css"  href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" 
	href="<%=basePath %>Public/Css/bootstrap.min.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>

	  <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	  
	  <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	 <script type="text/javascript" src="<%=basePath%>kindeditor-4.1.7/kindeditor.js"></script>
	<script charset="utf-8" src="<%=basePath%>kindeditor-4.1.7/lang/zh_CN.js"></script>
	  <link rel="stylesheet" href="<%=basePath%>kindeditor-4.1.7/themes/default/default.css" />
	  	 <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	<style type="text/css">
	.table tr td{
			width:100px;
			height:50px;
			font-size:12px;
		}
 	.hr{
 		 border-bottom:1px solid #ddd; padding: 5px 3px 15px; min-height:30px
  		}
  	.container-f{min-width:80px}
  	.form-actions input{
			padding: 6px 12px;
		}
		.ke-upload-file{
			width:150px;
			cursor:pointer;
		}
		.ke-upload-area{
			margin-left:30px;
		}
		.ke-button-common{
			width:65px;
			line-height:0px;
		}
		.tabs{display:none;}
		.modal_save,.modal_giveUp{
			width:57px;
		}
		body{
			min-width:1000px;
		}
	</style>
  </head>
  <body onload="load()">
  <div class="container-f">
  	<div class="hr"></div>
 	<br />
    <fieldset style="padding-bottom:15px;padding-top:17px;">
      <legend style="font-weight: bold;font-size: 14px;">用户查询</legend>
			<form id="subForm" method="post" action=" ">
				<div class="control-group f_l">
					<select class="easyui-combobox" id="condition1" editable=false name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px" >     
						<option value="useraccount">用户名 </option>  
						<option value="usercode">人员代码 </option>     
						<option value="username">人员姓名</option>     
						<option value="userdep">所属部门 </option>  
						<option value="userduty">职务 </option> 
						<option value="usertype">人员类别</option>     
						<option value="usersex">性别 </option>  
						<option value="userstate">状态 </option>
					</select>     
					<select class="easyui-combobox" id="condition2" name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">        
					</select>    
					<a class="btn cf" href="javascript:void(0)" onclick="findUser()">
						<i class="fa fa-search"></i><span>查询</span>
					</a>
				</div>
				<div  class="control-group f_l" style="float:right">
					<span style="font-size:14px;font-family: Arial,Helvetica,sans-serif;font-weight:bold;">导入人员信息：</span>
					<input type="text" style="height:25px;width:300px;margin-left:-5px;" autofocus style="input-xlarge"  id="app_file" name="resumename" value="" readonly="readonly" >
				 	<input type="hidden" class="input-xlarge" id="filename" name="resumeurl" value="" readonly="readonly"/> 
					<button type="button" class="btn add_app_file" id="selectBtn" style="width:115px;height:28px;padding-top:3px;padding-bottom:3px">选择文件</button>
				</div>
			</form>
		</fieldset>
<br />

	<shiro:hasPermission name="checkauth">
		
		<script type="text/javascript">
			$("#selectBtn").removeClass("add_app_file");
			//$("#selectBtn").
			document.getElementById("selectBtn").setAttribute("onclick", "alert('权限不足，不能执行此操作')")
			
		</script>
		
	
	</shiro:hasPermission>
	<fieldset>
		<legend style="font-weight: bold;font-size: 14px;">查询结果</legend>
		<table class="table-hover dataTable">
			<tr style="background: rgb(243, 243, 243) none repeat scroll 0% 0%;">
				<th style="background-color:#eee;">用户名</th>
				<th style="background-color:#eee;width:15%;">人员代码</th>
				<th style="background-color:#eee;">人员姓名</th>
				<th style="background-color:#eee;">所属部门</th>
				<th style="background-color:#eee;">职务</th>
				<th style="background-color:#eee;">人员类别</th>
				<th style="background-color:#eee;">性别</th>
				<th style="background-color:#eee;">状态</th>
				<th style="background-color:#eee;">设置权限</th>
				<th style="background-color:#eee;">操作</th>
		</tr>
		<c:forEach items="${tUserExtendsList }" var="userextend">
		<tr style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;">
				<td>${userextend.useraccount}</td>
				<td>${userextend.usercode}</td>
				<td>${userextend.username}</td>
				<td>${userextend.userdepString}</td>
				<td>${userextend.userduty}</td>
				<td>${userextend.usertype}</td>
				<td>${userextend.usersex}</td>
				<td>${userextend.userstate}</td>
				<td>
					<a user-id="${userextend.id}" user-role="${userextend.userrole}" class="btn btn-setrole btnset" >设置</a>
				</td>
				<td class="tab-td">
					<a href="${basePath}adminusermanagercontroller/showedituser.htm?id=${userextend.id}&precurrentPage=${pager.currentPage }&condition=${condition }&text=${text }" class="btn-editor btn"><i class="fa fa-edit"></i>修改</a>
					
				</td> 
		</tr>
	</c:forEach>
	</table>
	<c:if test="${tUserExtendsList.size()==0 }">
			                   <br/>
			     &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp 暂无数据
			     			<br/><br/>
			</c:if>	
	<cc:page url="${basePath}adminusermanagercontroller/getuserbyconditionwithpage.htm?condition=${condition }&text=${text }" value="${pager}" />
</fieldset>
<div class="modal fade" id="modalset">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i></i>请选择该员工角色</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" style="font-size:15px;"for="web_bg">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;角色：
								</label>
								
								<div class="controls">
								<input type="hidden" name="userid" id="userid" value="">
									<select class="easyui-combobox" name="state" id="userrole"  style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">		
									</select>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id">
						<input style="height:30px;" class="btn btn-primary modal_save" onclick="setuserrole()" data-dismiss="modal" value="确定">
						<input type="hidden" name="id">
						<input style="height:30px;"  class="btn btn-primary modal_giveUp" data-dismiss="modal" value="取消">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<input type="hidden" id="precondition" value="${condition }">
	<input type="hidden" id="pretext" value="${text }">
	<input type="hidden"  value="${meg}"  id="meg">
	<script>
	KindEditor.ready(function(K) {
		var editor = K.editor({
			allowFileManager: true ,
			uploadJson : 'kindeditor-4.1.7/jsp/upload_json.jsp',
			fileManagerJson : 'kindeditor-4.1.7/jsp/file_manager_json.jsp',
	 	});
		
		K('button.add_app_file').click(function (e) {
			
		    $.ajax({
		        url:'${basePath}file/index.htm', /* 发送请求标记当前上传是文件 */
		        type:'GET',
		        data:'isfile=true',
		        success:function(e){
		        	/*弹出上传文件对话框*/
		        	editor.loadPlugin('image', function () {
						editor.plugin.imageDialog({
							 showRemote : false,
							clickFn: function (url, title, width, height, border, align) {
								$.ajax({
							        url:'${basePath}file/name.htm', //获得文件名称
							        type:'POST',
							        success:function(e){
							        	var  data = eval("("+e+")");
							        		$("#app_file").val(data.filename);
							        	}
								});
								
								
								$("#filename").val(url);
								editor.hideDialog();
								$(e.target).text("重新选择");
								//自动获取text中的路径，并展示页面信息
								var filepath = $("#filename").val();
								location.href="<%=basePath%>adminimportexcelcontroller/importuserlist.htm?filePath="+filepath;
								/* var filepath = $("#filename").val();
								alert(filepath); */
								/* location.href='${basePath}adminasset/showassetconvert.htm?filePath='+filepath; */
							}
							
						});
						

					});
		        	

		        }
		       }); //第一个ajax的括号
		       
		       
		});//K('button.add_app_file') 的括号

	});//KindEditor.ready的括号
	KindEditor.ready(function(K) {
		var editor = K.editor({
			allowFileManager: true,
			uploadJson : 'kindeditor-4.1.7/jsp/upload_json.jsp',
			fileManagerJson : 'kindeditor-4.1.7/jsp/file_manager_json.jsp',
		});	
		K('button.add_app_icon').click(function (e) {
				editor.loadPlugin('image', function () {
				editor.plugin.imageDialog({
					showRemote : false,
					allowImageUpload : true,/* 
					urlType:'domain', */
					clickFn: function (url, title, width, height, border, align) {

						$("#app_icon").val(url);
						$("#app_icon_src").show();
						$("#app_icon_src").attr("src",url);

						editor.hideDialog();
						$(e.target).text("重新选择");
					}
				});
			});
		});

	});
	
	
	//进行查询操作
	function findUser(){
		var condition = $('#condition1').combobox('getValue');
		var text = $('#condition2').combobox('getValue');
		location.href="<%=basePath%>adminusermanagercontroller/getuserbyconditionwithpage.htm?condition="+condition+"&text="+text;
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
      		    url:'<%=basePath%>adminusermanagercontroller/getuserjson.htm?condition='+condition,
      		    valueField:'value', //设置combobox的value
      		    textField:'text',//设置combobox显示的text
      		    editable:true
      		    });
		$('#condition2').combobox('select',pretext);
	}
	</script>
	<!-- 执行设置权限 -->
	<script type="text/javascript">
	function setuserrole(){
		var condition = $('#precondition').val();
		var text = $('#pretext').val();//取出本次的查询条件以备回显
		var Role = $('#userrole').combobox('getValue');
		var Id=document.getElementById("userid").value;
		 $.ajax({ 
		     type:"POST", //表单提交类型 
		     dataType: "html",
		     url:'<%=basePath%>adminusermanagercontroller/updateuserrole.htm', 
		     data:{userid:Id,role:Role}, //表单数据
		  success:function(e){
			  var  data = eval("("+e+")");
		      if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
		       		alert(data.msg); 
		    		location.href="<%=basePath%>adminusermanagercontroller/getuserbyconditionwithpage.htm?condition="+condition+"&text="+text;
		      }else{
				alert(data.msg);
		      }
			
		     }
		    });
		
	}
	</script>
	<!-- 根据第一个的查询条件，远程绑定第二个combobox中的数据 -->
	<script>
	$('#condition1').combobox({  
        onSelect:function(){  
       	 var condition= $('#condition1').combobox('getValue'); 
       	 $('#condition2').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
       		    url:'<%=basePath%>adminusermanagercontroller/getuserjson.htm?condition='+condition,
       		    valueField:'value', //设置combobox的value
       		    textField:'text',//设置combobox显示的text
       		    editable:true
       		    });
       	 } 
});  
	</script>
<!--根据每个用户的角色代码远程绑定combobox的数据 -->
	<script>
		$(function(){
	    	$(".btnset").click(function(){
	    	
	    	var id=$(this).attr("user-id");//设置model中的隐藏userid
	    	var rolecode=$(this).attr("user-role");//设置model中的隐藏userid
	       	 $('#userid').val(id); 
	     	
	    		$('#userrole').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
	    		    url:'<%=basePath%>adminusermanagercontroller/getuserrolejson.htm',
	    		    valueField:'id', //设置combobox的value
	    		    textField:'text',//设置combobox显示的text
	    		    editable:false,//将combobox置为不可输入状态
	    		    onLoadSuccess: function () { //onLoadSuccess	当远程数据加载成功时触发。
	                    var data = $('#userrole').combobox('getData');//getData 返回加载的数据。
	                    if (data.length > 0) {
	                        $('#userrole').combobox('select', rolecode);//data[0].id  代表选中第一项  根据需要自行设置 (如果不写此事件则默认选中空白)
	                    } 
	                }
	    		});
	        	$("#modalset").modal("toggle");
	        	$('#modalset').on('shown.bs.modal', function () {//此处是使焦点在输入框的最后的方法，注意是要在模态框显示之后再触发此事件
	        		var t=$('.textbox-text').eq(2).val();//需要注意的是此处输入框在combobox里面需要对其中的输入框进行赋值.eq()中的数字代表第几个combobox
	 				 $('.textbox-text').eq(2).val("").focus().val(t);//使用重新赋值重新聚焦的方法 
				});
	        	
	    	});
	    });/* 
		$("#btnset1").click(function(){
        	$("#modalset").modal("toggle");
    	}); */
	  
	</script>
<!-- 页面跳转操作 -->

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
	<script type="text/javascript">
	$(document).ready(function(){
		var meg=document.getElementById("meg").value;
		if(meg!=""){
			alert(meg);
		}
	});
	</script>
<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		//将设置权限
		for(var i=0;i<$(".btn-setrole").length;i++){
			$(".btn-setrole").removeClass("btnset");
		}
		$(".btn-setrole").click(function(){alert("权限不足，无法进行此操作");});

		//设置修改按钮权限
		 for (var i = 0; i < $(".btn-editor").length; i++) {
			//$(".btn-delete").click(function(){alert("权限不足，无法进行此操作")});
			$(".btn-editor").attr("href","javascript:void(0)");
		}
		 $(".btn-editor").click(function(){alert("权限不足，无法进行此操作");});
		</script>	
</shiro:hasPermission>
			<script type="text/javascript">
			$('.dataTable tr:even').css('background','#F3F3F3');//注意此处的table同load事件冲突，所以此处将table.js直接写到这
			$('.dataTable tr:odd').css('background','#ffffff');
		</script>
</body>
</html>
