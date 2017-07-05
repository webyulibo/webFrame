package cn.bronze.services;

import java.text.SimpleDateFormat;
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

import cn.bronze.daos.AssetMapper;
import cn.bronze.daos.MyBorrowMapper;
import cn.bronze.daos.TMaintainMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.Assetmaintain;
import cn.bronze.entities.TMaintain;
import cn.bronze.entities.TMaintainExampleCustom;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.util.page.PageParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service

public class AdminAssetMaintainService {
   
	@Autowired
	public TMaintainMapper TmaintainMapper;
	@Autowired
	public MyBorrowMapper myBorrowMapper;
	@Autowired
	public AssetMapper Assetmapper;
	@Autowired
	public TUserMapper Tusermapper;
	
	/***
	 * 刘晓峰
	 * 插入维修记录 
	 * @param TMaintain
	 * @return 
	 */
	public int insertMaintain(TMaintain Tmaintain)
	{
		int a=TmaintainMapper.insert(Tmaintain);
		return a;
	}
	
	/***
	 * 刘晓峰
	 * 获得维修记录表 
	 * @param PageParameter
	 * @return List<TMaintain>
	 */
	
	public List<Assetmaintain> getTmaintainList(
   		 PageParameter page
   		 )
   {
	List<TMaintain> TmaintainList=new ArrayList<>();
   	TMaintainExampleCustom example=new TMaintainExampleCustom();
   	example.setPage(page);
   	TmaintainList=TmaintainMapper.selectByExample(example);
   	int a=TmaintainList.size();
   	List<Assetmaintain> Assetmaintainlist=new ArrayList<>();
   	for(int i=0;i<a;i++)
   	{ 
   		Assetmaintain assetmaintain=new Assetmaintain();
   	    AssetExample assetExample=new AssetExample();
	    AssetExample.Criteria criteria=assetExample.createCriteria();
   		String code=TmaintainList.get(i).getCode();
   		String dealresult=TmaintainList.get(i).getDealresult();
   		String faultdescription=TmaintainList.get(i).getFaultdescription();
   		String guy=TmaintainList.get(i).getGuy();
   		Date sendtime=TmaintainList.get(i).getSenddate();
   		criteria.andCodeEqualTo(code);
   		List<Asset> assetListbycode=Assetmapper.selectByExample(assetExample);
   		String model=assetListbycode.get(0).getModel();
   		if(model.equals(""))
   		{
   			model="无记录";
   		}
   		int id=TmaintainList.get(i).getId();
   		Date purchasedata=assetListbycode.get(0).getPurchasetime();
   		String ghostyears=assetListbycode.get(0).getGhostyear();
   		if(ghostyears.equals(""))
   		{
   			ghostyears="无记录";
   		}
   		String name=assetListbycode.get(0).getName();
   		assetmaintain.setId(id);
   		assetmaintain.setCode(code);
   		assetmaintain.setDealresult(dealresult);
   		assetmaintain.setFaultdescription(faultdescription);
   		assetmaintain.setGuy(guy);
   		assetmaintain.setSenddate(sendtime);
   		assetmaintain.setName(name);
   		assetmaintain.setGhostyears(ghostyears);
   		assetmaintain.setModel(model);
   		assetmaintain.setPurchasedata(purchasedata);
   		Assetmaintainlist.add(assetmaintain);
   	}
	List<Assetmaintain> maintainlist=new ArrayList<>();
	int n=Assetmaintainlist.size();
    for(int i=n-1;i>=0;i--)
    {
    	maintainlist.add(Assetmaintainlist.get(i));
    }
		return maintainlist;
   }
	/***
	 * 刘晓峰
	 * 获得资产编号
	 * @param 
	 * @return JSONArray
	 */
	 public JSONArray getassetcode(){
		 AssetExample AssetExample=new AssetExample();
		 List<Asset> getpossesscode=Assetmapper.selectByExample(AssetExample);
		 JSONObject jsonObject = new JSONObject();
		 JSONArray jsonArray=new JSONArray();
		 int count=getpossesscode.size();
		 int j=0;
		 for(int i=0;i<count;i++)
		 {  
			if(getpossesscode.get(i)!=null)
			{
				if(getpossesscode.get(i).getCode()!=null)
				{
					if(getpossesscode.get(i).getUsestate().equals("损坏不能用"))
					{
			          jsonObject.put("text", getpossesscode.get(i).getCode());
			          jsonArray.add(j,jsonObject);
			          j++;
			        }
				}
			 }
		 }
		 return jsonArray;
	 }
	 /***
		 * 刘晓峰
		 * 获得资产名称
		 * @param 
		 * @return JSONArray
		 */
	 public JSONArray getassetname(){
		 AssetExample AssetExample=new AssetExample();
		 List<Asset> getpossesscode=Assetmapper.selectByExample(AssetExample);
		 JSONObject jsonObject = new JSONObject();
		 JSONArray jsonArray=new JSONArray();
		 int count=getpossesscode.size();
		 int j=0;
		 for(int i=0;i<count;i++)
		 {  
			if(getpossesscode.get(i)!=null)
			{
				if(getpossesscode.get(i).getName()!=null)
				{
					if(getpossesscode.get(i).getUsestate().equals("损坏不能用"))
					{
				     jsonObject.put("status", "ok");
			         jsonObject.put("text", getpossesscode.get(i).getName());
			         jsonArray.add(j,jsonObject);
			         j++;
					}
				}
			 }
		 }
		 return jsonArray;
	 }
	 /***
		 * 刘晓峰
		 * 根据资产名称获取资产编号
		 * @param name/资产名称
		 * @return JSONArray
		 */
	 public List<String>  getAssetcodebyname(
				String assetname
				){
			List<String> assetcode=myBorrowMapper.getAssetcode1(assetname);
		    return  assetcode;
	}
	 /***
		 * 刘晓峰
		 * 根据资产编号获取资产名称
		 * @param code/资产编号
		 * @return JSONArray
		 */
	 public String  getAssetnamebycode(
				String assetcode
				){
			String assetname=myBorrowMapper.getAssetname(assetcode);
		    return  assetname;
	}
		 /***
			 * 刘晓峰
			 * 根据资产编号获取资产名称2
			 * @param code/资产编号
			 * @return JSONArray
			 */
		 
