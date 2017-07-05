/**
 * 
 */
package cn.bronze.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.language.bm.Lang;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetCustom;
import cn.bronze.entities.AssetType;
import cn.bronze.entities.CustomExcelObject;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TUser;
import cn.bronze.log.Log;
import cn.bronze.services.AdminAssetCheckDataExportService;
import cn.bronze.services.AdminAssetService;
import cn.bronze.services.AdminAssetTypeService;
import cn.bronze.services.AdminImportExcelService;
import cn.bronze.services.AdminUserManagerService;
import cn.bronze.services.BaseAssetServcie;
import cn.bronze.services.FileExcelReaderService;
import cn.bronze.services.FileExcelWriterService;
import cn.bronze.services.FileImagePdfWriterService;
import cn.bronze.util.excel.AssetIOUtil;
import cn.bronze.util.excel.EntityIllegalRemarkException;
import cn.bronze.util.excel.EntityRemarkNotFoundException;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceContext;
import cn.bronze.util.excel.ResourceHasClosedException;
import cn.bronze.util.file.FileDownload;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;
import cn.bronze.util.spring.MAVUtil;

/**
 * @author 董浩
 * 2016年6月17日
 */
@RequestMapping("/adminasset")
@Controller
public class AdminAssetController {

	@Autowired
	private AdminAssetService adminAssetService;

	@Autowired
	private AdminAssetTypeService adminAssetTypeService;

	@Autowired
	private BaseAssetServcie baseAssetServcie;
	@Autowired
	public AdminImportExcelService aminImportExcelService;
	@Autowired
	private FileExcelReaderService fileExcelReaderService;

	@Autowired
	private FileExcelWriterService fileExcelWriterService;

	@Autowired
	private FileImagePdfWriterService fileImagePdfWriterService;

	@Autowired
	private AdminAssetCheckDataExportService adminAssetCheckDataExportService;

	@Autowired
	private AdminUserManagerService adminUserManagerService;


	/**
	 * 资产管理首页（与查询）
	 * @author 董浩
	 * 2016年6月18日 下午1:57:56
	 * @param category
	 * @param text
	 * @param usestate
	 * @param state
	 * @param currentPage
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/showassetmenu")
	public ModelAndView showassetmenu(HttpSession session){

		ModelAndView modelAndView=new ModelAndView();
		List<AssetType> list = adminAssetTypeService.selectFirstAssetTypeMenu();

		String useraccount=(String)session.getAttribute("usernamelog");
		String userdepnameString=adminUserManagerService.getUserByUserAccount(useraccount);
		if(list!=null){
			modelAndView.addObject("list", list);
			if(userdepnameString!=null){
				modelAndView.addObject("userdepnameString", userdepnameString);
			}
			modelAndView.setViewName("dataadmin/assetadmin/admin/zcglcxzp");
			return modelAndView;
		}
		else{
			return MAVUtil.getErrorModelAndView("一级菜单查询有误");
		}


		//return modelAndView;
	}

	/**
	 * 陈铮
	 * @param AssetCustom 将查询条件封装的对象
	 * @param currentPage 当前页数
	 * @return
	 * */
	@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/getassetcheckresultwithpage")
	public ModelAndView getassetcheckresultwithpage(AssetCustom assetCustom,Integer currentPage,HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		currentPage=(currentPage!=null)?currentPage:1;
		PageParameter page=PageParameter.NewInstance(currentPage);


		List<Asset> assets=adminAssetCheckDataExportService.getassetsbyconditionwithpage(assetCustom,page);
		session.setAttribute("assetCustom", assetCustom);
		modelAndView.addObject("assetCustom", assetCustom);
		modelAndView.addObject("pager", page);
		modelAndView.addObject("assets", assets);
		//System.out.println(assets.size());
		modelAndView.setViewName("dataadmin/assetadmin/admin/zcgljgzp");
		return modelAndView;


	}


