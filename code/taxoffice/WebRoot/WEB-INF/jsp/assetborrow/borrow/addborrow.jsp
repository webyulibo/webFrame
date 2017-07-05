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

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/input.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/datazp.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/themes/material/easyui.css" />
<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
<style>
.tab td {
	height: 50px;
	vertical-align: top;
	padding-top: 20px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width: 100px;
	padding-right: 20px;
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
			<h3 class="current">
				<a href="<%=basePath%>AdminAssetBorrowController/index.htm"> <span
					class="fa fa-table"></span> 资产借用
				</a>
			</h3>
			<h3>
				<a href="<%=basePath%>AdminAssetReturnController/index.htm"> <span
					class="fa fa-cog"></span> 资产归还
				</a>
			</h3>
		</div>
		<div class="lbgl-top-left f_1"
			style="margin-top:60px;margin-left:100px;">
			<a href="<%=basePath%>AdminAssetBorrowController/showborrow.htm"
				class="btn btn-add" style="width:110px;"> <i class="fa fa-plus"></i><span>查看借用记录列表</span>
			</a>
		</div>
		<div class="control-group f_l" style="min-width:1100px">
			<form action="" name="borrow">
				<div style="margin-top:30px;margin-left:100px;">
					<div>
						<table class="tab">
							<tr>
								<td style="padding-right:20px">借出单号：</td>
								<td width="30%"><input type="text" class="in"
									id="borrownum" readonly="readonly"> <pbn></pbn></td>
							</tr>
							<tr>
								<td>资产编号：</td>
								<td><select class="easyui-combobox" name="state"
									style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"
									id="assetcode">
								</select> <pb1></pb1></td>
								<td width="100px">资产名称：</td>
									<td>
										<select class="easyui-combobox" name="name" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"  id="assetname">
										<!-- 	<option value="" checked="checked"></option>
											<option value="" ></option> -->
										</select>
										<pbname></pbname>
									</td>
								
								<!-- <td width="100px">资产名称：</td>
								<td><input type="text" class="in" id="assetname" readonly="readonly"> <pbname></pbname></td> -->
								
								
								
							</tr>
							<tr>
								
								<td>借出部门：</td>
								<td><select class="easyui-combobox" name="state"
									style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"
									id="borrowdep">
								</select></td>
								<td>借出人：</td>
								<td><select class="easyui-combobox" name="state"
									style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"
									id="borrowpeople">
								</select> <pb2></pb2></td>
							</tr>
							<tr>
								<td>借用部门：</td>
								<td><select class="easyui-combobox" name="state"
									style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"
									id="borrowusedep">
								</select></td>
								<td>借用人：</td>
								<td><select class="easyui-combobox" name="state"
									style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"
									id="borrowuser">
								</select> <pb3></pb3></td>
							</tr>
							<tr>
								<td>借出日期：</td>
								<td>
								<input  type="text" name="purchasetime" placeholder="申请日期" class="laydate-icon"  id="demo" style="text-align:center;height:25px;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
									<btm></btm></td>
								<td>拟还日期：</td>
								<td><input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
									placeholder="拟还日期" class="laydate-icon" id="demo2"
									name="purchasetime"
									style="text-align:center;height:25px;"><bkm></bkm></td>
							</tr>
							<tr>
								<td>批准人：</td>
								<td><select class="easyui-combobox" name="state"
									style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"
									id="approvepeople">
								</select> <pb4></pb4></td>
							</tr>
							<tr>
								<td ALIGN="left" VALIGN="top">备注：</td>
								<td colspan="3"><textarea rows="4" cols="85" value=""
										name="remark" id="remark"></textarea></td>
							</tr>
						</table>

					</div>
					<div style="margin-left:565px;margin-top:30px;">
						<span> <input type="button" class="btn btn-primary"
							id="save" value="保存" onclick="javascript:void(0)">
						</span> <span style="padding-left:5px;"> <input type="button"
							class="btn btn-primary" id="clear" value="清空"
							onclick="javascript:void(0)">
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>
	<input type="hidden"  id="h1"  value=""/>
	<input type="hidden"  id="h2"  value=""/>
	<input type="hidden"  id="hide" />
			<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		    document.getElementById("hide").value="fe";
			document.getElementById("save").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("clear").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		</script>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="faultauth">
		<script type="text/javascript">
		
		
		document.getElementByClassName("btn-add").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		
		    document.getElementById("hide").value="fe";
			document.getElementById("save").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("clear").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		</script>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="movepeoauth">
		<script type="text/javascript">
		
		document.getElementByClassName("btn-add").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		    document.getElementById("hide").value="fe";
			document.getElementById("save").setAttribute("onclick","alert('权限不足，无法进行此操作')");
			document.getElementById("clear").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		</script>
	</shiro:hasPermission>
	<script type="text/javascript">
		laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
		$("#borrownum").val( (new Date()).format('ymd')+Math.floor(Math.random()*8999999+1000000).toString());
			var start = {
			    elem: '#demo',
			    format: 'YYYY-MM-DD',
			    max: '2099-06-16', //最大日期
			    istime: true,
			    istoday: false,
			    choose: function(datas){
			         end.min = datas; //开始日选好后，重置结束日的最小日期
			         end.start = datas; //将结束日的初始值设定为开始日
			    }
			};

			var end = {
			    elem: '#demo2',
			    format: 'YYYY-MM-DD',
			    max: '2099-06-16',
			    istime: true,
			    istoday: false,
			    choose: function(datas){
			        start.max = datas; //结束日选好后，充值开始日的最大日期
			    }
			};
			laydate(start);
			laydate(end);
</script>
<script type="text/javascript">
//清空对应的js代码
$("#clear").click(function clear(){
	if(document.getElementById("hide").value!="fe"){
		 $("pb1").html("");
		 $("pb2").html("");
		 $("pb3").html("");
		 $("pb4").html("");
			$("#assetcode").combobox("clear");
			$("#assetname").combobox("clear");
			//document.getElementById("assetname").value="";
			document.getElementById("demo").value="";
			$("#borrowdep").combobox("clear");
			$("#borrowpeople").combobox("clear");
			$("#approvepeople").combobox("clear");
			document.getElementById("demo2").value="";
			$("#borrowusedep").combobox("clear");
			$("#borrowuser").combobox("clear");
			document.getElementById("remark").value="";
	}

});
//对各选项的js校验代码(实时监听文本框)
 $("#borrownum").bind("propertychange input",function(){
     var borrownum=document.getElementById("borrownum").value;
	 if(/\s/.test(borrownum)){
		$("pbn").html("不能有空格");
	 }
	 else
		 $("pbn").html("");
 });
<%--  //js监听资产编号
 document.getElementById("assetname").value="";
 $('#assetcode').combobox({  
         onChange:function(){ 
        	 var assetcode= $('#assetcode').combobox('getValue');    
             $.ajax({
              	type:"post",
              	url:'<%=basePath%>AdminAssetBorrowController/listenassetcode.htm',
              	data:{assetcode:assetcode},
                success:function(data){
                 
         		}
              });
          //js监听资产编号查询对应的资产名称
             if(!(/^\d+$/.test(assetcode))||assetcode.length!=15) {
            	 document.getElementById("assetname").value="";
             }
        	 if(/^\d+$/.test(assetcode)&&assetcode.length==15) 
        	 { 
        		   $.ajax({
                     	type:"post",
                     	url:'<%=basePath%>AdminAssetBorrowController/getassetname.htm',
                     	data:{assetcode:assetcode},
                        success:function(e){
                         var data=eval("("+e+")");
                    			if(data.state=="1"){
                    		$("pbname").html("");
                    		document.getElementById("assetname").value=data.assetname;
                    		}
                    			else{
                    			document.getElementById("assetname").value="无此资产";
                    		}
                    	  }
                     });
        	 } 
         }
   });  --%>
//对各选项的js校验代码(光标离开文本框时触发)
/* $("#borrownum").blur(function (){
	var borrownum=document.getElementById("borrownum").value;
    if(borrownum.indexOf("")>=0){
    	$("pbn").html("不能有空格");
    }
}); */
//保存对应的js代码
$("#save").click(function save(){
     var borrownum=document.getElementById("borrownum").value;
     var assetcode= $('#assetcode').combobox('getValue');
     var assetname=$('#assetname').combobox('getValue');
     var borrowdate=document.getElementById("demo").value;
     var borrowdep= $('#borrowdep').combobox('getValue');
     var borrowpeople= $('#borrowpeople').combobox('getValue');
     var approvepeople= $('#approvepeople').combobox('getValue');
     var plandate=document.getElementById("demo2").value;
     var borrowusedep= $('#borrowusedep').combobox('getValue');
     var borrowuser= $('#borrowuser').combobox('getValue');
     var remark=document.getElementById("remark").value;
     var h1=document.getElementById("h1").value;
     var h2=document.getElementById("h2").value;
/*      if(borrownum==""&&assetcode==""&&assetname==""&&borrowdate==""&&approvepeople==""&&borrowdep==""&&borrowpeople==""&&plandate==""&&borrowusedep==""&&borrowuser==""&&remark==""){
    	 alert("你未填写任何数据！");
     } */
     if(assetcode==""&&$('#assetcode').combobox('getText')==""&&document.getElementById("hide").value!="fe"){
    	/*  alert("资产编号不能为空！"); */
    	 $("pb1").html("不能为空");
     }
     if(borrowpeople==""&&document.getElementById("hide").value!="fe"){
    	/*  alert("借出人不能为空！"); */
    	 $("pb2").html("不能为空");
     }                                                                           
     if(borrowuser==""&&document.getElementById("hide").value!="fe"){
    	/*  alert("借用人不能为空！"); */
    	 $("pb3").html("不能为空");
     }
     if(approvepeople==""&&document.getElementById("hide").value!="fe"){
    	/*  alert("批准人不能为空！"); */
    	 $("pb4").html("不能为空");
     }
     if(assetcode!=""&&document.getElementById("hide").value!="fe"){
     	/*  alert("资产编号不能为空！"); */
     	 $("pb1").html("");
      }
      if(borrowpeople!=""&&document.getElementById("hide").value!="fe"){
     	/*  alert("借出人不能为空！"); */
     	 $("pb2").html("");
      }                                                                           
      if(borrowuser!=""&&document.getElementById("hide").value!="fe"){
     	/*  alert("借用人不能为空！"); */
     	 $("pb3").html("");
      }
      if(approvepeople!=""&&document.getElementById("hide").value!="fe"){
     	/*  alert("批准人不能为空！"); */
     	 $("pb4").html("");
      }
      if((isNaN(assetcode)||assetcode.length>15)&&document.getElementById("hide").value!="fe"){
    	  alert("数据格式错误");
    	  $('#assetcode').combobox('clear');
    	  $('#assetcode').combobox().next('span').find('input').focus();
      }
      if((h1=="no"||h2=="no")&&document.getElementById("hide").value!="fe"){
    	  alert("存在非法数据(检查资产代码或资产名称是否正确)");
      }
      if(assetcode!=""&&approvepeople!=""&&borrowpeople!=""&&borrowuser!=""&&h1=="yes"&&h2=="yes"&&document.getElementById("hide").value!="fe"){
     $.ajax({
    	 type:"post",
    	 url:'<%=basePath %>AdminAssetBorrowController/saveassetborrowrecord.htm',
         data : {borrownum : borrownum,assetcode : assetcode,assetname : assetname,borrowdate : borrowdate,borrowdep : borrowdep,borrowpeople : borrowpeople,approvepeople : approvepeople,plandate : plandate,borrowusedep : borrowusedep,borrowuser : borrowuser,remark : remark},
		success : function(e) {
			var data = eval("(" + e + ")");
			alert(data.msg);
			window.location.reload();
			document.getElementById("demo").value="";
			document.getElementById("demo2").value="";
			document.getElementById("remark").value="";
	}
				});
							}
						});
//assetcode的json串
$(function(){
		$('#assetcode').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		    url:'<%=basePath%>AdminAssetBorrowController/getassetcodejson.htm',
		    valueField:'text', //设置combobox的value
		    textField:'text',//设置combobox显示的text
		    editable:true
		    });
});
//department的json串
$(function(){
	$('#borrowdep').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
	    url:'<%=basePath%>AdminAssetBorrowController/getborrowdepjson.htm',
	    valueField:'text', //设置combobox的value
	    textField:'text',//设置combobox显示的text
	    editable:true
	    });
}); 
$('#borrowdep').combobox({  
    onSelect:function(record){  
   	 $('#borrowpeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
   		    url:'<%=basePath%>AdminAssetBorrowController/getdepartmentpeoplejson.htm?borrowdep='+record.text,
   		    valueField:'text', //设置combobox的value
   		    textField:'text',//设置combobox显示的text
   		    editable:true
   		    });
   	 } 
});  
//borrowpeople的json串
$(function(){
		$('#borrowpeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
		    valueField:'text', //设置combobox的value
		    textField:'text',//设置combobox显示的text
		    editable:true
		    });
});
//borrowuser的json串
$(function(){
		$('#borrowuser').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
		    valueField:'text', //设置combobox的value
		    textField:'text',//设置combobox显示的text
		    editable:true
		    });
});
//approvepeople的json串
$(function(){
		$('#approvepeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
		    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
		    valueField:'text', //设置combobox的value
		    textField:'text',//设置combobox显示的text
		    editable:true
		    });
});
//借用部门的json串
$(function(){
	$('#borrowusedep').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
	    url:'<%=basePath%>AdminAssetBorrowController/getborrowdepjson.htm',
	    valueField:'text', //设置combobox的value
	    textField:'text',//设置combobox显示的text
	    editable:true
	    });
}); 
$('#borrowusedep').combobox({  
    onSelect:function(record){  
   	 $('#borrowuser').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
   		    url:'<%=basePath%>AdminAssetBorrowController/getdepartmentpeoplejson.htm?borrowdep='+record.text,
   		    valueField:'text', //设置combobox的value
   		    textField:'text',//设置combobox显示的text
   		    editable:true
   		    });
   	 } 
});  
$('#borrowusedep').combobox({  
    onChange:function(){  
   if($('#borrowusedep').combobox('getText')=="")
    {	
		$(function(){
			$('#borrowuser').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
			    valueField:'text', //设置combobox的value
			    textField:'text',//设置combobox显示的text
			    editable:true
			    });
	});
    }
    }
});
$('#borrowdep').combobox({  
    onChange:function(){  
   if($('#borrowdep').combobox('getText')=="")
    {	
		$(function(){
			$('#borrowpeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
			    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
			    valueField:'text', //设置combobox的value
			    textField:'text',//设置combobox显示的text
			    editable:true
			    });
	});
    }
    }
});

