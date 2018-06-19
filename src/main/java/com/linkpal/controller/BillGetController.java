package com.linkpal.controller;

import com.linkpal.model.Billget;
import com.linkpal.model.Page;
import com.linkpal.model.User;
import com.linkpal.service.*;
import com.linkpal.util.InitBinderUtil;
import com.linkpal.util.MapUtil;
import com.linkpal.util.GlobalVarContext;
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
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BillGetController {

    @Autowired
    IBillGetService billGetService;
    @Autowired
    IMaterialService materialService;
    @Autowired
    IStockService stockService;
    @Autowired
    IUserService userService;
    @Autowired
    IOrganizationService organizationService;
    @Autowired
    ICustomService customService;

    @RequestMapping(value = "/billget/index")
    @RequiresPermissions("billget:view")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/billget/index");
        mav.addObject("model",new HashMap<>());
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
        return mav;
    }

    @RequestMapping(value = "/billget/getList")
    @ResponseBody
    @RequiresPermissions("billget:view")
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, String> params)
    {

        Map<String, Object> m=billGetService.getPageList(request, params);
        ModelAndView mav=new ModelAndView("web/billget/index");
        mav.addObject("billgetlist", (List<Billget>) m.get("list"));
        mav.addObject("page", (Page) m.get("page"));
        mav.addObject("url", "billget/getList");
        mav.addObject("model",m.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
/*        if(request!=null)
       GlobalVarContext.request=request;*/
        return mav;
    }

    @RequestMapping(value = "/billget/create")
    @RequiresPermissions("billget:create")
    public ModelAndView Create(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView("web/billget/edit");
        Billget billget=new Billget();
        User user= GlobalVarContext.user;
        billget.setCreator(user);
        billget.setFcreaterid(user.getFid());
        billget.setFnumber(billGetService.getAutoNumber());
        mav.addObject("billget",billget);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
        mav.addObject("readonly","");
        mav.addObject("disabled","");
       // System.out.println(billget.getFcreatedate());
        return mav;
    }

    @RequestMapping(value = "/billget/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Billget billget)
    {
        if(billget.getFid()==0)
        {
            try {
                billGetService.create(billget);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            try {
                billGetService.update(billget);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return  getList(request, (Map) request.getSession().getAttribute("Billget")) ;
    }

    @RequestMapping(value = "/billget/edit")
    @RequiresPermissions("billget:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/billget/edit");
       Billget billget=billGetService.getDetail(ID);
        mav.addObject("billget",billget);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("stocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
        if(billget.getFstate()==1) {
            mav.addObject("readonly", "readonly");
            mav.addObject("disabled","disabled");
        }
        return mav;
    }

    @RequestMapping(value = "/billget/delete")
    @RequiresPermissions("billget:delete")
    public ModelAndView Delete(HttpServletRequest request, int ID) throws Exception {
        billGetService.delete(ID);
        return getList(request, (Map) request.getSession().getAttribute("Billget")) ;
    }

    @RequestMapping(value = "/billget/deleteBatch")
    @RequiresPermissions("billget:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        billGetService.deleteBatch(ids);
        return getList(request, (Map) request.getSession().getAttribute("Billget")) ;
    }

    @RequestMapping(value = "/billget/CheckOnly")
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

    @RequestMapping(value = "/billget/audit")
    @RequiresPermissions("billget:audit")
    public ModelAndView Audit(HttpServletRequest request, int ID) throws Exception {
        Billget billget=billGetService.getDetail(ID);
        billget.setFauditorid(GlobalVarContext.user.getFid());
        billget.setFauditdate(new Date());
        billGetService.update(billget);
        return getList(request, (Map) request.getSession().getAttribute("Billget")) ;
    }

    @RequestMapping(value = "/billget/unaudit")
    @RequiresPermissions("billget:unaudit")
    public ModelAndView UnAudit(HttpServletRequest request, int ID) throws Exception {
        Billget billget=billGetService.getDetail(ID);
        billget.setFauditorid(0);
        billget.setFauditdate(null);
        billGetService.update(billget);
        return getList(request, (Map) request.getSession().getAttribute("Billget")) ;
    }

    @RequestMapping(value = "/billget/checkrelation")
    public void checkRealtion(HttpServletRequest  request,HttpServletResponse response,int ID) throws IOException {


        response.getWriter().println("false");
    }

    @RequestMapping(value = "/billget/print")
    @RequiresPermissions("billget:print")
    public ModelAndView Print(int ID)
    {
        ModelAndView mav=Edit(ID);
        mav.addObject("isgprint",1);
        return mav;
    }


    @InitBinder
    public void InitBinder(WebDataBinder dataBinder)
    {
        InitBinderUtil.InitBinder(dataBinder);
    }

}
