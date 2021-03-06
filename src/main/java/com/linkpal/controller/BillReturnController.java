package com.linkpal.controller;

import com.linkpal.model.Billreturn;
import com.linkpal.model.Page;
import com.linkpal.model.User;
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
public class BillReturnController {

    @Autowired
    IBillReturnService billReturnService;
    @Autowired
    IMaterialService materialService;
    @Autowired
    IERPStockService stockService;
    @Autowired
    IUserService userService;
    @Autowired
    ISupplierService supplierService;
    @RequestMapping(value = "/billreturn/index")
    @RequiresPermissions("billreturn:view")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/billreturn/index");
        mav.addObject("model",new HashMap<>());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        return mav;
    }

    @RequestMapping(value = "/billreturn/getList")
    @ResponseBody
    @RequiresPermissions("billreturn:view")
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String,Object> params)
    {
        if(params==null)params=new HashMap<>();
        if(params.size()==0)
        {
            params.put("sdate", DateUtil.getDatePreM());
            params.put("edate",DateUtil.getDateNow());
            params.put("fstate",-1);
        }

        if(((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
            params.put("creatorid",null);
        else
            params.put("creatorid",((User) request.getSession().getAttribute("user")).getFid());
        Map<String, Object> m=billReturnService.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/billreturn/index");
        mav.addObject("billreturnlist", (List<Billreturn>) m.get("list"));
        mav.addObject("page", (Page) m.get("page"));
        mav.addObject("url", "billreturn/getList");
        mav.addObject("model",m.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
/*        if(request!=null)
       GlobalVarContext.request=request;*/
        return mav;
    }

    @RequestMapping(value = "/billreturn/create")
    @RequiresPermissions("billreturn:create")
    public ModelAndView Create(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView("web/billreturn/edit");
        Billreturn billreturn=new Billreturn();
        User user= ((User) request.getSession().getAttribute("user"));
        billreturn.setCreator(user);
        billreturn.setFcreatorid(user.getFid());
        billreturn.setFnumber(billReturnService.getAutoNumber());
        mav.addObject("billreturn",billreturn);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("readonly","");
        mav.addObject("disabled","");
       // System.out.println(billreturn.getFcreatedate());
        return mav;
    }

    @RequestMapping(value = "/billreturn/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Billreturn billreturn) throws  Exception
    {
        if(StringUtil.Change(billreturn.getFid())==0)
        {

                billReturnService.create(billreturn);


        }
        else
        {

                billReturnService.update(billreturn);

        }

        return  getList(request, (Map) request.getSession().getAttribute("Billreturn")) ;
    }

    @RequestMapping(value = "/billreturn/edit")
    @RequiresPermissions("billreturn:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/billreturn/edit");
       Billreturn billreturn=billReturnService.getDetail(ID);
        mav.addObject("billreturn",billreturn);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        if(billreturn.getFstate()==1) {
            mav.addObject("readonly", "readonly");
            mav.addObject("disabled","disabled");
        }
        return mav;
    }

    @RequestMapping(value = "/billreturn/delete")
    @RequiresPermissions("billreturn:delete")
    public ModelAndView Delete(HttpServletRequest request, int ID) throws Exception {
        billReturnService.delete(ID);
        return getList(request, (Map) request.getSession().getAttribute("Billreturn")) ;
    }

    @RequestMapping(value = "/billreturn/deleteBatch")
    @RequiresPermissions("billreturn:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        billReturnService.deleteBatch(ids);
        return getList(request, (Map) request.getSession().getAttribute("Billreturn")) ;
    }

    @RequestMapping(value = "/billreturn/CheckOnly")
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

    @RequestMapping(value = "/billreturn/audit")
    @RequiresPermissions("billreturn:audit")
    public ModelAndView Audit(HttpServletRequest request, int ID) throws Exception {
        Billreturn billreturn=billReturnService.getDetail(ID);
        billreturn.setFauditorid(((User) request.getSession().getAttribute("user")).getFid());
        billreturn.setFauditdate(new Date());
        billreturn.setFstate(1);
        billReturnService.update(billreturn);
        return getList(request, (Map) request.getSession().getAttribute("Billreturn")) ;
    }

    @RequestMapping(value = "/billreturn/unaudit")
    @RequiresPermissions("billreturn:unaudit")
    public ModelAndView UnAudit(HttpServletRequest request, int ID) throws Exception {
        Billreturn billreturn=billReturnService.getDetail(ID);
        billreturn.setFauditorid(0);
        billreturn.setFauditdate(null);
        billreturn.setFstate(0);
        billReturnService.update(billreturn);
        return getList(request, (Map) request.getSession().getAttribute("Billreturn")) ;
    }

    @RequestMapping(value = "/billreturn/checkrelation")
    public void checkRealtion(HttpServletRequest  request,HttpServletResponse response,int ID) throws IOException {


        response.getWriter().println("false");
    }

    @RequestMapping(value = "/billreturn/print")
    @RequiresPermissions("billreturn:print")
    public ModelAndView Print(int ID)
    {
        ModelAndView mav=Edit(ID);
        mav.addObject("isrprint",1);
        return mav;
    }


    @InitBinder
    public void InitBinder(WebDataBinder dataBinder)
    {
        InitBinderUtil.InitBinder(dataBinder);
    }

}
