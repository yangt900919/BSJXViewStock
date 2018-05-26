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
}
