package cn.bronze.services;

import java.util.ArrayList;
import java.util.List;

import javassist.compiler.ast.IntConst;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TMessageListWithMobilizePeopleMapper;
import cn.bronze.daos.TMessageMapper;
import cn.bronze.daos.TMobilizepeopleMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TMessage;
import cn.bronze.entities.TMessageExample;
import cn.bronze.entities.TMessageExampleCustom;
import cn.bronze.entities.TMessageExtend;
import cn.bronze.entities.TMessageListWithMobilizePeople;
import cn.bronze.entities.TMobilizepeople;
import cn.bronze.entities.TMobilizepeopleExample;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;
@Component//定义切面
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminMessageService {
@Autowired
private TUserMapper tUserMapper;
@Autowired
private TMessageMapper tMessageMapper;
@Autowired
private TDepartmentMapper tDepartmentMapper;
@Autowired
private TMobilizepeopleMapper tMobilizepeopleMapper;
@Autowired
private TMessageListWithMobilizePeopleMapper tMessageListWithMobilizePeopleMapper;

	/**
	 * 尼雷清
	 * 根据部门代码 和 查询条件                分页显示   只  显示部门通知(适用于：除去人事部门、机关服务中心、财务的等  其他      使用部门)
	 * @param depcode pageParameter
	 * @return List<TMessageExtend>
	 */
	public List<TMessageExtend> getgetAcceptmessagepageByCondition(String depcode,String title,String sendpeople,Boolean status,String senddepcode,PageParameter pageParameter){
		TMessageExampleCustom tMessageExampleCustom=new TMessageExampleCustom();
		TMessageExampleCustom.Criteria tMessageExampleCriteria=tMessageExampleCustom.createCriteria();
		tMessageExampleCriteria.andAcceptdepcodeEqualTo(depcode);
		if(title!=null&&title.equals("")==false){
			tMessageExampleCriteria.andTitleLike(title);
		}
		if(sendpeople!=null&&sendpeople.equals("")==false){
			tMessageExampleCriteria.andSendpeopleEqualTo(sendpeople);
		}
		if(status!=null){
			tMessageExampleCriteria.andStatusEqualTo(status);
		}
		if(senddepcode!=null&&senddepcode.equals("")==false){
			tMessageExampleCriteria.andSenddepcodeEqualTo(senddepcode);
		}
		tMessageExampleCustom.setOrderByClause("id desc");
		tMessageExampleCustom.setPage(pageParameter);
		List<TMessage> tMessagesList=tMessageMapper.selectByExample(tMessageExampleCustom);
		List<TMessageExtend> tMessageExtendsList=getTMessageExtendsList(tMessagesList);//如果tMessagesList为空，tMessageExtendsList=null
		return tMessageExtendsList;
	}
	/**
	 * 尼雷清
	 * 根据部门代码 和 查询条件            分页显示  普通通知以及通知单   (适用于：使用部门，只显示对应人员通知单上的原部门代码的人员通知单)
	 * @param depcode pageParameter
	 * @return List<TMessageListWithMobilizePeople>
	 */
	public List<TMessageListWithMobilizePeople> getTMessageListWithMobilizePeoplesByCondition(String depcode,String title,String sendpeople,Boolean status,String senddepname,PageParameter pageParameter){	
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples=tMessageListWithMobilizePeopleMapper.getMessageListWithMobilizePeoples(depcode);
		//按照title查询
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples1=new ArrayList<TMessageListWithMobilizePeople>();
		if(title!=null&&title.equals("")==false){
			for(int i=0;i<tMessageListWithMobilizePeoples.size();i++){
				if(tMessageListWithMobilizePeoples.get(i).getTitle().equals(title)==true){
					tMessageListWithMobilizePeoples1.add(tMessageListWithMobilizePeoples.get(i));
				}
			}
		}else{
			tMessageListWithMobilizePeoples1=tMessageListWithMobilizePeoples;
		}
		//按照sendpeople查询
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples2=new ArrayList<TMessageListWithMobilizePeople>();
		if(sendpeople!=null&&sendpeople.equals("")==false){
			for(int i=0;i<tMessageListWithMobilizePeoples1.size();i++){
				if(tMessageListWithMobilizePeoples1.get(i).getSendpeople()!=null&&tMessageListWithMobilizePeoples1.get(i).getSendpeople()!=""&&tMessageListWithMobilizePeoples1.get(i).getSendpeople().equals(sendpeople)==true){
					tMessageListWithMobilizePeoples2.add(tMessageListWithMobilizePeoples1.get(i));
				}
			}
		}else{
			tMessageListWithMobilizePeoples2=tMessageListWithMobilizePeoples1;
		}
		
		//按照status查询
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples3=new ArrayList<TMessageListWithMobilizePeople>();
		if(status!=null){
			for(int i=0;i<tMessageListWithMobilizePeoples2.size();i++){
				if(tMessageListWithMobilizePeoples2.get(i).getStatus()==status){
					tMessageListWithMobilizePeoples3.add(tMessageListWithMobilizePeoples2.get(i));
				}
			}
		}else{
			tMessageListWithMobilizePeoples3=tMessageListWithMobilizePeoples2;
		}
		//按照senddepname查询
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples4=new ArrayList<TMessageListWithMobilizePeople>();
		if(senddepname!=null&&senddepname.equals("")==false){
			for(int i=0;i<tMessageListWithMobilizePeoples3.size();i++){
				if(tMessageListWithMobilizePeoples3.get(i).getSenddepname().equals(senddepname)==true){
					tMessageListWithMobilizePeoples4.add(tMessageListWithMobilizePeoples3.get(i));
				}
			}
		}else{
			tMessageListWithMobilizePeoples4=tMessageListWithMobilizePeoples3;
		}
		
		int currentPage=pageParameter.getCurrentPage();
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesWithPageList=new ArrayList<TMessageListWithMobilizePeople>();
		if(currentPage*10>tMessageListWithMobilizePeoples4.size()){//若为最后一页
			for(int i=(currentPage-1)*10;i<tMessageListWithMobilizePeoples4.size();i++){
				tMessageListWithMobilizePeoplesWithPageList.add(tMessageListWithMobilizePeoples4.get(i));
			}
		}else{
			for(int i=(currentPage-1)*10;i<currentPage*10;i++){//不为最后一页
				tMessageListWithMobilizePeoplesWithPageList.add(tMessageListWithMobilizePeoples4.get(i));
			}
		}
		
		pageParameter.setTotalPage((tMessageListWithMobilizePeoples4.size()+9)/10);//设置假分页的总页数
		pageParameter.setTotalCount(tMessageListWithMobilizePeoples4.size());//设置假分页的总条目
		return tMessageListWithMobilizePeoplesWithPageList;
	}
	/**
	 * 尼雷清
	 * 根据部门代码 和 查询条件                分页显示  普通通知以及所有通知单     (适用于： 人事部门、财务科、机关服务中心)   
	 * @param depcode pageParameter
	 * @return List<TMessageListWithMobilizePeople>
	 */
	public List<TMessageListWithMobilizePeople> getTMessageListWithAllMobilizePeoplesByCondition(String depcode,String title,String sendpeople,Boolean status,String senddepname,PageParameter pageParameter){	
		//首先查出来对应的所有通知
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples=tMessageListWithMobilizePeopleMapper.getMessageListWithAllMobilizePeoples(depcode);
		//根据查询条件查询出来对应得list集合
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesWithConditionList=getListByCondition(tMessageListWithMobilizePeoples, title, sendpeople, status, senddepname);
		//根据查询结果制造假分页
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesWithPageList=cheatToShowListWithList(tMessageListWithMobilizePeoplesWithConditionList, pageParameter);
		
		return tMessageListWithMobilizePeoplesWithPageList;
	}
	
	/**
	 * 尼雷清
	 * 分页显示     通知以及人员变动表(*查询出来的是   符合depcode的人员变动表和普通通知   适用于：普通使用部门)
	 * @param 
	 * @return 
	 */
	public List<TMessageListWithMobilizePeople> getTMessageListWithMobilizePeoples(String depcode,PageParameter pageParameter){
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples=tMessageListWithMobilizePeopleMapper.getMessageListWithMobilizePeoples(depcode);
		int currentPage=pageParameter.getCurrentPage();
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesWithPageList=new ArrayList<TMessageListWithMobilizePeople>();
		if(currentPage*10>tMessageListWithMobilizePeoples.size()){
			for(int i=(currentPage-1)*10;i<tMessageListWithMobilizePeoples.size();i++){
				tMessageListWithMobilizePeoplesWithPageList.add(tMessageListWithMobilizePeoples.get(i));
			}
		}else{
			for(int i=(currentPage-1)*10;i<currentPage*10;i++){
				tMessageListWithMobilizePeoplesWithPageList.add(tMessageListWithMobilizePeoples.get(i));
			}
		}
		
		pageParameter.setTotalPage((tMessageListWithMobilizePeoples.size()+9)/10);
		pageParameter.setTotalCount(tMessageListWithMobilizePeoples.size());
		return tMessageListWithMobilizePeoplesWithPageList;
	}
	/**
	 * 尼雷清
	 * 分页显示     通知以及人员变动表(*查询出来的是  所有的人员变动表和符合depcode的普通通知  适用于机关服务中心、财务科、和人事部门)
	 * @param 
	 * @return 
	 */
	public List<TMessageListWithMobilizePeople> getTMessageListWithAllMobilizePeoples(String depcode,PageParameter pageParameter){
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples=tMessageListWithMobilizePeopleMapper.getMessageListWithAllMobilizePeoples(depcode);
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesWithPageList=cheatToShowListWithList(tMessageListWithMobilizePeoples, pageParameter);
		return tMessageListWithMobilizePeoplesWithPageList;
	}
	/**
	 * 尼雷清
	 * 根据sid返回对应的messageExtand对象，在显示消息的detail时使用(mark==0||false)
	 * @param id
	 * @return messageExtand
	 */
	public TMessageExtend getMessageExtend(Integer id){
		TMessage tMessage=tMessageMapper.selectByPrimaryKey(id);
		tMessage.setStatus(true);
		int m=tMessageMapper.updateByPrimaryKey(tMessage);
		if(m==0){
			System.out.println("nlq:id为"+tMessage.getId()+"的消息更新其状态失败！");
		}
		TMessageExtend tMessageExtend=new TMessageExtend();
		
		tMessageExtend.setId(id);
		tMessageExtend.setSendpeople(tMessage.getSendpeople());
		tMessageExtend.setTitle(tMessage.getTitle());
		tMessageExtend.setSendtime(tMessage.getSendtime());
		tMessageExtend.setSenddepcode(tMessage.getSenddepcode());
		tMessageExtend.setAcceptdepcode(tMessage.getAcceptdepcode());
		tMessageExtend.setStatus(tMessage.getStatus());
		tMessageExtend.setMsg(tMessage.getMsg());
		
		TDepartmentExample tDepartmentExample=new TDepartmentExample();//执行查询出对应发送部门的中文名称
		TDepartmentExample.Criteria tdepCriteria=tDepartmentExample.createCriteria();
		tdepCriteria.andDepcodeEqualTo(tMessage.getSenddepcode());
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		if(tDepartmentsList.size()==0){
			System.out.println("nlq:ID为"+tMessage.getId()+"的用户中的部门代码未在部门信息表中找到对应的部门名称信息！");
			return null;
		}
		tMessageExtend.setSenddepstring(tDepartmentsList.get(0).getDepname());
		
		if(tMessage.getStatus()==true){//将status转换已读
			tMessageExtend.setStatusString("已读");
		}else{
			tMessageExtend.setStatusString("未读");
		}
		
		return tMessageExtend;
	}
	/**
	 * 尼雷清
	 * 根据sid返回对应包含有人员通知单信息的对象，在显示消息的detail时使用(mark==1||true)
	 * @param id
	 * @return messageExtand
	 */
	public TMobilizepeople  getpersonchangesmessage(Integer id){
		TMobilizepeople tMobilizepeople=tMobilizepeopleMapper.selectByPrimaryKey(id);
		return tMobilizepeople;
	}
	/**
	 * 尼雷清
	 * 根据已经查询出的list集合来  整合出  带有中文  部门名称和状态的List集合
	 * @param List<TMessage>
	 * @return List<TMessageExtend>
	 */
	public List<TMessageExtend> getTMessageExtendsList(List<TMessage> tMessagesList){
		
		if(tMessagesList.size()==0){//当tMessagesList集合为空时直接返回null
			return null;
		}else{
			List<TMessageExtend> tMessageExtendsList=new ArrayList<TMessageExtend>();
			for(int i=0;i<tMessagesList.size();i++){
				TMessageExtend tMessageExtend=new TMessageExtend();
				TMessage tMessage=tMessagesList.get(i);
				
				tMessageExtend.setId(tMessagesList.get(i).getId());
				tMessageExtend.setSendpeople(tMessagesList.get(i).getSendpeople());
				tMessageExtend.setTitle(tMessagesList.get(i).getTitle());
				tMessageExtend.setSendtime(tMessagesList.get(i).getSendtime());
				tMessageExtend.setSenddepcode(tMessagesList.get(i).getSenddepcode());
				tMessageExtend.setAcceptdepcode(tMessagesList.get(i).getAcceptdepcode());
				tMessageExtend.setStatus(tMessagesList.get(i).getStatus());
				tMessageExtend.setMsg(tMessagesList.get(i).getMsg());
				
				TDepartmentExample tDepartmentExample=new TDepartmentExample();//执行查询出对应发送部门的中文名称
				TDepartmentExample.Criteria tdepCriteria=tDepartmentExample.createCriteria();
				tdepCriteria.andDepcodeEqualTo(tMessage.getSenddepcode());
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
				if(tDepartmentsList.size()==0){
					System.out.println("nlq:ID为"+tMessage.getId()+"的用户中的部门代码未在部门信息表中找到对应的部门名称信息！");
					return null;
				}
				tMessageExtend.setSenddepstring(tDepartmentsList.get(0).getDepname());
				
				if(tMessage.getStatus()==true){//将status转换为未读或者已读
					tMessageExtend.setStatusString("已读");
				}else{
					tMessageExtend.setStatusString("未读");
				}
				tMessageExtendsList.add(i, tMessageExtend);
			}
			return tMessageExtendsList;
			
		}
	}
	/**
	 * 尼雷清
	 * 执行发送消息 sendMessage
	 * @param TMessage
	 * @return int
	 */
	@Log(descrp="执行发送通知操作",type="拥有资产管理模块下的所有权限")
	public int sendMessage(TMessage tMessage){
		int m=tMessageMapper.insert(tMessage);
		return m;
	} 
	/**
	 * 尼雷清
	 * 执行删除普通通知  deleteGeneralMessage
	 * @param 
	 * @return 
	 */
	@Log(descrp="执行删除通知操作",type="拥有资产管理模块下的所有权限")
	public int deleteGeneralMessage(Integer id){
		int m=tMessageMapper.deleteByPrimaryKey(id);
		return m;
	}
	/**
	 * 尼雷清
	 * 执行删除人员通知单的通知  deletePeoplechangeMessage
	 * @param 
	 * @return 
	 */
	@Log(descrp="执行删除已处理完毕的人员通知单操作",type="拥有资产管理模块下的所有权限")
	public int deletePeoplechangeMessage(Integer id){
		int m;
		TMobilizepeople tMobilizepeople=tMobilizepeopleMapper.selectByPrimaryKey(id);
		if(tMobilizepeople.getStatus()==false){
		   m=0;
		}else{
			m=tMobilizepeopleMapper.deleteByPrimaryKey(id);
		}
		return m;
	}
	/**
	 * 尼雷清
	 * 执行     *使用部门    保存人员通知单的内容 savePeopleChangesMsgOfUseDepartment
	 * @param 
	 * @return 
	 */
	@Log(descrp="执处理人员通知单操作",type="拥有资产管理模块下的所有权限")
	public int savePeopleChangesMsgOfUseDepartment(Integer id,String userdep){
		TMobilizepeople tMobilizepeople=tMobilizepeopleMapper.selectByPrimaryKey(id);
		tMobilizepeople.setUsedep(userdep);//更新使用部门处理的意见
		if(tMobilizepeople.getFinancialdep()!=null&&tMobilizepeople.getFinancialdep().equals("")==false){//更新该消息通知的处理情况
			if(tMobilizepeople.getServicedep()!=null&&tMobilizepeople.getServicedep().equals("")==false){
				tMobilizepeople.setStatus(true);
			}
		}
		int m=tMobilizepeopleMapper.updateByPrimaryKey(tMobilizepeople);
		return m;
	}
	/**
	 * 尼雷清
	 * 执行     *机关服务中心    保存人员通知单的内容     只需要servicedep    savePeopleChangesMsgOfAgencyServiCecenterAboutOneParameter
	 * @param 
	 * @return 
	 */
	@Log(descrp="执处理人员通知单操作",type="拥有资产管理模块下的所有权限")
	public int savePeopleChangesMsgOfAgencyServiCecenterAboutOneParameter(Integer id,String servicedep,Boolean originaldepexit){
		TMobilizepeople tMobilizepeople=tMobilizepeopleMapper.selectByPrimaryKey(id);
		tMobilizepeople.setServicedep(servicedep);//更新机关生活服务中心处理的意见
		if(originaldepexit==true){
			if(tMobilizepeople.getFinancialdep()!=null&&tMobilizepeople.getFinancialdep().equals("")==false){//原部门存在的情况下
				if(tMobilizepeople.getUsedep()!=null&&tMobilizepeople.getUsedep().equals("")==false){
					tMobilizepeople.setStatus(true);
				}
			}
		}else{
			if(tMobilizepeople.getFinancialdep()!=null&&tMobilizepeople.getFinancialdep().equals("")==false){//不存在原部门的情况下
					tMobilizepeople.setStatus(true);
			}
		}
		
		int m=tMobilizepeopleMapper.updateByPrimaryKey(tMobilizepeople);
		return m;
	}
	/**
	 * 尼雷清
	 * 执行     *机关服务中心    保存人员通知单的内容     需要servicedep、usedep两个参数    savePeopleChangesMsgOfAgencyServiCecenterAboutTwoParameter
	 * @param 
	 * @return 
	 */
	@Log(descrp="执处理人员通知单操作",type="拥有资产管理模块下的所有权限")
	public int savePeopleChangesMsgOfAgencyServiCecenterAboutTwoParameter(Integer id,String servicedep,String usedep){
		TMobilizepeople tMobilizepeople=tMobilizepeopleMapper.selectByPrimaryKey(id);
		tMobilizepeople.setUsedep(usedep);
		tMobilizepeople.setServicedep(servicedep);//更新机关生活服务中心处理的意见
		if(tMobilizepeople.getFinancialdep()!=null&&tMobilizepeople.getFinancialdep().equals("")==false){//更新该消息通知的处理情况
				tMobilizepeople.setStatus(true);
		}
		int m=tMobilizepeopleMapper.updateByPrimaryKey(tMobilizepeople);
		return m;
	}
	/**
	 * 尼雷清
	 * 执行     *财务管理科   保存人员通知单的内容     只需要financialdep    savePeopleChangesMsgOfFinancialManagementAboutOneParameter
	 * @param 
	 * @return 
	 */
	@Log(descrp="执处理人员通知单操作",type="拥有资产管理模块下的所有权限")
	public int savePeopleChangesMsgOfFinancialManagementAboutOneParameter(Integer id,String financialdep,Boolean originaldepexit ){
		TMobilizepeople tMobilizepeople=tMobilizepeopleMapper.selectByPrimaryKey(id);
		tMobilizepeople.setFinancialdep(financialdep);//更新财务管理科处理的意见
		
		if(originaldepexit==true){//如果存在原部门存在的话
			if(tMobilizepeople.getServicedep()!=null&&tMobilizepeople.getServicedep().equals("")==false){//更新该消息通知的处理情况
				if(tMobilizepeople.getUsedep()!=null&&tMobilizepeople.getUsedep().equals("")==false){
					tMobilizepeople.setStatus(true);
				}
			}
		}else{//如果原部门为空的话
			if(tMobilizepeople.getServicedep()!=null&&tMobilizepeople.getServicedep().equals("")==false){//更新该消息通知的处理情况
					tMobilizepeople.setStatus(true);
			}
		}
		int m=tMobilizepeopleMapper.updateByPrimaryKey(tMobilizepeople);
		return m;
	}
	/**
	 * 尼雷清
	 * 执行     *财务管理科    保存人员通知单的内容     需要financialdep、usedep两个参数    savePeopleChangesMsgOfFinancialManagementAboutTwoParameter
	 * @param 
	 * @return 
	 */
	@Log(descrp="执处理人员通知单操作",type="拥有资产管理模块下的所有权限")
	public int savePeopleChangesMsgOfFinancialManagementAboutTwoParameter(Integer id,String financialdep,String usedep){
		TMobilizepeople tMobilizepeople=tMobilizepeopleMapper.selectByPrimaryKey(id);
		tMobilizepeople.setUsedep(usedep);
		tMobilizepeople.setFinancialdep(financialdep);//更新财务管理科处理的意见
		if(tMobilizepeople.getServicedep()!=null&&tMobilizepeople.getServicedep().equals("")==false){//更新该消息通知的处理情况
				tMobilizepeople.setStatus(true);
		}
		int m=tMobilizepeopleMapper.updateByPrimaryKey(tMobilizepeople);
		return m;
	}
	
	/**
	 * 尼雷清
	 * 根据depcode 查询该部门名称查询该部门名称
	 * @param 
	 * @return
	 */
	public String getDepNameByDepcode(String depcode){
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		TDepartmentExample.Criteria tdepartCriteria=tDepartmentExample.createCriteria();
		tdepartCriteria.andDepcodeEqualTo(depcode);
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		if(tDepartmentsList.size()==0){
			System.out.println("nlq:部门代码为"+depcode+"对应的部门名称不存在！");
			return null;
		}else{
			return tDepartmentsList.get(0).getDepname();
		}
	}
	/***
	 * 尼雷清
	 * 返回jsonarry 包含所有的人员信息
	 * @param 
	 * @return 
	 */
	public JSONArray getAllUserName(){
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		TUserExample tUserExample = new TUserExample();
		List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
		if(tUsersList.size()==0){//若查找不到对应的人员信息则返回空
			return null;
		}else{
			for(int i=0;i<tUsersList.size();i++){
				jsonObject.put("username", tUsersList.get(i).getUsername());
				jsonArray.add(i, jsonObject);
			}
			return jsonArray;
		}
	}
	
	
	/**
	 * 尼雷清
	 * 假分页的实现     
	 * @param pageParameter、List<TMessageListWithMobilizePeople>
	 * @return List<TMessageListWithMobilizePeople>
	 */
	public List<TMessageListWithMobilizePeople> cheatToShowListWithList(List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples,PageParameter pageParameter){
		int currentPage=pageParameter.getCurrentPage();
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoplesWithPageList=new ArrayList<TMessageListWithMobilizePeople>();
		if(currentPage*10>tMessageListWithMobilizePeoples.size()){
			for(int i=(currentPage-1)*10;i<tMessageListWithMobilizePeoples.size();i++){
				tMessageListWithMobilizePeoplesWithPageList.add(tMessageListWithMobilizePeoples.get(i));
			}
		}else{
			for(int i=(currentPage-1)*10;i<currentPage*10;i++){
				tMessageListWithMobilizePeoplesWithPageList.add(tMessageListWithMobilizePeoples.get(i));
			}
		}
		
		pageParameter.setTotalPage((tMessageListWithMobilizePeoples.size()+9)/10);
		pageParameter.setTotalCount(tMessageListWithMobilizePeoples.size());
		return tMessageListWithMobilizePeoplesWithPageList;
	}
	/**
	 * 尼雷清
	 * 自己写的查询  等效于and**equalto
	 * 根据 title、sendpeople、status、senddepname四个条件查询该部门下接受的所有通知     
	 * @param title、sendpeople、status、senddepname、List<TMessageListWithMobilizePeople>(查询出来的对应的List集合)
	 * @return List<TMessageListWithMobilizePeople>  返回按照条件筛选完的list集合
	 */
	public List<TMessageListWithMobilizePeople> getListByCondition(List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples,String title,String sendpeople,Boolean status,String senddepname){
		//按照title查询
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples1=new ArrayList<TMessageListWithMobilizePeople>();
		if(title!=null&&title.equals("")==false){
			for(int i=0;i<tMessageListWithMobilizePeoples.size();i++){
				if(tMessageListWithMobilizePeoples.get(i).getTitle().equals(title)==true){
					tMessageListWithMobilizePeoples1.add(tMessageListWithMobilizePeoples.get(i));
				}
			}
		}else{
			tMessageListWithMobilizePeoples1=tMessageListWithMobilizePeoples;
		}
		//按照sendpeople查询
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples2=new ArrayList<TMessageListWithMobilizePeople>();
		if(sendpeople!=null&&sendpeople.equals("")==false){
			for(int i=0;i<tMessageListWithMobilizePeoples1.size();i++){
				if(tMessageListWithMobilizePeoples1.get(i).getSendpeople()!=null&&tMessageListWithMobilizePeoples1.get(i).getSendpeople()!=""&&tMessageListWithMobilizePeoples1.get(i).getSendpeople().equals(sendpeople)==true){
					tMessageListWithMobilizePeoples2.add(tMessageListWithMobilizePeoples1.get(i));
				}
			}
		}else{
			tMessageListWithMobilizePeoples2=tMessageListWithMobilizePeoples1;
		}
		
		//按照status查询
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples3=new ArrayList<TMessageListWithMobilizePeople>();
		if(status!=null){
			for(int i=0;i<tMessageListWithMobilizePeoples2.size();i++){
				if(tMessageListWithMobilizePeoples2.get(i).getStatus()==status){
					tMessageListWithMobilizePeoples3.add(tMessageListWithMobilizePeoples2.get(i));
				}
			}
		}else{
			tMessageListWithMobilizePeoples3=tMessageListWithMobilizePeoples2;
		}
		//按照senddepname查询
		List<TMessageListWithMobilizePeople> tMessageListWithMobilizePeoples4=new ArrayList<TMessageListWithMobilizePeople>();
		if(senddepname!=null&&senddepname.equals("")==false){
			for(int i=0;i<tMessageListWithMobilizePeoples3.size();i++){
				if(tMessageListWithMobilizePeoples3.get(i).getSenddepname().equals(senddepname)==true){
					tMessageListWithMobilizePeoples4.add(tMessageListWithMobilizePeoples3.get(i));
				}
			}
		}else{
			tMessageListWithMobilizePeoples4=tMessageListWithMobilizePeoples3;
		}
		return tMessageListWithMobilizePeoples4;
	}
	/********************************************************************主界面top消息提醒模块**********************************************************************************/
	/**
	 * 尼雷清
	 * 统计该人员需要接受和处理的通知   的个数   
	 * @param depcode
	 * @return int 
	 */
/*	public int countMsg(String depcode){
		int msgcount=0;//普通通知需要处理的个数
		int mbpcount=0;//人员变动表需要做操作的个数(注：是该depcode需要的操作是否已经做了，此处不用判断status)
		TMessageExample tMessageExample=new TMessageExample();
		TMessageExample.Criteria tMsgCriteria=tMessageExample.createCriteria();
		tMsgCriteria.andAcceptdepcodeEqualTo(depcode).andStatusEqualTo(false);//筛选出需要接受的消息中的未处理的消息
		List<TMessage> tMessagesList=tMessageMapper.selectByExample(tMessageExample);
		msgcount=tMessagesList.size();//计算出普通通知中的未处理的消息个数
		
		//统计人员变动表需要做操作的个数
		if(depcode.equals("07")==true){//如果该人员对应的是财务管理科
			TMobilizepeopleExample tMobilizepeopleExample=new TMobilizepeopleExample();
			List<TMobilizepeople> tMobilizepeoplesList=tMobilizepeopleMapper.selectByExample(tMobilizepeopleExample);
				if(tMobilizepeoplesList==null){
					mbpcount=0;
				}else{
					for(int i=0;i<tMobilizepeoplesList.size();i++){
						if(tMobilizepeoplesList.get(i).getFinancialdep()==null||tMobilizepeoplesList.get(i).getFinancialdep().equals("")==true){
							mbpcount++;
						}
					}
				}
		}
	}*/
	/**
	 * 尼雷清(先前的 当变动人员的原部门同  财务、机关服务中心相同时只需处理一次              条件下的统计该登陆人员的消息条数)
	 * 根据部门代码统计出未读的普通通知以及未处理的人员变动表的通知   的个数   
	 * @param depcode
	 * @return json
	 */
	public int msgToDealWithCount(String depcode){
		int msgcount=0;//普通通知需要处理的个数
		int mbpcount=0;//人员变动表需要做操作的个数(注：是该depcode需要的操作是否已经做了，此处不用判断status)
		TMessageExample tMessageExample=new TMessageExample();
		TMessageExample.Criteria tMsgCriteria=tMessageExample.createCriteria();
		tMsgCriteria.andAcceptdepcodeEqualTo(depcode).andStatusEqualTo(false);//筛选出需要接受的消息中的未处理的消息
		List<TMessage> tMessagesList=tMessageMapper.selectByExample(tMessageExample);
		msgcount=tMessagesList.size();//计算出普通通知中的未处理的消息个数
		
		
		
		//统计人员变动表需要做操作的个数
		if(depcode==null||depcode.equals("")==true){
			System.out.println("nlq:top消息通知模块：depcode为空！");
			return 0;
		}
		if(depcode.equals("07")==true){//如果该人员对应的是财务管理科
			TMobilizepeopleExample tMobilizepeopleExample=new TMobilizepeopleExample();
			List<TMobilizepeople> tMobilizepeoplesList=tMobilizepeopleMapper.selectByExample(tMobilizepeopleExample);
				if(tMobilizepeoplesList==null){
					mbpcount=0;
				}else{
					for(int i=0;i<tMobilizepeoplesList.size();i++){
						if(tMobilizepeoplesList.get(i).getFinancialdep()==null||tMobilizepeoplesList.get(i).getFinancialdep().equals("")==true){
							mbpcount++;
						}
					}
				}
		}else if(depcode.equals("16")==true){//如果该人员对应的是机关服务中心
			TMobilizepeopleExample tMobilizepeopleExample=new TMobilizepeopleExample();
			List<TMobilizepeople> tMobilizepeoplesList=tMobilizepeopleMapper.selectByExample(tMobilizepeopleExample);
				if(tMobilizepeoplesList==null){
					mbpcount=0;
				}else{
					for(int i=0;i<tMobilizepeoplesList.size();i++){
						if(tMobilizepeoplesList.get(i).getServicedep()==null||tMobilizepeoplesList.get(i).getServicedep().equals("")==true){
							mbpcount++;
						}
					}
				}
		}else{
			TDepartmentExample tDepartmentExample=new TDepartmentExample();
			TDepartmentExample.Criteria tDepCriteria=tDepartmentExample.createCriteria();
			tDepCriteria.andDepcodeEqualTo(depcode);
			List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);//查询出该depcode对应得中文部门名称
			if(tDepartmentsList.size()==0){
				System.out.println("nlq:部门表中不存在depcode="+depcode+"的部门！");
				return 0;
			}
			
			TMobilizepeopleExample tMobilizepeopleExample=new TMobilizepeopleExample();
			TMobilizepeopleExample.Criteria tMobileCriteria=tMobilizepeopleExample.createCriteria();
			tMobileCriteria.andOriginaldepEqualTo(tDepartmentsList.get(0).getDepname());//在t_Mobilizepeople中Originaldep对应得是中文部门名称
			List<TMobilizepeople> tMobilizepeoplesList=tMobilizepeopleMapper.selectByExample(tMobilizepeopleExample);
				if(tMobilizepeoplesList==null){
					mbpcount=0;
				}else{
					for(int i=0;i<tMobilizepeoplesList.size();i++){
						if(tMobilizepeoplesList.get(i).getUsedep()==null||tMobilizepeoplesList.get(i).getUsedep().equals("")==true){
							mbpcount++;
						}
					}
				}
		}
		int msgTotalCount=msgcount+mbpcount;	
		return msgTotalCount;
	}
}
