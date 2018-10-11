package com.linkpal.controller;

import com.linkpal.model.Datardataseat;
import com.linkpal.model.Page;
import com.linkpal.service.*;
import com.linkpal.util.StringUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import java.util.List;
import java.util.Map;


@Controller
public class DataRDataseatController
{
    private static final Logger log = Logger.getLogger(DataRDataseatController.class);
	
    @Autowired
    private IDataRDataseatService dataRDataseatService;
    
    @Autowired
	private IMaterialService materialService;
    
    @Autowired
    private IDataseatService DataseatService;
    
    
    @Autowired
   	private IStockService stockService;
    
    @Autowired
   	private IDataCabinetService cabinetService;
    
    @Autowired
   	private IDataSCabinetService scabinetService;
    
    
    @RequestMapping(value = "/datardataseat/index")
	@RequiresPermissions("datardataseat:view")
    public ModelAndView Index()
    {
    	ModelAndView mav=new ModelAndView("web/datardataseat/index");
    	//mav.addObject("model",new Datardataseat());
    	mav.addObject("materiallist", materialService.getList());
    	mav.addObject("dataseatlist",DataseatService.getList());
    	mav.addObject("stocklist", stockService.getList());
    	mav.addObject("cabinetlist", cabinetService.getList());
    	mav.addObject("scabinetlist", scabinetService.getList());
    	return mav;
    }
 
    @RequestMapping(value = "/datardataseat/getList")
	@RequiresPermissions("datardataseat:view")
    public ModelAndView getList(HttpServletRequest request,Datardataseat Datardataseat) 
    {

    	Datardataseat.setMaterial(materialService.getDetail(StringUtil.Change(Datardataseat.getFdataid())));
    	Datardataseat.setDataseat(DataseatService.getDetail(StringUtil.Change(Datardataseat.getFdataseatid())));
    	Datardataseat.setStock(stockService.getDetail(StringUtil.Change(Datardataseat.getFstockid())));
    	Datardataseat.setCabinet(cabinetService.getDetail(StringUtil.Change(Datardataseat.getFcabinetid())));
    	Datardataseat.setScabinet(scabinetService.getDetail(StringUtil.Change(Datardataseat.getFscabinetid())));
    	Map map=dataRDataseatService.getPageList(request, Datardataseat);
    	ModelAndView mav=new ModelAndView("web/datardataseat/index");
    	mav.addObject("datardataseatlist", (List<Datardataseat>) map.get("list"));
    	mav.addObject("page", (Page) map.get("page"));
    	mav.addObject("url", "materialrdataseat/getList");
    	mav.addObject("model",(Datardataseat) map.get("model"));
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("dataseatlist",DataseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());

    	return mav;
    }
    
    @RequestMapping(value = "/datardataseat/create")
	@RequiresPermissions("datardataseat:create")
    public ModelAndView Create()
    {
    	ModelAndView mav=new ModelAndView("web/datardataseat/edit");
    	Datardataseat Datardataseat=new Datardataseat();
    	mav.addObject("datardataseat",Datardataseat);
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("dataseatlist",DataseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/datardataseat/save")
    @POST
    public ModelAndView Save(HttpServletRequest request,Datardataseat Datardataseat) throws Exception {
    	if(StringUtil.Change(Datardataseat.getFid())==0)
    	{
			dataRDataseatService.create(Datardataseat)	;
    		
    	}
    	else
    	{
			dataRDataseatService.update(Datardataseat);
    	}
    	
    	 return  getList(request,(Datardataseat) request.getSession().getAttribute("Datardataseat")) ;
    }
    
    @RequestMapping(value = "/datardataseat/edit")
	@RequiresPermissions("datardataseat:edit")
    public ModelAndView Edit(int ID)
    {
    	ModelAndView mav=new ModelAndView("web/datardataseat/edit");
    	Datardataseat materialrdataseat=dataRDataseatService.getDetail(ID);
    	mav.addObject("datardataseat",materialrdataseat);
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("dataseatlist",DataseatService.getList());
		mav.addObject("stocklist", stockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", scabinetService.getList());
    	   return mav;
    }
    
    @RequestMapping(value = "/datardataseat/delete")
	@RequiresPermissions("datardataseat:delete")
    public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
		dataRDataseatService.delete(ID);
    	   return getList(request,(Datardataseat) request.getSession().getAttribute("Datardataseat"));
    }
    
    @RequestMapping(value = "/datardataseat/deleteBatch")
	@RequiresPermissions("datardataseat:delete")
    public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
    {
		dataRDataseatService.deleteBatch(ids);
    	return getList(request,(Datardataseat) request.getSession().getAttribute("Datardataseat"));
    }


}
