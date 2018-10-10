package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Materialrgoodseat;
import com.linkpal.model.Page;
import com.linkpal.model.User;
import com.linkpal.service.*;
import com.linkpal.util.DateUtil;
import com.linkpal.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {

    @Autowired
    IReportService reportService;
    @Autowired
    IMaterialService materialService;

    @Autowired
    private IMaterialRGoodseatService MaterialRGoodseatService;



    @Autowired
    private IGoodseatService GoodseatService;


    @Autowired
    private IStockService stockService;

    @Autowired
    private ICabinetService cabinetService;

    @Autowired
    private ISCabinetService scabinetService;

    @Autowired
    private IERPStockService ierpStockService;



    @RequestMapping(value = "/report/getLibAge")
    @ResponseBody
    @POST
    public ModelAndView getLibAge(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String,Object> params)
    {
        //if(params.size()==2)
            params.put("type","libage");
        ModelAndView mav=new ModelAndView("web/chart/"+request.getParameter("page"));
        List<Map<String,Object>> list=reportService.getList(params);
        mav.addObject("libage",JSON.toJSONString(list));
        mav.addObject("malist",materialService.getList());
        mav.addObject("model",params);
        mav.addObject("size",params.size());
      return mav;
    }

    @RequestMapping(value = "/report/getQualified")
    @ResponseBody
    @POST
    public ModelAndView getQualified(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String,Object> params)
    {
       // if(params.size()==2)
            params.put("type","qrate");
        ModelAndView mav=new ModelAndView("web/chart/"+request.getParameter("page"));
        List<Map<String,Object>> list=reportService.getList(params);
        mav.addObject("qrate",JSON.toJSONString(list));
       // mav.addObject("malist",materialService.getList());
        mav.addObject("model",params);
        mav.addObject("size",params.size());
        return mav;
    }

    @RequestMapping(value = "/report/getFrenqucy")
    @ResponseBody
    @POST
    public ModelAndView getFrenqucy(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String,Object> params)
    {
        //if(params.size()==2)
            params.put("type","frenqucy");
        ModelAndView mav=new ModelAndView("web/chart/"+request.getParameter("page"));
        List<Map<String,Object>> list=reportService.getList(params);
        mav.addObject("frenqucy",JSON.parseArray(JSON.toJSONString(list)));
        //mav.addObject("malist",materialService.getList());
        mav.addObject("model",params);
        mav.addObject("size",params.size());
        return mav;
    }


    @RequestMapping(value = "/report/mgindex")

    public ModelAndView mgIndex()
    {
        ModelAndView mav=new ModelAndView("web/materialrgoodseat/indexview");
        //mav.addObject("model",new Materialrgoodseat());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist",GoodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());
        return mav;
    }

    @RequestMapping(value = "/report/getmgList")

    public ModelAndView getmgList(HttpServletRequest request,Materialrgoodseat MaterialRGoodseat)
    {

        MaterialRGoodseat.setMaterial(materialService.getDetail(StringUtil.Change(MaterialRGoodseat.getFmaterialid())));
        MaterialRGoodseat.setGoodseat(GoodseatService.getDetail(StringUtil.Change(MaterialRGoodseat.getFgoodseatid())));
        MaterialRGoodseat.setStock(stockService.getDetail(StringUtil.Change(MaterialRGoodseat.getFstockid())));
        MaterialRGoodseat.setCabinet(cabinetService.getDetail(StringUtil.Change(MaterialRGoodseat.getFcabinetid())));
        MaterialRGoodseat.setScabinet(scabinetService.getDetail(StringUtil.Change(MaterialRGoodseat.getFscabinetid())));
        Map map=MaterialRGoodseatService.getPageList(request, MaterialRGoodseat);
        ModelAndView mav=new ModelAndView("web/materialrgoodseat/indexview");
        mav.addObject("materialrgoodseatlist", (List<Materialrgoodseat>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "materialrgoodseat/getList");
        mav.addObject("model",(Materialrgoodseat) map.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("goodseatlist",GoodseatService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("scabinetlist", scabinetService.getList());

        return mav;
    }


    @RequestMapping(value = "/report/getInventoryBalance")
    @ResponseBody
    @POST
    public ModelAndView getInventoryBalance(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String,Object> params)
    {

        if(params.get("sdate")==null)
        {
            params.put("edate", DateUtil.getDateNow());
            params.put("sdate",DateUtil.getDatePreM());
        }


        params.put("type","InventoryBalance");

        for( String key:params.keySet())
        {
            if(params.get(key)!=null&&(params.get(key).toString().equals("")||params.get(key).toString().equals("0")))
            {
                params.put(key,null);
            }
        }

        if(request.getSession().getAttribute("user")!=null) {
            if (((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
                params.put("fuserid", null);
            else
                params.put("fuserid", ((User) request.getSession().getAttribute("user")).getFid());
        }
        ModelAndView mav=new ModelAndView("web/report/inventorybalance");
        mav.addObject("balance_list",reportService.getReportList(params));
        mav.addObject("model",params);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", ierpStockService.getList());
        //mav.addObject("flag",params.get("flag"));
        return mav;
    }

    @RequestMapping(value = "/report/getInventoryBalance_date")
    @ResponseBody
    @POST
    public ModelAndView getInventoryBalance_date(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String,Object> params)
    {

        if(params.get("sdate")==null)
        {
            params.put("edate", DateUtil.getDateNow());
            params.put("sdate",DateUtil.getDatePreM());
        }


        params.put("type","InventoryBalance_date");

        for( String key:params.keySet())
        {
            if(params.get(key)!=null&&(params.get(key).toString().equals("")||params.get(key).toString().equals("0")))
            {
                params.put(key,null);
            }
        }

        if(request.getSession().getAttribute("user")!=null) {
            if (((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
                params.put("fuserid", null);
            else
                params.put("fuserid", ((User) request.getSession().getAttribute("user")).getFid());
        }
        ModelAndView mav=new ModelAndView("web/report/inventorybalance_date");
        mav.addObject("balance_date_list",reportService.getReportList(params));
        mav.addObject("model",params);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", ierpStockService.getList());
        //mav.addObject("flag",params.get("flag"));
        return mav;
    }


    @RequestMapping(value = "/report/getInventorySummary")
    @ResponseBody
    @POST
    public ModelAndView getInventorySummary(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String,Object> params)
    {

        if(params.get("sdate")==null)
        {
            params.put("edate", DateUtil.getDateNow());
            params.put("sdate",DateUtil.getDatePreM());
        }


        params.put("type","Inventorysummary");

        for( String key:params.keySet())
        {
            if(params.get(key)!=null&&(params.get(key).toString().equals("")||params.get(key).toString().equals("0")))
            {
                params.put(key,null);
            }
        }

        if(request.getSession().getAttribute("user")!=null) {
            if (((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
                params.put("fuserid", null);
            else
                params.put("fuserid", ((User) request.getSession().getAttribute("user")).getFid());
        }
        ModelAndView mav=new ModelAndView("web/report/inventorysummary");
        mav.addObject("balance_list",reportService.getReportList(params));
        mav.addObject("model",params);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", ierpStockService.getList());
        //mav.addObject("flag",params.get("flag"));
        return mav;
    }

    @RequestMapping(value = "/report/getICstockSummary")
    @ResponseBody
    @POST
    public ModelAndView getICstockSummary(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String,Object> params)
    {

        if(params.get("sdate")==null)
        {
            params.put("edate", DateUtil.getDateNow());
            params.put("sdate",DateUtil.getDatePreM());
        }


        params.put("type","icstockbill");

        for( String key:params.keySet())
        {
            if(params.get(key)!=null&&(params.get(key).toString().equals("")||params.get(key).toString().equals("0")))
            {
                params.put(key,null);
            }
        }

        if(request.getSession().getAttribute("user")!=null) {
            if (((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
                params.put("fuserid", null);
            else
                params.put("fuserid", ((User) request.getSession().getAttribute("user")).getFid());
        }
        ModelAndView mav=new ModelAndView("web/report/icstocksummary");
        mav.addObject("balance_list",reportService.getReportList(params));
        mav.addObject("model",params);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", ierpStockService.getList());
        //mav.addObject("flag",params.get("flag"));
        return mav;
    }

    @RequestMapping(value = "/report/getGuaranteePeriod")
    @ResponseBody
    @POST
    public ModelAndView getGuaranteePeriod(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String,Object> params)
    {



        params.put("type","ga");

      /*  for( String key:params.keySet())
        {
            if(params.get(key)!=null&&(params.get(key).toString().equals("")||params.get(key).toString().equals("0")))
            {
                params.put(key,null);
            }
        }
*/
        if(request.getSession().getAttribute("user")!=null) {
            if (((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
                params.put("fuserid", null);
            else
                params.put("fuserid", ((User) request.getSession().getAttribute("user")).getFid());
        }
        ModelAndView mav=new ModelAndView("web/report/guaranteeperiod");
        mav.addObject("balance_list",reportService.getReportList(params));
       mav.addObject("model",params);
        /* mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", ierpStockService.getList());*/
        //mav.addObject("flag",params.get("flag"));
        return mav;
    }
}
