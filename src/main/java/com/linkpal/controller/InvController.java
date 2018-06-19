package com.linkpal.controller;

import com.linkpal.model.Inv;
import com.linkpal.model.Page;
import com.linkpal.service.IInvService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class InvController
{
    private static final Logger log = Logger.getLogger(InvController.class);  
	
    @Autowired
	private IInvService invService;
    
 
    @RequestMapping(value = "/inv/index")
    public String Index()
    {
    	return "web/inv/index";
    }
    
    @RequestMapping(value = "/inv/getList")
	@RequiresPermissions("inv:view")
    public ModelAndView getList(HttpServletRequest request,Inv inv)
    {

    	Map map=invService.getPageList(request, inv);
    	ModelAndView mav=new ModelAndView("web/inv/index");
    	mav.addObject("invList", (List<Inv>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "inv/getList");
    	mav.addObject("model",(Inv) map.get("model"));
    	return mav;
    }
    
    @RequestMapping(value = "/inv/create")
	@RequiresPermissions("inv:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/inv/edit");
    	Inv inv=new Inv();
		inv.setFid(0);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

		inv.setFname(sdf.format(new Date()) );
		inv.setFcreatetime(new Date());
		inv.setFstate(0);
		inv.setFdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    	mav.addObject("inv",inv);
    	   return mav;
    }

	@RequestMapping(value = "/inv/entry")
	public ModelAndView getEntryList(int ID)
	{

		ModelAndView mav=new ModelAndView("web/inv/entry");
		mav.addObject("inventryList", invService.getDetail(ID).getInventries());
		return mav;
	}


	@RequestMapping(value = "/inv/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Inv Inv) throws Exception {
    	if(Inv.getFid()==null)
    	{
    		invService.create(Inv);	
    		
    	}
    	else
    	{
    		invService.update(Inv);
    	}
    	
    	 return  getList(request,(Inv) request.getSession().getAttribute("Inv")) ; 
    }
    
    @RequestMapping(value = "/inv/edit")
	@RequiresPermissions("inv:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/inv/edit");
    	Inv Inv=invService.getDetail(ID);
    	mav.addObject("inv",Inv);
    	   return mav;
    }
    
    @RequestMapping(value = "/inv/delete")
	@RequiresPermissions("inv:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	invService.delete(ID);
    	   return getList(request,(Inv)request.getSession().getAttribute("Inv"));
    }
    
    @RequestMapping(value = "/inv/deleteBatch")
	@RequiresPermissions("inv:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	invService.deleteBatch(ids);
    	return getList(request,(Inv)request.getSession().getAttribute("Inv"));
    }

	@RequestMapping(value = "/inv/close")
	public ModelAndView Close(HttpServletRequest request,int ID)
	{
		invService.close(ID);
		return getList(request,(Inv)request.getSession().getAttribute("Inv")) ;
	}

	@RequestMapping(value = "/inv/closeBatch")
	public ModelAndView CloseBatch(HttpServletRequest request,Integer[] ids)
	{
		invService.closeBatch(ids);
		return getList(request,(Inv)request.getSession().getAttribute("Inv")) ;
	}
}
