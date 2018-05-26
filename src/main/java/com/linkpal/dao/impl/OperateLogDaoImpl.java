package com.linkpal.dao.impl;

import com.linkpal.dao.IOperateLogDao;
import com.linkpal.map.OperatelogMapper;
import com.linkpal.model.Operatelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("OperateLogDaoImpl")
public class OperateLogDaoImpl implements IOperateLogDao {

    @Autowired
    OperatelogMapper operatelogMapper;

    @Override
    public List<Operatelog> getList(Map map) {
        return operatelogMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return operatelogMapper.getTotalNum(map);
    }
}
