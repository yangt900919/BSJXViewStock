package com.linkpal.service;

import com.linkpal.model.Dsprint;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IDsPrintService extends IBaseService<Dsprint>{

 /*   List<Dsprint> getStockDsprints(int stockid);

    List<Dsprint> getNoCabinetDsprints(int stockid);

    List<Dsprint> getCabinetDsprints(int stockid);

    List<Dsprint> getCabinetDsprints(int stockid, int cabinetid);*/

    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Dsprint t);

}
