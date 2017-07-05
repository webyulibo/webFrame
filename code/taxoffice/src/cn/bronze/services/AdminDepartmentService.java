package cn.bronze.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;





























import cn.bronze.daos.AssetTypeMapper;
import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TMessageMapper;
import cn.bronze.daos.TRoleMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.AssetType;
import cn.bronze.entities.AssetTypeExample;
import cn.bronze.entities.AssetTypeExampleCumtom;
import cn.bronze.entities.DepartmentWithUserMessage;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TDepartmentExampleCustom;
import cn.bronze.entities.TMessage;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.entities.TUserExampleCumtom;
import cn.bronze.entities.TUserExtend;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;
@RunWith(SpringJUnit4ClassRunner.class)
@Component//定义切面
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminDepartmentService {
	@Autowired
	private TDepartmentMapper tDepartmentMapper;
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TRoleMapper tRoleMapper;
	
	@Autowired
	private TMessageMapper tMessageMapper;
	
	@Test
	public void testDepCode() {

		TDepartmentExample example=new TDepartmentExample();
		//先从部门表中将所有部门代码查出来
		TDepartmentExample.Criteria criteria=example.createCriteria();
		List<TDepartment> departments=tDepartmentMapper.selectByExample(example);
		System.out.println(departments.size());
		
		if (departments!=null&&departments.size()>0) {
			//封装一个message对象，用户插入数据
			for (int i = 0; i < departments.size(); i++) {
				TMessage tMessage=new TMessage();
				Date date=new Date();
				tMessage.setTitle("系统通知");
				tMessage.setSendtime(date);
				tMessage.setMsg("各位资产管理员，年初了该制定按月抽查盘点计划和年终盘点计划了");
				tMessage.setAcceptdepcode(departments.get(i).getDepcode());
				tMessageMapper.insert(tMessage);
			}
			
		}
		
	}
	
	
	
	/*@Test
	*//***
	 * 尼雷清(测试用例)
	 * 测试根据查询条件查询用户信息    testgetDepByConditionWithPage
	 * @param pageParameter
	 * @param condition
	 * @param text
	 * @return 
	 */
/*	public void testgetDepByConditionWithPage(){
		String condition="depcode";
		String text="01";
		PageParameter pageParameter=new PageParameter();
		
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		TDepartmentExampleCustom.Criteria tDepcCriteria=tDepartmentExampleCustom.createCriteria();
		if(condition!=null&&condition!=""){
			if(text!=null&&text!=""){
				if(condition.equals("depcode")==true){//按照部门代码查询
					tDepcCriteria.andDepcodeEqualTo(text);
				}else if(condition.equals("depname")==true){//按照部门名称查询	
					tDepcCriteria.andDepnameEqualTo(text);
				}else if(condition.equals("depstate")==true){//根据状态查询
					tDepcCriteria.andDepstateEqualTo(text);
				}
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
				tDepartmentExampleCustom.setPage(pageParameter);
				System.out.println(tDepartmentsList.get(0).getDepname());
			}else{//若查询条件选择，但未输入值那么直接按照对应的字段排序
				tDepartmentExampleCustom.setOrderByClause(condition);
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
				tDepartmentExampleCustom.setPage(pageParameter);
				System.out.println(tDepartmentsList.get(0).getDepcode()+" "+tDepartmentsList.get(1).getDepcode());
			}
		}else{
			System.out.println("查询条件condition为空!");
		}

	}*/
	/***
	 * 尼雷清
	 * 根据查询条件查询部门信息    getDepByConditionWithPage
	 * @param pageParameter
	 * @param condition
	 * @param text
	 * @return List<TDepartment>
	 */
	public List<TDepartment> getDepByConditionWithPage(String condition,String text,PageParameter pageParameter ){
		//countDepUseNum();//计算各个部门的总人数并赋值
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		TDepartmentExampleCustom.Criteria tDepcCriteria=tDepartmentExampleCustom.createCriteria();
		if(condition!=null&&condition!=""){
			if(text!=null&&text!=""){
				if(condition.equals("depcode")==true){//按照部门代码查询
					tDepcCriteria.andDepcodeEqualTo(text);
				}else if(condition.equals("depname")==true){//按照部门名称查询	
					tDepcCriteria.andDepnameEqualTo(text);
				}else if(condition.equals("depstate")==true){//根据状态查询
					tDepcCriteria.andDepstateEqualTo(text);
				}
				tDepartmentExampleCustom.setPage(pageParameter);
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
				return tDepartmentsList;
			}else{//若查询条件选择，但未输入值那么直接按照对应的字段排序
				if(condition.equals("depstate")==true){
					tDepartmentExampleCustom.setOrderByClause(condition+" desc");
				}else{
					tDepartmentExampleCustom.setOrderByClause(condition);
				}
				
				tDepartmentExampleCustom.setPage(pageParameter);
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
				return tDepartmentsList;
			}
		}else{
			System.out.println("nlq:部门信息查询条件condition为空!");
			return null;
		}
	}
/*	@Test
	*//***
	 * 尼雷清(测试用例)
	 * 测试执行添加部门信息    testaddDep
	 * @param String
	 * @return 
	 * 
	 *//*
	public void testaddDep(){
		String depcode="";
		String depname="";
		int depusernum=0;
		String depstate="";
		TDepartment tDepartment=new TDepartment();
		tDepartment.setDepcode(depcode);
		tDepartment.setDepname(depname);
		tDepartment.setDepusernum(depusernum);
		tDepartment.setDepstate(depstate);
		int m=tDepartmentMapper.insert(tDepartment);
		System.out.println(m);
	}*/
	/***
	 * 尼雷清
	 * 执行添加部门信息    addDep
	 * @param String
	 * @return  int
	 * 
	 */
	@Log(descrp="执行添加部门操作",type="系统管理员权限")
	public int addDep(String depcode,String depname,String depstate){
		if(depcode.equals("")==true||depcode==null){
			return 0;
		}
		if(depname.equals("")==true||depname==null){
			return 0;
		}
		if(depstate.equals("")==true||depstate==null){
			return 0;
		}
		TDepartment tDepartment=new TDepartment();
		tDepartment.setDepcode(depcode);
		tDepartment.setDepname(depname);
		tDepartment.setDepusernum(0);
		tDepartment.setDepstate(depstate);
		int m=tDepartmentMapper.insert(tDepartment);
		return m;
	}
	/***
	 * 尼雷清
	 * 执行编辑修改部门信息    updateDep
	 * @param id depcode depname depstate
	 * @return  int
	 * 
	 */
	@Log(descrp="执行编辑部门操作",type="系统管理员权限")
	public int updateDep(Integer id, String depcode,String depname,String depstate){
		if(depcode.equals("")==true||depcode==null){
			System.out.println("nlq:部门代码不能为空！");
			return 0;
		}
		if(depname.equals("")==true||depname==null){
			System.out.println("nlq:部门姓名不能为空！");
			return 0;
		}
		if(depstate.equals("")==true||depstate==null){
			System.out.println("nlq:状态不能为空！");
			return 0;
		}
		TDepartment tDepartment=tDepartmentMapper.selectByPrimaryKey(id);
		tDepartment.setDepcode(depcode);
		tDepartment.setDepname(depname);
		tDepartment.setDepstate(depstate);
		int m=tDepartmentMapper.updateByPrimaryKey(tDepartment);
		return m;
	}
/*	@Test
	*//***
	 * 尼雷清(测试用例)
	 * 执行删除部门信息    testdeleteDep
	 * @param id 
	 * @return  int
	 * 
	 *//*
	public void testdeleteDep(){
		Integer id=5;
		TDepartment tDepartment=tDepartmentMapper.selectByPrimaryKey(id);
		TUserExample tUserExample=new TUserExample();
		TUserExample.Criteria tUserCriteria=tUserExample.createCriteria();
		if(tDepartment.getDepcode()==null||tDepartment.getDepcode().equals("")){
			System.out.println("nlq:该部门ID对应的部门代码为空，不能进行删除操作!");
		}else{
			tUserCriteria.andUserdepEqualTo(tDepartment.getDepcode());//此处是这个部门存在那么必须有部门代码 和 名称
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
			if(tUsersList.size()!=0){
				System.out.println("nlq:该部门下存在员工无法删除，请删除员工后再进行操作！");
			}else{
				int m=tDepartmentMapper.deleteByPrimaryKey(id);
				System.out.println("nlq:删除成功！"+m);
			}
		}
		
	}*/
	/***
	 * 尼雷清
	 * 执行删除部门信息    deleteDep
	 * @param id 
	 * @return  int
	 * 
	 */
	@Log(descrp="执行删除部门操作",type="系统管理员权限")
	public int deleteDep(Integer id){
		TDepartment tDepartment=tDepartmentMapper.selectByPrimaryKey(id);
		TUserExample tUserExample=new TUserExample();
		TUserExample.Criteria tUserCriteria=tUserExample.createCriteria();
		if(tDepartment.getDepcode()==null||tDepartment.getDepcode().equals("")){
			System.out.println("nlq:该部门ID对应的部门代码为空，不能进行删除操作!");
			return -1;
		}else{
			tUserCriteria.andUserdepEqualTo(tDepartment.getDepcode());//此处是这个部门存在那么必须有部门代码 和 名称
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
			if(tUsersList.size()!=0){
				System.out.println("nlq:该部门下存在员工无法删除，请删除员工后再进行操作！");
				return 0;
			}else{
				int m=tDepartmentMapper.deleteByPrimaryKey(id);
				return m;
			}
		}
		
	}
	/***
	 * 尼雷清
	 * 执行删除部门内人员信息    deleteUserByDep
	 * @param id (Tuser-id)
	 * @return  
	 * 
	 */
	@Log(descrp="执行删除部门人员操作",type="系统管理员权限")
	public int deleteUserByDep(Integer id){
		TUser tUser=tUserMapper.selectByPrimaryKey(id);
		if(tUser.getUserdep().equals("")||tUser.getUserdep()==null){
			System.out.println("nlq:t_user表中id为："+id+"的用户，userdep为空！");
			return 0;
		}
		int record=tUserMapper.deleteByPrimaryKey(id);
		countDepUseNum();//更新各个部门的部门总人数
		return record;
	}
/*	@Test
	*//***
	 * 尼雷清(测试用例)
	 * 根据depcode显示部门人员信息  testgetDepUser
	 * @param depcode(String) 
	 * @return 
	 * 
	 *//*
	public void testgetDepUser(){
		String depcode="01";
		TUserExample tUserExample=new TUserExample();
		TUserExample.Criteria tUserCriteria=tUserExample.createCriteria();
		tUserCriteria.andUserdepEqualTo(depcode);
		List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
		System.out.println(tUsersList.size());
	}*/
	/***
	 * 尼雷清
	 * 根据depcode显示部门人员信息  getUserByDepWithPage
	 * @param depcode(String) pageParameter 
	 * @return 
	 * 
	 */
	public List<TUserExtend> getUserByDepWithPage(String depcode,PageParameter pageParameter){
		TUserExampleCumtom tUserExampleCumtom=new TUserExampleCumtom();
		TUserExampleCumtom.Criteria tUserCriteria=tUserExampleCumtom.createCriteria();
		tUserCriteria.andUserdepEqualTo(depcode);
		tUserExampleCumtom.setPage(pageParameter);
		List<TUser> tUsersList=tUserMapper.selectByExample(tUserExampleCumtom);
		List<TUserExtend> tUserExtendsList=fuzhi(tUsersList);
		return tUserExtendsList;
	}
	/***
	 * 尼雷清
	 * 执行对相应部门内添加人员，并更新部门的人员总数
	 * @param depcode(String) 
	 * @return 
	 * 
	 */
	@Log(descrp="执行添加部门人员操作",type="系统管理员权限")
	public int addDepUserByDepCode(String depcode,String useraccount,String userpassword,String username,String usercode,String usersex,String userduty,Integer userrole,String usertype,String userstate){
		TUser tUser=new TUser();
		if(useraccount!=null&&useraccount.equals("")==false){
			tUser.setUseraccount(useraccount);
		}else{
			System.out.println("nlq(部门管理):用户名不能为空，添加人员失败！");
			return 0;
		}
		if(userpassword!=null&&userpassword.equals("")==false){
			tUser.setUserpassword(userpassword);
		}else{
			System.out.println("nlq(部门管理):密码不能为空，添加人员失败！");
			return 0;
		}
		if(username!=null&&username.equals("")==false){
			tUser.setUsername(username);
		}else{
			System.out.println("nlq(部门管理):人员姓名不能为空，添加人员失败！");
			return 0;
		}
		if(depcode!=null&&depcode.equals("")==false){
			tUser.setUserdep(depcode);
		}else{
			System.out.println("nlq(部门管理):部门代码不能为空，添加人员失败！");
			return 0;
		}
		if(usercode!=null&&usercode.equals("")==false){
			tUser.setUsercode(usercode);
		}else{
			System.out.println("nlq(部门管理):人员代码不能为空，添加人员失败！");
			return 0;
		}
		if(usersex!=null&&usersex.equals("")==false){
			tUser.setUsersex(usersex);
		}else{
			System.out.println("nlq(部门管理):人员性别不能为空，添加人员失败！");
			return 0;
		}
		if(usertype!=null&&usertype.equals("")==false){
			tUser.setUsertype(usertype);
		}
			tUser.setUserduty(userduty);//人员职务无论是否为空，都可添加进去
			
		if(userrole!=null&&userrole.equals("")==false){
			tUser.setUserrole(userrole);
		}else{
			System.out.println("nlq(部门管理):人员角色不能为空，添加人员失败！");
			return 0;
		}
		if(userstate!=null&&userstate.equals("")==false){
			tUser.setUserstate(userstate);
		}
		int record=tUserMapper.insert(tUser);
		if(record>0){//进行更新各部门的总人数
			countDepUseNum();
		}
		return record;
	}
	/***
	 * 尼雷清
	 * 执行对带有roleString 以及 depString的扩展类进行赋值    setUserRole
	 * @param List<TUser>
	 * @return List<TUserExtend> 
	 */
	public List<TUserExtend> fuzhi(List<TUser> tUsersList){
		List<TUserExtend> tUserExtendsList=new ArrayList<TUserExtend>();
		for(int i=0;i<tUsersList.size();i++)
		{	
			if(tUsersList.get(i).getUserrole()==null||tUsersList.get(i).getUserrole().equals("")){System.out.println("nlq:id为"+tUsersList.get(i).getId() +"人员角色不能为空！"); return null;}
			if(tUsersList.get(i).getUserdep()==null||tUsersList.get(i).getUserdep().equals("")){System.out.println("nlq:id为"+ tUsersList.get(i).getId()+"人员部门不能为空！"); return null;}
			if(tRoleMapper.selectByPrimaryKey(tUsersList.get(i).getUserrole()).getRolename()==null||tRoleMapper.selectByPrimaryKey(tUsersList.get(i).getUserrole()).getRolename().equals("")){System.out.println("nlq:人员角色表代码对应的角色名不能为空！"); return null;}
			String userroleString=tRoleMapper.selectByPrimaryKey(tUsersList.get(i).getUserrole()).getRolename();
			
			TDepartmentExample tDepartmentExample=new TDepartmentExample();
			TDepartmentExample.Criteria tDepCriteria=tDepartmentExample.createCriteria();
			tDepCriteria.andDepcodeEqualTo(tUsersList.get(i).getUserdep());
			if(tDepartmentMapper.selectByExample(tDepartmentExample).size()==0){System.out.println("nlq:人员表中部门代码未在部门表中找到对应部门"); return null;}
			if(tDepartmentMapper.selectByExample(tDepartmentExample).get(0).getDepname()==null||tDepartmentMapper.selectByExample(tDepartmentExample).get(0).getDepname().equals("")){System.out.println("nlq:人员表中部门代码对应的部门名不能为空！"); return null;}
			String userdepString=tDepartmentMapper.selectByExample(tDepartmentExample).get(0).getDepname();
			TUserExtend tUserExtend=new TUserExtend();
			tUserExtend.setId(tUsersList.get(i).getId());
			tUserExtend.setUseraccount(tUsersList.get(i).getUseraccount());
			tUserExtend.setUserpassword(tUsersList.get(i).getUserpassword());
			tUserExtend.setUsercode(tUsersList.get(i).getUsercode());
			tUserExtend.setUsername(tUsersList.get(i).getUsername());
			tUserExtend.setUsertype(tUsersList.get(i).getUsertype());
			tUserExtend.setUserbankcode(tUsersList.get(i).getUserbankcode());
			tUserExtend.setUsersalarycode(tUsersList.get(i).getUsersalarycode());
			tUserExtend.setUsersex(tUsersList.get(i).getUsersex());
			tUserExtend.setUserstate(tUsersList.get(i).getUserstate());
			tUserExtend.setUserdep(tUsersList.get(i).getUserdep());
			tUserExtend.setUserrole(tUsersList.get(i).getUserrole());
			tUserExtend.setUserduty(tUsersList.get(i).getUserduty());
			tUserExtend.setUserroleString(userroleString);
			tUserExtend.setUserdepString(userdepString);
			tUserExtendsList.add(tUserExtend);
//			System.out.println(tUserExtendsList.get(i).getUserroleString()+" ");
//			System.out.println(tUserExtendsList.get(i).getUserdepString()+" ");
		}
		return tUserExtendsList;
	}
	@Test
	/***
	 * 尼雷清(测试用例)
	 * 测试从t_user中统计各部门人数并将其赋值到t_department中的depusernum
	 * @param 
	 * @return  
	 */
	public void testcountDepUseNum(){
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		for(int i=0;i<tDepartmentsList.size();i++){
			TUserExample tUserExample=new TUserExample();
			TUserExample.Criteria tUserCriteria=tUserExample.createCriteria();
			if(tDepartmentsList.get(i).getDepcode()==null||tDepartmentsList.get(i).getDepcode().equals("")==true){
				System.out.println("nlq:id为"+tDepartmentsList.get(i).getId()+"的部门代码不能为空！");
			}
			tUserCriteria.andUserdepEqualTo(tDepartmentsList.get(i).getDepcode());//查询出该部门下的所有用户 ,若出去退休人员那么在加条件
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
			TDepartment tDepartment=tDepartmentsList.get(i);
			tDepartment.setDepusernum(tUsersList.size());//此处是将该部门下的各种状态的人员总数更新到部门表中
			tDepartmentMapper.updateByPrimaryKey(tDepartment);
		}
	}

	/***
	 * 尼雷清
	 * 从t_user中统计各部门人数并将其赋值到t_department中的depusernum
	 * @param 
	 * @return 
	 */
	public void countDepUseNum(){
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		for(int i=0;i<tDepartmentsList.size();i++){
			TUserExample tUserExample=new TUserExample();
			TUserExample.Criteria tUserCriteria=tUserExample.createCriteria();
			if(tDepartmentsList.get(i).getDepcode()==null||tDepartmentsList.get(i).getDepcode().equals("")==true){
				System.out.println("nlq:id为"+tDepartmentsList.get(i).getId()+"的部门代码不能为空！");
				/*return null;*/
			}
			tUserCriteria.andUserdepEqualTo(tDepartmentsList.get(i).getDepcode());//查询出该部门下的所有用户 ,若出去退休人员那么在加条件
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
			TDepartment tDepartment=tDepartmentsList.get(i);
			tDepartment.setDepusernum(tUsersList.size());//此处是将该部门下的各种状态的人员总数更新到部门表中
			tDepartmentMapper.updateByPrimaryKey(tDepartment);
		}
	}
	/*@Test
	*//***
	 * 尼雷清(测试用例)
	 * 测试通过查询条件condition生成下一个下拉框的jsonArray
	 * @param 
	 * @return 
	 *//*
	public void testgetDepJson(){
		String conditon="depstate";
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		if(conditon.equals("depcode")==true){
			for(int i=0;i<tDepartmentsList.size();i++){
				jsonObject.put("value", tDepartmentsList.get(i).getDepcode());
				jsonObject.put("text", tDepartmentsList.get(i).getDepcode());
				jsonArray.add(i, jsonObject);
			}
		}
		if(conditon.equals("depname")==true){
			for(int i=0;i<tDepartmentsList.size();i++){
				jsonObject.put("value", tDepartmentsList.get(i).getDepname());
				jsonObject.put("text", tDepartmentsList.get(i).getDepname());
				jsonArray.add(i, jsonObject);
			}
		}
		if(conditon.equals("depstate")==true){//部门状态就两种所以直接写两种状态的Jsono串
				jsonObject.put("value","启用");
				jsonObject.put("text","启用");
				jsonArray.add(0, jsonObject);
				jsonObject.put("value","关闭");
				jsonObject.put("text","关闭");
				jsonArray.add(1, jsonObject);
		}
		System.out.println("生成JsonArray成功！");
	}*/
	/***
	 * 尼雷清
	 * 测试通过查询条件condition生成下一个下拉框的jsonArray
	 * @param 
	 * @return 
	 */
	public JSONArray getDepJson(String condition){
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		if(condition.equals("depcode")==true){
			for(int i=0;i<tDepartmentsList.size();i++){
				jsonObject.put("value", tDepartmentsList.get(i).getDepcode());
				jsonObject.put("text", tDepartmentsList.get(i).getDepcode());
				jsonArray.add(i, jsonObject);
			}
		}
		if(condition.equals("depname")==true){
			for(int i=0;i<tDepartmentsList.size();i++){
				jsonObject.put("value", tDepartmentsList.get(i).getDepname());
				jsonObject.put("text", tDepartmentsList.get(i).getDepname());
				jsonArray.add(i, jsonObject);
			}
		}
		if(condition.equals("depstate")==true){//部门状态就两种所以直接写两种状态的Jsono串
				jsonObject.put("value","启用");
				jsonObject.put("text","启用");
				jsonArray.add(0, jsonObject);
				jsonObject.put("value","关闭");
				jsonObject.put("text","关闭");
				jsonArray.add(1, jsonObject);
		}
		return jsonArray;
	}
	/***
	 * 尼雷清
	 * 部门代码的合法性验证   isDepCodeLegal
	 * @param 
	 * @return 
	 */
	public boolean isDepCodeLegal(String depcode){
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		TDepartmentExample.Criteria tDepcCriteria=tDepartmentExample.createCriteria();
		tDepcCriteria.andDepcodeEqualTo(depcode);
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		if(tDepartmentsList.size()==0){
			return true;
		}else{
			return false;
		}
	}
	/***
	 * 尼雷清
	 * 部门名称的合法性验证   isDepNameLegal
	 * @param 
	 * @return 
	 */
	public boolean isDepNameLegal(String depname){
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		TDepartmentExample.Criteria tDepcCriteria=tDepartmentExample.createCriteria();
		tDepcCriteria.andDepnameEqualTo(depname);
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		if(tDepartmentsList.size()==0){
			return true;
		}else{
			return false;
		}
	}
	/***
	 * 尼雷清
	 * 添加用户名合法性验证   isUserAccountLegal
	 * @param 
	 * @return 
	 */
	public boolean isUserAccountLegal(String useraccount){

			TUserExampleCumtom tUserExampleCumtom=new TUserExampleCumtom();
			TUserExampleCumtom.Criteria tuserCriteria=tUserExampleCumtom.createCriteria();
			tuserCriteria.andUseraccountEqualTo(useraccount);
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExampleCumtom);
			if(tUsersList.size()==0){
				return true;
			}else{
				return false;
			}
	}
	/***
	 * 尼雷清
	 * 添加人员代码合法性验证   isUserCodeLegal
	 * @param 
	 * @return 
	 */
	public boolean isUserCodeLegal(String usercode){
			TUserExampleCumtom tUserExampleCumtom=new TUserExampleCumtom();
			TUserExampleCumtom.Criteria tuserCriteria=tUserExampleCumtom.createCriteria();
			tuserCriteria.andUsercodeEqualTo(usercode);
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExampleCumtom);
			if(tUsersList.size()==0){
				return true;
			}else{
				return false;
			}
	}
	/***
	 * 尼雷清
	 * 修改编辑部门代码的合法性验证   isEditDepCodeLegal
	 * @param 
	 * @return 
	 */
	public boolean isEditDepCodeLegal(String depcode,String predepcode){
		if(depcode.equals(predepcode)==true){
			return true;
		}else{
			TDepartmentExample tDepartmentExample=new TDepartmentExample();
			TDepartmentExample.Criteria tDepcCriteria=tDepartmentExample.createCriteria();
			tDepcCriteria.andDepcodeEqualTo(depcode);
			List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
			if(tDepartmentsList.size()==0){
				return true;
			}else{
				return false;
			}
		}
		
	}
	/***
	 * 尼雷清
	 * 在 资产添加时 根据 选择的部门名称返回对应的  人员名称的jsonArray
	 * @param 
	 * @return 
	 */
	public JSONArray getUserNameByAssetDep(String depname){
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		TDepartmentExample.Criteria tdepCriteria=tDepartmentExample.createCriteria();
		tdepCriteria.andDepnameEqualTo(depname);
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		if(tDepartmentsList.size()==0){
			System.out.println("nlq:在资产模块中：  在部 门列表中找不到对应的部门名称！");
			return null;
		}else{
			String userdep=tDepartmentsList.get(0).getDepcode();
			TUserExample tUserExample=new TUserExample();
			TUserExample.Criteria tuserCriteria=tUserExample.createCriteria();
			tuserCriteria.andUserdepEqualTo(userdep);
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
			if(tUsersList.size()==0){
				return null;
			}else{
				int n=0;
				for(int i=0;i<tUsersList.size();i++){
					if(tUsersList.get(i).getUsername()!=null||tUsersList.get(i).getUsername().equals("")==false){
						jsonObject.put("username",tUsersList.get(i).getUsername());
						jsonArray.add(n, jsonObject);
					}else{
						System.out.println("nlq：user表id为："+tUsersList.get(i).getId()+"的人员信息中人员姓名为空！");
					}
					n++;
				}
				return jsonArray;
			}
		}
	}
	/***
	 * 尼雷清
	 * 在消息通知处 根据相应的部门代码depcode显示对应得人员信息
	 * @param 
	 * @return 
	 */
	public JSONArray getUserNameByDepcode(String depcode){
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		TUserExample tUserExample = new TUserExample();
		TUserExample.Criteria tUserCriteria=tUserExample.createCriteria();
		tUserCriteria.andUserdepEqualTo(depcode);
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
	/***
	 * 尼雷清
	 * 返回部门名称并对应部门内人员姓名的集合
	 * @param 
	 * @return 
	 */
	public List<DepartmentWithUserMessage> getUserMessageByDep(){
		List<DepartmentWithUserMessage> departmentWithUserMessagesList=new ArrayList<DepartmentWithUserMessage>();
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		if(tDepartmentsList.size()==0){
			System.out.println("nlq:部门信息为空！");
			return null;
		}else{
			for(int i=0;i<tDepartmentsList.size();i++){
				
				if(tDepartmentsList.get(i).getDepcode()==null||tDepartmentsList.get(i).getDepcode().equals("")==true){
					System.out.println("nlq:部门表中ID为"+tDepartmentsList.get(i).getId()+"的部门代码不存在!");
					return null;
				}
				if(tDepartmentsList.get(i).getDepname()==null||tDepartmentsList.get(i).getDepname().equals("")==true){
					System.out.println("nlq:部门表中ID为"+tDepartmentsList.get(i).getId()+"的部门名称不存在!");
					return null;
				}
				
				
				TUserExample tUserExample=new TUserExample();
				TUserExample.Criteria tuserCriteria=tUserExample.createCriteria();
				tuserCriteria.andUserdepEqualTo(tDepartmentsList.get(i).getDepcode());
				List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);//查询出符合对应部门的所有人员信息
				List<String> tUserListStrings=new ArrayList<String>();
				for(int j=0;j<tUsersList.size();j++){//遍历tUsersList集合，并将所有的集合中的人员姓名存储到list集合当中
					tUserListStrings.add(j, tUsersList.get(j).getUsername());
				}
				DepartmentWithUserMessage departmentWithUserMessage=new DepartmentWithUserMessage();
				departmentWithUserMessage.setDepartmentname(tDepartmentsList.get(i).getDepname());//首先将对应的部门名称放入departmentWithUserMessage对象
				departmentWithUserMessage.setUsermessagelist(tUserListStrings);//将查询出来的部门人员名称的list<string>集合放入departmentWithUserMessage对象
				departmentWithUserMessagesList.add(i, departmentWithUserMessage);
			}
			return departmentWithUserMessagesList;
		}
		
	}
