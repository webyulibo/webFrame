package cn.bronze.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

public class FileDownload {

	public static void download(HttpServletResponse resp,File file,String filename){
		
		resp.reset();
        resp.setContentType("application/octet-stream");
        try {
			resp.addHeader("Content-Disposition", "attachment;filename=\"" + new String(filename.getBytes("utf-8"),"ISO-8859-1")+"\"");
		} catch (UnsupportedEncodingException e1) {
			// 
			e1.printStackTrace();
		}
        InputStream fis = null;
		try {
			fis = new BufferedInputStream(new FileInputStream(file));
	         byte[] buffer = new byte[fis.available()];
	         fis.read(buffer);
	         fis.close();
	         resp.addHeader("Content-Length", "" + file.length());
	         OutputStream toClient = new BufferedOutputStream(resp.getOutputStream());
	         
	         resp.setContentType("application/octet-stream");
	         toClient.write(buffer);
	         toClient.flush();
	         toClient.close();
		} catch (Exception e) {
			return ;
		}
	}

}
