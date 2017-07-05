package cn.bronze.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetType;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExtend;
import cn.bronze.log.Log;
import cn.bronze.log.LogModule;
import cn.bronze.services.AdminUserManagerService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;


@Controller
@RequestMapping("/adminusermanagercontroller")
public class AdminUserManagerController {
	@Autowired
	private AdminUserManagerService adminUserManagerService;
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.setViewName("/usermanager/getusersby");
		return modelAndView;
		
	}


	/**
	 * 尼雷清
	 * 根据查询条件显示用户信息
	 * @param currentpage 当前页数
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","checkauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/getuserbyconditionwithpage")
	public String getuserbyconditionwithpage(Model model,Integer currentPage,String condition,String text){
		if(currentPage==null){
			currentPage=1;
		}
		if(condition==null){
			condition="useraccount";
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TUserExtend> tUserExtendsList=adminUserManagerService.getUserByConditionWithPage(condition, text, pageParameter);
		model.addAttribute("tUserExtendsList", tUserExtendsList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("condition", condition);
		model.addAttribute("text", text);
		return "usermanager/getusersby";
	}
	/**
	 * 尼雷清
	 * 设置权限下拉菜单赋值需要的Jsonarray
	 * @param 
	 * @return
	 */
	@RequestMapping("/getuserrolejson")
	public void getuserrolejson(HttpServletResponse response) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminUserManagerService.getUserRoleJson();
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	
	/**
	 * 尼雷清
	 * 设置查询下拉菜单赋值需要的Jsonarray
	 * @param 
	 * @return
	 */
	@RequestMapping("/getuserjson")
	public void getuserjson(String condition,HttpServletResponse response) throws IOException{
		if(condition==null){
			System.out.println("nlq:查询条件为空!");
		}
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminUserManagerService.getUserJson(condition);
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	/**
	 * 尼雷清
	 * 显示修改页面对应的部门信息的Jsonarray
	 * @param 
	 * @return
	 */
	@RequestMapping("/getdepjson")
	public void getdepjson(HttpServletResponse response) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminUserManagerService.getDepJson();
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	/**
	 * 尼雷清
	 * 显示修改页面对应的职务信息的Jsonarray
	 * @param 
	 * @return
	 */
	@RequestMapping("/getdutyjson")
	public void getdutyjson(HttpServletResponse response) throws IOException{
		JSONArray jsonArray=new JSONArray();
		jsonArray=adminUserManagerService.getDutyJson();
		JsonResponse.PrintJsonList(response, jsonArray);
	}
	/***
	 * 尼雷清
	 * 执行修改用户角色      updateuserrole
	 * @param userid(Integer)
	 * @param role(Integer)
	 * @return 
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/updateuserrole")
	public void updateuserrole(Integer userid,Integer role,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminUserManagerService.updateUserRole(userid, role);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "设置权限成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "设置权限失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 显示用户修改页面   
	 * @param precurrentpage 当前页数
	 * @return
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/showedituser")
	public String showedituser(Model model,Integer id,Integer precurrentPage,String condition,String text){
		if(precurrentPage==null){
			precurrentPage=1;
		}
		if(condition==null){
			condition="useraccount";
		}
		TUser tUser=adminUserManagerService.selectUserById(id);
		model.addAttribute("id", id);
		model.addAttribute("tUser", tUser);
		model.addAttribute("precurrentPage", precurrentPage);
		model.addAttribute("condition", condition);
		model.addAttribute("text", text);
		return "usermanager/edituser";
	}
	/***
	 * 尼雷清
	 * 修改用户名合法性验证      isuseraccountlegal
	 * @param typename
	 * @param response
	 * @return 
	 */
	@RequestMapping("/isuseraccountlegal")
	public void isuseraccountlegal(String useraccount,String preuseraccount,HttpServletResponse response)throws IOException{
		if(useraccount==null){
			System.out.println("nlq：用户名合法性验证时没有取到useraccount!");
		}else{
			JSONObject jsonObject=new JSONObject();
			boolean m=adminUserManagerService.isUserAccountLegal(useraccount, preuseraccount);
			if(m==true){
				jsonObject.put("status", "ok");
				jsonObject.put("msg", "用户名合法！");
			}else{
				jsonObject.put("status", "no");
				jsonObject.put("msg", "该用户名已存在！");
			}
			JsonResponse.PrintJsonOne(response, jsonObject);
		}
	}
	/***
	 * 尼雷清
	 * 修改人员代码合法性验证      isusercodelegal
	 * @param typename
	 * @param response
	 * @return 
	 */
	@RequestMapping("/isusercodelegal")
	public void isusercodelegal(String usercode,String preusercode,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		boolean m=adminUserManagerService.isUserCodeLegal(usercode, preusercode);
		if(m==true){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "人员代码合法！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "该人员代码已存在！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/***
	 * 尼雷清
	 * 执行修改用户信息      updateuser
	 * @param userid(Integer)
	 * @param role(Integer)
	 * @return 
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/updateuser")
	public void updateuser(Integer userid,String useraccount,String userpassword,String username,String usercode,String usersex,String userdep,String userduty,String usertype,String userstate,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminUserManagerService.updateUserByTUser(userid, useraccount, userpassword, username, usercode, usersex, userdep, userduty, usertype, userstate);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "修改成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "修改失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	@RequestMapping("/showedituserbyid")
	public ModelAndView showedituserbyid(){
		
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.setViewName("/usermanager/edituser");
		return modelAndView;
		
	}
	
	
	
}
