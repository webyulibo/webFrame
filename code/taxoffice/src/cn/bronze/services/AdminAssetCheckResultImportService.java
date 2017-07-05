package cn.bronze.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetMapper;
import cn.bronze.daos.CheckResultDetailMapper;
import cn.bronze.daos.CheckResultDetailMapperCustom;
import cn.bronze.daos.CheckResultMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.AssetExampleCustom;
import cn.bronze.entities.AssetType;
import cn.bronze.entities.AssetTypeExample;
import cn.bronze.entities.CheckResult;
import cn.bronze.entities.CheckResultDetail;
import cn.bronze.entities.CheckResultDetailAndResult;
import cn.bronze.entities.CheckResultDetailExample;
import cn.bronze.entities.CheckResultDetailExampleCustom;
import cn.bronze.entities.CheckResultExample;
import cn.bronze.entities.CheckResultExampleCustom;
import cn.bronze.entities.CustomAssetCheckResultWithDetail;
import cn.bronze.util.page.PageParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminAssetCheckResultImportService{

	@Autowired
	private CheckResultMapper checkResultMapper;

	@Autowired
	private CheckResultDetailMapper checkResultDetailMapper;

	@Autowired
	private AssetMapper assetMapper;
	
	@Autowired
	private CheckResultDetailMapperCustom checkResultDetailMapperCustom;
	
	
	/**
	 * 
	 * 陈铮
	 * 
	 * 将“盘点结果”和“盘点结果详情”添加到数据库中
	 * 
	 * @param CustomAsscheckResultWithDetail “盘点结果”和“盘点结果详情”POJO
	 * @return
	 */
	public int addCheckResultAndCheckResultDetail(CustomAssetCheckResultWithDetail customAsscheckResultWithDetail){
		int result = 0;
		//插入盘点结果
		result=checkResultMapper.insert(customAsscheckResultWithDetail.getCheckResult());		
		List<CheckResultDetail> checkList1=customAsscheckResultWithDetail.getCheckResultDetails();	
		int a=0;
		//将盘点结果对弈的所有盘点详情插入到详情表中
		for (int i = 0; i < checkList1.size(); i++) {
			a=checkResultDetailMapper.insert(checkList1.get(i));
			result+=a;
		}							
		return result;
	}
	
	//将数据先查漏盘的，再查已盘的	
	public List<CheckResultDetailAndResult> checkResultData(){
		List<CheckResultDetailAndResult> checkResultDetailAndResults=checkResultDetailMapperCustom.selectCheckResult();
		return checkResultDetailAndResults;	
	}

//	@Test
//	public void checkResultData(){
//		
//		List<CheckResultDetailAndResult> checkResultDetailAndResults=checkResultDetailMapperCustom.selectCheckResult();
//		
//		//System.out.println(checkResultDetailAndResults.size());
//		//System.out.println(checkResultDetailAndResults.get(0).getResult());
//		
//	}
	

//	@Test
//	public void testaddCheckResultAndCheckResultDetail(){
//		int result = 0;
//		CustomAssetCheckResultWithDetail customAsscheckResultWithDetail=new CustomAssetCheckResultWithDetail();	
//		//TODO
//		//用于测试的CheckResult
//		CheckResult checkResult=new CheckResult();
//		checkResult.setResultnum("123456");
//		checkResult.setRemark("阿斯顿发送到服务器而");
//		checkResult.setCheckpeople("陈铮");	
//		Date date=new Date();
//		checkResult.setChecktime(date);		
//		customAsscheckResultWithDetail.setCheckResult(checkResult);				
//		CheckResultDetail check1=new CheckResultDetail();
//		check1.setResultnum("123456");
//		check1.setCode("789878");
//		check1.setResult("1");	
//		CheckResultDetail check2=new CheckResultDetail();
//		check2.setResultnum("123456");
//		check2.setCode("12332");
//		check2.setResult("2");		
//		List<CheckResultDetail> checkList=new ArrayList<>();
//		checkList.add(check1);
//		checkList.add(check2);		
//		customAsscheckResultWithDetail.setCheckResultDetails(checkList);
//		
//		
//		result=checkResultMapper.insert(customAsscheckResultWithDetail.getCheckResult());		
//		List<CheckResultDetail> checkList1=customAsscheckResultWithDetail.getCheckResultDetails();	
//		int a=0;
//		for (int i = 0; i < checkList1.size(); i++) {
//			a=checkResultDetailMapper.insert(checkList1.get(i));
//			result+=a;
//		}						
//		System.out.println(result);
//		//return result;
//	}



}
