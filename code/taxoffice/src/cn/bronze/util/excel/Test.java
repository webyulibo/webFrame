package cn.bronze.util.excel;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import cn.bronze.entities.Asset;

public class Test {

	public static void main(String[] args) {

		PropertiesUtil boudle = new PropertiesUtil(Asset.class);
		System.out.println(Asset.class.getName());
		List<Object> keys = boudle.getKeyList();
		for (Object object : keys) {
			System.out.println(object);
		}
	}

}
