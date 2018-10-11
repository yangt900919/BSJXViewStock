package com.linkpal.dao;

import com.linkpal.model.Dataoperatelog;
import com.linkpal.model.Operatelog;

import java.util.List;
import java.util.Map;

public interface IDataOperateLogDao {

    public List<Dataoperatelog> getList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getTotalNum(Map map);
}
