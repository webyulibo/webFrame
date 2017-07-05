package cn.bronze.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.daos.AssetMapper;
import cn.bronze.daos.AssetTypeMapper;
import cn.bronze.entities.Asset;
import cn.bronze.entities.AssetCustom;
import cn.bronze.entities.AssetExample;
import cn.bronze.entities.AssetExampleCustom;
import cn.bronze.entities.AssetType;
import cn.bronze.log.Log;
import cn.bronze.util.page.PageParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class AdminAssetCheckDataExportService extends GenernicServiceImpl<Asset, AssetExample>{

	@Autowired
	private AssetMapper assetMapper;

	@Autowired
	private AssetTypeMapper assetTypeMapper;
	
	@Autowired
	private AdminAssetTypeService adminAssetTypeService;

	
	
	/**
	 * 刘仁鹏  陈铮
	 *
	 * @param assetCustom 要查询的条件
	 *
	 * @param PageParameter 分页对象
	 * @return
	 */

	public List<Asset> getassetsbyconditionwithpage(AssetCustom assetCustom,PageParameter page){
		List<Asset> assets=new ArrayList<>();
		AssetExampleCustom example=new AssetExampleCustom();
		example.setPage(page);
		AssetExampleCustom.Criteria criteria=example.createCriteria();
		///按使用状态查询
		if(assetCustom.getUsestate()!=null&&assetCustom.getUsestate()!=""){
			criteria.andUsestateEqualTo(assetCustom.getUsestate());
		}
		//按状态查询
	   if(assetCustom.getState()!=null&&assetCustom.getState()!=""){
		   criteria.andStateEqualTo(assetCustom.getState());
	   }
	   //按资产姓名查询
	   if(assetCustom.getName()!=null&&assetCustom.getName()!=""){
		   criteria.andNameEqualTo(assetCustom.getName());
	   }
	   //按资产代码查询
	   if(assetCustom.getCode()!=null&&assetCustom.getCode()!=""){
		   criteria.andCodeEqualTo(assetCustom.getCode());
	   }
	   //保管部门查询
	   if(assetCustom.getKeepdepartment()!=null&&assetCustom.getKeepdepartment()!=""){
		   criteria.andKeepdepartmentEqualTo(assetCustom.getKeepdepartment());
	   }
	   //保管人
	   if(assetCustom.getKeeper()!=null&&assetCustom.getKeeper()!=""){
		   criteria.andKeeperEqualTo(assetCustom.getKeeper());
	   }
	   //使用部门
	   if(assetCustom.getUsedepartment()!=null&&assetCustom.getUsedepartment()!=""){
		   
		   criteria.andUsedepartmentEqualTo(assetCustom.getUsedepartment());
	   }
	   //使用人\
	   if(assetCustom.getUser()!=null&&assetCustom.getUser()!=""){
		   criteria.andUserEqualTo(assetCustom.getUser());
	   }
	   //是否期初
	   if(assetCustom.getIsbegin1()!=null&&assetCustom.getIsbegin1()!=""){
		   if(assetCustom.getIsbegin1().equals("是")){
			   criteria.andIsbeginEqualTo(true);
		   }
		   else{
			   criteria.andIsbeginEqualTo(false);
		   }
	   }
		
		//报废年度
		if(assetCustom.getGhostyear()!=null&&assetCustom.getGhostyear()!=""){
			criteria.andGhostyearEqualTo(assetCustom.getGhostyear());
		}
		
	   //起始购置日期
		if(assetCustom.getPurchasetime()!=null){
			criteria.andPurchasetimeGreaterThanOrEqualTo(assetCustom.getPurchasetime());
		}
		
		//截止购置日期
		if(assetCustom.getAbortpurchasetime()!=null){
			criteria.andPurchasetimeLessThanOrEqualTo(assetCustom.getAbortpurchasetime());
		}
		//起始制卡日期
		if(assetCustom.getMakecardtime()!=null){
			criteria.andMakecardtimeGreaterThanOrEqualTo(assetCustom.getMakecardtime());
		}
		//截止制卡日期
		if(assetCustom.getAbortmakecardtime()!=null){
			criteria.andMakecardtimeLessThanOrEqualTo(assetCustom.getAbortmakecardtime());
		}
		//起始启用日期
		if(assetCustom.getStartusetime()!=null){
			criteria.andStartusetimeGreaterThanOrEqualTo(assetCustom.getStartusetime());
		}
		//截止启用日期
		if(assetCustom.getAbortstartusetime()!=null){
			criteria.andStartusetimeLessThanOrEqualTo(assetCustom.getAbortstartusetime());
		}
		//起始资产金额
		if(assetCustom.getValue()!=null){
			criteria.andValueGreaterThanOrEqualTo(assetCustom.getValue());
		}
		//截止资产金额
		if(assetCustom.getAbortvalue()!=null){
			criteria.andValueLessThanOrEqualTo(assetCustom.getValue());
		}
	   
		List<String> typeConditon=new ArrayList<>();
		List<AssetType> assetType=new ArrayList<>();
		List<AssetType> assetTypeMedium=new ArrayList<>();
		//对类型5进行判断
		//assetCustom.setType5("计算机设备");
		if(assetCustom.getType5()!=null&&assetCustom.getType5()!=""&&!assetCustom.getType5().equals("请选择")){
			criteria.andTypeEqualTo(assetCustom.getType5());
			 assets=assetMapper.selectByExample(example);
			 return assets;
		}
		//类型4进行判断
		if(assetCustom.getType4()!=null&&assetCustom.getType4()!=""&&!assetCustom.getType4().equals("请选择")){
			assetType=adminAssetTypeService.selectChildAssetTypeByName(assetCustom.getType4());
			if(assetType!=null&&assetType.size()>0){
				for (int i = 0; i < assetType.size(); i++) {
					typeConditon.add(assetType.get(i).getTypename());
					
				}
				criteria.andTypeIn(typeConditon);
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			else{
				criteria.andTypeEqualTo(assetCustom.getType4());
				assets=assetMapper.selectByExample(example);
				return assets;
			}			
		}
		
		//类型3进行判断
		if(assetCustom.getType3()!=null&&assetCustom.getType3()!=""&&!assetCustom.getType3().equals("请选择")){
			
			//获得第四级
			assetType=adminAssetTypeService.selectChildAssetTypeByName(assetCustom.getType3());
			if(assetType==null||assetType.size()==0){
				criteria.andTypeEqualTo(assetCustom.getType3());
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			else{
				//获得第五级
				for (int i = 0; i < assetType.size(); i++) {
					assetTypeMedium=adminAssetTypeService.selectChildAssetTypeByName(assetType.get(i).getTypename());
					if(assetTypeMedium==null||assetTypeMedium.size()==0){
						typeConditon.add(assetType.get(i).getTypename());
					}
					else{
						List<AssetType>assetTypeMedium1=new ArrayList<>();
						for (int j = 0; j < assetTypeMedium.size(); j++) {
							assetTypeMedium1=adminAssetTypeService.selectChildAssetTypeByName(assetTypeMedium.get(j).getTypename());
							if(assetTypeMedium1==null||assetTypeMedium1.size()==0){
								typeConditon.add(assetTypeMedium.get(j).getTypename());
							}
						}
					}
				}
				criteria.andTypeIn(typeConditon);
				assets=assetMapper.selectByExample(example);
				return assets;
			}		
		}
		
		//从类型2开始判断
		if(assetCustom.getType2()!=null&&assetCustom.getType2()!=""&&!assetCustom.getType2().equals("请选择")){
			//获得类型3
			assetType=adminAssetTypeService.selectChildAssetTypeByName(assetCustom.getType2());
			if(assetType==null||assetType.size()==0){
				criteria.andTypeEqualTo(assetCustom.getType2());
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			else{
				//获得类型4
				for (int i = 0; i < assetType.size(); i++) {
					assetTypeMedium=adminAssetTypeService.selectChildAssetTypeByName(assetType.get(i).getTypename());
					if(assetTypeMedium==null||assetTypeMedium.size()==0){
						typeConditon.add(assetType.get(i).getTypename());
					}
					else{
						//获得类型5
						for (int j = 0; j < assetTypeMedium.size(); j++) {
							List<AssetType> assetTypeMedium2=new ArrayList<>();
							assetTypeMedium2=adminAssetTypeService.selectChildAssetTypeByName(assetTypeMedium.get(j).getTypename());
							if(assetTypeMedium2==null||assetTypeMedium2.size()==0){
								typeConditon.add(assetTypeMedium.get(j).getTypename());
							}
							else{
								for (int k = 0; k < assetTypeMedium2.size(); k++) {
									typeConditon.add(assetTypeMedium2.get(k).getTypename());
								}
							}
						}
					}
					
				}
				
				criteria.andTypeIn(typeConditon);
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			
			
		}
	   
	   
		//从类型1开始判断
		if(assetCustom.getType1()!=null&&assetCustom.getType1()!=""&&!assetCustom.getType1().equals("请选择")){
			//获得类型2的集合
			assetType=adminAssetTypeService.selectChildAssetTypeByName(assetCustom.getType1());
			if(assetType==null||assetType.size()==0){
				criteria.andTypeEqualTo(assetCustom.getType1());
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			else{
				//获得类型3的集合
				for (int i = 0; i < assetType.size(); i++) {
					assetTypeMedium=adminAssetTypeService.selectChildAssetTypeByName(assetType.get(i).getTypename());
					if(assetTypeMedium==null||assetTypeMedium.size()==0){
						typeConditon.add(assetType.get(i).getTypename());
					}
					else{
						List<AssetType>assetTypeMedium4=new ArrayList<>();
						//获得类型4的集合
						for (int j = 0; j < assetTypeMedium.size(); j++) {
							
							assetTypeMedium4=adminAssetTypeService.selectChildAssetTypeByName(assetTypeMedium.get(j).getTypename());
							if(assetTypeMedium4==null||assetTypeMedium4.size()==0){
								typeConditon.add(assetTypeMedium.get(j).getTypename());
							}
							else{
								//获得类型5的集合
								List<AssetType>assetTypeMedium5=new ArrayList<>();
								for (int k = 0; k < assetTypeMedium4.size(); k++) {
									assetTypeMedium5=adminAssetTypeService.selectChildAssetTypeByName(assetTypeMedium4.get(k).getTypename());
									if(assetTypeMedium5==null||assetTypeMedium5.size()==0){
										typeConditon.add(assetTypeMedium4.get(k).getTypename());
									}
									else{
										for (int k2 = 0; k2 < assetTypeMedium5.size(); k2++) {
											typeConditon.add(assetTypeMedium5.get(k2).getTypename());
										}
									}
									
								}
							}
						}
					}
					
				}
				
				criteria.andTypeIn(typeConditon);
				assets=assetMapper.selectByExample(example);
				return assets;
				
			}
		}
		assets=assetMapper.selectByExample(example);		
		return assets;
		
		
	}
	
	
	/**
	 * 刘仁鹏  陈铮
	 *
	 * @param assetCustom 要查询的条件
	 *
	 * @return
	 */
	@Log(descrp="执行导出盘点资产操作",type="系统管理权限，资产管理权限")
	public List<Asset> getassetsbycondition(AssetCustom assetCustom){
		List<Asset> assets=new ArrayList<>();
		AssetExampleCustom example=new AssetExampleCustom();
		//example.setPage(page);
		AssetExampleCustom.Criteria criteria=example.createCriteria();
		///按使用状态查询
		if(assetCustom.getUsestate()!=null&&assetCustom.getUsestate()!=""){
			criteria.andUsestateEqualTo(assetCustom.getUsestate());
		}
		//按状态查询
	   if(assetCustom.getState()!=null&&assetCustom.getState()!=""){
		   criteria.andStateEqualTo(assetCustom.getState());
	   }
	   //按资产姓名查询
	   if(assetCustom.getName()!=null&&assetCustom.getName()!=""){
		   criteria.andNameEqualTo(assetCustom.getName());
	   }
	   //按资产代码查询
	   if(assetCustom.getCode()!=null&&assetCustom.getCode()!=""){
		   criteria.andCodeEqualTo(assetCustom.getCode());
	   }
	   //保管部门查询
	   if(assetCustom.getKeepdepartment()!=null&&assetCustom.getKeepdepartment()!=""){
		   criteria.andKeepdepartmentEqualTo(assetCustom.getKeepdepartment());
	   }
	   //保管人
	   if(assetCustom.getKeeper()!=null&&assetCustom.getKeeper()!=""){
		   criteria.andKeeperEqualTo(assetCustom.getKeeper());
	   }
	   //使用部门
	   if(assetCustom.getUsedepartment()!=null&&assetCustom.getUsedepartment()!=""){
		   
		   criteria.andUsedepartmentEqualTo(assetCustom.getUsedepartment());
	   }
	   //使用人\
	   if(assetCustom.getUser()!=null&&assetCustom.getUser()!=""){
		   criteria.andUserEqualTo(assetCustom.getUser());
	   }
	   //是否期初
	   if(assetCustom.getIsbegin1()!=null&&assetCustom.getIsbegin1()!=""){
		   if(assetCustom.getIsbegin1().equals("是")){
			   criteria.andIsbeginEqualTo(true);
		   }
		   else{
			   criteria.andIsbeginEqualTo(false);
		   }
	   }
		
		//报废年度
		if(assetCustom.getGhostyear()!=null&&assetCustom.getGhostyear()!=""){
			criteria.andGhostyearEqualTo(assetCustom.getGhostyear());
		}
		
	   //起始购置日期
		if(assetCustom.getPurchasetime()!=null){
			criteria.andPurchasetimeGreaterThanOrEqualTo(assetCustom.getPurchasetime());
		}
		
		//截止购置日期
		if(assetCustom.getAbortpurchasetime()!=null){
			criteria.andPurchasetimeLessThanOrEqualTo(assetCustom.getAbortpurchasetime());
		}
		//起始制卡日期
		if(assetCustom.getMakecardtime()!=null){
			criteria.andMakecardtimeGreaterThanOrEqualTo(assetCustom.getMakecardtime());
		}
		//截止制卡日期
		if(assetCustom.getAbortmakecardtime()!=null){
			criteria.andMakecardtimeLessThanOrEqualTo(assetCustom.getAbortmakecardtime());
		}
		//起始启用日期
		if(assetCustom.getStartusetime()!=null){
			criteria.andStartusetimeGreaterThanOrEqualTo(assetCustom.getStartusetime());
		}
		//截止启用日期
		if(assetCustom.getAbortstartusetime()!=null){
			criteria.andStartusetimeLessThanOrEqualTo(assetCustom.getAbortstartusetime());
		}
		//起始资产金额
		if(assetCustom.getValue()!=null){
			criteria.andValueGreaterThanOrEqualTo(assetCustom.getValue());
		}
		//截止资产金额
		if(assetCustom.getAbortvalue()!=null){
			criteria.andValueLessThanOrEqualTo(assetCustom.getValue());
		}
	   
		List<String> typeConditon=new ArrayList<>();
		List<AssetType> assetType=new ArrayList<>();
		List<AssetType> assetTypeMedium=new ArrayList<>();
		//对类型5进行判断
		//assetCustom.setType5("计算机设备");
		if(assetCustom.getType5()!=null&&assetCustom.getType5()!=""&&!assetCustom.getType5().equals("请选择")){
			criteria.andTypeEqualTo(assetCustom.getType5());
			 assets=assetMapper.selectByExample(example);
			 return assets;
		}
		//类型4进行判断
		if(assetCustom.getType4()!=null&&assetCustom.getType4()!=""&&!assetCustom.getType4().equals("请选择")){
			assetType=adminAssetTypeService.selectChildAssetTypeByName(assetCustom.getType4());
			if(assetType!=null&&assetType.size()>0){
				for (int i = 0; i < assetType.size(); i++) {
					typeConditon.add(assetType.get(i).getTypename());
					
				}
				criteria.andTypeIn(typeConditon);
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			else{
				criteria.andTypeEqualTo(assetCustom.getType4());
				assets=assetMapper.selectByExample(example);
				return assets;
			}			
		}
		
		//类型3进行判断
		if(assetCustom.getType3()!=null&&assetCustom.getType3()!=""&&!assetCustom.getType3().equals("请选择")){
			
			//获得第四级
			assetType=adminAssetTypeService.selectChildAssetTypeByName(assetCustom.getType3());
			if(assetType==null||assetType.size()==0){
				criteria.andTypeEqualTo(assetCustom.getType3());
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			else{
				//获得第五级
				for (int i = 0; i < assetType.size(); i++) {
					assetTypeMedium=adminAssetTypeService.selectChildAssetTypeByName(assetType.get(i).getTypename());
					if(assetTypeMedium==null||assetTypeMedium.size()==0){
						typeConditon.add(assetType.get(i).getTypename());
					}
					else{
						List<AssetType>assetTypeMedium1=new ArrayList<>();
						for (int j = 0; j < assetTypeMedium.size(); j++) {
							assetTypeMedium1=adminAssetTypeService.selectChildAssetTypeByName(assetTypeMedium.get(j).getTypename());
							if(assetTypeMedium1==null||assetTypeMedium1.size()==0){
								typeConditon.add(assetTypeMedium.get(j).getTypename());
							}
						}
					}
				}
				criteria.andTypeIn(typeConditon);
				assets=assetMapper.selectByExample(example);
				return assets;
			}		
		}
		
		//从类型2开始判断
		if(assetCustom.getType2()!=null&&assetCustom.getType2()!=""&&!assetCustom.getType2().equals("请选择")){
			//获得类型3
			assetType=adminAssetTypeService.selectChildAssetTypeByName(assetCustom.getType2());
			if(assetType==null||assetType.size()==0){
				criteria.andTypeEqualTo(assetCustom.getType2());
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			else{
				//获得类型4
				for (int i = 0; i < assetType.size(); i++) {
					assetTypeMedium=adminAssetTypeService.selectChildAssetTypeByName(assetType.get(i).getTypename());
					if(assetTypeMedium==null||assetTypeMedium.size()==0){
						typeConditon.add(assetType.get(i).getTypename());
					}
					else{
						//获得类型5
						for (int j = 0; j < assetTypeMedium.size(); j++) {
							List<AssetType> assetTypeMedium2=new ArrayList<>();
							assetTypeMedium2=adminAssetTypeService.selectChildAssetTypeByName(assetTypeMedium.get(j).getTypename());
							if(assetTypeMedium2==null||assetTypeMedium2.size()==0){
								typeConditon.add(assetTypeMedium.get(j).getTypename());
							}
							else{
								for (int k = 0; k < assetTypeMedium2.size(); k++) {
									typeConditon.add(assetTypeMedium2.get(k).getTypename());
								}
							}
						}
					}
					
				}
				
				criteria.andTypeIn(typeConditon);
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			
			
		}
	   
	   
		//从类型1开始判断
		if(assetCustom.getType1()!=null&&assetCustom.getType1()!=""&&!assetCustom.getType1().equals("请选择")){
			//获得类型2的集合
			assetType=adminAssetTypeService.selectChildAssetTypeByName(assetCustom.getType1());
			if(assetType==null||assetType.size()==0){
				criteria.andTypeEqualTo(assetCustom.getType1());
				assets=assetMapper.selectByExample(example);
				return assets;
			}
			else{
				//获得类型3的集合
				for (int i = 0; i < assetType.size(); i++) {
					assetTypeMedium=adminAssetTypeService.selectChildAssetTypeByName(assetType.get(i).getTypename());
					if(assetTypeMedium==null||assetTypeMedium.size()==0){
						typeConditon.add(assetType.get(i).getTypename());
					}
					else{
						List<AssetType>assetTypeMedium4=new ArrayList<>();
						//获得类型4的集合
						for (int j = 0; j < assetTypeMedium.size(); j++) {
							
							assetTypeMedium4=adminAssetTypeService.selectChildAssetTypeByName(assetTypeMedium.get(j).getTypename());
							if(assetTypeMedium4==null||assetTypeMedium4.size()==0){
								typeConditon.add(assetTypeMedium.get(j).getTypename());
							}
							else{
								//获得类型5的集合
								List<AssetType>assetTypeMedium5=new ArrayList<>();
								for (int k = 0; k < assetTypeMedium4.size(); k++) {
									assetTypeMedium5=adminAssetTypeService.selectChildAssetTypeByName(assetTypeMedium4.get(k).getTypename());
									if(assetTypeMedium5==null||assetTypeMedium5.size()==0){
										typeConditon.add(assetTypeMedium4.get(k).getTypename());
									}
									else{
										for (int k2 = 0; k2 < assetTypeMedium5.size(); k2++) {
											typeConditon.add(assetTypeMedium5.get(k2).getTypename());
										}
									}
									
								}
							}
						}
					}
					
				}
				
				criteria.andTypeIn(typeConditon);
				assets=assetMapper.selectByExample(example);
				return assets;
				
			}
		}
		assets=assetMapper.selectByExample(example);		
		return assets;
		
		
	}
	
	
	@Test
	public void getassetsbyconditionwithpage(){
		List<Asset> assets=new ArrayList<>();
		AssetExampleCustom example=new AssetExampleCustom();
		//example.setPage(page);
		AssetExampleCustom.Criteria criteria=example.createCriteria();
		//criteria.andUsestateEqualTo("在用");
		criteria.andUserEqualTo("刘建波");
		//example.or(criteria);
		assets=assetMapper.selectByExample(example);
		
		System.out.println(assets.size());
	
	}
		
}
