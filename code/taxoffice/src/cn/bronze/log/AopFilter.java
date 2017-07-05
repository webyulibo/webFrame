package cn.bronze.log;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="aopfilter",urlPatterns="/*")
public class AopFilter implements Filter{
	public static void main(String[] args){
		
	}
	@Override
	public void destroy(){
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpSession session=request.getSession();
		UserSession.set("user", session.getAttribute("usernamelog"));
		
		arg2.doFilter(arg0, arg1);
		UserSession.remove();
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
