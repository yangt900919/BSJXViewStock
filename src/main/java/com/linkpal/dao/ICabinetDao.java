package com.linkpal.dao;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Scabinet;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface ICabinetDao extends IBaseDao<Cabinet> {


    List<Scabinet> getScabinetList(Integer fid);
/*    public boolean deleteBatch(Integer[] ids);


    *//***
     * 按查询条件获取列表
     * @param
     * @return
     *//*
    public List<Cabinet> getList(int pageIndex, int pageSize, Cabinet t);*/




}
