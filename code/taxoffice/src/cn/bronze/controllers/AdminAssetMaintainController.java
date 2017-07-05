package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Assetmaintain;
import cn.bronze.entities.TMaintain;
import cn.bronze.services.AdminAssetMaintainService;
import cn.bronze.services.AdminScrapService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;


@Controller
@RequestMapping("/adminassetmaintaincontroller")

public class AdminAssetMaintainController {
	@Autowired
	public AdminScrapService adminScrapService;
	@Autowired
	public AdminAssetMaintainService adminAssetMaintainService;
	
	 /**
	   * 刘晓峰
	   * 显示维修故障界面
	   * @param
	   * @return  ModelAndView
	   */
	@RequiresPermissions(value={"assetauth","checkauth","sysauth","faultauth"},logical=Logical.OR)
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/assetmaintain/assetmaintain");
		return modelAndView;
	}
	/**
	   * 刘晓峰
	   * 显示维修故障列表
       * @param
	   * @return  ModelAndView
	   */
	@RequestMapping("/showmaintainlist")
	public ModelAndView showmaintainlist(Integer currentPage){
		ModelAndView modelAndView=new ModelAndView();
		List<Assetmaintain> maintainList=new ArrayList<Assetmaintain>();
		currentPage = (currentPage!=null)?currentPage:1;
		PageParameter pageParameter = PageParameter.NewInstance(currentPage);
		maintainList=adminAssetMaintainService.getTmaintainList(pageParameter);
		modelAndView.addObject("pager",pageParameter);
		modelAndView.addObject("maintainList",maintainList);
		modelAndView.setViewName("/assetmaintain/showmaintain");
		return modelAndView;
	}
	@RequestMapping("/savemaintain")
	public void savemaintain(
			TMaintain Tmaintain,
			  HttpServletResponse response)throws IOException
		{   
			JSONObject jsonObject = new JSONObject();
			//更改状态为闲置
			adminScrapService.changeAssetState1(Tmaintain.getCode());
			int a=0;
			a=adminAssetMaintainService.insertMaintain(Tmaintain);
			if(a>0)
			jsonObject.put("msg", "保存成功");
			else
	        jsonObject.put("msg", "保存失败");
			JsonResponse.PrintJsonOne(response, jsonObject);
		}
	/**
	   * 刘晓峰
	   * 提取资产编号
	   * @param response
	   * @return  JsonResponse
	   */
	@RequestMapping("/getmaintaincode")
	public void getmaintaincode(HttpServletResponse response) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminAssetMaintainService.getassetcode();
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	
	/**
	   * 刘晓峰
	   * 提取资产名称
	   *  @param response
	   * @return  JsonResponse
	   */
	@RequestMapping("/getmaintainname")
	public void getmaintainname(HttpServletResponse response) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminAssetMaintainService.getassetname();
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	/**
	   * 刘晓峰
	   * 提取人员
	   *  @param response
	   * @return  JsonResponse
	   */
	@RequestMapping("/getguy")
	public void getguy(HttpServletResponse response) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminAssetMaintainService.getguy();
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	/**
	   * 刘晓峰
	   * 根据姓名提取资产编号
	   * @param response name姓名
	   * @return  void JsonResponse
	   */
	@RequestMapping("/getcodebyname")
	public void  getcodebyname(
			  String name, 
			  HttpServletResponse response
			  )
				throws IOException {
			JSONObject jsonObject = new JSONObject();
			List<String>  assetcode = adminAssetMaintainService.getAssetcodebyname(name);	
			if(assetcode!=null){
			jsonObject.put("state", "1");	
			jsonObject.put("assetcode",  assetcode);
			}
			if(assetcode==null){
				jsonObject.put("state", "0");	
				}
			JsonResponse.PrintJsonOne(response, jsonObject);
	   }
	/**
	   * 刘晓峰
	   * 根据资产编号提取资产名称
	   * @param response code资产编号
	   * @return  void JsonResponse
	   */
	@RequestMapping("/getnamebycode")
	  public void  getnamebycode(
			  String code, 
			  HttpServletResponse response
			  )
				throws IOException {
			JSONObject jsonObject = new JSONObject();
			String  assetname = adminAssetMaintainService.getAssetnamebycode(code);	
			if(assetname!=null){
			jsonObject.put("state", "1");	
			jsonObject.put("assetname",  assetname);
			}
			if(assetname==null){
				jsonObject.put("state", "0");	
				}
			JsonResponse.PrintJsonOne(response, jsonObject);
	   }
	/**
	   * 刘晓峰
	   * 根据资产编号提取购买年限
	   * @param response code资产编号
	   * @return  void JsonResponse
	   */
	@RequestMapping("/getpurchasedatabycode")
	public void getpurchasedatabycode(HttpServletResponse response,String code) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminAssetMaintainService.getmaintainAssetDate(code);
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	/**
	   * 刘晓峰
	   * 根据资产编号提取报废年限
	   * @param response code资产编号
	   * @return  void JsonResponse
	   */
	@RequestMapping("/getghostyearsbycode")
	public void getghostyearsbycode(HttpServletResponse response,String code) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminAssetMaintainService.getmaintainAssetGhostyear(code);
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	/**
	   * 刘晓峰
	   * 根据资产编号提取资产类型
	   * @param response code资产编号
	   * @return  void JsonResponse
	   */
	@RequestMapping("/getmodelbycode")
	public void getmodelbycode(HttpServletResponse response,String code) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminAssetMaintainService.getmaintainAssetModel(code);
		JsonResponse.PrintJsonList(response, jsonArray);
		//JsonResponse.PrintJsonOne(response, jsonArray);
	}
	/**
	   * 刘晓峰
	   * 判断资产编号是否合法
	   * @param response code资产编号
	   * @return  void JsonResponse
	   */
	@RequestMapping("/iscodelegal")
	public void iscodelegal(String code,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
	    boolean s;
	    s=adminAssetMaintainService.IscodeIegal(code);
        if(s==true)
        {
        	jsonObject.put("status", "ok");
        }
        else
        {
        	jsonObject.put("status", "no");
        	jsonObject.put("msg", "不存在该资产或该资产未报损坏");
        }
        JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	   * 刘晓峰
	   * 判断资产名称是否合法
	   * @param response code资产编号
	   * @return  void JsonResponse
	   */
	@RequestMapping("/isnamelegal")
	public void isnamelegal(String name,HttpServletResponse response) throws IOException{
		//name = new String(name.getBytes("iso8859-1"),"UTF-8");
		
		JSONObject jsonObject=new JSONObject();
	    boolean s;
	    s=adminAssetMaintainService.IsnameIegal(name);
        if(s==true)
        {
        	jsonObject.put("status", "ok");
        }
        else
        {
        	jsonObject.put("status", "no");
        	jsonObject.put("msg", "不存在该资产名称");
        }
        JsonResponse.PrintJsonOne(response, jsonObject);
	}
	@RequestMapping("/getassetcodejson2")
	public void getassetcodejson2(
			String assetname
			,HttpServletResponse response
			) throws IOException{
		JSONArray jsonArray=new JSONArray();
     	jsonArray=adminAssetMaintainService.getAssetcode2Json(assetname);
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	@RequestMapping("/iscodeandnamelegal")
	public void iscodeandnamelegal(String code,String name,HttpServletResponse response) throws IOException{
		//name = new String(name.getBytes("iso8859-1"),"UTF-8");
		JSONObject jsonObject=new JSONObject();
		 boolean s;
		 s=adminAssetMaintainService.IscodeandnameIegal(code, name);
		 if(s==true)
	        {
	        	jsonObject.put("status", "ok");
	        }
	        else
	        {
	        	jsonObject.put("status", "no");
	        	jsonObject.put("msg", "资产名称与资产编号不对应");
	        }
		 JsonResponse.PrintJsonOne(response, jsonObject);
	}
		
	
}
