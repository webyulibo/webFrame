<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>	
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/data.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/themes/material/easyui.css" />
    <link rel="stylesheet" type="text/css"
	href="<%=basePath%>Public/Css/font-awesome/css/font-awesome.css" />
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.easyui.min.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.js"></script>
	 <script type="text/javascript" src="<%=basePath%>Public/Js/jquery.min.js"></script>
	<style type="text/css">
	.table tr td{
			width:120px;
			height:50px;
			font-size:12px;
		}
   .table td {
	height: 50px;
	vertical-align: top;
	padding-top: 20px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 15px;
	min-width:100px;
	padding-right:20px;
}
 
  .la {
    font-size: 15px;
    font-weight: bold;
}
.hr{
 		 border-bottom:1px solid #ddd; padding: 5px 3px 15px; min-height:30px
  		}
#save{
position:absolute;
top:400px;
left:790px;
}
	</style>
  </head>
  <body>
  <div class="container-f">
		<div class="hr"></div>
		<br />
			<div class="returnbtn">
				<a href="jsp/systemadmin/yhgllmt/getusersby.jsp"class="btn btn-primary">返回</a>

			</div>
           <div class="form">
			<form id="subForm" method="post" action=" ">
					<table class="table">
						<tbody  style="position:relative;left:90px;top:20px;">
							<tr>
								<td>
								<label class="la">性别：</label>
								</td>
								<td>
					   			    <label class="la">男性：</label>
					   	     		<input type="radio" checked="checked" name="Sex" value="male" />
								     <label class="la">女性：</label>
								<input type="radio" name="Sex" value="female" />
						
								</td>
								<td></td>
							<td><label class="la">所属部门:</label></td>
							<td>
							 <select class="easyui-combobox"name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="局领导">局领导</option>
										<option value="办公室">办公室</option>
										<option value="纳税服务科">纳税服务科</option>
										<option value="监察室">监察室 </option>
										<option value="进出口税收管理科 ">进出口税收管理科 </option>
										<option value="信息中心"> 信息中心</option>
										<option value="财务管理科">财务管理科 </option>
										<option value="票证中心">票证中心 </option>
										<option value="货物和劳务税科">货物和劳务税科 </option>
										<option value="收入核算科">收入核算科 </option>
										<option value="所得税科">所得税科 </option>
										<option value="机关生活服务中心"> 机关生活服务中心</option>
										<option value="系统工会 "> 系统工会 </option>
										<option value="车购税管理分局办  "> 车购税管理分局办 </option>
										<option value="机关党委办公室">机关党委办公室 </option>
										<option value="政策法规科">政策法规科 </option>
										<option value="征收管理科">征收管理科 </option>
										<option value="稽查局 ">稽查局 </option>
										<option value="老干部科 ">老干部科 </option>
										<option value="人事教育科">人事教育科</option>
										<option value="大企业一科  ">大企业一科 </option>
										<option value="大企业二科 ">大企业二科 </option>
										<option value="北戴河新区 ">北戴河新区 </option>
										<option value="进出口分局 ">进出口分局 </option>
										<option value="涉外分局 ">涉外分局 </option>
										
									</select>
                               </td>
							</tr>
							<tr>
								<td>
								<label class="la"> 用户名： </label> 
								</td>
								<td>
									<input type="text" name="name" id="name" class="input" value="">
						
								</td>
								<td></td>
					            <td><label class="la">职务：</label></td>
							<td>
							
									<span style="overflow:hidden;">
				    					 <select class="easyui-combobox" name="unit" id="unit0"  style="width:150px;height:30px;border:solid 1px gray;padding-left:7px;">
												<option value="部门经理 ">部门经理 </option>
												<option value="公司职员"> 公司职员</option>
										</select> 
					                     </span>
									</td>
							</tr>
							<tr>
							<td>
							<label class="la">密码：</label>
							</td>
							
							<td><input type="text" name="pwd" id="pwd" class="input"value=""></td>
								
								<td></td>
								<td><label class="la">人员类别：</label></td>
								<td>
									<select class="easyui-combobox"name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="在职人员">在职人员</option>
										<option value="离休人员">离休人员</option>
										<option value="退休人员">退休人员</option>
										
									</select>
 
							</td>
							</tr>
							<tr>
							<td>
								<label class="la">人员姓名：</label> 
								</td>
								<td>
									<input type="text" name="name" id="name" class="input"value="">
								</td>
							
							<td></td>
								<td><label class="la">状态：</label></td>
								<td>
									<select  class="easyui-combobox"name="state" style="width:150px;height:30px;border:soild 1px gray;padding-left:7px">
										<option value="启用">启用</option>
										<option value="关闭"> 关闭</option>
									</select>
							</td>
							</tr>
							<tr>
							<td>
							<label class="la">人员代码：</label>
							</td>
							
							<td><input type="text" name="num" id="num" class="input"value=""></td>							</tr>
			     </tbody>
		    </table>
		    </div>
	   <div class="form-actions" id="baocun">

						<a href="javascript:void(0)" class="btn btn-primary" id="save">保存</a>

					</div>	
	    </form>
	   
     </div>
   </body>
</html>