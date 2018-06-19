package com.linkpal.controller;

import com.linkpal.model.Permission;
import com.linkpal.model.Role;
import com.linkpal.service.IRoleService;
import com.linkpal.service.IUserService;
import com.linkpal.util.MD5Util;
import com.linkpal.util.MenuContext;
import com.linkpal.util.GlobalVarContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

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
        /*boolean authorized = userService.isAuthorizedUser(FName, FPassword)>0? true:false;
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
        }*/

        //得到当前用户
        Subject subject = SecurityUtils.getSubject();
        //通过前台传递过来的用户名和密码生成token
        UsernamePasswordToken token = new UsernamePasswordToken(FName, MD5Util.getResult(FPassword));
        try {
            //登录
            subject.login(token);
            //登录成后，会将登录者的信息存到session中，登录失败则会进到catch
            Session session = subject.getSession();
            request.setAttribute("userSession", session);

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
            List<Role> rlist=userService.getDetail(FName).getRoles();
            List<Permission> plist=new ArrayList<>();
            for(Role r:rlist)
            {
                plist.addAll(roleService.getDetail(r.getRolename()).getPermissions());
            }
          //  HttpSession session=;
            request.getSession().setAttribute("pList", plist);
            return mav;
        } catch (Exception e) {
            //登录失败
            e.printStackTrace();
            mav = new ModelAndView("/login");
            mav.addObject("username", FName);
            mav.addObject("msg", "用户名或密码错误");
            return mav;
        }
    }

    @RequestMapping(value = "/Loginout")
    public String Loginout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return "login";
    }
}
