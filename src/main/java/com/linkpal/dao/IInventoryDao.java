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


    /**
     * 获取所查询的列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Inventory> getMaList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getMaTotalNum(Map map);

    /**
     * 获取导出列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Inventory> getMaExportList(Map map);


    /**
     * 获取所查询的列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Inventory> getMgList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getMgTotalNum(Map map);

    /**
     * 获取导出列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Inventory> getMgExportList(Map map);


    public List<Map<String,Object>> getZJList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getZJTotalNum(Map map);

    /**
     * 获取导出列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Map<String,Object>> getZJExportList(Map map);


    public List<Map<String,Object>> getZJMaList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getZJMaTotalNum(Map map);

    /**
     * 获取导出列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Map<String,Object>> getZJMaExportList(Map map);





    public List<Map<String,Object>> getHGList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getHGTotalNum(Map map);

    /**
     * 获取导出列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Map<String,Object>> getHGExportList(Map map);


    public List<Map<String,Object>> getHGMaList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getHGMaTotalNum(Map map);

    /**
     * 获取导出列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Map<String,Object>> getHGMaExportList(Map map);



    public List<Inventory> getInventoryDetail(Map map);
}
