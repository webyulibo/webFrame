/**
 * 
 */
package cn.bronze.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.AssetExampleCustom;
import cn.bronze.util.page.PageParameter;

/**
 * @author 董浩
 * 2016年6月17日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminAssetService extends GenernicServiceImpl<Asset, AssetExample>{
	
	@Autowired
	private AssetMapper assetMapper;
	
	@PostConstruct
	public void  post(){
		if(assetMapper!=null){
			super.setDao(assetMapper);
			System.err.println("已经注入了"+assetMapper.getClass().getName());
		}
	}	

	
	/**
	 * 首页显示（首页条件查询）
	 * @author 董浩
	 * 2016年6月17日 下午9:09:22
	 */
	@Test
	public void testGetAssetItemsByCondition(){
		String category = "全部";
		String text = "";
		//String type = "保险柜";
		String usestate = "全部";
		String state = "全部";
		AssetExampleCustom assetExampleCustom = new AssetExampleCustom();
		AssetExampleCustom.Criteria criteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria userCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria usedepartmentCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria keeperCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria keepdepartmentCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria codeCriteria = assetExampleCustom.createCriteria();
		
		if(category!=null&&category.equals("全部")&&text.equals("")==false){
			if(usestate.equals("全部")){
				if (state.equals("全部")) {
					userCriteria.andUserEqualTo(text);
					usedepartmentCriteria.andUsedepartmentEqualTo(text);
					keeperCriteria.andKeeperEqualTo(text);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text);
					codeCriteria.andCodeEqualTo(text);
				}else {
					userCriteria.andUserEqualTo(text).andStateEqualTo(state);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andStateEqualTo(state);
					keeperCriteria.andKeeperEqualTo(text).andSobEqualTo(state);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andStateEqualTo(state);
					codeCriteria.andCodeEqualTo(text).andStateEqualTo(state);
				}
			}else{
				if(state.equals("全部")){
					userCriteria.andUserEqualTo(text).andUsestateEqualTo(usestate);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andUsestateEqualTo(usestate);
					keeperCriteria.andKeeperEqualTo(text).andUsestateEqualTo(usestate);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andUsestateEqualTo(usestate);
					codeCriteria.andCodeEqualTo(text).andUsestateEqualTo(usestate);
				}else {
					userCriteria.andUserEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					keeperCriteria.andKeeperEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					codeCriteria.andCodeEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
				}
			}
			assetExampleCustom.or(userCriteria);
			assetExampleCustom.or(usedepartmentCriteria);
			assetExampleCustom.or(keeperCriteria);
			assetExampleCustom.or(keepdepartmentCriteria);
			assetExampleCustom.or(codeCriteria);
			assetExampleCustom.or(userCriteria);
			List<Asset> list = this.selectByExample(assetExampleCustom);
			System.out.println(list.size());
		}
		else {
			if(usestate!=null&&usestate.equals("")==false&&usestate.equals("全部")==false){
				criteria.andUsestateEqualTo(usestate);
			}
			if(state!=null&&state.equals("")==false&&state.equals("全部")==false){
				criteria.andStateEqualTo(state);
			}
			
			if(category!=null&&category.equals("使用人")){
				criteria.andUserEqualTo(text);
				//assetExampleCustom.or(userCriteria);
			}
			if(category!=null&&category.equals("使用部门")){
				criteria.andUsedepartmentEqualTo(text);
				//assetExampleCustom.or(usedepartmentCriteria);
			}
			if(category!=null&&category.equals("保管人")){
				criteria.andKeeperEqualTo(text);
				//assetExampleCustom.or(keeperCriteria);
			}
			if(category!=null&&category.equals("保管部门")){
				criteria.andKeepdepartmentEqualTo(text);
				//assetExampleCustom.or(keepdepartmentCriteria);
			}
			if(category!=null&&category.equals("资产代码")){
				criteria.andCodeEqualTo(text);
				//assetExampleCustom.or(codeCriteria);
			}
			List<Asset> list = this.selectByExample(assetExampleCustom);
			System.out.println(list.size());
			
			
		}
		/*else if(category!=null&&category.equals("资产类型")){
			criteria.andTypeEqualTo(text);
			//assetExampleCustom.or(typeCriteria);
		}*/
		
		//System.out.println(list.get(0).getType());
	}
	
	
	/**
	 * @author 董浩
	 * 2016年6月17日 下午9:33:20
	 * @param type
	 * @param usestate
	 * @param state
	 * @param currentPage
	 * @return
	 */
	public List<Asset> getAssetItemsByCondition(String category,String text,String usestate,String state,PageParameter page){
		
		AssetExampleCustom assetExampleCustom = new AssetExampleCustom();
		AssetExampleCustom.Criteria criteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria userCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria usedepartmentCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria keeperCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria keepdepartmentCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria codeCriteria = assetExampleCustom.createCriteria();
		List<Asset> list;
		
		if(category!=null&&category.equals("全部")&&text.equals("")==false){
			if(usestate.equals("全部")){
				if (state.equals("全部")) {
					userCriteria.andUserEqualTo(text);
					usedepartmentCriteria.andUsedepartmentEqualTo(text);
					keeperCriteria.andKeeperEqualTo(text);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text);
					codeCriteria.andCodeEqualTo(text);
				}else {
					userCriteria.andUserEqualTo(text).andStateEqualTo(state);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andStateEqualTo(state);
					keeperCriteria.andKeeperEqualTo(text).andSobEqualTo(state);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andStateEqualTo(state);
					codeCriteria.andCodeEqualTo(text).andStateEqualTo(state);
				}
			}else{
				if(state.equals("全部")){
					userCriteria.andUserEqualTo(text).andUsestateEqualTo(usestate);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andUsestateEqualTo(usestate);
					keeperCriteria.andKeeperEqualTo(text).andUsestateEqualTo(usestate);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andUsestateEqualTo(usestate);
					codeCriteria.andCodeEqualTo(text).andUsestateEqualTo(usestate);
				}else {
					userCriteria.andUserEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					keeperCriteria.andKeeperEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					codeCriteria.andCodeEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
				}
			}
			assetExampleCustom.or(userCriteria);
			assetExampleCustom.or(usedepartmentCriteria);
			assetExampleCustom.or(keeperCriteria);
			assetExampleCustom.or(keepdepartmentCriteria);
			assetExampleCustom.or(codeCriteria);
			assetExampleCustom.or(userCriteria);
			assetExampleCustom.setPage(page);
			list = this.selectByExample(assetExampleCustom);
		}
		else {
			if(usestate!=null&&usestate.equals("")==false&&usestate.equals("全部")==false){
				criteria.andUsestateEqualTo(usestate);
			}
			if(state!=null&&state.equals("")==false&&state.equals("全部")==false){
				criteria.andStateEqualTo(state);
			}
			
			if(category!=null&&category.equals("使用人")){
				criteria.andUserEqualTo(text);
			}
			if(category!=null&&category.equals("使用部门")){
				criteria.andUsedepartmentEqualTo(text);
			}
			if(category!=null&&category.equals("保管人")){
				criteria.andKeeperEqualTo(text);
			}
			if(category!=null&&category.equals("保管部门")){
				criteria.andKeepdepartmentEqualTo(text);
			}
			if(category!=null&&category.equals("资产代码")){
				criteria.andCodeEqualTo(text);
			}
			assetExampleCustom.setPage(page);
			list = this.selectByExample(assetExampleCustom);
		}
		return list;
	}
	
	
	/**
	 * 不带page参数的条件查询
	 * @author 董浩
	 * 2016年6月20日 上午10:50:07
	 * @param category
	 * @param text
	 * @param usestate
	 * @param state
	 * @return
	 */
	public List<Asset> selectAssetAllByCondition(String category,String text,String usestate,String state){
		AssetExampleCustom assetExampleCustom = new AssetExampleCustom();
		AssetExampleCustom.Criteria criteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria userCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria usedepartmentCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria keeperCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria keepdepartmentCriteria = assetExampleCustom.createCriteria();
		AssetExampleCustom.Criteria codeCriteria = assetExampleCustom.createCriteria();
		List<Asset> list;
		
		if(category!=null&&category.equals("全部")&&text.equals("")==false){
			if(usestate.equals("全部")){
				if (state.equals("全部")) {
					userCriteria.andUserEqualTo(text);
					usedepartmentCriteria.andUsedepartmentEqualTo(text);
					keeperCriteria.andKeeperEqualTo(text);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text);
					codeCriteria.andCodeEqualTo(text);
				}else {
					userCriteria.andUserEqualTo(text).andStateEqualTo(state);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andStateEqualTo(state);
					keeperCriteria.andKeeperEqualTo(text).andSobEqualTo(state);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andStateEqualTo(state);
					codeCriteria.andCodeEqualTo(text).andStateEqualTo(state);
				}
			}else{
				if(state.equals("全部")){
					userCriteria.andUserEqualTo(text).andUsestateEqualTo(usestate);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andUsestateEqualTo(usestate);
					keeperCriteria.andKeeperEqualTo(text).andUsestateEqualTo(usestate);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andUsestateEqualTo(usestate);
					codeCriteria.andCodeEqualTo(text).andUsestateEqualTo(usestate);
				}else {
					userCriteria.andUserEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					usedepartmentCriteria.andUsedepartmentEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					keeperCriteria.andKeeperEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					keepdepartmentCriteria.andKeepdepartmentEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
					codeCriteria.andCodeEqualTo(text).andUsestateEqualTo(usestate).andStateEqualTo(state);
				}
			}
			assetExampleCustom.or(userCriteria);
			assetExampleCustom.or(usedepartmentCriteria);
			assetExampleCustom.or(keeperCriteria);
			assetExampleCustom.or(keepdepartmentCriteria);
			assetExampleCustom.or(codeCriteria);
			assetExampleCustom.or(userCriteria);
			list = this.selectByExample(assetExampleCustom);
		}
		else {
			if(usestate!=null&&usestate.equals("")==false&&usestate.equals("全部")==false){
				criteria.andUsestateEqualTo(usestate);
			}
			if(state!=null&&state.equals("")==false&&state.equals("全部")==false){
				criteria.andStateEqualTo(state);
			}
			
			if(category!=null&&category.equals("使用人")){
				criteria.andUserEqualTo(text);
			}
			if(category!=null&&category.equals("使用部门")){
				criteria.andUsedepartmentEqualTo(text);
			}
			if(category!=null&&category.equals("保管人")){
				criteria.andKeeperEqualTo(text);
			}
			if(category!=null&&category.equals("保管部门")){
				criteria.andKeepdepartmentEqualTo(text);
			}
			if(category!=null&&category.equals("资产代码")){
				criteria.andCodeEqualTo(text);
			}
			list = this.selectByExample(assetExampleCustom);
		}
		return list;
	}
	
	/**
	 * 展示导出页面时加载的数据
	 * @author 董浩
	 * 2016年6月24日 上午8:56:34
	 * @param page
	 * @return
	 */
	public List<Asset> selectAssetListWithNone(PageParameter page){
		AssetExampleCustom assetExampleCustom = new AssetExampleCustom();
		//AssetExampleCustom.Criteria criteria = assetExampleCustom.createCriteria();
		assetExampleCustom.setPage(page);
		List<Asset> list = this.selectAll(assetExampleCustom);
		return list;
	}
	
	/**
	 * 导出界面数据测试
	 * @author 董浩
	 * 2016年6月24日 上午9:16:10
	 */
	@Test
	public void testSelectAssetListWithNone(){
		AssetExample assetExample = new AssetExample();
		List<Asset> list = this.selectAll(assetExample);
		System.out.println(list.size());
	}
	
	
	/**
	 * 根据查询是否有相同code代码的资产已经存在
	 * @author 董浩
	 * 2016年6月30日 下午4:15:50
	 * @param code
	 * @return
	 */
	public List<Asset> selectListByCode(String code){
		AssetExample assetExample = new AssetExample();
		AssetExample.Criteria criteria = assetExample.createCriteria();
		criteria.andCodeEqualTo(code);
		List<Asset> list = this.selectByExample(assetExample);
		if (list!=null&&list.size()!=0) {
			return list;
		}else {
			return null;
		}
	}
	
	/**
	 * 查询Asset表的totalPage
	 * @author 董浩
	 * 2016年7月12日 上午11:01:51
	 * @return
	 */
	public int getAssetTotalPage(){
		int totalPage = 1;
		AssetExample assetExample = new AssetExample();
		//AssetExample.Criteria criteria = assetExample.createCriteria();
		int count = this.countByExample(assetExample);
		totalPage = (int)Math.ceil((double)count/10.0);
		return totalPage;
	}
	
	/**
	 * 获取Asset表的totalPage测试用例
	 * @author 董浩
	 * 2016年7月12日 上午11:03:07
	 */
	@Test
	public void testGetAssetTotalPage(){
		int totalPage = 1;
		AssetExample assetExample = new AssetExample();
		//AssetExample.Criteria criteria = assetExample.createCriteria();
		int count = this.countByExample(assetExample);
		totalPage = (int)Math.ceil((double)count/10.0);
		System.out.println(totalPage);
	}
	
	/**
	 * 根据资产代码更新数据
	 * @author 董浩
	 * 2016年7月13日 下午9:39:36
	 * @param asset
	 * @return
	 */
	public int updateAssetByCode(Asset asset){
		AssetExample assetExample = new AssetExample();
		AssetExample.Criteria criteria = assetExample.createCriteria();
		criteria.andCodeEqualTo(asset.getCode());
		//int isSuccess = this.updateByExample(asset, assetExample);
		int isSuccess=this.updateByExample(asset, assetExample);
		return isSuccess;
	}
	
	
	
	
	
	
}
