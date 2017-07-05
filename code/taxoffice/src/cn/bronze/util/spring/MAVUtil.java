/**
 * 
 */
package cn.bronze.util.spring;

import org.springframework.web.servlet.ModelAndView;

/**
 * 返回ModelAndView工具类
 * @author 董浩
 * 2016年6月18日
 */
public class MAVUtil {
	
	/**
	 * 返回指定名字的ModelAndView
	 * @author 董浩
	 * 2016年6月18日 下午5:21:01
	 * @param viewName
	 * @return
	 */
	public static ModelAndView getModelAndViewByName(String viewName){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		return modelAndView;
	}
	
	/**
	 * 返回指定信息的错误界面
	 * @author 董浩
	 * 2016年6月18日 下午5:25:11
	 * @param message
	 * @return
	 */
	public static ModelAndView getErrorModelAndView(String message){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("/error");
		return modelAndView;
	}
	
}
