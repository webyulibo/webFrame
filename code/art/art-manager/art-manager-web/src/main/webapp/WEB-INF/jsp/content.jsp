<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'/content/category/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid" id="contentList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/content/query/list',queryParams:{categoryId:0}">
		    <thead>
		        <tr>
		            <th data-options="field:'id',width:30">ID</th>
		            <th data-options="field:'title',width:120">内容标题</th>
		            <th data-options="field:'subTitle',width:100">内容子标题</th>
		            <th data-options="field:'titleDesc',width:120">内容描述</th>
		            <!-- <th data-options="field:'url',width:60,align:'center',formatter:TAOTAO.formatUrl">内容连接</th> -->
		            <th data-options="field:'pic',width:50,align:'center',formatter:TAOTAO.formatUrl">图片</th>
		            <th data-options="field:'pic2',width:50,align:'center',formatter:TAOTAO.formatUrl">图片2</th>
		            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
		            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
		        </tr>
		    </thead>
		</table>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	var tree = $("#contentCategoryTree");
	var datagrid = $("#contentList");
	tree.tree({
		onClick : function(node){
			if(tree.tree("isLeaf",node.target)){
				datagrid.datagrid('reload', {
					categoryId :node.id
		        });
			}
			
			var categoryId=node.id;
			var hiddentype;
			if(categoryId=="61"){//logo及地址的id对应hiddentype
				var option1=datagrid.datagrid('getColumnOption', 'title');
				var option2=datagrid.datagrid('getColumnOption', 'subTitle');
				var option3=datagrid.datagrid('getColumnOption', 'titleDesc');
				option1.title = "电话";
				option2.title = "传真";
				option3.title = "地址";
				datagrid.datagrid();//更新标题文本为电话传真地址
				datagrid.datagrid('hideColumn', 'url');//隐藏对应的列
				datagrid.datagrid('hideColumn', 'pic2');
				datagrid.datagrid('showColumn', 'pic');
				datagrid.datagrid('showColumn', 'title');//显示对应的列
				datagrid.datagrid('showColumn', 'subTitle');
				datagrid.datagrid('showColumn', 'titleDesc');

			}else if(categoryId=="62"||categoryId=="65"||categoryId=="68"){//相关链接、院长信箱、推荐站点
				var option1=datagrid.datagrid('getColumnOption', 'title');
				var option2=datagrid.datagrid('getColumnOption', 'url');
				option1.title = "链接名称";
				option2.title = "链接地址";
				datagrid.datagrid();//更新标题文本为电话传真地址
				datagrid.datagrid('hideColumn', 'subTitle');//隐藏对应的列
				datagrid.datagrid('hideColumn', 'titleDesc');
				datagrid.datagrid('hideColumn', 'pic');
				datagrid.datagrid('hideColumn', 'pic2');
				datagrid.datagrid('showColumn', 'title');//显示对应的列
				datagrid.datagrid('showColumn', 'url');
				
			}else if(categoryId=="63"){//关注我们
				datagrid.datagrid('hideColumn', 'subTitle');//隐藏对应的列
				datagrid.datagrid('hideColumn', 'titleDesc');
				datagrid.datagrid('hideColumn', 'title');
				datagrid.datagrid('hideColumn', 'url');
				datagrid.datagrid('showColumn', 'pic');//显示对应的列
				datagrid.datagrid('showColumn', 'pic2');
			
			}else if(categoryId=="69"){ //页眉logo
				datagrid.datagrid('hideColumn', 'subTitle');//隐藏对应的列
				datagrid.datagrid('hideColumn', 'titleDesc');
				datagrid.datagrid('hideColumn', 'title');
				datagrid.datagrid('hideColumn', 'url');
				datagrid.datagrid('showColumn', 'pic2');
				datagrid.datagrid('showColumn', 'pic');//显示对应的列
			
			}else if(categoryId=="64"){//大广告
				var option1=datagrid.datagrid('getColumnOption', 'title');
				option1.title = "内容标题";
				datagrid.datagrid();//更新标题文本为电话传真地址
				datagrid.datagrid('hideColumn', 'subTitle');//隐藏对应的列
				datagrid.datagrid('hideColumn', 'titleDesc');
				datagrid.datagrid('hideColumn', 'url');
				datagrid.datagrid('hideColumn', 'pic2');
				datagrid.datagrid('showColumn', 'pic');//显示对应的列
				datagrid.datagrid('showColumn', 'title');
			
			}else {//在线展示
				var option1=datagrid.datagrid('getColumnOption', 'title');
				var option2=datagrid.datagrid('getColumnOption', 'subTitle');
				var option3=datagrid.datagrid('getColumnOption', 'titleDesc');
				option1.title = "内容标题";
				option2.title = "内容子标题";
				option3.title = "内容描述";
				datagrid.datagrid();//更新标题文本为电话传真地址
				datagrid.datagrid('hideColumn', 'subTitle');//隐藏对应的列
				datagrid.datagrid('hideColumn', 'titleDesc');
				datagrid.datagrid('showColumn', 'url');//显示对应的列
				datagrid.datagrid('showColumn', 'pic2');
				datagrid.datagrid('showColumn', 'pic');
				datagrid.datagrid('showColumn', 'title');
			}
			
			
		}
	});
});
var contentListToolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	var node = $("#contentCategoryTree").tree("getSelected");
    	if(!node || !$("#contentCategoryTree").tree("isLeaf",node.target)){
    		$.messager.alert('提示','新增内容必须选择一个内容分类!');
    		return ;
    	}
    	TT.createWindow({
			url : "/content-add",
	onLoad : function(){
		var categoryId= document.getElementById("categoryId").value;
		var hiddentype;
		if(categoryId=="61"){//logo及地址的id对应hiddentype
			
			hiddentype=0;//电话传真地址
			
		}else if(categoryId=="62"||categoryId=="65"||categoryId=="68"){//相关链接、院长信箱、推荐站点
			
			hiddentype=1;//只是 链接名称以及地址
			
		}else if(categoryId=="63"){//关注我们
			
			hiddentype=2;//单单两个图片
		
		}else if(categoryId=="69"){ //页眉logo
			
			hiddentype=2;//只显示一个图片
		
		}else if(categoryId=="64"){//大广告
			
			hiddentype=4;//显示一个标题和显示一个图片
		
		}else {//在线展示
			
			hiddentype=5;//显示标题、url、以及内容
		}
		if(hiddentype=="0"){//对应的左下角logo以及地址
			$("#J_title1").html("电话");
			$("#J_subTitle1").html("传真");
			$("#J_titleDesc1").html("地址");
			 document.getElementById("J_url1").style.display="none";
			 document.getElementById("J_url2").style.display="none";
			 document.getElementById("J_pic1").style.display="none";
			 document.getElementById("J_pic2").style.display="none";
			 document.getElementById("J_content1").style.display="none";
			 document.getElementById("J_content2").style.display="none";
			 document.getElementById("J_specialy").style.display="none";
			 document.getElementById("J_titleDesc1y").style.display="none";
		}else if(hiddentype=="1"){//相关链接  只是 链接名称以及地址
			$("#J_title1").html("链接名称");
			$("#J_url1").html("链接地址");
			 document.getElementById("J_titleDesc1").style.display="none";
			 document.getElementById("J_titleDesc2").style.display="none";
			 document.getElementById("J_subTitle1").style.display="none";
			 document.getElementById("J_subTitle2").style.display="none";
			 document.getElementById("J_pic").style.display="none";
			 document.getElementById("photo").style.display="none";
			 document.getElementById("J_pic1").style.display="none";
			 document.getElementById("J_pic2").style.display="none";
			 document.getElementById("J_content1").style.display="none";
			 document.getElementById("J_content2").style.display="none";
			 document.getElementById("J_specialy").style.display="none";
			 document.getElementById("J_titleDesc1y").style.display="none";
		}else if(hiddentype=="2"){//单单两个图片
			document.getElementById("J_title1").style.display="none";
			 document.getElementById("J_title2").style.display="none";
			 document.getElementById("J_titleDesc1").style.display="none";
			 document.getElementById("J_titleDesc2").style.display="none";
			 document.getElementById("J_subTitle1").style.display="none";
			 document.getElementById("J_subTitle2").style.display="none";
			 document.getElementById("J_url1").style.display="none";
			 document.getElementById("J_url2").style.display="none";
			 document.getElementById("J_content1").style.display="none";
			 document.getElementById("J_content2").style.display="none";
			 document.getElementById("J_specialy").style.display="none";
			 document.getElementById("J_titleDesc1y").style.display="none";
		}else if(hiddentype=="3"){// 只显示一个图片
			document.getElementById("J_title1").style.display="none";
			 document.getElementById("J_title2").style.display="none";
			 document.getElementById("J_titleDesc1").style.display="none";
			 document.getElementById("J_titleDesc2").style.display="none";
			 document.getElementById("J_subTitle1").style.display="none";
			 document.getElementById("J_subTitle2").style.display="none";
			 document.getElementById("J_url1").style.display="none";
			 document.getElementById("J_url2").style.display="none";
			 document.getElementById("J_pic1").style.display="none";
			 document.getElementById("J_pic2").style.display="none";
			 document.getElementById("J_content1").style.display="none";
			 document.getElementById("J_content2").style.display="none";
			 document.getElementById("J_specialy").style.display="none";
			 document.getElementById("J_titleDesc1y").style.display="none";
		}else if(hiddentype=="4"){//显示一个标题和显示一个图片
			 document.getElementById("J_titleDesc1").style.display="none";
			 document.getElementById("J_titleDesc2").style.display="none";
			 document.getElementById("J_subTitle1").style.display="none";
			 document.getElementById("J_subTitle2").style.display="none";
			 document.getElementById("J_url1").style.display="none";
			 document.getElementById("J_url2").style.display="none";
			 document.getElementById("J_pic1").style.display="none";
			 document.getElementById("J_pic2").style.display="none";
			 document.getElementById("J_content1").style.display="none";
			 document.getElementById("J_content2").style.display="none";
			 document.getElementById("J_specialy").style.display="none";
			 document.getElementById("J_titleDesc1y").style.display="none";
		}else if(hiddentype=="5"){//公告、新闻等
			 document.getElementById("J_titleDesc1").style.display="none";
			 document.getElementById("J_titleDesc2").style.display="none";
			 document.getElementById("J_subTitle1").style.display="none";
			 document.getElementById("J_subTitle2").style.display="none";
/* 					 document.getElementById("J_url1").style.display="none";
			 document.getElementById("J_url2").style.display="none"; */
			 document.getElementById("J_pic").style.display="none";
			 document.getElementById("photo").style.display="none";
			 document.getElementById("J_pic1").style.display="none";
			 document.getElementById("J_pic2").style.display="none";
			 document.getElementById("J_url1").style.display="none";
			 document.getElementById("J_url2").style.display="none";
		}
	}
		}); 
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','必须选择一个内容才能编辑!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('提示','只能选择一个内容!');
    		return ;
    	}
		TT.createWindow({
			url : "/content-edit",
			onLoad : function(){
				var data = $("#contentList").datagrid("getSelections")[0];
				$("#contentEditForm").form("load",data);
				
				// 实现图片
				if(data.pic){
					$("#contentEditForm [name=pic]").after("<a href='"+data.pic+"' target='_blank'><img src='"+data.pic+"' width='80' height='50'/></a>");	
				}
				if(data.pic2){
					$("#contentEditForm [name=pic2]").after("<a href='"+data.pic2+"' target='_blank'><img src='"+data.pic2+"' width='80' height='50'/></a>");					
				}
				var categoryId= document.getElementById("categoryId").value;
				var hiddentype;
				if(categoryId=="61"){//logo及地址的id对应hiddentype
					
					hiddentype=0;//电话传真地址
					
				}else if(categoryId=="62"||categoryId=="65"||categoryId=="68"){//相关链接、院长信箱、推荐站点
					
					hiddentype=1;//只是 链接名称以及地址
					
				}else if(categoryId=="63"){//关注我们
					
					hiddentype=2;//单单两个图片
				
				}else if(categoryId=="69"){ //页眉logo
					
					hiddentype=2;
				
				}else if(categoryId=="64"){//大广告
					
					hiddentype=4;//显示一个标题和显示一个图片
				
				}else {//在线展示
					
					hiddentype=5;//显示标题、url、以及内容
				}
				if(hiddentype=="0"){//对应的左下角logo以及地址
					$("#J_title1").html("电话");
					$("#J_subTitle1").html("传真");
					$("#J_titleDesc1").html("地址");
					 document.getElementById("J_url1").style.display="none";
					 document.getElementById("J_url2").style.display="none";
					 document.getElementById("J_pic1").style.display="none";
					 document.getElementById("J_pic2").style.display="none";
					 document.getElementById("J_content1").style.display="none";
					 document.getElementById("J_content2").style.display="none";
					 document.getElementById("J_specialy").style.display="none";
					 document.getElementById("J_titleDesc1y").style.display="none";
					 
				}else if(hiddentype=="1"){//相关链接  只是 链接名称以及地址
					$("#J_title1").html("链接名称");
					$("#J_url1").html("链接地址");
					 document.getElementById("J_titleDesc1").style.display="none";
					 document.getElementById("J_titleDesc2").style.display="none";
					 document.getElementById("J_subTitle1").style.display="none";
					 document.getElementById("J_subTitle2").style.display="none";
					 document.getElementById("J_pic").style.display="none";
					 document.getElementById("photo").style.display="none";
					 document.getElementById("J_pic1").style.display="none";
					 document.getElementById("J_pic2").style.display="none";
					 document.getElementById("J_content1").style.display="none";
					 document.getElementById("J_content2").style.display="none";
					 document.getElementById("J_specialy").style.display="none";
					 document.getElementById("J_titleDesc1y").style.display="none";
				}else if(hiddentype=="2"){//单单两个图片
					document.getElementById("J_title1").style.display="none";
					 document.getElementById("J_title2").style.display="none";
					 document.getElementById("J_titleDesc1").style.display="none";
					 document.getElementById("J_titleDesc2").style.display="none";
					 document.getElementById("J_subTitle1").style.display="none";
					 document.getElementById("J_subTitle2").style.display="none";
					 document.getElementById("J_url1").style.display="none";
					 document.getElementById("J_url2").style.display="none";
					 document.getElementById("J_content1").style.display="none";
					 document.getElementById("J_content2").style.display="none";
					 document.getElementById("J_specialy").style.display="none";
					 document.getElementById("J_titleDesc1y").style.display="none";
				}else if(hiddentype=="3"){// 只显示一个图片
					document.getElementById("J_title1").style.display="none";
					 document.getElementById("J_title2").style.display="none";
					 document.getElementById("J_titleDesc1").style.display="none";
					 document.getElementById("J_titleDesc2").style.display="none";
					 document.getElementById("J_subTitle1").style.display="none";
					 document.getElementById("J_subTitle2").style.display="none";
					 document.getElementById("J_url1").style.display="none";
					 document.getElementById("J_url2").style.display="none";
					 document.getElementById("J_pic1").style.display="none";
					 document.getElementById("J_pic2").style.display="none";
					 document.getElementById("J_content1").style.display="none";
					 document.getElementById("J_content2").style.display="none";
					 document.getElementById("J_specialy").style.display="none";
					 document.getElementById("J_titleDesc1y").style.display="none";
				}else if(hiddentype=="4"){//显示一个标题和显示一个图片
					 document.getElementById("J_titleDesc1").style.display="none";
					 document.getElementById("J_titleDesc2").style.display="none";
					 document.getElementById("J_subTitle1").style.display="none";
					 document.getElementById("J_subTitle2").style.display="none";
					 document.getElementById("J_url1").style.display="none";
					 document.getElementById("J_url2").style.display="none";
					 document.getElementById("J_pic1").style.display="none";
					 document.getElementById("J_pic2").style.display="none";
					 document.getElementById("J_content1").style.display="none";
					 document.getElementById("J_content2").style.display="none";
					 document.getElementById("J_specialy").style.display="none";
					 document.getElementById("J_titleDesc1y").style.display="none";
				}else if(hiddentype=="5"){//公告、新闻等
					 document.getElementById("J_titleDesc1").style.display="none";
					 document.getElementById("J_titleDesc2").style.display="none";
					 document.getElementById("J_subTitle1").style.display="none";
					 document.getElementById("J_subTitle2").style.display="none";
		/* 					 document.getElementById("J_url1").style.display="none";
					 document.getElementById("J_url2").style.display="none"; */
					 document.getElementById("J_pic").style.display="none";
					 document.getElementById("photo").style.display="none";
					 document.getElementById("J_pic1").style.display="none";
					 document.getElementById("J_pic2").style.display="none";
				}
				contentEditEditor.html(data.content);
			}
		});    	
    }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中内容!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的内容吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/content/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#contentList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
}];
</script>