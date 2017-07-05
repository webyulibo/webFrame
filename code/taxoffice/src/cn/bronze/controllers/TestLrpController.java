package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;

@RequestMapping("/testlrpcontroller")
@Controller
public class TestLrpController {

	@RequestMapping("/testselect")
	public void testselect(String isbegin,Asset asset){
		
		System.out.println("lrp输出isbegin：" + isbegin);
		//System.out.println("lrp输出asset.getName()：" + asset.getName());
		
	}
	
}
