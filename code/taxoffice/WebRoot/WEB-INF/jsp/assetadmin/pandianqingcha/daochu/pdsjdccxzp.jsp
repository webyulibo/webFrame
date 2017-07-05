<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/pageuri" prefix="cc"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>   


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>资产盘点清查</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/tablezp.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
     <script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
      <script type="text/javascript" src="<%=basePath %>Public/Js/laydate.js"></script>
      
      <script src="Public/Js/jquery-2.1.4.js" type="<%=basePath %>text/javascript"></script>
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
      <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
 
 		<script type="text/javascript">
 			
 			function subForm() {
 			
 			  document.getElementById("editform").submit();
		
			}
 		
 		</script>
 		
 		
 
 
  </head>
  <body>
	
	
	
	<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a
					href="<%=basePath%>adminassetcheckdataexportcontroller/getassetspageshow.htm">
					<span class="fa fa-table"></span> 盘点数据导出
				</a>
			</h3>
			<h3>
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
		<div class="box-content clearfix">
		<div class="row clearfix">
				<div class="control-group f_l">
					<div class="f_l">
						<a href="<%=basePath %>adminassetcheckdataexportcontroller/exportdepartmentandusertotext.htm" style="width:140px;margin-top:10px;margin-left:10px;margin-bottom:30px;" id="addBtn" class="btn cf"> <i class="fa fa-edit"></i><span>导出部门与人员信息</span></a>
					</div>
				</div>
			</div>
		<form action="<%=basePath %>adminassetcheckdataexportcontroller/getassetcheckresultwithpage.htm" class="form-horizontal ajax_form"  method="post"  id="editform">
		<fieldset class="search" >
		
			<legend><span>查询条件</span></legend>
			
			
			
			<table style="width:100%;">
				<tr>
					<td style="width:50%">
						<div class="add">
							<table>
							
								<tr>
									<td><h2>使用状态：</h2></td>
									<td>
									<%-- <form action="<%=basePath %>adminassetcheckdataexportcontroller/getassetcheckresultwithpage.htm" method="post" > --%>
										<select class="easyui-combobox"  name="usestate" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
										   <option value="" checked="checked"></option>
											<option value="在用" >在用</option>
											<option value="闲置">闲置</option>
											<option value="损坏不能用">损坏不能用</option>
											
										</select>
										<!-- <input type="submit" value="产训">
										
										</form> -->
									</td>
								</tr>
								<tr>
									<td><h2>资产代码：</h2></td>
									<td>
										<select class="easyui-combobox" name="code" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"  class="easyui-combobox"  style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="assetcode1">
