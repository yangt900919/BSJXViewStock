package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Page;
import com.linkpal.model.Stock;
import com.linkpal.service.IStockService;
import com.linkpal.util.CheckOnlyContext;
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
public class StockController {

    @Autowired
    IStockService stockService;

/*    @Override
    @RequestMapping(value = "/stock/create")
    @POST
    public void create(HttpServletRequest request, HttpServletResponse response, Stock stock) throws Exception {
        if(stockService.create(stock)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/stock/delete")
    @POST
    public void delete(HttpServletRequest request, HttpServletResponse response, int fid) throws Exception {
        if(stockService.delete(fid)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/stock/edit")
    @POST
    public void update(HttpServletRequest request, HttpServletResponse response, Stock stock) throws Exception {
        if(stockService.update(stock)){
            response.getWriter().write("ok");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    @Override
    @RequestMapping(value = "/stock/list")
    public ModelAndView getList(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("web/Warehouse/Warehouse");
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }

    @Override
    @RequestMapping(value = "/stock/part-list")
    public void getTipList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String stocknumber = request.getParameter("stocknumber");
        response.getWriter().write(JSON.toJSONString(stockService.getTipList(stocknumber)));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    @RequestMapping(value = "/stock/detail")
    public ModelAndView getDetail(HttpServletRequest request){
        String stocknumber = request.getParameter("stocknumber");
        ModelAndView mav = new ModelAndView("web/Warehouse/Warehouse-change");
        Stock stock = stockService.getDetail(stocknumber);
        mav.addObject("stock", stock);
        return mav;
    }

    @Override
    @RequestMapping(value = "/stock/add")
    public ModelAndView toAdd() {
        ModelAndView mav = new ModelAndView("web/Warehouse/Warehouse-add");
        return mav;
    }

    @Override
    public ModelAndView toEdit(HttpServletRequest request, int fid) {
        return null;
    }

    @Override
    @RequestMapping(value = "/stock/auto-list")
    public ModelAndView getMatchList(HttpServletRequest request, String fnumber) {
        ModelAndView mav = new ModelAndView("web/Warehouse/Warehouse");
        mav.addObject("stocklist", stockService.getTipList(fnumber));
        return mav;
    }

    @RequestMapping(value = "stock/deletebatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        stockService.deleteBatch(ids);
        return getList(request,(Stock) request.getSession().getAttribute("Stock"));
    }*/

    @RequestMapping(value = "stock/getList")
    @RequiresPermissions("stock:view")
    public ModelAndView getList(HttpServletRequest request,Stock stock)
    {
        Map map=stockService.getPageList(request, stock);

        ModelAndView mav=new ModelAndView("web/Warehouse/Warehouse");

        mav.addObject("stocklist",(List<Stock>) map.get("list"));
        mav.addObject("page", (Page)map.get("page"));
        mav.addObject("url", "stock/getList");
        mav.addObject("model",(Stock) map.get("model"));
        return mav;
    }

    @RequestMapping(value = "/stock/create")
    @RequiresPermissions("stock:create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/Warehouse/edit");
        Stock stock=new Stock();
        stock.setFid(0);
        mav.addObject("stock", stock);
       // mav.addObject("areaList",areaService.getAllList());
        return mav;
    }

    @RequestMapping(value = "/stock/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Stock stock) throws Exception {
        if(stock.getFid()==null)
        {
            stockService.create(stock);

        }
        else
        {
            stockService.update(stock);
        }

        return  getList(request,(Stock) request.getSession().getAttribute("Stock")) ;
    }

    @RequestMapping(value = "/stock/edit")
    @RequiresPermissions("stock:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/Warehouse/edit");
        Stock stock= stockService.getDetail(ID);
        mav.addObject("stock",stock);
        //mav.addObject("areaList",areaService.getAllList());
        return mav;
    }

    @RequestMapping(value = "/stock/delete")
    @RequiresPermissions("stock:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        stockService.delete(ID);
        return getList(request,(Stock) request.getSession().getAttribute("Stock"));
    }

    @RequestMapping(value = "/stock/deleteBatch")
    @RequiresPermissions("stock:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        stockService.deleteBatch(ids);
        return getList(request,(Stock) request.getSession().getAttribute("Stock"));
    }


    @RequestMapping(value = "/stock/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CheckOnlyContext coc=new CheckOnlyContext();
        Stock model=null;
        if(ID==0)model=new Stock();
        else model=stockService.getDetail(ID);
        out.println( coc.CheckOnly(model.getStocknumber(), stockService, param, ID));
    }

}
