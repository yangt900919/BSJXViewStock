package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Organization;
import com.linkpal.model.Organization;
import com.linkpal.model.Page;
import com.linkpal.service.IOrganizationService;
import com.linkpal.util.CheckOnlyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
public class OrganizationController {

    @Autowired
    IOrganizationService organizationService;


    @RequestMapping(value = "/organization/index")
    public String Index()
    {
        return "web/organization/index";
    }

    @RequestMapping(value = "/organization/getList")
    public ModelAndView getList(HttpServletRequest request,Organization organization)
    {

        Map map=organizationService.getPageList(request, organization);
        ModelAndView mav=new ModelAndView("web/organization/index");
        mav.addObject("organizationList", (List<Organization>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "organization/getList");
        mav.addObject("model",(Organization) map.get("model"));
        return mav;
    }

    @RequestMapping(value = "/organization/create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/organization/edit");
        Organization organization=new Organization();
        organization.setFid(0);
        mav.addObject("organization",organization);
        return mav;
    }

    @RequestMapping(value = "/organization/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Organization Organization) throws Exception {
        if(Organization.getFid()==null)
        {
            organizationService.create(Organization);

        }
        else
        {
            organizationService.update(Organization);
        }

        return  getList(request,(Organization) request.getSession().getAttribute("Organization")) ;
    }

    @RequestMapping(value = "/organization/edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/organization/edit");
        Organization Organization=organizationService.getDetail(ID);
        mav.addObject("organization",Organization);
        return mav;
    }

    @RequestMapping(value = "/organization/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        organizationService.delete(ID);
        return getList(request,(Organization)request.getSession().getAttribute("Organization"));
    }

    @RequestMapping(value = "/organization/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        organizationService.deleteBatch(ids);
        return getList(request,(Organization)request.getSession().getAttribute("Organization"));
    }

    @RequestMapping(value = "/organization/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Organization model=null;
		if(ID==0)model=new Organization();
		else model=organizationService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getOrganizationnumber(), organizationService, param, ID));
    }
//    @Override
//    @POST
//    @RequestMapping(value = "/organization/create")
//    public void create(HttpServletRequest request, HttpServletResponse response, Organization obj) throws Exception  {
//        if(organizationService.create(obj)){
//            response.getWriter().write("ok");
//            response.getWriter().flush();
//            response.getWriter().close();
//        }
//    }
//
//    @Override
//    @POST
//    @RequestMapping(value = "/organization/delete")
//    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
//        if (organizationService.delete(fid)){
//            response.getWriter().write("ok");
//            response.getWriter().flush();
//            response.getWriter().close();
//        }
//    }
//
//    @Override
//    @POST
//    @RequestMapping(value = "/organization/edit")
//    public void update(HttpServletRequest request, HttpServletResponse response, Organization obj) throws Exception  {
//        if(organizationService.update(obj)){
//            response.getWriter().write("ok");
//            response.getWriter().flush();
//            response.getWriter().close();
//        }
//    }
//
//    @Override
//    @RequestMapping(value = "/organization/list")
//    public ModelAndView getList(HttpServletRequest request){
//        ModelAndView mav = new ModelAndView("web/MaterialUnit/MaterialUnit");
//        mav.addObject("organizationlist" , organizationService.getList());
//        return mav;
//    }
//
//    @Override
//    @RequestMapping(value = "/organization/part-list")
//    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String organizationnumber =request.getParameter("organizationnumber");
//        response.getWriter().write(JSON.toJSONString(organizationService.getTipList(organizationnumber)));
//        response.getWriter().flush();
//        response.getWriter().close();
//    }
//
//    @Override
//    @RequestMapping(value = "/organization/detail")
//    public ModelAndView getDetail(HttpServletRequest request){
//        String organizationnumber = request.getParameter("organizationnumber");
//        ModelAndView mav = new ModelAndView("web/MaterialUnit/MaterialUnit-change");
//        Organization organization = organizationService.getDetail(organizationnumber);
//        mav.addObject("organization", organization);
//        return mav;
//    }
//
//    @Override
//    @RequestMapping(value = "/organization/add")
//    public ModelAndView toAdd() {
//        ModelAndView mav = new ModelAndView("web/MaterialUnit/MaterialUnit-add");
//        return mav;
//    }
//
//    @Override
//    public ModelAndView toEdit(HttpServletRequest request, int fid) {
//        return null;
//    }
//
//    @Override
//    @RequestMapping(value = "/organization/auto-list")
//    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
//        ModelAndView mav = new ModelAndView("web/MaterialUnit/MaterialUnit");
//        mav.addObject("organizationlist" , organizationService.getTipList(fnumber));
//        return mav;
//    }
}
