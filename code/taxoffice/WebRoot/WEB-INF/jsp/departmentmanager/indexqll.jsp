<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib uri="/pageuri" prefix="cc"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'yjbmlb.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/page.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/themes/material/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/page.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery.pagination.js"></script>

<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath%>kindeditor-4.1.7/kindeditor.js"></script>
<script charset="utf-8"
	src="<%=basePath%>kindeditor-4.1.7/lang/zh_CN.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>kindeditor-4.1.7/themes/default/default.css" />
<script type="text/javascript"
	src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
<style type="text/css">
table tr td {
	width: 100px;
	height: 50px;
	font-size: 12px;
}

body {
	min-width: 1150px;
}

#list>fieldset>table tr td {
	height: 30px;
	font-size: 15px;
	text-align: center;
}

#list>fieldset>table tr th {
	height: 30px;
	font-size: 15px;
}

fieldset {
	margin-top: 20px;
	margin-bottom: 10px;
	padding-top: 15px;
	padding-bottom: 5px;
	padding-left: 10px;
	padding-right: 10px;
}

legend {
	font-weight: bold;
	font-size: 14px;
}

.form-actions input {
	padding: 6px 12px;
}

.ke-upload-file {
	width: 150px;
	cursor: pointer;
}

.ke-upload-area {
	margin-left: 30px;
}

.ke-button-common {
	width: 65px;
	line-height: 0px;
}

.tabs {
	display: none;
}

.modal_save,.modal_giveUp {
	width: 57px;
}
</style>
<style>
div.modal-footer {
	padding: 0px;
}

div.modal-header {
	padding: 0px;
	padding-top: 10px;
	padding-left: 30px;
}

.modal_save,.modal_giveUp {
	height: 30px;
}

.modal_save {
	padding-top: 5px;
	margin-left: 105px;
	padding-bottom: 10px;
}

.modal_giveUp {
	padding-top: 7px;
	padding-bottom: 8px;
	margin-right: 50px;
}

.hr {
	border-bottom: 1px solid #ddd;
	padding: 5px 3px 15px;
	min-height: 30px
}
</style>
</head>

