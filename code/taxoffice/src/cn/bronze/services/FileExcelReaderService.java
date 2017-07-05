package cn.bronze.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.entities.Asset;
import cn.bronze.entities.CustomExcelObject;
import cn.bronze.util.excel.EntityIllegalRemarkException;
import cn.bronze.util.excel.EntityRemarkNotFoundException;
import cn.bronze.util.excel.HResourceContext;
import cn.bronze.util.excel.MyFileHelper;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceContext;
import cn.bronze.util.excel.ResourceHasClosedException;
  

/**
 * @author 于海强
 * 2016-6-21  上午10:12:34
 * excel文件读取类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class FileExcelReaderService {

	
	
	@Test
	public void testImportFromExcel() throws 
	FileNotFoundException
	, ParamCanNotBeNullException{
		CustomExcelObject<Asset,String> excelObject = new CustomExcelObject<Asset,String>();
		excelObject.setClazz(Asset.class);
		ResourceContext context = new ResourceContext(excelObject.getClass());
		File file = new File("E://税务局固资管理//taxoffice//1.需求分析+界面设计//1.2.相关表单//工作簿1.xlsx");
		System.out.println(MyFileHelper.isExcel2003(new FileInputStream(file)));
		System.out.println(MyFileHelper.isExcel2007(new FileInputStream(file)));
		excelObject.setFile(file);
		this.importFromExcel(excelObject);
		System.out.println(excelObject.getObjects().size());
		try {
			context.close();
		} catch (ResourceHasClosedException e) {
			// 
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void importFromExcel( CustomExcelObject excelObject) throws FileNotFoundException  
	{
		File file = excelObject.getFile();
		if(MyFileHelper.isExcel2007(new FileInputStream(file))){
			try {
				ResourceContext context = new ResourceContext(excelObject.getClazz());
				context.setReadFile(file);
				Map<String, String> resultMap = context.isTitleIllegal();
				if(resultMap!=null&&resultMap.size()>0){
					Map<String, Object> map = new HashMap<String,Object>(resultMap.size());
					for(Entry<String,String> s:resultMap.entrySet()) {
						map.put(s.getKey(), s.getValue());
					}
					excelObject.setExceptionMsg(map);
					
				}
				List list = context.getEntityList();
				excelObject.setObjects(list);
				context.close();
			}  catch (FileNotFoundException e) {
				/**
				 *  这个异常时编码异常，即你传入的File是错误的，典型当指定写入的文件出现中文时，可能
				 * 找不到File，报这个错误，你需要看你的代码是不是错了
				 */
				e.printStackTrace();
			} catch (ParamCanNotBeNullException e) {
				// 这个异常也是编码异常，你需要检查你的参数传入的都是否非空
				e.printStackTrace();
			} catch (ResourceHasClosedException e) {
				/**
				 * 当resourcecontext已经调用close后，你在调用，则会出错
				 */
				e.printStackTrace();
			} catch (NullPointerException e) {
				// 空指针也是编码错误
				e.printStackTrace();
			} catch (EntityRemarkNotFoundException e) {
				/*
				 * 
				 *  检查cn.bronze.entities下对应的实体，有没有相关的配置文件
				 *  例如Asset 对应Asset.properties
				 */
				
				e.printStackTrace();
			} catch (EntityIllegalRemarkException e) {
				// 检查相关实体配置文件 是否正确，有没有出现相同的remark
				e.printStackTrace();
			}
		}
		
			if(MyFileHelper.isExcel2003(new FileInputStream(file))){
				
				try {
					HResourceContext context = new HResourceContext(excelObject.getClazz());
					context.setReadFile(file);
					Map<String, String> resultMap = context.isTitleIllegal();
					if(resultMap!=null&&resultMap.size()>0){
						Map<String, Object> map = new HashMap<String,Object>(resultMap.size());
						for(Entry<String,String> s:resultMap.entrySet()) {
							map.put(s.getKey(), s.getValue());
						}
						excelObject.setExceptionMsg(map);
						
					}
					List list = context.getEntityList();
					excelObject.setObjects(list);
					context.close();
				}  catch (FileNotFoundException e) {
					/**
					 *  这个异常时编码异常，即你传入的File是错误的，典型当指定写入的文件出现中文时，可能
					 * 找不到File，报这个错误，你需要看你的代码是不是错了
					 */
					e.printStackTrace();
				} catch (ParamCanNotBeNullException e) {
					// 这个异常也是编码异常，你需要检查你的参数传入的都是否非空
					e.printStackTrace();
				} catch (ResourceHasClosedException e) {
					/**
					 * 当resourcecontext已经调用close后，你在调用，则会出错
					 */
					e.printStackTrace();
				} catch (NullPointerException e) {
					// 空指针也是编码错误
					e.printStackTrace();
				} catch (EntityRemarkNotFoundException e) {
					/*
					 * 
					 *  检查cn.bronze.entities下对应的实体，有没有相关的配置文件
					 *  例如Asset 对应Asset.properties
					 */
					
					e.printStackTrace();
				} catch (EntityIllegalRemarkException e) {
					// 检查相关实体配置文件 是否正确，有没有出现相同的remark
					e.printStackTrace();
				}
				
			}
			
			
			
			
			
	
		
	}
	
	
	
	
}
