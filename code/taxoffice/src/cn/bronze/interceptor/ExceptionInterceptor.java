package cn.bronze.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description:测试拦截器1 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-14下午4:45:47
 * @version 1.0
 */
public class ExceptionInterceptor implements HandlerInterceptor {

	
	//进入 Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//request.getRequestURL()
		return true;
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//System.out.println("ExceptionInterceptor...postHandle");
		
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		/*int status = response.getStatus();
		if(status/100==4||status/100==5)
			{
			String message = "<h1>出错了！！！</h1>";
			
			response.sendRedirect("/WEN-INF/jsp/error.jsp");
			
			
		}
		System.err.println("执行到这里，说明可以获取返回值，Spring过滤器");*/
	}
}
