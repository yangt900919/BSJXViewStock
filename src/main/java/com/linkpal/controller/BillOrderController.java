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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class BillOrderController {

    @Autowired
    IBillOrderService billorderservice;

    @Autowired
    IMaterialService materialService;
    @Autowired
    IERPStockService stockService;
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
        mav.addObject("erpstocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
        return mav;
    }

    @RequestMapping(value = "/billorder/getList")
    @ResponseBody
    @RequiresPermissions("billorder:view")
    public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String,Object> params)
    {

        if(params==null)params=new HashMap<>();
        List<Billorder> billorderList=new ArrayList<>();
        Map<String, Object> m=new HashMap<>();
        if(params.size()==0)
        {
            params.put("sdate", DateUtil.getDatePreM());
            params.put("edate",DateUtil.getDateNow());
            params.put("fstatus",-1);
        }
        User user=(User) request.getSession().getAttribute("user");
        if(user.getRoles().stream().filter(r->r.getRolename().equals("采购员")).collect(Collectors.toList()).size()>0)
            params.put("creatorid",((User) request.getSession().getAttribute("user")).getFid());
        else if(user.getUsername().equals("admin"))
            params.put("creatorid",null);
        int size=user.getRoles().stream().filter(r->r.getRolename().equals("库管员")).collect(Collectors.toList()).size();
        if(size>0 && !(user.getUsername().equals("admin")))
        {
            for(int i=0;i<user.getErpStocks().size();i++)
            {
                params.put("fstockid",user.getErpStocks().get(i).getFid());
                m=billorderservice.getPageList(request, params);
                billorderList.addAll((List<Billorder>) m.get("list"));
            }
        }
        else
        {
            m=billorderservice.getPageList(request, params);
           billorderList=(List<Billorder>) m.get("list");
        }

        /*if(user.getRoles().stream().filter(r->r.getRolename().equals("库管员")).collect(Collectors.toList()).size()>0)
        {
            olist=olist.stream().filter(o->user.getErpStocks().stream().filter(e->))
        }*/
        ModelAndView mav=new ModelAndView("web/billorder/index");
        mav.addObject("billorderlist", billorderList);
        mav.addObject("page", (Page) m.get("page"));
        mav.addObject("url", "billorder/getList");
        mav.addObject("model",m.get("model"));
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", stockService.getList());
        mav.addObject("userlist",userService.getList());
        mav.addObject("supplierlist", supplierService.getList());
        mav.addObject("orgnizationlist", organizationService.getList());
        mav.addObject("customlist", customService.getList());
       // mav.addObject("msg","");
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
        User user= ((User) request.getSession().getAttribute("user"));
        billorder.setCreator(user);
        billorder.setFcruserid(user.getFid());
        //billorder.setFnumber(billorderservice.getAutoNumber());
        mav.addObject("billorder",billorder);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", stockService.getList());
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

        return  getList(request, (Map<String,Object>) request.getSession().getAttribute("Billorder")) ;
    }

    @RequestMapping(value = "/billorder/edit")
    @RequiresPermissions("billorder:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/billorder/edit");
       Billorder billorder=billorderservice.getDetail(ID);
        mav.addObject("billorder",billorder);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", stockService.getList());
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
        return  getList(request, (Map<String,Object>) request.getSession().getAttribute("Billorder")) ;
    }

    @RequestMapping(value = "/billorder/deleteBatch")
    @RequiresPermissions("billorder:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        billorderservice.deleteBatch(ids);
        return  getList(request, (Map<String,Object>) request.getSession().getAttribute("Billorder")) ;
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
        billorder.setFchuserid(((User) request.getSession().getAttribute("user")).getFid());
        billorder.setFcheckdate(new Date());
        billorder.setFstatus(1);
        billorderservice.update(billorder);
        return  getList(request, (Map<String,Object>) request.getSession().getAttribute("Billorder")) ;
    }

    @RequestMapping(value = "/billorder/unaudit")
    @RequiresPermissions("billorder:unaudit")
    public ModelAndView UnAudit(HttpServletRequest request, int ID) throws Exception {
        Billorder billorder=billorderservice.getDetail(ID);
        billorder.setFchuserid(0);
        billorder.setFcheckdate(null);
        billorder.setFstatus(0);
        billorderservice.update(billorder);
        return  getList(request, (Map<String,Object>) request.getSession().getAttribute("Billorder")) ;
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
            billcheckentry.setfStock(stockService.getById(billcheckentry.getFstockid()));
            // System.out.println(billorderservice.getPushDownQty(billorderentry.getFentriyid(),billorderentry.getFbillid()));
            DecimalFormat df=new DecimalFormat("0.000000");
            double qty= (billorderentry.getFqty()-billorderservice.getPushDownQty(billorderentry.getFentriyid(),billorderentry.getFbillid()));
            billcheckentry.setFqty(Double.valueOf(df.format(qty)));
            billcheckentry.setFdeltime(new java.sql.Date(new Date().getTime()));
            billcheckentries.add(billcheckentry);
        }
        billcheck.setBillcheckentries(billcheckentries);
        User user= ((User) request.getSession().getAttribute("user"));
        billcheck.setCreator(user);
        billcheck.setFcruid(user.getFid());
        billcheck.setFnumber(billCheckService.getAutoNumber());
        billcheck.setFstatus(0);
        Map map=new HashMap();
        map.put("sdate", DateUtil.getDatePreM());
        map.put("edate",DateUtil.getDateNow());
        map.put("pageIndex",0);
        map.put("pageSize",20);
        if(((User) request.getSession().getAttribute("user")).getUsername().equals("admin"))
            map.put("creatorid",null);
        else
            map.put("creatorid",((User) request.getSession().getAttribute("user")).getFid());
        request.getSession().setAttribute("Billcheck",map);
        mav.addObject("billcheck",billcheck);
        mav.addObject("materiallist", materialService.getList());
        mav.addObject("erpstocklist", stockService.getList());
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
    public ModelAndView Import(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file) throws IOException {

        ModelAndView mav=null;

       // System.out.println(file);

        //获取上传的文件
       // MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        //MultipartFile file = multipart.getFile("upfile");
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
                 Map  map= billorderservice.importInfo(in,file,request);
                 mav=
                    //new ModelAndView("web/billorder/orderimport");
                    getList(request, (Map<String,Object>) request.getSession().getAttribute("Billorder"));
            mav.addObject("msg",map.get("rs"));
           //mav.addObject("malist",(List<Material>)map.get("malist"));
           mav.addObject("stlist",stockService.getList());
           //mav.addObject("size",(List<Material>)map.get("malist"));
        } catch (ImportException e) {
            mav=
                    //new ModelAndView("web/billorder/orderimport");
                    getList(request, (Map<String,Object>) request.getSession().getAttribute("Billorder"));
            String msg=e.getMessage();
            mav.addObject("msg",msg);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return "redirect:/test.jsp";
        return  mav ;
    }

    @RequestMapping(value = "/billorder/updatestock")
    @POST
    public ModelAndView updateStock(HttpServletRequest request,HttpServletResponse response) throws IOException {

      Map map=new HashMap();
      map.put("fstockid",request.getParameter("stock"));
      map.put("fmaterialid",request.getParameter("material"));


      billorderservice.updateStock(map);
ModelAndView mav=getList(request, (Map<String,Object>) request.getSession().getAttribute("Billorder"));
List<Material> malist=materialService.getnoStList();
if(malist.size()>0)
{
    mav.addObject("msg","");
    mav.addObject("malist",malist);
    mav.addObject("stlist",stockService.getList());
}
else
{
    mav.addObject("msg","");
    mav.addObject("malist",new ArrayList<>());
}

        return mav;
    }

}
