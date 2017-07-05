package cn.bronze.services;

import java.util.List;

import javax.annotation.PostConstruct;

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
public class AdminAssetTypeService extends GenernicServiceImpl<AssetType,AssetTypeExample>{
	@Autowired
	private AssetTypeMapper assetTypeMapper;
	
	@PostConstruct
	public void  post(){
		if(assetTypeMapper!=null){
			super.setDao(assetTypeMapper);
			System.err.println("已经注入了"+assetTypeMapper.getClass().getName());
		}
	}	
	/***
	 * 尼雷清
	 * 根据"typename"精确查询一级类型     getAssetTypeFirstMenuByTypeNameWithPage
	 * @param pageParameter
	 * @param typename
	 * @return List<AssetType>
	 */
	public List<AssetType> getAssetTypeFirstMenuByTypeNameWithPage(String typename,PageParameter pageParameter){
		if(typename==null||typename.length()==0)
			return null;
		AssetTypeExampleCumtom assetTypeExampleCumtom=new AssetTypeExampleCumtom();
		AssetTypeExampleCumtom.Criteria assetTypeCriteria = assetTypeExampleCumtom.createCriteria();
		assetTypeCriteria.andFidEqualTo(0).andTypenameEqualTo(typename);
		assetTypeExampleCumtom.setPage(pageParameter);
		List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExampleCumtom);
		
