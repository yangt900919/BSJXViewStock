package com.linkpal.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Goodseat;
import com.linkpal.model.Page;
import com.linkpal.service.*;
import com.linkpal.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GoodseatController
{
    private static final Logger log = Logger.getLogger(GoodseatController.class);

    @Autowired
    private IGoodseatService GoodseatService;

    @Autowired
    private ISCabinetService scabinetService;

    @Autowired
    private ICabinetService cabinetService;



    @Autowired
    private IStockService stockService;


   /* @RequestMapping(value = "/goodseat/index")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("web/goodseat/index");
        mav.addObject("model",new Goodseat());
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }*/


    @RequestMapping(value = "/goodseat/getList")
    public ModelAndView getList(HttpServletRequest request,Goodseat Goodseat)
    {

        Goodseat.setScabinet(scabinetService.getDetail(StringUtil.Change(Goodseat.getFscabinetid())));
        Goodseat.setCabinet(cabinetService.getDetail(StringUtil.Change(Goodseat.getFcabinetid())));
        Goodseat.setStock(stockService.getDetail(StringUtil.Change(Goodseat.getFstockid())));
        Map map=GoodseatService.getPageList(request, Goodseat);
        ModelAndView mav=new ModelAndView("web/goodseat/index");
        mav.addObject("goodseatlist", (List<Goodseat>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "goodseat/getList");
        mav.addObject("model",(Goodseat) map.get("model"));
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("stocklist", stockService.getList());

        return mav;
    }

    @RequestMapping(value = "/goodseat/create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/goodseat/edit");
        Goodseat Goodseat=new Goodseat();
        mav.addObject("Goodseat", Goodseat);
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }

    @RequestMapping(value = "/goodseat/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Goodseat Goodseat) throws Exception {
        if(Goodseat.getFid()==0)
        {
            try {
                GoodseatService.create(Goodseat);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            GoodseatService.update(Goodseat);
        }

        return  getList(request,(Goodseat) request.getSession().getAttribute("Goodseat")) ;
    }

    @RequestMapping(value = "/goodseat/edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/goodseat/edit");
        Goodseat Goodseat=GoodseatService.getDetail(ID);
        mav.addObject("Goodseat",Goodseat);
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }

    @RequestMapping(value = "/goodseat/getinfo")
    public void GetInfo(HttpServletRequest request,HttpServletResponse response, int ID)
    {

  try{
      PrintWriter out=response.getWriter();
      Goodseat goodseat=GoodseatService.getDetail(ID);
      out.println(JSON.toJSONString(goodseat));
  }
  catch(Exception e){e.printStackTrace();}

    }

    @RequestMapping(value = "/goodseat/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        GoodseatService.delete(ID);
        return getList(request,(Goodseat) request.getSession().getAttribute("Goodseat"));
    }

    @RequestMapping(value = "/goodseat/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        GoodseatService.deleteBatch(ids);
        return getList(request,(Goodseat) request.getSession().getAttribute("Goodseat"));
    }

   /* @RequestMapping(value = "/goodseat/Close")
    public ModelAndView Close(HttpServletRequest request,int ID)
    {
    	service.close(ID);
    	   return getList(request,(Goodseat) request.getSession().getAttribute("Goodseat"));
    }

    @RequestMapping(value = "/goodseat/CloseBatch")
    public ModelAndView CloseBatch(HttpServletRequest request,Integer[] ids)
    {
    	service.closeBatch(ids);
    	return getList(request,(Goodseat) request.getSession().getAttribute("Goodseat"));
    }

    @RequestMapping(value = "/goodseat/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Goodseat model=null;
		if(ID==0)model=new Goodseat();
		else model=GoodseatService.getById(ID);
    	out.println( coc.CheckOnly(model.getFNumber(), GoodseatService, param, ID));
    }
    */

}
