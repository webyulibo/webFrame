package cn.bronze.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.CustomExcelObject;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExtend;
import cn.bronze.services.AdminDepartmentService;
import cn.bronze.services.AdminImportExcelService;
import cn.bronze.services.AdminUserManagerService;
import cn.bronze.services.FileExcelReaderService;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceContext;
import cn.bronze.util.excel.ResourceHasClosedException;
import cn.bronze.util.file.FileDownload;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/adminimportexcelcontroller")
public class AdminImportExcelController {
	@Autowired
	public FileExcelReaderService fileExcelReaderService;
	@Autowired
	public AdminImportExcelService aminImportExcelService;
	@Autowired
	private AdminUserManagerService adminUserManagerService;
	@Autowired
	private AdminDepartmentService adminDepartmentService;
 	/**
	 *  于立波
	 *  导入人员信息
	 * @param path
	 * @throws FileNotFoundException
	 * @throws ParamCanNotBeNullException
	 */
	@RequestMapping("/importuserlist")
	public ModelAndView importuserlist(
			String filePath
			) throws FileNotFoundException, ParamCanNotBeNullException{
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
		 CustomExcelObject<TUser, String> excelObject = new CustomExcelObject<TUser,String>(); 
		 excelObject.setClazz(TUser.class);
		 ResourceContext context = new ResourceContext(excelObject.getClass());
     	 File file = new File(filePath);
//		 File file = new File("E://税务局固资管理//taxoffice//1.需求分析+界面设计//1.2.相关表单//副本人员信息2.xls");
		 excelObject.setFile(file);
		 fileExcelReaderService.importFromExcel(excelObject);
		 List<TUser> userlist1=excelObject.getObjects();
		 List<TUser> userlist=aminImportExcelService.clearuse(userlist1);
		 //校验导入的人员信息
		 String re1="x";//设一个初值
		 String re2="y";//设一个初值
		 String re3="z";//设一个初值
		 for(int i=0;i<userlist.size();i++){
			 System.out.println(userlist.get(i).getUsercode());
			 if(userlist.get(i).getUsercode()==""||userlist.get(i).getUserdep()==null||userlist.get(i).getUserdep()==null||userlist.get(i).getUsercode()==null){
				 re1="x1";//存在空数据
			 }
			 if(userlist.get(i).getUsercode()!=null&&userlist.get(i).getUsercode()!=""&&userlist.get(i).getUserdep()!=null&&userlist.get(i).getUserdep()!=""){
				 for(int j=0;j<userlist.size();j++){
				     System.out.println("yulibo"+userlist.get(i).getUsercode());
				     System.out.println("yulibo"+userlist.get(j).getUsercode());
					 if(userlist.get(i).getUsercode().equals(userlist.get(j).getUsercode())&&i!=j){
						 re2="y2";//导入的人员代码存在重复
					 }
				 }
			 }
			 if(userlist.get(i).getUserdep()!=null&&userlist.get(i).getUserdep()!=""){
                 String reh=aminImportExcelService.getRe(userlist.get(i).getUserdep());
                 if(reh==null){
				 re3="z3";//导入的人员所属部门不存在
                 }
			 }
		 }
		 if(re1=="x1"){
			 String condition="useraccount";
			 String text="";
			 Integer currentPage=1;
			 PageParameter pageParameter=PageParameter.NewInstance(currentPage);
				List<TUserExtend> tUserExtendsList=adminUserManagerService.getUserByConditionWithPage(condition, text, pageParameter);
				modelAndView.addObject("tUserExtendsList", tUserExtendsList);
				modelAndView.addObject("pager", pageParameter);
				modelAndView.addObject("condition", condition);
				modelAndView.addObject("text", text);
				modelAndView.addObject("meg", "导入失败(检查是否存在无效数据)");
			   modelAndView.setViewName("/usermanager/getusersby");
			 return modelAndView;
		 }
		 if(re2=="y2"){
			 String condition="useraccount";
			 String text="";
			 Integer currentPage=1;
			 PageParameter pageParameter=PageParameter.NewInstance(currentPage);
				List<TUserExtend> tUserExtendsList=adminUserManagerService.getUserByConditionWithPage(condition, text, pageParameter);
				modelAndView.addObject("tUserExtendsList", tUserExtendsList);
				modelAndView.addObject("pager", pageParameter);
				modelAndView.addObject("condition", condition);
				modelAndView.addObject("text", text);
				modelAndView.addObject("meg", "导入失败(检查导入的人员代码是否重复)");
			   modelAndView.setViewName("/usermanager/getusersby");
			 return modelAndView;
		 }
		 if(re3=="z3"){
			 String condition="useraccount";
			 String text="";
			 Integer currentPage=1;
			 PageParameter pageParameter=PageParameter.NewInstance(currentPage);
				List<TUserExtend> tUserExtendsList=adminUserManagerService.getUserByConditionWithPage(condition, text, pageParameter);
				modelAndView.addObject("tUserExtendsList", tUserExtendsList);
				modelAndView.addObject("pager", pageParameter);
				modelAndView.addObject("condition", condition);
				modelAndView.addObject("text", text);
				modelAndView.addObject("meg", "导入失败(检查导入的人员所属部门是否存在)");
			   modelAndView.setViewName("/usermanager/getusersby");
			 return modelAndView;
		 }
		 if(re1=="x"&&re2=="y"&&re3=="z"){
		 aminImportExcelService.importUserList(userlist);
		 String condition="useraccount";
		 String text="";
		 Integer currentPage=1;
		 PageParameter pageParameter=PageParameter.NewInstance(currentPage);
			List<TUserExtend> tUserExtendsList=adminUserManagerService.getUserByConditionWithPage(condition, text, pageParameter);
			modelAndView.addObject("tUserExtendsList", tUserExtendsList);
			modelAndView.addObject("pager", pageParameter);
			modelAndView.addObject("condition", condition);
			modelAndView.addObject("text", text);
			modelAndView.addObject("meg", "导入成功");
     		adminDepartmentService.countDepUseNum();
		 modelAndView.setViewName("/usermanager/getusersby");
		 return modelAndView;
		 }
		return modelAndView;
	}
	/**
	 * 于立波
	 * 导入部门信息
	 * @param path
	 * @throws FileNotFoundException
	 * @throws ParamCanNotBeNullException
	 */
	@RequestMapping("/importdeplist")
	public ModelAndView importdeplist(
			String filePath
			) throws FileNotFoundException, ParamCanNotBeNullException{
		ModelAndView modelAndView=new ModelAndView();
		//获取tomcat下webapps的地址
		System.out.println(getClass().getResource("/"));
		String classesPath=getClass().getResource("/").getPath();
		System.out.println(classesPath);
		int subIndex=classesPath.indexOf("/taxoffice");
		classesPath=classesPath.substring(0, subIndex);
		System.out.println(classesPath);
		//System.out.println(System.getProperty("user.dir").replace("bin", "webapps"););
		filePath=classesPath+filePath;
		 CustomExcelObject<TDepartment, String> excelObject = new CustomExcelObject<TDepartment,String>(); 
		 excelObject.setClazz(TDepartment.class);
		 ResourceContext context = new ResourceContext(excelObject.getClass());
     	 File file = new File(filePath);
		 excelObject.setFile(file);
		 fileExcelReaderService.importFromExcel(excelObject);
		 List<TDepartment> deplist1=excelObject.getObjects();
		 //去除deplist里的空格
		 List<TDepartment> deplist=AdminImportExcelService.cleardep(deplist1);
		 //校验导入的部门信息
		 String ch1="f1";//设一个初值
		 String ch2="f2";//设一个初值
		 String ch3="f3";//设一个初值
         for(int i=0;i<deplist.size();i++){
        	 if(deplist.get(i).getDepcode()==""||deplist.get(i).getDepcode()==null||deplist.get(i).getDepname()==null||deplist.get(i).getDepname()==""){
        		 ch1="y1";//代表存在空值
//        	 System.out.println("检查部门代码或部门名称是否存在无效值");
        	 }
        	 if(deplist.get(i).getDepcode()!=null&&deplist.get(i).getDepname()!=null&&deplist.get(i).getDepcode()!=""&&deplist.get(i).getDepname()!=""){
        		 if(!(deplist.get(i).getDepcode().matches("^\\d+$$"))){
        			 ch2="h2";
        		 }
        	 for(int j=0;j<deplist.size();j++){
        		 if(i!=j){
        		 if(deplist.get(i).getDepcode().equals(deplist.get(j).getDepcode())||deplist.get(i).getDepname().equals(deplist.get(j).getDepname())){
        			 ch3="c3";//代表存在重复数据
        		 }
        		 }
        	 }
         }
         }
		 if(ch1=="y1"){
			 Integer currentPage=1;
				String condition="depcode";
				String text="";
				PageParameter pageParameter=PageParameter.NewInstance(currentPage);
				List<TDepartment> tDepartmentsList=adminDepartmentService.getDepByConditionWithPage(condition, text, pageParameter);
				modelAndView.addObject("tDepartmentsList", tDepartmentsList);
				modelAndView.addObject("pager", pageParameter);
				modelAndView.addObject("condition", condition);
				modelAndView.addObject("text", text);
				modelAndView.addObject("meg", "导入失败(检查是否存在无效数据)");
			modelAndView.setViewName("/departmentmanager/indexqll");
		    return modelAndView;
		 }
		 if(ch3=="c3"){
			 Integer currentPage=1;
				String condition="depcode";
				String text="";
				PageParameter pageParameter=PageParameter.NewInstance(currentPage);
				List<TDepartment> tDepartmentsList=adminDepartmentService.getDepByConditionWithPage(condition, text, pageParameter);
				modelAndView.addObject("tDepartmentsList", tDepartmentsList);
				modelAndView.addObject("pager", pageParameter);
				modelAndView.addObject("condition", condition);
				modelAndView.addObject("text", text);
				modelAndView.addObject("meg", "导入失败(检查是否存在重复数据)");
			modelAndView.setViewName("/departmentmanager/indexqll");
		    return modelAndView;
		 }
		 if(ch2=="h2"){
			 Integer currentPage=1;
				String condition="depcode";
				String text="";
				PageParameter pageParameter=PageParameter.NewInstance(currentPage);
				List<TDepartment> tDepartmentsList=adminDepartmentService.getDepByConditionWithPage(condition, text, pageParameter);
				modelAndView.addObject("tDepartmentsList", tDepartmentsList);
				modelAndView.addObject("pager", pageParameter);
				modelAndView.addObject("condition", condition);
				modelAndView.addObject("text", text);
				modelAndView.addObject("meg", "导入失败(检查导入的excel是否为文本格式)");
			modelAndView.setViewName("/departmentmanager/indexqll");
		    return modelAndView;
		 }
		 if(ch1=="f1"&&ch2=="f2"&&ch3=="f3"){
		 aminImportExcelService.importDepList(deplist);
			Integer currentPage=1;
			String condition="depcode";
			String text="";
			PageParameter pageParameter=PageParameter.NewInstance(currentPage);
			List<TDepartment> tDepartmentsList=adminDepartmentService.getDepByConditionWithPage(condition, text, pageParameter);
			modelAndView.addObject("tDepartmentsList", tDepartmentsList);
			modelAndView.addObject("pager", pageParameter);
			modelAndView.addObject("condition", condition);
			modelAndView.addObject("text", text);
			modelAndView.addObject("meg", "导入成功");
		modelAndView.setViewName("/departmentmanager/indexqll");
	    return modelAndView;
		 }
		return modelAndView;
	}
}
