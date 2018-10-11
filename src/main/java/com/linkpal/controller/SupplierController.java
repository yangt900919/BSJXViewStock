package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Supplier;
import com.linkpal.model.Page;
import com.linkpal.model.Supplier;
import com.linkpal.service.ISupplierService;
import com.linkpal.util.CheckOnlyContext;
import com.linkpal.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
public class SupplierController {

    @Autowired
    ISupplierService supplierService;


    @RequestMapping(value = "/supplier/index")
    public String Index()
    {
        return "web/supp/index";
    }

    @RequestMapping(value = "/supplier/getList")
    @RequiresPermissions("supplier:view")
    public ModelAndView getList(HttpServletRequest request,Supplier supplier)
    {

        Map map=supplierService.getPageList(request, supplier);
        ModelAndView mav=new ModelAndView("web/supp/index");
        mav.addObject("supplierList", (List<Supplier>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "supplier/getList");
        mav.addObject("model",(Supplier) map.get("model"));
        return mav;
    }

    @RequestMapping(value = "/supplier/create")
    @RequiresPermissions("supplier:create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/supp/edit");
        Supplier supplier=new Supplier();
        supplier.setFid(0);
        mav.addObject("supplier",supplier);
        return mav;
    }

    @RequestMapping(value = "/supplier/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Supplier Supplier) throws Exception {
        if(Supplier.getFid()==null)
        {
            supplierService.create(Supplier);

        }
        else
        {
            supplierService.update(Supplier);
        }

        return  getList(request,(Supplier) request.getSession().getAttribute("Supplier")) ;
    }

    @RequestMapping(value = "/supplier/edit")
    @RequiresPermissions("supplier:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/supp/edit");
        Supplier Supplier=supplierService.getDetail(ID);
        mav.addObject("supplier",Supplier);
        return mav;
    }

    @RequestMapping(value = "/supplier/delete")
    @RequiresPermissions("supplier:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        supplierService.delete(ID);
        return getList(request,(Supplier)request.getSession().getAttribute("Supplier"));
    }

    @RequestMapping(value = "/supplier/deleteBatch")
    @RequiresPermissions("supplier:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        supplierService.deleteBatch(ids);
        return getList(request,(Supplier)request.getSession().getAttribute("Supplier"));
    }

    @RequestMapping(value = "/supplier/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Supplier model=null;
		if(ID==0)model=new Supplier();
		else model=supplierService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getSuppliernumber(), supplierService, param, ID));
    }
/*
    @Override
    @RequestMapping(value = "supplier/create")
    @POST
    public void create(HttpServletRequest request, HttpServletResponse response, Supplier obj) throws Exception {
        if(supplierService.create(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "supplier/delete")
    @POST
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if (supplierService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "supplier/edit")
    @POST
    public void update(HttpServletRequest request, HttpServletResponse response, Supplier obj) throws Exception {
        if(supplierService.update(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/supplier/list")
    public ModelAndView getList(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("web/Supplier/Supplier");
        mav.addObject("supplierlist", supplierService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/supplier/part-list")
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String suppliernumber = request.getParameter("suppliernumber");
        response.getWriter().write(JSON.toJSONString(supplierService.getTipList(suppliernumber)));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    @RequestMapping(value = "/supplier/detail")
    public ModelAndView getDetail(HttpServletRequest request){
        String code = request.getParameter("suppliernumber");
        ModelAndView mav = new ModelAndView("web/Supplier/Supplier-change");
        mav.addObject("supplier", supplierService.getDetail(code));
        return mav;
    }

    @Override
    @RequestMapping(value = "/supplier/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("web/Supplier/Supplier-add");
        return mav;
    }

    @Override
    public ModelAndView toEdit(HttpServletRequest request, int fid) {
        return null;
    }

    @Override
    @RequestMapping(value = "/supplier/auto-list")
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        ModelAndView mav = new ModelAndView("web/Supplier/Supplier");
        mav.addObject("supplierlist", supplierService.getTipList(fnumber));
        return mav;
    }*/
}
