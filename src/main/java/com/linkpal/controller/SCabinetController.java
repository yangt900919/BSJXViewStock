package com.linkpal.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import com.linkpal.model.MaPrint;
import com.linkpal.model.Page;
import com.linkpal.model.Scabinet;
import com.linkpal.service.ICabinetService;
import com.linkpal.service.ICabinetTypeService;
import com.linkpal.service.ISCabinetService;
import com.linkpal.service.IStockService;
import com.linkpal.util.CheckOnlyContext;
import com.linkpal.util.StringUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class SCabinetController
{
    private static final Logger log = Logger.getLogger(SCabinetController.class);  
	
    @Autowired
   	private ISCabinetService scabinetService;
    
    @Autowired
	private ICabinetService cabinetService;
    
    @Autowired
	private ICabinetTypeService cabinetTypeService;
    
  
    
    @Autowired
   	private IStockService stockService;
    
    @RequestMapping(value = "/scabinet/index")
	@RequiresPermissions("scabinet:view")
    public ModelAndView Index()
    {
    	ModelAndView mav=new ModelAndView("web/scabinet/index");
    	mav.addObject("model",new Scabinet());
    	mav.addObject("cabinetlist", cabinetService.getList());
    	mav.addObject("cabinettypelist", cabinetTypeService.getList());
    	mav.addObject("stocklist", stockService.getList());
    	return mav;
    }
	
    @RequestMapping(value = "/scabinet/getList")
	@RequiresPermissions("scabinet:view")
    public ModelAndView getList(HttpServletRequest request,Scabinet scabinet) 
    {


    	scabinet.setCabinet(cabinetService.getDetail(StringUtil.Change(scabinet.getFcabinetid())));
    	scabinet.setCabinettype(cabinetTypeService.getDetail(StringUtil.Change(scabinet.getFcabinettypeid())));
    	//scabinet.setContainerType(containerTypeService.getDetail(scabinet.getFContainerTypeID()));
    	scabinet.setStock(stockService.getDetail(StringUtil.Change(scabinet.getFstockid())));
    	Map map=scabinetService.getPageList(request, scabinet);
    	ModelAndView mav=new ModelAndView("web/scabinet/index");
    	mav.addObject("scabinetlist", (List<Scabinet>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "scabinet/getList");
    	mav.addObject("model",(Scabinet) map.get("model"));
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("cabinettypelist", cabinetTypeService.getList());
		mav.addObject("stocklist", stockService.getList());
    	return mav;
    }
    
    @RequestMapping(value = "/scabinet/create")
	@RequiresPermissions("scabinet:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/scabinet/edit");
    	Scabinet scabinet=new Scabinet();
    	scabinet.setFid(0);
    	mav.addObject("scabinet", scabinet);
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("cabinettypelist", cabinetTypeService.getList());
		mav.addObject("stocklist", stockService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/scabinet/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Scabinet scabinet) throws Exception {
    	if(scabinet.getFid()==null)
    	{
    		scabinetService.create(scabinet);
    		
    	}
    	else
    	{
    		scabinetService.update(scabinet);
    	}
    	
    	 return  getList(request,(Scabinet) request.getSession().getAttribute("SCabinet")) ;
    }
    
    @RequestMapping(value = "/scabinet/edit")
	@RequiresPermissions("scabinet:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/scabinet/edit");
    	Scabinet scabinet=scabinetService.getDetail(ID);
    	mav.addObject("scabinet",scabinet);
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("cabinettypelist", cabinetTypeService.getList());
		mav.addObject("stocklist", stockService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/scabinet/delete")
	@RequiresPermissions("scabinet:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	scabinetService.delete(ID);
    	   return getList(request,(Scabinet) request.getSession().getAttribute("SCabinet"));
    }
    
    @RequestMapping(value = "/scabinet/deleteBatch")
	@RequiresPermissions("scabinet:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	System.out.print(ids);
    	return getList(request,(Scabinet) request.getSession().getAttribute("SCabinet"));
    }
    
    @RequestMapping(value = "/scabinet/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Scabinet model=null;
		if(ID==0)model=new Scabinet();
		else model=scabinetService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFnumber(), scabinetService, param, ID));
    }

	@RequestMapping(value = "/scabinet/print")
	@RequiresPermissions("scabinet:print")
	public ModelAndView Print(HttpServletRequest request,Integer[] qrcodes)
	{
		ModelAndView mav=  getList(request,(Scabinet) request.getSession().getAttribute("SCabinet"));
		//ModelAndView mav=new ModelAndView("web/maboxprint/maboxprint");
		List<Scabinet> mpboxlist=new ArrayList<>();
		for(Integer code:qrcodes)
		{
			mpboxlist.add(scabinetService.getDetail(code));
		}
		mav.addObject("isscprint",mpboxlist.size());
		mav.addObject("scplist", mpboxlist);
		return mav;
	}
 
}
