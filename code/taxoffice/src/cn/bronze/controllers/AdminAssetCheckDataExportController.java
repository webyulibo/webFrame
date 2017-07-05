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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetCustom;
import cn.bronze.entities.AssetType;
import cn.bronze.entities.CustomAssetCheckData;
import cn.bronze.entities.DepartmentWithUserMessage;
import cn.bronze.log.Log;
import cn.bronze.services.AdminAssetCheckDataExportService;
import cn.bronze.services.AdminAssetTypeService;
import cn.bronze.services.AdminDepartmentService;
import cn.bronze.services.AdminUserManagerService;
import cn.bronze.services.BaseAssetServcie;
import cn.bronze.services.FileTextWriterService;
import cn.bronze.util.file.FileDownload;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;
import cn.bronze.util.spring.MAVUtil;

@RequestMapping("/adminassetcheckdataexportcontroller")
@Controller
public class AdminAssetCheckDataExportController {

	@Autowired
	private AdminAssetCheckDataExportService adminAssetCheckDataExportService;
	 
	@Autowired
	private FileTextWriterService fileTextWriterService;
	
	@Autowired
	private AdminDepartmentService adminDepartmentService;
	
	@Autowired
	private AdminUserManagerService adminUserManagerService;
	
	/***
	 * 陈铮
	 * 
	 * 资产盘点清查导出查询页面
	 * */
	@Autowired
	private AdminAssetTypeService adminAssetTypeService;
	@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/getassetspageshow")
	public ModelAndView getassetspageshow(HttpSession session){		
		ModelAndView modelAndView=new ModelAndView();
		List<AssetType> list = adminAssetTypeService.selectFirstAssetTypeMenu();
		String useraccount=(String)session.getAttribute("usernamelog");
		String userdepnameString=adminUserManagerService.getUserByUserAccount(useraccount);
		if(list!=null&&list.size()>0){
			modelAndView.addObject("list", list);
			if(userdepnameString!=null){
				modelAndView.addObject("userdepnameString", userdepnameString);
			}
			modelAndView.setViewName("/assetadmin/pandianqingcha/daochu/pdsjdccxzp");
			return modelAndView;
		}
		else{
			return MAVUtil.getErrorModelAndView("一级菜单查询有误");
		}
	
	}
	
