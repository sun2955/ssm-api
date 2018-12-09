package com.sun.common.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 拦截器，拦截未登录用户
 * @author Administrator
 *
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private static final String LOGIN_URL = "/myblog/login";  
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);  
		// 从session 里面获取用户名的信息  
        Object obj = session.getAttribute("loginUser");  
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆  
        System.out.println("——————————————————————————————————————————————————进入过滤器——————————————————————————————————————————————————");
        if (obj == null || "".equals(obj.toString())) {  
        	resp.sendRedirect(LOGIN_URL);//返回true进行重定向
        	return false;
        } 
		return true;
	}

}
