package com.linkpal.controller;

import com.linkpal.model.GsPrint;
import com.linkpal.model.GsPrint;
import com.linkpal.model.Page;
import com.linkpal.service.*;
import com.linkpal.service.IGsPrintService;
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
public class GsPrintController
{
    private static final Logger log = Logger.getLogger(GsPrintController.class);  
	
    @Autowired
   	private IGsPrintService gsprintService;
    
  /*  @Autowired
	private IGsPrintService materialService;*/
  @Autowired
  private IGoodseatService GoodseatService;


	@Autowired
	private IStockService stockService;

	@Autowired
	private ICabinetService cabinetService;

	@Autowired
	private ISCabinetService scabinetService;

	@Autowired
	private ICabinetTypeService cabinetTypeService;
  


    @RequestMapping(value = "/gsprint/getList")
	@RequiresPermissions("gsprint:view")
    public ModelAndView getList(HttpServletRequest request,GsPrint gsprint)
    {

		gsprint.setCabinettype(cabinetTypeService.getDetail(StringUtil.Change(gsprint.getFcabinettypeid())));
		gsprint.setGoodseat(GoodseatService.getDetail(StringUtil.Change(gsprint.getFgoodseatid())));
		gsprint.setStock(stockService.getDetail(StringUtil.Change(gsprint.getFstockid())));
		gsprint.setCabinet(cabinetService.getDetail(StringUtil.Change(gsprint.getFcabinetid())));
		gsprint.setScabinet(scabinetService.getDetail(StringUtil.Change(gsprint.getFscabinetid())));

		Map map=gsprintService.getPageList(request, gsprint);
    	ModelAndView mav=new ModelAndView("web/gsprint/index");
    	mav.addObject("gsprintlist", (List<GsPrint>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "gsprint/getList");
    	mav.addObject("model",(GsPrint) map.get("model"));
		mav.addObject("goodseatlist",GoodseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
		mav.addObject("cabinettypelist",cabinetTypeService.getList());
    	return mav;
    }
    
    @RequestMapping(value = "/gsprint/create")
	@RequiresPermissions("gsprint:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/gsprint/edit");
    	GsPrint gsprint=new GsPrint();
    	//gsprint.setFbillno(gsprintService.getCSNo());
    	mav.addObject("gsprint", gsprint);
		mav.addObject("goodseatlist",GoodseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
		mav.addObject("cabinettypelist",cabinetTypeService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/gsprint/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,GsPrint gsprint) throws Exception {
    	if(gsprint.getFid()==null)
    	{
    		gsprintService.add(gsprint);
    		
    	}
    	else
    	{
    		gsprintService.update(gsprint);
    	}
    	
    	 return  getList(request,(GsPrint) request.getSession().getAttribute("GsPrint")) ;
    }
    
    @RequestMapping(value = "/gsprint/edit")
	@RequiresPermissions("gsprint:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/gsprint/edit");
    	GsPrint gsprint=gsprintService.getById(ID);
    	mav.addObject("gsprint",gsprint);
		mav.addObject("goodseatlist",GoodseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
		mav.addObject("cabinettypelist",cabinetTypeService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/gsprint/delete")
	@RequiresPermissions("gsprint:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	gsprintService.delete(ID);
		return  getList(request,(GsPrint) request.getSession().getAttribute("GsPrint")) ;
    }
    
    @RequestMapping(value = "/gsprint/deleteBatch")
	@RequiresPermissions("gsprint:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	gsprintService.deleteBatch(ids);
		return  getList(request,(GsPrint) request.getSession().getAttribute("GsPrint")) ;
    }

	@RequestMapping(value = "/gsprint/print")
	@RequiresPermissions("gsprint:print")
	public ModelAndView Print(HttpServletRequest request,Integer[] qrcodes)
	{
		ModelAndView mav= getList(request,(GsPrint) request.getSession().getAttribute("GsPrint"));
		//ModelAndView mav=new ModelAndView("web/gsprint/gsprint");
		List<GsPrint> gplist=new ArrayList<>();
		for(Integer code:qrcodes)
		{
			gplist.add(gsprintService.getById(code));
		}
		mav.addObject("isgprint",gplist.size());
		mav.addObject("gplist", gplist);
		return mav;
	}


	@RequestMapping(value = "/gsprint/CheckOnly")
    @POST
    public void CheckOnly(HttpServletResponse response,String param,int ID) throws Exception
    {
    	/*response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CheckOnlyContext coc=new CheckOnlyContext();
		SCabinet model=null;
		if(ID==0)model=new SCabinet();
		else model=gsprintService.getDetail(ID);
    	out.println( coc.CheckOnly(model.getFNumber(), gsprintService, param, ID));*/
    }  
 
}
