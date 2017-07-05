package cn.bronze.util.file;

import java.io.File;


public class FileUtil {

	
	
	public static void createFile(String filepath){
		File file = new File(filepath);
		if(!file.exists()){
			String parent = file.getParent();
			createFile(parent);
			file.mkdir();
		}
	}

}
