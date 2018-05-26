package com.linkpal.controller;

import com.linkpal.model.MaPrint;
import com.linkpal.model.MaPrint;
import com.linkpal.model.Page;
import com.linkpal.service.IMaPrintService;
import com.linkpal.service.IMaPrintService;
import com.linkpal.service.ISupplierService;
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
public class MaboxPrintController
{
    private static final Logger log = Logger.getLogger(MaboxPrintController.class);  
	
    @Autowired
   	private IMaPrintService maboxprintService;
    
    @Autowired
	private IMaPrintService materialService;
    
    @Autowired
	private ISupplierService supplierService;
    
  


    @RequestMapping(value = "/maboxprint/getList")
    public ModelAndView getList(HttpServletRequest request,MaPrint maprint)
    {


    	Map map=maboxprintService.getboxPageList(request, maprint);
    	ModelAndView mav=new ModelAndView("web/maboxprint/index");
    	mav.addObject("maboxprintlist", (List<MaPrint>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "maboxprint/getList");
    	mav.addObject("model",(MaPrint) map.get("model"));
		//mav.addObject("materiallist", materialService.getList());
		mav.addObject("supplierlist", supplierService.getList());
    	return mav;
    }
    
    @RequestMapping(value = "/maboxprint/create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/maboxprint/edit");
    	MaPrint maboxprint=new MaPrint();
		maboxprint.setFbillno(maboxprintService.getCSNo());
    	mav.addObject("maboxprint", maboxprint);
		//mav.addObject("materiallist", materialService.getList());
		mav.addObject("supplierlist", supplierService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/maboxprint/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,MaPrint maboxprint) throws Exception {
    	if(maboxprint.getFid()==null)
    	{
    		maboxprintService.add(maboxprint);
    		
    	}
    	else
    	{
    		maboxprintService.update(maboxprint);
    	}
    	
    	 return  getList(request,(MaPrint) request.getSession().getAttribute("MaboxPrint")) ;
    }
    
    @RequestMapping(value = "/maboxprint/edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/maboxprint/edit");
    	MaPrint maboxprint=maboxprintService.getById(ID);
    	mav.addObject("maboxprint",maboxprint);
		//mav.addObject("materiallist", materialService.getList());
		mav.addObject("supplierlist", supplierService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/maboxprint/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	maboxprintService.delete(ID);
		return  getList(request,(MaPrint) request.getSession().getAttribute("MaboxPrint")) ;
    }
    
    @RequestMapping(value = "/maboxprint/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	maboxprintService.deleteBatch(ids);
		return  getList(request,(MaPrint) request.getSession().getAttribute("MaboxPrint")) ;
    }

	@RequestMapping(value = "/maboxprint/print")
	public ModelAndView Print(HttpServletRequest request,Integer[] qrcodes)
	{
		ModelAndView mav= getList(request,(MaPrint) request.getSession().getAttribute("MaboxPrint"));
		//ModelAndView mav=new ModelAndView("web/maboxprint/maboxprint");
		List<MaPrint> mpboxlist=new ArrayList<>();
		for(Integer code:qrcodes)
		{
			mpboxlist.add(maboxprintService.getById(code));
		}
		mav.addObject("isboxprint",mpboxlist.size());
		mav.addObject("mpboxlist", mpboxlist);
		return mav;
	}


	@RequestMapping(value = "/maboxprint/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	/*response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		SCabinet model=null;
		if(ID==0)model=new SCabinet();
		else model=maboxprintService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFNumber(), maboxprintService, param, ID));*/
    }  
 
}
