package cn.bronze.controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;
import cn.bronze.entities.CustomExcelObject;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TLog;
import cn.bronze.services.AdminLogService;
import cn.bronze.services.FileExcelWriterService;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceHasClosedException;
import cn.bronze.util.file.FileDownload;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;


@Controller
@RequestMapping("/adminlogcontroller")
public class AdminLogController {
	
	@Autowired
	private AdminLogService adminLogService;
	@Autowired
	private FileExcelWriterService fileExcelWriterService;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/diaryadmin/indexrrn");
		return modelAndView;
	}
	
	/**
	 * 尼雷清
	 * 显示日志信息操作  根据默认条件查询条件condition 
	 * @param currentpage 当前页数
	 * @return
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/gettlogbyconditionwithpage")
	public String gettlogbyconditionwithpage(Model model,Integer currentPage,String condition,String text){
		if(currentPage==null){
			currentPage=1;
		}
		if(condition==null){
			condition="operatorpeople";
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TLog> tLogsList=adminLogService.getTlogByConditionWithPage(condition, text, pageParameter);
		model.addAttribute("tLogsList", tLogsList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("condition", condition);
		model.addAttribute("text", text);
		return "diaryadmin/indexrrn";
	}
	/**
	 * 尼雷清
	 * 执行查询日志信息操作  根据用户所所选的查询条件condition 
	 * @param currentpage 当前页数
	 * @return
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/findtlogbyconditionwithpage")
	public String findtlogbyconditionwithpage(Model model,Integer currentPage,String condition,String text){
		if(currentPage==null){
			currentPage=1;
		}
		if(condition==null){
			condition="operatedescription";
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TLog> tLogsList=adminLogService.findTlogByConditionWithPage(condition, text, pageParameter);
		model.addAttribute("tLogsList", tLogsList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("condition", condition);
		model.addAttribute("text", text);
		return "diaryadmin/indexrrn";
	}
	/**
	 * 尼雷清
	 * 设置查询下拉菜单赋值需要的Jsonarray
	 * @param 
	 * @return
	 */
	@RequestMapping("/getlogjson")
	public void getlogjson(String condition,HttpServletResponse response) throws IOException{
		if(condition==null){
			System.out.println("nlq:查询条件为空!");
		}else{
			JSONArray jsonArray=new JSONArray();
			jsonArray=adminLogService.getLogJson(condition);
			JsonResponse.PrintJsonList(response, jsonArray);
		}
	}
	/**
	 * 尼雷清
	 * 日志信息导出操作
	 * @param condition text 两个查询条件
	 * @return
	 * @throws ParamCanNotBeNullException 
	 * @throws ResourceHasClosedException 
	 */
	@RequiresPermissions(value={"sysauth","checkauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/logexport")
	public void logexport(String condition,String text,HttpServletResponse response) throws ResourceHasClosedException, ParamCanNotBeNullException{
		List<TLog> list=adminLogService.geTLogsExportList(condition, text);
		
		 CustomExcelObject<TLog, String> excelObject = new CustomExcelObject<TLog,String>(); 
		   excelObject.setClazz(TLog.class);
		  // excelObject.setFile(new File("E://资产信息详情.xls"));
	     	excelObject.setObjects(list);
			fileExcelWriterService.exportToExcel(excelObject);
			File  file = excelObject.getFile();
			
			String returnStr = null;
	        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
	        returnStr = f.format(date);
	        
			FileDownload.download(response, file, "系统操作日志记录表("+returnStr+").xls");
			//jsonObject.put("msg", "导出成功！");
			//JsonResponse.PrintJsonOne(response, jsonObject);
	}
}
