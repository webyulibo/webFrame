<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资产领用</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/data.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
      <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
      <script type="text/javascript" src="<%=basePath%>Public/Js/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	<script type="text/javascript" src="<%=basePath%>/Public/Js/laydate.js"></script>
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
  </head>
 <body >
	<div class="container-f">
		<div class="box-title clearfix tab-title"></div>
	</div>
	<div style="margin-top:40px;margin-left:100px;">
		<a class="btn fbtn" href="<%=basePath%>AdminAssetLeadController/showleadasset.htm">
			<i class="fa fa-plus"></i><span>查看领用记录列表</span>
		</a>
	</div>
	<form id=form1>
	<div style="margin-top:50px;margin-left:100px;min-width:1100px;">
		<div>
			<table class="tab">
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">领用单号：</td>
					<td width="250px"><input type="text" class="in"    name="scrapNum" readonly="readonly" id="assetcode" ></td><!-- scrapNum -->
				<td class="td" ALIGN="left" VALIGN="top">资产编号：</td>
					<td>
					<select class="easyui-combobox" name="code" id="code" 
						style="width:150px;height:30px;border:solid 1px gra;padding-left:7px;">
					</select> <p-typename0 style="font-size:12px;color:black"></p-typename0>
					</td>
				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">领用部门：</td>
					<td><select class="easyui-combobox" name="state"  id="possessdepartment"
						style="width:150px;height:30px;border:solid 1px #ddd;padding-left:7px;">
					</select></td>
					<td class="td" ALIGN="left" VALIGN="top">领用人：</td>
					<td><select class="easyui-combobox" name="state"  id="possesspeople"
						style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
					</select></td>
				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">领用日期：</td>
					<td><input type="text"  
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="填写日期"
						class="laydate-icon" id="possessdate" 
						name="possessdate" style="text-align:center;height:25px;width:150px;"></td>

				</tr>
				<tr>
					<td class="td" ALIGN="left" VALIGN="top">备注：</td>
					<td colspan="3"><textarea rows="4" style="width:545px;" id="remark" name="remark"></textarea></td>
				</tr>
			</table>
		</div>
		</div>
		<div style="margin-left:580px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary cf save_btn save" value="保存" id="savelead"  style="height:30px;padding-top:0px;" onclick="javascript:void(0)">
			</span> <span style="margin-left:5px;"> <input type="button" id="clear"  style="height:30px;padding-top:0px;"class="btn btn-primary" value="清空" onclick="javascript:void(0)">
			</span>
		</div> 
		</form>
<shiro:hasPermission name="checkauth">
	<script type="text/javascript">
	//document.getElementById("save").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		$(".save_btn").removeClass("save");
		$(".save_btn").click(function(){alert('权限不足，无法进行此操作');});	
</script>
</shiro:hasPermission>	
	<script type="text/javascript">
	//清空对应的js代码
$("#clear").click(function clear(){
	$("#code").combobox("clear");
	$("#possesspeople").combobox("clear");
	$("#possessdepartment").combobox("clear");
	document.getElementById("remark").value="";
	 $("p-typename0").html("");
});
	</script>
	<script type="text/javascript">
		!function() {
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({
				elem : '#possessdate'
			});//绑定元素
		}();
	        //领取单号的随机生成
			$("#assetcode").val( (new Date()).format('ymd')+Math.floor(Math.random()*8999999+1000000).toString());
			//领取日期首先定位到当前日期
			$("#possessdate").val( (new Date()).format('y-m-d'));
	</script>
	<script type="text/javascript">
	$(".save").click(function save(){
		var assetcode=document.getElementById("assetcode").value;
		var code=$('#code').combobox('getValue');
		var possesspeople=$('#possesspeople').combobox('getValue');
		var possessdepartment=$('#possessdepartment').combobox('getValue');
		var possessdate=document.getElementById("possessdate").value;
		var possessremark=document.getElementById("remark").value;
		if(assetcode=="")
	   		alert("领用编号不能为空");
	   	else if(code=="")
	   		alert("资产编号不能为空");
	   	else if(code.indexOf(" ")>=0)
	   	    alert("资产编号只能是数字");
	   	else if(possesspeople=="")
	   		alert("领用人不能为空");
	   	else if(possessdepartment.indexOf(" ")>0)
	        alert("领用部门不能含空格");
	    else if(possesspeople.indexOf(" ")>0)
	        alert("领用人姓名不能含空格");
	   	else if(possessdepartment=="")
	   		alert("领用部门不能为空");
	   	else if(possessdate=="")
	   		alert("领用日期不能为空");
	   	else 
	   	{  
	   	$('#savelead').attr("disabled","disabled");
	   	  $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 url:'<%=basePath%>AdminAssetLeadController/isleadasset.htm', 
    					 data:{code:code,possesspeople:possesspeople,possessdepartment:possessdepartment}, //表单数据
 					 	success:function(e)
 					 	{
	 							var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 							$.ajax({
		      	                                type:"post",
		                                     	url:'<%=basePath %>AdminAssetLeadController/saveleadasset.htm',
		                                    	data : {assetcode:assetcode,code:code,possessdepartment:possessdepartment,possesspeople:possesspeople,possessdate:possessdate,possessremark:possessremark},
		                                       	success : function(e) {
				                              	var data = eval("(" + e + ")");
					                            alert(data.msg);
					                            location.href="<%=basePath%>AdminAssetLeadController/index.htm";
			                                     	 }  
		                                       	});	
			                           
		                                  $.ajax({
		      	                                       type:"post",
		                                     	       url:'<%=basePath %>AdminAssetLeadController/updateasset.htm',
					                                   data : {code:code},
			                                     	   });
			                              //领取单号的随机生成
			                             $("#assetcode").val( (new Date()).format('ymd')+Math.floor(Math.random()*8999999+1000000).toString());
			                             //领取日期首先定位到当前日期
		                                 $("#possessdate").val( (new Date()).format('y-m-d'));
      					    	}else{
								       alert(data.msg);
    							     }
   					   }
   			   });   
	      
		}
		
	});
