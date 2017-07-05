<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>角色管理</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/datazp.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	<style type="text/css">
		table tr td {
			width: 100px;
			height: 50px;
			font-size: 15px;
		}

		body {
			min-width: 700px;
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
			padding-top:7px;
			padding-bottom:8px;
			margin-left:105px;
		}
		.modal_giveUp{
			padding-top:7px;
			padding-bottom:8px;
			margin-right:50px;
		}
</style>
		<style>
            .leftMenu{
            	padding:0px;
            }
            .leftMenu .panel-title{
            	font-size:15px;position:relative;cursor:pointer;padding:7px 10px;
            }
            .leftMenu .panel-heading span{
            	position:absolute;right:10px;
            }
            .leftMenu .list-group .list-group-item{
            	padding: 5px; 
            	padding-left:35px;
            	text-align:left;
            	border:none;
            	border-radius: 1px;
            	cursor:pointer;
            	font-size:15px;
            }
            .leftMenu .list-group-item:hover{
            	background:#368ee0;
            	border:none;
            	color:white;
            }
            .activeList{
            	background:#efe;
            	border:none;
            	color:black;
            }
            
            .listGroupItem0{
            	padding: 5px; 
            	padding-left:20px;
            	text-align:left;
            	border:none;
            	border-radius: 1px;
            	cursor:pointer;
            	font-size:15px;
            }
            .listGroupItem0:hover{
            	background:#368ee0;
            	border:none;
            	color:white;
            }
            .fa-times{
            	padding:2.5px;
            }
            #middleImage{
            	width:15px;
            	height:30px;
            	opacity:0.2;
            	cursor:pointer;
            }
            #listGroupItemUl{
            	height:300px;
            	overflow:auto;
            }
        </style>