<body onload="load()">

	<div class="container-f">
		<div class="hr"></div>
		<fieldset style="padding-bottom:15px;">
			<legend>部门查询</legend>
			<div class="control-group f_l">
				<a style="width:80px;margin-left:4px;margin-right:50px;"
					class="btn add-department cf btnAdd"> <i class="fa  fa-plus"></i><span>添加部门</span></a>
				<select class="easyui-combobox" id="condition1" editable=false
					name="state"
					style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
					<option value="depcode">部门代码</option>
					<option value="depname">部门名称</option>
					<option value="depstate">状态</option>
				</select> <select class="easyui-combobox" id="condition2" name="state"
					style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
				</select> <a class="btn" onclick="findDep()"><i class="fa fa-search"></i>查询</a>
			</div>
			<div class="control-group f_l" style="float:right">
				<div class="f_l">
					<span
						style="font-size:14px;font-family: Arial,Helvetica,sans-serif;font-weight:bold;">导入部门信息：</span>
					<input type="text"
						style="height:25px;width:300px;margin-left:-5px;" autofocus
						style="input-xlarge" id="app_file" name="resumename" value=""
						readonly="readonly"> <input type="hidden"
						class="input-xlarge" id="filename" name="resumeurl" value=""
						readonly="readonly" />
					<button type="button" class="btn add_app_file" id="selectBtn"
						style="width:115px;height:28px;padding-top:3px;padding-bottom:3px">选择文件</button>

				</div>
			</div>
		</fieldset>
		<shiro:hasPermission name="checkauth">

			<script type="text/javascript">
			$("#selectBtn").removeClass("add_app_file");
			//$("#selectBtn").
			document.getElementById("selectBtn").setAttribute("onclick", "alert('权限不足，不能执行此操作')")
			
		</script>


		</shiro:hasPermission>
		<div style="margin-top:10px;" id="list">
			<fieldset>
				<legend>查询结果</legend>
				<table id="tableinfo" class="table-hover dataTable">
					<tr>
						<th>部门代码</th>
						<th>部门名称</th>
						<th>人数</th>
						<th>状态</th>
						<th class="tab-th">查看人员</th>
						<th class="tab-th">添加人员</th>
						<th class="tab-th">操作</th>
					</tr>
					<c:forEach items="${tDepartmentsList }" var="department">
						<tr>
							<td class="tab-td">${department.depcode}</td>
							<td class="tab-td">${department.depname}</td>
							<td class="tab-td">${department.depusernum}</td>
							<td class="tab-td">${department.depstate}</td>
							<td class="tab-td"><a id="chakan"
								href="${basePath}admindepartmentcontroller/getuserbydep.htm?depcode=${department.depcode }&precondition=${condition }&pretext=${text }&precurrentPage=${pager.currentPage }"
								class="btn"><i class="fa fa-search"></i>查看</a></td>
							<td class="tab-td"><a data-depcode="${department.depcode}"
								class="btn add-user tianjia"><i class="fa fa-plus"></i>添加</a></td>
							<td class="tab-td"><a data-id="${department.id}"
								data-depcode="${department.depcode}"
								data-depname="${department.depname}"
								data-depstate="${department.depstate}"
								class="btn edit-department bianji"><i class="fa fa-edit"></i>编辑</a>
								<a href="javascript:void(0)" class="btn delete-department"
								onclick="deleteDep(${department.id})"><i
									class="fa fa-times"></i>删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="pagination ue-clear"
					style="margin-top:0px;margin-bottom:50px;"></div>
				<c:if test="${tDepartmentsList.size()==0 }">
					<br />
			     &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp 暂无数据
			     			<br />
					<br />
				</c:if>
				<cc:page
					url="${basePath}admindepartmentcontroller/getdepbyconditionwithpage.htm?condition=${condition }&text=${text }"
					value="${pager}" />
			</fieldset>
		</div>
	</div>
	<div class="container-f">

		<div class="box-content clearfix"></div>
		<div style="margin-top:10px;"></div>
	</div>
	<input type="hidden" value="${meg}" id="meg">
	<div class="modal fade" id="tianjiabumen">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix"
							style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l">
								<h3>
									<i class="fa fa-plus"></i>添加部门
								</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge"
							style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg"> 部门代码： </label>
								<div class="controls">
									<input type="text" name="adddepcode" id="adddepcode"
										data-rule-maxlength="60" class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;">
									<p-adddepcode
										style="font-size:12px;font-weight:normal;line-height:30px;margin-left:0px;"></p-adddepcode>
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg"> 部门名称： </label>
								<div class="controls">
									<input type="text" name="adddepname" id="adddepname"
										data-rule-maxlength="60" class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;">
									<p-adddepname
										style="font-size:12px;font-weight:normal;line-height:30px;margin-left:0px;"></p-adddepname>

								</div>
							</div>

							<div class="control-group cf clearfix">
								<label class="control-label" for="title"> 状态： </label>
								<div class="controls">
									<select class="easyui-combobox" name="adddepstate"
										id="adddepstate" editable="false"
										style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="启用">启用</option>
										<option value="关闭">关闭</option>
									</select>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id"> <input
							class="btn btn-primary modal_save" style="margin-left:175px;"
							id="add-Depart" onclick="addDep()" value="添加"> <input
							class="btn btn-primary modal_save" style="margin-left:10px;"
							data-dismiss="modal" value="取消">

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="chakanbumen"></div>

	<div class="modal fade" id="tianjiarenyuan">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix"
							style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l">
								<h3>
									<i class="fa fa-plus"></i>添加人员
								</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge"
							style="margin-left:60px;">
							<div class="control-group cf clearfix">
								<label class="control-label" for="title"> 人员代码： </label>
								<div class="controls">
									<input type="text" name="usercode" id="usercode"
										data-rule-maxlength="60" class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;"
										value="">
									<p-usercode
										style="font-size:12px;font-weight:normal;line-height:30px;margin-left:0px;"></p-usercode>
								</div>
							</div>

							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">人员姓名：</div>
								<div class="controls">
									<input type="text" name="username" id="username" value=""
										class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;"
										value="">
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">职务：</div>
								<div class="controls">
									<select class="easyui-combobox" name="userduty" id="userduty"
										style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
									</select>

								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">角色：</div>
								<div class="controls">
									<select class="easyui-combobox" name="userrole" id="userrole"
										style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
									</select>
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">性别：</div>
								<div class="controls">
									<label class="la">男性：<input type="radio"
										checked="checked" name="Sex" value="男" /> 女性：<input
										type="radio" name="Sex" value="女" /></label>

								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">状态：</div>
								<div class="controls">
									<select class="easyui-combobox" name="userstate" id="userstate"
										editable="false"
										style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="启用">启用</option>
										<option value="关闭">关闭</option>
									</select>
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">人员类别：</div>

								<div class="controls">
									<select class="easyui-combobox" name="usertype" id="usertype"
										editable="false"
										style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="在职人员">在职人员</option>
										<option value="离休人员">离休人员</option>
										<option value="退休人员">退休人员</option>
									</select>
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">用户名：</div>
								<div class="controls">
									<input type="text" name="useraccount" id="useraccount"
										class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;"
										value="">
									<p-useraccount
										style="font-size:12px;font-weight:normal;line-height:30px;margin-left:0px;"></p-useraccount>
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">密码：</div>
								<div class="controls">
									<input type="password" name="userpassword" id="userpassword"
										class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;"
										value="">
								</div>
							</div>
							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">确认密码：</div>
								<div class="controls">
									<input type="password" name="confirmuserpassword"
										id="confirmuserpassword" class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;"
										value="">
									<p-confirmuserpassword
										style="font-size:12px;font-weight:normal;line-height:30px;margin-left:0px;"></p-confirmuserpassword>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="adduserdepcode" id="adduserdepcode"
							value="" /> <input class="btn btn-primary modal_save"
							style="margin-left:175px;" id="adduserbydep"
							onclick="addUserByDep()" value="添加"> <input
							class="btn btn-primary modal_save" style="margin-left:10px;"
							data-dismiss="modal" value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="bianjibumen">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix"
							style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l">
								<h3>
									<i class="fa fa-edit"></i>编辑部门
								</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" class="input-xlarge"
							style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg"> 部门代码： </label>
								<div class="controls">
									<input type="text" name="editdepcode" id="editdepcode"
										data-rule-maxlength="60" class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;"
										value="">
									<p-editdepcode
										style="font-size:12px;font-weight:normal;line-height:30px;margin-left:0px;"></p-editdepcode>
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg"> 部门名称： </label>
								<div class="controls">
									<input type="text" name="editdepname" id="editdepname"
										data-rule-maxlength="60" class="input-medium ipt_require"
										style="width: 150px;padding: 5px 2px;border:1px solid #ddd;"
										value="">
									<p-editdepname
										style="font-size:12px;font-weight:normal;line-height:30px;margin-left:0px;"></p-editdepname>

								</div>
							</div>

							<div class="control-group cf clearfix">
								<div class="control-label" for="sort">状态：</div>
								<div class="controls">
									<select class="easyui-combobox" name="editdepstate"
										id="editdepstate" editable="false"
										style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="启用">启用</option>
										<option value="关闭">关闭</option>
									</select>
								</div>
							</div>
							<input type="hidden" name="editid" id="editid" value="" /> <input
								type="hidden" name="preeditdepcode" id="preeditdepcode" value="" />
							<input type="hidden" name="preeditdepname" id="preeditdepname"
								value="" />
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input class="btn btn-primary modal_save"
							style="margin-left:175px;" id="edit-Depart" onclick="updateDep()"
							value="保存"> <input class="btn btn-primary modal_save"
							style="margin-left:10px;" data-dismiss="modal" value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 存储上次查询条件condition和text -->
	<input type="hidden" id="precondition" value="${condition }" />
	<!-- 存储本次查询条件以备回显 -->
	<input type="hidden" id="pretext" value="${text }" />
	<input type="hidden" id="currentPage" value="${pager.currentPage }" />
	<%-- 存储当前页，因为在js中ajax中的键值对不能够用${} --%>

	<input type="hidden" id="dep-code-legal" name="dep-code-legal"
		value="false" />
	<input type="hidden" id="dep-name-legal" name="dep-name-legal"
		value="false" />
	<!-- 添加部门时 记录部门代码或者名称是否冲突的状态，以便不重复进行ajax -->

	<input type="hidden" id="edit-dep-code-legal"
		name="edit-dep-code-legal" value="false" />
	<input type="hidden" id="edit-dep-name-legal"
		name="edit-dep-name-legal" value="false" />
	<!-- 修改编辑部门时 记录部门代码或者名称是否冲突的状态，以便不重复进行ajax -->

	<input type="hidden" id="add-user-code-legal"
		name="add-user-code-legal" value="false" />
	<input type="hidden" id="add-user-account-legal"
		name="add-user-account-legal" value="false" />
	<!-- 添加人员时 记录人员代码或者用户名，确认密码是否冲突的状态，以便不重复进行ajax -->
	<input type="hidden" id="add-user-confirmuserpassword-legal"
		name="add-user-confirmuserpassword-legal" value="false" />

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
							location.href="<%=basePath%>adminimportexcelcontroller/importdeplist.htm?filePath="+filepath;
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
		
		
		
		$(function(){
	    	$(".btnAdd").click(function(){
	        	$("#tianjiabumen").modal("toggle");
	    	});
	    });
	  
	    $(function(){
	    	$(".tianjia").click(function(){
	        	$("#tianjiarenyuan").modal("toggle");
	    	});
	    });
	</script>
	<script>
   function findDep(){
		var condition = $('#condition1').combobox('getValue');
		var text = $('#condition2').combobox('getValue');
		location.href="<%=basePath%>admindepartmentcontroller/getdepbyconditionwithpage.htm?condition="+condition+"&text="+text;
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
      		    url:'<%=basePath%>admindepartmentcontroller/getdepjson.htm?condition='+condition,
      		    valueField:'value', //设置combobox的value
      		    textField:'text',//设置combobox显示的text
      		    editable:true
      		    });
		$('#condition2').combobox('select',pretext);
		
	}
   </script>
	<!-- 显示添加部门人员信息模态框tianjiarenyuan 之前内容的赋值 -->
	<script>
	//必不可少
    $(function(){
    	$(".tianjia").click(function(){
    	//首先对模态框中的部门代码进行赋值
    	var depcode=$(this).attr("data-depcode");
    	document.getElementById("adduserdepcode").value=depcode;
    	//combobox赋值
       	$('#userduty').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminusermanagercontroller/getdutyjson.htm',
      		    valueField:'value', //设置combobox的value
      		    textField:'text',//设置combobox显示的text
      		    editable:true
      		    });
    	$('#userrole').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
	    		    url:'<%=basePath%>adminusermanagercontroller/getuserrolejson.htm',
	    		    valueField:'id', //设置combobox的value
	    		    textField:'text',//设置combobox显示的text
	    		    editable:false//将combobox置为不可输入状态
	    		});	 
	    		//记录状态类	
    		 	document.getElementById("add-user-code-legal").value="false";//记录人员代码的合法性 避免保存时再进行ajax验证
			    document.getElementById("add-user-account-legal").value="false";//记录人员用户名的合法性 避免保存时再进行ajax验证
				document.getElementById("add-user-confirmuserpassword-legal").value="false";//记录密码是否匹配
				 //显示模态框
        		$('#tianjiarenyuan').modal('show');//显示模态框
        		$('#tianjiarenyuan').on('shown.bs.modal', function () {
        		
   				 $("#usercode").focus();//使用重新赋值重新聚焦的方法
			});
        	
    	});
    });
