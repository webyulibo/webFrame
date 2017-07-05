package cn.bronze.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.ws.spi.http.HttpContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class MobileGetAssetCheckDataService {

	public String getAssetCheckDataFIlePath(){
		//String path = getWebRootPath() + "attached/File/Text/assetcheckdata.txt";
		String path = getWebRootPath() + "File/Text/assetcheckdata.txt";
		return path;
	}
	
	@Test
	public void testGetWebRootPath(){
		//String ssString = HttpContext.class.getClass().getResource("/").getPath() ;
		//System.out.println("lrp输出ssString：" + ssString);
		
		//获得路径/WebRoot/WEB-INF/classes/的绝对路径
		//String path=Class.class.getClass().getResource("/").getPath() ;
		String path=getClass().getResource("/").getPath() ;
		//将%20换成空格（如果文件夹的名称带有空格的话，会在取得的字符串上变成%20）
		path=path.replaceAll("%20", " ");  
		//查找“WebRoot”在该字符串的位置
		int num = path.indexOf("WebRoot");
		//截取
		path=path.substring(0, num+"WebRoot".length());  
		System.out.println("lrp输出path：" + path);
	}
	
	public String getWebRootPath(){
		//获得路径/WebRoot/WEB-INF/classes/的绝对路径
		//String path=Class.class.getClass().getResource("/").getPath() ;
		String path=getClass().getResource("/").getPath() ;
		path=path.replaceAll("%20", " ");  
		
		/*
		//将%20换成空格（如果文件夹的名称带有空格的话，会在取得的字符串上变成%20）
		path=path.replaceAll("%20", " ");  
		//查找“WebRoot”在该字符串的位置
		int num = path.indexOf("WebRoot");
		//截取
		path=path.substring(0, num+"WebRoot".length());  
		*/

		return path;
	}
	
}
