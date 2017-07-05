package cn.bronze.util.db;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import cn.bronze.log.Log;
public class Recover {
	/**
	 * 于立波
	 * 根据sql文件还原数据库
	 * fpath  还原路径
	 */
	@Log(descrp="执行还原数据库记录操作",type="系统管理权限")
	public  void recover(
			String filePath1
			) {      
        try {      
            //String fPath = "c:/test.sql";    
            Runtime rt = Runtime.getRuntime();      
            
    	    Properties prop = new Properties();   
		    InputStream inm=this.getClass().getResourceAsStream("/db.properties");
	        //InputStream inm= Object.class.getResourceAsStream("/db.properties");
	        prop.load(inm);   
	        String use= prop.getProperty("jdbc.username").trim();  
            String pwd = prop.getProperty("jdbc.password").trim(); 
           // 调用 mysql 的 cmd:      
            Process child = rt.exec("mysql.exe -u"+use+" -p"+pwd+" taxoffice ");      
            OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流      
            String inStr;      
            StringBuffer sb = new StringBuffer("");      
            String outStr;      
            BufferedReader br = new BufferedReader(new InputStreamReader(      
                    new FileInputStream(filePath1), "utf8"));      
            while ((inStr = br.readLine()) != null) {      
                sb.append(inStr + "\r\n");      
            }      
            outStr = sb.toString();      
     
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");      
            writer.write(outStr);      
            // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免      
            writer.flush();      
            // 别忘记关闭输入输出流      
            out.close();      
            br.close();      
            writer.close();      
     
            System.out.println("恢复完成");      
     
        } catch (Exception e) {      
            e.printStackTrace();      
        }      
     
    } 

}
