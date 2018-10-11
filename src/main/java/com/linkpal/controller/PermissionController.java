package com.linkpal.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Page;
import com.linkpal.model.Permission;

import com.linkpal.service.IPermissionService;
import com.linkpal.util.CheckOnlyContext;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PermissionController
{
    private static final Logger log = Logger.getLogger(PermissionController.class);  
	
    @Autowired
	private IPermissionService permissionService;
    
 
    @RequestMapping(value = "/permission/index")
    @RequiresPermissions("permission:view")
    public ModelAndView getList(HttpServletRequest request,Permission Permission) 
    {

    	Map map=permissionService.getPageList(request, Permission);
    	ModelAndView mav=new ModelAndView("web/permission/index");
    	mav.addObject("permissionList", (List<Permission>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "/permission/index");
    	mav.addObject("model",(Permission) map.get("model"));
    	return mav;
    }
    
    @RequestMapping(value = "/permission/create")
    @RequiresPermissions("permission:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/permission/edit");
    	Permission permission=new Permission();
    	mav.addObject("permission",permission);
    	   return mav;
    }
    
    @RequestMapping(value = "/permission/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Permission Permission) throws Exception {
    	if(Permission.getFid()==0)
    	{
    		permissionService.create(Permission);

    	}
    	else
    	{
    		permissionService.update(Permission);
    	}
    	
    	 return  getList(request,(Permission) request.getSession().getAttribute("Permission")) ; 
    }
    
    @RequestMapping(value = "/permission/edit")
    @RequiresPermissions("permission:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/permission/edit");
    	Permission permission=permissionService.getDetail(ID);
    	mav.addObject("permission",permission);
    	   return mav;
    }
    
    @RequestMapping(value = "/permission/delete")
    @RequiresPermissions("permission:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	permissionService.delete(ID);
    	   return getList(request,(Permission)request.getSession().getAttribute("Permission"));
    }
    
    @RequestMapping(value = "/permission/deleteBatch")
    @RequiresPermissions("permission:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	permissionService.deleteBatch(ids);
    	return getList(request,(Permission)request.getSession().getAttribute("Permission"));
    }

    @RequestMapping(value = "/permission/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CheckOnlyContext coc=new CheckOnlyContext();
        Permission model=null;
        if(ID==0)model=new Permission();
        else model=permissionService.getDetail(ID);
        out.println( coc.CheckOnly(model.getFnumber(), permissionService, param, ID));
    }
}
