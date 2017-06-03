package org.smart4j.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ConfigHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CodecUtil;
import org.smart4j.framework.util.JsonUtil;
import org.smart4j.framework.util.ReflectionUtil;
import org.smart4j.framework.util.StreamUtil;
import org.smart4j.framework.util.StringUtil;

/**
 * 请求转发器
 *
 * @since 1.0.0
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        HelperLoader.init();

        ServletContext servletContext = servletConfig.getServletContext();

        registerServlet(servletContext);
    }

    private void registerServlet(ServletContext servletContext) {
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping("/index.jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping("/favicon.ico");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String requestMethod = request.getMethod().toLowerCase();
            String requestPath = request.getPathInfo();
            Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
            if (handler != null) {
                Class<?> controllerClass = handler.getControllerClass();
                Object controllerBean = BeanHelper.getBean(controllerClass);

                //创建请求参数对象
                Map<String, Object> paramMap=new HashedMap<String, Object>();
                Enumeration<String> paramNames=request.getParameterNames();
                while(paramNames.hasMoreElements()){
                	String paraName=paramNames.nextElement();
                	String paraValue=request.getParameter(paraName);
                	paramMap.put(paraName, paraValue);
                }
                String body=CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
                if(StringUtil.isNotEmpty(body)){
                	String[] params=StringUtil.splitString(body, "&");
                	if(ArrayUtil.isNotEmpty(params)){
                		for(String param:params){
                			String[] array=StringUtil.splitString(body, "=");
                			if(ArrayUtil.isNotEmpty(array)&&array.length==2){
                				String paraName=array[0];
                            	String paraValue=array[1];
                            	paramMap.put(paraName, paraValue);
                			}
                		}
                	}
                }
                               
                Param param=new Param(paramMap);
                //调用action方法
                Method actionMethod = handler.getActionMethod();
                Object result=ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
                //处理action返回值
                if(result instanceof View){
                	View view=(View) result;
                	String path = view.getPath();
                    if (StringUtil.isNotEmpty(path)) {
                        if (path.startsWith("/")) {
                            response.sendRedirect(request.getContextPath() + path);
                        } else {
                            Map<String, Object> model = view.getModel();
                            for (Map.Entry<String, Object> entry : model.entrySet()) {
                                request.setAttribute(entry.getKey(), entry.getValue());
                            }
                            request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, response);
                        }
                    }
                }else if(result instanceof Data){
                	    Data data=(Data) result;
                	    Object model = data.getModel();
                        if (model != null) {
                            response.setContentType("application/json");
                            response.setCharacterEncoding("UTF-8");
                            PrintWriter writer = response.getWriter();
                            String json = JsonUtil.toJson(model);
                            writer.write(json);
                            writer.flush();
                            writer.close();
                        }
                   }
              }
    }
}
