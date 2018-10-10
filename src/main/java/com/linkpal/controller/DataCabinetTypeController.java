package com.linkpal.controller;

import com.linkpal.model.Cabinettype;
import com.linkpal.model.Datacabinettype;
import com.linkpal.model.Page;
import com.linkpal.service.ICabinetTypeService;
import com.linkpal.service.IDataCabinetTypeService;
import com.linkpal.util.CheckOnlyContext;
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
public class DataCabinetTypeController
{
    private static final Logger log = Logger.getLogger(DataCabinetTypeController.class);
	
    @Autowired
	private IDataCabinetTypeService cabinetTypeService;
    
 
    @RequestMapping(value = "/datacabinettype/index")
    public String Index()
    {
    	return "web/datacabinettype/index";
    }
    
    @RequestMapping(value = "/datacabinettype/getList")
	@RequiresPermissions("datacabinettype:view")
    public ModelAndView getList(HttpServletRequest request,Datacabinettype cabinetType)
    {

    	Map map=cabinetTypeService.getPageList(request, cabinetType);
    	ModelAndView mav=new ModelAndView("web/datacabinettype/index");
    	mav.addObject("cabinetTypeList", (List<Datacabinettype>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "cabinettype/getList");
    	mav.addObject("model",(Datacabinettype) map.get("model"));
    	return mav;
    }
    
    @RequestMapping(value = "/datacabinettype/create")
	@RequiresPermissions("datacabinettype:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/datacabinettype/edit");
    	Datacabinettype cabinetType=new Datacabinettype();
		cabinetType.setFid(0);
    	mav.addObject("cabinettype",cabinetType);
    	   return mav;
    }
    
    @RequestMapping(value = "/datacabinettype/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Datacabinettype CabinetType) throws Exception {
    	if(CabinetType.getFid()==null)
    	{
    		cabinetTypeService.create(CabinetType);	
    		
    	}
    	else
    	{
    		cabinetTypeService.update(CabinetType);
    	}
    	
    	 return  getList(request,(Datacabinettype) request.getSession().getAttribute("Datacabinettype")) ;
    }
    
    @RequestMapping(value = "/datacabinettype/edit")
	@RequiresPermissions("datacabinettype:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/datacabinettype/edit");
    	Datacabinettype CabinetType=cabinetTypeService.getDetail(ID);
    	mav.addObject("cabinetType",CabinetType);
    	   return mav;
    }
    
    @RequestMapping(value = "/datacabinettype/delete")
	@RequiresPermissions("datacabinettype:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	cabinetTypeService.delete(ID);
    	   return getList(request,(Datacabinettype)request.getSession().getAttribute("Datacabinettype"));
    }
    
    @RequestMapping(value = "/datacabinettype/deleteBatch")
	@RequiresPermissions("datacabinettype:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	cabinetTypeService.deleteBatch(ids);
    	return getList(request,(Datacabinettype)request.getSession().getAttribute("Datacabinettype"));
    }
    
    @RequestMapping(value = "/datacabinettype/checkonly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		Datacabinettype model=null;
		if(ID==0)model=new Datacabinettype();
		else model=cabinetTypeService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFnumber(), cabinetTypeService, param, ID));
    }
}