</script>
	<!-- 执行添加部门人员操作 -->
	<script>
function addUserByDep(){
	 var usercode=document.getElementById("usercode").value;//必填
	 var username=document.getElementById("username").value;//必填
	 var userduty= $('#userduty').combobox('getValue');//可以不填
	 var userrole= $('#userrole').combobox('getValue');//必填
	 var usersex=$("input:radio[name='Sex']:checked").val();//默认填
	 var usertype=$('#usertype').combobox('getValue');//默认填
  	 var userstate=$('#userstate').combobox('getValue');//默认填
  	 var useraccount=document.getElementById("useraccount").value;//必填
	 var userpassword=document.getElementById("userpassword").value;//必填
	 var depcode=document.getElementById("adduserdepcode").value;
	 var confirmuserpassword=document.getElementById("confirmuserpassword").value;//必填
	 if(usercode==""||usercode==null){
       	alert("人员代码不能为空,请重新输入！");
     }else{
          if((/^\d{5}$/).test(usercode)==false){
                alert("人员代码须为五位数字,请重新输入！");
          }else{
          		if(usercode.indexOf(" ")>=0){//如果人员代码有空格，去除空格
            		usercode = usercode.replace(/\s/g, "");
         		}
				if(document.getElementById("add-user-code-legal").value=="false"){
					alert("该人员代码已存在，请重新输入！");
				}else{//到此处人员代码已经合法
					if(username==null||username==""){
						alert("人员姓名不能为空，请重新输入！");
					}else{
						if(username.indexOf(" ")>=0){//如果人员姓名带有空格去除空格
				            username = username.replace(/\s/g, "");
				          }
						if(userrole==null||userrole==""){
							alert("请选择权限！");
						}else{
							if(useraccount==null||useraccount==""){
								alert("用户名不能为空，请重新输入！");
							}else{
								if(document.getElementById("add-user-account-legal").value=="false"){
									alert("该用户名已存在，请重新输入！");
								}else{
									if(userpassword==null||userpassword==""){
										alert("请输入密码！");
									}else{
										if(confirmuserpassword==null||confirmuserpassword==""){
											alert("请确认密码！");
										}else{
											if(userpassword.indexOf(" ")>=0||confirmuserpassword.indexOf(" ")>=0){
												alert("密码不能有空格！");
											}else{
												if(document.getElementById("add-user-confirmuserpassword-legal").value=="false"){
													alert("密码不匹配，请重新输入！");
												}
												else{
														$('#adduserbydep').attr("disabled","disabled");
														 $.ajax({ 
     															type:"POST", //表单提交类型 
     															dataType: "html",
     															url:'<%=basePath%>admindepartmentcontroller/adddepuserbydepcode.htm', 
    															data:{useraccount:useraccount, userpassword:userpassword, username:username, usercode:usercode, usersex:usersex, depcode:depcode, userduty:userduty, usertype:usertype, userstate:userstate,userrole:userrole}, //表单数据
  																success:function(e){
	 																				var  data = eval("("+e+")");
      																				if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       																					alert(data.msg);
       																					location.href="<%=basePath%>admindepartmentcontroller/getdepbyconditionwithpage.htm?currentPage=${pager.currentPage}&condition=${condition}&text=${text}";
       									 											}else{
																						alert(data.msg);//添加失败重新对表单进行赋值
     										 										}
	
     															}
 									 						}); 
 									 					
												}
											}
											
										}
									}
								}
							}
						}
					}
				}
		  }
         
         
    }
}
</script>
	<!--添加部门人员模态框   内容复位 -->
	<script>
   $(function () { $("#tianjiarenyuan").on('hidden.bs.modal', function () {
   //将用户自己输入的值清空
	document.getElementById("usercode").value="";//必填
	document.getElementById("username").value="";//必填
	$('#userduty').combobox('select','');//可以不填
	$('#userrole').combobox('select','');//必填
	$("input:radio[name='Sex']")[0].checked = true;//默认填
	$('#usertype').combobox('select',"在职人员");//默认填
  	$('#userstate').combobox('select',"启用");//默认填
  	document.getElementById("useraccount").value="";//必填
	document.getElementById("userpassword").value="";//必填
	document.getElementById("adduserdepcode").value="";
	document.getElementById("confirmuserpassword").value="";//必填
	//将添加人员所用的一些判断条件设置为初始值
	document.getElementById("add-user-confirmuserpassword-legal").value="false";
	document.getElementById("add-user-account-legal").value="false";
	document.getElementById("add-user-code-legal").value=="false";
	//将提示信息置空
	  $("p-usercode").html("");
	  $("p-useraccount").html("");
	  $("p-confirmuserpassword").html("");
	});
   });
