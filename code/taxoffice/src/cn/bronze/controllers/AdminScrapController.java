 package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;
import cn.bronze.entities.TAssetborrow;
import cn.bronze.entities.TScrap;
import cn.bronze.entities.TScrapExample;
import cn.bronze.services.AdminScrapService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/AdminScrapController")
public class AdminScrapController {
	@Autowired
	public AdminScrapService adminScrapService;
	
	@RequiresPermissions(value={"assetauth","checkauth","sysauth"},logical=Logical.OR)
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/assetscrap/addscrap");
		return modelAndView;
	}
	 /**
	   * 于立波
	   * 用于查询报废记录列表
	   * @param currentPage 用于分页
	   * @return
	   */
	@RequiresPermissions(value={"assetauth","checkauth","sysauth"},logical=Logical.OR)
	@RequestMapping("/showscrap")
	public ModelAndView showscrap(
			 Integer currentPage
			){
		 ModelAndView modelAndView=new ModelAndView();
		 List<TScrap> scrapList=new ArrayList<>();
		  currentPage = (currentPage!=null)?currentPage:1;
		  PageParameter pageParameter = PageParameter.NewInstance(currentPage);
		  scrapList=adminScrapService.getScrapList(pageParameter);
		  modelAndView.addObject("pager",pageParameter);
		  modelAndView.addObject("scrapList", scrapList);
		modelAndView.setViewName("/assetscrap/showscrap");
		return modelAndView;
	}
	 /**
	   * 于立波
	   * scrapRecord  报废记录
	   * 保存报废记录
	 * @throws IOException 
	   */
	@RequiresPermissions(value={"assetauth","sysauth"},logical=Logical.OR)
	  @RequestMapping("/savescraprecord")
	  public void savescraprecord(
			 TScrap    scrapRecord
			  ,HttpServletResponse response
			  ) throws IOException{
		    JSONObject jsonObject = new JSONObject();
          //验证资产的状态
		    String checkResult=adminScrapService.checkAssetState(scrapRecord.getAssetcode());
		    if(checkResult.equals("在用")){
		    	jsonObject.put("msg", "资产状态为在用，无法报废");
				JsonResponse.PrintJsonOne(response, jsonObject);
		    }
		    if(checkResult.equals("损坏不能用")){
		    	jsonObject.put("msg", "资产已损坏不能用");
				JsonResponse.PrintJsonOne(response, jsonObject);
		    }
		    if(checkResult.equals("闲置")){
		    //保存报废记录
		    adminScrapService.saveScrapRecord(scrapRecord);
		    //把资产的状态改为在用
		    adminScrapService.changeAssetState(scrapRecord.getAssetcode());
			jsonObject.put("msg", "保存成功");
			JsonResponse.PrintJsonOne(response, jsonObject);
		    }
	  }
}
