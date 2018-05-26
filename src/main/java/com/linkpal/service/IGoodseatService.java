package com.linkpal.service;

import com.linkpal.model.Goodseat;
import com.linkpal.model.Scabinet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IGoodseatService extends IBaseService<Goodseat>{

 /*   List<Goodseat> getStockGoodseats(int stockid);

    List<Goodseat> getNoCabinetGoodseats(int stockid);

    List<Goodseat> getCabinetGoodseats(int stockid);

    List<Goodseat> getCabinetGoodseats(int stockid, int cabinetid);*/

    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Goodseat t);

}
