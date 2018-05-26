package com.linkpal.service;

import com.linkpal.model.Billget;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IBillGetService extends  IBaseService<Billget> {

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
}
