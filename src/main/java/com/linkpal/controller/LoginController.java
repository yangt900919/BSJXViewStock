package com.linkpal.controller;

import com.linkpal.service.IUserService;
import com.linkpal.util.MenuContext;
import com.linkpal.util.GlobalVarContext;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;

    /*@RequestMapping(value = "/Login")
    @POST
    public ModelAndView Login(HttpServletRequest request, String FName, String FPassword) {
        ModelAndView mav;
        int userid;
        if ((userid = userService.isAuthorizedUser(FName, FPassword)) > 0) {
            request.getSession().setAttribute("loginSession", FName);
            request.getSession().setAttribute("userid", userid);
            mav = new ModelAndView("/web/index");
        }else {
            mav = new ModelAndView("/login");
        }
        return mav;
    }*/


    @RequestMapping(value = "/Login")
    @POST
    public ModelAndView Login(HttpServletRequest request,@RequestParam("FName") String FName, @RequestParam("FPassword") String FPassword) {
        ModelAndView mav = null;
        boolean authorized = userService.isAuthorizedUser(FName, FPassword)>0? true:false;
        if (authorized) {
            mav = new ModelAndView("/home");
            List<Map<String, Object>> mlist = null;
            try {
                mlist = MenuContext.AnMenuConfig(request.getRealPath("/WEB-INF/classes/"));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            //System.out.println(mlist);
            // request.getSession().setAttribute("pList", userService.getPermissionList(FName));
            //mav.addObject("pList",);
            mav.addObject("username", FName);
            GlobalVarContext.user=this.userService.getDetail(FName);
            mav.addObject("menuList", mlist);
            return mav;
        } else {
            mav = new ModelAndView("/login");
            mav.addObject("username", FName);
            mav.addObject("msg", "用户名或密码错误");
            return mav;
        }
    }
}
