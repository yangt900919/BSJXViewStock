package com.linkpal.dao;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Materialrgoodseat;

import java.util.List;
import java.util.Map;

public interface IMaterialRGoodSeatDao extends IBaseDao<Materialrgoodseat> {

    void ajustGoodsSeat(Map map);
/*
    *//**
     * 批量删除
     * @param ids
     * @return
     *//*
    public boolean deleteBatch(Integer[] ids);


    *//***
     * 按查询条件获取列表
     * @param
     * @return
     *//*
    public List<Materialrgoodseat> getList(int pageIndex, int pageSize, Materialrgoodseat t);*/



}
