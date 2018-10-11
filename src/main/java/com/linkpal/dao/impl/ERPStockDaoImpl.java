package com.linkpal.dao.impl;

import com.linkpal.dao.IERPStockDao;
import com.linkpal.map.ERPStockMapper;
import com.linkpal.model.ERPStock;
import com.linkpal.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ERPStockDaoImpl")
public class ERPStockDaoImpl implements IERPStockDao {

    @Autowired
    ERPStockMapper erpStockMapper;

    @Override
    public ERPStock getById(int ID) {
        return erpStockMapper.getById(ID);
    }

    @Override
    public int add(ERPStock t) {
        return erpStockMapper.add(t);
    }

    @Override
    public int update(ERPStock t) {
        return erpStockMapper.update(t);
    }

    @Override
    public int delete(int ID) {
        return erpStockMapper.delete(ID);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return erpStockMapper.deleteBatch(ids);
    }

    @Override
    public List<ERPStock> getAllList() {
        return erpStockMapper.getAllList();
    }

    @Override
    public List<ERPStock> getList(int pageIndex, int pageSize, ERPStock t) {
        return erpStockMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public int getTotalNum(ERPStock t) {
        return erpStockMapper.getTotalNum(t);
    }



}
