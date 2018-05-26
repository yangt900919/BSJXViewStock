package com.linkpal.dao;

import com.linkpal.dao.IBaseDao;
import com.linkpal.model.Bill;
import com.linkpal.model.Billget;

import java.util.List;
import java.util.Map;

public interface IBillGetDao extends IBaseDao<Billget> {
    List<Billget> getList(Map map);

    int getTotalNum(Map map);

    String getAutoNumber();
}
