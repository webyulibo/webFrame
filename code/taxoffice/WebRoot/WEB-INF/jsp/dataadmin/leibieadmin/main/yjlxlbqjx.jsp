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
    <title>一级类型列表</title>
 	<base href="<%=basePath%>">
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
<!-- 执行删除一级类型操作 -->
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
      		 location.href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?dis=1&pagenum=${pagenum}&currentPage=${pager.currentPage}";
     	 }else{
			alert(data.msg+",该类别下有其他子类别，无法删除，请先将子类别删除！");
     	 }
     }
    }); 
	}
}
	
	</script>

<!-- 页面跳转操作 -->
<script type="text/javascript">
		function getInfoByPage() {
			var inputpage=document.getElementById("inputPage").value;
			
			if(inputpage.length==0){
				document.getElementById("inputPage").value="";
				return;
			}
			else{
				if(!isNaN(inputpage)){
					
					var totalPage=document.getElementById("inputPage").getAttribute("totalPage");
					if(inputpage>totalPage){
						document.getElementById("inputPage").value="";
						document.getElementById("inputPage").focus();
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

<!--执行添加一级类型操作 -->
<script type="text/javascript">
	function addfirstassettypemenu(){
/* 	var Typename=asset.typename.value;
	var	Unit=asset.unit.value;
	var Value=asset.value.value; */
	 var Typename=document.getElementById("typename0").value;
	var Unit = $('#unit0').combobox('getValue');
	var Value=document.getElementById("value0").value;
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
     						 url:'<%=basePath%>adminassettype/addassettypemenu.htm', 
    						 data:{typename:Typename,unit:Unit,value:Value}, //表单数据
 							 success:function(e){
								  var  data = eval("("+e+")");
    							  if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       							alert(data.msg);
       							if(${pager.totalPage}==0){
       						
       						$.ajax({ 
    						 type:"POST", //表单提交类型 
     						 url:'<%=basePath%>adminassettype/getassettypetotalpage.htm', 
    						 data:{fid:0}, //表单数据
 							 success:function(e){
								  var  data = eval("("+e+")");
    							  if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       								var totalpage=data.totalPage;
       								location.href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?dis=1&pagenum=${pagenum}&currentPage="+totalpage;	 
      								}
    							 }
   							 });
       							
       								
       							}else{
       								location.href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?dis=1&pagenum=${pagenum}&currentPage=${pager.totalPage}";
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

<!-- 显示添加一级类型模态框 mymodal1 之前内容的赋值 -->
<script>
	//必不可少
    $(function(){
    	$(".btn-tck1").click(function(){
    		$('#unit0').combobox({editable:false});//将combobox可编辑的属性改为false
        	//$("#mymodal1").modal("toggle");
        	$('#mymodal1').modal('show');
        	$('#mymodal1').on('shown.bs.modal', function () {
			  	$('#typename0').focus();
			});
        	
    	});
    });
</script>

<!-- 添加一级类型模态框 mymodal1  内容复位 -->
<script>
   $(function () { $("#mymodal1").on('hidden.bs.modal', function () {
	$('#unit0').combobox('select',"");//修改回显设置默认选中值
	document.getElementById("typename0").value="";
	document.getElementById("value0").value="";
	Fid=document.getElementById("fidhidden").value="";
	 $("p-typename0").html("");
	 $("p-value0").html("");
	$('#unit0').combobox({}).combobox("initClear");
	});
   });
</script>	

<!-- 添加子类型原先的返回按钮 -->
<script>
		function f(){
			if(${fid}==0){
       			location.href='<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?&currentPage=${pager.currentPage}';
       		}
       		else{
       			location.href='<%=basePath%>adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${fid}&currentPage=${pager.currentPage}';
       		}
		}
</script>

<!--执行添加子类型操作 -->
<script>
function addelseassettypemenu(){
    var Typename=document.getElementById("typename").value;
	var Unit = $('#unit1').combobox('getValue');
	var Value=document.getElementById("value1").value;
	var Fid=document.getElementById("fidhidden").value;
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
     url:'<%=basePath%>adminassettype/addassettypemenu.htm', 
     data:{fid:Fid,typename:Typename,unit:Unit,value:Value}, //表单数据
  success:function(e){
	  var  data = eval("("+e+")");
      if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
       		alert(data.msg);
       		
       			location.href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?dis=1&pagenum=${pagenum}&currentPage=${pager.currentPage}";
      
      		 
      }else{
		alert(data.msg);
		$('#unit1').combobox('select',Unit);//修改回显设置默认选中值
      }
	
     }
    }); 
    	}
				else{
					alert("资产金额输入不合法，请重新输入！");
					$('#unit1').combobox('select',Unit);//修改回显设置默认选中值
				}
	}
			
		}
</script>

<!-- 显示添加子类型模态框 mymodal2 之前内容的赋值 -->
<script>
	//必不可少
    $(function(){

    $('#unit1').combobox({editable:false});//将combobox可编辑的属性改为false
    	$(".btn-tck2").click(function(){
    		var fid=$(this).attr("data-fid");
    		var typename=$(this).attr("data-typename");
    		 $('#fidhidden').val(fid); 
    		  $("p-ftypename").html(typename);  
    		 // $('#unit1').combobox({editable:false});//将combobox可编辑的属性改为false
        	$("#mymodal2").modal('show');  
        	$('#mymodal2').on('shown.bs.modal', function () {
			  	$('#typename').focus();
			});
    	});
    });
</script>

<!-- 添加子类型模态框 mymodal2 的内容复位 -->
<script>
   $(function () { $("#mymodal2").on('hidden.bs.modal', function () {
	document.getElementById("typename").value="";
	document.getElementById("value1").value="";
	Fid=document.getElementById("fidhidden").value="";
	 $("p-typename").html("");
	 $("p-value1").html("");
	  $("p-ftypename").html(""); 
	  $('#unit1').combobox({}).combobox("initClear"); 
	});
   });
</script>

<!--执行修改操作 -->
<script>
function csave(){
	var Typename=document.getElementById("typename2").value;
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
 
       			location.href="<%=basePath%>adminassettype/getassettypefirstmenubyfidwithpage.htm?id=${id}&dis=1&pagenum=${pagenum}&currentPage=${pager.currentPage}";
       		
      		 
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
<!-- 显示修改模态框 mymodal3 之前内容的赋值 -->
<script>
	//必不可少
   $(function(){
   		$('#unit2').combobox({editable:false});//将combobox可编辑的属性改为false
    	$(".btn-tck3").click(function(){
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
        	$("#mymodal3").modal('show'); 
        		$('#mymodal3').on('shown.bs.modal', function () {
        		var t=$("#typename2").val();
   				 $("#typename2").val("").focus().val(t);//使用重新赋值重新聚焦的方法
			});
    	});
    });
</script>

<!-- 修改模态框 mymodal3 的内容复位 -->
<script>
   $(function () { $("#mymodal3").on('hidden.bs.modal', function () {
	 $("p-typename2").html("");
	 $("p-value2").html("");
	 $('#unit2').combobox({}).combobox("initClear");
	});
   });
</script>

<!-- 添加一级类型表单合法性验证 -->
<script>
		//类型名称的验证
        $(function(){
            $("#typename0").bind("input propertychange",function(){
                var Typename=document.getElementById("typename0").value;
               
                if(Typename==""||Typename==null){
                    $("p-typename0").html("类型名称不能为空！");
                }else{
                if(Typename.indexOf(" ")>=0){
                	$("p-typename0").html("输入有空格！");
                }else{
                   $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 url:'<%=basePath%>adminassettype/istypenamelegal.htm', 
    					 data:{typename:Typename}, //表单数据
 					 	success:function(e){
	 							 var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 						$("p-typename0").html("");
      						}else{
								$("p-typename0").html(data.msg);
    							 }
   								            }
   							 }); 
                }	
                }
            });
        });
        //资产金额的验证
         $(function(){
            $("#value0").bind("input propertychange",function(){
                var Value=document.getElementById("value0").value;
                    if(!isNaN(Value)) {
                        if (Value != "") {
                            if(!/^\d{1,11}(?:\.\d{1,2})?$/.test(Value)){
                            	 $("p-value0").html("数字格式不正确！");
                            }
                            else{
                             $("p-value0").html("");
                            }
                        }
                    }
                    else{
                        $("p-value0").html("请输入合法数字！");
                    }
            });
        });
    </script>

