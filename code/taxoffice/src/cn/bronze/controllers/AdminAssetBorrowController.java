package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.TAssetborrow;
import cn.bronze.services.AdminAssetBorrowService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/AdminAssetBorrowController")
public class AdminAssetBorrowController {
	@Autowired
	public AdminAssetBorrowService adminAssetBorrowService;
	/**
	 * 于立波
	 * 显示addborrow
	 */
	@RequiresPermissions(value={"assetauth","checkauth","sysauth"},logical=Logical.OR)
	@RequestMapping("/index")
	public ModelAndView addborrow(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/assetborrow/borrow/addborrow");
		return modelAndView;
	}
	 /**
	   * 于立波
	   * 用于查询归还记录列表
	   * @param currentPage 用于分页
	   * @return
	   */
	@RequiresPermissions(value={"assetauth","checkauth","sysauth"},logical=Logical.OR)
	@RequestMapping("/showborrow")
	public ModelAndView showborrow(
			 Integer currentPage
			){
		 ModelAndView modelAndView=new ModelAndView();
		 List<TAssetborrow> assetBorrowList=new ArrayList<>();
		  currentPage = (currentPage!=null)?currentPage:1;
		  PageParameter pageParameter = PageParameter.NewInstance(currentPage);
		  assetBorrowList=adminAssetBorrowService.getAssetBorrowList(pageParameter);
		  modelAndView.addObject("pager",pageParameter);
		  modelAndView.addObject("assetBorrowList", assetBorrowList);
		modelAndView.setViewName("/assetborrow/borrow/showborrow");
		return modelAndView;
	}
	 /**
	   * 于立波
	   * assetBorrow  借用记录
	   * 保存借用记录
	 * @throws IOException 
	   */
	@RequiresPermissions(value={"assetauth","sysauth"},logical=Logical.OR)
	  @RequestMapping("/saveassetborrowrecord")
	  public void saveassetborrowrecord(
			  TAssetborrow assetBorrow,
			  HttpServletResponse response
			  ) throws IOException{
		    JSONObject jsonObject = new JSONObject();
            //验证资产的状态
		    String checkResult=adminAssetBorrowService.checkAssetState(assetBorrow.getAssetcode());
		    if(checkResult.equals("在用")){
		    	jsonObject.put("msg", "资产状态为在用");
				JsonResponse.PrintJsonOne(response, jsonObject);
		    }
		    if(checkResult.equals("损坏不能用")){
		    	jsonObject.put("msg", "资产损坏不能用");
				JsonResponse.PrintJsonOne(response, jsonObject);
		    }
		    if(checkResult.equals("闲置")){
		    //保存借用记录
		    adminAssetBorrowService.saveBorrowRecord(assetBorrow);
		    //把资产的状态改为在用
		    adminAssetBorrowService.changeAssetState(assetBorrow.getAssetcode());
			jsonObject.put("msg", "保存成功");
			JsonResponse.PrintJsonOne(response, jsonObject);
		    }
	  }
	  /**
	   * 于立波
	   * assetcode 资产编码
	   * 监听资产编码的变化
	   */
	  @RequestMapping("/listenassetcode")
	  public void  listenassetcode(
			  String assetcode, 
			  HttpServletResponse response
			  )
				throws IOException {
			JSONObject jsonObject = new JSONObject();
			List<String>  assetcodelist = adminAssetBorrowService.getAssetcode(assetcode);
			jsonObject.put("assetcodelist",  assetcodelist);
			JsonResponse.PrintJsonOne(response, jsonObject);
	   }
	  /**
	   * 于立波
	   * assetcode 资产编码
	   * 根据assetcode查出对应的assetname
	   */
	  @RequestMapping("/getassetname")
	  public void  getassetname(
			  String assetcode, 
			  HttpServletResponse response
			  )
				throws IOException {
			JSONObject jsonObject = new JSONObject();
			String  assetname = adminAssetBorrowService.getAssetname(assetcode);	
			if(assetname!=null){
			jsonObject.put("state", "1");	
			jsonObject.put("assetname",  assetname);
			}
			if(assetname==null){
				jsonObject.put("state", "0");	
				}
			JsonResponse.PrintJsonOne(response, jsonObject);
	   }
	  @RequestMapping("/getassetcodejson2")
		public void getassetcodejson2(
				String assetname
				,HttpServletResponse response
				) throws IOException{
			JSONArray jsonArray=new JSONArray();
         	jsonArray=adminAssetBorrowService.getAssetcode2Json(assetname);
			JsonResponse.PrintJsonList(response, jsonArray);
		}
	  @RequestMapping("/getassetcode")
	  public void  getassetcode(
			  String assetname, 
			  HttpServletResponse response
			  )
				throws IOException {
			JSONObject jsonObject = new JSONObject();
			List<String>  assetcode = adminAssetBorrowService.getAssetcode1(assetname);	
			if(assetname!=null){
			jsonObject.put("state", "1");	
			jsonObject.put("assetcode",  assetcode);
			}
			if(assetname==null){
				jsonObject.put("state", "0");	
				}
			JsonResponse.PrintJsonOne(response, jsonObject);
	   }
	  @RequestMapping("/getassetcode2")
	  public void  getassetcode2(
			  String assetcode, 
			  HttpServletResponse response
			  )
				throws IOException {
			JSONObject jsonObject = new JSONObject();
			String  assetcode2= adminAssetBorrowService.getAssetcode2(assetcode);	
			if(assetcode2!=null){
			jsonObject.put("state", "0");	
			}
			if(assetcode2==null){
				jsonObject.put("state", "1");	
				}
			JsonResponse.PrintJsonOne(response, jsonObject);
	   }
	  @RequestMapping("/getassetname3")
	  public void  getassetname3(
			  String assetname, 
			  HttpServletResponse response
			  )
				throws IOException {
			JSONObject jsonObject = new JSONObject();
			List<String>  assetname3= adminAssetBorrowService.getAssetname3(assetname);	
			if(assetname3!=null){
			jsonObject.put("state", "0");	
			}
			if(assetname3==null){
				jsonObject.put("state", "1");	
				}
			JsonResponse.PrintJsonOne(response, jsonObject);
	   }
	  /**
		 * 于立波
		 * 下拉菜单赋值需要的Jsonarray
		 * @param 
		 * @return
		 */
		@RequestMapping("/getassetcodejson")
		public void getassetcodejson(
				HttpServletResponse response
				) throws IOException{
			JSONArray jsonArray=new JSONArray();
			jsonArray=adminAssetBorrowService.getAssetcodeJson();
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		@RequestMapping("/getborrowdepjson")
		public void getborrowdepjson(
				HttpServletResponse response
				) throws IOException{
			JSONArray jsonArray=new JSONArray();
			jsonArray=adminAssetBorrowService.getBorrowdepJson();
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		@RequestMapping("/getdepartmentpeoplejson")
		public void getdepartmentpeoplejson(
				String borrowdep
				,HttpServletResponse response
				) throws IOException{
			//borrowdep = new String(borrowdep.getBytes("iso8859-1"),"UTF-8");
			JSONArray jsonArray=new JSONArray();
			//查询部门代码`
			String departmentCode=adminAssetBorrowService.getdepartmentCode(borrowdep);
			//根据部门代码查出人员信息
           	jsonArray=adminAssetBorrowService.getUsernameJson(departmentCode);
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		@RequestMapping("/getborrowpeoplejson")
		public void getborrowpeoplejson(
				HttpServletResponse response
				) throws IOException{
			JSONArray jsonArray=new JSONArray();
           	jsonArray=adminAssetBorrowService.getBorrowpeopleJson();
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		//查出所有的aasetcode
		@RequestMapping("/getallassetcodejson")
		public void getallassetcodejson(
				HttpServletResponse response
				) throws IOException{
			JSONArray jsonArray=new JSONArray();
           	jsonArray=adminAssetBorrowService.getAllAssetcodeJson();
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		//查出所有的aasetname
				@RequestMapping("/getallassetnamejson")
				public void getallassetnamejson(
						HttpServletResponse response
						) throws IOException{
					JSONArray jsonArray=new JSONArray();
		           	jsonArray=adminAssetBorrowService.getAllAssetnameJson();
					JsonResponse.PrintJsonList(response, jsonArray);
				}
				//查出状态为闲置的aasetname
				@RequestMapping("/getassetnamejson1")
				public void getassetnamejson1(
						HttpServletResponse response
						) throws IOException{
					JSONArray jsonArray=new JSONArray();
		           	jsonArray=adminAssetBorrowService. getAssetnameJson1();
					JsonResponse.PrintJsonList(response, jsonArray);
				}
				//根据借出人选借出部门
				@RequestMapping("/getborrowpeople")
				public void  getborrowpeople(
						  String borrowpeople, 
						  HttpServletResponse response
						  )
							throws IOException {
						JSONObject jsonObject = new JSONObject();
						String  borrowdep = adminAssetBorrowService.getBorrowdep1(borrowpeople);	
						if(borrowdep!=null){
						String  borrowdepname = adminAssetBorrowService.getBorrowdepName1(borrowdep);	
						jsonObject.put("state", "1");	
						jsonObject.put("borrowdepname",  borrowdepname);
						}
						if(borrowdep==null){
							jsonObject.put("state", "0");	
							}
						JsonResponse.PrintJsonOne(response, jsonObject);
				   }
}
