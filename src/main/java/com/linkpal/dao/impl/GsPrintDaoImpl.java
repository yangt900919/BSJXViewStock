package com.linkpal.dao.impl;

import com.linkpal.dao.IGsPrintDao;
import com.linkpal.map.GsPrintMapper;
import com.linkpal.model.GsPrint;
import com.linkpal.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("GsPrintDaoImpl")
public class GsPrintDaoImpl implements IGsPrintDao {

    @Autowired
    GsPrintMapper gsPrintMapper;

    @Override
    public GsPrint getById(int ID) {
        return gsPrintMapper.getById(ID);
    }

    @Override
    public int add(GsPrint t) {
        return gsPrintMapper.add(t);
    }

    @Override
    public int update(GsPrint t) {
        return gsPrintMapper.update(t);
    }

    @Override
    public int delete(int ID) {
        return gsPrintMapper.delete(ID);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return gsPrintMapper.deleteBatch(ids);
    }

    @Override
    public List<GsPrint> getList(int pageIndex, int pageSize, GsPrint t) {
        return gsPrintMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public int getTotalNum(GsPrint t) {
        return gsPrintMapper.getTotalNum(t);
    }


}
