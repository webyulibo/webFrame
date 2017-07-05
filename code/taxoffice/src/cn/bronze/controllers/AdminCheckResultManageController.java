package cn.bronze.controllers;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;























//import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;
import cn.bronze.entities.CheckResult;
import cn.bronze.entities.CheckResultDetail;
import cn.bronze.entities.CustomExcelObject;
import cn.bronze.services.AdminCheckResultMapperService;
import cn.bronze.services.FileExcelWriterService;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceHasClosedException;
import cn.bronze.util.file.FileDownload;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@RequestMapping("/admincheckresultmanagecontroller")
@Controller
public class AdminCheckResultManageController {

	@Autowired
	private AdminCheckResultMapperService adminCheckResultMapperService;
	
	@Autowired
	private FileExcelWriterService fileExcelWriterService;
	
	//调出pdlsjlzp视图
//	@RequestMapping("/showgetcheckresultsbyselecttermswithpage")
//	public ModelAndView showgetcheckresultsbyselecttermswithpage()
//			throws Exception {
//		// 返回ModelAndView
//		ModelAndView modelAndView = new ModelAndView();		
//		modelAndView.setViewName("assetadmin/pandianqingcha/jilu/pdlsjlzp"); 
//		return modelAndView;		
//	}
	//返回pdlsjlzp视图
		@RequestMapping("/backgetcheckresultsbyselecttermswithpage")
		public ModelAndView backgetcheckresultsbyselecttermswithpage(HttpSession session)
				throws Exception {
			ModelAndView modelAndView = new ModelAndView();	
//			int currentPage=1;
			String checktimestart=(String) session.getAttribute("checktimestart");
			String checktimeend=(String) session.getAttribute("checktimeend");
			String checkpeople=(String) session.getAttribute("checkpeople");
			String resultnum=(String) session.getAttribute("resultnum");
     		String str=session.getAttribute("currentPage").toString();
//	if(str==""||str==null||str.isEmpty())
//			{
//				currentPage=1;
//			}
//			if(str!=""&&str!=null&&str.isEmpty()){
//			    currentPage=Integer.parseInt(str);
//			}
     		int currentPage=Integer.parseInt(str);
			java.util.Date dateChecktimestart=null;
			java.util.Date dateChecktimeend=null;	
			if(!checktimestart.isEmpty()&&checktimestart!=null&&!checktimeend.isEmpty()&&checktimeend!=null){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
				dateChecktimestart =sdf.parse(checktimestart);  
				dateChecktimeend=sdf.parse(checktimeend); 
			}	
			PageParameter pageParameter = PageParameter.NewInstance(currentPage);
		    List<CheckResult> checkResultList=adminCheckResultMapperService.getCheckResultsBySelectTermsWithPage(dateChecktimestart , dateChecktimeend, checkpeople, resultnum, pageParameter ); 
			modelAndView.addObject("pager",pageParameter);
			modelAndView.addObject("checkResultList", checkResultList);	
			modelAndView.setViewName("assetadmin/pandianqingcha/jilu/pdlsjlzp"); 
			return modelAndView;	
		}
	/**
	 * 查询盘点记录列表
	 * @author 于立波
	 * @param checktimestart 起始盘点日期
	 * @param checktimeend 结束盘点日期
	 * @param checkpeople 盘点人
	 * @param resultnum 盘点编号
	 * @param currentpage 当前页数
	 * @return
	 * @throws ParseException 
	 */
	@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/showgetcheckresultsbyselecttermswithpage")
	public ModelAndView showgetcheckresultsbyselecttermswithpage(
			HttpSession session
			,@ModelAttribute(value="checktimestart") @Validated String checktimestart
			,@ModelAttribute(value="checktimeend") @Validated String checktimeend
			,@ModelAttribute(value="checkpeople") @Validated String checkpeople
			,@ModelAttribute(value="resultnum") @Validated String resultnum
			,Integer currentPage
			) throws ParseException{
		ModelAndView modelAndView = new ModelAndView();	
		session.setAttribute("checktimestart", checktimestart);
		session.setAttribute("checktimeend", checktimeend);
		session.setAttribute("checkpeople", checkpeople);
		session.setAttribute("resultnum", resultnum);
		session.setAttribute("currentPage", currentPage);
		java.util.Date dateChecktimestart=null;
		java.util.Date dateChecktimeend=null;	
		if(!checktimestart.isEmpty()&&checktimestart!=null&&!checktimeend.isEmpty()&&checktimeend!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
			dateChecktimestart =sdf.parse(checktimestart);  
			dateChecktimeend=sdf.parse(checktimeend); 
		}	
		currentPage = (currentPage!=null)?currentPage:1;
		PageParameter pageParameter = PageParameter.NewInstance(currentPage);
	    List<CheckResult> checkResultList=adminCheckResultMapperService.getCheckResultsBySelectTermsWithPage(dateChecktimestart , dateChecktimeend, checkpeople, resultnum, pageParameter ); 
		modelAndView.addObject("pager",pageParameter);
		modelAndView.addObject("checkResultList", checkResultList);	
		modelAndView.setViewName("assetadmin/pandianqingcha/jilu/pdlsjlzp"); 
		return modelAndView;	
	}
	/**
	 * 查询盘点记录详情
	 * @author 于立波
	 * @param resultnum 盘点编号
	 * @param currentpage 当前页数
	 * return
	 */
//	@RequestMapping("/getassetdetailbyresultnumwithpage")
//	public ModelAndView getassetdetailbyresultnumwithpage(
//			@ModelAttribute(value="resultnum") @Validated String resultnum
//			,Integer currentPage){
//		ModelAndView modelAndView = new ModelAndView();	
//		//TODO 
//		currentPage = (currentPage!=null)?currentPage:1;
//		PageParameter pageParameter = PageParameter.NewInstance(currentPage);
//		List<List<Asset>> assetList=adminCheckResultMapperService.getAssetDetailByResultnumWithPage(resultnum, pageParameter);
//		//List<List<Asset>> assetList=adminCheckResultMapperService.getAssetDetailByResultnumWithPage("1234", pageParameter);
//		//根据每条Asset的code查出t_checkresultdetail中对应的result
//		List<String> resultList=new ArrayList<>();
//		if(assetList!=null)
//{
//	    for(int i=0;i<assetList.size();i++){
//	    	String strResult=adminCheckResultMapperService.getCheckResultsByCode(assetList.get(i).get(0).getCode());
//	    	resultList.add(strResult);															
//	    }
// }
//	    modelAndView.addObject("pager",pageParameter);
//		modelAndView.addObject("assetList",  assetList);
//		modelAndView.addObject("resultList",  resultList);
//		modelAndView.setViewName("assetadmin/pandianqingcha/jilu/pdlsjlxqzp"); 
//		return modelAndView;	
//	}
	//加test的为第一版本后新测试的
		@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/getassetdetailbyresultnumwithpage")
	public ModelAndView getassetdetailbyresultnumwithpage(
			@ModelAttribute(value="resultnum") @Validated String resultnum
			,Integer currentPage
			,HttpSession session1){
			session1.setAttribute("currentPage", currentPage);
		ModelAndView modelAndView = new ModelAndView();	
		//TODO 
		currentPage = (currentPage!=null)?currentPage:1;
		PageParameter pageParameter = PageParameter.NewInstance(currentPage);
		List<List<Asset>> assetList=adminCheckResultMapperService.getAssetDetailByResultnumWithPage(resultnum, pageParameter);
		//List<List<Asset>> assetList=adminCheckResultMapperService.getAssetDetailByResultnumWithPage("1234", pageParameter);
		 List<CheckResultDetail>  checkResultDetailList=adminCheckResultMapperService.getCheckResultsByResultnum(resultnum);
		List<String> resultList=new ArrayList<>();	
		if(checkResultDetailList!=null)
{
	    for(int i=0;i<checkResultDetailList.size();i++){
	    	String strResult=checkResultDetailList.get(i).getResult();
	    	resultList.add(strResult);															
	    }
 }	
		List<Asset> assetN=new ArrayList<>();	
		for(int i=0;i<assetList.size();i++){
			if(assetList.get(i).size()!=0){
			Asset asset=assetList.get(i).get(0);
			assetN.add(asset);
			}
		}
		if(assetN.size()!=0){
			modelAndView.addObject("pager",pageParameter);
		}
		if(assetN.size()==0){
			modelAndView.addObject("pager","");
		}
	    //modelAndView.addObject("assetList",  assetList);
	    modelAndView.addObject("assetN",  assetN);
		modelAndView.addObject("resultList",  resultList);
		modelAndView.setViewName("assetadmin/pandianqingcha/jilu/pdlsjlxqzp"); 
		return modelAndView;	
	}
	/**
	 * @author 于立波
	 * 查询备注
	 * 	 param  resultnum
	 *   return
	 * @throws IOException 
	 */
		@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/getcheckresultsremarkbyresultnum")
	public void getcheckresultsremarkbyresultnum(
			String resultnum,
			 HttpServletResponse response
			) throws IOException{
		        JSONObject jsonObject = new JSONObject();
		        String strRemark=adminCheckResultMapperService.getCheckResultsRemarkByResultnum(resultnum);
		        if(strRemark!=null){
					jsonObject.put("msg", strRemark);
				}
		        else{
					jsonObject.put("msg", "相关信息不存在！");
		    }
				JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * @author 于立波
	 * 导出查询结果到excel
	 * 	 param  
	 * @throws IOException 
	 */
	@RequestMapping("/exportchectresulttuexcel")
	public void exportchectresulttuexcel(
			  String checktimestart
			, String checktimeend
			, String checkpeople
			, String resultnum
			, HttpServletResponse response
			) throws ParseException, ResourceHasClosedException, ParamCanNotBeNullException, IOException{
		//JSONObject jsonObject = new JSONObject();
		java.util.Date dateChecktimestart=null;
		java.util.Date dateChecktimeend=null;		
		if(!checktimestart.isEmpty()&&checktimestart!=null&&checktimestart!=""&&!checktimeend.isEmpty()&&checktimeend!=null&&checktimeend!=""){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
			dateChecktimestart =sdf.parse(checktimestart);  
			dateChecktimeend=sdf.parse(checktimeend); 
		}
		List<CheckResult> checkResultList=adminCheckResultMapperService.getCheckResultsBySelectTerms(dateChecktimestart, dateChecktimeend, checkpeople,resultnum);
		CustomExcelObject<CheckResult, String> excelObject = new CustomExcelObject<CheckResult,String>(); 
		excelObject.setClazz(CheckResult.class);
		//excelObject.setFile(new File("E://资产信息查询结果详情.xls"));
		excelObject.setObjects(checkResultList);
		fileExcelWriterService.exportToExcel(excelObject);
		File  file = excelObject.getFile();
		FileDownload.download(response, file, "资产盘点信息.xls");
		//jsonObject.put("msg", "导出成功！");
		//JsonResponse.PrintJsonOne(response, jsonObject);
	}
	@RequiresPermissions(value={"sysauth","assetauth"},logical=Logical.OR)
	@RequestMapping("/exportchectresulttuexcelbycheckbox")
	public void exportchectresulttuexcelbycheckbox(
                String s
              , HttpServletResponse response
			) throws ParseException, ResourceHasClosedException, ParamCanNotBeNullException, IOException{
        System.out.println(s);
        String[] resultnumList = s.split(",");
		List<CheckResult> checkResultList=adminCheckResultMapperService.getCheckResultsByCheckbox(resultnumList);
		CustomExcelObject<CheckResult, String> excelObject = new CustomExcelObject<CheckResult,String>(); 
		excelObject.setClazz(CheckResult.class);
		excelObject.setObjects(checkResultList);
		fileExcelWriterService.exportToExcel(excelObject);
		File  file = excelObject.getFile();
		FileDownload.download(response, file, "资产盘点信息.xls");
	}
	@RequiresPermissions(value={"sysauth","assetauth"},logical=Logical.OR)
	@RequestMapping("/exportassetresulttuexcel")
	public void exportassetresulttuexcel(
			String resultnum
		    ,HttpServletResponse response
			) throws ResourceHasClosedException, ParamCanNotBeNullException {
		//JSONObject jsonObject = new JSONObject();
		List<List<Asset>> assetList=adminCheckResultMapperService.getAssetDetailByResultnum(resultnum); 
		List<Asset> list=new ArrayList();
		for(int i=0;i<assetList.size();i++){
			list.add(assetList.get(i).get(0));
		}
	   CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
	   excelObject.setClazz(Asset.class);
	  // excelObject.setFile(new File("E://资产信息详情.xls"));
     	excelObject.setObjects(list);
		fileExcelWriterService.exportToExcel(excelObject);
		File  file = excelObject.getFile();
		FileDownload.download(response, file, "资产详情信息.xls");
		//jsonObject.put("msg", "导出成功！");
		//JsonResponse.PrintJsonOne(response, jsonObject);
	}
}
