package cn.bronze.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;








//import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.AssetType;
import cn.bronze.services.BaseAssetTypeService;
import cn.bronze.util.page.PageParameter;

@RequestMapping("/dhtestcontroller")
@Controller
public class DHTestController {
	
	/*@Autowired
	private BaseAssetTypeService baseAssetTypeService;
	
	private String baseurl = "/test";
	
	@RequestMapping("/testlist")
	public ModelAndView testlist(Integer currentpage){
		ModelAndView modelAndView = new ModelAndView();

		if(currentpage==null){
			currentpage = 1;
		}
		
		if(currentpage<=0){
			currentpage = 1;
		}
		
		PageParameter pageParameter = PageParameter.NewInstance(currentpage);
	
		List<AssetType> assetTypeList = baseAssetTypeService.getAllByPage(pageParameter);
		
		//baseAssetTypeService.
		
		modelAndView.addObject("assettypelist", assetTypeList);
		modelAndView.addObject("pager", pageParameter);
		modelAndView.addObject("currentpage", currentpage);
		modelAndView.setViewName(baseurl + "/testlist");

		return modelAndView;
	}*/
	
}
