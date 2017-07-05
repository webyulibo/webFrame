package cn.bronze.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.TAuthorityMapper;
import cn.bronze.daos.TRoleMapper;
import cn.bronze.entities.TRole;
import cn.bronze.entities.TRoleExample;
import cn.bronze.entities.TRoleExampleCustom;
import cn.bronze.util.page.PageParameter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminRoleService extends GenernicServiceImpl<TRole, TRoleExample> {

	@Autowired
	private TRoleMapper dao;

	/*
	 * 
	 * 分页查询
	 * @param page 分页参数
	 * */
	public List<TRole> getroleswithpage(PageParameter page){
		TRoleExampleCustom tRoleExampleCustom=new TRoleExampleCustom();
		tRoleExampleCustom.setPage(page);
		TRoleExample.Criteria criteria=tRoleExampleCustom.createCriteria();
		List<TRole>roles=dao.selectByExample(tRoleExampleCustom);
		if(roles!=null&&roles.size()>0)
			return roles;
		else
			return null;
	}
	
	/*
	 * 
	 * 根据id值删除对应角色
	 * 
	 * */
	public boolean deleterolebyid(Integer id){
		Integer status=0;
		//Integer id=8;
		status=dao.deleteByPrimaryKey(id);
		if(status!=null&&status>0)
			return true;
		else
			return false;
		
	}
	
	/*
	 * 
	 * 添加角色
	 * */
	public boolean addrole(String rolename){
		//String rolename="系统管理员";
		TRole tRole=new TRole();
		tRole.setRolename(rolename);		
		Integer status=dao.insert(tRole);		
		if(status!=null&&status>0)
			return true;
		else
			return false;
	}
	
	/*
	 * 
	 * 根据角色名称，判断是否有该角色
	 * */
	
	public boolean getrolebyrolename(String rolename){
		//String rolename="管理员";
		TRoleExampleCustom tRoleExampleCustom=new TRoleExampleCustom();
		TRoleExample.Criteria criteria=tRoleExampleCustom.createCriteria();
		criteria.andRolenameEqualTo(rolename);
		List<TRole> roles=dao.selectByExample(tRoleExampleCustom);
		if(roles!=null&&roles.size()>0)
			return true;
		else
			return false;					
	}
	
	/*
	 * 
	 * 根据id更新角色
	 * 
	 * */
	public boolean updaterolebyrolename(TRole role){
		Integer status=dao.updateByPrimaryKey(role);
		if(status!=null&&status>0)
			return true;
		else
			return false;
	}
	
	/*
	 * 
	 * 根据角色名字，获取对应的id值
	 * */
	
	public int getidbyrolename(String rolename){
		//int roleid=0;
		//String rolename="系统管理员";
		TRoleExample example=new TRoleExample();
		TRoleExample.Criteria criteria=example.createCriteria();
		criteria.andRolenameEqualTo(rolename);
		List<TRole>roles=dao.selectByExample(example);
		if(roles!=null&&roles.size()>0)
			return roles.get(0).getId();
		else
			return 0;
		//System.out.println(roleid);
	}
	
	
}
