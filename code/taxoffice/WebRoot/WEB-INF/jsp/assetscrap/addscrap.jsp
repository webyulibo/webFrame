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
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css">
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
.td {
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	width:80px;
}

.tab td {
	height: 50px;
	vertical-align: top;
	padding-right:20px;
	font-size: 15px;
	min-width:100px;
}

.fbtn {
	width: 120px;
}
</style>

</head>
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

		//调用方式
		//alert((new Date()).format("ymd"));
		//var my = document.getElementById("aaaa");
		//alert(my.value);
		//document.getElementById("scrapNum").value = (new Date()).format('ymd');
	</script>

<body>
	<div class="container-f">
		<div class="box-title clearfix tab-title"></div>
	</div>
	<div style="margin-top:40px;margin-left:100px;">
		<a class="btn fbtn" href="<%=basePath%>AdminScrapController/showscrap.htm">
			<i class="fa fa-plus"></i><span>查看报废记录列表</span>
		</a>
	</div>
	<div style="margin-top:50px;margin-left:100px;min-width:1100px;">
		<div>
			<table class="tab">
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">报废单号：</td>
					<td width="250px"><input type="text" class="in"    name="scrapNum" readonly="readonly" id="scrapNum" value="aa"></td><!-- scrapNum -->
					<td class="td" ALIGN="left" VALIGN="top">资产名称：</td>
					<td>
										<select class="easyui-combobox" name="name" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;"  id="assetname">
										<!-- 	<option value="" checked="checked"></option>
											<option value="" ></option> -->
										</select>
										<pb2></pb2></td> 
					<!-- <td><input type="text" class="in"  id="assetname"  readonly="readonly"><pb2></pb2></td> -->
				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">资产编号：</td>
					<td><select class="easyui-combobox" name="state"
						style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;" id="assetcode">
					</select><pb1></pb1></td>
					<td class="td" ALIGN="left" VALIGN="top">清理方式：</td>
					<td><select name="state"  class="easyui-combobox" 
						style="width:150px;height:30px;border:solid 1px #ddd;padding-left:7px;"  id="cleanway">
							<option value="报损">报损</option>
							<option value="报废">报废</option>
					</select></td>
				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">清理日期：</td>
					<td><input type="text"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="申请日期"
						class="laydate-icon" id="demo" 
						name="purchasetime"
						style="text-align:center;height:25px;width:150px;"><pb3></pb3></td>

				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top" ">备注：</td>
					<td colspan="3"><textarea rows="4" style="width:545px;"
							value="" name="remark"   id="remark"></textarea></td>
				</tr>
			</table>
		</div>
		<div style="margin-left:560px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary" value="保存" onclick="javascript:void(0)"  id="save">
				</span> <span style="padding-left:5px;"> <input type="button"
							class="btn btn-primary" id="clear" value="清空"
							onclick="javascript:void(0)">
						</span>
		</div>
	</div>
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
	<input type="hidden"  id="h1"  value=""/>
	<input type="hidden"  id="h2"  value=""/>
	<script type="text/javascript">
		!function() {
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({
				elem : '#demo',
				format: 'YYYY-MM-DD',
			    istime: true,
			    istoday: false
			});//绑定元素
		}();
		
		$("#scrapNum").val( (new Date()).format('ymd')+Math.floor(Math.random()*8999999+1000000).toString());	
	</script>
<script type="text/javascript">
//清空对应的js代码
$("#clear").click(function clear(){
	if(document.getElementById("hide").value!="fe"){
		$("#assetcode").combobox("clear");
		$("#assetname").combobox("clear");
		//document.getElementById("assetname").value="";
		document.getElementById("demo").value="";
		document.getElementById("remark").value="";
	}

});
//保存对应的js代码
$("#save").click(function save(){
     var scrapNum=document.getElementById("scrapNum").value;
     var assetcode= $('#assetcode').combobox('getValue');
     var cleanway= $('#cleanway').combobox('getValue');
     var assetname=$('#assetname').combobox('getValue');
    //var assetname=document.getElementById("assetname").value;
     var cleandate=document.getElementById("demo").value;
     var remark=document.getElementById("remark").value;
     var h1=document.getElementById("h1").value;
     var h2=document.getElementById("h2").value;
     if(assetcode==""&&document.getElementById("hide").value!="fe"){
    	 $("pb1").html("不能为空");
     }
     if(assetname==""&&document.getElementById("hide").value!="fe"){
    	 $("pb2").html("不能为空");
     }
     if(cleandate==""&&document.getElementById("hide").value!="fe"){
    	 $("pb3").html("不能为空");
     }
     if(assetcode!=""&&document.getElementById("hide").value!="fe"){
     	 $("pb1").html("");
      }
     if(assetname!=""&&document.getElementById("hide").value!="fe"){
     	 $("pb2").html("");
      }
     if(cleandate!=""&&document.getElementById("hide").value!="fe"){
    	 $("pb3").html("");
      }
      if((isNaN(assetcode)||assetcode.length>15)&&document.getElementById("hide").value!="fe"){
    	  alert("数据格式错误");
      }
      if(((h1=="no"||h2=="no")&&document.getElementById("hide").value!="fe")&&document.getElementById("hide").value!="fe"){
    	  alert("存在非法数据(检查资产代码或资产名称是否正确)");
      }
      if((assetcode!=""&&assetname!=""&&cleandate!=""&&h1=="yes"&&h2=="yes"&&document.getElementById("hide").value!="fe")&&document.getElementById("hide").value!="fe"){
     $.ajax({
    	 type:"post",
    	 url:'<%=basePath %>AdminScrapController/savescraprecord.htm',
         data : {scrapnum:scrapNum,assetcode : assetcode,cleanway : cleanway,assetname : assetname,cleandate : cleandate,remark : remark},
		success : function(e) {
			var data = eval("(" + e + ")");
			alert(data.msg);
			window.location.reload();
			$('#assetcode').combobox("clear");
			document.getElementById("demo").value="";
			//document.getElementById("assetname").value="";
			$('#assetname').combobox("clear");
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
<%-- //js监听资产编号
document.getElementById("assetname").value="";
$('#assetcode').combobox({  
        onChange:function(){   
       	 var assetcode= $('#assetcode').combobox('getValue');    
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
                   		if(data.state==1){
                   		$("pbname").html("");
                   		document.getElementById("assetname").value=data.assetname;
                   		}
                   	  }
                    });
       	 }
        }
  });  --%>
  
  
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
  				//$('#assetcode').combobox('setValue',data.assetcode); 
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
					$("pb1").html("无此资产");
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
					$("pb2").html("无此资产");
					document.getElementById("h2").value="no";
				}
				if(data.state=="0"){
					$("pb2").html("");
					document.getElementById("h2").value="yes";

				}
		}
	});  
	    }
	});  
</script>
</body>
</html>