<!-- 添加子类型表单合法性验证 -->
<script>
	//类型名称的验证
        $(function(){
            $("#typename").bind("input propertychange",function(){
                var Typename=document.getElementById("typename").value;
                var Fid=document.getElementById("fidhidden").value;
                if(Typename==""||Typename==null){
                    $("p-typename").html("类型名称不能为空！");
                }else{
                 if(Typename.indexOf(" ")>=0){
                	$("p-typename").html("输入有空格！");
                }else{
                   $.ajax({ 
    					 type:"POST", //表单提交类型 
    					 url:'<%=basePath%>adminassettype/istypenamelegal.htm', 
    					 data:{typename:Typename,fid:Fid}, //表单数据
 					 	success:function(e){
	 							 var  data = eval("("+e+")");
      							if(data.status == 'ok'){//msg 是后台调用action时，你穿过来的参数
      		 						$("p-typename").html("");
      						}else{
								$("p-typename").html(data.msg);
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
		<legend>
			<span style="font-size:14px;">
				一级类型列表
			</span>
		</legend>
		<div class="lbgl-top">
		<div class="lbgl-top-left f_1">
			<a  class="btn btn-add btn-tck1" style="width:110px;"><i class="fa fa-plus"></i><span>添加一级类型</span></a>
		</div>
		<div class="modal fade" id="mymodal1">
    		<div class="modal-dialog">
       			<div class="modal-content">
            		<div class="modal-header" style="text-align:center;">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						<h2 class="modal-title">添加一级类型</h2>
					</div>
					<div class="modal-body">
					<!-- <p>模态弹出窗主体内容</p> --><!-- 直接把那个表单的代码放到这里就行 -->
						<div class="container-f">
	  					<div class="box-title clearfix tab-title"  class="input-xlarge">
	   						<form id="asset" action="${basePath}adminassettype/getassettypefirstmenubyfidwithpage.htm?currentPage=${pager.totalPage} " method="post" class="form" >
								<div class="control-group cf clearfix " >
									<label class="form-lb form" for="web_bg">
						   			 类型名称：
									</label>
									<input type="text" name="typename" id="typename0"   class="input"style="padding: 5px 2px; " value=""><p-typename0 style="font-size:12px;"></p-typename0>		
								</div>
								<div class="control-group cf clearfix " >
									<label class="form-lb form" for="web_bg">
					   				 计量单位：
									</label>
				    				<span style="overflow:hidden;">
				    					 <select class="easyui-combobox" name="unit" id="unit0"  style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
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
								<div class="control-group cf clearfix " >
									<label class="form-lb form" for="web_bg">
					   				 资产金额：
									</label>
									<input type="text" name="value" id="value0"  class="input" style="padding: 5px 2px; " placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''"  onBlur="javascript:placeholder='小数点后最多保留两位'" value=""> <p-value0 style="font-size:12px;"></p-value0>
								</div>
								<!-- <div class="form-actions" >
								<a href="javascript:void(0)" onclick="addassettypemenu()" class="btn btn-primary" ><i class="fa fa-plus"></i>添加</a>
								</div> -->
  							</form>
  						</div>
  						</div>  
  					</div>
					<div class="modal-footer">
					<!-- <button type="button" class="btn btn-primary btn-tck" data-dismiss="modal">关闭</button> -->
<%-- 				<a href='${basePath}adminassettype/getassettypefirstmenubyfidwithpage.htm?id=0&currentPage=${pager.currentPage}' class="btn btn-primary btn-tck2" data-dismiss="modal" style="height:30px;">返回</a>
 --%>				<!-- 这里只有data-dismiss是跟之前的返回不一样 -->
					<button type="button" class="btn btn-primary btn-tck" onclick="addfirstassettypemenu()"><i class="fa fa-plus"></i>添加</button>
					</div>
				</div>
			</div>
		</div>
	<div class="lbgl-top-right">
		<form id="asset5" action="${basePath}adminassettype/selectassettypefirstmenu.htm?dis=2&pagenum=${pagenum}">
			<input type="text" name="assetTypeName" class="lbgl-search" placeholder="类别名称" style="width: 220px; height: 30px;"
				onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='类别名称'">
			<!-- <input type="submit" class="btn btn-primary" value="查询"> -->
			<button class="btn" style="width:90px;height:30px;"><i class="fa fa-search"></i>查询</button>
		</form>
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
					<a href="${basePath}adminassettype/getassettypeelsemenubyfidwithpage.htm?id=${assetType.id}&dis=2&pagenum=${pagenum}" class="btn" ><i class="fa fa-search"></i>查看</a>
				</td>
				<td class="tab-td">
				<a data-fid="${assetType.id}" data-typename="${assetType.typename}"  class="btn btn-addchild btn-tck2" ><i class="fa fa-plus"></i>添加</a>		
					<div class="modal fade" id="mymodal2">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
									<h2 class="modal-title">&nbsp&nbsp&nbsp&nbsp添加&nbsp<p-ftypename></p-ftypename>&nbsp的子类型
									<label class="name"></label>
									</h2>
								</div>
				<div class="modal-body">
					<div class="container-f"style="padding-left:0px;">
 				 	<div class="hr"></div>
  						<div class="box-title clearfix tab-title"  class="input-xlarge">
   						<form id="asset1" action=" " method="post" class="form">
							<div class="control-group cf clearfix" style="text-align:left;padding-left:14px">
									<label class="form-lb form" for="web_bg"> 类型名称：</label>
									<input type="text" name="typename" id="typename"   class="input form-text"style="padding: 5px 2px;" value=""><p-typename style="font-size:12px;"></p-typename>	
									<input type="hidden" name="fidhidden" id="fidhidden"  value="">	
									
							</div>
							<div class="form-row ">
									<label class="form-lb form" style="margin-left:-10px;" for="web_bg"> 计量单位：</label>
									<span style="overflow:hidden;">
									 <select class="easyui-combobox" name="unit" id="unit1"  style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
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
				                     </span><!-- <input name="unit" style="width:135px;position:absolute;left:140px; top:40px;"> -->
							</div>
							<div class="form-row"style="text-align:left;padding-left:135px">
									<label class="form-lb form" for="web_bg">资产金额：</label>
									<input type="text" name="value" id="value1"  class="input form-text" value=""style="padding: 5px 2px; " placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='小数点后最多保留两位'"><p-value1 style="font-size:12px;"></p-value1>
							</div>
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
				<a  data-id="${assetType.id}" data-fid="${assetType.fid}" data-typename="${assetType.typename}" data-unit="${assetType.unit}"  data-value="${assetType.value}"    class="btn btn-edit btn-tck3" ><i class="fa fa-edit"></i>修改</a>
				<div class="modal fade" id="mymodal3">
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
							<label for="" class="form-lb form" style="margin-left:-6px;">计量单位：</label>
							<%-- <input type="text" class="form-text" name="unit" value="${assetType.unit}"> --%>
							 <span style="overflow:hidden;">  
							 <!-- 可以弄成动态生成select -->
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
										</select> </span>
						</div>
						<div class="form-row"style="text-align:left;padding-left:145px;">
							<label for="" class="form-lb form">资产金额：</label>
							<input type="text" class="form-text" name="value2" id="value2" placeholder="小数点后最多保留两位" onfocus="javascript:placeholder=''" onBlur="javascript:placeholder='小数点后最多保留两位'" value=""><p-value2 style="font-size:12px;"></p-value2>
						</div>
						</form>	
					</div>
				</div>
					<div class="modal-footer">
						<button class="btn btn-primary <!-- btn-tck3 这里千万不要带btn-tck3否则会重新加载模态框-->" onclick="csave()"><i class="fa fa-edit btn-tck3"></i>修改</button>

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
		<cc:page url="${basePath}adminassettype/getassettypefirstmenubyfidwithpage.htm?dis=1&pagenum=${pagenum}" value="${pager}" />
	</div>
	</fieldset>
</div>
<div class="font">

</div>

	<!-- <script type="text/javascript">
	
	window.onload()=function(){
		
		alert("OK");
		for(var i=0;i<$(".btn-edit").length;i++){
			$(".btn-edit").removeClass("btn-tck3");
		}
		
		alert("OK2");
	}
		
		
			
			
	
	</script> -->

	<shiro:hasPermission name="checkauth">
		<script type="text/javascript">
		/* window.onload=function(){
			document.getElementById("myCheck").setAttribute("onclick","alert('权限不足，无法进行此操作')");
		}	 */
		
		//将修改按钮改为无权限
		for(var i=0;i<$(".btn-edit").length;i++){
			$(".btn-edit").removeClass("btn-tck3");
		}
		$(".btn-edit").click(function(){alert("权限不足，无法进行此操作")});
		
		//将添加一级类型改为无权限
		for (var j = 0; j < $(".btn-add").length; j++) {
			$(".btn-add").removeClass("btn-tck1");
		}
		$(".btn-add").click(function(){alert("权限不足，无法进行此操作")});
		
		//添加子类型权限设置
		for (var i = 0; i < $(".btn-addchild").length; i++) {
			$(".btn-addchild").removeClass("btn-tck2");
		}
		$(".btn-addchild").click(function(){alert("权限不足，无法进行此操作")});
		
		//删除按钮
		for (var i = 0; i < $(".btn-delete").length; i++) {
			//$(".btn-delete").click(function(){alert("权限不足，无法进行此操作")});
			$(".btn-delete").attr("onclick","alert('权限不足，无法进行此操作')");
		}
		
		
		</script>	
	
	</shiro:hasPermission>
		
	<script type="text/javascript" src="<%=basePath %>Public/Js/table.js"></script>
</body>
</html>
