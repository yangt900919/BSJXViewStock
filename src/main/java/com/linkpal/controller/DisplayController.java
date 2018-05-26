package com.linkpal.controller;

import com.linkpal.service.ICabinetService;
import com.linkpal.service.IGoodseatService;
import com.linkpal.service.IInventoryService;
import com.linkpal.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DisplayController {

    @Autowired
    IStockService stockService;

    @Autowired
    ICabinetService cabinetService;

    @Autowired
    IGoodseatService goodseatService;

    @Autowired
    IInventoryService inventoryService;

    /**
     * 获取指定仓库的所有货位
     * @param request
     * @param stockid
     * @return
     */
    @RequestMapping(value = "/display/stock/goodseat")
    public ModelAndView showGoodseat(HttpServletRequest request, int stockid){
        ModelAndView mav = new ModelAndView("");
       // mav.addObject("", goodseatService.getStockGoodseats(stockid));
        return mav;
    }
    @RequestMapping(value = "/display/stock/list")
    public ModelAndView showList(){
        ModelAndView mav = new ModelAndView("web/plan/cabinet");
        return mav;
    }

    /**
     * 获取指定仓库的所有货架
     * @param request
     * @param stockid
     * @return
     */
    @RequestMapping(value = "/display/stock/cabinet")
    public ModelAndView showCabinet(HttpServletRequest request, int stockid){
        ModelAndView mav = new ModelAndView("");
       // mav.addObject("", cabinetService.getStockCabinet(stockid));
        return mav;
    }

    /**
     * 获取指定仓库的所有货架和货位
     * @param request
     * @param stockid
     * @return
     */
    @RequestMapping(value = "/display/stock/detail")
    public ModelAndView showCabinetAndGoodseat(HttpServletRequest request, int stockid){
        ModelAndView mav = new ModelAndView("");
       /* mav.addObject("", goodseatService.getNoCabinetGoodseats(stockid));
        mav.addObject("", cabinetService.getStockCabinet(stockid));*/
        return mav;
    }

    /**
     * 获取指定仓库货架的所有货位
     * @param request
     * @param stockid
     * @param cabinetid
     * @return
     */
    @RequestMapping(value = "/display/stock/cabinet/goodseat")
    public ModelAndView showCabinetAndGoodseat(HttpServletRequest request, int stockid, int cabinetid){
        ModelAndView mav = new ModelAndView("");
       /* mav.addObject("", goodseatService.getCabinetGoodseats(stockid));*/
        return mav;
    }

    /**
     * 添加无货架的货位物料展示
     * @param request
     * @param stockNumber
     * @return
     */
    @RequestMapping(value = "/display/stock/materials")
    public ModelAndView showMaterialsOnGoodseat(HttpServletRequest request, String stockNumber){
        ModelAndView mav = new ModelAndView("");
        int stockid = stockService.getDetail(stockNumber).getFid();
       /* mav.addObject("", inventoryService.showStockGoodseat(goodseatService.getNoCabinetGoodseats(stockid)));*/
        return mav;
    }

    /**
     * 添加有货架的货位物料展示
     * @param request
     * @param stockNumber
     * @param cabinetNumber
     * @return
     */
    @RequestMapping(value = "/display/stock/cabinet/materials")
    public ModelAndView showMaterialsOnCabinetGoodseat(HttpServletRequest request, String stockNumber, String cabinetNumber){
        ModelAndView mav = new ModelAndView("");
        int stockid = stockService.getDetail(stockNumber).getFid();
        int cabinetid = cabinetService.getDetail(cabinetNumber).getFid();
        //mav.addObject("", inventoryService.showStockGoodseat(goodseatService.getCabinetGoodseats(stockid, cabinetid)));
        return mav;
    }
}
