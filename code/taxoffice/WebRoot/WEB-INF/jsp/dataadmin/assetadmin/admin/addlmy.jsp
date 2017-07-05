<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
     <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datebox.css"> 
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/bootstrap.min.css" />
	
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
     <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
     <script type="text/javascript" src="<%=basePath %>Public/Js/laydate.js"></script>
     <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />

     <script src="Public/Js/jquery-2.1.4.js" type="<%=basePath %>text/javascript"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
     <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
  </head>
  <body>
		<form action="" class="form-horizontal ajax_form" id="addform">
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
			<div class="add" style="clear:both;width:1000px">
				<table>
				<tr>
					<td><h2>资产类型：</h2></td>
					
					<td>
						
						 <select name="type1" value="" class="sel" style="display:block" id="typename"> 
							<!-- <option value="1" checked="checked"/>请选择</option> -->
							<option value="请选择">请选择</option>
							<c:forEach items="${firsttype }" var="menu">
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
						
						 <select name="type3" style="display:none;" class="sel" value='1'>
							
							
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
			<div class="add" style="min-width: 421px;">
				<table>
					<tr>
					<td><h2>账套：</h2></td>
					<td><input type="text" placeholder="河北省秦皇岛市国家税务局国有资产 账套01" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='河北省秦皇岛市国家税务局国有资产 账套01'" name="sob" id="sob"></td>
					</tr>
					<tr>
					<td><h2>资产代码：</h2></td>
					<td><input type="text" value="${code }" data-rule-maxlength="60" name="code" id="code"></td>
					</tr>
					<tr>
					<td><h2>资产名称：</h2></td>
					<td><input type="text" placeholder="电脑" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='电脑'"data-rule-maxlength="60" name="name" id="name"></td>
					</tr>
					<tr>
					<td><h2>规格型号：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60" name="model" id="model"></td>
					</tr>
					<tr>
					<td><h2>购置日期：</h2></td>
					<td>
                	<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="申请日期" class="laydate-icon" id="demo" name="purchasetime"/> 
                	</td>
					</tr>
					<tr>
					<td><h2>资产金额：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60" name="value" placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onblur="this.focus()" id="value" ></td>
					</tr>
					<tr>
					<td><h2>使用部门：</h2></td>
					<td>
					<select class="easyui-combobox sel" name="usedepartment" value='1' style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="usedepartment">
					<!-- <select name="usedepartment" id="usedepartment"> -->
						   <!-- <option value="1" checked="checked"/>请选择</option> -->
<!-- 							<option value="办公室" >办公室</option>
							<option value="秘书室">秘书室</option>
							<option value="宣传部" checked="checked">宣传部</option> -->
					</select>
					 <!-- <input type="text" value="" data-rule-maxlength="60" name="usedepartment" id="usedepartment"> --></td> 
					</tr>
					<tr>
					<td><h2>使用人：</h2></td>
					<td>
					<!-- <input type="text" value="" data-rule-maxlength="60" name="user" id="user"> -->
					<select class="easyui-combobox sel" name="user" value='1' style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="user">
						   <!-- <option value="1" checked="checked"/>请选择</option> -->
<!-- 							<option value="刘仁鹏" >刘仁鹏</option>
							<option value="于海强" selected="selected">于海强</option>
							<option value="董浩" >董浩</option> -->
					</select>
					
					</td>
					</tr>
					
					<tr>
					<td><h2>备注：</h2></td>
					<td><textarea rows="3" cols="40" name="remark"></textarea></td>
					</tr>
				</table>
				<input class="btn btn-primary" type="submit" value="添加" id="add" style="margin-left:25%;margin-top:10%;">
			</div>
			<div class="add sec" style="min-width: 262px;">
				<table>
					<tr>
					<td><h2>保管部门：</h2></td>
					<td>
					<select class="easyui-combobox sel" name="keepdepartment" value='1' style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="keepdepartment">
					<!-- <select name="keepdepartment" id="keepdepartment"> -->
						   <!-- <option value="1" checked="checked"/>请选择</option> -->
<!-- 							<option value="办公室" >办公室</option>
							<option value="秘书室">秘书室</option>
							<option value="宣传部" checked="checked">宣传部</option> -->
					</select>
				 <!-- <input type="text" value="" data-rule-maxlength="60" name="keepdepartment" id="keepdepartment"> --></td>
					</tr>
					<tr>
					<td><h2>保管人：</h2></td>
					<td>
					<!-- <input type="text" value="" data-rule-maxlength="60" style="width:150px" name="keeper" id="keeper"> -->
					<select class="easyui-combobox sel" name="keeper" value='1' style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="keeper">
