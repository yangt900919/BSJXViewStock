package com.linkpal.dao;

import com.linkpal.model.Billget;
import com.linkpal.model.Billstock;

import java.util.List;
import java.util.Map;

public interface IBillStockDao extends IBaseDao<Billstock> {
    List<Billstock> getList(Map map);

    int getTotalNum(Map map);

    String getAutoNumber();
}
