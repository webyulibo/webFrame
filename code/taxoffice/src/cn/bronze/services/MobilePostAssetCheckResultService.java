package cn.bronze.services;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class MobilePostAssetCheckResultService {
	
	@Autowired
	FileTextWriterService fileTextWriterService;
	
	@Autowired
	FileTextReaderService fileTextReaderService;

	public int postAssetCheckResult(String resultStr) throws IOException{	
		//0:未知错误
		//1:写入成功
		//2:写入失败：文件内容不合法
		//3:写入失败：内容为空
		//4:上次盘点结果未导入数据库，需要先导入数据库才能上传本次结果
		int resultNum = 0;
		
		//1.检查数据合法性
		//测试合法性
		if(resultStr != null && resultStr.length() > 0){
			
		}else{
			resultNum = 3;
			return resultNum;
		}
		String resultStrTemp = doCheck(resultStr);
		if(resultStrTemp != null && resultStrTemp.length() > 0){
			
		}else {
			resultNum = 2;
			return resultNum;
		}
		
		//2.查看文件是否为空（上次盘点结果是否已经导入数据库）
		//读取文件中的内容
		File file=new File(getWebRootPath() +"File/Text/assetcheckresult.txt");
        if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String content= fileTextReaderService.getTextContent(getWebRootPath() +"File/Text/assetcheckresult.txt");
		if(content == null || content.length()<=0){
			
		}else{
			
			System.out.println("lrp输出Mobile:postAssetCheckResult:content：" + content);
			
			resultNum = 4;
			return resultNum;
		}
		
		//3.写入数据到文档中
		System.out.println("lrp输出Mobile:postAssetCheckResult:resultNum：" + resultNum);
		resultNum = fileTextWriterService.writeStringToText(getWebRootPath() + "File/Text/assetcheckresult.txt", resultStr);
		return resultNum;
	}
	
	public String doCheck(String resultStr){
		String result = "";
		String[] resultStrings = resultStr.split("#");
		if(resultStrings.length <= 1){
			result = "";
			return result;
		}
		
		//获取验证码
		String verfiString = "";
		for (int i = 0; i < resultStrings[1].length(); i += 2)
        {
			verfiString = verfiString +  resultStrings[1].charAt(i);
        }
		
		if(verfiString.equals(resultStrings[0])){
			int jnum = resultStr.indexOf("#");
			result = resultStr.substring(jnum + 1,resultStr.length());
		}else{
			result = "";
			return result;
		}
		
		return result;
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
