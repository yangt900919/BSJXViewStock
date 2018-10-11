package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Dataseat;
import com.linkpal.model.Page;
import com.linkpal.service.*;
import com.linkpal.util.StringUtil;
import org.apache.log4j.Logger;
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
public class DataseatController
{
    private static final Logger log = Logger.getLogger(DataseatController.class);

    @Autowired
    private IDataseatService DataseatService;

    @Autowired
    private IDataSCabinetService scabinetService;

    @Autowired
    private IDataCabinetService cabinetService;



    @Autowired
    private IStockService stockService;


   /* @RequestMapping(value = "dataseat/index")
    public ModelAndView Index()
    {
        ModelAndView mav=new ModelAndView("webdataseat/index");
        mav.addObject("model",new Dataseat());
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }*/


    @RequestMapping(value = "dataseat/getList")
    @RequiresPermissions("dataseat:view")
    public ModelAndView getList(HttpServletRequest request,Dataseat Dataseat)
    {

        Dataseat.setScabinet(scabinetService.getDetail(StringUtil.Change(Dataseat.getFscabinetid())));
        Dataseat.setCabinet(cabinetService.getDetail(StringUtil.Change(Dataseat.getFcabinetid())));
        Dataseat.setStock(stockService.getDetail(StringUtil.Change(Dataseat.getFstockid())));
        Map map=DataseatService.getPageList(request, Dataseat);
        ModelAndView mav=new ModelAndView("web/dataseat/index");
        mav.addObject("dataseatlist", (List<Dataseat>) map.get("list"));
        mav.addObject("page", (Page) map.get("page"));
        mav.addObject("url", "goodseat/getList");
        mav.addObject("model",(Dataseat) map.get("model"));
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("stocklist", stockService.getList());

        return mav;
    }

    @RequestMapping(value = "dataseat/create")
    @RequiresPermissions("dataseat:create")
    public ModelAndView Create()
    {
        ModelAndView mav=new ModelAndView("web/dataseat/edit");
        Dataseat Dataseat=new Dataseat();
        mav.addObject("dataseat", Dataseat);
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }

    @RequestMapping(value = "dataseat/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Dataseat Dataseat) throws Exception {
        if(Dataseat.getFid()==0)
        {
            try {
                DataseatService.create(Dataseat);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            DataseatService.update(Dataseat);
        }

        return  getList(request,(Dataseat) request.getSession().getAttribute("Dataseat")) ;
    }

    @RequestMapping(value = "dataseat/edit")
    @RequiresPermissions("dataseat:edit")
    public ModelAndView Edit(int ID)
    {
        ModelAndView mav=new ModelAndView("web/dataseat/edit");
        Dataseat Dataseat=DataseatService.getDetail(ID);
        mav.addObject("dataseat",Dataseat);
        mav.addObject("scabinetlist", scabinetService.getList());
        mav.addObject("cabinetlist", cabinetService.getList());
        mav.addObject("stocklist", stockService.getList());
        return mav;
    }

    @RequestMapping(value = "dataseat/getinfo")
    public void GetInfo(HttpServletRequest request,HttpServletResponse response, int ID)
    {

  try{
      PrintWriter out=response.getWriter();
      Dataseat goodseat=DataseatService.getDetail(ID);
      out.println(JSON.toJSONString(goodseat));
  }
  catch(Exception e){e.printStackTrace();}

    }

    @RequestMapping(value = "dataseat/delete")
    @RequiresPermissions("dataseat:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
        DataseatService.delete(ID);
        return getList(request,(Dataseat) request.getSession().getAttribute("Dataseat"));
    }

    @RequestMapping(value = "dataseat/deleteBatch")
    @RequiresPermissions("dataseat:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
        DataseatService.deleteBatch(ids);
        return getList(request,(Dataseat) request.getSession().getAttribute("Dataseat"));
    }

   /* @RequestMapping(value = "dataseat/Close")
    public ModelAndView Close(HttpServletRequest request,int ID)
    {
    	service.close(ID);
    	   return getList(request,(Dataseat) request.getSession().getAttribute("Dataseat"));
    }

    @RequestMapping(value = "dataseat/CloseBatch")
    public ModelAndView CloseBatch(HttpServletRequest request,Integer[] ids)
    {
    	service.closeBatch(ids);
    	return getList(request,(Dataseat) request.getSession().getAttribute("Dataseat"));
    }

    @RequestMapping(value = "dataseat/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Dataseat model=null;
		if(ID==0)model=new Dataseat();
		else model=DataseatService.getById(ID);
    	out.println( coc.CheckOnly(model.getFNumber(), DataseatService, param, ID));
    }
    */

}
