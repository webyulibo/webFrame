package cn.bronze.controllers.converter;

import java.io.UnsupportedEncodingException;

import org.springframework.core.convert.converter.Converter;

public class StringToByteConverter implements Converter<String, byte[]>{

	public static void main(String[] args) {

	}
	
	public StringToByteConverter(String charset){
		this.charset = charset;
	}

	private String charset;
	@Override
	public byte[] convert(String arg0) {
		
		try {
			return arg0.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			// 
			e.printStackTrace();
		}
		return null;
	}

}