<!-- 										 <option value=""></option>
											<option value="电脑">电脑 </option>
											<option value="csdn">csdn </option>
											<option value="123">123</option> -->
										</select>
										<!--<div class="diffinputdiv">     
											<span class="diffinputspan">     
												<select class="diffinputsel" onchange="this.parentNode.nextSibling.value=this.value">     
													<option value="电脑">电脑 </option>  
													<option value="csdn">csdn </option>     
													<option value="123">123</option>  
												</select>
											</span>
											<input name="box" class="diffinput">     
										</div>-->
									</td>
								</tr>
								<tr>
									<td><h2>保管部门：</h2></td>
									<td>
										<select class="easyui-combobox" name="keepdepartment" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="keepdep">
									<!-- 	<option value="" checked="checked"></option>
											<option value="办公室" >办公室</option>
											<option value="秘书室">秘书室</option>
											<option value="宣传部">宣传部</option> -->
										</select>
									</td>
								</tr>
								<tr>
									<td><h2>使用部门：</h2></td>
									<td>
										<select class="easyui-combobox" name="usedepartment" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="usedep">
										<!-- 	<option value="" checked="checked"></option>
											<option value="办公室" >办公室</option>
											<option value="秘书室">秘书室</option>
											<option value="宣传部">宣传部</option> -->
										</select>
									</td>
								</tr>
								<tr>
									<td><h2>是否期初：</h2></td>
									<td>
				                		<select class="easyui-combobox" name="isbegin1" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
				                		<option value="" checked="checked"></option>
											<option value="是" >是</option>
											<option value="否">否</option>
										</select>
				                	</td>
								</tr>
							</table>
						</div>
					</td>
					<td style="width:50%">
						<div class="add">
							<table>
								<tr>
									<td><h2>状态：</h2></td>
									<td>
										<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
							
											<option value="" checked="checked"></option>
											<option value="正常" >正常</option>
											<option value="盘亏">盘亏</option>
										</select>
									</td>
								</tr>
								<tr>
									<td><h2>资产名称：</h2></td>
									<td>
										<select class="easyui-combobox" name="name" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"  id="assetname1">
										<!-- 	<option value="" checked="checked"></option>
											<option value="" ></option> -->
										</select>
										<pbname></pbname>
									</td>
									<!-- <td><input type="text" class="in" id="assetname1"  name="name"> <pbname></pbname></td> -->
								</tr>
								<tr>
									<td><h2>保管人：</h2></td>
									<td>
										<select class="easyui-combobox" name="keeper" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="keeper">
											<!-- <option value="" checked="checked"></option>
											<option value="" ></option> -->
										</select>
									</td>
								</tr>
								<tr>
									<td><h2>使用人：</h2></td>
									<td>
										<select class="easyui-combobox" name="user" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="user">
										<!-- 	<option value="" checked="checked"></option>
											<option value="" ></option> -->
										</select>
									</td>
								</tr>
								<tr>
									<td><h2>报废年度：</h2></td>
									<td>
				                		<input style="width:150px" type="text"  name="ghostyear" pattern="yyyy-MM-dd" data-rule-maxlength="60" placeholder="" class="laydate-icon" id="demo0"/>
				                	</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="add">
							<table>
							<tr>
					<td><h2>资产类型：</h2></td>
					
					<td>
						<select name="type1" value="" class=" sel" style="display:block">
							<!-- <option value="1" checked="checked"/>请选择</option> -->
							<option value="请选择">请选择</option>
							
							
							<c:forEach items="${list }" var="menu">
								<option value="${menu.typename }" >${menu.typename }</option>
							</c:forEach>
							
						</select>
					</td>
					<td>
						<select name="type2" style="display:none;" class="sel" value='1'>
						<!-- 	<option value="大型设备" checked="checked">大型设备</option>
							<option value="文具类" >文具类</option>
							<option value="电子类">电子类</option> -->
							
						</select>
					</td>
					<td>
						<select name="type3" style="display:none;" class=" sel" value='1'>
							
							
						</select>
					</td>
					<td>
						<select name="type4" style="display:none;" class="sel" value='1'>
							
							
						</select>
					</td>
					<td>
						<select name="type5" style="display:none;" class="sel" value='1'>
							
							
						</select>
					</td>				
					</tr>
					<tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td style="width:50%">
						<div class="add">
						
						
							<table>
							
								<tr>
									<td><h2>起始购置日期：</h2></td>
									<td>
										<input style="width:150px" name="purchasetime" type="text" pattern="yyyy-MM-dd" data-rule-maxlength="60" placeholder="" class="laydate-icon" id="demo1"/>
									</td>
								</tr>
								<tr>
									<td><h2>起始制卡日期：</h2></td>
									<td>
										<input style="width:150px" type="text" name="makecardtime" pattern="yyyy-MM-dd" data-rule-maxlength="60" placeholder="" class="laydate-icon" id="demo2">
									</td>
								</tr>
								<tr>
									<td><h2>起始启用日期：</h2></td>
									<td>
										<input style="width:150px" type="text" name="startusetime" pattern="yyyy-MM-dd" data-rule-maxlength="60" placeholder="" class="laydate-icon" id="demo3">
									</td>
								</tr>
								<tr>
									<td><h2>起始资产金额：</h2></td>
									<td>
										<input type="number" name="value" value=""/>
									</td>
								</tr>
							</table>
						</div>
					</td>
					<td style="width:50%">
						<div class="add">
							<table>
								<tr>
									<td><h2>截止购置日期：</h2></td>
									<td>
										<input style="width:150px" type="text" name="abortpurchasetime" pattern="yyyy-MM-dd" data-rule-maxlength="60" placeholder="" class="laydate-icon" id="demo4"/>
									</td>
								</tr>
								<tr>
									<td><h2>截止制卡日期：</h2></td>
									<td>
										<input style="width:150px" type="text"  name="abortmakecardtime"  pattern="yyyy-MM-dd" data-rule-maxlength="60" placeholder="" class="laydate-icon" id="demo5">
									</td>
								</tr>
								<tr>
									<td><h2>截止启用日期：</h2></td>
									<td>
										<input style="width:150px" type="text"  name="abortstartusetime"  pattern="yyyy-MM-dd" data-rule-maxlength="60" placeholder="" class="laydate-icon" id="demo6">
									</td>
								</tr>
								<tr>
									<td><h2>截止资产金额：</h2></td>
									<td>
										<input type="number" name="abortvalue" value=""/>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>
				<!-- </form> -->
					<td colspan="2">
						<div class="control-group f_l">
								<a id="myCheck" style="margin-top:10px;margin-right:100px;float:right;" onclick="subForm()" class="btn cf"  href="javascript:void(0)"> 
									<i class="fa fa-search"></i>
									<span>查询</span>
								</a>
						</div>
					</td> 
					<!-- <input type="submit" value="查询"> -->
				</tr>
				
				
			</table>
			
				
		</fieldset>
		</form>
		</div>
	</div>
	
	
	
    <%-- <shiro:hasPermission name="sysauth">
		<script type="text/javascript">
		
	
			document.getElementById("myCheck").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			
		</script>	
	</shiro:hasPermission> --%>
		