		 public JSONArray getmaintainAssetName(String code){
			 JSONObject jsonObject = new JSONObject();
			 JSONArray jsonArray=new JSONArray();
			 AssetExample assetExample=new AssetExample();
			 AssetExample.Criteria criteria=assetExample.createCriteria();
			 criteria.andCodeEqualTo(code);
			 List<Asset> assetListbycode=Assetmapper.selectByExample(assetExample);
			 int count=assetListbycode.size();
			 int j=0;
			 if(count==0)
			 {
				 jsonObject.put("text","资产不存在");
				 jsonArray.add(j,jsonObject); 
			 }
			 else
			 {
			    for(int i=0;i<count;i++)
			     {
			    	jsonObject.put("text",assetListbycode.get(i).getName());
				    jsonArray.add(j,jsonObject); 
				   // j++;同下
			     }
			 } 
			 return jsonArray;
			 
		 }
		 
		 /***
			 * 刘晓峰
			 * 根据资产编号获取资产购置日期
			 * @param code/资产编号
			 * @return JSONArray
			 */
		 //根据资产编号获取资产购置日期    为了精准可以同时传入name  
		//这里若不能成功，则利用code获取唯一id，根据id获取唯一购置日期，但也存在保存卡进两个相同的code造成两个相同的id的现象
		 public JSONArray getmaintainAssetDate(String code){
			 JSONObject jsonObject = new JSONObject();
			 JSONArray jsonArray=new JSONArray();
			 AssetExample assetExample=new AssetExample();
			 AssetExample.Criteria criteria=assetExample.createCriteria();
			 criteria.andCodeEqualTo(code);
			 List<Asset> assetListbycode=Assetmapper.selectByExample(assetExample);
			 int count=assetListbycode.size();
			 int j=0;
			 if(count==1)
			 {
				 jsonObject.put("status", "ok");
			       if(assetListbycode.get(0).getPurchasetime().equals(null))
			       {
			        jsonObject.put("text","资产的购买时间没有记录");
			        jsonArray.add(j,jsonObject); 
			       }
			      else
			     { 
			    	  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义格式，不显示毫秒 
			          String str = df.format(assetListbycode.get(0).getPurchasetime()); 
				      jsonObject.put("text",str);
			          jsonArray.add(j,jsonObject); 
				   
			     } 
			   }
			 else
			 {
				 jsonObject.put("status", "no");
				 jsonObject.put("msg","数据库存在问题，含有两个或多个相同的该资产编号");
			     jsonArray.add(j,jsonObject); 
			 }
				 return jsonArray;
		 }
		 /***
			 * 刘晓峰
			 * 根据资产编号获取资产型号
			 * @param code/资产编号
			 * @return JSONArray
			 */
		 //根据资产编号获取资产型号 
		 public JSONArray getmaintainAssetModel(String code){
			 JSONObject jsonObject = new JSONObject();
			 JSONArray jsonArray=new JSONArray();
			 AssetExample assetExample=new AssetExample();
			 AssetExample.Criteria criteria=assetExample.createCriteria();
			 criteria.andCodeEqualTo(code);
			 List<Asset> assetListbycode=Assetmapper.selectByExample(assetExample);
			 int count=assetListbycode.size();
			 int j=0;
			 if(count==1)
			 {
			   jsonObject.put("status", "ok");
			   if(assetListbycode.get(0).getModel().equals(null)||assetListbycode.get(0).getModel().equals(""))
			   {
			     jsonObject.put("text","型号没有记录");
			     jsonArray.add(j,jsonObject); 
			   }
			   else
			   {
				   jsonObject.put("text",assetListbycode.get(0).getModel());
				   jsonArray.add(j,jsonObject); 
			   }
			  }
			 else
			 {
				 jsonObject.put("status", "no");
				 jsonObject.put("msg","数据库存在问题，含有两个或多个相同的该资产编号");
			     jsonArray.add(j,jsonObject); 
			 }
			 return jsonArray;
		 }
		 
