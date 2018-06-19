package com.linkpal.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import com.linkpal.model.Cabinettype;
import com.linkpal.model.Page;
import com.linkpal.service.ICabinetTypeService;
import com.linkpal.util.CheckOnlyContext;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class CabinetTypeController
{
    private static final Logger log = Logger.getLogger(CabinetTypeController.class);  
	
    @Autowired
	private ICabinetTypeService cabinetTypeService;
    
 
    @RequestMapping(value = "/cabinettype/index")
    public String Index()
    {
    	return "web/cabinettype/index";
    }
    
    @RequestMapping(value = "/cabinettype/getList")
	@RequiresPermissions("cabinettype:view")
    public ModelAndView getList(HttpServletRequest request,Cabinettype cabinetType)
    {

    	Map map=cabinetTypeService.getPageList(request, cabinetType);
    	ModelAndView mav=new ModelAndView("web/cabinettype/index");
    	mav.addObject("cabinetTypeList", (List<Cabinettype>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "cabinettype/getList");
    	mav.addObject("model",(Cabinettype) map.get("model"));
    	return mav;
    }
    
    @RequestMapping(value = "/cabinettype/create")
	@RequiresPermissions("cabinettype:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/cabinettype/edit");
    	Cabinettype cabinetType=new Cabinettype();
		cabinetType.setFid(0);
    	mav.addObject("cabinettype",cabinetType);
    	   return mav;
    }
    
    @RequestMapping(value = "/cabinettype/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Cabinettype CabinetType) throws Exception {
    	if(CabinetType.getFid()==null)
    	{
    		cabinetTypeService.create(CabinetType);	
    		
    	}
    	else
    	{
    		cabinetTypeService.update(CabinetType);
    	}
    	
    	 return  getList(request,(Cabinettype) request.getSession().getAttribute("CabinetType")) ; 
    }
    
    @RequestMapping(value = "/cabinettype/edit")
	@RequiresPermissions("cabinettype:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/cabinettype/edit");
    	Cabinettype CabinetType=cabinetTypeService.getDetail(ID);
    	mav.addObject("cabinetType",CabinetType);
    	   return mav;
    }
    
    @RequestMapping(value = "/cabinettype/delete")
	@RequiresPermissions("cabinettype:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	cabinetTypeService.delete(ID);
    	   return getList(request,(Cabinettype)request.getSession().getAttribute("CabinetType"));
    }
    
    @RequestMapping(value = "/cabinettype/deleteBatch")
	@RequiresPermissions("cabinettype:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	cabinetTypeService.deleteBatch(ids);
    	return getList(request,(Cabinettype)request.getSession().getAttribute("CabinetType"));
    }
    
    @RequestMapping(value = "/cabinettype/checkonly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Cabinettype model=null;
		if(ID==0)model=new Cabinettype();
		else model=cabinetTypeService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFnumber(), cabinetTypeService, param, ID));
    }
}
