package com.linkpal.dao.impl;

import com.linkpal.dao.IICStockBillDao;
import com.linkpal.map.IICStockBillMapper;
import com.linkpal.model.ICStockBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("ICStockBillDaoImpl")
public class ICStockBillDaoImpl implements IICStockBillDao {

    @Autowired
    IICStockBillMapper icstockBillMapper;

    @Override
    public ICStockBill getById(int ID) {
        return icstockBillMapper.getById(ID);
    }

    @Override
    public int add(ICStockBill t) {
        return icstockBillMapper.add(t);
    }

    @Override
    public int update(ICStockBill t) {
        return icstockBillMapper.update(t);
    }

    @Override
    public int delete(int ID) {
        return icstockBillMapper.delete(ID);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return icstockBillMapper.deleteBatch(ids);
    }

    @Override
    public List<ICStockBill> getList(Map map) {
        return icstockBillMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return icstockBillMapper.getTotalNum(map);
    }

    @Override
    public String getAutoNumber() {
        return icstockBillMapper.getAutoNumber();
    }


}
