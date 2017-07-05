package cn.bronze.util.db;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class Backup {
	/**
	 * 于立波
	 * 备份数据库
	 * path 备份路径
	 */
	public  void backup(
			String path
			) {
		  try {
		   Runtime rt = Runtime.getRuntime();
		   
		   
		    Properties prop = new Properties();   
		    InputStream inm=this.getClass().getResourceAsStream("/db.properties");
	        //InputStream inm= Object.class.getResourceAsStream("/db.properties");
	        prop.load(inm);   
	        String use= prop.getProperty("jdbc.username").trim();  
            String pwd = prop.getProperty("jdbc.password").trim();  
		   
		   
		   
            //D:\mysql
		   // 调用 调用mysql的安装目录的命令
		  // Process child = rt.exec("D://mysql//bin//mysqldump -h localhost -uroot -proot  taxoffice");
		   //Process child = rt.exec("mysqldump -h localhost -uroot -proot  taxoffice --tables t_asset t_assetborrow t_assettype t_authority t_back t_checkresult t_checkresultdetail t_department t_log t_maintain t_message t_mobilizepeople t_possess t_role t_roleandauth t_scrap t_user");
            Process child = rt.exec("mysqldump -h localhost -u"+use+" -p"+pwd+"  taxoffice --tables t_asset t_assetborrow t_assettype t_authority t_back t_checkresult t_checkresultdetail t_department t_log t_maintain t_message t_mobilizepeople t_possess t_role t_roleandauth t_scrap t_user");
          // Process child = rt.exec("mysqldump -h localhost -uroot -p"+pwd+"  taxoffice");
		   // 设置导出编码为utf-8。这里必须是utf-8
		   // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
		   InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

		   InputStreamReader xx = new InputStreamReader(in, "utf-8");
		   // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码

		   String inStr;
		   StringBuffer sb = new StringBuffer("");
		   String outStr;
		   // 组合控制台输出信息字符串
		   BufferedReader br = new BufferedReader(xx);
		   while ((inStr = br.readLine()) != null) {
		    sb.append(inStr + "\r\n");
		   }
		   outStr = sb.toString();

		   // 要用来做导入用的sql目标文件：
		   FileOutputStream fout = new FileOutputStream(path);
		   OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
		   writer.write(outStr);
		   writer.flush();
		   in.close();
		   xx.close();
		   br.close();
		   writer.close();
		   fout.close();

		   System.out.println("备份完成");

		  } catch (Exception e) {
		   e.printStackTrace();
		  }

		 }
}
