package com.linkpal.dao;

import com.linkpal.model.Inventory;

import java.util.List;
import java.util.Map;

public interface IInventoryDao  {

/*    public List<Inventory> getDetailByGoodseat(String fnumber);

    public List<Inventory> getDetailByGoodseat(int fid);*/
    /**
     * 获取所有列表
     * @return
     */
    public List<Inventory> getAllList();

    /**
     * 获取所查询的列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Inventory> getList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getTotalNum(Map map);
    /**
     * 更新库存数量
     * @param ID
     * @return
     */
    public int updateQty(Map map);

    /**
     * 获取导出列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Inventory> getExportList(Map map);
}
