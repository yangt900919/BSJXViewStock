/**package com.linkpal.controller;

import com.linkpal.model.Role;
import com.linkpal.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

@Controller
public class RoleController extends BaseController<Role> {

    @Autowired
    IRoleService roleService;

    @Override
    @POST
    public ModelAndView create(HttpServletRequest request, Role obj) {
        return null;
    }

    @Override
    @POST
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {

    }

    @Override
    @POST
    public ModelAndView update(HttpServletRequest request, Role obj) {
        return null;
    }

    @Override
    public ModelAndView getList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", roleService.getRoles());
        return mav;
    }

    @Override
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    public ModelAndView getDetail(HttpServletRequest request) {
        return null;
    }

    @Override
    public ModelAndView toAdd() {
        return null;
    }

    @Override
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        return null;
    }
}
**/
