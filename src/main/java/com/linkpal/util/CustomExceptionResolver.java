package com.linkpal.util;

import com.linkpal.model.CustomException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    /** 
     * 系统抛出的异常 
     * @param httpServletRequest 
     * @param httpServletResponse 
     * @param o 
     * @param e 系统抛出的异常 
     * @return 
     */  
    @Override  
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       // 解析出异常类型  
        CustomException customException = null;
        // 若该异常类型是系统自定义的异常，直接取出异常信息在错误页面展示即可。  
        if(e instanceof CustomException){  
            customException = (CustomException)e;  
        }else{  
            // 如果不是系统自定义异常，构造一个系统自定义的异常类型，信息为“未知错误”  
            customException = new CustomException("未知错误");  
        }  
        //错误信息  
        String message = customException.getMessage();  
        ModelAndView modelAndView = new ModelAndView();  
        //将错误信息传到页面  
        modelAndView.addObject("message",message);  
        //指向错误页面  
        modelAndView.setViewName("error");  
        return modelAndView;  
    }  
}  