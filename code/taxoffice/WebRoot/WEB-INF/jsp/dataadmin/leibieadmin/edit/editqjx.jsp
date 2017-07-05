<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
   
    <title>修改</title>
   	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/lbglqjx.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	
	
	<script>
function csave(){
	var Typename=asset.typename.value;
	var Unit=asset.unit.value;
	var Value=asset.value.value;
	var Pretypename=asset.typenamehidden.value;
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
     url:'<%=basePath%>adminassettype/updateassettypemenu.htm', 
     data:{id:${assetType.id },fid:${assetType.fid },typename:Typename,unit:Unit,value:Value,pretypename:Pretypename}, //表单数据
  success:function(e){
	  var  data = eval("("+e+")");
      if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
       		if(${assetType.fid }==0){
       			location.href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?currentPage=${pager.currentPage}";
       		}
       		else{
       			location.href="<%=basePath%>adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${assetType.fid }&currentPage=${pager.currentPage}";
       		}
      		 
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
	<script>
function back(){
if(${assetType.fid }==0){
       			location.href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?currentPage=${pager.currentPage}";
       		}
       		else{
       			location.href="<%=basePath%>adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${assetType.fid }&currentPage=${pager.currentPage}";
       		}
			
		}
</script>
 </head>
  
  <body>
  <div class="cz-edit">
		<div class="top-hx table-title"></div>
		<div class="form-edit">
			<form id="asset" action="" class="form">
				<div class="form-row">
					<label for="" class="form-lb">类型名称：</label>
					<input type="text" class="form-text" name="typename" value="${assetType.typename }">
					<input type="hidden" class="form-text" name="typenamehidden" value="${assetType.typename }">
				</div>
				<div class="form-row">
					<label for="" class="form-lb">计量单位：</label>
					<%-- <input type="text" class="form-text" name="unit" value="${assetType.unit}"> --%>
					 <span style="overflow:hidden;">  
					<select name="unit" style="cursor: pointer;margin-left:5px;" onchange="this.parentNode.nextSibling.value=this.value">
						<c:if test="${assetType.unit==''}">
			            <option value="">请选择计量单位</option>
						<option value="平方米">平方米</option>
						<option value="台">台</option>
						<option value="套">套</option>
						<option value="辆">辆</option>
						<option value="部">部</option>
						<option value="件">件</option>
						<option value="个">个</option>
						<option value="台,套">台,套</option>
						</c:if>
						<c:if test="${assetType.unit!=''}">
						<option value="${assetType.unit}" >${assetType.unit}</option>
						<option value="">请选择计量单位</option>
						<c:if test="${assetType.unit!='平方米'}">
						<option value="平方米">平方米</option>
						</c:if>
						<c:if test="${assetType.unit!='台'}">
						<option value="台">台</option>
						</c:if>
						<c:if test="${assetType.unit!='套'}">
						<option value="套">套</option>
						</c:if>
						<c:if test="${assetType.unit!='辆'}">
						<option value="辆">辆</option>
						</c:if>
						<c:if test="${assetType.unit!='部'}">
						<option value="部">部</option>
						</c:if>
						<c:if test="${assetType.unit!='件'}">
						<option value="件">件</option>
						</c:if>
						<c:if test="${assetType.unit!='个'}">
						<option value="个">个</option>
						</c:if>
						<c:if test="${assetType.unit!='台,套'}">
						<option value="台,套">台,套</option>
						</c:if>
						</c:if>
						
					</select></span><%-- <input name="unit"  value="${assetType.unit}" style="width:135px;position:absolute;left:123px; top:121px;"> --%>
				</div>
				<div class="form-row">
					<label for="" class="form-lb">资产金额：</label>
					<input type="text" class="form-text" name="value" placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='小数点后最多保留两位'" value="${assetType.value}">
				</div>
			</form>
		</div>
		<div class="bottom">
			<button class="btn btn-primary" onclick="csave()"><i class="fa fa-edit"></i>修改</button>
			<button class="btn btn-primary" onclick="back()">返回</button>
		</div>
	</div>
  </body>
</html>