<script type="text/javascript">






!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#demo0'});
	var start1 = {
		elem: '#demo1',
		format: 'YYYY-MM-DD',
		max: '2099-06-16', //最大日期
		istime: true,
		istoday: false,
		choose: function(datas){
		     end1.min = datas; //开始日选好后，重置结束日的最小日期
		     end1.start = datas; //将结束日的初始值设定为开始日
		}
	};

	var end1 = {
		elem: '#demo4',
		format: 'YYYY-MM-DD',
		max: '2099-06-16',
		istime: true,
		istoday: false,
		choose: function(datas){
		    start1.max = datas; //结束日选好后，充值开始日的最大日期
		}
	};
	laydate(start1);
	laydate(end1);
	
	var start2 = {
			elem: '#demo2',
			format: 'YYYY-MM-DD',
			max: '2099-06-16', //最大日期
			istime: true,
			istoday: false,
			choose: function(datas){
			     end2.min = datas; //开始日选好后，重置结束日的最小日期
			     end2.start = datas; //将结束日的初始值设定为开始日
			}
		};

		var end2 = {
			elem: '#demo5',
			format: 'YYYY-MM-DD',
			max: '2099-06-16',
			istime: true,
			istoday: false,
			choose: function(datas){
			    start2.max = datas; //结束日选好后，充值开始日的最大日期
			}
		};
		laydate(start2);
		laydate(end2);
		
		var start3 = {
				elem: '#demo3',
				format: 'YYYY-MM-DD',
				max: '2099-06-16', //最大日期
				istime: true,
				istoday: false,
				choose: function(datas){
				     end3.min = datas; //开始日选好后，重置结束日的最小日期
				     end3.start = datas; //将结束日的初始值设定为开始日
				}
			};

			var end3 = {
				elem: '#demo6',
				format: 'YYYY-MM-DD',
				max: '2099-06-16',
				istime: true,
				istoday: false,
				choose: function(datas){
				    start3.max = datas; //结束日选好后，充值开始日的最大日期
				}
			};
			laydate(start3);
			laydate(end3);
	
}();
$(document).ready(function(){
	 var a = $('.sel1').val();
	 if(!a){
		$('.sel1').css('display','none');
	 }else{
		$('.sel1').css('display','block');
	 }
 	
});
</script>

