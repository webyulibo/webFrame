package cn.bronze.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.TRoleandauthMapper;
import cn.bronze.entities.TAuthority;
import cn.bronze.entities.TRole;
import cn.bronze.entities.TRoleExampleCustom;
import cn.bronze.entities.TRoleandauth;
import cn.bronze.entities.TRoleandauthExample;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminRoleAndAuthService extends GenernicServiceImpl<TRoleandauth,TRoleandauthExample>{

	@Autowired
	private TRoleandauthMapper dao;
	
	/*
	 * 
	 * 根据传入的角色id和权限id值的集合，向表中插入对应数据
	 * */
	
	public boolean addauthstorole(int roleid,List<Integer> authids){		
		//int roleid=8;
		//List<Integer> authids=new ArrayList<>();
		//authids.add(1);
		//authids.add(2);
		int status=0;
		for (int i = 0; i < authids.size(); i++) {
			TRoleandauth tRoleandauth=new TRoleandauth();
			tRoleandauth.setRoleid(roleid);
			tRoleandauth.setAuthorityid(authids.get(i));
			dao.insert(tRoleandauth);
			status++;
		}
		if(status>0)
			return true;
		else
			return false;
	
	}
	
	/*
	 * 
	 * 查出对应角色没有的权限id，并返回对应权限集合
	 * 
	 * */
	public List<Integer> getdistinctauthids(int roleid,List<Integer> authids){
		List<Integer> distinctauthids=new ArrayList<>();
		
		//根据roleid值将所有数据查出来
		TRoleandauthExample example=new TRoleandauthExample();
		TRoleandauthExample.Criteria criteria=example.createCriteria();
		criteria.andRoleidEqualTo(roleid);
		List<TRoleandauth> roleandauths=dao.selectByExample(example);		
		boolean isTrue=false;	
		
		if(authids!=null&&authids.size()>0){
			if(roleandauths!=null&&roleandauths.size()>0){
				for (int i = 0; i < authids.size(); i++) {
					int authid=authids.get(i);
					for (int j = 0; j< roleandauths.size(); j++) {
						if(authid==roleandauths.get(j).getAuthorityid()){
							isTrue=true;
							break;
						}
					}
					
					if(!isTrue){
						distinctauthids.add(authid);
					}
					isTrue=false;
					
				}
			}
			else{
				distinctauthids=authids;
			}
		}
		
		if(distinctauthids!=null&&distinctauthids.size()>0)
			return distinctauthids;
		else
			return null;

	}
	
	
	/*
	 * 
	 * 根绝传入的角色id，删除所有对应id的记录
	 * */
	
	
	public boolean deleteroleauthbyroleid(int roleid){
		
		//int roleid=2;
		
		TRoleandauthExample tRoleandauthExample=new TRoleandauthExample();
		TRoleandauthExample.Criteria criteria=tRoleandauthExample.createCriteria();
		criteria.andRoleidEqualTo(roleid);
		Integer status=dao.deleteByExample(tRoleandauthExample);
		//System.out.println(status);
		if(status!=null&&status>0)
			return true;
		else
			return false;
		
	}
	
	
	
	/*
	 * 根据传入的roleid查找对应的权限authid的集合
	 * */
	
	public List<Integer> getauthidsbyroleid(int roleid){
		//int roleid=1;
		TRoleandauthExample example=new TRoleandauthExample();
		TRoleandauthExample.Criteria criteria=example.createCriteria();
		criteria.andRoleidEqualTo(roleid);
		
		List<Integer> authids=new ArrayList<>();
		List<TRoleandauth> tRoleandauths=dao.selectByExample(example);
		if(tRoleandauths!=null&&tRoleandauths.size()>0){
			for (int i = 0; i < tRoleandauths.size(); i++) {
				authids.add(tRoleandauths.get(i).getAuthorityid());
			}
		}
		if(authids!=null&&authids.size()>0){
			return authids;
		}	
		else
			return null;
	}
	
}
