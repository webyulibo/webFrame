<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>税务局管理系统</title>

<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/input.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
<style>
.td {
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	vertical-align: top;
	height:50px;
}

.tab td {
	padding-top: 20px;
		padding-right:20px;
}

/* .btn {
	padding: 3px 8px 0px 8px;
} */
</style>
<script type="text/javascript">
		Date.prototype.format = function(partten)
		{
			if(partten ==null||partten=='')
			{
				partten = 'y-m-d'	;
			}
			var y = this.getFullYear();
			var m = this.getMonth()+1;
			var d = this.getDate();
			var r = partten.replace(/y+/gi,y);
			r = r.replace(/m+/gi,(m<10?"0":"")+m);
			r = r.replace(/d+/gi,(d<10?"0":"")+d);
			return r; 
		}
	</script>
</head>
<body>
		<div class="container-f">
	  	 <div class="box-title clearfix tab-title">
			<h3 >
				<a href="<%=basePath %>AdminAssetBorrowController/index.htm">
				<span class="fa fa-table"></span>
				资产借用
				</a>
			</h3>
			<h3 class="current">
				<a href="<%=basePath %>AdminAssetReturnController/index.htm">
				<span class="fa fa-cog"></span>
				资产归还
				</a>
			</h3>
		</div>
	<div class="lbgl-top-left f_1" style="margin-top:60px;margin-left:100px;">
			<a href="<%=basePath %>AdminAssetReturnController/showreturn.htm" class="btn btn-add" style="width:110px;">
			<i class="fa fa-plus"></i><span>查看归还记录列表</span>
			</a>
		</div>
	<form action="" name="return">
	<div style="margin-top:30px;margin-left:100px;min-width:1100px">
		<div>
			<table class="tab">
				<tr>
					<td class="td">归还编号：</td>
					<td width="250px"><input type="text" class="in" readonly="readonly" id="returnnum"></td>
					<!-- <td class="td">借出单号：</td>
					<td><input type="text" class="in"  id="borrownum"><pbn></pbn></td> -->
					<td class="td">借出单号：</td>
					<td>
						<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"  id="borrownum">
						</select><pbr></pbr>
					</td>
				</tr>
				<tr>
					<td class="td">归还日期：</td>
					<td>
						<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
						placeholder="申请日期" class="laydate-icon" id="demo" 
						name="purchasetime" style="text-align:center;height:25px;"><pb2></pb2>
					</td>
					<td class="td">资产编号：</td>
					<!-- <td><input type="text" class="in"  id="assetcode"  readonly="readonly"></td> -->
								<td><select class="easyui-combobox" name="state"
									style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"
									id="assetcode">
								</select> <pb1></pb1></td>
				</tr>
				<tr>
					<td class="td">归还人：</td>
					<td>
						<select class="easyui-combobox" name="state" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"  id="backpeople">
						</select>
					</td>
					<td class="td">资产名称：</td>
					<td>
					<!-- 	<input type="text" class="in"  id="assetname"  readonly="readonly"> -->
										<select class="easyui-combobox" name="name" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"  id="assetname">
										<!-- 	<option value="" checked="checked"></option>
											<option value="" ></option> -->
										</select>
										<pbname></pbname>
					</td>
				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">备注：</td>
					<td colspan="3">
						<textarea rows="4" style="width:545px" value="" name="remark"   id="remark"></textarea>
					</td>
				</tr>
			</table>
		</div>
		<div style="margin-left:560px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary" id="save"
				value="保存" onclick="javascript:void(0)">
			</span> <span style="padding-left:5px;"> <input type="button"
				class="btn btn-primary" id="clear" value="清空" onclick="javascript:void(0)">
			</span>
		</div>
	</div>
	</form>
</div>
<input type="hidden"   id="hide"/>
			<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		    document.getElementById("hide").value="fe";
			document.getElementById("save").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("clear").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		</script>
	</shiro:hasPermission>
	
	
		<shiro:hasPermission name="faultauth">
		<script type="text/javascript">
		
		
		document.getElementByClassName("fa-plus").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		
		    document.getElementById("hide").value="fe";
			document.getElementById("save").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("clear").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		</script>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="movepeoauth">
		<script type="text/javascript">
		
		document.getElementByClassName("fa-plus").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		    document.getElementById("hide").value="fe";
			document.getElementById("save").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("clear").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		</script>
	</shiro:hasPermission>
		<input type="hidden"  id="h1"  value=""/>
	<input type="hidden"  id="h2"  value=""/>
	<input type="hidden"  id="h3"  value=""/>
<script type="text/javascript">
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({
				elem: '#demo',
				format: 'YYYY-MM-DD',
			    istime: true,
			    istoday: false
			});//绑定元素
		}();
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({
				elem: '#demo2',
				format: 'YYYY-MM-DD',
			    istime: true,
			    istoday: false
			});//绑定元素
		}();
		$("#returnnum").val( (new Date()).format('ymd')+Math.floor(Math.random()*8999999+1000000).toString());
