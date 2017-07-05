package cn.bronze.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.MyImportMapper;
import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.log.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminImportExcelService {
	@Autowired
	public MyImportMapper myImportMapper;
	@Autowired
	public TUserMapper userMapper;
	@Autowired
	public TDepartmentMapper  departmentMapper;
/**
 * 于立波
 * userlist 用户信息集合
 * 插入数据库方式为覆盖
 */
	@Log(descrp="执行导入人员信息操作",type="系统管理权限")
	public void  importUserList(
			List<TUser> userlist
			){
        for(int i=0;i<userlist.size();i++){
        	String depcode=myImportMapper.getDepcode(userlist.get(i).getUserdep());
        	userlist.get(i).setUserdep(depcode);
        	String result=myImportMapper.getName(userlist.get(i).getUsername());
        	if(result==null){
        	    //插入
        		userlist.get(i).setUserrole(6);
        		userlist.get(i).setUseraccount(userlist.get(i).getUsercode());
        		userlist.get(i).setUserpassword("123456");
        		userMapper.insert(userlist.get(i));
        	}
        	else{
        		//更新
        		 myImportMapper.updataUser(userlist.get(i));
        	}
        }
        //更改部门对应的字段
        //myImportMapper.updataUserdep();
	}
	
	/**
	 * 于立波
	 * deplist 部门信息集合
	 * 插入数据库方式为覆盖
	 */
	@Log(descrp="执行导入部门信息操作",type="系统管理权限")
public void importDepList(
		List<TDepartment> deplist
		) {
	// TODO Auto-generated method stub
	 for(int i=0;i<deplist.size();i++){
     	//String result=myImportMapper.getDepname(deplist.get(i).getDepname());
		 String result=myImportMapper.getDepcode1(deplist.get(i).getDepcode());
     	if(result==null){
     	    //插入
     		departmentMapper.insert(deplist.get(i));
     	}
     	else{
     		//更新
     		 myImportMapper.updataDep(deplist.get(i));
     	}
     }
}
  //查询导入的人员的部门信息是否存在
	public String getRe(String userdep) {
		// TODO Auto-generated method stub
		String re=myImportMapper.getDepname(userdep);
		return re;
	}
    //去除deplist里的空格
	public static List<TDepartment> cleardep(List<TDepartment> deplist1) {
		// TODO Auto-generated method stub
		if(deplist1.size()==0){
			System.out.println(deplist1+"(这个list集合是空的)");
			return deplist1;
		}
		if(deplist1.size()!=0){
			for(int i=0;i<deplist1.size();i++){
				if(deplist1.get(i).getDepcode()!=null){
					deplist1.get(i).setDepcode(deplist1.get(i).getDepcode().replace(" ", ""));
				}
				if(deplist1.get(i).getDepname()!=null){
					deplist1.get(i).setDepname(deplist1.get(i).getDepname().replace(" ", ""));
				}
				if(deplist1.get(i).getDepstate()!=null){
					deplist1.get(i).setDepstate(deplist1.get(i).getDepstate().replace(" ", ""));
				}
			}
			 return deplist1;
		}
      return deplist1;
	}
	//去除userlist里的空格
	public List<TUser> clearuse(List<TUser> userlist1) {
		// TODO Auto-generated method stub
		if(userlist1.size()==0){
			System.out.println(userlist1+"(这个list集合是空的)");
			return userlist1;
		}
		if(userlist1.size()!=0){
			for(int i=0;i<userlist1.size();i++){
				if(userlist1.get(i).getUsercode()!=null){
					userlist1.get(i).setUsercode(userlist1.get(i).getUsercode().replace(" ", ""));
				}
				if(userlist1.get(i).getUsername()!=null){
					userlist1.get(i).setUsername(userlist1.get(i).getUsername().replace(" ", ""));
				}
				if(userlist1.get(i).getUsertype()!=null){
					userlist1.get(i).setUsertype(userlist1.get(i).getUsertype().replace(" ", ""));
				}
				if(userlist1.get(i).getUserbankcode()!=null){
					userlist1.get(i).setUserbankcode(userlist1.get(i).getUserbankcode().replace(" ", ""));
				}
				if(userlist1.get(i).getUsersalarycode()!=null){
					userlist1.get(i).setUsersalarycode(userlist1.get(i).getUsersalarycode().replace(" ", ""));
				}
				if(userlist1.get(i).getUsersex()!=null){
					userlist1.get(i).setUsersex(userlist1.get(i).getUsersex().replace(" ", ""));
				}
				if(userlist1.get(i).getUserstate()!=null){
					userlist1.get(i).setUserstate(userlist1.get(i).getUserstate().replace(" ", ""));
				}
				if(userlist1.get(i).getUserdep()!=null){
					userlist1.get(i).setUserdep(userlist1.get(i).getUserdep().replace(" ", ""));
				}      
				if(userlist1.get(i).getUserduty()!=null){
					userlist1.get(i).setUserduty(userlist1.get(i).getUserduty().replace(" ", ""));
				}
			}
			 return userlist1;
		}
      return userlist1;
	}

	public List<Asset> clearasser(List<Asset> list1) {
		// TODO Auto-generated method stub
		
		if(list1.size()==0){
			System.out.println(list1+"(这个list集合是空的)");
			return list1;
		}
		if(list1.size()!=0){
			for(int i=0;i<list1.size();i++){
				if(list1.get(i).getCode()!=null){
					list1.get(i).setCode(list1.get(i).getCode().replace(" ", ""));
				}
				if(list1.get(i).getName()!=null){
					list1.get(i).setName(list1.get(i).getName().replace(" ", ""));
				}
				if(list1.get(i).getType()!=null){
					list1.get(i).setType(list1.get(i).getType().replace(" ", ""));
				}
				if(list1.get(i).getModel()!=null){
					list1.get(i).setModel(list1.get(i).getModel().replace(" ", ""));
				}
				if(list1.get(i).getNumber()!=null){
					list1.get(i).setNumber(list1.get(i).getNumber().replace(" ", ""));
				}
//				if(list1.get(i).getPurchasetime()!=null){
//					list1.get(i).setPurchasetime(list1.get(i).getPurchasetime().replace(" ", ""));
//				}
//				if(list1.get(i).getValue()!=null){
//					list1.get(i).setValue(list1.get(i).getValue().replace(" ", ""));
//				}
				if(list1.get(i).getUser()!=null){
					list1.get(i).setUser(list1.get(i).getUser().replace(" ", ""));
				}      
				if(list1.get(i).getUsedepartment()!=null){
					list1.get(i).setUsedepartment(list1.get(i).getUsedepartment().replace(" ", ""));
				}
				if(list1.get(i).getGhostyear()!=null){
					list1.get(i).setGhostyear(list1.get(i).getGhostyear().replace(" ", ""));
				}
			}
			 return list1;
		}
      return list1;
	}
}
