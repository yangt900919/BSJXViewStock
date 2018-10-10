package com.linkpal.controller;

import com.linkpal.model.ERPStock;
import com.linkpal.model.ICStockBill;
import com.linkpal.model.Page;
import com.linkpal.model.User;
import com.linkpal.service.*;
import com.linkpal.service.IICStockBillService;
import com.linkpal.util.DateUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ICStockBillController
{
    private static final Logger log = Logger.getLogger(ICStockBillController.class);  
	
    @Autowired
   	private IICStockBillService icstockbillService;
    
    @Autowired
	private IMaterialService materialService;
    
    @Autowired
	private IGoodseatService goodseatService;

    @Autowired
	private  IERPStockService ierpStockService;

    @Autowired
	private ICabinetService cabinetService;

    @Autowired
	private  ISCabinetService isCabinetService;


	@RequestMapping(value = "/icstockbill/getList")
	@ResponseBody
	@RequiresPermissions("icstockbill:view")
	public ModelAndView getList(HttpServletRequest request,@RequestParam Map<String, Object> params)
	{

		if(params==null) params=new HashMap<>();
		if(params.size()==0)
		{
			params.put("sdate", DateUtil.getDatePreM());
			params.put("edate",DateUtil.getDateNow());

		}


		Map map=icstockbillService.getPageList(request, params);
		ModelAndView mav=new ModelAndView("web/icstockbill/index");
		mav.addObject("icstockbilllist", (List<ICStockBill>) map.get("list"));
		mav.addObject("page", (Page) map.get("page"));
		mav.addObject("url", "icstockbill/getList");
		mav.addObject("model",(Map<String, Object>) map.get("model"));
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("goodseatlist", goodseatService.getList());
		mav.addObject("erpstocklist", ierpStockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", isCabinetService.getList());
		return mav;
	}

	@RequestMapping(value = "/icstockbill/create")
	@RequiresPermissions("icstockbill:create")
	public ModelAndView Create(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView("web/icstockbill/edit");
		ICStockBill icstockbill=new ICStockBill();
		icstockbill.setFNumber(icstockbillService.getAutoNumber());
		User user= (User) request.getSession().getAttribute("user");
		icstockbill.setFcreatorID(user.getFid());
		icstockbill.setCreator(user);
		//ERPStock stock=user.getErpStocks().get(0);
		//icstockbill.setStock(stock);
		//icstockbill.setFStockID(stock.getFid());
		if(user.getErpStocks().size()>0)
		{
		ERPStock stock=user.getErpStocks().get(0);
		icstockbill.setFStockID(stock.getFid());
		icstockbill.setStock(stock);}
		mav.addObject("icstockbill", icstockbill);
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("goodseatlist", goodseatService.getList());
		mav.addObject("erpstocklist", ierpStockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", isCabinetService.getList());
		return mav;
	}


	@RequestMapping(value = "/icstockbill/save")
	@POST
	public ModelAndView Save(HttpServletRequest request,ICStockBill icstockbill) throws Exception {
		if(icstockbill.getFID()==0)
		{
			icstockbillService.add(icstockbill);

		}
		else
		{
			icstockbillService.update(icstockbill);
		}

		return  getList(request,(Map<String,Object>) request.getSession().getAttribute("ICStockBill")) ;
	}

	@RequestMapping(value = "/icstockbill/edit")
	@RequiresPermissions("icstockbill:edit")
	public ModelAndView Edit(int ID)
	{
		ModelAndView mav=new ModelAndView("web/icstockbill/edit");
		ICStockBill icstockbill=icstockbillService.getById(ID);
		mav.addObject("icstockbill", icstockbill);
		mav.addObject("materiallist", materialService.getList());
		mav.addObject("goodseatlist", goodseatService.getList());
		mav.addObject("erpstocklist", ierpStockService.getList());
		mav.addObject("cabinetlist", cabinetService.getList());
		mav.addObject("scabinetlist", isCabinetService.getList());
		return mav;
	}

	@RequestMapping(value = "/icstockbill/delete")
	@RequiresPermissions("icstockbill:delete")
	public ModelAndView Delete(HttpServletRequest request,int ID) throws Exception {
		icstockbillService.delete(ID);
		return  getList(request,(Map<String,Object>) request.getSession().getAttribute("ICStockBill")) ;
	}

	@RequestMapping(value = "/icstockbill/deleteBatch")
	@RequiresPermissions("icstockbill:delete")
	public ModelAndView DeleteBatch(HttpServletRequest request,Integer[] ids)
	{
		icstockbillService.deleteBatch(ids);
		return  getList(request,(Map<String,Object>)  request.getSession().getAttribute("ICStockBill")) ;
	}

}
