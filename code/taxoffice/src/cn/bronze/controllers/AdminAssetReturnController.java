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

import cn.bronze.entities.Asset;
import cn.bronze.entities.TAssetborrow;
import cn.bronze.entities.TBack;
import cn.bronze.services.AdminAssetBorrowService;
import cn.bronze.services.AdminAssetReturnService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/AdminAssetReturnController")
public class AdminAssetReturnController {
	@Autowired
	public AdminAssetReturnService adminAssetReturnService;
	@Autowired
	public AdminAssetBorrowService adminAssetBorrowService;
/**
 * 于立波
 * 显示addreturn界面
 * @return
 */
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();	
		modelAndView.setViewName("/assetborrow/return/addreturn");
		return modelAndView;
	}
	 /**
	   * 于立波
	   * 用于查询归借用录列表
	   * @param currentPage 用于分页
	   * @return
	   */
	@RequiresPermissions(value={"assetauth","checkauth","sysauth"},logical=Logical.OR)
	@RequestMapping("/showreturn")
	public ModelAndView showborrow(
			 Integer currentPage
			){
		 ModelAndView modelAndView=new ModelAndView();
		 List<TBack> assetReturnList=new ArrayList<>();
		  currentPage = (currentPage!=null)?currentPage:1;
		  PageParameter pageParameter = PageParameter.NewInstance(currentPage);
		  assetReturnList=adminAssetReturnService.getAssetReturnList(pageParameter);
		  modelAndView.addObject("pager",pageParameter);
		  modelAndView.addObject("assetReturnList", assetReturnList);
		modelAndView.setViewName("/assetborrow/return/showreturn");
		return modelAndView;
	}
	 /**
	   * 于立波
	   * assetReturn  归还记录
	   * 保存归还记录
	 * @throws IOException 
	   */
	@RequiresPermissions(value={"assetauth","sysauth"},logical=Logical.OR)
	  @RequestMapping("/saveassetreturnrecord")
	  public void saveassetreturnrecord(
			  TBack assetReturn,
			  HttpServletResponse response
			  ) throws IOException{
		    JSONObject jsonObject = new JSONObject();
          //验证资产的状态
		 TAssetborrow assetborrow=adminAssetBorrowService.getcheck1(assetReturn.getBorrownum());
		  if(assetborrow==null){
			  jsonObject.put("state", "0");	
		  }
		  if(assetborrow!=null){
			  String  bo=assetReturn.getBorrownum();
			  String ac=assetReturn.getAssetcode();
			  String an=assetReturn.getAssetname();
			  String bp=assetReturn.getBackpeople();
			  String  bo1=assetborrow.getBorrownum();
			  String ac1=assetborrow.getAssetcode();
			  String an1=assetborrow.getAssetname();
			  String bp1=assetborrow.getBorrowpeople();
//			  if(bo.equals(bo1)&&ac.equals(ac1)&&an.equals(an1)&&bp.equals(bp1)){
			  if(bo.equals(bo1)&&ac.equals(ac1)&&an.equals(an1)){
				    //保存借用记录    	
				    adminAssetReturnService.saveReturnRecord(assetReturn);  
				    //删除对应的借用记录
				    adminAssetReturnService.deleteReturnRecord(assetReturn.getBorrownum());  
				    //把资产的状态改为在用
				    adminAssetReturnService.changeAssetState(assetReturn.getAssetcode());
				  jsonObject.put("state", "1");	
			  }
			  else{
				  jsonObject.put("state", "0");	
			  }
		  }		  
				JsonResponse.PrintJsonOne(response, jsonObject); 
//		    String checkResult=adminAssetBorrowService.checkAssetState(assetReturn.getAssetcode());
//		    if(checkResult.equals("闲置")){
//		    	jsonObject.put("msg", "资产状态为闲置");
//				JsonResponse.PrintJsonOne(response, jsonObject);
//		    }
//		    if(checkResult.equals("损坏不能用")){
//		    	jsonObject.put("msg", "资产损坏不能用");
//				JsonResponse.PrintJsonOne(response, jsonObject);
//		    }
//		    if(checkResult.equals("在用")){
//		    //保存借用记录    	
//		    adminAssetReturnService.saveReturnRecord(assetReturn);  
//		    //删除对应的借用记录
//		    adminAssetReturnService.deleteReturnRecord(assetReturn.getBorrownum());  
//		    //把资产的状态改为在用
//		    adminAssetReturnService.changeAssetState(assetReturn.getAssetcode());
//			jsonObject.put("msg", "归还成功");
//			JsonResponse.PrintJsonOne(response, jsonObject);
//		    }
	  }
	  /**
	   * 于立波
	   * borrownum  借出编号
	   * 根据borrownum查出对应的assetinfo
	   */
	  @RequestMapping("/getassetinfo")
	  public void  getassetinfo(
			  String borrownum, 
			  HttpServletResponse response
			  )
				throws IOException {
			JSONObject jsonObject = new JSONObject();
			String assetcode= adminAssetReturnService.getAssetcode(borrownum);	
			String assetname= adminAssetReturnService.getAssetname(borrownum);
			String borrowpeople=adminAssetReturnService.getBorrowpeople(borrownum);
			if(assetcode!=""&&assetcode!=null&&assetname!=""&&assetname!=null&&borrowpeople!=""&&borrowpeople!=null){
			jsonObject.put("state", "1");	
			jsonObject.put("assetcode",  assetcode);
			jsonObject.put("assetname",  assetname);
			jsonObject.put("borrowpeople",  borrowpeople);
			}
			else{
				jsonObject.put("state", "0");	
				}
			JsonResponse.PrintJsonOne(response, jsonObject);
	   }
	  /**
	   * 于立波
	   * 查询归还人
	   * @param response
	   * @throws IOException
	   */
		@RequestMapping("/getborrowpeoplejson")
		public void getborrowpeoplejson(
				HttpServletResponse response
				) throws IOException{
			JSONArray jsonArray=new JSONArray();
         	jsonArray=adminAssetReturnService.getBorrowpeopleJson();
			JsonResponse.PrintJsonList(response, jsonArray);
		}
		/**
		   * 于立波
		   * 查询借出单号
		   * @param response
		   * @throws IOException
		   */
			@RequestMapping("/getborrownumjson")
			public void getborrownumjson(
					HttpServletResponse response
					) throws IOException{
				JSONArray jsonArray=new JSONArray();
	         	jsonArray=adminAssetReturnService.getBorrownumJson();
				JsonResponse.PrintJsonList(response, jsonArray);
			}
			
			//查出aasetname(资产借用表)
			@RequestMapping("/getassetnamejsonre")
			public void getassetnamejsonre(
					HttpServletResponse response
					) throws IOException{
				JSONArray jsonArray=new JSONArray();
	           	jsonArray=adminAssetReturnService. getAssetnamejsonre();
				JsonResponse.PrintJsonList(response, jsonArray);
			}
			
			//查出aasetname(资产借用表)
			@RequestMapping("/getassetcodejsonre")
			public void getassetcodejsonre(
					HttpServletResponse response
					) throws IOException{
				JSONArray jsonArray=new JSONArray();
	           	jsonArray=adminAssetReturnService. getAssetcodejsonre();
				JsonResponse.PrintJsonList(response, jsonArray);
			}
			
			
			@RequestMapping("/getassetinfo1")
			  public void  getassetinfo1(
					  String assetcode, 
					  HttpServletResponse response
					  )
						throws IOException {
					JSONObject jsonObject = new JSONObject();
					String borrownum= adminAssetReturnService.getBorrownum1(assetcode);	
					String assetname= adminAssetReturnService.getAssetname1(assetcode);
					String borrowpeople=adminAssetReturnService.getBorrowpeople1(assetcode);
					if(borrownum!=""&&borrownum!=null&&assetname!=""&&assetname!=null&&borrowpeople!=""&&borrowpeople!=null){
					jsonObject.put("state", "1");	
					jsonObject.put("borrownum",  borrownum);
					jsonObject.put("assetname",  assetname);
					jsonObject.put("borrowpeople",  borrowpeople);
					}
					else{
						jsonObject.put("state", "0");	
						}
					JsonResponse.PrintJsonOne(response, jsonObject);
			   }
			
			@RequestMapping("/getassetinfo2")
			  public void  getassetinfo2(
					  String assetname, 
					  HttpServletResponse response
					  )
						throws IOException {
					JSONObject jsonObject = new JSONObject();
					List<String> borrownum= adminAssetReturnService.getBorrownum2(assetname);	
					List<String> assetcode= adminAssetReturnService.getAssetcode2(assetname);
					List<String> borrowpeople=adminAssetReturnService.getBorrowpeople2(assetname);
					if(borrownum.size()!=0&&assetcode.size()!=0&&borrowpeople.size()!=0){
					jsonObject.put("state", "1");	
					jsonObject.put("borrownum",  borrownum);
					jsonObject.put("assetcode",  assetcode);
					jsonObject.put("borrowpeople",  borrowpeople);
					}
					else{
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
	         	jsonArray=adminAssetReturnService.getAssetcode2Json(assetname);
				JsonResponse.PrintJsonList(response, jsonArray);
			}
			@RequestMapping("/getborrownumjson2")
			public void getborrownumjson2(
					String assetname
					,HttpServletResponse response
					) throws IOException{
				JSONArray jsonArray=new JSONArray();
	         	jsonArray=adminAssetReturnService.getBorrownum2Json(assetname);
				JsonResponse.PrintJsonList(response, jsonArray);
			}
			@RequestMapping("/getbackpeoplejson2")
			public void getbackpeoplejson2(
					String assetname
					,HttpServletResponse response
					) throws IOException{
				JSONArray jsonArray=new JSONArray();
	         	jsonArray=adminAssetReturnService.getBackpeople2Json(assetname);
				JsonResponse.PrintJsonList(response, jsonArray);
			}
}