<script type="text/javascript">
 				function hidden(type){
 			
				var num = type.substring(4,5);
				
				num = parseInt(num); 
				num++;
				var child = "type"+num;
				//大于5说明没有当前节点没有子节点
				if(num>5){
						
				}else{
					//将子节点清空
					$("select[name='"+type+"']").empty();
					//隐藏子节点
					hidden(child);
				}
				//隐藏当前节点
				$("select[name='"+type+"']").css('display','none');
		}
		
		
			list = "";
			$('.sel').change(function(){
				///获取name属性，截取字符串，获取当前的节点序号，然后加加
				var type = $(this).attr('name');
				var num = type.substring(4,5);
				num = parseInt(num); 
				num++;
				var child = "type"+num;
				
				//隐藏子节点，及子节点的子节点们
				hidden(child);
				///显示子节点
				
				var value = $(this).val();
				
				var ajax_url = '<%=basePath%>adminasset/selectchildassettype.htm';
				var ajax_data = '{name:'+value+'}';
							
							$.ajax({
							type:'post',
					     		url:ajax_url, //表单提交目标 
					     		data:{name:value}, //表单数据
					    		success:function(e){
						     		var data = eval("("+e+")");
						     		
						      		if(data.msg == "error"){//msg 是后台调用action时，你穿过来的参数
						       			$("select[name='"+child+"']").css('display','none');
						      			//location.href="<%=basePath%>adminasset/showassetmenu.htm";
						      		}else{
										var array =   data.msg.split("#");
										$("select[name='"+child+"']").css('display','block');
										
										$("select[name='"+child+"']").append("<option value='"+'请选择'+"'>"+'请选择'+"</option>");
										
										//alert($("input[name='type']").val());
										 for(var i = 0;i<array.length;i++){
											
											$("select[name='"+child+"']").append("<option value='"+array[i]+"'>"+array[i]+"</option>");
											
										} 
						      		}
						      		//获取当前项的值
						      		var typevalue = $("select[name='"+type+"']").val();
						      		if(typevalue!="请选择"){//如果不等于请选择，提交的值为选中的值
						      			$("input[name='type']").val(typevalue);
						      		}
						      		else{//如果为请选择，那么则为上一级菜单的值
						      			num--;
						      			num--;
						      			if(num==0){
						      				alert("请选择分类，否则可将导致系统异常");
						      				return;
						      			}
										var fth = "type"+num;
										$("input[name='type']").val($("select[name='"+fth+"']").val());
						      		}
			     				}
			     			}); 
			}); 
 		
 		</script>


