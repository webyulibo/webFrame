/**
 * 
 */
package cn.bronze.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import cn.bronze.entities.Asset;
import cn.bronze.util.excel.EntityIllegalRemarkException;
import cn.bronze.util.excel.EntityRemarkNotFoundException;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceContext;
import cn.bronze.util.excel.ResourceHasClosedException;

/**
 * @author 董浩
 * 2016年6月19日
 */
public class DHTestExcelService {
	
	public static void main(String[] args) throws FileNotFoundException, ParamCanNotBeNullException, ResourceHasClosedException, NullPointerException, EntityRemarkNotFoundException, EntityIllegalRemarkException{
		File file = new File("D://JavaTest//taxoffice//1.需求分析+界面设计//1.2.相关表单//资产信息.xls");
		ResourceContext context = new ResourceContext(Asset.class);
		context.setReadFile(file);
		context.getRemark();
		@SuppressWarnings("unchecked")
		List<Asset> list = (List<Asset>) context.getEntityList();
		if(list==null){
			System.out.println("文件读取出错");
			return;
		}
		System.out.println(list.size());
		boolean isSuccess = context.write(list, new File("F://资产信息.xls"));
		System.out.println(isSuccess);
	}
	
	
	
	

}
