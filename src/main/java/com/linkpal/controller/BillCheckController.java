package com.linkpal.controller;

import com.linkpal.model.*;
import com.linkpal.service.*;
import com.linkpal.util.DateUtil;
import com.linkpal.util.GlobalVarContext;
import com.linkpal.util.InitBinderUtil;
import com.linkpal.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BillCheckController {

    @Autowired
    IBillCheckService billcheckService;
    @Autowired
    IMaterialService materialService;
    @Autowired
    IStockService stockService;
    @Autowired
    IUserService userService;
    @Autowired
    ISupplierService supplierService;
    @Autowired
    ICustomService customService;

    @Autowired
    IBillStockService billStockService;

    @RequestMapping(value = "/billcheck/index")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/billcheck/index");
        mav.addObject("model",new HashMap<>());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        return mav;
    }

    @RequestMapping(value = "/billcheck/getList")
    @ResponseBody
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, String> params)
    {

        Map<String, Object> m=billcheckService.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/billcheck/index");
        mav.addObject("billchecklist", (List<Billcheck>) m.get("list"));
        mav.addObject("page", (Page) m.get("page"));
        mav.addObject("url", "billcheck/getList");
        mav.addObject("model",m.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        if(request!=null)
       GlobalVarContext.request=request;
        return mav;
    }

    @RequestMapping(value = "/billcheck/create")
    public ModelAndView Create(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView("web/billcheck/edit");
        Billcheck billcheck=new Billcheck();
        User user= GlobalVarContext.user;
        billcheck.setCreator(user);
        billcheck.setFcruid(user.getFid());
        billcheck.setFnumber(billcheckService.getAutoNumber());
        mav.addObject("billcheck",billcheck);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("readcheck","readonly");
       // System.out.println(billcheck.getFcreatedate());
        return mav;
    }

    @RequestMapping(value = "/billcheck/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Billcheck billcheck) throws Exception {
        if(billcheck.getFid()==null)
        {

                billcheckService.create(billcheck);


        }
        else
        {

                billcheckService.update(billcheck);

        }

        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billcheck")) ;
    }

    @RequestMapping(value = "/billcheck/edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/billcheck/edit");
       Billcheck billcheck=billcheckService.getDetail(ID);
        mav.addObject("billcheck",billcheck);
        mav.addObject("billcheck",billcheck);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        if(billcheck.getFstatus()==1) {
            mav.addObject("readonly", "readonly");
            mav.addObject("disabled","disabled");
            mav.addObject("readcheck","");

        }
        else if(billcheck.getFstatus()==2)
        {
            mav.addObject("readonly", "readonly");
            mav.addObject("disabled","disabled");
            mav.addObject("readcheck","disabled");
        }
        else if(billcheck.getFstatus()==0)
        {
            mav.addObject("readcheck","readonly");
        }
        return mav;
    }

    @RequestMapping(value = "/billcheck/delete")
    public ModelAndView Delete(HttpServletRequest request, int ID) throws Exception {
        billcheckService.delete(ID);
        return getList(request, (Map<String, String>) request.getSession().getAttribute("Billcheck")) ;
    }

    @RequestMapping(value = "/billcheck/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        billcheckService.deleteBatch(ids);
        return getList(request, (Map<String, String>) request.getSession().getAttribute("Billcheck")) ;
    }

    @RequestMapping(value = "/billcheck/audit")
    public ModelAndView Audit(HttpServletRequest request, int ID) throws Exception {
        Billcheck billcheck=billcheckService.getDetail(ID);
        billcheck.setFchuid(GlobalVarContext.user.getFid());
        billcheck.setFchetime(new Date());
        billcheck.setFstatus(1);
        billcheckService.update(billcheck);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billcheck"));
    }

    @RequestMapping(value = "/billcheck/unaudit")
    public ModelAndView UnAudit(HttpServletRequest request, int ID) throws Exception {
        Billcheck billcheck=billcheckService.getDetail(ID);
        billcheck.setFchuid(0);
        billcheck.setFchetime(null);
        billcheck.setFstatus(0);
        billcheckService.update(billcheck);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billcheck"));
    }


    @RequestMapping(value = "/billcheck/pushdown")
    public ModelAndView PushDown(HttpServletRequest request,Integer[] ids)
    {
        ModelAndView mav=new ModelAndView("web/billstock/edit");
        Billstock billstock =new Billstock();
        Billcheck billcheck=billcheckService.getDetail(billcheckService.getentryDetail(ids[0]).getFbillid());
        billstock.setFsupplierid(billcheck.getFsupplierid());
        billstock.setSupplier(supplierService.getDetail(billcheck.getFsupplierid()));
        billstock.setFstockid(billcheckService.getentryDetail(ids[0]).getFstockid());
        billstock.setStock(stockService.getDetail(billcheckService.getentryDetail(ids[0]).getFstockid()));
        List<Billstockentry> billstockentries=new ArrayList<>();
        for(Integer id:ids)
        {
            Billstockentry billstockentry=new Billstockentry();
            Billcheckentry billcheckentry=billcheckService.getentryDetail(id);
            billstockentry.setFoid(billcheckentry.getFentryid());
            billstockentry.setFobillid(billcheckentry.getFbillid());
            billstockentry.setFonumber(billcheckService.getDetail(billcheckentry.getFbillid()).getFnumber());
            billstockentry.setFmaterialid(billcheckentry.getFmaid());
            billstockentry.setMaterial(materialService.getDetail(billcheckentry.getFmaid()));
            billstockentry.setFstockid(billcheckentry.getFstockid());
            billstockentry.setStock(stockService.getDetail(billcheckentry.getFstockid()));
            billstockentry.setFqty(billcheckentry.getFqty()-billcheckService.getPushDownQty(billcheckentry.getFentryid(),billcheckentry.getFbillid()));
            billstockentry.setFbatch(billcheckentry.getFbatch());
            billstockentries.add(billstockentry);
        }
        billstock.setBillstockentries(billstockentries);
        User user= GlobalVarContext.user;
        billstock.setCreator(user);
        billstock.setFuserid(user.getFid());
        billstock.setFnumber(billStockService.getAutoNumber());
        billstock.setFstatus(0);
        billstock.setFboxno(billcheck.getFboxno());
        billstock.setFisqt(billcheck.getFisqt());

        Map map=new HashMap();
        map.put("sdate", DateUtil.getDatePreM());
        map.put("edate",DateUtil.getDateNow());
        map.put("pageIndex",0);
        map.put("pageSize",20);
        request.getSession().setAttribute("Billstock",map);
        mav.addObject("billstock",billstock);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("readonly","");
        mav.addObject("disabled","");
        // System.out.println(billcheck.getFcreatedate());
        return mav;
    }

    @RequestMapping(value = "/billcheck/maprint")
    public ModelAndView maPrint(HttpServletRequest request,Integer[] qrcodes)
    {
        ModelAndView mav= getList(request,(Map<String, String>) request.getSession().getAttribute("Billcheck"));
        //ModelAndView mav=new ModelAndView("web/maprint/maprint");
        List<Billcheck> mplist=new ArrayList<>();
        for(Integer code:qrcodes)
        {
            List<Billcheckentry> bel=new ArrayList<>();
            Billcheckentry be=billcheckService.getentryDetail(code);
            be.setfMaterial(materialService.getDetail(be.getFmaid()));
            bel.add(be);
            Billcheck b=billcheckService.getDetail(be.getFbillid());
            b.setBillcheckentries(bel);

            mplist.add(b);
        }
        mav.addObject("isprint",mplist.size());
        mav.addObject("mplist", mplist);
        return mav;
    }

    @RequestMapping(value = "/billcheck/checkrelation")
    public void checkRealtion(HttpServletRequest  request,HttpServletResponse response,int ID) throws IOException {
        Map map=new HashMap();
        map.put("fid",ID);
        // map.put("fentryid",entryID);

        response.getWriter().println(billcheckService.checkRelation(map));
    }

    @RequestMapping(value = "/billcheck/getboxno")
    public void getboxno(HttpServletRequest  request,HttpServletResponse response,String fonumber) throws IOException {
        Map map=new HashMap();
      //  map.put("fid",ID);
        // map.put("fentryid",entryID);

        response.getWriter().println(billcheckService.initAutoboxno(fonumber));
    }


    @RequestMapping(value = "/billcheck/print")
    public ModelAndView Print(int ID)
    {
        ModelAndView mav=Edit(ID);
        mav.addObject("iscprint",1);
        return mav;
    }


    @InitBinder
    public void InitBinder(WebDataBinder dataBinder)
    {
        InitBinderUtil.InitBinder(dataBinder);
    }

}
