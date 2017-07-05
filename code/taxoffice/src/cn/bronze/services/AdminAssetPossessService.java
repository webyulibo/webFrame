package cn.bronze.services;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetMapper;
import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TPossessMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TPossess;
import cn.bronze.entities.TPossessExample;
import cn.bronze.entities.TPossessExampleCustom;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;
@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service

public class AdminAssetPossessService {
	
	@Autowired
	public TPossessMapper TPossessMapper;
	@Autowired
	public AssetMapper Assetmapper;
	@Autowired
	public TUserMapper TUsermapper;
	@Autowired
	public TDepartmentMapper TeDpartmentMapper;
	//获取领用记录
	 public List<TPossess> getTPossessList(
    		 PageParameter page
    		 )
    {
    	List<TPossess> TAssetPossessList=new ArrayList<>();
    	TPossessExampleCustom example=new TPossessExampleCustom();
    	example.setPage(page);
        TAssetPossessList=TPossessMapper.selectByExample(example);
        List<TPossess> PossessList=new ArrayList<>();
        int n=TAssetPossessList.size();
        for(int i=n-1;i>=0;i--)
        {
        	PossessList.add(TAssetPossessList.get(i));
        }
		return PossessList;
    	
    }
    //向领用表中增加领用记录
	 @Log(descrp="执行增加资产领用操作",type="资产管理权限")
	 public void indexPossess(
			 TPossess  TPossess
			 )
	 {
		 TPossessMapper.insert(TPossess);
	 }
	 //根据资产编号改变资产表中资产的状态
	 public  void updateasset(String code)
	 {
		 AssetExample assetexample=new AssetExample();
		 AssetExample.Criteria criteria=assetexample.createCriteria();
		 criteria.andCodeEqualTo(code);
		 List<Asset> assetlist=Assetmapper.selectByExample(assetexample);
		 assetlist.get(0).setUsestate("在用");
		 Assetmapper.updateByPrimaryKey(assetlist.get(0));
	 }
	 //判断人员合法性
	 public boolean IsPeopleLegal(String possesspeople,String possessdepartment)
	 {		
	             TDepartmentExample TdepartmentExample=new TDepartmentExample();
	             TDepartmentExample.Criteria criteria=TdepartmentExample.createCriteria();
	             criteria.andDepnameEqualTo(possessdepartment);
	             List<TDepartment> possessdepartments=TeDpartmentMapper.selectByExample(TdepartmentExample);
	             int counts=possessdepartments.size();
				 int j;
				 String depcode=null;
				 for(j=0;j<counts;j++)
				 {
					 depcode=possessdepartments.get(j).getDepcode();
			         break;
				 }
		         TUserExample Tuserexample=new TUserExample();
				 TUserExample.Criteria criterias=Tuserexample.createCriteria();
				 criterias.andUserdepEqualTo(depcode);
				 List<TUser> assetpeople=TUsermapper.selectByExample(Tuserexample);
				 int count=assetpeople.size();
				 int i;
				 for(i=0;i<count;i++)
				 {
					 String people=assetpeople.get(i).getUsername();
					 if(people.equals(possesspeople))
					 {
						 break;
					 }
				 }
				 if(i==count)
				    return false;
				 else
					 return true;
	 }
	 //判断资产合法性
	 public boolean IspossesscodeIegal(String code)
	 {
		 AssetExample assetexample=new AssetExample();
		 AssetExample.Criteria criteria=assetexample.createCriteria();
		 criteria.andCodeEqualTo(code);
		 List<Asset> assetlist=Assetmapper.selectByExample(assetexample);
		 if(assetlist.size()==0)
		 {
			 return false;
		 }
		 else
		 {
		   int count=assetlist.size();
		   int i;
		   for(i=0;i<count;i++)
		   {
			  String usestate=assetlist.get(i).getUsestate();
			  if(usestate.equals("闲置"));
			  break;
		   }
		   if(i==count)
		   {
			  return false; 
		   }
		   else
			  return true;
		 }
	 }
	 
