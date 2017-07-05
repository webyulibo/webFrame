package cn.bronze.controllers.converter;

import java.io.UnsupportedEncodingException;

import org.springframework.core.convert.converter.Converter;

public class ByteToStringConverter implements Converter<byte[], Object>{

	public static void main(String[] args) {

	}

	@Override
	public Object convert(byte[] arg0) {
		try {
			return new String(arg0,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// 
			e.printStackTrace();
		}
		return null;
	}

}
