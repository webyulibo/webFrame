package cn.bronze.controllers;

import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
  

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;

import cn.bronze.entities.Asset;
import cn.bronze.services.FileImagePdfWriterService;

@RequestMapping("/testlrppdfwriterController")
@Controller
public class TestLrpPdfWriterController {

	@Autowired
	FileImagePdfWriterService fileImagePdfWriterService;
	
	@RequestMapping("/downpdf")
	public void downpdf(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		// TODO Auto-generated method stub
		
				Asset asset = new Asset();
				asset.setName("办公椅");  //资产名称
				asset.setCode("030400000001819"); //编号
				asset.setType("椅类"); //分类
				asset.setValue(1966.8); //原值
				//asset.setModel(""); //规格型号
				asset.setStartusetime(new Date()); //启用日期
				asset.setUsedepartment("局领导"); //使用部门
				asset.setUser("刘耀民"); //使用人
				asset.setMakecardtime(new Date()); //制卡日期
				asset.setGhostyear("2019");  //报废年度
				List<Asset> assets=new ArrayList<Asset>();//akg修改
				assets.add(asset);
				String filename = fileImagePdfWriterService.printAssetToPdfDocument(assets);
		
				System.out.println("lrp输出：filename" + filename);
				
				response.setHeader("Content-Disposition", "attachment;filename="+filename);

				//读取文件
				InputStream in = new FileInputStream(filename);
				OutputStream out = response.getOutputStream();
				
				//写文件
				int b;
				while((b=in.read())!= -1)
				{
					out.write(b);
				}
				
				in.close();
				out.close();
	}
	
}
