package com.art.service.impl;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.art.common.utils.IDUtils;
import com.art.common.utils.UpLoadUtil;
import com.art.service.PictureService;
@Service
public class PictureServiceImpl implements PictureService {
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;//图片的访问路径（即nginx的访问路径)
	@Value("${FILI_UPLOAD_PATH}")
	private String FILI_UPLOAD_PATH;//要上传到服务器的路径
	@Override
	/**
	 * 于立波
	 * 上传图片
	 */
	public Map uploadFile(MultipartFile uploadFile) {
		Map resultMap=new HashMap<>();
				// 上传文件功能实现
				String path = savePicture(uploadFile);
				// 回显
				if(path!=""&&path!=null&&!(path.isEmpty())){
					resultMap.put("error", 0);
					resultMap.put("url", IMAGE_BASE_URL + path);
				}
				else{
					resultMap.put("error", 1);
					resultMap.put("url", "");
					resultMap.put("message", "文件上传失败");
				}
				return resultMap;
			}
		
			private String savePicture(MultipartFile uploadFile) {
				String filePath="";
				String newName="";
				String resultPath="";
				try {
					// 上传文件功能实现
					// 判断文件是否为空
					if (uploadFile.isEmpty()){
						System.out.println("文件不可用");
						return null;	
					}
					// 上传文件以日期为单位分开存放，可以提高图片的查询速度
					 filePath = "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
							+ new SimpleDateFormat("MM").format(new Date()) + "/"
							+ new SimpleDateFormat("dd").format(new Date())+ "/";
					 //建立对应文件目录
				        try {
				        	if (!(new File(FILI_UPLOAD_PATH+filePath).isDirectory())){
				        		new File(FILI_UPLOAD_PATH+filePath).mkdirs();
				        	    System.out.println("文件路径创建成功");	
				        	}
						}catch (SecurityException e) {
				        	e.printStackTrace();
				        	}   
					 //创建心得文件名 
					 newName=IDUtils.genImageName();
					 //获得文件后缀名
			          String fileNameP=uploadFile.getOriginalFilename();
			          String prefix=fileNameP.substring(fileNameP.lastIndexOf(".")+1);
			          resultPath=filePath+newName+"."+prefix; //返回的路径
			         // 新建文件输入流并对它进行缓冲  
				     InputStream input = uploadFile.getInputStream();
					//上传文件并返回图片所在路径
				     UpLoadUtil.SaveFileFromInputStream(input, FILI_UPLOAD_PATH+filePath, newName+"."+prefix);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				return resultPath;
			}
}