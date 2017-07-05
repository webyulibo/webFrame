package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import cn.bronze.entities.TPossess;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.services.AdminAssetPossessService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/AdminAssetLeadController")
public class AdminAssetLeadController {

	@Autowired
	public AdminAssetPossessService AdminAssetPossessService;
     
	 /**
	   * 刘晓峰
	   * 显示领用界面
	   */
    @RequiresPermissions(value={"assetauth","checkauth","sysauth"},logical=Logical.OR)
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/assetlead/indexjyg");
		return modelAndView;
	}
	 /**
	   * 刘晓峰
	   * TPossess 领用记录
	   * 保存领用记录
	 * @throws IOException 
	   */
@RequiresPermissions(value={"assetauth","sysauth"},logical=Logical.OR)
@RequestMapping("/saveleadasset")

		public void saveleadasset(
				TPossess TPossess,
				  HttpServletResponse response)throws IOException
			{   
				JSONObject jsonObject = new JSONObject();
				AdminAssetPossessService.indexPossess(TPossess);
				jsonObject.put("msg", "保存成功");
				JsonResponse.PrintJsonOne(response, jsonObject);
			}
			 /**
			   * 刘晓峰
			   * currentPage 分页
			   * 显示领用记录
			   */
        @RequiresPermissions(value={"assetauth","checkauth","sysauth"},logical=Logical.OR)
		@RequestMapping("/showleadasset")
		
		public ModelAndView showleadasset(
				Integer currentPage
				){
			ModelAndView modelAndView=new ModelAndView();
			 List<TPossess> TAssetPossessList=new ArrayList<TPossess>();
			currentPage = (currentPage!=null)?currentPage:1;
			 PageParameter pageParameter = PageParameter.NewInstance(currentPage);
			TAssetPossessList=AdminAssetPossessService.getTPossessList(pageParameter);
			modelAndView.addObject("pager",pageParameter);
			modelAndView.addObject("TAssetPossessList",TAssetPossessList);
			modelAndView.setViewName("/assetlead/showleadasset");
			return modelAndView;
		}
		 /**
		   * 刘晓峰
		   * currentPage 分页
		   * 判断是否可以领取
		   */
		@RequestMapping("/isleadasset")
		public void isleadasset(String code ,String possesspeople,String possessdepartment,HttpServletResponse response) throws IOException{
			JSONObject jsonObject=new JSONObject();
//			boolean m=AdminAssetPossessService.codeIsInLegal(code);
//			if(m==true){
				boolean n=AdminAssetPossessService.IsdepartmentLegal(possessdepartment);
				if(n==true)
				{
					boolean t=AdminAssetPossessService.IsPeopleLegal(possesspeople, possessdepartment);
					if(t==true)
					jsonObject.put("status", "ok");
					else
					{
						jsonObject.put("status", "no");
				        jsonObject.put("msg", "该部门不存在该人员！");
					}
				}
				else
				{
					jsonObject.put("status", "no");
				    jsonObject.put("msg", "该部门不存在！");
				}
			JsonResponse.PrintJsonOne(response, jsonObject);
		}
		
		/**
		   * 刘晓峰
		   * 提取可以领取的资产编号
		   */
		@RequestMapping("/getpossesscode")
		public void getpossesscode(HttpServletResponse response) throws IOException{
			JSONArray jsonArray=new JSONArray();
			jsonArray=AdminAssetPossessService.getassetpossesscode();
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		
		/**
		   * 刘晓峰
		   * 在combobox框后资产编号是否合法
		   */
		@RequestMapping("/ispossesscodelegal")
		public void ispossesscodelegal(String code,HttpServletResponse response) throws IOException{
			JSONObject jsonObject=new JSONObject();
		    boolean s;
		    s=AdminAssetPossessService.IspossesscodeIegal(code);
            if(s==true)
            {
            	jsonObject.put("status", "ok");
            	System.out.println("success");
            }
            else
            {
            	jsonObject.put("status", "no");
            }
            JsonResponse.PrintJsonOne(response, jsonObject);
		}
		
	    
		/**
		   * 刘晓峰
		   * 提取可以领取的人员姓名
		   */
		@RequestMapping("/getpossesspeople")
		public void getpossesspeople(String possessdepartment, HttpServletResponse response) throws IOException{
			//possessdepartment = new String(possessdepartment.getBytes("iso8859-1"),"UTF-8");
			JSONArray jsonArray=new JSONArray();
			jsonArray=AdminAssetPossessService.getassetpossesspeople(possessdepartment);
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		/**
		   * 刘晓峰
		   * 提取可以领取的部门
		   */
		@RequestMapping("/getpossessdepartment")
		public void getpossessdepartment(HttpServletResponse response) throws IOException{
			JSONArray jsonArray=new JSONArray();
			jsonArray=AdminAssetPossessService.getassetpossessdepartment();
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		
		/**
		   * 刘晓峰
		   * 更改领取物品的状态
		   */
		@RequestMapping("/updateasset")
		public void updateasset(String code) throws IOException{
			AdminAssetPossessService.updateasset(code);
		}
		@RequestMapping("/getpossessnum")
		public int  getpossessnum() throws IOException{
			return  AdminAssetPossessService.getpossessnum();
		}

}