<!-- 						<option value="刘仁鹏" >刘仁鹏</option>
						<option value="于海强">于海强</option>
						<option value="董浩" >董浩</option> -->
					</select>
					</td>
					</tr>
					
					<tr>
					<td><h2>使用状态：</h2></td>
					<td>
					<select class="easyui-combobox sel" name="usestate" value='1' style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="usestate">
					<!-- <select name="usestate" id="usestate"> -->
			  			<option value="在用" checked="checked">在用</option>
						<option value="闲置">闲置</option>
						<option value="损坏不能用">损坏不能用</option>
			  		</select>
					 <!-- <input type="text" value="" data-rule-maxlength="60" name="usestate" id="usestate"> --></td>
					</tr>
					<tr>
					<td><h2>凭证字号：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60" name="certificate" id="certificate"></td>
					</tr>
					<tr>
					<td><h2>状态：</h2></td>
					<td>
					<select class="easyui-combobox sel" name="state" value='1' style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="state">
					<!-- <select style="width: 150px;padding: 5px 2px;cursor: pointer;" id="state" name="state"> -->
			  			<option value="正常" checked="checked">正常</option>
						<option value="盘亏">盘亏</option>
			  		</select>
					<!-- <input type="text" value="" data-rule-maxlength="60" name="state"> --></td>
					</tr>
					<tr>
					<td><h2>是否期初：</h2></td>
					<td>
					<span><input type="radio" name="qc" name="isbegin" checked="checked">是</span>
					<span><input type="radio" name="qc" name="isbegin">否</span>
					</td>
					</tr>
					<tr>
					<td><h2>报废年度：</h2></td>
					<td><input type="text" value="" data-rule-maxlength="60" name="ghostyear" id="ghostyear"></td>
					</tr>
					<tr>
					<td><h2>启用日期：</h2></td>
					<td><input type="text" value=""  placeholder="启用日期"data-rule-maxlength="60" class="laydate-icon" id="demo2" name="startusetime"></td>
					</tr>
					<tr>
					<td><h2>制卡日期：</h2></td>
					<td><input type="text" value="" placeholder="制卡日期"data-rule-maxlength="60"class="laydate-icon" id="demo3" name="makecardtime"></td>
					</tr>
					
				</table>
				<input type="hidden" name="list"/>
				<input type="hidden" class="cate" name="type" value="请选择"/>
			</div>
	</div>
