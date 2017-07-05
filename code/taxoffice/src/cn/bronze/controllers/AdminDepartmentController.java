package cn.bronze.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExampleCumtom;
import cn.bronze.entities.TUserExtend;
import cn.bronze.services.AdminDepartmentService;
import cn.bronze.services.AdminUserManagerService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;


@Controller
@RequestMapping("/admindepartmentcontroller")
public class AdminDepartmentController {
	@Autowired
	private AdminDepartmentService adminDepartmentService;
	@Autowired
	private AdminUserManagerService adminUserManagerService;
	@RequestMapping("index")
	public ModelAndView index(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/departmentmanager/indexqll");
		return modelAndView;
		
	}
	/**
	 * 尼雷清
	 * 根据查询条件condition 显示部门信息
	 * @param currentpage 当前页数
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","checkauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/getdepbyconditionwithpage")
	public String getdepbyconditionwithpage(Model model,Integer currentPage,String condition,String text){
		if(currentPage==null){
			currentPage=1;
		}
		if(condition==null){
			condition="depcode";
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TDepartment> tDepartmentsList=adminDepartmentService.getDepByConditionWithPage(condition, text, pageParameter);
		model.addAttribute("tDepartmentsList", tDepartmentsList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("condition", condition);
		model.addAttribute("text", text);
		return "departmentmanager/indexqll";
	}
	/**
	 * 尼雷清
	 * 根据部门代码depcode显示该部门人员 同时需要返回查询部门的页面的时候回显先前的条件
	 * @param currentpage 当前页数  depcode 部门代码
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","checkauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/getuserbydep")
	public String getuserbydep(Model model,Integer currentPage,String depcode,String precondition,String pretext,Integer precurrentPage){
		if(currentPage==null){
			currentPage=1;
		}
		if(depcode==null){
			System.out.println("nlq:显示部门人员时，没有取到部门代码depcode!");
			return null;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TUserExtend> tUserExtendsList=adminDepartmentService.getUserByDepWithPage(depcode, pageParameter);
		model.addAttribute("tUserExtendsList", tUserExtendsList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("precondition", precondition);
		model.addAttribute("pretext", pretext);
		model.addAttribute("precurrentPage", precurrentPage);
		model.addAttribute("depcode", depcode);
		return "departmentmanager/check";
	}
	/**
	 * 尼雷清
	 * 执行添加部门信息
	 * @param String depcode,depname,depstate 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/adddep")
	public void adddep(String depcode,String depname,String depstate,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminDepartmentService.addDep(depcode, depname, depstate);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "添加部门成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "添加部门失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 执行添加部门人员信息
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/adddepuserbydepcode")
	public void adddepuserbydepcode(String depcode,String useraccount,String userpassword,String username,String usercode,String usersex,String userduty,Integer userrole,String usertype,String userstate,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminDepartmentService.addDepUserByDepCode(depcode, useraccount, userpassword, username, usercode, usersex, userduty, userrole, usertype, userstate);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "添加人员成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "添加人员失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 设置查询下拉菜单赋值需要的Jsonarray
	 * @param 
	 * @return
	 */
	@RequestMapping("/getdepjson")
	public void getdepjson(String condition,HttpServletResponse response) throws IOException{
		if(condition==null){
			System.out.println("nlq:查询条件为空!");
		}else{
			JSONArray jsonArray=new JSONArray();
			jsonArray=adminDepartmentService.getDepJson(condition);
			JsonResponse.PrintJsonList(response, jsonArray);
		}
	}
	/***
	 * 尼雷清
	 * 添加部门代码合法性验证      isadddepcodelegal
	 * @param depcode
	 * @param response
	 * @return 
	 */
	@RequestMapping("/isadddepcodelegal")
	public void isadddepcodelegal(String depcode,HttpServletResponse response)throws IOException{
		if(depcode==null){
			System.out.println("nlq：添加部门代码合法性验证时没有取到depcode!");
		}else{
			JSONObject jsonObject=new JSONObject();
			boolean m=adminDepartmentService.isDepCodeLegal(depcode);
			if(m==true){
				jsonObject.put("status", "ok");
				jsonObject.put("msg", "部门代码合法！");
			}else{
				jsonObject.put("status", "no");
				jsonObject.put("msg", "该部门代码已存在！");
			}
			JsonResponse.PrintJsonOne(response, jsonObject);
		}
	}
	/***
	 * 尼雷清
	 * 添加部门名称合法性验证      isadddepnamelegal
	 * @param depname
	 * @param response
	 * @return 
	 */
	@RequestMapping("/isadddepnamelegal")
	public void isadddepnamelegal(String depname,HttpServletResponse response)throws IOException{
		if(depname==null){
			System.out.println("nlq：添加部门名称合法性验证时没有取到depname!");
		}else{
			JSONObject jsonObject=new JSONObject();
			boolean m=adminDepartmentService.isDepNameLegal(depname);
			if(m==true){
				jsonObject.put("status", "ok");
				jsonObject.put("msg", "部门名称合法！");
			}else{
				jsonObject.put("status", "no");
				jsonObject.put("msg", "该部门名称已存在！");
			}
			JsonResponse.PrintJsonOne(response, jsonObject);
		}
	}
	/***
	 * 尼雷清
	 * 添加人员代码合法性验证      isusercodelegal
	 * @param usercode
	 * @param response
	 * @return 
	 */
	@RequestMapping("/isusercodelegal")
	public void isusercodelegal(String usercode,HttpServletResponse response)throws IOException{
		if(usercode==null){
			System.out.println("nlq：添加部门代码合法性验证时没有取到depcode!");
		}else{
			JSONObject jsonObject=new JSONObject();
			boolean m=adminDepartmentService.isUserCodeLegal(usercode);
			if(m==true){
				jsonObject.put("status", "ok");
				jsonObject.put("msg", "人员代码合法！");
			}else{
				jsonObject.put("status", "no");
				jsonObject.put("msg", "该人员代码已存在！");
			}
			JsonResponse.PrintJsonOne(response, jsonObject);
		}
	}
	/***
	 * 尼雷清
	 * 添加人员用户名合法性验证      isuseraccountlegal
	 * @param usercode
	 * @param response
	 * @return 
	 */
	@RequestMapping("/isuseraccountlegal")
	public void isuseraccountlegal(String useraccount,HttpServletResponse response)throws IOException{
		if(useraccount==null){
			System.out.println("nlq：添加部门代码合法性验证时没有取到depcode!");
		}else{
			JSONObject jsonObject=new JSONObject();
			boolean m=adminDepartmentService.isUserAccountLegal(useraccount);
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
	 * 修改编辑部门代码合法性验证      iseditadddepcodelegal
	 * @param depcode
	 * @param response
	 * @return 
	 */
	@RequestMapping("/iseditadddepcodelegal")
	public void iseditadddepcodelegal(String depcode,String predepcode,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		if(depcode.equals(predepcode)==true){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "部门代码合法！");
		}else{
			boolean m=adminDepartmentService.isDepCodeLegal(depcode);
			if(m==true){
				jsonObject.put("status", "ok");
				jsonObject.put("msg", "部门代码合法！");
			}else{
				jsonObject.put("status", "no");
				jsonObject.put("msg", "该部门代码已存在！");
			}
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/***
	 * 尼雷清
	 * 修改编辑部门名称合法性验证      iseditadddepnamelegal
	 * @param depcode
	 * @param response
	 * @return 
	 */
	@RequestMapping("/iseditadddepnamelegal")
	public void iseditadddepnamelegal(String depname,String predepname,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		if(depname.equals(predepname)==true){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "部门名称合法！");
		}else{
			boolean m=adminDepartmentService.isDepNameLegal(depname);
			if(m==true){
				jsonObject.put("status", "ok");
				jsonObject.put("msg", "部门名称合法！");
			}else{
				jsonObject.put("status", "no");
				jsonObject.put("msg", "该部门名称已存在！");
			}
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 执行删除人员信息
	 * @param Integer userid 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/deleteuserbydep")
	public void deleteuserbydep(Integer userid,Integer currentPage,String depcode,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminDepartmentService.deleteUserByDep(userid);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TUserExtend> tUserExtendsList=adminDepartmentService.getUserByDepWithPage(depcode, pageParameter);
		if(tUserExtendsList.size()==0&&currentPage>1){
			jsonObject.put("issubcurrentPage", "ok");
		}else {
			jsonObject.put("issubcurrentPage", "no");
		}
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除成功！");
		}else{
				jsonObject.put("status", "no");
				jsonObject.put("msg", "删除失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 执行编辑部门信息
	 * @param Integer userid 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/updatedep")
	public void updatedep(Integer depid, String depcode,String depname,String depstate,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminDepartmentService.updateDep(depid, depcode, depname, depstate);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "编辑成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "编辑失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 执行删除部门信息
	 * @param Integer dep_id 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)//设置权限
	@RequestMapping("/deletedep")
	public void deletedep(Integer depid,Integer currentPage,String condition,String text,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminDepartmentService.deleteDep(depid);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TDepartment> tDepartmentsList=adminDepartmentService.getDepByConditionWithPage(condition, text, pageParameter);
		if(tDepartmentsList.size()==0&&currentPage>1){
			jsonObject.put("issubcurrentPage", "ok");
		}else {
			jsonObject.put("issubcurrentPage", "no");
		}
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除成功！");
		}else{
			if(record==0){
				jsonObject.put("status", "no");
				jsonObject.put("msg", "该部门下存在员工无法删除，请删除员工后再进行操作！");
			}else{
				jsonObject.put("status", "no");
				jsonObject.put("msg", "删除失败！");
			}
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	
	/**
	 * 尼雷清
	 * 查询显示员工信息页面的总人数
	 * @param 
	 * @return
	 */
	@RequestMapping("/gettotalcount")
	public void gettotalcount(Integer currentPage,String condition,String text,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TDepartment> tDepartmentsList=adminDepartmentService.getDepByConditionWithPage(condition, text, pageParameter);
		int record=tDepartmentsList.size();//若查出数据总数为0，那么返回no  否则返回ok
		if(record>0){
			jsonObject.put("status", "ok");
		}else{
			if(currentPage==1){
				jsonObject.put("status", "ok");
			}else{
				jsonObject.put("status", "no");
			}	
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	@RequestMapping("/check")
	public ModelAndView check(){
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.setViewName("/departmentmanager/check");
		return modelAndView;
		
	}
	/**
	 * 尼雷清
	 * 资产表中 根据部门名称显示对应部门人员的方法
	 * @param 
	 * @return
	 */
	@RequestMapping("/getusernamebyassetdep")
	public void getusernamebyassetdep(String depname,HttpServletResponse response) throws IOException{
		if(depname==null){
			System.out.println("nlq:查询条件为空!");
		}else{
			JSONArray jsonArray=new JSONArray();
			jsonArray=adminDepartmentService.getUserNameByAssetDep(depname);
			JsonResponse.PrintJsonList(response, jsonArray);
		}
	}
	/**
	 * 尼雷清
	 * 根据depcode 查询对应该部门下的人员姓名的jsonarray
	 * @param 
	 * @return
	 */
	@RequestMapping("/getusernamebydepcode")
	public void getusernamebydepcode(String depcode,HttpServletResponse response) throws IOException{
		if(depcode==null){
			System.out.println("nlq:部门代码为空!");
		}else{
			JSONArray jsonArray=new JSONArray();
			jsonArray=adminDepartmentService.getUserNameByDepcode(depcode);
			JsonResponse.PrintJsonList(response, jsonArray);
		}
	}
}
