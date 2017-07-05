package cn.bronze.controllers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.TAssetborrow;
import cn.bronze.entities.TDb;
import cn.bronze.services.AdminDbService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/AdminDbController")
public class AdminDbController {
	@Autowired
	public AdminDbService adminDbService;
/*
	@RequestMapping("/indexjyg")
	public ModelAndView indexjyg(
			 Integer currentPage
			){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/datacopy&renew/indexjyg");
		return modelAndView;
	}*/
	 /**
	   * 于立波
	   * 用于查询备份记录列表,只有超级管理员可以执行此操作
	   * @param currentPage 用于分页
	   * @return
	   */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)
	@RequestMapping("/indexjyg")
	public ModelAndView indexjyg(
			 Integer currentPage
			){
		 ModelAndView modelAndView=new ModelAndView();
		 List<TDb> dbList=new ArrayList<>();
		  currentPage = (currentPage!=null)?currentPage:1;
		  PageParameter pageParameter = PageParameter.NewInstance(currentPage);
		  dbList=adminDbService.getDbRecord(pageParameter);
		  modelAndView.addObject("pager",pageParameter);
		  modelAndView.addObject("dbList", dbList);
		  modelAndView.setViewName("/datacopy&renew/indexjyg");
		return modelAndView;
	}
	/**
	 * 于立波
	 * 备份数据库
	 * @param dbname
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@RequestMapping("/backupdb")
	public void backup(
			String dbname
			,String remark
			,String currentdate
			,HttpServletResponse response
			) throws IOException, ParseException{
		JSONObject jsonObject=new JSONObject();
		//查询是否存在相同的文件名
		String name=adminDbService.getName(dbname);
		//if(!(name.equals(dbname))){
		if(name==null){
			//保存记录
			//获取tomcat下webapps的地址
					System.out.println(getClass().getResource("/"));
					String classesPath=getClass().getResource("/").getPath();
					System.out.println(classesPath);
					int subIndex=classesPath.indexOf("/taxoffice");
					classesPath=classesPath.substring(0, subIndex);
					System.out.println(classesPath);
					System.out.println(System.getProperty("user.dir").replace("bin", "webapps"));
                     String fileDir=classesPath+"/Db";
                     String fileName=dbname+".sql";
                     File f = new File(fileDir,fileName);
                     if(f.exists()) {
                         System.out.println("文件已存在");
                       } else {
                         //  先创建文件所在的目录
                    	   f.getParentFile().mkdirs();
                           try {
                            // 创建新文件
                               f.createNewFile();
                               System.out.println("文件已创建"+f.getPath());
                               adminDbService.backupDb(f.getPath());
                           } catch (IOException e) {
                               System.out.println("创建新文件时出现了错误");
                               e.printStackTrace();
                           }
                       }
             //保存相关信息
              java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
             Date date =  formatter.parse(currentdate);
             TDb db=new TDb();
             db.setAdress(f.getPath());
             db.setDbname(dbname);
             db.setRemark(remark);
             db.setDbdate(date);
             String ch=adminDbService.saveRecord(db);
             if(ch=="ok"){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "当前数据库备份成功");
             }
             if(ch=="no"){
     			jsonObject.put("status", "no");
     			jsonObject.put("msge", "当前数据库备份失败");
                  }
		}
		if(name!=null&&name.equals(dbname)){
			jsonObject.put("status", "no1");
			jsonObject.put("msg1", "文件名已存在");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 于立波
	 * dbname 数据库文件
	 * 还原数据库
	 * @throws IOException 
	 */
	@RequestMapping("/recoverdb")
	public void recoverdb(
			String dbname
			,HttpServletResponse response
			) throws IOException{
		JSONObject jsonObject=new JSONObject();
		//根据dbname查出sql文件路径
		String classesPath=getClass().getResource("/").getPath();
		System.out.println(classesPath);
		int subIndex=classesPath.indexOf("/taxoffice");
		classesPath=classesPath.substring(0, subIndex);
		System.out.println(classesPath);
		 String fileDir=classesPath+"/Db";
         String fileName=dbname+".sql";
         File f = new File(fileDir,fileName);
         String filePath1=f.getPath().replaceAll("\\\\", "/");
         System.out.println("恢复路径："+filePath1);
//		 String filePath=adminDbService.getRecoverPath(dbname);
//         String filePath1=filePath.replaceAll("\\\\", "/");
	    //还原数据库
		String ch=adminDbService.recoverDb(filePath1);
		if(ch=="ok"){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "恢复成功");
		}
		if(ch=="no"){
			jsonObject.put("status", "no");
			jsonObject.put("msge", "恢复失败");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 于立波
	 * dbname 数据库文件
	 * 删除备份
	 * @throws IOException 
	 */
	@RequestMapping("/deletedb")
	public void deletedb(
			String dbname
			,HttpServletResponse response
			) throws IOException{
		JSONObject jsonObject=new JSONObject();
		//根据dbname查出sql文件路径
		String filePath=adminDbService.getRecoverPath(dbname);
		System.out.println("删除路径："+filePath);
		//删除对应文件
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
		String ch=adminDbService.deleteDb(dbname);
		if(ch=="ok"){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除成功");
		}
		if(ch=="no"){
			jsonObject.put("status", "no");
			jsonObject.put("msge", "删除失败");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
}
