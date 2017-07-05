package cn.bronze.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.entities.Asset;
import cn.bronze.entities.CustomAssetCheckData;
import cn.bronze.entities.DepartmentWithUserMessage;
import cn.bronze.log.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class FileTextWriterService {

	/**
	 * 将根据”查询键“、”查询值“、”使用状态“查询到的资产列表的id拼接字符串打印到text文件中
	 * @param selectKey
	 * @param selectValue
	 * @param useState
	 * @throws Exception 
	 */
	public String exportAssetCheckDataToText(CustomAssetCheckData assets) throws Exception{
		int result = 0;

		//判断盘点资产列表是否为空
		if(assets.getAssets().size() <= 0){
			result = 0;
			throw new Exception("资产列表为空");
		}

		//获取资产编号拼接字符串
		String assetsString = getAssetsString(assets.getAssets());
		if(assetsString == null || assetsString.length() <= 0){
			result = 0;
			throw new Exception("资产列表为空");
		}

		System.out.println("lrp输出assetsString：" + assetsString);

		//获取查询条件拼接字符串
		String selectTermsString = getSelectTermsString(assets.getSelectTerms());
		if(selectTermsString == null || selectTermsString.length() <= 0){
			result = 0;
			throw new Exception("获取查询条件拼接字符串失败");
		}

		//生成要写入到文件中的字符串
		String resultStr = assetsString + selectTermsString;

		//String pathStr = getWebRootPath() +"File/Text/assetcheckdata.txt";

		//服务器桌面的路径
		String pathStr=FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
		pathStr+="\\assetcheckdata.txt";
		System.out.println(pathStr);
		//将字符串写入到文件中
		//result = writeStringToText(getWebRootPath() +"File/Text/assetcheckdata.txt",resultStr);
		result = writeStringToText(pathStr,resultStr);

		return pathStr;
	}

	@Log(descrp="执行导出部门与人员信息操作",type="系统管理权限，资产管理权限")
	public String exportDepartmentAndUserToText(List<DepartmentWithUserMessage> departmentWithUserMessages){
		//服务器桌面的路径
		String pathStr=FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
		pathStr+="\\departmentanduser.txt";
		System.out.println(pathStr);
		
		//获取要写入文件的字符串
		String resultString=getDepartmentAndUserString(departmentWithUserMessages);
		
		try {
			writeDepartmentAndUserToText(pathStr, resultString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return pathStr;
	}


	public int writeDepartmentAndUserToText(String textPath,String string) throws Exception{

		int result = 0;

		System.out.println("cz输出textPath：" + textPath);

		File file=new File(textPath);

		//deleteFile(textPath);

		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//FileOutputStream out=new FileOutputStream(file,true); 
		FileOutputStream out=new FileOutputStream(file); 

		try {
			out.write(string.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = 1;
		return result;


	}




	public int writeStringToText(String textPath,String string) throws IOException{
		int result = 0;

		System.out.println("lrp输出textPath：" + textPath);

		File file=new File(textPath);

		//deleteFile(textPath);

		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//FileOutputStream out=new FileOutputStream(file,true); 
		FileOutputStream out=new FileOutputStream(file); 

		try {
			out.write(string.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = 1;
		return result;
	}

	





	/**
	 * 刘仁鹏
	 * 获取查询条件拼接字符串
	 * @param selectTerms
	 * @return
	 */
	public String getSelectTermsString(List<String> selectTerms){
		String result = "";

		for(int i = 0; i< selectTerms.size(); i ++){
			result = result + "@" + selectTerms.get(i);
		}

		return result;
	}

	/**(第二阶段)已修改
	 * 刘仁鹏
	 * 获取资产编号拼接字符串
	 * @param assets
	 * @return
	 */

	public String getAssetsString(List<Asset> assets){
		String result = "";

		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

		//判断盘点资产列表是否为空
		if(assets.size() <= 0){
			return result;
		}

		//获取验证码
		String verfiString = "";
		String firstAssetCode = assets.get(0).getCode();
		for (int i = 0; i < firstAssetCode.length(); i += 2)
		{
			verfiString = verfiString + firstAssetCode.charAt(i);
		}

		//开始使用时间
		String startusetime="";
		String makecardtime="";
		String ghostyear="";
		//String makecardtime1="";
		//拼接result
		result += verfiString + "#";
		for(int i = 0; i < assets.size(); i ++ ){



			if(i == assets.size() - 1){
				if(assets.get(i).getStartusetime()!=null){
					startusetime=simpleDateFormat.format(assets.get(i).getStartusetime());
				}
				else{
					startusetime="";
				}
				if(assets.get(i).getMakecardtime()!=null){
					makecardtime=simpleDateFormat.format(assets.get(i).getMakecardtime());
				}
				else{
					makecardtime="";
				}
				//ghostyear=simpleDateFormat.format(assets.get(i).getGhostyear());
				result = result+assets.get(i).getCode()
						+"["+assets.get(i).getName()
						+"!"+assets.get(i).getCode()
						+"!"+assets.get(i).getType()
						+"!"+assets.get(i).getValue()
						+"!"+assets.get(i).getModel()
						+"!"+startusetime
						+"!"+assets.get(i).getUsedepartment()
						+"!"+assets.get(i).getUser()
						+"!"+makecardtime
						+"!"+assets.get(i).getGhostyear()
						+"]";
			}else{
				if(assets.get(i).getStartusetime()!=null){
					startusetime=simpleDateFormat.format(assets.get(i).getStartusetime());
				}
				else{
					startusetime="";
				}
				if(assets.get(i).getMakecardtime()!=null){
					makecardtime=simpleDateFormat.format(assets.get(i).getMakecardtime());
				}
				else{
					makecardtime="";
				}


				//ghostyear=simpleDateFormat.format(assets.get(i).getGhostyear());
				result = result+assets.get(i).getCode()
						+"["+assets.get(i).getName()
						+"!"+assets.get(i).getCode()
						+"!"+assets.get(i).getType()
						+"!"+assets.get(i).getValue()
						+"!"+assets.get(i).getModel()
						+"!"+startusetime
						+"!"+assets.get(i).getUsedepartment()
						+"!"+assets.get(i).getUser()
						+"!"+makecardtime
						+"!"+assets.get(i).getGhostyear()
						+"]#";
			}			
		}

		return result;
	}


	public void testGetWebRootPath(){
		//获得路径/WebRoot/WEB-INF/classes/的绝对路径
		String path=Class.class.getClass().getResource("/").getPath() ;
		//将%20换成空格（如果文件夹的名称带有空格的话，会在取得的字符串上变成%20）
		path=path.replaceAll("%20", " ");  
		//查找“WebRoot”在该字符串的位置
		int num = path.indexOf("WebRoot");
		//截取
		path=path.substring(0, num+"WebRoot".length());  
		System.out.println("lrp输出path：" + path);
	}

	public String getWebRootPath(){
		/*
		//获得路径/WebRoot/WEB-INF/classes/的绝对路径
		String path=Class.class.getClass().getResource("/").getPath() ;
		//将%20换成空格（如果文件夹的名称带有空格的话，会在取得的字符串上变成%20）
		path=path.replaceAll("%20", " ");  
		//查找“WebRoot”在该字符串的位置
		int num = path.indexOf("WebRoot");
		//截取
		path=path.substring(0, num+"WebRoot".length());  

		return path;
		 */

		String path=getClass().getResource("/").getPath() ;
		path=path.replaceAll("%20", " ");  
		return path;
	}


	public String getDepartmentAndUserString(List<DepartmentWithUserMessage> departmentWithUserMessages) {		
		String resultString="";

		String depnameString="";
		if(departmentWithUserMessages!=null&&departmentWithUserMessages.size()>0){
			for (int i = 0; i < departmentWithUserMessages.size(); i++) {
				depnameString=departmentWithUserMessages.get(i).getDepartmentname();
				resultString+=departmentWithUserMessages.get(i).getDepartmentname()+"[";
				if(departmentWithUserMessages.get(i).getUsermessagelist()!=null&&departmentWithUserMessages.get(i).getUsermessagelist().size()>0){

					for (int j = 0; j < departmentWithUserMessages.get(i).getUsermessagelist().size(); j++) {

						if(j==(departmentWithUserMessages.get(i).getUsermessagelist().size()-1)){
							resultString+=departmentWithUserMessages.get(i).getUsermessagelist().get(j)+"]";
							break;
						}
						resultString+=departmentWithUserMessages.get(i).getUsermessagelist().get(j)+"!";			
					}

				}
				else{
					resultString+="]";
				}

				if(i==departmentWithUserMessages.size()-1){
					//resultString+="]";
					break;

				}
				else {
					resultString+="#";
				}
			}		
		}
		
		System.out.println("cz:"+resultString);
		return resultString;

	}



	@Test
	public void testExportAssetCheckDataToText() throws IOException{

		int result = 0;

		Asset asset1 = new Asset();
		asset1.setCode("030400000000055");
		Asset asset2 = new Asset();
		asset2.setCode("030400000000066");
		List<Asset> assetList = new ArrayList<>();
		assetList.add(asset1);
		assetList.add(asset2);
		String selectTerm1 = "资产类型：保险柜";
		String selectTerm2 = "使用状态：在用";
		String selectTerm3 = "状态：正常";
		List<String> selectTermsList = new ArrayList<>();
		selectTermsList.add(selectTerm1);
		selectTermsList.add(selectTerm2);
		selectTermsList.add(selectTerm3);
		CustomAssetCheckData assets = new CustomAssetCheckData();
		assets.setAssets(assetList);
		assets.setSelectTerms(selectTermsList);

		//判断盘点资产列表是否为空
		if(assets.getAssets().size() <= 0){
			result = 0;
			//return result;
		}

		//获取资产编号拼接字符串
		String assetsString = getAssetsString(assets.getAssets());
		if(assetsString == null || assetsString.length() <= 0){
			result = 0;
			//return result;
		}

		//获取查询条件拼接字符串
		String selectTermsString = getSelectTermsString(assets.getSelectTerms());
		if(selectTermsString == null || selectTermsString.length() <= 0){
			result = 0;
			//return result;
		}

		//生成要写入到文件中的字符串
		String resultStr = assetsString + selectTermsString;

		//将字符串写入到文件中
		System.out.println("lrp输出resultStr：" + resultStr);
		result = writeStringToText(getWebRootPath() +"File/Text/assetcheckdata.txt",resultStr);
		System.out.println("lrp输出result：" + result);
	}


}

