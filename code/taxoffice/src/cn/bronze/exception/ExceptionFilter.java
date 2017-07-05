/**
* 
* <p>Description: </p>
* <p>Company: 鐕曞北澶у</p> 
* @author   浜庢捣寮�
* @date       2016-3-30
*/
package cn.bronze.exception;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** * @author  浣滆� E-mail: 
 * @date 鍒涘缓鏃堕棿锛�016-3-30 涓嬪崍9:32:54 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
/**
 * 
 * <p>Description: </p>
 * <p>Company: 鐕曞北澶у</p> 
 * @author   浜庢捣寮�
 * @date       2016-3-30
 */
public class ExceptionFilter implements Filter {

	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		int status = ((HttpServletResponse) response).getStatus();
		//response = ((HttpServletResponse) response);
		System.err.println(status);
		
		if(status/100==4||status/100==5)
		{
			String message = "<h1>鍑洪敊浜嗭紒锛侊紒</h1>";
			
			((HttpServletRequest)request).getRequestDispatcher("/WEN-INF/jsp/error.jsp?message="+message).forward(request, response);
			//((HttpServletResponse)response).sendRedirect(");
			//response.getWriter().print(message);
		}
		//System.err.println("鎵ц鍒拌繖閲岋紝璇存槑鍙互鑾峰彇杩斿洖鍊�鏈�師鐢熺殑杩囨护鍣�);
		chain.doFilter(request, response);
	}

	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
