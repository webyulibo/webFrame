/**
 * 
 */
package cn.bronze.util.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.junit.Test;

import cn.bronze.entities.Asset;
import cn.bronze.util.excel.EntityIllegalRemarkException;
import cn.bronze.util.excel.EntityRemarkNotFoundException;
import cn.bronze.util.excel.ParamCanNotBeNullException;
import cn.bronze.util.excel.ResourceContext;
import cn.bronze.util.excel.ResourceHasClosedException;
import cn.bronze.util.file.FileUtil;

/**
 * Excel输入与输出
 * @author 董浩
 * 2016年6月19日
 */
public class AssetIOUtil {
	
	/**
	 * 
	 * 
	 * Excel文件导入
	 * @author 董浩
	 * 2016年6月19日 下午8:21:39
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParamCanNotBeNullException
	 * @throws ResourceHasClosedException
	 * @throws NullPointerException
	 * @throws EntityRemarkNotFoundException
	 * @throws EntityIllegalRemarkException
	 */
	public static List<Asset> AssetInput(String filePath) throws FileNotFoundException, ParamCanNotBeNullException, ResourceHasClosedException, NullPointerException, EntityRemarkNotFoundException, EntityIllegalRemarkException{
		
		String serverPath = System.getProperty("serverPath");
		//FileUtil.createFile(filePath);
		File file = new File(serverPath+File.separator+"webapps"+File.separator+filePath);
		ResourceContext context = new ResourceContext(Asset.class);
		context.setReadFile(file);
		context.getRemark();
		List<Asset> list = null;
		list = (List<Asset>) context.getEntityList();
		if(list==null){
			System.out.println("未查询到数据");
			return null;
		}
		return list;
	}
	
	
	/*public static List<Asset> AssetInput(String filePath,String path) throws FileNotFoundException, ParamCanNotBeNullException, ResourceHasClosedException, NullPointerException, EntityRemarkNotFoundException, EntityIllegalRemarkException{
		
		String serverPath = System.getProperty("serverPath");
		FileUtil.createFile(path);
		File file = new File(serverPath+filePath);
		ResourceContext context = new ResourceContext(Asset.class);
		context.setReadFile(file);
		context.getRemark();
		List<Asset> list = (List<Asset>) context.getEntityList();
		if(list==null){
			System.out.println("未查询到数据");
			return null;
		}
		return list;
	}*/
	
	
	
	public static void main(String[] args){
		try {
			AssetIOUtil.AssetInput("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParamCanNotBeNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceHasClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityRemarkNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityIllegalRemarkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	/**
	 * Excel文件导出
	 * @author 董浩
	 * 2016年6月19日 下午8:30:30
	 * @param list
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParamCanNotBeNullException
	 * @throws ResourceHasClosedException
	 */
	public static boolean AssetOutput(List<Asset> list,String filePath) throws FileNotFoundException, ParamCanNotBeNullException, ResourceHasClosedException{
		ResourceContext context = new ResourceContext(Asset.class);
		boolean isSuccess = context.write(list, new File(filePath));
		return isSuccess;
	}
	
	
	
	

}
