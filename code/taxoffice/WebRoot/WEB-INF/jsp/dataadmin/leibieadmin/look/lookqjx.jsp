<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@	taglib uri="/pageuri" prefix="cc" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看子类型</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/page.css" />
 	 	<script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.js"></script>
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/page.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/lbglqjx.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/lbglqll.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/lbgllmt.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Public/Css/themes/material/easyui.css" />
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>Public/Css/bootstrap.min.css" />
	
	<style>
	.box-title { border-bottom:1px solid #fff;}
	</style>
<!-- 返回页面跳转操作 -->
<script>
		function f(){
				if(${fid}==0){
       			location.href='<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?dis=3&pagenum=${pagenum}';
       		}
       		else{
       			location.href='<%=basePath%>adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${fid}&dis=3&pagenum=${pagenum}';
       		}
		}
</script>

<!-- 页面跳转操作 -->
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
				}
			}						
		}
	</script>

<!-- 执行删除子类型操作 -->
	<script type="text/javascript">
	function deleteAssetType(Id){
		var co=confirm('确定删除？');
		if(co==true){
			var ID=Id;
			 $.ajax({ 
     	type:"POST", //表单提交类型 
    	 url:'<%=basePath%>adminassettype/deleteassettypemenu.htm', 
     	data:{id:ID}, //表单数据
  		success:function(e){
	 	 var  data = eval("("+e+")");
      	if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
      		 location.href="<%=basePath%>adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${id}&dis=1&pagenum=${pagenum}&currentPage=${pager.currentPage}";
     	 }else{
			alert(data.msg+",该类别下有其他子类别，无法删除，请先将子类别删除！");
     	 }
	
     }
    }); 
	}
}
	
	</script>

<!-- 执行添加子类型操作 -->
	<script>
