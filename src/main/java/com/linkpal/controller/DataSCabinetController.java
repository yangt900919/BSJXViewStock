package com.linkpal.controller;

import com.linkpal.model.Page;
import com.linkpal.model.Datascabinet;
import com.linkpal.service.*;
import com.linkpal.util.CheckOnlyContext;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class DataSCabinetController
{
    private static final Logger log = Logger.getLogger(DataSCabinetController.class);
	
    @Autowired
   	private IDataSCabinetService scabinetService;
    
    @Autowired
	private IDataCabinetService cabinetService;
    
    @Autowired
	private IDataCabinetTypeService cabinetTypeService;
    
  
    
    @Autowired
   	private IStockService stockService;
    
    @RequestMapping(value = "/datascabinet/index")
	@RequiresPermissions("datascabinet:view")
    public ModelAndView Index()
    {
    	ModelAndView mav=new ModelAndView("web/datascabinet/index");
    	mav.addObject("model",new Datascabinet());
    	mav.addObject("cabinetlist", cabinetService.getList());
    	mav.addObject("cabinettypelist", cabinetTypeService.getList());
    	mav.addObject("stocklist", stockService.getList());
    	return mav;
    }
	
    @RequestMapping(value = "/datascabinet/getList")
	@RequiresPermissions("datascabinet:view")
    public ModelAndView getList(HttpServletRequest request,Datascabinet scabinet) 
    {


    	scabinet.setCabinet(cabinetService.getDetail(StringUtil.Change(scabinet.getFcabinetid())));
    	scabinet.setCabinettype(cabinetTypeService.getDetail(StringUtil.Change(scabinet.getFcabinettypeid())));
    	//datascabinet.setContainerType(containerTypeService.getDetail(scabinet.getFContainerTypeID()));
    	scabinet.setStock(stockService.getDetail(StringUtil.Change(scabinet.getFstockid())));
    	Map map=scabinetService.getPageList(request, scabinet);
    	ModelAndView mav=new ModelAndView("web/datascabinet/index");
    	mav.addObject("scabinetlist", (List<Datascabinet>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "datascabinet/getList");
    	mav.addObject("model",(Datascabinet) map.get("model"));
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("cabinettypelist", cabinetTypeService.getList());
		mav.addObject("stocklist", stockService.getList());
    	return mav;
    }
    
    @RequestMapping(value = "/datascabinet/create")
	@RequiresPermissions("datascabinet:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/datascabinet/edit");
    	Datascabinet scabinet=new Datascabinet();
    	scabinet.setFid(0);
    	mav.addObject("datascabinet", scabinet);
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("cabinettypelist", cabinetTypeService.getList());
		mav.addObject("stocklist", stockService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/datascabinet/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Datascabinet scabinet) throws Exception {
    	if(scabinet.getFid()==null)
    	{
    		scabinetService.create(scabinet);
    		
    	}
    	else
    	{
    		scabinetService.update(scabinet);
    	}
    	
    	 return  getList(request,(Datascabinet) request.getSession().getAttribute("Datascabinet")) ;
    }
    
    @RequestMapping(value = "/datascabinet/edit")
	@RequiresPermissions("datascabinet:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/datascabinet/edit");
    	Datascabinet scabinet=scabinetService.getDetail(ID);
    	mav.addObject("datascabinet",scabinet);
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("cabinettypelist", cabinetTypeService.getList());
		mav.addObject("stocklist", stockService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/datascabinet/delete")
	@RequiresPermissions("datascabinet:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	scabinetService.delete(ID);
    	   return getList(request,(Datascabinet) request.getSession().getAttribute("Datascabinet"));
    }
    
    @RequestMapping(value = "/datascabinet/deleteBatch")
	@RequiresPermissions("datascabinet:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	System.out.print(ids);
    	return getList(request,(Datascabinet) request.getSession().getAttribute("Datascabinet"));
    }
    
    @RequestMapping(value = "/datascabinet/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Datascabinet model=null;
		if(ID==0)model=new Datascabinet();
		else model=scabinetService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFnumber(), scabinetService, param, ID));
    }

	@RequestMapping(value = "/datascabinet/print")
	@RequiresPermissions("datascabinet:print")
	public ModelAndView Print(HttpServletRequest request,Integer[] qrcodes)
	{
		ModelAndView mav=  getList(request,(Datascabinet) request.getSession().getAttribute("Datascabinet"));
		//ModelAndView mav=new ModelAndView("web/maboxprint/maboxprint");
		List<Datascabinet> mpboxlist=new ArrayList<>();
		for(Integer code:qrcodes)
		{
			mpboxlist.add(scabinetService.getDetail(code));
		}
		mav.addObject("isscprint",mpboxlist.size());
		mav.addObject("scplist", mpboxlist);
		return mav;
	}
 
}
