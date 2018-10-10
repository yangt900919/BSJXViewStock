package com.linkpal.controller;

import com.linkpal.model.ERPStock;
import com.linkpal.model.ERPStock;
import com.linkpal.model.Page;
import com.linkpal.service.IERPStockService;
import com.linkpal.service.IERPStockService;
import com.linkpal.service.IStockService;
import com.linkpal.service.ISupplierService;
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
public class ERPStockController
{
    private static final Logger log = Logger.getLogger(ERPStockController.class);  
	
    @Autowired
   	private IERPStockService erpstockService;
    
    @Autowired
	private IStockService stockService;
    
   
  


    @RequestMapping(value = "/erpstock/getList")
	@RequiresPermissions("erpstock:view")
    public ModelAndView getList(HttpServletRequest request,ERPStock stock)
    {


    	Map map=erpstockService.getPageList(request, stock);
    	ModelAndView mav=new ModelAndView("web/erpstock/index");
    	mav.addObject("erpstocklist", (List<ERPStock>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "erpstock/getList");
    	mav.addObject("model",(ERPStock) map.get("model"));
		mav.addObject("stocklist", stockService.getList());

    	return mav;
    }
    
    @RequestMapping(value = "/erpstock/create")
	@RequiresPermissions("erpstock:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/erpstock/edit");
    	ERPStock erpstock=new ERPStock();
    	//erpstock.setFbillno(erpstockService.getCSNo());
    	mav.addObject("erpstock", erpstock);
		mav.addObject("stocklist", stockService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/erpstock/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,ERPStock erpstock) throws Exception {
    	if(erpstock.getFid()==null)
    	{
    		erpstockService.add(erpstock);
    		
    	}
    	else
    	{
    		erpstockService.update(erpstock);
    	}
    	
    	 return  getList(request,(ERPStock) request.getSession().getAttribute("ERPStock")) ;
    }
    
    @RequestMapping(value = "/erpstock/edit")
	@RequiresPermissions("erpstock:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/erpstock/edit");
    	ERPStock erpstock=erpstockService.getById(ID);
    	mav.addObject("erpstock",erpstock);
		mav.addObject("stocklist", stockService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/erpstock/delete")
	@RequiresPermissions("erpstock:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	erpstockService.delete(ID);
		return  getList(request,(ERPStock) request.getSession().getAttribute("ERPStock")) ;
    }
    
    @RequestMapping(value = "/erpstock/deleteBatch")
	@RequiresPermissions("erpstock:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	erpstockService.deleteBatch(ids);
		return  getList(request,(ERPStock) request.getSession().getAttribute("ERPStock")) ;
    }



	@RequestMapping(value = "/erpstock/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	/*response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		SCabinet model=null;
		if(ID==0)model=new SCabinet();
		else model=erpstockService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFNumber(), erpstockService, param, ID));*/
    }  
 
}
