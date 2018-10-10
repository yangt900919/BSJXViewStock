package com.linkpal.service;

import com.linkpal.model.Goodseat;
import com.linkpal.model.Inventory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IInventoryService  {


    public List<Inventory> getAllList();

    /**
     * 获取分页信息
     * @param request
     * @return
     */
    public Map<String,Object> getPageList(HttpServletRequest request, Map map);

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
    public Map<String,Object> getMaPageList(HttpServletRequest request, Map map);

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
    public Map<String,Object> getMgPageList(HttpServletRequest request, Map map);

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









    public List<Inventory> getInventoryDetail(Map map);


    public Map<String,Object> getZJPageList(HttpServletRequest request, Map map);

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


    public Map<String,Object> getZJMaPageList(HttpServletRequest request, Map map);

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

    public Map<String,Object> getHGPageList(HttpServletRequest request, Map map);

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

    public Map<String,Object> getHGMaPageList(HttpServletRequest request, Map map);

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
}
