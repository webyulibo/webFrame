<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/bootstrap.min.css" />
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
 	<script type="text/javascript" src="<%=basePath%>kindeditor-4.1.7/kindeditor.js"></script>
	<script charset="utf-8" src="<%=basePath%>kindeditor-4.1.7/lang/zh_CN.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/mydefault.css">
	 <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datebox.css"> 
  
	<script src="Public/Js/jquery-2.1.4.js" type="<%=basePath %>text/javascript"></script>
	<script src="Public/Js/jquery-1.11.1.js" type="<%=basePath %>text/javascript"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" href="<%=basePath%>kindeditor-4.1.7/themes/default/default.css" />
	<style type="text/css">
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
	</style>
  </head>
  <body>
    <div class="container-f">
  	 <div class="box-title clearfix tab-title">
			<h3 >
				<a href="<%=basePath %>adminasset/showassetmenu.htm">
				<span class="fa fa-table"></span>
				资产管理
				</a>
			</h3>
			<h3 class="current">
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
	<div>
	<span style="font-size:18px;font-family: Arial,Helvetica,sans-serif;font-weight:bold;">文件导入：</span>
	<%-- ${article.picurl } --%>
	<input type="text" style="height:25px;width:300px;margin-left:-5px;" autofocus style="input-xlarge"  id="app_file" name="resumename" value="" readonly="readonly" >
	 <input type="hidden" class="input-xlarge" id="filename" name="resumeurl" value="" readonly="readonly"/> 
	<button type="button" id="selectBtn" class="btn add_app_file" style="width:115px;height:28px;padding-top:3px;padding-bottom:3px">选择文件</button>
	<!-- <a href="javascript:void(0)" class="btn fbtn showbtn" style="padding-left:30px;padding-right:30px;margin-left:10%;">显示</a> -->
	<a  class="btn submitbtn" id="btnAdd" style="padding-left:30px;padding-right:30px;margin-left:10%;">提交数据</a>
	<!-- <a href="javascript:void(0)" class="btn" style="width:90px; padding-left:30px;padding-right:30px;margin-left:10%;" id="exportexcel">导出比对表格</a> -->
  </div>
  <div style="margin-top:80px"   >
	<table width="100%" class="dataTable">
		<tr>
			<th>序号</th>
			<th>资产代码</th>
			<th>资产名称</th>
			<th>资产类型</th>
			<th>规格型号</th>
			<th>使用人</th>
			<th>使用部门</th>
			
		</tr>
		<input id="list" value="${list}" type="hidden"/>
		<c:forEach items="${list }" var="asset" varStatus="s">
		<%-- <input id="ceshi" value="${asset.code}" type="hidden"> --%>
		<tr class="isExitRow">
		
			<td><c:out value="${s.count }"></c:out></td>
			<td>${asset.code }</td>
			<td>${asset.name }</td>
			<td>${asset.type }</td>
			<td>${asset.model }</td>
			<td>${asset.user }</td>
			<td>${asset.usedepartment }</td>
		
		</tr>
		</c:forEach>
	</table>
  </div>
 </div>
 <div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
 </div>
 
 <button id="modalbtn" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modaladd" style="display:none;">
  Launch demo modal
</button>
 
  	<div class="modal fade" id="modaladd">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-edit"></i>资产导入</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<h2 style="font-weight:bold;" for="web_bg">
								<input type="hidden" value="" id="codevalue">
								<div id="text">
								
									
								</div>
									
								</h2>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions" style="padding-bottom:40px;">
					<!-- data-dismiss="modal" -->
					<button type="button" id="none_display" class="btn btn-default" data-dismiss="modal" style="display:none">Close</button>
						<input type="hidden" name="id">
						<input class="btn btn-primary" type="button" style="float:left;left:5%;width:82px;height:34px;" name="judgebtn" value="跳过该条" id="skip">
						<input type="hidden" name="id">
						<input class="btn btn-primary" style="float:left;left:15%;width:82px;height:34px;" type="button" name="judgebtn"  value="全部跳过" id="skipall">
						<input type="hidden" name="id">
						<input class="btn btn-primary" style="float:left;left:25%;width:82px;height:34px;" type="button" name="judgebtn"  value="更新该条" id="update">
						<input type="hidden" name="id">
						<input class="btn btn-primary" style="float:left;left:35%;width:82px;height:34px;" type="button" name="judgebtn"  value="全部更新" id="updateall">
					</div>
				</div>
			</div>
		</div>
	</div>
 <script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(function(){
		
		$('.dataTable tr:even').css('background','#F3F3F3');
		$('.dataTable tr:odd').css('background','#ffffff');
		
	});
	
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
									
									location.href="<%=basePath%>adminasset/showassetconvert.htm?filePath="+filepath;
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
		
