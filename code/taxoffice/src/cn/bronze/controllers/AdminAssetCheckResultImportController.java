package cn.bronze.controllers;

import java.io.File;
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

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetCustomUnusual;
import cn.bronze.entities.CheckResult;
import cn.bronze.entities.CheckResultDetail;
import cn.bronze.entities.CheckResultDetailAndResult;
import cn.bronze.entities.CustomAssetCheckResult;
import cn.bronze.entities.CustomAssetCheckResultWithDetail;
import cn.bronze.entities.CustomExcelObject;
import cn.bronze.log.Log;
import cn.bronze.services.AdminAssetCheckResultImportService;
import cn.bronze.services.FileExcelWriterService;
import cn.bronze.services.FileTextReaderService;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceHasClosedException;
import cn.bronze.util.file.FileDownload;
import cn.bronze.util.json.JsonResponse;

@RequestMapping("/adminassetcheckresultimportcontroller")
@Controller
public class AdminAssetCheckResultImportController {
	
	@Autowired
	private AdminAssetCheckResultImportService adminAssetCheckResultImportService;
	
	@Autowired
	private FileTextReaderService fileTextReaderService;
	
	@Autowired
	private FileExcelWriterService fileExcelWriterService;
	
	/**
	 * 刘仁鹏
	 * 显示“盘点结果导入”页面
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth"},logical=Logical.OR)
	@RequestMapping("/showstartpage")
	public ModelAndView showstartpage(HttpSession session){		
		ModelAndView modelAndView = new ModelAndView();
		
		if(session.getAttribute("assetCustomUnusuals")!=null){
			session.removeAttribute("assetCustomUnusuals");
		}

		modelAndView.setViewName("/assetadmin/pandianqingcha/daoru/indexlmy");
		
		
		return modelAndView;		
	}
	
	/**
	 * 
	 * 将导入的资产信息显示到页面上,并将异常信息添加到session中，供导出数据时使用
	 * @param filePath上传文件的路径
	 * 
	 * */
	
