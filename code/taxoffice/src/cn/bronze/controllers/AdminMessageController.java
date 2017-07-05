package cn.bronze.controllers;

import java.io.IOException;
import java.util.Date;
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

import com.sun.xml.internal.messaging.saaj.soap.StringDataContentHandler;

import cn.bronze.daos.TMessageMapper;
import cn.bronze.entities.TMessage;
import cn.bronze.entities.TMessageExtend;
import cn.bronze.entities.TMessageListWithMobilizePeople;
import cn.bronze.entities.TMobilizepeople;
import cn.bronze.entities.TUserExtend;
import cn.bronze.services.AdminMessageService;
import cn.bronze.services.AdminUserManagerService;
import cn.bronze.util.json.JsonResponse;
import cn.bronze.util.page.PageParameter;

@Controller
@RequestMapping("/adminmessagecontroller")
public class AdminMessageController {
	@Autowired
	private AdminMessageService adminMessageService;
	@Autowired
	private AdminUserManagerService adminUserManagerService;

	/**
	 * 尼雷清
	 * 执行发送消息，并将消息保存至数据库
	 * @param 
	 * @return
	 */
	@RequestMapping("/sendmessage")
	public void sendmessage(TMessage tMessage,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		 Date date = new Date(); 
		tMessage.setSendtime(date);
		int record=adminMessageService.sendMessage(tMessage);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "通知发送成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "通知发送失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 显示所有的人员姓名人员姓名的jsonarray
	 * @param 
	 * @return
	 */
	@RequestMapping("/getallusername")
	public void getallusername(HttpServletResponse response) throws IOException{
			JSONArray jsonArray=new JSONArray();
			jsonArray=adminMessageService.getAllUserName();
			JsonResponse.PrintJsonList(response, jsonArray);
	}
	
	
	/********************************************************************机关服务中心**********************************************************************************/
	
	/**
	 * 尼雷清
	 * 显示机关服务中心 发送信息通知的界面 
	 * @param 
	 * @return
	 */
	@RequestMapping("/getsendmessagepageofagencyservicecenter")
	public String  getsendmessagepageofagencyservicecenter(Model model,String depcode){
		String depname=adminMessageService.getDepNameByDepcode(depcode);
		model.addAttribute("depname", depname);
		model.addAttribute("depcode", depcode);
		return "informationnotice/agencyservicecenter/index";
	}
	/**
	 * 尼雷清
	 * 显示      查看机关服务中心通知   列表(显示这个部门需要接受的所有的通知)
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","movepeoauth"},logical=Logical.OR)
	@RequestMapping("/getacceptmessagepageofagencyservicecenter")
	public String  getacceptmessagepageofagencyservicecenter(Model model,String depcode,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithAllMobilizePeoples(depcode, pageParameter);
		model.addAttribute("tMessageListWithMobilizePeoplesList", tMessageListWithMobilizePeoplesList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("depcode", depcode);
		return "informationnotice/agencyservicecenter/list";
	}
	/**
	 * 尼雷清
	 * 根据查询条件   查询机关服务中心通知   列表(显示这个部门需要接受的所有的通知)
	 * @param 
	 * @return
	 */
	@RequestMapping("/findacceptmessagepageofagencyservicecenterbycondition")
	public String  findacceptmessagepageofagencyservicecenterbycondition(Model model,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithAllMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		model.addAttribute("tMessageListWithMobilizePeoplesList", tMessageListWithMobilizePeoplesList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("depcode", depcode);
		
		model.addAttribute("title", title);//回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		return "informationnotice/agencyservicecenter/list";
	}
	/**
	 * 尼雷清
	 * 显示机关服务中心  接受普通通知的     详情
	 * @param 
	 * @return
	 */
	@RequestMapping("/getacceptmessagedetailpageofagencyservicecenter")
	public String  getacceptmessagedetailpageofagencyservicecenter(Model model,Integer id,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		TMessageExtend messageExtend=adminMessageService.getMessageExtend(id);
		model.addAttribute("messageExtend", messageExtend);
		model.addAttribute("depcode", depcode);
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("title", title);//以备回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		
		return "informationnotice/agencyservicecenter/detail";
	}
	/**
	 * 尼雷清
	 * 显示机关服务中心 处理人员变动通知单的     详情
	 * @param 
	 * @return
	 */
	@RequestMapping("/getpersonchangesdetailpageofagencyservicecenter")
	public String  getpersonchangesdetailpageofagencyservicecenter(Model model,Integer id,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		TMobilizepeople tMobilizepeople=adminMessageService.getpersonchangesmessage(id);
		model.addAttribute("tMobilizepeople", tMobilizepeople);
		
		
		model.addAttribute("currentPage", currentPage);//回显先前的页数
		model.addAttribute("depcode", depcode);
		model.addAttribute("title", title);//以备回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		return "informationnotice/agencyservicecenter/staffchangenotice";
	}
	/**
	 * 尼雷清
	 * 机关服务中心处理人员变动通知单，并保存至数据库     只有一个参数时   描述(当该变动人员原部门不是机关服务中心时只需要，传入一个参数)
	 * @param 
	 * @return
	 */
	@RequestMapping("/savepeoplechangesmsgofagencyservicecenteraboutoneparameter")
	public void savepeoplechangesmsgofagencyservicecenteraboutoneparameter(Integer id,String servicedep,Boolean originaldepexit,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.savePeopleChangesMsgOfAgencyServiCecenterAboutOneParameter(id, servicedep,originaldepexit);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "办理成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "办理失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 机关服务中心处理人员变动通知单，并保存至数据库     两个参数时   描述(当该变动人员原部门是机关服务中心时，传入两个参数)
	 * @param 
	 * @return
	 */
	@RequestMapping("/savepeoplechangesmsgofagencyservicecenterabouttwoparameter")
	public void savepeoplechangesmsgofagencyservicecenterabouttwoparameter(Integer id,String servicedep,String usedep,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.savePeopleChangesMsgOfAgencyServiCecenterAboutTwoParameter(id, servicedep, usedep);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "办理成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "办理失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 删除机关服务中心的 普通通知
	 * @param 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deleteacceptmessagepageofagencyservicecenter")
	public void deleteacceptmessagepageofagencyservicecenter(String depcode,Integer id,Integer currentPage,String title,String sendpeople,Boolean status,String senddepname,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.deleteGeneralMessage(id);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithAllMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		if(tMessageListWithMobilizePeoplesList==null){
			if(currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else{
				jsonObject.put("issubcurrentPage", "no");
			}
			
		}else{
			if(tMessageListWithMobilizePeoplesList.size()==0&&currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else {
				jsonObject.put("issubcurrentPage", "no");
			}
		}
		
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除消息成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "删除消息失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 删除机关服务中心的  人员变动表
	 * @param 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deletepeoplechangemessageofagencyservicecenter")
	public void deletepeoplechangemessageofagencyservicecenter(String depcode,Integer id,Integer currentPage,String title,String sendpeople,Boolean status,String senddepname,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.deletePeoplechangeMessage(id);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithAllMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		if(tMessageListWithMobilizePeoplesList==null){
			if(currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else{
				jsonObject.put("issubcurrentPage", "no");
			}
			
		}else{
			if(tMessageListWithMobilizePeoplesList.size()==0&&currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else {
				jsonObject.put("issubcurrentPage", "no");
			}
		}
		
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除消息成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "该人员变动表还未处理完毕，删除消息失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	
	
	
	/********************************************************************人事教育科**********************************************************************************/	
	
	
	/**
	 * 尼雷清
	 * 显示人事部门发送信息通知的界面 
	 * @param 
	 * @return
	 */
	@RequestMapping("/getsendmessagepageofpersonneldepartment")
	public String  getsendmessagepageofpersonneldepartment(Model model,String depcode){
		String depname=adminMessageService.getDepNameByDepcode(depcode);
		model.addAttribute("depname", depname);
		model.addAttribute("depcode", depcode);
		return "informationnotice/personneldepartment/index";
	}
	/**
	 * 尼雷清
	 * 显示      查看人事部门通知   列表(显示这个部门需要接受的所有的通知)
	 * @param 
	 * @return
	 */

	@RequiresPermissions(value={"sysauth","assetauth"},logical=Logical.OR)
	@RequestMapping("/getacceptmessagepageofpersonneldepartment")
	public String  getacceptmessagepageofpersonneldepartment(Model model,String depcode,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithMobilizePeoples(depcode, pageParameter);
		model.addAttribute("tMessageListWithMobilizePeoplesList", tMessageListWithMobilizePeoplesList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("depcode", depcode);
		return "informationnotice/personneldepartment/list";
	}
	/**
	 * 尼雷清
	 * 根据查询条件   查询人事部门通知   列表(显示这个部门需要接受的所有的通知)
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","movepeoauth"},logical=Logical.OR)
	@RequestMapping("/findacceptmessagepageofpersonneldepartmentbycondition")
	public String  findacceptmessagepageofpersonneldepartmentbycondition(Model model,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		model.addAttribute("tMessageListWithMobilizePeoplesList", tMessageListWithMobilizePeoplesList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("depcode", depcode);
		
		model.addAttribute("title", title);//回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		return "informationnotice/personneldepartment/list";
	}
	/**
	 * 尼雷清
	 * 显示人事部门  接受普通通知的     详情
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth"},logical=Logical.OR)
	@RequestMapping("/getacceptmessagedetailpageofpersonneldepartment")
	public String  getacceptmessagedetailpageofpersonneldepartment(Model model,Integer id,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		TMessageExtend messageExtend=adminMessageService.getMessageExtend(id);
		model.addAttribute("messageExtend", messageExtend);
		model.addAttribute("depcode", depcode);
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("title", title);//以备回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		
		return "informationnotice/personneldepartment/detail";
	}
	/**
	 * 尼雷清
	 * 显示人事部门 处理人员变动通知单的     详情
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","movepeoauth"},logical=Logical.OR)
	@RequestMapping("/getpersonchangesdetailpageofpersonneldepartment")
	public String  getpersonchangesdetailpageofpersonneldepartment(Model model,Integer id,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		TMobilizepeople tMobilizepeople=adminMessageService.getpersonchangesmessage(id);
		model.addAttribute("tMobilizepeople", tMobilizepeople);
		
		
		model.addAttribute("currentPage", currentPage);//回显先前的页数
		model.addAttribute("depcode", depcode);
		model.addAttribute("title", title);//以备回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		return "informationnotice/personneldepartment/dealwithstaffchangenotice";
	}
	/**
	 * 尼雷清
	 * 人事部门处理人员变动通知单，并保存至数据库
	 * @param 
	 * @return
	 */
	
	@RequestMapping("/savepeoplechangesmsgofpersonneldepartment")
	public void savepeoplechangesmsgofpersonneldepartment(Integer id,String userdep,String depcode,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.savePeopleChangesMsgOfUseDepartment(id, userdep);//调用财务管理科对应的    该人员变动的状态处理方法
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "办理成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "办理失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 删除使用部门的 普通通知
	 * @param 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deleteacceptmessagepageofpersonneldepartment")
	public void deleteacceptmessagepageofpersonneldepartment(String depcode,Integer id,Integer currentPage,String title,String sendpeople,Boolean status,String senddepname,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.deleteGeneralMessage(id);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		if(tMessageListWithMobilizePeoplesList==null){
			if(currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else{
				jsonObject.put("issubcurrentPage", "no");
			}
			
		}else{
			if(tMessageListWithMobilizePeoplesList.size()==0&&currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else {
				jsonObject.put("issubcurrentPage", "no");
			}
		}
		
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除消息成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "删除消息失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 删除使用部门的  人员变动表
	 * @param 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deletepeoplechangemessageofpersonneldepartment")
	public void deletepeoplechangemessageofpersonneldepartment(String depcode,Integer id,Integer currentPage,String title,String sendpeople,Boolean status,String senddepname,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.deletePeoplechangeMessage(id);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		if(tMessageListWithMobilizePeoplesList==null){
			if(currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else{
				jsonObject.put("issubcurrentPage", "no");
			}
			
		}else{
			if(tMessageListWithMobilizePeoplesList.size()==0&&currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else {
				jsonObject.put("issubcurrentPage", "no");
			}
		}
		
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除消息成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "该人员变动表还未处理完毕，删除消息失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	
	
	
	
	
	/********************************************************************财务管理科**********************************************************************************/
	
	
	
	/**
	 * 尼雷清
	 * 显示财务管理部门发送信息通知的界面 
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","movepeoauth"},logical=Logical.OR)
	@RequestMapping("/getsendmessagepageoffinancialmanagement")
	public String  getsendmessagepageoffinancialmanagement(Model model,String depcode){
		String depname=adminMessageService.getDepNameByDepcode(depcode);
		model.addAttribute("depname", depname);
		model.addAttribute("depcode", depcode);
		return "informationnotice/financialmanagement/index";
	}
	/**
	 * 尼雷清
	 * 显示      查看财务管理部门通知   列表(显示这个部门需要接受的所有的通知)
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","movepeoauth"},logical=Logical.OR)
	@RequestMapping("/getacceptmessagepageoffinancialmanagement")
	public String  getacceptmessagepageoffinancialmanagement(Model model,String depcode,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithAllMobilizePeoples(depcode, pageParameter);
		model.addAttribute("tMessageListWithMobilizePeoplesList", tMessageListWithMobilizePeoplesList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("depcode", depcode);
		return "informationnotice/financialmanagement/list";
	}
	/**
	 * 尼雷清
	 * 根据查询条件   查询财务管理部门通知   列表(显示这个部门需要接受的所有的通知)
	 * @param 
	 * @return
	 */
	@RequestMapping("/findacceptmessagepageoffinancialmanagementbycondition")
	public String  findacceptmessagepageoffinancialmanagementbycondition(Model model,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithAllMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		model.addAttribute("tMessageListWithMobilizePeoplesList", tMessageListWithMobilizePeoplesList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("depcode", depcode);
		
		model.addAttribute("title", title);//回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		return "informationnotice/financialmanagement/list";
	}
	/**
	 * 尼雷清
	 * 显示财务管理部门  接受普通通知的     详情
	 * @param 
	 * @return
	 */
	@RequestMapping("/getacceptmessagedetailpageoffinancialmanagement")
	public String  getacceptmessagedetailpageoffinancialmanagement(Model model,Integer id,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		TMessageExtend messageExtend=adminMessageService.getMessageExtend(id);
		model.addAttribute("messageExtend", messageExtend);
		model.addAttribute("depcode", depcode);
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("title", title);//以备回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		
		return "informationnotice/financialmanagement/detail";
	}
	/**
	 * 尼雷清
	 * 显示财务管理部门 处理人员变动通知单的     详情
	 * @param 
	 * @return
	 */
	@RequestMapping("/getpersonchangesdetailpageoffinancialmanagement")
	public String  getpersonchangesdetailpageoffinancialmanagement(Model model,Integer id,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		TMobilizepeople tMobilizepeople=adminMessageService.getpersonchangesmessage(id);
		model.addAttribute("tMobilizepeople", tMobilizepeople);
		
		
		model.addAttribute("currentPage", currentPage);//回显先前的页数
		model.addAttribute("depcode", depcode);
		model.addAttribute("title", title);//以备回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		return "informationnotice/financialmanagement/staffchangenotice";
	}
	/**
	 * 尼雷清
	 * 财务管理部门处理人员变动通知单，并保存至数据库     只有一个参数时   描述(当该变动人员原部门不是财务管理部门时只需要，传入一个参数)
	 * @param 
	 * @return
	 */
	@RequestMapping("/savepeoplechangesmsgoffinancialmanagementaboutoneparameter")
	public void savepeoplechangesmsgoffinancialmanagementaboutoneparameter(Integer id,String financialdep,Boolean originaldepexit,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.savePeopleChangesMsgOfFinancialManagementAboutOneParameter(id, financialdep,originaldepexit);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "办理成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "办理失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 财务管理部门处理人员变动通知单，并保存至数据库     两个参数时   描述(当该变动人员原部门是财务管理部门时，传入两个参数)
	 * @param 
	 * @return
	 */
	@RequestMapping("/savepeoplechangesmsgoffinancialmanagementabouttwoparameter")
	public void savepeoplechangesmsgoffinancialmanagementabouttwoparameter(Integer id,String financialdep,String usedep,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.savePeopleChangesMsgOfFinancialManagementAboutTwoParameter(id, financialdep, usedep);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "办理成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "办理失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 删除财务管理部门的 普通通知
	 * @param 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deleteacceptmessagepageoffinancialmanagement")
	public void deleteacceptmessagepageoffinancialmanagement(String depcode,Integer id,Integer currentPage,String title,String sendpeople,Boolean status,String senddepname,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.deleteGeneralMessage(id);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithAllMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		if(tMessageListWithMobilizePeoplesList==null){
			if(currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else{
				jsonObject.put("issubcurrentPage", "no");
			}
			
		}else{
			if(tMessageListWithMobilizePeoplesList.size()==0&&currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else {
				jsonObject.put("issubcurrentPage", "no");
			}
		}
		
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除消息成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "删除消息失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 删除财务管理部门的  人员变动表
	 * @param 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deletepeoplechangemessageoffinancialmanagement")
	public void deletepeoplechangemessageoffinancialmanagement(String depcode,Integer id,Integer currentPage,String title,String sendpeople,Boolean status,String senddepname,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.deletePeoplechangeMessage(id);
		//判断是否删除后当前页面为空，在currentPage>1的情况下会将cerrentPage-1
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithAllMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		if(tMessageListWithMobilizePeoplesList==null){
			if(currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else{
				jsonObject.put("issubcurrentPage", "no");
			}
			
		}else{
			if(tMessageListWithMobilizePeoplesList.size()==0&&currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else {
				jsonObject.put("issubcurrentPage", "no");
			}
		}
		
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除消息成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "该人员变动表还未处理完毕，删除消息失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	
	
	
	
	
	
	
	
	
	
	/********************************************************************普通的使用部门**********************************************************************************/

	
	/**
	 * 尼雷清
	 * 显示使用部门发送信息通知的  界面 
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","movepeoauth"},logical=Logical.OR)
	@RequestMapping("/getsendmessagepageofusedepartment")
	public String  getsendmessagepageofusedepartment(Model model,String depcode){
		String depname=adminMessageService.getDepNameByDepcode(depcode);
		model.addAttribute("depname", depname);
		model.addAttribute("depcode", depcode);
		return "informationnotice/usedepartment/index";
	}
	/**
	 * 尼雷清
	 * 显示      查看使用部门通知   列表(显示这个部门需要接受的所有的通知)
	 * @param 
	 * @return
	 */
	@RequiresPermissions(value={"sysauth","assetauth","movepeoauth"},logical=Logical.OR)
	@RequestMapping("/getacceptmessagepageofusedepartment")
	public String  getacceptmessagepageofusedepartment(Model model,String depcode,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithMobilizePeoples(depcode, pageParameter);
		model.addAttribute("tMessageListWithMobilizePeoplesList", tMessageListWithMobilizePeoplesList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("depcode", depcode);
		return "informationnotice/usedepartment/list";
	}
	/**
	 * 尼雷清
	 * 显示使用部门 接受普通通知的     详情
	 * @param 
	 * @return
	 */
	@RequestMapping("/getacceptmessagedetailpageofusedepartment")
	public String  getacceptmessagedetailpageofusedepartment(Model model,Integer id,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		TMessageExtend messageExtend=adminMessageService.getMessageExtend(id);
		model.addAttribute("messageExtend", messageExtend);
		model.addAttribute("depcode", depcode);
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("title", title);//以备回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		
		return "informationnotice/usedepartment/detail";
	}
	/**
	 * 尼雷清
	 * 显示使用部门 处理人员变动通知单的     详情
	 * @param 
	 * @return
	 */
	@RequestMapping("/getpersonchangesdetailpageofusedepartment")
	public String  getpersonchangesdetailpageofusedepartment(Model model,Integer id,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		TMobilizepeople tMobilizepeople=adminMessageService.getpersonchangesmessage(id);
		model.addAttribute("tMobilizepeople", tMobilizepeople);
		
		
		model.addAttribute("currentPage", currentPage);//回显先前的页数
		model.addAttribute("depcode", depcode);
		model.addAttribute("title", title);//以备回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		return "informationnotice/usedepartment/staffchangenotice";
	}
	/**
	 * 尼雷清
	 * 根据查询条件   查询使用部门通知   列表(显示这个部门需要接受的所有的通知)
	 * @param 
	 * @return
	 */
	@RequestMapping("/findacceptmessagepageofusedepartmentbycondition")
	public String  findacceptmessagepageofusedepartmentbycondition(Model model,String depcode,String title,String sendpeople,Boolean status,String senddepname,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		model.addAttribute("tMessageListWithMobilizePeoplesList", tMessageListWithMobilizePeoplesList);
		model.addAttribute("pager", pageParameter);
		model.addAttribute("depcode", depcode);
		
		model.addAttribute("title", title);//回显查询条件
		model.addAttribute("sendpeople", sendpeople);
		model.addAttribute("status", status);
		model.addAttribute("senddepname", senddepname);
		return "informationnotice/usedepartment/list";
	}
	/**
	 * 尼雷清
	 * 使用部门处理人员变动通知单，并保存至数据库
	 * @param 
	 * @return
	 */
	@RequestMapping("/savepeoplechangesmsg")
	public void savepeoplechangesmsg(Integer id,String userdep,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.savePeopleChangesMsgOfUseDepartment(id, userdep);
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "办理成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "办理失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 删除使用部门的 普通通知
	 * @param 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deleteacceptmessagepageofusedepartment")
	public void deleteacceptmessagepageofusedepartment(String depcode,Integer id,Integer currentPage,String title,String sendpeople,Boolean status,String senddepname,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.deleteGeneralMessage(id);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		if(tMessageListWithMobilizePeoplesList==null){
			if(currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else{
				jsonObject.put("issubcurrentPage", "no");
			}
			
		}else{
			if(tMessageListWithMobilizePeoplesList.size()==0&&currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else {
				jsonObject.put("issubcurrentPage", "no");
			}
		}
		
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除消息成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "删除消息失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/**
	 * 尼雷清
	 * 删除使用部门的  人员变动表
	 * @param 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deletepeoplechangemessageofusedepartment")
	public void deletepeoplechangemessageofusedepartment(String depcode,Integer id,Integer currentPage,String title,String sendpeople,Boolean status,String senddepname,HttpServletResponse response) throws IOException{
		JSONObject jsonObject=new JSONObject();
		int record=adminMessageService.deletePeoplechangeMessage(id);
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesList=adminMessageService.getTMessageListWithMobilizePeoplesByCondition(depcode, title, sendpeople, status, senddepname, pageParameter);
		if(tMessageListWithMobilizePeoplesList==null){
			if(currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else{
				jsonObject.put("issubcurrentPage", "no");
			}
			
		}else{
			if(tMessageListWithMobilizePeoplesList.size()==0&&currentPage>1){
				jsonObject.put("issubcurrentPage", "ok");
			}else {
				jsonObject.put("issubcurrentPage", "no");
			}
		}
		
		if(record>0){
			jsonObject.put("status", "ok");
			jsonObject.put("msg", "删除消息成功！");
		}else{
			jsonObject.put("status", "no");
			jsonObject.put("msg", "该人员变动表还未处理完毕，删除消息失败！");
		}
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
	/********************************************************************主界面top消息提醒模块**********************************************************************************/
	/**
	 * 尼雷清
	 * 根据depcode需要处理信息的   个数   
	 * @param depcode
	 * @return json
	 */
	@RequestMapping("/msgtodealwithcount")
	public void msgtodealwithcount(String useraccount,HttpServletResponse response)throws IOException{
		JSONObject jsonObject=new JSONObject();
		String depcode=adminUserManagerService.getUserDepCodeByUserAccount(useraccount);
		int msgTotalCount=adminMessageService.msgToDealWithCount(depcode);
		jsonObject.put("msgTotalCount", msgTotalCount);
		JsonResponse.PrintJsonOne(response, jsonObject);
	}
}
