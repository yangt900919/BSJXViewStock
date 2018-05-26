package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Custom;
import com.linkpal.model.Custom;
import com.linkpal.model.Page;
import com.linkpal.model.Stock;
import com.linkpal.service.ICustomService;
import com.linkpal.util.CheckOnlyContext;
import com.linkpal.util.StringUtil;
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
public class CustomController {

    @Autowired
    ICustomService customService;


    @RequestMapping(value = "/custom/index")
    public String Index()
    {
        return "web/custom/index";
    }

    @RequestMapping(value = "/custom/getList")
    public ModelAndView getList(HttpServletRequest request,Custom custom)
    {

        Map map=customService.getPageList(request, custom);
        ModelAndView mav=new ModelAndView("web/custom/index");
        mav.addObject("customList", (List<Custom>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "custom/getList");
        mav.addObject("model",(Custom) map.get("model"));
        return mav;
    }

    @RequestMapping(value = "/custom/create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/custom/edit");
        Custom custom=new Custom();
        custom.setFid(0);
        mav.addObject("custom",custom);
        return mav;
    }

    @RequestMapping(value = "/custom/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Custom custom) throws Exception {
        if(custom.getFid()==null)
        {
            customService.create(custom);

        }
        else
        {
            customService.update(custom);
        }

        return  getList(request,(Custom) request.getSession().getAttribute("Custom")) ;
    }

    @RequestMapping(value = "/custom/edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/custom/edit");
        Custom custom=customService.getDetail(ID);
        mav.addObject("custom",custom);
        return mav;
    }

    @RequestMapping(value = "/custom/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        customService.delete(ID);
        return getList(request,(Custom)request.getSession().getAttribute("Custom"));
    }

    @RequestMapping(value = "/custom/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        customService.deleteBatch(ids);
        return getList(request,(Custom)request.getSession().getAttribute("Custom"));
    }

    @RequestMapping(value = "/custom/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Custom model=null;
		if(ID==0)model=new Custom();
		else model=customService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getCustomnumber(), customService, param, ID));
    }

    /*@Override
    @RequestMapping(value = "/custom/create")
    public void create(HttpServletRequest request, HttpServletResponse response, Custom custom) throws Exception {
        if(customService.create(custom)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/custom/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if(customService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/custom/edit")
    public void update(HttpServletRequest request, HttpServletResponse response, Custom custom) throws Exception {
        if(customService.update(custom)) {
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/custom/list")
    public ModelAndView getList(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("web/Customer/Customer");
        mav.addObject("customlist", customService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/custom/part-list")
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String customnumber = request.getParameter("customnumber");
        response.getWriter().write(JSON.toJSONString(customService.getTipList(customnumber)));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    @RequestMapping(value = "/custom/detail")
    public ModelAndView getDetail(HttpServletRequest request){
        String customnumber = request.getParameter("customnumber");
        ModelAndView mav = new ModelAndView("web/Customer/Customer-change");
        Custom custom = customService.getDetail(customnumber);
        mav.addObject("custom", custom);
        return mav;
    }

    @Override
    @RequestMapping(value = "/custom/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("web/Customer/Customer-add");
        return mav;
    }

    @Override
    public ModelAndView toEdit(HttpServletRequest request, int fid) {
        return null;
    }

    @Override
    @RequestMapping(value = "/custom/auto-list")
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        ModelAndView mav = new ModelAndView("web/Customer/Customer");
        mav.addObject("customlist", customService.getTipList(fnumber));
        return mav;
    }*/

}
