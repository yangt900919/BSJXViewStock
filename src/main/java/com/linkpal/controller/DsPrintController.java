package com.linkpal.controller;


import com.linkpal.model.Dsprint;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class DsPrintController
{
    private static final Logger log = Logger.getLogger(DsPrintController.class);  
	
    @Autowired
   	private IDsPrintService dsprintService;
    
  /*  @Autowired
	private IDsPrintService materialService;*/
  @Autowired
  private IDataseatService DataseatService;


	@Autowired
	private IStockService stockService;

	@Autowired
	private IDataCabinetService cabinetService;

	@Autowired
	private IDataSCabinetService scabinetService;

	@Autowired
	private IDataCabinetTypeService cabinetTypeService;
  


    @RequestMapping(value = "/dsprint/getList")
	@RequiresPermissions("dsprint:view")
    public ModelAndView getList(HttpServletRequest request,Dsprint dsprint)
    {

		dsprint.setCabinettype(cabinetTypeService.getDetail(StringUtil.Change(dsprint.getFcabinettypeid())));
		dsprint.setDataseat(DataseatService.getDetail(StringUtil.Change(dsprint.getFdataseatid())));
		dsprint.setStock(stockService.getDetail(StringUtil.Change(dsprint.getFstockid())));
		dsprint.setCabinet(cabinetService.getDetail(StringUtil.Change(dsprint.getFcabinetid())));
		dsprint.setScabinet(scabinetService.getDetail(StringUtil.Change(dsprint.getFscabinetid())));

		Map map=dsprintService.getPageList(request, dsprint);
    	ModelAndView mav=new ModelAndView("web/dsprint/index");
    	mav.addObject("dsprintlist", (List<Dsprint>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "dsprint/getList");
    	mav.addObject("model",(Dsprint) map.get("model"));
		mav.addObject("dataseatlist",DataseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
		mav.addObject("cabinettypelist",cabinetTypeService.getList());
    	return mav;
    }
    
    @RequestMapping(value = "/dsprint/create")
	@RequiresPermissions("dsprint:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/dsprint/edit");
    	Dsprint dsprint=new Dsprint();
    	//dsprint.setFbillno(dsprintService.getCSNo());
    	mav.addObject("dsprint", dsprint);
		mav.addObject("dataseatlist",DataseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
		mav.addObject("cabinettypelist",cabinetTypeService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/dsprint/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Dsprint dsprint) throws Exception {
    	if(dsprint.getFid()==null)
    	{
    		dsprintService.create(dsprint);
    		
    	}
    	else
    	{
    		dsprintService.update(dsprint);
    	}
    	
    	 return  getList(request,(Dsprint) request.getSession().getAttribute("Dsprint")) ;
    }
    
    @RequestMapping(value = "/dsprint/edit")
	@RequiresPermissions("dsprint:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/dsprint/edit");
    	Dsprint dsprint=dsprintService.getDetail(ID);
    	mav.addObject("dsprint",dsprint);
		mav.addObject("dataseatlist",DataseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
		mav.addObject("cabinettypelist",cabinetTypeService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/dsprint/delete")
	@RequiresPermissions("dsprint:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	dsprintService.delete(ID);
		return  getList(request,(Dsprint) request.getSession().getAttribute("Dsprint")) ;
    }
    
    @RequestMapping(value = "/dsprint/deleteBatch")
	@RequiresPermissions("dsprint:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	dsprintService.deleteBatch(ids);
		return  getList(request,(Dsprint) request.getSession().getAttribute("Dsprint")) ;
    }

	@RequestMapping(value = "/dsprint/print")
	@RequiresPermissions("dsprint:print")
	public ModelAndView Print(HttpServletRequest request,Integer[] qrcodes)
	{
		ModelAndView mav= getList(request,(Dsprint) request.getSession().getAttribute("Dsprint"));
		//ModelAndView mav=new ModelAndView("web/dsprint/dsprint");
		List<Dsprint> gplist=new ArrayList<>();
		for(Integer code:qrcodes)
		{
			gplist.add(dsprintService.getDetail(code));
		}
		mav.addObject("isdprint",gplist.size());
		mav.addObject("dplist", gplist);
		return mav;
	}


	@RequestMapping(value = "/dsprint/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	/*response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		SCabinet model=null;
		if(ID==0)model=new SCabinet();
		else model=dsprintService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFNumber(), dsprintService, param, ID));*/
    }  
 
}