</script>
<script>
$('#possessdepartment').combobox({  
        onSelect:function(){  
       	 var possessdepartment= $('#possessdepartment').combobox('getValue'); 
       	 <%-- alert("<%=basePath%>AdminAssetLeadController/getpossesspeople.htm?possessdepartment="+possessdepartment); --%>
       	 $('#possesspeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
       		    url:"<%=basePath%>AdminAssetLeadController/getpossesspeople.htm?possessdepartment="+possessdepartment,
       		    valueField:'text', //设置combobox的value
       		    textField:'text',//设置combobox显示的text
       		    editable:true
       		    });
       	 } 
});  
</script>

<script type="text/javascript">
$('#code').combobox({  
onSelect:function(){  
   $("p-typename0").html("");
}
});
</script>
<script type="text/javascript">
 $(function()
 {
  $('#code').combobox({
      url:'<%=basePath%>AdminAssetLeadController/getpossesscode.htm',
      valueField:'text',
      textField:'text',
      editable:true   
       });
     $('#possessdepartment').combobox({
      url:'<%=basePath%>AdminAssetLeadController/getpossessdepartment.htm',
      valueField:'text',
      textField:'text',
      editable:true//将combobox置为不可输入状态
    });
 });
</script>


 <script type="text/javascript">
 $(function()
 {
  
  $(".textbox-text:eq(0)").bind("input propertychange",function(){
  var code=$(".textbox-text:eq(0)").val();
  if(code==""||code==null)
  {
    $("p-typename0").html("类型名称不能为空！");
  }
  else
  {
     if(code.indexOf(" ")>=0)
     {
        $("p-typename0").html("输入有空格！");
     }
     else
     {
      $.ajax({ 
         type:"POST", //表单提交类型 
         url:'<%=basePath%>AdminAssetLeadController/ispossesscodelegal.htm', 
         data:{code:code}, //表单数据
 	     success:function(e)
 	     {
	  	  var  data = eval("("+e+")");
      	  if(data.status == 'ok')
      	     {//msg 是后台调用action时，你穿过来的参数
      		 $("p-typename0").html("");
      		 }
      		 else if(data.status=='no')
      		 {
			  $("p-typename0").html("不存在");
    		 }
    	}
          });
    							 
     }
  }
 });
 });
 
 $(function(){
 		$('#possesspeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
 		    url:'<%=basePath%>AdminAssetBorrowController/getborrowpeoplejson.htm',
 		    valueField:'text', //设置combobox的value
 		    textField:'text',//设置combobox显示的text
 		    editable:true
 		    });
 });
 
 $('#possesspeople').combobox({  
	    onChange:function(){  
	    var borrowpeople=$('#possesspeople').combobox('getValue'); 
	    $.ajax({
	    	 type:"post",
	    	 url:'<%=basePath %>AdminAssetBorrowController/getborrowpeople.htm',
	         data : {borrowpeople:borrowpeople},
			success : function(e) {
				var data = eval("(" + e + ")");
				if(data.state=="1"){
					$('#possessdepartment').combobox('setValue',data.borrowdepname); 
				}
				if(data.state=="0"){
					$('#possessdepartment').combobox('setValue',""); 
				}
		}
});  
	    }
	});
 
 $('#possessdepartment').combobox({  
	    onChange:function(){  
	   if($('#possessdepartment').combobox('getText')=="")
	    {	
			$(function(){
				$('#possesspeople').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
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