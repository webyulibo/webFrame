<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@	taglib uri="/pageuri" prefix="cc" %>
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
.tab td {
	height: 50px;
	vertical-align: top;
	padding-top: 20px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	padding-right:20px;
}
	input[readonly]{
		background-color:white;
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
		<div class="lbgl-top-left f_1" style="margin-top:60px;margin-left:100px;">
			<a href="<%=basePath%>adminassetmaintaincontroller/showmaintainlist.htm" class="btn btn-add" style="width:110px;">
			<i class="fa fa-plus"></i><span>查看维修记录列表</span>
			</a>
		</div>
	<div class="control-group f_l" style="min-width:1100px">
	<form action="" name="borrow">
	<div style="margin-top:30px;margin-left:100px;">
		<div>
			<table class="tab">
				<tr>
			      <td width="100px">资产名称：</td>
					<td width="250px">
						<select class="easyui-combobox" name="name" id="name" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
						</select>
					</td>
					<td>资产编号：</td>
					<td width="250px">
						<select class="easyui-combobox" name="code" id="code" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
						</select>
					</td>
				</tr>
				<tr>
					<td>购置日期：</td>
					<td><input type="text" readonly="readonly" class="in"  name="purchasedata" id="purchasedata"></td>
				
					<td>规格型号：</td>
					<td><input type="text" readonly="readonly" class="in" name="model" id="model"></td>
				</tr>
				<tr>
					<td>报废年限：</td>
					<td><input type="text" readonly="readonly" class="in" name="ghostyears" id="ghostyears"></td>
					<td>经手人：</td>
					<td>
						<select class="easyui-combobox" name="guy" id="guy" style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
						</select>
					</td>
					
				</tr>
				<tr>
					<td>送修日期：</td>
					<td>
						<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
						 class="laydate-icon" id="senddate"  
						name="senddate" style="text-align:center;height:25px;">
					</td>
				<tr>
					<td align="left" valign="top">故障描述：</td>
					<td colspan="3">
						<textarea rows="4" style="width:550px"  name="faultdescription" id="faultdescription"></textarea>
					</td>
				</tr>
				<tr>
					<td align="left" valign="top">办理结果：</td>
					<td colspan="3">
						<textarea rows="4" style="width:550px"  name="dealresult" id="dealresult"></textarea>
					</td>
				</tr>
			</table>
			<input type="hidden" id="ifhave" class="in" value="yes">
		</div>
		<div style="margin-left:565px;margin-top:30px;">
			<span> <input type="button" class="btn btn-primary" id="save"
				value="保存" onclick="saveInfo()">
			</span> <span style="padding-left:5px;"> <input type="button"
				class="btn btn-primary" id="clear" value="清空" onclick="clearInfo()">
			</span>
		</div>
	</div>
	</form>
	</div>
</div>




<script type="text/javascript">
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#senddate'});//绑定元素
		}();
		$("#senddate").val( (new Date()).format('y-m-d'));
</script>

<script type="text/javascript">
/* $("#clear").click(function clear(){
	document.getElementById("ifhave").value="no";
	$("#code").combobox("clear");
	$("#name").combobox("clear");
	$("#guy").combobox("clear");
    document.getElementById("purchasedata").value="";
	document.getElementById("model").value="";
	document.getElementById("ghostyears").value="";
	document.getElementById("faultdescription").value="";
	document.getElementById("dealresult").value="";
	document.getElementById("ifhave").value="yes";
}); */

function clearInfo(){
	document.getElementById("ifhave").value="no";
	$("#code").combobox("clear");
	$("#name").combobox("clear");
	$("#guy").combobox("clear");
    document.getElementById("purchasedata").value="";
	document.getElementById("model").value="";
	document.getElementById("ghostyears").value="";
	document.getElementById("faultdescription").value="";
	document.getElementById("dealresult").value="";
	document.getElementById("ifhave").value="yes";
}

