package com.linkpal.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;

import com.linkpal.model.Materialrgoodseat;
import com.linkpal.model.Page;
import com.linkpal.service.*;
import com.linkpal.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MaterialRGoodseatController
{
    private static final Logger log = Logger.getLogger(MaterialRGoodseatController.class);
	
    @Autowired
    private IMaterialRGoodseatService MaterialRGoodseatService;
    
    @Autowired
	private IMaterialService materialService;
    
    @Autowired
    private IGoodseatService GoodseatService;
    
    
    @Autowired
   	private IStockService stockService;
    
    @Autowired
   	private ICabinetService cabinetService;
    
    @Autowired
   	private ISCabinetService scabinetService;
    
    
    @RequestMapping(value = "/materialrgoodseat/index")
    public ModelAndView Index()
    {
    	ModelAndView mav=new ModelAndView("web/materialrgoodseat/index");
    	//mav.addObject("model",new Materialrgoodseat());
    	mav.addObject("materiallist", materialService.getList());
    	mav.addObject("goodseatlist",GoodseatService.getList());
    	mav.addObject("stocklist", stockService.getList());
    	mav.addObject("cabinetlist", cabinetService.getList());
    	mav.addObject("scabinetlist", scabinetService.getList());
    	return mav;
    }
 
    @RequestMapping(value = "/materialrgoodseat/getList")
    public ModelAndView getList(HttpServletRequest request,Materialrgoodseat MaterialRGoodseat) 
    {

    	MaterialRGoodseat.setMaterial(materialService.getDetail(StringUtil.Change(MaterialRGoodseat.getFmaterialid())));
    	MaterialRGoodseat.setGoodseat(GoodseatService.getDetail(StringUtil.Change(MaterialRGoodseat.getFgoodseatid())));
    	MaterialRGoodseat.setStock(stockService.getDetail(StringUtil.Change(MaterialRGoodseat.getFstockid())));
    	MaterialRGoodseat.setCabinet(cabinetService.getDetail(StringUtil.Change(MaterialRGoodseat.getFcabinetid())));
    	MaterialRGoodseat.setScabinet(scabinetService.getDetail(StringUtil.Change(MaterialRGoodseat.getFscabinetid())));
    	Map map=MaterialRGoodseatService.getPageList(request, MaterialRGoodseat);
    	ModelAndView mav=new ModelAndView("web/materialrgoodseat/index");
    	mav.addObject("materialrgoodseatlist", (List<Materialrgoodseat>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "materialrgoodseat/getList");
    	mav.addObject("model",(Materialrgoodseat) map.get("model"));
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("goodseatlist",GoodseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());

    	return mav;
    }
    
    @RequestMapping(value = "/materialrgoodseat/create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/materialrgoodseat/edit");
    	Materialrgoodseat MaterialRGoodseat=new Materialrgoodseat();
    	mav.addObject("materialrgoodseat",MaterialRGoodseat);
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("goodseatlist",GoodseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/materialrgoodseat/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Materialrgoodseat MaterialRGoodseat) throws Exception {
    	if(StringUtil.Change(MaterialRGoodseat.getFid())==0)
    	{
    		MaterialRGoodseatService.create(MaterialRGoodseat)	;
    		
    	}
    	else
    	{
    		MaterialRGoodseatService.update(MaterialRGoodseat);
    	}
    	
    	 return  getList(request,(Materialrgoodseat) request.getSession().getAttribute("MaterialRGoodseat")) ;
    }
    
    @RequestMapping(value = "/materialrgoodseat/edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/materialrgoodseat/edit");
    	Materialrgoodseat materialrgoodseat=MaterialRGoodseatService.getDetail(ID);
    	mav.addObject("MaterialRGoodseat",materialrgoodseat);
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("goodseatlist",GoodseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/materialrgoodseat/delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
    	MaterialRGoodseatService.delete(ID);
    	   return getList(request,(Materialrgoodseat) request.getSession().getAttribute("MaterialRGoodseat"));
    }
    
    @RequestMapping(value = "/materialrgoodseat/deleteBatch")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
    	MaterialRGoodseatService.deleteBatch(ids);
    	return getList(request,(Materialrgoodseat) request.getSession().getAttribute("MaterialRGoodseat"));
    }
    
/*    @RequestMapping(value = "/MaterialRGoodseat/adjustGoodseat")
    public ModelAndView adjustGoodseat(int ID)
    {
    	ModelAndView mav=new ModelAndView("/materialrgoodseat/adjust");
    	MaterialRGoodseat MaterialRGoodseat=MaterialRGoodseatService.getDetail(ID);
    	mav.addObject("MaterialRGoodseat",MaterialRGoodseat);
    	mav.addObject("materialList", materialService.getAllList());
    	mav.addObject("GoodseatList",GoodseatService.getAllList());
    	   return mav;
    }
    
    @RequestMapping(value = "/MaterialRGoodseat/doAdjust")
    public ModelAndView doAdjust(HttpServletRequest request)
    {
    	service.ajustGoodseat(BuildMapUtil.getMap(request));
    	return getList(request,(MaterialRGoodseat) request.getSession().getAttribute("MaterialRGoodseat"));
    }*/
}