</script>
<script type="text/javascript">
//清空对应的js代码
$("#clear").click(function clear(){
	if(document.getElementById("hide").value!="fe"){
		$("pbr").html("");
		$("pb2").html("");
		$("#borrownum").combobox("clear");
		document.getElementById("demo").value="";
		$("#assetcode").combobox("clear");
		//document.getElementById("assetcode").value="";
		$("#backpeople").combobox("clear");
		$("#assetname").combobox("clear");
		//document.getElementById("assetname").value="";
		document.getElementById("remark").value="";
	}
});

//保存对应的js代码
$("#save").click(function save(){
	var returnnum=document.getElementById("returnnum").value;
	var borrownum=$("#borrownum").combobox("getValue");
	var backdate=document.getElementById("demo").value;
	//var assetcode=document.getElementById("assetcode").value;
	var assetcode=$("#assetcode").combobox("getValue");
	var backpeople= $('#backpeople').combobox('getValue');
	//var assetname=document.getElementById("assetname").value;
	var assetname=$("#assetname").combobox("getValue");
	var remark=document.getElementById("remark").value;
/* 	var h1=document.getElementById("h1").value;
	var h2=document.getElementById("h2").value;
	var h3=document.getElementById("h3").value; */
    	/*  alert("借用人不能为空！"); */
    	$("pb2").html("");
    	 $("pbr").html("");
 /*     if(h1=="no"||h2=="no"||h3=="no"){
   	  alert("存在非法数据(检查资产信息或借出单号是否正确)");
     } */
      if(backdate!=""&&borrownum!=""&&backpeople!=""&&assetcode!=""&&assetname!=""&&document.getElementById("hide").value!="fe"){
     $.ajax({
    	 type:"post",
    	 url:'<%=basePath %>AdminAssetReturnController/saveassetreturnrecord.htm',
         data : {backnum:returnnum,borrownum:borrownum,backdate : backdate,borrownum : borrownum,assetcode:assetcode,backpeople:backpeople,assetname:assetname,remark:remark},
		success : function(e) {
			var data = eval("(" + e + ")");
			if(data.state==1){
				alert("归还成功");
				window.location.reload();
				document.getElementById("returnnum").value="";
				$("#borrownum").combobox("clear");
				document.getElementById("demo").value="";
				$("#assetcode").combobox("clear");
				$("#assetname").combobox("clear");
				$("#backpeople").combobox("clear");
				document.getElementById("remark").value="";
			}
			if(data.state==0){
				alert("归还失败(检查信息是否正确)");
				}
	}
				});
							}
      else{
    	  if(backdate==""&&document.getElementById("hide").value!="fe"){
    		  $("pb2").html("不能为空");
    	  }
    	  if(borrownum==""&&document.getElementById("hide").value!="fe"){
    		  $("pbr").html("不能为空");
    	  }
    	  if(((assetcode==""||assetname==""||backpeople=="")&&backdate!=""&&borrownum!="")&&assetname!=""&&document.getElementById("hide").value!="fe"){
        	  alert("归还失败(除备注外其余为必填项)");   
    	  }
      }
						});
	//backpeople的json串
$(function(){
		$('#backpeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		    url:'<%=basePath%>AdminAssetReturnController/getborrowpeoplejson.htm',
		    valueField:'text', //设置combobox的value
		    textField:'text',//设置combobox显示的text
		    editable:true
		    });
});
//borrownum的json串
$(function(){
		$('#borrownum').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		    url:'<%=basePath%>AdminAssetReturnController/getborrownumjson.htm',
		    valueField:'text', //设置combobox的value
		    textField:'text',//设置combobox显示的text
		    editable:true
		    });
});
//在用的assetname的json串
$(function(){
	$('#assetname').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
	    url:'<%=basePath%>AdminAssetReturnController/getassetnamejsonre.htm',
	    valueField:'text', //设置combobox的value
	    textField:'text',//设置combobox显示的text
	    editable:true
	    });
}); 
//在用的assetcode的json串
$(function(){
		$('#assetcode').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		    url:'<%=basePath%>AdminAssetReturnController/getassetcodejsonre.htm',
		    valueField:'text', //设置combobox的value
		    textField:'text',//设置combobox显示的text
		    editable:true
		    });
});


