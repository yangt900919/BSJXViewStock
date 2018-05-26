package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Material;
import com.linkpal.model.Page;
import com.linkpal.model.MaPrint;
import com.linkpal.service.IMaterialService;
import com.linkpal.service.ISupplierService;
import com.linkpal.service.IMaPrintService;
import com.linkpal.service.IStockService;
import com.linkpal.util.StringUtil;
import org.apache.log4j.Logger;
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
public class MaPrintController
{
    private static final Logger log = Logger.getLogger(MaPrintController.class);  
	
    @Autowired
   	private IMaPrintService maprintService;
    
    @Autowired
	private IMaterialService materialService;
    
    @Autowired
	private ISupplierService supplierService;
    
  


    @RequestMapping(value = "/maprint/getList")
    public ModelAndView getList(HttpServletRequest request,Material material)
    {


    	Map map=maprintService.getPageList(request, material);
    	ModelAndView mav=new ModelAndView("web/maprint/index");
    	mav.addObject("maprintlist", (List<MaPrint>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "maprint/getList");
    	mav.addObject("model",(Material) map.get("model"));
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("supplierlist", supplierService.getList());
    	return mav;
    }
    
    @RequestMapping(value = "/maprint/create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/maprint/edit");
    	MaPrint maprint=new MaPrint();
    	maprint.setFbillno(maprintService.getCSNo());
    	mav.addObject("maprint", maprint);
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("supplierlist", supplierService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/maprint/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,MaPrint maprint) throws Exception {
    	if(maprint.getFid()==null)
    	{
    		maprintService.add(maprint);
    		
    	}
    	else
    	{
    		maprintService.update(maprint);
    	}
    	
    	 return  getList(request,(Material) request.getSession().getAttribute("MaPrint")) ;
    }
    
    @RequestMapping(value = "/maprint/edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/maprint/edit");
    	MaPrint maprint=maprintService.getById(ID);
    	mav.addObject("maprint",maprint);
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("supplierlist", supplierService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/maprint/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	maprintService.delete(ID);
		return  getList(request,(Material) request.getSession().getAttribute("MaPrint")) ;
    }
    
    @RequestMapping(value = "/maprint/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	maprintService.deleteBatch(ids);
		return  getList(request,(Material) request.getSession().getAttribute("MaPrint")) ;
    }

	@RequestMapping(value = "/maprint/print")
	public ModelAndView Print(HttpServletRequest request,Integer[] qrcodes)
	{
		ModelAndView mav= getList(request,(Material) request.getSession().getAttribute("MaPrint"));
		//ModelAndView mav=new ModelAndView("web/maprint/maprint");
		List<MaPrint> mplist=new ArrayList<>();
		for(Integer code:qrcodes)
		{
			mplist.add(maprintService.getById(code));
		}
		mav.addObject("isprint",mplist.size());
		mav.addObject("mplist", mplist);
		return mav;
	}


	@RequestMapping(value = "/maprint/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	/*response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		SCabinet model=null;
		if(ID==0)model=new SCabinet();
		else model=maprintService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFNumber(), maprintService, param, ID));*/
    }  
 
}
