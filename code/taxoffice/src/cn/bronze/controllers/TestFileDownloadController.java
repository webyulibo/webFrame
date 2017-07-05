package cn.bronze.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bronze.util.file.FileDownload;

@RequestMapping("/filedownload")
@Controller
public class TestFileDownloadController {

	
	
	@RequestMapping("/test")
	public void test(HttpServletResponse resp){
		
		File file = new File("e://资产信息于海强.xls");
		FileDownload.download(resp, file, "资产信息于海强");
		
	}
	public static void main(String[] args) {

	}

}
