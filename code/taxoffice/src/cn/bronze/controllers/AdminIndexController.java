package cn.bronze.controllers;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.TUser;
import cn.bronze.services.AdminMessageService;
import cn.bronze.services.AdminUserManagerService;

@Controller
//@RequestMapping("/AdminIndexController")
public class AdminIndexController {
	@Autowired
	private AdminUserManagerService adminUserManagerService;
	@Autowired 
	private AdminMessageService adminMessageService;
	//顶部
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView modelAndView=new ModelAndView();		
		modelAndView.setViewName("manage/login");
		return modelAndView;
	}

	//测试页面
	@RequestMapping("testjsp")
	public ModelAndView testpage(){
		ModelAndView modelAndView=new ModelAndView();

		modelAndView.setViewName("/assetadmin/pandianqingcha/daochu/testjsp");
		return modelAndView;

	}



	/***
	 * 
	 * 登录校验
	 * 
	 */
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(String username,String password,HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();

		if(username==null||password==null||username==""||password==""){
//			String errormsg="登录失败，请确认账号密码后重新登录";
//        	modelAndView.addObject("errormsg", errormsg);
        	modelAndView.setViewName("manage/login");
        	return modelAndView;       	
		}
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);	
		try {
        	//执行认证操作. 
            subject.login(token);
            session.setAttribute("usernamelog", subject.getPrincipal());     
            subject.getSession().setTimeout(-1000l);
        }catch (AuthenticationException ae) {
        	String errormsg="登录失败，请确认账号密码后重新登录";
        	modelAndView.addObject("errormsg", errormsg);
        	modelAndView.setViewName("manage/login");
        	return modelAndView;       	
        }
		modelAndView.setViewName("/manage/index");
		return modelAndView;
	}


	/***
	 * 
	 * 登出
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(){
		ModelAndView modelAndView=new ModelAndView();
		
		Subject subject=SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			//将session注销
			subject.logout();
			
		}
		
		modelAndView.setViewName("manage/login");
		return modelAndView;
	}
	
	

	//跳转到主页面
	@RequestMapping("/AdminIndexController/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();

		modelAndView.setViewName("/manage/index");
		return modelAndView;
	}

	//左边部分
	@RequestMapping("/AdminIndexController/left")
	public ModelAndView left(HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		String useraccount=(String)session.getAttribute("usernamelog");
		String userdepnameString=adminUserManagerService.getUserByUserAccount(useraccount);
		String userdepcode=adminUserManagerService.getUserDepCodeByUserAccount(useraccount);
		modelAndView.addObject("useraccount", useraccount);
		modelAndView.addObject("userdepcode", userdepcode);
		modelAndView.addObject("userdepnameString", userdepnameString);
		modelAndView.setViewName("/manage/left");
		return modelAndView;
	}

	//顶部
	@RequestMapping("/AdminIndexController/top")
	public ModelAndView top(HttpSession session){
		ModelAndView modelAndView=new ModelAndView(); 
		String useraccount=(String)session.getAttribute("usernamelog");
		String userdepnameString=adminUserManagerService.getUserByUserAccount(useraccount);
		String depcode=adminUserManagerService.getUserDepCodeByUserAccount(useraccount);
		modelAndView.addObject("depcode",depcode);
		modelAndView.addObject("userdepnameString", userdepnameString);
		modelAndView.addObject("useraccount", useraccount);
		modelAndView.setViewName("/manage/top");
		return modelAndView;
	}


}