		return assetTypeList;
	}
	/***
	 * 尼雷清
	 * 根据"typename"精确查询一级类型     getAssetTypeFirstMenuByTypeNameWithPage
	 * @param pageParameter
	 * @param typename
	 * @return List<AssetType>
	 */
	@Test
	public void testgetAssetTypeFirstMenuByTypeNameWithPage(){
		String typename="土地、房屋及构建物";
		if(typename==null||typename.length()==0)
		{System.out.println("输入为空");}
		
		AssetTypeExample assetTypeExample=new AssetTypeExample();
		AssetTypeExample.Criteria criteria=assetTypeExample.createCriteria();
		criteria.andTypenameEqualTo(typename);
		List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExample);
		System.out.println(assetTypeList.get(0).getTypename());
	}
	/***
	 * 尼雷清
	 * 测试   分页查询对应fid的list      getAssetTypeElseMenuByFidWithPage
	 * @param pageParameter
	 * @param String fid
	 * @return List<AssetType>
	 */
	@Test
	public void testgetAssetTypeElseMenuByFidWithPage(){
		int fid=0;
		int currentPage=1;
		PageParameter pageParameter=PageParameter.NewInstance(currentPage);
		AssetTypeExampleCumtom assetTypeExampleCumtom=new AssetTypeExampleCumtom();
		
		AssetTypeExampleCumtom.Criteria assetTypeCriteria = assetTypeExampleCumtom.createCriteria();
		assetTypeCriteria.andFidEqualTo(fid);
		assetTypeExampleCumtom.setPage(pageParameter);
		
		List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExampleCumtom);
		System.out.println(assetTypeList.size());
	}
	/***
	 * 尼雷清
	 * 分页查询对应fid的list      getAssetTypeElseMenuByFidWithPage
	 * @param currentpage
	 * @param fid
	 * @return List<AssetType>
	 */
	public List<AssetType> getAssetTypeElseMenuByFidWithPage(int fid,PageParameter pageParameter){
		
		AssetTypeExampleCumtom assetTypeExampleCumtom=new AssetTypeExampleCumtom();
		
		AssetTypeExampleCumtom.Criteria assetTypeCriteria = assetTypeExampleCumtom.createCriteria();
		assetTypeCriteria.andFidEqualTo(fid);
		assetTypeExampleCumtom.setPage(pageParameter);
		
		List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExampleCumtom);
		return assetTypeList;
	}
	/***
	 * 尼雷清
	 * 查询出分页的总数      findTotalPage
	 * @param currentpage
	 * @param fid
	 * @return int
	 */
	public int findTotalPage(int fid){
		PageParameter pageParameter=new PageParameter();
		AssetTypeExampleCumtom assetTypeExampleCumtom=new AssetTypeExampleCumtom();
		AssetTypeExampleCumtom.Criteria assetTypeCriteria = assetTypeExampleCumtom.createCriteria();
		assetTypeCriteria.andFidEqualTo(fid);
		assetTypeExampleCumtom.setPage(pageParameter);
		List<AssetType> assetTypeList =assetTypeMapper.selectByExample(assetTypeExampleCumtom);
		return pageParameter.getTotalPage();
	}
	/***
	 * 尼雷清
	 * 执行插入资产类型操作并且保证同fid下不能出现同一个typename      insertByAssetTypeByFid
	 * @param assetType
	 * @return int
	 */
	public int insertByAssetTypeByFid(AssetType assetType){
		if(assetType.getTypename()!=null){//先对其类型名进行判空，否则下面equals的时候有可能出现空指针异常
			AssetTypeExample assetTypeExample=new AssetTypeExample();
			AssetTypeExample.Criteria criteria=assetTypeExample.createCriteria();
			criteria.andFidEqualTo(assetType.getFid());
			List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExample);
			int i;
			for(i=0;i<assetTypeList.size();i++){
				if(assetTypeList.get(i).getTypename().equals(assetType.getTypename())){
					i++;
					break;
				}
				if(i==assetTypeList.size()-1){
					int status=assetTypeMapper.insert(assetType);
					return status;
				}
			}
			if(i==0){
				int status=assetTypeMapper.insert(assetType);
				return status;
			}
			System.out.println("有重复的类型名称，添加失败!");
			return 0;
			
		}else{
			System.out.println("没有穿过来assettype，添加失败!");
			return 0;
		}
		
	}
	/***
	 * 尼雷清
	 * 添加资产名称合法性验证      typenameIsInLegal
	 * @param assetType
	 * @return boolean
	 */
	public boolean typenameIsInLegal(String typename,Integer fid){
			AssetTypeExample assetTypeExample=new AssetTypeExample();
			AssetTypeExample.Criteria criteria=assetTypeExample.createCriteria();
			criteria.andFidEqualTo(fid).andTypenameEqualTo(typename);
			List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExample);
			if(assetTypeList.size()!=0){
				return false;
			}else{
				return true;
			}	
	}
	/***
	 * 尼雷清
	 * 修改资产名称合法性验证      typenameIsInLegal
	 * @param assetType
	 * @return boolean
	 */
	public boolean updatetypenameIsInLegal(String typename,Integer fid,String pretypename){
			
			if(typename!=null||typename!=""){//先对其类型名进行判空，否则下面equals的时候有可能出现空指针异常
				if(typename.equals(pretypename)){//此处确认用户是否修改了，类型名称，若没有修改则直接进行修改操作
					return true;
				}else{//此处用户修改了类型名称
					AssetTypeExample assetTypeExample=new AssetTypeExample();
					AssetTypeExample.Criteria criteria=assetTypeExample.createCriteria();
					criteria.andFidEqualTo(fid).andTypenameEqualTo(typename);
					List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExample);
					if(assetTypeList.size()!=0){
						return false;
					}else{
						return true;
					}	
				}
			}
			return false;
	}
	/***
	 * 尼雷清
	 * 测试  执行插入资产类型操作并且保证同fid下不能出现同一个typename      testinsertByAssetTypeByFid
	 * @param assetType
	 * @return int
	 */
	@Test
	public void testinsertByAssetTypeByFid(){
		AssetType assetType=new AssetType();
		assetType.setTypename("通用设备80");
		assetType.setFid(0);
		if(assetType.getTypename()!=null){//先对其类型名进行判空，否则下面equals的时候有可能出现空指针异常
			AssetTypeExample assetTypeExample=new AssetTypeExample();
			AssetTypeExample.Criteria criteria=assetTypeExample.createCriteria();
			criteria.andFidEqualTo(assetType.getFid());
			List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExample);
			for(int i=0;i<assetTypeList.size();i++){
				if(assetTypeList.get(i).getTypename().equals(assetType.getTypename())){
					break;
				}
				if(i==assetTypeList.size()-1){
					assetTypeMapper.insert(assetType);
					System.out.println("无重复的类型名称，添加成功!");
				}
			}
			System.out.println("有重复的类型名称，添加失败!");
			
		}else{
			System.out.println("没有穿过来assettype，添加失败!");
		}
		
	}
	/***
	 * 尼雷清
	 * 执行按照id查询资产类型操作     selectByAssetTypeByFid
	 * @param int
	 * @return AssetType 
	 */
	public AssetType selectByAssetTypeById(int id){
		AssetType assetType=assetTypeMapper.selectByPrimaryKey(id);
		return assetType;
	}
	/***
	 * 尼雷清
	 * 执行更新资产类型操作     selectByAssetTypeByFid
	 * @param AssetType
	 * @return int
	 */
	public int updateByAssetTypeByFid(AssetType assetType,String pretypename){
		if(assetType.getTypename()!=null){//先对其类型名进行判空，否则下面equals的时候有可能出现空指针异常
			if(assetType.getTypename().equals(pretypename)){//此处确认用户是否修改了，类型名称，若没有修改则直接进行修改操作
				int record=assetTypeMapper.updateByPrimaryKey(assetType);
				return record;
			}else{//此处用户修改了类型名称
				AssetTypeExample assetTypeExample=new AssetTypeExample();
				AssetTypeExample.Criteria criteria=assetTypeExample.createCriteria();
				criteria.andFidEqualTo(assetType.getFid());
				List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExample);
				for(int i=0;i<assetTypeList.size();i++){
					if(assetTypeList.get(i).getTypename().equals(assetType.getTypename())){
						break;
					}
					if(i==assetTypeList.size()-1){
							int record=assetTypeMapper.updateByPrimaryKey(assetType);
							return record;
					}
				}
				System.out.println("该级下有重复的类型名称，更新失败!");
				return 0;
			}
		}else{
			System.out.println("没有穿过来assettype，更新失败!");
			return 0;
		}
	}
	/***
	 * 尼雷清
	 * 执行按照id删除资产类型操作     selectByAssetTypeByFid
	 * @param int
	 * @return int
	 */
	public int deleteAssetTypeById(int id){
		AssetTypeExample assetTypeExample=new AssetTypeExample();
		AssetTypeExample.Criteria criteria=assetTypeExample.createCriteria();
		criteria.andFidEqualTo(id);
		List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExample);
		if(assetTypeList.size()!=0){
			return 0;
		}else{
			int record=assetTypeMapper.deleteByPrimaryKey(id);
			return record;
		}
	}
	/***
	 * 尼雷清
	 * 递归删除   多个  资产类型操作     deleteAssetType
	 * @param int
	 * @return 
	 */
	public int deleteAssetType(int id){
		AssetTypeExample assetTypeExample=new AssetTypeExample();
		AssetTypeExample.Criteria criteria=assetTypeExample.createCriteria();
		criteria.andFidEqualTo(id);
		List<AssetType> assetTypeList=assetTypeMapper.selectByExample(assetTypeExample);
		if(assetTypeList.size()!=0){
		for(int i=0;i<assetTypeList.size();i++){
			deleteAssetType(assetTypeList.get(i).getId());
		}
		return assetTypeMapper.deleteByPrimaryKey(id);
		}else{
		return assetTypeMapper.deleteByPrimaryKey(id);
		}
	}
	/***
	 * 尼雷清
	 * 测试   递归删除   多个  资产类型操作     deleteAssetType
	 * @param int
	 * @return 
	 */
	@Test
	public void testdeleteAssetType(){
		int id=8;
		deleteAssetType(id);
	}
	
	
	
	
	
	
	/**
	 * 通过名称查询子菜单
	 * @author 董浩
	 * 2016年6月26日 下午9:44:51
	 * @param name
	 * @return
	 */
	public List<AssetType> selectChildAssetTypeByName(String name){
		AssetTypeExample assetTypeExample = new AssetTypeExample();
		AssetTypeExample.Criteria criteria = assetTypeExample.createCriteria();
		criteria.andTypenameEqualTo(name);
		List<AssetType> assetTypes = assetTypeMapper.selectByExample(assetTypeExample);
		/*List<AssetType> assetTypes = assetTypeMapper.selectByExample(assetTypeExample);*/
		
		
		if(assetTypes!=null&&assetTypes.size()>0){
			int id = assetTypes.get(0).getId();
			AssetTypeExample assetTypeExample2 = new AssetTypeExample();
			AssetTypeExample.Criteria criteria2 = assetTypeExample2.createCriteria();
			criteria2.andFidEqualTo(id);
			List<AssetType> list = assetTypeMapper.selectByExample(assetTypeExample2);
			if(list!=null){
				return list;
			}else {
				return null;
			}
		}else {
			return null;
		}
		
	}
	
	
	/**
	 * 查询子菜单测试
	 * @author 董浩
	 * 2016年6月26日 下午10:08:25
	 */
	@Test
	public void testSelectChildAssetTypeByName(){
		String name = "土地";
		AssetTypeExample assetTypeExample = new AssetTypeExample();
		AssetTypeExample.Criteria criteria = assetTypeExample.createCriteria();
		criteria.andTypenameEqualTo(name);
		/*List<AssetType> assetTypes = this.selectByExample(assetTypeExample);*/
		List<AssetType> assetTypes = assetTypeMapper.selectByExample(assetTypeExample);
		
		if(assetTypes!=null){
			int id = assetTypes.get(0).getId();
			AssetTypeExample assetTypeExample2 = new AssetTypeExample();
			AssetTypeExample.Criteria criteria2 = assetTypeExample2.createCriteria();
			criteria2.andFidEqualTo(id);
			List<AssetType> list = assetTypeMapper.selectByExample(assetTypeExample2);
			if(list!=null){
				System.out.println(list.size());
			}else {
				System.out.println("无数据");
			}
		}else {
			System.out.println("无数据");
		}
		
	}
	
	/**
	 * 查询一级菜单
	 * @author 董浩
	 * 2016年6月27日 上午9:18:30
	 * @return
	 */
	public List<AssetType> selectFirstAssetTypeMenu(){
		AssetTypeExample assetTypeExample = new AssetTypeExample();
		AssetTypeExample.Criteria criteria = assetTypeExample.createCriteria();
		criteria.andFidEqualTo(0);
		List<AssetType> list = assetTypeMapper.selectByExample(assetTypeExample);
		if (list!=null&&list.size()!=0) {
			return list;
		}else {
			return null;
		}
	}
	
	
	/**
	 * 根据名称查询fid
	 * @author 董浩
	 * 2016年6月27日 上午11:16:35
	 * @param name
	 * @return
	 */
	public int selectFidById(int id){
		AssetTypeExample assetTypeExample = new AssetTypeExample();
		AssetTypeExample.Criteria criteria = assetTypeExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<AssetType> list = assetTypeMapper.selectByExample(assetTypeExample);
		if(list!=null&&list.size()!=0){
			return list.get(0).getFid();
		}else {
			return -1;
		}
	}
	
	
	/**
	 * 根据AssetType的name查询其id值
	 * @author 董浩
	 * 2016年6月27日 下午4:34:04
	 * @param typename
	 * @return
	 */
	public int selectIdByAssetTypeName(String typename){
		AssetTypeExample assetTypeExample = new AssetTypeExample();
		AssetTypeExample.Criteria criteria = assetTypeExample.createCriteria();
		criteria.andTypenameEqualTo(typename);
		List<AssetType> list = assetTypeMapper.selectByExample(assetTypeExample);
		if(list!=null&&list.size()!=0){
			return list.get(0).getId();
		}else {
			return -1;
		}
	}
	
	
	
	
	
	/**
	 * 根据fid查询兄弟列表
	 * @author 董浩
	 * 2016年6月27日 上午11:20:22
	 * @param fid
	 * @return
	 */
	public List<AssetType> selectBrotherAssetTypeByFid(int fid){
		AssetTypeExample assetTypeExample = new AssetTypeExample();
		AssetTypeExample.Criteria criteria = assetTypeExample.createCriteria();
		criteria.andFidEqualTo(fid);
		List<AssetType> list = assetTypeMapper.selectByExample(assetTypeExample);
		if (list!=null&&list.size()!=0) {
			return list;
		}else {
			return null;
		}
	}
	
	
}