/*	@Test
	public void getTDepartmentList(){
		int currentPage=1;
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TDepartment> departmentList = new ArrayList<>();
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		tDepartmentExampleCustom.setPage(pageParameter);
		TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
		departmentList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
		System.out.println(departmentList.size());
	}
	public List<TDepartment> getTDepartmentListWithPage(PageParameter page){
		List<TDepartment> departmentList = new ArrayList<>();
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		tDepartmentExampleCustom.setPage(page);
		TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
		departmentList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
		return departmentList;
	}
	@Test
	public void testgetTDepartmentByCode(){
		String code="01";
		int currentPage=1;
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		List<TDepartment> departmentList = new ArrayList<>();
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		tDepartmentExampleCustom.setPage(pageParameter);
		TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
		tDepartmentCriteria.andDepcodeEqualTo(code);
		departmentList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
		System.out.println(departmentList.size());
	}
	public List<TDepartment>  getTDepartmentByCode(String code,PageParameter page){
		if(code==null||code.length()==0)
			return null;
		List<TDepartment> departmentList = new ArrayList<>();
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		tDepartmentExampleCustom.setPage(page);
		TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
		tDepartmentCriteria.andDepcodeEqualTo(code);
		departmentList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
		return departmentList;
	}
	@Test
	public void testinsertTDepartment(){
		TDepartment tDepartment=new TDepartment();
		tDepartment.setDepcode("02");
		tDepartment.setDepname("人事教育科");
		tDepartment.setDepstate("启用");
		if(tDepartment.getDepcode()!=null)
		{
			if(tDepartment.getDepname()!=null){
				TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
				TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
				List<TDepartment> departmentList = new ArrayList<>();
				departmentList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
				for(int i=0;i<departmentList.size();i++){
					if(tDepartment.getDepcode().equals(departmentList.get(i).getDepcode())||tDepartment.getDepname().equals(departmentList.get(i).getDepname())){
						System.out.println("部门名称重复！");
						break;
					}
					if(i==departmentList.size()-1){
						tDepartmentMapper.insert(tDepartment);
					}
		     	}
			}else
				System.out.println("部门名称不能为空！");
		}
		else{
			System.out.println("部门代码不能为空！");
			}
	}
	public int insertTDepartment(TDepartment tDepartment){
		if(tDepartment.getDepcode()!=null)
		{
			if(tDepartment.getDepname()!=null){
				TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
				TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
				List<TDepartment> departmentList = new ArrayList<>();
				departmentList=tDepartmentMapper.selectByExample(tDepartmentExampleCustom);
				for(int i=0;i<departmentList.size();i++){
					if(tDepartment.getDepcode().equals(departmentList.get(i).getDepcode())){
						System.out.println("部门代码重复！");
						break;
					}
					if(tDepartment.getDepname().equals(departmentList.get(i).getDepname())){
						System.out.println("部门名称重复！");
						break;
					}
					if(i==departmentList.size()-1){
						int status=tDepartmentMapper.insert(tDepartment);
						return status;
					}
		     	}
				
			}else{
				System.out.println("部门名称不能为空！");
				return 0;}
		}
		else{
			System.out.println("部门代码不能为空！");
			return 0;
		}
		return 0;
	}
	@Test
	public void testdeleteTDepartmentById(){
		int id=3;
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
		tDepartmentMapper.deleteByPrimaryKey(id);
	}
	public int deleteTDepartmentById(int id){
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
		int record=tDepartmentMapper.deleteByPrimaryKey(id);
		return record;
	}
	@Test
	public void testupdateByTDepartment(){
		TDepartmentExampleCustom tDepartmentExampleCustom=new TDepartmentExampleCustom();
		TDepartmentExampleCustom.Criteria tDepartmentCriteria = tDepartmentExampleCustom.createCriteria();
		List<TDepartment> departmentList = new ArrayList<>();
		TDepartment tDepartment=departmentList.get(1);
		tDepartment.setDepcode("03");
		tDepartment.setDepname("人事教育科");
		tDepartment.setDepstate("启用");
		if(tDepartment.getDepcode()!=null){
			if(tDepartment.getDepname()!=null){
				if(tDepartment.getDepcode().equals(departmentList.get(1).getDepcode())&&tDepartment.getDepname().equals(departmentList.get(2).getDepname())){
					tDepartmentMapper.updateByPrimaryKey(tDepartment);
				}else{
					int i,j;
					for(i=0;i<departmentList.size();i++){
						if(i!=1)
						{
							if(tDepartment.getDepcode().equals(departmentList.get(i).getDepcode()))
								break;
						}
					}
					for(j=0;j<departmentList.size();j++){
						if(j!=1)
						{
							if(tDepartment.getDepname().equals(departmentList.get(i).getDepname()))
								break;
						}
					}
					if(i==departmentList.size()-1&&j==departmentList.size()-1)
						tDepartmentMapper.updateByPrimaryKey(tDepartment);
					else if(i!=departmentList.size()-1&&j!=departmentList.size()-1){
						System.out.println("部门代码重复！");
						System.out.println("部门名称重复！");
					}else if(i!=departmentList.size()-1){
						System.out.println("部门代码重复！");
					}else if(j!=departmentList.size()-1)
						System.out.println("部门代码重复！");
					}
			}else{
				System.out.println("部门名称不能为空！");
			}
		}else{
			System.out.println("部门代码不能为空！");
		}
	}*/
}
