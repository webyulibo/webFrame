package cn.bronze.services;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TRoleMapper;
import cn.bronze.daos.TRoleMapperExtand;
import cn.bronze.daos.TUserMapper;
import cn.bronze.daos.TUserMapperExtand;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TRole;
import cn.bronze.entities.TRoleExample;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.entities.TUserExampleCumtom;
import cn.bronze.entities.TUserExtend;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
@Component//定义切面
public class AdminUserManagerService extends GenernicServiceImpl<TUser, TUserExample>{
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TRoleMapper tRoleMapper;
	@Autowired
	private TDepartmentMapper tDepartmentMapper;
	@Autowired
	private TRoleMapperExtand tRoleMapperExtand;
	@Autowired
	private TUserMapperExtand tUserMapperExtand;
	@Test
	/***
	 * 尼雷清
	 * 测试根据查询条件查询用户信息    testgetTuserByConditionWithPage
	 * @param pageParameter
	 * @param condition
	 * @param text
	 * @return List<AssetType>
	 */
	public void testgetUserByConditionWithPage(){
		String condition="";
		String text="";
		PageParameter pageParameter=new PageParameter();
		
		TUserExampleCumtom tUserExampleCumtom=new TUserExampleCumtom();
		TUserExampleCumtom.Criteria tUserCriteria=tUserExampleCumtom.createCriteria();
		if(condition!=null&&condition!=""){
			if(text!=null&&text!=""){
				if(condition.equals("useraccount")==true){//按照用户名查询
					tUserCriteria.andUseraccountEqualTo(text);
				}else if(condition.equals("usercode")==true){//按照人员代码查询	
					tUserCriteria.andUsercodeEqualTo(text);
					//tUserCriteria.andUsercodeLike("%"+text+"%");
				}else if(condition.equals("username")==true){//根据人员姓名查询
					tUserCriteria.andUsernameEqualTo(text);
				}else if(condition.equals("usertype")==true){//根据人员类别查询
					tUserCriteria.andUsertypeEqualTo(text);
				}else if(condition.equals("usersex")==true){//根据人员性别查询
					tUserCriteria.andUsersexEqualTo(text);
				}else if(condition.equals("userstate")==true){//根据状态查询
					tUserCriteria.andUserstateEqualTo(text);
				}else if(condition.equals("userduty")==true){//根据职务查询
					tUserCriteria.andUserdutyEqualTo(text);
				}else if(condition.equals("userdep")==true){//根据部门查询 ， 注意此时数据库中用的是 部门代码
					tUserCriteria.andUserdepEqualTo(text);
				}
				List<TUser> tUsersList=tUserMapper.selectByExample(tUserExampleCumtom);
				List<TUserExtend> tUserExtendsList=fuzhi(tUsersList);
				tUserExampleCumtom.setPage(pageParameter);
				System.out.println(tUsersList.size());
			}else{//若查询条件选择，但未输入值那么直接按照对应的字段排序
				tUserExampleCumtom.setOrderByClause(condition);
				List<TUser> tUsersList=tUserMapper.selectByExample(tUserExampleCumtom);
				List<TUserExtend> tUserExtendsList=fuzhi(tUsersList);
				tUserExampleCumtom.setPage(pageParameter);
				System.out.println(tUsersList.get(0).getUsercode()+" "+tUsersList.get(1).getUsercode());
			}
		}else{
			System.out.println("查询条件condition为空!");
		}

	}
	/***
	 * 尼雷清
	 * 根据查询条件查询用户信息    getTuserByConditionWithPage
	 * @param pageParameter
	 * @param condition
	 * @param text
	 * @return List<TUser>
	 */
	public List<TUserExtend> getUserByConditionWithPage(String condition,String text,PageParameter pageParameter){
	
		TUserExampleCumtom tUserExampleCumtom=new TUserExampleCumtom();
		TUserExampleCumtom.Criteria tUserCriteria=tUserExampleCumtom.createCriteria();
		if(condition!=null&&condition!=""){
			if(text!=null&&text!=""){
				if(condition.equals("useraccount")==true){//按照用户名查询
					tUserCriteria.andUseraccountEqualTo(text);
				}else if(condition.equals("usercode")==true){//按照人员代码查询	
					tUserCriteria.andUsercodeEqualTo(text);
					//tUserCriteria.andUsercodeLike("%"+text+"%");
				}else if(condition.equals("username")==true){//根据人员姓名查询
					tUserCriteria.andUsernameEqualTo(text);
				}else if(condition.equals("usertype")==true){//根据人员类别查询
					tUserCriteria.andUsertypeEqualTo(text);
				}else if(condition.equals("usersex")==true){//根据人员性别查询
					tUserCriteria.andUsersexEqualTo(text);
				}else if(condition.equals("userstate")==true){//根据状态查询
					tUserCriteria.andUserstateEqualTo(text);
				}else if(condition.equals("userduty")==true){//根据职务查询
					tUserCriteria.andUserdutyEqualTo(text);
				}else if(condition.equals("userdep")==true){//根据部门查询 ， 注意此时数据库中用的是 部门代码
					tUserCriteria.andUserdepEqualTo(text);
				}
				tUserExampleCumtom.setPage(pageParameter);
				List<TUser> tUsersList=tUserMapper.selectByExample(tUserExampleCumtom);
				List<TUserExtend> tUserExtendsList=fuzhi(tUsersList);
				return tUserExtendsList;
			}else{//若查询条件选择，但未输入值那么直接按照对应的字段排序
				tUserExampleCumtom.setOrderByClause(condition);
				tUserExampleCumtom.setPage(pageParameter);
				List<TUser> tUsersList=tUserMapper.selectByExample(tUserExampleCumtom);
				List<TUserExtend> tUserExtendsList=fuzhi(tUsersList);
				return tUserExtendsList;
			}
		}else{
			System.out.println("查询条件condition为空!");
			return null;
		}

	}
	@Test
	/***
	 * 尼雷清(测试用例)
	 * 测试用户登陆验证   testLoginCheckOn
	 * @param useraccount
	 * @return List<TUser>
	 */
	public void testLoginCheckOn(){
		String useraccount="admin9";
		TUserExample tUserExample=new TUserExample();
		TUserExample.Criteria tUserCriteria=tUserExample.createCriteria();
		tUserCriteria.andUseraccountEqualTo(useraccount);
		List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
		if(tUsersList.size()==0){
			System.out.println("不存在该用户！");
		}else{
			System.out.println(tUsersList.get(0).getUsername());
		}
	}
	/***
	 * 尼雷清
	 * 用户登陆验证   LoginCheckOn
	 * @param useraccount
	 * @return TUser
	 */
	public TUser loginCheckOn(String useraccount){
		TUserExample tUserExample=new TUserExample();
		TUserExample.Criteria tUserCriteria=tUserExample.createCriteria();
		tUserCriteria.andUseraccountEqualTo(useraccount);
		List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
		if(tUsersList.size()==0){
			return null;
		}else{
			return tUsersList.get(0);
		}
	}
	@Test
	/***
	 * 尼雷清
	 * 测试执行设置用户角色    setUserRole
	 * @param id(int)
	 * @param role(int)
	 * @return record(int)
	 */
	public void testupdateUserRole(){
		int role=2;
		int id=1;
		TUser tUser=tUserMapper.selectByPrimaryKey(id);
		tUser.setUserrole(role);
		int record=tUserMapper.updateByPrimaryKey(tUser);
		System.out.println(record);
	}
	/***
	 * 尼雷清
	 * 执行设置用户角色    setUserRole
	 * @param id(int)
	 * @param role(int)
	 * @return record(int)
	 */
	@Log(descrp="执行设置用户角色操作",type="系统管理员权限")
	public int updateUserRole(int userid,int role){
		TUser tUser=tUserMapper.selectByPrimaryKey(userid);
		tUser.setUserrole(role);
		int record=tUserMapper.updateByPrimaryKey(tUser);
		return record;
	}
	@Test
	/***
	 * 尼雷清
	 * 测试修改用户信息    updateUserById
	 * @param Tuser
	 * @return 
	 */
	public void testupdateUserByTUser(){
		TUser tUser=new TUser();
		tUser.setId(3);
		tUser.setUseraccount("admin3");
		int record=tUserMapper.updateByPrimaryKey(tUser);
		System.out.println(record);
	}
	/***
	 * 尼雷清
	 * 执行修改用户信息    updateUserByTuser
	 * @param String
	 * @return int
	 * 
	 */
	@Log(descrp="执行修改用户信息操作",type="系统管理员权限")
	public int updateUserByTUser(Integer userid,String useraccount,String userpassword,String username,String usercode,String usersex,String userdep,String userduty,String usertype,String userstate ){
		TUser tUser=tUserMapper.selectByPrimaryKey(userid);
		tUser.setUseraccount(useraccount);
		tUser.setUserpassword(userpassword);
		tUser.setUsername(username);
		tUser.setUsercode(usercode);
		tUser.setUsersex(usersex);
		tUser.setUserdep(userdep);
		tUser.setUserduty(userduty);
		tUser.setUsertype(usertype);
		tUser.setUserstate(userstate);
		int record=tUserMapper.updateByPrimaryKey(tUser);
		return record;
	}
	/***
	 * 尼雷清
	 * 执行显示用户信息    showUserById
	 * @param id(int)
	 * @return TUser
	 */
	public TUser selectUserById (Integer id){
		TUser tUser=tUserMapper.selectByPrimaryKey(id);
		return tUser;
	}
	/***
	 * 尼雷清
	 * 根据用户名查询用户信息    getUserByUserAccount
	 * @param id(int)
	 * @return TUser
	 */
	public String getUserByUserAccount (String ueraccount){
		TUserExample tUserExample=new TUserExample();
		TUserExample.Criteria tCriteria=tUserExample.createCriteria();
		tCriteria.andUseraccountEqualTo(ueraccount);
		List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
		if(tUsersList.size()==0){
			System.out.println("nlq:不存在该用户名，因而无法去到对应的人员信息！");
			return null;
		}else {
			TDepartmentExample tDepartmentExample=new TDepartmentExample();
			TDepartmentExample.Criteria tdepCriteria=tDepartmentExample.createCriteria();
			String  depcode=tUsersList.get(0).getUserdep();
			if(depcode==null||depcode.equals("")==true){
				System.out.println("nlq:该useraccount在t_user中对应的部门代码不能为空！");
				return null;
			}else{
				tdepCriteria.andDepcodeEqualTo(depcode);
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
				if(tDepartmentsList.size()==0){
					System.out.println("nlq:该useraccount在t_user中对应的部门代码，在t_department表中找不到对应的部门！");
					return null;
				}else{
					return tDepartmentsList.get(0).getDepname();
				}
			}
		}
		
	}
	/***
	 * 尼雷清
	 * 根据用户名查询用户所在部门代码    getUserByUserAccount
	 * @param id(int)
	 * @return TUser
	 */
	public String getUserDepCodeByUserAccount (String ueraccount){
		TUserExample tUserExample=new TUserExample();
		TUserExample.Criteria tCriteria=tUserExample.createCriteria();
		tCriteria.andUseraccountEqualTo(ueraccount);
		List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);
		if(tUsersList.size()==0){
			System.out.println("nlq:不存在该用户名，因而无法去到对应的人员信息！");
			return null;
		}else {
			TDepartmentExample tDepartmentExample=new TDepartmentExample();
			TDepartmentExample.Criteria tdepCriteria=tDepartmentExample.createCriteria();
			String  depcode=tUsersList.get(0).getUserdep();
			if(depcode==null||depcode.equals("")==true){
				System.out.println("nlq:该useraccount在t_user中对应的部门代码不能为空！");
				return null;
			}else{
				tdepCriteria.andDepcodeEqualTo(depcode);
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
				if(tDepartmentsList.size()==0){
					System.out.println("nlq:该useraccount在t_user中对应的部门代码，在t_department表中找不到对应的部门！");
					return null;
				}else{
					return tDepartmentsList.get(0).getDepcode();
				}
			}
		}
		
	}
	@Test
	/***
	 * 尼雷清
	 * 测试返回 设置权限 的Json串    testgetUserRoleJson
	 * @param 
	 * @return 
	 */
	public void testgetUserRoleJson(){
		TRoleExample tRoleExample=new TRoleExample();
		List<TRole> tRolesList=tRoleMapper.selectByExample(tRoleExample);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		int count=tRoleMapperExtand.countRoleItems();
		for(int i=0;i<count;i++){
			jsonObject.put("id",tRolesList.get(i).getId());
			jsonObject.put("text", tRolesList.get(i).getRolename());
			jsonArray.add(i, jsonObject);
		}
		System.out.println("asdas");
	}
	/***
	 * 尼雷清
	 * 返回   设置用户权限   的Json串    getUserRoleJson
	 * @param 
	 * @return 
	 */
	public JSONArray getUserRoleJson(){
		TRoleExample tRoleExample=new TRoleExample();
		List<TRole> tRolesList=tRoleMapper.selectByExample(tRoleExample);
		
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		int count=tRoleMapperExtand.countRoleItems();
		for(int i=0;i<count;i++){
			jsonObject.put("id",tRolesList.get(i).getId());
			jsonObject.put("text", tRolesList.get(i).getRolename());
			jsonArray.add(i, jsonObject);
		}
		return jsonArray;
	}
	@Test
	/***
	 * 尼雷清
	 * 测试 根据查询条件condition 返回对应的用户信息的Json串    testgetUserJson
	 * @param 
	 * @return 
	 */
	public void testgetUserJson(){
		String condition="usercode";
		TUserExample tUserExample=new TUserExample();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);//查询出来所有用户的信息
		List<TUserExtend> tUserExtendsList=fuzhi(tUsersList);//应用拓展的user类
		if(condition.equals("useraccount")==true){//按照用户名查询
			for(int i=0;i<tUsersList.size();i++){
				jsonObject.put("value",tUserExtendsList.get(i).getUseraccount());
				jsonObject.put("text",tUserExtendsList.get(i).getUseraccount());
				jsonArray.add(i, jsonObject);
			}
		}else if(condition.equals("usercode")==true){//按照人员代码查询	
			for(int i=0;i<tUserExtendsList.size();i++){
				jsonObject.put("value",tUserExtendsList.get(i).getUsercode());
				jsonObject.put("text",tUserExtendsList.get(i).getUsercode());
				jsonArray.add(i, jsonObject);
			};
		}else if(condition.equals("username")==true){//根据人员姓名查询
			for(int i=0;i<tUserExtendsList.size();i++){
				jsonObject.put("value",tUserExtendsList.get(i).getUsername());
				jsonObject.put("text",tUserExtendsList.get(i).getUsername());
				jsonArray.add(i, jsonObject);
			};
		}else if(condition.equals("usertype")==true){//根据人员类别查询
			for(int i=0;i<tUserExtendsList.size();i++){
				jsonObject.put("value",tUserExtendsList.get(i).getUsercode());
				jsonObject.put("text",tUserExtendsList.get(i).getUsercode());
				jsonArray.add(i, jsonObject);
			};
		}else if(condition.equals("usersex")==true){//根据人员性别查询
			for(int i=0;i<tUserExtendsList.size();i++){
				jsonObject.put("value",tUserExtendsList.get(i).getUsersex());
				jsonObject.put("text",tUserExtendsList.get(i).getUsersex());
				jsonArray.add(i, jsonObject);
			};
		}else if(condition.equals("userstate")==true){//根据状态查询
			for(int i=0;i<tUserExtendsList.size();i++){
				jsonObject.put("value",tUserExtendsList.get(i).getUserstate());
				jsonObject.put("text",tUserExtendsList.get(i).getUserstate());
				jsonArray.add(i, jsonObject);
			};
		}else if(condition.equals("userduty")==true){//根据职务查询
			for(int i=0;i<tUserExtendsList.size();i++){
				jsonObject.put("value",tUserExtendsList.get(i).getUserduty());
				jsonObject.put("text",tUserExtendsList.get(i).getUserduty());
				jsonArray.add(i, jsonObject);
			};
		}else if(condition.equals("userdep")==true){//根据部门查询 ， 注意此时数据库中用的是 部门代码
			for(int i=0;i<tUserExtendsList.size();i++){
				jsonObject.put("value",tUserExtendsList.get(i).getUserdep());
				jsonObject.put("text",tUserExtendsList.get(i).getUserdepString());
				jsonArray.add(i, jsonObject);
			};
		}
		System.out.println("asdas");
	}
	/***
	 * 尼雷清
	 * 根据查询条件condition 返回对应的用户信息的Json串    testgetUserJson
	 * @param condition(String)
	 * @return 
	 */
	public JSONArray getUserJson(String condition){
		TUserExample tUserExample=new TUserExample();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		if(condition.equals("useraccount")==true){//按照用户名查询
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);//查询出来所有用户的信息
			for(int i=0;i<tUsersList.size();i++){
				if(tUsersList.get(i).getUseraccount()!=null&&tUsersList.get(i).getUseraccount().equals("")==false){
				jsonObject.put("value",tUsersList.get(i).getUseraccount());
				jsonObject.put("text",tUsersList.get(i).getUseraccount());
				jsonArray.add(i, jsonObject);
				}
			}
		}else if(condition.equals("usercode")==true){//按照人员代码查询	
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);//查询出来所有用户的信息
			//List<TUserExtend> tUserExtendsList=fuzhi(tUsersList);//应用拓展的user类
			for(int i=0;i<tUsersList.size();i++){
				if(tUsersList.get(i).getUsercode()!=null&&tUsersList.get(i).getUsercode().equals("")==false){
				jsonObject.put("value",tUsersList.get(i).getUsercode());
				jsonObject.put("text",tUsersList.get(i).getUsercode());
				jsonArray.add(i, jsonObject);
				}
			};
		}else if(condition.equals("username")==true){//根据人员姓名查询
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExample);//查询出来所有用户的信息
			//List<TUserExtend> tUserExtendsList=fuzhi(tUsersList);//应用拓展的user类
			for(int i=0;i<tUsersList.size();i++){
				if(tUsersList.get(i).getUsername()!=null&&tUsersList.get(i).getUsername().equals("")==false){
				jsonObject.put("value",tUsersList.get(i).getUsername());
				jsonObject.put("text",tUsersList.get(i).getUsername());
				jsonArray.add(i, jsonObject);
				}
				else
					continue;
			};
		}else if(condition.equals("usertype")==true){//根据人员类别查询   
			List<String> userTypeList=tUserMapperExtand.selectUserType();
			for(int i=0;i<userTypeList.size();i++){
				if(userTypeList.get(i)!=null&&userTypeList.get(i).equals("")==false){
					jsonObject.put("value",userTypeList.get(i));
					jsonObject.put("text",userTypeList.get(i));
					jsonArray.add(i, jsonObject);
				}
			};
		}else if(condition.equals("usersex")==true){//根据人员性别查询
				jsonObject.put("value","男");
				jsonObject.put("text","男");
				jsonArray.add(0, jsonObject);
				jsonObject.put("value","女");
				jsonObject.put("text","女");
				jsonArray.add(1, jsonObject);
		}else if(condition.equals("userstate")==true){//根据状态查询  
			List<String> userStateList=tUserMapperExtand.selectUserState();
			for(int i=0;i<userStateList.size();i++){
				if(userStateList.get(i)!=null&&userStateList.get(i).equals("")==false){
					jsonObject.put("value",userStateList.get(i));
					jsonObject.put("text",userStateList.get(i));
					jsonArray.add(i, jsonObject);
				}
			};
		}else if(condition.equals("userduty")==true){//根据职务查询 
			List<String> userDutyList=tUserMapperExtand.selectUserDuty();
			int m=0;
			for(int i=0;i<userDutyList.size();i++){
				if(userDutyList.get(i)!=null&&userDutyList.get(i).equals("")==false){
				jsonObject.put("value",userDutyList.get(i));
				jsonObject.put("text",userDutyList.get(i));
				jsonArray.add(m, jsonObject);
				m++;
				}
			};
		}else if(condition.equals("userdep")==true){//根据部门查询 ， 注意此时数据库中用的是 部门代码 
			List<String> userDepList=tUserMapperExtand.selectUserDep();
			for(int i=0;i<userDepList.size();i++){
				TDepartmentExample tDepartmentExample=new TDepartmentExample();
				TDepartmentExample.Criteria tDepCriteria=tDepartmentExample.createCriteria();
				tDepCriteria.andDepcodeEqualTo(userDepList.get(i));//根据部门代码查询出对应的部门名称 注：数据库中的部门代码不能出现重复的
				List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
				if(tDepartmentsList.size()==0){System.out.println("nlq:getUserJson()--部门代码取值错误，导致无法取到对应部门名称！");}
				jsonObject.put("value",userDepList.get(i));
				jsonObject.put("text",tDepartmentsList.get(0).getDepname());
				jsonArray.add(i, jsonObject);
			};
		}
		return jsonArray;
	}
	/***
	 * 尼雷清
	 * 只返回对应部门信息的Json串    depcodevalue:depnametext
	 * @param 
	 * @return 
	 */
	public JSONArray getDepJson(){
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		tDepartmentExample.setOrderByClause("depcode");
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		for(int i=0;i<tDepartmentsList.size();i++){
			jsonObject.put("depcodevalue", tDepartmentsList.get(i).getDepcode());
			jsonObject.put("depnametext", tDepartmentsList.get(i).getDepname());
			jsonArray.add(i, jsonObject);	
		}
		return jsonArray;
		}
	@Test
	/***
	 * 尼雷清
	 * 测试只返回对应部门信息的Json串    depcodevalue:depnametext
	 * @param 
	 * @return 
	 */
	public void testgetDepJson(){
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		TDepartmentExample tDepartmentExample=new TDepartmentExample();
		tDepartmentExample.setOrderByClause("depcode");
		List<TDepartment> tDepartmentsList=tDepartmentMapper.selectByExample(tDepartmentExample);
		for(int i=0;i<tDepartmentsList.size();i++){
			jsonObject.put("depcodevalue", tDepartmentsList.get(i).getDepcode());
			jsonObject.put("depnametext", tDepartmentsList.get(i).getDepname());
			jsonArray.add(i, jsonObject);	
		}
		System.out.println("asdasd");
		}
	@Test
	/***
	 * 尼雷清
	 * 测试只返回对应职务信息的Json串   testgetDutyJson
	 * @param 
	 * @return 
	 */
	public void testgetDutyJson(){
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		List<String> userDutyList=tUserMapperExtand.selectUserDuty();
		for(int i=0;i<userDutyList.size();i++){
			if(userDutyList.get(i)!=null){//如果查询的不为空的话在将其添加到Json串中将其传出去
			jsonObject.put("value",userDutyList.get(i));
			jsonObject.put("text",userDutyList.get(i));
			jsonArray.add(i, jsonObject);
			}
		};
		System.out.println("asdasd");
		}
	/***
	 * 尼雷清
	 * 只返回对应职务信息的Json串   getDutyJson
	 * @param 
	 * @return 
	 */
	public JSONArray getDutyJson(){
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		List<String> userDutyList=tUserMapperExtand.selectUserDuty();
		int n=0;
		for(int i=0;i<userDutyList.size();i++){
			if(userDutyList.get(i)!=null&&userDutyList.get(i).equals("")==false){//如果查询的不为空的话在将其添加到Json串中将其传出去
			jsonObject.put("value",userDutyList.get(i));
			jsonObject.put("text",userDutyList.get(i));
			jsonArray.add(n, jsonObject);
			n++;
			}
		};
		return jsonArray;
		}
	@Test
	/***
	 * 尼雷清
	 * 测试修改用户名合法性验证   testisUserAccountLegal
	 * @param 
	 * @return 
	 */
	public void testisUserAccountLegal(){
		String useraccount="admin4";
		String preuseraccount="admin4";
		boolean m;
		if(useraccount.equals(preuseraccount)==true){
			m=true;
		}else{
			TUserExampleCumtom tUserExampleCumtom=new TUserExampleCumtom();
			TUserExampleCumtom.Criteria tuserCriteria=tUserExampleCumtom.createCriteria();
			tuserCriteria.andUseraccountEqualTo(useraccount);
			List<TUser> tUsersList=tUserMapper.selectByExample(tUserExampleCumtom);
			if(tUsersList.size()==0){
				m=true;
			}else{
				m=false;
			}
		}
		System.out.println(m);
	}
	/***
	 * 尼雷清
	 * 修改用户名合法性验证   isUserAccountLegal
	 * @param 
	 * @return 
	 */
	public boolean isUserAccountLegal(String useraccount,String preuseraccount){
		if(useraccount.equals(preuseraccount)==true){
			return true;
		}else{
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
	}
	/***
	 * 尼雷清
	 * 修改人员代码合法性验证   isUserCodeLegal
	 * @param 
	 * @return 
	 */
	public boolean isUserCodeLegal(String usercode,String preusercode){
		if(usercode.equals(preusercode)==true){
			return true;
		}else{
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
	
}
