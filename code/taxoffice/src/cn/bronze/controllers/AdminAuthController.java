package cn.bronze.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.daos.TAuthorityMapper;
import cn.bronze.entities.TAuthority;
import cn.bronze.services.AdminAuthService;
import cn.bronze.util.page.PageParameter;


@Controller
@RequestMapping("/AdminAuthController")
public class AdminAuthController {
	
	@Autowired
	private AdminAuthService adminAuthService;
	/*
	 * 分页展示所有权限
	 * */
	@RequestMapping("/showpropertymanagewithpage")
	public ModelAndView showpropertymanage(Integer currentPage)
	{
		ModelAndView modelAndView=new ModelAndView();
		
		currentPage=(currentPage!=null)?currentPage:1;
		PageParameter page=PageParameter.NewInstance(currentPage);
		List<TAuthority> authorities=adminAuthService.getroleswithpage(page);
		
		modelAndView.addObject("authorities",authorities);
		modelAndView.addObject("pager", page);
		modelAndView.setViewName("/systemadmin/propertymanage/showpropertymanage");
		return modelAndView;
		
	}
}
