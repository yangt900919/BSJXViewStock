package com.linkpal.controller;

import com.linkpal.model.Inventory;
import com.linkpal.model.Page;
import com.linkpal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InventoryController {

    @Autowired
    IMaterialService materialService;

    @Autowired
    IGoodseatService goodseatService;

    @Autowired
    IStockService stockService;

    @Autowired
    ICabinetService cabinetService;

    @Autowired
    IInventoryService inventoryService;

    @Autowired
    ISCabinetService scabinetService;

    @RequestMapping(value = "/inventory/index")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/inventory/index");
        mav.addObject("model",new HashMap());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist", goodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
        return mav;
    }

    @RequestMapping(value = "/inventory/getList")
    @ResponseBody
    private ModelAndView getPageList(HttpServletRequest request,@RequestParam Map<String, String> params)
    {

        Map map=inventoryService.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/inventory/index");

        mav.addObject("inventorylist", (List<Inventory>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "inventory/getList");
        mav.addObject("model",map.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist", goodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
      //  request.getSession().setAttribute("inventoryMap", m);
        return mav;
    }



    /*@Override
    @POST
    @RequestMapping(value = "/inventory/create")
    public void create(HttpServletRequest request, HttpServletResponse response, Inventory obj) throws Exception {
        if (inventoryService.create(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/inventory/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if (inventoryService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/inventory/update")
    public void update(HttpServletRequest request, HttpServletResponse response, Inventory obj) throws Exception {
        if (inventoryService.update(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/inventory/list")
    public ModelAndView getList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", inventoryService.getList());
        return mav;
    }

    @Override
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    @RequestMapping(value = "/inventory/detail")
    public ModelAndView getDetail(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", inventoryService.getDetail(Integer.parseInt(request.getParameter(""))));
        return mav;
    }

    @Override
    @RequestMapping(value = "/inventory/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", materialService.getList());
        mav.addObject("", stockService.getList());
        mav.addObject("", cabinetService.getList());
        mav.addObject("", goodseatService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/inventory/edit")
    public ModelAndView toEdit(HttpServletRequest request, int fbillid) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", inventoryService.getDetail(Integer.parseInt(request.getParameter(""))));
        return mav;
    }

    @Override
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        return null;
    }*/
}
