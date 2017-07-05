<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/page.css" />
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>kindeditor-4.1.7/kindeditor.js"></script>
    <script charset="utf-8" src="<%=basePath%>kindeditor-4.1.7/lang/zh_CN.js"></script>
  </head>
  <body>
    <div class="container-f">
  	 <div class="box-title clearfix tab-title">
			<h3 >
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/admin/indexlmy.jsp">
				<span class="fa fa-table"></span>
				资产管理
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/daoru/indexkw.jsp">
				<span class="fa fa-cog"></span>
				资产信息导入
				</a>
			</h3>
			<h3 >
				<a href="<%=basePath %>jsp/dataadmin/assetadmin/daochu/indexlmy.jsp">
				<span class="fa fa-bar-chart-o"></span>
				资产信息导出
				</a>
			</h3>
		</div> 
<div class="box-content clearfix">
	<div style="margin-left:10px;">
	<span class="font">文件导入：</span>
	<input type="text" style="height:25px;width:300px;margin-left:10px" autofocus style="input-xlarge"  id="app_file" name="resumename" value="${article.picurl }" readonly="readonly" >
	<input type="hidden" class="input-xlarge" id="filename" name="resumeurl" value="" readonly="readonly" />
	<button type="button" class="btn add_app_file">选择文件</button>
	<a href="javascript:void(0)" class="btn fbtn"  id="btnAdd" style="padding-left:30px;padding-right:30px;margin-left:30%;">提交数据</a>
  </div>
  <div style="margin-top:80px">
	<table width="100%" class="dataTable">
		<tr>
			<th>序号</th>
			<th>资产代码</th>
			<th>资产名称</th>
			<th>资产类型</th>
			<th>规格型号</th>
			<th>使用人</th>
			<th>使用部门</th>
			<th>保管人</th>
			<th>保管部门</th>
			<th>使用状态</th>
		</tr>
		<tr>
			<td>1</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
  </div>
 </div>
 <div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
 </div>

 <script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=basePath %>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript">
	$(function(){
    	$("#btnAdd").click(function(){
        	$("#modalCheck").modal("toggle");
    	});
    });
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
								} 
							});

						});
			        	

			        }
			       }); 
			});

		});
	</script>
  </body>
</html>
