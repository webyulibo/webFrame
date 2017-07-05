<i><%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
<head>

<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>Public/Css/lbglqll.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>Public/Css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>Public/Css/data.css">
<title>添加一级类型</title>

</head>

<body>
	<div class="container-f">
		<div class="hr"></div>
		<div class="box-title clearfix tab-title" class="input-xlarge">

			<div class="returnbtn">


				<a href=" jsp/dataadmin/leibieadmin/main/yjlxlbqjx.jsp"
					class="btn btn-primary">返回</a>

			</div>
			<form action=" " method="post" class="form">
				<div class="control-group cf clearfix ">
					<label class="control-label" for="web_bg"> 类型名称： </label> <input
						type="text" name="typename" id=" " class="input"
						style="padding: 5px 2px; " value="">


				</div>
				<div class="control-group cf clearfix ">
					 <label class="control-label" for="web_bg"> 计量单位： </label> 
					 <span style="overflow:hidden;">  
					  
					  <select id=""  style="width: 150px;padding: 5px 2px;cursor: pointer;" onchange="this.parentNode.nextSibling.value=this.value">
  						<option value="平方米">平方米</option>
  						<option value="台">台</option>
  						<option value="套">套</option>
  						<option value="辆">辆</option>
  						<option value="部">部</option>
  						<option value="件">件</option>
  						<option value="个">个</option>
					  </select> 
                     </span><input name="unit" style="width:135px;position:absolute;left:140px; top:40px;">
                      
					</div>
					
					<div class="control-group cf clearfix ">
						<label class="control-label" for="web_bg"> 资产金额： </label> <input
							type="text" name=" " id="sum" class="input"
							style="padding: 5px 2px; " placeholder="小数点后最多保留两位"
							onfocus="javascript:placeholder=''"
							onBlur="javascript:placeholder='小数点后最多保留两位'" value="">

					</div>
					<div class="form-actions">

						<a href="javascript:void(0)" class="btn btn-primary"><i
							class="fa fa-plus"></i>添加</a>

					</div>
					</form><!-- 后加的 -->
				</div>
			<!-- </form> -->
		</div>
	<!-- </div> -->
</body>
	</html> </i>