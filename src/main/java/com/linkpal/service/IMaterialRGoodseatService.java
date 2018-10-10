package com.linkpal.service;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Cabinettype;
import com.linkpal.model.Materialrgoodseat;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IMaterialRGoodseatService extends IBaseService<Materialrgoodseat> {
    public boolean deleteBatch(Integer[] ids);

    public Map<String,Object> getPageList(HttpServletRequest request, Materialrgoodseat t);

    void ajustGoodsSeat(Map map);
}
