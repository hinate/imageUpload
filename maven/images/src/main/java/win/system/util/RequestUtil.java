package win.system.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * request工具类
 * 
 * 
 */
public class RequestUtil {

	private static ServletContext servletContext = null;
	private static ServletConfig servletConfig = null;

	/**
	 * 获得请求路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		if (requestPath.indexOf("&") > -1) {// 去掉其他参数
			requestPath = requestPath.substring(0, requestPath.indexOf("&"));
		}
		requestPath = requestPath.substring(request.getContextPath().length()+1);// 去掉项目路径
		return requestPath;
	}
	
	public static HttpServletRequest getRequest(){
		ServletRequestAttributes ra = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
		if(ra == null){
			return null;
		}
		
		HttpServletRequest request = ra.getRequest();
		return request;
	}
	
	
	public static ServletContext getServletContext(){
		return servletContext;
	}

	
	public static void setServletContext(ServletContext sc){
		servletContext = sc;
	}


	public static ServletConfig getServletConfig() {
		return servletConfig;
	}


	public static void setServletConfig(ServletConfig sc) {
		servletConfig = sc;
	}
	

}

