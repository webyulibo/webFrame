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
import cn.bronze.daos.MyBorrowMapper;
import cn.bronze.daos.MyDepartmentMapper;
import cn.bronze.daos.TAssetborrowMapper;
import cn.bronze.daos.TDepartmentMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.AssetborrowExampleCustom;
import cn.bronze.entities.TAssetborrow;
import cn.bronze.entities.TAssetborrowExample;
import cn.bronze.entities.TDepartment;
import cn.bronze.entities.TDepartmentExample;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminAssetBorrowService {
	@Autowired
	public TAssetborrowMapper assetborrowMapper;
	@Autowired
	public AssetMapper assetMapper;
	@Autowired
	public MyBorrowMapper myBorrowMapper;
	@Autowired
	public TDepartmentMapper departmentMapper;
	@Autowired
	public MyDepartmentMapper myDepartmentMapper;
	@Autowired
	public TUserMapper userMapper;
	/**
	 * 于立波
	 * page  用于分页
	 * 查询借用记录详情
	 */
//   @Test
//   public void getAssetBorrowList(){
//	   List<Assetborrow> assetBorrowList=new ArrayList<>();
//	   AssetborrowExampleCustom assetborrowExample=new AssetborrowExampleCustom();
//	   AssetborrowExample.Criteria criteria=assetborrowExample.createCriteria();
//	   assetBorrowList=assetborrowMapper.selectByExample(assetborrowExample);
//	   System.out.println(assetBorrowList.size());
//   }
	@Log(descrp="执行查询借用记录详情操作",type="系统管理权限，资产管理权限，查询权限")
   public List<TAssetborrow> getAssetBorrowList(
		   PageParameter page
		   ){
	   List<TAssetborrow> assetBorrowList=new ArrayList<>();
	   AssetborrowExampleCustom assetborrowExample=new AssetborrowExampleCustom();
	   assetborrowExample.setPage(page);
	   TAssetborrowExample.Criteria criteria=assetborrowExample.createCriteria();
	   assetBorrowList=assetborrowMapper.selectByExample(assetborrowExample);
	   return assetBorrowList;
   }
   /**
    * 于立波
    * assetcode  资产编号
    * 检查资产的状态
    */
   public String  checkAssetState(
		   String assetcode
		   ){
	  String result=myBorrowMapper.checkAssetState(assetcode);
      return result;
   }
   /**
    * 于立波
    * assetcode  资产编号
    * 改变资产的状态
    */
   public void changeAssetState(
		   String assetcode
		   ){
	 myBorrowMapper.changeAssetState(assetcode);
   }
   /**
    * 于立波
    * assetBorrow  借用记录
    * 保存借用记录
    */
  /* @Test
   public void saveBorrowRecord(){
	   TAssetborrow assetBorrow = new TAssetborrow();
	   assetBorrow.setApprovepeople("于立波");
	   assetborrowMapper.insert(assetBorrow);
	   System.out.println(assetBorrow.getApprovepeople());
   }*/
   @Log(descrp="执行保存借用记录操作",type="系统管理权限，资产管理权限")
   public void saveBorrowRecord(
		   TAssetborrow assetBorrow
		   ){
	   assetborrowMapper.insert(assetBorrow);
   }
	/**
	 * 于立波
	 * assetcode 实时查询所有assetcode
	 */
   public JSONArray  getAllAssetcodeJson(
			){
		List<String> assecodetList1=myBorrowMapper.getAllAssetcode();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<assecodetList1.size();i++){
			jsonObject.put("text", assecodetList1.get(i));
			jsonArray.add(i, jsonObject);
		}
			return jsonArray;
}
	/**
	 * 于立波
	 * assetname 实时查询所有assetname
	 */
  public JSONArray  getAllAssetnameJson(
			){
		List<String> assenametList1=myBorrowMapper.getAllAssetname();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<assenametList1.size();i++){
			jsonObject.put("text", assenametList1.get(i));
			jsonArray.add(i, jsonObject);
		}
			return jsonArray;
}
  
  
  
  
	/**
	 * 于立波
	 * assetcode 实时查询assetcode
	 */
	public List<String>  getAssetcode(
			String assetcode
			){
		List<String> assetcodelist=myBorrowMapper.getAssetcode(assetcode);
	    return  assetcodelist;
}
	/**
	 * 于立波
	 * assetcode  资产编号
	 * 根据资产编号查询对应的资产名称
	 */
	public String  getAssetname(
			String assetcode
			){
		String assetname=myBorrowMapper.getAssetname(assetcode);
	    return  assetname;
}
	public List<String>  getAssetcode1(
			String assetname
			){
		List<String> assetcode=myBorrowMapper.getAssetcode1(assetname);
	    return  assetcode;
}
	public String  getAssetcode2(
			String assetcode
			){
		String assetcode2=myBorrowMapper.getAssetcode2(assetcode);
	    return  assetcode2;
}
	public List<String>  getAssetname3(
			String assetname
			){
		List<String> assetname3=myBorrowMapper.getAssetname3(assetname);
	    return  assetname3;
}
	
	
	
	
	
	
	/***
	 * 于立波
	 * 返回assetcode的jsoon串
	 * @param 
	 * @return 
	 */
	public JSONArray getAssetcodeJson(){
	AssetExample assetExample=new AssetExample();
	AssetExample.Criteria aecCriteria=assetExample.createCriteria();
	aecCriteria.andUsestateEqualTo("闲置");
	List<Asset> assetList=assetMapper.selectByExample(assetExample);
	JSONObject jsonObject = new JSONObject();
	JSONArray jsonArray=new JSONArray();
	for(int i=0;i<assetList.size();i++){
		jsonObject.put("id",assetList.get(i).getId());
		jsonObject.put("text", assetList.get(i).getCode());
		jsonArray.add(i, jsonObject);
	}
		return jsonArray;
	}

