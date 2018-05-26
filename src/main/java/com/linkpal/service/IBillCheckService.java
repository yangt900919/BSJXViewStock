package com.linkpal.service;

import com.linkpal.model.Billcheck;
import com.linkpal.model.Billcheckentry;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IBillCheckService extends  IBaseService<Billcheck> {

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
    String getAutoNumber();

    Billcheckentry getentryDetail(Integer fid);

    String checkRelation(Map map);


    float getPushDownQty( Integer fentryid,Integer fid);

    String initAutoboxno( String fonumber);
}
