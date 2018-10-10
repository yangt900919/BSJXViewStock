package com.linkpal.controller;

import com.linkpal.model.Dataoperatelog;
import com.linkpal.model.Inventory;
import com.linkpal.model.Page;
import com.linkpal.model.User;
import com.linkpal.service.*;
import com.linkpal.util.DateUtil;
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
public class DataOperateLogController {

    @Autowired
    IMaterialService materialService;

    @Autowired
    IDataseatService dataseatService;

    @Autowired
    IStockService stockService;

    @Autowired
    IDataCabinetService cabinetService;

    @Autowired
    IDataOperateLogService operatelogService;

    @Autowired
    IDataSCabinetService scabinetService;


    @Autowired
    IERPStockService erpstockService;

    @RequestMapping(value = "/dataoperatelog/index")
    @RequiresPermissions("dataoperatelog:view")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/dataoperatelog/index");
        mav.addObject("model",new HashMap());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("dataseatlist", dataseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("erpstocklist", erpstockService.getList());
   /*     mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());*/
        return mav;
    }

    @RequestMapping(value = "/dataoperatelog/getList")
    @ResponseBody
    @RequiresPermissions("dataoperatelog:view")
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, String> params)
    {

        if(params.size()==0)
        {
            params.put("sdate", DateUtil.getDatePreM());
            params.put("edate",DateUtil.getDateNow());

        }

        if(((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
            params.put("fuser",null);
        else
            params.put("fuser",((User) request.getSession().getAttribute("user")).getUsername());
        Map map=operatelogService.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/dataoperatelog/index");

        mav.addObject("dataoperateloglist", (List<Dataoperatelog>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "operatelog/getList");
        mav.addObject("model",map.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("dataseatlist", dataseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("erpstocklist", erpstockService.getList());
      /*  mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());*/
      //  request.getSession().setAttribute("operatelogMap", m);
        return mav;
    }



    /*@Override
    @POST
    @RequestMapping(value = "/dataoperatelog/create")
    public void create(HttpServletRequest request, HttpServletResponse response, Inventory obj) throws Exception {
        if (operatelogService.create(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().cl ose();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/dataoperatelog/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if (operatelogService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/dataoperatelog/update")
    public void update(HttpServletRequest request, HttpServletResponse response, Inventory obj) throws Exception {
        if (operatelogService.update(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/dataoperatelog/list")
    public ModelAndView getList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", operatelogService.getList());
        return mav;
    }

    @Override
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    @RequestMapping(value = "/dataoperatelog/detail")
    public ModelAndView getDetail(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", operatelogService.getDetail(Integer.parseInt(request.getParameter(""))));
        return mav;
    }

    @Override
    @RequestMapping(value = "/dataoperatelog/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", materialService.getList());
        mav.addObject("", stockService.getList());
        mav.addObject("", cabinetService.getList());
        mav.addObject("", dataseatService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/dataoperatelog/edit")
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
