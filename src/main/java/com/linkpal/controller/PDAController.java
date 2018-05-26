package com.linkpal.controller;

import com.alibaba.fastjson.JSON;
import com.linkpal.model.Inventory;
import com.linkpal.model.Operation;
import com.linkpal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

@Controller
public class PDAController {

    @Autowired
    IBillService billService;

    @Autowired
    IStockService stock;

    @Autowired
    ICabinetService cabinetService;

    @Autowired
    IGoodseatService goodseatService;

    @Autowired
    IInventoryService inventoryService;
/*
    @RequestMapping(value = "/pda/bills")
    public void getList(HttpServletRequest request, HttpServletResponse response, int userID) throws Exception{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(billService.getStockBills(userID)));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/pda/mags")
    public void getMaGsList(HttpServletRequest request, HttpServletResponse response, int stockid) throws Exception{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //response.getWriter().write(JSON.toJSONString(goodseatService.getStockGoodseats(stockid)));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/pad/inventories")
    @POST
    public void receiveInventory(HttpServletRequest request, HttpServletResponse response, Inventory inventory) throws Exception{
        response.setHeader("Content-type", "text/html;charset=UTF-8");

    }

    @RequestMapping(value = "/pda/operations")
    @POST
    public void receiveOperation(HttpServletRequest request, HttpServletResponse response,  Operation operation) throws Exception{
        response.setHeader("Content-type", "text/html;charset=UTF-8");

    }

    @RequestMapping(value = "/pad/movegs")
    @POST
    public void receiveMoveAction(HttpServletRequest request, HttpServletResponse response,  Operation operation) throws Exception{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
    }*/
}
