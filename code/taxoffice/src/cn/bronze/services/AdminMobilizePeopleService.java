package cn.bronze.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;






import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TMobilizepeopleMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TMobilizepeople;
import cn.bronze.entities.TMobilizepeopleExampleCustom;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.util.page.PageParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service

public class AdminMobilizePeopleService {
	@Autowired
	public TDepartmentMapper TeDpartmentMapper;
	@Autowired
	public TMobilizepeopleMapper TmobilizepeopleMapper;
	@Autowired
	public TUserMapper TuserMapper;
	/**
	   * 刘晓峰
	   * 获取人员表更记录
	   * @param  PageParameter 当前页数
	   * @return  List<TMobilizepeople>
	   */
	 public List<TMobilizepeople> getMobilizepeopleList(
	    		 PageParameter page
	    		 )
	    {
	    	List<TMobilizepeople> MobilizepeopleList=new ArrayList<>();
	    	TMobilizepeopleExampleCustom example=new TMobilizepeopleExampleCustom();
	    	example.setPage(page);
	    	MobilizepeopleList=TmobilizepeopleMapper.selectByExample(example); 
	    	List<TMobilizepeople> MobilizeList=new ArrayList<>();
	        int n=MobilizepeopleList.size();
	        for(int i=n-1;i>=0;i--)
	        {
	        	MobilizeList.add(MobilizepeopleList.get(i));
	        }
			return MobilizeList;
	    }
	 /**
	   * 刘晓峰
	   * 插入人员表更记录
	   * @param TMobilizepeople 插入的表单内容
	   * @return int
	   */
	 public int indexMobilizepeople(
			 TMobilizepeople  TMobilizepeople
			 )
	 {
		Date date=new Date();
		TMobilizepeople.setSendtime(date);
		int a=0;
		a=TmobilizepeopleMapper.insert(TMobilizepeople);
		return a;
	 }
	 /**
	   * 刘晓峰
	   * 判断部门是否合法
	   * @param department 部门
	   * @return  boolean
	   */
	 public boolean IsLegal(String department)
	 {
		 if(department=="")
			 return true;
		 else
		 {
		 TDepartmentExample TdepartmentExample=new TDepartmentExample();
		 TDepartmentExample.Criteria criteria=TdepartmentExample.createCriteria();
		 criteria.andDepnameEqualTo(department);
		 List<TDepartment> assetdepartment=TeDpartmentMapper.selectByExample(TdepartmentExample);
		 int count=assetdepartment.size();
		 if(count>0)
		     return true;
		 else
			 return false;
		 }
	 }
	 /**
	   * 刘晓峰
	   * 更新人员的部门信息
	   * @param name  originaldep newdep人员的名字，原部门，新部门
	   * @return 
	   */
	 public  void updateasset (String name,String originaldep,String newdep)
	 {
		 TDepartmentExample TdepartmentExample=new TDepartmentExample();
		 List<TDepartment> possessdepartments=TeDpartmentMapper.selectByExample(TdepartmentExample);
		 int counts=possessdepartments.size();
		 String depcode=null;
		 int m=0;
		 for(m=0;m<counts;m++)
		 {
			 String department=possessdepartments.get(m).getDepname();
			 if(department.equals(originaldep))
			 {
				depcode=possessdepartments.get(m).getDepcode();
				 break;
			 }
		 }
		 TDepartmentExample TdepartmentExample2=new TDepartmentExample();
		 List<TDepartment> possessdepartments2=TeDpartmentMapper.selectByExample(TdepartmentExample2);
		 int count=possessdepartments2.size();
		 String depcode2=null;
		 int n=0;
		 for(n=0;n<count;n++)
		 {
			 String department=possessdepartments2.get(n).getDepname();
			 if(department.equals(newdep))
			 {
				depcode2=possessdepartments2.get(n).getDepcode();
				 break;
			 }
		 }
		 TUserExample userexample=new TUserExample();
		 TUserExample.Criteria criteria=userexample.createCriteria();
		 criteria.andUsernameEqualTo(name);
		 criteria.andUserdepEqualTo(depcode);
		 List<TUser> Userlist=TuserMapper.selectByExample(userexample); 
		 //因为更新之前先对人员的姓名和原部门进行了验证，所以user表里一定有该人员
		 int count3 =Userlist.size();
		 for(int i=0;i<count3;i++)
		 {
			 Userlist.get(i).setUserdep(depcode2);
			 TuserMapper.updateByPrimaryKeySelective(Userlist.get(i));
		 }
	 }
	 /**
	   * 刘晓峰
	   * 判断人员的部门信息是否合法
	   * @param originaldep username 原部门，人员姓名
	   * @return  boolean
	   */
	 public boolean IspeopleIegal(String originaldep,String username){
		 TDepartmentExample TdepartmentExample=new TDepartmentExample();
		 List<TDepartment> possessdepartments=TeDpartmentMapper.selectByExample(TdepartmentExample);
		 int counts=possessdepartments.size();
		 String depcode="";
		 int m=0;
		 for(m=0;m<counts;m++)
		 {
			 String department=possessdepartments.get(m).getDepname();
			 if(department.equals(originaldep))
			 {
				depcode=possessdepartments.get(m).getDepcode();
				System.out.println(depcode);
				 break;
			 }
		 }
		 TUserExample userexample=new TUserExample();
		 TUserExample.Criteria criteria=userexample.createCriteria();
		 criteria.andUsernameEqualTo(username);
		 criteria.andUserdepEqualTo(depcode);
		 List<TUser> Userlist=TuserMapper.selectByExample(userexample); 
		 int count=Userlist.size();
		 if(count>0)
			 return true;
		 else
			 return false;
	 }
	 /**
	   * 刘晓峰
	   * 获取人员姓名列表
	   * @param
	   * @return  JSONArray
	   */
	 public JSONArray getname(){
		 TUserExample TuserExample=new TUserExample();
		 List<TUser> peoples=TuserMapper.selectByExample(TuserExample);
		 JSONObject jsonObject = new JSONObject();
		 JSONArray jsonArray=new JSONArray();
		 int count=peoples.size();
		 int j=0;
		 if(count==0)
		 {
			 jsonObject.put("text", "人员列表为空");
			 jsonArray.add(j,jsonObject); 
		 }
		 else
		 {
		    for(int i=0;i<count;i++)
		    {
			    jsonObject.put("text", peoples.get(i).getUsername());
			    jsonArray.add(j,jsonObject); 
			    j++;  
		    }
		 }
		 return jsonArray;
	 }
	 /**
	   * 刘晓峰
	   * 获取部门列表
	   * @param
	   * @return  JSONArray
	   */
	 public JSONArray getdepartment(){
		 TDepartmentExample TdepartmentExample=new TDepartmentExample();
		 List<TDepartment> possessdepartment=TeDpartmentMapper.selectByExample(TdepartmentExample);
		 JSONObject jsonObject = new JSONObject();
		 JSONArray jsonArray=new JSONArray();
		 int count=possessdepartment.size();
		 for(int i=0;i<count;i++)
		 {
			 jsonObject.put("text", possessdepartment.get(i).getDepname());
			 jsonArray.add(i,jsonObject); 
		 }
		 return jsonArray;
	 }
}
