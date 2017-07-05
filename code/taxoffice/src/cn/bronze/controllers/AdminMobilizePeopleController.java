package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.TMobilizepeople;
import cn.bronze.services.AdminDepartmentService;
import cn.bronze.services.AdminMobilizePeopleService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/adminmobilizepeoplecontroller")

public class AdminMobilizePeopleController {
	
	@Autowired
    public AdminMobilizePeopleService AdminMobilizePeopleService;
	@Autowired
    public AdminDepartmentService admindepartmentservice;
	
	/**
	   * 刘晓峰
	   * 显示人员变更界面
	   * return ModelAndView
	   */
	@RequiresPermissions(value={"movepeoauth"})
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("informationnotice/personneldepartment/staffchangenotice");
		return modelAndView;
	}
	/**
	   * 刘晓峰
	   * 显示人员变更列表
	   * return ModelAndView
	   */
	@RequestMapping("/showlist")
	public ModelAndView showlist(Integer currentPage){
		ModelAndView modelAndView=new ModelAndView();
		 List<TMobilizepeople> TMobilizepeopleList=new ArrayList<TMobilizepeople>();
		currentPage = (currentPage!=null)?currentPage:1;
		 PageParameter pageParameter = PageParameter.NewInstance(currentPage);
		 TMobilizepeopleList=AdminMobilizePeopleService.getMobilizepeopleList(pageParameter);
		modelAndView.addObject("pager",pageParameter);
		modelAndView.addObject("TMobilizepeopleList",TMobilizepeopleList);
		modelAndView.setViewName("informationnotice/personneldepartment/staffchangelist");
		return modelAndView;
	}
	
	/**
	   * 刘晓峰
	   * 保存人员表更
	   * return void JsonResponse
	   */
	@RequestMapping("/saveMobilizepeople")
	public void saveMobilizepeople(
			TMobilizepeople  TMobilizepeople,
			  HttpServletResponse response)throws IOException
		{   
		
			JSONObject jsonObject = new JSONObject();
			int a;
			a=AdminMobilizePeopleService.indexMobilizepeople(TMobilizepeople);
			if(a>0)
			{
			   admindepartmentservice.countDepUseNum();
		       jsonObject.put("status", "ok");
			   jsonObject.put("msg", "保存成功");
			   JsonResponse.PrintJsonOne(response, jsonObject);
			}
			else
			{	
				jsonObject.put("status", "no");
				jsonObject.put("msg", "保存失败");
			   JsonResponse.PrintJsonOne(response, jsonObject);
			}		
		}
	
	/**
	   * 刘晓峰
	   * 判断人员和原部门是否合法
	   * return void JsonResponse
	   */
	@RequestMapping("/isnameandolddepiegal")
	public void isnameandolddepiegal(String username,String originaldep,HttpServletResponse response) throws IOException
	{
		JSONObject jsonObject=new JSONObject();
			boolean n=AdminMobilizePeopleService.IsLegal(originaldep);
			if(n==true)
			{  
				if(originaldep.equals(""))
				{ 
					jsonObject.put("status", "ok");
				}
				else
				{
				  boolean m=AdminMobilizePeopleService.IspeopleIegal(originaldep, username);
				  if(m==true)
					  jsonObject.put("status", "ok");
			      else
				  {
					 jsonObject.put("status", "no");
			         jsonObject.put("msg", "该部门不存在该人员！");
				  }
				}
			}
			else
			{
				jsonObject.put("status", "no");
			    jsonObject.put("msg", "输入的原部门不存在！");
			}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	   * 刘晓峰
	   * 判断原部门和新部门是否合法
	   * return void JsonResponse
	   */
	@RequestMapping("/isdeplegal")
	public void isdeplegal (String newdep,String originaldep,HttpServletResponse response)throws IOException
	{   	
		JSONObject jsonObject=new JSONObject();
		boolean n=AdminMobilizePeopleService.IsLegal(newdep);
		boolean m=AdminMobilizePeopleService.IsLegal(originaldep);
		if(n==true&&m==true)
			jsonObject.put("status", "ok");
		else
			{
			 jsonObject.put("status", "no");
			 jsonObject.put("msg", "输入的部门不合法！");
			}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	   * 刘晓峰
	   * 更新人员所在部门
	   * return void JsonResponse
	   */
	@RequestMapping("/updatedep")
	public void updatedep(String username,String originaldep,String newdep) throws IOException{
		AdminMobilizePeopleService.updateasset(username, originaldep, newdep);
		admindepartmentservice.countDepUseNum();
	}
	/**
	   * 刘晓峰
	   * 获取人员列表
	   * return void JsonResponse
	   */
	@RequestMapping("/getname")
	public void getname(HttpServletResponse response) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=AdminMobilizePeopleService.getname();
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	/**
	   * 刘晓峰
	   *获取部门列表
	   * return void JsonResponse
	   */
	@RequestMapping("/getdepartment")
	public void getdepartment(HttpServletResponse response) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=AdminMobilizePeopleService.getdepartment();
		JsonResponse.PrintJsonList(response, jsonArray);
	}
}