</head>
<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="<%=basePath%>jsp/systemadmin/propertymanage/showrolemanage.jsp">
					<span class="fa fa-table"></span> 角色管理
				</a>
			</h3>
			<h3>
				<a href="<%=basePath%>jsp/systemadmin/propertymanage/showpropertymanage.jsp">
					<span class="fa fa-cog"></span> 权限管理
				</a>
			</h3>
		</div>
		<div class="box-content clearfix">
			<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a style="width:80px;margin-top:10px;margin-left:4px;" id="addBtn" class="btn cf"> <i class="fa fa-plus"></i><span>添加角色</span></a>
					</div>
				</div>
			</div>	
		</div>
		<div style="margin-top:10px;" id="list">
			<fieldset>
			<legend>角色管理</legend>
				<table  class="table-hover dataTable">
					<tr>
						<th style="background-color:#eee;">序号</th>
						<th style="background-color:#eee;">角色名称</th>
						<th style="background-color:#eee;">编辑权限</th>
						<th style="background-color:#eee;">重命名</th>
						<th style="background-color:#eee;">删除</th>
					</tr>
					<tr>
						<td>1</td>
						<td>系统管理员</td>
						<td>
							<a id="Btn" class="btn cf updateBtn" style="padding-top:7px;"> 
								<i class="fa fa-edit"></i>
								<span>编辑</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf renameBtn" style="padding-top:7px;width:60px;"> 
								<i class="fa fa-edit"></i>
								<span>重命名</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf" style="padding-top:7px;" onclick="javascript:if(confirm('您确定要删除吗？')){alert('删除成功！')};"> 
								<i class="fa fa-times"></i>
								<span>删除</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>财务部门资产管理员</td> 
						<td>
							<a id="Btn" class="btn cf updateBtn" style="padding-top:7px;"> 
								<i class="fa fa-edit"></i>
								<span>编辑</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf renameBtn" style="padding-top:7px;width:60px;"> 
								<i class="fa fa-edit renameBtn"></i>
								<span>重命名</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf" style="padding-top:7px;" onclick="javascript:if(confirm('您确定要删除吗？')){alert('删除成功！')};"> 
								<i class="fa fa-times"></i>
								<span>删除</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>3</td>
						<td>实物部门资产管理员</td> 
						<td>
							<a id="Btn" class="btn cf updateBtn" style="padding-top:7px;"> 
								<i class="fa fa-edit"></i>
								<span>编辑</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf renameBtn" style="padding-top:7px;width:60px;"> 
								<i class="fa fa-edit renameBtn"></i>
								<span>重命名</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf" style="padding-top:7px;" onclick="javascript:if(confirm('您确定要删除吗？')){alert('删除成功！')};"> 
								<i class="fa fa-times"></i>
								<span>删除</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>4</td>
						<td>信息中心资产管理员</td> 
						<td>
							<a id="Btn" class="btn cf updateBtn" style="padding-top:7px;"> 
								<i class="fa fa-edit"></i>
								<span>编辑</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf renameBtn" style="padding-top:7px;width:60px;"> 
								<i class="fa fa-edit"></i>
								<span>重命名</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf" style="padding-top:7px;" onclick="javascript:if(confirm('您确定要删除吗？')){alert('删除成功！')};"> 
								<i class="fa fa-times"></i>
								<span>删除</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>5</td>
						<td>人事部门资产管理员</td> 
						<td>
							<a id="Btn" class="btn cf updateBtn" style="padding-top:7px;"> 
								<i class="fa fa-edit"></i>
								<span>编辑</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf renameBtn" style="padding-top:7px;width:60px;"> 
								<i class="fa fa-edit"></i>
								<span>重命名</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf" style="padding-top:7px;" onclick="javascript:if(confirm('您确定要删除吗？')){alert('删除成功！')};"> 
								<i class="fa fa-times"></i>
								<span>删除</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>6</td>
						<td>使用部门资产管理员</td> 
						<td>
							<a id="Btn" class="btn cf updateBtn" style="padding-top:7px;"> 
								<i class="fa fa-edit"></i>
								<span>编辑</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf renameBtn" style="padding-top:7px;width:60px;"> 
								<i class="fa fa-edit"></i>
								<span>重命名</span>
							</a>
						</td>
						<td>
							<a id="Btn" class="btn cf" style="padding-top:7px;" onclick="javascript:if(confirm('您确定要删除吗？')){alert('删除成功！')};"> 
								<i class="fa fa-times"></i>
								<span>删除</span>
							</a>
						</td>
					</tr>
				</table>
				<div class="pagination ue-clear" style="margin-top:0px;margin-bottom:50px;"></div>
			</fieldset>
		</div>
	</div>
	
	<div class="modal fade" id="modalAdd">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-plus"></i>添加角色</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body" style="padding:0px;">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" id="modal_add" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									序号：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_add_id" data-rule-maxlength="60"  class="input-medium ipt_require" style="height:30px;width:250px;border:1px solid #ddd;" value="7">
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									角色名称：
								</label>
								<div class="controls">
									<select class="easyui-combobox" id="modal_add_number" style="width:250px;height:30px;border:solid 1px gray;padding-left:7px;"  name="usedepartment" id="usedepartment">
										<option value="系统管理员" checked="checked">系统管理员</option>
										<option value="财务部门资产管理员">财务部门资产管理员</option>
										<option value="实物部门资产管理员">实物部门资产管理员</option>
										<option value="信息中心资产管理员">信息中心资产管理员</option>
										<option value="人事部门资产管理员">人事部门资产管理员</option>
										<option value="使用部门资产管理员">使用部门资产管理员</option>
									</select>
								</div>
							</div>
							
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input class="btn btn-primary modal_save" data-dismiss="modal" value="添加">
						<input class="btn btn-primary modal_giveUp" data-dismiss="modal" value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modalUpdate">
	    <div class="modal-dialog" style="width:800px;">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-edit"></i>编辑权限</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body" style="padding-top:20px;padding-bottom:20px;">
					<table style="width:100%;font-size:18px;" cellspacing="0" cellpadding="0">
						<tr>
							<td style="width:44%;border:solid 1px #eee;font-size:15px;font-weight:bold;">
								<p style="padding-left:10px;">权限列表&nbsp;></p>
							</td>
							<td style="width:12%" rowspan="3" valign="middle" align="center">
								<img id="middleImage" src="<%=basePath%>Public/Images/right00.png"/>
							</td>
							<td style="width:44%;border:solid 1px #eee;font-size:15px;font-weight:bold;">
								<p style="padding-left:10px;">已选权限&nbsp;></p>
							</td>
						</tr>
						<tr style="height:56px;">
							<td style="border:solid 1px #eee;padding-left:10px;background-color:#eee">
								<input id="query_btn" type="text" style="width:70%" placeholder="请输入查询内容" onfocus="javascript:placeholder=''" onblur="javascript:placeholder='请输入查询内容'"/>
								<a class="btn" style="padding-top:6px;height:24px;margin-left:15px"><i class="fa fa-search"></i><span>查询</span></a>
							</td>
							
							<td style="border:solid 1px #eee;background-color:#eee" rowspan="2">
								<ul id="listGroupItemUl">
				                    <!--<li class="listGroupItem0">系统管理员添加功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员修改功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员删除功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员查询功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员导入导出功能<i class="fa" style="float:right"></i></li>
				                    <li class="listGroupItem0">系统管理员其他功能<i class="fa" style="float:right"></i></li>-->
				                </ul>
							</td>
						</tr>
						<tr valign="top">
							<td style="border:solid 1px #eee;background-color:#eee">
								<div class="panel-group table-responsive" role="tablist" style="height:244px;overflow:auto;border-top:solid 1px black;">
				                    <div class="panel panel-primary leftMenu">
				                        <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab" >
				                            <h4 class="panel-title"><font class="tran">></font>&nbsp;系统管理员</h4>
				                        </div>
				                        <div id="collapseListGroup1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
				                            <ul class="list-group">
				                              <li class="list-group-item" id="item_11">系统管理员添加功能</li>
				                              <li class="list-group-item" id="item_12">系统管理员修改功能</li>
				                              <li class="list-group-item" id="item_13">系统管理员删除功能</li>
				                              <li class="list-group-item" id="item_14">系统管理员查询功能</li>
				                              <li class="list-group-item" id="item_15">系统管理员导入导出功能</li>
				                              <li class="list-group-item" id="item_16">系统管理员其他功能</li>
				                            </ul>
				                        </div>
				                    </div>
				                    <div class="panel panel-primary leftMenu">
				                        <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
				                            <h4 class="panel-title"><font class="tran">></font>&nbsp;财务部门资产管理员</h4>
				                        </div>
				                        <div id="collapseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
				                            <ul class="list-group">
				                              <li class="list-group-item" id="item_21">财务部门资产管理员添加功能</li>
				                              <li class="list-group-item" id="item_22">财务部门资产管理员修改功能</li>
				                              <li class="list-group-item" id="item_23">财务部门资产管理员删除功能</li>
				                              <li class="list-group-item" id="item_24">财务部门资产管理员查询功能</li>
				                              <li class="list-group-item" id="item_25">财务部门资产管理员导入导出功能</li>
				                              <li class="list-group-item" id="item_26">财务部门资产管理员其他功能</li>
				                            </ul>
				                        </div>
				                    </div>  
				                    <div class="panel panel-primary leftMenu">
				                        <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" >
				                            <h4 class="panel-title"><font class="tran">></font>&nbsp;实物部门资产管理员</h4>
				                        </div>
				                        <div id="collapseListGroup3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
				                            <ul class="list-group">
				                              <li class="list-group-item" id="item_31">实物部门资产管理员添加功能</li>
				                              <li class="list-group-item" id="item_32">实物部门资产管理员修改功能</li>
				                              <li class="list-group-item" id="item_33">实物部门资产管理员删除功能</li>
				                              <li class="list-group-item" id="item_34">实物部门资产管理员查询功能</li>
				                              <li class="list-group-item" id="item_35">实物部门资产管理员导入导出功能</li>
				                              <li class="list-group-item" id="item_36">实物部门资产管理员其他功能</li>
				                            </ul>
				                        </div>
				                    </div> 
				                    <div class="panel panel-primary leftMenu">
				                        <div class="panel-heading" id="collapseListGroupHeading4" data-toggle="collapse" data-target="#collapseListGroup4" role="tab" >
				                            <h4 class="panel-title"><font class="tran">></font>&nbsp;信息中心资产管理员</h4>
				                        </div>
				                        <div id="collapseListGroup4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading4">
				                            <ul class="list-group">
				                              <li class="list-group-item" id="item_41">信息中心资产管理员添加功能</li>
				                              <li class="list-group-item" id="item_42">信息中心资产管理员修改功能</li>
				                              <li class="list-group-item" id="item_43">信息中心资产管理员删除功能</li>
				                              <li class="list-group-item" id="item_44">信息中心资产管理员查询功能</li>
				                              <li class="list-group-item" id="item_45">信息中心资产管理员导入导出功能</li>
				                              <li class="list-group-item" id="item_46">信息中心资产管理员其他功能</li>
				                            </ul>
				                        </div>
				                    </div> 
				                    <div class="panel panel-primary leftMenu">
				                        <div class="panel-heading" id="collapseListGroupHeading5" data-toggle="collapse" data-target="#collapseListGroup5" role="tab" >
				                            <h4 class="panel-title"><font class="tran">></font>&nbsp;人事部门资产管理员</h4>
				                        </div>
				                        <div id="collapseListGroup5" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading5">
				                            <ul class="list-group">
				                              <li class="list-group-item" id="item_51">人事部门资产管理员添加功能</li>
				                              <li class="list-group-item" id="item_52">人事部门资产管理员修改功能</li>
				                              <li class="list-group-item" id="item_53">人事部门资产管理员删除功能</li>
				                              <li class="list-group-item" id="item_54">人事部门资产管理员查询功能</li>
				                              <li class="list-group-item" id="item_55">人事部门资产管理员导入导出功能</li>
				                              <li class="list-group-item" id="item_56">人事部门资产管理员其他功能</li>
				                            </ul>
				                        </div>
				                    </div> 
				                    <div class="panel panel-primary leftMenu">
				                        <div class="panel-heading" id="collapseListGroupHeading6" data-toggle="collapse" data-target="#collapseListGroup6" role="tab" >
				                            <h4 class="panel-title"><font class="tran">></font>&nbsp;使用部门资产管理员</h4>
				                        </div>
				                        <div id="collapseListGroup6" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading6">
				                            <ul class="list-group">
				                              <li class="list-group-item" id="item_61">使用部门资产管理员添加功能</li>
				                              <li class="list-group-item" id="item_62">使用部门资产管理员修改功能</li>
				                              <li class="list-group-item" id="item_63">使用部门资产管理员删除功能</li>
				                              <li class="list-group-item" id="item_64">使用部门资产管理员查询功能</li>
				                              <li class="list-group-item" id="item_65">使用部门资产管理员导入导出功能</li>
				                              <li class="list-group-item" id="item_66">使用部门资产管理员其他功能</li>
				                            </ul>
				                        </div>
				                    </div> 
				                </div>
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input class="btn btn-primary modal_save" data-dismiss="modal" value="保存">
						<input class="btn btn-primary modal_giveUp" data-dismiss="modal" value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="modalRename">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
					<div class="container-f">
						<div class="box-title clearfix" style="border-bottom:none;padding-bottom:0px;padding-top:0px;">
							<div class="f_l"><h3><i class="fa fa-edit"></i>重命名角色</h3></div>
						</div>
					</div>
				</div>
				<div class="modal-body" style="padding:0px;">
					<div class="row clearfix">
						<form class="form-horizontal ajax_form" id="modal_add" class="input-xlarge" style="margin-left:60px;">
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									序号：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_rename_id" data-rule-maxlength="60"  class="input-medium ipt_require" style="height:30px;width:250px;border:1px solid #ddd;" value="1">
								</div>
							</div>
							<div class="control-group cf clearfix ">
								<label class="control-label" for="web_bg">
									角色名称：
								</label>
								<div class="controls">
									<input type="text" name="title" id="modal_add_id" data-rule-maxlength="60"  class="input-medium ipt_require" style="height:30px;width:250px;border:1px solid #ddd;" value="财务部门资产管理员">
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<div class="form-actions">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_save" data-dismiss="modal" value="保存">
						<input type="hidden" name="id">
						<input class="btn btn-primary modal_giveUp" data-dismiss="modal" value="取消">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.pagination.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
	<script>
		$(document).ready(function(){
			$(".panel-heading").click(function(){
				if($(this).find("font").hasClass("tran")){
					$(this).find("font").html("v");
					$(this).find("font").removeClass("tran");
				}else{
					$(this).find("font").html(">");
					$(this).find("font").addClass("tran");
				}
            });
            
			$(".list-group-item").click(function(){
				//$(".list-group-item").removeClass("activeList");
				//$(this).addClass("activeList");
				var conten=$(this).html();
				var cont="<li class='listGroupItem0' id='"+$(this).attr('id')+"'>"+conten+"<i class='fa' style='float:right;'></i></li>";
				
				//$("#listGroupItemUl").remove(cont);
				if(!($(this).hasClass("activeList"))){
					$(this).addClass("activeList");
					$("#listGroupItemUl").append(cont);
				}
				
				$(".listGroupItem0").mouseover(function(){
					$(this).find("i.fa").addClass("fa-times");
				});
				$(".listGroupItem0").mouseout(function(){
					$(this).find("i.fa").removeClass("fa-times");
				});
				$("i.fa").click(function(){
					var results=$(this).parents(".listGroupItem0").attr("id");
					$(".list-group").find("#"+results).removeClass("activeList");
					$(this).parents(".listGroupItem0").hide();
				});
			});
			$(".listGroupItem0").mouseover(function(){
				$(this).find("i.fa").addClass("fa-times");
			});
			$(".listGroupItem0").mouseout(function(){
				$(this).find("i.fa").removeClass("fa-times");
			});
			$("i.fa").click(function(){
				var resulted=$(this).parents(".listGroupItem0").attr("id");
				$(".list-group").find("#"+resulted).removeClass("activeList");
				$(this).parents(".listGroupItem0").hide();
			});
			
			
			
		});
		
	</script>
	<script type="text/javascript">
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
	<script type="text/javascript" src="<%=basePath %>Public/Js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>Public/Js/bootstrap.min.js"></script>
	<script>
		var modaling=document.getElementsByClassName("modal-dialog");
		$(function(){
	    	$("#addBtn").click(function(){
	        	$("#modalAdd").modal("toggle");
	        	modaling[0].style.marginTop=($(window).height())/4+"px";
	    	});
	    	$('#modalAdd').on('shown.bs.modal', function () {
			  	$('#modal_add_id').focus();
			});
	    });
	    
	    $(function(){
	    	$(".updateBtn").click(function(){
	        	$("#modalUpdate").modal("toggle");
	    	});
	    	$('#modalUpdate').on('shown.bs.modal', function () {
			  	$('#query_btn').focus();
			});
	    });
	    $(function(){
	    	$(".renameBtn").click(function(){
	        	$("#modalRename").modal("toggle");
	        	modaling[2].style.marginTop=($(window).height())/4+"px";
	    	});
	    	$('#modalRename').on('shown.bs.modal', function () {
			  	$('#modal_rename_id').focus();
			});
	    });
	</script>
</body>
</html>

