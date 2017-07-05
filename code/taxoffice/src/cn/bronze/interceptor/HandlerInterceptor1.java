package cn.bronze.interceptor;

//import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class HandlerInterceptor1 implements HandlerInterceptor {

	
	//进入 Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
	//	System.out.println("HandlerInterceptor1...preHandle");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		return true;
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*HttpSession session = request.getSession();
		if(session.getAttribute("prepage")==null){
			//TODO 需要判断是管理员还是用户
			session.setAttribute("prepage", MAVUtil.getModleAndView("/front/index/index"));
			session.setAttribute("currpage", modelAndView);
		}
		else{
			session.setAttribute("prepage", session.getAttribute("currpage"));
			session.setAttribute("currpage", modelAndView);
		}*/
		
		//System.out.println("HandlerInterceptor1...postHandle");
		
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//System.out.println("HandlerInterceptor1...afterCompletion");
	}

}
