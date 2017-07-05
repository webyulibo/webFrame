<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/mymain.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
          <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
     <script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
      <script type="text/javascript" src="<%=basePath %>Public/Js/laydate.js"></script>
      
      <script src="Public/Js/jquery-2.1.4.js" type="<%=basePath %>text/javascript"></script>
      <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
 
  </head>
  <body onload="load()">
		<form action="" class="form-horizontal ajax_form" id="editform">
		<div class="container-f">
		<div class="box-title clearfix tab-title">
			<h3 class="current">
				<a href="<%=basePath %>adminasset/showassetmenu.htm">
				<span class="fa fa-table"></span>
				资产管理
				</a>
			</h3>
			<h3>
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
		<div class="box-content clearfix" style="max-width:1097px;float:left;">
			<div class="add"  style="clear:both;width:1000px">
				<table>
				<tr>
					<td><h2>资产类型：</h2></td>
						<td>
							<input type="hidden" name="list"/>
							<input type="hidden" class="cate" name="type" value="${asset.type }" id="assetType"/>
							
					 	<select name="type1" value="" class="sel" style="display:block"> 
							<!-- <option value="1" checked="checked"/>请选择</option> -->
							
							<c:forEach items="${list1 }" var="item" varStatus="s">
								<c:if test="${s.index+1 eq fn:length(list1) }">
								<option value="${item.typename }"  selected="selected">${item.typename }</option>
								</c:if>
								<c:if test="${s.index+1 ne fn:length(list1) }">
								<option value="${item.typename }" >${item.typename }</option>
								</c:if>
							</c:forEach>
							
						</select>
					</td>
					<td>
						<c:if test="${fn:length(list2) ne 0 }">
					
							 <select name="type2" style="display:block;" class="sel" value='1'> 
						</c:if>
							<c:if test="${fn:length(list2) eq 0 }">
					
					 		<select name="type2" style="display:none;" class="sel" value='1'> 
							</c:if>
							<c:forEach items="${list2 }" var="item" varStatus="s">
								<c:if test="${s.index+1 eq fn:length(list) }">
								<option value="${item.typename }"  selected="selected">${item.typename }</option>
								</c:if>
								<c:if test="${s.index+1 ne fn:length(list) }">
								<option value="${item.typename }" >${item.typename }</option>
								</c:if>
							</c:forEach>
							
						</select>
					</td>
					<td>
						<c:if test="${fn:length(list3) ne 0 }">
						
							 <select name="type3" style="display:block;" class="sel" value='1'> 
						</c:if>
							<c:if test="${fn:length(list3) eq 0 }">
							
								 <select name="type3" style="display:none;" class="sel" value='1'>
							</c:if>
							<c:forEach items="${list3 }" var="item" varStatus="s">
								<c:if test="${s.index eq fn:length(list3)-1 }">
								<option value="${item.typename }"  selected="selected">${item.typename }</option>
								</c:if>
								<c:if test="${s.index ne fn:length(list3)-1 }">
								<option value="${item.typename }" >${item.typename }</option>
								</c:if>
							</c:forEach>
							
						</select>
					</td>
					<td>
					
						<c:if test="${fn:length(list4) ne 0 }">
							
	 						<select name="type4" style="display:block;" class="sel" value='1'> 
						</c:if>
							<c:if test="${fn:length(list4) eq 0 }">
					
						<select name="type4" style="display:none;" class="sel" value='1'> 
							</c:if>
							
							<c:forEach items="${list4 }" var="item" varStatus="s">
							
								<c:if test="${(s.index + 1) eq fn:length(list4) }">
								<option value="${item.typename }" selected="selected">${item.typename }</option>
								</c:if>
								<c:if test="${s.index+1  ne fn:length(list4) }">
								<option value="${item.typename }" >${item.typename }</option>
								</c:if>
							</c:forEach>
							
						</select>
					</td>
					<td>
						<c:if test="${fn:length(list5) ne 0 }">
						
							<select name="type5" style="display:block;" class="sel" value='1'> 
						</c:if>
							<c:if test="${fn:length(list5) eq 0 }">
								
								 <select name="type5" style="display:none;" class="sel" value='1'> 
							</c:if>
							<c:forEach items="${list5 }" var="item" varStatus="s">
								<c:if test="${s.index eq fn:length(list5)-1 }">
								<option value="${item.typename }" checked="checked">${item.typename }</option>
								</c:if>
								<c:if test="${s.index ne fn:length(list5)-1 }">
								<option value="${item.typename }" >${item.typename }</option>
								</c:if>
							</c:forEach>
							
						</select>
					</td>				
						
					
					</tr>
					<tr>
					</table>
			</div>
			<div class="add" style="min-width: 421px;">
				<table>
					<c:if test="${not empty asset}">
					<tr>
					<td><h2>账套：</h2></td>
					<td>
					<input type="text" placeholder="河北省秦皇岛市国家税务局国有资产 账套01" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='河北省秦皇岛市国家税务局国有资产 账套01'" value="${asset.sob }" name="sob" id="sob">
					<input type="hidden" class="assetCurrentPage" value="${assetCurrentPage }" id="assetCurrentPage">
					</td>
					</tr>
					<tr>
					<td><h2>资产代码：</h2></td>
					<!-- disabled="disabled" -->
					<td><input type="text" value="${asset.code }" data-rule-maxlength="60" name="code" id="code" readonly="readonly">
						<input type="hidden" value="${asset.id }" name="id">
					</td>
					</tr>
					<tr>
					<td><h2>资产名称：</h2></td>
					<!-- disabled="disabled" -->
					<td><input type="text" value="${asset.name }" data-rule-maxlength="60" name="name" id="name" readonly="readonly"></td>
					</tr>
					
					<tr>
					<td><h2>规格型号：</h2></td>
					<td><input type="text" value="${asset.model }" data-rule-maxlength="60" name="model" id="model"></td>
					</tr>
					<tr>
					<td><h2>购置日期：</h2></td>
					<td>
                	<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="申请日期" class="laydate-icon" id="demo"  value=" <fmt:formatDate pattern="yyyy-MM-dd" value="${asset.purchasetime }"/> " name="purchasetime"/> 
                	</td>
					</tr>
					<tr>
					<td><h2>资产金额：</h2></td>
					<td><input type="text" value="${asset.value }" data-rule-maxlength="60" name="value" placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='小数点后最多保留两位'" id="value"></td>
					</tr>
					<tr>
					<td><h2>使用部门：</h2></td>
					<td>
					<select class="sel easyui-combobox" name="usedepartment"  id="usedepartment"  style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >	
					</select>
					</td>
					</tr>
					<tr>
					<td><h2>使用人：</h2></td>
					<td>
					<%-- <input type="text" value="${asset.user }" data-rule-maxlength="60" name="user" id="user"> --%>
					<select class="easyui-combobox sel" name="user" id="user" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >
					</select>
					</td>
					</tr>
					<tr>
					<td><h2>备注：</h2></td>
					<td><textarea rows="3" cols="40" value="${asset.remark }" name="remark"></textarea></td>
					</tr>
					
					</c:if>

				</table>
				<input class="btn btn-primary" type="submit" value="修改" id="edit" style="margin-left:25%;margin-top:10%;">
			</div>
			<div class="add sec" style="min-width: 262px;">
				<table>
					<c:if test="${not empty asset}">
					<tr>
					<td><h2>保管部门：</h2></td>
					<td>
					<select class="sel easyui-combobox" name="keepdepartment"  id="keepdepartment" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >	
					</select>
					<%-- <input type="text" value="${asset.keepdepartment }" data-rule-maxlength="60" name="keepdepartment"> --%>
					</td>
					</tr>
					<tr>
					<td><h2>保管人：</h2></td>
					<td>
					<%-- <input type="text" value="${asset.keeper }" data-rule-maxlength="60" style="width:150px" name="keeper" id="keeper"> --%>
					<!-- <select class="easyui-combobox sel" name="keeper" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="keeper">
						<option value="刘仁鹏" >刘仁鹏</option>
						<option value="于海强">于海强</option>
						<option value="董浩" >董浩</option>
					</select> -->
					<select class="easyui-combobox sel" name="keeper" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="keeper">
					</select>
					</td>
					</tr>
					<tr>
					<td><h2>使用状态：</h2></td>
					<td>
					
					<select class="sel easyui-combobox" name="usestate"  id="usestate" value='1' style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >	
			  			<option value="在用">在用</option>
						<option value="闲置">闲置</option>
						<option value="损坏不能用">损坏不能用</option>
			  		</select>
					<%-- <input type="text" value="${asset.usestate }" data-rule-maxlength="60" name="usestate"> --%>
					</td>
					</tr>
					<tr>
					<td><h2>凭证字号：</h2></td>
					<td><input type="text" value="${asset.certificate }" data-rule-maxlength="60" name="certificate" id="certificate"></td>
					</tr>
					<tr>
					<td><h2>状态：</h2></td>
					<td>
					<select class="sel easyui-combobox" name="state"  id="state" value='1' style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" >	
			  			<option value="正常" checked="checked">正常</option>
						<option value="盘亏">盘亏</option>
						<option value="记账">记账</option>
			  		</select>
					<%-- <input type="text" value="${asset.state }" data-rule-maxlength="60" name="state"> --%>
					</td>
					</tr>
					<tr>
					<td><h2>是否期初：</h2></td>
					<td>
					<span>
					<c:if test="${asset.isbegin}">
					<input type="radio" name="qc" checked="checked" name="isbegin">是
					<input type="radio" name="qc" name="isbegin">否
					</c:if>
					<c:if test="${!asset.isbegin}">
					<input type="radio" name="qc" name="isbegin">是
					<input type="radio" name="qc" checked="checked" name="isbegin">否
					</c:if>
					</span>
					
					</td>
					</tr>
					<tr>
					<td><h2>报废年度：</h2></td>
					<td><input type="text" value="${asset.ghostyear }" data-rule-maxlength="60" name="ghostyear" id="ghostyear"></td>
					</tr>
					<tr>
					<td><h2>启用日期：</h2></td>
					<td><input type="text" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${asset.startusetime }"/>" data-rule-maxlength="60" placeholder="启用日期" class="laydate-icon" id="demo2" name="startusetime"></td>
					</tr>
					<tr>
					<td><h2>制卡日期：</h2></td>
					<td><input type="text" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${asset.makecardtime }"/>" data-rule-maxlength="60" placeholder="制卡日期" class="laydate-icon" id="demo3" name="makecardtime"></td>
					</tr>
					</c:if>
					
				</table>
			</div>
			
	</div>
