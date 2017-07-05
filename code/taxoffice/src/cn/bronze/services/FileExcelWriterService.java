package cn.bronze.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bronze.entities.Asset;
import cn.bronze.entities.CustomExcelObject;
import cn.bronze.log.Log;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceContext;
import cn.bronze.util.excel.ResourceHasClosedException;
import cn.bronze.util.file.FileUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@Service
public class FileExcelWriterService {
	
	
	@Test
	public void testExportToExcel(){
		CustomExcelObject<Asset, String> excelObject = new CustomExcelObject<Asset,String>(); 
		excelObject.setClazz(Asset.class);
		//excelObject.setFile(new File("e://资产信息于海强.xls"));
		List<Asset> objects = new LinkedList<Asset>();//list集合
		objects.add(new Asset());
		excelObject.setObjects(objects);
		try {
			exportToExcel(excelObject);
		} catch (ResourceHasClosedException e) {
			// 
			e.printStackTrace();
		} catch (ParamCanNotBeNullException e) {
			// 
			e.printStackTrace();
		}
	}
	
	
	
	
	public void exportToExcel(CustomExcelObject excelObject) throws
	ResourceHasClosedException
	, ParamCanNotBeNullException{
	    ResourceContext context;
		try {
			context = new ResourceContext(excelObject.getClazz());
			List<Object> list = excelObject.getObjects();
			System.out.println("service"+list.size());
			String path = System.getProperty("contextPath")
					+File.separator+"attached"
					+File.separator+"File"
					+File.separator+"excel"
					+File.separator;
			String filename = UUID.randomUUID().toString()+".xls";
			FileUtil.createFile(path);
			File file = new File(path+filename);
			System.out.println(path+filename);
			
			
			List<String> tailList = excelObject.getTailStrings();
			boolean success = context.write(list,tailList, file);
			Map<String, Object> map = new HashMap<String, Object>();
			if(excelObject.getExceptionMsg()==null){
				excelObject.setExceptionMsg(map);
			}
			map.put("success",success);
			excelObject.setFile(file);
			context.close();
		} catch (FileNotFoundException e) {
			// 
			e.printStackTrace();
		}
		
		
		
	}
	
}
