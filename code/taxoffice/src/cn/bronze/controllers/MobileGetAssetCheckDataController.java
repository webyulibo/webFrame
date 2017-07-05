package cn.bronze.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

import cn.bronze.entities.Asset;
import cn.bronze.services.AdminAssetCheckDataExportService;
import cn.bronze.services.BaseAssetServcie;
import cn.bronze.services.FileTextWriterService;
import cn.bronze.services.MobileGetAssetCheckDataService;
import cn.bronze.util.page.PageParameter;


@RequestMapping("/mobilegetassetcheckdatacontroller")
@Controller
public class MobileGetAssetCheckDataController {
	
	@Autowired
	private MobileGetAssetCheckDataService mobileGetAssetCheckDataService;
	
	@RequestMapping("/getassetcheckdata")
	public void getAssetCheckData(HttpServletRequest request,HttpServletResponse response){

		String path = mobileGetAssetCheckDataService.getAssetCheckDataFIlePath();
		
		System.out.println("lrp输出path：" + path);
		
		  try
		    {
		        java.io.OutputStream    os  = response.getOutputStream();
		        java.io.FileInputStream fis = new java.io.FileInputStream(path);


		        byte[] b = new byte[1024];
		        int    i = 0;


		        while ( (i = fis.read(b)) > 0 ) 
		        {
		            os.write(b, 0, i);
		        }


		        fis.close();
		        os.flush();
		        os.close();
		    }
	   	    catch ( Exception e )
		    {
		    }
	}

}
