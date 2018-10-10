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
import javax.servlet.jsp.tagext.PageData;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
    IERPStockService erpstockService;

    @Autowired
    ICabinetService cabinetService;

    @Autowired
    IInventoryService inventoryService;

    @Autowired
    ISCabinetService scabinetService;

    @RequestMapping(value = "/inventory/index")
    @RequiresPermissions("inventory:view")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/inventory/index");
        mav.addObject("model",new HashMap());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist", goodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("erpstocklist", erpstockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
        return mav;
    }

    @RequestMapping(value = "/inventory/getList")
    @ResponseBody
    @RequiresPermissions("inventory:view")
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, Object> params)
    {


        if(params.get("fstate")==null)
        {
            params.put("fstate","rk");
        }

        if(((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
            params.put("fuser",null);
        else
            params.put("fuser",((User) request.getSession().getAttribute("user")).getFid());
        Map map=new HashMap();
        ModelAndView mav=new ModelAndView("web/inventory/index");
        if(params.get("fstate").toString().equals("rk"))
        {
            map=inventoryService.getPageList(request, params);
            mav.addObject("inventorylist", (List<Inventory>) map.get("list"));
        }
        else if(params.get("fstate").toString().equals("zj"))
        {
            map=inventoryService.getZJPageList(request, params);
            mav.addObject("inventorylist", (List<Map<String,Object>>) map.get("list"));
        }
        else if(params.get("fstate").toString().equals("hg"))
        {
            map=inventoryService.getHGPageList(request, params);
            mav.addObject("inventorylist", (List<Map<String,Object>>) map.get("list"));
        }



        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "inventory/getList");
        mav.addObject("model",map.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist", goodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("erpstocklist", erpstockService.getList());
      //  request.getSession().setAttribute("inventoryMap", m);
        return mav;
    }


    @RequestMapping(value = "/inventory/getExportList")
    //@RequiresPermissions("inventory:export")
    public ModelAndView getExportList(HttpServletRequest request,HttpServletResponse response)
    {

        Map<String,Object> map= (Map<String, Object>) request.getSession().getAttribute("Inventory");

        HSSFWorkbook wb=null;
        String fileName="";
        if(map.get("fstate").toString().equals("rk")) {
            List<Inventory> list = inventoryService.getExportList(map);

            //excel标题
            String[] title = {"物料编码", "物料名称", "单位", "货位", "仓库", "批号", "入库日期", "生产日期", "保质期", "数量"};

            //List objs=new ArrayList();
            //objs.add();
            //excel文件名
             fileName = "即时库存" + System.currentTimeMillis() + ".xls";

            //sheet名
            String sheetName = "即时库存";

            //String content[]=b

            String[][] content = new String[list.size()][];

            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                //PageData obj = list.get(i);
                content[i][0] = list.get(i).getMaterial().getMaterialnumber();
                content[i][1] = list.get(i).getMaterial().getMaterialname();
                content[i][2] = list.get(i).getMaterial().getMaterialunit();
                content[i][3] = list.get(i).getGoodseat().getFnumber();
                content[i][4] = list.get(i).getErpstock().getFnumber();
                content[i][5] = list.get(i).getFbatch();
                content[i][6] = list.get(i).getFdate();
                content[i][7] = list.get(i).getFmdate();
                content[i][8] = list.get(i).getFgperiod() == null ? "0" : list.get(i).getFgperiod().toString();
                content[i][9] = list.get(i).getFqty().toString();
            }

             wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);


        }
        else
        {
            List<Map<String,Object>> list=new ArrayList<>();
            String[] title={"物料编码", "物料名称", "单位", "单据编号", "仓库", "批号", "收货日期", "生产日期", "保质期", "数量"};
             fileName = "质检库存" + System.currentTimeMillis() + ".xls";

            //sheet名
            String sheetName = "质检库存";
            if(map.get("fstate").toString().equals("hg"))
            {
                fileName="合格库存"+ System.currentTimeMillis() + ".xls";
                sheetName="合格库存";
                list=inventoryService.getHGExportList(map);
            }
            else
            {
                list=inventoryService.getZJExportList(map);
            }

            String[][] content = new String[list.size()][];

            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                //PageData obj = list.get(i);
                content[i][0] = list.get(i).get("materialNumber").toString();
                content[i][1] = list.get(i).get("materialName").toString();
                content[i][2] = list.get(i).get("materialUnit").toString();
                content[i][3] = list.get(i).get("fbillno").toString();
                content[i][4] = list.get(i).get("fstock").toString();
                content[i][5] = list.get(i).get("fbatch").toString();
                content[i][6] = list.get(i).get("fdate").toString();
                content[i][7] = list.get(i).get("fmdate").toString();
                content[i][8] = list.get(i).get("fguartime").toString() == null ? "0" : list.get(i).get("fguartime").toString();
                content[i][9] = list.get(i).get("fqty").toString();
            }

            wb= ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        }
        //响应到客户端
        try {
            ExportUtil.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getList(request,map);
    }


    @RequestMapping(value = "/inventory/getMaList")
    @ResponseBody
    @RequiresPermissions("inventory:view")
    public ModelAndView getMaList(HttpServletRequest request,@RequestParam Map<String, Object> params)
    {


        if(params.get("fstate")==null)
        {
            params.put("fstate","rk");
        }

        if(((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
            params.put("fuser",null);
        else
            params.put("fuser",((User) request.getSession().getAttribute("user")).getFid());
        Map map=new HashMap();
        ModelAndView mav=new ModelAndView("web/inventory/maindex");
        if(params.get("fstate").toString().equals("rk"))
        {
            map=inventoryService.getMaPageList(request, params);
            mav.addObject("inventorymalist", (List<Inventory>) map.get("list"));
        }
        else if(params.get("fstate").toString().equals("zj"))
        {
            map=inventoryService.getZJMaPageList(request, params);
            mav.addObject("inventorymalist", (List<Map<String,Object>>) map.get("list"));
        }
        else if(params.get("fstate").toString().equals("hg"))
        {
            map=inventoryService.getHGMaPageList(request, params);
            mav.addObject("inventorymalist", (List<Map<String,Object>>) map.get("list"));
        }

       // mav.addObject("inventorymalist", (List<Inventory>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "inventory/getMaList");
        mav.addObject("model",map.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist", goodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("erpstocklist", erpstockService.getList());
        //  request.getSession().setAttribute("inventoryMap", m);
        return mav;
    }


    @RequestMapping(value = "/inventory/getMaExportList")
    //@RequiresPermissions("inventory:export")
    public ModelAndView getMaExportList(HttpServletRequest request,HttpServletResponse response)
    {

        Map<String,Object> map= (Map<String, Object>) request.getSession().getAttribute("Inventory");


        //excel标题
        String[] title = {"物料编码","物料名称","单位","数量"};

        //List objs=new ArrayList();
        //objs.add();
        //excel文件名
        String fileName = "即时库存"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "即时库存";

        HSSFWorkbook wb=null;

        //String content[]=b



        if(map.get("fstate").toString().equals("rk")) {
            List<Inventory> list=inventoryService.getExportList(map);
            String[][] content = new String[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                //PageData obj = list.get(i);
                content[i][0] = list.get(i).getMaterial().getMaterialnumber();
                content[i][1] = list.get(i).getMaterial().getMaterialname();
                content[i][2] = list.get(i).getMaterial().getMaterialunit();

                content[i][3] = list.get(i).getFqty().toString();
            }
            wb= ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        }
        else
        {
            fileName = "质检库存"+System.currentTimeMillis()+".xls";

            //sheet名
             sheetName = "质检库存";
             List<Map<String,Object>> list=new ArrayList<>();

             if(map.get("fstate").toString().equals("hg"))
             {
                 list=inventoryService.getHGMaExportList(map);
             }
             else
             {
                 list=inventoryService.getZJMaExportList(map);
             }
            String[][] content = new String[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                //PageData obj = list.get(i);
                content[i][0] = list.get(i).get("materialNumber").toString();
                content[i][1] = list.get(i).get("materialName").toString();
                content[i][2] = list.get(i).get("materialUnit").toString();

                content[i][3] = list.get(i).get("fqty").toString();
            }
            wb= ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        }



        //响应到客户端
        try {
             ExportUtil.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getMaList(request,map);
    }


    @RequestMapping(value = "/inventory/getMgList")
    @ResponseBody
    @RequiresPermissions("inventory:view")
    public ModelAndView getMgList(HttpServletRequest request,@RequestParam Map<String, Object> params)
    {

        if(((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
            params.put("fuser",null);
        else
            params.put("fuser",((User) request.getSession().getAttribute("user")).getFid());
        Map map=inventoryService.getMgPageList(request, params);
        ModelAndView mav=new ModelAndView("web/inventory/mgindex");

        mav.addObject("inventorymglist", (List<Inventory>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "inventory/getList");
        mav.addObject("model",map.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist", goodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("erpstocklist", erpstockService.getList());
        //  request.getSession().setAttribute("inventoryMap", m);
        return mav;
    }


    @RequestMapping(value = "/inventory/getMgExportList")
    //@RequiresPermissions("inventory:export")
    public ModelAndView getMgExportList(HttpServletRequest request,HttpServletResponse response)
    {

        Map<String,Object> map= (Map<String, Object>) request.getSession().getAttribute("Inventory");
        List<Inventory> list=inventoryService.getExportList(map);

        //excel标题
        String[] title = {"物料编码","物料名称","单位","货位","数量"};

        //List objs=new ArrayList();
        //objs.add();
        //excel文件名
        String fileName = "即时库存"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "即时库存";

        //String content[]=b

        String[][] content = new String[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            //PageData obj = list.get(i);
            content[i][0] = list.get(i).getMaterial().getMaterialnumber();
            content[i][1] = list.get(i).getMaterial().getMaterialname();
            content[i][2] = list.get(i).getMaterial().getMaterialunit();
            content[i][3] = list.get(i).getGoodseat().getFnumber();
            content[i][4] = list.get(i).getFqty().toString();
        }

        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            ExportUtil.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getMgList(request,map);
    }


    @RequestMapping(value = "/inventory/getInventoryDetail")
    @ResponseBody
    //@RequiresPermissions("inventorydetail:view")
    public ModelAndView getInventoryDetail(HttpServletRequest request,@RequestParam Map<String, Object> params) {

        ModelAndView mav=new ModelAndView("web/inventory/inventorydetail");
        mav.addObject("inventorydetail",inventoryService.getInventoryDetail(params));
        return mav;

    }

    @RequestMapping(value = "/inventory/updateQty")
    @ResponseBody
    //@RequiresPermissions("updateQty:view")
    public ModelAndView updateQty(HttpServletRequest request,@RequestParam Map<String, Object> params) {

        inventoryService.updateQty(params);
        return getMaList(request,params);

    }


    }