	@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/getassetcheckresultoutputwithpage")
	public ModelAndView getassetcheckresultoutputwithpage(AssetCustom assetCustom,Integer currentPage){
		ModelAndView modelAndView=new ModelAndView();
		currentPage=(currentPage!=null)?currentPage:1;
		PageParameter page=PageParameter.NewInstance(currentPage);


		List<Asset> assets=adminAssetCheckDataExportService.getassetsbyconditionwithpage(assetCustom,page);

		modelAndView.addObject("assetCustom", assetCustom);
		modelAndView.addObject("pager", page);
		modelAndView.addObject("assets", assets);
		//System.out.println(assets.size());
		modelAndView.setViewName("dataadmin/assetadmin/daochu/pdsjdcjgzp");
		return modelAndView;


	}


	/**
	 * 陈铮
	 * @param AssetCustom 将查询条件封装的对象
	 * @return
	 * */
	@RequestMapping("/getassetcheckresultoutput")
	@Log(descrp="执行资产信息导出操作",type="系统管理权限，资产管理权限")
	public void getassetcheckresultoutput(AssetCustom assetCustom,HttpServletResponse response) throws IOException, ResourceHasClosedException, ParamCanNotBeNullException{
		//JSONObject jsonObject = new JSONObject();
		//查询结果集合
		List<Asset> assets = adminAssetCheckDataExportService.getassetsbycondition(assetCustom);

		CustomExcelObject<Asset, Object> excelObject = new CustomExcelObject<>();
		excelObject.setClazz(Asset.class);
		excelObject.setObjects(assets);
		fileExcelWriterService.exportToExcel(excelObject);
		//System.out.println(list.size());
		File file = excelObject.getFile();
		String filename = "资产信息表.xls";
		FileDownload.download(response, file, filename);


	}



	/**
	 * 展示添加菜单
	 * @author 董浩
	 * 2016年6月18日 下午4:18:09
	 * @return
	 */
	@RequestMapping("/showassetadd")
	public ModelAndView showassetadd(){
		ModelAndView modelAndView = new ModelAndView();
		List<AssetType> list = adminAssetTypeService.selectFirstAssetTypeMenu();
		if(list!=null){
			modelAndView.addObject("firsttype", list);
			modelAndView.setViewName("dataadmin/assetadmin/admin/addlmy");
			return modelAndView;
		}else {
			return MAVUtil.getErrorModelAndView("一级菜单查询有误");
		}
	}

	private void loop(List save,int id){
		if(id==0){
			return ;
		}
		int fid = adminAssetTypeService.selectFidById(id);
		List<AssetType> list = adminAssetTypeService.selectBrotherAssetTypeByFid(fid);
		list.add(adminAssetTypeService.selectByPrimaryKey(id));
		save.add(list);
		loop(save,fid);
	}


	/**
	 * 根据id查询资产信息
	 * @author 董浩
	 * 2016年6月18日 下午5:29:04
	 * @param id
	 * @return
	 */
	@RequestMapping("/showassetbyid")
	public ModelAndView showassetbyid(int id,int assetCurrentPage){
		ModelAndView modelAndView = new ModelAndView();
		Asset asset = baseAssetServcie.selectByPrimaryKey(id);

		String assetTypeName = asset.getType();
		//System.out.println("assetTypeName="+assetTypeName);
		int assetTypeId = adminAssetTypeService.selectIdByAssetTypeName(assetTypeName);

		List saveList = new LinkedList();
		loop(saveList, assetTypeId);
		int j = 1;
		for(int i=saveList.size()-1;i>=0;i--){
			List<AssetType> list = (List<AssetType>) saveList.get(i);
			modelAndView.addObject("list"+j, list);
			j++;
		}

		if(asset!=null){
			modelAndView.addObject("asset", asset);
			//modelAndView.addObject("purch",asset.getPurchasetime());
			modelAndView.addObject("assetCurrentPage",assetCurrentPage);
			System.err.println(assetCurrentPage);
			modelAndView.setViewName("dataadmin/assetadmin/admin/editlmy");
			return modelAndView;
		}else {
			return MAVUtil.getErrorModelAndView("输入参数有误");
		}

	}