	@RequestMapping("/importassetcheckresulttotextshow")
	public ModelAndView importassetcheckresulttotextshow(String filePath,HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		
		//获取tomcat下webapps的地址
		System.out.println(getClass().getResource("/"));
		String classesPath=getClass().getResource("/").getPath();
		System.out.println(classesPath);
		int subIndex=classesPath.indexOf("/taxoffice");
		classesPath=classesPath.substring(0, subIndex);
		System.out.println(classesPath);
		//System.out.println(System.getProperty("user.dir").replace("bin", "webapps"););
		System.out.println();
		filePath=classesPath+filePath;
		
		CustomAssetCheckResult customAssetCheckResult = new CustomAssetCheckResult();
		try {
			try {
				customAssetCheckResult=fileTextReaderService.importAssetCheckResultFromText(1, filePath);
			} catch (Exception e) {
				modelAndView.addObject("errormsg", "导入失败，请检查导入文件是否正确");
				modelAndView.setViewName("/assetadmin/pandianqingcha/daoru/indexlmy");
				// TODO Auto-generated catch block
				e.printStackTrace();
				return modelAndView;
			}
			
			//获取已盘的数据
			List<Asset> assetsChecked=new ArrayList<>();
			//获取漏盘的数据
			List<Asset> assetsNotChecked=new ArrayList<>();
			//获取查询条件，添加到备注里边
			List<String> selectTerms=new ArrayList<>();
			//获取异常信息
			List<Asset> assetsStateWrong=new ArrayList<>();
			
			assetsChecked=customAssetCheckResult.getAssetsChecked();
			
			assetsNotChecked=customAssetCheckResult.getAssetsNotChecked();
			
			selectTerms=customAssetCheckResult.getSelectTerms();
			
			assetsStateWrong=customAssetCheckResult.getAssetsStateWrong();
			
			String selectTermStr="";
			if(selectTerms!=null){
				for (int i = 0; i < selectTerms.size(); i++) {
					if(i==(selectTerms.size()-1)){
						selectTermStr+=selectTerms.get(i);
					}
					else{
						selectTermStr+=selectTerms.get(i)+"，";
					}
			}									
			}
			
			List<AssetCustomUnusual> assetCustomUnusuals=new ArrayList<>();
			
			//获取原使用人
//			List<String> originaluser=new ArrayList<>();
//			List<String> originaldepartment=new ArrayList<>();
			if(assetsStateWrong!=null&&assetsStateWrong.size()>0){
				for (int i = 0; i < assetsStateWrong.size(); i++) {
					for (int j = 0; j < assetsChecked.size(); j++) {
						if(assetsStateWrong.get(i).getCode().equals(assetsChecked.get(j).getCode())){
							
							AssetCustomUnusual assetCustomUnusual=new AssetCustomUnusual();
							//封装成异常信息集合
							assetCustomUnusual.setCode(assetsStateWrong.get(i).getCode());
							assetCustomUnusual.setName(assetsStateWrong.get(i).getName());
							assetCustomUnusual.setOriginaluser(assetsChecked.get(j).getUser());
							assetCustomUnusual.setUser(assetsStateWrong.get(i).getUser());
							assetCustomUnusual.setOriginaldepartment(assetsChecked.get(j).getUsedepartment());
							assetCustomUnusual.setUsedepartment(assetsStateWrong.get(i).getUsedepartment());
							assetCustomUnusual.setUnusualremark(assetsStateWrong.get(i).getRemark());
							
							assetCustomUnusuals.add(assetCustomUnusual);
//							originaluser.add(assetsChecked.get(j).getUser());
//							originaldepartment.add(assetsChecked.get(j).getKeepdepartment());
						}
						
					}
				}
			}
			
			
			int totalInfoCount=0;
			//判断已盘信息和未盘信息总数
			if(assetsChecked!=null&&assetsChecked.size()>0){
				totalInfoCount=assetsChecked.size();
				if(assetsNotChecked!=null&&assetsNotChecked.size()>0)
					totalInfoCount+=assetsNotChecked.size();
			}
			else if(assetsNotChecked!=null&&assetsNotChecked.size()>0)
				totalInfoCount=assetsNotChecked.size();
			
			
			//用于显示已盘与未盘的数据集合
			List<Asset> assetsCheckedInNumber=new ArrayList<>();
			List<Asset> assetsNotCheckedInNumber=new ArrayList<>();
			if(totalInfoCount>20){
				if(assetsChecked.size()<=10){
					assetsCheckedInNumber=assetsChecked;
				}
				else{
					for (int i = 0; i <10; i++) {
						assetsCheckedInNumber.add(assetsChecked.get(i));
					}
				}
				if(assetsNotChecked.size()<=10){
					assetsNotCheckedInNumber=assetsNotChecked;
				}
				else{
					for (int i = 0; i <10; i++) {
						assetsNotCheckedInNumber.add(assetsNotChecked.get(i));
					}
				}
				
			}
			else{
				assetsCheckedInNumber=assetsChecked;
				assetsNotCheckedInNumber=assetsNotChecked;
			}
			
			
			selectTermStr=selectTermStr.trim();
			
			
			//字符串第一个为逗号，去除第一个逗号
			int indexdou=selectTermStr.indexOf('，');
			if(indexdou==0){
				selectTermStr=selectTermStr.substring(indexdou+1);
			}
			
			//char maohao=selectTermStr[selectTermStr.le]
			//如果字符串的最后一个为冒号，则去除前边的查询条件
			int lastcolon=selectTermStr.lastIndexOf('：');
			
			System.out.println(selectTermStr.length());
			if(lastcolon==selectTermStr.length()-1){
				System.out.println(selectTermStr.length());
				int lastdou=selectTermStr.indexOf('，');
				selectTermStr=selectTermStr.substring(0, lastdou); 
						
			}
			
			
			//selectTerms=customAssetCheckResult.getSelectTerms();
			
			
			if(totalInfoCount>20){
				modelAndView.addObject("message", "盘点数据总数超过20条，提交后请到盘点历史记录中查看此次盘点详情");
			}
			//将异常信息保存到session中
			session.setAttribute("assetCustomUnusuals", assetCustomUnusuals);
			
			
			modelAndView.addObject("filePath", filePath);
			modelAndView.addObject("assetsCheckeds", assetsCheckedInNumber);
			modelAndView.addObject("assetsNotCheckeds",assetsNotCheckedInNumber);
			modelAndView.addObject("selectTermStr", selectTermStr);
			modelAndView.addObject("assetCustomUnusuals",assetCustomUnusuals);
			modelAndView.setViewName("/assetadmin/pandianqingcha/daoru/indexlmy");
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("errormsg", "导入失败，请检查导入文件是否正确");
			modelAndView.setViewName("/assetadmin/pandianqingcha/daoru/indexlmy");
			e.printStackTrace();
		}
		
		
		return modelAndView;
	}
	
	
	@RequestMapping("/importassetcheckresulttotext")
	public void importassetcheckresulttotext(String resultnum,String checkpeople,String remark,String filePath,HttpServletResponse response){
		//ModelAndView modelAndView = new ModelAndView();

		CustomAssetCheckResult customAssetCheckResult = new CustomAssetCheckResult();
		System.out.println("lrp输出：是否执行到1");
		try {
			customAssetCheckResult = fileTextReaderService.importAssetCheckResultFromText(1, filePath);

			System.out.println("lrp输出：是否执行到2");
			
			//定义一个CustomAssetCheckResultWithDetail用于封装相应的信息，作为参数进行保存
			CustomAssetCheckResultWithDetail customAssetcheckResultWithDetail=new CustomAssetCheckResultWithDetail();
			
			//获取漏盘的数据
			List<Asset> assetsChecked=new ArrayList<>();
			List<Asset> assetsNotChecked=new ArrayList<>();
			
			assetsChecked=customAssetCheckResult.getAssetsChecked();
			assetsNotChecked=customAssetCheckResult.getAssetsNotChecked();
			
			//设置查询结果
			CheckResult checkResult=new CheckResult();
			checkResult.setResultnum(resultnum);
			checkResult.setCheckpeople(checkpeople);
			checkResult.setRemark(remark);
			Date checktime=new Date();
			checkResult.setChecktime(checktime);
			
				
			//封装结果详情，code来自CustomAssetCheckData类中asset中的code
			//盘点编号来自传过来的参数
			//result根据遍历的是漏盘集合还是已盘集合
			
			List<CheckResultDetail> checkResultDetails=new ArrayList<>();
			
			int status=0;
			
			if(assetsNotChecked!=null&&assetsChecked!=null){
				//对漏盘的进行封装
				for (int i = 0; i < assetsNotChecked.size(); i++) {
					CheckResultDetail checkResultDetail=new CheckResultDetail();
					checkResultDetail.setCode(assetsNotChecked.get(i).getCode());
					checkResultDetail.setResultnum(resultnum);
					checkResultDetail.setResult("漏盘");
					checkResultDetails.add(checkResultDetail);
				}
				
				//对已盘的进行封装
				for (int i = 0; i < assetsChecked.size(); i++) {
					CheckResultDetail checkResultDetail1=new CheckResultDetail();
					checkResultDetail1.setCode(assetsChecked.get(i).getCode());
					checkResultDetail1.setResultnum(resultnum);
					checkResultDetail1.setResult("已盘");
					checkResultDetails.add(checkResultDetail1);
					
				}
				
				
				
				//最后封装成所需要的参数
				
				//customAsscheckResultWithDetail.setCheckResult(checkResult1);
				//customAsscheckResultWithDetail.setCheckResultDetails(checkResultDetails);
				customAssetcheckResultWithDetail.setCheckResult(checkResult);
				customAssetcheckResultWithDetail.setCheckResultDetails(checkResultDetails);
				
				
				status=adminAssetCheckResultImportService.addCheckResultAndCheckResultDetail(customAssetcheckResultWithDetail);
				
				
			}
			
			if(assetsChecked!=null&&assetsNotChecked==null){
				
				
				
				//对已盘的进行封装
				for (int i = 0; i < assetsChecked.size(); i++) {
					CheckResultDetail checkResultDetail1=new CheckResultDetail();
					checkResultDetail1.setCode(assetsChecked.get(i).getCode());
					checkResultDetail1.setResultnum(resultnum);
					checkResultDetail1.setResult("已盘");
					checkResultDetails.add(checkResultDetail1);
					
				}
				
				
				
				//最后封装成所需要的参数
				
				//customAsscheckResultWithDetail.setCheckResult(checkResult1);
				//customAsscheckResultWithDetail.setCheckResultDetails(checkResultDetails);
				customAssetcheckResultWithDetail.setCheckResult(checkResult);
				customAssetcheckResultWithDetail.setCheckResultDetails(checkResultDetails);
				
				
				status=adminAssetCheckResultImportService.addCheckResultAndCheckResultDetail(customAssetcheckResultWithDetail);
				
				
			}
			
			if(assetsChecked==null&&assetsNotChecked!=null){
				
				
				
				//对漏盘的进行封装
				for (int i = 0; i < assetsNotChecked.size(); i++) {
					CheckResultDetail checkResultDetail=new CheckResultDetail();
					checkResultDetail.setCode(assetsNotChecked.get(i).getCode());
					checkResultDetail.setResultnum(resultnum);
					checkResultDetail.setResult("漏盘");
					checkResultDetails.add(checkResultDetail);
				}
				
				
				
				//最后封装成所需要的参数
			
				customAssetcheckResultWithDetail.setCheckResult(checkResult);
				customAssetcheckResultWithDetail.setCheckResultDetails(checkResultDetails);
				status=adminAssetCheckResultImportService.addCheckResultAndCheckResultDetail(customAssetcheckResultWithDetail);				
			}

			JSONObject jsonObject=new JSONObject();
			jsonObject.put("status", status);
			JsonResponse.PrintJsonOne(response, jsonObject);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	//讲异常信息导出到excel
	
	@RequestMapping("importunusualassettoexcel")
	@Log(descrp="执行盘点异常信息导入Excel操作",type="系统管理权限，资产管理权限")
	public void importunusualassettoexcel(HttpSession session,HttpServletResponse response){
		
		List<AssetCustomUnusual> assetCustomUnusuals=new ArrayList<>();
		assetCustomUnusuals=(List<AssetCustomUnusual>) session.getAttribute("assetCustomUnusuals");
	 	//session.removeAttribute("assetCustomUnusuals");	 
	 	
		CustomExcelObject<AssetCustomUnusual, String> excelObject = new CustomExcelObject<AssetCustomUnusual,String>(); 
		excelObject.setClazz(AssetCustomUnusual.class);
		//excelObject.setFile(new File("E://资产信息查询结果详情.xls"));
		excelObject.setObjects(assetCustomUnusuals);
		
		try {
			fileExcelWriterService.exportToExcel(excelObject);
		} catch (ResourceHasClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParamCanNotBeNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File  file = excelObject.getFile();
		FileDownload.download(response, file, "资产盘点异常信息.xls");
		
	}
	
	
}
