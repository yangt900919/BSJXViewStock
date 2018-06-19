package com.linkpal.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import com.linkpal.model.Page;
import com.linkpal.model.Role;
import com.linkpal.service.IPermissionService;
import com.linkpal.service.IRoleService;
import com.linkpal.util.CheckOnlyContext;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;






@Controller
public class RoleController
{
    private static final Logger log = Logger.getLogger(RoleController.class);

    @Autowired
    private IRoleService roleService;


    @Autowired
    private IPermissionService pService;

    @RequestMapping(value = "/role/index")
    @RequiresPermissions("role:view")
    public ModelAndView getList(HttpServletRequest request,Role role)
    {

        Map map=roleService.getPageList(request, role);
        ModelAndView mav=new ModelAndView("web/role/index");
        mav.addObject("roleList", (List<Role>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
//    	mav.addObject("url", "/Role/index");
        mav.addObject("url", "role/index");
        mav.addObject("model",(Role) map.get("model"));
        return mav;
    }

    @RequestMapping(value = "/role/create")
    @RequiresPermissions("role:create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/role/edit");
        Role role=new Role();
        mav.addObject("role",role);
       // mav.addObject("permissionList", pService.getList());
        //mav.addObject("permissionList", pService.getAllList());
        return mav;
    }

    @RequestMapping(value = "/role/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Role role) throws Exception {
        if(role.getFid()==0)
        {
            roleService.create(role);
            //service.rolepermissionBind(BuildMapUtil.getMap(request));
        }
        else
        {
            roleService.update(role);
        }

        return  getList(request,(Role) request.getSession().getAttribute("Role")) ;
    }

    @RequestMapping(value = "/role/edit")
    @RequiresPermissions("role:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/role/edit");
        Role role=roleService.getDetail(ID);
        mav.addObject("role",role);
       // mav.addObject("permissionList", pService.getList());
        //mav.addObject("permissionList", pService.getAllList());
        return mav;
    }

    @RequestMapping(value = "/role/delete")
    @RequiresPermissions("role:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        roleService.delete(ID);
        return getList(request,(Role)request.getSession().getAttribute("Role"));
    }

    @RequestMapping(value = "/role/deleteBatch")
    @RequiresPermissions("role:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        roleService.deleteBatch(ids);
        return getList(request,(Role)request.getSession().getAttribute("Role"));
    }

    @RequestMapping(value = "/role/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CheckOnlyContext coc=new CheckOnlyContext();
        Role model=null;
        if(ID==0)model=new Role();
        else model=roleService.getDetail(ID);
        out.println( coc.CheckOnly(model.getRolename(), roleService, param, ID));
    }

    @RequestMapping(value = "/authority")
    public ModelAndView Authority(int ID)
    {

        ModelAndView mav=new ModelAndView("web/role/auth");
        Role role=roleService.getDetail(ID);
        mav.addObject("role",role);
        mav.addObject("permissionList", pService.getList());
        return mav;
    }

    @RequestMapping(value = "/doauthority")
    public ModelAndView doAuthority(HttpServletRequest request,int ID,Integer[] pids)
    {
        roleService.rolepermissionBind(ID, pids);
        return getList(request,(Role) request.getSession().getAttribute("Role"));
    }
}
