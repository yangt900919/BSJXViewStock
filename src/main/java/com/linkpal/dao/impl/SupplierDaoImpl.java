package com.linkpal.dao.impl;

import com.linkpal.dao.ISupplierDao;
import com.linkpal.map.SupplierMapper;
import com.linkpal.model.Page;
import com.linkpal.model.Supplier;
import com.linkpal.model.example.SupplierExample;
import com.linkpal.model.example.SupplierExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplierDaoImpl implements ISupplierDao{

    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public Supplier getDetail(String suppliernumber) {
        return supplierMapper.getSupplierDetail(suppliernumber);
    }

    @Override
    public Supplier getDetail(int fid) {
        return supplierMapper.selectByPrimaryKey(fid);
    }

    @Override
    public boolean create(Supplier supplier) {
        return supplierMapper.insert(supplier) > 0;
    }

    @Override
    public boolean update(Supplier supplier) {
        return supplierMapper.updateByPrimaryKey(supplier) > 0;
    }

    @Override
    public boolean delete(int fid) {
        return supplierMapper.deleteByPrimaryKey(fid) > 0;
    }

    @Override
    public List<Supplier> getList() {
        SupplierExample example = new SupplierExample();
        return supplierMapper.selectByExample(example);
    }

    @Override
    public List<Supplier> getTipList(String suppliernumber) {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andSuppliernumberLike("%" + suppliernumber + "%");
        return supplierMapper.selectByExample(example);
    }

    @Override
    public List<Supplier> showCurrentPage(int totalSize, int perSize) {
        return supplierMapper.getPageList(perSize, totalSize);
    }

    @Override
    public List<Supplier> showTipPageList(String fnumber, int totalSize, int perSize) {
        return supplierMapper.getTipPageList(perSize, totalSize, "%" + fnumber + "%");
    }

    @Override
    public int getTotalNum(Supplier supplier) {

        SupplierExample example=new SupplierExample();
        if(supplier.getSuppliernumber()!=null&&!(supplier.getSuppliernumber().equals("")))
            example.createCriteria().andSuppliernumberLike("%"+supplier.getSuppliernumber()+"%");
        if(supplier.getSuppliername()!=null&&!(supplier.getSuppliername().equals("")))
            example.createCriteria().andSuppliernameLike("%"+supplier.getSuppliername()+"%");
        return (int) supplierMapper.countByExample(example);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return supplierMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Supplier> getList(int pageIndex, int pageSize, Supplier supplier) {
        return supplierMapper.getList(pageIndex,pageSize,supplier);
    }
}