function addelseassettypemenu(){
/* 	var Typename=document.getElementById("typename1").value;
	var Unit=document.getElementById("unit1").value;
	var Value=document.getElementById("value1").value;
	var Fid=document.getElementById("fidhidden1").value; */
	
	var Typename=document.getElementById("typename1").value;
	var Unit = $('#unit1').combobox('getValue');
	var Value=document.getElementById("value1").value;
	var Fid=document.getElementById("fidhidden1").value;
	if(Typename==""){
		alert("类型名称为空，请重新输入！");
	}else{
	if(!isNaN(Value)){
	if(Typename.indexOf(" ")>=0){
                	Typename = Typename.replace(/\s/g, "");
                }
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
     data:{fid:Fid,typename:Typename,unit:Unit,value:Value}, //表单数据
  success:function(e){
	  var  data = eval("("+e+")");
      if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
       		
       			location.href="<%=basePath%>adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${id}&dis=1&pagenum=${pagenum}&currentPage=${pager.currentPage}";
      
      		 
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

<!-- 添加类型表单合法性验证 -->
<script>
	//类型名称的验证
        $(function(){
            $("#typename1").bind("input propertychange",function(){
                var Typename=document.getElementById("typename1").value;
                var Fid=document.getElementById("fidhidden1").value;
                if(Typename==""||Typename==null){
                    $("p-typename1").html("类型名称不能为空！");
                }else{
                 if(Typename.indexOf(" ")>=0){
                	$("p-typename1").html("输入有空格！");
                }else{
                $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 url:'<%=basePath%>adminassettype/istypenamelegal.htm', 
    					 data:{typename:Typename,fid:Fid}, //表单数据
 					 	success:function(e){
	 							 var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 						$("p-typename1").html("");
      						}else{
								$("p-typename1").html(data.msg);
    							 }
   								            }
   							 }); 
                }
                
               		
                }
            });
        });
        //资产金额的验证
         $(function(){
            $("#value1").bind("input propertychange",function(){
                var Value=document.getElementById("value1").value;
                    if(!isNaN(Value)) {
                        if (Value != "") {
                            if(!/^\d{1,11}(?:\.\d{1,2})?$/.test(Value)){
                            	 $("p-value1").html("数字格式不正确！");
                            }
                            else{
                             $("p-value1").html("");
                            }
                        }
                    }
                    else{
                        $("p-value1").html("请输入合法数字！");
                    }
            });
        });
    </script>

<!-- 添加模态框 mymodal4 的内容复位 -->
<script>
   $(function () { $("#mymodal4").on('hidden.bs.modal', function () {
	document.getElementById("typename1").value="";
	//document.getElementById("unit1").value="";
	$('#unit1').combobox('select',"");//修改回显设置默认选中值
	document.getElementById("value1").value="";
	document.getElementById("fidhidden1").value="";
	$("p-typename1").html("");
	 $("p-value1").html("");
	 $("p-ftypename").html("");  
	  $('#unit1').combobox({}).combobox("initClear");
	});
   });
</script>

<!-- 显示添加模态框 mymodal4 之前内容的赋值 -->
<script>
	//必不可少
   $(function(){
    	$(".btn-tck4").click(function(){
    		$('#unit1').combobox({editable:false});//将combobox可编辑的属性改为false
    		var fid=$(this).attr("data-fid");
    		var typename=$(this).attr("data-typename");
    		$("p-ftypename").html(typename);  
    		 $('#fidhidden1').val(fid);  
        	$("#mymodal4").modal('show');  
        	$('#mymodal4').on('shown.bs.modal', function () {
			  	$('#typename1').focus();
			});
    	});
    });
</script>

<!-- 执行修改操作 -->
<script>
function csave(){
	var Typename=document.getElementById("typename2").value;
	//var Unit=document.getElementById("unit2").value;
	var Unit = $('#unit2').combobox('getValue');
	var Value=document.getElementById("value2").value;
	var Pretypename=document.getElementById("typenamehidden2").value;
	var Id=document.getElementById("idhidden2").value;
	var Fid=document.getElementById("fidhidden2").value;
	if(Typename==""){
		alert("类型名称为空，请重新输入！");
	}else{
	if(Typename.indexOf(" ")>=0){
                	Typename = Typename.replace(/\s/g, "");
                }
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
     data:{id:Id,fid:Fid,typename:Typename,unit:Unit,value:Value,pretypename:Pretypename}, //表单数据
  success:function(e){
	  var  data = eval("("+e+")");
      if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
 
       			location.href="<%=basePath%>adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${id}&dis=1&pagenum=${pagenum}&currentPage=${pager.currentPage}";
       		
      		 
      }else{
		alert(data.msg);//添加失败重新对表单进行赋值
	$("#typename2").val(Typename); 
	$('#unit2').combobox('select',Unit);//修改回显设置默认选中值
	document.getElementById("value2").value=Value;
	document.getElementById("typenamehidden2").value=Pretypename;
	document.getElementById("idhidden2").value=Id;
	document.getElementById("fidhidden2").value=Fid;
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

<!-- 显示修改模态框 mymodal5 之前内容的赋值 -->
<script>
	//必不可少
   $(function(){
   		$('#unit2').combobox({editable:false});//将combobox可编辑的属性改为false
    	$(".btn-tck5").click(function(){
    	var id=$(this).attr("data-id");
        var fid=$(this).attr("data-fid");
        var typename=$(this).attr("data-typename");
        var unit=$(this).attr("data-unit");
        var value=$(this).attr("data-value");
        	$('#idhidden2').val(id); 
        	$('#fidhidden2').val(fid);   
    		 $('#typename2').val(typename);  
    		 $('#typenamehidden2').val(typename); 
    		 if(unit==null){
    		 $('#unit2').val(""); 
    		 }else{
    		 $('#unit2').combobox('select',unit);//修改回显设置默认选中值
    		  $('#unit2').val(unit);
    		 }
    		 $('#value2').val(value);  
        	$("#mymodal5").modal('show'); 
        	$('#mymodal5').on('shown.bs.modal', function () {
        		var t=$("#typename2").val();
   				 $("#typename2").val("").focus().val(t);//使用重新赋值重新聚焦的方法
			});
    	});
    });
</script>

<!-- 修改模态框 mymodal5 的内容复位 -->
<script>
   $(function () { $("#mymodal5").on('hidden.bs.modal', function () {
	 $("p-typename2").html("");
	 $("p-value2").html("");
	  $('#unit2').combobox({}).combobox("initClear");
	});
   });
</script>

<!-- 修改类型表单合法性验证 -->
<script>
	//类型名称的验证
        $(function(){
            $("#typename2").bind("input propertychange",function(){
                var Typename=document.getElementById("typename2").value;
                var Fid=document.getElementById("fidhidden2").value;
                var Pretypename=document.getElementById("typenamehidden2").value;
                if(Typename==""||Typename==null){
                    $("p-typename2").html("类型名称不能为空！");
                }else{
                	 if(Typename.indexOf(" ")>=0){
                	$("p-typename2").html("输入有空格！");
                }else{
                 $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 url:'<%=basePath%>adminassettype/isupdatetypenamelegal.htm', 
    					 data:{typename:Typename,fid:Fid,pretypename:Pretypename}, //表单数据
 					 	success:function(e){
	 							 var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 						$("p-typename2").html("");
      						}else{
								$("p-typename2").html(data.msg);
    							 }
   								            }
   							 }); 
                }
               
               		
                }
            });
        });
        //资产金额的验证
         $(function(){
            $("#value2").bind("input propertychange",function(){
                var Value=document.getElementById("value2").value;
                    if(!isNaN(Value)) {
                        if (Value != "") {
                            if(!/^\d{1,11}(?:\.\d{1,2})?$/.test(Value)){
                            	 $("p-value2").html("数字格式不正确！");
                            }
                            else{
                             $("p-value2").html("");
                            }
                        }
                    }
                    else{
                        $("p-value2").html("请输入合法数字！");
                    }
            });
        });
    </script>
 </head>
  
  <body>
    <div class="lbgl">
	<div class="top-hx tab-title"></div>
	<fieldset>
		<legend><span style="font-size:14px;">${fAssetTypeName }${assetType.fid }</span></legend>
	<div class="lbgl-top" style="padding-top:0px;margin-top:10px;">
		<div class="lbgl-top-left f_1" style="width:100px;">
		<input type="button" class="btn btn-primary" value="返回" onclick="f()"/>
		</div>
		<div class="lbgl-top-right">
		</div>
	</div>
	<div class="tab-lbgl" style="margin-top:50px;">
		<table class="tab dataTable">
			<tr class="tab-tr">
				<th class="tab-th">类型名称</th>
				<th class="tab-th">计量单位</th>
				<th class="tab-th">资产金额</th>
				<th class="tab-th">查看子类型</th>
				<th class="tab-th">添加子类型</th>
				<th class="tab-th">操作</th>
			</tr>
			<c:forEach items="${assetTypeList }" var="assetType">
			<tr class="tab-tr">
				<td class="tab-td">${assetType.typename}</td>
				<td class="tab-td">${assetType.unit}</td>
				<td class="tab-td">${assetType.value}</td>
				<td class="tab-td">
					<a href="${basePath}adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${assetType.id}&fAssetTypeName=${assetType.typename}&dis=2&pagenum=${pagenum}" class="btn" ><i class="fa fa-search"></i>查看</a>
				</td>
				<td class="tab-td">
					<a data-fid="${assetType.id}" data-typename="${assetType.typename}" class="btn btn-add btn-tck4" ><i class="fa fa-plus"></i>添加</a>
					<div class="modal fade" id="mymodal4">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
									<h2 class="modal-title">&nbsp&nbsp&nbsp&nbsp添加&nbsp<p-ftypename></p-ftypename>&nbsp的子类型
									<label class="name"><%-- ${fAssetTypeName } --%></label>
									</h2>
								</div>
								<div class="modal-body">
									<div class="container-f" style="padding-left:0px;">
 				 					<div class="hr"></div>
  										<div class="box-title clearfix tab-title"  class="input-xlarge">
   						<form id="asset1" action=" " method="post" class="form" >
							<div class="control-group cf clearfix" style="text-align:left;padding-left:14px">
									<label class="form-lb form" for="web_bg"> 类型名称：</label>
									<input type="text" name="typename1" id="typename1"   class="input form-text"style="padding: 5px 2px;" value=""><p-typename1 style="font-size:12px;"></p-typename1>		
									<input type="hidden" name="fidhidden1" id="fidhidden1"  value="">	
							</div>
							<div class="form-row " style="padding-left:0px;" >
									<label class="form-lb form" for="web_bg"style="margin-left:-10px;"> 计量单位：</label>
									<span style="overflow:hidden;">
									  <select class="easyui-combobox" name="unit1" id="unit1"  style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
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
				                     </span>
							</div>
							<div class="form-row"style="text-align:left;padding-left:135px;">
									<label class="form-lb form" for="web_bg">资产金额：</label>
									<input type="text" name="value1" id="value1"  class="input form-text" value=""style="padding: 5px 2px; " placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='小数点后最多保留两位'"><p-value1 style="font-size:12px;"></p-value1>
							</div>
							<!-- <div class="form-actions" >
								<a href="javascript:void(0)" class="btn btn-primary" onclick="addassettypemenu()" ><i class="fa fa-plus"></i>添加</a>
								</div> -->
  						</form>
				  	</div>
				 </div>	
				</div>
					<div class="modal-footer">
<!-- 						<a href="javascript:void(0)" class="btn btn-primary btn-tck2" onclick="f()" data-dismiss="modal">返回</a>
 -->						<button type="button" class="btn btn-primary btn-tck2" onclick="addelseassettypemenu()"><i class="fa fa-plus"></i>添加</button>
					</div>
				</div>
			</div>
		</div>
				</td>
				<td class="tab-td">
					<a data-id="${assetType.id}" data-fid="${assetType.fid}" data-typename="${assetType.typename}" data-unit="${assetType.unit}"  data-value="${assetType.value}"  class="btn btn-edit btn-tck5" ><i class="fa fa-edit"></i>修改</a>
					<div class="modal fade" id="mymodal5">
				    <div class="modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
								<h2 class="modal-title">修改</h2>
							</div>
							<div class="modal-body">
							<div>
						<form id="asset2" action="" class="form">
							<div class="control-group cf clearfix" style="text-align:left;padding-left:25px">
								<label for="" class="form-lb form">类型名称：</label>
								<input type="text" class="form-text" id="typename2" name="typename2" value=""><p-typename2 style="font-size:12px;"></p-typename2>
								<input type="hidden" name="typenamehidden2" id="typenamehidden2" value="">
								<input type="hidden" name="idhidden2" id="idhidden2"  value="">	
								<input type="hidden" name="fidhidden2" id="fidhidden2"  value="">	
							</div>
						<div class="form-row">
							<label for="" class="form-lb form"style="margin-left:-10px;">计量单位：</label>
							<%-- <input type="text" class="form-text" name="unit" value="${assetType.unit}"> --%>
							 <span style="overflow:hidden;">  
							 <select class="easyui-combobox" name="unit2" id="unit2"  style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
											<option value="">请选择计量单位</option>
											<option value="平方米">平方米</option>
											<option value="台">台</option>
											<option value="套">套</option>
					  						<option value="辆">辆</option>
					  						<option value="部">部</option>
					  						<option value="件">件</option>
					  						<option value="个">个</option>
					  						<option value="台,套">台,套</option>
							</select> </span><%-- <input name="unit"  value="${assetType.unit}" style="width:135px;position:absolute;left:123px; top:121px;"> --%>
						</div>
						<div class="form-row"style="text-align:left;padding-left:145px;">
							<label for="" class="form-lb form">资产金额：</label>
							<input type="text"  class="form-text" name="value2" id="value2" placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='小数点后最多保留两位'" value=""><p-value2 style="font-size:12px;"></p-value2>
						</div>
						</form>	
					</div>
				</div>
					<div class="modal-footer">
						<button class="btn btn-primary <!-- btn-tck3 这里千万不要带btn-tck3否则会重新加载模态框-->" onclick="csave()"><i class="fa fa-edit btn-tck5"></i>修改</button>
					</div>	
				</div>
			</div>
		</div>
				<a href="javascript:void(0)" class="btn btn-delete"  onclick="deleteAssetType(${assetType.id})" ><i class="fa fa-times"></i>删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
			<c:if test="${assetTypeList.size()==0 }">
			                   <br/>
			     &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp 暂无数据
			     				<br/>
			</c:if>
			<br/>
			<cc:page url="${basePath}adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${id}&dis=1&pagenum=${pagenum}" value="${pager}"/>
	</div>
	</fieldset>
	
	<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		/* window.onload=function(){
			document.getElementById("myCheck").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		}	 */
		
		//将修改按钮改为无权限
		for(var i=0;i<$(".btn-edit").length;i++){
			$(".btn-edit").removeClass("btn-tck5");
		}
		$(".btn-edit").click(function(){alert("权限不足，无法进行此操作")});
		
		//将添加一级类型改为无权限
		for (var j = 0; j < $(".btn-add").length; j++) {
			$(".btn-add").removeClass("btn-tck4");
		}
		$(".btn-add").click(function(){alert("权限不足，无法进行此操作")});
		
		//删除按钮权限设置
		for (var j = 0; j < $(".btn-delete").length; j++) {
			//$(".btn-delete").removeClass("btn-tck4");
			$(".btn-delete").attr("onclick","alert('权限不足，无法进行此操作')");
		}
		//$(".btn-delete").click(function(){alert("权限不足，无法进行此操作")});
		
		
		</script>	
	
	</shiro:hasPermission>
	
</div>
<div class="font">
		
	</div>
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
  </body>
</html>
