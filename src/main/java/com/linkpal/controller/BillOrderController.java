package com.linkpal.controller;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.model.*;
import com.linkpal.service.*;
import com.linkpal.util.DateUtil;
import com.linkpal.util.GlobalVarContext;
import com.linkpal.util.InitBinderUtil;
import com.linkpal.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller
public class BillOrderController {

    @Autowired
    IBillOrderService billorderservice;

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
    IOrganizationService organizationService;

    @Autowired
    IBillCheckService billCheckService;

    @RequestMapping(value = "/billorder/index")
    @RequiresPermissions("billorder:view")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/billorder/index");
        mav.addObject("model",new HashMap<>());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
        return mav;
    }

    @RequestMapping(value = "/billorder/getList")
    @ResponseBody
    @RequiresPermissions("billorder:view")
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, String> params)
    {

        Map<String, Object> m=billorderservice.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/billorder/index");
        mav.addObject("billorderlist", (List<Billorder>) m.get("list"));
        mav.addObject("page", (Page) m.get("page"));
        mav.addObject("url", "billorder/getList");
        mav.addObject("model",m.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
        if(request!=null)
       GlobalVarContext.request=request;
        return mav;
    }

    @RequestMapping(value = "/billorder/create")
    @RequiresPermissions("billorder:create")
    public ModelAndView Create(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView("web/billorder/edit");
        Billorder billorder=new Billorder();
        User user= GlobalVarContext.user;
        billorder.setCreator(user);
        billorder.setFcruserid(user.getFid());
        //billorder.setFnumber(billorderservice.getAutoNumber());
        mav.addObject("billorder",billorder);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
        mav.addObject("readonly","");
        mav.addObject("disabled","");
       // System.out.println(billorder.getFcreatedate());
        return mav;
    }

    @RequestMapping(value = "/billorder/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Billorder billorder)
    {
        if(StringUtil.Change(billorder.getFbillid())==0)
        {
            try {
                billorderservice.create(billorder);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            try {
                billorderservice.update(billorder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billorder")) ;
    }

    @RequestMapping(value = "/billorder/edit")
    @RequiresPermissions("billorder:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/billorder/edit");
       Billorder billorder=billorderservice.getDetail(ID);
        mav.addObject("billorder",billorder);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
        if(billorder.getFstatus()==1) {
            mav.addObject("readonly", "readonly");
            mav.addObject("disabled","disabled");
        }
        return mav;
    }



    @RequestMapping(value = "/billorder/delete")
    @RequiresPermissions("billorder:delete")
    public ModelAndView Delete(HttpServletRequest request, int ID) throws Exception {
        billorderservice.delete(ID);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billorder")) ;
    }

    @RequestMapping(value = "/billorder/deleteBatch")
    @RequiresPermissions("billorder:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        billorderservice.deleteBatch(ids);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billorder")) ;
    }

    @RequestMapping(value = "/billorder/CheckOnly")
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

    @RequestMapping(value = "/billorder/audit")
    @RequiresPermissions("billorder:audit")
    public ModelAndView Audit(HttpServletRequest request, int ID) throws Exception {
        Billorder billorder=billorderservice.getDetail(ID);
        billorder.setFchuserid(GlobalVarContext.user.getFid());
        billorder.setFcheckdate(new Date());
        billorder.setFstatus(1);
        billorderservice.update(billorder);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billorder")) ;
    }

    @RequestMapping(value = "/billorder/unaudit")
    @RequiresPermissions("billorder:unaudit")
    public ModelAndView UnAudit(HttpServletRequest request, int ID) throws Exception {
        Billorder billorder=billorderservice.getDetail(ID);
        billorder.setFchuserid(0);
        billorder.setFcheckdate(null);
        billorder.setFstatus(0);
        billorderservice.update(billorder);
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billorder")) ;
    }

    @RequestMapping(value = "/billorder/pushdown")
    @RequiresPermissions("billorder:push")
    public ModelAndView PushDown(HttpServletRequest request,Integer[] ids)
    {
        ModelAndView mav=new ModelAndView("web/billcheck/edit");
        Billcheck billcheck =new Billcheck();
          Billorder billorder=billorderservice.getDetail(billorderservice.getentryDetail(ids[0]).getFbillid());
          billcheck.setFsupplierid(billorder.getFsupplierid());
          billcheck.setSupplier(supplierService.getDetail(billorder.getFsupplierid()));
          List<Billcheckentry> billcheckentries=new ArrayList<>();
        for(Integer id:ids)
        {
        Billcheckentry billcheckentry=new Billcheckentry();
        Billorderentry billorderentry=billorderservice.getentryDetail(id);
            billcheckentry.setFoid(billorderentry.getFentriyid());
            billcheckentry.setFobillid(billorderentry.getFbillid());
            billcheckentry.setFonumber(billorderservice.getDetail(billorderentry.getFbillid()).getFnumber());
            billcheckentry.setFmaid(billorderentry.getFmaid());
            billcheckentry.setfMaterial(materialService.getDetail(billorderentry.getFmaid()));
            billcheckentry.setFstockid(billorderentry.getFstockid());
            billcheckentry.setfStock(stockService.getDetail(billcheckentry.getFstockid()));
            billcheckentry.setFqty(billorderentry.getFqty()-billorderservice.getPushDownQty(billorderentry.getFentriyid(),billorderentry.getFbillid()));
            billcheckentries.add(billcheckentry);
        }
        billcheck.setBillcheckentries(billcheckentries);
        User user= GlobalVarContext.user;
        billcheck.setCreator(user);
        billcheck.setFcruid(user.getFid());
        billcheck.setFnumber(billCheckService.getAutoNumber());
        billcheck.setFstatus(0);
        Map map=new HashMap();
        map.put("sdate", DateUtil.getDatePreM());
        map.put("edate",DateUtil.getDateNow());
        map.put("pageIndex",0);
        map.put("pageSize",20);
        request.getSession().setAttribute("Billcheck",map);
        mav.addObject("billcheck",billcheck);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("readcheck","readonly");
        // System.out.println(billcheck.getFcreatedate());
        return mav;
    }

    @RequestMapping(value = "/billorder/print")
    @RequiresPermissions("billorder:print")
    public ModelAndView Print(int ID)
    {
        ModelAndView mav=Edit(ID);
        mav.addObject("isoprint",1);
        return mav;
    }

    @RequestMapping(value = "/billorder/deleteentry")
    public void deleteEntry(HttpServletRequest  request,HttpServletResponse response,int ID)
    {
        billorderservice.deleteEntry(ID);
    }

    @RequestMapping(value = "/billorder/checkrelation")
    public void checkRealtion(HttpServletRequest  request,HttpServletResponse response,int ID) throws IOException {
        Map map=new HashMap();
        map.put("fid",ID);
       // map.put("fentryid",entryID);

      response.getWriter().println(billorderservice.checkRelation(map));
    }


    @InitBinder
    public void InitBinder(WebDataBinder dataBinder)
    {
        InitBinderUtil.InitBinder(dataBinder);
    }


    @RequestMapping(value = "/billorder/import")
    @POST
    @RequiresPermissions("billorder:import")
    public ModelAndView Import(HttpServletRequest request,HttpServletResponse response) throws IOException {


        //获取上传的文件
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("upfile");
       // int insertType=Integer.parseInt(request.getParameter("insertType"));
        // String insertType = request.getParameter("insertType");
        InputStream in = null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //数据导入
       // Material ma=new Material();
        try {
            billorderservice.importInfo(in,file);
        } catch (ImportException e) {
            String msg=e.getMessage();
            request.setAttribute("msg",msg);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return "redirect:/test.jsp";
        return  getList(request, (Map<String, String>) request.getSession().getAttribute("Billorder")) ;
    }

}