$(".validatebox-text").eq(0).bind("propertychange input",function(){
 var assertext=$(".validatebox-text").eq(0).val();
 alert(assertext);
});
//根据借出人的变化选择借出部门+
$('#borrowpeople').combobox({  
		    onChange:function(){  
		    var borrowpeople=$('#borrowpeople').combobox('getValue'); 
		    $.ajax({
		    	 type:"post",
		    	 url:'<%=basePath %>AdminAssetBorrowController/getborrowpeople.htm',
		         data : {borrowpeople:borrowpeople},
				success : function(e) {
					var data = eval("(" + e + ")");
					if(data.state=="1"){
						$('#borrowdep').combobox('setValue',data.borrowdepname); 
					}
					if(data.state=="0"){
						$('#borrowdep').combobox('setValue',""); 
					}
			}
	});  
		    }
		});
//根据借出人的变化选择借出部门+
$('#borrowuser').combobox({  
		    onChange:function(){  
		    var borrowuser=$('#borrowuser').combobox('getValue'); 
		    $.ajax({
		    	 type:"post",
		    	 url:'<%=basePath %>AdminAssetBorrowController/getborrowpeople.htm',
		         data : {borrowpeople:borrowuser},
				success : function(e) {
					var data = eval("(" + e + ")");
					if(data.state=="1"){
						$('#borrowusedep').combobox('setValue',data.borrowdepname); 
					}
					if(data.state=="0"){
						$('#borrowusedep').combobox('setValue',""); 
					}
			}
	});  
		    }
		});
		