</script>
	<!-- 根据第一个的查询条件，远程绑定第二个combobox中的数据 -->
	<script>
	$('#condition1').combobox({  
        onSelect:function(){  
       	 var condition= $('#condition1').combobox('getValue'); 
       	 $('#condition2').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
       		    url:'<%=basePath%>admindepartmentcontroller/getdepjson.htm?condition='+condition,
       		    valueField:'value', //设置combobox的value
       		    textField:'text',//设置combobox显示的text
       		    editable:true
       		    });
       	 } 
});  
	</script>
	<!-- 添加部门人员时：人员代码的合法性验证 -->
	<script>
	$(function(){
            $("#usercode").bind("input propertychange",function(){
                var usercode=document.getElementById("usercode").value;
				  if(usercode==""||usercode==null){
                    $("p-usercode").html("人员代码不能为空！");
                }else{
                 if(usercode.indexOf(" ")>=0){
                	$("p-usercode").html("输入有空格！");
                	}else{
                		 if((/^\d{5}$/).test(usercode)==false){
                		$("p-usercode").html("人员代码须为五位数字！");
                			}else{
			                   $.ajax({ 
			    					 type:"POST", //表单提交类型 
			    					 dataType: "html",
			    					 url:'<%=basePath%>admindepartmentcontroller/isusercodelegal.htm', 
			    					 data:{usercode:usercode}, //表单数据
			 					 	success:function(e){
				 							 var  data = eval("("+e+")");
			      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
			      		 						document.getElementById("add-user-code-legal").value="true";
			      		 						$("p-usercode").html("");
			      						}else{
			      								document.getElementById("add-user-code-legal").value="false";
												$("p-usercode").html(data.msg);
			    							 }
			   								            }
			   							 }); 
			                }
                	}
         
                }
            });
        });
	</script>
	<!-- 添加部门人员时：用户名的合法性验证 -->
	<script>
	$(function(){
            $("#useraccount").bind("input propertychange",function(){
                var useraccount=document.getElementById("useraccount").value;
				  if(useraccount==""||useraccount==null){
                    $("p-useraccount").html("用户名不能为空！");
                }else{
                 if(useraccount.indexOf(" ")>=0){
                	$("p-useraccount").html("输入有空格！");
                	}else{
                   $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 dataType: "html",
    					 url:'<%=basePath%>admindepartmentcontroller/isuseraccountlegal.htm', 
    					 data:{useraccount:useraccount}, //表单数据
 					 	success:function(e){
	 							 var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 						document.getElementById("add-user-account-legal").value="true";
      		 						$("p-useraccount").html("");
      						}else{
      								document.getElementById("add-user-account-legal").value="false";
									$("p-useraccount").html(data.msg);
    							 }
   								            }
   							 }); 
                }
             
               		
                }
            });
        });
	</script>
	<!-- 添加部门人员时 密码的确认 -->
	<script>
		$(function(){
            $("#confirmuserpassword").bind("input propertychange",function(){
            	var password=document.getElementById("userpassword").value;
            	if(password==null||password==""){
            		document.getElementById("add-user-confirmuserpassword-legal").value="false";
            		$("p-confirmuserpassword").html("请先输入密码！");
            		
            	}else{
            	var confirmuserpassword=document.getElementById("confirmuserpassword").value;
		            	if(confirmuserpassword==password){
		                	document.getElementById("add-user-confirmuserpassword-legal").value="true";
		                	$("p-confirmuserpassword").html("密码匹配！");
		                }else{
		                document.getElementById("add-user-confirmuserpassword-legal").value="false";
		                	$("p-confirmuserpassword").html("密码不匹配！");
		                }
            	}
            });
            });
            $(function(){
            $("#userpassword").bind("input propertychange",function(){
            	var password=document.getElementById("userpassword").value;
            	var confirmuserpassword=document.getElementById("confirmuserpassword").value;
            		if(password==null||password==""){
            				document.getElementById("add-user-confirmuserpassword-legal").value="false";
            				$("p-confirmuserpassword").html("请先输入密码！");
            		}else{
		            	if(confirmuserpassword==password){
		            		document.getElementById("add-user-confirmuserpassword-legal").value="true";
		                	$("p-confirmuserpassword").html("密码匹配！");
		                }else{
		                	document.getElementById("add-user-confirmuserpassword-legal").value="false";
		                	$("p-confirmuserpassword").html("密码不匹配！");
		                }
            		}
            });
            });
	</script>
	<!-- 添加部门时：部门代码的合法性验证 -->
	<script>
	           $(function(){
            $("#adddepcode").bind("input propertychange",function(){
                var depcode=document.getElementById("adddepcode").value;
				  if(depcode==""||depcode==null){
                    $("p-adddepcode").html("部门代码不能为空！");
                }else{
                 if(depcode.indexOf(" ")>=0){
                	$("p-adddepcode").html("输入有空格！");
                	}else{
                		 if((/^\d{2}$/).test(depcode)==false){
                		$("p-adddepcode").html("部门代码须为两位数字！");
                			}else{
			                   $.ajax({ 
			    					 type:"POST", //表单提交类型 
			    					  dataType: "html",
			    					 url:'<%=basePath%>admindepartmentcontroller/isadddepcodelegal.htm', 
			    					 data:{depcode:depcode}, //表单数据
			 					 	success:function(e){
			 					 	
				 							  var  data = eval("("+e+")"); 
			      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
			      		 						document.getElementById("dep-code-legal").value="true";
			      		 						$("p-adddepcode").html("");
			      						}else{
			      						document.getElementById("dep-code-legal").value="false";
											$("p-adddepcode").html(data.msg);
			    							 }
			   								            }
			   							 }); 
			                }
                	}
         
                }
            });
        });
	</script>
	<!--添加部门时： 部门名称的合法性验证 -->
	<script>
	           $(function(){
            $("#adddepname").bind("input propertychange",function(){
                var depname=document.getElementById("adddepname").value;
				  if(depname==""||depname==null){
                    $("p-adddepname").html("部门名称不能为空！");
                }else{
                 if(depname.indexOf(" ")>=0){
                	$("p-adddepname").html("输入有空格！");
                	}else{
                   $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 dataType: "html",
    					 url:'<%=basePath%>admindepartmentcontroller/isadddepnamelegal.htm', 
    					 data:{depname:depname}, //表单数据
 					 	success:function(e){
	 							 var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 						document.getElementById("dep-name-legal").value="true";
      		 						$("p-adddepname").html("");
      						}else{
      						document.getElementById("dep-name-legal").value="false";
								$("p-adddepname").html(data.msg);
    							 }
   								            }
   							 }); 
                }
             
               		
                }
            });
        });
	</script>
	<!-- 显示编辑部门信息模态框 bianji 之前内容的赋值 -->
	<script>
	//必不可少
    $(function(){
    	$(".bianji").click(function(){
    	var id=$(this).attr("data-id");
        var depcode=$(this).attr("data-depcode");
        var depname=$(this).attr("data-depname");
        var depstate=$(this).attr("data-depstate");
        		$('#editid').val(id);
        		$('#editdepcode').val(depcode); 
        		$('#preeditdepcode').val(depcode);//记录修改之前的部门代码，以便验证   
    			$('#editdepname').val(depname); 
    			$('#preeditdepname').val(depname);//记录修改之前的部门名称，以便验证     
    		 	$('#editdepstate').combobox('select',depstate);//修改回显设置默认选中值
    		 	
    		 	document.getElementById("edit-dep-code-legal").value="true";//记录部门代码的合法性 避免保存时再进行ajax验证
				 document.getElementById("edit-dep-name-legal").value="true";//记录部门名称的合法性 避免保存时再进行ajax验证
				 
        		$('#bianjibumen').modal('show');//显示模态框
        		$('#bianjibumen').on('shown.bs.modal', function () {
        		var t=$("#editdepcode").val();
   				 $("#editdepcode").val("").focus().val(t);//使用重新赋值重新聚焦的方法
			});
        	
    	});
    });
