package com.linkpal.dao.impl;

import com.linkpal.dao.IDataOperateLogDao;
import com.linkpal.dao.IOperateLogDao;
import com.linkpal.map.DataoperatelogMapper;
import com.linkpal.map.OperatelogMapper;
import com.linkpal.model.Dataoperatelog;
import com.linkpal.model.Operatelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("DataOperateLogDaoImpl")
public class DataOperateLogDaoImpl implements IDataOperateLogDao {

    @Autowired
    DataoperatelogMapper operatelogMapper;

    @Override
    public List<Dataoperatelog> getList(Map map) {
        return operatelogMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return operatelogMapper.getTotalNum(map);
    }
}
