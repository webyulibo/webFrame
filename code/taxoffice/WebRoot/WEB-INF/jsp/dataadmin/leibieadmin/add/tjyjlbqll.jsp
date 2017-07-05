<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
  
  <base href="<%=basePath%>">
  	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/lbglqll.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	<title>添加一级类型</title>		
			
    
  </head>
  
  <body>
     <div class="container-f">
  <div class="hr"></div>
  <div class="box-title clearfix tab-title"  class="input-xlarge">
  
  <div class="returnbtn">

             
				<a href='${basePath}adminassettype/getassettypefirstmenubyfidwithpage.htm?id=0&currentPage=${pager.currentPage}' class="btn btn-primary" >返回</a>
				
  </div>
   <form id="asset" action="${basePath}adminassettype/getassettypefirstmenubyfidwithpage.htm?currentPage=${pager.totalPage} " method="post" class="form" >
		<div class="control-group cf clearfix " >
					<label class="control-label" for="web_bg">
					    类型名称：
					</label>
					
						<input type="text" name="typename" id=" "   class="input"style="padding: 5px 2px; " value="">
					
					
		</div>
		<div class="control-group cf clearfix " >
					<label class="control-label" for="web_bg">
					    计量单位：
					</label>
				    <span style="overflow:hidden;">
					  
					<select name="unit"  style="width: 150px;padding: 5px 2px;cursor: pointer;" onchange="this.parentNode.nextSibling.value=this.value"> 
  						<option value="">请选择计量单位</option>
  						<option value="平方米">平方米</option>
  						<option value="台">台</option>
  						<option value="套">套</option>
  						<option value="辆">辆</option>
  						<option value="部">部</option>
  						<option value="件">件</option>
  						<option value="个">个</option>
  						<option value="台,套">台,套</option>
					  </select> 
                     </span>  <!-- <input name="unit" style="width:135px;position:absolute;left:140px; top:40px;"> -->
		</div>
		<div class="control-group cf clearfix " >
					<label class="control-label" for="web_bg">
					    资产金额：
					</label>
					
						<input type="text" name="value" id="sum"  class="input" style="padding: 5px 2px; " placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''"  onBlur="javascript:placeholder='小数点后最多保留两位'" value="">
					
		</div>
		<div class="form-actions" >
					
					<a href="javascript:void(0)" onclick="addassettypemenu()" class="btn btn-primary" ><i class="fa fa-plus"></i>添加</a>
				</div>
  </form>
  </div >
  </div>  
  
  
  
<script type="text/javascript">
	function addassettypemenu(){
	var Typename=asset.typename.value;
	var	Unit=asset.unit.value;
	var Value=asset.value.value;
	
	if(Typename==""){
		alert("类型名称为空，请重新输入！");
	}else{
				if(!isNaN(Value)){
				if(Value!=""){
					Value += '';
    				Value = Value.replace(/[^0-9|\.]/g, ''); 
    				if(/^0+/) //清除字符串开头的0
      				  Value = Value.replace(/^0+/, '');
   					 if(!/\./.test(Value)) //为整数字符串在末尾添加.00
     				   Value += '.00';
    				if(/^\./.test(Value)) //字符以.开头时,在开头添加0
     				   Value = '0' + Value;
   					 Value += '00';        //在字符串末尾补零
    				Value = Value.match(/\d+\.\d{2}/)[0];
	}
		
						 $.ajax({ 
    						 type:"POST", //表单提交类型 
     						 url:'<%=basePath%>adminassettype/addassettypemenu.htm', 
    						 data:{typename:Typename,unit:Unit,value:Value}, //表单数据
 							 success:function(e){
								  var  data = eval("("+e+")");
    							  if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       							alert(data.msg);
      							 location.href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?currentPage=${pager.totalPage}";
      					}else{
								alert(data.msg);
     						 }
	
    					 }
   							 });
					
				}
				else{
					alert("资产金额输入不合法，请重新输入！");
				}
	}	
	}
	
</script>
</body>
</html>
