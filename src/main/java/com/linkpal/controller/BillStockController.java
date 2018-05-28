package com.linkpal.controller;

import com.linkpal.model.Billstock;
import com.linkpal.model.Billstock;
import com.linkpal.model.Page;
import com.linkpal.model.User;
import com.linkpal.service.*;
import com.linkpal.util.GlobalVarContext;
import com.linkpal.util.InitBinderUtil;
import com.linkpal.util.MapUtil;
import com.linkpal.util.StringUtil;
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
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BillStockController {

    @Autowired
    IBillStockService billStockService;
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

    @RequestMapping(value = "/billstock/index")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/billstock/index");
        mav.addObject("model",new HashMap<>());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        return mav;
    }

    @RequestMapping(value = "/billstock/getList")
    @ResponseBody
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, String> params)
    {

        Map<String, Object> m=billStockService.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/billstock/index");
        mav.addObject("billstocklist", (List<Billstock>) m.get("list"));
        mav.addObject("page", (Page) m.get("page"));
        mav.addObject("url", "billstock/getList");
        mav.addObject("model",m.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        if(request!=null)
       GlobalVarContext.request=request;
        return mav;
    }

    @RequestMapping(value = "/billstock/create")
    public ModelAndView Create(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView("web/billstock/edit");
        Billstock billstock=new Billstock();
        User user= GlobalVarContext.user;
        billstock.setCreator(user);
        billstock.setFuserid(user.getFid());
        billstock.setFnumber(billStockService.getAutoNumber());
        mav.addObject("billstock",billstock);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("readonly","");
        mav.addObject("disabled","");
       // System.out.println(billstock.getFcreatedate());
        return mav;
    }

    @RequestMapping(value = "/billstock/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Billstock billstock)
    {
        if(StringUtil.Change(billstock.getFid())==0)
        {
            try {
                billStockService.create(billstock);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            try {
                billStockService.update(billstock);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billstock")) ;
    }

    @RequestMapping(value = "/billstock/edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/billstock/edit");
       Billstock billstock=billStockService.getDetail(ID);
        mav.addObject("billstock",billstock);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        if(billstock.getFstatus()==1) {
            mav.addObject("readonly", "readonly");
            mav.addObject("disabled","disabled");
        }
        return mav;
    }

    @RequestMapping(value = "/billstock/delete")
    public ModelAndView Delete(HttpServletRequest request, int ID) throws Exception {
        billStockService.delete(ID);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billstock")) ;
    }

    @RequestMapping(value = "/billstock/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        billStockService.deleteBatch(ids);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billstock")) ;
    }

    @RequestMapping(value = "/billstock/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response, String param, int ID) throws Exception
    {
        /*response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CheckOnlyContext coc=new CheckOnlyContext();
        SCabinet model=null;
        if(ID==0)model=new SCabinet();
        else model=scabinetService.getById(ID);
        out.println( coc.CheckOnly(model.getFNumber(), scabinetService, param, ID));*/
    }

    @RequestMapping(value = "/billstock/audit")
    public ModelAndView Audit(HttpServletRequest request, int ID) throws Exception {
        Billstock billstock=billStockService.getDetail(ID);
        billstock.setFuserid(GlobalVarContext.user.getFid());
        billstock.setFdate(new Date());
        billStockService.update(billstock);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billstock")) ;
    }

    @RequestMapping(value = "/billstock/unaudit")
    public ModelAndView UnAudit(HttpServletRequest request, int ID) throws Exception {
        Billstock billstock=billStockService.getDetail(ID);
        billstock.setFuserid(0);
        billstock.setFdate(null);
        billStockService.update(billstock);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billstock")) ;
    }

    @RequestMapping(value = "/billstock/checkrelation")
    public void checkRealtion(HttpServletRequest  request,HttpServletResponse response,int ID) throws IOException {


        response.getWriter().println("false");
    }


    @RequestMapping(value = "/billstock/print")
    public ModelAndView Print(int ID)
    {
        ModelAndView mav=Edit(ID);
        mav.addObject("issprint",1);
        return mav;
    }


    @InitBinder
    public void InitBinder(WebDataBinder dataBinder)
    {
        InitBinderUtil.InitBinder(dataBinder);
    }

}