</div>
		</form>
		<script type="text/javascript">
		$(document).ready(function(){
		/* $('#value').blur(function(){
			  var a = document.getElementById('value').value;
			 var b =/^0{1}[.]?$|^[1-9]\d*([.]{1}[0-9]{1,2})?$/;	 
			 if(!b.test(a)){
				 alert('请按提示正确输入'); 
				 this.focus();
			 }  
		});  */
		//资产代码填完后鼠标失去焦点事件
		$('#code').blur(function(){
		//alert("失去焦点");\
			/* alert('hg'); */
			 var value = $(this).val();
			var ajax_url="<%=basePath%>adminasset/selectassetbycode.htm";
			$.ajax({
				type:'post',
				url:ajax_url,
				data:{code:value},
				success:function(e){
					var data = eval("("+e+")");
					if(data.status=="no"){
						alert(data.msg);
					}
				}
			}); 
		});
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
	$("#addform").submit(function (){
 	 /* alert("submit");
	 if(!confirm('确认提交?')){
		 return false;
	 } */
	 
	 var code = document.getElementById("code").value;
	 var name = document.getElementById("name").value;
	 //var user = document.getElementById("user").value;
	 var user=$("#user").combobox('getValue');
	
	 var usedepartment=$("#usedepartment").combobox('getValue');
	 
	 var keeper = $("#keeper").combobox('getValue');
	 var keepdepartment = $("#keepdepartment").combobox('getValue');
	 var usestate = $("#usestate").combobox('getValue');
	 
	 
	 var sob = document.getElementById("sob").value;
	 var model = document.getElementById("model").value;
	 var value = document.getElementById("value").value;     //double类型
	 var certificate = document.getElementById("certificate").value;
	 var state = document.getElementById("state").value;
	 var ghostyear = document.getElementById("ghostyear").value;
	 var typename = $("#typename").val();
	 //alert(typename);
	 
	 if(code==null||code==""){
	 	alert("资产代码不能为空，请重新输入");
	 	return false;
	 }else if(code.length>15){
	 	alert("资产代码不能超过15个字符，请重新输入");
	 	return false;
	 }
	 if(isNaN(code)){
	 	alert("资产代码只能为数字，请重新输入");
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
	 if(typename=="请选择"){
	 	alert("请选择资产类型");
	 	return false;
	 }
	 
	 	var ajax_url = "<%=basePath %>adminasset/insertasset.htm"; //表单目标 
    	var ajax_type = $(this).attr('method'); //提交方法 
    	var ajax_data = $(this).serialize(); //表单数据
	
	
    	$.ajax({ 
     		type:ajax_type, //表单提交类型 
     		url:ajax_url, //表单提交目标 
     		data:ajax_data, //表单数据
    		success:function(e){
     		var data = eval("("+e+")");
      		if(data.status == "ok"){//msg 是后台调用action时，你穿过来的参数
       			alert(data.msg);
      			location.href="<%=basePath%>adminasset/showassetmenu.htm";
      		}else{
				alert(data.msg);
      		}
     	}
     }); 
    return false; //阻止表单的默认提交事件 
   	//这里是else的括号
   });//这里是addform的括号 
	
		});
		
		</script>
		
		
	<script type="text/javascript">
	//alert("");
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
	
<%-- $(document).ready(function(){
	//alert("document");
 $("#addform").submit(function (){
 	//alert("submit");
	 /* if(!confirm('确认提交?')){
		 return ;
	 } */
	 
	 var code = document.getElementById("code").value;
	 var name = document.getElementById("name").value;
	 var user = document.getElementById("user").value;
	 var usedepartment = document.getElementById("usedepartment").value;
	 var keeper = document.getElementById("keeper").value;
	 var keepdepartment = document.getElementById("keepdepartment").value;
	 var usestate = document.getElementById("usestate").value;
	 if(code==null||code==""){
	 	alert("资产代码不能为空，请重新输入");
	 	return false;
	 }
	 if(name==null||name==""){
	 	alert("资产名称不能为空，请重新输入");
	 	//return false;
	 }
	 else if(user==null||user==""){
	 	alert("使用人不能为空，请重新输入");
	 	//return;
	 }
	 else if(usedepartment==null||usedepartment==""){
	 	alert("使用部门不能为空，请重新输入");
	 	//return;
	 }
	 else if(keeper==null||keeper==""){
	 	alert("保管人不能为空，请重新输入");
	 	//return;
	 }
	 else if(keepdepartment==null||keepdepartment==""){
	 	alert("保管部门不能为空，请重新输入");
	 	//return;
	 }
	 else if(usestate==null||usestate==""){
	 	alert("使用状态不能为空，请重新输入");
	 	//return;
	 }
	 else{
	 	var ajax_url = "<%=basePath %>adminasset/insertasset.htm"; //表单目标 
    	var ajax_type = $(this).attr('method'); //提交方法 
    	var ajax_data = $(this).serialize(); //表单数据
	
	
    	$.ajax({ 
     		type:ajax_type, //表单提交类型 
     		url:ajax_url, //表单提交目标 
     		data:ajax_data, //表单数据
    		success:function(e){
     		var data = eval("("+e+")");
      		if(data.status == "ok"){//msg 是后台调用action时，你穿过来的参数
       			alert(data.msg);
      			location.href="<%=basePath%>adminasset/showassetmenu.htm";
      		}else{
				alert(data.msg);
      		}
     	}
     }); 
    return false; //阻止表单的默认提交事件 
   	}//这里是else的括号
   });//这里是addform的括号
	 
	 
	 
	 
	 
	 
    var ajax_url = "<%=basePath %>adminasset/insertasset.htm"; //表单目标 
    var ajax_type = $(this).attr('method'); //提交方法 
    var ajax_data = $(this).serialize(); //表单数据
	
	
    $.ajax({ 
     type:ajax_type, //表单提交类型 
     url:ajax_url, //表单提交目标 
     data:ajax_data, //表单数据
     success:function(e){
     var data = eval("("+e+")");
      if(data.status == "ok"){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
      		location.href="<%=basePath%>adminasset/showassetmenu.htm";
      }else{
		alert(data.msg);
      }
     }
    }); 
    return false; //阻止表单的默认提交事件 
    });
});//这里是document的括号 --%>
		
		
		
$(function(){
	$('#keepdepartment').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
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
$('#keepdepartment').combobox({  
    onSelect:function(record){  
   	 $('#keeper').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
   		    url:'<%=basePath%>AdminAssetBorrowController/getdepartmentpeoplejson.htm?borrowdep='+record.text,
   		    valueField:'text', //设置combobox的value
   		    textField:'text',//设置combobox显示的text
   		    editable:true
   		    });
   	 } 
}); 
$('#keepdepartment').combobox({  
    onChange:function(){  
   if($('#keepdepartment').combobox('getText')=="")
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
	$('#usedepartment').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
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
$('#usedepartment').combobox({  
    onSelect:function(record){  
   	 $('#user').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
   		    url:'<%=basePath%>AdminAssetBorrowController/getdepartmentpeoplejson.htm?borrowdep='+record.text,
   		    valueField:'text', //设置combobox的value
   		    textField:'text',//设置combobox显示的text
   		    editable:true
   		    });
   	 } 
}); 
$('#usedepartment').combobox({  
    onChange:function(){  
   if($('#usedepartment').combobox('getText')=="")
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
	</script>
  </body>
</html>
