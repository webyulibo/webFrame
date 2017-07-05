package cn.bronze.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bronze.util.json.JsonResponse;

@RequestMapping("/file")
@Controller
public class FileUploadFlagController {


	@RequestMapping(value="/index",method=RequestMethod.GET)
	public void index(HttpSession session,boolean isfile,HttpServletResponse response){
		session.setAttribute("isfile", true);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 1);
		try {
			JsonResponse.PrintJsonOne(response, jsonObject);
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/name",method=RequestMethod.POST)
	public void getfileName(HttpSession session,boolean isfile,HttpServletResponse response){
		String fileName = (String)session.getAttribute("filename");
		JSONObject jsonObject = new JSONObject();
		if(fileName!=null){
			jsonObject.put("filename", fileName);
		}else{
			//迷惑
			jsonObject.put("status", "success");
		}
		try {
			JsonResponse.PrintJsonOne(response, jsonObject);
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
	}
}
