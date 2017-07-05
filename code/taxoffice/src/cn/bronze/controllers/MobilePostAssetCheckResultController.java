package cn.bronze.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bronze.services.MobilePostAssetCheckResultService;
import cn.bronze.util.json.JsonResponse;

@RequestMapping("/mobilepostassetcheckresultcontroller")
@Controller
public class MobilePostAssetCheckResultController {
	
	@Autowired
	private MobilePostAssetCheckResultService mobilePostAssetCheckResultService;

	@RequestMapping("/postassetcheckresult")
	public void postAssetCheckResult(String result,HttpServletResponse response) throws IOException{
		JSONObject jsonObject = new JSONObject();
		System.out.println("result：" + result);
		result=result.replaceAll("!", "#");  
		
		System.out.println("lrp输出MobileController:postAssetCheckResult:result：" + result);
		
		int resultNum = 0;
		resultNum = mobilePostAssetCheckResultService.postAssetCheckResult(result);
		
		jsonObject.put("status", resultNum);
		
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	
}
