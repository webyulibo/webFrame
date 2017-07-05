package cn.bronze.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.ValueStyler;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.CustomAssetCheckData;
import cn.bronze.entities.CustomAssetCheckResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class FileTextReaderService {
	
	@Autowired
	private AssetMapper assetMapper;
	
	private static String ASSETSCHECKED = "assetsChecked";
	private static String ASSETSNOTCHECKED = "assetsNotChecked";
	private static String SELECTTERMS = "selectTerms";
	private static String ASSETSSTATEWRONG="assetsStateWrong";
	private static String textPath="";
	//assetsChecked：已盘
	//assetsNotChecked：漏盘
	//selectTerms：查询条件
	
	@Test
	public void testImportAssetCheckResultFromText() throws Exception{
		CustomAssetCheckResult customAssetCheckResult = new CustomAssetCheckResult();
		customAssetCheckResult = importAssetCheckResultFromText(1,"D:\\text1.txt");
		FileTextWriterService ftw = new FileTextWriterService();
		CustomAssetCheckData assets = new CustomAssetCheckData();
		assets.setAssets(customAssetCheckResult.getAssetsChecked());
		assets.setSelectTerms(customAssetCheckResult.getSelectTerms());
		System.out.println("path"+ftw.exportAssetCheckDataToText(assets));
		System.out.println("lrp输出AssetsChecked：" + customAssetCheckResult.getAssetsChecked().size());
		System.out.println("lrp输出AssetsNotChecked：" + customAssetCheckResult.getAssetsNotChecked().size());
		System.out.println("lrp输出SelectTerms：" + customAssetCheckResult.getSelectTerms().size());
	}
	
	/**(第二阶段)已修改..
	 * 根据assetcheckresult.txt中的文件内容，返回盘点的结果对象
	 * @param flag 0:读取后清空，1:读取后不清空
	 * @param textPath:文件路径
	 * @return
	 * @throws IOException
	 */
	public CustomAssetCheckResult importAssetCheckResultFromText(int flag,String textPath) throws Exception{
		
		//包含已盘漏盘查询条件异常列表的对象
		CustomAssetCheckResult assetCheckResult = new CustomAssetCheckResult();
		//保存路径为全局变量,使其他函数可用.
		this.textPath = textPath;
		//读取文件中的内容
		String resultStr = getTextContent(textPath);
		//如果flag是0,清空文件内的内容
		if(flag == 0){
			clearFile(textPath);
		}
		
		//测试合法性,如果resultStr中不含"#"则返回"",如果符合验证规则.则把resultStr的值赋值给resultStrTemp.
		String resultStrTemp = doCheck(resultStr);
		
		if(!resultStrTemp.contains("$"))
		{
			resultStrTemp = "$"+resultStrTemp;
		}
		
		if(resultStrTemp != null && resultStrTemp.length() > 0){
			resultStr = resultStrTemp;
		}else {
			return assetCheckResult;
		}
		if(resultStr != null && resultStr.length() > 0){
			
		}else{
			return assetCheckResult;
		}
		
		//获取已盘资产列表
		List<Asset> assetsChecked = new ArrayList<>();
		assetsChecked = getAssetsChecked(getSpecifiedSubString(resultStr,ASSETSCHECKED));
		System.out.println("lrp输出assetsChecked.size()："+ assetsChecked.size());
		
		
		//获取漏盘资产列表
		List<Asset> assetsNotChecked = new ArrayList<>();
		assetsNotChecked = getAssetsNotChecked(getSpecifiedSubString(resultStr,ASSETSNOTCHECKED));
		
		//获取查询条件列表
		List<String> selectTerms = new ArrayList<>();
		selectTerms = getSelectTerms(getSpecifiedSubString(resultStr,SELECTTERMS));
		//获取异常条件列表
		List<Asset> assetsStateWrong = new ArrayList<>();
		assetsStateWrong = getAssetsStateWrong(getSpecifiedSubString(resultStr,ASSETSSTATEWRONG));
		
		//拼接
		assetCheckResult.setAssetsChecked(assetsChecked);
		assetCheckResult.setAssetsNotChecked(assetsNotChecked);
		assetCheckResult.setSelectTerms(selectTerms);
		assetCheckResult.setAssetsStateWrong(assetsStateWrong);
		
		return assetCheckResult;
	}
	
	public void clearFile(String file) throws FileNotFoundException{
		//deleteFile(path);
        FileOutputStream out=new FileOutputStream(file); 
        
        try {
			out.write("".getBytes("utf-8"));
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
	}
	
	/**(第二阶段)已修改
	 * 根据assetcheckresult.txt中的文件内容，返回盘点的结果对象
	 * @return
	 * @throws Exception 
	 */
	public CustomAssetCheckResult importAssetCheckResultFromText() throws Exception{
		CustomAssetCheckResult assetCheckResult = new CustomAssetCheckResult();
		
		//读取文件中的内容
		String resultStr = getTextContent(textPath);
		
		//测试合法性
		String resultStrTemp = doCheck(resultStr);
		
		if(resultStrTemp != null && resultStrTemp.length() > 0){
			resultStr = resultStrTemp;
		}else {
			return assetCheckResult;
		}
		if(resultStr != null && resultStr.length() > 0){
			
		}else{
			return assetCheckResult;
		}
		
		//获取已盘资产列表
		List<Asset> assetsChecked = new ArrayList<>();
		assetsChecked = getAssetsChecked(getSpecifiedSubString(resultStr,ASSETSCHECKED));
		System.out.println("lrp输出assetsChecked.size()："+ assetsChecked.size());
		
		
		//获取漏盘资产列表
		List<Asset> assetsNotChecked = new ArrayList<>();
		assetsNotChecked = getAssetsNotChecked(getSpecifiedSubString(resultStr,ASSETSNOTCHECKED));
		
		//获取查询条件列表
		List<String> selectTerms = new ArrayList<>();
		selectTerms = getSelectTerms(getSpecifiedSubString(resultStr,SELECTTERMS));
		
		//获取异常条件列表
		List<Asset> assetsStateWrong = new ArrayList<>();
		assetsStateWrong = getAssetsStateWrong(getSpecifiedSubString(resultStr,ASSETSSTATEWRONG));
		
		//拼接
		assetCheckResult.setAssetsChecked(assetsChecked);
		assetCheckResult.setAssetsNotChecked(assetsNotChecked);
		assetCheckResult.setSelectTerms(selectTerms);
		assetCheckResult.setAssetsStateWrong(assetsStateWrong);
		
		return assetCheckResult;
	}
	
	@Test
	public void testDoCheck(){
		String testStr = "00000009#030400000000089[茶几!030400000000089!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]#030400000000034[茶几!030400000000034!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]$030400000000088[茶几!030400000000088!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]#030400000000034[茶几!030400000000034!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]#030400000000089[茶几!030400000000089!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]@资产类型：保险柜@使用状态：在用@状态：正常{030400000000089[使用部门:信息中心&使用人:李铭]#030400000000034[使用人:孙浩]}";
		System.out.println("lrp输出doCheck：" + doCheck(testStr));
	}
	
	public String doCheck(String resultStr){
		String result = "";
		int jing = resultStr.indexOf("#");
		int meijin = resultStr.indexOf("$");
		String[] resultStrings ;
		if(meijin>jing&&jing!=-1)
		{
			resultStrings = new String[2];
			resultStrings[0] = resultStr.substring(0,jing);
			resultStrings[1]=resultStr.substring(jing+1,resultStr.length());
		}else
		{
			resultStrings = new String[2];
			resultStrings[0] = resultStr.substring(0,meijin);
			resultStrings[1]=resultStr.substring(meijin+1,resultStr.length());
		}
		
		if(resultStrings.length <= 1){
			result = "";
			return result;
		}
		
		String checkNumtemp = resultStrings[1].substring(0,resultStrings[1].indexOf("["));
		String checkNum="";
		for (int i = 0; i < checkNumtemp.length(); i=i+2) {
			checkNum=checkNum+checkNumtemp.charAt(i);
		}
		if(resultStrings[0].length()>8)
		{
			resultStrings[0]=resultStrings[0].substring(1,resultStrings[0].length());
		}
		//验证,验证成功则返回截去验证码后的结果
		if(resultStrings[0].trim().equals(checkNum.trim())){
			result = resultStrings[1];
		}
		return result;
	}
	
//	@Test
//	public void testGetSpecifiedSubString(){
//		String result = getSpecifiedSubString("00000009#030400000000089[茶几!030400000000089!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]#030400000000034[茶几!030400000000034!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]$030400000000088[茶几!030400000000088!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]@资产类型：保险柜@使用状态：在用@状态：正常{030400000000089[使用部门:信息中心&使用人:李铭]#030400000000034[使用人:孙浩]}"
//				,"selectTerms");
//		System.out.println(result);
//	}
	/**
	 * 获取指定的子字符串
	 * @param key 截去验证后的字符串.
	 * @param caseKey
	 * @return
	 */
	public String getSpecifiedSubString(String key,String caseKey){
		//key:
		//assetsChecked：已盘
		//assetsNotChecked：漏盘
		//selectTerms：查询条件
		//assetsStateWrong:异常
		String valueString = "";
		
		String assetsCheckedString = ""; //已盘
		String assetsNotCheckedString = ""; //漏盘
		String selectTermsString = ""; //查询条件
		String assetsStateWrongString="";//异常
		
		if(key != null && key.length() > 0 && key.contains("$") && key.contains("@")){
			
		}
		else{
			System.out.println("lrp输出 异常：key值不合法1");
			valueString = "";
			return valueString;
		}
		
		String str1 = ""; // $符号之前的内容
		String str2 = ""; //$符号之后的内容

		int dnum = key.indexOf("$");
		
		
		str1 = key.substring(0,dnum);
		str2 =key.substring(dnum + 1,key.length());
		
		//取得漏盘字符串
		assetsNotCheckedString = str1;
		
		int num = str2.indexOf("@");
		int num1 = str2.indexOf("{");
		int num2 = str2.indexOf("}");
		
		//取得已盘字符串
		assetsCheckedString  = str2.substring(0,num);
		//取得查询条件字符串
		selectTermsString = str2.substring(num,num1);
		//取得异常字符串
		if(num1+1==num2)
		{
			assetsStateWrongString="";
		}
		else
		{
			assetsStateWrongString = str2.substring(num1+1,num2);
		}
		/*System.out.println("lrp输出assetsNotCheckedString：" + assetsNotCheckedString);
		System.out.println("lrp输出assetsCheckedString：" + assetsCheckedString);
		System.out.println("lrp输出selectTermsString：" + selectTermsString);*/
	
		switch (caseKey) {
		case "assetsNotChecked":
			valueString = assetsNotCheckedString;
			break;
		case "assetsChecked":
			valueString = assetsCheckedString;
			break;
		case "selectTerms":
			valueString = selectTermsString;
			break;
		case "assetsStateWrong":
			if(assetsStateWrongString.length()<1)
			{
				valueString="!@!!";
			}
			else
			{
				valueString = assetsStateWrongString+"!@!!"+assetsCheckedString;
			}
			break;
		default:
			break;
		}
		
		return valueString;
	}
	
	
	
	/**(第二阶段)已修改
	 * 获取查询条件列表
	 * @param resultStr
	 * @return
	 */
	public List<String> getSelectTerms(String resultStr){
		List<String> selectTerms = new ArrayList<>();
		
		String[] terms = resultStr.split("@");
		for(int i = 1;i < terms.length; i ++){
			selectTerms.add(terms[i]);
		}
		
		return selectTerms;
	}
	
	public List<Asset> getAssetsStateWrong(String resultStr) throws Exception
	{
		List<Asset> assets = new ArrayList<Asset>();
		
		if(resultStr != null && resultStr.length() > 0 ){
			String wrongAssets[] = resultStr.split("!@!!");
			if(wrongAssets.length!=0)
			{
				String wrongAssetInfos[] = wrongAssets[0].split("#");
				String wrongAssetData[] = wrongAssets[1].split("#");
				List<String> wrongCodeOfAssets = new ArrayList<String>();
				
				
				List<String> codeOfAssets = new ArrayList<String>();
		
				for (int i = 0; i < wrongAssetInfos.length; i++) {
					for(int j=0;j<wrongAssetData.length;j++)
					{
						if(wrongAssetInfos[i].substring(0,wrongAssetInfos[i].indexOf("[")).equals(wrongAssetData[j].substring(0,wrongAssetData[j].indexOf("["))))
						{
							codeOfAssets.add(wrongAssetInfos[i].substring(0,wrongAssetInfos[i].indexOf("[")));
							if(wrongAssetInfos[i].contains("&&"))
							{
								int num1 = wrongAssetInfos[i].indexOf("使用人:");
								int num2 = wrongAssetInfos[i].indexOf("]");
								String userinfo = wrongAssetInfos[i].substring(num1+4,num2);
								num1 = wrongAssetInfos[i].indexOf("使用部门:");
								num2 = wrongAssetInfos[i].indexOf("&&");
								String departmentInfo= wrongAssetInfos[i].substring(num1+5,num2);
								String dataInfo[] = wrongAssetData[j].split("!");
								dataInfo[6]=departmentInfo;
								dataInfo[7]=userinfo;
								wrongAssetData[j]="";
								for(int k=0;k<dataInfo.length;k++)
								{
									wrongAssetData[j]+=dataInfo[k]+"!";
								} 
								wrongAssetData[j]=(String) wrongAssetData[j].subSequence(0, wrongAssetData[j].length()-1);
								
							}else
							{
								int num1 = wrongAssetInfos[i].indexOf("使用人:");
								int num2 = wrongAssetInfos[i].indexOf("]");
								String info = wrongAssetInfos[i].substring(num1+4,num2);
								String dataInfo[] = wrongAssetData[j].split("!");
								dataInfo[7]=info;
								wrongAssetData[j]="";
								for(int k=0;k<dataInfo.length;k++)
								{
									wrongAssetData[j]+=dataInfo[k]+"!";
								} 
								wrongAssetData[j]=(String) wrongAssetData[j].subSequence(0, wrongAssetData[j].length()-1);
							}
						}
					}
				
				
				}
				for (int i = 0; i < wrongAssetData.length; i++) {
						if(codeOfAssets.contains((wrongAssetData[i].substring(0, wrongAssetData[i].indexOf("[")))))
						{
							assets.add(getAssetByCode(wrongAssetData[i]));
						}
				}
			}
		}
		
		
		return assets;
	}
	
	
	/**(第二阶段)已修改
	 * 获取已盘资产列表
	 * @param resultStr
	 * @return
	 * @throws ParseException 
	 */
	public List<Asset> getAssetsNotChecked(String resultStr) throws ParseException{
		List<Asset> assetsNotChecked = new ArrayList<>();
		System.out.println("lrp输出getAssetsNotChecked:resultStr:" + resultStr);
		if(resultStr != null && resultStr.length() > 0 && (!resultStr.contains("@"))){
			String[] codes = resultStr.split("#");
			for(int i = 0;i < codes.length; i ++){
				Asset asset = new Asset();
				asset = getAssetByCode(codes[i]);
				assetsNotChecked.add(asset);
			}
		}
		
		
		return assetsNotChecked;
	}
	
	/**(第二阶段)已修改
	 * 获取漏盘资产列表
	 * @param resultStr
	 * @return
	 * @throws ParseException 
	 */
	public List<Asset> getAssetsChecked(String resultStr) throws ParseException{
		List<Asset> assetsChecked = new ArrayList<>();
		System.out.println("lrp输出assetsChecked.size()1："+ assetsChecked.size());
		System.out.println("lrp输出getAssetsChecked:resultStr:" + resultStr);
		System.out.println("lrp输出getAssetsChecked:resultStr.length():" + resultStr.length());
		if(resultStr != null && resultStr.length() > 0 && (!resultStr.contains("@"))){
			String[] codes = resultStr.split("#");
			for(int i = 0;i < codes.length; i ++){
				Asset asset = new Asset();
				asset = getAssetByCode(codes[i]);
				assetsChecked.add(asset);
			}
		}
		
		System.out.println("lrp输出assetsChecked.size()2："+ assetsChecked.size());
		
		return assetsChecked;
	}
	
	
/**(第二阶段)已修改
 * 把字符串转换为Asset对象.
 * @param code "030400000000034[茶几!030400000000034!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]"格式的字符串
 * @return Asset
 * @throws ParseException 
 */
	
	public Asset getAssetByCode(String code) throws ParseException{ 
		Asset asset = new Asset();
//		"030400000000034[茶几!030400000000034!架类!860!!1998-11-20!服务中心!石建强!2011-11-15!2018]";
		String aString = code;
		
		int indexOfFirstLeftbracket = aString.indexOf('[');
		int indexOfFirstRightbracket = aString.indexOf(']');
		aString = aString.substring(indexOfFirstLeftbracket+1,indexOfFirstRightbracket);
		String infoOfAssent[] = aString.split("!");
		
		if(infoOfAssent.length<10)
		{
			String temp[] = new String[10];
			for(int i=0;i<10;++i)
			{
				if(i<infoOfAssent.length)
					temp[i]=infoOfAssent[i];
				else
					temp[i]="";
			}
			infoOfAssent=temp;
		}
		
		String DATA[] = infoOfAssent[5].split("-");
		if(DATA.length==3)
		{
//			Date date = new Date();
//			SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
//			Date data5 = DateFormat.parse(infoOfAssent[5]);
//		    String dateStr=
			Date data5 = new Date();
			data5.setYear(Integer.parseInt(DATA[0]));
			data5.setMonth(Integer.parseInt(DATA[1]));
			data5.setDate(Integer.parseInt(DATA[2]));
			asset.setStartusetime(data5);
		}
		DATA = infoOfAssent[8].split("-");
		if(DATA.length==3)
		{
			Date data8 = new Date();
			data8.setYear(Integer.parseInt(DATA[0]));
			data8.setMonth(Integer.parseInt(DATA[1]));
			data8.setDate(Integer.parseInt(DATA[2]));
			asset.setMakecardtime(data8);
		}
		asset.setName(infoOfAssent[0]);
		asset.setCode(infoOfAssent[1]);
		asset.setType(infoOfAssent[2]);
		if(!code.contains("null"))
			asset.setValue(Double.parseDouble(infoOfAssent[3]));
		else
			asset.setValue(null);
		asset.setModel(infoOfAssent[4]);
		
		asset.setUsedepartment(infoOfAssent[6]);
		asset.setUser(infoOfAssent[7]);
		
		
		asset.setGhostyear(infoOfAssent[9]);

		return asset;
	}

	
	/**
	 * 读取文件内容
	 * @param path 需要读取的txt文件路径
	 * @return 读取到的文件中全部的内容(string)
	 * @throws IOException
	 */
	public String getTextContent(String path) throws IOException {
		String result = "";
//		System.out.println("lrp输出path：" + path);
//		File file=new File(path);
//        if(!file.exists()||file.isDirectory())
//            throw new FileNotFoundException();
//        FileInputStream fis=new FileInputStream(file);
//        byte[] buf = new byte[1024];
//        StringBuffer sb=new StringBuffer();
//        while((fis.read(buf))!=-1){
//            sb.append(new String(buf,"UTF-8"));    
//            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
//        }
//        result = sb.toString();
//        System.out.println("getTextContent输出result：" + result);
//        
        
        List<String> lines=new ArrayList<String>();  
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));  
        String line = null;  
        while ((line = br.readLine()) != null) {  
        	result+=line;
        }  
        br.close();  
		return result;
	}
	
	/*public boolean deleteFile(String sPath) {  
	    Boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    return flag;  
	}  */

	
	@Test
	public void testGetTextContent() throws IOException{
		String path = "D:\\text1.txt";
		String result = "";
		System.out.println("lrp输出path：" + path);
		File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        FileInputStream fis=new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuffer sb=new StringBuffer();
        while((fis.read(buf))!=-1){
            sb.append(new String(buf,"UTF-8"));    
            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
        }
        result = sb.toString();
        System.out.println("lrp输出result：" + result);
	}
	
	@Test
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
	
	@Test
	public void testGetTimeStamp() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String dateString = "2014/10/11 14:50:11";
        Date date = df.parse(dateString);
         long s=date.getTime();
         System.out.println("lrp输出timestamp：" + s/1000);
	}

}