	 //领用部门验证
	 public boolean IsdepartmentLegal(String department)
	 {
		 TDepartmentExample TdepartmentExample=new TDepartmentExample();
		 TDepartmentExample.Criteria criteria=TdepartmentExample.createCriteria();
		 criteria.andDepnameEqualTo(department);
		 List<TDepartment> assetdepartment=TeDpartmentMapper.selectByExample(TdepartmentExample);
		 int count=assetdepartment.size();
		 int i;
		 for( i=0;i<count;i++)
		 {
			 String departments=assetdepartment.get(i).getDepname();
			 if(departments.equals(department))
			 {
				 break;
			 }
		 }
		 if(i==count)
		     return false;
		 else
			 return true;
	 }
	 //资产编号验证
	 public boolean codeIsInLegal(String code)
	 {
		 TPossessExample TpossessExample=new TPossessExample();
		 TPossessExample.Criteria criteria=TpossessExample.createCriteria();
		 criteria.andCodeEqualTo(code);
		 List<TPossess> assetpossessList=TPossessMapper.selectByExample(TpossessExample);
		 if(assetpossessList.size()!=0){
			return false;
		}else{
			 AssetExample AssetExample=new AssetExample();
			 List<Asset> getpossesscode=Assetmapper.selectByExample(AssetExample);
			 int count=getpossesscode.size();
			 int i;
			 for( i=0;i<count;i++)
			 {  
			    String possesscode=getpossesscode.get(i).getCode();
			    if(possesscode.equals(code))
			    {
			    	break;
			    }
			 }
			 if(i==count)
				 return false;
			 else
				 return true;
		}	
	 }
	 //获取资产编号
	 public JSONArray getassetpossesscode(){
		 AssetExample AssetExample=new AssetExample();
		 List<Asset> getpossesscode=Assetmapper.selectByExample(AssetExample);
		 JSONObject jsonObject = new JSONObject();
		 JSONArray jsonArray=new JSONArray();
		 int count=getpossesscode.size();
		 int j=0;
		 for(int i=0;i<count;i++)
		 {  
			if(getpossesscode.get(i)!=null)
		    if(getpossesscode.get(i).getUsestate()!=null)
			 { 
		    	String usestate=getpossesscode.get(i).getUsestate();	 
		     if(usestate.equals("闲置"))
		     {
			  // jsonObject.put("id",getpossesscode.get(i).getId());
			     jsonObject.put("text", getpossesscode.get(i).getCode());
			   jsonArray.add(j,jsonObject);
			   j++;
			 }
		     //不写j不对，显示时会有null的选项；
//		     else
//		     {
//		    	 jsonObject.put("id",getpossesscode.get(i).getId());
//				 jsonObject.put("text",state);
//				 jsonArray.add(i,jsonObject); 
//		     }
		     }
		 }
		 return jsonArray;
	 }
	 //获取可领取的人员名单
	 public JSONArray getassetpossesspeople(String possessdepartment){
		 TDepartmentExample TdepartmentExample=new TDepartmentExample();
		 List<TDepartment> possessdepartments=TeDpartmentMapper.selectByExample(TdepartmentExample);
		 int counts=possessdepartments.size();
		 String depcode=null;
		 int m=0;
		 for(m=0;m<counts;m++)
		 {
			 String department=possessdepartments.get(m).getDepname();
			 if(department.equals(possessdepartment))
			 {
				depcode=possessdepartments.get(m).getDepcode();
				 break;
			 }
		 }
		 TUserExample TuserExample=new TUserExample();
		 List<TUser> possesspeoples=TUsermapper.selectByExample(TuserExample);
		 JSONObject jsonObject = new JSONObject();
		 JSONArray jsonArray=new JSONArray();
		 int count=possesspeoples.size();
		 int j=0;
		 for(int i=0;i<count;i++)
		 {
			 String departmentcode=possesspeoples.get(i).getUserdep();
			 if(departmentcode.equals(depcode))
			 {
			    jsonObject.put("text", possesspeoples.get(i).getUsername());
			    jsonArray.add(j,jsonObject); 
			    j++; 
		     }
		 }
		 return jsonArray;
	 }
	 //获取可领取资产的部门
	 public JSONArray getassetpossessdepartment(){
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
	 
	 public int getpossessnum()
	 {
		 TPossessExample possesslist=new TPossessExample();
		 List<TPossess> possesslistnum=TPossessMapper.selectByExample(possesslist);
		 int a=possesslistnum.size();
		 return a;
		 
	 }
	 
//	 public void updateasset(Asset asset)
//	 {
//		 Assetmapper.updateByPrimaryKey(asset);
//	 }
//	 
//	 public Asset selectasset(int id)
//	 {
//		 Asset asset;
//		 asset=Assetmapper.selectByPrimaryKey(id);
//		 return asset;
//	 }
}
