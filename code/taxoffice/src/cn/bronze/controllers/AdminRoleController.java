package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.TRole;
import cn.bronze.services.AdminAuthService;
import cn.bronze.services.AdminRoleAndAuthService;
import cn.bronze.services.AdminRoleService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/AdminRoleController")
public class AdminRoleController {

	
	@Autowired
	private AdminRoleService adminRoleService;
	@Autowired
	private AdminAuthService adminAuthService;
	
	@Autowired
	private AdminRoleAndAuthService adminRoleAndAuthService;
	
	/*
	 * 展示所有角色即其他权限的页面
	 * */
	@RequiresPermissions(value={"sysauth"},logical=Logical.OR)
	@RequestMapping("/index")
	public ModelAndView index(Integer currentPage){
		ModelAndView modelAndView=new ModelAndView();
		
		currentPage=(currentPage!=null)?currentPage:1;
		PageParameter page=PageParameter.NewInstance(currentPage);
		List<TRole>roles=adminRoleService.getroleswithpage(page);
		
		modelAndView.addObject("roles", roles);
		modelAndView.addObject("pager", page);
		modelAndView.setViewName("/systemadmin/propertymanage/showrolemanage");		
		return modelAndView;
	}
	
	/*
	 * 
	 * 添加角色
	 * */
	@RequestMapping("/addrole")
	public void addrole(String rolename,HttpServletResponse response){
		
		JSONObject jsonObject = new JSONObject();
		//验证是否有该角色
		boolean isexit=adminRoleService.getrolebyrolename(rolename);
		
		if(isexit){
			jsonObject.put("status", "2");
			try {
				JsonResponse.PrintJsonOne(response, jsonObject);
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		boolean status=adminRoleService.addrole(rolename);
		//System.out.println("asset的typeName="+asset.getType());
		//int record = adminAssetService.updateByPrimaryKey(asset);
		if(status){
			jsonObject.put("status", "1");
			//jsonObject.put("assetCurrentPage", assetCurrentPage);
			//jsonObject.put("msg", "修改成功");
		}else {
			jsonObject.put("status", "0");
			//jsonObject.put("assetCurrentPage", assetCurrentPage);
			//jsonObject.put("msg", "修改失败");
		}
		try {
			JsonResponse.PrintJsonOne(response, jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/*
	 * 
	 * 删除某个角色
	 * 
	 * */
	
	@RequestMapping("deleterolebyid")
	public void deleterolebyid(int roleid,HttpServletResponse response){
		
		boolean status=adminRoleService.deleterolebyid(roleid);
		
		JSONObject jsonObject=new JSONObject();
		
		if(status){
			jsonObject.put("status", "1");
			try {
				JsonResponse.PrintJsonOne(response, jsonObject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else{
			jsonObject.put("status", "0");
			try {
				JsonResponse.PrintJsonOne(response, jsonObject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	/*
	 *
	 * 根据id值更新对应角色名字，重命名功能
	 * */
	@RequestMapping("updaterolebyid")
	public void updaterolebyid(TRole role,HttpServletResponse response){
		boolean status=adminRoleService.updaterolebyrolename(role);
		JSONObject jsonObject=new JSONObject();

		if(status){
			jsonObject.put("status", "1");
			try {
				JsonResponse.PrintJsonOne(response, jsonObject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else{
			jsonObject.put("status", "0");
			try {
				JsonResponse.PrintJsonOne(response, jsonObject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
	}
	
	
	/*
	 * 为角色添加权限
	 * 
	 * @para rolename 角色名字
	 * @para authStr 传过来权限的集合字符串
	 * */
	
	@RequestMapping("addauthtorole")
	public void addauthtorole(String rolename,String authStr,HttpServletResponse response){	
		List<String> authlist=new ArrayList<>();
		String authStr1="";
		//对传入的字符串进行截取
		int a=0;
		//="abc;def;";
		//将传过来的字符串解析
		while(true){	
			a=authStr.indexOf(';');
			if(a<0)
				break;
			authStr1=authStr.substring(0, a).trim();
			
			authStr=authStr.substring(a+1);
			authlist.add(authStr1);			
		}
		
		//根据角色名称，查出对应id
		int roleid=adminRoleService.getidbyrolename(rolename);	
		JSONObject jsonObject=new JSONObject();
		if(roleid==0){
			//0代表角色不存在
			jsonObject.put("status", "0");
			try {
				JsonResponse.PrintJsonOne(response, jsonObject);
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("不存在该角色");			
		}		
		
		//根据roleid删除表中对应的权限id记录
		boolean isdelete=adminRoleAndAuthService.deleteroleauthbyroleid(roleid);
		
		
		//根据权限名称的集合，查询所有对应的id集合
		List<Integer> authids=adminAuthService.getidsbyauthnames(authlist);
		//List<Integer> distinctAuthList=new ArrayList<>();
		if(authids!=null&&authids.size()>0){
			
			boolean isadd= adminRoleAndAuthService.addauthstorole(roleid, authids);
			
			if(isadd){
				jsonObject.put("status", "1");
				try {
					JsonResponse.PrintJsonOne(response, jsonObject);
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			else{
				jsonObject.put("status", "0");
				try {
					JsonResponse.PrintJsonOne(response, jsonObject);
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
				
			
			//根据角色id和权限id集合，查出对应
			/*distinctAuthList=adminRoleAndAuthService.getdistinctauthids(roleid, authids);
			if(distinctAuthList==null||distinctAuthList.size()<=0){
				jsonObject.put("status", "3");
				try {
					JsonResponse.PrintJsonOne(response, jsonObject);
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}*/
			/*else{
				boolean isstatus=adminRoleAndAuthService.addauthstorole(roleid, distinctAuthList);
				if(isstatus)
					
			}*/
		}
		
		/*if(distinctAuthList!=null&&distinctAuthList.size()>0){			
			boolean istrue=adminRoleAndAuthService.addauthstorole(roleid, distinctAuthList);
			if(istrue){
				//1代表添加成功
				jsonObject.put("status", "1");
				try {
					JsonResponse.PrintJsonOne(response, jsonObject);
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}				
			else{
				//2 代表添加失败
				jsonObject.put("status", "2");
				try {
					JsonResponse.PrintJsonOne(response, jsonObject);
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}*/
		
	}
	
	/*
	 * 
	 * 根据roleid查询其拥有的所有权限
	 * 
	 * */
	@RequestMapping("getauthnamesbyroleid")
	public void getauthnamesbyroleid(int roleid,HttpServletResponse response){
		
		//int roleid=2;
		String resultnames="";
		//获取权限id
		List<Integer> authids=adminRoleAndAuthService.getauthidsbyroleid(roleid);
		if(authids!=null&&authids.size()>0){
			//获取权限名称集合
			List<String> authnames=adminAuthService.getauthnamebyauthids(authids);
			if(authnames!=null&&authnames.size()>0){
				for (int i = 0; i < authnames.size(); i++) {					
					resultnames+=authnames.get(i)+";";
				}
			}
		}
		System.out.println(resultnames);
		
		JSONObject jsonObject=new JSONObject();
		
		if(resultnames==""){
			jsonObject.put("status", "0");
			try {
				JsonResponse.PrintJsonOne(response, jsonObject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		else{
			jsonObject.put("status", resultnames);
			try {
				JsonResponse.PrintJsonOne(response, jsonObject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
