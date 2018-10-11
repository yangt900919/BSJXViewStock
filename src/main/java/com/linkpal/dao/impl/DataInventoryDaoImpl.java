package com.linkpal.dao.impl;

import com.linkpal.dao.IDataInventoryDao;
import com.linkpal.map.DatainventoryMapper;
import com.linkpal.model.Datainventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("DataInventoryDaoImpl")
public class DataInventoryDaoImpl implements IDataInventoryDao {

    @Autowired
    DatainventoryMapper inventoryMapper;

    @Override
    public List<Datainventory> getAllList() {
        return inventoryMapper.getAllList();
    }

    @Override
    public List<Datainventory> getList(Map map) {
        return inventoryMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return inventoryMapper.getTotalNum(map);
    }

    @Override
    public int updateQty(Map map) {
        return inventoryMapper.updateQty(map);
    }

    @Override
    public List<Datainventory> getExportList(Map map) {
        return inventoryMapper.getExportList(map);
    }
/*
    @Override
    public boolean create(Datainventory inventory) {
        DatainventoryExample example = new DatainventoryExample();
        example.createCriteria().andFmaidEqualTo(inventory.getFmaid());
        example.createCriteria().andFgoodseatidEqualTo(inventory.getFgoodseatid());
        example.createCriteria().andFstockidEqualTo(inventory.getFstockid());
        if (inventoryMapper.selectByExample(example) == null){
            return inventoryMapper.insert(inventory) > 0;
        }
        return false;
    }

    @Override
    public boolean update(Datainventory inventory) {
        DatainventoryExample example = new DatainventoryExample();
        example.createCriteria().andFidEqualTo(inventory.getFid());
        return inventoryMapper.updateByExample(inventory, example) > 0;
    }

    @Override
    public boolean delete(int fid) {
        DatainventoryExample example = new DatainventoryExample();
        example.createCriteria().andFidEqualTo(fid);
        return inventoryMapper.deleteByExample(example) > 0;
    }

    @Override
    public List<Datainventory> getList() {
        return inventoryMapper.selectByExample(new DatainventoryExample());
    }

    @Override
    public Datainventory getDetail(String fnumber) {
        return null;
    }

    @Override
    public Datainventory getDetail(int fid) {
        return null;
    }

    @Override
    public List<Datainventory> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Datainventory> showCurrentPage(int totalSize, int preSize) {
        return inventoryMapper.showCurrentPage(totalSize, preSize);
    }

    @Override
    public List<Datainventory> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Datainventory inventory) {
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return false;
    }

    @Override
    public List<Datainventory> getList(int pageIndex, int pageSize, Datainventory inventory) {
        return null;
    }

    @Override
    public List<Datainventory> getDetailByGoodseat(String fnumber) {
        return inventoryMapper.getDetail(fnumber);
    }

    @Override
    public List<Datainventory> getDetailByGoodseat(int fid) {
        return inventoryMapper.getDetailByID(fid);
    }*/

}
