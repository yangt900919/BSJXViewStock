package com.linkpal.dao;

import com.linkpal.model.Billreturn;

import java.util.List;
import java.util.Map;

public interface IBillReturnDao extends IBaseDao<Billreturn> {
    List<Billreturn> getList(Map map);

    int getTotalNum(Map map);

    String getAutoNumber();
}
