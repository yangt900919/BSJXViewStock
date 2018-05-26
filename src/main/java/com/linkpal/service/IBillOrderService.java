package com.linkpal.service;

import com.linkpal.model.Billorder;
import com.linkpal.model.Billorderentry;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IBillOrderService extends  IBaseService<Billorder> {

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

    public Billorderentry getentryDetail(Integer fid);
    String getAutoNumber();

    void deleteEntry(Integer fid);

    String checkRelation(Map map);


    float getPushDownQty( Integer fentryid,Integer fid);
}