		 /***
			 * 刘晓峰
			 * 根据资产编号获取资产报废年限
			 * @param code/资产编号
			 * @return JSONArray
			 */
		 //根据code获取报废年限
		 public JSONArray getmaintainAssetGhostyear(String code){
			 JSONObject jsonObject = new JSONObject();
			 JSONArray jsonArray=new JSONArray();
			 AssetExample assetExample=new AssetExample();
			 AssetExample.Criteria criteria=assetExample.createCriteria();
			 criteria.andCodeEqualTo(code);
			 List<Asset> assetListbycode=Assetmapper.selectByExample(assetExample);
			 int count=assetListbycode.size();
			 int j=0;
			 if(count==1)
			 {
			   jsonObject.put("status", "ok");
			   if(assetListbycode.get(0).getGhostyear().equals(null)||assetListbycode.get(0).getGhostyear().equals(""))
			   {
			     jsonObject.put("text","资产的报废年限没有记录");
			     jsonArray.add(j,jsonObject); 
			   }
			   else
			   {
				   jsonObject.put("text",assetListbycode.get(0).getGhostyear());
				   jsonArray.add(j,jsonObject); 
			   }
			  }
			 else
			 {
				 jsonObject.put("status", "no");
				 jsonObject.put("msg","数据库存在问题，含有两个或多个相同的该资产编号");
			     jsonArray.add(j,jsonObject); 
			 }
			 return jsonArray;
		 }
		 
		 /***
			 * 刘晓峰
			 * 更新资产状态信息
			 * @param code/资产编号
			 * @return 
			 */
		 public  void updateasset(String code)
		 {
			 AssetExample assetexample=new AssetExample();
			 AssetExample.Criteria criteria=assetexample.createCriteria();
			 criteria.andCodeEqualTo(code);
			 List<Asset> assetlist=Assetmapper.selectByExample(assetexample);
			 int count=assetlist.size();
			 //因为在保存成功后才会进行更新操作，所以资产编号必然在资产库里存在
			 //正常情况下count=1;
			 for(int i=0;i<count;i++)
			 {
				 assetlist.get(i).setUsestate("闲置");
				 Assetmapper.updateByPrimaryKey(assetlist.get(i));
			 }
		 }
		 /***
			 * 刘晓峰
			 * 获得经手人列表
			 * @param 
			 * @return JSONArray
			 */
		 public JSONArray getguy(){
			 TUserExample TuserExample=new TUserExample();
			 List<TUser> peoples=Tusermapper.selectByExample(TuserExample);
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
		 
		 /***
			 * 刘晓峰
			 * 保存按钮之后验证资产编号和资产名称是否合法
			 * @param  code
			 * @param  name
			 * @return boolean
			 */
		 public boolean IscodeandnameIegal(String code,String name)
		 {
			 AssetExample assetexample=new AssetExample();
			 AssetExample.Criteria criteria=assetexample.createCriteria();
			 criteria.andCodeEqualTo(code);
			 criteria.andNameEqualTo(name);
			 List<Asset> assetlist=Assetmapper.selectByExample(assetexample);
			 if(assetlist.size()==0)
			 {
				 return false;
			 }
			 else
			 {
			   return true;
			 }
		 }
		 public boolean IscodeIegal(String code)
		 {
			 AssetExample assetexample=new AssetExample();
			 AssetExample.Criteria criteria=assetexample.createCriteria();
			 criteria.andCodeEqualTo(code);
			 criteria.andUsestateEqualTo("损坏不能用");
			 List<Asset> assetlist=Assetmapper.selectByExample(assetexample);
			 if(assetlist.size()==1)
			 {
				 return true;
			 }
			 else
			 {
			   return false;
			 }
		 }
		 public boolean IsnameIegal(String name)
		 {
			 AssetExample assetexample=new AssetExample();
			 AssetExample.Criteria criteria=assetexample.createCriteria();
			 criteria.andCodeEqualTo(name);
			 List<Asset> assetlist=Assetmapper.selectByExample(assetexample);
			 if(assetlist.size()!=0)
			 {
				 return true;
			 }
			 else
			 {
			   return false;
			 }
		 }
		 
			public JSONArray getAssetcode2Json(String assetname) {
				// TODO Auto-generated method stub	
				List<String> assetcode=myBorrowMapper.getAssetcode11(assetname);
				JSONObject jsonObject = new JSONObject();
				JSONArray jsonArray=new JSONArray();
				for(int i=0;i<assetcode.size();i++){
					jsonObject.put("text", assetcode.get(i));
					jsonArray.add(i, jsonObject);
				}
					return jsonArray;
			}
		 /***
			 * 刘晓峰
			 * 根据资产编号获取处理结果
			 * @param code/资产编号
			 * @return JSONArray
			 */
		 
 }
	 
	 
