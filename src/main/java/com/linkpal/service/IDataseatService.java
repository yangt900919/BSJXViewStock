package com.linkpal.service;

import com.linkpal.model.Dataseat;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IDataseatService extends IBaseService<Dataseat>{

 /*   List<Dataseat> getStockDataseats(int stockid);

    List<Dataseat> getNoCabinetDataseats(int stockid);

    List<Dataseat> getCabinetDataseats(int stockid);

    List<Dataseat> getCabinetDataseats(int stockid, int cabinetid);*/

    public boolean deleteBatch(Integer[] ids);

    public Map<String, Object> getPageList(HttpServletRequest request, Dataseat t);

}
