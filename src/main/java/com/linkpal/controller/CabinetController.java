package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Cabinet;
import com.linkpal.model.Page;
import com.linkpal.service.ICabinetService;
import com.linkpal.service.IStockService;
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
public class CabinetController  {

    @Autowired
    ICabinetService cabinetService;

    @Autowired
    IStockService stockService;

    @RequestMapping(value = "/cabinet/index")
    public String Index()
    {
        return "web/cabinet/index";
    }

    @RequestMapping(value = "/cabinet/getList")
    public ModelAndView getList(HttpServletRequest request,Cabinet cabinet)
    {

        cabinet.setStock(stockService.getDetail(StringUtil.Change(cabinet.getFstockid())));
        Map map=cabinetService.getPageList(request, cabinet);
        ModelAndView mav=new ModelAndView("web/cabinet/index");
        mav.addObject("cabinetList", (List<Cabinet>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "cabinet/getList");
        mav.addObject("model",(Cabinet) map.get("model"));
    mav.addObject("stocklist",stockService.getList());
        return mav;
    }

    @RequestMapping(value = "/cabinet/create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/cabinet/edit");
        Cabinet cabinet=new Cabinet();
        cabinet.setFid(0);
        mav.addObject("cabinet", cabinet);
    mav.addObject("stocklist",stockService.getList());
        return mav;
    }

    @RequestMapping(value = "cabinet/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Cabinet cabinet) throws Exception
    {
        if(cabinet.getFid()==null)
        {
            cabinetService.create(cabinet);

        }
        else
        {
            cabinetService.update(cabinet);
        }

        return  getList(request,(Cabinet) request.getSession().getAttribute("Cabinet")) ;
    }

    @RequestMapping(value = "/cabinet/edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("/web/cabinet/edit");
        Cabinet cabinet=cabinetService.getDetail(ID);
        mav.addObject("cabinet",cabinet);
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }

    @RequestMapping(value = "/cabinet/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception
    {
        cabinetService.delete(ID);
        return getList(request,(Cabinet) request.getSession().getAttribute("Cabinet"));
    }

    @RequestMapping(value = "/cabinet/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        cabinetService.deleteBatch(ids);
        return getList(request,(Cabinet) request.getSession().getAttribute("Cabinet"));
    }

    @RequestMapping(value = "/cabinet/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CheckOnlyContext coc=new CheckOnlyContext();
        Cabinet model=null;
        if(ID==0)model=new Cabinet();
        else model=cabinetService.getDetail(ID);
        out.println( coc.CheckOnly(model.getFnumber(), cabinetService, param, ID));
    }
/*
    @Override
    @POST
    @RequestMapping(value = "/cabinet/create")
    public void create(HttpServletRequest request, HttpServletResponse response, Cabinet obj) throws Exception {
        if (cabinetService.create(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/cabinet/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if (cabinetService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/cabinet/update")
    public void update(HttpServletRequest request, HttpServletResponse response, Cabinet obj) throws Exception {
        if (cabinetService.update(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/cabinet/list")
    public ModelAndView getList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", cabinetService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/cabinet/part-list")
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write(JSON.toJSONString(cabinetService.getTipList(request.getParameter(""))));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    @RequestMapping(value = "/cabinet/detail")
    public ModelAndView getDetail(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", cabinetService.getDetail(request.getParameter("")));
        return mav;
    }

    @Override
    @RequestMapping(value = "/cabinet/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", cabinetService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/cabinet/edit")
    public ModelAndView toEdit(HttpServletRequest request, int fid) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", cabinetService.getDetail(fid));
        return mav;
    }

    @Override
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        return null;
    }*/
}