</script>
	<!-- 编辑修改部门时：部门代码的合法性验证 -->
	<script>
	    $(function(){
            $("#editdepcode").bind("input propertychange",function(){
                  var depcode=document.getElementById("editdepcode").value;
                  var predepcode=document.getElementById("preeditdepcode").value;  
				  if(depcode==""||depcode==null){
                    $("p-editdepcode").html("部门代码不能为空！");
                }else{
                 if(depcode.indexOf(" ")>=0){
                	$("p-editdepcode").html("输入有空格！");
                	}else{
                		 if((/^\d{2}$/).test(depcode)==false){
                		$("p-editdepcode").html("部门代码须为两位数字！");
                			}else{
			                   $.ajax({ 
			    					 type:"POST", //表单提交类型 
			    					 dataType: "html",
			    					 url:'<%=basePath%>admindepartmentcontroller/iseditadddepcodelegal.htm', 
			    					 data:{depcode:depcode,predepcode:predepcode}, //表单数据
			 					 	success:function(e){
				 							 var  data = eval("("+e+")");
			      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
			      						
			      		 						document.getElementById("edit-dep-code-legal").value="true";
			      		 						$("p-editdepcode").html("");
			      						}else{
			      						document.getElementById("edit-dep-code-legal").value="false";
											$("p-editdepcode").html(data.msg);
			    							 }
			   								            }
			   							 }); 
			                }
                	}
         
                }
            });
        });
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
		var meg=document.getElementById("meg").value;
		if(meg!=""){
			alert(meg);
		}
	});
	</script>
	<!--编辑修改部门时： 部门名称的合法性验证 -->
	<script>
	           $(function(){
            $("#editdepname").bind("input propertychange",function(){
                var depname=document.getElementById("editdepname").value;
                var predepname=document.getElementById("preeditdepname").value;
				  if(depname==""||depname==null){
                    $("p-editdepname").html("部门名称不能为空！");
                }else{
                 if(depname.indexOf(" ")>=0){
                	$("p-editdepname").html("输入有空格！");
                	}else{
                   $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 dataType: "html",
    					 url:'<%=basePath%>admindepartmentcontroller/iseditadddepnamelegal.htm', 
    					 data:{depname:depname,predepname:predepname}, //表单数据
 					 	success:function(e){
	 							 var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 						document.getElementById("edit-dep-name-legal").value="true";
      		 						$("p-editdepname").html("");
      						}else{
      						document.getElementById("edit-dep-name-legal").value="false";
								$("p-editdepname").html(data.msg);
    							 }
   								            }
   							 }); 
                }
             
               		
                }
            });
        });
	</script>
	<!-- 进行编辑修改部门 -->
	<script>
	function updateDep(){
		var depid=document.getElementById("editid").value;
		var depcode=document.getElementById("editdepcode").value;
		var depname=document.getElementById("editdepname").value;
		var depstate=$('#editdepstate').combobox('getValue');
		if(depcode==null||depcode==""){
			alert("部门代码不能为空，请重新输入！");
		}else{
			if((/^\d{2}$/).test(depcode)==false){
					alert("部门代码需为两位数字，请重新输入!");
			}else{
				if(depname==null||depname==""){
				alert("部门名称不能为空，请重新输入！");
				}else{
					if(document.getElementById("edit-dep-code-legal").value=="false"){
						alert("该部门代码已存在，请重新输入！");
					}else{
						if(document.getElementById("edit-dep-name-legal").value=="false"){
							alert("该部门名称已存在，请重新输入！");
						}else{
						$('#edit-Depart').attr("disabled","disabled");
							$.ajax({ 
     							type:"POST", //表单提交类型 
     							dataType: "html",
     							url:'<%=basePath%>admindepartmentcontroller/updatedep.htm', 
    							 data:{depid:depid,depcode:depcode,depname:depname,depstate:depstate}, //表单数据
  								success:function(e){
	 									 var  data = eval("("+e+")");
      									if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       											alert(data.msg);
       										location.href="<%=basePath%>admindepartmentcontroller/getdepbyconditionwithpage.htm?currentPage=${pager.currentPage}&condition=${condition}&text=${text}";
       									 }else{
												alert(data.msg);//添加失败重新对表单进行赋值
     										 }
	
     												}
 									 });
						}
					}
				}
			}
		}
	}
	</script>
	<!--编辑修改部门模态框   内容复位 -->
	<script>
   $(function () { $("#bianjibumen").on('hidden.bs.modal', function () {
	$('#editdepstate').combobox('select',"启用");//修改回显设置默认选中值
	document.getElementById("editdepcode").value="";
	document.getElementById("editdepname").value="";
	document.getElementById("preeditdepcode").value="";
	document.getElementById("preeditdepname").value="";
	  $("p-editdepcode").html("");
	 $("p-editdepname").html("");
	$('#editdepstate').combobox({}).combobox("initClear");
	});
   });
