package com.linkpal.dao;

import com.linkpal.model.Cabinet;
import com.linkpal.model.Datacabinet;
import com.linkpal.model.Datascabinet;

import java.util.List;

public interface IDataCabinetDao extends IBaseDao<Datacabinet> {


    List<Datascabinet> getDatascabinetList(Integer fid);
/*    public boolean deleteBatch(Integer[] ids);


    *//***
     * 按查询条件获取列表
     * @param
     * @return
     *//*
    public List<Cabinet> getList(int pageIndex, int pageSize, Cabinet t);*/




}
