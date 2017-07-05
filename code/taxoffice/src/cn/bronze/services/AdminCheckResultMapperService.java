package cn.bronze.services;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetMapper;
import cn.bronze.daos.CheckResultDetailMapper;
import cn.bronze.daos.CheckResultMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.AssetExampleCustom;
import cn.bronze.entities.CheckResult;
import cn.bronze.entities.CheckResultDetail;
import cn.bronze.entities.CheckResultDetailExample;
import cn.bronze.entities.CheckResultDetailExampleCustom;
import cn.bronze.entities.CheckResultExample;
import cn.bronze.entities.CheckResultExampleCustom;
import cn.bronze.entities.CustomAssetCheckResultWithDetail;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminCheckResultMapperService extends GenernicServiceImpl<CheckResult, CheckResultExample> {

	@Autowired
	private CheckResultMapper checkResultMapper;
	
	@Autowired
	private CheckResultDetailMapper checkResultDetailMapper;
	
	@Autowired
	private AssetMapper assetMapper;
	/**
	 * 查询盘点记录结果列表
	 * @author 于立波
	 * @param checktimestart 起始盘点日期
	 * @param checktimeend 结束盘点日期
	 * @param checkpeople 盘点人
	 * @param resultnum 盘点编号
	 * @param page   页数
	 * @return
	 */
	@Log(descrp="执行查询盘点记录结果操作",type="系统管理权限，资产管理权限，查询权限")
	public List<CheckResult> getCheckResultsBySelectTermsWithPage(	
			Date checktimestart
			,Date checktimeend
			,String checkpeople
			,String resultnum
			,PageParameter page
			){
		List<CheckResult> checkResultList  = new ArrayList<>();		
     	CheckResultExampleCustom   checkResultExample=new  CheckResultExampleCustom();
     	CheckResultExample.Criteria criteria=checkResultExample.createCriteria();
     	checkResultExample.setPage(page);
 		//CheckResultExample.Criteria criteria =checkResultExample.createCriteria();
 		//List<CheckResultExample.Criteria> list = new ArrayList<CheckResultExample.Criteria>();
 		//checkResultExample.setPage(page);
     	if(checktimestart==null&&checktimeend==null&&checkpeople.isEmpty()&&resultnum.isEmpty()){
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart==null&&checktimeend==null&&checkpeople.isEmpty()&&!resultnum.isEmpty()){
     		criteria.andResultnumEqualTo(resultnum);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart==null&&checktimeend==null&&!checkpeople.isEmpty()&&resultnum.isEmpty()){
     		criteria.andCheckpeopleEqualTo(checkpeople);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart!=null&&checktimeend!=null&&checkpeople.isEmpty()&&resultnum.isEmpty()){
     		criteria.andChecktimeBetween(checktimestart, checktimeend);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart!=null&&checktimeend!=null&&!checkpeople.isEmpty()&&resultnum.isEmpty()){
     		criteria.andChecktimeBetween(checktimestart, checktimeend).andCheckpeopleEqualTo(checkpeople);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart!=null&&checktimeend!=null&&checkpeople.isEmpty()&&!resultnum.isEmpty()){
     		criteria.andChecktimeBetween(checktimestart, checktimeend).andResultnumEqualTo(resultnum);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart==null&&checktimeend==null&&!checkpeople.isEmpty()&&!resultnum.isEmpty()){
     		criteria.andCheckpeopleEqualTo(checkpeople).andResultnumEqualTo(resultnum);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart!=null&&checktimeend!=null&&!checkpeople.isEmpty()&&!resultnum.isEmpty()){
     		criteria.andCheckpeopleEqualTo(checkpeople).andResultnumEqualTo(resultnum).andChecktimeBetween(checktimestart, checktimeend);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
		return checkResultList;
 	
	}
	/**
	 * 查询盘点记录结果列表(用于导出使用)
	 * @author 于立波
	 * @param checktimestart 起始盘点日期
	 * @param checktimeend 结束盘点日期
	 * @param checkpeople 盘点人
	 * @param resultnum 盘点编号
	 * @return
	 */
	public List<CheckResult> getCheckResultsBySelectTerms(
			Date checktimestart
			,Date checktimeend
			,String checkpeople
			,String resultnum
			){	
		List<CheckResult> checkResultList  = new ArrayList<>();		
     	CheckResultExampleCustom   checkResultExample=new  CheckResultExampleCustom();
     	CheckResultExample.Criteria criteria=checkResultExample.createCriteria();
 		//CheckResultExample.Criteria criteria =checkResultExample.createCriteria();
 		//List<CheckResultExample.Criteria> list = new ArrayList<CheckResultExample.Criteria>();
 		//checkResultExample.setPage(page);
     	if(checktimestart==null&&checktimeend==null&&checkpeople.isEmpty()&&resultnum.isEmpty()){
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart==null&&checktimeend==null&&checkpeople.isEmpty()&&!resultnum.isEmpty()){
     		criteria.andResultnumEqualTo(resultnum);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart==null&&checktimeend==null&&!checkpeople.isEmpty()&&resultnum.isEmpty()){
     		criteria.andCheckpeopleEqualTo(checkpeople);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart!=null&&checktimeend!=null&&checkpeople.isEmpty()&&resultnum.isEmpty()){
     		criteria.andChecktimeBetween(checktimestart, checktimeend);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart!=null&&checktimeend!=null&&!checkpeople.isEmpty()&&resultnum.isEmpty()){
     		criteria.andChecktimeBetween(checktimestart, checktimeend).andCheckpeopleEqualTo(checkpeople);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart!=null&&checktimeend!=null&&checkpeople.isEmpty()&&!resultnum.isEmpty()){
     		criteria.andChecktimeBetween(checktimestart, checktimeend).andResultnumEqualTo(resultnum);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
     	if(checktimestart==null&&checktimeend==null&&!checkpeople.isEmpty()&&!resultnum.isEmpty()){
     		criteria.andCheckpeopleEqualTo(checkpeople).andResultnumEqualTo(resultnum);
     		checkResultList =checkResultMapper.selectByExample(checkResultExample);
     		return checkResultList;
     	}
		return checkResultList;
	}
	public List<CheckResult> getCheckResultsByCheckbox(
			String[] resultnumList
			){
		List<CheckResult> checkResultList  = new ArrayList<>();		
		        for(int i=0;i<resultnumList.length;i++){	        	
		        	checkResultList.add(checkResultMapper.selectresultnumbycheckbox(resultnumList[i]));
		        }		        
				return checkResultList;		
	}
//	@Test
//	public void  testgetCheckResultsBySelectTerms()
//	{
//	
//		String checkpeople="qq";
//		CheckResultExampleCustom   checkResultExample=new  CheckResultExampleCustom();
//		CheckResultExample.Criteria criteria =checkResultExample.createCriteria();
//		criteria.andCheckpeopleEqualTo(checkpeople);
// 		List<CheckResult>  assetResultList =checkResultMapper.selectByExample(checkResultExample);
// 		System.out.println( assetResultList.get(0).getResultnum());
//	} 
	/**
	 * 查询盘点记录详情列表
	 * @author 于立波
	 * @param resultnum  盘点编号
	 * @param  page   页数
	 * @return
	 */
	@Log(descrp="执行查询盘点记录结果详情操作",type="系统管理权限，资产管理权限，查询权限")
	public List< List<Asset>> getAssetDetailByResultnumWithPage(
			String resultnum
			,PageParameter page
			){	
		CheckResultDetailExampleCustom   checkResultDetailExample=new  CheckResultDetailExampleCustom();
		checkResultDetailExample.setOrderByClause("result desc");
		checkResultDetailExample.setPage(page);
		CheckResultDetailExample.Criteria criteria =checkResultDetailExample.createCriteria();
		criteria.andResultnumEqualTo(resultnum);
		List<CheckResultDetail> assetResultDetailList =checkResultDetailMapper.selectByExample(checkResultDetailExample);
		//根据assetdetaillist里的多个code查询Aseet表,再把查出来的Asset放到一个集合里
		List<List<Asset>> assetList=new ArrayList<>();
	    for(int i=0;i<assetResultDetailList .size();i++){
	    	//根据assetdetaillist查询Asset表	    	
	    	AssetExampleCustom assetExample=new AssetExampleCustom();
			//assetExample.setPage(page);
	    	AssetExample.Criteria  acriteria= assetExample.createCriteria();
	    	acriteria.andCodeEqualTo(assetResultDetailList .get(i).getCode());
	    	 assetList.add(assetMapper.selectByExample(assetExample));
	    }
		if ( assetList.size()>0) {
			return  assetList;
		}
			else{
				new NullPointerException("没有找到相关信息");
				return null;
			}
	}
//	@Test
//	public void testGetAssetDetailByResultnum(){
//		String resultnum="1234";
//		CheckResultDetailExampleCustom   checkResultDetailExample=new  CheckResultDetailExampleCustom();
//		CheckResultDetailExample.Criteria criteria =checkResultDetailExample.createCriteria();
//		criteria.andResultnumEqualTo(resultnum);
//		List<CheckResultDetail> assetResultdetaiLiist =checkResultDetailMapper.selectByExample(checkResultDetailExample);
//		List<List<Asset>> assetList=new ArrayList<>();
//	    for(int i=0;i< assetResultdetaiLiist.size();i++){
//	    	//根据assetdetaillist查询Asset表	    
//	    	AssetExampleCustom assetExample=new AssetExampleCustom();
//	    	AssetExample.Criteria  acriteria= assetExample.createCriteria();
//	    	acriteria.andCodeEqualTo( assetResultdetaiLiist .get(i).getCode());
//	    	assetList.add(assetMapper.selectByExample(assetExample));
//	       System.out.println(assetMapper.selectByExample(assetExample));
//	    }    
//	     System.out.println(assetList.size());	    
//	}
	/**
	 * 查询每条资产的盘点状态
	 * @author 于立波
 	 * @param resultnum  盘点编号
	 * @return
	 */
	public String getCheckResultsByCode(
			String code
			){
	    CheckResultDetailExampleCustom   checkResult=new  CheckResultDetailExampleCustom();
	    CheckResultDetailExample.Criteria criteria =checkResult.createCriteria();
	    criteria.andCodeEqualTo(code);
	    List<CheckResultDetail> assetResultList=checkResultDetailMapper.selectByExample( checkResult);
	    return assetResultList.get(0).getResult();
}/**
	 * 查询每条资产的盘点状态(测试)
	 * @author 于立波
 	 * @param resultnum  盘点编号
	 * @return
	 */
//	@Test
//	public void getCheckResultsByResultnum(){
//CheckResultDetailExampleCustom   checkResultDetail=new  CheckResultDetailExampleCustom();
//CheckResultDetailExample.Criteria criteria =checkResultDetail.createCriteria();
//criteria.andResultnumEqualTo("G9GRdRYvl4uYFPXyI2DKbh9KV");
//List<CheckResultDetail> checkResultDetailList=checkResultDetailMapper.selectByExample(checkResultDetail);
//System.out.println(checkResultDetailList.get(4).getResult());
//}
//加test的为第一版本后新测试的
public List<CheckResultDetail> getCheckResultsByResultnum(
			String resultnum
			){
	    CheckResultDetailExampleCustom   checkResultDetail=new  CheckResultDetailExampleCustom();
	    checkResultDetail.setOrderByClause("result desc");
	    CheckResultDetailExample.Criteria criteria =checkResultDetail.createCriteria();
	    criteria.andResultnumEqualTo(resultnum);
	    List<CheckResultDetail> checkResultDetailList=checkResultDetailMapper.selectByExample(checkResultDetail);
	    return checkResultDetailList;
}
//	@Test
//	public void testgetCheckResultsByCode(	){
//	    String code="9876";
//	    CheckResultDetailExampleCustom   checkResult=new  CheckResultDetailExampleCustom();
//	    CheckResultDetailExample.Criteria criteria =checkResult.createCriteria();
//	    criteria.andCodeEqualTo(code);
//	    List<CheckResultDetail>assetResultList=checkResultDetailMapper.selectByExample( checkResult);
//	    System.out.println(assetResultList.get(0).getResult());
//}
	/**
	 * 查询盘点记录备注
	 * @author 于立波
	 * @param resultnum  盘点编号
	 * @return
	 */
@Log(descrp="执行查询资产盘点记录操作",type="系统管理权限，资产管理权限，查询权限")
	public String getCheckResultsRemarkByResultnum(
			String resultnum
			){
		    CheckResultExampleCustom   checkResultRemark=new  CheckResultExampleCustom();
		    CheckResultExample.Criteria criteria =checkResultRemark.createCriteria();
		    //查Remark
		    criteria.andResultnumEqualTo(resultnum);
		    List<CheckResult> assetResultList=checkResultMapper.selectByExample( checkResultRemark);
		    return assetResultList.get(0).getRemark() ;
	}
	public List< List<Asset>> getAssetDetailByResultnum(
			String resultnum
			){	
		CheckResultDetailExampleCustom   checkResultDetailExample=new  CheckResultDetailExampleCustom();
		checkResultDetailExample.setOrderByClause("result desc");
		CheckResultDetailExample.Criteria criteria =checkResultDetailExample.createCriteria();
		criteria.andResultnumEqualTo(resultnum);
		List<CheckResultDetail> assetResultDetailList =checkResultDetailMapper.selectByExample(checkResultDetailExample);
		//根据assetdetaillist里的多个code查询Aseet表,再把查出来的Asset放到一个集合里
		List<List<Asset>> assetList=new ArrayList<>();
	    for(int i=0;i<assetResultDetailList .size();i++){
	    	//根据assetdetaillist查询Asset表	    	
	    	AssetExampleCustom assetExample=new AssetExampleCustom();
	    	AssetExample.Criteria  acriteria= assetExample.createCriteria();
	    	acriteria.andCodeEqualTo(assetResultDetailList .get(i).getCode());
	    	 assetList.add(assetMapper.selectByExample(assetExample));
	    }
			return  assetList;
	}
//	@Test
//	public void testgetCheckResultsRemarkByResultnum(	){
//		    String resultnum="6789";
//		    CheckResultExampleCustom   checkResultRemark=new  CheckResultExampleCustom();
//		    CheckResultExample.Criteria criteria =checkResultRemark.createCriteria();
//		    criteria.andResultnumEqualTo(resultnum);
//		    List<CheckResult> assetResultList=checkResultMapper.selectByExample( checkResultRemark);
//		    System.out.println(assetResultList.get(0).getRemark());
//	}
	/**
	 * 查询盘点记录列表
	 * @param checktimestart 起始盘点日期
	 * @param checktimeend 结束盘点日期
	 * @param checkpeople 盘点人
	 * @param resultnum 盘点编号
	 * @param currentpage 当前页数
	 * @return
	 */
//	public CustomAssetCheckResultWithDetail getCheckResultsBySelectTermsWithPage(
//			Date checktimestart
//			,Date checktimeend
//			,String checkpeople
//			,String resultnum
//			,Integer currentpage){
//		CustomAssetCheckResultWithDetail checkResultWithDetail = new CustomAssetCheckResultWithDetail();	
//		//TODO	
//		return checkResultWithDetail;
//	}
}
