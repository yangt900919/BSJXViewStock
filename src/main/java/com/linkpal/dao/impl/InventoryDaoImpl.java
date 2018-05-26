package com.linkpal.dao.impl;

import com.linkpal.dao.IInventoryDao;
import com.linkpal.map.InventoryMapper;
import com.linkpal.model.Inventory;
import com.linkpal.model.InventoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class InventoryDaoImpl implements IInventoryDao {

    @Autowired
    InventoryMapper inventoryMapper;

    @Override
    public List<Inventory> getAllList() {
        return inventoryMapper.getAllList();
    }

    @Override
    public List<Inventory> getList(Map map) {
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
    public List<Inventory> getExportList(Map map) {
        return null;
    }
/*
    @Override
    public boolean create(Inventory inventory) {
        InventoryExample example = new InventoryExample();
        example.createCriteria().andFmaidEqualTo(inventory.getFmaid());
        example.createCriteria().andFgoodseatidEqualTo(inventory.getFgoodseatid());
        example.createCriteria().andFstockidEqualTo(inventory.getFstockid());
        if (inventoryMapper.selectByExample(example) == null){
            return inventoryMapper.insert(inventory) > 0;
        }
        return false;
    }

    @Override
    public boolean update(Inventory inventory) {
        InventoryExample example = new InventoryExample();
        example.createCriteria().andFidEqualTo(inventory.getFid());
        return inventoryMapper.updateByExample(inventory, example) > 0;
    }

    @Override
    public boolean delete(int fid) {
        InventoryExample example = new InventoryExample();
        example.createCriteria().andFidEqualTo(fid);
        return inventoryMapper.deleteByExample(example) > 0;
    }

    @Override
    public List<Inventory> getList() {
        return inventoryMapper.selectByExample(new InventoryExample());
    }

    @Override
    public Inventory getDetail(String fnumber) {
        return null;
    }

    @Override
    public Inventory getDetail(int fid) {
        return null;
    }

    @Override
    public List<Inventory> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Inventory> showCurrentPage(int totalSize, int preSize) {
        return inventoryMapper.showCurrentPage(totalSize, preSize);
    }

    @Override
    public List<Inventory> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Inventory inventory) {
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return false;
    }

    @Override
    public List<Inventory> getList(int pageIndex, int pageSize, Inventory inventory) {
        return null;
    }

    @Override
    public List<Inventory> getDetailByGoodseat(String fnumber) {
        return inventoryMapper.getDetail(fnumber);
    }

    @Override
    public List<Inventory> getDetailByGoodseat(int fid) {
        return inventoryMapper.getDetailByID(fid);
    }*/

}