<script type="text/javascript">
		function getInfoByPage() {
			var inputpage=document.getElementById("inputPage").value;
			
			if(inputpage.length==0){
				//alert("请输入合法数据")
				document.getElementById("inputPage").value="";
				document.getElementById("inputPage").focus();
				return;
			}
			else{
				if(!isNaN(inputpage)){
					var totalPage=document.getElementById("inputPage").getAttribute("totalPage");
					if(inputpage>totalPage){
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
					document.getElementById("inputPage").focus();
				}
			}						
		}
		
		
		
		$(function(){
			$('#keepdep').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>AdminAssetBorrowController/getborrowdepjson.htm',
			    valueField:'text', //设置combobox的value
			    textField:'text',//设置combobox显示的text
			    editable:true
			    });
		}); 
		$(function(){
			$('#keeper').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
			    valueField:'text', //设置combobox的value
			    textField:'text',//设置combobox显示的text
			    editable:true
			    });
		});
		
		
		<%-- $('#keepdep').combobox({  
		    onSelect:function(record){  
		   	 $('#keeper').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		   		    url:'<%=basePath%>AdminAssetBorrowController/getdepartmentpeoplejson.htm?borrowdep='+record.text,
		   		    valueField:'text', //设置combobox的value
		   		    textField:'text',//设置combobox显示的text
		   		    editable:true
		   		    });
		   	 } 
		});  --%>
		$('#keepdep').combobox({  
		    onChange:function(){  
		   if($('#keepdep').combobox('getText')=="")
		    {	
				$(function(){
					$('#keeper').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
					    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
					    valueField:'text', //设置combobox的value
					    textField:'text',//设置combobox显示的text
					    editable:true
					    });
			});
		    }
		    }
		});
		
		
		
		
		$(function(){
			$('#usedep').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>AdminAssetBorrowController/getborrowdepjson.htm',
			    valueField:'text', //设置combobox的value
			    textField:'text',//设置combobox显示的text
			    editable:true
			    });
		}); 
		$(function(){
			$('#user').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
			    valueField:'text', //设置combobox的value
			    textField:'text',//设置combobox显示的text
			    editable:true
			    });
		});
		$('#usedep').combobox({  
		    onSelect:function(record){  
		   	 $('#user').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		   		    url:'<%=basePath%>AdminAssetBorrowController/getdepartmentpeoplejson.htm?borrowdep='+record.text,
		   		    valueField:'text', //设置combobox的value
		   		    textField:'text',//设置combobox显示的text
		   		    editable:true
		   		    });
		   	 } 
		}); 
		$('#usedep').combobox({  
		    onChange:function(){  
		   if($('#usedep').combobox('getText')=="")
		    {	
				$(function(){
					$('#user').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
					    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
					    valueField:'text', //设置combobox的value
					    textField:'text',//设置combobox显示的text
					    editable:true
					    });
			});
		    }
		    }
		});
		
		
		//assetcode的json串
		$(function(){
			$('#assetcode1').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>AdminAssetBorrowController/getallassetcodejson.htm',
			    valueField:'text', //设置combobox的value
			    textField:'text',//设置combobox显示的text
			    editable:true
			    });
		}); 
		//assetname的json串
		$(function(){
			$('#assetname1').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>AdminAssetBorrowController/getallassetnamejson.htm',
			    valueField:'text', //设置combobox的value
			    textField:'text',//设置combobox显示的text
			    editable:true
			    });
		}); 
   //资产编码对应的onSelect事件
		$('#assetcode1').combobox({  
		    onSelect:function(record){  
		    var assetcode=record.text;
		     $.ajax({
		    	 type:"post",
		    	 url:'<%=basePath %>AdminAssetBorrowController/getassetname.htm',
		         data : {assetcode:assetcode},
				success : function(e) {
					var data = eval("(" + e + ")");
					if(data.state=="1"){
						$('#assetname1').combobox('setValue',data.assetname); 
					}
					if(data.state=="0"){
						$('#assetname1').combobox('setValue',"无此资产"); 
					}
			}
	});  
		    }
		});  
		   //资产名称对应的onSelect事件
		$('#assetname1').combobox({  
		    onSelect:function(record){  
		    var assetname=record.text;
		     $.ajax({
		    	 type:"post",
		    	 url:'<%=basePath %>AdminAssetBorrowController/getassetcode.htm',
		         data : {assetname:assetname},
				success : function(e) {
					var data = eval("(" + e + ")");
					if(data.state=="1"){
						$('#assetcode1').combobox('setValue',data.assetcode); 
					}
					if(data.state=="0"){
						$('#assetcode1').combobox('setValue',"无此资产"); 
					}
			}
	});  
		    }
		}); 
		//资产编码对应的onChange事件
		$('#assetcode1').combobox({  
		    onChange:function(){  
		    var assetcode=$('#assetcode1').combobox('getValue'); 
		    $.ajax({
		    	 type:"post",
		    	 url:'<%=basePath %>AdminAssetBorrowController/getassetname.htm',
		         data : {assetcode:assetcode},
				success : function(e) {
					var data = eval("(" + e + ")");
					if(data.state=="1"){
						$('#assetname1').combobox('setValue',data.assetname); 
					}
					if(data.state=="0"){
						$('#assetname1').combobox('setValue',"无此资产"); 
					}
			}
	});  
		    }
		});
	</script>

	<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		document.getElementById("addBtn").setAttribute("href","javascript:void(0)");
		document.getElementById("addBtn").setAttribute("onclick","alert('权限不足，无法进行此操作')");	
		
		var userdepnameString1="${userdepnameString}";
		$(function(){
			
			$('#keepdep').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>adminassetcheckdataexportcontroller/userdepnameStringToJson.htm?userdepnameString='+userdepnameString1,
			    valueField:'userdepnameString', //设置combobox的value
			    textField:'userdepnameString',//设置combobox显示的text
			    editable:false,
			    onSelect:function(record){  
			    	/* alert($('#keepdep').combobox('getValue')); */
			      	 $('#keeper').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			      		    url:'<%=basePath%>AdminAssetBorrowController/getdepartmentpeoplejson.htm?borrowdep='+$('#keepdep').combobox('getValue'),
			      		    valueField:'text', //设置combobox的value
			      		    textField:'text',//设置combobox显示的text
			      		    editable:true
			      		    });
			      	 } 
			    });
		
			
			$('#usedep').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>adminassetcheckdataexportcontroller/userdepnameStringToJson.htm?userdepnameString='+userdepnameString1,
			    valueField:'userdepnameString', //设置combobox的value
			    textField:'userdepnameString',//设置combobox显示的text
			    editable:false,
			    onSelect:function(record){  
			    	/* alert($('#keepdep').combobox('getValue')); */
			      	 $('#user').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			      		    url:'<%=basePath%>AdminAssetBorrowController/getdepartmentpeoplejson.htm?borrowdep='+$('#usedep').combobox('getValue'),
			      		    valueField:'text', //设置combobox的value
			      		    textField:'text',//设置combobox显示的text
			      		    editable:true
			      		    });
			      	 } 
			    });
			
			/* $('#keepdep').combobox("setValuet",userdepnameString1); */
		})
		
		
		</script>
		
	
	</shiro:hasPermission>


  </body>
</html>
