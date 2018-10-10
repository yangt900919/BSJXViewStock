package com.linkpal.controller;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Datacabinet;
import com.linkpal.model.Page;
import com.linkpal.service.ICabinetService;
import com.linkpal.service.IDataCabinetService;
import com.linkpal.service.ISCabinetService;
import com.linkpal.service.IStockService;
import com.linkpal.util.CheckOnlyContext;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataCabinetController {

    @Autowired
    IDataCabinetService cabinetService;

    @Autowired
    IStockService stockService;

    @Autowired
    ISCabinetService scabinetService;

    @RequestMapping(value = "/datacabinet/index")
    public String Index()
    {
        return "web/datacabinet/index";
    }

    @RequestMapping(value = "/datacabinet/getList")
    public ModelAndView getList(HttpServletRequest request,Datacabinet dcabinet)
    {

        dcabinet.setStock(stockService.getDetail(StringUtil.Change(dcabinet.getFstockid())));
        Map map=cabinetService.getPageList(request, dcabinet);
        ModelAndView mav=new ModelAndView("web/datacabinet/index");
        mav.addObject("datacabinetList", (List<Datacabinet>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "datacabinet/getList");
        mav.addObject("model",(Datacabinet) map.get("model"));
    mav.addObject("stocklist",stockService.getList());
        return mav;
    }

    @RequestMapping(value = "/datacabinet/create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/datacabinet/edit");
        Datacabinet cabinet=new Datacabinet();
        cabinet.setFid(0);
        mav.addObject("datacabinet", cabinet);
    mav.addObject("stocklist",stockService.getList());
        return mav;
    }

    @RequestMapping(value = "datacabinet/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Datacabinet cabinet) throws Exception
    {
        if(cabinet.getFid()==null)
        {
            cabinetService.create(cabinet);

        }
        else
        {
            cabinetService.update(cabinet);
        }

        return  getList(request,(Datacabinet) request.getSession().getAttribute("Datacabinet")) ;
    }

    @RequestMapping(value = "/datacabinet/edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("/web/datacabinet/edit");
        Datacabinet cabinet=cabinetService.getDetail(ID);
        mav.addObject("datacabinet",cabinet);
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }

    @RequestMapping(value = "/datacabinet/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception
    {
        cabinetService.delete(ID);
        return getList(request,(Datacabinet) request.getSession().getAttribute("Datacabinet"));
    }

    @RequestMapping(value = "/datacabinet/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        cabinetService.deleteBatch(ids);
        return getList(request,(Datacabinet) request.getSession().getAttribute("Datacabinet"));
    }

    @RequestMapping(value = "/datacabinet/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CheckOnlyContext coc=new CheckOnlyContext();
        Datacabinet model=null;
        if(ID==0)model=new Datacabinet();
        else model=cabinetService.getDetail(ID);
        out.println( coc.CheckOnly(model.getFnumber(), cabinetService, param, ID));
    }

    @RequestMapping(value = "/datacabinet/print")
    public ModelAndView Print(HttpServletRequest request,Integer[] qrcodes)
    {
        ModelAndView mav=  getList(request,(Datacabinet) request.getSession().getAttribute("Datacabinet"));
        //ModelAndView mav=new ModelAndView("web/maboxprint/maboxprint");
        List<Map<String,Object>> mpboxlist=new ArrayList<>();
        for(Integer code:qrcodes)
        {
            Datacabinet cabinet=cabinetService.getDetail(code);
           /* Scabinet scabinet=new Scabinet();
            scabinet.setDatacabinet(cabinet);
            scabinet.setFcabinetid(cabinet.getFid());*/
          Map map=new HashMap();
          map.put("cabprint",cabinet);
          map.put("sclist",cabinetService.getScabinetList(code));
            mpboxlist.add(map);
        }
        mav.addObject("iscprint",mpboxlist.size());
        mav.addObject("cplist", mpboxlist);
        return mav;
    }
/*
    @Override
    @POST
    @RequestMapping(value = "/datacabinet/create")
    public void create(HttpServletRequest request, HttpServletResponse response, Cabinet obj) throws Exception {
        if (cabinetService.create(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/datacabinet/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if (cabinetService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @POST
    @RequestMapping(value = "/datacabinet/update")
    public void update(HttpServletRequest request, HttpServletResponse response, Cabinet obj) throws Exception {
        if (cabinetService.update(obj)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/datacabinet/list")
    public ModelAndView getList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", cabinetService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/datacabinet/part-list")
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write(JSON.toJSONString(cabinetService.getTipList(request.getParameter(""))));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    @RequestMapping(value = "/datacabinet/detail")
    public ModelAndView getDetail(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", cabinetService.getDetail(request.getParameter("")));
        return mav;
    }

    @Override
    @RequestMapping(value = "/datacabinet/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", cabinetService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/datacabinet/edit")
    public ModelAndView toEdit(HttpServletRequest request, int fid) {
        ModelAndView mav = new ModelAndView("");
        mav.addObject("", cabinetService.getDetail(fid));
        return mav;
    }

    @Override
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        return null;
    }*/
}
