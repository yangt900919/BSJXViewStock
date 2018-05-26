package com.linkpal.dao.impl;

import com.linkpal.dao.IMaPrintDao;
import com.linkpal.map.MaPrintMapper;
import com.linkpal.model.MaPrint;
import com.linkpal.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("MaPrintDaoImpl")
public class MaPrintDaoImpl implements IMaPrintDao {

    @Autowired
    MaPrintMapper maPrintMapper;

    @Override
    public MaPrint getById(int ID) {
        return maPrintMapper.getById(ID);
    }

    @Override
    public int add(MaPrint t) {
        return maPrintMapper.add(t);
    }

    @Override
    public int update(MaPrint t) {
        return maPrintMapper.update(t);
    }

    @Override
    public int delete(int ID) {
        return maPrintMapper.delete(ID);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return maPrintMapper.deleteBatch(ids);
    }

    @Override
    public List<MaPrint> getList(int pageIndex, int pageSize, Material t) {
        return maPrintMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public int getTotalNum(Material t) {
        return maPrintMapper.getTotalNum(t);
    }

    @Override
    public List<MaPrint> getboxList(int pageIndex, int pageSize, MaPrint t) {
        return maPrintMapper.getboxList(pageIndex,pageSize,t);
    }

    @Override
    public int getboxTotalNum(MaPrint t) {
        return maPrintMapper.getboxTotalNum(t);
    }

    @Override
    public String getCSNo() {
        return maPrintMapper.getCSNo();
    }
}