</div>
		</form>
		<%-- <fmt:formatDate value="${purch }" pattern="yyyy/MM/dd"/> --%>
		<input type="hidden"  value="${asset.usedepartment }" data-rule-maxlength="60" name="usedepartmenthidden" id="usedepartmenthidden"> 
		<input type="hidden" value="${asset.user }" data-rule-maxlength="60" name="userhidden" id="userhidden"> 
		<input type="hidden" value="${asset.keeper }" data-rule-maxlength="60" name="keeperhidden" id="keeperhidden">
		<input type="hidden" value="${asset.keepdepartment }" data-rule-maxlength="60" name="keepdepartmenthidden" id="keepdepartmenthidden">
		<input type="hidden" value="${asset.usestate }" data-rule-maxlength="60" name="usestatehidden" id="usestatehidden">
		<input type="hidden" value="${asset.state }" data-rule-maxlength="60" name="statehidden" id="statehidden">
 <script>
  function load(){//加载完即对性别进行赋值
  
  	var usedepartmenthidden=document.getElementById("usedepartmenthidden").value;
  	var userhidden=document.getElementById("userhidden").value;
  	var keeperhidden=document.getElementById("keeperhidden").value;
  	var keepdepartmenthidden=document.getElementById("keepdepartmenthidden").value;
  	var usestatehidden=document.getElementById("usestatehidden").value;
  	var statehidden=document.getElementById("statehidden").value;


  	$('#usedepartment').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminusermanagercontroller/getdepjson.htm',
      		    valueField:'depnametext', //设置combobox的value
      		    textField:'depnametext',//设置combobox显示的text
      		    editable:true//在此处是不能够添加部门的
      		    });
  
   $('#keepdepartment').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>adminusermanagercontroller/getdepjson.htm',
      		    valueField:'depnametext', //设置combobox的value
      		    textField:'depnametext',//设置combobox显示的text
      		    editable:true//在此处是不能够添加部门的
      		    });

     $('#usedepartment').combobox('select',usedepartmenthidden);
     
     $('#keepdepartment').combobox('select',keepdepartmenthidden);
     
     $('#usestate').combobox('select',usestatehidden);
     $('#state').combobox('select',statehidden);
     
     var usedepname = $('#usedepartment').combobox('getValue');
     var keepdepname = $('#keepdepartment').combobox('getValue'); 
     $('#user').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>admindepartmentcontroller/getusernamebyassetdep.htm?depname='+usedepname,
      		    valueField:'username', //设置combobox的value
      		    textField:'username',//设置combobox显示的text
      		    editable:true
      		    });
     $('#keeper').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
      		    url:'<%=basePath%>admindepartmentcontroller/getusernamebyassetdep.htm?depname='+keepdepname,
      		    valueField:'username', //设置combobox的value
      		    textField:'username',//设置combobox显示的text
      		    editable:true
      		    });
     $('#user').combobox('select',userhidden);
     $('#keeper').combobox('select',keeperhidden);
  }
  </script>