</script>
	<!-- 添加部门模态框 tianjiabumen  内容复位 -->
	<script>
   $(function () { $("#tianjiabumen").on('hidden.bs.modal', function () {
	$('#adddepstate').combobox('select',"启用");//修改回显设置默认选中值
	document.getElementById("adddepcode").value="";
	document.getElementById("adddepname").value="";
	  $("p-adddepcode").html("");
	 $("p-adddepname").html("");
	 document.getElementById("dep-code-legal").value="false";//记录部门代码的合法性 避免保存时再进行ajax验证
	 document.getElementById("dep-name-legal").value="false";//记录部门名称的合法性 避免保存时再进行ajax验证
	$('#adddepstate').combobox({}).combobox("initClear");
	});
   });
</script>


	<!-- 进行添加部门 -->
	<script>
	function addDep(){
		var depcode=document.getElementById("adddepcode").value;
		var depname=document.getElementById("adddepname").value;
		var depstate=$('#adddepstate').combobox('getValue');
		if(depcode==null||depcode==""){
			alert("部门代码不能为空，请重新输入！");
		}else{
			if((/^\d{2}$/).test(depcode)==false){
					alert("部门代码需为两位数字，请重新输入!");
			}else{
				if(depname==null||depname==""){
				alert("部门名称不能为空，请重新输入！");
				}else{
					if(document.getElementById("dep-code-legal").value=="false"){
						alert("该部门代码已存在，请重新输入！");
					}else{
						if(document.getElementById("dep-name-legal").value=="false"){
							alert("该部门名称已存在，请重新输入！");
						}else{
							$('#add-Depart').attr("disabled","disabled");
							$.ajax({ 
     							type:"POST", //表单提交类型 
     							dataType: "html",
     							url:'<%=basePath%>admindepartmentcontroller/adddep.htm', 
    							 data:{depcode:depcode,depname:depname,depstate:depstate}, //表单数据
  								success:function(e){
	 									 var  data = eval("("+e+")");
      									if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       											alert(data.msg);
       										location.href="<%=basePath%>admindepartmentcontroller/getdepbyconditionwithpage.htm?currentPage=${pager.currentPage}&condition=${condition}&text=${text}";
       									 }else{
												alert(data.msg);//添加失败重新对表单进行赋值
     										 }
	
     												}
 									 });
						}
					}
				}
			}
		}
	}
	</script>
	<!-- 执行删除部门信息 -->
	<script type="text/javascript">
	function deleteDep(depid){
		var co=confirm('确定删除？');
		if(co==true){
	    var condition=document.getElementById("precondition").value;
		var text=document.getElementById("pretext").value;
		var currentPage=document.getElementById("currentPage").value;
			 $.ajax({ 
     	type:"POST", //表单提交类型 
     	dataType: "html",
    	 url:'<%=basePath%>admindepartmentcontroller/deletedep.htm', 
     	data:{depid:depid,currentPage:currentPage,condition:condition,text:text}, //表单数据
  		success:function(e){
	 	 var  data = eval("("+e+")");
      	if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
       		if(data.issubcurrentPage == 'ok'){
       			 location.href="<%=basePath%>admindepartmentcontroller/getdepbyconditionwithpage.htm?currentPage=${pager.currentPage-1}&condition=${condition}&text=${text}";
       		}else{
       			location.href="<%=basePath%>admindepartmentcontroller/getdepbyconditionwithpage.htm?currentPage=${pager.currentPage}&condition=${condition}&text=${text}";
									}
								} else {
									alert(data.msg);
								}
							}
						});
			}
		}
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
	<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
			//添加部门权限
			for (var i = 0; i < $(".add-department").length; i++) {
				$(".add-department").removeClass("btnAdd");
			}
			$(".add-department").click(function() {
				alert("权限不足，无法进行此操作");
			});

			//添加部门人员权限	
			for (var i = 0; i < $(".add-user").length; i++) {
				$(".add-user").removeClass("tianjia");
			}
			$(".add-user").click(function() {
				alert("权限不足，无法进行此操作");
			});

			//编辑部门信息权限
			for (var i = 0; i < $(".edit-department").length; i++) {
				$(".edit-department").removeClass("bianji");
			}
			$(".edit-department").click(function() {
				alert("权限不足，无法进行此操作");
			});

			//删除部门的权限     //注意已经有onclick事件的要使用attr才能将其原先的覆盖
			$(".delete-department").attr("onclick", "alert('权限不足，无法进行此操作')");
		</script>
	</shiro:hasPermission>
	<script type="text/javascript">
			$('.dataTable tr:even').css('background','#F3F3F3');
			$('.dataTable tr:odd').css('background','#ffffff');
		</script>
</body>
</html>
