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
        return inventoryMapper.getExportList(map);
    }

    @Override
    public List<Inventory> getMaList(Map map) {
        return inventoryMapper.getMaList(map);
    }

    @Override
    public int getMaTotalNum(Map map) {
        return inventoryMapper.getMaTotalNum(map);
    }

    @Override
    public List<Inventory> getMaExportList(Map map) {
        return inventoryMapper.getMaExportList(map);
    }

    @Override
    public List<Inventory> getMgList(Map map) {
        return inventoryMapper.getMgList(map);
    }

    @Override
    public int getMgTotalNum(Map map) {
        return inventoryMapper.getMgTotalNum(map);
    }

    @Override
    public List<Inventory> getMgExportList(Map map) {
        return inventoryMapper.getMgExportList(map);
    }

    @Override
    public List<Map<String,Object>> getZJList(Map map) {
        return inventoryMapper.getZJList(map);
    }

    @Override
    public int getZJTotalNum(Map map) {
        return inventoryMapper.getZJTotalNum(map);
    }

    @Override
    public List<Map<String,Object>> getZJExportList(Map map) {
        return inventoryMapper.getZJExportList(map);
    }

    @Override
    public List<Map<String,Object>> getZJMaList(Map map) {
        return inventoryMapper.getZJMaList(map);
    }

    @Override
    public int getZJMaTotalNum(Map map) {
        return inventoryMapper.getZJMaTotalNum(map);
    }

    @Override
    public List<Map<String,Object>> getZJMaExportList(Map map) {
        return inventoryMapper.getZJMaExportList(map);
    }

    @Override
    public List<Map<String,Object>> getHGList(Map map) {
        return inventoryMapper.getHGList(map);
    }

    @Override
    public int getHGTotalNum(Map map) {
        return inventoryMapper.getHGTotalNum(map);
    }

    @Override
    public List<Map<String,Object>> getHGExportList(Map map) {
        return inventoryMapper.getHGExportList(map);
    }

    @Override
    public List<Map<String,Object>> getHGMaList(Map map) {
        return inventoryMapper.getHGMaList(map);
    }

    @Override
    public int getHGMaTotalNum(Map map) {
        return inventoryMapper.getHGMaTotalNum(map);
    }

    @Override
    public List<Map<String,Object>> getHGMaExportList(Map map) {
        return inventoryMapper.getHGMaExportList(map);
    }

    @Override
    public List<Inventory> getInventoryDetail(Map map) {
        return inventoryMapper.getInventoryDetail(map);
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
