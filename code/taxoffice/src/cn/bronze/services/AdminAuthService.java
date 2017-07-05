package cn.bronze.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.TAuthorityMapper;
import cn.bronze.entities.TAuthority;
import cn.bronze.entities.TAuthorityExample;
import cn.bronze.entities.TAuthorityExampleCustom;
import cn.bronze.entities.TRole;
import cn.bronze.entities.TRoleExample;
import cn.bronze.entities.TRoleExampleCustom;
import cn.bronze.util.page.PageParameter;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminAuthService extends GenernicServiceImpl<TAuthority,TAuthorityExample>{

	@Autowired
	private TAuthorityMapper authdao;
	
	/***
	 * 
	 * 分页查询
	 * @param page 分页参数
	 * */
	public List<TAuthority> getroleswithpage(PageParameter page){
		TAuthorityExampleCustom exampleCustom=new TAuthorityExampleCustom();
		exampleCustom.setPage(page);
		TAuthorityExample.Criteria criteria=exampleCustom.createCriteria();
		List<TAuthority> authrities=authdao.selectByExample(exampleCustom);
		if(authrities!=null&&authrities.size()>0)
			return authrities;
		else
			return null;
//		TRoleExampleCustom tRoleExampleCustom=new TRoleExampleCustom();
//		tRoleExampleCustom.setPage(page);
//		TRoleExample.Criteria criteria=tRoleExampleCustom.createCriteria();
//		List<TRole>roles=dao.selectByExample(tRoleExampleCustom);
//		if(roles!=null&&roles.size()>0)
//			return roles;
//		else
//			return null;
	}
	
	@Test
	public void test(){
		System.out.println("123");
	}
	
	
	
	/***
	 * 根据权限名称的集合，返回所有权限对应的id
	 * 
	 * */
	public List<Integer> getidsbyauthnames(List<String> authlist){
			
//		List<String> authlist=new ArrayList<>();
		
//		authlist.add("系统管理模块查询功能");
//		authlist.add("系统管理模块其他功能");
//		authlist.add("系统管理模块全部功能");
//		
//		authlist.add("资产管理模块查询功能");
//		authlist.add("资产管理模块其他功能");
//		authlist.add("资产管理模块全部功能");
		
		TAuthorityExample example=new TAuthorityExample();
		TAuthorityExample.Criteria criteria=example.createCriteria();
		
		criteria.andAuthoritynameIn(authlist);
		
		List<TAuthority> authorities=authdao.selectByExample(example);
		
		if(authorities!=null&&authorities.size()>0){
			List<Integer> authids=new ArrayList<>();
			for (int i = 0; i < authorities.size(); i++) {
				authids.add(authorities.get(i).getId());
			}
			return authids;
			//System.out.println(authids.size());
		}
		else{
			return null;
		}
			
	}
	
	
	/***
	 * 
	 * 根据权限id集合返回对应权限名称集合
	 * */	
	public List<String> getauthnamebyauthids(List<Integer>authids){

		TAuthorityExample example=new TAuthorityExample();
		TAuthorityExample.Criteria criteria=example.createCriteria();
		criteria.andIdIn(authids);
		List<TAuthority> tAuthorities=authdao.selectByExample(example);		
		//权限名称的集合
		List<String> authorityNames=new ArrayList<>();		
		if(tAuthorities!=null&&tAuthorities.size()>0){
			for (int i = 0; i < tAuthorities.size(); i++) {			
				authorityNames.add(tAuthorities.get(i).getAuthorityname());
			}
		}
		if(authorityNames!=null&&authorityNames.size()>0){
			return authorityNames;
		}
		else
			return null;	
	}
	
	
	/***
	 * 
	 * 根据权限id的集合，返回对应权限key的集合
	 * @param List<Integer>authids 权限id集合
	 * @return authorityKeys 对应权限啊关键字的集合
	 * 
	 * */
	public List<String> getauthkeysbyauthids(List<Integer>authids){

		TAuthorityExample example=new TAuthorityExample();
		TAuthorityExample.Criteria criteria=example.createCriteria();
		criteria.andIdIn(authids);
		List<TAuthority> tAuthorities=authdao.selectByExample(example);		
		//权限名称的集合
		List<String> authorityKeys=new ArrayList<>();		
		if(tAuthorities!=null&&tAuthorities.size()>0){
			for (int i = 0; i < tAuthorities.size(); i++) {			
				authorityKeys.add(tAuthorities.get(i).getAuthoritykey());
			}
		}
		if(authorityKeys!=null&&authorityKeys.size()>0){
			return authorityKeys;
		}
		else
			return null;	
	}
	
}
