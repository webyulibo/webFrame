<%@ page contentType="text/html;charset=utf-8" language="java"
	import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>盘点结果导入</title>

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
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
 <script type="text/javascript" src="<%=basePath%>kindeditor-4.1.7/kindeditor.js"></script>
 <script charset="utf-8" src="<%=basePath%>kindeditor-4.1.7/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>kindeditor-4.1.7/kindeditor.js"></script>
	<script charset="utf-8" src="<%=basePath%>kindeditor-4.1.7/lang/zh_CN.js"></script>
	<link rel="stylesheet" href="<%=basePath%>kindeditor-4.1.7/themes/default/default.css" />
<style type="text/css">
		table tr td {
			width: 100px;
			height: 50px;
			font-size: 12px;
		}

		body {
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
			margin-top:20px;
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
</style>

<script type="text/javascript">
	
	function submit() {
		
		
		if(document.getElementById("tableinfo")==undefined){
			
			alert("提交失败，请导入数据后再进行提交！")
			return;
		} 
		
		var resultnum1=document.getElementById("resultnum").value;
		
		var checkpeople1=document.getElementById("checkpeople").value;
		
		var remark1=document.getElementById("remarkId").value;
		
				
		$.ajax({ 
			
		    type:"POST", //表单提交类型 
		     url:"<%=basePath%>adminassetcheckresultimportcontroller/importassetcheckresulttotext.htm", //表单提交目标 
		     data:{resultnum:resultnum1,checkpeople:checkpeople1,remark:remark1}, //表单数据
		     success:function(e){
		    	 //alert(e)
		     var  data = eval("("+e+")");
		      if(data.status == '0'){//msg 是后台调用action时，你穿过来的参数
		       		alert("提交失败！");
		      		
		      }else{
				alert("提交成功！");
		      }
		     }
		    }); 

		
	}

</script>


</head>

<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3>
				<a
										href="<%=basePath%>adminassetcheckdataexportcontroller/getassetsbyusestateandbyotherwithpage.htm">
					<span class="fa fa-table"></span> 盘点数据导出
				</a>
			</h3>
			<h3 class="current">
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
		<fieldset>
		
		<div class="clearfix">
			<div class="control-group f_l">
				<div class="f_l">
					<div style="margin-left:4%">
						<span style="font-size:12px;font-family: Arial,Helvetica,sans-serif;font-weight:bold;">文件导入：</span>
						<input type="text" style="height:25px;width:300px;margin-left:-5px;" autofocus style="input-xlarge"  id="app_file" name="resumename" value="" readonly="readonly" >
						<input type="hidden" class="input-xlarge" id="filename" name="resumeurl" value="" readonly="readonly"/>
						<button type="button" class="btn add_app_file" style="width:115px;height:28px;padding-top:3px;padding-bottom:3px">选择文件</button>
					 </div>
					<table>
						<tr>
							<%-- <td>
								<div class="f_l">
									<a style="margin-top:0px;margin-left:0px;height:23px;padding-top:6px" class="btn cf"
										href="<%=basePath%>adminassetcheckresultimportcontroller/importassetcheckresulttotextshow.htm"> <i class="fa fa-edit"></i><span>导入</span></a>
								</div>
							</td> --%>
							<td><h3 style="width:70px;float:right;">盘点编号:</h3></td>
							<td><input type="text" id="resultnum" style="width:240px;height:30px;" readonly="readonly"></td>
							
							<td><h3 style="width:50px;float:right;">盘点人:</h3></td>
							<td><input type="text" id="checkpeople" style="width:240px;height:30px;"></td>
							<td><input type="button" id="searchBtn" value="提交"
								class="btn btn-primary" onclick="submit()" style="margin-left:75px;height:34px;padding-top:4px;width:60px;"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<hr />
		<div class="box-content clearfix">
				<div class="f_l">
					<table>
						<tr>
							<td><h3>备注:</h3></td>
							
							<c:choose>
								<c:when test="${not empty selectTermStr }">
									<td><textarea
									style="width:300px;height:100px;margin-top:20px;margin-bottom:20px;" id="remarkId">${selectTermStr }</textarea></td>
								</c:when>
								<c:otherwise>
								<td><textarea
									style="width:300px;height:100px;margin-top:20px;margin-bottom:20px;" id="remarkId"></textarea></td>
								</c:otherwise>
							</c:choose>
							
						</tr>
					</table>
				</div>
		</div>
		</fieldset>
		<%!int count=0; %>
		<div style="margin-top:10px;" id="list">
			<fieldset>
			<legend>盘点结果列表</legend>
			<c:choose>
				<c:when test="${not empty assetsCheckeds && not empty assetsNotCheckeds }">
					<table id="tableinfo" class="table-hover dataTable">
							<tr>
								<th style="background-color:#eee;width:5%">序号</th>
								<th style="background-color:#eee;width:15%">资产代码</th>
								<th style="background-color:#eee;">资产名称</th>
								<th style="background-color:#eee;">资产类型</th>
								<!-- <th style="background-color:#eee;">规格型号</th> -->
								<th style="background-color:#eee;">使用人</th>
								<th style="background-color:#eee;width:13%">使用部门</th>
								<th style="background-color:#eee;">保管人</th>
								<th style="background-color:#eee;width:13%">保管部门</th>
								<th style="background-color:#eee;">使用状态</th>
								<th style="background-color:#eee;">盘点结果</th>
							</tr>
							<c:forEach items="${assetsNotCheckeds }" var="assetsNotChecked">
								<tr>
								<%count++; %>
									<td><%=count %></td>
									<td>${assetsNotChecked.code }</td>
									<td>${assetsNotChecked.name }</td>
									<td>${assetsNotChecked.type }</td>
									<!-- <td>${assetsNotChecked.model }</td> -->
									<td>${assetsNotChecked.user }</td>
									<td>${assetsNotChecked.usedepartment }</td>
									<td>${assetsNotChecked.keeper }</td>
									<td>${assetsNotChecked.keepdepartment }</td>
									<td>${assetsNotChecked.usestate }</td>
									<td>漏盘</td>
								</tr>
							</c:forEach>

							<c:forEach items="${assetsCheckeds }" var="assetsChecked">
								<tr>
									<%count++; %>
									<td><%=count %></td>
									<td>${assetsChecked.code }</td>
									<td>${assetsChecked.name }</td>
									<td>${assetsChecked.type }</td>
									<!-- <td>${assetsNotChecked.model }</td> -->
									<td>${assetsChecked.user }</td>
									<td>${assetsChecked.usedepartment }</td>
									<td>${assetsChecked.keeper }</td>
									<td>${assetsChecked.keepdepartment }</td>
									<td>${assetsChecked.usestate }</td>
									<td>已盘</td>
								</tr>
							</c:forEach>
						</table>			
				</c:when>
				<c:otherwise>
				<c:choose>
					<c:when test="${not empty assetsNotCheckeds }">
						<table id="tableinfo"  class="table-hover dataTable">
							<tr>
								<th style="background-color:#eee;width:5% ">序号</th>
								<th style="background-color:#eee;width:15%">资产代码</th>
								<th style="background-color:#eee;">资产名称</th>
								<th style="background-color:#eee;">资产类型</th>
								<!-- <th style="background-color:#eee;">规格型号</th> -->
								<th style="background-color:#eee;">使用人</th>
								<th style="background-color:#eee;width:13%">使用部门</th>
								<th style="background-color:#eee;">保管人</th>
								<th style="background-color:#eee;width:13%">保管部门</th>
								<th style="background-color:#eee;">使用状态</th>
								<th style="background-color:#eee;">盘点结果</th>
							</tr>
							<c:forEach items="${assetsNotCheckeds }" var="assetsNotChecked">
								<tr>
									<%count++; %>
									<td><%=count %></td>
									<td>${assetsNotChecked.code }</td>
									<td>${assetsNotChecked.name }</td>
									<td>${assetsNotChecked.type }</td>
									<!-- <td>${assetsNotChecked.model }</td> -->
									<td>${assetsNotChecked.user }</td>
									<td>${assetsNotChecked.usedepartment }</td>
									<td>${assetsNotChecked.keeper }</td>
									<td>${assetsNotChecked.keepdepartment }</td>
									<td>${assetsNotChecked.usestate }</td>
									<td>漏盘</td>
								</tr>
							</c:forEach>			
						</table>						
					</c:when>
					<c:otherwise>
					<c:choose>
						<c:when test="${not empty assetsCheckeds }">						
						<table id="tableinfo"  class="table-hover dataTable">
							<tr>
								<th style="background-color:#eee;width:5% ">序号</th>
								<th style="background-color:#eee;width:15%">资产代码</th>
								<th style="background-color:#eee;">资产名称</th>
								<th style="background-color:#eee;">资产类型</th>
								<!-- <th style="background-color:#eee;">规格型号</th> -->
								<th style="background-color:#eee;">使用人</th>
								<th style="background-color:#eee;width:13%">使用部门</th>
								<th style="background-color:#eee;">保管人</th>
								<th style="background-color:#eee;width:13%">保管部门</th>
								<th style="background-color:#eee;">使用状态</th>
								<th style="background-color:#eee;">盘点结果</th>
							</tr>							
							<c:forEach items="${assetsCheckeds }" var="assetsChecked">
								<tr>
									<%count++; %>
									<td><%=count %></td>
									<td>${assetsChecked.code }</td>
									<td>${assetsChecked.name }</td>
									<td>${assetsChecked.type }</td>
									<!-- <td>${assetsNotChecked.model }</td> -->
									<td>${assetsChecked.user }</td>
									<td>${assetsChecked.usedepartment }</td>
									<td>${assetsChecked.keeper }</td>
									<td>${assetsChecked.keepdepartment }</td>
									<td>${assetsChecked.usestate }</td>
									<td>已盘</td>
								</tr>
							</c:forEach>
						</table>
						
						</c:when>
						</c:choose>
					
					</c:otherwise>
					</c:choose>
				
				</c:otherwise>
			</c:choose>									
			
			</table>
			<%count=0; %>
			<c:if test="${empty assetsNotCheckeds && empty assetsCheckeds }">
				暂无数据
			</c:if>
			</fieldset>
		</div>
		<div>
			<fieldset>
				<legend>异常资产列表</legend>
				<div style="float:right;padding:10px;">
					<a class="btn cf" href="javascript:void(0)" id="search1"><i class="fa fa-edit "></i>导出</a>
				</div>
				<div class="show tab-lbgl">
  		<table class="table-hover dataTable">
  			<tr>
  				<th>序号</th>
  				<th>资产编号</th>
  				<th>资产名称</th>
  				<th>原使用人</th>
  				<th>实际使用人</th>
  				<th>原使用部门</th>
  				<th>实际使用部门</th>
  				<th>异常备注</th>
  			</tr>
			<tr>
				<td>1</td>
				<td>12001200000</td>
				<td>电脑</td>
				<td>刘梦园</td>
				<td>办公室</td>
				<td>刘梦</td>
				<td>秘书部</td>
				<td>使用人异常</td>
			</tr>
			<tr>
				<td>2</td>
				<td>12001200000</td>
				<td>电脑</td>
				<td>刘梦园</td>
				<td>办公室</td>
				<td>刘梦</td>
				<td>秘书部</td>
				<td>使用人异常</td>
			</tr>
  		</table>
  	</div>
			</fieldset>
		</div>
	</div>
	<!-- <div class="pagination ue-clear"
		style="margin-top:0px;margin-bottom:50px;"></div> -->
	<script type="text/javascript"
		src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/Math.uuid.js"></script>
	<script>
		$(function(){   
            $("#resultnum").val(Math.uuid(25));
        });
	</script>
	<script type="text/javascript">
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
		$(document).ready(function(){
			
			$('.submitbtn').click(function(){
			    var filepath = $("#filename").val();
			    if(filepath==null||filepath==""){
			    	filepath="${filepath}";
			    }
				//alert(filepath);
				input(filepath);
				
			});
		});
		$('.pagination').pagination(100, {
			callback : function(page) {
				console.log(page + 1);
			},
			display_msg : true,
			setPageNo : true
		});
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
		
	</script>
</body>
</html>

