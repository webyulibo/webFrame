package cn.bronze.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetMapper;
import cn.bronze.daos.MyBorrowMapper;
import cn.bronze.daos.MyScrapMapper;
import cn.bronze.daos.TScrapMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.AssetborrowExampleCustom;
import cn.bronze.entities.TAssetborrow;
import cn.bronze.entities.TAssetborrowExample;
import cn.bronze.entities.TScrap;
import cn.bronze.entities.TScrapExample;
import cn.bronze.entities.TScrapExampleCustom;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;
@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminScrapService {
@Autowired
public TScrapMapper scrapMapper;
@Autowired
public  MyScrapMapper myScrapMapper;
@Autowired
public  MyBorrowMapper myBorrowMapper;
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
 * scrapRecord  报废记录
 * 保存报废记录
 */
@Log(descrp="执行保存报废记录操作",type="系统管理权限，资产管理权限")
public void saveScrapRecord(
		   TScrap scrapRecord
		   ){
	  scrapMapper.insert(scrapRecord);
}
/**
 * 于立波
 * assetcode  资产编号
 * 改变资产的状态
 */
public void changeAssetState(
		   String assetcode
		   ){
	 myScrapMapper.changeAssetState(assetcode);
}
public void changeAssetState1(
		   String assetcode
		   ){
	 myScrapMapper.changeAssetState1(assetcode);
}
/**
 * 于立波
 * page  用于分页
 * 查询报废记录详情
 */
@Log(descrp="执行查询报废记录详情操作",type="系统管理权限，资产管理权限，查询权限")
public List<TScrap> getScrapList(
	   PageParameter page
	   ){
   List<TScrap> scrapList=new ArrayList<>();
  TScrapExampleCustom scrapExample=new TScrapExampleCustom();
  scrapExample.setPage(page);
   TScrapExample.Criteria criteria=scrapExample.createCriteria();
   scrapList=scrapMapper.selectByExample(scrapExample);
   return scrapList;
}
}