//资产编号的onChange事件
$('#assetcode').combobox({  
    onChange:function(){   
var assetcode=$("#assetcode").combobox("getValue");
/* 	 if(/\s/.test(borrownum)){
	$("pbn").html("不能有空格");
} */
if(isNaN(assetcode)||(/\s/.test(assetcode))||assetcode.length>15)
{ 
	 $("pb1").html("数据格式错误");
}
if(/^\d+$/.test(assetcode)&&!(/\s/.test(assetcode))&&assetcode.length==15){
	 $("pb1").html("");
	 $.ajax({
     	type:"post",
     	url:'<%=basePath%>AdminAssetReturnController/getassetinfo1.htm',
     	data:{assetcode:assetcode},
        success:function(e){
        var data=eval("("+e+")");
    		if(data.state==1){
    		/* document.getElementById("assetcode").value=data.assetcode;
    		document.getElementById("assetname").value=data.assetname; */
    		$('#borrownum').combobox('setValue',data.borrownum); 
    		$('#assetname').combobox('setValue',data.assetname); 
    		//$('#backpeople').combobox('setValue',data.borrowpeople);
    		$("pb1").html("");
			document.getElementById("h2").value="yes";
    		}
    		if(data.state==0){
        		/* document.getElementById("assetcode").value=data.assetcode;
        		document.getElementById("assetname").value=data.assetname; */
    			/* $("pb1").html("无此资产"); */
				document.getElementById("h2").value="no";
        		}
    	  }
     });
        }	
    }
});

//资产名称的onChange事件
$('#assetname').combobox({  
    onChange:function(){   
var assetname=$("#assetname").combobox("getValue");
/* 	 if(/\s/.test(borrownum)){
	$("pbn").html("不能有空格");
} */
if(assetname!=""){
	 $.ajax({
     	type:"post",
     	url:'<%=basePath%>AdminAssetReturnController/getassetinfo2.htm',
     	data:{assetname:assetname},
        success:function(e){
        var data=eval("("+e+")");
    		if(data.state==1){
    		/* document.getElementById("assetcode").value=data.assetcode;
    		document.getElementById("assetname").value=data.assetname; */
    		//$('#borrownum').combobox('setValue',data.borrownum); 
    		//$('#assetcode').combobox('setValue',data.assetcode); 
    		//$("#backpeople").combobox('setValue',data.borrowpeople);
    		 $('#assetcode').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
   		    url:'<%=basePath%>AdminAssetReturnController/getassetcodejson2.htm?assetname='+record.text,
   		    valueField:'text', //设置combobox的value
   		    textField:'text',//设置combobox显示的text
   		    editable:true
   		    });
    			 $('#borrownum').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
    		   		    url:'<%=basePath%>AdminAssetReturnController/getborrownumjson2.htm?assetname='+record.text,
    		   		    valueField:'text', //设置combobox的value
    		   		    textField:'text',//设置combobox显示的text
    		   		    editable:true
    		   		    });
    <%-- 			 $('#backpeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
    		   		    url:'<%=basePath%>AdminAssetReturnController/getbackpeoplejson2.htm?assetname='+record.text,
    		   		    valueField:'text', //设置combobox的value
    		   		    textField:'text',//设置combobox显示的text
    		   		    editable:true
    		   		    }); --%>
    		$("pbname").html("");
			document.getElementById("h3").value="yes";

    		}
    		if(data.state==0){
        		/* document.getElementById("assetcode").value=data.assetcode;
        		document.getElementById("assetname").value=data.assetname; */
    			/* $("pbname").html("无此资产"); */
				document.getElementById("h3").value="no";
        		}
    	  }
     });
        }	
    }
});
//对各选项的js校验代码(实时监听借出单号的变化)
$('#borrownum').combobox({  
        onChange:function(){   
   var borrownum=$("#borrownum").combobox("getValue");
/* 	 if(/\s/.test(borrownum)){
		$("pbn").html("不能有空格");
	 } */
/* 	 if(isNaN(borrownum)||(/\s/.test(borrownum))||borrownum.length>15)
	 { 
		 $("pbn").html("数据格式错误");
	 }
	 if(/^\d+$/.test(borrownum)&&!(/\s/.test(borrownum))&&borrownum.length==15){
		 $("pbn").html(""); */
		 if(borrownum!=""){
		 $.ajax({
         	type:"post",
         	url:'<%=basePath%>AdminAssetReturnController/getassetinfo.htm',
         	data:{borrownum:borrownum},
            success:function(e){
            var data=eval("("+e+")");
        		if(data.state==1){
        		/* document.getElementById("assetcode").value=data.assetcode;
        		document.getElementById("assetname").value=data.assetname; */
        		$('#assetcode').combobox('setValue',data.assetcode); 
        		$('#assetname').combobox('setValue',data.assetname); 
        		//$("#backpeople").combobox('setValue',data.borrowpeople);
        		$("pbr").html("");
				document.getElementById("h1").value="yes";
        		}
        		if(data.state==0){
           		/* document.getElementById("assetcode").value=data.assetcode;
           		document.getElementById("assetname").value=data.assetname; */
       			/* $("pbr").html("无相关信息"); */
   				document.getElementById("h1").value="no";
           		}
        	  }
         });
		 }
	         }	
        });
</script>
</body>
</html>