/***
 * 于立波
 * 返回assetcode的jsoon串
 * @param 
 * @return 
 */
	public JSONArray getAssetnameJson1(){
		AssetExample assetExample=new AssetExample();
		AssetExample.Criteria aecCriteria=assetExample.createCriteria();
		aecCriteria.andUsestateEqualTo("闲置");
		List<Asset> assetList=assetMapper.selectByExample(assetExample);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<assetList.size();i++){
			jsonObject.put("id",assetList.get(i).getId());
			jsonObject.put("text", assetList.get(i).getName());
			jsonArray.add(i, jsonObject);
		}
			return jsonArray;
		}
	public JSONArray getBorrowdepJson() {
		// TODO Auto-generated method stub
		TDepartmentExample assetExample=new TDepartmentExample();
		List<TDepartment> departmentList=departmentMapper.selectByExample(assetExample);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<departmentList.size();i++){
			jsonObject.put("id",departmentList.get(i).getId());
			jsonObject.put("text", departmentList.get(i).getDepname());
			jsonArray.add(i, jsonObject);
		}
			return jsonArray;
	}
	public JSONArray getUsernameJson(String departmentCode) {
		// TODO Auto-generated method stub	
		TUserExample userExample=new TUserExample();
		TUserExample.Criteria userCriteria=userExample.createCriteria();
		userCriteria.andUserdepEqualTo(departmentCode);
		List<TUser> userList=userMapper.selectByExample(userExample);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<userList.size();i++){
			jsonObject.put("id",userList.get(i).getId());
			jsonObject.put("text", userList.get(i).getUsername());
			jsonArray.add(i, jsonObject);
		}
			return jsonArray;
	}
	public JSONArray getAssetcode2Json(String assetname) {
		// TODO Auto-generated method stub	
		List<String> assetcode=myBorrowMapper.getAssetcode1(assetname);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<assetcode.size();i++){
			jsonObject.put("text", assetcode.get(i));
			jsonArray.add(i, jsonObject);
		}
			return jsonArray;
	}
	/**
	 * 于立波
	 * 查询部门代码
	 * @param borrowdep
	 * @return
	 */
	public String getdepartmentCode(String borrowdep) {
		// TODO Auto-generated method stub
		String departmentCode=myDepartmentMapper.getDepartmentCode(borrowdep);
		return departmentCode;
	}
	public JSONArray getBorrowpeopleJson() {
		// TODO Auto-generated method stub
		TUserExample  userExample=new TUserExample();
		List<TUser> userList=userMapper.selectByExample(userExample);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<userList.size();i++){
			jsonObject.put("id",userList.get(i).getId());
			jsonObject.put("text", userList.get(i).getUsername());
			jsonArray.add(i, jsonObject);
		}
			return jsonArray;
	}
	//根据借出人查出借出部门
	public String getBorrowdep1(String borrowpeople) {
		// TODO Auto-generated method stub
		String borrowdep=myDepartmentMapper.getBorrowdep1(borrowpeople);
		return borrowdep;
	}
	public String getBorrowdepName1(String borrowdep) {
		// TODO Auto-generated method stub
		String borrowdepname=myDepartmentMapper.getBorrowdepName1(borrowdep);
		return borrowdepname;
	}
	public TAssetborrow getcheck1(String borrownum) {
		// TODO Auto-generated method stub
//		TAssetborrowExample assetborrowExample=new TAssetborrowExample();
//		TAssetborrowExample.Criteria assCriteria=assetborrowExample.createCriteria();
//		assCriteria.andBorrownumEqualTo(borrownum);
//		List<TAssetborrow> assetborrow=assetborrowMapper.selectByExample(assetborrowExample);
//		return assetborrow.get(0) ;
	    TAssetborrow assetborrow=myBorrowMapper.getcheck1(borrownum);
	    return assetborrow;
	}
	
	
}
