package cn.bronze.listener;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.bronze.services.FileTextReaderService;

public class TaxOfficeInitListener  implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.setProperty("contextPath",sce.getServletContext().getRealPath(""));
		/*String context =  sce.getServletContext().getContextPath();
		System.out.println(context);
		System.out.println(System.getProperty("user.dir"));
		String path = sce.getServletContext().getRealPath("");
		System.out.println("path:"+path);
		String serverpath = path.substring(0, path.indexOf(context));*/
		String root = sce.getServletContext().getRealPath("");

		String serverpath = root.substring(0,root.lastIndexOf(File.separator));
		 serverpath = root.substring(0,serverpath.lastIndexOf(File.separator));
		System.setProperty("serverPath", serverpath);
		//System.out.println("涓婁笅鏂囪矾寰�+System.getProperty("contextPath"));
		//System.out.println("鏈嶅姟鍣ㄨ矾寰�+System.getProperty("serverPath"));
		/*Field[] fields = Charset.class.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			if(fields[i].getName().startsWith("defaultCharset")){
				fields[i].setAccessible(true);
				try {
					fields[i].set(Charset.class,Charset.forName("UTF-8"));
				} catch (IllegalArgumentException e) {
					// 
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// 
					e.printStackTrace();
				}
			}
		}*/
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