	@RequestMapping("/userdepnameStringToJson")
	public void userdepnameStringToJson(String userdepnameString,HttpServletResponse response){
		
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("userdepnameString", userdepnameString);
		JSONArray jsonArray=new JSONArray();
		jsonArray.add(jsonObject);
		try {
			//JsonResponse.PrintJsonOne(response, jsonObject);
			JsonResponse.PrintJsonList(response, jsonArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/***
	 * 陈铮
	  * @param AssetCustom 将查询条件封装的对象
	 * @param currentPage 当前页数
	 * @return
	 * */
	@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/getassetcheckresultwithpage")
	public ModelAndView getassetcheckresultwithpage(AssetCustom assetCustom,Integer currentPage){
		ModelAndView modelAndView=new ModelAndView();
		
		
		currentPage=(currentPage!=null)?currentPage:1;
		PageParameter page=PageParameter.NewInstance(currentPage);
		
		
		List<Asset> assets=adminAssetCheckDataExportService.getassetsbyconditionwithpage(assetCustom,page);
		
		for (int i = 0; i < assets.size(); i++) {
			System.out.println(assets.get(i).getMakecardtime());
		}
		
		modelAndView.addObject("assetCustom", assetCustom);
		modelAndView.addObject("pager", page);
		modelAndView.addObject("assets", assets);
		//System.out.println(assets.size());
		modelAndView.setViewName("/assetadmin/pandianqingcha/daochu/pdsjdcjgzp");
		return modelAndView;
		
		
	}		
	/***
	 * 刘仁鹏,陈铮
	 * 将根据”查询键“、”查询值“、”使用状态“查询到的资产列表的id拼接字符串打印到text文件中
	 * @param selectkey
	 * @param selectvalue
	 * @param usestate
	 */
	
	@RequestMapping("/exportassetcheckdatatotext")
	public void exportassetcheckdatatotext(AssetCustom assetCustom,HttpServletResponse response){

		String selectkey="";
		String usestate="";
		String state="";
		
		List<Asset> assets=adminAssetCheckDataExportService.getassetsbycondition(assetCustom);
		
		
		List<String> selectTerms=new ArrayList<>();
		
		if(assetCustom.getType5()!=""&&assetCustom.getType5()!=null&&!assetCustom.getType5().equals("请选择")){
			selectkey="资产类型："+assetCustom.getType5();
		}
		else if(assetCustom.getType4()!=""&&assetCustom.getType4()!=null&&!assetCustom.getType4().equals("请选择")){
			selectkey="资产类型："+assetCustom.getType4();
		}
		else if(assetCustom.getType3()!=""&&assetCustom.getType3()!=null&&!assetCustom.getType3().equals("请选择")){
			selectkey="资产类型："+assetCustom.getType3();
		}
		else if(assetCustom.getType2()!=""&&assetCustom.getType2()!=null&&!assetCustom.getType2().equals("请选择")){
			selectkey="资产类型："+assetCustom.getType2();
		}
		else if(assetCustom.getType1()!=""&&assetCustom.getType1()!=null&&!assetCustom.getType1().equals("请选择")){
			selectkey="资产类型："+assetCustom.getType1();
		}
		
		if(assetCustom.getName()!=null&&assetCustom.getName()!=""){
			if(selectkey==""){
				selectkey="资产名称:"+assetCustom.getName();
			}
			else{
				selectkey+="@资产名称:"+assetCustom.getName();
			}
		}
		
		if(assetCustom.getCode()!=null&&assetCustom.getCode()!=""){
			if(selectkey==""){
				selectkey="资产代码:"+assetCustom.getCode();
			}
			else{
				selectkey+="@资产代码:"+assetCustom.getCode();
			}
		}
		
		if(assetCustom.getKeepdepartment()!=null&&assetCustom.getKeepdepartment()!=""){
			if(selectkey==""){
				selectkey="保管部门:"+assetCustom.getKeepdepartment();
			}
			else{
				selectkey+="@保管部门:"+assetCustom.getKeepdepartment();
			}
		}
		
		if(assetCustom.getKeeper()!=null&&assetCustom.getKeeper()!=""){
			if(selectkey==""){
				selectkey="保管人:"+assetCustom.getKeeper();
			}
			else{
				selectkey+="@保管人:"+assetCustom.getKeeper();
			}
		}
		
		if(assetCustom.getUsedepartment()!=null&&assetCustom.getUsedepartment()!=""){
			if(selectkey==""){
				selectkey="使用部门:"+assetCustom.getUsedepartment();
			}
			else{
				selectkey+="@使用部门:"+assetCustom.getUsedepartment();
			}
		}
		
		if(assetCustom.getUser()!=null&&assetCustom.getUser()!=""){
			if(selectkey==""){
				selectkey="使用人:"+assetCustom.getUser();
			}
			else{
				selectkey+="@使用人:"+assetCustom.getUser();
			}
		}
		
		if(assetCustom.getIsbegin1()!=null&&assetCustom.getIsbegin1()!=""){
			if(selectkey==""){
				selectkey="是否初期:"+assetCustom.getIsbegin1();
			}
			else{
				selectkey+="@是否初期:"+assetCustom.getIsbegin1();
			}
		}
		
		if(assetCustom.getGhostyear()!=null&&assetCustom.getGhostyear()!=""){
			if(selectkey==""){
				selectkey="报废年度:"+assetCustom.getGhostyear();
			}
			else{
				selectkey+="@报废年度:"+assetCustom.getGhostyear();
			}
		}
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(assetCustom.getPurchasetime()!=null){
			
			String purchasetime=simpleDateFormat.format(assetCustom.getPurchasetime());
			if(selectkey==""){
				
				selectkey="起始购置日期:"+purchasetime;
			}
			else{
				selectkey+="@起始购置日期:"+purchasetime;
			}
		}
		
		if(assetCustom.getAbortpurchasetime()!=null){
			String abortpurchasetime=simpleDateFormat.format(assetCustom.getAbortpurchasetime());
			if(selectkey==""){
				
				selectkey="截止购置日期:"+abortpurchasetime;
			}
			else{
				selectkey+="@截止购置日期:"+abortpurchasetime;
			}
		}
		
		if(assetCustom.getMakecardtime()!=null){
			String makecardime=simpleDateFormat.format(assetCustom.getMakecardtime());
			if(selectkey==""){
				
				selectkey="起始制卡日期:"+makecardime;
			}
			else{
				selectkey+="@起始制卡日期:"+makecardime;
			}
		}
		
		if(assetCustom.getAbortmakecardtime()!=null){
			String abortmakecardtime=simpleDateFormat.format(assetCustom.getAbortmakecardtime());
			if(selectkey==""){
				
				selectkey="截止制卡日期:"+abortmakecardtime;
			}
			else{
				selectkey+="@截止制卡日期:"+abortmakecardtime;
			}
		}
		
		if(assetCustom.getStartusetime()!=null){
			String Startusetime=simpleDateFormat.format(assetCustom.getStartusetime());
			if(selectkey==""){
				
				selectkey="起始启用日期:"+Startusetime;
			}
			else{
				selectkey+="@起始启用日期:"+Startusetime;
			}
		}
		
		if(assetCustom.getAbortstartusetime()!=null){
			String Abortstartusetime=simpleDateFormat.format(assetCustom.getAbortstartusetime());
			if(selectkey==""){
				
				selectkey="截止启用日期:"+Abortstartusetime;
			}
			else{
				selectkey+="@截止启用日期:"+Abortstartusetime;
			}
		}
		
		if(assetCustom.getValue()!=null){
			//String Abortstartusetime=simpleDateFormat.format(assetCustom.getAbortstartusetime());
			if(selectkey==""){
				
				selectkey="起始资产金额:"+assetCustom.getValue();
			}
			else{
				selectkey+="@起始资产金额:"+assetCustom.getValue();
			}
		}
		
		if(assetCustom.getAbortvalue()!=null){
			//String Abortstartusetime=simpleDateFormat.format(assetCustom.getAbortstartusetime());
			if(selectkey==""){
				
				selectkey="截止资产金额:"+assetCustom.getAbortvalue();
			}
			else{
				selectkey+="@截止资产金额:"+assetCustom.getAbortvalue();
			}
		}
		
		
		usestate="使用状态："+assetCustom.getUsestate();
		state="状态："+assetCustom.getState();
		
		selectTerms.add(selectkey);
		//selectTerms.add(selectvalue);
		selectTerms.add(usestate);
		selectTerms.add(state);
		
		CustomAssetCheckData customAssetCheckData=new CustomAssetCheckData();
		customAssetCheckData.setAssets(assets);
		customAssetCheckData.setSelectTerms(selectTerms);
		
		//System.out.println("lrp输出custom：" + customAssetCheckData.getAssets().get(0).getCode());
		
		try {
			String filepath=fileTextWriterService.exportAssetCheckDataToText(customAssetCheckData);
			JSONObject jsonObject=new JSONObject();
			
			File file=new File(filepath);
			String filename="assetcheckdata.txt";
			
			FileDownload.download(response, file, filename);
			
			
			/*jsonObject.put("status", filepath);
			JsonResponse.PrintJsonOne(response, jsonObject);
			*/
			
			//System.out.println(status);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * 
	 * 陈铮
	 * 
	 * */
	@RequestMapping("/exportdepartmentandusertotext")
	public void exportdepartmentandusertotext(HttpServletResponse response){
		
		List<DepartmentWithUserMessage> departmentWithUserMessages=adminDepartmentService.getUserMessageByDep();
		
		//String resultString=fileTextWriterService.ExportDepartmentAndUser(departmentWithUserMessages);
		
		//System.out.println(resultString);
		String filepath=fileTextWriterService.exportDepartmentAndUserToText(departmentWithUserMessages);
		
		File file=new File(filepath);
		String filename="departmentanduser.txt";
		
		FileDownload.download(response, file, filename);
		
		
	}
	
	
	public static void main(String[] args) {
		String time="Wed Jun 15 00:00:00 CST 2016";
		Date date=new Date(time);
		SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
		String dateString;
		dateString=format1.format(date);
		Date date1=new Date(dateString);
		System.out.println(date1);
		//dateString=format1.format(date);
		
		
//		try {
//			dateString = format1.parse(time);
//			
//			System.out.println(dateString);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	
}