//assetname的json串
$(function(){
	$('#assetname').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
	    url:'<%=basePath%>AdminAssetBorrowController/getassetnamejson1.htm',
	    valueField:'text', //设置combobox的value
	    textField:'text',//设置combobox显示的text
	    editable:true
	    });
}); 
//资产名称对应的onSelect事件
$('#assetname').combobox({  
    onSelect:function(record){  
    var assetname=record.text;
     $.ajax({
    	 type:"post",
    	 url:'<%=basePath %>AdminAssetBorrowController/getassetcode.htm',
         data : {assetname:assetname},
		success : function(e) {
			var data = eval("(" + e + ")");
			if(data.state=="1"){
			   	 $('#assetcode').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
   		    url:'<%=basePath%>AdminAssetBorrowController/getassetcodejson2.htm?assetname='+record.text,
   		    valueField:'text', //设置combobox的value
   		    textField:'text',//设置combobox显示的text
   		    editable:true
   		    });
			}
			if(data.state=="0"){
				$('#assetcode').combobox('setValue',""); 
			}
	}
});  
    }
});  
<%-- $('#assetname').combobox({  
    onSelect:function(record){  
   	 $('#assetcode').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
   		    url:'<%=basePath%>AdminAssetBorrowController/getassetcodejson2.htm?assetname='+record.text,
   		    valueField:'text', //设置combobox的value
   		    textField:'text',//设置combobox显示的text
   		    editable:true
   		    });
   	 } 
});  --%> 
//资产编码对应的onSelect事件
$('#assetcode').combobox({  
    onSelect:function(record){  
    var assetcode=record.text;
     $.ajax({
    	 type:"post",
    	 url:'<%=basePath %>AdminAssetBorrowController/getassetname.htm',
         data : {assetcode:assetcode},
		success : function(e) {
			var data = eval("(" + e + ")");
			if(data.state=="1"){
				$('#assetname').combobox('setValue',data.assetname); 
			}
			if(data.state=="0"){
				$('#assetname').combobox('setValue',""); 
			}
	}
});  
    }
});  

$('#assetcode').combobox({  
    onChange:function(record){  
  var assetcode=$('#assetcode').combobox('getValue'); 
  $.ajax({
 	 type:"post",
 	 url:'<%=basePath %>AdminAssetBorrowController/getassetcode2.htm',
      data : {assetcode:assetcode},
		success : function(e) {
			var data = eval("(" + e + ")");
			if(data.state=="1"){
				//
				//$("pb1").html("无此资产");
				document.getElementById("h1").value="no";
			}
			if(data.state=="0"){
				$("pb1").html("");
				document.getElementById("h1").value="yes";
			}
	}
});  
    }
});  


$('#assetname').combobox({  
    onChange:function(record){  
  var assetname=$('#assetname').combobox('getValue'); 
  $.ajax({
 	 type:"post",
 	 url:'<%=basePath %>AdminAssetBorrowController/getassetname3.htm',
      data : {assetname:assetname},
		success : function(e) {
			var data = eval("(" + e + ")");
			if(data.state=="1"){
				//
				//$("pbname").html("无此资产");
				document.getElementById("h2").value="no";
			}
			if(data.state=="0"){
				$("pbname").html("");
				document.getElementById("h2").value="yes";

			}
	}
});  
    }
});  
	</script>
</body>
</html>
