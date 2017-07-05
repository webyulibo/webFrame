package cn.bronze.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.record.chart.AxisUsedRecord;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetType;
import cn.bronze.entities.AssetTypeExample;
import cn.bronze.services.AdminAssetTypeService;
import cn.bronze.services.BaseAssetTypeService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@RequestMapping("/adminassettype")
@Controller
public class AdminAssettypeController {
	@Autowired
	private AdminAssetTypeService adminAssetTypeService;
	/**
	 * 尼雷清
	 * 根据"当前页数" 查询一级 资产类型列表（返回的jsp 不一样所以单独写一个查询一级资产类型的Controller）
	 * @param currentpage 当前页数
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/getassettypefirstmenubyfidwithpage")
	public String getassettypefirstmenubyfidwithpage(Model model,Integer dis,String pagenum,Integer currentPage)throws IOException{		
		if(currentPage==null)
		{
		currentPage=1;
		}
		if(dis==null){
			dis=0;
			pagenum=";1";
			//System.out.println(dis+"  "+pagenum);
			model.addAttribute("pagenum", pagenum);
		}else if(dis==1){//更新当前
			int i=pagenum.lastIndexOf(";");
			String s=pagenum.substring(0, i+1);
			String a=Integer.toString(currentPage);
			pagenum=s+a;
			model.addAttribute("pagenum", pagenum);
		}else if(dis==2){
			String a=Integer.toString(currentPage);
			pagenum=";"+a;
			model.addAttribute("pagenum", pagenum);
		}else if(dis==3){
			int i=pagenum.lastIndexOf(";");
			String s=pagenum.substring(0, i);//将最后一位的页数截取掉
			int m=s.lastIndexOf(";");//倒数第二个页数，倒数第一个代表当前页
			String c=s.substring(m+1, i);//代表返回页数
			currentPage=Integer.parseInt(c);
			pagenum=s;
			
			model.addAttribute("pagenum", pagenum);
		}
			PageParameter pageParameter=PageParameter.NewInstance(currentPage);
			List<AssetType> assetTypeList=adminAssetTypeService.getAssetTypeElseMenuByFidWithPage(0, pageParameter);//写死了
			model.addAttribute("pager", pageParameter);
			model.addAttribute("assetTypeList", assetTypeList);
		return "dataadmin/leibieadmin/main/yjlxlbqjx";		
	}
	/**
	 * 尼雷清
	 * 根据"当前页数" "fid" 查看   子资产类型列表
	 * @param currentpage 当前页数     
	 * @param fid 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","checkauth"},logical=Logical.OR)
	@RequestMapping("/getassettypeelsemenubyfidwithpage")
	public String getassettypeelsemenubyfidwithpage(Model model,Integer dis,String pagenum,Integer level,Integer currentPage,Integer id)throws IOException{		
		if(currentPage==null)
		{
		currentPage=1;
		}
		if(id==null)
		{
		System.out.println("页面没有传过来fid!");
		return null;
		}
		if(dis==null){
			dis=0;
			pagenum=";1";
			model.addAttribute("pagenum", pagenum);
		}else if(dis==1){//更新当前
			int i=pagenum.lastIndexOf(";");
			String s=pagenum.substring(0, i+1);
			String a=Integer.toString(currentPage);
			pagenum=s+a;
			model.addAttribute("pagenum", pagenum);
		}else if(dis==2){
			String a=Integer.toString(currentPage);
			pagenum=pagenum+";"+a;
			model.addAttribute("pagenum", pagenum);
		}else if(dis==3){
			int i=pagenum.lastIndexOf(";");
			String s=pagenum.substring(0, i);//将最后一位的页数截取掉
			int m=s.lastIndexOf(";");//倒数第二个页数，倒数第一个代表当前页
			String c=s.substring(m+1, i);//代表返回页数
			currentPage=Integer.parseInt(c);
			pagenum=s;
			//System.out.println(dis+"  "+pagenum);
			model.addAttribute("pagenum", pagenum);
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<AssetType> assetTypeList=adminAssetTypeService.getAssetTypeElseMenuByFidWithPage(id, pageParameter);
		String fAssetTypeName=adminAssetTypeService.selectByAssetTypeById(id).getTypename();
		int fid=adminAssetTypeService.selectByAssetTypeById(id).getFid();
		
		model.addAttribute("fAssetTypeName", fAssetTypeName);//返回该子类型的父类型的名称
		model.addAttribute("fid",fid); 
		model.addAttribute("id",id); 
		model.addAttribute("pager", pageParameter);
     	model.addAttribute("assetTypeList", assetTypeList);
		return "dataadmin/leibieadmin/look/lookqjx";		
	}
	/***
	 * 尼雷清
	 * 执行添加资产类型，      addassettypemenu
	 * @param assetType
	 * @param response
	 * @return 
	 */
	@RequestMapping("/addassettypemenu")
	public  void addassettypemenu(AssetType assetType,HttpServletResponse response,HttpServletRequest request)throws IOException{
		JSONObject jsonObject=new JSONObject();
		if(assetType.getFid()==null){//如果添加页面没有传过来fid 的值则设置添加到一级类型
			assetType.setFid(0);
		}
		int record=adminAssetTypeService.insertByAssetTypeByFid(assetType);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "添加成功");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "添加失败！"+"此级别下已存在该类型,不可再重复添加！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/***
	 * 尼雷清
	 * 执行修改资产类型      updateassettypemenu
	 * @param assetType
	 * @param response
	 * @return 
	 */
	@RequestMapping("/updateassettypemenu")
	public void updateassettypefirstmenu(AssetType assetType,String pretypename,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminAssetTypeService.updateByAssetTypeByFid(assetType,pretypename);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "修改成功");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "修改失败！此级别下已存在该类型,请重新修改！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/***
	 * 尼雷清
	 * 执行删除资产类型      deleteassettypemenu
	 * @param fid
	 * @param response
	 * @return 
	 */
	@RequestMapping("/deleteassettypemenu")
	public void deleteassettypefirstmenu(Integer id,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminAssetTypeService.deleteAssetTypeById(id);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除成功");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "删除失败");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/***
	 * 尼雷清
	 * 添加类型名称合法性验证      typenameLegal
	 * @param typename
	 * @param response
	 * @return 
	 */
	@RequestMapping("/istypenamelegal")
	public void istypenamelegal(String typename,Integer fid,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		if(fid==null){
			fid=0;
		}
		boolean m=adminAssetTypeService.typenameIsInLegal(typename,fid);
		if(m==true){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "类型名称合法！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "此级别下已存在该类型！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/***
	 * 尼雷清
	 * 修改类型名称合法性验证      isupdatetypenamelegal
	 * @param typename fid pretypename
	 * @param response
	 * @return 
	 */
	@RequestMapping("/isupdatetypenamelegal")
	public void isupdatetypenamelegal(String typename,Integer fid,String pretypename,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		if(fid==null){
			fid=0;
		}
		boolean m=adminAssetTypeService.updatetypenameIsInLegal(typename, fid, pretypename);
		if(m==true){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "类型名称合法！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "此级别下已存在该类型！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/***
	 * 尼雷清
	 * 返回跳转页面的总页数     getassettypetotalpage
	 * @param fid
	 * @param response
	 * @return 
	 */
	@RequestMapping("/getassettypetotalpage")
	public void isUpdateTypenameLegal(Integer fid,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		if(fid==null){
			fid=0;
		}
		int m=adminAssetTypeService.findTotalPage(fid);
			jsonObject.put("status", "ok");
			jsonObject.put("totalPage", m);
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/***
	 * 尼雷清
	 * 根据类型名  执行精确查寻一级资产类型界面      selectassettypefirstmenu
	 * @param id
	 * @return 
	 */
	@RequestMapping("/selectassettypefirstmenu")
	public String selectassettypefirstmenu(Model model,Integer dis,String pagenum,String assetTypeName,Integer currentPage)throws IOException{
		if(assetTypeName==null)
		{
		System.out.println("页面没有传过来  typename!");
		return null;
		}
		if(currentPage==null)
		{
		currentPage=1;
		}
		if(dis==null){
			dis=0;
			pagenum=";1";
			//System.out.println(dis+"  "+pagenum);
			model.addAttribute("pagenum", pagenum);
		}else if(dis==1){//更新当前
			int i=pagenum.lastIndexOf(";");
			String s=pagenum.substring(0, i+1);
			String a=Integer.toString(currentPage);
			pagenum=s+a;
			model.addAttribute("pagenum", pagenum);
		}else if(dis==2){
			String a=Integer.toString(currentPage);
			pagenum=";"+a;
			model.addAttribute("pagenum", pagenum);
		}else if(dis==3){
			int i=pagenum.lastIndexOf(";");
			String s=pagenum.substring(0, i);//将最后一位的页数截取掉
			int m=s.lastIndexOf(";");//倒数第二个页数，倒数第一个代表当前页
			String c=s.substring(m+1, i);//代表返回页数
			currentPage=Integer.parseInt(c);
			pagenum=s;
			
			model.addAttribute("pagenum", pagenum);
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		model.addAttribute("pager", pageParameter);
		List<AssetType> assetTypeList=adminAssetTypeService.getAssetTypeFirstMenuByTypeNameWithPage(assetTypeName,pageParameter);
		model.addAttribute("assetTypeList", assetTypeList);
		return "dataadmin/leibieadmin/main/yjlxlbqjx";
	}
}
