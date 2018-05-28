package com.linkpal.service;

import com.linkpal.model.Billreturn;
import com.linkpal.model.Billreturnentry;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IBillReturnService extends  IBaseService<Billreturn> {

    /**
     * 获取分页信息
     * @param request
     * @return
     */
    public Map<String,Object> getPageList(HttpServletRequest request, Map map);
/*
    *//**
     * 获取查询的所有条数
     * @param
     * @return
     *//*
    public int getTotalNum(Map map);*/

    public boolean deleteBatch(Integer[] ids);

   // public Billreturnentry getentryDetail(Integer fid);
    String getAutoNumber();

   /* void deleteEntry(Integer fid);

    String checkRelation(Map map);


    float getPushDownQty(Integer fentryid, Integer fid);*/
}
