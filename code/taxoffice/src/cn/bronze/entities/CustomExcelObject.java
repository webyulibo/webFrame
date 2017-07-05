package cn.bronze.entities;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;

public class CustomExcelObject <TEntity,TExcept>{
	
	//文件
	private File file;
	
	//对应的类
	private Class clazz;
	
	//标题
	@Deprecated
	private List<String> titleStrings;
	
	//内容
	private List<TEntity> objects;
	
	//尾部
	private List<String> tailStrings;
	
	//异常信息
	private Map<String, TExcept> exceptionMsg;

	

	public File getFile() {
		
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	


	@Deprecated
	public List<String> getTitleStrings() {
		return titleStrings;
	}

	@Deprecated
	public void setTitleStrings(List<String> titleStrings) {
		this.titleStrings = titleStrings;
	}

	
	public List<String> getTailStrings() {
		return tailStrings;
	}

	public void setTailStrings(List<String> tailStrings) {
		this.tailStrings = tailStrings;
	}

	public List<TEntity> getObjects() {
		return objects;
	}

	public void setObjects(List<TEntity> objects) {
		this.objects = objects;
	}

	public Map<String, TExcept> getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(Map<String, TExcept> exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	

}