	/**
	 * 更新资产
	 * @author 董浩
	 * 2016年6月18日 下午9:58:01
	 * @param asset
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/updateasset")
	public void updateasset(Asset asset,HttpServletResponse response) throws IOException{
		JSONObject jsonObject = new JSONObject();
		//System.out.println("asset的typeName="+asset.getType());
		int record = adminAssetService.updateByPrimaryKey(asset);
		if(record>0){
			jsonObject.put("status", "ok");
			//jsonObject.put("assetCurrentPage", assetCurrentPage);
			jsonObject.put("msg", "修改成功");
		}else {
			jsonObject.put("status", "no");
			//jsonObject.put("assetCurrentPage", assetCurrentPage);
			jsonObject.put("msg", "修改失败");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
		/*response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(jsonObject);*/
	}

	/**
	 * 插入资产
	 * @author 董浩
	 * 2016年6月18日 下午10:04:56
	 * @param asset
	 * @param response
	 * @throws IOException
	 */
	@Log(descrp="执行资产添加操作",type="系统管理权限，资产管理权限")
	@RequestMapping("/insertasset")
	public void insertasset(Asset asset,HttpServletResponse response) throws IOException{
		JSONObject jsonObject = new JSONObject();
		String code = asset.getCode();
		List<Asset> assets = adminAssetService.selectListByCode(code);
		if (assets!=null&&assets.size()!=0) {
			jsonObject.put("status", "no");
			jsonObject.put("asset", asset);
			jsonObject.put("msg", "添加失败，该资产代码已存在");
		}else {
			int record = adminAssetService.insert(asset);
			int assetTotalPage = adminAssetService.getAssetTotalPage();
			if(record>0){
				jsonObject.put("status", "ok");
				jsonObject.put("assetTotalPage", assetTotalPage);
				jsonObject.put("msg", "添加成功");
			}else {
				jsonObject.put("status", "no");
				jsonObject.put("assetTotalPage", assetTotalPage);
				jsonObject.put("msg", "添加失败");
			}
		}

		JsonResponse.PrintJsonOne(response, jsonObject);
	}

	/**
	 * 展示资产导入页面
	 * @author 董浩
	 * 2016年6月19日 下午12:07:35
	 * @return
	 */

	@RequiresPermissions(value={"sysauth","assetauth"},logical=Logical.OR)
	@RequestMapping("/showassetinput")
	public ModelAndView showassetinput(){
		return MAVUtil.getModelAndViewByName("dataadmin/assetadmin/daoru/indexkw");
	}

	/**
	 * 展示资产导出页面
	 * @author 董浩
	 * 2016年6月19日 下午12:09:26
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth"},logical=Logical.OR)
	@RequestMapping("/showassetoutput")
	public ModelAndView showassetoutput(){

		ModelAndView modelAndView=new ModelAndView();
		List<AssetType> list = adminAssetTypeService.selectFirstAssetTypeMenu();

		if(list!=null){
			modelAndView.addObject("list", list);
			modelAndView.setViewName("dataadmin/assetadmin/daochu/pdsjdccxzp");
			return modelAndView;
		}
		else{
			return MAVUtil.getErrorModelAndView("一级菜单查询有误");
		}

	}

	/**
	 * 带有条件查询的导出界面list展示
	 * @author 董浩
	 * 2016年6月24日 下午2:52:21
	 * @param category
	 * @param text
	 * @param usestate
	 * @param state
	 * @return
	 */
	@RequestMapping("/showassetoutputsearch")
	public ModelAndView showassetoutputsearch(String category,String text,String usestate,String state){
		ModelAndView modelAndView = new ModelAndView();
		List<Asset> list = adminAssetService.selectAssetAllByCondition(category, text, usestate, state);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("dataadmin/assetadmin/daochu/indexlmy");
		return modelAndView;
	}


	/**
	 * 导出比对表格
	 * @author 陈铮
	 * @param filePath
	 * @throws EntityIllegalRemarkException 
	 * @throws EntityRemarkNotFoundException 
	 * @throws ResourceHasClosedException 
	 * @throws ParamCanNotBeNullException 
	 * @throws NullPointerException 
	 * @throws FileNotFoundException 
	 * 
	 * */

	@RequestMapping("/outputexcel")
	public void outputexcel(String filePath,HttpServletResponse response) throws FileNotFoundException, NullPointerException, ParamCanNotBeNullException, ResourceHasClosedException, EntityRemarkNotFoundException, EntityIllegalRemarkException {
		//List<Asset> list = AssetIOUtil.AssetInput(filePath);
		
		
		
		CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
		excelObject.setClazz(Asset.class);
		ResourceContext context = new ResourceContext(excelObject.getClass());
		File filer = new File(filePath);
		excelObject.setFile(filer);
		fileExcelReaderService.importFromExcel(excelObject);
		List<Asset> list=excelObject.getObjects();
		

//		CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
//		excelObject.setClazz(Asset.class);		
		excelObject.setObjects(list);
		fileExcelWriterService.exportToExcel(excelObject);
		File  file = excelObject.getFile();
		FileDownload.download(response, file, "资产比对表格.xls");


	}






	/**
	 * 数据导入
	 * @author 董浩
	 * 2016年6月19日 下午12:51:38
	 * @param filePath
	 * @return
	 * @throws NullPointerException
	 * @throws ParamCanNotBeNullException
	 * @throws ResourceHasClosedException
	 * @throws EntityRemarkNotFoundException
	 * @throws EntityIllegalRemarkException
	 * @throws IOException 
	 */
	@RequestMapping("/inputasset")
	public void inputasset(String filePath,HttpServletResponse response) throws NullPointerException, ParamCanNotBeNullException, ResourceHasClosedException, EntityRemarkNotFoundException, EntityIllegalRemarkException, IOException{
		//AdminAssetIOService adminAssetIOService = new AdminAssetIOService();
		//ModelAndView modelAndView = new ModelAndView();
		System.err.println("inputasset");
		JSONObject jsonObject = new JSONObject();
		String classesPath=getClass().getResource("/").getPath();
		int subIndex=classesPath.indexOf("/taxoffice");
		
		CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
		excelObject.setClazz(Asset.class);
		ResourceContext context = new ResourceContext(excelObject.getClass());
		File file = new File(filePath);
		excelObject.setFile(file);
		fileExcelReaderService.importFromExcel(excelObject);
		List<Asset> list=excelObject.getObjects();
		//设置导入资产的usestate属性默认为"闲置"
		for(int i=0;i<list.size();i++){
			list.get(i).setUsestate("闲置");
		}	
		List codeList = new LinkedList();
		//新添加
		for (Asset asset : list) {
			String codeString = asset.getCode();
			List<Asset> assets = adminAssetService.selectListByCode(codeString);
			if (assets != null) {
				codeList.add(codeString);
			}else {
				baseAssetServcie.insert(asset);
			}
		}
		
		//新注释
		/*for (Asset asset : list) {
			codeList.add(asset.getCode());
		}*/
		if(list != null && list.size() != 0 && codeList != null && codeList.size() != 0){
			jsonObject.put("status", "yes");
			jsonObject.put("codeList", codeList);
		}else if (codeList.size() == 0) {		//判断是否有重复代码
			jsonObject.put("status", "no");
			jsonObject.put("msg", "提交成功");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "提交数据不能为空，请重新选择");
		}
		/*if(list!=null){
			for (Asset asset : list) {
				int record = adminAssetService.insert(asset);
				if(record<=0){
					jsonObject.put("status", "no");
					jsonObject.put("msg", "提交失败");
				}else {
					jsonObject.put("status", "ok");
					jsonObject.put("msg", "提交成功");
				}
			}
		}*/
		JsonResponse.PrintJsonOne(response, jsonObject);

	}

	/**
	 * Excel数据导出
	 * @author 董浩
	 * 2016年6月20日 上午11:05:59
	 * @param category
	 * @param text
	 * @param usestate
	 * @param state
	 * @param response
	 * @throws ParamCanNotBeNullException
	 * @throws ResourceHasClosedException
	 * @throws IOException 
	 */
	@RequestMapping("/outputasset")
	public void outputasset(String category,String text,String usestate,String state,HttpServletResponse response) throws ParamCanNotBeNullException, ResourceHasClosedException, IOException{
		JSONObject jsonObject = new JSONObject();
		List<Asset> list = adminAssetService.selectAssetAllByCondition(category, text, usestate, state);
		//String filePath = "\\taxoffice\\attached\\file\\20160624\\资产信息_测试.xls";
		//FileExcelWriterService fileExcelWriterService = new FileExcelWriterService();
		CustomExcelObject<Asset, Object> excelObject = new CustomExcelObject<>();
		excelObject.setClazz(Asset.class);
		excelObject.setObjects(list);
		fileExcelWriterService.exportToExcel(excelObject);
		//System.out.println(list.size());
		File file = excelObject.getFile();
		String filename = "1.xls";
		FileDownload.download(response, file, filename);

		//Map<String, Object> map = excelObject.getExceptionMsg();


		//ResourceContext context = new ResourceContext(Asset.class);
		/*if(map==null||map.size()==0||(map.get("success")).equals("true")){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "导出成功");

		}else {
			jsonObject.put("status", "no");
			jsonObject.put("msg", "导出失败");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);*/
	}

	/**
	 * 安凯刚修改多标签生成，浩哥代码已注释
	 * 生成二维码
	 * @author 董浩
	 * 2016年6月24日 下午4:34:22
	 * @param id
	 * @throws IOException
	 * @throws DocumentException
	 */
	@RequestMapping("/createlabel")
	public void createlabel(String data,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, DocumentException{
		OutputStream out = response.getOutputStream();
		if ("all".equals(data)) {
			AssetCustom example = (AssetCustom) session
					.getAttribute("assetCustom");
			List<Asset> assets = adminAssetCheckDataExportService
					.getassetsbycondition(example);
			String filename = fileImagePdfWriterService
					.printAssetToPdfDocument(assets);
			response.setHeader("Content-Disposition", "attachment;filename="
					+ filename);

			// 读取文件
			InputStream in = new FileInputStream(filename);

			// 写文件
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
			return;
		} else {
			String[] idArray = data.split(",");
			System.out.println(data);

			List<Asset> assets = new ArrayList<Asset>();
			for (String idStr : idArray) {
				Asset asset = adminAssetService.selectByPrimaryKey(Integer
						.parseInt(idStr));
				if (asset != null)
					assets.add(asset);
			}
			String filename = fileImagePdfWriterService
					.printAssetToPdfDocument(assets);
			response.setHeader("Content-Disposition", "attachment;filename="
					+ filename);

			// 读取文件
			InputStream in = new FileInputStream(filename);

			// 写文件
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
		}
	}
	/*	public void createlabel(int id,HttpServletRequest request,HttpServletResponse response) throws IOException, DocumentException{
		Asset asset = adminAssetService.selectByPrimaryKey(id);
		String filename = fileImagePdfWriterService.printAssetToPdfDocument(asset);
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
	}*/

	/**
	 * 资产信息导出展示
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 * @throws ParamCanNotBeNullException
	 * @throws ResourceHasClosedException
	 * @throws EntityRemarkNotFoundException
	 * @throws EntityIllegalRemarkException
	 */
	@RequestMapping("showassetconvert")
	public ModelAndView showassetconvert(String filePath) throws FileNotFoundException, NullPointerException, ParamCanNotBeNullException, ResourceHasClosedException, EntityRemarkNotFoundException, EntityIllegalRemarkException{
		//		List<Asset> list = AssetIOUtil.AssetInput(filePath);

		String classesPath=getClass().getResource("/").getPath();
		int subIndex=classesPath.indexOf("/taxoffice");
		classesPath=classesPath.substring(0, subIndex);
		filePath=classesPath+filePath;
		//List<Asset> list = AssetIOUtil.AssetInput(filePath);
		CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
		excelObject.setClazz(Asset.class);
		ResourceContext context = new ResourceContext(excelObject.getClass());
		File file = new File(filePath);
		excelObject.setFile(file);
		fileExcelReaderService.importFromExcel(excelObject);
		List<Asset> list=excelObject.getObjects();
		// List<Asset> list=aminImportExcelService.clearasser(list1);


		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("filepath", filePath);
		modelAndView.setViewName("dataadmin/assetadmin/daoru/indexkw");
		return modelAndView;
	}


	/**
	 * 通过名字查询子菜单
	 * @author 董浩
	 * 2016年6月26日 下午10:11:22
	 * @param name
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selectchildassettype")
	public void selectchildassettype(String name,HttpServletResponse response) throws IOException{
		//System.out.println(name);
		JSONObject jsonObject = new JSONObject();
		List<AssetType> list = adminAssetTypeService.selectChildAssetTypeByName(name);
		String childName = "";
		//System.out.println(list.size());
		if (list!=null&&list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				childName = childName+list.get(i).getTypename().toString()+"#";
			}
			jsonObject.put("msg", childName.substring(0, childName.length()-1));
		}else{
			jsonObject.put("msg", "error");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}


	/**
	 * 根据code查询是否有该资产存在
	 * @author 董浩
	 * 2016年6月30日 下午4:37:56
	 * @param code
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/selectassetbycode")
	public void selectassetbycode(String code,HttpServletResponse response) throws IOException{
		JSONObject jsonObject = new JSONObject();
		List<Asset> list;
		if(code!=null&&code.length()!=0){
			list = adminAssetService.selectListByCode(code);
			if (list!=null) {
				jsonObject.put("status", "no");
				jsonObject.put("msg", "该资产已存在，请重新输入");
			}
		}else {
			jsonObject.put("status", "no");
			jsonObject.put("msg", "资产代码不能为空，请重新输入");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}


	/**
	 * 检查是否有重复的资产代码
	 * @author 董浩
	 * 2016年7月3日 上午10:54:46
	 * @param code
	 * @param response
	 * @throws IOException
	 * @throws EntityIllegalRemarkException 
	 * @throws EntityRemarkNotFoundException 
	 * @throws ResourceHasClosedException 
	 * @throws ParamCanNotBeNullException 
	 * @throws NullPointerException 
	 */
	@RequestMapping("/checkAssetCode")
	public void checkAssetCode(String filePath,String code,HttpServletResponse response) throws IOException, NullPointerException, ParamCanNotBeNullException, ResourceHasClosedException, EntityRemarkNotFoundException, EntityIllegalRemarkException{
		JSONObject jsonObject = new JSONObject();
		List<Asset> list = adminAssetService.selectListByCode(code);
		if (list!=null) {
			jsonObject.put("status", "ok");
			jsonObject.put("code", code);
		}else {
			//List<Asset> assetList = AssetIOUtil.AssetInput(filePath);
			CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
			excelObject.setClazz(Asset.class);
			ResourceContext context = new ResourceContext(excelObject.getClass());
			File file = new File(filePath);
			excelObject.setFile(file);
			fileExcelReaderService.importFromExcel(excelObject);
			List<Asset> assetList=excelObject.getObjects();
			for (Asset asset : assetList) {
				if (asset.getCode().equals(code)) {
					baseAssetServcie.insert(asset);
				}
			}
			jsonObject.put("status", "no");
			jsonObject.put("msg", "提交成功");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}


	/**
	 * 忽略掉所有的重复项
	 * @author 董浩
	 * 2016年7月3日 下午6:13:20
	 * @param filePath
	 * @param codeList
	 * @param response
	 * @throws NullPointerException
	 * @throws ParamCanNotBeNullException
	 * @throws ResourceHasClosedException
	 * @throws EntityRemarkNotFoundException
	 * @throws EntityIllegalRemarkException
	 * @throws IOException 
	 */
	@RequestMapping("/skipallasset")
	public void skipallasset(String filePath,String stringList,HttpServletResponse response) throws NullPointerException, ParamCanNotBeNullException, ResourceHasClosedException, EntityRemarkNotFoundException, EntityIllegalRemarkException, IOException{
		stringList = stringList.substring(0, stringList.length()-1);
		String[] codeList = stringList.split("#");
		JSONObject jsonObject = new JSONObject();
		//List<Asset> assetList = AssetIOUtil.AssetInput(filePath);

		CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
		excelObject.setClazz(Asset.class);
		ResourceContext context = new ResourceContext(excelObject.getClass());
		File file = new File(filePath);
		excelObject.setFile(file);
		fileExcelReaderService.importFromExcel(excelObject);
		List<Asset> assetList=excelObject.getObjects();

		System.out.println(assetList.get(0).getCode());

		for (int i = 0; i < codeList.length; i++) {
			String code = (String) codeList[i];
			List<Asset> list = adminAssetService.selectListByCode(code);

			if(list==null){
				for (Asset asset : assetList) {
					if (asset.getCode().equals(code)) {
						baseAssetServcie.insert(asset);
					}
				}
			}
		}
		jsonObject.put("status", "ok");
		jsonObject.put("msg", "提交成功");
		JsonResponse.PrintJsonOne(response, jsonObject);
	}



	/**
	 * 更新该条记录
	 * @author 董浩
	 * 2016年7月3日 下午6:56:54
	 * @param code
	 * @param response
	 * @throws NullPointerException
	 * @throws ParamCanNotBeNullException
	 * @throws ResourceHasClosedException
	 * @throws EntityRemarkNotFoundException
	 * @throws EntityIllegalRemarkException
	 * @throws IOException 
	 */
	@RequestMapping("/updateoneasset")
	public void updateoneasset(String code,String filePath,HttpServletResponse response) throws NullPointerException, ParamCanNotBeNullException, ResourceHasClosedException, EntityRemarkNotFoundException, EntityIllegalRemarkException, IOException{
		JSONObject jsonObject = new JSONObject();
		//List<Asset> assetList = AssetIOUtil.AssetInput(filePath);
		CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
		excelObject.setClazz(Asset.class);
		ResourceContext context = new ResourceContext(excelObject.getClass());
		File file = new File(filePath);
		excelObject.setFile(file);
		fileExcelReaderService.importFromExcel(excelObject);
		List<Asset> assetList=excelObject.getObjects();
		/*for (Asset asset : assetList) {

		}*/
		List<Asset> list = adminAssetService.selectListByCode(code);
		if (list!=null) {
			//int isSuccess = baseAssetServcie.updateByPrimaryKey(list.get(0));
			for (Asset asset : assetList) {
				if (asset.getCode().equals(code)) {
					asset.setId(list.get(0).getId());
					int isSuccess = adminAssetService.updateAssetByCode(asset);
					if(isSuccess>0){
						jsonObject.put("status", "ok");
					}else {
						jsonObject.put("status", "no");
						jsonObject.put("msg", "更新失败");
					}
				}
			}
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}


	/**
	 * 更新全部记录
	 * @author 董浩
	 * 2016年7月3日 下午7:22:18
	 * @param filePath
	 * @param codeList
	 * @param response
	 * @throws NullPointerException
	 * @throws ParamCanNotBeNullException
	 * @throws ResourceHasClosedException
	 * @throws EntityRemarkNotFoundException
	 * @throws EntityIllegalRemarkException
	 * @throws IOException
	 */
	@RequestMapping("/updateallasset")
	public void updateallasset(String stringList,String filePath,String code,HttpServletResponse response) throws NullPointerException, ParamCanNotBeNullException, ResourceHasClosedException, EntityRemarkNotFoundException, EntityIllegalRemarkException, IOException{
		JSONObject jsonObject = new JSONObject();
		stringList = stringList.substring(0, stringList.length()-1);	//前台传进来的带分隔符的字符串
		String[] codeList = stringList.split("#");		//从前台获取到的code数组
		//List<Asset> assetList = AssetIOUtil.AssetInput(filePath);  //要更新的数据（在前台显示出的数据）
		CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
		excelObject.setClazz(Asset.class);
		ResourceContext context = new ResourceContext(excelObject.getClass());
		File file = new File(filePath);
		excelObject.setFile(file);
		fileExcelReaderService.importFromExcel(excelObject);
		List<Asset> assetList=excelObject.getObjects();
		ArrayList<String> codes = new ArrayList<>();	//要更新的字符串集合（无id值需要从assetList中获取，并赋值）
		int temp = 0;	//找到传入的code值所在的位置
		for (int i = 0; i < codeList.length; i++) {  //得到code的位置
			//String str = codeList[i];
			if (codeList[i].equals(code)) {
				//System.out.println(codeList[i].equals(code));
				temp = i;
			}
		}
		//System.out.println(temp);
		for (int i = 0; i < codeList.length; i++) {  //获取到code及以后代码的list集合
			if (i>=temp) {
				codes.add(codeList[i]);
			}
		}
		//System.out.println(codes.length());
		for (String string : codes) {		//执行插入和更新操作
			List<Asset> list = adminAssetService.selectListByCode(string);
			if (list!=null) {
				for (Asset asset : assetList) {
					if (asset.getCode().equals(string)) {
						asset.setId(list.get(0).getId());
						baseAssetServcie.updateByPrimaryKey(asset);
					}
				}
			}else {
				for (Asset asset : assetList) {
					if (asset.getCode().equals(string)) {
						baseAssetServcie.insert(asset);
					}
				}
			}
		}
		jsonObject.put("status", "ok");
		jsonObject.put("msg", "提交成功");
		JsonResponse.PrintJsonOne(response, jsonObject);
	}


	/**
	 * 传回分页的最后一页的值
	 * @author 董浩
	 * 2016年7月12日 上午10:10:27
	 * @param currentPage
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/gettotalpage")
	public void gettotalpage(HttpServletResponse response) throws IOException{
		JSONObject jsonObject = new JSONObject();
		PageParameter page = PageParameter.NewInstance(1);
		jsonObject.put("pager", page);
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	
	/**
	 * 摸态框传回重复代码并进行更新
	 * @author 董浩
	 * 2016年10月28日 下午11:01:46
	 * @param filePath
	 * @param code
	 * @param response
	 * @throws ParamCanNotBeNullException
	 * @throws IOException
	 */
	@RequestMapping("/modalAsset")
	public void modalAsset(String filePath,String code,HttpServletResponse response) throws ParamCanNotBeNullException, IOException{
		JSONObject jsonObject = new JSONObject();
		if (code != null) {
			//抽取excel对象
			CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>();
			excelObject.setClazz(Asset.class);
			ResourceContext context = new ResourceContext(excelObject.getClass());
			File file = new File(filePath);
			excelObject.setFile(file);
			fileExcelReaderService.importFromExcel(excelObject);
			List<Asset> assetList=excelObject.getObjects();
			
			String[] codeList = code.split(",");	//前台传回code集合
			
			//更新asset
			for (Asset asset : assetList) {
				String assetCode = asset.getCode();
				for (String codeString : codeList) {
					if (codeString.equals(assetCode)) {
						adminAssetService.updateAssetByCode(asset);
					}
				}
			}
			//System.out.println(code);
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "提交成功");
		}else {
			jsonObject.put("status", "no");
			jsonObject.put("msg", "提交成功");
		}
		
		JsonResponse.PrintJsonOne(response, jsonObject);
	}





}
