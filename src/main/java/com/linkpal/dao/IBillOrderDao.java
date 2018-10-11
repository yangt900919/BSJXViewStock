package com.linkpal.dao;

import com.linkpal.model.Billorder;
import com.linkpal.model.Billorderentry;

import java.util.List;
import java.util.Map;

public interface IBillOrderDao extends IBaseDao<Billorder> {
    List<Billorder> getList(Map map);

    int getTotalNum(Map map);

    public Billorderentry getentryDetail(Integer fid);

    String getAutoNumber();

    void deleteEntry(Integer fid);

    //int deleteEntry(Integer fid);

    String checkRelation(Map map);


    float getPushDownQty( Integer fentryid,Integer fid);

    List<Map<String,Object>> saveBillOrder(Map map);

    void updateStock(Map map);

}