<script type="text/javascript">

		$(document).ready(function(){
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
						     		$("select[name='"+child+"']").append("<option value='"+'请选择'+"'>"+'请选择'+"</option>");
						      		if(data.msg == "error"){//msg 是后台调用action时，你穿过来的参数
						       			
						      			//location.href="<%=basePath%>adminasset/showassetmenu.htm";
						      		}else{
										var array =   data.msg.split("#");
										$("select[name='"+child+"']").css('display','block');
										
										//alert($("input[name='type']").val());
										 for(var i = 0;i<array.length;i++){
											
											$("select[name='"+child+"']").append("<option value='"+array[i]+"'>"+array[i]+"</option>");
											
										} 
						      		}
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
});

!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#demo'});//绑定元素
}();

!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#demo2'});//绑定元素
}();
!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#demo3'});//绑定元素
}();
	//alert("${asset.id}");
	
$(document).ready(function(){
	 var a = $('.sel1').val();
	 if(!a){
		$('.sel1').css('display','none');
	 }else{
		$('.sel1').css('display','block');
	 }
 $("#editform").submit(function (){
	 /* if(!confirm('确认修改?')){
		 return false;
	 } */
	 /* var assetType = document.getElementById("assetType").value;
	 alert(assetType); */
	 //alert(${assetCurrentPage});
	 
	 
	 
	 var code = document.getElementById("code").value;
	 var name = document.getElementById("name").value;
	 var user = $('#user').combobox('getValue');
	 var usedepartment = $('#usedepartment').combobox('getValue');
	 var keeper = $('#keeper').combobox('getValue'); 
	 var keepdepartment = $('#keepdepartment').combobox('getValue'); 
	 var usestate =$('#usestate').combobox('getValue');
	 
	 var sob = document.getElementById("sob").value;
	 var model = document.getElementById("model").value;
	 var value = document.getElementById("value").value;     //double类型
	 var certificate = document.getElementById("certificate").value;
	
	 var state = $('#state').combobox('getValue');
	 var ghostyear = document.getElementById("ghostyear").value;
	 
	 
	 
	 
	 if(code==null||code==""){
	 	alert("资产代码不能为空，请重新输入");
	 	return false;
	 }else if(code.length>15){
	 	alert("资产代码不能超过15个字符，请重新输入");
	 	return false;
	 }
	 if(name==null||name==""){
	 	alert("资产名称不能为空，请重新输入");
	 	return false;
	 }else if(name.length>25){
	 	alert("资产名称不能超过25个字符，请重新输入");
	 	return false;
	 }
	 if(user==null||user==""){
	 	alert("使用人不能为空，请重新输入");
	 	return false;
	 }else if(user.length>5){
	 	alert("使用人名称不能超过5个字符，请重新输入");
	 	return false;
	 }
	 if(usedepartment==null||usedepartment==""){
	 	alert("使用部门不能为空，请重新输入");
	 	return false;
	 }else if(usedepartment.length>15){
	 	alert("使用部门名称不能超过15个字符，请重新输入");
	 	return false;
	 }
	 if(keeper==null||keeper==""){
	 	alert("保管人不能为空，请重新输入");
	 	return false;
	 }else if(keeper.length>5){
	 	alert("保管人名称不能超过5个字符，请重新输入");
	 	return false;
	 }
	 if(keepdepartment==null||keepdepartment==""){
	 	alert("保管部门不能为空，请重新输入");
	 	return false;
	 }else if(keepdepartment.length>15){
	 	alert("保管部门名称不能大于15个字符，请重新输入");
	 	return false;
	 }
	 if(usestate==null||usestate==""){
	 	alert("使用状态不能为空，请重新输入");
	 	return false;
	 }
	 if(sob.length>25){
	 	alert("账套名称不能大于25个字符，请重新输入");
	 	return false;
	 }
	 if(model.length>15){
	 	alert("规格型号长度不能大于15个字符，请重新输入");
	 	return false;
	 }
	 if(isNaN(value)){
	 	alert("资产金额只能为数字，请重新输入");
	 	return false;
	 }
	 if(certificate.length>25){
	 	alert("凭证字号长度不能大于25个字符，请重新输入");
	 	return false;
	 }
	 if(state==null||state==''){
	 	alert("状态栏不能为空");
	 	return false;
	 }
	 if(ghostyear.length>4){
	 	alert("报废年限长度不能大于4个字符，请重新输入");
	 	return false;
	 }
	 if(value){
	 	var b =/^0{1}[.]?$|^[1-9]\d*([.]{1}[0-9]{1,2})?$/;	 
		if(!b.test(value)){
			alert('资产金额输入有误，最多保留小数点后两位');
			return false;
		}
	 }
	 
	 
	 
	 
    var ajax_url = "<%=basePath %>adminasset/updateasset.htm"; //表单目标 
    var ajax_type = $(this).attr('method'); //提交方法 
    var ajax_data = $(this).serialize(); //表单数据
	var assetCurrentPage = document.getElementById("assetCurrentPage").value;
    $.ajax({ 
     type:ajax_type, //表单提交类型 
     url:ajax_url, //表单提交目标 
     data:ajax_data,//表单数据
     success:function(e){
     var  data = eval("("+e+")");
      if(data.status == "ok"){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
       		//var assetCurrentPage = data.assetCurrentPage;
       		//alert(assetCurrentPage);
      		location.href="<%=basePath%>adminasset/getassetcheckresultwithpage.htm?currentPage="+assetCurrentPage;
      }else{
		alert(data.msg);
      }
     }
    }); 
    return false; //阻止表单的默认提交事件 
    });
});


	<%-- $("#editform").click(function (){
	 if(!confirm('确认修改?')){
		 return ;
	 }
    var ajax_url = "<%=basePath %>adminasset/updateasset.htm"; //表单目标 
    var ajax_type = $(this).attr('method'); //提交方法 
    var ajax_data = $(this).serialize(); //表单数据
	
	
    $.ajax({ 
     type:ajax_type, //表单提交类型 
     url:ajax_url, //表单提交目标 
     data:ajax_data, //表单数据
     success:function(e){
     var  data = eval("("+e+")");
      if(data.status == "ok"){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
      		location.href="<%=basePath%>adminasset/showassetmenu.htm";
      }else{
		alert(data.msg);
      }
     }
    }); 
    return false; //阻止表单的默认提交事件 
    }); --%>
	
</script>
	<!-- 根据第一个的查询条件，远程绑定第二个combobox中的数据 -->
	<script>
	$('#usedepartment').combobox({  
        onSelect:function(){  
       	 var depname= $('#usedepartment').combobox('getValue'); 
       	 $('#user').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
       		    url:'<%=basePath%>admindepartmentcontroller/getusernamebyassetdep.htm?depname='+depname,
       		    valueField:'username', //设置combobox的value
       		    textField:'username',//设置combobox显示的text
       		    editable:true
       		    });
       	 } 
});  
	$('#keepdepartment').combobox({  
        onSelect:function(){  
       	 var depname= $('#keepdepartment').combobox('getValue'); 
       	 $('#keeper').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
       		    url:'<%=basePath%>admindepartmentcontroller/getusernamebyassetdep.htm?depname='+depname,
       		    valueField:'username', //设置combobox的value
       		    textField:'username',//设置combobox显示的text
       		    editable:true
       		    });
       	 } 
}); 
	</script>
  </body>
</html>