</script>
<script type="text/javascript">
 $(function()
 {
  $('#code').combobox({
      url:'<%=basePath%>adminassetmaintaincontroller/getmaintaincode.htm',
      valueField:'text',
      textField:'text',
      editable:true   
       });

     $('#name').combobox({
      url:'<%=basePath%>adminassetmaintaincontroller/getmaintainname.htm',
      valueField:'text',
      textField:'text',
      editable:true//将combobox置为不可输入状态
    });
    
     $('#guy').combobox({
      url:'<%=basePath%>adminassetmaintaincontroller/getguy.htm',
      valueField:'text',
      textField:'text',
      editable:true   
       });
       $('#name').combobox({  
		    onSelect:function(record){  
		    var name=record.text;
		     $.ajax({
		    	 type:"post",
		    	 url:'<%=basePath %>adminassetmaintaincontroller/getcodebyname.htm',
		         data : {name:name},
				success : function(e) {
					var data = eval("(" + e + ")");
					if(data.state=="1"){
						//$('#code').combobox('setValue',data.assetcode); 
						 $('#code').combobox({// combobox本身就有根据输入的关键字自动检索的功能，所以只需要传入所有的数据即可
					   		    url:'<%=basePath%>adminassetmaintaincontroller/getassetcodejson2.htm?assetname='+record.text,
					   		    valueField:'text', //设置combobox的value
					   		    textField:'text',//设置combobox显示的text
					   		    editable:true
					   		    });
					}
					if(data.state=="0"){
						$('#code').combobox('setValue',"无此资产"); 
					}
			}
	});  
		    }
		});  
       //资产编码对应的onSelect事件
		$('#code').combobox({  
		    onSelect:function(record){  
		    var ifhave=document.getElementById("ifhave").value;
		    if(ifhave!="no")
		    {
		     var code= $('#code').combobox('getValue');
       	 $.ajax({
		    type:"post",
		    url:'<%=basePath %>adminassetmaintaincontroller/iscodelegal.htm',
		    data : {code:code},
		    success : function(e) {
            var data = eval("(" + e + ")");
            if(data.status == 'ok')
            {
             $.ajax({
		        type:"post",
		        url:'<%=basePath %>adminassetmaintaincontroller/getpurchasedatabycode.htm',
		        data : {code:code},
		        success : function(e) {
                var data = eval("(" + e + ")");
                 if(data[0].status =="ok")
                {
                  
                  document.getElementById("purchasedata").value=data[0].text;
                }
                else
                alert(data[0].msg);
                }
                });
                
             $.ajax({
		        type:"post",
		        url:'<%=basePath %>adminassetmaintaincontroller/getmodelbycode.htm',
		        data : {code:code},
		        success : function(e){
		        var data = eval("(" + e + ")");
                 if(data[0].status=="ok")
                document.getElementById("model").value=data[0].text;
                else
                alert(data[0].msg);                
                }
                });
             $.ajax({
		        type:"post",
		        url:'<%=basePath %>adminassetmaintaincontroller/getghostyearsbycode.htm',
		        data : {code:code},
		        success : function(e){
                var data = eval("(" + e + ")");
                  if(data[0].status=="ok")
                  {
                  
                   document.getElementById("ghostyears").value=data[0].text;
                  }
                  else
                   alert(data[0].msg);
                }
                });
            }
           else
           {
			    alert(data.msg);
    	   }
	     }
	     
	});
		    var code=record.text;
		     $.ajax({
		    	 type:"post",
		    	 url:'<%=basePath %>adminassetmaintaincontroller/getnamebycode.htm',
		         data : {code:code},
				success : function(e) {
					var data = eval("(" + e + ")");
					if(data.state=="1"){
						$('#name').combobox('setValue',data.assetname); 
					}
					if(data.state=="0"){
						$('#name').combobox('setValue',"无此资产"); 
					}
			}
	});  
	}
		    }
		}); 
			$('#code').combobox({  
		    onChange:function(){ 
		    var ifhave=document.getElementById("ifhave").value; 
		    if(ifhave!="no")
		    {
		   var code= $('#code').combobox('getValue');
       	 $.ajax({
		    type:"post",
		    url:'<%=basePath %>adminassetmaintaincontroller/iscodelegal.htm',
		    data : {code:code},
		    success : function(e) {
            var data = eval("(" + e + ")");
            if(data.status == 'ok')
            {
             $.ajax({
		        type:"post",
		        url:'<%=basePath %>adminassetmaintaincontroller/getpurchasedatabycode.htm',
		        data : {code:code},
		        success : function(e) {
                var data = eval("(" + e + ")");
                 if(data[0].status =="ok")
                {
                  
                  document.getElementById("purchasedata").value=data[0].text;
                }
                else
                alert(data[0].msg);
                }
                });
                
             $.ajax({
		        type:"post",
		        url:'<%=basePath %>adminassetmaintaincontroller/getmodelbycode.htm',
		        data : {code:code},
		        success : function(e){
		        var data = eval("(" + e + ")");
                 if(data[0].status=="ok")
                document.getElementById("model").value=data[0].text;
                else
                alert(data[0].msg);                
                }
                });
             $.ajax({
		        type:"post",
		        url:'<%=basePath %>adminassetmaintaincontroller/getghostyearsbycode.htm',
		        data : {code:code},
		        success : function(e){
                var data = eval("(" + e + ")");
                  if(data[0].status=="ok")
                  {
                  
                   document.getElementById("ghostyears").value=data[0].text;
                  }
                  else
                   alert(data[0].msg);
                }
                });
            }
          else
           {
			    alert(data.msg);
    	   }
	     }
	      
	}); 
	} 
		 }   
		}); 
});
</script>
<script type="text/javascript">
	/* $("#save").click(); */
	
	function saveInfo(){
		var code=$('#code').combobox('getValue');
		var name=$('#name').combobox('getValue');
		var guy=$('#guy').combobox('getValue');
		var senddate=document.getElementById("senddate").value;
		var faultdescription=document.getElementById("faultdescription").value;
		var dealresult=document.getElementById("dealresult").value;
		if(code=="")
		 alert("资产代码不能为空");
		else if(name=="")
		 alert("资产名称不能为空");
		 else if(guy=="")
		alert("经手人不能为空");
		else if(senddate=="")
		 alert("送修日期不能为空");
		else if(faultdescription=="")
		 alert("故障描述不能为空");
		else{
		  $('#savelead').attr("disabled","disabled");
	   	  $.ajax({ 
    		 type:"post", //表单提交类型 
    	     url:'<%=basePath%>adminassetmaintaincontroller/iscodelegal.htm', 
		     data:{code:code}, //表单数据
 			 success:function(e)
 		    {
 		    	var data = eval("(" + e + ")");
 		    	if(data.status=="ok")
 		    	{
 		    	   $.ajax({ 
    		       type:"post", //表单提交类型 
    	           url:'<%=basePath%>adminassetmaintaincontroller/iscodeandnamelegal.htm', 
		           data:{code:code,name:name}, //表单数据
 			       success:function(e)
 		           {
 		               var data = eval("(" + e + ")");
 		    	       if(data.status=="ok")
 		    	       {
 		    	          $.ajax({ 
    		              type:"post", //表单提交类型 
    	                  url:'<%=basePath%>adminassetmaintaincontroller/savemaintain.htm', 
		                  data:{code:code,guy:guy,senddate:senddate,faultdescription:faultdescription,dealresult:dealresult},
		                   success:function(e)
 		                    {
 		                      var data = eval("(" + e + ")");
 		    	              alert(data.msg);
 		    	            }
 		    	         });
 		    	         }
 		    	         else
 		    	          alert(data.msg);
 		             }
 		    	   });
 		    	}
 		    	else
 		    	{
 		    	alert(data.msg);
 		    	}
 		    }
		});
		}
}
</script>	

<shiro:hasPermission name="checkauth">
	
	<script type="text/javascript">
	document.getElementById("save").setAttribute("onclick", "alert('权限不足，无法进行此操作'); ");
	document.getElementById("clear").setAttribute("onclick", "alert('权限不足，无法进行此操作'); ");
	</script>
	

</shiro:hasPermission>


</body>
</html>
