package com.linkpal.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerIntercepter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj)
			throws Exception {
		// TODO Auto-generated method stub
		 String requestURI = httpservletrequest.getRequestURI();  
         if(requestURI.indexOf("Home") > 0){
             //说明处在编辑的页面  
             HttpSession session = httpservletrequest.getSession();  
             String username = (String) session.getAttribute("loginSession");
             System.out.println(username+"*************");
             if(username!=null){  
                 //登陆成功的用户  
                 return true;  
             }else{  
                //没有登陆，转向登陆界面  
            	 httpservletrequest.getRequestDispatcher("/login.jsp").forward(httpservletrequest,httpservletresponse);
               return false;  
             }
         }else{
             return true;
         }
	}

}
