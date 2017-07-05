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

import cn.bronze.daos.MyBorrowMapper;
import cn.bronze.daos.MyReturnMapper;
import cn.bronze.daos.TAssetborrowMapper;
import cn.bronze.daos.TBackMapper;
import cn.bronze.daos.TUserMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.AssetborrowExample;
import cn.bronze.entities.AssetborrowExampleCustom;
import cn.bronze.entities.BackExample;
import cn.bronze.entities.BackExampleCustom;
import cn.bronze.entities.TAssetborrow;
import cn.bronze.entities.TAssetborrowExample;
import cn.bronze.entities.TBack;
import cn.bronze.entities.TBackExample;
import cn.bronze.entities.TUser;
import cn.bronze.entities.TUserExample;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminAssetReturnService {
	@Autowired
	public TBackMapper backMapper;
	@Autowired
	public TUserMapper userMapper;
	@Autowired
	public MyReturnMapper myReturnMapper;
	@Autowired
	public MyBorrowMapper myBorrowMapper;
	@Autowired
	public TAssetborrowMapper assetBorrowMapper;
	/**
	 * 于立波
	 * page  用于分页
	 * 查询归还记录详情
	 */
	@Log(descrp="执行查询归还记录详情操作",type="系统管理权限，资产管理权限，查询权限")
	   public List<TBack> getAssetReturnList(
			   PageParameter page
			   ){
		   List<TBack> assetReturnList=new ArrayList<>();
		  BackExampleCustom assetreturnExample=new BackExampleCustom();
		   assetreturnExample.setPage(page);
		   TBackExample.Criteria criteria=assetreturnExample.createCriteria();
		   assetReturnList=backMapper.selectByExample(assetreturnExample);
		   return assetReturnList;
	   }
	   /**
	    * 于立波
	    * assetcode  资产编号
	    * 改变资产的状态
	    */
	   public void changeAssetState(
			   String assetcode
			   ){
		   myReturnMapper.changeAssetState(assetcode);
	   }
	   /**
	    * 于立波
	    * assetReturn  归还记录
	    * 保存归还记录
	    */
	   @Log(descrp="执行保存归还记录操作",type="系统管理权限，资产管理权限")
	   public void saveReturnRecord(
			   TBack assetReturn
			   ){
		   backMapper.insert(assetReturn);
	   }
	   /**
		 * 于立波
        * borrownum  借出编号
		 * 根据借出编号查询对应的资产信息
		 */
		public String  getAssetname(
				String borrownum
				){
			String assetname=myReturnMapper.getAssetname(borrownum);
		    return  assetname;
	}
		public String  getAssetcode(
				String borrownum
				){
			String assetcode=myReturnMapper.getAssetcode(borrownum);
		    return  assetcode;
	}
		public String  getBorrowpeople(
				String borrownum
				){
			String borowpeople=myReturnMapper.getBorrowpeople(borrownum);
		    return  borowpeople;
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
		/***
		 * 于立波
		 * 返回borrownum的jsoon串
		 * @param 
		 * @return 
		 */
		public JSONArray getBorrownumJson() {
//		TAssetborrowExample assetBorrowExample=new TAssetborrowExample();
//		List<TAssetborrow> asseBorrowtList=assetBorrowMapper.selectByExample(assetBorrowExample);
//		//只查出状态为在用的
//		List<TAssetborrow>  asseBorrowtList2=new ArrayList<>();
//		for(int i=0;i<asseBorrowtList.size();i++){
//			if(myBorrowMapper.checkAssetState(asseBorrowtList.get(i).getAssetcode()).equals("在用")){
//				asseBorrowtList2.add(asseBorrowtList.get(i));
//			}
//		}
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray=new JSONArray();
//		for(int i=0;i<asseBorrowtList2.size();i++){
//			jsonObject.put("id",asseBorrowtList2.get(i).getId());
//			jsonObject.put("text", asseBorrowtList2.get(i).getBorrownum());
//			jsonArray.add(i, jsonObject);
//		}
			List<String>  asseBorrowtList2=myBorrowMapper.getBorrownumJson1();
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<asseBorrowtList2.size();i++){
				jsonObject.put("text", asseBorrowtList2.get(i));
				jsonArray.add(i, jsonObject);
			}
			return jsonArray;
		}
		//删除对应的借用记录
		public void deleteReturnRecord(String borrownum) {
			// TODO Auto-generated method stub
			myBorrowMapper.deleteReturnRecord(borrownum);
		}

/**
 * 查询资产名称		
 * @return
 */
		public JSONArray getAssetnamejsonre() {
			TAssetborrowExample assetBorrowExample=new TAssetborrowExample();
			List<TAssetborrow> asseBorrowtList=assetBorrowMapper.selectByExample(assetBorrowExample);
			//只查出状态为在用的
			List<String>  assetList2=new ArrayList<>();
			for(int i=0;i<asseBorrowtList.size();i++){
					assetList2.add(asseBorrowtList.get(i).getAssetname());
			}
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<assetList2.size();i++){
				jsonObject.put("text", assetList2.get(i));
				jsonArray.add(i, jsonObject);
			}
				return jsonArray;
			}

		public JSONArray getAssetcodejsonre() {
			TAssetborrowExample assetBorrowExample=new TAssetborrowExample();
			List<TAssetborrow> asseBorrowtList=assetBorrowMapper.selectByExample(assetBorrowExample);
			//只查出状态为在用的
			List<String>  assetList2=new ArrayList<>();
			for(int i=0;i<asseBorrowtList.size();i++){
					assetList2.add(asseBorrowtList.get(i).getAssetcode());
			}
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<assetList2.size();i++){
				jsonObject.put("text", assetList2.get(i));
				jsonArray.add(i, jsonObject);
			}
				return jsonArray;
			}
	
		
		public String  getBorrownum1(
				String assetcode
				){
			String borrownum=myReturnMapper.getBorrownum1(assetcode);
		    return  borrownum;
	}
		public String  getAssetname1(
				String assetcode
				){
			String assetname=myReturnMapper.getAssetname1(assetcode);
		    return  assetname;
	}
		public String  getBorrowpeople1(
				String assetcode
				){
			String borowpeople=myReturnMapper.getBorrowpeople1(assetcode);
		    return  borowpeople;
	}

		public List<String>  getBorrownum2(
				String assetname
				){
			List<String> borrownum=myReturnMapper.getBorrownum2(assetname);
		    return  borrownum;
	}
		public List<String>  getAssetcode2(
				String assetname
				){
			List<String> assetcode=myReturnMapper.getAssetcode2(assetname);
		    return  assetcode;
	}
		public List<String>  getBorrowpeople2(
				String assetname
				){
			List<String> borowpeople=myReturnMapper.getBorrowpeople2(assetname);
		    return  borowpeople;
	}
		public JSONArray getAssetcode2Json(String assetname) {
			// TODO Auto-generated method stub	
			List<String> assetcode=myReturnMapper.getAssetcode2(assetname);
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<assetcode.size();i++){
				jsonObject.put("text", assetcode.get(i));
				jsonArray.add(i, jsonObject);
			}
				return jsonArray;
		}	
		public JSONArray getBorrownum2Json(String assetname) {
			// TODO Auto-generated method stub	
			List<String> borrownum=myReturnMapper.getBorrownum2(assetname);
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<borrownum.size();i++){
				jsonObject.put("text", borrownum.get(i));
				jsonArray.add(i, jsonObject);
			}
				return jsonArray;
		}	
		public JSONArray getBackpeople2Json(String assetname) {
			// TODO Auto-generated method stub	
			List<String> borowpeople=myReturnMapper.getBorrowpeople2(assetname);
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<borowpeople.size();i++){
				jsonObject.put("text", borowpeople.get(i));
				jsonArray.add(i, jsonObject);
			}
				return jsonArray;
		}	
}
