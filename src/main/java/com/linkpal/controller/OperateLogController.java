package com.linkpal.controller;

import com.linkpal.model.Inventory;
import com.linkpal.model.Page;
import com.linkpal.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OperateLogController {

    @Autowired
    IMaterialService materialService;

    @Autowired
    IGoodseatService goodseatService;

    @Autowired
    IStockService stockService;

    @Autowired
    ICabinetService cabinetService;

    @Autowired
    IOperateLogService operatelogService;

    @Autowired
    ISCabinetService scabinetService;

    @RequestMapping(value = "/operatelog/index")
    @RequiresPermissions("operatelog:view")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/operatelog/index");
        mav.addObject("model",new HashMap());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist", goodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
   /*     mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());*/
        return mav;
    }

    @RequestMapping(value = "/operatelog/getList")
    @ResponseBody
    @RequiresPermissions("operatelog:view")
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, String> params)
    {

        Map map=operatelogService.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/operatelog/index");

        mav.addObject("operateloglist", (List<Inventory>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "operatelog/getList");
        mav.addObject("model",map.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist", goodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
      /*  mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());*/
      //  request.getSession().setAttribute("operatelogMap", m);
        return mav;
    }



    /*@Override
    @POST
    @RequestMapping(value = "/operatelog/create")
    public void create(HttpServletRequest request, HttpServletResponse response, Inventory obj) throws Exception {
        if (operatelogService.create(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/operatelog/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if (operatelogService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/operatelog/update")
    public void update(HttpServletRequest request, HttpServletResponse response, Inventory obj) throws Exception {
        if (operatelogService.update(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/operatelog/list")
    public ModelAndView getList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", operatelogService.getList());
        return mav;
    }

    @Override
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    @RequestMapping(value = "/operatelog/detail")
    public ModelAndView getDetail(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", operatelogService.getDetail(Integer.parseInt(request.getParameter(""))));
        return mav;
    }

    @Override
    @RequestMapping(value = "/operatelog/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", materialService.getList());
        mav.addObject("", stockService.getList());
        mav.addObject("", cabinetService.getList());
        mav.addObject("", goodseatService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/operatelog/edit")
    public ModelAndView toEdit(HttpServletRequest request, int fbillid) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", operatelogService.getDetail(Integer.parseInt(request.getParameter(""))));
        return mav;
    }

    @Override
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        return null;
    }*/
}
