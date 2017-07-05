package cn.bronze.util.excel;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyFileHelper {
	public static boolean isExcel2003(InputStream is) {
	    try {
	      new HSSFWorkbook(is);
	    } catch (Exception e) {
	      return false;
	    }
	    return true;
	  }



	public static boolean isExcel2007(InputStream is) {
	    try {
	      new XSSFWorkbook( is);
	    } catch (Exception e) {
	      return false;
	    }
	    return true;
	  }
}
