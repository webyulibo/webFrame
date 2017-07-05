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
public class AdminAssetIOService {
	
	public List<Asset> AssetInput(String filePath) throws FileNotFoundException, ParamCanNotBeNullException, ResourceHasClosedException, NullPointerException, EntityRemarkNotFoundException, EntityIllegalRemarkException{
		File file = new File(filePath);
		ResourceContext context = new ResourceContext(Asset.class);
		context.setReadFile(file);
		context.getRemark();
		List<Asset> list = (List<Asset>) context.getEntityList();
		if(list==null){
			System.out.println("未查询到数据");
			return null;
		}
		return list;
	}
	

}
