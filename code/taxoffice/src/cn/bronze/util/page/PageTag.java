package cn.bronze.util.page;

import cn.bronze.util.page.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag  extends TagSupport{

	
	public static void main(String[] args) {

	}

	private PageParameter value;
	private String url;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		  if(value == null) {
			  return super.doStartTag();
          }
		  try {
				/*out.println("<div class='pages clearfix'>");
				out.println("总条数：<span class='radius3'>"+value.getTotalCount()+"&nbsp;&nbsp;&nbsp;&nbsp;</span>");
				if(value.getTotalPage()>1){
					out.println("<div class='blank20'></div>"
							+"<div class='pagination'>");
					boolean bool = url.indexOf("?")>0;//判断后面字符串用？还是&
					String sepe =""; 
					if(bool){
						sepe = "&";
					}else {
						sepe = "?";
					}
					if (value.getCurrentPage()>1) {
							out.println("<a href="+url+sepe+"currentPage="+(value.getCurrentPage()-1)+ " class='radius3 page_prev' >上一页</a>");
					}
					
					
						if (value.getCurrentPage()>=7) {
							
							out.println("<a class='radius3' href="+url+sepe+"currentPage=1"+" >1</a>");
						
							out.println("<i>...</i>");
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()-4) +">"+(value.getCurrentPage()-4)+"</a>");
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()-3) +">"+(value.getCurrentPage()-3)+"</a>");
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()-2) +">"+(value.getCurrentPage()-2)+"</a>");
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()-1) +">"+(value.getCurrentPage()-1)+"</a>");
							
					}else{
						for (int i = 1; i <= value.getCurrentPage()-1; i++) {
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(i) +">"+(i)+"</a>");
						}
					}
						
						out.println("<span class='radius3'>"+value.getCurrentPage()+"</span>");
						
						

						if (value.getTotalPage()-value.getCurrentPage()>=6) {
							
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()+1) +">"+(value.getCurrentPage()+1)+"</a>");
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()+2) +">"+(value.getCurrentPage()+2)+"</a>");
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()+3) +">"+(value.getCurrentPage()+3)+"</a>");
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()+4) +">"+(value.getCurrentPage()+4)+"</a>");
							
							out.println("<i>...</i>");
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+value.getTotalPage()+" >"+value.getTotalPage()+"</a>");
					}else{
						for (int i = value.getCurrentPage()+1; i <= value.getTotalPage(); i++) {
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(i) +">"+(i)+"</a>");
							
						}
					}
						if(value.getCurrentPage()-value.getTotalPage()<0){
							out.println("<a class='radius3' href="+url+sepe+"currentPage="+(value.getCurrentPage()+1)+" class='radius3 page_prev' >下一页</a>");
						}
						
				}
				out.println("</div>");
				*/
			  
			  //算出第几条数据
			  //开始 的条数
			  int startInfo=value.getCurrentPage()*value.getPageSize()-(value.getPageSize()-1);
			  int endInfo=value.getCurrentPage()*value.getPageSize();
			  
			  if(value.getTotalCount()==0){
				  startInfo=0;
				  endInfo=value.getTotalCount();
			  }
			  else{
				  endInfo=endInfo>value.getTotalCount()?value.getTotalCount():endInfo;
			  }
			  
			 
			  //获得总页数
			  int totalPage=value.getTotalPage();
			  
			  
			  out.println("<div class='pagination ue-clear' style='margin-top:0px;margin-bottom:50px;'>");
				out.println("<div class='pxofy'>显示第&nbsp;"+startInfo+"&nbsp;条到&nbsp;"+endInfo+"&nbsp;条记录，总共&nbsp;"+value.getTotalCount()+"&nbsp;条</div>");
				out.println("<div class='goto'><span class='text'>转到第</span><input id='inputPage' url='"+url+"' totalPage='"+totalPage+"' type='text'/><span class='page'>页</span><a href='javascript:void(0)' onclick='getInfoByPage()'>转</a></div>");
				if(value.getTotalPage()>1){
					out.println("<div class='pagin-list'>");
					boolean bool = url.indexOf("?")>0;//判断后面字符串用？还是&
					String sepe =""; 
					if(bool){
						sepe = "&";
					}else {
						sepe = "?";
					}
					if (value.getCurrentPage()>1) {
							out.println("<a href="+url+sepe+"currentPage="+(value.getCurrentPage()-1)+ " class='prev' style='text-decoration:none;'>&lt;&nbsp;上一页</a>");
					}
					else{
						out.println("<span class='prev'>&lt;&nbsp;上一页</span>");
					}
					
					
						if (value.getCurrentPage()>=7) {
							
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage=1"+" >1</a>");
						
							out.println("<i>...</i>");
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()-4) +">"+(value.getCurrentPage()-4)+"</a>");
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()-3) +">"+(value.getCurrentPage()-3)+"</a>");
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()-2) +">"+(value.getCurrentPage()-2)+"</a>");
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()-1) +">"+(value.getCurrentPage()-1)+"</a>");
							
					}else{
						for (int i = 1; i <= value.getCurrentPage()-1; i++) {
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(i) +">"+(i)+"</a>");
						}
					}
						
						out.println("<span class='current'>"+value.getCurrentPage()+"</span>");
						
						

						if (value.getTotalPage()-value.getCurrentPage()>=6) {
							
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()+1) +">"+(value.getCurrentPage()+1)+"</a>");
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()+2) +">"+(value.getCurrentPage()+2)+"</a>");
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()+3) +">"+(value.getCurrentPage()+3)+"</a>");
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()+4) +">"+(value.getCurrentPage()+4)+"</a>");
							
							out.println("<span>...</span>");
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+value.getTotalPage()+" >"+value.getTotalPage()+"</a>");
					}else{
						for (int i = value.getCurrentPage()+1; i <= value.getTotalPage(); i++) {
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(i) +">"+(i)+"</a>");
							
						}
					}
						if(value.getCurrentPage()-value.getTotalPage()<0){
							out.println("<a style='text-decoration:none;' href="+url+sepe+"currentPage="+(value.getCurrentPage()+1)+" class='next' >下一页&nbsp;&gt;</a>");
						}
						else{
							out.println("<span class='prev'>下一页&nbsp;&gt;</span>");
						}
				}
				out.println("</div></div>");
			  
			} catch (Exception e) {
				// 
				e.printStackTrace();
			}
		  super.doStartTag();
            return SKIP_BODY;
	}

	@Override
	public void release() {
		        super.release();
		        this.value = null;
	}

	public PageParameter getValue() {
		return value;
	}

	public void setValue(PageParameter value) {
		this.value = value;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}




}