</script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#exportexcel").click(function(){
		
		var isExit=document.getElementsByClassName("isExitRow");
		
		if(parseInt(isExit.length)>0){
			var filepath = $("#filename").val();
		    if(filepath==null||filepath==""){
		    	filepath="${filepath}";
		    	
		    	
		    }
		    location.href="<%=basePath%>adminasset/outputexcel.htm?filePath="+filepath;	
		}
		else{
			alert("请先导入数据后，再执行此操作")
			return;
		}
		
	})
	
	
	
	 $('.submitbtn').click(function(){
		 var isExit=document.getElementsByClassName("isExitRow");
		 
		 if(parseInt(isExit.length)>0){
			 var filepath = $("#filename").val();	  	        
			    if(filepath==null||filepath==""){
			    	filepath="${filepath}";
			    	
			    }
				input(filepath);			 
		 }
		 else{
			 alert("请导入文件后再进行提交数据");
			 return;
		 }	
	}); 
	
	
	//弹出提示
	function alertSuccess(){
		setTimeout(function(){
			if(dataCount==codeList.length&&repeatCount==0){
				alert("提交成功！");
				//alert("abasdf")
			}
			dataCount=0;
			repeatCount=0;
		},1000)
	}
	
	
	var dataCount=0;//用来记录总条数
	var repeatCount=0;//用来记录是否有重复的数据
	function input(filepath){
	file = filepath;
	//codeList;
		$.post(
			'<%=basePath%>adminasset/inputasset.htm',
			{filePath:filepath},
			function(data){
			if(data.status == "no"){
				alert(data.msg);
				
			}else{
				
				codeList = data.codeList;
				path = filepath;
				check(path,codeList);
				/* for(var i=0;i<codeList.length;i++){
				debugger
					check(filepath,codeList[i]);
				} */
				alertSuccess();
				
			}
		},
		'json'
		);
	}
	
	monitor = 0;	//监控变量
	skipList = new Array();		//跳过代码
	updateList = new Array();	//更新代码
	
	function check(path,codeList){
			$("#text").html("该条资产："+codeList[monitor]+"已存在，是否更新?");
			$("#codevalue").val(codeList[monitor]);
			$("#modalbtn").click();
	}
	
	//跳过该条
	$("#skip").click(function(){
		var listSize = codeList.length;
		skipList.push(codeList[monitor]);
		if(monitor<listSize){
			monitor++;
			$("#text").html("该条资产："+codeList[monitor]+"已存在，是否更新?");
		}
		if(monitor == listSize){
			$("#none_display").click();
			monitor = 0;
			
			if(updateList!=null){
				var code = updateList[0];
			}
			var updateLength = updateList.length;
			for(var i = 1;i < updateLength;i++){
				code = code + "," + updateList[i];
			}
			$.ajaxSetup({
	    		async: true
	 		});
			$.post(
				'<%=basePath%>adminasset/modalAsset.htm',
				{filePath:file,code:code},
				function(data){
					if(data.status=="ok"){
						alert(data.msg);
	
					}else{
						alert(data.msg);
					}
				},
				'json'
			);
			updateList = [];
			skipList = [];
		}
	});
	//跳过全部
	$("#skipall").click(function(){
		var listSize = codeList.length;
		for(var i = monitor;i < listSize;i++){
			skipList.push(codeList[i]);
		}
		$("#none_display").click();
		monitor = 0;

		if(updateList!=null){
			var code = updateList[0];
		}
		
		var updateLength = updateList.length;
		for(var i = 1;i < updateLength;i++){
			code = code + "," + updateList[i];
		}
		$.ajaxSetup({
    		async: true
 		});
		$.post(
			'<%=basePath%>adminasset/modalAsset.htm',
			{filePath:file,code:code},
			function(data){
				if(data.status=="ok"){
					alert(data.msg);

				}else{
				debugger
					alert(data.msg);
				}
			},
			'json'
		);
		updateList = [];
		skipList = [];
	});
	//更新该条
	$("#update").click(function(){
		var listSize = codeList.length;
		updateList.push(codeList[monitor]);
		if(monitor<listSize){
			monitor++;
			$("#text").html("该条资产："+codeList[monitor]+"已存在，是否更新?");
		}
		if(monitor == listSize){
			$("#none_display").click();
			monitor = 0;
			
			if(updateList!=null){
				var code = updateList[0];
			}
			var updateLength = updateList.length;
			for(var i = 1;i < updateLength;i++){
				code = code + "," + updateList[i];
			}
			$.ajaxSetup({
	    		async: true
	 		});
			$.post(
				'<%=basePath%>adminasset/modalAsset.htm',
				{filePath:file,code:code},
				function(data){
					if(data.status=="ok"){
						alert(data.msg);
	
					}else{
						alert(data.msg);
					}
				},
				'json'
			);
			updateList = [];
			skipList = [];
		}
	});
	//更新全部
	$("#updateall").click(function(){
		var listSize = codeList.length;
		for(var i = monitor;i < listSize;i++){
			updateList.push(codeList[i]);
		}
		$("#none_display").click();
		monitor = 0;

		if(updateList!=null){
			var code = updateList[0];
		}
		var updateLength = updateList.length;
		for(var i = 1;i < updateLength;i++){
			code = code + "," + updateList[i];
		}
		$.ajaxSetup({
    		async: true
 		});
		$.post(
			'<%=basePath%>adminasset/modalAsset.htm',
			{filePath:file,code:code},
			function(data){
				if(data.status=="ok"){
					alert(data.msg);

				}else{
					alert(data.msg);
				}
			},
			'json'
		);
		updateList = [];
		skipList = [];
	});
	
	
	
	
	//=======================================舍弃开始=========================================
	<%-- var j=0;
	$("#skip").click(function(){
		
			if(j<codeList.length-1){
		
				//repeatCount++;
				j++;
				check(file,codeList[j]);
				
				
				
			}else if(j==codeList.length-1){
				
				alert("更新成功!");
				$("#none_display").click();
				j=0;
			}
				
		});
		
	
	function check(filepath,code){
	debugger
	
		dataCount++;
					$.ajaxSetup({
       					 async: true
    				});
					$.post(
						'<%=basePath%>adminasset/checkAssetCode.htm',
						{filePath:filepath,code:code},
						function(codedata){
							if(codedata.status=="ok"){
								repeatCount++;
								//alert(repeatCount);
								$("#text").html("该条资产："+codedata.code+"已存在，是否更新?");
								$("#codevalue").val(codedata.code);
								$("#modalbtn").click();
								$("body").removeClass("modal-open");
							}else{
								//dataCount++;
								$("#none_display").click();
							}
						},
						'json'
					);
					
	}
	
	
	
	$("#skipall").click(function(){
		//alert(codeList);
		//alert(file);
		
		var stringList=codeList[0]+"#";
		for(var i=1;i<codeList.length;i++){
			stringList = stringList+codeList[i]+"#";
			
		}
		//alert(stringList);
		skipall(file,stringList);
		$("#none_display").click();
	});
	
	function skipall(file,stringList){
	//alert(file);
	//alert("skipall");
	repeatCount++;
		$.ajaxSetup({
       		async: true
    	});
		$.post(
			'<%=basePath%>adminasset/skipallasset.htm',
			{filePath:file,stringList:stringList},
			function(codedata){
				if(codedata.status=="ok"){
					alert(codedata.msg);
				}
			},
			'json'
		);
	}
	
	$("#update").click(function(){
		/* var file = $("#filename").val();
	    if(file==null||file==""){
	    	file="${filepath}";
	    } */
	    
	   // alert("123");
	   var code = $("#codevalue").val();
		updateone(code,file);
		//$("#none_display").click();
		/* if(i<codeList.length){
			i++;
			check(file,codeList[i]);
		} */
	});
	
	
	function updateone(code,file){
	//alert(code);
	//repeatCount++;
		$.ajaxSetup({
       		async: true
    	});
		$.post(
			'<%=basePath%>adminasset/updateoneasset.htm',
			{code:code,filePath:file},
			function(codedata){
			//var codedata = eval("("+e+")");
				if(codedata.status=="ok"){
				//alert("status");
					/* $("#text").html("该条资产："+codedata.code+"已存在，是否更新?");
					$("#codevalue").val(codedata.code);
					$("#modaladd").modal("toggle");
					return; */
					if(j<codeList.length-1){
						j++;
						check(file,codeList[j]);
					}
					else if(j==codeList.length-1){
						//alert("提交成功");
						$("#none_display").click();
						j=0;
					}
					
					 
					
				}else{
					alert(codedata.msg);
				}
				/* if(codedata.status=="no"){
					alert(codedata.msg);
				} */
			},
			'json'
		);
	}
	
	
	$("#updateall").click(function(){
	//alert(codeList.length);
	
		var code = $("#codevalue").val();
		var stringList = codeList[0]+"#";
		for(var i=1;i<codeList.length;i++){
			stringList = stringList+codeList[i]+"#";
		}
		//alert(stringList);
		//var code = $("#codevalue").val();
		//alert(code);
		updateall(stringList,file,code);
		$("#none_display").click();
	});
	function updateall(stringList,file,code){
	//alert(stringList);
	//repeatCount++;
		$.ajaxSetup({
       		async: true
    	});
		$.post(
			'<%=basePath%>adminasset/updateallasset.htm',
			{stringList:stringList,filePath:file,code:code},
			function(codedata){
				//var codedata = eval("("+e+")");
				if(codedata.status=="ok"){
					alert(codedata.msg);
				}
			},
			'json'
		);
	} --%>
	//===================================舍弃结束=====================================
	
	<%-- $('.showbtn').click(function(){
	    var filepath = $("#filename").val();
		//alert(filepath);
		//input(filepath);
		location.href="<%=basePath%>adminasset/showassetconvert.htm?filePath="+filepath;
	}); --%>
	
	
	
	
	
	

 $("#sign").submit(function (){
	 /* if(!confirm('确认提交?')){
		 return false;
	 } */
    var ajax_url = "<%=basePath %>sign/dosign.htm"; //表单目标 
    var ajax_type = $(this).attr('method'); //提交方法 
    var ajax_data = $(this).serialize(); //表单数据
	
    $.ajax({ 
     type:ajax_type, //表单提交类型 
     url:ajax_url, //表单提交目标 
     data:ajax_data, //表单数据
     success:function(e){
     var  data = eval("("+e+")");
      if(data.status == '1'){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
      		 location.href="<%=basePath%>index.htm";
      }else{
		alert(data.msg);
      }
     }
    }); 
    return false; //阻止表单的默认提交事件 
    });
});

	$(document).ready(function(){
		$('#about li').click(function(){
			
			$(this).addClass('cur');
			$(this).siblings().removeClass('cur');
			var myid = $(this).attr('id');
			if(myid=='jianjie'){
				$('#fr').attr('src','jsp/front/textimglist.jsp');
			}
			else if(myid=='tixi'){
				$('#fr').attr('src','jsp/front/richtext.jsp');
			}
			else if(myid=='zhidu'){
				$('#fr').attr('src','jsp/front/richtext.jsp');
			}

		});
		$('#about li a').click(function(){
			$(this).siblings().toggle();
		});
		var wHeight = $(window).height();
		if($('.main').height()<wHeight){
			$('.main').height(wHeight);
		}

	});
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
</script>

	<shiro:hasPermission name="checkauth">
		
		<script type="text/javascript">
			$("#selectBtn").removeClass("add_app_file");
			$("#selectBtn").attr("onclick","alert('权限不足，无法进行此操作')");
			
		
		</script>
		
	
	</shiro:hasPermission>

  </body>
</html>
