package com.linkpal.controller;

import com.linkpal.model.Inventory;
import com.linkpal.model.Page;
import com.linkpal.model.User;
import com.linkpal.service.*;
import com.linkpal.util.ExcelUtil;
import com.linkpal.util.ExportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataInventoryController {

    @Autowired
    IMaterialService materialService;

    @Autowired
    IDataseatService dataseatService;

    @Autowired
    IStockService stockService;

    @Autowired
    IERPStockService erpstockService;

    @Autowired
    IDataCabinetService cabinetService;

    @Autowired
    IDataInventoryService inventoryService;

    @Autowired
    IDataSCabinetService scabinetService;

    @RequestMapping(value = "/datainventory/index")
    @RequiresPermissions("datainventory:view")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/datainventory/index");
        mav.addObject("model",new HashMap());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("dataseatlist", dataseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("erpstocklist", erpstockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
        return mav;
    }

    @RequestMapping(value = "/datainventory/getList")
    @ResponseBody
    @RequiresPermissions("datainventory:view")
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, Object> params)
    {

        if(((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
            params.put("fuser",null);
        else
            params.put("fuser",((User) request.getSession().getAttribute("user")).getFid());
        Map map=inventoryService.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/datainventory/index");

        mav.addObject("datainventorylist", (List<Inventory>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "inventory/getList");
        mav.addObject("model",map.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("dataseatlist", dataseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("erpstocklist", erpstockService.getList());
      //  request.getSession().setAttribute("inventoryMap", m);
        return mav;
    }




}
