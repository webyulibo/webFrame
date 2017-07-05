package cn.bronze.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetTypeMapper;
import cn.bronze.entities.AssetType;
import cn.bronze.entities.AssetTypeExample;
import cn.bronze.entities.AssetTypeExampleCumtom;
import cn.bronze.util.page.PageParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class BaseAssetTypeService  extends GenernicServiceImpl<AssetType,AssetTypeExample> {

	@Autowired
	private AssetTypeMapper assetTypeMapper;
	
	/***
	 * 刘仁鹏
	 * 测试示例
	 */
	@Test
	public void testInsert(){
		System.out.println("lrp:This is testInsert Method;");
		AssetType assetType = new AssetType();
		assetType.setFid(0);
		assetType.setNumber(10);
		assetType.setTypename("土地、房屋及构建物");
		assetType.setUnit("平方米");
		
		System.out.println("result:" + assetTypeMapper.insert(assetType));
		
	}
	
	@Test
	public void testGetAllByPage(){
		PageParameter pageParameter = new PageParameter();
		pageParameter.setCurrentPage(1);
		System.out.println();
	}
	
	
	/***
	 * 刘仁鹏
	 * 分页查询AssetType表
	 * @param pageParameter
	 * @return
	 */
	public List<AssetType> getAllByPage(PageParameter pageParameter){
		if(pageParameter==null)
			return null;
		
		AssetTypeExampleCumtom assetTypeExampleCumtom = new AssetTypeExampleCumtom();
		AssetTypeExampleCumtom.Criteria assetTypeCriteria = assetTypeExampleCumtom.createCriteria();
		assetTypeExampleCumtom.setPage(pageParameter);
		
		
		List<AssetType> assetTypeList = assetTypeMapper.selectByExample(assetTypeExampleCumtom);
		return assetTypeList;
		
	}

}
