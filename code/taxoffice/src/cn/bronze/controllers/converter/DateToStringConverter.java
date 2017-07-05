/**
 * 
 */
package cn.bronze.controllers.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 董浩
 * 2016年6月23日
 */
public class DateToStringConverter implements Converter<Date, String>{

	
	@Override
	public String convert(Date date) {
		String time;  
        SimpleDateFormat formater = new SimpleDateFormat();  
        formater.applyPattern("yyyy-MM-dd hh:mm:ss");  
        time = formater.format(date);  
        return time; 
		
	}

}
