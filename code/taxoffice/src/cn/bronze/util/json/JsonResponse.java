/**
 * 
 */
package cn.bronze.util.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * json串的输出
 * @author 董浩
 * 2016年6月18日
 */
public class JsonResponse {
	
	/**
	 * 输出单个Json串
	 * @author 董浩
	 * 2016年6月18日 下午10:42:40
	 * @param response
	 * @param jsonObject
	 * @throws IOException
	 */
	public static void PrintJsonOne(HttpServletResponse response,JSONObject jsonObject) throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(jsonObject);
	}
	
	/**
	 * 输出json数组
	 * @author 董浩
	 * 2016年6月18日 下午10:43:38
	 * @param response
	 * @param jsonObject
	 * @throws IOException
	 */
	public static void PrintJsonList(HttpServletResponse response,JSONArray jsonArray)throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	

}
