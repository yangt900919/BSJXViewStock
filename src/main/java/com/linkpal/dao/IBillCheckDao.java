package com.linkpal.dao;

import com.linkpal.model.Billcheck;
import com.linkpal.model.Billcheckentry;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IBillCheckDao extends IBaseDao<Billcheck> {
    List<Billcheck> getList(Map map);

    int getTotalNum(Map map);

    String getAutoNumber();

    Billcheckentry getentryDetail(Integer fid);

    String checkRelation(Map map);


    float getPushDownQty( Integer fentryid,Integer fid);

    String initAutoboxno( String fonumber);
}
