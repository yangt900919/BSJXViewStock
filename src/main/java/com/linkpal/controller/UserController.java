package com.linkpal.controller;

import com.alibaba.fastjson.JSONObject;
import com.linkpal.model.User;
import com.linkpal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

@Controller
public class UserController extends BaseController<User>{

    @Autowired
    IUserService userService;

    @Override
    @RequestMapping(value = "/user/create")
    @POST
    public void create(HttpServletRequest request, HttpServletResponse response, User obj) throws Exception {
        if(userService.create(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/user/delete")
    @POST
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if (userService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/user/edit")
    @POST
    public void update(HttpServletRequest request, HttpServletResponse response, User obj) throws Exception {
        if(userService.update(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/user/list")
    public ModelAndView getList(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("web/user/user");
        mav.addObject("userlist", userService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/user/part-list")
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = request.getParameter("fid");
        response.getWriter().write(JSONObject.toJSONString(userService.getTipList(code)));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    @RequestMapping(value = "/user/detail")
    public ModelAndView getDetail(HttpServletRequest request){
        int fid = Integer.parseInt(request.getParameter("fid"));
        ModelAndView mav = new ModelAndView("web/user/user-change");
        User user = userService.getDetail(fid);
        mav.addObject("user", user);
        return mav;
    }

    @Override
    @RequestMapping(value = "/user/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("web/user/user-add");
        return mav;
    }

    @Override
    public ModelAndView toEdit(HttpServletRequest request, int fid) {
        return null;
    }

    @Override
    @RequestMapping(value = "/user/auto-list")
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        ModelAndView mav = new ModelAndView("web/user/user");
        mav.addObject("userlist", userService.getTipList(fnumber));
        return mav;
    }

}
